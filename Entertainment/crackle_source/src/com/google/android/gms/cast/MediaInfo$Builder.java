// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaInfo, MediaMetadata

public static class kN
{

    private final MediaInfo kN;

    public MediaInfo build()
        throws IllegalArgumentException
    {
        kN.aO();
        return kN;
    }

    public kN setContentType(String s)
        throws IllegalArgumentException
    {
        kN.setContentType(s);
        return this;
    }

    public ntType setCustomData(JSONObject jsonobject)
    {
        kN.a(jsonobject);
        return this;
    }

    public kN setMetadata(MediaMetadata mediametadata)
    {
        kN.a(mediametadata);
        return this;
    }

    public kN setStreamDuration(long l)
        throws IllegalArgumentException
    {
        kN.f(l);
        return this;
    }

    public kN setStreamType(int i)
        throws IllegalArgumentException
    {
        kN.setStreamType(i);
        return this;
    }

    public (String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Content ID cannot be empty");
        } else
        {
            kN = new MediaInfo(s);
            return;
        }
    }
}
