// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.mShop.ActivityTerminationReceiver;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.contentprovider.HomeServiceCallWrapper;
import com.amazon.mShop.kiang.KiangController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.CallObserver;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.net.ServiceCallIdentifier;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOBackgroundAccountService, SSOUtil, MShopCheckLogin, AccountCookiesSyncManager, 
//            DebugListener, DistributedSSOLoginActivity, DistributedSSOLogoutActivity, CentralSSOLoginActivity, 
//            CentralSSOLogoutActivity

public abstract class IdentityType extends Enum
{

    private static final IdentityType $VALUES[];
    public static final IdentityType CENTRAL_SSO_TYPE;
    public static final IdentityType DISTRIBUTED_SSO_TYPE;
    public static final IdentityType NON_SSO_TYPE;

    private IdentityType(String s, int i)
    {
        super(s, i);
    }


    public static IdentityType valueOf(String s)
    {
        return (IdentityType)Enum.valueOf(com/amazon/mShop/sso/IdentityType, s);
    }

    public static IdentityType[] values()
    {
        return (IdentityType[])$VALUES.clone();
    }

    public abstract void handleBackgroundService(SSOBackgroundAccountService ssobackgroundaccountservice, Intent intent);

    public abstract void handleSSOInit(Context context);

    public abstract void handleSSOLogin(Activity activity);

    public abstract void handleSSOLogin(Activity activity, boolean flag, boolean flag1, boolean flag2, String s);

    public abstract void handleSSOLogin(Context context, String s, int i);

    public abstract void handleSSOLogout(AmazonActivity amazonactivity);

    static 
    {
        DISTRIBUTED_SSO_TYPE = new IdentityType("DISTRIBUTED_SSO_TYPE", 0) {

            private boolean ignoreNewAddedAccount(String s)
            {
                if (SSOUtil.isLoginTriggeredFromApplication())
                {
                    SSOUtil.setLoginTriggeredFromApplication(false);
                } else
                {
                    String s1 = SSOUtil.getAuthPoolForCurrentLocale();
                    String s2 = SSOUtil.getAuthPoolFromAccount(s);
                    if (SSOUtil.DEBUG)
                    {
                        Log.d("Amazon.SSOUtil", (new StringBuilder()).append("IdentityType: currentAuthPool: ").append(s1).append("the auth pool of account ").append(s).append(" is ").append(s2).toString());
                    }
                    if (s1.equals(s2))
                    {
                        return User.isLoggedIn();
                    }
                }
                return true;
            }

            private boolean silentUpgradeAccount(Context context)
            {
                Object obj;
                Object obj1;
                Object obj2;
                String s;
                Object obj3;
                Object obj4;
                Object obj5;
                HashSet hashset;
                CallObserver callobserver;
                Object obj6;
                boolean flag;
                boolean flag1;
                boolean flag2;
                boolean flag3;
                boolean flag4;
                boolean flag5;
                boolean flag6;
                obj2 = CookieBridge.getAtMainCookie(context);
                s = CookieBridge.getUbidCookie(context);
                if (Util.isEmpty(((String) (obj2))) || Util.isEmpty(s))
                {
                    return false;
                }
                obj = SSOUtil.getMAPAccountManager(context);
                hashset = new HashSet();
                hashset.addAll(((MAPAccountManager) (obj)).getAccounts());
                obj1 = new Bundle();
                ((Bundle) (obj1)).putString("com.amazon.identity.ap.domain", CookieBridge.getCookieDomain(context, true).substring(1));
                ((Bundle) (obj1)).putString("com.amazon.dcp.sso.AddAccount.options.AuthToken", ((String) (obj2)));
                ((Bundle) (obj1)).putString("com.amazon.dcp.sso.AddAccount.options.AuthTokenClientContext", s);
                ((Bundle) (obj1)).putBoolean("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary", true);
                callobserver = CallObserver.start(new ServiceCallIdentifier("MobileAuthenticationPlatform", "silentUpgrade"));
                flag4 = false;
                flag5 = false;
                flag6 = false;
                flag3 = false;
                SSOUtil.setLoginTriggeredFromApplication(true);
                obj6 = ((MAPAccountManager) (obj)).registerAccount(RegistrationType.FROM_AUTH_TOKEN, ((Bundle) (obj1)), null);
                obj3 = null;
                obj4 = null;
                obj5 = null;
                obj = null;
                obj1 = obj3;
                flag = flag4;
                obj2 = obj4;
                flag1 = flag5;
                s = obj5;
                flag2 = flag6;
                obj6 = (Bundle)((MAPFuture) (obj6)).get();
                if (obj6 == null) goto _L2; else goto _L1
_L1:
                obj1 = obj3;
                flag = flag4;
                obj2 = obj4;
                flag1 = flag5;
                s = obj5;
                flag2 = flag6;
                if (Util.isEmpty(((Bundle) (obj6)).getString("com.amazon.dcp.sso.property.account.acctId"))) goto _L2; else goto _L3
_L3:
                flag4 = true;
                flag5 = true;
                flag6 = true;
                flag3 = true;
                obj1 = obj3;
                flag = flag4;
                obj2 = obj4;
                flag1 = flag5;
                s = obj5;
                flag2 = flag6;
                obj = ((Bundle) (obj6)).getString("com.amazon.dcp.sso.property.account.acctId");
                obj1 = obj;
                flag = flag4;
                obj2 = obj;
                flag1 = flag5;
                s = ((String) (obj));
                flag2 = flag6;
                callobserver.onComplete();
                flag = flag3;
_L4:
                if (!callobserver.isFinished())
                {
                    callobserver.onFailed("failed");
                }
                if (flag)
                {
                    User.saveUser(new User("", SSOUtil.getFullNameFromCustomerAttribute(((String) (obj))), false, false, null, Boolean.valueOf(false), null));
                    SSOUtil.setPreviouslySeenAmazonAccount(context, ((String) (obj)));
                    SSOUtil.addAccountCustomKeyMapping(((String) (obj)));
                    (new MShopCheckLogin(context, true, null)).checkLogin();
                    if (hashset.contains(obj))
                    {
                        obj = "sso_silent_primary";
                    } else
                    {
                        obj = "sso_silent_local";
                    }
                    obj1 = obj;
                    if (SSOUtil.isAppstoreInstalledWithSpecificVersion(context))
                    {
                        obj1 = (new StringBuilder()).append(((String) (obj))).append("_wappstore").toString();
                    }
                    RefMarkerObserver.logRefMarker(((String) (obj1)));
                    return flag;
                } else
                {
                    SSOUtil.setLoginTriggeredFromApplication(false);
                    SSOUtil.clearUserInfoOfCurrentLocale();
                    SSOUtil.setPreviouslySeenAmazonAccount(context, "");
                    return flag;
                }
_L2:
                obj1 = obj3;
                flag = flag4;
                obj2 = obj4;
                flag1 = flag5;
                s = obj5;
                flag2 = flag6;
                callobserver.onFailed("registerAccount result is null or has No directedID");
                flag = flag3;
                  goto _L4
                obj2;
                obj = ((MAPCallbackErrorException) (obj2)).getErrorBundle();
                if (((Bundle) (obj)).getInt("com.amazon.dcp.sso.ErrorCode") == com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ACCOUNT_ALREADY_EXISTS.value() && !Util.isEmpty(((Bundle) (obj)).getString("com.amazon.dcp.sso.property.account.acctId")))
                {
                    obj1 = ((Bundle) (obj)).getString("com.amazon.dcp.sso.property.account.acctId");
                    flag1 = true;
                    callobserver.onComplete();
                } else
                {
                    callobserver.onFailed(((MAPCallbackErrorException) (obj2)).getMessage());
                    flag1 = flag;
                }
                SSOUtil.setLoginTriggeredFromApplication(false);
                obj = obj1;
                flag = flag1;
                if (SSOUtil.DEBUG)
                {
                    Log.d("Amazon.SSOUtil", (new StringBuilder()).append("silentUpgradeAccount: ").append(((MAPCallbackErrorException) (obj2)).getMessage()).toString());
                    obj = obj1;
                    flag = flag1;
                }
                  goto _L4
                obj;
                SSOUtil.setLoginTriggeredFromApplication(false);
                if (SSOUtil.DEBUG)
                {
                    Log.d("Amazon.SSOUtil", (new StringBuilder()).append("silentUpgradeAccount: ").append(((InterruptedException) (obj)).getMessage()).toString());
                }
                callobserver.onFailed(((InterruptedException) (obj)).getMessage());
                obj = obj2;
                flag = flag1;
                  goto _L4
                obj;
                SSOUtil.setLoginTriggeredFromApplication(false);
                if (SSOUtil.DEBUG)
                {
                    Log.d("Amazon.SSOUtil", (new StringBuilder()).append("silentUpgradeAccount: ").append(((ExecutionException) (obj)).getMessage()).toString());
                }
                callobserver.onFailed(((ExecutionException) (obj)).getMessage());
                obj = s;
                flag = flag2;
                  goto _L4
            }

            public void handleBackgroundService(SSOBackgroundAccountService ssobackgroundaccountservice, Intent intent)
            {
                String s;
                ssobackgroundaccountservice = ssobackgroundaccountservice.getApplicationContext();
                s = intent.getAction();
                intent = intent.getStringExtra("com.amazon.dcp.sso.extra.account.directed_id");
                if (SSOUtil.DEBUG)
                {
                    Log.d("Amazon.SSOUtil", (new StringBuilder()).append("DistributedSSOServiceHandler#handleBackgroundService getAllAccounts: ").append(SSOUtil.getAllAccounts().toString()).append("actionName = ").append(s).toString());
                }
                if (!"com.amazon.dcp.sso.action.account.added".equals(s)) goto _L2; else goto _L1
_L1:
                if (!ignoreNewAddedAccount(intent)) goto _L4; else goto _L3
_L3:
                return;
_L4:
                if (SSOUtil.DEBUG)
                {
                    Log.d("Amazon.SSOUtil", (new StringBuilder()).append("Handle account registration in BackgroundService for account: ").append(intent).toString());
                }
                SSOUtil.addAccountCustomKeyMapping(intent);
                boolean flag1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("hasFetchedNonauthCookies");
                boolean flag;
                if (!Util.isEmpty(CookieBridge.getCurrentSessionId()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag && !flag1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                AccountCookiesSyncManager.syncAndWait(ssobackgroundaccountservice, false, true, intent, flag1);
                KiangController.getInstance().kiangUpdate(ssobackgroundaccountservice);
                ActivityTerminationReceiver.sendTerminationBroadcast(ssobackgroundaccountservice);
                return;
_L2:
                if ("com.amazon.dcp.sso.action.account.removed".equals(s) && !Util.isEmpty(SSOUtil.getPreviouslySeenAmazonAccount()))
                {
                    if (!SSOUtil.isLogoutTriggeredFromApplication())
                    {
                        if (SSOUtil.DEBUG)
                        {
                            Log.d("Amazon.SSOUtil", "Handle account Deregistration in BackgroundService ");
                            Log.d("Amazon.SSOUtil", (new StringBuilder()).append("current Account : ").append(SSOUtil.getCurrentAccount(ssobackgroundaccountservice)).toString());
                        }
                        SSOUtil.clearMapSSOUserDataInAllLocales(ssobackgroundaccountservice);
                        AccountCookiesSyncManager.fetchNonAuthCookies(ssobackgroundaccountservice);
                        SSOUtil.setPreviouslySeenAmazonAccount(ssobackgroundaccountservice, "");
                        KiangController.getInstance().kiangUpdate(ssobackgroundaccountservice);
                        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(ssobackgroundaccountservice. new Runnable() {

                            final _cls1 this$0;
                            final Context val$applicationContext;

                            public void run()
                            {
                                User.userSignedOut();
                                ActivityTerminationReceiver.sendTerminationBroadcast(applicationContext);
                                if (MShopPushNotificationUtils.isPushNotificationAvailable())
                                {
                                    PushNotificationManager.getInstance().enbleNotificationForAnonymousCustomer();
                                }
                            }

            
            {
                this$0 = final__pcls1;
                applicationContext = Context.this;
                super();
            }
                        });
                    }
                    SSOUtil.setLogoutTriggeredFromApplication(false);
                    return;
                }
                if (true) goto _L3; else goto _L5
_L5:
            }

            public void handleSSOInit(Context context)
            {
                Context context1;
                String s;
                String s1;
                String s2;
                context1 = context.getApplicationContext();
                CookieBridge.init(context1);
                if (SSOUtil.DEBUG)
                {
                    Log.d("Amazon.SSOUtil", "SSO.init");
                    DebugListener.init();
                }
                com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
                s = SSOUtil.getPreviouslySeenAmazonAccount();
                s1 = SSOUtil.getCurrentAccount(context);
                s2 = SSOUtil.selectMatchedAccount();
                if (SSOUtil.DEBUG)
                {
                    Log.d("Amazon.SSOUtil", (new StringBuilder()).append("previousAccount = ").append(s).append("currentAccount = ").append(s1).append(" selectedAccount = ").append(s2).toString());
                }
                if (!Util.isEmpty(s2)) goto _L2; else goto _L1
_L1:
                if (s != null) goto _L4; else goto _L3
_L3:
                if (!User.isLoggedIn()) goto _L6; else goto _L5
_L5:
                silentUpgradeAccount(context);
_L8:
                return;
_L6:
                boolean flag;
                if (!Util.isEmpty(CookieBridge.getCurrentSessionId()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    AccountCookiesSyncManager.fetchNonAuthCookies(context1);
                }
                SSOUtil.setPreviouslySeenAmazonAccount(context, "");
                return;
_L4:
                if (!"".equals(s))
                {
                    SSOUtil.clearUserInfoOfCurrentLocale();
                    AccountCookiesSyncManager.fetchNonAuthCookies(context1);
                    SSOUtil.setPreviouslySeenAmazonAccount(context, "");
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (!s2.equals(s))
                {
                    if (!Util.isEmpty(s))
                    {
                        SSOUtil.clearCurrentLocaleCookieAndCookieJar(context1);
                        SSOUtil.handleSSOAccount(context1, s2);
                        return;
                    }
                    if (User.isLoggedIn())
                    {
                        if (Util.isEmpty(s1))
                        {
                            if (!silentUpgradeAccount(context))
                            {
                                SSOUtil.handleSSOAccount(context1, s2);
                                return;
                            }
                        } else
                        {
                            SSOUtil.clearUserInfoOfCurrentLocale();
                            SSOUtil.handleSSOAccount(context1, s2);
                            return;
                        }
                    } else
                    {
                        SSOUtil.handleSSOAccount(context1, s2);
                        return;
                    }
                }
                if (true) goto _L8; else goto _L7
_L7:
            }

            public void handleSSOLogin(Activity activity)
            {
                handleSSOLogin(activity, false, false, false, null);
            }

            public void handleSSOLogin(Activity activity, boolean flag, boolean flag1, boolean flag2, String s)
            {
                Intent intent = new Intent(activity, com/amazon/mShop/sso/DistributedSSOLoginActivity);
                intent.putExtra("USER_INITIATED_LOGIN", flag);
                intent.putExtra("FORCE_SIGN_IN", flag1);
                intent.putExtra("LOGIN_ORIGIN_KEY", s);
                intent.putExtra("CREATE_NEW_ACCOUNT", flag2);
                intent.setClass(activity, com/amazon/mShop/sso/DistributedSSOLoginActivity);
                activity.startActivityForResult(intent, 0);
            }

            public void handleSSOLogin(Context context, String s, int i)
            {
                Intent intent = new Intent(context, com/amazon/mShop/sso/DistributedSSOLoginActivity);
                intent.putExtra("USER_INITIATED_LOGIN", false);
                intent.putExtra("FORCE_SIGN_IN", false);
                intent.putExtra("LOGIN_ORIGIN_KEY", s);
                intent.setFlags(i);
                intent.setClass(context, com/amazon/mShop/sso/DistributedSSOLoginActivity);
                context.startActivity(intent);
            }

            public void handleSSOLogout(AmazonActivity amazonactivity)
            {
                amazonactivity.startActivity(new Intent(amazonactivity, com/amazon/mShop/sso/DistributedSSOLogoutActivity));
            }

        };
        CENTRAL_SSO_TYPE = new IdentityType("CENTRAL_SSO_TYPE", 1) {

            private boolean ignoreNewAddedAccount(String s)
            {
                if (SSOUtil.isLoginTriggeredFromApplication())
                {
                    SSOUtil.setLoginTriggeredFromApplication(false);
                } else
                {
                    String s2 = SSOUtil.getAuthPoolForCurrentLocale();
                    String s1 = SSOUtil.getAuthPoolFromAccount(s);
                    s = s1;
                    if (Util.isEmpty(s1))
                    {
                        s = "Amazon";
                    }
                    if (s2.equals(s))
                    {
                        return false;
                    }
                }
                return true;
            }

            public void handleBackgroundService(SSOBackgroundAccountService ssobackgroundaccountservice, Intent intent)
            {
                ssobackgroundaccountservice = ssobackgroundaccountservice.getApplicationContext();
                String s = intent.getAction();
                intent = intent.getStringExtra("com.amazon.dcp.sso.extra.account.directed_id");
                if (SSOUtil.DEBUG)
                {
                    Log.d("Amazon.SSOUtil", (new StringBuilder()).append("changedAccount = ").append(intent).toString());
                }
                if ("com.amazon.dcp.sso.action.account.removed".equals(s))
                {
                    if (!Util.isEmpty(SSOUtil.getPreviouslySeenAmazonAccount()))
                    {
                        if (!SSOUtil.isLogoutTriggeredFromApplication())
                        {
                            SSOUtil.clearMShopUserDataInWorldwideAuthPool(ssobackgroundaccountservice);
                            AccountCookiesSyncManager.fetchNonAuthCookies(ssobackgroundaccountservice);
                            SSOUtil.setPreviouslySeenAmazonAccount(ssobackgroundaccountservice, "");
                            KiangController.getInstance().kiangUpdate(ssobackgroundaccountservice);
                            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(ssobackgroundaccountservice. new Runnable() {

                                final _cls2 this$0;
                                final Context val$applicationContext;

                                public void run()
                                {
                                    User.userSignedOut();
                                    ActivityTerminationReceiver.sendTerminationBroadcast(applicationContext);
                                }

            
            {
                this$0 = final__pcls2;
                applicationContext = Context.this;
                super();
            }
                            });
                            if (MShopPushNotificationUtils.isPushNotificationAvailable())
                            {
                                PushNotificationManager.getInstance().enbleNotificationForAnonymousCustomer();
                            }
                        }
                        SSOUtil.setLogoutTriggeredFromApplication(false);
                        SSOUtil.removePreviousAccountInWorldwideAuthPool();
                    }
                } else
                if ("com.amazon.dcp.sso.action.account.added".equals(s) && !ignoreNewAddedAccount(intent))
                {
                    if (SSOUtil.DEBUG)
                    {
                        Log.d("Amazon.SSOUtil", "Handle account registration in BackgroundService ");
                    }
                    AccountCookiesSyncManager.syncAndWait(ssobackgroundaccountservice, false, true, intent);
                    KiangController.getInstance().kiangUpdate(ssobackgroundaccountservice);
                    HomeServiceCallWrapper.startHomeCall(ssobackgroundaccountservice);
                    ActivityTerminationReceiver.sendTerminationBroadcast(ssobackgroundaccountservice);
                    return;
                }
            }

            public void handleSSOInit(Context context)
            {
                Context context1;
                DataStore datastore;
                String s;
                String s1;
                context1 = context.getApplicationContext();
                CookieBridge.init(context1);
                if (SSOUtil.DEBUG)
                {
                    Log.d("Amazon.SSOUtil", "SSO.init");
                    DebugListener.init();
                }
                datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
                s = SSOUtil.getPreviouslySeenAmazonAccount();
                s1 = SSOUtil.selectMatchedAccount();
                if (!Util.isEmpty(s1)) goto _L2; else goto _L1
_L1:
                if (s != null) goto _L4; else goto _L3
_L3:
                SSOUtil.clearMShopUserDataInWorldwideAuthPool(context1);
                AccountCookiesSyncManager.fetchNonAuthCookies(context1);
                SSOUtil.setPreviouslySeenAmazonAccount(context, "");
_L6:
                return;
_L4:
                if (!"".equals(s))
                {
                    SSOUtil.clearMShopUserDataInWorldwideAuthPool(context1);
                    AccountCookiesSyncManager.fetchNonAuthCookies(context1);
                    SSOUtil.setPreviouslySeenAmazonAccount(context, "");
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (!s1.equals(s))
                {
                    SSOUtil.clearMShopUserDataInWorldwideAuthPool(context1);
                    AccountCookiesSyncManager.syncAndWait(context1, true, true, s1);
                    return;
                }
                if (!datastore.getBoolean("ignoreOptOutFirstLaunch", SSOUtil.getAuthPoolForCurrentLocale()))
                {
                    AccountCookiesSyncManager.syncAndWait(context1, false, true, s1);
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public void handleSSOLogin(Activity activity)
            {
                handleSSOLogin(activity, false, false, false, null);
            }

            public void handleSSOLogin(Activity activity, boolean flag, boolean flag1, boolean flag2, String s)
            {
                Intent intent = new Intent(activity, com/amazon/mShop/sso/CentralSSOLoginActivity);
                intent.putExtra("USER_INITIATED_LOGIN", flag);
                intent.putExtra("FORCE_SIGN_IN", flag1);
                intent.putExtra("LOGIN_ORIGIN_KEY", s);
                intent.putExtra("CREATE_NEW_ACCOUNT", flag2);
                intent.setClass(activity, com/amazon/mShop/sso/CentralSSOLoginActivity);
                activity.startActivityForResult(intent, 0);
            }

            public void handleSSOLogin(Context context, String s, int i)
            {
                Intent intent = new Intent(context, com/amazon/mShop/sso/CentralSSOLoginActivity);
                intent.putExtra("USER_INITIATED_LOGIN", false);
                intent.putExtra("FORCE_SIGN_IN", false);
                intent.putExtra("LOGIN_ORIGIN_KEY", s);
                intent.setFlags(i);
                intent.setClass(context, com/amazon/mShop/sso/CentralSSOLoginActivity);
                context.startActivity(intent);
            }

            public void handleSSOLogout(AmazonActivity amazonactivity)
            {
                amazonactivity.startActivity(new Intent(amazonactivity, com/amazon/mShop/sso/CentralSSOLogoutActivity));
            }

        };
        NON_SSO_TYPE = new IdentityType("NON_SSO_TYPE", 2) {

            public void handleBackgroundService(SSOBackgroundAccountService ssobackgroundaccountservice, Intent intent)
            {
                boolean flag = intent.getAction().equals("com.amazon.dcp.sso.action.account.removed");
                ssobackgroundaccountservice = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
                if (flag && SSOUtil.hasAmazonAuthenticator(ssobackgroundaccountservice))
                {
                    SSOUtil.clearMShopUserDataInWorldwideAuthPool(ssobackgroundaccountservice);
                }
            }

            public void handleSSOInit(Context context)
            {
                if (!Util.isEmpty(SSOUtil.getPreviouslySeenAmazonAccount()))
                {
                    SSOUtil.clearMShopUserDataInWorldwideAuthPool(context.getApplicationContext());
                    User.userSignedOut();
                }
            }

            public void handleSSOLogin(Activity activity)
            {
            }

            public void handleSSOLogin(Activity activity, boolean flag, boolean flag1, boolean flag2, String s)
            {
            }

            public void handleSSOLogin(Context context, String s, int i)
            {
            }

            public void handleSSOLogout(AmazonActivity amazonactivity)
            {
            }

        };
        $VALUES = (new IdentityType[] {
            DISTRIBUTED_SSO_TYPE, CENTRAL_SSO_TYPE, NON_SSO_TYPE
        });
    }
}
