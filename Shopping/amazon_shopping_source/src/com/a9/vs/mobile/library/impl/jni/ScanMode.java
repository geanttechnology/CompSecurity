// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class ScanMode extends Enum
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


    private static final ScanMode $VALUES[];
    public static final ScanMode CONTINUOUS_SCAN;
    public static final ScanMode SINGLE_SCAN;
    private final int swigValue;

    private ScanMode(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private ScanMode(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private ScanMode(String s, int i, ScanMode scanmode)
    {
        Enum(s, i);
        swigValue = scanmode.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static ScanMode swigToEnum(int i)
    {
        ScanMode ascanmode[] = (ScanMode[])com/a9/vs/mobile/library/impl/jni/ScanMode.getEnumConstants();
        if (i >= ascanmode.length || i < 0 || ascanmode[i].swigValue != i) goto _L2; else goto _L1
_L1:
        ScanMode scanmode = ascanmode[i];
_L4:
        return scanmode;
_L2:
        int k = ascanmode.length;
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
                ScanMode scanmode1 = ascanmode[j];
                scanmode = scanmode1;
                if (scanmode1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/ScanMode).append(" with value ").append(i).toString());
    }

    public static ScanMode valueOf(String s)
    {
        return (ScanMode)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/ScanMode, s);
    }

    public static ScanMode[] values()
    {
        return (ScanMode[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        SINGLE_SCAN = new ScanMode("SINGLE_SCAN", 0);
        CONTINUOUS_SCAN = new ScanMode("CONTINUOUS_SCAN", 1);
        $VALUES = (new ScanMode[] {
            SINGLE_SCAN, CONTINUOUS_SCAN
        });
    }
}
