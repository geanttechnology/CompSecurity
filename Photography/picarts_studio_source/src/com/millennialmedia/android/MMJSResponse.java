// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            Base64, MMLog

class MMJSResponse
{

    String a;
    String b;
    int c;
    Object d;
    byte e[];

    MMJSResponse()
    {
    }

    static MMJSResponse a()
    {
        return a("Success.");
    }

    static MMJSResponse a(String s)
    {
        MMJSResponse mmjsresponse = new MMJSResponse();
        mmjsresponse.c = 1;
        mmjsresponse.d = s;
        return mmjsresponse;
    }

    static MMJSResponse b()
    {
        return b("An unknown error occured.");
    }

    static MMJSResponse b(String s)
    {
        MMJSResponse mmjsresponse = new MMJSResponse();
        mmjsresponse.c = 0;
        mmjsresponse.d = s;
        return mmjsresponse;
    }

    final String c()
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
            jsonobject.put("response", Base64.encodeToString(e, false));
        }
        catch (JSONException jsonexception)
        {
            MMLog.e("MMJSResponse", jsonexception.getMessage());
            return "";
        }
        if (true) goto _L4; else goto _L3
_L3:
        return "";
    }
}
