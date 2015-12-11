// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zziz;
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

    _cls9(_cls9 _pcls9, Map map)
    {
        zzwQ = _pcls9;
        zzwP = map;
        super();
    }
}
