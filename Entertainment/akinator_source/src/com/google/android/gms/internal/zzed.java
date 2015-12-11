// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzej

public final class zzed
{

    public final String zzyM;
    public final String zzyN;
    public final List zzyO;
    public final String zzyP;
    public final String zzyQ;
    public final List zzyR;
    public final List zzyS;
    public final String zzyT;
    public final List zzyU;
    public final List zzyV;

    public zzed(JSONObject jsonobject)
        throws JSONException
    {
        Object obj1 = null;
        super();
        zzyN = jsonobject.getString("id");
        Object obj = jsonobject.getJSONArray("adapters");
        ArrayList arraylist = new ArrayList(((JSONArray) (obj)).length());
        for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
        {
            arraylist.add(((JSONArray) (obj)).getString(i));
        }

        zzyO = Collections.unmodifiableList(arraylist);
        zzyP = jsonobject.optString("allocation_id", null);
        zzyR = zzp.zzbH().zza(jsonobject, "clickurl");
        zzyS = zzp.zzbH().zza(jsonobject, "imp_urls");
        zzyU = zzp.zzbH().zza(jsonobject, "video_start_urls");
        zzyV = zzp.zzbH().zza(jsonobject, "video_complete_urls");
        obj = jsonobject.optJSONObject("ad");
        if (obj != null)
        {
            obj = ((JSONObject) (obj)).toString();
        } else
        {
            obj = null;
        }
        zzyM = ((String) (obj));
        obj = jsonobject.optJSONObject("data");
        if (obj != null)
        {
            jsonobject = ((JSONObject) (obj)).toString();
        } else
        {
            jsonobject = null;
        }
        zzyT = jsonobject;
        jsonobject = obj1;
        if (obj != null)
        {
            jsonobject = ((JSONObject) (obj)).optString("class_name");
        }
        zzyQ = jsonobject;
    }
}
