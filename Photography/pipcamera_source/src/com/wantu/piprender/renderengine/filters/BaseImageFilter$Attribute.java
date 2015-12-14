// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender.renderengine.filters;


public final class  extends Enum
{

    private static final RE_NUM_ATTRIBUTES $VALUES[];
    public static final RE_NUM_ATTRIBUTES RE_ATTRIB_TEXTUREPOSITON;
    public static final RE_NUM_ATTRIBUTES RE_ATTRIB_VERTEX;
    public static final RE_NUM_ATTRIBUTES RE_NUM_ATTRIBUTES;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/wantu/piprender/renderengine/filters/BaseImageFilter$Attribute, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RE_ATTRIB_VERTEX = new <init>("RE_ATTRIB_VERTEX", 0);
        RE_ATTRIB_TEXTUREPOSITON = new <init>("RE_ATTRIB_TEXTUREPOSITON", 1);
        RE_NUM_ATTRIBUTES = new <init>("RE_NUM_ATTRIBUTES", 2);
        $VALUES = (new .VALUES[] {
            RE_ATTRIB_VERTEX, RE_ATTRIB_TEXTUREPOSITON, RE_NUM_ATTRIBUTES
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
