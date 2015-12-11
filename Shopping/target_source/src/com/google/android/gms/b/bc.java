// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import org.json.JSONException;
import org.json.JSONObject;

public class bc
{

    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    private bc(a a1)
    {
    /* block-local class not found */
    class a {}

        a = a.a(a1);
        b = com.google.android.gms.b.a.b(a1);
        c = a.c(a1);
        d = a.d(a1);
        e = a.e(a1);
    }

    bc(a a1, _cls1 _pcls1)
    {
        this(a1);
    }

    public JSONObject a()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = (new JSONObject()).put("sms", a).put("tel", b).put("calendar", c).put("storePicture", d).put("inlineVideo", e);
        }
        catch (JSONException jsonexception)
        {
            com.google.android.gms.ads.internal.util.client.b.b("Error occured while obtaining the MRAID capabilities.", jsonexception);
            return null;
        }
        return jsonobject;
    }
}
