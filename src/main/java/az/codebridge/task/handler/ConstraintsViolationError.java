package az.codebridge.task.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConstraintsViolationError {
    private String field;
    private Object rejectedValue;
    private String errorMessage;
}
