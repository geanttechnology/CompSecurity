// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.reviews;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Error
{

    private String code;
    private String message;

    public Error()
    {
    }

    public static ArrayList loadErrorsData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                Error error = new Error();
                error.message = jsonobject.optString("Message");
                error.code = jsonobject.optString("Code");
                arraylist.add(error);
            }
        }

        return arraylist;
    }

    public String getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }
}
