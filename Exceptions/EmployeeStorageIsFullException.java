package pro.sky.hwstreams.Exceptions;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException (String message) {
        super(message);
    }
}
