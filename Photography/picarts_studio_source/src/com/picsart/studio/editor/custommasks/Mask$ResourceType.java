// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;


public final class  extends Enum
{

    private static final DOWNLOADABLE $VALUES[];
    public static final DOWNLOADABLE DOWNLOADABLE;
    public static final DOWNLOADABLE RESOURCE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/editor/custommasks/Mask$ResourceType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RESOURCE = new <init>("RESOURCE", 0);
        DOWNLOADABLE = new <init>("DOWNLOADABLE", 1);
        $VALUES = (new .VALUES[] {
            RESOURCE, DOWNLOADABLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
