// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;


public final class  extends Enum
{

    private static final GLOSS $VALUES[];
    public static final GLOSS BRIGHT;
    public static final GLOSS GLOSS;
    public static final GLOSS THICK;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/clgpuimage/CLMakeupLiveLipStickFilter$BlendMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        THICK = new <init>("THICK", 0);
        BRIGHT = new <init>("BRIGHT", 1);
        GLOSS = new <init>("GLOSS", 2);
        $VALUES = (new .VALUES[] {
            THICK, BRIGHT, GLOSS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
