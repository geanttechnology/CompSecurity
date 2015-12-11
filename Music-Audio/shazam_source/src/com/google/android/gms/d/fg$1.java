// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.w;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            ce, fg, ab, gx, 
//            he

final class c
    implements ce
{

    final ab a;
    final c b;
    final gx c;
    final fg d;

    public final void a(he he, Map map)
    {
        a.b("/nativeAdPreProcess", b.a);
        try
        {
            he = (String)map.get("success");
            if (!TextUtils.isEmpty(he))
            {
                c.b((new JSONObject(he)).getJSONArray("ads").getJSONObject(0));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (he he)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Malformed native JSON response.", he);
        }
        d.a(0);
        w.a(d.a(), "Unable to set the ad state error!");
        c.b(null);
    }

    internal.w(fg fg1, ab ab1, internal.w w1, gx gx1)
    {
        d = fg1;
        a = ab1;
        b = w1;
        c = gx1;
        super();
    }
}
