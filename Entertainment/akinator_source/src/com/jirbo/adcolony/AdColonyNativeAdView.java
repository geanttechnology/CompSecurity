// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.media.MediaPlayer;
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
import android.widget.TextView;
import java.io.FileInputStream;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            AdColonyIAPEngagement, ADCImage, a, d, 
//            u, AdColonyInterstitialAd, c, AdColonyNativeAdListener, 
//            AdColony, l, ag, q, 
//            ADCVideo, AdColonyOverlay, t, AdColonyFullscreen, 
//            AdColonyNativeAdMutedListener

public class AdColonyNativeAdView extends FrameLayout
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{

    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    AdColonyInterstitialAd K;
    AdColonyNativeAdListener L;
    AdColonyNativeAdMutedListener M;
    ADCImage N;
    ADCImage O;
    ADCImage P;
    ImageView Q;
    b R;
    View S;
    Bitmap T;
    ADCImage U;
    ImageView V;
    boolean W;
    Button Z;
    TextView a;
    float aA;
    boolean aB;
    boolean aC;
    android.widget.FrameLayout.LayoutParams aD;
    android.widget.FrameLayout.LayoutParams aE;
    FileInputStream aF;
    String aa;
    String ab;
    String ac;
    MediaPlayer ad;
    Surface ae;
    String af;
    String ag;
    String ah;
    String ai;
    String aj;
    String ak;
    String al;
    String am;
    AdColonyIAPEngagement an;
    int ao;
    int ap;
    int aq;
    int ar;
    int as;
    int at;
    int au;
    int av;
    n.ab aw;
    n.a ax;
    float ay;
    float az;
    TextView b;
    TextView c;
    Activity d;
    String e;
    String f;
    ViewGroup g;
    SurfaceTexture h;
    int i;
    int j;
    int k;
    int l;
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

    public AdColonyNativeAdView(Activity activity, String s1, int i1)
    {
        super(activity);
        B = true;
        D = true;
        W = false;
        aa = "";
        ab = "";
        ac = "";
        am = "";
        an = AdColonyIAPEngagement.NONE;
        ar = -1;
        at = 0xffcccccc;
        au = 0xff000000;
        ay = 0.25F;
        az = 0.25F;
        a(activity, s1, i1);
        a();
    }

    public AdColonyNativeAdView(Activity activity, String s1, int i1, int j1)
    {
        super(activity);
        B = true;
        D = true;
        W = false;
        aa = "";
        ab = "";
        ac = "";
        am = "";
        an = AdColonyIAPEngagement.NONE;
        ar = -1;
        at = 0xffcccccc;
        au = 0xff000000;
        ay = 0.25F;
        az = 0.25F;
        a(activity, s1, i1, j1);
        a(false);
    }

    AdColonyNativeAdView(Activity activity, String s1, int i1, boolean flag)
    {
        super(activity);
        B = true;
        D = true;
        W = false;
        aa = "";
        ab = "";
        ac = "";
        am = "";
        an = AdColonyIAPEngagement.NONE;
        ar = -1;
        at = 0xffcccccc;
        au = 0xff000000;
        ay = 0.25F;
        az = 0.25F;
        G = flag;
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
        az = f1;
        if (ad == null || (double)f1 < 0.0D || (double)f1 > 1.0D)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!x)
        {
            ad.setVolume(f1, f1);
        }
        if (!z) goto _L1; else goto _L3
_L3:
        if (T == P.a && (double)f1 > 0.0D && !x)
        {
            ADCData.g g1 = new ADCData.g();
            g1.b("user_action", flag);
            Q.setImageBitmap(O.a);
            T = O.a;
            a.l.d.a("sound_unmute", g1, K);
            r = true;
            return;
        }
        if (T != O.a || (double)f1 != 0.0D) goto _L1; else goto _L4
_L4:
        ADCData.g g2 = new ADCData.g();
        g2.b("user_action", flag);
        Q.setImageBitmap(P.a);
        T = P.a;
        a.l.d.a("sound_mute", g2, K);
        r = false;
        return;
        if ((double)f1 < 0.0D || (double)f1 > 1.0D) goto _L1; else goto _L5
_L5:
        ay = f1;
        return;
    }

    void a(Activity activity, String s1, int i1)
    {
        a(activity, s1, i1, 0);
    }

    void a(Activity activity, String s1, int i1, int j1)
    {
        com.jirbo.adcolony.a.e();
        if (!G)
        {
            a.ah.add(this);
        }
        a.ad = 0;
        d = activity;
        e = s1;
        aq = i1;
        k = i1;
        if (j1 != 0)
        {
            l = j1;
            ar = j1;
            o = true;
        }
        r = true;
        aA = com.jirbo.adcolony.a.b().getResources().getDisplayMetrics().density;
        activity = com.jirbo.adcolony.a.b().getWindowManager().getDefaultDisplay();
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
        av = i1;
        K = new AdColonyInterstitialAd(s1);
        K.j = "native";
        K.k = "native";
        a.l.d.a(s1, K);
        setBackgroundColor(0xff000000);
    }

    void a(boolean flag)
    {
        z = false;
        q = false;
        setWillNotDraw(false);
        K.x = this;
        if (!B)
        {
            break MISSING_BLOCK_LABEL_1359;
        }
        if (a.l != null && a.l.a != null && K != null && K.g != null && a.l.a(K.g, true, false))
        {
            a.l.a.b(e);
        } else
        {
            u = true;
        }
        K.b(true);
        aw = K.h;
        f = com.jirbo.adcolony.a.j("video_filepath");
        af = com.jirbo.adcolony.a.j("advertiser_name");
        ag = com.jirbo.adcolony.a.j("description");
        ah = com.jirbo.adcolony.a.j("title");
        ai = com.jirbo.adcolony.a.j("poster_image");
        aj = com.jirbo.adcolony.a.j("unmute");
        ak = com.jirbo.adcolony.a.j("mute");
        al = com.jirbo.adcolony.a.j("thumb_image");
        W = com.jirbo.adcolony.a.i("native_engagement_enabled");
        aa = com.jirbo.adcolony.a.j("native_engagement_label");
        ab = com.jirbo.adcolony.a.j("native_engagement_command");
        ac = com.jirbo.adcolony.a.j("native_engagement_type");
        J = com.jirbo.adcolony.a.i("v4iap_enabled");
        if (J)
        {
            an = AdColonyIAPEngagement.AUTOMATIC;
        }
        am = com.jirbo.adcolony.a.j("product_id");
        if (K.i != null && K.i.w != null)
        {
            y = K.i.w.b;
        } else
        {
            y = true;
        }
        if (aw != null)
        {
            aw.k();
        }
        if (K.i != null && K.i.w != null && K.i.w.a && K.h != null) goto _L2; else goto _L1
_L1:
        a.ad = 13;
_L4:
        return;
_L2:
        s = true;
        if (G) goto _L4; else goto _L3
_L3:
        if (B)
        {
            ao = K.i.v.b;
            ap = K.i.v.c;
            if (ar == -1)
            {
                ar = (int)((double)ap * ((double)aq / (double)ao));
                l = ar;
            }
            if (!flag && W)
            {
                ar = ar - ar / 6;
            }
            float f1 = (float)aq / (float)ao;
            float f2 = (float)ar / (float)ap;
            float f3 = (float)ao / (float)ap;
    /* block-local class not found */
    class a {}

    /* block-local class not found */
    class b {}

            android.widget.FrameLayout.LayoutParams layoutparams;
            if (f1 > f2)
            {
                aC = true;
                aq = (int)((float)ar * f3);
            } else
            {
                aB = true;
                ar = (int)((float)aq / f3);
            }
            aE = new android.widget.FrameLayout.LayoutParams(aq, ar, 48);
            aD = new android.widget.FrameLayout.LayoutParams(k, l, 48);
            if (W && !flag && aB)
            {
                aE.setMargins(0, (l - ar) / 2 - ar / 10, 0, 0);
                aD.setMargins(0, (l - ar) / 2 - ar / 10, 0, ((l - ar) / 2 - ar / 10) * -1);
            } else
            if (!flag && aB)
            {
                aE.setMargins(0, (l - ar) / 2, 0, 0);
                aD.setMargins(0, (l - ar) / 2, 0, ((l - ar) / 2) * -1);
            } else
            if (W && !flag && aC)
            {
                aE.setMargins((k - aq) / 2, 0, 0, 0);
                aD.setMargins((k - aq) / 2, 0, ((k - aq) / 2) * -1, 0);
            } else
            if (!flag && aC)
            {
                aE.setMargins((k - aq) / 2, 0, 0, 0);
                aD.setMargins((k - aq) / 2, 0, ((k - aq) / 2) * -1, 0);
            }
            N = new ADCImage(ai, true, false);
            if (1.0F / ((float)N.f / (float)aq) > 1.0F / ((float)N.g / (float)ar))
            {
                f1 = 1.0F / ((float)N.g / (float)ar);
            } else
            {
                f1 = 1.0F / ((float)N.f / (float)aq);
            }
            N.a(f1, true);
            B = false;
        }
        if (W)
        {
            Z = new Button(com.jirbo.adcolony.a.b());
            Z.setText(aa);
            Z.setGravity(17);
            Z.setTextSize((int)(18D * ((double)aq / (double)av)));
            Z.setPadding(0, 0, 0, 0);
            Z.setBackgroundColor(at);
            Z.setTextColor(au);
            Z.setOnTouchListener(new _cls1());
        }
        P = new ADCImage(aj, true, false);
        O = new ADCImage(ak, true, false);
        U = new ADCImage(al, true, false);
        U.a(1.0F / (float)((double)((float)U.f / (float)aq) / ((double)aq / 5.5D / (double)(float)aq)), true);
        O.a(aA / 2.0F, true);
        P.a(aA / 2.0F, true);
        R = new b(com.jirbo.adcolony.a.b());
        V = new ImageView(com.jirbo.adcolony.a.b());
        Q = new ImageView(com.jirbo.adcolony.a.b());
        V.setImageBitmap(U.a);
        if (r)
        {
            Q.setImageBitmap(O.a);
        } else
        {
            Q.setImageBitmap(P.a);
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams(O.f, O.g, 48);
        layoutparams.setMargins(k - O.f, 0, 0, 0);
        Q.setOnClickListener(new _cls2());
        T = O.a;
        if (u)
        {
            Q.setVisibility(8);
        }
        if (v)
        {
            Q.setVisibility(4);
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            S = new a(com.jirbo.adcolony.a.b(), u);
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            addView(S, aE);
        }
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            u = true;
        }
        addView(R, aD);
        if (y && android.os.Build.VERSION.SDK_INT >= 14 && D)
        {
            addView(Q, layoutparams);
        }
        if (!W) goto _L4; else goto _L5
_L5:
        android.widget.FrameLayout.LayoutParams layoutparams1;
        if (flag)
        {
            layoutparams1 = new android.widget.FrameLayout.LayoutParams(k, l / 5, 80);
        } else
        {
            layoutparams1 = new android.widget.FrameLayout.LayoutParams(k, ar / 5, 80);
        }
        addView(Z, layoutparams1);
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
            Q.setImageBitmap(P.a);
            r = false;
            a(0.0F, flag1);
            T = P.a;
        } else
        if (!x && T == P.a)
        {
            Q.setImageBitmap(O.a);
            r = true;
            if (ad != null)
            {
                if ((double)az != 0.0D)
                {
                    a(az, flag1);
                } else
                {
                    a(0.25F, flag1);
                }
            }
            T = O.a;
            return;
        }
    }

    void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!u && ad != null && ad.isPlaying()) goto _L2; else goto _L1
_L1:
        MediaPlayer mediaplayer = ad;
        if (mediaplayer != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        setVolume(az);
        ad.start();
        a.l.a(K);
        K.q = true;
        if (L != null)
        {
            L.onAdColonyNativeAdStarted(false, this);
        }
        if (true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    boolean b(boolean flag)
    {
        return K.a(true) && AdColony.isZoneNative(e);
    }

    void c()
    {
        if (!u && ad != null && ad.isPlaying() && !v)
        {
            a.l.d.b("video_paused", K);
            ad.pause();
        }
    }

    void c(boolean flag)
    {
label0:
        {
            if (ad != null && Q != null)
            {
                if (!flag)
                {
                    break label0;
                }
                ad.setVolume(0.0F, 0.0F);
                Q.setImageBitmap(P.a);
                T = P.a;
            }
            return;
        }
        ad.setVolume(az, az);
        Q.setImageBitmap(O.a);
        T = O.a;
    }

    public boolean canceled()
    {
        return I;
    }

    public void destroy()
    {
        l.c.b("[ADC] Native Ad Destroy called.");
        if (ae != null)
        {
            ae.release();
        }
        if (ad != null)
        {
            ad.release();
        }
        ad = null;
        a.ah.remove(this);
    }

    public ImageView getAdvertiserImage()
    {
        if (U == null)
        {
            U = new ADCImage(al, true, false);
            U.a(aA / 2.0F, true);
        }
        if (V == null)
        {
            V = new ImageView(com.jirbo.adcolony.a.b());
            V.setImageBitmap(U.a);
        }
        return V;
    }

    public String getAdvertiserName()
    {
        return af;
    }

    public String getDescription()
    {
        return ag;
    }

    public int getNativeAdHeight()
    {
        if (!o && W)
        {
            return l + l / 5;
        } else
        {
            return l;
        }
    }

    public int getNativeAdWidth()
    {
        return k;
    }

    public String getTitle()
    {
        return ah;
    }

    public boolean iapEnabled()
    {
        return J;
    }

    public AdColonyIAPEngagement iapEngagementType()
    {
        if (K != null && K.u == AdColonyIAPEngagement.END_CARD)
        {
            return AdColonyIAPEngagement.END_CARD;
        } else
        {
            return an;
        }
    }

    public String iapProductID()
    {
        return am;
    }

    public boolean isReady()
    {
        return K.a(true) && s && !F;
    }

    public void notifyAddedToListView()
    {
        if (!m)
        {
            m = true;
            return;
        } else
        {
            ((a)S).onSurfaceTextureAvailable(h, i, j);
            return;
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        try
        {
            aF.close();
        }
        // Misplaced declaration of an exception variable
        catch (MediaPlayer mediaplayer) { }
        R.setVisibility(0);
        Q.setVisibility(8);
        K.j = "native";
        K.k = "native";
        K.q = true;
        u = true;
        if (ad != null)
        {
            ad.release();
        }
        ad = null;
        K.p = 0;
        mediaplayer = new ADCData.g();
        mediaplayer.b("ad_slot", K.h.k.d);
        mediaplayer.b("replay", false);
        a.l.d.a("native_complete", mediaplayer, K);
        if (L != null)
        {
            L.onAdColonyNativeAdFinished(false, this);
        }
        C = true;
    }

    public void onDraw(Canvas canvas)
    {
        if (g != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Rect rect = new Rect();
        if (!g.hasFocus())
        {
            g.requestFocus();
        }
        if (!u && ad != null)
        {
            as = ad.getCurrentPosition();
        }
        if (as != 0)
        {
            K.p = as;
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
        if ((flag || n) && (!n || flag && (rect.bottom - rect.top >= getNativeAdHeight() || rect.top == 0)))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!u && ad != null && ad.isPlaying() && !v)
        {
            l.c.b("[ADC] Scroll Pause");
            a.l.d.b("video_paused", K);
            ad.pause();
            R.setVisibility(0);
        }
_L4:
        if (!A && !u)
        {
            invalidate();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!u && ad != null && ad.isPlaying())
        {
            if (!z)
            {
                canvas.drawARGB(255, 0, 0, 0);
            } else
            {
                K.j = "native";
                K.k = "native";
                a.l.a((double)ad.getCurrentPosition() / (double)ad.getDuration(), K);
                if (!H)
                {
                    H = true;
                    a.l.a("native_start", (new StringBuilder()).append("{\"ad_slot\":").append(K.h.k.d).append(", \"replay\":false}").toString(), K);
                }
            }
        } else
        if (!R.a)
        {
            canvas.drawARGB(255, 0, 0, 0);
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        R.setVisibility(0);
        Q.setVisibility(8);
        u = true;
        z = true;
        ad = null;
        K.p = 0;
        return true;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        l.c.b("[ADC] Native Ad onPrepared called.");
        z = true;
        if (T == null || O.a == null)
        {
            R.setVisibility(0);
            Q.setVisibility(8);
            u = true;
            ad = null;
            K.p = 0;
            return;
        }
        if (!r && T.equals(O.a))
        {
            c(true);
            return;
        } else
        {
            setVolume(az);
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return false;
        }
        if (motionevent.getAction() == 1 && a.v && com.jirbo.adcolony.q.c())
        {
            a.K = K;
            a.l.a.a(e, K.i);
            ADCVideo.a();
            K.s = C;
            K.r = true;
            K.j = "native";
            K.k = "fullscreen";
            a.v = false;
            a.l.d.b("video_expanded", K);
            if (L != null)
            {
                L.onAdColonyNativeAdStarted(true, this);
            }
            if (a.m)
            {
                l.a.b("Launching AdColonyOverlay");
                com.jirbo.adcolony.a.b().startActivity(new Intent(com.jirbo.adcolony.a.b(), com/jirbo/adcolony/AdColonyOverlay));
            } else
            {
                l.a.b("Launching AdColonyFullscreen");
                com.jirbo.adcolony.a.b().startActivity(new Intent(com.jirbo.adcolony.a.b(), com/jirbo/adcolony/AdColonyFullscreen));
            }
            if (u)
            {
                K.f = -1;
                motionevent = K.h.k;
                motionevent.d = ((ag) (motionevent)).d + 1;
                a.l.a("start", (new StringBuilder()).append("{\"ad_slot\":").append(K.h.k.d).append(", \"replay\":").append(K.s).append("}").toString(), K);
                a.l.h.a(K.g, K.i.d);
            }
            u = true;
            C = true;
        }
        return true;
    }

    public void pause()
    {
        l.c.b("[ADC] Native Ad Pause called.");
        if (ad != null && !u && ad.isPlaying() && android.os.Build.VERSION.SDK_INT >= 14)
        {
            a.l.d.b("video_paused", K);
            v = true;
            ad.pause();
            R.setVisibility(0);
            Q.setVisibility(4);
        }
    }

    public void prepareForListView()
    {
        n = true;
    }

    public void resume()
    {
        l.c.b("[ADC] Native Ad Resume called.");
        if (ad != null && v && !u && android.os.Build.VERSION.SDK_INT >= 14)
        {
            a.l.d.b("video_resumed", K);
            v = false;
            ad.seekTo(K.p);
            ad.start();
            R.setVisibility(4);
            Q.setVisibility(0);
        }
    }

    public void setMuted(boolean flag)
    {
        a(flag, false);
    }

    public void setOverlayButtonColor(int i1)
    {
        if (W)
        {
            Z.setBackgroundColor(i1);
        }
        at = i1;
    }

    public void setOverlayButtonTextColor(int i1)
    {
        if (W)
        {
            Z.setTextColor(i1);
        }
        au = i1;
    }

    public void setOverlayButtonTypeface(Typeface typeface, int i1)
    {
        if (W)
        {
            Z.setTypeface(typeface, i1);
        }
    }

    public void setVolume(float f1)
    {
        a(f1, false);
    }

    public AdColonyNativeAdView withListener(AdColonyNativeAdListener adcolonynativeadlistener)
    {
        L = adcolonynativeadlistener;
        K.w = adcolonynativeadlistener;
        return this;
    }

    public AdColonyNativeAdView withMutedListener(AdColonyNativeAdMutedListener adcolonynativeadmutedlistener)
    {
        M = adcolonynativeadmutedlistener;
        return this;
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
