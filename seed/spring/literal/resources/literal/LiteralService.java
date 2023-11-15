/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.literal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import resources.literal.requests.CreateOptionsRequest;
import resources.literal.requests.GetOptionsRequest;
import resources.literal.types.CreateOptionsResponse;
import resources.literal.types.Options;

@RequestMapping(
    path = "/"
)
public interface LiteralService {
  @PostMapping(
      value = "/options",
      produces = "application/json",
      consumes = "application/json"
  )
  CreateOptionsResponse createOptions(@RequestBody CreateOptionsRequest body);

  @PostMapping(
      value = "/options",
      produces = "application/json",
      consumes = "application/json"
  )
  Options getOptions(@RequestBody GetOptionsRequest body);
}
