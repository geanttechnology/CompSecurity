// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;


// Referenced classes of package com.uplynk.media:
//            CaptionEvent

public static final class  extends Enum
{

    public static final LINEBREAK CLEAR;
    private static final LINEBREAK ENUM$VALUES[];
    public static final LINEBREAK LINEBREAK;
    public static final LINEBREAK TEXT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/uplynk/media/CaptionEvent$CaptionEventType, s);
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
        TEXT = new <init>("TEXT", 0);
        CLEAR = new <init>("CLEAR", 1);
        LINEBREAK = new <init>("LINEBREAK", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            TEXT, CLEAR, LINEBREAK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
