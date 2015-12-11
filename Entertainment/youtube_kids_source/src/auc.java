// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class auc extends Enum
{

    private static auc A;
    private static auc B;
    private static auc C;
    private static auc D;
    private static auc E;
    private static auc F;
    private static auc G;
    private static auc H;
    private static auc I;
    private static auc J;
    private static auc K;
    private static auc L;
    private static auc M;
    private static auc N;
    private static auc O;
    private static auc P;
    private static auc Q;
    private static auc R;
    private static auc S;
    private static auc T;
    private static final auc U[];
    public static final auc a;
    public static final auc b;
    public static final auc c;
    public static final auc d;
    public static final auc e;
    public static final auc f;
    private static auc h;
    private static auc i;
    private static auc j;
    private static auc k;
    private static auc l;
    private static auc m;
    private static auc n;
    private static auc o;
    private static auc p;
    private static auc q;
    private static auc r;
    private static auc s;
    private static auc t;
    private static auc u;
    private static auc v;
    private static auc w;
    private static auc x;
    private static auc y;
    private static auc z;
    public final String g;

    private auc(String s1, int i1, String s2)
    {
        super(s1, i1);
        g = s2;
    }

    public static auc valueOf(String s1)
    {
        return (auc)Enum.valueOf(auc, s1);
    }

    public static auc[] values()
    {
        return (auc[])U.clone();
    }

    static 
    {
        h = new auc("SUCCESS", 0, "Ok");
        i = new auc("BAD_AUTHENTICATION", 1, "BadAuthentication");
        j = new auc("NEEDS_2F", 2, "InvalidSecondFactor");
        k = new auc("NOT_VERIFIED", 3, "NotVerified");
        l = new auc("TERMS_NOT_AGREED", 4, "TermsNotAgreed");
        m = new auc("UNKNOWN", 5, "Unknown");
        n = new auc("UNKNOWN_ERROR", 6, "UNKNOWN_ERR");
        o = new auc("ACCOUNT_DELETED", 7, "AccountDeleted");
        p = new auc("ACCOUNT_DISABLED", 8, "AccountDisabled");
        q = new auc("SERVICE_DISABLED", 9, "ServiceDisabled");
        r = new auc("SERVICE_UNAVAILABLE", 10, "ServiceUnavailable");
        s = new auc("CAPTCHA", 11, "CaptchaRequired");
        t = new auc("NETWORK_ERROR", 12, "NetworkError");
        u = new auc("USER_CANCEL", 13, "UserCancel");
        v = new auc("PERMISSION_DENIED", 14, "PermissionDenied");
        w = new auc("DEVICE_MANAGEMENT_REQUIRED", 15, "DeviceManagementRequiredOrSyncDisabled");
        x = new auc("DM_INTERNAL_ERROR", 16, "DeviceManagementInternalError");
        a = new auc("DM_SYNC_DISABLED", 17, "DeviceManagementSyncDisabled");
        b = new auc("DM_ADMIN_BLOCKED", 18, "DeviceManagementAdminBlocked");
        c = new auc("DM_ADMIN_PENDING_APPROVAL", 19, "DeviceManagementAdminPendingApproval");
        d = new auc("DM_STALE_SYNC_REQUIRED", 20, "DeviceManagementStaleSyncRequired");
        e = new auc("DM_DEACTIVATED", 21, "DeviceManagementDeactivated");
        f = new auc("DM_REQUIRED", 22, "DeviceManagementRequired");
        y = new auc("CLIENT_LOGIN_DISABLED", 23, "ClientLoginDisabled");
        z = new auc("NEED_PERMISSION", 24, "NeedPermission");
        A = new auc("BAD_PASSWORD", 25, "WeakPassword");
        B = new auc("ALREADY_HAS_GMAIL", 26, "ALREADY_HAS_GMAIL");
        C = new auc("BAD_REQUEST", 27, "BadRequest");
        D = new auc("BAD_USERNAME", 28, "BadUsername");
        E = new auc("LOGIN_FAIL", 29, "LoginFail");
        F = new auc("NOT_LOGGED_IN", 30, "NotLoggedIn");
        G = new auc("NO_GMAIL", 31, "NoGmail");
        H = new auc("REQUEST_DENIED", 32, "RequestDenied");
        I = new auc("SERVER_ERROR", 33, "ServerError");
        J = new auc("USERNAME_UNAVAILABLE", 34, "UsernameUnavailable");
        K = new auc("DELETED_GMAIL", 35, "DeletedGmail");
        L = new auc("SOCKET_TIMEOUT", 36, "SocketTimeout");
        M = new auc("EXISTING_USERNAME", 37, "ExistingUsername");
        N = new auc("NEEDS_BROWSER", 38, "NeedsBrowser");
        O = new auc("GPLUS_OTHER", 39, "GPlusOther");
        P = new auc("GPLUS_NICKNAME", 40, "GPlusNickname");
        Q = new auc("GPLUS_INVALID_CHAR", 41, "GPlusInvalidChar");
        R = new auc("GPLUS_INTERSTITIAL", 42, "GPlusInterstitial");
        S = new auc("GPLUS_PROFILE_ERROR", 43, "ProfileUpgradeError");
        T = new auc("INVALID_SCOPE", 44, "INVALID_SCOPE");
        U = (new auc[] {
            h, i, j, k, l, m, n, o, p, q, 
            r, s, t, u, v, w, x, a, b, c, 
            d, e, f, y, z, A, B, C, D, E, 
            F, G, H, I, J, K, L, M, N, O, 
            P, Q, R, S, T
        });
    }
}
