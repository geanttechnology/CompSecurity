// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class zzVD
    implements zzo
{

    final s zzVD;

    public void zza(long l, int i, Object obj)
    {
        if (obj instanceof JSONObject)
        {
            obj = (JSONObject)obj;
        } else
        {
            obj = null;
        }
        zzVD.a(new nit>(new Status(i), ((JSONObject) (obj))));
    }

    public void zzy(long l)
    {
        zzVD.a(zzVD.s(new Status(2103)));
    }

    _cls9(_cls9 _pcls9)
    {
        zzVD = _pcls9;
        super();
    }
}
