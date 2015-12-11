// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class Orientation extends Enum
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


    private static final Orientation $VALUES[];
    public static final Orientation LANDSCAPE_LEFT;
    public static final Orientation LANDSCAPE_RIGHT;
    public static final Orientation PORTRAIT;
    public static final Orientation PORTRAIT_UPSIDE_DOWN;
    private final int swigValue;

    private Orientation(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private Orientation(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private Orientation(String s, int i, Orientation orientation)
    {
        Enum(s, i);
        swigValue = orientation.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static Orientation swigToEnum(int i)
    {
        Orientation aorientation[] = (Orientation[])com/a9/vs/mobile/library/impl/jni/Orientation.getEnumConstants();
        if (i >= aorientation.length || i < 0 || aorientation[i].swigValue != i) goto _L2; else goto _L1
_L1:
        Orientation orientation = aorientation[i];
_L4:
        return orientation;
_L2:
        int k = aorientation.length;
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
                Orientation orientation1 = aorientation[j];
                orientation = orientation1;
                if (orientation1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/Orientation).append(" with value ").append(i).toString());
    }

    public static Orientation valueOf(String s)
    {
        return (Orientation)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/Orientation, s);
    }

    public static Orientation[] values()
    {
        return (Orientation[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        PORTRAIT = new Orientation("PORTRAIT", 0);
        PORTRAIT_UPSIDE_DOWN = new Orientation("PORTRAIT_UPSIDE_DOWN", 1);
        LANDSCAPE_LEFT = new Orientation("LANDSCAPE_LEFT", 2);
        LANDSCAPE_RIGHT = new Orientation("LANDSCAPE_RIGHT", 3);
        $VALUES = (new Orientation[] {
            PORTRAIT, PORTRAIT_UPSIDE_DOWN, LANDSCAPE_LEFT, LANDSCAPE_RIGHT
        });
    }
}
