// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.mopub.c.p;
import com.mopub.common.d.a;
import com.mopub.common.d.d;
import com.mopub.common.d.m;
import com.mopub.common.n;
import com.mopub.common.o;
import com.mopub.d.a.g;
import com.mopub.mobileads.b.c;
import com.mopub.mobileads.b.e;
import com.mopub.mobileads.b.f;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            i, ah, am, aj, 
//            ak, al, ai, ag, 
//            ap, ao, aa, aq, 
//            x, af, v, y

public final class an extends i
{

    private final ao A;
    private final android.view.View.OnTouchListener B;
    private int C;
    final ah d;
    final am e;
    aj f;
    aj g;
    ImageView h;
    ak i;
    al j;
    ai k;
    x l;
    final View m;
    final View n;
    final aa o;
    final View p;
    int q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    int w;
    boolean x;
    private ag y;
    private final ap z;

    an(Activity activity, Bundle bundle, Bundle bundle1, long l1, i.a a1)
    {
        super(activity, Long.valueOf(l1), a1);
        q = 5000;
        u = false;
        v = false;
        x = false;
        C = -1;
        a1 = null;
        if (bundle1 != null)
        {
            a1 = bundle1.getSerializable("resumed_vast_config");
        }
        bundle = bundle.getSerializable("vast_video_config");
        if (a1 != null && (a1 instanceof ah))
        {
            d = (ah)a1;
            C = bundle1.getInt("current_position", -1);
        } else
        if (bundle != null && (bundle instanceof ah))
        {
            d = (ah)bundle;
        } else
        {
            throw new IllegalStateException("VastVideoConfig is invalid");
        }
        if (d.k == null)
        {
            throw new IllegalStateException("VastVideoConfig does not have a video disk path");
        }
        l = d.a(activity.getResources().getConfiguration().orientation);
        o = d.l;
        B = new android.view.View.OnTouchListener(activity) {

            final Activity a;
            final an b;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1 && b.r)
                {
                    b.x = true;
                    b.a("com.mopub.action.interstitial.click");
                    view = b.d;
                    motionevent = a;
                    int i1;
                    if (b.s)
                    {
                        i1 = b.w;
                    } else
                    {
                        i1 = b.e.getCurrentPosition();
                    }
                    com.mopub.common.m.a(motionevent, "activity cannot be null");
                    com.mopub.c.p.a(((ah) (view)).g, null, Integer.valueOf(i1), ((ah) (view)).j, motionevent);
                    if (!TextUtils.isEmpty(((ah) (view)).i))
                    {
                        com.mopub.common.o.a a2 = (new com.mopub.common.o.a()).a(n.b, new n[] {
                            n.e, n.d, n.f, n.g, n.h, n.i
                        });
                        a2.a = new ah._cls1(view, motionevent);
                        a2.c = true;
                        a2.a().a(motionevent, ((ah) (view)).i);
                    }
                }
                return true;
            }

            
            {
                b = an.this;
                a = activity;
                super();
            }
        };
        super.b.setBackgroundColor(0xff000000);
        if (d.k == null)
        {
            throw new IllegalStateException("VastVideoConfig does not have a video disk path");
        }
        bundle = new am(activity);
        bundle.setId((int)com.mopub.common.d.m.a());
        bundle.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener(bundle) {

            final am a;
            final an b;

            public final void onPrepared(MediaPlayer mediaplayer)
            {
                b.w = b.e.getDuration();
                mediaplayer = b;
                int i1 = ((an) (mediaplayer)).e.getDuration();
                if (i1 < 16000)
                {
                    mediaplayer.q = i1;
                }
                Integer integer = ((an) (mediaplayer)).d.b(i1);
                if (integer != null)
                {
                    mediaplayer.q = integer.intValue();
                    mediaplayer.u = true;
                }
                if (b.l == null)
                {
                    mediaplayer = a;
                    Object obj = b.h;
                    String s1 = b.d.k;
                    if (((am) (mediaplayer)).b != null)
                    {
                        mediaplayer.a = new af(((am) (mediaplayer)).b, ((ImageView) (obj)), mediaplayer.getDuration());
                        int j1;
                        int k1;
                        try
                        {
                            com.mopub.common.d.a.a(((am) (mediaplayer)).a, new String[] {
                                s1
                            });
                        }
                        // Misplaced declaration of an exception variable
                        catch (MediaPlayer mediaplayer)
                        {
                            com.mopub.common.c.a.b("Failed to blur last video frame", mediaplayer);
                        }
                    }
                }
                mediaplayer = b.i;
                j1 = b.e.getDuration();
                k1 = b.q;
                obj = ((ak) (mediaplayer)).a;
                obj.a = j1;
                obj.b = k1;
                obj.e = (float)((e) (obj)).b / (float)((e) (obj)).a;
                mediaplayer.setVisibility(0);
                mediaplayer = b.j;
                j1 = b.q;
                ((al) (mediaplayer)).a.a = j1;
                mediaplayer.setVisibility(0);
                b.v = true;
            }

            
            {
                b = an.this;
                a = am1;
                super();
            }
        });
        bundle.setOnTouchListener(B);
        bundle.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener(bundle, activity) {

            final am a;
            final Context b;
            final an c;

            public final void onCompletion(MediaPlayer mediaplayer)
            {
                c.k();
                c.i();
                c.a(false);
                c.s = true;
                if (!c.t && c.d.a(0x7fffffff, 0x7fffffff).size() == 0)
                {
                    mediaplayer = c.d;
                    Context context = ((i) (c)).a;
                    int i1 = c.e.getCurrentPosition();
                    com.mopub.common.m.a(context, "context cannot be null");
                    com.mopub.c.p.a(((ah) (mediaplayer)).d, null, Integer.valueOf(i1), ((ah) (mediaplayer)).j, context);
                }
                a.setVisibility(4);
                c.i.setVisibility(8);
                c.p.setVisibility(8);
                c.f.a();
                c.g.a();
                mediaplayer = c.k;
                mediaplayer.b = true;
                mediaplayer.c = true;
                mediaplayer.a();
                if (c.l != null)
                {
                    if (b.getResources().getConfiguration().orientation == 1)
                    {
                        c.n.setVisibility(0);
                    } else
                    {
                        c.m.setVisibility(0);
                    }
                    c.l.a(b, c.w);
                } else
                if (c.h.getDrawable() != null)
                {
                    c.h.setVisibility(0);
                    return;
                }
            }

            
            {
                c = an.this;
                a = am1;
                b = context;
                super();
            }
        });
        bundle.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener(bundle) {

            final am a;
            final an b;

            public final boolean onError(MediaPlayer mediaplayer, int i1, int j1)
            {
                if (a.a(mediaplayer, i1, j1, b.d.k))
                {
                    return true;
                } else
                {
                    b.k();
                    b.i();
                    b.h();
                    b.t = true;
                    mediaplayer = b.d;
                    Context context = ((i) (b)).a;
                    y y1 = com.mopub.mobileads.y.d;
                    i1 = b.e.getCurrentPosition();
                    com.mopub.common.m.a(context, "context cannot be null");
                    com.mopub.c.p.a(((ah) (mediaplayer)).h, y1, Integer.valueOf(i1), ((ah) (mediaplayer)).j, context);
                    return false;
                }
            }

            
            {
                b = an.this;
                a = am1;
                super();
            }
        });
        bundle.setVideoPath(d.k);
        bundle.setVisibility(0);
        e = bundle;
        e.requestFocus();
        m = a(activity, d.a(2));
        n = a(activity, d.a(1));
        boolean flag;
        boolean flag1;
        if (l != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = new aj(activity, android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, d.p, flag, 0, 6, super.b.getId());
        super.b.addView(f);
        i = new ak(activity, e.getId());
        i.setVisibility(4);
        super.b.addView(i);
        if (l != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = new aj(activity, android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP, d.p, flag, 8, 2, i.getId());
        super.b.addView(g);
        j = new al(activity);
        j.setVisibility(4);
        super.b.addView(j);
        bundle1 = o;
        com.mopub.common.m.a(activity);
        if (bundle1 == null)
        {
            bundle = new View(activity);
        } else
        {
            bundle = com.mopub.mobileads.aq.a(activity, ((aa) (bundle1)).e);
            bundle.a = new aq.a(bundle1, activity) {

                final aa a;
                final Context b;
                final an c;

                public final void a()
                {
                    com.mopub.c.p.a(a.f, null, Integer.valueOf(c.e.getCurrentPosition()), c.j(), b);
                    a.a(((i) (c)).a, null);
                }

            
            {
                c = an.this;
                a = aa1;
                b = context;
                super();
            }
            };
            bundle.setWebViewClient(new WebViewClient(bundle1) {

                final aa a;
                final an b;

                public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
                {
                    a.a(((i) (b)).a, s1);
                    return true;
                }

            
            {
                b = an.this;
                a = aa1;
                super();
            }
            });
            bundle.setVisibility(4);
            bundle1 = new android.widget.RelativeLayout.LayoutParams(com.mopub.common.d.d.c(((aa) (bundle1)).a + 16, activity), com.mopub.common.d.d.c(((aa) (bundle1)).b + 16, activity));
            bundle1.addRule(9);
            bundle1.addRule(10);
            super.b.addView(bundle, bundle1);
        }
        p = bundle;
        h = new ImageView(activity);
        h.setVisibility(4);
        bundle = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        super.b.addView(h, bundle);
        if (l != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!TextUtils.isEmpty(d.i))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        k = new ai(activity, e.getId(), flag, flag1);
        super.b.addView(k);
        k.setOnTouchListener(B);
        bundle = d.m;
        if (bundle != null)
        {
            bundle1 = k.a;
            bundle1.a = bundle;
            bundle1.invalidateSelf();
        }
        y = new ag(activity);
        y.setVisibility(8);
        super.b.addView(y);
        activity = new android.view.View.OnTouchListener() {

            final an a;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                int i1;
                if (a.s)
                {
                    i1 = a.w;
                } else
                {
                    i1 = a.e.getCurrentPosition();
                }
                if (motionevent.getAction() == 1)
                {
                    a.x = true;
                    view = a.d;
                    motionevent = ((i) (a)).a;
                    com.mopub.common.m.a(motionevent, "context cannot be null");
                    com.mopub.c.p.a(((ah) (view)).e, null, Integer.valueOf(i1), ((ah) (view)).j, motionevent);
                    com.mopub.c.p.a(((ah) (view)).f, null, Integer.valueOf(i1), ((ah) (view)).j, motionevent);
                    ((i) (a)).c.a();
                }
                return true;
            }

            
            {
                a = an.this;
                super();
            }
        };
        y.setOnTouchListenerToContent(activity);
        activity = d.n;
        if (activity != null)
        {
            bundle = y;
            if (((ag) (bundle)).a != null)
            {
                ((ag) (bundle)).a.setText(activity);
            }
        }
        activity = d.o;
        if (activity != null)
        {
            bundle = y;
            ((ag) (bundle)).b.a(activity, new ag._cls1(bundle, activity));
        }
        activity = new Handler(Looper.getMainLooper());
        z = new ap(this, d, activity);
        A = new ao(this, activity);
    }

    private View a(Context context, x x1)
    {
        com.mopub.common.m.a(context);
        if (x1 == null)
        {
            context = new View(context);
            context.setVisibility(4);
            return context;
        } else
        {
            RelativeLayout relativelayout = new RelativeLayout(context);
            relativelayout.setGravity(17);
            Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            super.b.addView(relativelayout, ((android.view.ViewGroup.LayoutParams) (obj)));
            obj = com.mopub.mobileads.aq.a(context, x1.c);
            obj.a = new aq.a(x1, context) {

                final x a;
                final Context b;
                final an c;

                public final void a()
                {
                    c.a("com.mopub.action.interstitial.click");
                    com.mopub.c.p.a(a.d, null, Integer.valueOf(c.w), null, b);
                    a.a(b, null);
                }

            
            {
                c = an.this;
                a = x1;
                b = context;
                super();
            }
            };
            ((aq) (obj)).setWebViewClient(new WebViewClient(x1, context) {

                final x a;
                final Context b;
                final an c;

                public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
                {
                    a.a(b, s1);
                    return true;
                }

            
            {
                c = an.this;
                a = x1;
                b = context;
                super();
            }
            });
            ((aq) (obj)).setVisibility(4);
            context = new android.widget.RelativeLayout.LayoutParams(com.mopub.common.d.d.b(x1.a + 16, context), com.mopub.common.d.d.b(x1.b + 16, context));
            context.addRule(13, -1);
            relativelayout.addView(((View) (obj)), context);
            return ((View) (obj));
        }
    }

    protected final void a()
    {
        super.a();
        static final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[com.mopub.common.d.c.a.values().length];
                try
                {
                    a[com.mopub.common.d.c.a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.mopub.common.d.c.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.mopub.common.d.c.a.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.mopub.common.d.c.a.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.mopub.mobileads._cls2.a[d.p.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 90
    //                   2 103;
           goto _L1 _L2 _L3
_L1:
        ah ah1 = d;
        Context context = super.a;
        int i1 = e.getCurrentPosition();
        com.mopub.common.m.a(context, "context cannot be null");
        com.mopub.c.p.a(ah1.a, null, Integer.valueOf(i1), ah1.j, context);
        a("com.mopub.action.interstitial.show");
        return;
_L2:
        super.c.a(1);
        continue; /* Loop/switch isn't completed */
_L3:
        super.c.a(0);
        if (true) goto _L1; else goto _L4
_L4:
    }

    final void a(int i1, int j1)
    {
        if (i1 == 1 && j1 == -1)
        {
            super.c.a();
        }
    }

    protected final void a(Bundle bundle)
    {
        bundle.putInt("current_position", C);
        bundle.putSerializable("resumed_vast_config", d);
    }

    protected final VideoView b()
    {
        return e;
    }

    protected final void c()
    {
        k();
        C = e.getCurrentPosition();
        e.pause();
        if (!s && !x)
        {
            ah ah1 = d;
            Context context = super.a;
            int i1 = C;
            com.mopub.common.m.a(context, "context cannot be null");
            com.mopub.c.p.a(ah1.b, null, Integer.valueOf(i1), ah1.j, context);
        }
    }

    protected final void d()
    {
        z.a(50L);
        A.a(250L);
        if (C > 0)
        {
            e.seekTo(C);
        }
        if (!s)
        {
            e.start();
        }
        if (C != -1)
        {
            ah ah1 = d;
            Context context = super.a;
            int i1 = C;
            com.mopub.common.m.a(context, "context cannot be null");
            com.mopub.c.p.a(ah1.c, null, Integer.valueOf(i1), ah1.j, context);
        }
    }

    protected final void e()
    {
        k();
        a("com.mopub.action.interstitial.dismiss");
        am am1 = e;
        if (am1.a != null && am1.a.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            am1.a.cancel(true);
        }
    }

    protected final void f()
    {
        int i1 = super.a.getResources().getConfiguration().orientation;
        l = d.a(i1);
        if (m.getVisibility() == 0 || n.getVisibility() == 0)
        {
            if (i1 == 1)
            {
                m.setVisibility(4);
                n.setVisibility(0);
            } else
            {
                n.setVisibility(4);
                m.setVisibility(0);
            }
            if (l != null)
            {
                l.a(super.a, w);
            }
        }
    }

    public final boolean g()
    {
        return r;
    }

    final void i()
    {
        r = true;
        j.setVisibility(8);
        y.setVisibility(0);
        ai ai1 = k;
        ai1.b = true;
        ai1.a();
    }

    final String j()
    {
        if (d == null)
        {
            return null;
        } else
        {
            return d.j;
        }
    }

    final void k()
    {
        z.b = false;
        A.b = false;
    }
}
