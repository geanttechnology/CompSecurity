// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.HttpVerb;
import com.amazon.identity.kcpsdk.common.WebProtocol;
import com.amazon.identity.kcpsdk.common.WebRequest;

public class DeregisterDeviceRequest
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest.getName();
    private boolean mDeregisterExisting;
    private boolean mDidDeleteContent;
    private WebRequest mWebRequest;

    public DeregisterDeviceRequest()
    {
    }

    public WebRequest getWebRequest()
    {
        if (mWebRequest != null)
        {
            return mWebRequest;
        }
        mWebRequest = new WebRequest();
        mWebRequest.setProtocol(WebProtocol.WebProtocolHttps);
        mWebRequest.setHost(EnvironmentUtils.getInstance().getFIRSHost());
        mWebRequest.setPath("/FirsProxy/disownFiona");
        mWebRequest.setVerb(HttpVerb.HttpVerbGet);
        String s;
        String s1;
        if (mDidDeleteContent)
        {
            mWebRequest.addQueryParameter("contentDeleted", "true");
        } else
        {
            mWebRequest.addQueryParameter("contentDeleted", "false");
        }
        if (mDeregisterExisting)
        {
            mWebRequest.addQueryParameter("deregisterExisting", "true");
        } else
        {
            mWebRequest.addQueryParameter("deregisterExisting", "false");
        }
        mWebRequest.setHeader("Content-Type", "text/xml");
        mWebRequest.setAuthenticationRequired(true);
        s1 = TAG;
        if (mDidDeleteContent)
        {
            s = "Yes";
        } else
        {
            s = "No";
        }
        MAPLog.formattedInfo(s1, "DeregisterDeviceRequest: getWebRequest: constructed a web request with:\nContent Deleted: %s", new Object[] {
            s
        });
        return mWebRequest;
    }

    public void setDeregisterAllAccountsForDevice(boolean flag)
    {
        mDeregisterExisting = flag;
    }

    public void setDidDeleteContent$1385ff()
    {
        mDidDeleteContent = false;
    }

}
