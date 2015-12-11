// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.oauth.signpost.commonshttpandroid;

import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import oauth.signpost.AbstractOAuthProvider;

public class CommonsHttpOAuthProvider extends AbstractOAuthProvider
{

    private transient HttpClient httpClient;

    public void setHttpClient(HttpClient httpclient)
    {
        httpClient = httpclient;
    }
}
