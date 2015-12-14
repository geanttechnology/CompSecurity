// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia.api;


public class b
{

    private com.baidu.frontia.module.push.entImpl a;
    private int b;

    public static b createNotificationMessage(String s, String s1, String s2)
    {
        return new <init>(com.baidu.frontia.module.push.entImpl.createNotificationMessage(s, s1, s2));
    }

    public static ionMessage createStringMessage(String s, String s1)
    {
        return new <init>(com.baidu.frontia.module.push.entImpl.createStringMessage(s, s1));
    }

    com.baidu.frontia.module.push.entImpl a()
    {
        return a;
    }

    public a getDeployStatus()
    {
        if (a.getDeployStatus() == 1)
        {
            return VELOPE;
        } else
        {
            return ODUCTION;
        }
    }

    public String getMessage()
    {
        return a.getMesssage();
    }

    public String getMessageKeys()
    {
        return a.getMessageKeys();
    }

    public tent getNotification()
    {
        return new tent(a.getNotificationContent());
    }

    public void setMessage(String s)
    {
        a.setMessage(s);
    }

    public void setNotification(tent tent)
    {
        a.setNotification(tent.a());
    }

    sageContentImpl(com.baidu.frontia.module.push.entImpl entimpl)
    {
        a = entimpl;
    }

    public a(String s, a a1)
    {
        if (a1 == VELOPE)
        {
            b = 1;
        } else
        {
            b = 2;
        }
        a = new com.baidu.frontia.module.push.entImpl(s, b);
    }
}
