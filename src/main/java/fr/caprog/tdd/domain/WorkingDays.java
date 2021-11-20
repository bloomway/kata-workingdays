package fr.caprog.tdd.domain;

public class WorkingDays {
    private WorkingDay previous;
    private WorkingDay current;
    private WorkingDay next;

    protected WorkingDays() {}

    private WorkingDays(WorkingDay previous, WorkingDay current, WorkingDay next) {
        this.previous = previous;
        this.current = current;
        this.next = next;
    }

    public static WorkingDays of(WorkingDay previous, WorkingDay current, WorkingDay next) {
        return new WorkingDays(previous, current, next);
    }

    public WorkingDay getPrevious() {
        return previous;
    }

    public WorkingDay getCurrent() {
        return current;
    }

    public WorkingDay getNext() {
        return next;
    }
}
