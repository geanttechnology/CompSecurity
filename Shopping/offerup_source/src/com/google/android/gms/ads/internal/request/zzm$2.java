// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzdz;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzm

class zzFr
    implements Runnable
{

    final zzm zzFp;
    final JSONObject zzFq;
    final String zzFr;

    public void run()
    {
        zzm.zza(zzFp, zzm.zzfO().zzdO());
        class _cls1
            implements com.google.android.gms.internal.zzis.zzc
        {

            final zzm._cls2 zzFs;

            public void zzb(zzbe zzbe1)
            {
                try
                {
                    zzbe1.zza("AFMA_getAdapterLessMediationAd", zzFs.zzFq);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (zzbe zzbe1)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", zzbe1);
                }
                zzm.zzfN().zzZ(zzFs.zzFr);
            }

            public void zzc(Object obj)
            {
                zzb((zzbe)obj);
            }

            _cls1()
            {
                zzFs = zzm._cls2.this;
                super();
            }
        }

        class _cls2
            implements com.google.android.gms.internal.zzis.zza
        {

            final zzm._cls2 zzFs;

            public void run()
            {
                zzm.zzfN().zzZ(zzFs.zzFr);
            }

            _cls2()
            {
                zzFs = zzm._cls2.this;
                super();
            }
        }

        com.google.android.gms.ads.internal.request.zzm.zzb(zzFp).zza(new _cls1(), new _cls2());
    }

    _cls2(zzm zzm1, JSONObject jsonobject, String s)
    {
        zzFp = zzm1;
        zzFq = jsonobject;
        zzFr = s;
        super();
    }
}
