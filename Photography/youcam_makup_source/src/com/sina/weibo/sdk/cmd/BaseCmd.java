// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.cmd;

import com.sina.weibo.sdk.exception.WeiboException;
import org.json.JSONException;
import org.json.JSONObject;

class BaseCmd
{

    private long mNotificationDelay;
    private String mNotificationText;
    private String mNotificationTitle;

    public BaseCmd()
    {
    }

    public BaseCmd(String s)
    {
        initFromJsonStr(s);
    }

    public BaseCmd(JSONObject jsonobject)
    {
        initFromJsonObj(jsonobject);
    }

    public long getNotificationDelay()
    {
        return mNotificationDelay;
    }

    public String getNotificationText()
    {
        return mNotificationText;
    }

    public String getNotificationTitle()
    {
        return mNotificationTitle;
    }

    protected void initFromJsonObj(JSONObject jsonobject)
    {
        mNotificationText = jsonobject.optString("notification_text");
        mNotificationTitle = jsonobject.optString("notification_title");
        mNotificationDelay = jsonobject.optLong("notification_delay");
    }

    protected void initFromJsonStr(String s)
    {
        if (s == null)
        {
            return;
        }
        try
        {
            initFromJsonObj(new JSONObject(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        throw new WeiboException("pase cmd has error !!!");
    }

    public void setNotificationDelay(long l)
    {
        mNotificationDelay = l;
    }

    public void setNotificationText(String s)
    {
        mNotificationText = s;
    }

    public void setNotificationTitle(String s)
    {
        mNotificationTitle = s;
    }
}
