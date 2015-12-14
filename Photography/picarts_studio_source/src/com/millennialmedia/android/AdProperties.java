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
//            Utils, MMSDK, BridgeMMDevice, MMLog

class AdProperties
{

    private static final String a = com/millennialmedia/android/AdProperties.getName();
    private WeakReference b;

    AdProperties(Context context)
    {
        b = new WeakReference(context);
    }

    private Context a()
    {
        return (Context)b.get();
    }

    private JSONObject b()
    {
        JSONObject jsonobject = new JSONObject();
        DisplayMetrics displaymetrics = a().getResources().getDisplayMetrics();
        jsonobject.put("height", String.valueOf((int)((float)displaymetrics.heightPixels / displaymetrics.density)));
        displaymetrics = a().getResources().getDisplayMetrics();
        jsonobject.put("width", String.valueOf((int)((float)displaymetrics.widthPixels / displaymetrics.density)));
        return jsonobject;
    }

    public JSONObject getAdProperties(View view)
    {
        JSONObject jsonobject;
        boolean flag;
        flag = true;
        jsonobject = new JSONObject();
        jsonobject.put("screen", b());
        jsonobject.put("ad", Utils.a(view));
        jsonobject.put("do", MMSDK.k(a()));
        view = new JSONObject();
        Context context = a();
        view.put("sms", Boolean.parseBoolean(MMSDK.i(context)));
        view.put("tel", Boolean.parseBoolean(MMSDK.j(context)));
        view.put("calendar", MMSDK.b());
        view.put("storePicture", false);
        view.put("inlineVideo", true);
        jsonobject.put("supports", view);
        jsonobject.put("device", BridgeMMDevice.a(a()));
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
        MMLog.a(a, "Error when building ad properties", view);
        return jsonobject;
    }

}
