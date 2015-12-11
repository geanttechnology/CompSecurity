// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;


// Referenced classes of package com.urbanairship.actions:
//            ActionValue

public final class ActionResult
{

    private final Exception exception;
    private final Status status;
    private final ActionValue value;

    ActionResult(ActionValue actionvalue, Exception exception1, Status status1)
    {
        ActionValue actionvalue1 = actionvalue;
        if (actionvalue == null)
        {
            actionvalue1 = new ActionValue();
        }
        value = actionvalue1;
        exception = exception1;
        if (status1 == null)
        {
            status1 = Status.COMPLETED;
        }
        status = status1;
    }

    public static ActionResult newEmptyResult()
    {
        return new ActionResult(null, null, Status.COMPLETED);
    }

    static ActionResult newEmptyResultWithStatus(Status status1)
    {
        return new ActionResult(null, null, status1);
    }

    public static ActionResult newErrorResult(Exception exception1)
    {
        return new ActionResult(null, exception1, Status.EXECUTION_ERROR);
    }

    public static ActionResult newResult(ActionValue actionvalue)
    {
        return new ActionResult(actionvalue, null, Status.COMPLETED);
    }

    public final Exception getException()
    {
        return exception;
    }

    public final Status getStatus()
    {
        return status;
    }

    public final ActionValue getValue()
    {
        return value;
    }

    private class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status ACTION_NOT_FOUND;
        public static final Status COMPLETED;
        public static final Status EXECUTION_ERROR;
        public static final Status REJECTED_ARGUMENTS;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/urbanairship/actions/ActionResult$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            COMPLETED = new Status("COMPLETED", 0);
            REJECTED_ARGUMENTS = new Status("REJECTED_ARGUMENTS", 1);
            ACTION_NOT_FOUND = new Status("ACTION_NOT_FOUND", 2);
            EXECUTION_ERROR = new Status("EXECUTION_ERROR", 3);
            $VALUES = (new Status[] {
                COMPLETED, REJECTED_ARGUMENTS, ACTION_NOT_FOUND, EXECUTION_ERROR
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }

}
