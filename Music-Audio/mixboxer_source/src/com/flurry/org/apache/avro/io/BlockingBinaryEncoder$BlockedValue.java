// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;


// Referenced classes of package com.flurry.org.apache.avro.io:
//            BlockingBinaryEncoder

private static class items
{
    public static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State OVERFLOW;
        public static final State REGULAR;
        public static final State ROOT;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/flurry/org/apache/avro/io/BlockingBinaryEncoder$BlockedValue$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            ROOT = new State("ROOT", 0);
            REGULAR = new State("REGULAR", 1);
            OVERFLOW = new State("OVERFLOW", 2);
            $VALUES = (new State[] {
                ROOT, REGULAR, OVERFLOW
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    static final boolean $assertionsDisabled;
    public int items;
    public long itemsLeftToWrite;
    public int lastFullItem;
    public int start;
    public State state;
    public com.flurry.org.apache.avro.ue.State type;

    public boolean check(State state1, int i)
    {
        if (!$assertionsDisabled && state == State.ROOT && type != null)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && state != State.ROOT && type != com.flurry.org.apache.avro.ue.type && type != com.flurry.org.apache.avro.ue.type)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && items < 0)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && items == 0 && start != i)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && 1 >= items && start != lastFullItem)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && items > 1 && start > lastFullItem)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && lastFullItem > i)
        {
            throw new AssertionError();
        }
        org.apache.avro.io.BlockingBinaryEncoder.BlockedValue.State[state.ordinal()];
        JVM INSTR tableswitch 1 3: default 252
    //                   1 254
    //                   2 293
    //                   3 361;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        if (!$assertionsDisabled && start != 0)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && state1 != null)
        {
            throw new AssertionError();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (!$assertionsDisabled && start < 0)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && state1.lastFullItem > start)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && 1 > state1.items)
        {
            throw new AssertionError();
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (!$assertionsDisabled && start != 0)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && items != 1)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && state1.state != State.ROOT && state1.state != State.OVERFLOW)
        {
            throw new AssertionError();
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    static 
    {
        boolean flag;
        if (!com/flurry/org/apache/avro/io/BlockingBinaryEncoder.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    public State()
    {
        type = null;
        state = State.ROOT;
        lastFullItem = 0;
        start = 0;
        items = 1;
    }
}
