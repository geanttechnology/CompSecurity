// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.json.JSONObject;

public class FormFieldOption
{

    private String availableLabel;
    private boolean isAvailable;
    private boolean isDefaultValue;
    private String name;
    private String nameBrandingKey;
    private String value;

    protected FormFieldOption(JSONObject jsonobject)
    {
        name = jsonobject.optString("Name");
        value = jsonobject.optString("Value");
        isDefaultValue = jsonobject.optBoolean("Default", false);
        nameBrandingKey = jsonobject.optString("NameBrandingKey");
        isAvailable = jsonobject.optBoolean("Available", true);
        availableLabel = jsonobject.optString("AvailableLabel");
    }

    public String getAvailableLabel()
    {
        return availableLabel;
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

    public boolean isAvailable()
    {
        return isAvailable;
    }

    public boolean isDefaultValue()
    {
        return isDefaultValue;
    }
}
