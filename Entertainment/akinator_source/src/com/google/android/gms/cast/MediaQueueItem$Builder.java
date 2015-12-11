// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaQueueItem, MediaInfo

public static class zzWs
{

    private final MediaQueueItem zzWs;

    public MediaQueueItem build()
    {
        zzWs.zzmx();
        return zzWs;
    }

    public zzWs clearItemId()
    {
        zzWs.zzaR(0);
        return this;
    }

    public zzWs setActiveTrackIds(long al[])
    {
        zzWs.zza(al);
        return this;
    }

    public zzWs setAutoplay(boolean flag)
    {
        zzWs.zzU(flag);
        return this;
    }

    public zzWs setCustomData(JSONObject jsonobject)
    {
        zzWs.setCustomData(jsonobject);
        return this;
    }

    public mData setPlaybackDuration(double d)
    {
        zzWs.zzd(d);
        return this;
    }

    public zzWs setPreloadTime(double d)
        throws IllegalArgumentException
    {
        zzWs.zze(d);
        return this;
    }

    public zzWs setStartTime(double d)
        throws IllegalArgumentException
    {
        zzWs.zzc(d);
        return this;
    }

    public (MediaInfo mediainfo)
        throws IllegalArgumentException
    {
        zzWs = new MediaQueueItem(mediainfo, null);
    }

    public zzWs(MediaQueueItem mediaqueueitem)
        throws IllegalArgumentException
    {
        zzWs = new MediaQueueItem(mediaqueueitem, null);
    }

    public zzWs(JSONObject jsonobject)
        throws JSONException
    {
        zzWs = new MediaQueueItem(jsonobject);
    }
}
