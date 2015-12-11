// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            co, cl, cn, dy

class ck
{
    public static final class a extends Enum
    {

        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
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
        public static final a a;
        public static final a aa;
        public static final a ab;
        public static final a ac;
        public static final a ad;
        public static final a ae;
        public static final a af;
        private static final a ai[];
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final a n;
        public static final a o;
        public static final a p;
        public static final a q;
        public static final a r;
        public static final a s;
        public static final a t;
        public static final a u;
        public static final a v;
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final String ag;
        final boolean ah;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/amazon/device/ads/ck$a, s1);
        }

        public static a[] values()
        {
            return (a[])ai.clone();
        }

        static 
        {
            a = new a("AD_LATENCY_TOTAL", 0, "tl", true);
            b = new a("AD_LATENCY_TOTAL_SUCCESS", 1, "tsl", true);
            c = new a("AD_LATENCY_TOTAL_FAILURE", 2, "tfl", true);
            d = new a("AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START", 3, "llfsl", true);
            e = new a("AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP", 4, "lfsul");
            f = new a("AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START", 5, "lfsasl");
            g = new a("AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END", 6, "laefel");
            h = new a("AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP", 7, "lffsul");
            i = new a("AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START", 8, "lffsrsl", true);
            j = new a("AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE", 9, "lffsfl", true);
            k = new a("AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL", 10, "lcaul");
            l = new a("ASSETS_CREATED_LATENCY", 11, "lacl");
            m = new a("ASSETS_ENSURED_LATENCY", 12, "lael");
            n = new a("ASSETS_FAILED", 13, "af");
            o = new a("AD_LOADED_TO_AD_SHOW_TIME", 14, "alast");
            p = new a("AD_SHOW_LATENCY", 15, "lsa");
            q = new a("AD_SHOW_DURATION", 16, "sd", true);
            r = new a("AD_LAYOUT_INITIALIZATION", 17, "ali");
            s = new a("AAX_LATENCY_GET_AD", 18, "al");
            t = new a("AD_LOAD_FAILED", 19, "lf");
            u = new a("AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT", 20, "lfat");
            v = new a("AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT", 21, "lfpt", true);
            w = new a("AD_COUNTER_IDENTIFIED_DEVICE", 22, "id");
            x = new a("AD_COUNTER_RENDERING_FATAL", 23, "rf", true);
            y = new a("AD_LATENCY_RENDER", 24, "rl", true);
            z = new a("AD_LATENCY_RENDER_FAILED", 25, "rlf", true);
            A = new a("AD_COUNTER_FAILED_DUE_TO_NO_RETRY", 26, "nrtf");
            B = new a("AD_NO_RETRY_TTL_RECEIVED", 27, "nrtr");
            C = new a("AD_COUNTER_AUTO_AD_SIZE", 28, "aas");
            D = new a("AD_COUNTER_PARENT_VIEW_MISSING", 29, "pvm");
            E = new a("ADLAYOUT_HEIGHT_ZERO", 30, "ahz");
            F = new a("VIEWPORT_SCALE", 31, "vs");
            G = new a("AD_COUNTER_RESHOWN", 32, "rs", true);
            H = new a("AD_FAILED_UNKNOWN_WEBVIEW_ISSUE", 33, "fuwi");
            I = new a("AD_FAILED_NULL_LAYOUT_PARAMS", 34, "fnlp");
            J = new a("AD_FAILED_LAYOUT_NOT_RUN", 35, "flnr");
            K = new a("AD_FAILED_INVALID_AUTO_AD_SIZE", 36, "faas");
            L = new a("SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED", 37, "sid");
            M = new a("SIS_LATENCY_REGISTER", 38, "srl");
            N = new a("SIS_LATENCY_UPDATE_DEVICE_INFO", 39, "sul");
            O = new a("SIS_LATENCY_REGISTER_EVENT", 40, "srel");
            P = new a("CONFIG_DOWNLOAD_ERROR", 41, "cde");
            Q = new a("CONFIG_DOWNLOAD_LATENCY", 42, "cdt");
            R = new a("CONFIG_PARSE_ERROR", 43, "cpe");
            S = new a("AAX_CONFIG_DOWNLOAD_LATENCY", 44, "acl");
            T = new a("AAX_CONFIG_DOWNLOAD_FAILED", 45, "acf");
            U = new a("CUSTOM_RENDER_HANDLED", 46, "crh");
            V = new a("TLS_ENABLED", 47, "tls");
            W = new a("WIFI_PRESENT", 48, "wifi");
            X = new a("CARRIER_NAME", 49, "car");
            Y = new a("CONNECTION_TYPE", 50, "ct");
            Z = new a("AD_IS_INTERSTITIAL", 51, "i");
            aa = new a("INTERSTITIAL_AD_ACTIVITY_FAILED", 52, "iaaf");
            ab = new a("RENDER_REQUIREMENT_CHECK_FAILURE", 53, "rrcfc", true);
            ac = new a("EXPIRED_AD_CALL", 54, "eac", true);
            ad = new a("AD_ASPECT_RATIO_LESS_THAN_SCREEN_ASPECT_RATIO", 55, "rarfc", true);
            ae = new a("SET_ORIENTATION_FAILURE", 56, "rsofc", true);
            af = new a("AD_EXPIRED_BEFORE_SHOWING", 57, "aebs", true);
            ai = (new a[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r, s, t, 
                u, v, w, x, y, z, A, B, C, D, 
                E, F, G, H, I, J, K, L, M, N, 
                O, P, Q, R, S, T, U, V, W, X, 
                Y, Z, aa, ab, ac, ad, ae, af
            });
        }

        private a(String s1, int i1, String s2)
        {
            this(s1, i1, s2, false);
        }

        private a(String s1, int i1, String s2, boolean flag)
        {
            super(s1, i1);
            ag = s2;
            ah = flag;
        }
    }

    static interface b
    {

        public abstract cl d();

        public abstract void e();

        public abstract String f();
    }


    private static final String c = com/amazon/device/ads/ck.getSimpleName();
    private static ck d = new ck();
    final cn a;
    cl b;

    ck()
    {
        new co();
        a = co.a(c);
        b = new cl();
    }

    public static ck a()
    {
        return d;
    }

    static cn a(ck ck1)
    {
        return ck1.a;
    }


    // Unreferenced inner class com/amazon/device/ads/ck$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final dy a;
        final ck b;

        public final void run()
        {
            a.e();
            static final class _cls2
            {

                static final int a[];

                static 
                {
                    a = new int[dy.f.values().length];
                    try
                    {
                        a[dy.f.d.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        a[dy.f.a.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[dy.f.c.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[dy.f.e.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            try
            {
                a.c();
                return;
            }
            catch (dy.c c1)
            {
                switch (_cls2.a[c1.a.ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    ck.a(b).d("Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", new Object[] {
                        c1.getMessage()
                    });
                    return;

                case 2: // '\002'
                    ck.a(b).d("Unable to submit metrics for ad due to Network Failure, msg: %s", new Object[] {
                        c1.getMessage()
                    });
                    return;

                case 3: // '\003'
                    ck.a(b).d("Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", new Object[] {
                        c1.getMessage()
                    });
                    // fall through

                case 4: // '\004'
                    ck.a(b).d("Unable to submit metrics for ad because of unsupported character encoding, msg: %s", new Object[] {
                        c1.getMessage()
                    });
                    break;
                }
            }
        }

            
            {
                b = ck.this;
                a = dy1;
                super();
            }
    }

}
