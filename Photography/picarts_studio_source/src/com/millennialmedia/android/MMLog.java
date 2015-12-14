// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.util.Log;

// Referenced classes of package com.millennialmedia.android:
//            ComponentRegistry

public class MMLog
{

    public MMLog()
    {
    }

    static void a(String s, String s1)
    {
        ComponentRegistry.j();
        if (LoggingComponent.a > 2);
    }

    static void a(String s, String s1, Throwable throwable)
    {
        LoggingComponent loggingcomponent = ComponentRegistry.j();
        if (LoggingComponent.a <= 6)
        {
            loggingcomponent.a(s, (new StringBuilder()).append(s1).append(": ").append(Log.getStackTraceString(throwable)).toString());
        }
    }

    static void b(String s, String s1)
    {
        ComponentRegistry.j();
        if (LoggingComponent.a > 3);
    }

    static void c(String s, String s1)
    {
        ComponentRegistry.j();
        if (LoggingComponent.a <= 4)
        {
            Log.i((new StringBuilder("MMSDK-")).append(s).toString(), s1);
        }
    }

    static void d(String s, String s1)
    {
        ComponentRegistry.j();
        if (LoggingComponent.a <= 5)
        {
            Log.w((new StringBuilder("MMSDK-")).append(s).toString(), s1);
        }
    }

    static void e(String s, String s1)
    {
        LoggingComponent loggingcomponent = ComponentRegistry.j();
        if (LoggingComponent.a <= 6)
        {
            loggingcomponent.a(s, s1);
        }
    }

    public static int getLogLevel()
    {
        return ComponentRegistry.j().getLogLevel();
    }

    public static void setLogLevel(int i)
    {
        ComponentRegistry.j().setLogLevel(i);
    }

    static 
    {
        ComponentRegistry.a(new LoggingComponent());
    }

    private class LoggingComponent
    {

        static int a = 4;

        final void a(String s, String s1)
        {
            Log.e((new StringBuilder("MMSDK-")).append(s).toString(), s1);
        }

        public int getLogLevel()
        {
            return a;
        }

        public void setLogLevel(int i)
        {
            a = i;
        }


        LoggingComponent()
        {
        }
    }

}
