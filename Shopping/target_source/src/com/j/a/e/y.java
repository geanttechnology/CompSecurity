// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import android.os.Handler;
import android.os.Looper;
import com.j.a.g.w;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            ar, az, z

class y
    implements ar
{

    final String a;
    final az b;

    y(az az1, String s)
    {
        b = az1;
        a = s;
        super();
    }

    public void a(Boolean boolean1)
    {
        if (!boolean1.booleanValue())
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (az.e(b) == null)
        {
            az.d(b, new JSONObject());
        }
        az.e(b).put("wasConnected", false);
        (new Handler(Looper.getMainLooper())).postDelayed(new z(this), 10L);
        return;
        boolean1;
        w.b("Sending pairing device socket", boolean1);
        return;
    }
}
