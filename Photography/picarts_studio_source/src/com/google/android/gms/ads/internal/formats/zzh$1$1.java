// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzh

class zzwP
    implements com.google.android.gms.internal.
{

    final Map zzwP;
    final zzb zzwQ;

    public void zza(zziz zziz, boolean flag)
    {
        zzh.zza(zzwQ.wO, (String)zzwP.get("id"));
        zziz = new JSONObject();
        try
        {
            zziz.put("messageType", "htmlLoaded");
            zziz.put("id", zzh.zzc(zzwQ.wO));
            zzh.zzd(zzwQ.wO).zzb("sendMessageToNativeJs", zziz);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zziz zziz)
        {
            zzb.zzb("Unable to dispatch sendMessageToNativeJsevent", zziz);
        }
    }

    wO(wO wo, Map map)
    {
        zzwQ = wo;
        zzwP = map;
        super();
    }

    // Unreferenced inner class com/google/android/gms/ads/internal/formats/zzh$1

/* anonymous class */
    class zzh._cls1
        implements zzdk
    {

        final zzh zzwO;

        public void zza(zziz zziz1, Map map)
        {
            zzh.zze(zzwO).zzhe().zza(new zzh._cls1._cls1(this, map));
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

            
            {
                zzwO = zzh1;
                super();
            }
    }

}
