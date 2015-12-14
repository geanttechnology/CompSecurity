// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.content.res.Resources;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            f

public class g
{

    private final int a;
    private String b;
    private f c;

    public g()
    {
        b = null;
        c = null;
        a = 0;
    }

    public g(int i)
    {
        b = null;
        c = null;
        a = i;
    }

    private void a()
    {
        if (c != null)
        {
            c.a();
            c = null;
        }
    }

    public void a(Activity activity, int i)
    {
        a();
        if (a > 0 && b == null)
        {
            b = activity.getResources().getString(a);
        }
        a(activity, b, i);
    }

    public void a(Activity activity, String s, int i)
    {
        a();
        c = f.a(activity, s, i);
        c.b();
    }
}
