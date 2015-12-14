// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;


public final class QueueProcessingType extends Enum
{

    public static final QueueProcessingType a;
    public static final QueueProcessingType b;
    private static final QueueProcessingType c[];

    private QueueProcessingType(String s, int i)
    {
        super(s, i);
    }

    public static QueueProcessingType valueOf(String s)
    {
        return (QueueProcessingType)Enum.valueOf(com/nostra13/universalimageloader/core/assist/QueueProcessingType, s);
    }

    public static QueueProcessingType[] values()
    {
        return (QueueProcessingType[])c.clone();
    }

    static 
    {
        a = new QueueProcessingType("FIFO", 0);
        b = new QueueProcessingType("LIFO", 1);
        c = (new QueueProcessingType[] {
            a, b
        });
    }
}
