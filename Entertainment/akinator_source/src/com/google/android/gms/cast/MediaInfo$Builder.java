// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaInfo, MediaMetadata, TextTrackStyle

public static class zzWd
{

    private final MediaInfo zzWd;

    public MediaInfo build()
        throws IllegalArgumentException
    {
        zzWd.zzmx();
        return zzWd;
    }

    public zzWd setContentType(String s)
        throws IllegalArgumentException
    {
        zzWd.setContentType(s);
        return this;
    }

    public ntType setCustomData(JSONObject jsonobject)
    {
        zzWd.setCustomData(jsonobject);
        return this;
    }

    public mData setMediaTracks(List list)
    {
        zzWd.zzq(list);
        return this;
    }

    public zzWd setMetadata(MediaMetadata mediametadata)
    {
        zzWd.zza(mediametadata);
        return this;
    }

    public zzWd setStreamDuration(long l)
        throws IllegalArgumentException
    {
        zzWd.zzx(l);
        return this;
    }

    public zzWd setStreamType(int i)
        throws IllegalArgumentException
    {
        zzWd.setStreamType(i);
        return this;
    }

    public mType setTextTrackStyle(TextTrackStyle texttrackstyle)
    {
        zzWd.setTextTrackStyle(texttrackstyle);
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
            zzWd = new MediaInfo(s);
            return;
        }
    }
}
