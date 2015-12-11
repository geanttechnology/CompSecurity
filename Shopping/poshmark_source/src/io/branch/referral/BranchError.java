// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


public class BranchError
{

    public static final int ERR_API_LVL_14_NEEDED = -108;
    public static final int ERR_BRANCH_DUPLICATE_REFERRAL_CODE = -106;
    public static final int ERR_BRANCH_DUPLICATE_URL = -105;
    public static final int ERR_BRANCH_INIT_FAILED = -104;
    public static final int ERR_BRANCH_NOT_INSTANTIATED = -109;
    public static final int ERR_BRANCH_NO_SHARE_OPTION = -110;
    public static final int ERR_BRANCH_REDEEM_REWARD = -107;
    public static final int ERR_INVALID_REFERRAL_CODE = -103;
    public static final int ERR_NO_INTERNET_PERMISSION = -102;
    public static final int ERR_NO_SESSION = -101;
    String errorMessage_;

    public BranchError(String s, int i)
    {
        errorMessage_ = "";
        errorMessage_ = (new StringBuilder()).append(s).append(getLocalisedErrorMessage(i)).toString();
    }

    private String getLocalisedErrorMessage(int i)
    {
        if (i == -1009)
        {
            return " Branch API Error: poor network connectivity. Please try again later.";
        }
        if (i == -1234)
        {
            return " Branch API Error: Please enter your branch_key in your project's manifest file first.";
        }
        if (i == -104)
        {
            return " Did you forget to call init? Make sure you init the session before making Branch calls.";
        }
        if (i == -101)
        {
            return " Unable to initialize Branch. Check network connectivity or that your branch key is valid.";
        }
        if (i == -102)
        {
            return " Please add 'android.permission.INTERNET' in your applications manifest file.";
        }
        if (i == -105)
        {
            return " Unable to create a URL with that alias. If you want to reuse the alias, make sure to submit the same properties for all arguments and that the user is the same owner.";
        }
        if (i == -106)
        {
            return " That Branch referral code is already in use.";
        }
        if (i == -107)
        {
            return " Unable to redeem rewards. Please make sure you have credits available to redeem.";
        }
        if (i == -108)
        {
            return "BranchApp class can be used only with API level 14 or above. Please make sure your minimum API level supported is 14. If you wish to use API level below 14 consider calling getInstance(Context) instead.";
        }
        if (i == -109)
        {
            return "Branch instance is not created. Make  sure your Application class is an instance of BranchLikedApp.";
        }
        if (i == -110)
        {
            return " Unable create share options. Couldn't find applications on device to share the link.";
        }
        if (i >= 500)
        {
            return " Unable to reach the Branch servers, please try again shortly.";
        }
        if (i == 409)
        {
            return " A resource with this identifier already exists.";
        }
        if (i > 400)
        {
            return " The request was invalid.";
        } else
        {
            return " Check network connectivity and that you properly initialized.";
        }
    }

    public String getMessage()
    {
        return errorMessage_;
    }

    public String toString()
    {
        return getMessage();
    }
}
