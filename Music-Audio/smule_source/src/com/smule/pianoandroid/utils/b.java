// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.smule.android.c.aa;
import com.smule.pianoandroid.ads.g;

// Referenced classes of package com.smule.pianoandroid.utils:
//            a, o

public class b
    implements AppEventListener
{

    private Activity a;
    private g b;

    public b(Activity activity)
    {
        a = activity;
    }

    public b(Activity activity, g g1)
    {
        this(activity);
        b = g1;
    }

    public void onAppEvent(String s, String s1)
    {
        aa.a(com.smule.pianoandroid.utils.a.d(), (new StringBuilder()).append("onAppEvent ").append(s).append(" ").append(s1).toString());
        if (s.equals("smule-url"))
        {
            if (b != null)
            {
                b.a(null);
            }
            s = Uri.parse(s1);
            o.a(a, s);
        }
    }
}
