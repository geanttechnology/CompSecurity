// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.b;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            hi

public class ec
{

    private final hi a;
    private final String b;

    public ec(hi hi1)
    {
        this(hi1, "");
    }

    public ec(hi hi1, String s)
    {
        a = hi1;
        b = s;
    }

    public final void a(int i, int j, int k, int l)
    {
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("x", i).put("y", j).put("width", k).put("height", l);
            a.a("onSizeChanged", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Error occured while dispatching size change.", jsonexception);
        }
    }

    public final void a(int i, int j, int k, int l, float f, int i1)
    {
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("width", i).put("height", j).put("maxSizeWidth", k).put("maxSizeHeight", l).put("density", f).put("rotation", i1);
            a.a("onScreenInfoChanged", jsonobject);
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
            s = (new JSONObject()).put("message", s).put("action", b);
            a.a("onError", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Error occurred while dispatching error event.", s);
        }
    }

    public final void b(int i, int j, int k, int l)
    {
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("x", i).put("y", j).put("width", k).put("height", l);
            a.a("onDefaultPositionReceived", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Error occured while dispatching default position.", jsonexception);
        }
    }

    public final void b(String s)
    {
        try
        {
            s = (new JSONObject()).put("js", s);
            a.a("onReadyEventReceived", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Error occured while dispatching ready Event.", s);
        }
    }

    public final void c(String s)
    {
        try
        {
            s = (new JSONObject()).put("state", s);
            a.a("onStateChanged", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Error occured while dispatching state change.", s);
        }
    }
}
