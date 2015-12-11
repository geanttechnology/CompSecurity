// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import android.content.Context;
import com.rdio.android.core.OAuth2Session;
import com.rdio.android.core.RdioApiRequestArg;
import com.rdio.android.core.stations.StationService;
import com.rdio.android.sdk.RdioService;
import java.util.List;

public class RdioFullService extends RdioService
    implements StationService
{

    public RdioFullService(String s, Context context, OAuth2Session oauth2session)
    {
        super(s, context, oauth2session);
    }

    public void generateStation(String s, List list, int i, int j, List list1, com.rdio.android.core.RdioService_Api.ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            createArg("method", "generateStation"), createArg("station_key", s), createArg("exclude_tracks", list), createArg("count", Integer.valueOf(i)), createArg("preset", Integer.valueOf(j)), createArg("extras", list1)
        }, responselistener);
    }
}
