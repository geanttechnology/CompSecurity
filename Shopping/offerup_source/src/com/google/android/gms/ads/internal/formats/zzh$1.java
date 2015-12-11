// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.text.TextUtils;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import java.util.Map;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzh

class zzwO
    implements zzdk
{

    final zzh zzwO;

    public void zza(zziz zziz1, Map map)
    {
        class _cls1
            implements com.google.android.gms.internal.zzja.zza
        {

            final Map zzwP;
            final zzh._cls1 zzwQ;

            public void zza(zziz zziz2, boolean flag)
            {
                zzh.zza(zzwQ.zzwO, (String)zzwP.get("id"));
                zziz2 = new JSONObject();
                try
                {
                    zziz2.put("messageType", "htmlLoaded");
                    zziz2.put("id", zzh.zzc(zzwQ.zzwO));
                    zzh.zzd(zzwQ.zzwO).zzb("sendMessageToNativeJs", zziz2);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (zziz zziz2)
                {
                    zzb.zzb("Unable to dispatch sendMessageToNativeJsevent", zziz2);
                }
            }

            _cls1(Map map)
            {
                zzwQ = zzh._cls1.this;
                zzwP = map;
                super();
            }
        }

        zzh.zze(zzwO).zzhe().zza(new _cls1(map));
        zziz1 = (String)map.get("overlayHtml");
        map = (String)map.get("baseUrl");
        if (TextUtils.isEmpty(map))
        {
            zzh.zze(zzwO).loadData(zziz1, "text/html", "UTF-8");
            return;
        } else
        {
            zzh.zze(zzwO).loadDataWithBaseURL(map, zziz1, "text/html", "UTF-8", null);
            return;
        }
    }

    _cls1(zzh zzh1)
    {
        zzwO = zzh1;
        super();
    }
}
