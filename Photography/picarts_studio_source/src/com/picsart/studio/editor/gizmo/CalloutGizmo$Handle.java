// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;


public final class _cls9 extends Enum
{

    private static final SCALE $VALUES[];
    public static final SCALE DST;
    public static final SCALE SCALE;
    public static final SCALE SRC;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/picsart/studio/editor/gizmo/CalloutGizmo$Handle, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        SRC = new <init>("SRC", 0);
        DST = new <init>("DST", 1);
        SCALE = new <init>("SCALE", 2);
        $VALUES = (new .VALUES[] {
            SRC, DST, SCALE
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
