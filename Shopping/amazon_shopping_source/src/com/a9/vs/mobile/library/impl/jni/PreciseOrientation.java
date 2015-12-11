// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class PreciseOrientation extends Enum
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


    private static final PreciseOrientation $VALUES[];
    public static final PreciseOrientation LANDSCAPE_LEFT;
    public static final PreciseOrientation LANDSCAPE_RIGHT;
    public static final PreciseOrientation PORTRAIT;
    public static final PreciseOrientation PORTRAIT_UPSIDE_DOWN;
    public static final PreciseOrientation PRECISE_ORIENTATION_UNSPECIFIED;
    private final int swigValue;

    private PreciseOrientation(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private PreciseOrientation(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private PreciseOrientation(String s, int i, PreciseOrientation preciseorientation)
    {
        Enum(s, i);
        swigValue = preciseorientation.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static PreciseOrientation swigToEnum(int i)
    {
        PreciseOrientation apreciseorientation[] = (PreciseOrientation[])com/a9/vs/mobile/library/impl/jni/PreciseOrientation.getEnumConstants();
        if (i >= apreciseorientation.length || i < 0 || apreciseorientation[i].swigValue != i) goto _L2; else goto _L1
_L1:
        PreciseOrientation preciseorientation = apreciseorientation[i];
_L4:
        return preciseorientation;
_L2:
        int k = apreciseorientation.length;
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
                PreciseOrientation preciseorientation1 = apreciseorientation[j];
                preciseorientation = preciseorientation1;
                if (preciseorientation1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/PreciseOrientation).append(" with value ").append(i).toString());
    }

    public static PreciseOrientation valueOf(String s)
    {
        return (PreciseOrientation)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/PreciseOrientation, s);
    }

    public static PreciseOrientation[] values()
    {
        return (PreciseOrientation[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        PORTRAIT = new PreciseOrientation("PORTRAIT", 0, 0);
        PORTRAIT_UPSIDE_DOWN = new PreciseOrientation("PORTRAIT_UPSIDE_DOWN", 1);
        LANDSCAPE_LEFT = new PreciseOrientation("LANDSCAPE_LEFT", 2);
        LANDSCAPE_RIGHT = new PreciseOrientation("LANDSCAPE_RIGHT", 3);
        PRECISE_ORIENTATION_UNSPECIFIED = new PreciseOrientation("PRECISE_ORIENTATION_UNSPECIFIED", 4);
        $VALUES = (new PreciseOrientation[] {
            PORTRAIT, PORTRAIT_UPSIDE_DOWN, LANDSCAPE_LEFT, LANDSCAPE_RIGHT, PRECISE_ORIENTATION_UNSPECIFIED
        });
    }
}
