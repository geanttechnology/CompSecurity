// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.e;
import com.google.android.gms.analytics.h;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.e.a;

// Referenced classes of package com.google.android.gms.d:
//            jw, jc, jm, jj

final class jv
{
    static final class a
        implements jc.a
    {

        private final h a;

        public final void a(jj jj1)
        {
            a.a("&cd", jj1.a);
            com.google.android.gms.analytics.f.b b1 = new com.google.android.gms.analytics.f.b();
            b1.a("&a", String.valueOf(jj1.b));
            a.a(b1.a());
        }

        public final void a(jj jj1, Activity activity)
        {
        }

        a(h h1)
        {
            a = h1;
        }
    }


    final jw a;
    private final Context b;

    public jv(Context context, com.google.android.gms.e.a a1, jw jw1)
    {
        boolean flag1 = false;
        super();
        b = context;
        context = jw1;
        if (a1 != null)
        {
            boolean flag;
            if (a1.b == 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                context = jw1;
            } else
            {
                context = new jw.a(jw1.d);
                context.d = a1.b("trackingId");
                context.b = a1.a("trackScreenViews");
                context.c = a1.a("collectAdIdentifiers");
                context = context.a();
            }
        }
        a = context;
        if (a.a && !TextUtils.isEmpty(a.c))
        {
            context = a.c;
            context = e.a(b).a(context);
            context.a = a.b;
            context = new a(context);
            w.a(context);
            a1 = com.google.android.gms.d.jc.a(b);
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                flag = flag1;
                if (((jc) (a1)).c != null)
                {
                    flag = true;
                }
                if (!flag)
                {
                    a1.c = new jm(a1);
                    ((jc) (a1)).a.registerActivityLifecycleCallbacks(((jc) (a1)).c);
                }
            }
            a1.a(context);
        }
    }
}
