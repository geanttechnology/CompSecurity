// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ck

public static final class ah extends Enum
{

    public static final af A;
    public static final af B;
    public static final af C;
    public static final af D;
    public static final af E;
    public static final af F;
    public static final af G;
    public static final af H;
    public static final af I;
    public static final af J;
    public static final af K;
    public static final af L;
    public static final af M;
    public static final af N;
    public static final af O;
    public static final af P;
    public static final af Q;
    public static final af R;
    public static final af S;
    public static final af T;
    public static final af U;
    public static final af V;
    public static final af W;
    public static final af X;
    public static final af Y;
    public static final af Z;
    public static final af a;
    public static final af aa;
    public static final af ab;
    public static final af ac;
    public static final af ad;
    public static final af ae;
    public static final af af;
    private static final af ai[];
    public static final af b;
    public static final af c;
    public static final af d;
    public static final af e;
    public static final af f;
    public static final af g;
    public static final af h;
    public static final af i;
    public static final af j;
    public static final af k;
    public static final af l;
    public static final af m;
    public static final af n;
    public static final af o;
    public static final af p;
    public static final af q;
    public static final af r;
    public static final af s;
    public static final af t;
    public static final af u;
    public static final af v;
    public static final af w;
    public static final af x;
    public static final af y;
    public static final af z;
    final String ag;
    final boolean ah;

    public static ah valueOf(String s1)
    {
        return (ah)Enum.valueOf(com/amazon/device/ads/ck$a, s1);
    }

    public static ah[] values()
    {
        return (ah[])ai.clone();
    }

    static 
    {
        a = new <init>("AD_LATENCY_TOTAL", 0, "tl", true);
        b = new <init>("AD_LATENCY_TOTAL_SUCCESS", 1, "tsl", true);
        c = new <init>("AD_LATENCY_TOTAL_FAILURE", 2, "tfl", true);
        d = new <init>("AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START", 3, "llfsl", true);
        e = new <init>("AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP", 4, "lfsul");
        f = new <init>("AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START", 5, "lfsasl");
        g = new <init>("AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END", 6, "laefel");
        h = new <init>("AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP", 7, "lffsul");
        i = new <init>("AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START", 8, "lffsrsl", true);
        j = new <init>("AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE", 9, "lffsfl", true);
        k = new <init>("AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL", 10, "lcaul");
        l = new <init>("ASSETS_CREATED_LATENCY", 11, "lacl");
        m = new <init>("ASSETS_ENSURED_LATENCY", 12, "lael");
        n = new <init>("ASSETS_FAILED", 13, "af");
        o = new <init>("AD_LOADED_TO_AD_SHOW_TIME", 14, "alast");
        p = new <init>("AD_SHOW_LATENCY", 15, "lsa");
        q = new <init>("AD_SHOW_DURATION", 16, "sd", true);
        r = new <init>("AD_LAYOUT_INITIALIZATION", 17, "ali");
        s = new <init>("AAX_LATENCY_GET_AD", 18, "al");
        t = new <init>("AD_LOAD_FAILED", 19, "lf");
        u = new <init>("AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT", 20, "lfat");
        v = new <init>("AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT", 21, "lfpt", true);
        w = new <init>("AD_COUNTER_IDENTIFIED_DEVICE", 22, "id");
        x = new <init>("AD_COUNTER_RENDERING_FATAL", 23, "rf", true);
        y = new <init>("AD_LATENCY_RENDER", 24, "rl", true);
        z = new <init>("AD_LATENCY_RENDER_FAILED", 25, "rlf", true);
        A = new <init>("AD_COUNTER_FAILED_DUE_TO_NO_RETRY", 26, "nrtf");
        B = new <init>("AD_NO_RETRY_TTL_RECEIVED", 27, "nrtr");
        C = new <init>("AD_COUNTER_AUTO_AD_SIZE", 28, "aas");
        D = new <init>("AD_COUNTER_PARENT_VIEW_MISSING", 29, "pvm");
        E = new <init>("ADLAYOUT_HEIGHT_ZERO", 30, "ahz");
        F = new <init>("VIEWPORT_SCALE", 31, "vs");
        G = new <init>("AD_COUNTER_RESHOWN", 32, "rs", true);
        H = new <init>("AD_FAILED_UNKNOWN_WEBVIEW_ISSUE", 33, "fuwi");
        I = new <init>("AD_FAILED_NULL_LAYOUT_PARAMS", 34, "fnlp");
        J = new <init>("AD_FAILED_LAYOUT_NOT_RUN", 35, "flnr");
        K = new <init>("AD_FAILED_INVALID_AUTO_AD_SIZE", 36, "faas");
        L = new <init>("SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED", 37, "sid");
        M = new <init>("SIS_LATENCY_REGISTER", 38, "srl");
        N = new <init>("SIS_LATENCY_UPDATE_DEVICE_INFO", 39, "sul");
        O = new <init>("SIS_LATENCY_REGISTER_EVENT", 40, "srel");
        P = new <init>("CONFIG_DOWNLOAD_ERROR", 41, "cde");
        Q = new <init>("CONFIG_DOWNLOAD_LATENCY", 42, "cdt");
        R = new <init>("CONFIG_PARSE_ERROR", 43, "cpe");
        S = new <init>("AAX_CONFIG_DOWNLOAD_LATENCY", 44, "acl");
        T = new <init>("AAX_CONFIG_DOWNLOAD_FAILED", 45, "acf");
        U = new <init>("CUSTOM_RENDER_HANDLED", 46, "crh");
        V = new <init>("TLS_ENABLED", 47, "tls");
        W = new <init>("WIFI_PRESENT", 48, "wifi");
        X = new <init>("CARRIER_NAME", 49, "car");
        Y = new <init>("CONNECTION_TYPE", 50, "ct");
        Z = new <init>("AD_IS_INTERSTITIAL", 51, "i");
        aa = new <init>("INTERSTITIAL_AD_ACTIVITY_FAILED", 52, "iaaf");
        ab = new <init>("RENDER_REQUIREMENT_CHECK_FAILURE", 53, "rrcfc", true);
        ac = new <init>("EXPIRED_AD_CALL", 54, "eac", true);
        ad = new <init>("AD_ASPECT_RATIO_LESS_THAN_SCREEN_ASPECT_RATIO", 55, "rarfc", true);
        ae = new <init>("SET_ORIENTATION_FAILURE", 56, "rsofc", true);
        af = new <init>("AD_EXPIRED_BEFORE_SHOWING", 57, "aebs", true);
        ai = (new ai[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D, 
            E, F, G, H, I, J, K, L, M, N, 
            O, P, Q, R, S, T, U, V, W, X, 
            Y, Z, aa, ab, ac, ad, ae, af
        });
    }

    private (String s1, int i1, String s2)
    {
        this(s1, i1, s2, false);
    }

    private <init>(String s1, int i1, String s2, boolean flag)
    {
        super(s1, i1);
        ag = s2;
        ah = flag;
    }
}
