// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class CartAdditionRequest
{

    private List additions;
    private String clickStreamOrigin;

    public CartAdditionRequest()
    {
    }

    public List getAdditions()
    {
        return additions;
    }

    public String getClickStreamOrigin()
    {
        return clickStreamOrigin;
    }

    public void setAdditions(List list)
    {
        additions = list;
    }

    public void setClickStreamOrigin(String s)
    {
        clickStreamOrigin = s;
    }
}
