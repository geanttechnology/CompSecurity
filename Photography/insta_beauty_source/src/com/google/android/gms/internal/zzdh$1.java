// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdh, zzhl, zzid

class zzwh
    implements Runnable
{

    final Map zzwg;
    final zzid zzwh;
    final zzdh zzwi;

    public void run()
    {
        zzb.zzay("Received Http request.");
        Object obj = (String)zzwg.get("http_request");
        obj = zzwi.zzT(((String) (obj)));
        if (obj == null)
        {
            zzb.zzaz("Response should not be null.");
            return;
        } else
        {
            class _cls1
                implements Runnable
            {

                final JSONObject zzwj;
                final zzdh._cls1 zzwk;

                public void run()
                {
                    zzwk.zzwh.zzb("fetchHttpRequestCompleted", zzwj);
                    zzb.zzay("Dispatched http response.");
                }

            _cls1(JSONObject jsonobject)
            {
                zzwk = zzdh._cls1.this;
                zzwj = jsonobject;
                super();
            }
            }

            zzhl.zzGk.post(new _cls1(((JSONObject) (obj))));
            return;
        }
    }

    _cls1(zzdh zzdh1, Map map, zzid zzid)
    {
        zzwi = zzdh1;
        zzwg = map;
        zzwh = zzid;
        super();
    }
}
