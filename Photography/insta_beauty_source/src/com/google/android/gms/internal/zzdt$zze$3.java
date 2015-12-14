// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzhl, zzbb

class zzxk
    implements zzxk
{

    final zza zzxk;

    public void zza(zzbb zzbb1)
    {
        class _cls1
            implements Runnable
        {

            final zzbb zzra;
            final zzdt.zze._cls3 zzxl;

            public void run()
            {
                zzdt.zze.zza(zzxl.zzxk).zzc(zzra);
                zzra.destroy();
            }

            _cls1(zzbb zzbb1)
            {
                zzxl = zzdt.zze._cls3.this;
                zzra = zzbb1;
                super();
            }
        }

        zzhl.runOnUiThread(new _cls1(zzbb1));
    }

    public void zzc(Object obj)
    {
        zza((zzbb)obj);
    }

    _cls1(_cls1 _pcls1)
    {
        zzxk = _pcls1;
        super();
    }
}
