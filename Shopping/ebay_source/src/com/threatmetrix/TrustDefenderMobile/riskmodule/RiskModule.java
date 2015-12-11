// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile.riskmodule;

import android.content.Context;
import android.location.Location;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import org.apache.http.Header;

public interface RiskModule
{

    public abstract byte[] getConfigurationBody();

    public abstract Header[] getConfigurationHTTPHeaders(String s);

    public abstract String getConfigurationHttpMethod();

    public abstract URL getConfigurationURL()
        throws MalformedURLException;

    public abstract byte[] getRiskDataBody(Hashtable hashtable);

    public abstract Header[] getRiskDataHTTPHeaders();

    public abstract String getRiskDataHttpMethod();

    public abstract URL getRiskDataURL()
        throws MalformedURLException;

    public abstract String getSessionID();

    public abstract boolean initWithoutTransport(String s, String s1);

    public abstract void prepareRiskTransaction(Context context);

    public abstract Object setConfigurationData(byte abyte0[]);

    public abstract void setLocation(Location location);

    public abstract void setRiskDataResponse(byte abyte0[])
        throws Exception;
}
