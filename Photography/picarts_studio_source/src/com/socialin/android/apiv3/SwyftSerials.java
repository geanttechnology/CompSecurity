// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class SwyftSerials
{

    private String asset;
    private String brand;
    private String pack;

    public SwyftSerials(String s, String s1, String s2)
    {
        brand = s;
        pack = s1;
        asset = s2;
    }

    public JSONObject toJSON()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            if (!TextUtils.isEmpty(brand))
            {
                jsonobject.put("brand", brand);
            }
            if (!TextUtils.isEmpty(pack))
            {
                jsonobject.put("pack", pack);
            }
            if (!TextUtils.isEmpty(asset))
            {
                jsonobject.put("asset", asset);
            }
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }
}
