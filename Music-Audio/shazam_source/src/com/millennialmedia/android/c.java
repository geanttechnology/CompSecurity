// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            au, an, l, al

class c
{

    private static final String b = com/millennialmedia/android/c.getName();
    WeakReference a;

    c(Context context)
    {
        a = new WeakReference(context);
    }

    private Context a()
    {
        return (Context)a.get();
    }

    private JSONObject b()
    {
        JSONObject jsonobject = new JSONObject();
        DisplayMetrics displaymetrics = a().getResources().getDisplayMetrics();
        jsonobject.put("height", (int)((float)displaymetrics.heightPixels / displaymetrics.density));
        displaymetrics = a().getResources().getDisplayMetrics();
        jsonobject.put("width", (int)((float)displaymetrics.widthPixels / displaymetrics.density));
        return jsonobject;
    }

    public final JSONObject a(View view)
    {
        JSONObject jsonobject;
        boolean flag;
        flag = true;
        jsonobject = new JSONObject();
        jsonobject.put("screen", b());
        jsonobject.put("ad", au.a(view));
        jsonobject.put("do", an.l(a()));
        view = new JSONObject();
        Context context = a();
        view.put("sms", Boolean.parseBoolean(an.j(context)));
        view.put("tel", Boolean.parseBoolean(an.k(context)));
        view.put("calendar", an.b());
        view.put("storePicture", false);
        view.put("inlineVideo", true);
        jsonobject.put("supports", view);
        jsonobject.put("device", l.a(a()));
        view = new JSONObject();
        if (a().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
        {
            flag = false;
        }
        view.put("android.permission.ACCESS_FINE_LOCATION", flag);
        jsonobject.put("permissions", view);
        jsonobject.put("maxSize", b());
        return jsonobject;
        view;
        al.a(b, "Error when building ad properties", view);
        return jsonobject;
    }

}
