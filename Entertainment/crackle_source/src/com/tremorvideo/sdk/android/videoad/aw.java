// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.webkit.URLUtil;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bw, ad

public class aw
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a f[];
        private String e;

        public static a a(String s)
        {
            a aa[] = values();
            int j1 = aa.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                a a1 = aa[i1];
                if (a1.toString().equalsIgnoreCase(s))
                {
                    return a1;
                }
            }

            return d;
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/tremorvideo/sdk/android/videoad/aw$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        public String toString()
        {
            return e;
        }

        static 
        {
            a = new a("ClickToAppStore", 0, "click-to-appstore");
            b = new a("ClickToBlackberryMarket", 1, "click-to-blackberrymarket");
            c = new a("ClickToITunes", 2, "click-to-itunes");
            d = new a("None", 3, "none");
            f = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i1, String s1)
        {
            super(s, i1);
            e = s1;
        }
    }

    public static final class b extends Enum
    {

        public static final b A;
        public static final b B;
        public static final b C;
        public static final b D;
        public static final b E;
        public static final b F;
        public static final b G;
        public static final b H;
        public static final b I;
        public static final b J;
        public static final b K;
        public static final b L;
        public static final b M;
        public static final b N;
        public static final b O;
        public static final b P;
        public static final b Q;
        public static final b R;
        public static final b S;
        public static final b T;
        public static final b U;
        public static final b V;
        public static final b W;
        public static final b X;
        public static final b Y;
        public static final b Z;
        public static final b a;
        private static final b aE[];
        public static final b aa;
        public static final b ab;
        public static final b ac;
        public static final b ad;
        public static final b ae;
        public static final b af;
        public static final b ag;
        public static final b ah;
        public static final b ai;
        public static final b aj;
        public static final b ak;
        public static final b al;
        public static final b am;
        public static final b an;
        public static final b ao;
        public static final b ap;
        public static final b aq;
        public static final b ar;
        public static final b as;
        public static final b at;
        public static final b au;
        public static final b av;
        public static final b aw;
        public static final b ax;
        public static final b ay;
        public static final b az;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        public static final b g;
        public static final b h;
        public static final b i;
        public static final b j;
        public static final b k;
        public static final b l;
        public static final b m;
        public static final b n;
        public static final b o;
        public static final b p;
        public static final b q;
        public static final b r;
        public static final b s;
        public static final b t;
        public static final b u;
        public static final b v;
        public static final b w;
        public static final b x;
        public static final b y;
        public static final b z;
        private String aA;
        private boolean aB;
        private String aC;
        private bv.d aD;

        public static b a(String s1)
        {
            b ab1[] = values();
            int j1 = ab1.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                b b1 = ab1[i1];
                if (b1.toString().equalsIgnoreCase(s1))
                {
                    return b1;
                }
            }

            return ar;
        }

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/videoad/aw$b, s1);
        }

        public static b[] values()
        {
            return (b[])aE.clone();
        }

        public boolean a()
        {
            return aB;
        }

        public bv.d b()
        {
            return aD;
        }

        public String c()
        {
            return aC;
        }

        public String toString()
        {
            return aA;
        }

        static 
        {
            a = new b("Invalid", 0, "", false, "", null);
            b = new b("Web", 1, "click-to-web", true, "Web", bv.d.a);
            c = new b("Call", 2, "click-to-call", true, "Call", bv.d.b);
            d = new b("MP3Store", 3, "click-to-mp3store", true, "MP3", bv.d.c);
            e = new b("Twitter", 4, "click-to-twitter", true, "Twitter", bv.d.e);
            f = new b("Market", 5, "click-to-market", true, "Market", bv.d.d);
            g = new b("Facebook", 6, "click-to-facebook", true, "Facebook", bv.d.f);
            h = new b("Ticket", 7, "click-to-tickets", true, "Tickets", bv.d.g);
            i = new b("Youtube", 8, "click-to-youtube", true, "Youtube", bv.d.h);
            j = new b("Timer", 9, "timer", false, "", null);
            k = new b("ExternalSurveyIntiated", 10, "external-survey-init", false, "", null);
            l = new b("ExternalSurveyStart", 11, "external-survey-start", false, "", bv.d.j);
            m = new b("ExternalSurveyEnd", 12, "external-survey-end", false, "", null);
            n = new b("ExternalSurveySkip", 13, "external-survey-skip", false, "", null);
            o = new b("ExternalSurveyButton", 14, "survey", false, "Survey", bv.d.d);
            p = new b("TwitterTweet", 15, "twitter-tweet", true, "Tweet", bv.d.e);
            q = new b("Map", 16, "click-to-map", true, "Map", bv.d.m);
            r = new b("Share", 17, "click-to-share", true, "Share", bv.d.k);
            s = new b("ShareEmail", 18, "share-email", true, "Share", bv.d.k);
            t = new b("ShareSMS", 19, "share-sms", true, "Share", bv.d.k);
            u = new b("PostToFacebook", 20, "post-to-facebook", true, "Post", bv.d.f);
            v = new b("Skip", 21, "skip", false, "Skip", bv.d.i);
            w = new b("Replay", 22, "replay", false, "Replay", bv.d.v);
            x = new b("Vibrate", 23, "timer-vibration", false, "Vibrate", null);
            y = new b("AdStart", 24, "ad-start", false, "Ad Start", null);
            z = new b("AdComplete", 25, "ad-complete", false, "Ad Complete", null);
            A = new b("CouponSave", 26, "save-coupon", true, "Save", bv.d.d);
            B = new b("CouponShow", 27, "show-coupon", true, "Coupon", bv.d.n);
            C = new b("CouponAutoDisplay", 28, "coupon-auto-display", false, "", null);
            D = new b("CouponSkip", 29, "coupon-skip", true, "Done", bv.d.i);
            E = new b("CouponBack", 30, "coupon-back", true, "Done", bv.d.i);
            F = new b("Date", 31, "show-date", true, "Date", bv.d.l);
            G = new b("Zip", 32, "show-zip", false, "Date", null);
            H = new b("AdChoices", 33, "ad-choices", false, "", null);
            I = new b("TMS", 34, "click-to-tms", false, "", null);
            J = new b("TMSZipClick", 35, "tms-zip-click", false, "", null);
            K = new b("TMSDateClick", 36, "tms-date-click", false, "", null);
            L = new b("AgeGate", 37, "age-gate", false, "", null);
            M = new b("CouponShare", 38, "coupon-share", true, "Share", bv.d.k);
            N = new b("CouponShareSMS", 39, "coupon-share-sms", true, "Share SMS", bv.d.k);
            O = new b("CouponShareEmail", 40, "coupon-share-email", true, "Share Email", bv.d.k);
            P = new b("InternalSurveyStart", 41, "internal-survey-start", false, "", null);
            Q = new b("InternalSurveySkip", 42, "internal-survey-skip", false, "", null);
            R = new b("InternalSurveySubmit", 43, "internal-survey-submit", false, "", null);
            S = new b("BuyItNow", 44, "buy-now", true, "", bv.d.n);
            T = new b("BuyItNowStart", 45, "buy-now-start", false, "", null);
            U = new b("BuyItNowClick", 46, "buy-now-click", false, "", null);
            V = new b("BuyItNowSkip", 47, "buy-now-skip", false, "", null);
            W = new b("BuyItNowEnd", 48, "buy-now-end", false, "", null);
            X = new b("MovieBoard", 49, "tms-movie-board", true, "", bv.d.n);
            Y = new b("MovieBoardStart", 50, "movie-board-start", false, "", null);
            Z = new b("MovieBoardEnd", 51, "movie-board-end", false, "", null);
            aa = new b("MovieBoardSkip", 52, "movie-board-skip", false, "", null);
            ab = new b("MovieBoardClickDate", 53, "movie-board-click-date", false, "", null);
            ac = new b("MovieBoardClickZip", 54, "movie-board-click-zip", false, "", null);
            ad = new b("MovieBoardClickShowTime", 55, "movie-board-click-ShowTime", false, "", null);
            ae = new b("MovieBoardClickMap", 56, "movie-board-click-map", false, "", null);
            af = new b("MovieBoardClickLogo", 57, "movie-board-click-logo", false, "", null);
            ag = new b("VideoImpression", 58, "video-impression", false, "", null);
            ah = new b("VideoStart", 59, "video-start", false, "", null);
            ai = new b("VideoQuater1", 60, "video-first-quarter", false, "", null);
            aj = new b("VideoQuater2", 61, "video-midpoint", false, "", null);
            ak = new b("VideoQuater3", 62, "video-third-quarter", false, "", null);
            al = new b("VideoEnd", 63, "video-end", false, "", null);
            am = new b("TwitterFeed", 64, "twitter-feed", false, "", null);
            an = new b("TwitterFeedClickIcon", 65, "twitter-feed-click-icon", false, "", null);
            ao = new b("TwitterFeedClickBody", 66, "twitter-feed-click-body", false, "", null);
            ap = new b("TwitterFeedClickRetweet", 67, "twitter-feed-click-retweet", false, "", null);
            aq = new b("ViewComplete", 68, "view-complete", false, "", null);
            ar = new b("Custom", 69, "custom", false, "", null);
            as = new b("ShowGenericComponent", 70, "show-generic-component", false, "", null);
            at = new b("Provider", 71, "show-provider", false, "", null);
            au = new b("ZIPCALLBACK", 72, "show-zip-callback", false, "", null);
            av = new b("TouchTracking", 73, "touch", false, "", null);
            aw = new b("Email", 74, "email", false, "", null);
            ax = new b("EmailSuccess", 75, "email-success", false, "", null);
            ay = new b("EmailFailure", 76, "email-failure", false, "", null);
            az = new b("EmailBox", 77, "email-box-click", false, "", null);
            aE = (new b[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r, s, t, 
                u, v, w, x, y, z, A, B, C, D, 
                E, F, G, H, I, J, K, L, M, N, 
                O, P, Q, R, S, T, U, V, W, X, 
                Y, Z, aa, ab, ac, ad, ae, af, ag, ah, 
                ai, aj, ak, al, am, an, ao, ap, aq, ar, 
                as, at, au, av, aw, ax, ay, az
            });
        }

        private b(String s1, int i1, String s2, boolean flag, String s3, bv.d d1)
        {
            super(s1, i1);
            aA = s2;
            aB = flag;
            aC = s3;
            aD = d1;
        }
    }


    private b a;
    private String b;
    private String c;
    private bw d[];
    private String e;
    private String f;
    private boolean g;
    private int h;
    private int i;
    private boolean j;
    private Dictionary k;
    private int l;
    private String m;
    private a n;
    private Map o;
    private int p;

    public aw(b b1, int i1, bw abw[])
    {
        this(b1, i1, abw, -1);
    }

    public aw(b b1, int i1, bw abw[], int j1)
    {
        a = b1;
        b = b1.c();
        c = "";
        d = abw;
        e = "";
        f = "0";
        g = true;
        h = 0;
        i = i1;
        j = true;
        l = -1;
        m = "";
        n = a.d;
        p = j1;
    }

    public aw(b b1, String s, bw abw[])
    {
        this(b1, s, abw, -1);
    }

    public aw(b b1, String s, bw abw[], int i1)
    {
        a = b1;
        b = b1.c();
        c = "";
        d = abw;
        e = s;
        f = "-1";
        g = true;
        h = 0;
        i = 0;
        j = true;
        l = -1;
        m = "";
        n = a.d;
        p = i1;
    }

    public aw(JSONObject jsonobject)
        throws Exception
    {
        l = -1;
        String s;
        ArrayList arraylist;
        if (jsonobject.has("id"))
        {
            f = jsonobject.getString("id");
        } else
        {
            f = "0";
        }
        if (jsonobject.has("billable"))
        {
            g = jsonobject.getBoolean("billable");
        }
        if (jsonobject.has("type"))
        {
            s = jsonobject.getString("type");
            a = b.a(s);
            n = a.a(s);
        } else
        {
            a = b.ar;
            n = a.d;
            s = null;
        }
        if (jsonobject.has("order"))
        {
            h = jsonobject.getInt("order");
        } else
        {
            h = 0;
        }
        if (jsonobject.has("text"))
        {
            b = jsonobject.getString("text");
        } else
        {
            b = "";
        }
        arraylist = new ArrayList();
        if (jsonobject.has("tracking-url"))
        {
            try
            {
                String s1 = a(jsonobject, "tracking-url");
                if (URLUtil.isValidUrl(s1))
                {
                    arraylist.add(new bw(s1));
                }
            }
            catch (Exception exception)
            {
                ad.a(exception);
            }
        }
        if (jsonobject.has("tracking"))
        {
            JSONArray jsonarray = jsonobject.getJSONArray("tracking");
            int i1 = 0;
            bw bw1 = null;
            for (; i1 < jsonarray.length(); i1++)
            {
                JSONObject jsonobject1 = jsonarray.getJSONObject(i1);
                if (jsonobject1 != null)
                {
                    bw1 = bw.a(jsonobject1);
                }
                if (bw1 != null)
                {
                    arraylist.add(bw1);
                }
            }

        }
        if (d == null)
        {
            d = (bw[])arraylist.toArray(new bw[arraylist.size()]);
        } else
        {
            bw abw[] = (bw[])arraylist.toArray(new bw[arraylist.size()]);
            bw abw1[] = new bw[d.length + abw.length];
            System.arraycopy(d, 0, abw1, 0, d.length);
            System.arraycopy(abw, 0, abw1, abw1.length, d.length);
            d = abw1;
        }
        e = a(jsonobject, "click-url");
        if (jsonobject.has("tag"))
        {
            m = jsonobject.getString("tag");
        } else
        {
            m = null;
        }
        if (jsonobject.has("icon"))
        {
            c = jsonobject.getString("icon");
        } else
        {
            c = null;
        }
        if (jsonobject.has("event-trigger-secs"))
        {
            i = (int)Math.round(jsonobject.getDouble("event-trigger-secs") * 1000D);
        } else
        {
            i = 0;
        }
        if (jsonobject.has("pre-event-trigger"))
        {
            j = jsonobject.getBoolean("pre-event-trigger");
        } else
        {
            j = false;
        }
        if (jsonobject.has("activity-trigger-secs"))
        {
            l = (int)Math.round(jsonobject.getDouble("activity-trigger-secs") * 1000D);
        }
        if (a == b.q)
        {
            f(jsonobject);
        } else
        {
            if (a == b.u)
            {
                e(jsonobject);
                return;
            }
            if (a == b.x)
            {
                g(jsonobject);
                return;
            }
            if (a == b.w)
            {
                h(jsonobject);
                return;
            }
            if (a == b.r)
            {
                i(jsonobject);
                return;
            }
            if (a == b.s)
            {
                i(jsonobject);
                return;
            }
            if (a == b.t)
            {
                i(jsonobject);
                return;
            }
            if (a == b.O)
            {
                i(jsonobject);
                return;
            }
            if (a == b.N)
            {
                i(jsonobject);
                return;
            }
            if (a == b.M)
            {
                i(jsonobject);
                return;
            }
            if (a == b.p)
            {
                d(jsonobject);
                return;
            }
            if (a == b.H)
            {
                a(jsonobject);
                return;
            }
            if (a == b.I)
            {
                b(jsonobject);
                return;
            }
            if (a == b.L)
            {
                c(jsonobject);
                return;
            }
            if (a == b.am)
            {
                j(jsonobject);
                return;
            }
            if (a == b.ar)
            {
                if (s == null)
                {
                    s = "";
                }
                b = s;
                return;
            }
        }
    }

    private static String a(JSONObject jsonobject, String s)
    {
        try
        {
            jsonobject = jsonobject.getString(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return null;
        }
        return jsonobject;
    }

    private static void a(Dictionary dictionary, JSONObject jsonobject, String s)
    {
        jsonobject = a(jsonobject, s);
        if (jsonobject != null)
        {
            dictionary.put(s, jsonobject);
        }
    }

    private void a(JSONObject jsonobject)
    {
        k = new Hashtable();
        a(k, jsonobject, "location");
    }

    public static String b(b b1)
    {
        return b1.c();
    }

    private void b(JSONObject jsonobject)
    {
        k = new Hashtable();
        a(k, jsonobject, "zip");
        a(k, jsonobject, "movie");
        a(k, jsonobject, "movie-date");
    }

    private void c(JSONObject jsonobject)
    {
        k = new Hashtable();
        a(k, jsonobject, "age");
    }

    private void d(JSONObject jsonobject)
    {
        k = new Hashtable();
        a(k, jsonobject, "message");
    }

    private void e(JSONObject jsonobject)
    {
        k = new Hashtable();
        a(k, jsonobject, "description");
        a(k, jsonobject, "image");
        a(k, jsonobject, "message");
        a(k, jsonobject, "link");
        a(k, jsonobject, "name");
        a(k, jsonobject, "video");
    }

    private void f(JSONObject jsonobject)
    {
        k = new Hashtable();
        a(k, jsonobject, "map-type");
        a(k, jsonobject, "latitude");
        a(k, jsonobject, "longitude");
        a(k, jsonobject, "pinpoint-name");
        a(k, jsonobject, "query");
        a(k, jsonobject, "zoom");
        a(k, jsonobject, "retailigence-endpoint");
        a(k, jsonobject, "html-template-path");
    }

    private void g(JSONObject jsonobject)
    {
        k = new Hashtable();
        a(k, jsonobject, "duration");
    }

    private void h(JSONObject jsonobject)
    {
        k = new Hashtable();
        a(k, jsonobject, "auto-skip");
    }

    private void i(JSONObject jsonobject)
    {
        k = new Hashtable();
        a(k, jsonobject, "message");
        a(k, jsonobject, "subject");
    }

    private void j(JSONObject jsonobject)
    {
        k = new Hashtable();
        a(k, jsonobject, "query-url");
    }

    public int a(String s, int i1)
    {
        String s1;
        int j1;
        try
        {
            s1 = (String)k.get(s);
        }
        catch (Exception exception)
        {
            ad.a((new StringBuilder()).append("Could not get integer parameter: ").append(s).toString(), exception);
            return i1;
        }
        j1 = i1;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        j1 = Integer.parseInt(s1);
        return j1;
    }

    public b a()
    {
        return a;
    }

    public String a(String s, String s1)
    {
        String s2 = (String)k.get(s);
        if (s2 != null)
        {
            return s2;
        }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        ad.a((new StringBuilder()).append("Could not get string parameter: ").append(s).toString(), exception);
        return s1;
    }

    public void a(b b1)
    {
        a = b1;
    }

    public void a(ay.a a1)
    {
        ad.d((new StringBuilder()).append("Start firing tracking for: ").append(a().toString()).append(" ").append(c()).toString());
        bw abw[] = d;
        int j1 = abw.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            abw[i1].a(a1);
        }

        ad.d((new StringBuilder()).append("Finished firing tracking for: ").append(a().toString()).append(" ").append(c()).toString());
    }

    public int b()
    {
        return l;
    }

    public void b(String s, String s1)
    {
        if (o == null)
        {
            o = new HashMap();
        }
        o.put(s, s1);
    }

    public String c()
    {
        return f;
    }

    public String d()
    {
        return m;
    }

    public int e()
    {
        return i;
    }

    public Dictionary f()
    {
        return k;
    }

    public boolean g()
    {
        return j;
    }

    public String h()
    {
        return b;
    }

    public int i()
    {
        return h;
    }

    public String j()
    {
        return e;
    }

    public int k()
    {
        return p;
    }

    public boolean l()
    {
        if (!a.a())
        {
            return false;
        } else
        {
            return m();
        }
    }

    public boolean m()
    {
        boolean flag1 = false;
        boolean flag;
        if (a == b.c)
        {
            flag = ad.r();
        } else
        {
            flag = flag1;
            if (!n())
            {
                flag = flag1;
                if (ad.a(a))
                {
                    return true;
                }
            }
        }
        return flag;
    }

    public boolean n()
    {
        return n != a.d;
    }

    public String o()
    {
        if (c != null)
        {
            return c;
        } else
        {
            return a.b().X;
        }
    }

    public boolean p()
    {
        return a.equals(b.ah) || a.equals(b.ag) || a.equals(b.ai) || a.equals(b.aj) || a.equals(b.ak) || a.equals(b.al) || a.equals(b.aq);
    }
}
