// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.helper;


public final class MAX_SIZE extends Enum
{

    private static final HIGH $VALUES[];
    public static final HIGH HIGH;
    public static final HIGH LOW;
    public final int MAX_SIZE;

    public static MAX_SIZE valueOf(String s)
    {
        return (MAX_SIZE)Enum.valueOf(com/picsart/studio/editor/helper/Background$Quality, s);
    }

    public static MAX_SIZE[] values()
    {
        return (MAX_SIZE[])$VALUES.clone();
    }

    static 
    {
        LOW = new <init>("LOW", 0, 640);
        HIGH = new <init>("HIGH", 1, 2048);
        $VALUES = (new .VALUES[] {
            LOW, HIGH
        });
    }

    private _cls9(String s, int i, int j)
    {
        super(s, i);
        MAX_SIZE = j;
    }
}
