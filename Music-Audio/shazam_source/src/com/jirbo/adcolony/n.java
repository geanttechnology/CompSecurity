// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Context;
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
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            k, c, q, ac, 
//            ar, l, aa, aj, 
//            ab, x, ao, e, 
//            AdColonyOverlay, aq, AdColonyFullscreen

public final class n extends FrameLayout
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{
    final class a extends TextureView
        implements android.view.TextureView.SurfaceTextureListener
    {

        boolean a;
        boolean b;
        final n c;

        public final void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i1, int j1)
        {
            if (surfacetexture == null)
            {
                c.p = true;
                c.H.setVisibility(8);
            } else
            {
                c.I.setVisibility(0);
                c.e = surfacetexture;
                if (!c.p && !a)
                {
                    c.T = new Surface(surfacetexture);
                    if (c.S != null)
                    {
                        c.S.release();
                    }
                    c.f = i1;
                    c.g = j1;
                    c.S = new MediaPlayer();
                    try
                    {
                        c.aw = new FileInputStream(c.c);
                        c.S.setDataSource(c.aw.getFD());
                        c.S.setSurface(c.T);
                        c.S.setOnCompletionListener(c);
                        c.S.setOnPreparedListener(c);
                        c.S.setOnErrorListener(c);
                        c.S.prepareAsync();
                        aj.c.b("[ADC] Native Ad Prepare called.");
                        b = true;
                        surfacetexture = new Handler();
                        Runnable runnable = new Runnable(this) {

                            final a a;

                            public final void run()
                            {
                                if (!a.c.t && !a.c.u)
                                {
                                    a.b = false;
                                    a.c.p = true;
                                    a.c.H.setVisibility(8);
                                }
                            }

            
            {
                a = a1;
                super();
            }
                        };
                        if (!b)
                        {
                            surfacetexture.postDelayed(runnable, 1800L);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (SurfaceTexture surfacetexture)
                    {
                        c.p = true;
                        c.H.setVisibility(8);
                        return;
                    }
                }
            }
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
        {
            aj.c.b("[ADC] Native surface destroyed");
            c.t = false;
            c.H.setVisibility(4);
            c.I.setVisibility(0);
            return true;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i1, int j1)
        {
            aj.c.b("[ADC] onSurfaceTextureSizeChanged");
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
        {
        }

        public final boolean onTouchEvent(MotionEvent motionevent)
        {
            int i1 = motionevent.getAction();
            float f1 = motionevent.getX();
            float f2 = motionevent.getY();
            if (i1 == 1 && q.m && com.jirbo.adcolony.ao.c() && (f1 <= (float)((c.ai - c.F.f) + 8) || f2 >= (float)(c.F.g + 8) || c.p || c.S == null || !c.S.isPlaying()))
            {
                q.A = c.D;
                q.c.a.a(c.b, c.D.d);
                com.jirbo.adcolony.e.a();
                c.D.e = "native";
                c.D.f = "fullscreen";
                c.D.m = true;
                c.D.n = c.w;
                if ((c.t || c.p) && com.jirbo.adcolony.ao.c())
                {
                    if (c.S != null && c.S.isPlaying())
                    {
                        e.c = c.S.getCurrentPosition();
                        c.D.j = c.D.i;
                        c.S.pause();
                        c.p = true;
                    } else
                    {
                        c.D.j = 0.0D;
                        e.c = 0;
                    }
                    q.m = false;
                    q.c.d.a("video_expanded", null, c.D);
                    if (q.d)
                    {
                        aj.a.b("Launching AdColonyOverlay");
                        com.jirbo.adcolony.q.b().startActivity(new Intent(com.jirbo.adcolony.q.b(), com/jirbo/adcolony/AdColonyOverlay));
                    } else
                    {
                        aj.a.b("Launching AdColonyFullscreen");
                        com.jirbo.adcolony.q.b().startActivity(new Intent(com.jirbo.adcolony.q.b(), com/jirbo/adcolony/AdColonyFullscreen));
                    }
                    if (c.p)
                    {
                        motionevent = c.D.c.k;
                        motionevent.d = ((x) (motionevent)).d + 1;
                        q.c.a("start", (new StringBuilder("{\"ad_slot\":")).append(c.D.c.k.d).append(", \"replay\":").append(c.D.n).append("}").toString(), c.D);
                        q.c.h.a(c.D.b, c.D.d.d);
                    }
                    c.w = true;
                    return true;
                }
            }
            return true;
        }

        a(Context context, boolean flag)
        {
            c = n.this;
            super(context);
            a = false;
            b = false;
            setSurfaceTextureListener(this);
            setWillNotDraw(false);
            setBackgroundColor(0xff000000);
            a = flag;
        }
    }

    final class b extends View
    {

        boolean a;
        final n b;

        public final void onDraw(Canvas canvas)
        {
            b.d = (ViewGroup)getParent().getParent();
            Rect rect = new Rect();
            if (b.S != null && !b.S.isPlaying() && b.j)
            {
                a = false;
            }
            if (getLocalVisibleRect(rect) && android.os.Build.VERSION.SDK_INT >= 14 && b.t)
            {
                if ((!b.j || b.j && (rect.top == 0 || rect.bottom - rect.top > b.getNativeAdHeight())) && rect.bottom - rect.top > b.getNativeAdHeight() / 2)
                {
                    if (!a && !b.p && b.S != null && !b.S.isPlaying() && !b.u)
                    {
                        b.D.b();
                    }
                    if (!b.o)
                    {
                        aj.c.b("[ADC] Native Ad Starting");
                        b.c();
                        b.o = true;
                        b.D.e = "native";
                        b.D.f = "native";
                    } else
                    if (!b.q && b.S != null && com.jirbo.adcolony.ao.c() && !b.S.isPlaying() && !q.k)
                    {
                        aj.c.b("[ADC] Native Ad Resuming");
                        q.c.d.a("video_resumed", null, b.D);
                        if (!b.m)
                        {
                            b.b();
                        }
                        b.setVolume(b.aq);
                        b.S.seekTo(b.D.k);
                        b.S.start();
                    } else
                    if (!b.p && !b.o && !q.c.a(b.D.b, true, false))
                    {
                        b.p = true;
                        setVisibility(0);
                        b.H.setVisibility(8);
                    }
                }
                a = true;
            } else
            {
                a = false;
            }
            if (!b.p && !com.jirbo.adcolony.ao.c() && b.S != null && !b.S.isPlaying())
            {
                setVisibility(0);
                b.H.setVisibility(8);
                b.p = true;
            }
            if (!b.p && b.S != null && b.S.isPlaying())
            {
                setVisibility(4);
                b.H.setVisibility(0);
            } else
            if (b.p || b.q)
            {
                canvas.drawARGB(255, 0, 0, 0);
                b.H.setVisibility(8);
                b.E.a(canvas, (b.ai - b.E.f) / 2, (b.aj - b.E.g) / 2);
            }
            if (!b.u && !b.p)
            {
                invalidate();
            }
        }

        public b(Context context)
        {
            b = n.this;
            super(context);
            setBackgroundColor(0xff000000);
        }
    }


    boolean A;
    boolean B;
    boolean C;
    public l D;
    c E;
    c F;
    c G;
    ImageView H;
    b I;
    View J;
    Bitmap K;
    c L;
    ImageView M;
    public boolean N;
    Button O;
    String P;
    String Q;
    String R;
    public MediaPlayer S;
    public Surface T;
    String U;
    String V;
    String W;
    Activity a;
    String aa;
    String ab;
    String ac;
    String ad;
    String ae;
    k af;
    int ag;
    int ah;
    int ai;
    int aj;
    int ak;
    int al;
    int am;
    int an;
    al.c ao;
    float ap;
    float aq;
    float ar;
    boolean as;
    boolean at;
    android.widget.FrameLayout.LayoutParams au;
    android.widget.FrameLayout.LayoutParams av;
    FileInputStream aw;
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
    public boolean n;
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
    public boolean y;
    boolean z;

    n(Activity activity, String s1)
    {
        super(activity);
        v = true;
        x = true;
        N = false;
        P = "";
        Q = "";
        R = "";
        ae = "";
        af = k.a;
        aj = -1;
        al = 0xffcccccc;
        am = 0xff000000;
        ap = 0.25F;
        aq = 0.25F;
        z = true;
        a(activity, s1, 300);
        a();
    }

    public n(Activity activity, String s1, int i1)
    {
        super(activity);
        v = true;
        x = true;
        N = false;
        P = "";
        Q = "";
        R = "";
        ae = "";
        af = k.a;
        aj = -1;
        al = 0xffcccccc;
        am = 0xff000000;
        ap = 0.25F;
        aq = 0.25F;
        a(activity, s1, i1);
        a();
    }

    private void a(float f1, boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14) goto _L2; else goto _L1
_L1:
        return;
_L2:
        aq = f1;
        if (S == null || (double)f1 < 0.0D || (double)f1 > 1.0D)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!r)
        {
            S.setVolume(f1, f1);
        }
        if (!t) goto _L1; else goto _L3
_L3:
        if (K == G.a && (double)f1 > 0.0D && !r)
        {
            a.g g1 = new a.g();
            g1.b("user_action", flag);
            H.setImageBitmap(F.a);
            K = F.a;
            q.c.d.a("sound_unmute", g1, D);
            m = true;
            return;
        }
        if (K != F.a || (double)f1 != 0.0D) goto _L1; else goto _L4
_L4:
        a.g g2 = new a.g();
        g2.b("user_action", flag);
        H.setImageBitmap(G.a);
        K = G.a;
        q.c.d.a("sound_mute", g2, D);
        m = false;
        return;
        if ((double)f1 < 0.0D || (double)f1 > 1.0D) goto _L1; else goto _L5
_L5:
        ap = f1;
        return;
    }

    private void a(Activity activity, String s1, int i1)
    {
        l l1;
        com.jirbo.adcolony.q.e();
        if (!z)
        {
            q.X.add(this);
        }
        q.T = 0;
        a = activity;
        b = s1;
        ai = i1;
        h = i1;
        m = true;
        ar = com.jirbo.adcolony.q.b().getResources().getDisplayMetrics().density;
        activity = com.jirbo.adcolony.q.b().getWindowManager().getDefaultDisplay();
        int j1;
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
        an = i1;
        D = new l(s1);
        D.e = "native";
        D.f = "native";
        activity = q.c.d;
        l1 = D;
        if (((ar) (activity)).a != null && ((ar) (activity)).a.b != null && ((ar) (activity)).a.b.j != null && ((ar) (activity)).a.b.j.n != null && ((ar) (activity)).a.b.j.n.a(s1) != null) goto _L2; else goto _L1
_L1:
        setBackgroundColor(0xff000000);
        return;
_L2:
        aj.a.a("Ad request for zone ").b(s1);
        s1 = ((ar) (activity)).a.b.j.n.a(s1);
        if (s1 != null && ((al.c) (s1)).h != null && ((al.c) (s1)).h.a != null)
        {
            a.g g1 = new a.g();
            if (q.T == 0)
            {
                g1.b("request_denied", false);
            } else
            {
                g1.b("request_denied", true);
            }
            g1.a("request_denied_reason", q.T);
            activity.a("request", ((al.c) (s1)).h.a, g1, l1);
            aj.a.a("Tracking ad request - URL : ").b(((al.c) (s1)).h.a);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    final void a()
    {
        t = false;
        l = false;
        setWillNotDraw(false);
        D.s = this;
        if (!v) goto _L2; else goto _L1
_L1:
        if (q.c != null && q.c.a != null && D != null && D.b != null && q.c.a(D.b, true, false))
        {
            q.c.a.a(b, null);
        } else
        {
            p = true;
        }
        D.a(true);
        ao = D.c;
        c = com.jirbo.adcolony.q.g("video_filepath");
        U = com.jirbo.adcolony.q.g("advertiser_name");
        V = com.jirbo.adcolony.q.g("description");
        W = com.jirbo.adcolony.q.g("title");
        aa = com.jirbo.adcolony.q.g("poster_image");
        ab = com.jirbo.adcolony.q.g("unmute");
        ac = com.jirbo.adcolony.q.g("mute");
        ad = com.jirbo.adcolony.q.g("thumb_image");
        N = com.jirbo.adcolony.q.f("native_engagement_enabled");
        P = com.jirbo.adcolony.q.g("native_engagement_label");
        Q = com.jirbo.adcolony.q.g("native_engagement_command");
        R = com.jirbo.adcolony.q.g("native_engagement_type");
        C = com.jirbo.adcolony.q.f("v4iap_enabled");
        if (C)
        {
            af = k.b;
        }
        ae = com.jirbo.adcolony.q.g("product_id");
        if (D.d != null && D.d.v != null)
        {
            s = D.d.v.b;
        } else
        {
            s = true;
        }
        if (ao != null)
        {
            ao.b();
        }
        if (D.d != null && D.d.v != null && D.d.v.a && D.c != null) goto _L4; else goto _L3
_L3:
        q.T = 13;
_L6:
        return;
_L4:
        n = true;
        if (z) goto _L6; else goto _L5
_L5:
        if (v)
        {
            ag = D.d.u.b;
            ah = D.d.u.c;
            if (aj == -1)
            {
                aj = (int)((double)ah * ((double)ai / (double)ag));
                i = aj;
            }
            float f1 = (float)ai / (float)ag;
            float f2 = (float)aj / (float)ah;
            float f3 = (float)ag / (float)ah;
            android.widget.FrameLayout.LayoutParams layoutparams;
            if (f1 > f2)
            {
                at = true;
                ai = (int)((float)aj * f3);
            } else
            {
                as = true;
                aj = (int)((float)ai / f3);
            }
            av = new android.widget.FrameLayout.LayoutParams(ai, aj, 48);
            au = new android.widget.FrameLayout.LayoutParams(h, i, 48);
            E = new c(aa, (byte)0);
            if (1.0F / ((float)E.f / (float)ai) > 1.0F / ((float)E.g / (float)aj))
            {
                f1 = 1.0F / ((float)E.g / (float)aj);
            } else
            {
                f1 = 1.0F / ((float)E.f / (float)ai);
            }
            E.a(f1, true);
            v = false;
        }
        if (N)
        {
            O = new Button(com.jirbo.adcolony.q.b());
            O.setText(P);
            O.setGravity(17);
            O.setTextSize((int)(18D * ((double)ai / (double)an)));
            O.setPadding(0, 0, 0, 0);
            O.setBackgroundColor(al);
            O.setTextColor(am);
            O.setOnTouchListener(new android.view.View.OnTouchListener() {

                final n a;

                public final boolean onTouch(View view, MotionEvent motionevent)
                {
                    int i1 = motionevent.getAction();
                    if (i1 == 0)
                    {
                        view = new float[3];
                        Color.colorToHSV(a.al, view);
                        view[2] = view[2] * 0.8F;
                        a.O.setBackgroundColor(Color.HSVToColor(view));
                    } else
                    {
                        if (i1 == 3)
                        {
                            a.O.setBackgroundColor(a.al);
                            return true;
                        }
                        if (i1 == 1)
                        {
                            if (a.C)
                            {
                                a.af = k.c;
                                a.p = true;
                                return true;
                            }
                            if (a.R.equals("install") || a.R.equals("url"))
                            {
                                q.c.d.a("native_overlay_click", null, a.D);
                                try
                                {
                                    view = new Intent("android.intent.action.VIEW", Uri.parse(a.Q));
                                    com.jirbo.adcolony.q.b().startActivity(view);
                                }
                                // Misplaced declaration of an exception variable
                                catch (View view)
                                {
                                    Toast.makeText(com.jirbo.adcolony.q.b(), "Unable to open store.", 0).show();
                                }
                            }
                            a.O.setBackgroundColor(a.al);
                            return true;
                        }
                    }
                    return true;
                }

            
            {
                a = n.this;
                super();
            }
            });
        }
        G = new c(ab, (byte)0);
        F = new c(ac, (byte)0);
        L = new c(ad, (byte)0);
        L.a(1.0F / (float)((double)((float)L.f / (float)ai) / ((double)ai / 5.5D / (double)(float)ai)), true);
        F.a(ar / 2.0F, true);
        G.a(ar / 2.0F, true);
        I = new b(com.jirbo.adcolony.q.b());
        M = new ImageView(com.jirbo.adcolony.q.b());
        H = new ImageView(com.jirbo.adcolony.q.b());
        M.setImageBitmap(L.a);
        if (m)
        {
            H.setImageBitmap(F.a);
        } else
        {
            H.setImageBitmap(G.a);
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams(F.f, F.g, 48);
        layoutparams.setMargins(h - F.f, 0, 0, 0);
        H.setOnClickListener(new android.view.View.OnClickListener() {

            final n a;

            public final void onClick(View view)
            {
                if (a.m)
                {
                    a.a(true, true);
                    a.r = true;
                } else
                if (a.K == a.G.a)
                {
                    a.r = false;
                    a.a(false, true);
                    return;
                }
            }

            
            {
                a = n.this;
                super();
            }
        });
        K = F.a;
        if (p)
        {
            H.setVisibility(8);
        }
        if (q)
        {
            H.setVisibility(4);
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            J = new a(com.jirbo.adcolony.q.b(), p);
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            addView(J, av);
        }
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            p = true;
        }
        addView(I, au);
        if (s && android.os.Build.VERSION.SDK_INT >= 14 && x)
        {
            addView(H, layoutparams);
        }
        if (N)
        {
            layoutparams = new android.widget.FrameLayout.LayoutParams(h, i / 5, 80);
            addView(O, layoutparams);
            return;
        } else
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        if (android.os.Build.VERSION.SDK_INT < 14) goto _L6; else goto _L5
    }

    final void a(boolean flag, boolean flag1)
    {
        if (flag)
        {
            H.setImageBitmap(G.a);
            m = false;
            a(0.0F, flag1);
            K = G.a;
        } else
        if (!r && K == G.a)
        {
            H.setImageBitmap(F.a);
            m = true;
            if (S != null)
            {
                if ((double)aq != 0.0D)
                {
                    a(aq, flag1);
                } else
                {
                    a(0.25F, flag1);
                }
            }
            K = F.a;
            return;
        }
    }

    final void b()
    {
        if (S != null && H != null)
        {
            S.setVolume(0.0F, 0.0F);
            H.setImageBitmap(G.a);
            K = G.a;
        }
    }

    final void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (!p && S != null && S.isPlaying()) goto _L2; else goto _L1
_L1:
        MediaPlayer mediaplayer = S;
        if (mediaplayer != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        setVolume(aq);
        S.start();
        q.c.a(D);
        D.l = true;
        if (true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public final ImageView getAdvertiserImage()
    {
        if (L == null)
        {
            L = new c(ad, (byte)0);
            L.a(ar / 2.0F, true);
        }
        if (M == null)
        {
            M = new ImageView(com.jirbo.adcolony.q.b());
            M.setImageBitmap(L.a);
        }
        return M;
    }

    public final String getAdvertiserName()
    {
        return U;
    }

    public final String getDescription()
    {
        return V;
    }

    public final String getEngagementCommand()
    {
        if (Q == null)
        {
            return "";
        } else
        {
            return Q;
        }
    }

    public final String getEngagementLabel()
    {
        if (P == null)
        {
            return "";
        } else
        {
            return P;
        }
    }

    public final String getEngagementType()
    {
        if (R == null)
        {
            return "";
        } else
        {
            return R;
        }
    }

    public final int getNativeAdHeight()
    {
        if (!k && N)
        {
            return i + i / 5;
        } else
        {
            return i;
        }
    }

    public final int getNativeAdWidth()
    {
        return h;
    }

    public final String getTitle()
    {
        return W;
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        try
        {
            aw.close();
        }
        // Misplaced declaration of an exception variable
        catch (MediaPlayer mediaplayer) { }
        I.setVisibility(0);
        H.setVisibility(8);
        D.e = "native";
        D.f = "native";
        D.l = true;
        p = true;
        if (S != null)
        {
            S.release();
        }
        S = null;
        D.k = 0;
        mediaplayer = new a.g();
        mediaplayer.a("ad_slot", D.c.k.d);
        mediaplayer.b("replay", false);
        q.c.d.a("native_complete", mediaplayer, D);
        w = true;
    }

    public final void onDraw(Canvas canvas)
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
        if (!p && S != null)
        {
            ak = S.getCurrentPosition();
        }
        if (ak != 0)
        {
            D.k = ak;
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
        if (!p && S != null && S.isPlaying() && !q)
        {
            aj.c.b("[ADC] Scroll Pause");
            q.c.d.a("video_paused", null, D);
            S.pause();
            I.setVisibility(0);
        }
_L4:
        if (!u && !p)
        {
            invalidate();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!p && S != null && S.isPlaying())
        {
            if (!t)
            {
                canvas.drawARGB(255, 0, 0, 0);
            } else
            {
                D.e = "native";
                D.f = "native";
                q.c.a((double)S.getCurrentPosition() / (double)S.getDuration(), D);
                if (!A)
                {
                    A = true;
                    q.c.a("native_start", (new StringBuilder("{\"ad_slot\":")).append(D.c.k.d).append(", \"replay\":false}").toString(), D);
                }
            }
        } else
        if (!I.a)
        {
            canvas.drawARGB(255, 0, 0, 0);
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        I.setVisibility(0);
        H.setVisibility(8);
        p = true;
        t = true;
        S = null;
        D.k = 0;
        return true;
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        aj.c.b("[ADC] Native Ad onPrepared called.");
        t = true;
        if (K == null || F.a == null)
        {
            I.setVisibility(0);
            H.setVisibility(8);
            p = true;
            S = null;
            D.k = 0;
            return;
        }
        if (!m && K.equals(F.a))
        {
            b();
            return;
        } else
        {
            setVolume(aq);
            return;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return false;
        }
        if (motionevent.getAction() == 1 && q.m && com.jirbo.adcolony.ao.c())
        {
            q.A = D;
            q.c.a.a(b, D.d);
            com.jirbo.adcolony.e.a();
            D.n = w;
            D.m = true;
            D.e = "native";
            D.f = "fullscreen";
            q.m = false;
            q.c.d.a("video_expanded", null, D);
            if (q.d)
            {
                aj.a.b("Launching AdColonyOverlay");
                com.jirbo.adcolony.q.b().startActivity(new Intent(com.jirbo.adcolony.q.b(), com/jirbo/adcolony/AdColonyOverlay));
            } else
            {
                aj.a.b("Launching AdColonyFullscreen");
                com.jirbo.adcolony.q.b().startActivity(new Intent(com.jirbo.adcolony.q.b(), com/jirbo/adcolony/AdColonyFullscreen));
            }
            if (p)
            {
                D.a = -1;
                motionevent = D.c.k;
                motionevent.d = ((x) (motionevent)).d + 1;
                q.c.a("start", (new StringBuilder("{\"ad_slot\":")).append(D.c.k.d).append(", \"replay\":").append(D.n).append("}").toString(), D);
                q.c.h.a(D.b, D.d.d);
            }
            p = true;
            w = true;
        }
        return true;
    }

    public final void setMuted(boolean flag)
    {
        a(flag, false);
    }

    public final void setOverlayButtonColor(int i1)
    {
        if (N)
        {
            O.setBackgroundColor(i1);
        }
        al = i1;
    }

    public final void setOverlayButtonTextColor(int i1)
    {
        if (N)
        {
            O.setTextColor(i1);
        }
        am = i1;
    }

    public final void setVolume(float f1)
    {
        a(f1, false);
    }
}
