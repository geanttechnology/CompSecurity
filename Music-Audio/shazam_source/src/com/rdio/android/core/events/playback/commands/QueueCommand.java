// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback.commands;


public class QueueCommand
{
    public static final class Operation extends Enum
    {

        private static final Operation $VALUES[];
        public static final Operation Add;
        public static final Operation Move;
        public static final Operation Remove;

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/rdio/android/core/events/playback/commands/QueueCommand$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])$VALUES.clone();
        }

        static 
        {
            Add = new Operation("Add", 0);
            Remove = new Operation("Remove", 1);
            Move = new Operation("Move", 2);
            $VALUES = (new Operation[] {
                Add, Remove, Move
            });
        }

        private Operation(String s, int i)
        {
            super(s, i);
        }
    }


    private final Operation operation;
    private final Object operationData;

    public QueueCommand(Operation operation1, Object obj)
    {
        validateOperationData(operation1, obj);
        operation = operation1;
        operationData = obj;
    }

    private void validateOperationData(Operation operation1, Object obj)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[];

            static 
            {
                $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation = new int[Operation.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[Operation.Add.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[Operation.Remove.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[Operation.Move.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.rdio.android.core.events.playback.commands.QueueCommand.Operation[operation1.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 73
    //                   3 150;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (!(obj instanceof String))
        {
            throw new IllegalArgumentException((new StringBuilder("Command type: ")).append(operation1).append(" must have operation data of type String").toString());
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (!(obj instanceof int[]))
        {
            throw new IllegalArgumentException((new StringBuilder("Command type: ")).append(operation1).append(" must have operation data of type int[] that is exactly 1 value").toString());
        }
        if (((int[])(int[])obj).length != 1)
        {
            throw new IllegalArgumentException((new StringBuilder("Command type: ")).append(operation1).append(" must have operation data of type int[] that is exactly 1 value").toString());
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (!(obj instanceof int[]))
        {
            throw new IllegalArgumentException((new StringBuilder("Command type: ")).append(operation1).append(" must have operation data of type int[] that is exactly 2 values").toString());
        }
        if (((int[])(int[])obj).length != 2)
        {
            throw new IllegalArgumentException((new StringBuilder("Command type: ")).append(operation1).append(" must have operation data of type int[] that is exactly 2 values").toString());
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public Operation getOperation()
    {
        return operation;
    }

    public Object getOperationData()
    {
        return operationData;
    }
}
