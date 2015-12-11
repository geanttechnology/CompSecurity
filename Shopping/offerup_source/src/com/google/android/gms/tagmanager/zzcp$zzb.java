// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbw

class zzaYM
{

    private zzbw zzaYL;
    private com.google.android.gms.internal.b.zzaYM zzaYM;

    public int getSize()
    {
        int j = ((com.google.android.gms.internal.b)zzaYL.getObject()).zzFQ();
        int i;
        if (zzaYM == null)
        {
            i = 0;
        } else
        {
            i = zzaYM.zzFQ();
        }
        return i + j;
    }

    public zzbw zzDy()
    {
        return zzaYL;
    }

    public com.google.android.gms.internal.b zzDz()
    {
        return zzaYM;
    }

    public (zzbw zzbw1, com.google.android.gms.internal.b b)
    {
        zzaYL = zzbw1;
        zzaYM = b;
    }
}
