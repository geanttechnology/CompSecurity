// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.Toast;
import com.flurry.android.FlurryAgent;

final class att
    implements Runnable
{

    final Activity a;
    final String b;
    final String c;
    final String d;
    final Bitmap e;
    final atx f;
    final String g;

    att(Activity activity, String s, String s1, String s2, Bitmap bitmap, atx atx1, String s3)
    {
        a = activity;
        b = s;
        c = s1;
        d = s2;
        e = bitmap;
        f = atx1;
        g = s3;
        super();
    }

    public void run()
    {
        if (!atq.a(a, b, c, d, e, -1, -1))
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
