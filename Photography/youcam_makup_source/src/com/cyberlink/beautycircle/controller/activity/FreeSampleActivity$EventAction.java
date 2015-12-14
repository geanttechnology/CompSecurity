// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;


public final class action extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];
    public String action;

    public static action a(String s)
    {
        action action1 = a;
        if (b.action.equals(s))
        {
            action1 = b;
        } else
        {
            if (d.action.equals(s))
            {
                return d;
            }
            if (e.action.equals(s))
            {
                return e;
            }
            if (c.action.equals(s))
            {
                return c;
            }
        }
        return action1;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/cyberlink/beautycircle/controller/activity/FreeSampleActivity$EventAction, s);
    }

    public static c[] values()
    {
        return (c[])f.clone();
    }

    static 
    {
        a = new <init>("NONE", 0, "");
        b = new <init>("APPLY", 1, "apply");
        c = new <init>("LISTUSER", 2, "listuser");
        d = new <init>("MESSAGE", 3, "message");
        e = new <init>("RESULT", 4, "result");
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        action = s1;
    }
}
