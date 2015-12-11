// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tremorvideo.sdk.android.d.aa;
import com.tremorvideo.sdk.android.d.ab;
import com.tremorvideo.sdk.android.d.ac;
import com.tremorvideo.sdk.android.d.ad;
import com.tremorvideo.sdk.android.d.ae;
import com.tremorvideo.sdk.android.d.af;
import com.tremorvideo.sdk.android.d.ag;
import com.tremorvideo.sdk.android.d.ah;
import com.tremorvideo.sdk.android.d.ai;
import com.tremorvideo.sdk.android.d.aj;
import com.tremorvideo.sdk.android.d.ak;
import com.tremorvideo.sdk.android.d.al;
import com.tremorvideo.sdk.android.d.am;
import com.tremorvideo.sdk.android.d.an;
import com.tremorvideo.sdk.android.d.ao;
import com.tremorvideo.sdk.android.d.ap;
import com.tremorvideo.sdk.android.d.aq;
import com.tremorvideo.sdk.android.d.ar;
import com.tremorvideo.sdk.android.d.as;
import com.tremorvideo.sdk.android.d.at;
import com.tremorvideo.sdk.android.d.au;
import com.tremorvideo.sdk.android.d.av;
import com.tremorvideo.sdk.android.d.aw;
import com.tremorvideo.sdk.android.d.e;
import com.tremorvideo.sdk.android.d.f;
import com.tremorvideo.sdk.android.d.g;
import com.tremorvideo.sdk.android.d.h;
import com.tremorvideo.sdk.android.d.i;
import com.tremorvideo.sdk.android.d.j;
import com.tremorvideo.sdk.android.d.k;
import com.tremorvideo.sdk.android.d.l;
import com.tremorvideo.sdk.android.d.m;
import com.tremorvideo.sdk.android.d.n;
import com.tremorvideo.sdk.android.d.o;
import com.tremorvideo.sdk.android.d.p;
import com.tremorvideo.sdk.android.d.q;
import com.tremorvideo.sdk.android.d.r;
import com.tremorvideo.sdk.android.d.t;
import com.tremorvideo.sdk.android.d.u;
import com.tremorvideo.sdk.android.d.v;
import com.tremorvideo.sdk.android.d.w;
import com.tremorvideo.sdk.android.d.x;
import com.tremorvideo.sdk.android.d.y;
import com.tremorvideo.sdk.android.d.z;
import java.io.File;
import java.io.InputStream;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad

public class bv
{
    class a
    {

        public Bitmap a(File file)
        {
            ((WindowManager)com.tremorvideo.sdk.android.videoad.ad.v().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
            Object obj = new android.graphics.BitmapFactory.Options();
            obj.inScaled = false;
            obj.inPurgeable = true;
            obj = BitmapFactory.decodeFile(file.getAbsolutePath(), ((android.graphics.BitmapFactory.Options) (obj)));
            file = ((File) (obj));
            if (ad.J() < 1.0F)
            {
                file = Bitmap.createScaledBitmap(((Bitmap) (obj)), Math.max(1, Math.round((float)((Bitmap) (obj)).getWidth() * ad.J())), Math.max(1, Math.round((float)((Bitmap) (obj)).getHeight() * ad.J())), true);
            }
            return file;
        }

        a()
        {
        }
    }

    class b
    {

        public Bitmap a(byte abyte0[])
        {
            ((WindowManager)com.tremorvideo.sdk.android.videoad.ad.v().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inScaled = false;
            options.inPurgeable = true;
            abyte0 = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
            return Bitmap.createScaledBitmap(abyte0, Math.max(1, Math.round((float)abyte0.getWidth() * ad.J())), Math.max(1, Math.round((float)abyte0.getHeight() * ad.J())), true);
        }

        b()
        {
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        public static final c d;
        public static final c e;
        public static final c f;
        public static final c g;
        public static final c h;
        public static final c i;
        public static final c j;
        private static final c m[];
        public final int k;
        public final String l;

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/tremorvideo/sdk/android/videoad/bv$c, s);
        }

        public static c[] values()
        {
            return (c[])m.clone();
        }

        static 
        {
            a = new c("ButtonText", 0, -1, "button_text_color");
            b = new c("ButtonTextShadow", 1, Color.argb(150, 0, 0, 0), "button_text_shadow_color");
            c = new c("WatermarkText", 2, -1, "watermark_text_color");
            d = new c("InputText", 3, 0xff000000, "input_text_color");
            e = new c("InputHintText", 4, 0xff888888, "input_hint_text_color");
            f = new c("DialogFill", 5, Color.argb(153, 0, 0, 0), "dialog_color");
            g = new c("DialogTitle", 6, -1, "dialog_title_color");
            h = new c("DialogTitleShadow", 7, Color.argb(153, 0, 0, 0), "dialog_title_shadow_color");
            i = new c("DialogText", 8, 0xff888888, "dialog_text_color");
            j = new c("DialogButtonText", 9, 0xff000000, "dialog_button_text_color");
            m = (new c[] {
                a, b, c, d, e, f, g, h, i, j
            });
        }

        private c(String s, int i1, int j1, String s1)
        {
            super(s, i1);
            k = j1;
            l = s1;
        }
    }

    public static final class d extends Enum
    {

        public static final d A;
        public static final d B;
        public static final d C;
        public static final d D;
        public static final d E;
        public static final d F;
        public static final d G;
        public static final d H;
        public static final d I;
        public static final d J;
        public static final d K;
        public static final d L;
        public static final d M;
        public static final d N;
        public static final d O;
        public static final d P;
        public static final d Q;
        public static final d R;
        public static final d S;
        public static final d T;
        public static final d U;
        public static final d V;
        private static final d Y[];
        public static final d a;
        public static final d b;
        public static final d c;
        public static final d d;
        public static final d e;
        public static final d f;
        public static final d g;
        public static final d h;
        public static final d i;
        public static final d j;
        public static final d k;
        public static final d l;
        public static final d m;
        public static final d n;
        public static final d o;
        public static final d p;
        public static final d q;
        public static final d r;
        public static final d s;
        public static final d t;
        public static final d u;
        public static final d v;
        public static final d w;
        public static final d x;
        public static final d y;
        public static final d z;
        public final byte W[];
        public final String X;

        public static d valueOf(String s1)
        {
            return (d)Enum.valueOf(com/tremorvideo/sdk/android/videoad/bv$d, s1);
        }

        public static d[] values()
        {
            return (d[])Y.clone();
        }

        static 
        {
            a = new d("IconWeb", 0, ae.a, "icon-web");
            b = new d("IconCall", 1, u.a, "icon-call");
            c = new d("IconMP3Store", 2, z.a, "icon-mp3store");
            d = new d("IconMarket", 3, w.a, "icon-market");
            e = new d("IconTwitter", 4, ad.a, "icon-twitter");
            f = new d("IconFacebook", 5, x.a, "icon-facebook");
            g = new d("IconTicket", 6, ac.a, "icon-ticket");
            h = new d("IconYoutube", 7, af.a, "icon-youtube");
            i = new d("IconSkip", 8, ab.a, "icon-skip");
            j = new d("IconSurvey", 9, w.a, "icon-survey");
            k = new d("IconShare", 10, aa.a, "icon-share");
            l = new d("IconCalendar", 11, t.a, "icon-calendar");
            m = new d("IconMap", 12, y.a, "icon-map");
            n = new d("IconCoupon", 13, v.a, "icon-coupon");
            o = new d("ButtonBarDivider", 14, com.tremorvideo.sdk.android.d.b.a, "buttonbar-divider");
            p = new d("ButtonBarLeft", 15, com.tremorvideo.sdk.android.d.c.a, "buttonbar-left");
            q = new d("ButtonBarMiddle", 16, e.a, "buttonbar-middle");
            r = new d("ButtonBarRight", 17, g.a, "buttonbar-right");
            s = new d("ButtonBarLeftPress", 18, com.tremorvideo.sdk.android.d.d.a, "buttonbar-left-press");
            t = new d("ButtonBarMiddlePress", 19, f.a, "buttonbar-middle-press");
            u = new d("ButtonBarRightPress", 20, h.a, "buttonbar-right-press");
            v = new d("ReplayBig", 21, ak.a, "replay-big");
            w = new d("WatermarkLeft", 22, av.a, "watermark-left");
            x = new d("WatermarkMiddle", 23, aw.a, "watermark-middle");
            y = new d("DialogTopLeft", 24, p.a, "dialog-top-left");
            z = new d("DialogTopMiddle", 25, q.a, "dialog-top-middle");
            A = new d("DialogTopRight", 26, r.a, "dialog-top-right");
            B = new d("DialogMiddleLeft", 27, n.a, "dialog-middle-left");
            C = new d("DialogMiddleRight", 28, o.a, "dialog-middle-right");
            D = new d("DialogBottomLeft", 29, i.a, "dialog-bottom-left");
            E = new d("DialogBottomMiddle", 30, j.a, "dialog-bottom-middle");
            F = new d("DialogBottomRight", 31, k.a, "dialog-bottom-right");
            G = new d("TwitterLeftTop", 32, as.a, "twitter-left-top");
            H = new d("TwitterLeftBottom", 33, ar.a, "twitter-left-bottom");
            I = new d("TwitterMiddle", 34, at.a, "twitter-middle");
            J = new d("TwitterRight", 35, au.a, "twitter-right");
            K = new d("InputLeft", 36, ag.a, "input-left");
            L = new d("InputMiddle", 37, ah.a, "input-middle");
            M = new d("InputRight", 38, ai.a, "input-right");
            N = new d("DialogButton", 39, l.a, "dialog-button");
            O = new d("DialogButtonPress", 40, m.a, "dialog-button-press");
            P = new d("SurveyLeft", 41, ap.a, "survey-left");
            Q = new d("SurveyMiddle", 42, aq.a, "survey-middle");
            R = new d("SurveyButtonLeft", 43, al.a, "survey-button-left");
            S = new d("SurveyButtonMiddle", 44, am.a, "survey-button-middle");
            T = new d("SurveyButtonPressLeft", 45, an.a, "survey-button-press-left");
            U = new d("SurveyButtonPressMiddle", 46, ao.a, "survey-button-press-middle");
            V = new d("InternalSurveySkip", 47, aj.a, "internal-survey-skip");
            Y = (new d[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r, s, t, 
                u, v, w, x, y, z, A, B, C, D, 
                E, F, G, H, I, J, K, L, M, N, 
                O, P, Q, R, S, T, U, V
            });
        }

        private d(String s1, int i1, byte abyte0[], String s2)
        {
            super(s1, i1);
            W = abyte0;
            X = s2;
        }
    }


    int a[];
    Dictionary b;

    public bv()
    {
        b = new Hashtable();
        a = new int[c.values().length];
    }

    public static Bitmap a(File file)
    {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) < 4)
        {
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            file = bitmap;
            if (ad.J() < 1.0F)
            {
                file = Bitmap.createScaledBitmap(bitmap, Math.max(1, Math.round((float)bitmap.getWidth() * ad.J())), Math.max(1, Math.round((float)bitmap.getHeight() * ad.J())), true);
            }
            return file;
        } else
        {
            return (new a()).a(file);
        }
    }

    private static Bitmap a(ZipEntry zipentry, ZipFile zipfile)
    {
        if (zipentry == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        byte abyte0[];
        int k;
        zipfile = zipfile.getInputStream(zipentry);
        k = (int)zipentry.getSize();
        abyte0 = new byte[k];
        int i = 0;
_L2:
        int j = i + zipfile.read(abyte0, i, k - i);
        i = j;
        if (j < k) goto _L2; else goto _L1
_L1:
        zipfile = a(abyte0);
        return zipfile;
        zipfile;
        ad.a((new StringBuilder()).append("Error loading theme image: ").append(zipentry.getName()).toString(), zipfile);
        return null;
    }

    public static Bitmap a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        if (Integer.parseInt(android.os.Build.VERSION.SDK) < 4)
        {
            abyte0 = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
            if (ad.J() < 1.0F)
            {
                Bitmap bitmap = Bitmap.createScaledBitmap(abyte0, Math.max(1, Math.round((float)abyte0.getWidth() * ad.J())), Math.max(1, Math.round((float)abyte0.getHeight() * ad.J())), true);
                abyte0.recycle();
                return bitmap;
            } else
            {
                return abyte0;
            }
        } else
        {
            return (new b()).a(abyte0);
        }
    }

    private boolean b(ZipFile zipfile)
    {
        boolean flag = false;
        ZipEntry zipentry;
        byte abyte0[];
        int i;
        try
        {
            zipentry = zipfile.getEntry("theme.json");
        }
        // Misplaced declaration of an exception variable
        catch (ZipFile zipfile)
        {
            ad.a("Error loading theme.json.", zipfile);
            return false;
        }
        if (zipentry == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        abyte0 = new byte[(int)zipentry.getSize()];
        zipfile.getInputStream(zipentry).read(abyte0);
        zipfile = new JSONObject(new String(abyte0));
        i = 0;
_L2:
        if (i >= c.values().length)
        {
            break; /* Loop/switch isn't completed */
        }
        a[i] = zipfile.getInt(c.values()[i].l);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        flag = true;
        return flag;
    }

    public int a(c c1)
    {
        return a[c1.ordinal()];
    }

    public Bitmap a(d d1)
    {
        if (d1 == null)
        {
            return null;
        } else
        {
            return (Bitmap)b.get(d1.X);
        }
    }

    public Bitmap a(String s)
    {
        return (Bitmap)b.get(s);
    }

    public void a()
    {
        boolean flag = false;
        int i = 0;
        int j;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= d.values().length)
            {
                break;
            }
            d d1 = d.values()[i];
            b.put(d1.X, a(d1.W));
            i++;
        } while (true);
        for (; j < c.values().length; j++)
        {
            a[j] = c.values()[j].k;
        }

    }

    public void a(ZipFile zipfile)
    {
        boolean flag = false;
        for (int i = 0; i < c.values().length; i++)
        {
            a[i] = c.values()[i].k;
        }

        if (!b(zipfile))
        {
            a();
        } else
        {
            Enumeration enumeration = zipfile.entries();
            int j;
            do
            {
                j = ((flag) ? 1 : 0);
                if (!enumeration.hasMoreElements())
                {
                    break;
                }
                Object obj = (ZipEntry)enumeration.nextElement();
                String s = ((ZipEntry) (obj)).getName().toLowerCase();
                if (s.endsWith(".png"))
                {
                    s = s.replace(".png", "");
                    obj = a(((ZipEntry) (obj)), zipfile);
                    if (obj != null)
                    {
                        b.put(s, obj);
                    }
                }
            } while (true);
            while (j < d.values().length) 
            {
                zipfile = d.values()[j];
                if ((Bitmap)b.get(((d) (zipfile)).X) == null)
                {
                    Bitmap bitmap = a(((d) (zipfile)).W);
                    b.put(((d) (zipfile)).X, bitmap);
                }
                j++;
            }
        }
    }

    public void b()
    {
        for (Enumeration enumeration = b.keys(); enumeration.hasMoreElements(); ((Bitmap)b.get(enumeration.nextElement())).recycle()) { }
    }
}
