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

final class chg
{

    private final String a;

    public chg(chf chf1, String s)
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
            break MISSING_BLOCK_LABEL_40;
        }
        return Collections.emptyMap();
        HashMap hashmap = new HashMap();
        int i = 0;
_L2:
        int j = jsonarray.length();
        Object obj;
        obj = hashmap;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        obj = jsonarray.getJSONObject(i);
        if (!((JSONObject) (obj)).has("screenId") || !((JSONObject) (obj)).has("loungeToken"))
        {
            break MISSING_BLOCK_LABEL_180;
        }
        try
        {
            hashmap.put(new cgr(((JSONObject) (obj)).getString("screenId")), new cgj(((JSONObject) (obj)).getString("loungeToken")));
            break MISSING_BLOCK_LABEL_180;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        try
        {
            Log.w(chf.a(), (new StringBuilder(32)).append("Error parsing screen ").append(i).toString());
            break MISSING_BLOCK_LABEL_180;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(chf.a(), "Error parsing screen status ", ((Throwable) (obj)));
            obj = Collections.emptyMap();
        }
        return ((Map) (obj));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
