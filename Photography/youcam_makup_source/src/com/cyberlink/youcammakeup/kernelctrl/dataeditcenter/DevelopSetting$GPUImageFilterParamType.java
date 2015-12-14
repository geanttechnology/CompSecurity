// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;


public final class a extends Enum
{

    public static final al A;
    public static final al B;
    public static final al C;
    public static final al D;
    public static final al E;
    public static final al F;
    public static final al G;
    public static final al H;
    public static final al I;
    public static final al J;
    public static final al K;
    public static final al L;
    public static final al M;
    public static final al N;
    public static final al O;
    public static final al P;
    public static final al Q;
    public static final al R;
    public static final al S;
    public static final al T;
    public static final al U;
    public static final al V;
    public static final al W;
    public static final al X;
    public static final al Y;
    public static final al Z;
    public static final al a;
    public static final al aa;
    public static final al ab;
    public static final al ac;
    public static final al ad;
    public static final al ae;
    public static final al af;
    public static final al ag;
    public static final al ah;
    public static final al ai;
    public static final al aj;
    public static final al ak;
    public static final al al;
    private static final al am[];
    public static final al b;
    public static final al c;
    public static final al d;
    public static final al e;
    public static final al f;
    public static final al g;
    public static final al h;
    public static final al i;
    public static final al j;
    public static final al k;
    public static final al l;
    public static final al m;
    public static final al n;
    public static final al o;
    public static final al p;
    public static final al q;
    public static final al r;
    public static final al s;
    public static final al t;
    public static final al u;
    public static final al v;
    public static final al w;
    public static final al x;
    public static final al y;
    public static final al z;

    public static a valueOf(String s1)
    {
        return (a)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/dataeditcenter/DevelopSetting$GPUImageFilterParamType, s1);
    }

    public static a[] values()
    {
        return (a[])am.clone();
    }

    static 
    {
        a = new <init>("WhiteBalance", 0);
        b = new <init>("Exposure", 1);
        c = new <init>("HighlightShadow", 2);
        d = new <init>("Brightness", 3);
        e = new <init>("Contrast", 4);
        f = new <init>("Clarity", 5);
        g = new <init>("Saturation", 6);
        h = new <init>("SplitTone", 7);
        i = new <init>("Sepia", 8);
        j = new <init>("Monochrome", 9);
        k = new <init>("RGB", 10);
        l = new <init>("Vignette", 11);
        m = new <init>("HSVEx", 12);
        n = new <init>("ToneCurveRGB", 13);
        o = new <init>("WhiteBalanceMatrix", 14);
        p = new <init>("HSL", 15);
        q = new <init>("Vibrance", 16);
        r = new <init>("LiveSmooth", 17);
        s = new <init>("LiveSmoothFreshColor", 18);
        t = new <init>("LiveSmoothRetroColor", 19);
        u = new <init>("LiveSmoothElegantColor", 20);
        v = new <init>("LiveSmoothWarmColor", 21);
        w = new <init>("LiveSmoothBlackWhite", 22);
        x = new <init>("LiveSmoothSoftlight", 23);
        y = new <init>("LiveSmoothNature", 24);
        z = new <init>("LiveSmoothWithTexture", 25);
        A = new <init>("CaptureSmooth", 26);
        B = new <init>("CaptureSmoothFreshColor", 27);
        C = new <init>("CaptureSmoothRetroColor", 28);
        D = new <init>("CaptureSmoothElegantColor", 29);
        E = new <init>("CaptureSmoothWarmColor", 30);
        F = new <init>("CaptureSmoothBlackWhite", 31);
        G = new <init>("CaptureSmoothSoftlight", 32);
        H = new <init>("CaptureSmoothNature", 33);
        I = new <init>("CaptureSmoothWithTexture", 34);
        J = new <init>("RetroColorFilter", 35);
        K = new <init>("BlackWhiteFilter", 36);
        L = new <init>("ElegantColorFilter", 37);
        M = new <init>("NatureFilter", 38);
        N = new <init>("SoftlightFilter", 39);
        O = new <init>("FreshColorFilter", 40);
        P = new <init>("WarmColorFilter", 41);
        Q = new <init>("LiveWithTexture", 42);
        R = new <init>("CaptureWithTexture", 43);
        S = new <init>("LensFlare", 44);
        T = new <init>("Overlays", 45);
        U = new <init>("AutoTone", 46);
        V = new <init>("Blur", 47);
        W = new <init>("Bokeh", 48);
        X = new <init>("CLCandyColor", 49);
        Y = new <init>("CLAestheticColor", 50);
        Z = new <init>("CLGentleColor", 51);
        aa = new <init>("CLForestColor", 52);
        ab = new <init>("CLCoolColor", 53);
        ac = new <init>("CLVintageColor", 54);
        ad = new <init>("CLRedColor", 55);
        ae = new <init>("CLSmooth", 56);
        af = new <init>("CLFreshColor", 57);
        ag = new <init>("CLWarmColor", 58);
        ah = new <init>("CLSoftlightColor", 59);
        ai = new <init>("CLElegantColor", 60);
        aj = new <init>("CLRetroColor", 61);
        ak = new <init>("CLLightColor", 62);
        al = new <init>("CLBlackWhiteColor", 63);
        am = (new am[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D, 
            E, F, G, H, I, J, K, L, M, N, 
            O, P, Q, R, S, T, U, V, W, X, 
            Y, Z, aa, ab, ac, ad, ae, af, ag, ah, 
            ai, aj, ak, al
        });
    }

    private a(String s1, int i1)
    {
        super(s1, i1);
    }
}
