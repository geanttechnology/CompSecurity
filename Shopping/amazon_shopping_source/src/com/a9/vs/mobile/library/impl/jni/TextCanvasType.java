// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class TextCanvasType extends Enum
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


    private static final TextCanvasType $VALUES[];
    public static final TextCanvasType BUSINESS_CARD_CANVAS;
    public static final TextCanvasType GENERAL_CANVAS;
    public static final TextCanvasType UNKNOWN_CANVAS;
    private final int swigValue;

    private TextCanvasType(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private TextCanvasType(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private TextCanvasType(String s, int i, TextCanvasType textcanvastype)
    {
        Enum(s, i);
        swigValue = textcanvastype.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static TextCanvasType swigToEnum(int i)
    {
        TextCanvasType atextcanvastype[] = (TextCanvasType[])com/a9/vs/mobile/library/impl/jni/TextCanvasType.getEnumConstants();
        if (i >= atextcanvastype.length || i < 0 || atextcanvastype[i].swigValue != i) goto _L2; else goto _L1
_L1:
        TextCanvasType textcanvastype = atextcanvastype[i];
_L4:
        return textcanvastype;
_L2:
        int k = atextcanvastype.length;
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
                TextCanvasType textcanvastype1 = atextcanvastype[j];
                textcanvastype = textcanvastype1;
                if (textcanvastype1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/TextCanvasType).append(" with value ").append(i).toString());
    }

    public static TextCanvasType valueOf(String s)
    {
        return (TextCanvasType)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/TextCanvasType, s);
    }

    public static TextCanvasType[] values()
    {
        return (TextCanvasType[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        GENERAL_CANVAS = new TextCanvasType("GENERAL_CANVAS", 0, 0);
        BUSINESS_CARD_CANVAS = new TextCanvasType("BUSINESS_CARD_CANVAS", 1);
        UNKNOWN_CANVAS = new TextCanvasType("UNKNOWN_CANVAS", 2);
        $VALUES = (new TextCanvasType[] {
            GENERAL_CANVAS, BUSINESS_CARD_CANVAS, UNKNOWN_CANVAS
        });
    }
}
