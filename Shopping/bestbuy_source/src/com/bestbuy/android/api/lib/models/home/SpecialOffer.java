// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class SpecialOffer
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xfa631f607d778b8fL;
    private boolean displayOnMdot;
    private String name;
    private String target;
    private String url;

    public SpecialOffer()
    {
    }

    public String getName()
    {
        return name;
    }

    public String getTarget()
    {
        return target;
    }

    public String getUrl()
    {
        return url;
    }

    public boolean isDisplayOnMdot()
    {
        return displayOnMdot;
    }

    public void setDisplayOnMdot(boolean flag)
    {
        displayOnMdot = flag;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setTarget(String s)
    {
        target = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
