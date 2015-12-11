// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.support.v7.mq;
import android.support.v7.ox;
import android.support.v7.ul;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzh

class zzwk
    implements ox
{

    final zzh zzwk;

    public void zza(ul ul, Map map)
    {
        ul = new JSONObject();
        try
        {
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ul.put(s, map.get(s)))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (ul ul)
        {
            zzb.zzb("Unable to dispatch sendMessageToNativeJs event", ul);
            return;
        }
        ul.put("id", zzh.zzc(zzwk));
        zzh.zzd(zzwk).b("sendMessageToNativeJs", ul);
        return;
    }

    b(zzh zzh1)
    {
        zzwk = zzh1;
        super();
    }
}
