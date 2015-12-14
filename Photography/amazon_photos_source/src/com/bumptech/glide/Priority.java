// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;


public final class Priority extends Enum
{

    private static final Priority $VALUES[];
    public static final Priority HIGH;
    public static final Priority IMMEDIATE;
    public static final Priority LOW;
    public static final Priority NORMAL;
    public static final Priority priority;

    private Priority(String s, int i)
    {
        super(s, i);
    }

    public static Priority valueOf(String s)
    {
        return (Priority)Enum.valueOf(com/bumptech/glide/Priority, s);
    }

    public static Priority[] values()
    {
        return (Priority[])$VALUES.clone();
    }

    static 
    {
        IMMEDIATE = new Priority("IMMEDIATE", 0);
        HIGH = new Priority("HIGH", 1);
        NORMAL = new Priority("NORMAL", 2);
        LOW = new Priority("LOW", 3);
        priority = new Priority("priority", 4);
        $VALUES = (new Priority[] {
            IMMEDIATE, HIGH, NORMAL, LOW, priority
        });
    }
}
