// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.rhythmnewmedia.sdk.display.InterstitialAdView;
import com.rhythmnewmedia.sdk.video.RhythmVideoView;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            b, r, s, w, 
//            y, i, RhythmActivity, u, 
//            t

public final class q extends b
    implements d.b, com.rhythmnewmedia.sdk.display.InterstitialAdView.a
{

    private InterstitialAdView k;
    private boolean l;
    private Runnable m;
    private Runnable n;
    private final Handler o = new Handler();

    public q(Activity activity, String s1, String s2)
    {
        super(activity, s1, s2);
        m = new r(this);
        n = new s(this);
    }

    static void a(q q1)
    {
        q1.l = true;
        q1.h();
    }

    private u g()
    {
        if (k != null)
        {
            return k.currentAdResponse;
        } else
        {
            return null;
        }
    }

    private void h()
    {
        if (!k.pinned && l)
        {
            c();
        }
    }

    private void i()
    {
        this;
        JVM INSTR monitorenter ;
        if (findViewById(2000) != null)
        {
            c.removeView(findViewById(2000));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(Intent intent)
    {
        Object aobj[] = w.a(intent.getStringExtra("ipckey"));
        if (aobj == null || aobj.length < 2)
        {
            y.b("interstitial takeover expected 2 parameters", new Object[0]);
            return;
        }
        k = (InterstitialAdView)aobj[0];
        d = (WebView)aobj[1];
        k.setClickListener(this);
        k.setInterstitialListener(this);
        d.requestFocus();
        d.getSettings().setBuiltInZoomControls(true);
        k.getLayoutParams().width = -1;
        k.getLayoutParams().height = -1;
        d.getLayoutParams().width = -1;
        d.getLayoutParams().height = -1;
        int j = intent.getIntExtra("backgroundColor", 0);
        setBackgroundColor(j);
        c.setBackgroundColor(j);
        d.setBackgroundColor(j);
        if (k.getParent() != null)
        {
            y.b("interstitial takeover already has a parent view", new Object[0]);
            return;
        } else
        {
            c.addView(k);
            return;
        }
    }

    public final void a(i j)
    {
        static final class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[d.a.values().length];
                try
                {
                    a[d.a.g.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[d.a.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[d.a.s.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3.a[j.a.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 111
    //                   2 118
    //                   3 125;
           goto _L1 _L2 _L3 _L4
_L1:
        if (!j.d || !j.b || j.a == d.a.s) goto _L6; else goto _L5
_L5:
        k.unpin();
        ((RhythmActivity)b).setExitTransition(f.a.b);
        o.removeCallbacks(m);
        o.postDelayed(new Runnable() {

            final q a;

            public final void run()
            {
                a.c();
            }

            
            {
                a = q.this;
                super();
            }
        }, 500L);
_L8:
        return;
_L2:
        h();
        continue; /* Loop/switch isn't completed */
_L3:
        c();
        continue; /* Loop/switch isn't completed */
_L4:
        RhythmVideoView rhythmvideoview = (RhythmVideoView)j.e;
        if (rhythmvideoview != null && !rhythmvideoview.isFullscreen() && k.currentAdResponse.g() == u.b)
        {
            o.removeCallbacks(n);
            o.postDelayed(n, u.c);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (!j.a.b()) goto _L8; else goto _L7
_L7:
        k.pin();
        return;
        if (true) goto _L1; else goto _L9
_L9:
    }

    protected final boolean a()
    {
        return false;
    }

    public final void a_()
    {
        o.removeCallbacks(n);
        i();
    }

    public final void b()
    {
        u u1 = g();
        if (u1 == null) goto _L2; else goto _L1
_L1:
        int j;
        int i1 = u1.g();
        j = i1;
        if (i1 == u.b)
        {
            if (u1.i() == u.a.c)
            {
                j = u.c;
                u1.b(j);
            } else
            {
                j = u.d;
            }
        }
        if (j != 0) goto _L4; else goto _L3
_L3:
        f();
_L6:
        o.postDelayed(m, u1.f());
        l = false;
        if (u1.i() == u.a.c)
        {
            k.pin();
        }
_L2:
        return;
_L4:
        if (j > 0)
        {
            o.postDelayed(n, j);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void b(i j)
    {
        if (j.d && j.b)
        {
            k.unpin();
            ((RhythmActivity)b).setExitTransition(f.a.b);
            o.removeCallbacks(m);
            c();
            return;
        } else
        {
            f();
            return;
        }
    }

    protected final void c()
    {
        o.removeCallbacks(m);
        o.removeCallbacks(n);
        super.c();
    }

    final void f()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (findViewById(2000) != null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        obj = BitmapFactory.decodeByteArray(t.a, 0, t.a.length);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        ImageButton imagebutton = new ImageButton(getContext());
        imagebutton.setPadding(10, 10, 10, 10);
        imagebutton.setBackgroundColor(0);
        ((Bitmap) (obj)).setDensity(160);
        imagebutton.setImageBitmap(((Bitmap) (obj)));
        imagebutton.setOnClickListener(new android.view.View.OnClickListener() {

            final q a;

            public final void onClick(View view)
            {
                a.c();
            }

            
            {
                a = q.this;
                super();
            }
        });
        obj = new android.widget.FrameLayout.LayoutParams(-2, -2);
        obj.gravity = 51;
        imagebutton.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        imagebutton.setId(2000);
        c.addView(imagebutton);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean onKeyDown(int j, KeyEvent keyevent)
    {
        if (j == 4 && g() != null && g().g() > 0 && findViewById(2000) != null && findViewById(2000).getVisibility() != 0)
        {
            return true;
        } else
        {
            return super.onKeyDown(j, keyevent);
        }
    }

    // Unreferenced inner class com/rhythmnewmedia/sdk/r
    final class r
        implements Runnable
    {

        final q a;

        public final void run()
        {
            q.a(a);
        }

            r()
            {
                a = q.this;
                super();
            }
    }


    // Unreferenced inner class com/rhythmnewmedia/sdk/s
    final class s
        implements Runnable
    {

        final q a;

        public final void run()
        {
            a.f();
        }

            s()
            {
                a = q.this;
                super();
            }
    }

}
