// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


// Referenced classes of package io.branch.referral:
//            Defines

public static final class key extends Enum
{

    private static final DebugConnect $VALUES[];
    public static final DebugConnect ApplyReferralCode;
    public static final DebugConnect CompletedAction;
    public static final DebugConnect DebugConnect;
    public static final DebugConnect GetCreditHistory;
    public static final DebugConnect GetCredits;
    public static final DebugConnect GetReferralCode;
    public static final DebugConnect GetURL;
    public static final DebugConnect IdentifyUser;
    public static final DebugConnect Logout;
    public static final DebugConnect RedeemRewards;
    public static final DebugConnect Referrals;
    public static final DebugConnect RegisterClose;
    public static final DebugConnect RegisterInstall;
    public static final DebugConnect RegisterOpen;
    public static final DebugConnect RegisterView;
    public static final DebugConnect SendAPPList;
    public static final DebugConnect ValidateReferralCode;
    private String key;

    public static key valueOf(String s)
    {
        return (key)Enum.valueOf(io/branch/referral/Defines$RequestPath, s);
    }

    public static key[] values()
    {
        return (key[])$VALUES.clone();
    }

    public String getPath()
    {
        return key;
    }

    public String toString()
    {
        return key;
    }

    static 
    {
        RedeemRewards = new <init>("RedeemRewards", 0, "v1/redeem");
        GetURL = new <init>("GetURL", 1, "v1/url");
        RegisterInstall = new <init>("RegisterInstall", 2, "v1/install");
        RegisterClose = new <init>("RegisterClose", 3, "v1/close");
        RegisterOpen = new <init>("RegisterOpen", 4, "v1/open");
        RegisterView = new <init>("RegisterView", 5, "v1/register-view");
        Referrals = new <init>("Referrals", 6, "v1/referrals/");
        SendAPPList = new <init>("SendAPPList", 7, "v1/applist");
        GetCredits = new <init>("GetCredits", 8, "v1/credits/");
        GetCreditHistory = new <init>("GetCreditHistory", 9, "v1/credithistory");
        CompletedAction = new <init>("CompletedAction", 10, "v1/event");
        IdentifyUser = new <init>("IdentifyUser", 11, "v1/profile");
        Logout = new <init>("Logout", 12, "v1/logout");
        GetReferralCode = new <init>("GetReferralCode", 13, "v1/referralcode");
        ValidateReferralCode = new <init>("ValidateReferralCode", 14, "v1/referralcode/");
        ApplyReferralCode = new <init>("ApplyReferralCode", 15, "v1/applycode/");
        DebugConnect = new <init>("DebugConnect", 16, "v1/debug/connect");
        $VALUES = (new .VALUES[] {
            RedeemRewards, GetURL, RegisterInstall, RegisterClose, RegisterOpen, RegisterView, Referrals, SendAPPList, GetCredits, GetCreditHistory, 
            CompletedAction, IdentifyUser, Logout, GetReferralCode, ValidateReferralCode, ApplyReferralCode, DebugConnect
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        key = "";
        key = s1;
    }
}
