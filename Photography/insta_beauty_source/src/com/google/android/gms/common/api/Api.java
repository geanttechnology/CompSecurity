// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            Scope

public final class Api
{

    private final String mName;
    private final ClientKey zzVu;
    private final zza zzWi;
    private final zzc zzWj = null;
    private final zzd zzWk = null;
    private final ArrayList zzWl;

    public transient Api(String s, zza zza, ClientKey clientkey, Scope ascope[])
    {
        zzu.zzb(zza, "Cannot construct an Api with a null ClientBuilder");
        zzu.zzb(clientkey, "Cannot construct an Api with a null ClientKey");
        mName = s;
        zzWi = zza;
        zzVu = clientkey;
        zzWl = new ArrayList(Arrays.asList(ascope));
    }

    public String getName()
    {
        return mName;
    }

    public zza zzmp()
    {
        boolean flag;
        if (zzWi != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzu.zza(flag, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return zzWi;
    }

    public zzc zzmq()
    {
        boolean flag;
        if (zzWj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzu.zza(flag, "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return zzWj;
    }

    public List zzmr()
    {
        return zzWl;
    }

    public ClientKey zzms()
    {
        boolean flag;
        if (zzVu != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzu.zza(flag, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return zzVu;
    }

    public boolean zzmt()
    {
        return zzWk != null;
    }
}
