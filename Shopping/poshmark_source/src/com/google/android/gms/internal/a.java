// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public final class a extends Enum
{

    public static final a F;
    public static final a G;
    public static final a H;
    public static final a I;
    public static final a J;
    public static final a K;
    public static final a L;
    public static final a M;
    public static final a N;
    public static final a O;
    public static final a P;
    public static final a Q;
    public static final a R;
    public static final a S;
    public static final a T;
    public static final a U;
    public static final a V;
    public static final a W;
    public static final a X;
    public static final a Y;
    public static final a Z;
    public static final a aA;
    public static final a aB;
    public static final a aC;
    public static final a aD;
    public static final a aE;
    public static final a aF;
    public static final a aG;
    public static final a aH;
    public static final a aI;
    public static final a aJ;
    public static final a aK;
    public static final a aL;
    public static final a aM;
    public static final a aN;
    public static final a aO;
    public static final a aP;
    public static final a aQ;
    public static final a aR;
    public static final a aS;
    public static final a aT;
    public static final a aU;
    public static final a aV;
    public static final a aW;
    public static final a aX;
    public static final a aY;
    public static final a aZ;
    public static final a aa;
    public static final a ab;
    public static final a ac;
    public static final a ad;
    public static final a ae;
    public static final a af;
    public static final a ag;
    public static final a ah;
    public static final a ai;
    public static final a aj;
    public static final a ak;
    public static final a al;
    public static final a am;
    public static final a an;
    public static final a ao;
    public static final a ap;
    public static final a aq;
    public static final a ar;
    public static final a as;
    public static final a at;
    public static final a au;
    public static final a av;
    public static final a aw;
    public static final a ax;
    public static final a ay;
    public static final a az;
    public static final a ba;
    public static final a bb;
    public static final a bc;
    public static final a bd;
    public static final a be;
    private static final a bf[];
    private final String name;

    private a(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/google/android/gms/internal/a, s);
    }

    public static a[] values()
    {
        return (a[])bf.clone();
    }

    public String toString()
    {
        return name;
    }

    static 
    {
        F = new a("ADVERTISER_ID", 0, "_aid");
        G = new a("ADVERTISING_TRACKING_ENABLED", 1, "_ate");
        H = new a("APP_ID", 2, "_ai");
        I = new a("APP_NAME", 3, "_an");
        J = new a("APP_VERSION", 4, "_av");
        K = new a("ARBITRARY_JAVASCRIPT", 5, "_jsm");
        L = new a("CONSTANT", 6, "_c");
        M = new a("COOKIE", 7, "_k");
        N = new a("CUSTOM_VAR", 8, "_v");
        O = new a("CONTAINER_VERSION", 9, "_ctv");
        P = new a("DEBUG_MODE", 10, "_dbg");
        Q = new a("DEVICE_NAME", 11, "_dn");
        R = new a("DEVICE_TYPE", 12, "_dt");
        S = new a("DOM_ELEMENT", 13, "_d");
        T = new a("EVENT", 14, "_e");
        U = new a("FUNCTION_CALL", 15, "_func");
        V = new a("JS_GLOBAL", 16, "_j");
        W = new a("LANGUAGE", 17, "_l");
        X = new a("OS_VERSION", 18, "_ov");
        Y = new a("PLATFORM", 19, "_p");
        Z = new a("RANDOM", 20, "_r");
        aa = new a("REFERRER", 21, "_f");
        ab = new a("RESOLUTION", 22, "_rs");
        ac = new a("RUNTIME_VERSION", 23, "_rv");
        ad = new a("SDK_VERSION", 24, "_sv");
        ae = new a("SIMPLE_MAP", 25, "_smm");
        af = new a("TIME", 26, "_t");
        ag = new a("URL", 27, "_u");
        ah = new a("ADWORDS_CLICK_REFERRER", 28, "_awcr");
        ai = new a("DEVICE_ID", 29, "_did");
        aj = new a("ENCODE", 30, "_enc");
        ak = new a("GTM_VERSION", 31, "_gtmv");
        al = new a("HASH", 32, "_hsh");
        am = new a("INSTALL_REFERRER", 33, "_ir");
        an = new a("JOINER", 34, "_jn");
        ao = new a("MOBILE_ADWORDS_UNIQUE_ID", 35, "_awid");
        ap = new a("REGEX_GROUP", 36, "_reg");
        aq = new a("DATA_LAYER_WRITE", 37, "_dlw");
        ar = new a("REGEX", 38, "_re");
        as = new a("STARTS_WITH", 39, "_sw");
        at = new a("ENDS_WITH", 40, "_ew");
        au = new a("CONTAINS", 41, "_cn");
        av = new a("EQUALS", 42, "_eq");
        aw = new a("LESS_THAN", 43, "_lt");
        ax = new a("LESS_EQUALS", 44, "_le");
        ay = new a("GREATER_THAN", 45, "_gt");
        az = new a("GREATER_EQUALS", 46, "_ge");
        aA = new a("ARBITRARY_PIXEL", 47, "_img");
        aB = new a("ARBITRARY_HTML", 48, "_html");
        aC = new a("GOOGLE_TAG_MANAGER", 49, "_gtm");
        aD = new a("GOOGLE_ANALYTICS", 50, "_ga");
        aE = new a("ADWORDS_CONVERSION", 51, "_awct");
        aF = new a("SMART_PIXEL", 52, "_sp");
        aG = new a("FLOODLIGHT_COUNTER", 53, "_flc");
        aH = new a("FLOODLIGHT_SALES", 54, "_fls");
        aI = new a("BIZO_INSIGHT", 55, "_bzi");
        aJ = new a("QUANTCAST_MEASUREMENT", 56, "_qcm");
        aK = new a("TARGUS_ADVISOR", 57, "_ta");
        aL = new a("MEDIAPLEX_ROI", 58, "_mpr");
        aM = new a("COMSCORE_MEASUREMENT", 59, "_csm");
        aN = new a("TURN_CONVERSION", 60, "_tc");
        aO = new a("TURN_DATA_COLLECTION", 61, "_tdc");
        aP = new a("MEDIA6DEGREES_UNIVERSAL_PIXEL", 62, "_m6d");
        aQ = new a("UNIVERSAL_ANALYTICS", 63, "_ua");
        aR = new a("MEDIAPLEX_MCT", 64, "_mpm");
        aS = new a("VISUAL_DNA_CONVERSION", 65, "_vdc");
        aT = new a("GOOGLE_AFFILIATE_NETWORK", 66, "_gan");
        aU = new a("MARIN_SOFTWARE", 67, "_ms");
        aV = new a("ADROLL_SMART_PIXEL", 68, "_asp");
        aW = new a("CONFIGURATION_VALUE", 69, "_cv");
        aX = new a("CRITEO", 70, "_crt");
        aY = new a("TRUSTED_STORES", 71, "_ts");
        aZ = new a("CLICK_TALE_STANDARD", 72, "_cts");
        ba = new a("LINK_CLICK_LISTENER", 73, "_lcl");
        bb = new a("FORM_SUBMIT_LISTENER", 74, "_fsl");
        bc = new a("TIMER_LISTENER", 75, "_tl");
        bd = new a("CLICK_LISTENER", 76, "_cl");
        be = new a("JS_ERROR_LISTENER", 77, "_jel");
        bf = (new a[] {
            F, G, H, I, J, K, L, M, N, O, 
            P, Q, R, S, T, U, V, W, X, Y, 
            Z, aa, ab, ac, ad, ae, af, ag, ah, ai, 
            aj, ak, al, am, an, ao, ap, aq, ar, as, 
            at, au, av, aw, ax, ay, az, aA, aB, aC, 
            aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM, 
            aN, aO, aP, aQ, aR, aS, aT, aU, aV, aW, 
            aX, aY, aZ, ba, bb, bc, bd, be
        });
    }
}
