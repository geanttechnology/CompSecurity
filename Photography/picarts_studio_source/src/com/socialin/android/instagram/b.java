// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import com.socialin.android.d;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.instagram:
//            a

public final class b
{

    String a;
    String b;
    String c;
    String d;
    String e;
    String f;

    public b()
    {
    }

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", a);
            jsonobject.put("username", b);
            jsonobject.put("full_name", c);
            jsonobject.put("bio", d);
            jsonobject.put("website", e);
            jsonobject.put("profile_picture", f);
        }
        catch (JSONException jsonexception)
        {
            com.socialin.android.d.b(com.socialin.android.instagram.a.b(), (new StringBuilder("Got unexpected exception: ")).append(jsonexception.getMessage()).toString(), jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }
}
