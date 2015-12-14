// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;


public final class _cls9 extends Enum
{

    private static final CENTER $VALUES[];
    public static final CENTER CENTER;
    public static final CENTER HEIGHT;
    public static final CENTER WIDTH;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/picsart/studio/editor/RotatingCamera$ScaleToFit, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        WIDTH = new <init>("WIDTH", 0);
        HEIGHT = new <init>("HEIGHT", 1);
        CENTER = new <init>("CENTER", 2);
        $VALUES = (new .VALUES[] {
            WIDTH, HEIGHT, CENTER
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
