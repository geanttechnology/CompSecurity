// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;


public final class index extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];
    public final int index;

    public static index valueOf(String s)
    {
        return (index)Enum.valueOf(com/cyberlink/beautycircle/controller/fragment/PageNotificationsFragment$NotificationTab, s);
    }

    public static index[] values()
    {
        return (index[])e.clone();
    }

    static 
    {
        a = new <init>("INVALID", 0, -1);
        b = new <init>("PEOPLE", 1, 0);
        c = new <init>("YOU", 2, 1);
        d = new <init>("MESSAGES", 3, 2);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        index = j;
    }
}
