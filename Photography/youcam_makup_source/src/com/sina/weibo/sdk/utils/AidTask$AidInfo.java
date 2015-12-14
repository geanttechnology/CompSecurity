// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import com.sina.weibo.sdk.exception.WeiboException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            LogUtil

public final class on
{

    private String mAid;
    private String mSubCookie;

    public static on parseJson(String s)
    {
        on on;
        on = new <init>();
        try
        {
            s = new JSONObject(s);
            if (s.has("error") || s.has("error_code"))
            {
                LogUtil.d("AidTask", "loadAidFromNet has error !!!");
                throw new WeiboException("loadAidFromNet has error !!!");
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogUtil.d("AidTask", (new StringBuilder("loadAidFromNet JSONException Msg : ")).append(s.getMessage()).toString());
            throw new WeiboException("loadAidFromNet has error !!!");
        }
        on.mAid = s.optString("aid", "");
        on.mSubCookie = s.optString("sub", "");
        return on;
    }

    mSubCookie cloneAidInfo()
    {
        mSubCookie msubcookie = new <init>();
        msubcookie.mAid = mAid;
        msubcookie.mSubCookie = mSubCookie;
        return msubcookie;
    }

    public String getAid()
    {
        return mAid;
    }

    public String getSubCookie()
    {
        return mSubCookie;
    }

    public on()
    {
    }
}
