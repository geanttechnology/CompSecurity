// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;


// Referenced classes of package com.smule.android.console:
//            DebugConsoleActivity, i, ConsoleScrollView

class a
    implements Runnable
{

    final DebugConsoleActivity a;

    public void run()
    {
        if (DebugConsoleActivity.b(a).getViewableHeight() > DebugConsoleActivity.c(a).getHeight())
        {
            DebugConsoleActivity.c(a).scrollTo(0, DebugConsoleActivity.b(a).getHeight());
        }
    }

    (DebugConsoleActivity debugconsoleactivity)
    {
        a = debugconsoleactivity;
        super();
    }
}
