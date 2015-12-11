// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.EnvironmentUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.RequestValidationHelper;

public class PandaRequest
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/PandaRequest.getName();
    private String mCookieDomain;

    public PandaRequest()
    {
    }

    protected String getPandaEndPoint(String s)
    {
        s = (new StringBuilder()).append(getPandaHost()).append(s).toString();
        MAPLog.i(TAG, (new StringBuilder("Using panda endpoint : ")).append(s).toString());
        return s;
    }

    protected String getPandaHost()
    {
        return EnvironmentUtils.getInstance().getPandaHost(mCookieDomain);
    }

    public void setCookieDomain(String s)
    {
        if (RequestValidationHelper.isNullOrEmpty(s) || s.startsWith("."))
        {
            MAPLog.e(TAG, " setCookieDomain: domain was invalid (null, empty or starts with dot). Cannot be set.  Will default to 'amazon.com'");
        }
        mCookieDomain = s;
    }

}
