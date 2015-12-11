// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzbf, zzbe, zzdk

public class zzbg
    implements zzbf
{

    private final zzbe zzrL;
    private final HashSet zzrM = new HashSet();

    public zzbg(zzbe zzbe1)
    {
        zzrL = zzbe1;
    }

    public void zza(String s, zzdk zzdk1)
    {
        zzrL.zza(s, zzdk1);
        zzrM.add(new java.util.AbstractMap.SimpleEntry(s, zzdk1));
    }

    public void zza(String s, String s1)
    {
        zzrL.zza(s, s1);
    }

    public void zza(String s, JSONObject jsonobject)
    {
        zzrL.zza(s, jsonobject);
    }

    public void zzb(String s, zzdk zzdk1)
    {
        zzrL.zzb(s, zzdk1);
        zzrM.remove(new java.util.AbstractMap.SimpleEntry(s, zzdk1));
    }

    public void zzb(String s, JSONObject jsonobject)
    {
        zzrL.zzb(s, jsonobject);
    }

    public void zzck()
    {
        java.util.AbstractMap.SimpleEntry simpleentry;
        for (Iterator iterator = zzrM.iterator(); iterator.hasNext(); zzrL.zzb((String)simpleentry.getKey(), (zzdk)simpleentry.getValue()))
        {
            simpleentry = (java.util.AbstractMap.SimpleEntry)iterator.next();
            com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder("Unregistering eventhandler: ")).append(((zzdk)simpleentry.getValue()).toString()).toString());
        }

        zzrM.clear();
    }
}
