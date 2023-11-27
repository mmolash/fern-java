import java.time.OffsetDateTime;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.Reader;
import java.util.Scanner;

/**
 * The {@code Stream} class implmenets {@link Iterable} to provide a simple mechanism for reading and parsing
 * objects of a given type from data streamed via a {@link Reader} using a specified delimiter.
 * <p>
 * {@code Stream} assumes that data is being pushed to the provided {@link Reader} asynchronously and utilizes a
 * {@code Scanner} to block during iteration if the next object is not available.
 *
 * @param <T> The type of objects in the stream.
 */
public final class Stream<T> implements Iterable<T> {
    /**
     * The {@link Class} of the objects in the stream.
     */
    private final Class<T> valueType;
    /**
     * The {@link Scanner} used for reading from the input stream and blocking when neede during iteration.
     */
    private final Scanner scanner;

    /**
     * Constructs a new {@code Stream} with the specified value type, reader, and delimiter.
     *
     * @param valueType The class of the objects in the stream.
     * @param reader    The reader that provides the streamed data.
     * @param delimiter The delimiter used to separate elements in the stream.
     */
    public Stream(Class<T> valueType, Reader reader, String delimiter) {
        this.scanner = new Scanner(reader).useDelimiter(delimiter);
        this.valueType = valueType;
    }

    /**
     * Returns an iterator over the elements in this stream that blocks during iteration when the next object is
     * not yet available.
     *
     * @return An iterator that can be used to traverse the elements in the stream.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * Returns {@code true} if there are more elements in the stream.
             * <p>
             * Will block and wait for input if the stream has not ended and the next object is not yet available.
             *
             * @return {@code true} if there are more elements, {@code false} otherwise.
             */
            @Override
            public boolean hasNext() {
                return scanner.hasNext();
            }

            /**
             * Returns the next element in the stream.
             * <p>
             * Will block and wait for input if the stream has not ended and the next object is not yet available.
             *
             * @return The next element in the stream.
             * @throws NoSuchElementException If there are no more elements in the stream.
             */
            @Override
            public T next() {
                if (!scanner.hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    try {
                        T parsedResponse =
                                ObjectMappers.JSON_MAPPER.readValue(scanner.next().trim(), valueType);
                        return parsedResponse;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            /**
             * Removing elements from {@code Stream} is not supported.
             *
             * @throws UnsupportedOperationException Always, as removal is not supported.
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}