// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.internal.zzmn;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzy, zzv, zzp, zzn, 
//            zzab, zzag, zzu, zzs, 
//            zzc

public class zzf extends zzy
{

    private long zzaLZ;
    private String zzaMa;

    zzf(zzv zzv)
    {
        super(zzv);
    }

    public volatile Context getContext()
    {
        return super.getContext();
    }

    public String zzgE()
    {
        zziE();
        return Build.MODEL;
    }

    protected void zzhR()
    {
        Object obj = Calendar.getInstance();
        Object obj1 = TimeUnit.MINUTES;
        int i = ((Calendar) (obj)).get(15);
        zzaLZ = ((TimeUnit) (obj1)).convert(((Calendar) (obj)).get(16) + i, TimeUnit.MILLISECONDS);
        obj = Locale.getDefault();
        obj1 = new StringBuilder();
        ((StringBuilder) (obj1)).append(((Locale) (obj)).getLanguage().toLowerCase(Locale.ENGLISH));
        ((StringBuilder) (obj1)).append("-");
        ((StringBuilder) (obj1)).append(((Locale) (obj)).getCountry().toLowerCase(Locale.ENGLISH));
        zzaMa = ((StringBuilder) (obj1)).toString();
    }

    public volatile void zzir()
    {
        super.zzir();
    }

    public volatile void zzis()
    {
        super.zzis();
    }

    public volatile zzmn zzit()
    {
        return super.zzit();
    }

    public volatile zzp zzyd()
    {
        return super.zzyd();
    }

    public String zzzA()
    {
        zziE();
        return zzaMa;
    }

    public volatile void zzzn()
    {
        super.zzzn();
    }

    public volatile zzn zzzo()
    {
        return super.zzzo();
    }

    public volatile zzab zzzp()
    {
        return super.zzzp();
    }

    public volatile zzag zzzq()
    {
        return super.zzzq();
    }

    public volatile zzu zzzr()
    {
        return super.zzzr();
    }

    public volatile zzs zzzs()
    {
        return super.zzzs();
    }

    public volatile zzc zzzt()
    {
        return super.zzzt();
    }

    public String zzzy()
    {
        zziE();
        return android.os.Build.VERSION.RELEASE;
    }

    public long zzzz()
    {
        zziE();
        return zzaLZ;
    }
}
