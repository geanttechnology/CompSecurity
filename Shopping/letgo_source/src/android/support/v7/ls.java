// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public final class ls extends Enum
{

    public static final ls A;
    public static final ls B;
    public static final ls C;
    public static final ls D;
    public static final ls E;
    public static final ls F;
    public static final ls G;
    public static final ls H;
    public static final ls I;
    public static final ls J;
    public static final ls K;
    public static final ls L;
    public static final ls M;
    public static final ls N;
    public static final ls O;
    public static final ls P;
    public static final ls Q;
    public static final ls R;
    public static final ls S;
    public static final ls T;
    public static final ls U;
    public static final ls V;
    public static final ls W;
    public static final ls X;
    public static final ls Y;
    public static final ls Z;
    public static final ls a;
    public static final ls aA;
    public static final ls aB;
    public static final ls aC;
    public static final ls aD;
    public static final ls aE;
    public static final ls aF;
    public static final ls aG;
    public static final ls aH;
    public static final ls aI;
    public static final ls aJ;
    public static final ls aK;
    public static final ls aL;
    public static final ls aM;
    public static final ls aN;
    public static final ls aO;
    public static final ls aP;
    public static final ls aQ;
    public static final ls aR;
    public static final ls aS;
    public static final ls aT;
    public static final ls aU;
    public static final ls aV;
    public static final ls aW;
    public static final ls aX;
    public static final ls aY;
    public static final ls aZ;
    public static final ls aa;
    public static final ls ab;
    public static final ls ac;
    public static final ls ad;
    public static final ls ae;
    public static final ls af;
    public static final ls ag;
    public static final ls ah;
    public static final ls ai;
    public static final ls aj;
    public static final ls ak;
    public static final ls al;
    public static final ls am;
    public static final ls an;
    public static final ls ao;
    public static final ls ap;
    public static final ls aq;
    public static final ls ar;
    public static final ls as;
    public static final ls at;
    public static final ls au;
    public static final ls av;
    public static final ls aw;
    public static final ls ax;
    public static final ls ay;
    public static final ls az;
    public static final ls b;
    public static final ls ba;
    public static final ls bb;
    public static final ls bc;
    public static final ls bd;
    private static final ls bf[];
    public static final ls c;
    public static final ls d;
    public static final ls e;
    public static final ls f;
    public static final ls g;
    public static final ls h;
    public static final ls i;
    public static final ls j;
    public static final ls k;
    public static final ls l;
    public static final ls m;
    public static final ls n;
    public static final ls o;
    public static final ls p;
    public static final ls q;
    public static final ls r;
    public static final ls s;
    public static final ls t;
    public static final ls u;
    public static final ls v;
    public static final ls w;
    public static final ls x;
    public static final ls y;
    public static final ls z;
    private final String be;

    private ls(String s1, int i1, String s2)
    {
        super(s1, i1);
        be = s2;
    }

    public static ls valueOf(String s1)
    {
        return (ls)Enum.valueOf(android/support/v7/ls, s1);
    }

    public static ls[] values()
    {
        return (ls[])bf.clone();
    }

    public String toString()
    {
        return be;
    }

    static 
    {
        a = new ls("ADVERTISER_ID", 0, "_aid");
        b = new ls("ADVERTISING_TRACKING_ENABLED", 1, "_ate");
        c = new ls("APP_ID", 2, "_ai");
        d = new ls("APP_NAME", 3, "_an");
        e = new ls("APP_VERSION", 4, "_av");
        f = new ls("ARBITRARY_JAVASCRIPT", 5, "_jsm");
        g = new ls("CONSTANT", 6, "_c");
        h = new ls("COOKIE", 7, "_k");
        i = new ls("CUSTOM_VAR", 8, "_v");
        j = new ls("CONTAINER_VERSION", 9, "_ctv");
        k = new ls("DEBUG_MODE", 10, "_dbg");
        l = new ls("DEVICE_NAME", 11, "_dn");
        m = new ls("DEVICE_TYPE", 12, "_dt");
        n = new ls("DOM_ELEMENT", 13, "_d");
        o = new ls("ELEMENT_TEXT", 14, "_et");
        p = new ls("ELEMENT_URL", 15, "_eu");
        q = new ls("EVENT", 16, "_e");
        r = new ls("FUNCTION_CALL", 17, "_func");
        s = new ls("JS_GLOBAL", 18, "_j");
        t = new ls("LANGUAGE", 19, "_l");
        u = new ls("OS_VERSION", 20, "_ov");
        v = new ls("PLATFORM", 21, "_p");
        w = new ls("RANDOM", 22, "_r");
        x = new ls("REFERRER", 23, "_f");
        y = new ls("RESOLUTION", 24, "_rs");
        z = new ls("RUNTIME_VERSION", 25, "_rv");
        A = new ls("SDK_VERSION", 26, "_sv");
        B = new ls("SIMPLE_MAP", 27, "_smm");
        C = new ls("TIME", 28, "_t");
        D = new ls("URL", 29, "_u");
        E = new ls("ADWORDS_CLICK_REFERRER", 30, "_awcr");
        F = new ls("DEVICE_ID", 31, "_did");
        G = new ls("ENCODE", 32, "_enc");
        H = new ls("GTM_VERSION", 33, "_gtmv");
        I = new ls("HASH", 34, "_hsh");
        J = new ls("INSTALL_REFERRER", 35, "_ir");
        K = new ls("JOINER", 36, "_jn");
        L = new ls("MOBILE_ADWORDS_UNIQUE_ID", 37, "_awid");
        M = new ls("REGEX_GROUP", 38, "_reg");
        N = new ls("DATA_LAYER_WRITE", 39, "_dlw");
        O = new ls("LOWERCASE_STRING", 40, "_ls");
        P = new ls("UPPERCASE_STRING", 41, "_us");
        Q = new ls("EXPERIMENT_ENABLED", 42, "_ee");
        R = new ls("IN_EXPERIMENT", 43, "_ie");
        S = new ls("EXPERIMENT_VARIATION_INDEX", 44, "_evi");
        T = new ls("AUDIENCE_LISTS", 45, "_aud");
        U = new ls("CSS_SELECTOR", 46, "_sel");
        V = new ls("GA_CLIENT_ID", 47, "_gacid");
        W = new ls("PRODUCT_SETTING_PROPERTY", 48, "_prodset");
        X = new ls("GA_OPT_OUT_CLIENT", 49, "_gaoo_c");
        Y = new ls("GA_OPT_OUT_SERVER", 50, "_gaoo_s");
        Z = new ls("REGEX", 51, "_re");
        aa = new ls("STARTS_WITH", 52, "_sw");
        ab = new ls("ENDS_WITH", 53, "_ew");
        ac = new ls("CONTAINS", 54, "_cn");
        ad = new ls("EQUALS", 55, "_eq");
        ae = new ls("LESS_THAN", 56, "_lt");
        af = new ls("LESS_EQUALS", 57, "_le");
        ag = new ls("GREATER_THAN", 58, "_gt");
        ah = new ls("GREATER_EQUALS", 59, "_ge");
        ai = new ls("CSS_SELECTOR_PREDICATE", 60, "_css");
        aj = new ls("ARBITRARY_PIXEL", 61, "_img");
        ak = new ls("ARBITRARY_HTML", 62, "_html");
        al = new ls("GOOGLE_TAG_MANAGER", 63, "_gtm");
        am = new ls("GOOGLE_ANALYTICS", 64, "_ga");
        an = new ls("ADWORDS_CONVERSION", 65, "_awct");
        ao = new ls("SMART_PIXEL", 66, "_sp");
        ap = new ls("FLOODLIGHT_COUNTER", 67, "_flc");
        aq = new ls("FLOODLIGHT_SALES", 68, "_fls");
        ar = new ls("BIZO_INSIGHT", 69, "_bzi");
        as = new ls("QUANTCAST_MEASUREMENT", 70, "_qcm");
        at = new ls("TARGUS_ADVISOR", 71, "_ta");
        au = new ls("MEDIAPLEX_ROI", 72, "_mpr");
        av = new ls("COMSCORE_MEASUREMENT", 73, "_csm");
        aw = new ls("TURN_CONVERSION", 74, "_tc");
        ax = new ls("TURN_DATA_COLLECTION", 75, "_tdc");
        ay = new ls("MEDIA6DEGREES_UNIVERSAL_PIXEL", 76, "_m6d");
        az = new ls("UNIVERSAL_ANALYTICS", 77, "_ua");
        aA = new ls("MEDIAPLEX_MCT", 78, "_mpm");
        aB = new ls("VISUAL_DNA_CONVERSION", 79, "_vdc");
        aC = new ls("GOOGLE_AFFILIATE_NETWORK", 80, "_gan");
        aD = new ls("MARIN_SOFTWARE", 81, "_ms");
        aE = new ls("ADROLL_SMART_PIXEL", 82, "_asp");
        aF = new ls("CONFIGURATION_VALUE", 83, "_cv");
        aG = new ls("CRITEO", 84, "_crt");
        aH = new ls("TRUSTED_STORES", 85, "_ts");
        aI = new ls("CLICK_TALE_STANDARD", 86, "_cts");
        aJ = new ls("LINK_CLICK_LISTENER", 87, "_lcl");
        aK = new ls("FORM_SUBMIT_LISTENER", 88, "_fsl");
        aL = new ls("TIMER_LISTENER", 89, "_tl");
        aM = new ls("CLICK_LISTENER", 90, "_cl");
        aN = new ls("JS_ERROR_LISTENER", 91, "_jel");
        aO = new ls("HISTORY_LISTENER", 92, "_hl");
        aP = new ls("AJAX_SUBMIT_LISTENER", 93, "_ajl");
        aQ = new ls("YOU_TUBE_LISTENER", 94, "_ytl");
        aR = new ls("ELEMENT_ATTRIBUTE", 95, "_ea");
        aS = new ls("ELEMENT_CONTENT", 96, "_ec");
        aT = new ls("ELEMENT_MOVE", 97, "_em");
        aU = new ls("ELEMENT_SCRIPT", 98, "_esc");
        aV = new ls("ELEMENT_STYLE", 99, "_est");
        aW = new ls("ELEMENT_TEXT_TAG", 100, "_etx");
        aX = new ls("ORDERED_LIST", 101, "_ol");
        aY = new ls("UNIVERSAL_ANALYTICS_EXPERIMENT", 102, "_uae");
        aZ = new ls("GOOGLE_ANALYTICS_GLOBAL", 103, "_gag");
        ba = new ls("ADOMETRY", 104, "_adm");
        bb = new ls("ADWORDS_APP_USAGE_TRACKING", 105, "_awut");
        bc = new ls("PAGE_REDIRECT", 106, "_pr");
        bd = new ls("APP_VERSION_NAME", 107, "_avn");
        bf = (new ls[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D, 
            E, F, G, H, I, J, K, L, M, N, 
            O, P, Q, R, S, T, U, V, W, X, 
            Y, Z, aa, ab, ac, ad, ae, af, ag, ah, 
            ai, aj, ak, al, am, an, ao, ap, aq, ar, 
            as, at, au, av, aw, ax, ay, az, aA, aB, 
            aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, 
            aM, aN, aO, aP, aQ, aR, aS, aT, aU, aV, 
            aW, aX, aY, aZ, ba, bb, bc, bd
        });
    }
}
