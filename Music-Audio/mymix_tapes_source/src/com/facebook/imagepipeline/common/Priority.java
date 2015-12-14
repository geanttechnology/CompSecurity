// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.common;


public final class Priority extends Enum
{

    private static final Priority $VALUES[];
    public static final Priority HIGH;
    public static final Priority LOW;
    public static final Priority MEDIUM;

    private Priority(String s, int i)
    {
        super(s, i);
    }

    public static Priority getHigherPriority(Priority priority, Priority priority1)
    {
        if (priority != null)
        {
            if (priority1 == null)
            {
                return priority;
            }
            if (priority.ordinal() > priority1.ordinal())
            {
                return priority;
            }
        }
        return priority1;
    }

    public static Priority valueOf(String s)
    {
        return (Priority)Enum.valueOf(com/facebook/imagepipeline/common/Priority, s);
    }

    public static Priority[] values()
    {
        return (Priority[])$VALUES.clone();
    }

    static 
    {
        LOW = new Priority("LOW", 0);
        MEDIUM = new Priority("MEDIUM", 1);
        HIGH = new Priority("HIGH", 2);
        $VALUES = (new Priority[] {
            LOW, MEDIUM, HIGH
        });
    }
}
