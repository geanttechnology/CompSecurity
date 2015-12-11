// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a;

import android.content.Context;
import android.util.Log;
import com.j.a.a.b;
import com.j.a.a.d;
import com.j.a.d.aa;
import com.j.a.d.e;
import com.j.a.e.az;
import org.json.JSONObject;

// Referenced classes of package com.j.a:
//            f, b

public class a
{

    public static void a(Context context, String s)
    {
        e.e().a(context, s, null);
    }

    public static void a(f f)
    {
        e.e().a(f);
    }

    public static void a(String s)
    {
        az.a().a(s);
    }

    public static void a(String s, com.j.a.b b1)
    {
        e.e().a(s, false, b1);
        aa.a().a(s, b1);
    }

    public static void a(JSONObject jsonobject)
    {
        if (e.e().n() != null)
        {
            e.e().n().a().a(jsonobject);
            return;
        } else
        {
            Log.w("Taplytics", "Taplytics not yet instantiated. Call Taplytics.startTaplytics before any other Taplytics call.");
            return;
        }
    }
}
