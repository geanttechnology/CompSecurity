// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class zzXv
    implements zzo
{

    final p zzXv;

    public void zza(long l, int i, Object obj)
    {
        if (obj instanceof JSONObject)
        {
            obj = (JSONObject)obj;
        } else
        {
            obj = null;
        }
        zzXv.b(new nit>(new Status(i), ((JSONObject) (obj))));
    }

    public void zzy(long l)
    {
        zzXv.b(zzXv.p(new Status(2103)));
    }

    _cls9(_cls9 _pcls9)
    {
        zzXv = _pcls9;
        super();
    }
}
