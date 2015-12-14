// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.activity.compose2;


public final class CollageStylesType extends Enum
{

    private static final CollageStylesType $VALUES[];
    public static final CollageStylesType collageFrame;
    public static final CollageStylesType collageFree;
    public static final CollageStylesType collageLink;

    private CollageStylesType(String s, int i)
    {
        super(s, i);
    }

    public static CollageStylesType valueOf(String s)
    {
        return (CollageStylesType)Enum.valueOf(com/fotoable/photocollage/activity/compose2/CollageStylesType, s);
    }

    public static CollageStylesType[] values()
    {
        return (CollageStylesType[])$VALUES.clone();
    }

    static 
    {
        collageFrame = new CollageStylesType("collageFrame", 0);
        collageFree = new CollageStylesType("collageFree", 1);
        collageLink = new CollageStylesType("collageLink", 2);
        $VALUES = (new CollageStylesType[] {
            collageFrame, collageFree, collageLink
        });
    }
}
