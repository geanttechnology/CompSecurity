// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaQueueItem, MediaInfo

public static class zzUB
{

    private final MediaQueueItem zzUB;

    public MediaQueueItem build()
    {
        zzUB.zzma();
        return zzUB;
    }

    public zzUB clearItemId()
    {
        zzUB.zzaK(0);
        return this;
    }

    public zzUB setActiveTrackIds(long al[])
    {
        zzUB.zza(al);
        return this;
    }

    public zzUB setAutoplay(boolean flag)
    {
        zzUB.zzT(flag);
        return this;
    }

    public zzUB setCustomData(JSONObject jsonobject)
    {
        zzUB.setCustomData(jsonobject);
        return this;
    }

    public mData setPreloadTime(double d)
        throws IllegalArgumentException
    {
        zzUB.zzd(d);
        return this;
    }

    public zzUB setStartTime(double d)
        throws IllegalArgumentException
    {
        zzUB.zzc(d);
        return this;
    }

    public (MediaInfo mediainfo)
        throws IllegalArgumentException
    {
        zzUB = new MediaQueueItem(mediainfo, null);
    }

    public zzUB(MediaQueueItem mediaqueueitem)
        throws IllegalArgumentException
    {
        zzUB = new MediaQueueItem(mediaqueueitem, null);
    }

    public zzUB(JSONObject jsonobject)
        throws JSONException
    {
        zzUB = new MediaQueueItem(jsonobject);
    }
}
