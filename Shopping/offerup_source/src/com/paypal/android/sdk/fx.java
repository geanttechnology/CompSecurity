// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public final class fx extends Enum
{

    private static fx A;
    private static fx B;
    private static fx C;
    private static fx D;
    private static fx E;
    private static fx F;
    private static fx G;
    private static fx H;
    private static fx I;
    private static fx J;
    private static fx K;
    private static fx L;
    private static fx M;
    private static fx N;
    private static fx O;
    private static fx P;
    private static fx Q;
    private static fx R;
    private static fx S;
    private static fx T;
    private static fx U;
    private static fx V;
    private static fx W;
    private static fx X;
    private static fx Y;
    private static fx Z;
    public static final fx a;
    private static fx aA;
    private static fx aB;
    private static fx aC;
    private static fx aD;
    private static fx aE;
    private static fx aF;
    private static fx aG;
    private static fx aH;
    private static fx aI;
    private static fx aJ;
    private static fx aK;
    private static fx aL;
    private static fx aM;
    private static fx aN;
    private static fx aO;
    private static fx aP;
    private static fx aQ;
    private static fx aR;
    private static fx aS;
    private static final fx aT[];
    private static fx aa;
    private static fx ab;
    private static fx ac;
    private static fx ad;
    private static fx ae;
    private static fx af;
    private static fx ag;
    private static fx ah;
    private static fx ai;
    private static fx aj;
    private static fx ak;
    private static fx al;
    private static fx am;
    private static fx an;
    private static fx ao;
    private static fx ap;
    private static fx aq;
    private static fx ar;
    private static fx as;
    private static fx at;
    private static fx au;
    private static fx av;
    private static fx aw;
    private static fx ax;
    private static fx ay;
    private static fx az;
    public static final fx b;
    public static final fx c;
    public static final fx d;
    public static final fx e;
    public static final fx f;
    public static final fx g;
    public static final fx h;
    public static final fx i;
    public static final fx j;
    public static final fx k;
    public static final fx l;
    public static final fx m;
    public static final fx n;
    private static fx p;
    private static fx q;
    private static fx r;
    private static fx s;
    private static fx t;
    private static fx u;
    private static fx v;
    private static fx w;
    private static fx x;
    private static fx y;
    private static fx z;
    final String o;

    private fx(String s1, int i1, String s2)
    {
        super(s1, i1);
        o = s2;
    }

    public static fx a(String s1)
    {
        if (s1.startsWith("SSL_"))
        {
            return valueOf((new StringBuilder("TLS_")).append(s1.substring(4)).toString());
        } else
        {
            return valueOf(s1);
        }
    }

    public static fx valueOf(String s1)
    {
        return (fx)Enum.valueOf(com/paypal/android/sdk/fx, s1);
    }

    public static fx[] values()
    {
        return (fx[])aT.clone();
    }

    static 
    {
        p = new fx("TLS_RSA_WITH_NULL_MD5", 0, "SSL_RSA_WITH_NULL_MD5");
        q = new fx("TLS_RSA_WITH_NULL_SHA", 1, "SSL_RSA_WITH_NULL_SHA");
        r = new fx("TLS_RSA_EXPORT_WITH_RC4_40_MD5", 2, "SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        s = new fx("TLS_RSA_WITH_RC4_128_MD5", 3, "SSL_RSA_WITH_RC4_128_MD5");
        t = new fx("TLS_RSA_WITH_RC4_128_SHA", 4, "SSL_RSA_WITH_RC4_128_SHA");
        u = new fx("TLS_RSA_EXPORT_WITH_DES40_CBC_SHA", 5, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        v = new fx("TLS_RSA_WITH_DES_CBC_SHA", 6, "SSL_RSA_WITH_DES_CBC_SHA");
        a = new fx("TLS_RSA_WITH_3DES_EDE_CBC_SHA", 7, "SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        w = new fx("TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 8, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        x = new fx("TLS_DHE_DSS_WITH_DES_CBC_SHA", 9, "SSL_DHE_DSS_WITH_DES_CBC_SHA");
        y = new fx("TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 10, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        z = new fx("TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 11, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        A = new fx("TLS_DHE_RSA_WITH_DES_CBC_SHA", 12, "SSL_DHE_RSA_WITH_DES_CBC_SHA");
        B = new fx("TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 13, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        C = new fx("TLS_DH_anon_EXPORT_WITH_RC4_40_MD5", 14, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        D = new fx("TLS_DH_anon_WITH_RC4_128_MD5", 15, "SSL_DH_anon_WITH_RC4_128_MD5");
        E = new fx("TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 16, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        F = new fx("TLS_DH_anon_WITH_DES_CBC_SHA", 17, "SSL_DH_anon_WITH_DES_CBC_SHA");
        G = new fx("TLS_DH_anon_WITH_3DES_EDE_CBC_SHA", 18, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        H = new fx("TLS_KRB5_WITH_DES_CBC_SHA", 19, "TLS_KRB5_WITH_DES_CBC_SHA");
        I = new fx("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 20, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        J = new fx("TLS_KRB5_WITH_RC4_128_SHA", 21, "TLS_KRB5_WITH_RC4_128_SHA");
        K = new fx("TLS_KRB5_WITH_DES_CBC_MD5", 22, "TLS_KRB5_WITH_DES_CBC_MD5");
        L = new fx("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 23, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        M = new fx("TLS_KRB5_WITH_RC4_128_MD5", 24, "TLS_KRB5_WITH_RC4_128_MD5");
        N = new fx("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 25, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        O = new fx("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 26, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        P = new fx("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 27, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        Q = new fx("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 28, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        b = new fx("TLS_RSA_WITH_AES_128_CBC_SHA", 29, "TLS_RSA_WITH_AES_128_CBC_SHA");
        c = new fx("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 30, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        d = new fx("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 31, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        R = new fx("TLS_DH_anon_WITH_AES_128_CBC_SHA", 32, "TLS_DH_anon_WITH_AES_128_CBC_SHA");
        e = new fx("TLS_RSA_WITH_AES_256_CBC_SHA", 33, "TLS_RSA_WITH_AES_256_CBC_SHA");
        S = new fx("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 34, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        f = new fx("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 35, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        T = new fx("TLS_DH_anon_WITH_AES_256_CBC_SHA", 36, "TLS_DH_anon_WITH_AES_256_CBC_SHA");
        U = new fx("TLS_RSA_WITH_NULL_SHA256", 37, "TLS_RSA_WITH_NULL_SHA256");
        V = new fx("TLS_RSA_WITH_AES_128_CBC_SHA256", 38, "TLS_RSA_WITH_AES_128_CBC_SHA256");
        W = new fx("TLS_RSA_WITH_AES_256_CBC_SHA256", 39, "TLS_RSA_WITH_AES_256_CBC_SHA256");
        X = new fx("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 40, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        Y = new fx("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 41, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        Z = new fx("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 42, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        aa = new fx("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 43, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        ab = new fx("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 44, "TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        ac = new fx("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 45, "TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        g = new fx("TLS_RSA_WITH_AES_128_GCM_SHA256", 46, "TLS_RSA_WITH_AES_128_GCM_SHA256");
        ad = new fx("TLS_RSA_WITH_AES_256_GCM_SHA384", 47, "TLS_RSA_WITH_AES_256_GCM_SHA384");
        h = new fx("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 48, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        ae = new fx("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 49, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        af = new fx("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 50, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        ag = new fx("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 51, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        ah = new fx("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 52, "TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        ai = new fx("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 53, "TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        aj = new fx("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 54, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        ak = new fx("TLS_ECDH_ECDSA_WITH_NULL_SHA", 55, "TLS_ECDH_ECDSA_WITH_NULL_SHA");
        al = new fx("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 56, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        am = new fx("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 57, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        an = new fx("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 58, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        ao = new fx("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 59, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        ap = new fx("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 60, "TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        aq = new fx("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 61, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        ar = new fx("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 62, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        i = new fx("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 63, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        j = new fx("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 64, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        as = new fx("TLS_ECDH_RSA_WITH_NULL_SHA", 65, "TLS_ECDH_RSA_WITH_NULL_SHA");
        at = new fx("TLS_ECDH_RSA_WITH_RC4_128_SHA", 66, "TLS_ECDH_RSA_WITH_RC4_128_SHA");
        au = new fx("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 67, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        av = new fx("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 68, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        aw = new fx("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 69, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        ax = new fx("TLS_ECDHE_RSA_WITH_NULL_SHA", 70, "TLS_ECDHE_RSA_WITH_NULL_SHA");
        ay = new fx("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 71, "TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        az = new fx("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 72, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        k = new fx("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 73, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        l = new fx("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 74, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        aA = new fx("TLS_ECDH_anon_WITH_NULL_SHA", 75, "TLS_ECDH_anon_WITH_NULL_SHA");
        aB = new fx("TLS_ECDH_anon_WITH_RC4_128_SHA", 76, "TLS_ECDH_anon_WITH_RC4_128_SHA");
        aC = new fx("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 77, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        aD = new fx("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 78, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        aE = new fx("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 79, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        aF = new fx("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 80, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        aG = new fx("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 81, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        aH = new fx("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 82, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        aI = new fx("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 83, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        aJ = new fx("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 84, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        aK = new fx("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 85, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        aL = new fx("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 86, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        aM = new fx("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 87, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        m = new fx("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 88, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        aN = new fx("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 89, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        aO = new fx("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 90, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        aP = new fx("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 91, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        n = new fx("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 92, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        aQ = new fx("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 93, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        aR = new fx("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 94, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        aS = new fx("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 95, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        aT = (new fx[] {
            p, q, r, s, t, u, v, a, w, x, 
            y, z, A, B, C, D, E, F, G, H, 
            I, J, K, L, M, N, O, P, Q, b, 
            c, d, R, e, S, f, T, U, V, W, 
            X, Y, Z, aa, ab, ac, g, ad, h, ae, 
            af, ag, ah, ai, aj, ak, al, am, an, ao, 
            ap, aq, ar, i, j, as, at, au, av, aw, 
            ax, ay, az, k, l, aA, aB, aC, aD, aE, 
            aF, aG, aH, aI, aJ, aK, aL, aM, m, aN, 
            aO, aP, n, aQ, aR, aS
        });
    }
}
