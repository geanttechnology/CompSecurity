// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.wishabi.flipp.content.b;
import com.wishabi.flipp.util.q;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.wishabi.flipp.b:
//            ak

public class z extends AsyncTask
{

    public static final String b = com/wishabi/flipp/b/z.getSimpleName();
    private final int a[];
    private final String c;

    public z(int ai[], String s)
    {
        a = ai;
        c = s;
    }

    private transient HashMap a()
    {
        if (!TextUtils.isEmpty(c)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        obj = Uri.parse("https://backflipp.wishabi.com/flipp/coupons").buildUpon();
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("ids", q.a(a, ","));
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("postal_code", c);
        obj = ((android.net.Uri.Builder) (obj)).build();
        if (obj == null) goto _L1; else goto _L3
_L3:
        obj = ak.a(((Uri) (obj)));
        if (obj == null) goto _L1; else goto _L4
_L4:
        HashMap hashmap = new HashMap();
        JSONArray jsonarray = ((JSONObject) (obj)).getJSONArray("coupons");
        int i = 0;
        int j = jsonarray.length();
_L6:
        obj = hashmap;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new b(jsonarray.getJSONObject(i));
        hashmap.put(Integer.valueOf(((b) (obj)).a), obj);
        i++;
        if (true) goto _L6; else goto _L5
        obj;
        (new StringBuilder("Error processing coupon details JSON: ")).append(((JSONException) (obj)).toString());
        obj = null;
_L5:
        return ((HashMap) (obj));
    }

    protected Object doInBackground(Object aobj[])
    {
        return a();
    }

}
