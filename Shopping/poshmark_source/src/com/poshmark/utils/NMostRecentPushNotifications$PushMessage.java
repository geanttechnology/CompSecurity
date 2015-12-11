// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            NMostRecentPushNotifications

public static class priority
{

    String msg;
    int priority;

    public CharSequence getMessage()
    {
        return msg;
    }

    public A(String s)
    {
        priority = 0;
        msg = s;
    }

    public msg(String s, String s1)
    {
        priority = 0;
        msg = s;
        try
        {
            priority = Integer.parseInt(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            priority = 1;
        }
    }
}
