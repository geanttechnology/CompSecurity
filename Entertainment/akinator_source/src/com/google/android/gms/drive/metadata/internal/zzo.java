// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzo extends zza
{

    public zzo(String s, int i)
    {
        super(s, i);
    }

    protected void zza(Bundle bundle, Object obj)
    {
        zzb(bundle, (String)obj);
    }

    protected void zzb(Bundle bundle, String s)
    {
        bundle.putString(getName(), s);
    }

    protected Object zzc(DataHolder dataholder, int i, int j)
    {
        return zzi(dataholder, i, j);
    }

    protected String zzi(DataHolder dataholder, int i, int j)
    {
        return dataholder.zzd(getName(), i, j);
    }

    protected Object zzk(Bundle bundle)
    {
        return zzr(bundle);
    }

    protected String zzr(Bundle bundle)
    {
        return bundle.getString(getName());
    }
}
