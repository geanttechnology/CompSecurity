// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia.api;


public class a
{

    private com.baidu.frontia.module.push.entImpl a;

    com.baidu.frontia.module.push.entImpl a()
    {
        return a;
    }

    public int getBuilderId()
    {
        return a.getBuilderId();
    }

    public tionStyle getNotificationStyle()
    {
        return new tionStyle(a.getNotificationStyle());
    }

    public String getPKGContent()
    {
        return a.getPKGContent();
    }

    public String getUrl()
    {
        return a.getUrl();
    }

    public void setBuilderId(int i)
    {
        a.setBuilderId(i);
    }

    public void setNotificationStyle(tionStyle tionstyle)
    {
        a.setNotificationStyle(tionstyle.a());
    }

    public void setPKGContent(String s)
    {
        a.setPKGContent(s);
    }

    public void setUrl(String s)
    {
        a.setUrl(s);
    }

    public roidContentImpl()
    {
        a = new com.baidu.frontia.module.push.entImpl();
    }

    roidContentImpl(com.baidu.frontia.module.push.entImpl entimpl)
    {
        a = entimpl;
    }
}
