// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbw

class zzaFi
{

    private zzbw zzaFh;
    private com.google.android.gms.internal.b.zzaFi zzaFi;

    public int getSize()
    {
        int j = ((com.google.android.gms.internal.b)zzaFh.getObject()).zAb();
        int i;
        if (zzaFi == null)
        {
            i = 0;
        } else
        {
            i = zzaFi.zAb();
        }
        return i + j;
    }

    public zzbw zzxx()
    {
        return zzaFh;
    }

    public com.google.android.gms.internal.b zzxy()
    {
        return zzaFi;
    }

    public (zzbw zzbw1, com.google.android.gms.internal.b b)
    {
        zzaFh = zzbw1;
        zzaFi = b;
    }
}
