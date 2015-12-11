// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.util.client.b;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            he

public class eb
{

    private final String a;
    final he t;

    public eb(he he1)
    {
        this(he1, "");
    }

    public eb(he he1, String s)
    {
        t = he1;
        a = s;
    }

    public final void a(int i, int j, int k, int l, float f, int i1)
    {
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("width", i).put("height", j).put("maxSizeWidth", k).put("maxSizeHeight", l).put("density", f).put("rotation", i1);
            t.a("onScreenInfoChanged", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Error occured while obtaining screen information.", jsonexception);
        }
    }

    public final void a(String s)
    {
        try
        {
            s = (new JSONObject()).put("message", s).put("action", a);
            t.a("onError", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Error occurred while dispatching error event.", s);
        }
    }

    public final void b(String s)
    {
        try
        {
            s = (new JSONObject()).put("state", s);
            t.a("onStateChanged", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Error occured while dispatching state change.", s);
        }
    }
}
