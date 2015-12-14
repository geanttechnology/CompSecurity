// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.network.Networking;

public abstract class BaseUrlGenerator
{

    private static final String HEIGHT_KEY = "h";
    private static final String WIDTH_KEY = "w";
    private boolean mFirstParam;
    private StringBuilder mStringBuilder;

    public BaseUrlGenerator()
    {
    }

    private String getParamDelimiter()
    {
        if (mFirstParam)
        {
            mFirstParam = false;
            return "?";
        } else
        {
            return "&";
        }
    }

    protected void addParam(String s, String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return;
        } else
        {
            mStringBuilder.append(getParamDelimiter());
            mStringBuilder.append(s);
            mStringBuilder.append("=");
            mStringBuilder.append(Uri.encode(s1));
            return;
        }
    }

    protected void appendAdvertisingInfoTemplates()
    {
        addParam("udid", "mp_tmpl_advertising_id");
        addParam("dnt", "mp_tmpl_do_not_track");
    }

    public abstract String generateUrlString(String s);

    protected String getFinalUrlString()
    {
        return mStringBuilder.toString();
    }

    protected void initUrlString(String s, String s1)
    {
        String s2;
        if (Networking.useHttps())
        {
            s2 = "https";
        } else
        {
            s2 = "http";
        }
        mStringBuilder = (new StringBuilder(s2)).append("://").append(s).append(s1);
        mFirstParam = true;
    }

    protected void setApiVersion(String s)
    {
        addParam("v", s);
    }

    protected void setAppVersion(String s)
    {
        addParam("av", s);
    }

    protected void setDeviceDimensions(Point point)
    {
        addParam("w", (new StringBuilder()).append("").append(point.x).toString());
        addParam("h", (new StringBuilder()).append("").append(point.y).toString());
    }

    protected transient void setDeviceInfo(String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (as == null || as.length < 1)
        {
            return;
        }
        for (int i = 0; i < as.length - 1; i++)
        {
            stringbuilder.append(as[i]).append(",");
        }

        stringbuilder.append(as[as.length - 1]);
        addParam("dn", stringbuilder.toString());
    }

    protected void setDoNotTrack(boolean flag)
    {
        if (flag)
        {
            addParam("dnt", "1");
        }
    }

    protected void setExternalStoragePermission(boolean flag)
    {
        String s;
        if (flag)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        addParam("android_perms_ext_storage", s);
    }

    protected void setUdid(String s)
    {
        addParam("udid", s);
    }
}
