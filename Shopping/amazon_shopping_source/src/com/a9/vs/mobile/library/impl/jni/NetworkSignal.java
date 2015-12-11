// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class NetworkSignal extends Enum
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


    private static final NetworkSignal $VALUES[];
    public static final NetworkSignal STRONG_SIGNAL;
    public static final NetworkSignal WEAK_SIGNAL;
    private final int swigValue;

    private NetworkSignal(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private NetworkSignal(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private NetworkSignal(String s, int i, NetworkSignal networksignal)
    {
        Enum(s, i);
        swigValue = networksignal.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static NetworkSignal swigToEnum(int i)
    {
        NetworkSignal anetworksignal[] = (NetworkSignal[])com/a9/vs/mobile/library/impl/jni/NetworkSignal.getEnumConstants();
        if (i >= anetworksignal.length || i < 0 || anetworksignal[i].swigValue != i) goto _L2; else goto _L1
_L1:
        NetworkSignal networksignal = anetworksignal[i];
_L4:
        return networksignal;
_L2:
        int k = anetworksignal.length;
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
                NetworkSignal networksignal1 = anetworksignal[j];
                networksignal = networksignal1;
                if (networksignal1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/NetworkSignal).append(" with value ").append(i).toString());
    }

    public static NetworkSignal valueOf(String s)
    {
        return (NetworkSignal)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/NetworkSignal, s);
    }

    public static NetworkSignal[] values()
    {
        return (NetworkSignal[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        WEAK_SIGNAL = new NetworkSignal("WEAK_SIGNAL", 0, 0);
        STRONG_SIGNAL = new NetworkSignal("STRONG_SIGNAL", 1);
        $VALUES = (new NetworkSignal[] {
            WEAK_SIGNAL, STRONG_SIGNAL
        });
    }
}
