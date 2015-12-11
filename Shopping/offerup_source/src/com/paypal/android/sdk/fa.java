// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public final class fa extends Enum
{

    public static final fa A;
    public static final fa B;
    public static final fa C;
    public static final fa D;
    public static final fa E;
    public static final fa F;
    public static final fa G;
    public static final fa H;
    public static final fa I;
    public static final fa J;
    public static final fa K;
    public static final fa L;
    public static final fa M;
    public static final fa N;
    public static final fa O;
    public static final fa P;
    public static final fa Q;
    public static final fa R;
    public static final fa S;
    public static final fa T;
    public static final fa U;
    public static final fa V;
    public static final fa W;
    public static final fa X;
    public static final fa Y;
    public static final fa Z;
    public static final fa a;
    public static final fa aA;
    public static final fa aB;
    public static final fa aC;
    public static final fa aD;
    public static final fa aE;
    public static final fa aF;
    public static final fa aG;
    public static final fa aH;
    public static final fa aI;
    public static final fa aJ;
    public static final fa aK;
    public static final fa aL;
    public static final fa aM;
    public static final fa aN;
    public static final fa aO;
    public static final fa aP;
    public static final fa aQ;
    public static final fa aR;
    public static final fa aS;
    public static final fa aT;
    public static final fa aU;
    public static final fa aV;
    public static final fa aW;
    public static final fa aX;
    public static final fa aY;
    public static final fa aZ;
    public static final fa aa;
    public static final fa ab;
    public static final fa ac;
    public static final fa ad;
    public static final fa ae;
    public static final fa af;
    public static final fa ag;
    public static final fa ah;
    public static final fa ai;
    public static final fa aj;
    public static final fa ak;
    public static final fa al;
    public static final fa am;
    public static final fa an;
    public static final fa ao;
    public static final fa ap;
    public static final fa aq;
    public static final fa ar;
    public static final fa as;
    public static final fa at;
    public static final fa au;
    public static final fa av;
    public static final fa aw;
    public static final fa ax;
    public static final fa ay;
    public static final fa az;
    public static final fa b;
    public static final fa ba;
    public static final fa bb;
    public static final fa bc;
    public static final fa bd;
    public static final fa be;
    public static final fa bf;
    public static final fa bg;
    public static final fa bh;
    public static final fa bi;
    public static final fa bj;
    public static final fa bk;
    public static final fa bl;
    public static final fa bm;
    public static final fa bn;
    public static final fa bo;
    public static final fa bp;
    public static final fa bq;
    public static final fa br;
    public static final fa bs;
    public static final fa bt;
    public static final fa bu;
    private static final fa bv[];
    public static final fa c;
    public static final fa d;
    public static final fa e;
    public static final fa f;
    public static final fa g;
    public static final fa h;
    public static final fa i;
    public static final fa j;
    public static final fa k;
    public static final fa l;
    public static final fa m;
    public static final fa n;
    public static final fa o;
    public static final fa p;
    public static final fa q;
    public static final fa r;
    public static final fa s;
    public static final fa t;
    public static final fa u;
    public static final fa v;
    public static final fa w;
    public static final fa x;
    public static final fa y;
    public static final fa z;

    private fa(String s1, int i1)
    {
        super(s1, i1);
    }

    public static fa valueOf(String s1)
    {
        return (fa)Enum.valueOf(com/paypal/android/sdk/fa, s1);
    }

    public static fa[] values()
    {
        return (fa[])bv.clone();
    }

    static 
    {
        a = new fa("AGREE_AND_PAY", 0);
        b = new fa("AND_OTHER_FUNDING_SOURCES", 1);
        c = new fa("AUTHENTICATING", 2);
        d = new fa("BACK_BUTTON", 3);
        e = new fa("BACKUP_FUNDING_SOURCE", 4);
        f = new fa("CANCEL", 5);
        g = new fa("CARDTYPE_AMERICANEXPRESS", 6);
        h = new fa("CARDTYPE_CARTAAURA", 7);
        i = new fa("CARDTYPE_CARTEAURORE", 8);
        j = new fa("CARDTYPE_CARTAPREPAGATAPAYPAL", 9);
        k = new fa("CARDTYPE_CARTEBLEUE", 10);
        l = new fa("CARDTYPE_COFINOGA", 11);
        m = new fa("CARDTYPE_DELTA", 12);
        n = new fa("CARDTYPE_DISCOVER", 13);
        o = new fa("CARDTYPE_ELECTRON", 14);
        p = new fa("CARDTYPE_JCB", 15);
        q = new fa("CARDTYPE_MAESTRO", 16);
        r = new fa("CARDTYPE_MASTERCARD", 17);
        s = new fa("CARDTYPE_POSTEPAY", 18);
        t = new fa("CARDTYPE_4ETOILES", 19);
        u = new fa("CARDTYPE_TARJETAAURORA", 20);
        v = new fa("CARDTYPE_VISA", 21);
        w = new fa("CHANGE_PAYMENT_METHOD", 22);
        x = new fa("CHECKING_ACCOUNT_FOR_INSTITUTION", 23);
        y = new fa("CHECKING_DEVICE", 24);
        z = new fa("CLEAR_CREDIT_CARD_INFO", 25);
        A = new fa("CONFIRM", 26);
        B = new fa("CONFIRM_CLEAR_CREDIT_CARD_INFO", 27);
        C = new fa("CONFIRM_CHARGE_CREDIT_CARD", 28);
        D = new fa("CONFIRM_LOG_OUT", 29);
        E = new fa("CONFIRM_SEND_PAYMENT", 30);
        F = new fa("CONSENT_AGREEMENT_AGREE", 31);
        G = new fa("CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_CREATION_DATE", 32);
        H = new fa("CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_STATUS", 33);
        I = new fa("CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_TYPE", 34);
        J = new fa("CONSENT_AGREEMENT_ATTRIBUTE_ADDRESS", 35);
        K = new fa("CONSENT_AGREEMENT_ATTRIBUTE_AGE_RANGE", 36);
        L = new fa("CONSENT_AGREEMENT_ATTRIBUTE_DATE_OF_BIRTH", 37);
        M = new fa("CONSENT_AGREEMENT_ATTRIBUTE_EMAIL_ADDRESS", 38);
        N = new fa("CONSENT_AGREEMENT_ATTRIBUTE_FULL_NAME", 39);
        O = new fa("CONSENT_AGREEMENT_ATTRIBUTE_GENDER", 40);
        P = new fa("CONSENT_AGREEMENT_ATTRIBUTE_LANGUAGE", 41);
        Q = new fa("CONSENT_AGREEMENT_ATTRIBUTE_LOCALE", 42);
        R = new fa("CONSENT_AGREEMENT_ATTRIBUTE_PHONE", 43);
        S = new fa("CONSENT_AGREEMENT_ATTRIBUTE_TIME_ZONE", 44);
        T = new fa("CONSENT_AGREEMENT_ATTRIBUTES", 45);
        U = new fa("CONSENT_AGREEMENT_EXPRESS_CHECKOUT", 46);
        V = new fa("CONSENT_AGREEMENT_INTRO", 47);
        W = new fa("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS", 48);
        X = new fa("CONSENT_AGREEMENT_FUNDING_OPTIONS", 49);
        Y = new fa("CONSENT_AGREEMENT_FUTURE_PAYMENTS", 50);
        Z = new fa("CONSENT_AGREEMENT_LOYALTY_CARD", 51);
        aa = new fa("CONSENT_AGREEMENT_MERCHANT_PRIVACY_POLICY", 52);
        ab = new fa("CONSENT_AGREEMENT_REQUEST_MONEY", 53);
        ac = new fa("CONSENT_AGREEMENT_SEND_MONEY", 54);
        ad = new fa("CONSENT_AGREEMENT_TITLE", 55);
        ae = new fa("EMAIL", 56);
        af = new fa("ENVIRONMENT_MOCK_DATA", 57);
        ag = new fa("ENVIRONMENT_SANDBOX", 58);
        ah = new fa("EXPIRES_ON_DATE", 59);
        ai = new fa("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS", 60);
        aj = new fa("FORGOT_PASSWORD", 61);
        ak = new fa("FROM_ACCOUNT", 62);
        al = new fa("FUTURE_PAYMENT_METHOD_QUESTION", 63);
        am = new fa("FUTURE_PAYMENT_LEGAL_DETAILS", 64);
        an = new fa("INTERNAL_ERROR", 65);
        ao = new fa("JAPANESE_COMPLIANCE_AGREEMENT", 66);
        ap = new fa("LOG_IN", 67);
        aq = new fa("LOG_IN_TO_PAYPAL", 68);
        ar = new fa("LOG_OUT_BUTTON", 69);
        as = new fa("LOG_OUT", 70);
        at = new fa("OK", 71);
        au = new fa("PASSWORD", 72);
        av = new fa("PAY_AFTER_DELIVERY", 73);
        aw = new fa("PAY_WITH", 74);
        ax = new fa("PAY_WITH_CARD", 75);
        ay = new fa("PAYPAL_BALANCE", 76);
        az = new fa("PAYPAL_CREDIT", 77);
        aA = new fa("PHONE", 78);
        aB = new fa("PIN", 79);
        aC = new fa("PREFERRED_PAYMENT_METHOD", 80);
        aD = new fa("PRIVACY", 81);
        aE = new fa("PROCESSING", 82);
        aF = new fa("REMEMBER_CARD", 83);
        aG = new fa("REQUEST_MONEY", 84);
        aH = new fa("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS", 85);
        aI = new fa("SAVINGS_ACCOUNT_FOR_INSTITUTION", 86);
        aJ = new fa("SEND_MONEY", 87);
        aK = new fa("SERVER_PROBLEM", 88);
        aL = new fa("SESSION_EXPIRED_MESSAGE", 89);
        aM = new fa("SESSION_EXPIRED_TITLE", 90);
        aN = new fa("SHIPPING_ADDRESS", 91);
        aO = new fa("SIGN_UP", 92);
        aP = new fa("STAY_LOGGED_IN", 93);
        aQ = new fa("SYSTEM_ERROR_WITH_CODE", 94);
        aR = new fa("TRY_AGAIN", 95);
        aS = new fa("TWO_FA_REQUIRED_ERROR", 96);
        aT = new fa("TWO_FACTOR_AUTH_TITLE", 97);
        aU = new fa("TWO_FACTOR_AUTH_SUBTITLE", 98);
        aV = new fa("TWO_FACTOR_AUTH_SENDING_DIALOG", 99);
        aW = new fa("TWO_FACTOR_AUTH_ENTER_SECURITY_CODE", 100);
        aX = new fa("TWO_FACTOR_AUTH_ENTER_MOBILE_NUMBER", 101);
        aY = new fa("TWO_FACTOR_AUTH_SEND_SMS", 102);
        aZ = new fa("TWO_FACTOR_AUTH_SEND_SMS_AGAIN", 103);
        ba = new fa("TWO_FACTOR_AUTH_NO_ACTIVE_TOKENS_ERROR", 104);
        bb = new fa("UNAUTHORIZED_DEVICE_MESSAGE", 105);
        bc = new fa("UNAUTHORIZED_DEVICE_TITLE", 106);
        bd = new fa("UNAUTHORIZED_MERCHANT_MESSAGE", 107);
        be = new fa("UNAUTHORIZED_MERCHANT_TITLE", 108);
        bf = new fa("UNEXPECTED_PAYMENT_FLOW", 109);
        bg = new fa("UNKNOWN_FUNDING_SOURCE", 110);
        bh = new fa("WE_ARE_SORRY", 111);
        bi = new fa("YOUR_ORDER", 112);
        bj = new fa("CLEAR_CC_ALERT_TITLE", 113);
        bk = new fa("CONSENT_FAILED_ALERT_TITLE", 114);
        bl = new fa("CONNECTION_FAILED_TITLE", 115);
        bm = new fa("LOGIN_FAILED_ALERT_TITLE", 116);
        bn = new fa("LOGIN_WITH_EMAIL", 117);
        bo = new fa("LOGIN_WITH_PHONE", 118);
        bp = new fa("ONE_MOMENT", 119);
        bq = new fa("PAY_FAILED_ALERT_TITLE", 120);
        br = new fa("SCAN_CARD_ICON_DESCRIPTION", 121);
        bs = new fa("TWO_FACTOR_AUTH_INVALID_ONE_TIME_PASSWORD", 122);
        bt = new fa("VIA_LABEL", 123);
        bu = new fa("PP_SERVICE_ERROR_JSON_PARSE_ERROR", 124);
        bv = (new fa[] {
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
            aW, aX, aY, aZ, ba, bb, bc, bd, be, bf, 
            bg, bh, bi, bj, bk, bl, bm, bn, bo, bp, 
            bq, br, bs, bt, bu
        });
    }
}
