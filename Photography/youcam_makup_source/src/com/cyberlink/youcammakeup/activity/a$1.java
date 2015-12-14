// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;


// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            a

class a
    implements ad.UncaughtExceptionHandler
{

    final ad.UncaughtExceptionHandler a;
    final a b;

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        Runnable runnable = com.cyberlink.youcammakeup.activity.a.a(b);
        b.a();
        if (runnable != null)
        {
            try
            {
                runnable.run();
            }
            catch (Exception exception) { }
        }
        if (a != null)
        {
            a.uncaughtException(thread, throwable);
        }
    }

    r(a a1, ad.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        b = a1;
        a = uncaughtexceptionhandler;
        super();
    }
}
