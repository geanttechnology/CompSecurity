// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            cd

final class av
{

    final JSONObject a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final PackageManager f;

    protected av()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        a = null;
        f = null;
    }

    public av(Context context)
    {
        b = context.getPackageName();
        f = context.getPackageManager();
        context = context.getApplicationInfo();
        c = (String)f.getApplicationLabel(context);
        String s;
        try
        {
            context = f.getPackageInfo(b, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = null;
        }
        if (context != null)
        {
            s = ((PackageInfo) (context)).versionName;
        } else
        {
            s = "";
        }
        e = s;
        if (context != null)
        {
            context = Integer.toString(((PackageInfo) (context)).versionCode);
        } else
        {
            context = "";
        }
        d = context;
        a = new JSONObject();
        cd.b(a, "lbl", c);
        cd.b(a, "pn", b);
        cd.b(a, "v", d);
        cd.b(a, "vn", e);
    }
}
