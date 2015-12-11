// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class IntentState extends Enum
{
    private static class SwigNext
    {

        private static int next = 0;



/*
        static int access$002(int i)
        {
            next = i;
            return i;
        }

*/


/*
        static int access$008()
        {
            int i = next;
            next = i + 1;
            return i;
        }

*/

        private SwigNext()
        {
        }
    }


    private static final IntentState $VALUES[];
    public static final IntentState INTENT;
    public static final IntentState INTENT_BEGIN;
    public static final IntentState INTENT_END;
    public static final IntentState NON_INTENT;
    private final int swigValue;

    private IntentState(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private IntentState(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private IntentState(String s, int i, IntentState intentstate)
    {
        Enum(s, i);
        swigValue = intentstate.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static IntentState swigToEnum(int i)
    {
        IntentState aintentstate[] = (IntentState[])com/a9/vs/mobile/library/impl/jni/IntentState.getEnumConstants();
        if (i >= aintentstate.length || i < 0 || aintentstate[i].swigValue != i) goto _L2; else goto _L1
_L1:
        IntentState intentstate = aintentstate[i];
_L4:
        return intentstate;
_L2:
        int k = aintentstate.length;
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= k)
                {
                    break label1;
                }
                IntentState intentstate1 = aintentstate[j];
                intentstate = intentstate1;
                if (intentstate1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/IntentState).append(" with value ").append(i).toString());
    }

    public static IntentState valueOf(String s)
    {
        return (IntentState)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/IntentState, s);
    }

    public static IntentState[] values()
    {
        return (IntentState[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        NON_INTENT = new IntentState("NON_INTENT", 0, 0);
        INTENT_BEGIN = new IntentState("INTENT_BEGIN", 1, 1);
        INTENT = new IntentState("INTENT", 2, 2);
        INTENT_END = new IntentState("INTENT_END", 3, 3);
        $VALUES = (new IntentState[] {
            NON_INTENT, INTENT_BEGIN, INTENT, INTENT_END
        });
    }
}
