// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.client;

import android.content.res.Resources;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;

public class ClientIdProvider
{

    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/client/ClientIdProvider);
    private static final String unknownClientID = "unknown";

    public ClientIdProvider()
    {
    }

    public static String getClientId(Resources resources)
    {
        return readClientIdFromConfig(resources);
    }

    private static String readClientIdFromConfig(Resources resources)
    {
        String s = resources.getString(com.amazon.retailsearch.R.string.config_rs_client_id);
        resources = s;
        if (s == null)
        {
            log.error("SRDS client ID is null");
            resources = "unknown";
        }
        return resources;
    }

}
