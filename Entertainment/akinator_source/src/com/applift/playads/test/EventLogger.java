// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applift.playads.test;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.applift.playads.test:
//            Event

public class EventLogger
{

    private static Handler handler;
    private static Listener listener;
    private static Boolean testApp;

    public EventLogger()
    {
    }

    public static void logEvent(Event event)
    {
        logEvent(event, null, null);
    }

    public static void logEvent(Event event, Object obj)
    {
        logEvent(event, obj, null);
    }

    public static void logEvent(Event event, Object obj, Boolean boolean1)
    {
        if (listener != null && runningFromTesterApp())
        {
            if (handler == null)
            {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new _cls1(event, boolean1, obj));
        }
    }

    public static void logEvent(Event event, boolean flag)
    {
        logEvent(event, null, Boolean.valueOf(flag));
    }

    private static boolean runningFromTesterApp()
    {
        if (testApp == null)
        {
            try
            {
                Class.forName("com.applift.playads.tester.MainActivity");
                testApp = Boolean.valueOf(true);
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                testApp = Boolean.valueOf(false);
            }
        }
        return testApp.booleanValue();
    }

    public static void setListener(Listener listener1)
    {
        listener = listener1;
    }


    // Unreferenced inner class com/applift/playads/test/EventLogger$Listener
    /* block-local class not found */
    class Listener {}


    /* member class not found */
    class _cls1 {}

}
