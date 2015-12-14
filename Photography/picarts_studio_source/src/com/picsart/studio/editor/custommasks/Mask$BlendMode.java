// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;


public final class mBlendModeName extends Enum
{

    private static final ADD $VALUES[];
    public static final ADD ADD;
    public static final ADD DARKEN;
    public static final ADD LIGHTEN;
    public static final ADD MULTIPLY;
    public static final ADD NORMAL;
    public static final ADD OVERLAY;
    public static final ADD SCREEN;
    private String mBlendModeName;

    public static mBlendModeName valueOf(String s)
    {
        return (mBlendModeName)Enum.valueOf(com/picsart/studio/editor/custommasks/Mask$BlendMode, s);
    }

    public static mBlendModeName[] values()
    {
        return (mBlendModeName[])$VALUES.clone();
    }

    public final String toString()
    {
        return mBlendModeName;
    }

    static 
    {
        NORMAL = new <init>("NORMAL", 0, "Normal");
        SCREEN = new <init>("SCREEN", 1, "Screen");
        OVERLAY = new <init>("OVERLAY", 2, "Overlay");
        MULTIPLY = new <init>("MULTIPLY", 3, "Multiply");
        DARKEN = new <init>("DARKEN", 4, "Darken");
        LIGHTEN = new <init>("LIGHTEN", 5, "Lighten");
        ADD = new <init>("ADD", 6, "Add");
        $VALUES = (new .VALUES[] {
            NORMAL, SCREEN, OVERLAY, MULTIPLY, DARKEN, LIGHTEN, ADD
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mBlendModeName = s1;
    }
}
