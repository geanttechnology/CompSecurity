// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
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
import android.widget.MediaController;
import android.widget.VideoView;
import com.immersion.hapticmediasdk.a;
import com.immersion.hapticmediasdk.c;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.jirbo.adcolony:
//            ak, ad, z, s, 
//            bf, au, p, m, 
//            AdColonyBrowser, de

public abstract class o extends Activity
{

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
    bf B;
    au C;
    s D;
    a E;
    String F;
    boolean G;
    boolean H;
    String I;
    VideoView J;
    FrameLayout K;
    FrameLayout L;
    FrameLayout M;
    Rect N;
    m O;
    p P;
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

    public o()
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

    void a(String s1)
    {
        x = s1;
        f = true;
        J = new VideoView(this);
        s1 = Uri.parse(s1);
        J.setVideoURI(s1);
        (new MediaController(this)).setMediaPlayer(J);
        J.setLayoutParams(new android.widget.FrameLayout.LayoutParams(s, t, 17));
        M.addView(J);
        M.addView(P);
        setContentView(M);
        J.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            final o a;

            public void onCompletion(MediaPlayer mediaplayer)
            {
                a.setContentView(a.K);
                a.M.removeAllViews();
                o.f = false;
            }

            
            {
                a = o.this;
                super();
            }
        });
        J.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {

            final o a;

            public void onPrepared(MediaPlayer mediaplayer)
            {
                a.M.removeViewAt(1);
            }

            
            {
                a = o.this;
                super();
            }
        });
        J.start();
    }

    boolean b()
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
        if (!ak.d && u < v)
        {
            s = j1;
            t = i1;
            u = j1;
            v = i1;
        }
        if (ak.s)
        {
            ak.s = false;
            flag = true;
        }
        return flag;
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag;
        flag = true;
        ak.R = false;
        super.onCreate(bundle);
        G = ak.f("haptics_enabled");
        F = ak.g("haptics_filepath");
        I = ak.g("in_progress");
        y = ak.g("video_filepath");
        boolean flag1;
        if (G)
        {
            int i1;
            try
            {
                E = com.immersion.hapticmediasdk.c.a(0, this);
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
        if (!ak.f("video_enabled"))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ak.H = flag1;
        if (!ak.f("end_card_enabled"))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ak.G = flag1;
        ak.I = ak.f("load_timeout_enabled");
        ak.J = ak.e("load_timeout");
        for (i1 = 0; i1 < ak.X.size(); i1++)
        {
            if (ak.X.get(i1) != null)
            {
                bundle = (ad)ak.X.get(i1);
                if (((ad) (bundle)).T != null)
                {
                    ((ad) (bundle)).K.setVisibility(4);
                }
                if (((ad) (bundle)).I != null)
                {
                    ((ad) (bundle)).I.setVisibility(4);
                }
            }
        }

        D = ak.A;
        if (D == null)
        {
            finish();
            return;
        }
        if (ak.f("v4iap_enabled"))
        {
            D.p = z.b;
            D.o = true;
            D.h = ak.g("product_id");
        }
        e = D.n;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (ak.d) goto _L2; else goto _L1
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
        B = new bf(this);
        K = new FrameLayout(this);
        C = new au(this);
        M = new FrameLayout(this);
        P = new p(this, this);
        O = new m(ak.g("browser_icon"));
        AdColonyBrowser.B = false;
        ak.B = this;
        ak.C = this;
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
        ak.n = j1;
        if (android.os.Build.VERSION.SDK_INT >= 10 && !Build.MODEL.equals("Kindle Fire"))
        {
            setRequestedOrientation(ak.n);
            continue; /* Loop/switch isn't completed */
        }
        if (!Build.MODEL.equals("Kindle Fire"))
        {
            break MISSING_BLOCK_LABEL_610;
        }
        getRequestedOrientation();
        j1 = ((flag) ? 1 : 0);
        ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 2: default 584
    //                   0 587
    //                   1 599
    //                   2 604;
           goto _L3 _L4 _L5 _L6
_L5:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        j1 = 8;
_L9:
        ak.n = j1;
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
        if (ak.R);
        ak.m = true;
        ak.B = null;
        ak.R = true;
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
        if (de.b != null && de.b.onKeyDown(i1, keyevent))
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
            ak.R = true;
            C.e();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (C != null && de.b != null)
        {
            for (keyevent = de.b.q.iterator(); keyevent.hasNext(); ((m)keyevent.next()).a()) { }
            de.b = null;
            com.jirbo.adcolony.de.a = false;
            B.start();
        } else
        if (C != null && C.L && C.N)
        {
            ak.R = true;
            C.f();
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
                E.g();
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
    }

    public void onResume()
    {
        h = true;
        super.onResume();
        if (com.jirbo.adcolony.ak.a())
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
        B.a(C);
        B.a(C);
        try
        {
            Q = new FileInputStream(y);
            B.a(Q.getFD());
        }
        catch (IOException ioexception)
        {
            ak.d((new StringBuilder()).append("Unable to play video: ").append(ak.g("video_filepath")).toString());
            finish();
            return;
        }
        if (!i)
        {
            onWindowFocusChanged(true);
        }
        if (ak.H)
        {
            C.a();
            C.c();
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
            if (ak.d)
            {
                Handler handler = new Handler();
                Runnable runnable = new Runnable() {

                    final o a;

                    public void run()
                    {
                        a.B.setBackgroundColor(0);
                    }

            
            {
                a = o.this;
                super();
            }
                };
                B.setBackgroundColor(0xff000000);
                handler.postDelayed(runnable, 900L);
            } else
            {
                B.setBackgroundColor(0);
            }
            if (!com.jirbo.adcolony.de.a)
            {
                C.Q = false;
                B.start();
                if (G)
                {
                    if (H)
                    {
                        E.d();
                    } else
                    {
                        E.f();
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
                E.g();
            }
            a = B.getCurrentPosition();
            B.pause();
        }
        i = true;
        return;
    }
}
