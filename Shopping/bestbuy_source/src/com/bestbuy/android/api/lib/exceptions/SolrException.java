// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.exceptions;

import org.json.JSONObject;

public class SolrException extends Exception
{

    private static final long serialVersionUID = 0x47e4ffc352960f41L;
    private String errorCode;
    private String errorMessage;
    private String moreInfo;
    private int statusCode;

    public SolrException(String s, String s1, String s2, int i)
    {
        errorCode = "";
        errorMessage = "";
        moreInfo = "";
        statusCode = 0;
        errorCode = s;
        errorMessage = s1;
        moreInfo = s2;
        statusCode = i;
    }

    public SolrException(JSONObject jsonobject)
    {
        errorCode = "";
        errorMessage = "";
        moreInfo = "";
        statusCode = 0;
        errorCode = jsonobject.optString("errorCode");
        errorMessage = jsonobject.optString("errorMessage");
        moreInfo = jsonobject.optString("moreInfo");
        statusCode = jsonobject.optInt("statusCode");
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public String getMoreInfo()
    {
        return moreInfo;
    }

    public int getStatusCode()
    {
        return statusCode;
    }
}
