// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;


public final class I extends Enum
{

    private static final ADD_DRAWABLE $VALUES[];
    public static final ADD_DRAWABLE ADD_DRAWABLE;
    public static final ADD_DRAWABLE SELECTION;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/picsart/studio/editor/fragment/SelectionFragment$FragmentUIMode, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        SELECTION = new <init>("SELECTION", 0);
        ADD_DRAWABLE = new <init>("ADD_DRAWABLE", 1);
        $VALUES = (new .VALUES[] {
            SELECTION, ADD_DRAWABLE
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
