// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.util.Stack;

// Referenced classes of package com.millennialmedia.android:
//            BridgeMMBanner, BridgeMMCachedVideo, BridgeMMCalendar, BridgeMMDevice, 
//            BridgeMMInlineVideo, BridgeMMInterstitial, BridgeMMMedia, BridgeMMNotification, 
//            BridgeMMSpeechkit

class ComponentRegistry
{

    private static Stack a = new Stack();
    private static Stack b = new Stack();
    private static Stack c = new Stack();
    private static Stack d = new Stack();
    private static Stack e = new Stack();
    private static Stack f = new Stack();
    private static Stack g = new Stack();
    private static Stack h = new Stack();
    private static Stack i = new Stack();
    private static Stack j = new Stack();

    ComponentRegistry()
    {
    }

    static BridgeMMBanner a()
    {
        return (BridgeMMBanner)a(a);
    }

    private static Object a(Stack stack)
    {
        if (stack.isEmpty())
        {
            return null;
        } else
        {
            return stack.lastElement();
        }
    }

    static void a(BridgeMMBanner bridgemmbanner)
    {
        a.push(bridgemmbanner);
    }

    static void a(BridgeMMCachedVideo bridgemmcachedvideo)
    {
        b.push(bridgemmcachedvideo);
    }

    static void a(BridgeMMCalendar bridgemmcalendar)
    {
        c.push(bridgemmcalendar);
    }

    static void a(BridgeMMDevice bridgemmdevice)
    {
        d.push(bridgemmdevice);
    }

    static void a(BridgeMMInlineVideo bridgemminlinevideo)
    {
        e.push(bridgemminlinevideo);
    }

    static void a(BridgeMMInterstitial bridgemminterstitial)
    {
        f.push(bridgemminterstitial);
    }

    static void a(BridgeMMMedia bridgemmmedia)
    {
        g.push(bridgemmmedia);
    }

    static void a(BridgeMMNotification bridgemmnotification)
    {
        h.push(bridgemmnotification);
    }

    static void a(BridgeMMSpeechkit bridgemmspeechkit)
    {
        i.push(bridgemmspeechkit);
    }

    static void a(MMLog.LoggingComponent loggingcomponent)
    {
        j.push(loggingcomponent);
    }

    static BridgeMMCachedVideo b()
    {
        return (BridgeMMCachedVideo)a(b);
    }

    static BridgeMMCalendar c()
    {
        return (BridgeMMCalendar)a(c);
    }

    static BridgeMMDevice d()
    {
        return (BridgeMMDevice)a(d);
    }

    static BridgeMMInlineVideo e()
    {
        return (BridgeMMInlineVideo)a(e);
    }

    static BridgeMMInterstitial f()
    {
        return (BridgeMMInterstitial)a(f);
    }

    static BridgeMMMedia g()
    {
        return (BridgeMMMedia)a(g);
    }

    static BridgeMMNotification h()
    {
        return (BridgeMMNotification)a(h);
    }

    static BridgeMMSpeechkit i()
    {
        return (BridgeMMSpeechkit)a(i);
    }

    static MMLog.LoggingComponent j()
    {
        return (MMLog.LoggingComponent)a(j);
    }

    static 
    {
        new Stack();
    }
}
