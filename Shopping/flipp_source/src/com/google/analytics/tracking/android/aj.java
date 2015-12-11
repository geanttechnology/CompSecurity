// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


public final class aj extends Enum
{

    public static final aj A;
    public static final aj B;
    public static final aj C;
    public static final aj D;
    public static final aj E;
    public static final aj F;
    public static final aj G;
    public static final aj H;
    public static final aj I;
    public static final aj J;
    public static final aj K;
    public static final aj L;
    public static final aj M;
    public static final aj N;
    public static final aj O;
    public static final aj P;
    public static final aj Q;
    public static final aj R;
    public static final aj S;
    public static final aj T;
    public static final aj U;
    public static final aj V;
    public static final aj W;
    public static final aj X;
    public static final aj Y;
    public static final aj Z;
    public static final aj a;
    public static final aj aa;
    public static final aj ab;
    public static final aj ac;
    public static final aj ad;
    public static final aj ae;
    public static final aj af;
    public static final aj ag;
    public static final aj ah;
    public static final aj ai;
    public static final aj aj;
    public static final aj ak;
    private static final aj al[];
    public static final aj b;
    public static final aj c;
    public static final aj d;
    public static final aj e;
    public static final aj f;
    public static final aj g;
    public static final aj h;
    public static final aj i;
    public static final aj j;
    public static final aj k;
    public static final aj l;
    public static final aj m;
    public static final aj n;
    public static final aj o;
    public static final aj p;
    public static final aj q;
    public static final aj r;
    public static final aj s;
    public static final aj t;
    public static final aj u;
    public static final aj v;
    public static final aj w;
    public static final aj x;
    public static final aj y;
    public static final aj z;

    private aj(String s1, int i1)
    {
        super(s1, i1);
    }

    public static aj valueOf(String s1)
    {
        return (aj)Enum.valueOf(com/google/analytics/tracking/android/aj, s1);
    }

    public static aj[] values()
    {
        return (aj[])al.clone();
    }

    static 
    {
        a = new aj("MAP_BUILDER_SET", 0);
        b = new aj("MAP_BUILDER_SET_ALL", 1);
        c = new aj("MAP_BUILDER_GET", 2);
        d = new aj("MAP_BUILDER_SET_CAMPAIGN_PARAMS", 3);
        e = new aj("BLANK_04", 4);
        f = new aj("BLANK_05", 5);
        g = new aj("BLANK_06", 6);
        h = new aj("BLANK_07", 7);
        i = new aj("BLANK_08", 8);
        j = new aj("GET", 9);
        k = new aj("SET", 10);
        l = new aj("SEND", 11);
        m = new aj("BLANK_12", 12);
        n = new aj("BLANK_13", 13);
        o = new aj("BLANK_14", 14);
        p = new aj("BLANK_15", 15);
        q = new aj("BLANK_16", 16);
        r = new aj("BLANK_17", 17);
        s = new aj("BLANK_18", 18);
        t = new aj("BLANK_19", 19);
        u = new aj("BLANK_20", 20);
        v = new aj("BLANK_21", 21);
        w = new aj("BLANK_22", 22);
        x = new aj("BLANK_23", 23);
        y = new aj("BLANK_24", 24);
        z = new aj("BLANK_25", 25);
        A = new aj("BLANK_26", 26);
        B = new aj("BLANK_27", 27);
        C = new aj("BLANK_28", 28);
        D = new aj("BLANK_29", 29);
        E = new aj("SET_EXCEPTION_PARSER", 30);
        F = new aj("GET_EXCEPTION_PARSER", 31);
        G = new aj("CONSTRUCT_TRANSACTION", 32);
        H = new aj("CONSTRUCT_EXCEPTION", 33);
        I = new aj("CONSTRUCT_RAW_EXCEPTION", 34);
        J = new aj("CONSTRUCT_TIMING", 35);
        K = new aj("CONSTRUCT_SOCIAL", 36);
        L = new aj("BLANK_37", 37);
        M = new aj("BLANK_38", 38);
        N = new aj("GET_TRACKER", 39);
        O = new aj("GET_DEFAULT_TRACKER", 40);
        P = new aj("SET_DEFAULT_TRACKER", 41);
        Q = new aj("SET_APP_OPT_OUT", 42);
        R = new aj("GET_APP_OPT_OUT", 43);
        S = new aj("DISPATCH", 44);
        T = new aj("SET_DISPATCH_PERIOD", 45);
        U = new aj("BLANK_46", 46);
        V = new aj("REPORT_UNCAUGHT_EXCEPTIONS", 47);
        W = new aj("SET_AUTO_ACTIVITY_TRACKING", 48);
        X = new aj("SET_SESSION_TIMEOUT", 49);
        Y = new aj("CONSTRUCT_EVENT", 50);
        Z = new aj("CONSTRUCT_ITEM", 51);
        aa = new aj("BLANK_52", 52);
        ab = new aj("BLANK_53", 53);
        ac = new aj("SET_DRY_RUN", 54);
        ad = new aj("GET_DRY_RUN", 55);
        ae = new aj("SET_LOGGER", 56);
        af = new aj("SET_FORCE_LOCAL_DISPATCH", 57);
        ag = new aj("GET_TRACKER_NAME", 58);
        ah = new aj("CLOSE_TRACKER", 59);
        ai = new aj("EASY_TRACKER_ACTIVITY_START", 60);
        aj = new aj("EASY_TRACKER_ACTIVITY_STOP", 61);
        ak = new aj("CONSTRUCT_APP_VIEW", 62);
        al = (new aj[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D, 
            E, F, G, H, I, J, K, L, M, N, 
            O, P, Q, R, S, T, U, V, W, X, 
            Y, Z, aa, ab, ac, ad, ae, af, ag, ah, 
            ai, aj, ak
        });
    }
}
