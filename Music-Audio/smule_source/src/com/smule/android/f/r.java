// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.android.f:
//            s

public class r
{

    static Toast a;
    static s b;
    static Handler c = new Handler(Looper.getMainLooper());
    private static String d = com/smule/android/f/r.getName();

    public r()
    {
    }

    public static void a(Context context, int i, s s1)
    {
        a(context, i, s1, 0, 0, 0);
    }

    public static void a(Context context, int i, s s1, int j, int k, int l)
    {
        if (context == null)
        {
            aa.b(d, "showToast - Context was null");
            return;
        } else
        {
            a(context, context.getResources().getString(i), s1, j, k, l);
            return;
        }
    }

    public static void a(Context context, String s1)
    {
        a(context, s1, b);
    }

    public static void a(Context context, String s1, s s2)
    {
        a(context, s1, s2, 0, 0, 0);
    }

    public static void a(Context context, String s1, s s2, int i, int j, int k)
    {
        if (context == null)
        {
            aa.b(d, "showToast - Context was null");
            return;
        }
        if (s1 == null)
        {
            aa.b(d, "showToast - text was null");
            return;
        } else
        {
            c.post(new Runnable(context, s1, s2, i, j, k) {

                final Context a;
                final String b;
                final s c;
                final int d;
                final int e;
                final int f;

                public void run()
                {
                    if (r.a != null)
                    {
                        r.a.cancel();
                    }
                    Context context1 = a.getApplicationContext();
                    String s3 = b;
                    int l;
                    if (c == s.b)
                    {
                        l = 1;
                    } else
                    {
                        l = 0;
                    }
                    r.a = Toast.makeText(context1, s3, l);
                    if (d != 0)
                    {
                        r.a.setGravity(d, e, f);
                    }
                    r.a.show();
                }

            
            {
                a = context;
                b = s1;
                c = s2;
                d = i;
                e = j;
                f = k;
                super();
            }
            });
            return;
        }
    }

    static 
    {
        b = s.b;
    }
}
