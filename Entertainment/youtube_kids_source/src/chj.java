// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class chj
{

    private final String a;

    public chj(chi chi1, String s)
    {
        a = s;
    }

    public final Map a()
    {
        JSONArray jsonarray;
        JSONObject jsonobject = new JSONObject(a);
        if (!jsonobject.has("screens"))
        {
            return Collections.emptyMap();
        }
        jsonarray = jsonobject.getJSONArray("screens");
        if (jsonarray != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        return Collections.emptyMap();
        HashMap hashmap = new HashMap();
        int i = 0;
_L1:
        int j = jsonarray.length();
        Object obj;
        obj = hashmap;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        Boolean boolean1;
        JSONObject jsonobject1;
        String s;
        jsonobject1 = jsonarray.getJSONObject(i);
        s = jsonobject1.optString("status");
        boolean1 = Boolean.valueOf(false);
        obj = boolean1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        obj = boolean1;
        if ("online".equals(s))
        {
            obj = Boolean.valueOf(true);
        }
        if (jsonobject1.has("loungeToken"))
        {
            hashmap.put(new cgj(jsonobject1.getString("loungeToken")), obj);
        }
_L2:
        i++;
          goto _L1
        obj;
        Log.w(chi.a(), (new StringBuilder(32)).append("Error parsing screen ").append(i).toString());
          goto _L2
        obj;
        Log.e(chi.a(), "Error parsing screen status ", ((Throwable) (obj)));
        obj = Collections.emptyMap();
        return ((Map) (obj));
    }
}
