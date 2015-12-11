// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.event;

import java.net.URL;

public class Subscriber
{

    private String SID;
    private String deliveryHost;
    private String deliveryPath;
    private int deliveryPort;
    private String deliveryURL;
    private String ifAddr;
    private long notifyCount;
    private long subscriptionTime;
    private long timeOut;

    public Subscriber()
    {
        SID = null;
        ifAddr = "";
        deliveryURL = "";
        deliveryHost = "";
        deliveryPath = "";
        deliveryPort = 0;
        timeOut = 0L;
        subscriptionTime = 0L;
        notifyCount = 0L;
        renew();
    }

    public String getDeliveryHost()
    {
        return deliveryHost;
    }

    public String getDeliveryPath()
    {
        return deliveryPath;
    }

    public int getDeliveryPort()
    {
        return deliveryPort;
    }

    public String getDeliveryURL()
    {
        return deliveryURL;
    }

    public String getInterfaceAddress()
    {
        return ifAddr;
    }

    public long getNotifyCount()
    {
        return notifyCount;
    }

    public String getSID()
    {
        return SID;
    }

    public long getSubscriptionTime()
    {
        return subscriptionTime;
    }

    public long getTimeOut()
    {
        return timeOut;
    }

    public void incrementNotifyCount()
    {
        if (notifyCount == 0x7fffffffffffffffL)
        {
            notifyCount = 1L;
            return;
        } else
        {
            notifyCount = notifyCount + 1L;
            return;
        }
    }

    public boolean isExpired()
    {
        for (long l = System.currentTimeMillis(); timeOut == -1L || getSubscriptionTime() + getTimeOut() * 1000L >= l;)
        {
            return false;
        }

        return true;
    }

    public void renew()
    {
        setSubscriptionTime(System.currentTimeMillis());
        setNotifyCount(0);
    }

    public void setDeliveryURL(String s)
    {
        deliveryURL = s;
        try
        {
            s = new URL(s);
            deliveryHost = s.getHost();
            deliveryPath = s.getPath();
            deliveryPort = s.getPort();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void setInterfaceAddress(String s)
    {
        ifAddr = s;
    }

    public void setNotifyCount(int i)
    {
        notifyCount = i;
    }

    public void setSID(String s)
    {
        SID = s;
    }

    public void setSubscriptionTime(long l)
    {
        subscriptionTime = l;
    }

    public void setTimeOut(long l)
    {
        timeOut = l;
    }
}
