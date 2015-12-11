// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import org.json.JSONObject;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavOperation

public static class 
{

    public static final String MASH_NAV_REQUEST_METHOD = "method";
    public static final String MASH_NAV_REQUEST_PARAMETERS = "parameters";
    public static final String MASH_NAV_REQUEST_URL = "url";
    private String mMethod;
    private JSONObject mParams;
    private String mUrl;

    public String getMethod()
    {
        return mMethod;
    }

    public JSONObject getParams()
    {
        return mParams;
    }

    public String getUrl()
    {
        return mUrl;
    }

    public void setMethod(String s)
    {
        mMethod = s;
    }

    public void setParams(JSONObject jsonobject)
    {
        mParams = jsonobject;
    }

    public void setUrl(String s)
    {
        mUrl = s;
    }

    public ()
    {
    }
}
