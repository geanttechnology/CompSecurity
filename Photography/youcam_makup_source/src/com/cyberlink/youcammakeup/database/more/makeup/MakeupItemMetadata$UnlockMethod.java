// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.makeup;


public final class  extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    static  a(String s)
    {
        return b(s);
    }

    private static b b(String s)
    {
        try
        {
            s = valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return c;
        }
        return s;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/cyberlink/youcammakeup/database/more/makeup/MakeupItemMetadata$UnlockMethod, s);
    }

    public static c[] values()
    {
        return (c[])d.clone();
    }

    static 
    {
        a = new <init>("SHARE", 0);
        b = new <init>("BC_LOGIN", 1);
        c = new <init>("OTHER", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
