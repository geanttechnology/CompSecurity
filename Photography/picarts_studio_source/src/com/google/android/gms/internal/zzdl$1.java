// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzdl, zzid, zziz

class zzxB
    implements Runnable
{

    final Map zzwP;
    final zziz zzxB;
    final zzdl zzxC;

    public void run()
    {
        zzb.zzaF("Received Http request.");
        Object obj = (String)zzwP.get("http_request");
        obj = zzxC.zzX(((String) (obj)));
        if (obj == null)
        {
            zzb.e("Response should not be null.");
            return;
        } else
        {
            zzid.zzIE.post(new Runnable(((JSONObject) (obj))) {

                final JSONObject zzxD;
                final zzdl._cls1 zzxE;

                public void run()
                {
                    zzxE.zzxB.zzb("fetchHttpRequestCompleted", zzxD);
                    zzb.zzaF("Dispatched http response.");
                }

            
            {
                zzxE = zzdl._cls1.this;
                zzxD = jsonobject;
                super();
            }
            });
            return;
        }
    }

    _cls1.zzxD(zzdl zzdl1, Map map, zziz zziz)
    {
        zzxC = zzdl1;
        zzwP = map;
        zzxB = zziz;
        super();
    }
}
