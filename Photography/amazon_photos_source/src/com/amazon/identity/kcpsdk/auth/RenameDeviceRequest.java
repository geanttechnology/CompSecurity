// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.text.TextUtils;
import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.HttpVerb;
import com.amazon.identity.kcpsdk.common.WebProtocol;
import com.amazon.identity.kcpsdk.common.WebRequest;

public class RenameDeviceRequest
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/RenameDeviceRequest.getName();
    private String mDeviceName;
    private WebRequest mWebRequest;

    public RenameDeviceRequest()
    {
    }

    public WebRequest getWebRequest()
    {
        if (mDeviceName == null)
        {
            MAPLog.e(TAG, "getWebRequest: Cannot construct a WebRequest because the RenameDeviceRequest is invalid. (See previous warnings from RenameDeviceRequest::isValidDeviceName for details.)");
            return null;
        }
        if (mWebRequest != null)
        {
            return mWebRequest;
        }
        mWebRequest = new WebRequest();
        mWebRequest.setProtocol(WebProtocol.WebProtocolHttps);
        mWebRequest.setHost(EnvironmentUtils.getInstance().getFIRSHost());
        mWebRequest.setPath("/FirsProxy/renameFiona");
        mWebRequest.setVerb(HttpVerb.HttpVerbGet);
        if (mDeviceName != null)
        {
            mWebRequest.addQueryParameter("nickname", mDeviceName);
        }
        mWebRequest.setHeader("Content-Type", "text/xml");
        mWebRequest.setAuthenticationRequired(true);
        MAPLog.i(TAG, "getWebRequest: getWebRequest: constructed a web request.");
        String s = TAG;
        s = mDeviceName;
        return mWebRequest;
    }

    public boolean setDeviceName(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            MAPLog.e(TAG, "setDeviceName: device name was invalid. Cannot be set.");
            return false;
        } else
        {
            mDeviceName = s;
            return true;
        }
    }

}
