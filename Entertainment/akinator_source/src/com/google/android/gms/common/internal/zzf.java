// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzqx;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzf
{

    private final Account zzQd;
    private final String zzRq;
    private final Set zzaaF;
    private final int zzaaG;
    private final View zzaaH;
    private final String zzaaI;
    private final zzqx zzaaT;
    private final Set zzafh;
    private final Map zzafi;
    private Integer zzafj;

    public zzf(Account account, Set set, Map map, int i, View view, String s, String s1, 
            zzqx zzqx)
    {
        zzQd = account;
        if (set == null)
        {
            account = Collections.EMPTY_SET;
        } else
        {
            account = Collections.unmodifiableSet(set);
        }
        zzaaF = account;
        account = map;
        if (map == null)
        {
            account = Collections.EMPTY_MAP;
        }
        zzafi = account;
        zzaaH = view;
        zzaaG = i;
        zzRq = s;
        zzaaI = s1;
        zzaaT = zzqx;
        account = new HashSet(zzaaF);
    /* block-local class not found */
    class zza {}

        for (set = zzafi.values().iterator(); set.hasNext(); account.addAll(((zza)set.next()).zzTm)) { }
        zzafh = Collections.unmodifiableSet(account);
    }

    public static zzf zzak(Context context)
    {
        return (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).zznB();
    }

    public Account getAccount()
    {
        return zzQd;
    }

    public String getAccountName()
    {
        if (zzQd != null)
        {
            return zzQd.name;
        } else
        {
            return null;
        }
    }

    public void zza(Integer integer)
    {
        zzafj = integer;
    }

    public Set zzb(Api api)
    {
        api = (zza)zzafi.get(api);
        if (api == null || ((zza) (api)).zzTm.isEmpty())
        {
            return zzaaF;
        } else
        {
            HashSet hashset = new HashSet(zzaaF);
            hashset.addAll(((zza) (api)).zzTm);
            return hashset;
        }
    }

    public Account zzoI()
    {
        if (zzQd != null)
        {
            return zzQd;
        } else
        {
            return new Account("<<default account>>", "com.google");
        }
    }

    public int zzoJ()
    {
        return zzaaG;
    }

    public Set zzoK()
    {
        return zzaaF;
    }

    public Set zzoL()
    {
        return zzafh;
    }

    public Map zzoM()
    {
        return zzafi;
    }

    public String zzoN()
    {
        return zzRq;
    }

    public String zzoO()
    {
        return zzaaI;
    }

    public View zzoP()
    {
        return zzaaH;
    }

    public zzqx zzoQ()
    {
        return zzaaT;
    }

    public Integer zzoR()
    {
        return zzafj;
    }
}
