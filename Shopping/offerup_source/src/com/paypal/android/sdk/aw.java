// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


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
    public static final aw T;
    public static final aw U;
    public static final aw V;
    public static final aw W;
    public static final aw X;
    private static aw Y;
    private static aw Z;
    public static final aw a;
    private static aw aA;
    private static aw aB;
    private static aw aC;
    private static final aw aE[];
    private static aw aa;
    private static aw ab;
    private static aw ac;
    private static aw ad;
    private static aw ae;
    private static aw af;
    private static aw ag;
    private static aw ah;
    private static aw ai;
    private static aw aj;
    private static aw ak;
    private static aw al;
    private static aw am;
    private static aw an;
    private static aw ao;
    private static aw ap;
    private static aw aq;
    private static aw ar;
    private static aw as;
    private static aw at;
    private static aw au;
    private static aw av;
    private static aw aw;
    private static aw ax;
    private static aw ay;
    private static aw az;
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
    private int aD;

    private aw(String s1, int i1, int j1)
    {
        super(s1, i1);
        aD = j1;
    }

    public static aw valueOf(String s1)
    {
        return (aw)Enum.valueOf(com/paypal/android/sdk/aw, s1);
    }

    public static aw[] values()
    {
        return (aw[])aE.clone();
    }

    public final int a()
    {
        return aD;
    }

    static 
    {
        Y = new aw("PPRiskDataAnId", 0, 0);
        a = new aw("PPRiskDataAppGuid", 1, 1);
        b = new aw("PPRiskDataAppId", 2, 2);
        c = new aw("PPRiskDataAppVersion", 3, 3);
        d = new aw("PPRiskDataBaseStationId", 4, 4);
        e = new aw("PPRiskDataBssid", 5, 5);
        f = new aw("PPRiskDataCellId", 6, 6);
        Z = new aw("PPRiskDataClrVersion", 7, 7);
        aa = new aw("PPRiskDataCompVersion", 8, 8);
        ab = new aw("PPRiskDataConfUrl", 9, 9);
        ac = new aw("PPRiskDataConfVersion", 10, 10);
        g = new aw("PPRiskDataConnType", 11, 11);
        ad = new aw("PPRiskDataDeviceFirmwareVersion", 12, 12);
        h = new aw("PPRiskDataDeviceId", 13, 13);
        i = new aw("PPRiskDataDeviceModel", 14, 14);
        j = new aw("PPRiskDataDeviceName", 15, 15);
        k = new aw("PPRiskDataDeviceUptime", 16, 16);
        ae = new aw("PPRiskDataDongleDeviceId", 17, 17);
        af = new aw("PPRiskDataEmailConfigured", 18, 18);
        ag = new aw("PPRiskDataEmulator", 19, 19);
        ah = new aw("PPRiskDataError", 20, 20);
        l = new aw("PPRiskDataIpAddrs", 21, 21);
        ai = new aw("PPRiskDataKeyboardPresent", 22, 22);
        m = new aw("PPRiskDataKnownApps", 23, 23);
        n = new aw("PPRiskDataLine1Number", 24, 24);
        o = new aw("PPRiskDataLinkerId", 25, 25);
        aj = new aw("PPRiskDataLicenseAccepted", 26, 26);
        p = new aw("PPRiskDataLocaleCountry", 27, 27);
        q = new aw("PPRiskDataLocaleLang", 28, 28);
        r = new aw("PPRiskDataLocation", 29, 29);
        s = new aw("PPRiskDataLocationAreaCode", 30, 30);
        ak = new aw("PPRiskDataLocationAuthStatus", 31, 31);
        t = new aw("PPRiskDataMacAddrs", 32, 32);
        al = new aw("PPRiskDataMobileOperatorName", 33, 33);
        u = new aw("PPRiskDataNotifToken", 34, 34);
        am = new aw("PPRiskDataOsPlatform", 35, 35);
        v = new aw("PPRiskDataOsType", 36, 36);
        an = new aw("PPRiskDataOsVersion", 37, 37);
        ao = new aw("PPRiskDataPayloadType", 38, 38);
        w = new aw("PPRiskDataPhoneType", 39, 39);
        ap = new aw("PPRiskDataPinLockLastTimestamp", 40, 40);
        aq = new aw("PPRiskDataPowerSource", 41, 41);
        x = new aw("PPRiskDataRiskCompSessionId", 42, 42);
        y = new aw("PPRiskDataRoaming", 43, 43);
        ar = new aw("PPRiskDataRoamingPossible", 44, 44);
        z = new aw("PPRiskDataSimOperatorName", 45, 45);
        as = new aw("PPRiskDataSimSerialNumber", 46, 46);
        A = new aw("PPRiskDataSmsEnabled", 47, 47);
        B = new aw("PPRiskDataSsid", 48, 48);
        C = new aw("PPRiskDataSubscriberId", 49, 49);
        D = new aw("PPRiskDataTimestamp", 50, 50);
        at = new aw("PPRiskDataTotalDeviceMemory", 51, 51);
        E = new aw("PPRiskDataTotalStorageSpace", 52, 52);
        F = new aw("PPRiskDataTzName", 53, 53);
        G = new aw("PPRiskDataAdvertisingIdentifier", 54, 54);
        au = new aw("PPRiskDataVendorIdentifier", 55, 55);
        H = new aw("PPRiskDataNetworkOperator", 56, 56);
        I = new aw("PPRiskDataCdmaNetworkId", 57, 57);
        J = new aw("PPRiskDataCdmaSystemId", 58, 58);
        K = new aw("PPRiskDataIsEmulator", 59, 59);
        L = new aw("PPRiskDataIsRooted", 60, 60);
        av = new aw("PPRiskDataGeoCountry", 61, 61);
        M = new aw("PPRiskDataSourceApp", 62, 62);
        N = new aw("PPRiskDataSourceAppVersion", 63, 63);
        O = new aw("PPRiskDataPairingId", 64, 64);
        P = new aw("PPRiskDataAppFirstInstallTime", 65, 65);
        Q = new aw("PPRiskDataAppLastUpdateTime", 66, 66);
        aw = new aw("PPRiskDataBluetoothMacAddress", 67, 67);
        R = new aw("PPRiskDataSerialNumber", 68, 68);
        S = new aw("PPRiskDataAndroidId", 69, 69);
        T = new aw("PPRiskDataGsfId", 70, 70);
        U = new aw("PPRiskDataVPNSetting", 71, 71);
        V = new aw("PPRiskDataProxySetting", 72, 72);
        ax = new aw("PPRiskDataLocalIdentifier", 73, 73);
        ay = new aw("PPRiskDataCloudIdentifier", 74, 74);
        az = new aw("PPRiskDataUnused1", 75, 75);
        aA = new aw("PPRiskDataUnused2", 76, 76);
        aB = new aw("PPRiskDataUnused3", 77, 77);
        aC = new aw("PPRiskDataUnused4", 78, 78);
        W = new aw("PPRiskDataIsDaylightSaving", 79, 79);
        X = new aw("PPRiskDataTimeZoneOffset", 80, 80);
        aE = (new aw[] {
            Y, a, b, c, d, e, f, Z, aa, ab, 
            ac, g, ad, h, i, j, k, ae, af, ag, 
            ah, l, ai, m, n, o, aj, p, q, r, 
            s, ak, t, al, u, am, v, an, ao, w, 
            ap, aq, x, y, ar, z, as, A, B, C, 
            D, at, E, F, G, au, H, I, J, K, 
            L, av, M, N, O, P, Q, aw, R, S, 
            T, U, V, ax, ay, az, aA, aB, aC, W, 
            X
        });
    }
}
