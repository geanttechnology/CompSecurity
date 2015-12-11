// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.net.Uri;

public class ClientAlertsAuthToken
{

    public long expiry;
    public String token;

    public ClientAlertsAuthToken()
    {
    }

    public String getEncodedToken()
    {
        return Uri.encode(token);
    }

    public boolean isValid()
    {
        return token != null && expiry > System.currentTimeMillis();
    }
}
