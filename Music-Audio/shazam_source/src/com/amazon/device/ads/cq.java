// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

// Referenced classes of package com.amazon.device.ads:
//            ds, cf, bv, d, 
//            bx, da, aw

final class cq
{

    ImageView a;
    ViewGroup b;
    ViewGroup c;
    final ViewGroup d;
    final d e;
    final ds.k f;
    final bx g;
    boolean h;
    private final cf i;

    public cq(ViewGroup viewgroup, d d1)
    {
        this(viewgroup, d1, ds.a(), new cf(), ((bx) (new bv())));
    }

    private cq(ViewGroup viewgroup, d d1, ds.k k, cf cf1, bx bx)
    {
        h = false;
        d = viewgroup;
        e = d1;
        f = k;
        i = cf1;
        g = bx;
    }

    final void a()
    {
        f.a(new Runnable() {

            final cq a;

            public final void run()
            {
                a.b.removeAllViews();
            }

            
            {
                a = cq.this;
                super();
            }
        }, ds.b.a, ds.c.a);
    }

    public final void a(boolean flag, da da)
    {
        h = true;
        if (b != null && a != null && d.equals(b.getParent()) && (b.equals(a.getParent()) || !flag))
        {
            if (!flag)
            {
                a();
            }
            return;
        } else
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((WindowManager)d.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
            int j = (int)(60F * displaymetrics.density + 0.5F);
            da = new ds.f((int)(80F * displaymetrics.density + 0.5F), flag, da, j) {

                final int a;
                final boolean b;
                final da c;
                final int d;
                final cq e;

                private transient Void a()
                {
                    cq cq1;
                    int k;
                    cq1 = e;
                    k = a;
                    boolean flag1 = false;
                    cq1;
                    JVM INSTR monitorenter ;
                    if (cq1.b != null)
                    {
                        break MISSING_BLOCK_LABEL_67;
                    }
                    cq1.b = cf.a(cq1.d.getContext(), cf.a.a, "nativeCloseButton");
                    cq1.a = cq1.g.a(cq1.d.getContext(), "nativeCloseButtonImage");
                    flag1 = true;
                    cq1;
                    JVM INSTR monitorexit ;
                    if (flag1)
                    {
                        Object obj = cq1.g.a(cq1.d.getContext().getResources(), aw.a().a("amazon_ads_close_normal.png"));
                        BitmapDrawable bitmapdrawable = cq1.g.a(cq1.d.getContext().getResources(), aw.a().a("amazon_ads_close_pressed.png"));
                        cq1.a.setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
                        cq1.a.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                        cq1.a.setBackgroundDrawable(null);
                        android.view.View.OnClickListener onclicklistener = cq1. new android.view.View.OnClickListener() {

                            final cq a;

                            public final void onClick(View view)
                            {
                                a.e.a();
                            }

            
            {
                a = cq.this;
                super();
            }
                        };
                        cq1.a.setOnClickListener(onclicklistener);
                        cq1.b.setOnClickListener(onclicklistener);
                        obj = cq1. new android.view.View.OnTouchListener(((BitmapDrawable) (obj)), bitmapdrawable) {

                            final BitmapDrawable a;
                            final BitmapDrawable b;
                            final cq c;

                            public final boolean onTouch(View view, MotionEvent motionevent)
                            {
                                BitmapDrawable bitmapdrawable;
                                BitmapDrawable bitmapdrawable1;
                                view = c;
                                bitmapdrawable = a;
                                bitmapdrawable1 = b;
                                motionevent.getAction();
                                JVM INSTR tableswitch 0 1: default 44
                            //                                           0 46
                            //                                           1 58;
                                   goto _L1 _L2 _L3
_L1:
                                return false;
_L2:
                                ((cq) (view)).a.setImageDrawable(bitmapdrawable1);
                                continue; /* Loop/switch isn't completed */
_L3:
                                ((cq) (view)).a.setImageDrawable(bitmapdrawable);
                                if (true) goto _L1; else goto _L4
_L4:
                            }

            
            {
                c = cq.this;
                a = bitmapdrawable;
                b = bitmapdrawable1;
                super();
            }
                        };
                        cq1.b.setOnTouchListener(((android.view.View.OnTouchListener) (obj)));
                        cq1.a.setOnTouchListener(((android.view.View.OnTouchListener) (obj)));
                        obj = new android.widget.RelativeLayout.LayoutParams(k, k);
                        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
                        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
                        cq1.c = cf.a(cq1.d.getContext(), cf.a.a, "nativeCloseButtonContainer");
                        cq1.c.addView(cq1.b, ((android.view.ViewGroup.LayoutParams) (obj)));
                    }
                    return null;
                    Exception exception;
                    exception;
                    cq1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

                protected final Object doInBackground(Object aobj[])
                {
                    return a();
                }

                protected final void onPostExecute(Object obj)
                {
                    android.widget.RelativeLayout.LayoutParams layoutparams;
                    cq cq1 = e;
                    boolean flag1 = b;
                    da da1 = c;
                    int k = d;
                    int l = a;
                    static final class _cls6
                    {

                        static final int a[];

                        static 
                        {
                            a = new int[da.values().length];
                            try
                            {
                                a[da.g.ordinal()] = 1;
                            }
                            catch (NoSuchFieldError nosuchfielderror6) { }
                            try
                            {
                                a[da.d.ordinal()] = 2;
                            }
                            catch (NoSuchFieldError nosuchfielderror5) { }
                            try
                            {
                                a[da.e.ordinal()] = 3;
                            }
                            catch (NoSuchFieldError nosuchfielderror4) { }
                            try
                            {
                                a[da.c.ordinal()] = 4;
                            }
                            catch (NoSuchFieldError nosuchfielderror3) { }
                            try
                            {
                                a[da.f.ordinal()] = 5;
                            }
                            catch (NoSuchFieldError nosuchfielderror2) { }
                            try
                            {
                                a[da.a.ordinal()] = 6;
                            }
                            catch (NoSuchFieldError nosuchfielderror1) { }
                            try
                            {
                                a[da.b.ordinal()] = 7;
                            }
                            catch (NoSuchFieldError nosuchfielderror)
                            {
                                return;
                            }
                        }
                    }

                    if (flag1 && !cq1.b.equals(cq1.a.getParent()))
                    {
                        obj = new android.widget.RelativeLayout.LayoutParams(k, k);
                        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
                        cq1.b.addView(cq1.a, ((android.view.ViewGroup.LayoutParams) (obj)));
                    } else
                    if (!flag1 && cq1.b.equals(cq1.a.getParent()))
                    {
                        cq1.b.removeView(cq1.a);
                    }
                    if (!cq1.d.equals(cq1.c.getParent()))
                    {
                        cq1.d.addView(cq1.c, new android.widget.FrameLayout.LayoutParams(-1, -1));
                    }
                    layoutparams = new android.widget.RelativeLayout.LayoutParams(l, l);
                    obj = da1;
                    if (da1 == null)
                    {
                        obj = da.b;
                    }
                    _cls6.a[((da) (obj)).ordinal()];
                    JVM INSTR tableswitch 1 7: default 192
                //                               1 259
                //                               2 276
                //                               3 293
                //                               4 310
                //                               5 320
                //                               6 337
                //                               7 354;
                       goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
                    layoutparams.addRule(10);
                    layoutparams.addRule(11);
_L10:
                    cq1.b.setLayoutParams(layoutparams);
                    cq1.c.bringToFront();
                    return;
_L2:
                    layoutparams.addRule(12);
                    layoutparams.addRule(14);
                    continue; /* Loop/switch isn't completed */
_L3:
                    layoutparams.addRule(12);
                    layoutparams.addRule(9);
                    continue; /* Loop/switch isn't completed */
_L4:
                    layoutparams.addRule(12);
                    layoutparams.addRule(11);
                    continue; /* Loop/switch isn't completed */
_L5:
                    layoutparams.addRule(13);
                    continue; /* Loop/switch isn't completed */
_L6:
                    layoutparams.addRule(10);
                    layoutparams.addRule(14);
                    continue; /* Loop/switch isn't completed */
_L7:
                    layoutparams.addRule(10);
                    layoutparams.addRule(9);
                    continue; /* Loop/switch isn't completed */
_L8:
                    layoutparams.addRule(10);
                    layoutparams.addRule(11);
                    if (true) goto _L10; else goto _L9
_L9:
                }

            
            {
                e = cq.this;
                a = j;
                b = flag;
                c = da1;
                d = k;
                super();
            }
            };
            f.a(da, new Void[0]);
            return;
        }
    }

    // Unreferenced inner class com/amazon/device/ads/cq$4

/* anonymous class */
    final class _cls4
        implements Runnable
    {

        final cq a;

        public final void run()
        {
            cq cq1 = a;
            cq1.d.removeView(cq1.c);
        }

            
            {
                a = cq.this;
                super();
            }
    }

}
