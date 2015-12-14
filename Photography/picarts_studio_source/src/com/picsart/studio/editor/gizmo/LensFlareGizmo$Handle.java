// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;


final class  extends Enum
{

    private static final ROTATE $VALUES[];
    public static final ROTATE DST;
    public static final ROTATE ROTATE;
    public static final ROTATE SCALE;
    public static final ROTATE SRC;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/editor/gizmo/LensFlareGizmo$Handle, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SRC = new <init>("SRC", 0);
        DST = new <init>("DST", 1);
        SCALE = new <init>("SCALE", 2);
        ROTATE = new <init>("ROTATE", 3);
        $VALUES = (new .VALUES[] {
            SRC, DST, SCALE, ROTATE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
