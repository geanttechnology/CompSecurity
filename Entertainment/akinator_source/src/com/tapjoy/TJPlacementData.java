// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import java.io.Serializable;
import java.util.UUID;

public class TJPlacementData
    implements Serializable
{

    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;
    private int g;
    private boolean h;
    private String i;
    private boolean j;

    public TJPlacementData(String s)
    {
        b = s;
        setBaseURL(s.substring(0, s.indexOf('/', s.indexOf("//") + 3)));
        a = UUID.randomUUID().toString();
    }

    public TJPlacementData(String s, String s1)
    {
        setBaseURL(s);
        setHttpResponse(s1);
        a = UUID.randomUUID().toString();
    }

    public String getBaseURL()
    {
        return c;
    }

    public String getGuid()
    {
        return a;
    }

    public String getHttpResponse()
    {
        return d;
    }

    public int getHttpStatusCode()
    {
        return e;
    }

    public String getPlacementName()
    {
        return f;
    }

    public String getRedirectURL()
    {
        return i;
    }

    public String getUrl()
    {
        return b;
    }

    public int getViewType()
    {
        return g;
    }

    public boolean hasProgressSpinner()
    {
        return h;
    }

    public boolean isPrerenderingRequested()
    {
        return j;
    }

    public void resetPlacementRequestData()
    {
        setHttpResponse(null);
        setHttpStatusCode(0);
        setRedirectURL(null);
        setHasProgressSpinner(false);
        setPrerenderingRequested(false);
    }

    public void setBaseURL(String s)
    {
        c = s;
    }

    public void setHasProgressSpinner(boolean flag)
    {
        h = flag;
    }

    public void setHttpResponse(String s)
    {
        d = s;
    }

    public void setHttpStatusCode(int k)
    {
        e = k;
    }

    public void setPlacementName(String s)
    {
        f = s;
    }

    public void setPrerenderingRequested(boolean flag)
    {
        j = flag;
    }

    public void setRedirectURL(String s)
    {
        i = s;
    }

    public void setViewType(int k)
    {
        g = k;
    }
}
