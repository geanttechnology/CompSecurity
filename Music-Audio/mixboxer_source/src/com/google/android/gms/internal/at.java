// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            az

public final class at
{

    public final String adJson;
    public final String fD;
    public final List fE;
    public final String fF;
    public final List fG;
    public final String fH;

    public at(JSONObject jsonobject)
        throws JSONException
    {
        Object obj1 = null;
        super();
        fD = jsonobject.getString("id");
        Object obj = jsonobject.getJSONArray("adapters");
        ArrayList arraylist = new ArrayList(((JSONArray) (obj)).length());
        for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
        {
            arraylist.add(((JSONArray) (obj)).getString(i));
        }

        fE = Collections.unmodifiableList(arraylist);
        fF = jsonobject.optString("allocation_id", null);
        fG = az.a(jsonobject, "imp_urls");
        obj = jsonobject.optJSONObject("ad");
        if (obj != null)
        {
            obj = ((JSONObject) (obj)).toString();
        } else
        {
            obj = null;
        }
        adJson = ((String) (obj));
        obj = jsonobject.optJSONObject("data");
        jsonobject = obj1;
        if (obj != null)
        {
            jsonobject = ((JSONObject) (obj)).toString();
        }
        fH = jsonobject;
    }
}
