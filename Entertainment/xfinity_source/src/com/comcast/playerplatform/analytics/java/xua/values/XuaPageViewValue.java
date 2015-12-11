// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaPageViewValue extends AbstractXuaValue
{

    private String pageId;
    private String title;

    public XuaPageViewValue(String s, String s1)
    {
        pageId = s;
        title = s1;
    }

    public String getPageId()
    {
        return pageId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setPageId(String s)
    {
        pageId = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
