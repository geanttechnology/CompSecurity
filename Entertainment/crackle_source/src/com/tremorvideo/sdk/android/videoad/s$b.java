// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            s

public class e
{

    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public JSONObject f;
    final s g;

    public (s s1)
    {
        g = s1;
        super();
        a = "";
        b = "";
        c = "";
        d = "";
        e = "";
    }

    public e(s s1, JSONObject jsonobject)
        throws Exception
    {
        g = s1;
        super();
        f = jsonobject;
        if (jsonobject.has("city"))
        {
            a = jsonobject.getString("city");
        } else
        {
            a = "";
        }
        if (jsonobject.has("country"))
        {
            b = jsonobject.getString("country");
        } else
        {
            b = "";
        }
        if (jsonobject.has("state"))
        {
            c = jsonobject.getString("state");
        } else
        {
            c = "";
        }
        if (jsonobject.has("zip"))
        {
            d = jsonobject.getString("zip");
        } else
        {
            d = "";
        }
        if (jsonobject.has("dma"))
        {
            e = jsonobject.getString("dma");
            return;
        } else
        {
            e = "";
            return;
        }
    }
}
