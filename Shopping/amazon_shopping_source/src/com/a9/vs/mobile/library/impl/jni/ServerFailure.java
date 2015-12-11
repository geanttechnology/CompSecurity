// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class ServerFailure extends Enum
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


    private static final ServerFailure $VALUES[];
    public static final ServerFailure NO_NETWORK;
    public static final ServerFailure NO_SERVER_ERROR;
    public static final ServerFailure SERVER_ERROR;
    public static final ServerFailure UNAUTHORIZED_ACCESS;
    public static final ServerFailure UNKNOWN_ERROR;
    private final int swigValue;

    private ServerFailure(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private ServerFailure(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private ServerFailure(String s, int i, ServerFailure serverfailure)
    {
        Enum(s, i);
        swigValue = serverfailure.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static ServerFailure swigToEnum(int i)
    {
        ServerFailure aserverfailure[] = (ServerFailure[])com/a9/vs/mobile/library/impl/jni/ServerFailure.getEnumConstants();
        if (i >= aserverfailure.length || i < 0 || aserverfailure[i].swigValue != i) goto _L2; else goto _L1
_L1:
        ServerFailure serverfailure = aserverfailure[i];
_L4:
        return serverfailure;
_L2:
        int k = aserverfailure.length;
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
                ServerFailure serverfailure1 = aserverfailure[j];
                serverfailure = serverfailure1;
                if (serverfailure1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/ServerFailure).append(" with value ").append(i).toString());
    }

    public static ServerFailure valueOf(String s)
    {
        return (ServerFailure)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/ServerFailure, s);
    }

    public static ServerFailure[] values()
    {
        return (ServerFailure[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        NO_SERVER_ERROR = new ServerFailure("NO_SERVER_ERROR", 0, 0);
        NO_NETWORK = new ServerFailure("NO_NETWORK", 1);
        UNAUTHORIZED_ACCESS = new ServerFailure("UNAUTHORIZED_ACCESS", 2);
        SERVER_ERROR = new ServerFailure("SERVER_ERROR", 3);
        UNKNOWN_ERROR = new ServerFailure("UNKNOWN_ERROR", 4);
        $VALUES = (new ServerFailure[] {
            NO_SERVER_ERROR, NO_NETWORK, UNAUTHORIZED_ACCESS, SERVER_ERROR, UNKNOWN_ERROR
        });
    }
}
