// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;


// Referenced classes of package com.google.android.gms.analytics:
//            u

public static final class  extends Enum
{

    public static final tv sA;
    public static final tv sB;
    public static final tv sC;
    public static final tv sD;
    public static final tv sE;
    public static final tv sF;
    public static final tv sG;
    public static final tv sH;
    public static final tv sI;
    public static final tv sJ;
    public static final tv sK;
    public static final tv sL;
    public static final tv sM;
    public static final tv sN;
    public static final tv sO;
    public static final tv sP;
    public static final tv sQ;
    public static final tv sR;
    public static final tv sS;
    public static final tv sT;
    public static final tv sU;
    public static final tv sV;
    public static final tv sW;
    public static final tv sX;
    public static final tv sY;
    public static final tv sZ;
    public static final tv sl;
    public static final tv sm;
    public static final tv sn;
    public static final tv so;
    public static final tv sp;
    public static final tv sq;
    public static final tv sr;
    public static final tv ss;
    public static final tv st;
    public static final tv su;
    public static final tv sv;
    public static final tv sw;
    public static final tv sx;
    public static final tv sy;
    public static final tv sz;
    public static final tv ta;
    public static final tv tb;
    public static final tv tc;
    public static final tv td;
    public static final tv te;
    public static final tv tf;
    public static final tv tg;
    public static final tv th;
    public static final tv ti;
    public static final tv tj;
    public static final tv tk;
    public static final tv tl;
    public static final tv tm;
    public static final tv tn;
    public static final tv to;
    public static final tv tp;
    public static final tv tq;
    public static final tv tr;
    public static final tv ts;
    public static final tv tt;
    public static final tv tu;
    public static final tv tv;
    private static final tv tw[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/gms/analytics/u$a, s);
    }

    public static [] values()
    {
        return ([])tw.clone();
    }

    static 
    {
        sl = new <init>("MAP_BUILDER_SET", 0);
        sm = new <init>("MAP_BUILDER_SET_ALL", 1);
        sn = new <init>("MAP_BUILDER_GET", 2);
        so = new <init>("MAP_BUILDER_SET_CAMPAIGN_PARAMS", 3);
        sp = new <init>("BLANK_04", 4);
        sq = new <init>("BLANK_05", 5);
        sr = new <init>("BLANK_06", 6);
        ss = new <init>("BLANK_07", 7);
        st = new <init>("BLANK_08", 8);
        su = new <init>("GET", 9);
        sv = new <init>("SET", 10);
        sw = new <init>("SEND", 11);
        sx = new <init>("BLANK_12", 12);
        sy = new <init>("BLANK_13", 13);
        sz = new <init>("BLANK_14", 14);
        sA = new <init>("BLANK_15", 15);
        sB = new <init>("BLANK_16", 16);
        sC = new <init>("BLANK_17", 17);
        sD = new <init>("BLANK_18", 18);
        sE = new <init>("BLANK_19", 19);
        sF = new <init>("BLANK_20", 20);
        sG = new <init>("BLANK_21", 21);
        sH = new <init>("BLANK_22", 22);
        sI = new <init>("BLANK_23", 23);
        sJ = new <init>("BLANK_24", 24);
        sK = new <init>("BLANK_25", 25);
        sL = new <init>("BLANK_26", 26);
        sM = new <init>("BLANK_27", 27);
        sN = new <init>("BLANK_28", 28);
        sO = new <init>("BLANK_29", 29);
        sP = new <init>("SET_EXCEPTION_PARSER", 30);
        sQ = new <init>("GET_EXCEPTION_PARSER", 31);
        sR = new <init>("CONSTRUCT_TRANSACTION", 32);
        sS = new <init>("CONSTRUCT_EXCEPTION", 33);
        sT = new <init>("CONSTRUCT_RAW_EXCEPTION", 34);
        sU = new <init>("CONSTRUCT_TIMING", 35);
        sV = new <init>("CONSTRUCT_SOCIAL", 36);
        sW = new <init>("BLANK_37", 37);
        sX = new <init>("BLANK_38", 38);
        sY = new <init>("GET_TRACKER", 39);
        sZ = new <init>("GET_DEFAULT_TRACKER", 40);
        ta = new <init>("SET_DEFAULT_TRACKER", 41);
        tb = new <init>("SET_APP_OPT_OUT", 42);
        tc = new <init>("GET_APP_OPT_OUT", 43);
        td = new <init>("DISPATCH", 44);
        te = new <init>("SET_DISPATCH_PERIOD", 45);
        tf = new <init>("BLANK_46", 46);
        tg = new <init>("REPORT_UNCAUGHT_EXCEPTIONS", 47);
        th = new <init>("SET_AUTO_ACTIVITY_TRACKING", 48);
        ti = new <init>("SET_SESSION_TIMEOUT", 49);
        tj = new <init>("CONSTRUCT_EVENT", 50);
        tk = new <init>("CONSTRUCT_ITEM", 51);
        tl = new <init>("BLANK_52", 52);
        tm = new <init>("BLANK_53", 53);
        tn = new <init>("SET_DRY_RUN", 54);
        to = new <init>("GET_DRY_RUN", 55);
        tp = new <init>("SET_LOGGER", 56);
        tq = new <init>("SET_FORCE_LOCAL_DISPATCH", 57);
        tr = new <init>("GET_TRACKER_NAME", 58);
        ts = new <init>("CLOSE_TRACKER", 59);
        tt = new <init>("EASY_TRACKER_ACTIVITY_START", 60);
        tu = new <init>("EASY_TRACKER_ACTIVITY_STOP", 61);
        tv = new <init>("CONSTRUCT_APP_VIEW", 62);
        tw = (new tw[] {
            sl, sm, sn, so, sp, sq, sr, ss, st, su, 
            sv, sw, sx, sy, sz, sA, sB, sC, sD, sE, 
            sF, sG, sH, sI, sJ, sK, sL, sM, sN, sO, 
            sP, sQ, sR, sS, sT, sU, sV, sW, sX, sY, 
            sZ, ta, tb, tc, td, te, tf, tg, th, ti, 
            tj, tk, tl, tm, tn, to, tp, tq, tr, ts, 
            tt, tu, tv
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
