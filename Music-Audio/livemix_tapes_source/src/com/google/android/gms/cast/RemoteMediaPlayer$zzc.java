// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

private static final class zzUl
    implements aChannelResult
{

    private final Status zzQA;
    private final JSONObject zzUl;

    public JSONObject getCustomData()
    {
        return zzUl;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    aChannelResult(Status status, JSONObject jsonobject)
    {
        zzQA = status;
        zzUl = jsonobject;
    }
}
