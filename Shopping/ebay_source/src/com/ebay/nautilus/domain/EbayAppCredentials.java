// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import com.ebay.nautilus.domain.net.EbayAccessTokenRequest;
import com.ebay.nautilus.domain.net.EbayAccessTokenResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Connector;
import java.text.DateFormat;
import java.util.Date;

public final class EbayAppCredentials
{

    public final String appId;
    public final String appName;
    public final String certId;
    public final String developerId;
    private long oAuthExpirationDate;
    private String oAuthToken;
    public final String paypalAppId;
    public final String trackingAppId;
    public final String userAgent;

    public EbayAppCredentials(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        trackingAppId = s;
        appId = s1;
        appName = s2;
        developerId = s3;
        certId = s4;
        paypalAppId = s5;
        userAgent = s6;
    }

    public static EbayAppCredentials get(EbayContext ebaycontext)
    {
        return (EbayAppCredentials)ebaycontext.getExtension(com/ebay/nautilus/domain/EbayAppCredentials);
    }

    public String getBearerToken(EbayContext ebaycontext, String s, ResultStatusOwner resultstatusowner)
        throws InterruptedException
    {
        NautilusKernel.verifyNotMain();
        if (s != null)
        {
            return s;
        }
        this;
        JVM INSTR monitorenter ;
        if (oAuthToken == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (System.currentTimeMillis() + 0x493e0L >= oAuthExpirationDate)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        ebaycontext = oAuthToken;
        this;
        JVM INSTR monitorexit ;
        return ebaycontext;
        ebaycontext;
        this;
        JVM INSTR monitorexit ;
        throw ebaycontext;
        oAuthToken = null;
        s = new EbayAccessTokenRequest(appId, certId);
        ebaycontext = (EbayAccessTokenResponse)ebaycontext.getConnector().sendRequest(s);
        resultstatusowner.setResultStatus(ebaycontext.getResultStatus());
        if (resultstatusowner.getResultStatus().hasError())
        {
            break MISSING_BLOCK_LABEL_125;
        }
        oAuthToken = ((EbayAccessTokenResponse) (ebaycontext)).token;
        oAuthExpirationDate = ((EbayAccessTokenResponse) (ebaycontext)).expirationDate;
        ebaycontext = oAuthToken;
        return ebaycontext;
        this;
        JVM INSTR monitorexit ;
        return null;
    }

    public void invalidateBearerToken(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        if (!s.equals(oAuthToken))
        {
            break MISSING_BLOCK_LABEL_22;
        }
        oAuthToken = null;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{appId:").append(appId).append(", appName:").append(appName).append(", developerId:").append(developerId).append(", certId:").append(certId).append(", userAgent:").append(userAgent).append(", accessToken:").append(oAuthToken);
        if (oAuthToken != null)
        {
            stringbuilder.append(" (");
            if (System.currentTimeMillis() < oAuthExpirationDate)
            {
                stringbuilder.append("expires:").append(DateFormat.getDateTimeInstance().format(new Date(oAuthExpirationDate)));
            } else
            {
                stringbuilder.append("expired");
            }
            stringbuilder.append(')');
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }
}
