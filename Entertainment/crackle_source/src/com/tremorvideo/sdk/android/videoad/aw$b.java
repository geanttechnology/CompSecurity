// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;


// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aw

public static final class aD extends Enum
{

    public static final az A;
    public static final az B;
    public static final az C;
    public static final az D;
    public static final az E;
    public static final az F;
    public static final az G;
    public static final az H;
    public static final az I;
    public static final az J;
    public static final az K;
    public static final az L;
    public static final az M;
    public static final az N;
    public static final az O;
    public static final az P;
    public static final az Q;
    public static final az R;
    public static final az S;
    public static final az T;
    public static final az U;
    public static final az V;
    public static final az W;
    public static final az X;
    public static final az Y;
    public static final az Z;
    public static final az a;
    private static final az aE[];
    public static final az aa;
    public static final az ab;
    public static final az ac;
    public static final az ad;
    public static final az ae;
    public static final az af;
    public static final az ag;
    public static final az ah;
    public static final az ai;
    public static final az aj;
    public static final az ak;
    public static final az al;
    public static final az am;
    public static final az an;
    public static final az ao;
    public static final az ap;
    public static final az aq;
    public static final az ar;
    public static final az as;
    public static final az at;
    public static final az au;
    public static final az av;
    public static final az aw;
    public static final az ax;
    public static final az ay;
    public static final az az;
    public static final az b;
    public static final az c;
    public static final az d;
    public static final az e;
    public static final az f;
    public static final az g;
    public static final az h;
    public static final az i;
    public static final az j;
    public static final az k;
    public static final az l;
    public static final az m;
    public static final az n;
    public static final az o;
    public static final az p;
    public static final az q;
    public static final az r;
    public static final az s;
    public static final az t;
    public static final az u;
    public static final az v;
    public static final az w;
    public static final az x;
    public static final az y;
    public static final az z;
    private String aA;
    private boolean aB;
    private String aC;
    private az aD;

    public static aD a(String s1)
    {
        aD aad[] = values();
        int j1 = aad.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            aD ad1 = aad[i1];
            if (ad1.toString().equalsIgnoreCase(s1))
            {
                return ad1;
            }
        }

        return ar;
    }

    public static ar valueOf(String s1)
    {
        return (ar)Enum.valueOf(com/tremorvideo/sdk/android/videoad/aw$b, s1);
    }

    public static ar[] values()
    {
        return (ar[])aE.clone();
    }

    public boolean a()
    {
        return aB;
    }

    public aB b()
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
        a = new <init>("Invalid", 0, "", false, "", null);
        b = new <init>("Web", 1, "click-to-web", true, "Web", a);
        c = new <init>("Call", 2, "click-to-call", true, "Call", b);
        d = new <init>("MP3Store", 3, "click-to-mp3store", true, "MP3", c);
        e = new <init>("Twitter", 4, "click-to-twitter", true, "Twitter", e);
        f = new <init>("Market", 5, "click-to-market", true, "Market", d);
        g = new <init>("Facebook", 6, "click-to-facebook", true, "Facebook", f);
        h = new <init>("Ticket", 7, "click-to-tickets", true, "Tickets", g);
        i = new <init>("Youtube", 8, "click-to-youtube", true, "Youtube", h);
        j = new <init>("Timer", 9, "timer", false, "", null);
        k = new <init>("ExternalSurveyIntiated", 10, "external-survey-init", false, "", null);
        l = new <init>("ExternalSurveyStart", 11, "external-survey-start", false, "", j);
        m = new <init>("ExternalSurveyEnd", 12, "external-survey-end", false, "", null);
        n = new <init>("ExternalSurveySkip", 13, "external-survey-skip", false, "", null);
        o = new <init>("ExternalSurveyButton", 14, "survey", false, "Survey", d);
        p = new <init>("TwitterTweet", 15, "twitter-tweet", true, "Tweet", e);
        q = new <init>("Map", 16, "click-to-map", true, "Map", m);
        r = new <init>("Share", 17, "click-to-share", true, "Share", k);
        s = new <init>("ShareEmail", 18, "share-email", true, "Share", k);
        t = new <init>("ShareSMS", 19, "share-sms", true, "Share", k);
        u = new <init>("PostToFacebook", 20, "post-to-facebook", true, "Post", f);
        v = new <init>("Skip", 21, "skip", false, "Skip", i);
        w = new <init>("Replay", 22, "replay", false, "Replay", v);
        x = new <init>("Vibrate", 23, "timer-vibration", false, "Vibrate", null);
        y = new <init>("AdStart", 24, "ad-start", false, "Ad Start", null);
        z = new <init>("AdComplete", 25, "ad-complete", false, "Ad Complete", null);
        A = new <init>("CouponSave", 26, "save-coupon", true, "Save", d);
        B = new <init>("CouponShow", 27, "show-coupon", true, "Coupon", n);
        C = new <init>("CouponAutoDisplay", 28, "coupon-auto-display", false, "", null);
        D = new <init>("CouponSkip", 29, "coupon-skip", true, "Done", i);
        E = new <init>("CouponBack", 30, "coupon-back", true, "Done", i);
        F = new <init>("Date", 31, "show-date", true, "Date", l);
        G = new <init>("Zip", 32, "show-zip", false, "Date", null);
        H = new <init>("AdChoices", 33, "ad-choices", false, "", null);
        I = new <init>("TMS", 34, "click-to-tms", false, "", null);
        J = new <init>("TMSZipClick", 35, "tms-zip-click", false, "", null);
        K = new <init>("TMSDateClick", 36, "tms-date-click", false, "", null);
        L = new <init>("AgeGate", 37, "age-gate", false, "", null);
        M = new <init>("CouponShare", 38, "coupon-share", true, "Share", k);
        N = new <init>("CouponShareSMS", 39, "coupon-share-sms", true, "Share SMS", k);
        O = new <init>("CouponShareEmail", 40, "coupon-share-email", true, "Share Email", k);
        P = new <init>("InternalSurveyStart", 41, "internal-survey-start", false, "", null);
        Q = new <init>("InternalSurveySkip", 42, "internal-survey-skip", false, "", null);
        R = new <init>("InternalSurveySubmit", 43, "internal-survey-submit", false, "", null);
        S = new <init>("BuyItNow", 44, "buy-now", true, "", n);
        T = new <init>("BuyItNowStart", 45, "buy-now-start", false, "", null);
        U = new <init>("BuyItNowClick", 46, "buy-now-click", false, "", null);
        V = new <init>("BuyItNowSkip", 47, "buy-now-skip", false, "", null);
        W = new <init>("BuyItNowEnd", 48, "buy-now-end", false, "", null);
        X = new <init>("MovieBoard", 49, "tms-movie-board", true, "", n);
        Y = new <init>("MovieBoardStart", 50, "movie-board-start", false, "", null);
        Z = new <init>("MovieBoardEnd", 51, "movie-board-end", false, "", null);
        aa = new <init>("MovieBoardSkip", 52, "movie-board-skip", false, "", null);
        ab = new <init>("MovieBoardClickDate", 53, "movie-board-click-date", false, "", null);
        ac = new <init>("MovieBoardClickZip", 54, "movie-board-click-zip", false, "", null);
        ad = new <init>("MovieBoardClickShowTime", 55, "movie-board-click-ShowTime", false, "", null);
        ae = new <init>("MovieBoardClickMap", 56, "movie-board-click-map", false, "", null);
        af = new <init>("MovieBoardClickLogo", 57, "movie-board-click-logo", false, "", null);
        ag = new <init>("VideoImpression", 58, "video-impression", false, "", null);
        ah = new <init>("VideoStart", 59, "video-start", false, "", null);
        ai = new <init>("VideoQuater1", 60, "video-first-quarter", false, "", null);
        aj = new <init>("VideoQuater2", 61, "video-midpoint", false, "", null);
        ak = new <init>("VideoQuater3", 62, "video-third-quarter", false, "", null);
        al = new <init>("VideoEnd", 63, "video-end", false, "", null);
        am = new <init>("TwitterFeed", 64, "twitter-feed", false, "", null);
        an = new <init>("TwitterFeedClickIcon", 65, "twitter-feed-click-icon", false, "", null);
        ao = new <init>("TwitterFeedClickBody", 66, "twitter-feed-click-body", false, "", null);
        ap = new <init>("TwitterFeedClickRetweet", 67, "twitter-feed-click-retweet", false, "", null);
        aq = new <init>("ViewComplete", 68, "view-complete", false, "", null);
        ar = new <init>("Custom", 69, "custom", false, "", null);
        as = new <init>("ShowGenericComponent", 70, "show-generic-component", false, "", null);
        at = new <init>("Provider", 71, "show-provider", false, "", null);
        au = new <init>("ZIPCALLBACK", 72, "show-zip-callback", false, "", null);
        av = new <init>("TouchTracking", 73, "touch", false, "", null);
        aw = new <init>("Email", 74, "email", false, "", null);
        ax = new <init>("EmailSuccess", 75, "email-success", false, "", null);
        ay = new <init>("EmailFailure", 76, "email-failure", false, "", null);
        az = new <init>("EmailBox", 77, "email-box-click", false, "", null);
        aE = (new aE[] {
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

    private (String s1, int i1, String s2, boolean flag, String s3,  )
    {
        super(s1, i1);
        aA = s2;
        aB = flag;
        aC = s3;
        aD = ;
    }
}
