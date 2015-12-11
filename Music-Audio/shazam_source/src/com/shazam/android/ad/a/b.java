// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.support.v4.a.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.shazam.android.ac.c;
import com.shazam.android.util.h.h;
import com.shazam.android.widget.bottombar.tagbar.TagBarViewSwitcher;
import com.shazam.i.b.ah.e.a;

// Referenced classes of package com.shazam.android.ad.a:
//            f, c, h, g

public final class b extends c
    implements f
{
    private final class a extends BroadcastReceiver
    {

        final b a;

        public final void onReceive(Context context, Intent intent)
        {
            boolean flag = intent.getBooleanExtra("extraAutoTagIsDupe", false);
            (new Thread(new a(this, com.shazam.android.ad.a.b.a(a).getAutoTagMatcherListener(), flag), "Auto Tag Matched Notifier")).start();
        }

        private a()
        {
            a = b.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class a.a
        implements Runnable
    {

        final a a;
        private final com.shazam.android.widget.bottombar.tagbar.a b;
        private final boolean c;

        public final void run()
        {
            com.shazam.model.AutoTag autotag;
label0:
            {
                autotag = b.b(a.a).a();
                if (autotag != null)
                {
                    if (!c)
                    {
                        break label0;
                    }
                    b.b(autotag);
                }
                return;
            }
            b.a(autotag);
        }

        public a.a(a a1, com.shazam.android.widget.bottombar.tagbar.a a2, boolean flag)
        {
            a = a1;
            super();
            b = a2;
            c = flag;
        }
    }


    private static int b;
    private final com.shazam.android.persistence.d.a c = com.shazam.i.b.ah.e.a.a();
    private final com.shazam.android.ad.a.c d = new com.shazam.android.ad.a.c();
    private final e e = android.support.v4.a.e.a(com.shazam.i.b.c.a());
    private View f;

    public b()
    {
        com.shazam.android.ad.a.c c1 = d;
        c1.b = (TagBarViewSwitcher)LayoutInflater.from(c1.getContext()).inflate(0x7f03007f, c1, true).findViewById(0x7f1101e7);
        c1.setId(0x7f11000d);
        c1.setOrientation(1);
        com.shazam.i.b.c.a().registerReceiver(new a((byte)0), new IntentFilter("com.shazam.android.actions.AUTO_TAG_MATCHED"));
    }

    public static int a()
    {
        return b;
    }

    static com.shazam.android.ad.a.c a(b b1)
    {
        return b1.d;
    }

    static com.shazam.android.persistence.d.a b(b b1)
    {
        return b1.c;
    }

    public final void a(int i)
    {
        b = i;
        if (f != null)
        {
            View view = f;
            long l = (long)((double)view.getResources().getInteger(0x10e0002) * 1.5D);
            Animation animation = new Animation(view, i) {

                final View a;
                final int b;
                final b c;

                protected final void applyTransformation(float f1, Transformation transformation)
                {
                    a.setPadding(0, 0, 0, (int)((float)b * f1));
                }

            
            {
                c = b.this;
                a = view;
                b = i;
                super();
            }
            };
            animation.setDuration(l);
            view.startAnimation(animation);
        }
        e e1 = e;
        Intent intent = new Intent("com.shazam.android.actions.BOTTOM_BAR_HEIGHT_CHANGED");
        intent.putExtra("offset", i);
        e1.a(intent);
    }

    public final void onActivityPaused(Activity activity)
    {
        d.setSizeChangedListener(com.shazam.android.ad.a.f.a);
        d.a();
        f = null;
    }

    public final void onActivityResumed(Activity activity)
    {
        if (activity instanceof com.shazam.android.activities.c)
        {
            if (d.a)
            {
                d.a();
            }
        } else
        {
            if (activity.findViewById(0x7f1100c3) == null)
            {
                Object obj1 = h.a(activity);
                Object obj;
                if (((ViewGroup) (obj1)).getChildCount() > 1)
                {
                    obj = h.a(activity, ((ViewGroup) (obj1)), 0x7f1100c3);
                    ((ViewGroup) (obj1)).addView(((View) (obj)));
                } else
                {
                    obj = ((ViewGroup) (obj1)).getChildAt(0);
                }
                if (obj != null && ((View) (obj)).getId() == -1)
                {
                    ((View) (obj)).setId(0x7f1100c3);
                } else
                {
                    (new StringBuilder("Check player position for ")).append(activity);
                }
            }
            obj = activity.findViewById(0x7f1100c3);
            if (obj == null)
            {
                obj = h.a(activity);
            }
            obj1 = obj;
            if (activity instanceof com.shazam.android.af.a.a)
            {
                obj1 = ((com.shazam.android.af.a.a)activity).a(((View) (obj)));
            }
            f = ((View) (obj1));
            if (!d.a)
            {
                obj = d;
                obj1 = h.a(activity);
                if (((ViewGroup) (obj1)).findViewById(0x7f11000d) == null)
                {
                    ((ViewGroup) (obj1)).addView(((View) (obj)), com.shazam.android.ad.a.c.b());
                }
                obj.a = true;
            }
            a(d.getCurrentHeight());
            d.setSizeChangedListener(this);
            if (activity instanceof com.shazam.android.ad.a.h)
            {
                activity = ((com.shazam.android.ad.a.h)activity).c();
                d.getTagDetailsViewedListener().a(activity);
                return;
            }
        }
    }
}
