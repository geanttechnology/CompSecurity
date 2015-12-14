// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzid, zzbb

class zzyK
    implements zzyK
{

    final zza zzyK;

    public void zza(zzbb zzbb1)
    {
        zzid.runOnUiThread(new Runnable(zzbb1) {

            final zzbb zzrE;
            final zzdz.zze._cls3 zzyL;

            public void run()
            {
                zzdz.zze.zza(zzyL.zzyK).zzc(zzrE);
                zzrE.destroy();
            }

            
            {
                zzyL = zzdz.zze._cls3.this;
                zzrE = zzbb1;
                super();
            }
        });
    }

    public void zzc(Object obj)
    {
        zza((zzbb)obj);
    }

    _cls1.zzrE(_cls1.zzrE zzre)
    {
        zzyK = zzre;
        super();
    }
}
