// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class ActionID extends Enum
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


    private static final ActionID $VALUES[];
    public static final ActionID DECODE;
    public static final ActionID DETECT;
    public static final ActionID FRAME_PROCESS;
    public static final ActionID NUM_ACTIONS;
    public static final ActionID RECEIVE_RESPONSE;
    public static final ActionID REDETECT;
    public static final ActionID SCHEDULE;
    public static final ActionID SCREEN;
    public static final ActionID SEND_REQUEST;
    public static final ActionID TRACK;
    public static final ActionID UNSPECIFIED_ACTION;
    public static final ActionID VERIFY;
    private final int swigValue;

    private ActionID(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private ActionID(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private ActionID(String s, int i, ActionID actionid)
    {
        Enum(s, i);
        swigValue = actionid.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static ActionID swigToEnum(int i)
    {
        ActionID aactionid[] = (ActionID[])com/a9/vs/mobile/library/impl/jni/ActionID.getEnumConstants();
        if (i >= aactionid.length || i < 0 || aactionid[i].swigValue != i) goto _L2; else goto _L1
_L1:
        ActionID actionid = aactionid[i];
_L4:
        return actionid;
_L2:
        int k = aactionid.length;
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
                ActionID actionid1 = aactionid[j];
                actionid = actionid1;
                if (actionid1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/ActionID).append(" with value ").append(i).toString());
    }

    public static ActionID valueOf(String s)
    {
        return (ActionID)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/ActionID, s);
    }

    public static ActionID[] values()
    {
        return (ActionID[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        FRAME_PROCESS = new ActionID("FRAME_PROCESS", 0, 0);
        SCREEN = new ActionID("SCREEN", 1);
        SCHEDULE = new ActionID("SCHEDULE", 2);
        DETECT = new ActionID("DETECT", 3);
        DECODE = new ActionID("DECODE", 4);
        TRACK = new ActionID("TRACK", 5);
        VERIFY = new ActionID("VERIFY", 6);
        REDETECT = new ActionID("REDETECT", 7);
        SEND_REQUEST = new ActionID("SEND_REQUEST", 8);
        RECEIVE_RESPONSE = new ActionID("RECEIVE_RESPONSE", 9);
        UNSPECIFIED_ACTION = new ActionID("UNSPECIFIED_ACTION", 10);
        NUM_ACTIONS = new ActionID("NUM_ACTIONS", 11);
        $VALUES = (new ActionID[] {
            FRAME_PROCESS, SCREEN, SCHEDULE, DETECT, DECODE, TRACK, VERIFY, REDETECT, SEND_REQUEST, RECEIVE_RESPONSE, 
            UNSPECIFIED_ACTION, NUM_ACTIONS
        });
    }
}
