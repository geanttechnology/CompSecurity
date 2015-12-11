// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            bd

public final class ax
{

    public final String adJson;
    public final String mm;
    public final List mn;
    public final String mo;
    public final List mp;
    public final String mq;

    public ax(JSONObject jsonobject)
        throws JSONException
    {
        mm = jsonobject.getString("id");
        Object obj = jsonobject.getJSONArray("adapters");
        ArrayList arraylist = new ArrayList(((JSONArray) (obj)).length());
        for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
        {
            arraylist.add(((JSONArray) (obj)).getString(i));
        }

        mn = Collections.unmodifiableList(arraylist);
        mo = jsonobject.optString("allocation_id", null);
        mp = bd.a(jsonobject, "imp_urls");
        obj = jsonobject.optJSONObject("ad");
        if (obj != null)
        {
            if (!(obj instanceof JSONObject))
            {
                obj = ((JSONObject) (obj)).toString();
            } else
            {
                obj = JSONObjectInstrumentation.toString((JSONObject)obj);
            }
        } else
        {
            obj = null;
        }
        adJson = ((String) (obj));
        jsonobject = jsonobject.optJSONObject("data");
        if (jsonobject != null)
        {
            if (!(jsonobject instanceof JSONObject))
            {
                jsonobject = jsonobject.toString();
            } else
            {
                jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
            }
        } else
        {
            jsonobject = null;
        }
        mq = jsonobject;
    }
}
