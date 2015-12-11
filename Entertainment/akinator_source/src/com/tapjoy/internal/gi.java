// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            gk, cw, gw, e, 
//            hj, hi, al, ak, 
//            gd, ge, fx, c, 
//            an, ao, ga, fy, 
//            gv

public final class gi extends gk
{

    final gd a;
    final String b;
    final gw c;
    long d;
    public fy e;
    boolean f;
    boolean g;
    private boolean i;
    private Context j;

    public gi(gd gd1, String s, gw gw1, Context context)
    {
        g = false;
        a = gd1;
        b = s;
        c = gw1;
        j = context;
    }

    private static Boolean a(Context context)
    {
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        context = ((Context) (context.get("tapjoy:hardwareAccelerated")));
        if (!(context instanceof Boolean))
        {
            break MISSING_BLOCK_LABEL_44;
        }
        context = (Boolean)context;
        return context;
        context;
        return null;
    }

    static void a(Context context, String s)
    {
        if (cw.c(s))
        {
            return;
        }
        try
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public final void a()
    {
        c.c();
    }

    public final void a(ge ge1)
    {
        Object obj1;
        boolean flag;
        if (!i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalStateException();
        }
        i = true;
        Activity activity;
        e e1;
        Object obj;
        ak.a a1;
        if (j != null)
        {
            activity = (Activity)j;
        } else
        {
            activity = com.tapjoy.internal.c.a(fx.a());
        }
        e1 = new e(activity);
        e1.setOnCancelListener(new android.content.DialogInterface.OnCancelListener(ge1) {

            final ge a;
            final gi b;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.d(b.b);
            }

            
            {
                b = gi.this;
                a = ge1;
                super();
            }
        });
        e1.setOnDismissListener(new android.content.DialogInterface.OnDismissListener(activity, ge1) {

            final Activity a;
            final ge b;
            final gi c;

            public final void onDismiss(DialogInterface dialoginterface)
            {
                gi.a(a, c.c.g);
                c.a.a(c.c.k, SystemClock.elapsedRealtime() - c.d);
                if (!c.f)
                {
                    b.b(c.b, c.c.h);
                }
                if (c.g && c.c.k != null && c.c.k.containsKey("action_id"))
                {
                    dialoginterface = c.c.k.get("action_id").toString();
                    if (dialoginterface != null && dialoginterface.length() > 0)
                    {
                        c.a.h(dialoginterface);
                    }
                }
            }

            
            {
                c = gi.this;
                a = activity;
                b = ge1;
                super();
            }
        });
        e1.setCanceledOnTouchOutside(false);
        obj = new hj(activity, c, new hj.a(e1, activity, activity, ge1) {

            final e a;
            final Activity b;
            final Activity c;
            final ge d;
            final gi e;

            public final void a()
            {
                a.cancel();
            }

            public final void a(gv gv1)
            {
                e.a.a(e.c.k, gv1.b);
                gi.a(b, gv1.d);
                if (gv1.e != null)
                {
                    e.e.a(c, gv1.e);
                    e.f = true;
                }
                d.a(e.b, gv1.f);
                if (gv1.c)
                {
                    a.dismiss();
                }
            }

            public final void b()
            {
                gi gi1 = e;
                boolean flag1;
                if (!e.g)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                gi1.g = flag1;
            }

            
            {
                e = gi.this;
                a = e1;
                b = activity;
                c = activity1;
                d = ge1;
                super();
            }
        });
        obj = new hi(activity, c, ((hj) (obj)));
        obj1 = new FrameLayout(activity);
        ((FrameLayout) (obj1)).addView(((android.view.View) (obj)), new android.widget.FrameLayout.LayoutParams(-2, -2, 17));
        e1.setContentView(((android.view.View) (obj1)));
        if (!Boolean.FALSE.booleanValue()) goto _L2; else goto _L1
_L1:
        obj1 = e1.getWindow();
        if (android.os.Build.VERSION.SDK_INT != 16 || !"4.1.2".equals(android.os.Build.VERSION.RELEASE)) goto _L4; else goto _L3
_L3:
        if (!Boolean.FALSE.equals(a(((Window) (obj1)).getContext()))) goto _L6; else goto _L5
_L5:
        flag = false;
_L15:
        if (!flag) goto _L2; else goto _L7
_L7:
        a1 = ak.a.b;
        obj1 = new al();
        ak._cls1.a[a1.ordinal()];
        JVM INSTR tableswitch 1 4: default 280
    //                   1 388
    //                   2 466
    //                   3 546
    //                   4 624;
           goto _L8 _L9 _L10 _L11 _L12
_L8:
        ((hi) (obj)).startAnimation(((al) (obj1)).b().a());
_L2:
        e1.show();
        e1.a();
        if ((activity.getWindow().getAttributes().flags & 0x400) != 0)
        {
            e1.getWindow().setFlags(1024, 1024);
        }
        d = SystemClock.elapsedRealtime();
        a.a(c.k);
        ge1.c(b);
        return;
_L6:
        ((Window) (obj1)).setFlags(0x1000000, 0x1000000);
_L4:
        flag = true;
        continue; /* Loop/switch isn't completed */
_L9:
        an an1 = new an();
        an1.a = false;
        an1.b = 60F;
        ((al) (obj1)).a(an1.a()).a(new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F)).a((new ao()).a(1.0F).b(0.3F).a());
        continue; /* Loop/switch isn't completed */
_L10:
        an an2 = new an();
        an2.a = false;
        an2.b = -60F;
        ((al) (obj1)).a(an2.a()).a(new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F)).a((new ao()).a(-0.4F).b(0.3F).a());
        continue; /* Loop/switch isn't completed */
_L11:
        an an3 = new an();
        an3.a = true;
        an3.b = -60F;
        ((al) (obj1)).a(an3.a()).a(new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F)).a((new ao()).a(0.3F).b(1.0F).a());
        continue; /* Loop/switch isn't completed */
_L12:
        an an4 = new an();
        an4.a = true;
        an4.b = 60F;
        ((al) (obj1)).a(an4.a()).a(new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F)).a((new ao()).a(0.3F).b(-0.4F).a());
        if (true) goto _L8; else goto _L13
_L13:
        ge1;
        ga.b("Failed to show the content for \"{}\" caused by invalid activity", new Object[] {
            b
        });
        return;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public final boolean b()
    {
        return c.d();
    }
}
