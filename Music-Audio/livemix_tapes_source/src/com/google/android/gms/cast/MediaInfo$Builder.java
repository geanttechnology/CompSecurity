// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaInfo, MediaMetadata, TextTrackStyle

public static class zzUm
{

    private final MediaInfo zzUm;

    public MediaInfo build()
        throws IllegalArgumentException
    {
        zzUm.zzma();
        return zzUm;
    }

    public zzUm setContentType(String s)
        throws IllegalArgumentException
    {
        zzUm.setContentType(s);
        return this;
    }

    public ntType setCustomData(JSONObject jsonobject)
    {
        zzUm.setCustomData(jsonobject);
        return this;
    }

    public mData setMediaTracks(List list)
    {
        zzUm.zzj(list);
        return this;
    }

    public zzUm setMetadata(MediaMetadata mediametadata)
    {
        zzUm.zza(mediametadata);
        return this;
    }

    public zzUm setStreamDuration(long l)
        throws IllegalArgumentException
    {
        zzUm.zzx(l);
        return this;
    }

    public zzUm setStreamType(int i)
        throws IllegalArgumentException
    {
        zzUm.setStreamType(i);
        return this;
    }

    public mType setTextTrackStyle(TextTrackStyle texttrackstyle)
    {
        zzUm.setTextTrackStyle(texttrackstyle);
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
            zzUm = new MediaInfo(s);
            return;
        }
    }
}
