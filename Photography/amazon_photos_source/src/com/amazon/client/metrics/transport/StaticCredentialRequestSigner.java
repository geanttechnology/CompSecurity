// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.transport;

import amazon.communication.MissingCredentialsException;
import amazon.communication.authentication.RequestContext;
import amazon.communication.authentication.RequestSigner;
import amazon.communication.authentication.SigningException;
import com.amazon.device.utils.DeviceUtil;
import org.apache.http.client.methods.HttpRequestBase;

public class StaticCredentialRequestSigner
    implements RequestSigner
{

    private final DeviceUtil mDeviceUtil;

    public StaticCredentialRequestSigner(DeviceUtil deviceutil)
    {
        if (deviceutil == null)
        {
            throw new IllegalArgumentException("deviceUtil cannot be null");
        } else
        {
            mDeviceUtil = deviceutil;
            return;
        }
    }

    public void signRequest(HttpRequestBase httprequestbase, RequestContext requestcontext)
        throws SigningException, MissingCredentialsException
    {
        requestcontext = mDeviceUtil.fetchStaticCredential();
        if (requestcontext != null && !requestcontext.isEmpty())
        {
            httprequestbase.addHeader("x-credential-token", requestcontext);
            return;
        } else
        {
            throw new MissingCredentialsException("Static Credential is unavailable.");
        }
    }
}
