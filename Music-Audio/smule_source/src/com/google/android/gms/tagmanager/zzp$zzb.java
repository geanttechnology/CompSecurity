// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbf, zzp

class <init>
    implements zzbf
{

    final zzp zzaCL;

    public void zza(com.google.android.gms.internal. )
    {
        com.google.android.gms.internal. 1;
        if (.zzaGM != null)
        {
            1 = .zzaGM;
        } else
        {
            com.google.android.gms.internal. 2 = .zzhh;
            1 = new com.google.android.gms.internal.<init>();
            1.zzhh = 2;
            1.zzhg = null;
            1.zzhi = 2.version;
        }
        zzp.zza(zzaCL, 1, .zzaGL, true);
    }

    public void zza( )
    {
        if (!zzp.zzh(zzaCL))
        {
            zzp.zza(zzaCL, 0L);
        }
    }

    public void zzv(Object obj)
    {
        zza((com.google.android.gms.internal.)obj);
    }

    public void zzwB()
    {
    }

    private (zzp zzp1)
    {
        zzaCL = zzp1;
        super();
    }

    zzaCL(zzp zzp1, zzaCL zzacl)
    {
        this(zzp1);
    }
}
