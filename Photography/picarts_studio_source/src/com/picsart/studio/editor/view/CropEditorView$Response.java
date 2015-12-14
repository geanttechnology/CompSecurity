// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;


final class  extends Enum
{

    private static final REJECT $VALUES[];
    public static final REJECT ACCEPT;
    public static final REJECT REJECT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/editor/view/CropEditorView$Response, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ACCEPT = new <init>("ACCEPT", 0);
        REJECT = new <init>("REJECT", 1);
        $VALUES = (new .VALUES[] {
            ACCEPT, REJECT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
