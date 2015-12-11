// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.h;

import com.rdio.android.core.RdioApiResponse;
import org.json.JSONObject;

public final class a
    implements com.shazam.b.a.a
{

    public a()
    {
    }

    public final Object a(Object obj)
    {
        Object obj1 = ((RdioApiResponse)obj).getResult();
        obj = com.shazam.model.rdio.RdioPlaylistInfo.Builder.a();
        if (obj1 != null && (obj1 instanceof JSONObject))
        {
            obj1 = (JSONObject)obj1;
            obj.key = ((JSONObject) (obj1)).optString("key");
            obj.url = ((JSONObject) (obj1)).optString("url");
        }
        return ((com.shazam.model.rdio.RdioPlaylistInfo.Builder) (obj)).b();
    }
}
