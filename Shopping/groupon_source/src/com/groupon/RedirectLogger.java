// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import android.app.Fragment;
import com.groupon.tracking.mobile.events.MobileEvent;
import com.groupon.tracking.mobile.sdk.Logger;
import com.squareup.otto.Bus;

public class RedirectLogger
{
    public static class LogContextEvent
    {

        private MobileEvent event;
        private String keyString;

        public MobileEvent getEvent()
        {
            return event;
        }

        public String getKeyString()
        {
            return keyString;
        }

        public LogContextEvent(String s, MobileEvent mobileevent)
        {
            keyString = s;
            event = mobileevent;
        }
    }


    public static final String INVALID_KEYSTRING = "INVALID_KEYSTRING";
    private Bus bus;
    private String keyString;
    private final Logger logger;

    public RedirectLogger(Bus bus1, Logger logger1)
    {
        logger = logger1;
        bus = bus1;
        bus1.register(this);
    }

    protected void finalize()
        throws Throwable
    {
        bus.unregister(this);
        super.finalize();
    }

    public void handlesNullLogEvents(LogContextEvent logcontextevent)
    {
        if (logcontextevent.getKeyString() == null)
        {
            logger.log(logcontextevent.getEvent());
        }
    }

    public void log(Fragment fragment, MobileEvent mobileevent)
    {
        if (fragment != null)
        {
            fragment = fragment.getClass().getSimpleName();
        } else
        {
            fragment = null;
        }
        log(((String) (fragment)), mobileevent);
    }

    public void log(MobileEvent mobileevent)
    {
        bus.post(new LogContextEvent(keyString, mobileevent));
    }

    public void log(String s, MobileEvent mobileevent)
    {
        bus.post(new LogContextEvent(s, mobileevent));
    }

    public void setKeyString(String s)
    {
        keyString = s;
    }
}
