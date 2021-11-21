package fr.caprog.tdd.domain;

public class BusinessDays {
    private BusinessDay previous;
    private BusinessDay current;
    private BusinessDay next;

    protected BusinessDays() {}

    private BusinessDays(BusinessDay previous, BusinessDay current, BusinessDay next) {
        this.previous = previous;
        this.current = current;
        this.next = next;
    }

    public static BusinessDays of(BusinessDay previous, BusinessDay current, BusinessDay next) {
        return new BusinessDays(previous, current, next);
    }

    public BusinessDay getPrevious() {
        return previous;
    }

    public BusinessDay getCurrent() {
        return current;
    }

    public BusinessDay getNext() {
        return next;
    }
}
