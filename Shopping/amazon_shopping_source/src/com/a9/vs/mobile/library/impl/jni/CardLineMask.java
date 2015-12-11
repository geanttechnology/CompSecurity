// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class CardLineMask extends Enum
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


    private static final CardLineMask $VALUES[];
    public static final CardLineMask BOTTOM;
    public static final CardLineMask LEFT;
    public static final CardLineMask RIGHT;
    public static final CardLineMask TOP;
    private final int swigValue;

    private CardLineMask(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private CardLineMask(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private CardLineMask(String s, int i, CardLineMask cardlinemask)
    {
        Enum(s, i);
        swigValue = cardlinemask.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static CardLineMask swigToEnum(int i)
    {
        CardLineMask acardlinemask[] = (CardLineMask[])com/a9/vs/mobile/library/impl/jni/CardLineMask.getEnumConstants();
        if (i >= acardlinemask.length || i < 0 || acardlinemask[i].swigValue != i) goto _L2; else goto _L1
_L1:
        CardLineMask cardlinemask = acardlinemask[i];
_L4:
        return cardlinemask;
_L2:
        int k = acardlinemask.length;
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
                CardLineMask cardlinemask1 = acardlinemask[j];
                cardlinemask = cardlinemask1;
                if (cardlinemask1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/CardLineMask).append(" with value ").append(i).toString());
    }

    public static CardLineMask valueOf(String s)
    {
        return (CardLineMask)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/CardLineMask, s);
    }

    public static CardLineMask[] values()
    {
        return (CardLineMask[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        TOP = new CardLineMask("TOP", 0, 1);
        LEFT = new CardLineMask("LEFT", 1, 2);
        BOTTOM = new CardLineMask("BOTTOM", 2, 4);
        RIGHT = new CardLineMask("RIGHT", 3, 8);
        $VALUES = (new CardLineMask[] {
            TOP, LEFT, BOTTOM, RIGHT
        });
    }
}
