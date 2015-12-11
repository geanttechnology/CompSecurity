// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;

import org.json.JSONException;
import org.json.JSONObject;

public class CountryListItem
{

    private static final String API_HOST_NAME = "ApiHostName";
    private static final String COUNTRY_CODE = "CountryCode";
    private static final String COUNTRY_NAME = "CountryName";
    private static final String ID = "ID";
    private static final String UI_TEMPLATE_TYPE = "UITemplateType";
    private String mApiHostName;
    private String mCountryCode;
    private String mCountryName;
    private String mID;
    private String mUITemplateType;

    public CountryListItem(JSONObject jsonobject)
        throws JSONException
    {
        mID = jsonobject.getString("ID");
        mCountryName = jsonobject.getString("CountryName");
        mCountryCode = jsonobject.getString("CountryCode");
        mApiHostName = jsonobject.getString("ApiHostName");
        mUITemplateType = jsonobject.getString("UITemplateType");
    }

    public String getApiHostName()
    {
        return mApiHostName;
    }

    public String getCountryCode()
    {
        return mCountryCode;
    }

    public String getCountryName()
    {
        return mCountryName;
    }

    public String getID()
    {
        return mID;
    }

    public String getUITemplateType()
    {
        return mUITemplateType;
    }
}
