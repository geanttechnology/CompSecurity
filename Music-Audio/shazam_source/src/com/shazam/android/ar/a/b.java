// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ar.a;

import com.rdio.android.core.RdioApiResponse;
import com.shazam.b.a.a;
import com.shazam.j.c;
import com.shazam.server.response.streaming.rdio.RdioTrialStartStatus;
import org.json.JSONObject;

public final class b
    implements a
{

    private final com.shazam.j.b a;

    public b(com.shazam.j.b b1)
    {
        a = b1;
    }

    private RdioTrialStartStatus a(RdioApiResponse rdioapiresponse)
    {
        rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
        try
        {
            rdioapiresponse = (RdioTrialStartStatus)a.a(rdioapiresponse.toString(), com/shazam/server/response/streaming/rdio/RdioTrialStartStatus);
        }
        // Misplaced declaration of an exception variable
        catch (RdioApiResponse rdioapiresponse)
        {
            return RdioTrialStartStatus.EMPTY;
        }
        return rdioapiresponse;
    }

    public final volatile Object a(Object obj)
    {
        return a((RdioApiResponse)obj);
    }
}
