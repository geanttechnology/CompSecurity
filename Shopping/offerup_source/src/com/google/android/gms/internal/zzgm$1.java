// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzbb, zzin, zzgm, 
//            zziz

class zzDM
    implements zzdk
{

    final zzbb zzDK;
    final b zzDL;
    final zzin zzDM;
    final zzgm zzDN;

    public void zza(zziz zziz, Map map)
    {
        zzDK.zzb("/nativeAdPreProcess", zzDL.zzDZ);
        try
        {
            zziz = (String)map.get("success");
            if (!TextUtils.isEmpty(zziz))
            {
                zzDM.zzf((new JSONObject(zziz)).getJSONArray("ads").getJSONObject(0));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (zziz zziz)
        {
            zzb.zzb("Malformed native JSON response.", zziz);
        }
        zzDN.zzC(0);
        zzx.zza(zzDN.zzfD(), "Unable to set the ad state error!");
        zzDM.zzf(null);
    }

    b(zzgm zzgm1, zzbb zzbb1, b b, zzin zzin1)
    {
        zzDN = zzgm1;
        zzDK = zzbb1;
        zzDL = b;
        zzDM = zzin1;
        super();
    }
}
