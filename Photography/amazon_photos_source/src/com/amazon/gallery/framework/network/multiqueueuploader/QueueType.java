// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


public final class QueueType extends Enum
{

    private static final QueueType $VALUES[];
    public static final QueueType AUTO_SAVE;
    public static final QueueType FORCE_UPLOAD;
    public static final QueueType MANUAL;

    private QueueType(String s, int i)
    {
        super(s, i);
    }

    public static QueueType valueOf(String s)
    {
        return (QueueType)Enum.valueOf(com/amazon/gallery/framework/network/multiqueueuploader/QueueType, s);
    }

    public static QueueType[] values()
    {
        return (QueueType[])$VALUES.clone();
    }

    static 
    {
        AUTO_SAVE = new QueueType("AUTO_SAVE", 0);
        MANUAL = new QueueType("MANUAL", 1);
        FORCE_UPLOAD = new QueueType("FORCE_UPLOAD", 2);
        $VALUES = (new QueueType[] {
            AUTO_SAVE, MANUAL, FORCE_UPLOAD
        });
    }
}
