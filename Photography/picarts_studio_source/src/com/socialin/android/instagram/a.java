// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import com.socialin.android.d;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.instagram:
//            b

public class a
{

    private static final String c = com/socialin/android/instagram/a.getSimpleName();
    String a;
    b b;

    public a(com.socialin.android.apiv3.model.UserConnection.Data data)
    {
        b = new b();
        a = data.token;
        b.a = data.id;
        b.b = data.screenName;
        b.c = data.name;
        b.f = data.profileImgUrl;
        b.d = "";
        b.e = "";
    }

    public a(JSONObject jsonobject)
    {
        b = new b();
        try
        {
            a = jsonobject.optString("access_token");
            b.a = jsonobject.optJSONObject("user").getString("id");
            jsonobject = jsonobject.optJSONObject("user");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            d.b(c, (new StringBuilder("Got unexpected exception: ")).append(jsonobject.getMessage()).toString(), jsonobject);
            return;
        }
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        b.b = jsonobject.getString("username");
        b.c = jsonobject.getString("full_name");
        b.d = jsonobject.getString("bio");
        b.f = jsonobject.getString("profile_picture");
        b.e = jsonobject.getString("website");
    }

    static String b()
    {
        return c;
    }

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("access_token", a);
            if (b != null)
            {
                jsonobject.put("user", b.a());
            }
        }
        catch (JSONException jsonexception)
        {
            d.b(c, "toJson", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

}
