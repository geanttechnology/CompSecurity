// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;


// Referenced classes of package com.uplynk.media:
//            CaptionEvent

public static final class  extends Enum
{

    private static final TEXT ENUM$VALUES[];
    public static final TEXT PAINT_ON;
    public static final TEXT POP_ON;
    public static final TEXT ROLL_UP;
    public static final TEXT TEXT;
    public static final TEXT UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/uplynk/media/CaptionEvent$CaptionMode, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        POP_ON = new <init>("POP_ON", 1);
        ROLL_UP = new <init>("ROLL_UP", 2);
        PAINT_ON = new <init>("PAINT_ON", 3);
        TEXT = new <init>("TEXT", 4);
        ENUM$VALUES = (new ENUM.VALUES[] {
            UNKNOWN, POP_ON, ROLL_UP, PAINT_ON, TEXT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
