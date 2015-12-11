// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.util;


// Referenced classes of package com.amazon.rio.j2me.client.util:
//            Worker

public static class name
{

    public static final name EXECUTING = new <init>("EXECUTING");
    public static final <init> IDLE = new <init>("IDLE");
    public static final <init> STOPPED = new <init>("STOPPED");
    private final String name;

    public String toString()
    {
        return name;
    }


    private (String s)
    {
        name = s;
    }
}
