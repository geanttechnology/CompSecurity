// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            eb, ce, gm, he, 
//            hf, dv, aq, dy

public final class ea extends eb
    implements ce
{

    DisplayMetrics a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    private final he h;
    private final Context i;
    private final WindowManager j;
    private final aq k;
    private float l;
    private int m;

    public ea(he he1, Context context, aq aq1)
    {
        super(he1);
        b = -1;
        c = -1;
        d = -1;
        e = -1;
        f = -1;
        g = -1;
        h = he1;
        i = context;
        k = aq1;
        j = (WindowManager)context.getSystemService("window");
    }

    public final void a(int i1, int j1)
    {
        Object obj;
        int k1;
        int l1;
        int i2;
        if (i instanceof Activity)
        {
            p.e();
            k1 = gm.c((Activity)i)[0];
        } else
        {
            k1 = 0;
        }
        l1 = f;
        i2 = g;
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("x", i1).put("y", j1 - k1).put("width", l1).put("height", i2);
            super.t.a("onDefaultPositionReceived", jsonobject);
        }
        catch (JSONException jsonexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Error occured while dispatching default position.", jsonexception);
        }
        obj = h.i();
        if (((hf) (obj)).j != null)
        {
            obj = ((hf) (obj)).j;
            obj.d = i1;
            obj.e = j1;
        }
    }

    public final void a(he he1, Map map)
    {
        a = new DisplayMetrics();
        he1 = j.getDefaultDisplay();
        he1.getMetrics(a);
        l = a.density;
        m = he1.getRotation();
        com.google.android.gms.ads.internal.client.m.a();
        b = com.google.android.gms.ads.internal.util.client.a.b(a, a.widthPixels);
        com.google.android.gms.ads.internal.client.m.a();
        c = com.google.android.gms.ads.internal.util.client.a.b(a, a.heightPixels);
        he1 = h.c();
        Intent intent;
        int i1;
        if (he1 == null || he1.getWindow() == null)
        {
            d = b;
            e = c;
        } else
        {
            p.e();
            he1 = com.google.android.gms.d.gm.a(he1);
            com.google.android.gms.ads.internal.client.m.a();
            d = com.google.android.gms.ads.internal.util.client.a.b(a, he1[0]);
            com.google.android.gms.ads.internal.client.m.a();
            e = com.google.android.gms.ads.internal.util.client.a.b(a, he1[1]);
        }
        if (h.h().e)
        {
            f = b;
            g = c;
        } else
        {
            h.measure(0, 0);
            com.google.android.gms.ads.internal.client.m.a();
            f = com.google.android.gms.ads.internal.util.client.a.b(i, h.getMeasuredWidth());
            com.google.android.gms.ads.internal.client.m.a();
            g = com.google.android.gms.ads.internal.util.client.a.b(i, h.getMeasuredHeight());
        }
        a(b, c, d, e, l, m);
        he1 = new dy.a();
        map = k;
        intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        he1.b = map.a(intent);
        map = k;
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        he1.a = map.a(intent);
        he1.c = k.b();
        he1.d = k.a();
        he1.e = true;
        he1 = new dy(he1, (byte)0);
        h.a("onDeviceFeaturesReceived", he1.a());
        he1 = new int[2];
        h.getLocationOnScreen(he1);
        com.google.android.gms.ads.internal.client.m.a();
        i1 = com.google.android.gms.ads.internal.util.client.a.b(i, he1[0]);
        com.google.android.gms.ads.internal.client.m.a();
        a(i1, com.google.android.gms.ads.internal.util.client.a.b(i, he1[1]));
        if (com.google.android.gms.ads.internal.util.client.b.a(2))
        {
            com.google.android.gms.ads.internal.util.client.b.a(4);
        }
        he1 = h.l().b;
        try
        {
            he1 = (new JSONObject()).put("js", he1);
            super.t.a("onReadyEventReceived", he1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (he he1)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Error occured while dispatching ready Event.", he1);
        }
    }
}
