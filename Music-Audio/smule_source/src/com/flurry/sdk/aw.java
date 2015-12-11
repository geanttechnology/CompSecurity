// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class aw extends Enum
{

    public static final aw A;
    public static final aw B;
    public static final aw C;
    public static final aw D;
    public static final aw E;
    public static final aw F;
    public static final aw G;
    public static final aw H;
    public static final aw I;
    public static final aw J;
    public static final aw K;
    public static final aw L;
    public static final aw M;
    public static final aw N;
    public static final aw O;
    public static final aw P;
    public static final aw Q;
    public static final aw R;
    public static final aw S;
    private static final aw U[];
    public static final aw a;
    public static final aw b;
    public static final aw c;
    public static final aw d;
    public static final aw e;
    public static final aw f;
    public static final aw g;
    public static final aw h;
    public static final aw i;
    public static final aw j;
    public static final aw k;
    public static final aw l;
    public static final aw m;
    public static final aw n;
    public static final aw o;
    public static final aw p;
    public static final aw q;
    public static final aw r;
    public static final aw s;
    public static final aw t;
    public static final aw u;
    public static final aw v;
    public static final aw w;
    public static final aw x;
    public static final aw y;
    public static final aw z;
    private final String T;

    private aw(String s1, int i1, String s2)
    {
        super(s1, i1);
        T = s2;
    }

    public static aw valueOf(String s1)
    {
        return (aw)Enum.valueOf(com/flurry/sdk/aw, s1);
    }

    public static aw[] values()
    {
        return (aw[])U.clone();
    }

    public String a()
    {
        return T;
    }

    public String toString()
    {
        return T;
    }

    static 
    {
        a = new aw("EV_UNKNOWN", 0, "unknown");
        b = new aw("EV_REQUESTED", 1, "requested");
        c = new aw("EV_REQUEST_AD_COMPONENTS", 2, "requestAdComponents");
        d = new aw("EV_FILLED", 3, "filled");
        e = new aw("EV_UNFILLED", 4, "unfilled");
        f = new aw("EV_RENDERED", 5, "rendered");
        g = new aw("EV_RENDER_FAILED", 6, "renderFailed");
        h = new aw("EV_CLICKED", 7, "clicked");
        i = new aw("EV_VIDEO_START", 8, "videoStart");
        j = new aw("EV_VIDEO_COMPLETED", 9, "videoCompleted");
        k = new aw("EV_VIDEO_PROGRESSED", 10, "videoProgressed");
        l = new aw("EV_SENT_TO_URL", 11, "sentToUrl");
        m = new aw("EV_ASYNC_NOTIFICATION", 12, "asyncNotification");
        n = new aw("EV_URL_VERIFIED", 13, "urlVerified");
        o = new aw("EV_URL_NOT_VERIFIED", 14, "urlNotVerified");
        p = new aw("EV_LAUNCH_URL_FAILED", 15, "launchUrlFailed");
        q = new aw("EV_USER_CONFIRMED", 16, "userConfirmed");
        r = new aw("EV_USER_CANCELLED", 17, "userCanceled");
        s = new aw("EV_AD_WILL_CLOSE", 18, "adWillClose");
        t = new aw("EV_AD_CLOSED", 19, "adClosed");
        u = new aw("EV_REQUEST_AD_EXPAND", 20, "expand");
        v = new aw("EV_REQUEST_AD_COLLAPSE", 21, "collapse");
        w = new aw("EV_REQUEST_LAUNCH_URL", 22, "open");
        x = new aw("EV_AD_LISTENER_ADDED", 23, "eventListenerAdded");
        y = new aw("EV_FILLED_FROM_SERVER", 24, "filledFromServer");
        z = new aw("EV_FILLED_FROM_CACHE", 25, "filledFromCache");
        A = new aw("EV_COMPLETED_FULL_LOAD", 26, "didCompleteFullLoad");
        B = new aw("EV_CAP_EXHAUSTED", 27, "capExhausted");
        C = new aw("EV_CAP_NOT_EXHAUSTED", 28, "capNotExhausted");
        D = new aw("EV_LOADING_VIDEO_CLOSED", 29, "loadingVideoClosed");
        E = new aw("EV_VIDEO_FIRST_QUARTILE", 30, "videoFirstQuartile");
        F = new aw("EV_VIDEO_MIDPOINT", 31, "videoMidpoint");
        G = new aw("EV_VIDEO_THIRD_QUARTILE", 32, "videoThirdQuartile");
        H = new aw("EV_VIDEO_CLICKED", 33, "videoClicked");
        I = new aw("EV_REWARD_GRANTED", 34, "rewardGranted");
        J = new aw("EV_SEND_URL_STATUS_RESULT", 35, "sendUrlStatusResult");
        K = new aw("EV_PREPARED", 36, "prepared");
        L = new aw("EV_AD_UNIT_MERGED", 37, "adunitMerged");
        M = new aw("EV_PRIVACY", 38, "privacy");
        N = new aw("INTERNAL_EV_AD_OPENED", 39, "adOpened");
        O = new aw("INTERNAL_EV_APP_EXIT", 40, "appExit");
        P = new aw("EV_STREAM_IMPRESSION", 41, "streamImpression");
        Q = new aw("EV_NATIVE_IMPRESSION", 42, "nativeImpression");
        R = new aw("EV_MRAID_NOT_SUPPORTED", 43, "mraidAdNotSupported");
        S = new aw("EV_MRAID_CLOSE_BUTTON_VISIBLE", 44, "mraidCloseButtonVisible");
        U = (new aw[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D, 
            E, F, G, H, I, J, K, L, M, N, 
            O, P, Q, R, S
        });
    }
}
