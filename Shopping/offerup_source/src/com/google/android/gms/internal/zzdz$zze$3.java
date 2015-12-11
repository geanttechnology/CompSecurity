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
        class _cls1
            implements Runnable
        {

            final zzbb zzrE;
            final zzdz.zze._cls3 zzyL;

            public void run()
            {
                zzdz.zze.zza(zzyL.zzyK).zzc(zzrE);
                zzrE.destroy();
            }

            _cls1(zzbb zzbb1)
            {
                zzyL = zzdz.zze._cls3.this;
                zzrE = zzbb1;
                super();
            }
        }

        zzid.runOnUiThread(new _cls1(zzbb1));
    }

    public void zzc(Object obj)
    {
        zza((zzbb)obj);
    }

    _cls1(_cls1 _pcls1)
    {
        zzyK = _pcls1;
        super();
    }
}
