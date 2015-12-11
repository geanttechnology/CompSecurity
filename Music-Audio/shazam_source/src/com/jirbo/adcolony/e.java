// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import com.immersion.hapticmediasdk.a;
import com.immersion.hapticmediasdk.b;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.jirbo.adcolony:
//            q, n, k, g, 
//            ad, v, c, AdColonyBrowser, 
//            at, f

public abstract class e extends Activity
{
    final class a extends View
    {

        Rect a;
        final e b;

        public final void onDraw(Canvas canvas)
        {
            canvas.drawARGB(255, 0, 0, 0);
            getDrawingRect(a);
            b.O.a(canvas, (a.width() - b.O.f) / 2, (a.height() - b.O.g) / 2);
            invalidate();
        }

        public a(Activity activity)
        {
            b = e.this;
            super(activity);
            a = new Rect();
        }
    }


    static int a;
    static int b;
    static int c;
    static boolean d;
    static boolean e;
    static boolean f;
    static Activity g;
    static boolean h;
    static boolean i;
    boolean A;
    ad B;
    v C;
    g D;
    com.immersion.hapticmediasdk.a E;
    String F;
    boolean G;
    boolean H;
    String I;
    VideoView J;
    FrameLayout K;
    FrameLayout L;
    FrameLayout M;
    Rect N;
    c O;
    a P;
    FileInputStream Q;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    double o;
    double p;
    long q;
    long r;
    int s;
    int t;
    int u;
    int v;
    int w;
    String x;
    String y;
    boolean z;

    public e()
    {
        x = "";
        y = "";
        z = true;
        A = true;
        H = true;
        I = "Your purchase will begin shortly!";
        N = new Rect();
    }

    static void a()
    {
        a = 0;
        d = false;
        e = false;
        f = false;
    }

    final boolean b()
    {
        boolean flag = false;
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        s = displaymetrics.widthPixels;
        t = displaymetrics.heightPixels;
        s = displaymetrics.widthPixels;
        t = displaymetrics.heightPixels;
        w = 0xff000000;
        getWindow().setBackgroundDrawable(new ColorDrawable(w));
        int i1 = s;
        int j1 = t;
        u = i1;
        v = j1;
        if (!q.d && u < v)
        {
            s = j1;
            t = i1;
            u = j1;
            v = i1;
        }
        if (q.s)
        {
            q.s = false;
            flag = true;
        }
        return flag;
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag;
        flag = true;
        q.R = false;
        super.onCreate(bundle);
        G = com.jirbo.adcolony.q.f("haptics_enabled");
        F = com.jirbo.adcolony.q.g("haptics_filepath");
        I = com.jirbo.adcolony.q.g("in_progress");
        y = com.jirbo.adcolony.q.g("video_filepath");
        boolean flag1;
        if (G)
        {
            int i1;
            try
            {
                E = com.immersion.hapticmediasdk.b.a(this);
                E.a(F);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
                G = false;
            }
            if (E == null)
            {
                G = false;
            }
        }
        g = this;
        if (!com.jirbo.adcolony.q.f("video_enabled"))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        q.H = flag1;
        if (!com.jirbo.adcolony.q.f("end_card_enabled"))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        q.G = flag1;
        q.I = com.jirbo.adcolony.q.f("load_timeout_enabled");
        q.J = com.jirbo.adcolony.q.e("load_timeout");
        for (i1 = 0; i1 < q.X.size(); i1++)
        {
            if (q.X.get(i1) != null)
            {
                bundle = (n)q.X.get(i1);
                if (((n) (bundle)).S != null)
                {
                    ((n) (bundle)).J.setVisibility(4);
                }
                if (((n) (bundle)).H != null)
                {
                    ((n) (bundle)).H.setVisibility(4);
                }
            }
        }

        D = q.A;
        if (D == null)
        {
            finish();
            return;
        }
        if (com.jirbo.adcolony.q.f("v4iap_enabled"))
        {
            D.p = com.jirbo.adcolony.k.b;
            D.o = true;
            D.h = com.jirbo.adcolony.q.g("product_id");
        }
        e = D.n;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (q.d) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            setRequestedOrientation(6);
        } else
        {
            setRequestedOrientation(0);
        }
_L8:
        setVolumeControlStream(3);
        B = new ad(this);
        K = new FrameLayout(this);
        C = new v(this);
        M = new FrameLayout(this);
        P = new a(this);
        O = new c(com.jirbo.adcolony.q.g("browser_icon"));
        AdColonyBrowser.B = false;
        q.B = this;
        q.C = this;
        return;
_L2:
        int j1;
        int k1;
        k1 = getResources().getConfiguration().orientation;
        if (k1 == 0 || k1 == 6 || k1 == 2)
        {
            j1 = 6;
        } else
        {
            j1 = 7;
        }
        q.n = j1;
        if (android.os.Build.VERSION.SDK_INT >= 10 && !Build.MODEL.equals("Kindle Fire"))
        {
            setRequestedOrientation(q.n);
            continue; /* Loop/switch isn't completed */
        }
        if (!Build.MODEL.equals("Kindle Fire"))
        {
            break MISSING_BLOCK_LABEL_606;
        }
        getRequestedOrientation();
        j1 = ((flag) ? 1 : 0);
        ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 2: default 580
    //                   0 583
    //                   1 595
    //                   2 600;
           goto _L3 _L4 _L5 _L6
_L5:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        j1 = 8;
_L9:
        q.n = j1;
        setRequestedOrientation(j1);
        if (true) goto _L8; else goto _L7
_L7:
        j1 = 0;
          goto _L9
_L6:
        j1 = 9;
          goto _L9
        j1 = k1;
          goto _L9
    }

    public void onDestroy()
    {
        super.onDestroy();
        boolean flag = q.R;
        q.m = true;
        q.B = null;
        q.R = true;
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (com.jirbo.adcolony.at.b != null && com.jirbo.adcolony.at.b.onKeyDown(i1, keyevent))
        {
            return true;
        }
        if (i1 != 4) goto _L2; else goto _L1
_L1:
        if (!d) goto _L4; else goto _L3
_L3:
        if (!f) goto _L6; else goto _L5
_L5:
        J.stopPlayback();
        f = false;
        M.removeAllViews();
        setContentView(K);
_L7:
        return true;
_L6:
        if (C != null && C.t == 0)
        {
            q.R = true;
            C.c();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (C != null && com.jirbo.adcolony.at.b != null)
        {
            c c1;
            for (keyevent = com.jirbo.adcolony.at.b.q.iterator(); keyevent.hasNext(); c1.n.clear())
            {
                c1 = (c)keyevent.next();
                for (Iterator iterator = c1.n.iterator(); iterator.hasNext(); ((Bitmap)iterator.next()).recycle()) { }
            }

            com.jirbo.adcolony.at.b = null;
            com.jirbo.adcolony.at.a = false;
            B.start();
        } else
        if (C != null && C.L && C.N)
        {
            q.R = true;
            C.b(false);
        }
        if (true) goto _L7; else goto _L2
_L2:
        if (i1 == 82)
        {
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    public void onPause()
    {
        h = false;
        if (f)
        {
            if (J != null)
            {
                b = J.getCurrentPosition();
                J.stopPlayback();
            }
        } else
        {
            b = 0;
        }
        if (d)
        {
            View view = new View(this);
            view.setBackgroundColor(0xff000000);
            setContentView(view);
            r = System.currentTimeMillis();
            if (!isFinishing())
            {
                p = p + (double)(r - q) / 1000D;
            }
        }
        if (B != null)
        {
            if (B.getCurrentPosition() != 0)
            {
                a = B.getCurrentPosition();
            }
            B.a();
            B.setBackgroundColor(0xff000000);
            if (G)
            {
                E.e();
            }
        } else
        {
            a = 0;
        }
        C.A = true;
        C.I = false;
        C.H = false;
        C.J = false;
        C.u = 0;
        C.t = 0;
        C.invalidate();
        super.onPause();
        com.jirbo.adcolony.f.a();
    }

    public void onResume()
    {
        h = true;
        super.onResume();
        com.jirbo.adcolony.f.a(this);
        if (com.jirbo.adcolony.q.a())
        {
            finish();
        }
        b();
        if (z)
        {
            z = false;
            if (!d)
            {
                if (C.P)
                {
                    L.addView(C.a);
                }
                if (C.P)
                {
                    L.setVisibility(4);
                }
                if (Build.MODEL.equals("Kindle Fire"))
                {
                    C.m = 20;
                }
                if (Build.MODEL.equals("SCH-I800"))
                {
                    C.m = 25;
                }
                K.addView(B, new android.widget.FrameLayout.LayoutParams(u, v, 17));
                if (C.P)
                {
                    K.addView(L, new android.widget.FrameLayout.LayoutParams(s, t - C.m, 17));
                }
                K.addView(C, new android.widget.FrameLayout.LayoutParams(s, t, 17));
            }
        }
        if (!f) goto _L2; else goto _L1
_L1:
        M.removeView(P);
        M.addView(P);
        setContentView(M);
_L4:
        B.n = C;
        B.q = C;
        try
        {
            Q = new FileInputStream(y);
            ad ad1 = B;
            ad1.c = Q.getFD();
            ad1.r = 0;
            ad1.c();
            ad1.requestLayout();
            ad1.invalidate();
        }
        catch (IOException ioexception)
        {
            com.jirbo.adcolony.q.d((new StringBuilder("Unable to play video: ")).append(com.jirbo.adcolony.q.g("video_filepath")).toString());
            finish();
            return;
        }
        if (!i)
        {
            onWindowFocusChanged(true);
        }
        if (q.H)
        {
            C.a();
            C.b();
        }
        return;
_L2:
        setContentView(K);
        if (d)
        {
            q = System.currentTimeMillis();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onWindowFocusChanged(boolean flag)
    {
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        i = false;
        if (d || !h) goto _L2; else goto _L1
_L1:
        if (B != null)
        {
            if (c != 0)
            {
                a = c;
            }
            c = 0;
            B.seekTo(a);
            if (q.d)
            {
                Handler handler = new Handler();
                Runnable runnable = new Runnable() {

                    final e a;

                    public final void run()
                    {
                        a.B.setBackgroundColor(0);
                    }

            
            {
                a = e.this;
                super();
            }
                };
                B.setBackgroundColor(0xff000000);
                handler.postDelayed(runnable, 900L);
            } else
            {
                B.setBackgroundColor(0);
            }
            if (!com.jirbo.adcolony.at.a)
            {
                C.Q = false;
                B.start();
                if (G)
                {
                    if (H)
                    {
                        E.c();
                    } else
                    {
                        E.d();
                    }
                    H = false;
                }
            }
            C.requestFocus();
            C.invalidate();
        }
_L4:
        return;
_L2:
        if (f)
        {
            if (J != null)
            {
                J.seekTo(b);
                J.start();
                return;
            }
            if (M != null)
            {
                M.removeAllViews();
            }
            setContentView(K);
            return;
        }
        if (!d) goto _L4; else goto _L3
_L3:
        C.invalidate();
        return;
        if (h)
        {
            if (G)
            {
                E.e();
            }
            a = B.getCurrentPosition();
            B.pause();
        }
        i = true;
        return;
    }

    // Unreferenced inner class com/jirbo/adcolony/e$2

/* anonymous class */
    final class _cls2
        implements android.media.MediaPlayer.OnCompletionListener
    {

        final e a;

        public final void onCompletion(MediaPlayer mediaplayer)
        {
            a.setContentView(a.K);
            a.M.removeAllViews();
            e.f = false;
        }

            
            {
                a = e.this;
                super();
            }
    }


    // Unreferenced inner class com/jirbo/adcolony/e$3

/* anonymous class */
    final class _cls3
        implements android.media.MediaPlayer.OnPreparedListener
    {

        final e a;

        public final void onPrepared(MediaPlayer mediaplayer)
        {
            a.M.removeViewAt(1);
        }

            
            {
                a = e.this;
                super();
            }
    }

}
