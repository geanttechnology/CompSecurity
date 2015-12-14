// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class code
{

    private int code;
    private String picId;

    public static code parse(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        code code1 = new <init>();
        try
        {
            s = new JSONObject(s);
            code1.code = s.optInt("code", -2);
            code1.picId = s.optString("data", "");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return code1;
        }
        return code1;
    }

    public int getCode()
    {
        return code;
    }

    public String getPicId()
    {
        return picId;
    }

    private ()
    {
        code = -2;
    }
}
