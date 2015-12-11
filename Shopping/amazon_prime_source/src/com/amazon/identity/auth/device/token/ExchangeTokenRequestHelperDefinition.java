// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import com.amazon.identity.auth.device.framework.Tracer;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

public interface ExchangeTokenRequestHelperDefinition
{

    public abstract boolean isFailure(int i);

    public abstract com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError parseExchangeTokenFailure(JSONObject jsonobject);

    public abstract OAuthTokenManager.ExchangeTokenResponse parseExchangeTokenSuccess(JSONObject jsonobject)
        throws JSONException, ParseException;

    public abstract HttpURLConnection startExchangeTokenRequest(String s, String s1, String s2, Tracer tracer)
        throws IOException, JSONException;
}
