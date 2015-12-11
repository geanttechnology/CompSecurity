// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

// Referenced classes of package com.millennialmedia.android:
//            an, al, ab, ag, 
//            w, at

static class _cls7.b
{

    protected static final String a = com/millennialmedia/android/an$a.getName();

    static void a(Context context, long l)
    {
        if (an.d())
        {
            a(context, new Intent("millennialmedia.action.ACTION_OVERLAY_OPENED"), l);
        }
    }

    private static final void a(Context context, Intent intent, long l)
    {
        if (context != null)
        {
            intent.addCategory("millennialmedia.category.CATEGORY_SDK");
            if (l != -4L)
            {
                intent.putExtra("internalId", l);
            }
            intent.putExtra("packageName", context.getPackageName());
            String s = intent.getStringExtra("intentType");
            if (!TextUtils.isEmpty(s))
            {
                s = String.format(" Type[%s]", new Object[] {
                    s
                });
            } else
            {
                s = "";
            }
            (new StringBuilder(" @@ Intent: ")).append(intent.getAction()).append(" ").append(s).append(" for ").append(l);
            al.a();
            context.sendBroadcast(intent);
        }
    }

    static void a(Context context, String s, long l)
    {
        if (an.d())
        {
            a(context, (new Intent("millennialmedia.action.ACTION_INTENT_STARTED")).putExtra("intentType", s), l);
        }
    }

    static void a(ab ab1)
    {
        if (ab1 != null)
        {
            an.a(new Runnable(ab1) {

                final ab a;

                public final void run()
                {
                    if (a == null || a.c == null)
                    {
                        break MISSING_BLOCK_LABEL_36;
                    }
                    a.c.onSingleTap(a.d());
                    return;
                    Exception exception;
                    exception;
                    al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                    return;
                }

            
            {
                a = ab1;
                super();
            }
            });
            if (an.d())
            {
                a(ab1.j(), new Intent("millennialmedia.action.ACTION_OVERLAY_TAP"), ab1.h);
                a(ab1.j(), new Intent("millennialmedia.action.ACTION_AD_SINGLE_TAP"), ab1.h);
                return;
            }
        }
    }

    static void a(ab ab1, ag ag)
    {
        if (ab1 == null)
        {
            al.d();
        } else
        {
            an.a(new Runnable(ab1, ag) {

                final ab a;
                final ag b;

                public final void run()
                {
                    if (a == null || a.c == null)
                    {
                        break MISSING_BLOCK_LABEL_40;
                    }
                    a.c.requestFailed(a.d(), b);
                    return;
                    Exception exception;
                    exception;
                    al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                    return;
                }

            
            {
                a = ab1;
                b = ag;
                super();
            }
            });
            if (an.d())
            {
                String s = ab1.m();
                a(ab1.j(), (new Intent(s)).putExtra("error", ag), ab1.h);
                return;
            }
        }
    }

    protected static void a(String s)
    {
        al.b();
        a(new Runnable(s) {

            final String a;

            public final void run()
            {
                w w1 = new w();
                try
                {
                    w1.a(a);
                    return;
                }
                catch (Exception exception)
                {
                    al.a(an.a.a, "Error logging event: ", exception);
                }
            }

            
            {
                a = s;
                super();
            }
        });
    }

    static void b(ab ab1)
    {
        if (ab1 == null)
        {
            al.d();
        } else
        {
            an.a(new Runnable(ab1) {

                final ab a;

                public final void run()
                {
                    if (a == null || a.c == null)
                    {
                        break MISSING_BLOCK_LABEL_36;
                    }
                    a.c.MMAdRequestIsCaching(a.d());
                    return;
                    Exception exception;
                    exception;
                    al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                    return;
                }

            
            {
                a = ab1;
                super();
            }
            });
            if (an.d())
            {
                a(ab1.j(), new Intent("millennialmedia.action.ACTION_FETCH_STARTED_CACHING"), ab1.h);
                return;
            }
        }
    }

    static void c(ab ab1)
    {
        if (ab1 == null)
        {
            al.d();
            return;
        }
        if (an.d())
        {
            a(ab1.j(), new Intent("millennialmedia.action.ACTION_DISPLAY_STARTED"), ab1.h);
        }
        d(ab1);
    }

    static void d(ab ab1)
    {
        if (ab1 == null)
        {
            al.d();
            return;
        } else
        {
            an.a(new Runnable(ab1) {

                final ab a;

                public final void run()
                {
                    if (a == null)
                    {
                        break MISSING_BLOCK_LABEL_44;
                    }
                    a.j = true;
                    if (a.c == null)
                    {
                        break MISSING_BLOCK_LABEL_44;
                    }
                    a.c.MMAdOverlayLaunched(a.d());
                    return;
                    Exception exception;
                    exception;
                    al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                    return;
                }

            
            {
                a = ab1;
                super();
            }
            });
            a(ab1.j(), ab1.h);
            return;
        }
    }

    static void e(ab ab1)
    {
        if (ab1 == null)
        {
            al.d();
        } else
        {
            an.a(new Runnable(ab1) {

                final ab a;

                public final void run()
                {
                    if (a == null)
                    {
                        break MISSING_BLOCK_LABEL_44;
                    }
                    a.j = false;
                    if (a.c == null)
                    {
                        break MISSING_BLOCK_LABEL_44;
                    }
                    a.c.MMAdOverlayClosed(a.d());
                    return;
                    Exception exception;
                    exception;
                    al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                    return;
                }

            
            {
                a = ab1;
                super();
            }
            });
            if (an.d() && ab1.j() != null)
            {
                a(ab1.j(), new Intent("millennialmedia.action.ACTION_OVERLAY_CLOSED"), ab1.h);
                return;
            }
        }
    }

    static void f(ab ab1)
    {
        if (ab1 == null)
        {
            al.d();
        } else
        {
            an.a(new Runnable(ab1) {

                final ab a;

                public final void run()
                {
                    if (a == null || a.c == null)
                    {
                        break MISSING_BLOCK_LABEL_36;
                    }
                    a.c.requestCompleted(a.d());
                    return;
                    Exception exception;
                    exception;
                    al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                    return;
                }

            
            {
                a = ab1;
                super();
            }
            });
            if (an.d())
            {
                String s = ab1.n();
                a(ab1.j(), new Intent(s), ab1.h);
                return;
            }
        }
    }


    _cls7.b()
    {
    }
}
