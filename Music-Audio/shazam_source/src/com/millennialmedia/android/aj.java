// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            h, al

final class aj
{

    String a;
    String b;
    int c;
    Object d;
    byte e[];

    aj()
    {
    }

    static aj a(String s)
    {
        aj aj1 = new aj();
        aj1.c = 1;
        aj1.d = s;
        return aj1;
    }

    static aj b(String s)
    {
        aj aj1 = new aj();
        aj1.c = 0;
        aj1.d = s;
        return aj1;
    }

    final String a()
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        if (a != null)
        {
            jsonobject.put("class", a);
        }
        if (b != null)
        {
            jsonobject.put("call", b);
        }
        jsonobject.put("result", c);
        if (d == null) goto _L2; else goto _L1
_L1:
        jsonobject.put("response", d);
_L4:
        return jsonobject.toString();
_L2:
        try
        {
            if (e == null)
            {
                break; /* Loop/switch isn't completed */
            }
            jsonobject.put("response", h.a(e));
        }
        catch (JSONException jsonexception)
        {
            al.a("MMJSResponse", jsonexception.getMessage());
            return "";
        }
        if (true) goto _L4; else goto _L3
_L3:
        return "";
    }
}
