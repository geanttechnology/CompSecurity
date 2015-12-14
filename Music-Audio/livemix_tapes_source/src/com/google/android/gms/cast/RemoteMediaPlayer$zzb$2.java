// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class zzQs
    implements hannelResult
{

    final Status zzQs;
    final zzQs zzVD;

    public JSONObject getCustomData()
    {
        return null;
    }

    public Status getStatus()
    {
        return zzQs;
    }

    hannelResult(hannelResult hannelresult, Status status)
    {
        zzVD = hannelresult;
        zzQs = status;
        super();
    }
}
