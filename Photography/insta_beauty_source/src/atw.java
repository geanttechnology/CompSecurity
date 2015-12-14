// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.widget.Toast;
import com.flurry.android.FlurryAgent;

final class atw
    implements Runnable
{

    final Activity a;
    final String b;
    final String c;
    final String d;
    final String e;
    final atx f;
    final String g;

    atw(Activity activity, String s, String s1, String s2, String s3, atx atx1, String s4)
    {
        a = activity;
        b = s;
        c = s1;
        d = s2;
        e = s3;
        f = atx1;
        g = s4;
        super();
    }

    public void run()
    {
        if (!atq.a(a, b, c, d, e))
        {
            Toast.makeText(a, d, 1).show();
            if (f != null)
            {
                f.a(true, false);
            }
        } else
        {
            FlurryAgent.logEvent(g);
            if (f != null)
            {
                f.a(true, true);
                return;
            }
        }
    }
}
