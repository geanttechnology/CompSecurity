// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;

import org.json.JSONException;
import org.json.JSONObject;

public class GenreItem
{

    private static final String ID = "ID";
    private static final String NAME = "Name";
    private static final String PRIMARY = "Primary";
    private String mID;
    private Boolean mIsPrimary;
    private String mName;

    public GenreItem(JSONObject jsonobject)
        throws JSONException
    {
        mID = jsonobject.getString("ID");
        mName = jsonobject.getString("Name");
        mIsPrimary = Boolean.valueOf(jsonobject.getBoolean("Primary"));
    }

    public String getID()
    {
        return mID;
    }

    public String getName()
    {
        return mName;
    }

    public Boolean isPrimary()
    {
        return mIsPrimary;
    }
}
