// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzrb

public static class <init>
{

    private final List zzbaA;
    private final List zzbar;
    private final List zzbas;
    private final List zzbat;
    private final List zzbau;
    private final List zzbav;
    private final List zzbaw;
    private final List zzbax;
    private final List zzbay;
    private final List zzbaz;

    public <init> zzEr()
    {
        return new <init>(zzbar, zzbas, zzbat, zzbau, zzbav, zzbaw, zzbax, zzbay, zzbaz, zzbaA, null);
    }

    public zzbaA zzd(zzbaA zzbaa)
    {
        zzbar.add(zzbaa);
        return this;
    }

    public zzbar zze(zzbar zzbar1)
    {
        zzbas.add(zzbar1);
        return this;
    }

    public zzbas zzf(zzbas zzbas1)
    {
        zzbat.add(zzbas1);
        return this;
    }

    public zzbat zzfp(String s)
    {
        zzbaz.add(s);
        return this;
    }

    public zzbaz zzfq(String s)
    {
        zzbaA.add(s);
        return this;
    }

    public zzbaA zzfr(String s)
    {
        zzbax.add(s);
        return this;
    }

    public zzbax zzfs(String s)
    {
        zzbay.add(s);
        return this;
    }

    public zzbay zzg(zzbay zzbay1)
    {
        zzbau.add(zzbay1);
        return this;
    }

    public zzbau zzh(zzbau zzbau1)
    {
        zzbav.add(zzbau1);
        return this;
    }

    public zzbav zzi(zzbav zzbav1)
    {
        zzbaw.add(zzbav1);
        return this;
    }

    private ()
    {
        zzbar = new ArrayList();
        zzbas = new ArrayList();
        zzbat = new ArrayList();
        zzbau = new ArrayList();
        zzbav = new ArrayList();
        zzbaw = new ArrayList();
        zzbax = new ArrayList();
        zzbay = new ArrayList();
        zzbaz = new ArrayList();
        zzbaA = new ArrayList();
    }

    zzbaA(zzbaA zzbaa)
    {
        this();
    }
}
