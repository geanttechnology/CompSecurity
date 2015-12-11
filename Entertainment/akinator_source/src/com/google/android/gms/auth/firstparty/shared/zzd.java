// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.firstparty.shared;


public final class zzd extends Enum
{

    public static final zzd zzTN;
    public static final zzd zzTO;
    public static final zzd zzTP;
    public static final zzd zzTQ;
    public static final zzd zzTR;
    public static final zzd zzTS;
    public static final zzd zzTT;
    public static final zzd zzTU;
    public static final zzd zzTV;
    public static final zzd zzTW;
    public static final zzd zzTX;
    public static final zzd zzTY;
    public static final zzd zzTZ;
    public static final zzd zzUA;
    public static final zzd zzUB;
    public static final zzd zzUC;
    public static final zzd zzUD;
    public static final zzd zzUE;
    public static final zzd zzUF;
    public static final zzd zzUG;
    public static final zzd zzUH;
    public static final zzd zzUI;
    public static final zzd zzUJ;
    private static final zzd zzUL[];
    public static final zzd zzUa;
    public static final zzd zzUb;
    public static final zzd zzUc;
    public static final zzd zzUd;
    public static final zzd zzUe;
    public static final zzd zzUf;
    public static final zzd zzUg;
    public static final zzd zzUh;
    public static final zzd zzUi;
    public static final zzd zzUj;
    public static final zzd zzUk;
    public static final zzd zzUl;
    public static final zzd zzUm;
    public static final zzd zzUn;
    public static final zzd zzUo;
    public static final zzd zzUp;
    public static final zzd zzUq;
    public static final zzd zzUr;
    public static final zzd zzUs;
    public static final zzd zzUt;
    public static final zzd zzUu;
    public static final zzd zzUv;
    public static final zzd zzUw;
    public static final zzd zzUx;
    public static final zzd zzUy;
    public static final zzd zzUz;
    private final String zzUK;

    private zzd(String s, int i, String s1)
    {
        super(s, i);
        zzUK = s1;
    }

    public static zzd valueOf(String s)
    {
        return (zzd)Enum.valueOf(com/google/android/gms/auth/firstparty/shared/zzd, s);
    }

    public static zzd[] values()
    {
        return (zzd[])zzUL.clone();
    }

    public static boolean zza(zzd zzd1)
    {
        return zzTV.equals(zzd1) || zzUe.equals(zzd1) || zzUh.equals(zzd1) || zzTZ.equals(zzd1) || zzUj.equals(zzd1) || zzUl.equals(zzd1) || zzb(zzd1);
    }

    public static boolean zzb(zzd zzd1)
    {
        return zzTO.equals(zzd1) || zzUm.equals(zzd1) || zzUn.equals(zzd1) || zzUo.equals(zzd1) || zzUp.equals(zzd1) || zzUq.equals(zzd1) || zzUr.equals(zzd1) || zzUs.equals(zzd1);
    }

    public static final zzd zzbE(String s)
    {
        zzd zzd1 = null;
        zzd azzd[] = values();
        int j = azzd.length;
        for (int i = 0; i < j; i++)
        {
            zzd zzd2 = azzd[i];
            if (zzd2.zzUK.equals(s))
            {
                zzd1 = zzd2;
            }
        }

        return zzd1;
    }

    public static boolean zzc(zzd zzd1)
    {
        return zzTS.equals(zzd1) || zzTT.equals(zzd1);
    }

    static 
    {
        zzTN = new zzd("CLIENT_LOGIN_DISABLED", 0, "ClientLoginDisabled");
        zzTO = new zzd("DEVICE_MANAGEMENT_REQUIRED", 1, "DeviceManagementRequiredOrSyncDisabled");
        zzTP = new zzd("SOCKET_TIMEOUT", 2, "SocketTimeout");
        zzTQ = new zzd("SUCCESS", 3, "Ok");
        zzTR = new zzd("UNKNOWN_ERROR", 4, "UNKNOWN_ERR");
        zzTS = new zzd("NETWORK_ERROR", 5, "NetworkError");
        zzTT = new zzd("SERVICE_UNAVAILABLE", 6, "ServiceUnavailable");
        zzTU = new zzd("INTNERNAL_ERROR", 7, "InternalError");
        zzTV = new zzd("BAD_AUTHENTICATION", 8, "BadAuthentication");
        zzTW = new zzd("EMPTY_CONSUMER_PKG_OR_SIG", 9, "EmptyConsumerPackageOrSig");
        zzTX = new zzd("NEEDS_2F", 10, "InvalidSecondFactor");
        zzTY = new zzd("NEEDS_POST_SIGN_IN_FLOW", 11, "PostSignInFlowRequired");
        zzTZ = new zzd("NEEDS_BROWSER", 12, "NeedsBrowser");
        zzUa = new zzd("UNKNOWN", 13, "Unknown");
        zzUb = new zzd("NOT_VERIFIED", 14, "NotVerified");
        zzUc = new zzd("TERMS_NOT_AGREED", 15, "TermsNotAgreed");
        zzUd = new zzd("ACCOUNT_DISABLED", 16, "AccountDisabled");
        zzUe = new zzd("CAPTCHA", 17, "CaptchaRequired");
        zzUf = new zzd("ACCOUNT_DELETED", 18, "AccountDeleted");
        zzUg = new zzd("SERVICE_DISABLED", 19, "ServiceDisabled");
        zzUh = new zzd("NEED_PERMISSION", 20, "NeedPermission");
        zzUi = new zzd("INVALID_SCOPE", 21, "INVALID_SCOPE");
        zzUj = new zzd("USER_CANCEL", 22, "UserCancel");
        zzUk = new zzd("PERMISSION_DENIED", 23, "PermissionDenied");
        zzUl = new zzd("THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED", 24, "ThirdPartyDeviceManagementRequired");
        zzUm = new zzd("DM_INTERNAL_ERROR", 25, "DeviceManagementInternalError");
        zzUn = new zzd("DM_SYNC_DISABLED", 26, "DeviceManagementSyncDisabled");
        zzUo = new zzd("DM_ADMIN_BLOCKED", 27, "DeviceManagementAdminBlocked");
        zzUp = new zzd("DM_ADMIN_PENDING_APPROVAL", 28, "DeviceManagementAdminPendingApproval");
        zzUq = new zzd("DM_STALE_SYNC_REQUIRED", 29, "DeviceManagementStaleSyncRequired");
        zzUr = new zzd("DM_DEACTIVATED", 30, "DeviceManagementDeactivated");
        zzUs = new zzd("DM_REQUIRED", 31, "DeviceManagementRequired");
        zzUt = new zzd("ALREADY_HAS_GMAIL", 32, "ALREADY_HAS_GMAIL");
        zzUu = new zzd("BAD_PASSWORD", 33, "WeakPassword");
        zzUv = new zzd("BAD_REQUEST", 34, "BadRequest");
        zzUw = new zzd("BAD_USERNAME", 35, "BadUsername");
        zzUx = new zzd("DELETED_GMAIL", 36, "DeletedGmail");
        zzUy = new zzd("EXISTING_USERNAME", 37, "ExistingUsername");
        zzUz = new zzd("LOGIN_FAIL", 38, "LoginFail");
        zzUA = new zzd("NOT_LOGGED_IN", 39, "NotLoggedIn");
        zzUB = new zzd("NO_GMAIL", 40, "NoGmail");
        zzUC = new zzd("REQUEST_DENIED", 41, "RequestDenied");
        zzUD = new zzd("SERVER_ERROR", 42, "ServerError");
        zzUE = new zzd("USERNAME_UNAVAILABLE", 43, "UsernameUnavailable");
        zzUF = new zzd("GPLUS_OTHER", 44, "GPlusOther");
        zzUG = new zzd("GPLUS_NICKNAME", 45, "GPlusNickname");
        zzUH = new zzd("GPLUS_INVALID_CHAR", 46, "GPlusInvalidChar");
        zzUI = new zzd("GPLUS_INTERSTITIAL", 47, "GPlusInterstitial");
        zzUJ = new zzd("GPLUS_PROFILE_ERROR", 48, "ProfileUpgradeError");
        zzUL = (new zzd[] {
            zzTN, zzTO, zzTP, zzTQ, zzTR, zzTS, zzTT, zzTU, zzTV, zzTW, 
            zzTX, zzTY, zzTZ, zzUa, zzUb, zzUc, zzUd, zzUe, zzUf, zzUg, 
            zzUh, zzUi, zzUj, zzUk, zzUl, zzUm, zzUn, zzUo, zzUp, zzUq, 
            zzUr, zzUs, zzUt, zzUu, zzUv, zzUw, zzUx, zzUy, zzUz, zzUA, 
            zzUB, zzUC, zzUD, zzUE, zzUF, zzUG, zzUH, zzUI, zzUJ
        });
    }
}
