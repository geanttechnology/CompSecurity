// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zziz;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzh

class zzwO
    implements zzdk
{

    final zzh zzwO;

    public void zza(zziz zziz, Map map)
    {
        zziz = new JSONObject();
        try
        {
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); zziz.put(s, map.get(s)))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (zziz zziz)
        {
            zzb.zzb("Unable to dispatch sendMessageToNativeJs event", zziz);
            return;
        }
        zziz.put("id", zzh.zzc(zzwO));
        zzh.zzd(zzwO).zzb("sendMessageToNativeJs", zziz);
        return;
    }

    b(zzh zzh1)
    {
        zzwO = zzh1;
        super();
    }
}
