// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.primeupsell;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.amazon.mShop.control.account.OneClickController;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.splashscreen.StartupActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.OneClickConfigResponse;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.amazon.mShop.primeupsell:
//            PrimeUpsellDatabaseHelper, PrimeFlagChecker, PrimeUpsellDebugSettingsActivity, PrimeUpsellActivity

public class PrimeUpsellHelper
{
    private static class PrimeOneClickSubscriber
        implements com.amazon.mShop.control.account.OneClickController.OneClickSubscriber
    {

        public void onError(Exception exception, ServiceCall servicecall)
        {
            PrimeUpsellHelper.refreshUserInfo();
        }

        public void onReceiveOneClickAddresses(List list)
        {
        }

        public void onReceiveOneClickConfig(OneClickConfigResponse oneclickconfigresponse)
        {
        }

        public void onRequiresUserLogin(com.amazon.mShop.model.auth.UserSubscriber.Callback callback)
        {
        }

        public void onSaveOneClickStatus(boolean flag)
        {
            PrimeUpsellHelper.refreshUserInfo();
        }

        private PrimeOneClickSubscriber()
        {
        }

    }

    public static interface PrimeUpsellSubscriber
    {

        public abstract void onComplete(boolean flag);

        public abstract void onPageLoadFinished();

        public abstract void onUserCancel();
    }


    private static final List sExcludeOrigin = Arrays.asList(new String[] {
        "public_url", "authenticate_user"
    });
    private static boolean sPrimeUpsellLaunched = false;
    private static PrimeUpsellSubscriber sPrimeUpsellSubscriber;

    public PrimeUpsellHelper()
    {
    }

    public static String getPrimeRefMarkerFromLoginOrigin(boolean flag, String s)
    {
        String s1 = null;
        if (flag)
        {
            s1 = "prime_fs";
        } else
        {
            if ("gno".equalsIgnoreCase(s))
            {
                return "prime_gno";
            }
            if ("gw".equalsIgnoreCase(s))
            {
                return "prime_gw";
            }
        }
        return s1;
    }

    public static boolean isPrimeUpsellLaunched()
    {
        return sPrimeUpsellLaunched;
    }

    private static boolean notExceedMaximumTimes(User user)
    {
        if (!Util.isEmpty(user.getFullName()))
        {
            boolean flag = true;
            int i = ((flag) ? 1 : 0);
            if (DebugSettings.isDebugEnabled())
            {
                int j = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getInt("primeMaximumTimeToShowDebug");
                i = ((flag) ? 1 : 0);
                if (j != 0)
                {
                    i = j;
                }
            }
            return PrimeUpsellDatabaseHelper.getInstance().notExceedMaxCount(user.getFullName(), i, 3);
        } else
        {
            return false;
        }
    }

    static void primePageFinishLoading()
    {
        if (sPrimeUpsellSubscriber != null)
        {
            sPrimeUpsellSubscriber.onPageLoadFinished();
        }
    }

    static void primeUpsellFinished(PrimeUpsellActivity.PrimeUpsellResult primeupsellresult)
    {
        boolean flag = false;
        if (PrimeUpsellActivity.PrimeUpsellResult.RESULT_SIGNUP_SUCCESS == primeupsellresult)
        {
            userSignupPrime();
        } else
        if (PrimeUpsellActivity.PrimeUpsellResult.RESULT_OFFER_PAGE_NOT_DISPLAYED == primeupsellresult || PrimeUpsellActivity.PrimeUpsellResult.RESULT_LOAD_PAGE_ERROR == primeupsellresult)
        {
            flag = true;
        }
        showedPrimeUpsellTo(User.getUser(), flag);
        if (sPrimeUpsellSubscriber != null)
        {
            if (PrimeUpsellActivity.PrimeUpsellResult.RESULT_USER_CANCELLED == primeupsellresult || PrimeUpsellActivity.PrimeUpsellResult.RESULT_LOAD_PAGE_ERROR == primeupsellresult || PrimeUpsellActivity.PrimeUpsellResult.RESULT_OFFER_PAGE_NOT_DISPLAYED == primeupsellresult)
            {
                sPrimeUpsellSubscriber.onUserCancel();
            } else
            if (PrimeUpsellActivity.PrimeUpsellResult.RESULT_SIGNUP_SUCCESS == primeupsellresult || PrimeUpsellActivity.PrimeUpsellResult.RESULT_SIGNUP_FAILURE == primeupsellresult)
            {
                PrimeUpsellSubscriber primeupsellsubscriber = sPrimeUpsellSubscriber;
                boolean flag1;
                if (PrimeUpsellActivity.PrimeUpsellResult.RESULT_SIGNUP_SUCCESS == primeupsellresult)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                primeupsellsubscriber.onComplete(flag1);
            }
        }
        sPrimeUpsellSubscriber = null;
    }

    private static void refreshUserInfo()
    {
        (new PrimeFlagChecker(null)).checkFlag();
    }

    public static boolean shouldCheckPrimeFlagStatus()
    {
label0:
        {
            boolean flag = false;
            if (ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_prime_upsell_support))
            {
                User user = User.getUser();
                if (user == null || user.isPrime() || !PrimeUpsellDatabaseHelper.getInstance().notExceedMaxCount(user.getFullName(), 1, 1))
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        return false;
    }

    public static boolean shouldShowPrimeUpsell(Context context)
    {
        String s;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        flag2 = true;
        flag3 = false;
        context = User.getUser();
        if (context != null && context.isPrimeEligible())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag = flag1;
        if (!DebugSettings.isDebugEnabled()) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (context != null)
        {
            flag = flag1;
            if (com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("primeUpsellForceEligibleToNonPrimeUserDebug", false))
            {
                if (!context.isPrime())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
        }
        s = PrimeUpsellDebugSettingsActivity.getPrimeUpsellDebugMode();
        if (!"always".equalsIgnoreCase(s)) goto _L4; else goto _L3
_L3:
        flag1 = flag;
_L5:
        return flag1;
_L4:
        flag1 = flag3;
        if ("never".equalsIgnoreCase(s)) goto _L5; else goto _L2
_L2:
        if (flag && notExceedMaximumTimes(context))
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public static boolean shouldTryToShowPrimeAfterLogin(String s, boolean flag, boolean flag1)
    {
        if (sExcludeOrigin.contains(s))
        {
            return false;
        }
        return flag || flag1;
    }

    public static boolean showPrimeUpsell(Activity activity, PrimeUpsellSubscriber primeupsellsubscriber, String s)
    {
        return showPrimeUpsell(activity, primeupsellsubscriber, s, null);
    }

    public static boolean showPrimeUpsell(Activity activity, PrimeUpsellSubscriber primeupsellsubscriber, String s, String s1)
    {
        boolean flag1 = false;
        if (activity != null && ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_prime_upsell_support) && NetInfo.hasNetworkConnection()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        sPrimeUpsellLaunched = flag;
        return flag;
_L2:
        flag = flag1;
        if (shouldShowPrimeUpsell(activity))
        {
            flag = flag1;
            if (!(activity instanceof PrimeUpsellActivity))
            {
                String s2 = AndroidPlatform.getInstance().getDataStore().getString("currentPrimeUpsellUrl");
                Object obj = s2;
                if (Util.isEmpty(s2))
                {
                    obj = s2;
                    if (User.getUser() != null)
                    {
                        obj = User.getUser().getPrimeFunnelUrl();
                    }
                }
                flag = flag1;
                if (!Util.isEmpty(((String) (obj))))
                {
                    obj = Uri.parse(((String) (obj))).buildUpon();
                    ((android.net.Uri.Builder) (obj)).appendQueryParameter("return_url", "amznapp://page?app-action=dismiss-all");
                    obj = ActivityUtils.getStartWebActivityIntent(activity, com/amazon/mShop/primeupsell/PrimeUpsellActivity, ((android.net.Uri.Builder) (obj)).build().toString(), -1);
                    if (Util.isEmpty(s1))
                    {
                        activity.startActivity(((android.content.Intent) (obj)));
                    } else
                    {
                        StartupActivity.startActivityForStartup(activity, ((android.content.Intent) (obj)), s1);
                    }
                    sPrimeUpsellSubscriber = primeupsellsubscriber;
                    flag = true;
                    RefMarkerObserver.logRefMarker(s);
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void showedPrimeUpsellTo(User user, boolean flag)
    {
        if (user != null && user.getFullName() != null)
        {
            PrimeUpsellDatabaseHelper.getInstance().showedPrimeTo(user.getFullName(), flag);
        }
    }

    private static void userSignupPrime()
    {
        if (User.getUser().isOneClick())
        {
            refreshUserInfo();
            return;
        } else
        {
            OneClickController oneclickcontroller = new OneClickController(new PrimeOneClickSubscriber());
            oneclickcontroller.setDeviceName(com.amazon.mShop.platform.Platform.Factory.getInstance().getDeviceName());
            oneclickcontroller.doSetOneClickEnabled(true, null);
            return;
        }
    }


}
