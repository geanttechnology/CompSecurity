// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class WebResponseHeaders
{

    private static final String TAG = com/amazon/identity/kcpsdk/common/WebResponseHeaders.getName();
    private final List mHeaderNames = new ArrayList();
    private final Map mHeaders = new HashMap();
    private long mStatusCode;

    public WebResponseHeaders()
    {
        mStatusCode = 200L;
    }

    public void addHeader(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            MAPLog.e(TAG, "WebResponseHeaders: addHeader: Header cannot be added. Name or value was null.");
            return;
        } else
        {
            mHeaderNames.add(s);
            mHeaders.put(s.toLowerCase(Locale.US), s1);
            return;
        }
    }

    public String getHeaderByName(String s)
    {
        return (String)mHeaders.get(s.toLowerCase(Locale.US));
    }

    public long getStatusCode()
    {
        return mStatusCode;
    }

    public void setStatusCode(long l)
    {
        mStatusCode = l;
    }

}
