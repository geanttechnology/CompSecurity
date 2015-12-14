// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook:
//            m

public final class l
{

    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public m f;

    public l(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return;
        }
        try
        {
            a = jsonobject.optString("id");
            e = (new StringBuilder("https://graph.facebook.com/v2.4/")).append(a).append("/picture?type=normal").toString();
            b = jsonobject.optString("email");
            c = jsonobject.optString("link");
            d = jsonobject.optString("name");
            f = new m(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
    }

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", a);
            jsonobject.put("email", b);
            jsonobject.put("link", c);
            jsonobject.put("name", d);
            if (f != null)
            {
                jsonobject.put("cover", f.a());
            }
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }
}
