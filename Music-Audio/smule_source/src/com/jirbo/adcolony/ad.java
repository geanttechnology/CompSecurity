// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            z, m, h, ak, 
//            be, db, aa, bd, 
//            bo, ci, bq, bp, 
//            af, ae, ab, q, 
//            ay, bl, cx, o, 
//            AdColonyOverlay, cz, AdColonyFullscreen, ac

public class ad extends FrameLayout
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{

    boolean A;
    boolean B;
    aa C;
    ab D;
    ac E;
    m F;
    m G;
    m H;
    ImageView I;
    af J;
    View K;
    Bitmap L;
    m M;
    ImageView N;
    boolean O;
    Button P;
    String Q;
    String R;
    String S;
    MediaPlayer T;
    Surface U;
    String V;
    String W;
    Activity a;
    String aa;
    String ab;
    String ac;
    String ad;
    String ae;
    String af;
    z ag;
    int ah;
    int ai;
    int aj;
    int ak;
    int al;
    int am;
    int an;
    int ao;
    bq ap;
    float aq;
    float ar;
    float as;
    boolean at;
    boolean au;
    android.widget.FrameLayout.LayoutParams av;
    android.widget.FrameLayout.LayoutParams aw;
    FileInputStream ax;
    String b;
    String c;
    ViewGroup d;
    SurfaceTexture e;
    int f;
    int g;
    int h;
    int i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;

    ad(Activity activity, String s1, int i1, boolean flag)
    {
        super(activity);
        v = true;
        x = true;
        O = false;
        Q = "";
        R = "";
        S = "";
        af = "";
        ag = z.a;
        ak = -1;
        am = 0xffcccccc;
        an = 0xff000000;
        aq = 0.25F;
        ar = 0.25F;
        y = flag;
        a(activity, s1, i1);
        a();
    }

    void a()
    {
        a(true);
    }

    void a(float f1, boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ar = f1;
        if (T == null || (double)f1 < 0.0D || (double)f1 > 1.0D)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!r)
        {
            T.setVolume(f1, f1);
        }
        if (!t) goto _L1; else goto _L3
_L3:
        if (L == H.a && (double)f1 > 0.0D && !r)
        {
            h h1 = new h();
            h1.b("user_action", flag);
            I.setImageBitmap(G.a);
            L = G.a;
            ak.c.d.a("sound_unmute", h1, C);
            m = true;
            return;
        }
        if (L != G.a || (double)f1 != 0.0D) goto _L1; else goto _L4
_L4:
        h h2 = new h();
        h2.b("user_action", flag);
        I.setImageBitmap(H.a);
        L = H.a;
        ak.c.d.a("sound_mute", h2, C);
        m = false;
        return;
        if ((double)f1 < 0.0D || (double)f1 > 1.0D) goto _L1; else goto _L5
_L5:
        aq = f1;
        return;
    }

    void a(Activity activity, String s1, int i1)
    {
        a(activity, s1, i1, 0);
    }

    void a(Activity activity, String s1, int i1, int j1)
    {
        com.jirbo.adcolony.ak.e();
        if (!y)
        {
            ak.X.add(this);
        }
        ak.T = 0;
        a = activity;
        b = s1;
        aj = i1;
        h = i1;
        if (j1 != 0)
        {
            i = j1;
            ak = j1;
            k = true;
        }
        m = true;
        as = com.jirbo.adcolony.ak.b().getResources().getDisplayMetrics().density;
        activity = com.jirbo.adcolony.ak.b().getWindowManager().getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            Point point = new Point();
            activity.getSize(point);
            i1 = point.x;
            j1 = point.y;
        } else
        {
            i1 = activity.getWidth();
            j1 = activity.getHeight();
        }
        if (i1 >= j1)
        {
            i1 = j1;
        }
        ao = i1;
        C = new aa(s1);
        C.e = "native";
        C.f = "native";
        ak.c.d.a(s1, C);
        setBackgroundColor(0xff000000);
    }

    void a(boolean flag)
    {
        t = false;
        l = false;
        setWillNotDraw(false);
        C.s = this;
        if (!v)
        {
            break MISSING_BLOCK_LABEL_1359;
        }
        if (ak.c != null && ak.c.a != null && C != null && C.b != null && ak.c.a(C.b, true, false))
        {
            ak.c.a.b(b);
        } else
        {
            p = true;
        }
        C.b(true);
        ap = C.c;
        c = com.jirbo.adcolony.ak.g("video_filepath");
        V = com.jirbo.adcolony.ak.g("advertiser_name");
        W = com.jirbo.adcolony.ak.g("description");
        aa = com.jirbo.adcolony.ak.g("title");
        ab = com.jirbo.adcolony.ak.g("poster_image");
        ac = com.jirbo.adcolony.ak.g("unmute");
        ad = com.jirbo.adcolony.ak.g("mute");
        ae = com.jirbo.adcolony.ak.g("thumb_image");
        O = com.jirbo.adcolony.ak.f("native_engagement_enabled");
        Q = com.jirbo.adcolony.ak.g("native_engagement_label");
        R = com.jirbo.adcolony.ak.g("native_engagement_command");
        S = com.jirbo.adcolony.ak.g("native_engagement_type");
        B = com.jirbo.adcolony.ak.f("v4iap_enabled");
        if (B)
        {
            ag = z.b;
        }
        af = com.jirbo.adcolony.ak.g("product_id");
        if (C.d != null && C.d.v != null)
        {
            s = C.d.v.b;
        } else
        {
            s = true;
        }
        if (ap != null)
        {
            ap.j();
        }
        if (C.d != null && C.d.v != null && C.d.v.a && C.c != null) goto _L2; else goto _L1
_L1:
        ak.T = 13;
_L4:
        return;
_L2:
        n = true;
        if (y) goto _L4; else goto _L3
_L3:
        if (v)
        {
            ah = C.d.u.b;
            ai = C.d.u.c;
            if (ak == -1)
            {
                ak = (int)((double)ai * ((double)aj / (double)ah));
                i = ak;
            }
            if (!flag && O)
            {
                ak = ak - ak / 6;
            }
            float f1 = (float)aj / (float)ah;
            float f2 = (float)ak / (float)ai;
            float f3 = (float)ah / (float)ai;
            android.widget.FrameLayout.LayoutParams layoutparams;
            if (f1 > f2)
            {
                au = true;
                aj = (int)((float)ak * f3);
            } else
            {
                at = true;
                ak = (int)((float)aj / f3);
            }
            aw = new android.widget.FrameLayout.LayoutParams(aj, ak, 48);
            av = new android.widget.FrameLayout.LayoutParams(h, i, 48);
            if (O && !flag && at)
            {
                aw.setMargins(0, (i - ak) / 2 - ak / 10, 0, 0);
                av.setMargins(0, (i - ak) / 2 - ak / 10, 0, ((i - ak) / 2 - ak / 10) * -1);
            } else
            if (!flag && at)
            {
                aw.setMargins(0, (i - ak) / 2, 0, 0);
                av.setMargins(0, (i - ak) / 2, 0, ((i - ak) / 2) * -1);
            } else
            if (O && !flag && au)
            {
                aw.setMargins((h - aj) / 2, 0, 0, 0);
                av.setMargins((h - aj) / 2, 0, ((h - aj) / 2) * -1, 0);
            } else
            if (!flag && au)
            {
                aw.setMargins((h - aj) / 2, 0, 0, 0);
                av.setMargins((h - aj) / 2, 0, ((h - aj) / 2) * -1, 0);
            }
            F = new m(ab, true, false);
            if (1.0F / ((float)F.f / (float)aj) > 1.0F / ((float)F.g / (float)ak))
            {
                f1 = 1.0F / ((float)F.g / (float)ak);
            } else
            {
                f1 = 1.0F / ((float)F.f / (float)aj);
            }
            F.a(f1, true);
            v = false;
        }
        if (O)
        {
            P = new Button(com.jirbo.adcolony.ak.b());
            P.setText(Q);
            P.setGravity(17);
            P.setTextSize((int)(18D * ((double)aj / (double)ao)));
            P.setPadding(0, 0, 0, 0);
            P.setBackgroundColor(am);
            P.setTextColor(an);
            P.setOnTouchListener(new android.view.View.OnTouchListener() {

                final ad a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    int i1 = motionevent.getAction();
                    if (i1 == 0)
                    {
                        view = new float[3];
                        Color.colorToHSV(a.am, view);
                        view[2] = view[2] * 0.8F;
                        a.P.setBackgroundColor(Color.HSVToColor(view));
                    } else
                    {
                        if (i1 == 3)
                        {
                            a.P.setBackgroundColor(a.am);
                            return true;
                        }
                        if (i1 == 1)
                        {
                            if (a.B)
                            {
                                a.ag = z.c;
                                a.p = true;
                                return true;
                            }
                            if (a.S.equals("install") || a.S.equals("url"))
                            {
                                ak.c.d.b("native_overlay_click", a.C);
                                try
                                {
                                    view = new Intent("android.intent.action.VIEW", Uri.parse(a.R));
                                    com.jirbo.adcolony.ak.b().startActivity(view);
                                }
                                // Misplaced declaration of an exception variable
                                catch (View view)
                                {
                                    Toast.makeText(com.jirbo.adcolony.ak.b(), "Unable to open store.", 0).show();
                                }
                            }
                            a.P.setBackgroundColor(a.am);
                            return true;
                        }
                    }
                    return true;
                }

            
            {
                a = ad.this;
                super();
            }
            });
        }
        H = new m(ac, true, false);
        G = new m(ad, true, false);
        M = new m(ae, true, false);
        M.a(1.0F / (float)((double)((float)M.f / (float)aj) / ((double)aj / 5.5D / (double)(float)aj)), true);
        G.a(as / 2.0F, true);
        H.a(as / 2.0F, true);
        J = new af(this, com.jirbo.adcolony.ak.b());
        N = new ImageView(com.jirbo.adcolony.ak.b());
        I = new ImageView(com.jirbo.adcolony.ak.b());
        N.setImageBitmap(M.a);
        if (m)
        {
            I.setImageBitmap(G.a);
        } else
        {
            I.setImageBitmap(H.a);
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams(G.f, G.g, 48);
        layoutparams.setMargins(h - G.f, 0, 0, 0);
        I.setOnClickListener(new android.view.View.OnClickListener() {

            final ad a;

            public void onClick(View view)
            {
                if (a.m)
                {
                    if (a.E != null)
                    {
                        a.E.a(a, true);
                    }
                    a.a(true, true);
                    a.r = true;
                } else
                if (a.L == a.H.a)
                {
                    if (a.E != null)
                    {
                        a.E.a(a, false);
                    }
                    a.r = false;
                    a.a(false, true);
                    return;
                }
            }

            
            {
                a = ad.this;
                super();
            }
        });
        L = G.a;
        if (p)
        {
            I.setVisibility(8);
        }
        if (q)
        {
            I.setVisibility(4);
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            K = new ae(this, com.jirbo.adcolony.ak.b(), p);
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            addView(K, aw);
        }
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            p = true;
        }
        addView(J, av);
        if (s && android.os.Build.VERSION.SDK_INT >= 14 && x)
        {
            addView(I, layoutparams);
        }
        if (!O) goto _L4; else goto _L5
_L5:
        android.widget.FrameLayout.LayoutParams layoutparams1;
        if (flag)
        {
            layoutparams1 = new android.widget.FrameLayout.LayoutParams(h, i / 5, 80);
        } else
        {
            layoutparams1 = new android.widget.FrameLayout.LayoutParams(h, ak / 5, 80);
        }
        addView(P, layoutparams1);
        return;
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            return;
        }
          goto _L3
    }

    void a(boolean flag, boolean flag1)
    {
        if (flag)
        {
            I.setImageBitmap(H.a);
            m = false;
            a(0.0F, flag1);
            L = H.a;
        } else
        if (!r && L == H.a)
        {
            I.setImageBitmap(G.a);
            m = true;
            if (T != null)
            {
                if ((double)ar != 0.0D)
                {
                    a(ar, flag1);
                } else
                {
                    a(0.25F, flag1);
                }
            }
            L = G.a;
            return;
        }
    }

    void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!p && T != null && T.isPlaying()) goto _L2; else goto _L1
_L1:
        MediaPlayer mediaplayer = T;
        if (mediaplayer != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        setVolume(ar);
        T.start();
        ak.c.a(C);
        C.l = true;
        if (D != null)
        {
            D.a(false, this);
        }
        if (true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    boolean b(boolean flag)
    {
        return C.a(true) && com.jirbo.adcolony.q.d(b);
    }

    void c()
    {
        if (!p && T != null && T.isPlaying() && !q)
        {
            ak.c.d.b("video_paused", C);
            T.pause();
        }
    }

    void c(boolean flag)
    {
label0:
        {
            if (T != null && I != null)
            {
                if (!flag)
                {
                    break label0;
                }
                T.setVolume(0.0F, 0.0F);
                I.setImageBitmap(H.a);
                L = H.a;
            }
            return;
        }
        T.setVolume(ar, ar);
        I.setImageBitmap(G.a);
        L = G.a;
    }

    public ImageView getAdvertiserImage()
    {
        if (M == null)
        {
            M = new m(ae, true, false);
            M.a(as / 2.0F, true);
        }
        if (N == null)
        {
            N = new ImageView(com.jirbo.adcolony.ak.b());
            N.setImageBitmap(M.a);
        }
        return N;
    }

    public String getAdvertiserName()
    {
        return V;
    }

    public String getDescription()
    {
        return W;
    }

    public int getNativeAdHeight()
    {
        if (!k && O)
        {
            return i + i / 5;
        } else
        {
            return i;
        }
    }

    public int getNativeAdWidth()
    {
        return h;
    }

    public String getTitle()
    {
        return aa;
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        try
        {
            ax.close();
        }
        // Misplaced declaration of an exception variable
        catch (MediaPlayer mediaplayer) { }
        J.setVisibility(0);
        I.setVisibility(8);
        C.e = "native";
        C.f = "native";
        C.l = true;
        p = true;
        if (T != null)
        {
            T.release();
        }
        T = null;
        C.k = 0;
        mediaplayer = new h();
        mediaplayer.b("ad_slot", C.c.k.d);
        mediaplayer.b("replay", false);
        ak.c.d.a("native_complete", mediaplayer, C);
        if (D != null)
        {
            D.b(false, this);
        }
        w = true;
    }

    public void onDraw(Canvas canvas)
    {
        if (d != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Rect rect = new Rect();
        if (!d.hasFocus())
        {
            d.requestFocus();
        }
        if (!p && T != null)
        {
            al = T.getCurrentPosition();
        }
        if (al != 0)
        {
            C.k = al;
        }
        getLocalVisibleRect(rect);
        boolean flag;
        if (rect.bottom - rect.top > getNativeAdHeight() / 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((flag || j) && (!j || flag && (rect.bottom - rect.top >= getNativeAdHeight() || rect.top == 0)))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!p && T != null && T.isPlaying() && !q)
        {
            bl.c.b("[ADC] Scroll Pause");
            ak.c.d.b("video_paused", C);
            T.pause();
            J.setVisibility(0);
        }
_L4:
        if (!u && !p)
        {
            invalidate();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!p && T != null && T.isPlaying())
        {
            if (!t)
            {
                canvas.drawARGB(255, 0, 0, 0);
            } else
            {
                C.e = "native";
                C.f = "native";
                ak.c.a((double)T.getCurrentPosition() / (double)T.getDuration(), C);
                if (!z)
                {
                    z = true;
                    ak.c.a("native_start", (new StringBuilder()).append("{\"ad_slot\":").append(C.c.k.d).append(", \"replay\":false}").toString(), C);
                }
            }
        } else
        if (!J.a)
        {
            canvas.drawARGB(255, 0, 0, 0);
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        J.setVisibility(0);
        I.setVisibility(8);
        p = true;
        t = true;
        T = null;
        C.k = 0;
        return true;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        bl.c.b("[ADC] Native Ad onPrepared called.");
        t = true;
        if (L == null || G.a == null)
        {
            J.setVisibility(0);
            I.setVisibility(8);
            p = true;
            T = null;
            C.k = 0;
            return;
        }
        if (!m && L.equals(G.a))
        {
            c(true);
            return;
        } else
        {
            setVolume(ar);
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return false;
        }
        if (motionevent.getAction() == 1 && ak.m && cx.c())
        {
            ak.A = C;
            ak.c.a.a(b, C.d);
            com.jirbo.adcolony.o.a();
            C.n = w;
            C.m = true;
            C.e = "native";
            C.f = "fullscreen";
            ak.m = false;
            ak.c.d.b("video_expanded", C);
            if (D != null)
            {
                D.a(true, this);
            }
            if (ak.d)
            {
                bl.a.b("Launching AdColonyOverlay");
                com.jirbo.adcolony.ak.b().startActivity(new Intent(com.jirbo.adcolony.ak.b(), com/jirbo/adcolony/AdColonyOverlay));
            } else
            {
                bl.a.b("Launching AdColonyFullscreen");
                com.jirbo.adcolony.ak.b().startActivity(new Intent(com.jirbo.adcolony.ak.b(), com/jirbo/adcolony/AdColonyFullscreen));
            }
            if (p)
            {
                C.a = -1;
                motionevent = C.c.k;
                motionevent.d = ((ay) (motionevent)).d + 1;
                ak.c.a("start", (new StringBuilder()).append("{\"ad_slot\":").append(C.c.k.d).append(", \"replay\":").append(C.n).append("}").toString(), C);
                ak.c.h.a(C.b, C.d.d);
            }
            p = true;
            w = true;
        }
        return true;
    }

    public void setMuted(boolean flag)
    {
        a(flag, false);
    }

    public void setOverlayButtonColor(int i1)
    {
        if (O)
        {
            P.setBackgroundColor(i1);
        }
        am = i1;
    }

    public void setOverlayButtonTextColor(int i1)
    {
        if (O)
        {
            P.setTextColor(i1);
        }
        an = i1;
    }

    public void setVolume(float f1)
    {
        a(f1, false);
    }
}
