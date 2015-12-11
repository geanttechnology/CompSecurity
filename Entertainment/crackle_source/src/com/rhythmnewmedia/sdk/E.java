// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.rhythmnewmedia.sdk.util.Util;
import com.rhythmnewmedia.sdk.video.RhythmVideoView;
import com.rhythmnewmedia.sdk.video.VideoAdEventListener;
import com.rhythmnewmedia.sdk.video.VideoDataSource;
import com.rhythmnewmedia.sdk.video.VideoEventListener;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            F, y, z, d, 
//            A, B, L, t, 
//            G, K, x, i, 
//            RhythmActivity, NoAdReason, O, M

public final class E extends FrameLayout
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener, android.view.SurfaceHolder.Callback, android.view.View.OnTouchListener, B.d, M.a, RhythmActivity.a, a.b
{
    final class a extends Handler
    {

        final E a;

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR lookupswitch 12: default 112
        //                       1: 113
        //                       2: 157
        //                       100: 211
        //                       200: 263
        //                       201: 307
        //                       202: 351
        //                       300: 402
        //                       301: 456
        //                       1000: 510
        //                       1010: 518
        //                       1020: 526
        //                       5000: 537;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
            return;
_L2:
            if (a.a != null)
            {
                a.a.onPrepared(E.b(a), E.c(a), E.d(a));
                return;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            if (a.a != null)
            {
                a.a.onCompletion(E.b(a), ((Integer)message.obj).intValue(), E.c(a), E.d(a));
                return;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (a.a != null)
            {
                a.a.onError(E.b(a), message.arg1, message.arg2, E.c(a), E.d(a));
                return;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (a.b != null)
            {
                a.b.onWillRequestAd(E.b(a), E.c(a), E.d(a));
                return;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (a.b != null)
            {
                a.b.onAdReceived(E.b(a), E.c(a), E.d(a));
                return;
            }
            continue; /* Loop/switch isn't completed */
_L7:
            if (a.b != null)
            {
                a.b.onNoAdReceived(E.b(a), (NoAdReason)message.obj, E.c(a), E.d(a));
                return;
            }
            continue; /* Loop/switch isn't completed */
_L8:
            if (a.a != null)
            {
                a.a.playbackStarted(E.b(a), ((Boolean)message.obj).booleanValue(), E.c(a), E.d(a));
                return;
            }
            continue; /* Loop/switch isn't completed */
_L9:
            if (a.a != null)
            {
                a.a.playbackStopped(E.b(a), ((Boolean)message.obj).booleanValue(), E.c(a), E.d(a));
                return;
            }
            if (true) goto _L1; else goto _L10
_L10:
            a.r();
            return;
_L11:
            E.e(a);
            return;
_L12:
            E.b(a).finishFullscreenActivity();
            return;
_L13:
            if (E.f(a) != b.d)
            {
                if (!a.g)
                {
                    E.a(a, NoAdReason.error);
                    E.g(a);
                    return;
                } else
                {
                    E.h(a).sendMessage(E.h(a).obtainMessage(100, 1, -110));
                    E.i(a);
                    return;
                }
            }
            if (true) goto _L1; else goto _L14
_L14:
        }

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            a = E.this;
            super();
        }
    }

    static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        private static final b g[];

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/rhythmnewmedia/sdk/E$b, s1);
        }

        public static b[] values()
        {
            return (b[])g.clone();
        }

        static 
        {
            a = new b("error", 0);
            b = new b("idle", 1);
            c = new b("preparing", 2);
            d = new b("playing", 3);
            e = new b("paused", 4);
            f = new b("stopped", 5);
            g = (new b[] {
                a, b, c, d, e, f
            });
        }

        private b(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private static String k;
    private boolean A;
    private boolean B;
    private Runnable C;
    private final Handler D;
    public VideoEventListener a;
    public VideoAdEventListener b;
    public VideoDataSource c;
    public String d;
    public String e;
    public boolean f;
    boolean g;
    public boolean h;
    int i;
    int j;
    private final RhythmVideoView l;
    private final A m;
    private final d n;
    private int o;
    private final Handler p;
    private L q;
    private final VideoView r;
    private int s;
    private int t;
    private b u;
    private b v;
    private int w;
    private String x;
    private int y;
    private int z;

    public E(Context context, RhythmVideoView rhythmvideoview)
    {
        super(context);
        g = false;
        n = (d)z.a.a(com/rhythmnewmedia/sdk/d, new Object[0]);
        o = 0;
        p = new Handler();
        x = null;
        y = 15000;
        z = -1;
        A = false;
        B = false;
        C = new F(this);
        D = new a();
        l = rhythmvideoview;
        m = (A)z.a.a(com/rhythmnewmedia/sdk/A, new Object[] {
            context
        });
        i = 0;
        j = 0;
        rhythmvideoview = new android.widget.FrameLayout.LayoutParams(-1, -1);
        rhythmvideoview.gravity = 17;
        r = new VideoView(context);
        r.setLayoutParams(rhythmvideoview);
        addView(r);
        r.setOnPreparedListener(this);
        r.setOnCompletionListener(this);
        r.setOnErrorListener(this);
        r.getHolder().addCallback(this);
        rhythmvideoview = new B(context);
        rhythmvideoview.setId(200);
        rhythmvideoview.setVisibility(8);
        rhythmvideoview.a = this;
        addView(rhythmvideoview);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        o = 0;
        u = b.b;
        setOnTouchListener(this);
        if (k != null)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        k = (new WebView(context)).getSettings().getUserAgentString();
        if (Util.a() == null)
        {
            Util.a(k);
        }
        return;
        context;
        com.rhythmnewmedia.sdk.y.a(context, "Failed to get browser user-agent", new Object[0]);
        return;
    }

    private void A()
    {
        this;
        JVM INSTR monitorenter ;
        com.rhythmnewmedia.sdk.y.a("------------ startPlaybackIfReady", new Object[0]);
        Object obj;
        if (e(1))
        {
            obj = "yes";
        } else
        {
            obj = "no";
        }
        com.rhythmnewmedia.sdk.y.a("  - surface ready:   %s", new Object[] {
            obj
        });
        if (e(2))
        {
            obj = "yes";
        } else
        {
            obj = "no";
        }
        com.rhythmnewmedia.sdk.y.a("  - bumper done:     %s", new Object[] {
            obj
        });
        if (e(4))
        {
            obj = "yes";
        } else
        {
            obj = "no";
        }
        com.rhythmnewmedia.sdk.y.a("  - ad ready:        %s", new Object[] {
            obj
        });
        if (e(8))
        {
            obj = "yes";
        } else
        {
            obj = "no";
        }
        com.rhythmnewmedia.sdk.y.a("  - movie ready:     %s", new Object[] {
            obj
        });
        if (u == b.d)
        {
            obj = "yes";
        } else
        {
            obj = "no";
        }
        com.rhythmnewmedia.sdk.y.a("  - already playing: %s", new Object[] {
            obj
        });
        if (u == b.f)
        {
            obj = "yes";
        } else
        {
            obj = "no";
        }
        com.rhythmnewmedia.sdk.y.a("  - stopped:         %s", new Object[] {
            obj
        });
        if (!e(1) || !e(2) || !e(4) || !e(8) || u == b.d || u == b.f) goto _L2; else goto _L1
_L1:
        u = b.d;
        D.removeMessages(5000);
        obj = (TextView)findViewById(1000);
        if (!h) goto _L4; else goto _L3
_L3:
        ((TextView) (obj)).setText("Playing audio...");
_L8:
        a(-1, q.f);
        n();
        if (z != 0) goto _L6; else goto _L5
_L5:
        B();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        obj = (TextView)findViewById(1000);
        if (obj == null) goto _L8; else goto _L7
_L7:
        ((TextView) (obj)).setVisibility(8);
          goto _L8
        obj;
        throw obj;
_L6:
        if (z <= 0) goto _L2; else goto _L9
_L9:
        D.postDelayed(C, z);
          goto _L2
    }

    private void B()
    {
        View view = findViewById(1010);
        Object obj = view;
        if (view == null)
        {
            Bitmap bitmap = BitmapFactory.decodeByteArray(t.b, 0, t.b.length);
            obj = view;
            if (bitmap != null)
            {
                obj = new ImageButton(getContext());
                ((ImageButton) (obj)).setPadding(10, 10, 10, 10);
                ((ImageButton) (obj)).setBackgroundColor(0);
                bitmap.setDensity(160);
                ((ImageButton) (obj)).setImageBitmap(bitmap);
                ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final E a;

                    public final void onClick(View view1)
                    {
                        a.q();
                    }

            
            {
                a = E.this;
                super();
            }
                });
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
                layoutparams.gravity = 51;
                ((ImageButton) (obj)).setLayoutParams(layoutparams);
                ((ImageButton) (obj)).setVisibility(8);
                ((ImageButton) (obj)).setId(1010);
                addView(((View) (obj)));
            }
        }
        if (obj != null)
        {
            ((View) (obj)).setVisibility(0);
        }
    }

    private void C()
    {
        byte byte0 = 100;
        int i1 = -1;
        int j1 = r.getDuration();
        if (j1 > 0)
        {
            j1 = (int)(((double)r.getCurrentPosition() * 100D) / (double)j1 + 0.5D);
            i1 = j1;
            if (j1 > 100)
            {
                i1 = byte0;
            }
        }
        D.sendMessage(D.obtainMessage(2, Integer.valueOf(i1)));
        D.removeMessages(5000);
        r.stopPlayback();
        o = 0;
        u = b.f;
        v = null;
        Handler handler = D;
        Message message = D.obtainMessage(1020);
        long l1;
        if (B)
        {
            l1 = 500L;
        } else
        {
            l1 = 0L;
        }
        handler.sendMessageDelayed(message, l1);
    }

    private void D()
    {
label0:
        {
            boolean flag = false;
            com.rhythmnewmedia.sdk.y.a("@@@@@@@@@@ movie done", new Object[0]);
            if (u == b.c || u == b.d || u == b.e)
            {
                if (u == b.d || u == b.e)
                {
                    flag = true;
                }
                if (flag)
                {
                    a(q.f, -1);
                }
                D.removeMessages(1000);
                u = b.b;
                if (v != b.b)
                {
                    break label0;
                }
                v = b.d;
                r.stopPlayback();
            }
            return;
        }
        if (v != b.f && q != null && !q.d && q.a())
        {
            y();
            z();
            return;
        } else
        {
            C();
            return;
        }
    }

    private void E()
    {
        g = true;
        String s1 = x();
        if (s1 != null)
        {
            F().setVisibility(4);
            q = new L(null);
            q.c = s1;
            q.d = true;
            z();
            return;
        } else
        {
            C();
            return;
        }
    }

    private B F()
    {
        return (B)findViewById(200);
    }

    private void a(int i1, int j1)
    {
        K k1;
        Object obj = q.a(i1);
        k1 = q.a(j1);
        if (obj != null)
        {
            boolean flag = obj instanceof G;
            if (flag)
            {
                G g1 = (G)obj;
                com.rhythmnewmedia.sdk.y.a("just watched ad %s", new Object[] {
                    ((K) (obj)).h
                });
                if (!g1.f)
                {
                    a(((K) (obj)));
                }
                a(new Runnable(g1) {

                    final G a;
                    final E b;

                    public final void run()
                    {
                        b.removeView(a.g);
                    }

            
            {
                b = E.this;
                a = g1;
                super();
            }
                });
                o = o & -5;
                g1.f = true;
            } else
            {
                com.rhythmnewmedia.sdk.y.a("just watched content %s", new Object[] {
                    ((K) (obj)).h
                });
                a(((K) (obj)));
            }
            D.sendMessage(D.obtainMessage(301, Boolean.valueOf(flag)));
        }
        if (k1 == null) goto _L2; else goto _L1
_L1:
        flag = k1 instanceof G;
        if (!flag) goto _L4; else goto _L3
_L3:
        com.rhythmnewmedia.sdk.y.a("about to watch ad %s", new Object[] {
            k1.h
        });
        F().a(true);
        obj = (G)k1;
        if (((G) (obj)).g != null)
        {
            a(new Runnable(((G) (obj))) {

                final G a;
                final E b;

                public final void run()
                {
                    if (a.g.getParent() != null)
                    {
                        b.removeView(a.g);
                    }
                    b.addView(a.g);
                    M m1 = a.g;
                    if (m1.a != null)
                    {
                        m1.a.loadUrl("javascript:net.rnmd.sdk.rhythmAdDisplayed()");
                    }
                }

            
            {
                b = E.this;
                a = g1;
                super();
            }
            });
        }
        if (u == b.d)
        {
            m.a(((G) (obj)).a);
        }
_L7:
        D.sendMessage(D.obtainMessage(300, Boolean.valueOf(flag)));
_L2:
        return;
_L4:
        Object obj1;
        com.rhythmnewmedia.sdk.y.a("about to watch content %s", new Object[] {
            k1.h
        });
        F().setVisibility(4);
        obj1 = q;
_L8:
        if (j1 >= ((L) (obj1)).b.size())
        {
            break MISSING_BLOCK_LABEL_366;
        }
        k1 = (K)((L) (obj1)).b.get(j1);
        if (!(k1 instanceof G)) goto _L6; else goto _L5
_L5:
        obj1 = (G)k1;
_L9:
        if (obj1 != null && ((G) (obj1)).g == null)
        {
            a(((G) (obj1)));
        }
          goto _L7
_L6:
        j1++;
          goto _L8
        obj1 = null;
          goto _L9
    }

    static void a(E e1)
    {
        e1.B();
    }

    static void a(E e1, NoAdReason noadreason)
    {
        e1.a(noadreason);
    }

    private void a(G g1)
    {
        a(new Runnable(g1) {

            final G a;
            final E b;

            public final void run()
            {
                M m1 = new M(b.getContext(), b, a);
                a.g = m1;
            }

            
            {
                b = E.this;
                a = g1;
                super();
            }
        });
    }

    private void a(K k1)
    {
        double d1;
        boolean flag1;
        flag1 = false;
        d1 = 100D;
        if (k1.j > 0) goto _L2; else goto _L1
_L1:
        if (d1 > 0.0D)
        {
            A a1 = m;
            String s1 = q.a;
            String s2 = k1.h;
            com.rhythmnewmedia.sdk.video.VideoDataSource.a a2 = com.rhythmnewmedia.sdk.video.VideoDataSource.a.b;
            x.a.a(new A._cls1(a1, s1, s2, d1, a2));
            k1.k = true;
        }
        return;
_L2:
        int j1 = r.getCurrentPosition();
        Iterator iterator = q.b.iterator();
        int i1 = 0;
label0:
        do
        {
label1:
            {
                boolean flag = flag1;
                K k2;
                if (iterator.hasNext())
                {
                    k2 = (K)iterator.next();
                    if (!k2.h.equals(k1.h))
                    {
                        break label1;
                    }
                    flag = true;
                }
                if (flag)
                {
                    d1 = ((double)(j1 - i1) * 100D) / (double)k1.j;
                    double d2 = d1;
                    if (d1 < 0.0D)
                    {
                        d2 = 0.0D;
                    }
                    d1 = d2;
                    if (d2 > 100D)
                    {
                        d1 = 100D;
                    }
                } else
                {
                    d1 = 0.0D;
                }
                break label0;
            }
            i1 = k2.j + i1;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void a(NoAdReason noadreason)
    {
        D.sendMessage(D.obtainMessage(202, noadreason));
    }

    private void a(Runnable runnable)
    {
        if (getHandler() != null)
        {
            getHandler().post(runnable);
        } else
        if (getContext() instanceof Activity)
        {
            ((Activity)getContext()).runOnUiThread(runnable);
            return;
        }
    }

    static RhythmVideoView b(E e1)
    {
        return e1.l;
    }

    static int c(E e1)
    {
        return e1.s;
    }

    static int d(E e1)
    {
        return e1.t;
    }

    static void e(E e1)
    {
        e1.z();
    }

    private boolean e(int i1)
    {
        return (o & i1) != 0;
    }

    static b f(E e1)
    {
        return e1.u;
    }

    private void f(int i1)
    {
        o = o | i1;
    }

    static void g(E e1)
    {
        e1.E();
    }

    static Handler h(E e1)
    {
        return e1.D;
    }

    static void i(E e1)
    {
        e1.C();
    }

    private int s()
    {
        int i1;
        try
        {
            Field field = android/widget/VideoView.getDeclaredField("mCurrentBufferPercentage");
            field.setAccessible(true);
            i1 = field.getInt(r);
        }
        catch (Throwable throwable)
        {
            return 0;
        }
        return i1;
    }

    private boolean t()
    {
        return r.isPlaying() || u == b.e;
    }

    private boolean u()
    {
        return d != null && e != null;
    }

    private boolean v()
    {
        while (u() || q != null && q.b.size() == 1 && (q.a(0) instanceof G)) 
        {
            return true;
        }
        return false;
    }

    private String w()
    {
        if (c == null || s < 0)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        String s1 = (String)com/rhythmnewmedia/sdk/video/VideoDataSource.getDeclaredMethod("getVideoID", new Class[0]).invoke(c, new Object[] {
            l, Integer.valueOf(s), Integer.valueOf(t)
        });
        return s1;
        Throwable throwable;
        throwable;
        return null;
    }

    private String x()
    {
        if (c != null && s >= 0)
        {
            return c.getVideoUrl(l, s, t);
        } else
        {
            return null;
        }
    }

    private void y()
    {
        TextView textview1 = (TextView)findViewById(1000);
        TextView textview = textview1;
        if (textview1 == null)
        {
            textview = new TextView(getContext());
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            layoutparams.gravity = 17;
            textview.setId(1000);
            textview.setLayoutParams(layoutparams);
            addView(textview);
        }
        if (h)
        {
            textview.setText("Loading audio...");
        } else
        {
            textview.setText("Loading ...");
        }
        textview.setVisibility(0);
    }

    private void z()
    {
        if (!D.hasMessages(5000))
        {
            D.sendEmptyMessageDelayed(5000, y);
        }
        K k1 = q.b();
        if (k1 instanceof G)
        {
            com.rhythmnewmedia.sdk.y.a(" - ad overlay is about to render", new Object[0]);
            a((G)k1);
        } else
        {
            com.rhythmnewmedia.sdk.y.a(" - no ad", new Object[0]);
            f(4);
        }
        a(new Runnable() {

            final E a;

            public final void run()
            {
                a.l();
            }

            
            {
                a = E.this;
                super();
            }
        });
    }

    public final i a(String s1)
    {
        Object obj;
        obj = q.b();
        if (!(obj instanceof G))
        {
            return n.a;
        }
        Object obj1 = (G)obj;
        obj = com.rhythmnewmedia.sdk.d.a(s1, getContext(), null, q.a, ((K) (obj)).h);
        q.e = r.getCurrentPosition();
        if (((i) (obj)).a == d.a.l)
        {
            Intent intent = new Intent(getContext(), com/rhythmnewmedia/sdk/RhythmActivity);
            intent.putExtra("url", s1);
            intent.putExtra("rnmdRequestId", q.a);
            intent.putExtra("rnmdAdId", ((K) (obj1)).h);
            intent.putExtra("rnmdActivityType", 4);
            intent.putExtra("backgroundColor", ((G) (obj1)).b);
            intent.setFlags(0x10010000);
            getContext().startActivity(intent);
        }
        if (((i) (obj)).a.b())
        {
            s1 = m;
            String s2 = q.a;
            obj1 = ((K) (obj1)).h;
            d.a a1 = ((i) (obj)).a;
            String s3 = ((i) (obj)).c;
            x.a.a(new a._cls3(s1, s2, ((String) (obj1)), a1, s3));
        }
        if (!((i) (obj)).b) goto _L2; else goto _L1
_L1:
        static final class _cls6
        {

            static final int a[];

            static 
            {
                a = new int[com.rhythmnewmedia.sdk.d.a.values().length];
                try
                {
                    a[d.a.h.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[d.a.i.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[d.a.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[d.a.n.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[d.a.s.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[d.a.l.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[d.a.m.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[d.a.o.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[d.a.p.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[d.a.q.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[d.a.r.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls6.a[((i) (obj)).a.ordinal()];
        JVM INSTR tableswitch 1 11: default 308
    //                   1 310
    //                   2 317
    //                   3 324
    //                   4 331
    //                   5 331
    //                   6 357
    //                   7 357
    //                   8 357
    //                   9 357
    //                   10 357
    //                   11 357;
           goto _L2 _L3 _L4 _L5 _L6 _L6 _L7 _L7 _L7 _L7 _L7 _L7
_L2:
        return ((i) (obj));
_L3:
        p();
        continue; /* Loop/switch isn't completed */
_L4:
        n();
        continue; /* Loop/switch isn't completed */
_L5:
        q();
        continue; /* Loop/switch isn't completed */
_L6:
        if (!v())
        {
            A = true;
            v = b.b;
        }
        D();
        continue; /* Loop/switch isn't completed */
_L7:
        if (!v())
        {
            v = b.b;
        } else
        {
            B = true;
        }
        D();
        if (true) goto _L2; else goto _L8
_L8:
    }

    public final void a()
    {
        q();
    }

    public final void a(int i1)
    {
        r.seekTo(i1);
        F().a(i1, s());
    }

    public final void a(B b1)
    {
        b1.a(r.getCurrentPosition(), s());
    }

    public final void a(a.a a1)
    {
    }

    public final void a(a.d d1)
    {
        if (d1 == a.d.a)
        {
            d1 = NoAdReason.noAd;
        } else
        {
            d1 = NoAdReason.error;
        }
        a(((NoAdReason) (d1)));
        E();
    }

    public final void a(InputStream inputstream)
    {
        if (g)
        {
            return;
        }
        try
        {
            q = (L)(new O()).a(inputstream);
            if (q.b.isEmpty())
            {
                a(NoAdReason.noAd);
                E();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            com.rhythmnewmedia.sdk.y.a(inputstream, "Error parsing server response", new Object[0]);
            a(NoAdReason.error);
            E();
            return;
        }
        if (f) goto _L2; else goto _L1
_L1:
        inputstream = q.b.iterator();
_L6:
        if (!inputstream.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((K)inputstream.next() instanceof G)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L10:
        if (!flag) goto _L8; else goto _L7
_L7:
        D.sendMessage(D.obtainMessage(201));
_L2:
        inputstream = Util.a(q.c, q.a);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        q.c = inputstream;
        z();
        return;
_L8:
        a(NoAdReason.noAd);
          goto _L2
_L4:
        flag = false;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public final void b()
    {
label0:
        {
            if (u == b.b && v == b.d && q != null && q.a())
            {
                v = null;
                y();
                if (!A)
                {
                    break label0;
                }
                A = false;
                D.sendMessageDelayed(D.obtainMessage(1010), 1000L);
            }
            return;
        }
        z();
    }

    public final void b(int i1)
    {
        y = i1;
    }

    public final String c()
    {
        StringBuilder stringbuilder;
        boolean flag;
        stringbuilder = new StringBuilder("&channel=video&delivery=progressiveDownload");
        String s1;
        if (((WifiManager)getContext().getSystemService("wifi")).isWifiEnabled())
        {
            s1 = "wifi";
        } else
        {
            s1 = "3G";
        }
        stringbuilder.append((new StringBuilder()).append("&link_type=").append(s1).toString());
        flag = true;
        s1 = w();
        if (s1 == null) goto _L2; else goto _L1
_L1:
        stringbuilder.append("&contentID=");
        stringbuilder.append(Util.d(s1));
        flag = false;
_L4:
        stringbuilder.append("&");
        stringbuilder.append("v");
        stringbuilder.append("=");
        stringbuilder.append(3);
        stringbuilder.append("&");
        stringbuilder.append("cl");
        stringbuilder.append("=");
        stringbuilder.append(3);
        stringbuilder.append("&w=");
        stringbuilder.append(getWidth());
        stringbuilder.append("&h=");
        stringbuilder.append(getHeight());
        if (f || w > 0 && !flag)
        {
            stringbuilder.append("&direct=true");
        }
        return stringbuilder.toString();
_L2:
        String s2 = x();
        if (s2 != null)
        {
            stringbuilder.append("&url=");
            stringbuilder.append(Util.d(s2));
            flag = false;
        } else
        if (u())
        {
            stringbuilder.append("&adId=");
            stringbuilder.append(e);
            stringbuilder.append("&originalRequestId=");
            stringbuilder.append(d);
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void c(int i1)
    {
        z = i1;
    }

    public final String d()
    {
        return x;
    }

    public final void d(int i1)
    {
        r.seekTo(i1);
    }

    public final String e()
    {
        return k;
    }

    public final void f()
    {
        n();
    }

    public final void g()
    {
        p();
    }

    public final void h()
    {
        p();
    }

    public final void i()
    {
        n();
    }

    public final int j()
    {
        if (q != null)
        {
            Object obj = q;
            int j2 = r.getCurrentPosition();
            obj = ((L) (obj)).b.iterator();
            int j1 = 0;
            int i1 = 0;
            do
            {
                int k2;
                boolean flag;
label0:
                {
                    int l1 = i1;
                    if (((Iterator) (obj)).hasNext())
                    {
                        K k1 = (K)((Iterator) (obj)).next();
                        flag = k1 instanceof G;
                        k2 = k1.j;
                        if (j1 + k2 <= j2)
                        {
                            break label0;
                        }
                        l1 = i1;
                        if (!flag)
                        {
                            l1 = i1 + (j2 - j1);
                        }
                    }
                    return l1;
                }
                int i2 = i1;
                if (!flag)
                {
                    i2 = i1 + k2;
                }
                j1 = k2 + j1;
                i1 = i2;
            } while (true);
        } else
        {
            return -1;
        }
    }

    public final boolean k()
    {
        return t() && q != null && (q.b() instanceof G);
    }

    protected final void l()
    {
        this;
        JVM INSTR monitorenter ;
        if (!q.d) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = q.c;
        if (q.f > 0)
        {
            w = q.e;
        }
_L3:
        com.rhythmnewmedia.sdk.y.a("preparing: %s", new Object[] {
            obj
        });
        r.setVideoPath(((String) (obj)));
        requestLayout();
        invalidate();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
label0:
        {
            com.rhythmnewmedia.sdk.y.a(" - playing media #%d", new Object[] {
                Integer.valueOf(q.f)
            });
            obj = q.b();
            if (((K) (obj)).a() <= 0)
            {
                break label0;
            }
            obj = String.format("%s&start_index=%d&end_index=%d", new Object[] {
                q.c, Integer.valueOf(q.f), Integer.valueOf(q.f)
            });
        }
          goto _L3
        obj = ((K) (obj)).i;
          goto _L3
        Throwable throwable;
        throwable;
        com.rhythmnewmedia.sdk.y.b(throwable, "Unable to open movie: ", new Object[] {
            obj
        });
        u = b.a;
        D.sendMessage(D.obtainMessage(100, 1, -100));
          goto _L4
        Exception exception;
        exception;
        throw exception;
          goto _L3
    }

    public final void m()
    {
        f(4);
        A();
    }

    public final void n()
    {
        boolean flag;
        if (u != b.a && u != b.b && u != b.c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            r.start();
            u = b.d;
            F().b(r.isPlaying());
            D.sendEmptyMessageDelayed(1000, 500L);
            return;
        }
        y();
        f(2);
        g = false;
        u = b.c;
        if (f)
        {
            E();
            return;
        }
        D.sendMessage(D.obtainMessage(200));
        if (!D.hasMessages(5000))
        {
            D.sendEmptyMessageDelayed(5000, y);
        }
        m.b(this);
    }

    public final void o()
    {
        if (u == b.e)
        {
            n();
            return;
        } else
        {
            b();
            return;
        }
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        com.rhythmnewmedia.sdk.y.a("@@@@@@@@@@ onCompletion", new Object[0]);
        D();
    }

    public final boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        com.rhythmnewmedia.sdk.y.a("@@@@@@@@@@ onError: %d,%d", new Object[] {
            Integer.valueOf(i1), Integer.valueOf(j1)
        });
        u = b.a;
        D.sendMessage(D.obtainMessage(100, i1, j1));
        C();
        return true;
    }

    public final boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 != 4)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (F().getVisibility() != 0) goto _L2; else goto _L1
_L1:
        F().a(false);
_L4:
        return true;
_L2:
        if (t() && z > 0 && findViewById(1010) == null) goto _L4; else goto _L3
_L3:
        v = b.f;
        q();
        return super.onKeyDown(i1, keyevent);
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        com.rhythmnewmedia.sdk.y.a("@@@@@@@@@@ onPrepared", new Object[0]);
        f(8);
        D.sendMessage(D.obtainMessage(1));
        int i1 = w;
        if (i1 != 0)
        {
            r.seekTo(i1);
        }
        B b1 = F();
        i1 = mediaplayer.getDuration();
        ((SeekBar)b1.findViewById(450)).setMax(i1);
        if (u != b.f)
        {
            A();
        }
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
label0:
        {
            if (t() && motionevent.getAction() == 0)
            {
                view = F();
                if (view.getVisibility() != 8)
                {
                    if (view.getVisibility() != 4)
                    {
                        break label0;
                    }
                    motionevent = new AlphaAnimation(0.0F, 1.0F);
                    motionevent.setDuration(200L);
                    view.startAnimation(motionevent);
                    view.setVisibility(0);
                    view.a();
                    if (((B) (view)).a != null)
                    {
                        ((B) (view)).a.a(view);
                    }
                }
            }
            return false;
        }
        view.a(false);
        return false;
    }

    public final void p()
    {
        if (r.isPlaying())
        {
            r.pause();
            u = b.e;
            F().b(r.isPlaying());
            if (s() >= 100)
            {
                D.removeMessages(1000);
            }
        }
    }

    public final void q()
    {
        if (t())
        {
            v = b.f;
        }
        D();
    }

    protected final void r()
    {
        B b1 = F();
        if (b1.getVisibility() == 0)
        {
            b1.a(r.getCurrentPosition(), s());
        }
        if (!q.d) goto _L2; else goto _L1
_L1:
        L l1;
        int i1;
        int j1;
        int k1;
        l1 = q;
        k1 = r.getCurrentPosition();
        i1 = 0;
        j1 = 0;
_L5:
        if (i1 >= l1.b.size())
        {
            break MISSING_BLOCK_LABEL_150;
        }
        j1 += ((K)l1.b.get(i1)).j;
        if (j1 < k1) goto _L4; else goto _L3
_L3:
        if (i1 != q.f)
        {
            a(q.f, i1);
            if (i1 >= 0)
            {
                q.f = i1;
            }
        }
_L2:
        D.sendEmptyMessageDelayed(1000, 500L);
        return;
_L4:
        i1++;
          goto _L5
        i1 = l1.b.size() - 1;
          goto _L3
    }

    public final void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
    }

    public final void surfaceCreated(SurfaceHolder surfaceholder)
    {
        com.rhythmnewmedia.sdk.y.a("@@@@@@@@@@ surface created", new Object[0]);
        f(1);
        A();
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        com.rhythmnewmedia.sdk.y.a("@@@@@@@@@@ surface destroyed", new Object[0]);
        q();
    }

    static 
    {
        com.rhythmnewmedia.sdk.y.a(" ", new Object[0]);
        com.rhythmnewmedia.sdk.y.a(" ", new Object[0]);
        com.rhythmnewmedia.sdk.y.a("--------- RhythmSDK %s (%s %s)", new Object[] {
            "5.0.1", "50831", "09/28/2011 04:45 PM"
        });
    }

    // Unreferenced inner class com/rhythmnewmedia/sdk/F
    final class F
        implements Runnable
    {

        final E a;

        public final void run()
        {
            E.a(a);
        }

            F()
            {
                a = E.this;
                super();
            }
    }

}
