// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            AppEvent

public class AmazonOOAppEvent extends AppEvent
{

    public static final AmazonOOAppEvent FIRST_LOGIN = new AmazonOOAppEvent("firstLogin");
    private static final String FIRST_LOGIN_EVENT_NAME = "firstLogin";
    public static final AmazonOOAppEvent FIRST_PURCHASE = new AmazonOOAppEvent("firstPurchase");
    private static final String FIRST_PURCHASE_EVENT_NAME = "firstPurchase";
    protected static final String INSTALL_REFERRER_EVENT_NAME = "INSTALL_REFERRER";
    public static final AmazonOOAppEvent LOGIN = new AmazonOOAppEvent("login");
    private static final String LOGIN_EVENT_NAME = "login";
    public static final AmazonOOAppEvent PURCHASE = new AmazonOOAppEvent("purchase");
    private static final String PURCHASE_EVENT_NAME = "purchase";

    AmazonOOAppEvent(String s)
    {
        super(s);
    }

    public AmazonOOAppEvent(String s, long l)
    {
        super(s, l);
    }

    public static AmazonOOAppEvent createAppEventWithTimestamp(AmazonOOAppEvent amazonooappevent, long l)
    {
        return new AmazonOOAppEvent(amazonooappevent.getEventName(), l);
    }

    public volatile String getEventName()
    {
        return super.getEventName();
    }

    public volatile String getProperty(String s)
    {
        return super.getProperty(s);
    }

    public volatile Set getPropertyEntries()
    {
        return super.getPropertyEntries();
    }

    public volatile long getTimestamp()
    {
        return super.getTimestamp();
    }

    public volatile AppEvent setProperty(String s, String s1)
    {
        return super.setProperty(s, s1);
    }

    public volatile String toString()
    {
        return super.toString();
    }

}
