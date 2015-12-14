// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;


public final class  extends Enum
{

    private static final OUTER $VALUES[];
    public static final OUTER INNER;
    public static final OUTER OUTER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/editor/view/BorderEditorView$Mode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INNER = new <init>("INNER", 0);
        OUTER = new <init>("OUTER", 1);
        $VALUES = (new .VALUES[] {
            INNER, OUTER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
