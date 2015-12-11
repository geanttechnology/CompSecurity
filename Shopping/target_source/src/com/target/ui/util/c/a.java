// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.c;

import com.google.a.a.f;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.NoSubscriberEvent;

public class com.target.ui.util.c.a
{
    public static class a
        implements b
    {

        public void a(NoSubscriberEvent nosubscriberevent)
        {
            nosubscriberevent = nosubscriberevent.originalEvent.getClass().getSimpleName();
            com.target.a.a.b.b(com.target.ui.util.c.a.b(), (new StringBuilder()).append("\n\n\n\n\nWARNING: NO SUBSCRIBERS FOR POSTED EVENT: ").append(nosubscriberevent).append("\n\n\n\n\n").toString());
        }

        public a()
        {
        }
    }

    public static interface b
    {

        public abstract void a(NoSubscriberEvent nosubscriberevent);
    }

    public static class c
    {

        private final b handler;

        public void onEvent(NoSubscriberEvent nosubscriberevent)
        {
            handler.a(nosubscriberevent);
        }

        private c(b b1)
        {
            handler = b1;
        }

    }


    private static final String TAG = com/target/ui/util/c/a.getSimpleName();
    private static EventBus sBus;
    private static c sNoSubscribersListener;

    public com.target.ui.util.c.a()
    {
    }

    public static EventBus a()
    {
        f.a(sBus, "You must call BusProvider.init() before accessing the event bus!");
        return sBus;
    }

    public static void a(EventBus eventbus, b b1)
    {
        boolean flag;
        if (sBus == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag, "BusProvider already initialized!");
        sBus = eventbus;
        sNoSubscribersListener = new c(b1);
        sBus.register(sNoSubscribersListener);
    }

    static String b()
    {
        return TAG;
    }

}
