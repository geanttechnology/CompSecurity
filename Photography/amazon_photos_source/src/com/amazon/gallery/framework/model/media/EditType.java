// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;


public final class EditType extends Enum
{

    private static final EditType $VALUES[];
    public static final EditType CLOUD;
    public static final EditType LOCAL;
    public static final EditType UNIFIED;

    private EditType(String s, int i)
    {
        super(s, i);
    }

    public static EditType valueOf(String s)
    {
        return (EditType)Enum.valueOf(com/amazon/gallery/framework/model/media/EditType, s);
    }

    public static EditType[] values()
    {
        return (EditType[])$VALUES.clone();
    }

    static 
    {
        LOCAL = new EditType("LOCAL", 0);
        CLOUD = new EditType("CLOUD", 1);
        UNIFIED = new EditType("UNIFIED", 2);
        $VALUES = (new EditType[] {
            LOCAL, CLOUD, UNIFIED
        });
    }
}
