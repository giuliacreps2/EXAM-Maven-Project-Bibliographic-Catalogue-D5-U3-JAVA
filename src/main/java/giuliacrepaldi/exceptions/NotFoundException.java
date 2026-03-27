package giuliacrepaldi.exceptions;

import java.util.Date;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Date annoPubblicazione) {
    }
}
