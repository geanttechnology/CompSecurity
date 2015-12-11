// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;

import android.app.Activity;
import android.content.Context;
import com.crittercism.app.Crittercism;
import com.crittercism.app.CrittercismConfig;
import com.smule.android.c;
import com.smule.android.network.core.b;

// Referenced classes of package com.smule.android.c:
//            t, x

public class u extends t
{

    private boolean a;
    private int b;

    public u(Context context, int i)
    {
        a = true;
        b = i;
        boolean flag;
        if (Math.abs(com.smule.android.network.core.b.d().c().hashCode() % 100) < b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
        if (a())
        {
            CrittercismConfig crittercismconfig = new CrittercismConfig();
            crittercismconfig.b(true);
            crittercismconfig.a(true);
            Crittercism.a(context.getApplicationContext(), com.smule.android.network.core.b.d().a(c.a), crittercismconfig);
        }
    }

    private boolean a()
    {
        return a;
    }

    public void b(Activity activity)
    {
        if (a())
        {
            activity = a(activity);
            Crittercism.a((new StringBuilder()).append("Activity start: ").append(activity).toString());
        }
    }

    public void b(x x1)
    {
        if (a())
        {
            String s = a(x1);
            Crittercism.a((new StringBuilder()).append(x1.b).append(": ").append(s).toString());
        }
    }

    public void c(Activity activity)
    {
    }
}
