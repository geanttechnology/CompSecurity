// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzmp;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzp, zzbg, zzo, Container, 
//            TagManager, zzcd

class zzaCK
    implements com.google.android.gms.internal.za
{

    final String zzaCK;
    final zzp zzaCL;

    public void zza(zzmp zzmp1)
    {
        if (zzmp1.getStatus() != Status.zzQU)
        {
            zzbg.zzak((new StringBuilder()).append("Load request failed for the container ").append(zzp.zza(zzaCL)).toString());
            zzaCL.setResult(zzaCL.zzaO(Status.zzQW));
            return;
        }
        com.google.android.gms.internal.zc zc = zzmp1.zzym().zzyq();
        if (zc == null)
        {
            zzbg.zzak("Response doesn't have the requested container");
            zzaCL.setResult(zzaCL.zzaO(new Status(8, "Response doesn't have the requested container", null)));
            return;
        } else
        {
            long l = zzmp1.zzym().zzyr();
            zzp.zza(zzaCL, new zzo(zzp.zzb(zzaCL), zzp.zzc(zzaCL), new Container(zzp.zzd(zzaCL), zzp.zzb(zzaCL).getDataLayer(), zzp.zza(zzaCL), l, zc), new zzo.zza() {

                final zzp._cls1 zzaCM;

                public void zzdB(String s)
                {
                    zzaCM.zzaCL.zzdB(s);
                }

                public String zzwu()
                {
                    return zzaCM.zzaCL.zzwu();
                }

                public void zzww()
                {
                    if (zzp.zze(zzaCM.zzaCL).zziU())
                    {
                        zzaCM.zzaCL.load(zzaCM.zzaCK);
                    }
                }

            
            {
                zzaCM = zzp._cls1.this;
                super();
            }
            }));
            zzaCL.setResult(zzp.zzf(zzaCL));
            return;
        }
    }

    _cls1.zzaCM(zzp zzp1, String s)
    {
        zzaCL = zzp1;
        zzaCK = s;
        super();
    }
}
