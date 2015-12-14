// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzdz;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzm

class zzFs
    implements com.google.android.gms.internal.
{

    final zzb zzFs;

    public void zzb(zzbe zzbe1)
    {
        try
        {
            zzbe1.zza("AFMA_getAdapterLessMediationAd", zzFs.Fq);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzbe zzbe1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", zzbe1);
        }
        zzm.zzfN().zzZ(zzFs.Fr);
    }

    public void zzc(Object obj)
    {
        zzb((zzbe)obj);
    }

    Fr(Fr fr)
    {
        zzFs = fr;
        super();
    }

    // Unreferenced inner class com/google/android/gms/ads/internal/request/zzm$2

/* anonymous class */
    class zzm._cls2
        implements Runnable
    {

        final zzm zzFp;
        final JSONObject zzFq;
        final String zzFr;

        public void run()
        {
            zzm.zza(zzFp, zzm.zzfO().zzdO());
            com.google.android.gms.ads.internal.request.zzm.zzb(zzFp).zza(new zzm._cls2._cls1(this), new zzm._cls2._cls2());
        }

            
            {
                zzFp = zzm1;
                zzFq = jsonobject;
                zzFr = s;
                super();
            }

        // Unreferenced inner class com/google/android/gms/ads/internal/request/zzm$2$2

/* anonymous class */
        class zzm._cls2._cls2
            implements com.google.android.gms.internal.zzis.zza
        {

            final zzm._cls2 zzFs;

            public void run()
            {
                zzm.zzfN().zzZ(zzFs.zzFr);
            }

                    
                    {
                        zzFs = zzm._cls2.this;
                        super();
                    }
        }

    }

}
