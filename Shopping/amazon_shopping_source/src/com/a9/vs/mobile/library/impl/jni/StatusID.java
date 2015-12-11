// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class StatusID extends Enum
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


    private static final StatusID $VALUES[];
    public static final StatusID FAIL;
    public static final StatusID NOTRUN;
    public static final StatusID NUM_STATUS;
    public static final StatusID PROCESSING;
    public static final StatusID START;
    public static final StatusID SUCCESS;
    public static final StatusID UNSPECIFIED_STATUS;
    private final int swigValue;

    private StatusID(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private StatusID(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private StatusID(String s, int i, StatusID statusid)
    {
        Enum(s, i);
        swigValue = statusid.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static StatusID swigToEnum(int i)
    {
        StatusID astatusid[] = (StatusID[])com/a9/vs/mobile/library/impl/jni/StatusID.getEnumConstants();
        if (i >= astatusid.length || i < 0 || astatusid[i].swigValue != i) goto _L2; else goto _L1
_L1:
        StatusID statusid = astatusid[i];
_L4:
        return statusid;
_L2:
        int k = astatusid.length;
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
                StatusID statusid1 = astatusid[j];
                statusid = statusid1;
                if (statusid1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/StatusID).append(" with value ").append(i).toString());
    }

    public static StatusID valueOf(String s)
    {
        return (StatusID)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/StatusID, s);
    }

    public static StatusID[] values()
    {
        return (StatusID[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        START = new StatusID("START", 0, 0);
        SUCCESS = new StatusID("SUCCESS", 1);
        FAIL = new StatusID("FAIL", 2);
        PROCESSING = new StatusID("PROCESSING", 3);
        NOTRUN = new StatusID("NOTRUN", 4);
        UNSPECIFIED_STATUS = new StatusID("UNSPECIFIED_STATUS", 5);
        NUM_STATUS = new StatusID("NUM_STATUS", 6);
        $VALUES = (new StatusID[] {
            START, SUCCESS, FAIL, PROCESSING, NOTRUN, UNSPECIFIED_STATUS, NUM_STATUS
        });
    }
}
