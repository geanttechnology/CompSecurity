// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class zzVb
    implements hannelResult
{

    final Status zzVb;
    final zzVb zzXv;

    public JSONObject getCustomData()
    {
        return null;
    }

    public Status getStatus()
    {
        return zzVb;
    }

    hannelResult(hannelResult hannelresult, Status status)
    {
        zzXv = hannelresult;
        zzVb = status;
        super();
    }
}
