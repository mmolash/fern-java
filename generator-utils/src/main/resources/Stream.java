import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.Reader;
import java.util.Scanner;

public final class Stream<T> implements Iterable<T> {
    private final Class<T> valueType;
    private final Scanner scanner;

    public Stream(Class<T> valueType, Reader reader, String delimiter) {
        this.scanner = new Scanner(reader).useDelimiter(delimiter);
        this.valueType = valueType;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return scanner.hasNext();
            }

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

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}