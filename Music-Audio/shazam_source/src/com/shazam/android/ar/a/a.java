// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ar.a;

import com.rdio.android.core.RdioApiResponse;
import com.shazam.j.b;
import com.shazam.j.c;
import com.shazam.server.response.streaming.rdio.RdioUserPlaylists;
import org.json.JSONObject;

public final class a
    implements com.shazam.b.a.a
{

    private final b a;

    public a(b b1)
    {
        a = b1;
    }

    private RdioUserPlaylists a(RdioApiResponse rdioapiresponse)
    {
        Object obj = (JSONObject)rdioapiresponse.getResult();
        rdioapiresponse = RdioUserPlaylists.EMPTY;
        try
        {
            obj = (RdioUserPlaylists)a.a(((JSONObject) (obj)).toString(), com/shazam/server/response/streaming/rdio/RdioUserPlaylists);
        }
        catch (c c1)
        {
            return rdioapiresponse;
        }
        return ((RdioUserPlaylists) (obj));
    }

    public final volatile Object a(Object obj)
    {
        return a((RdioApiResponse)obj);
    }
}
