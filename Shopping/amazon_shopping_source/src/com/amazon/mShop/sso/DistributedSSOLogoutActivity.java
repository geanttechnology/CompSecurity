// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.kiang.KiangController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.CallObserver;
import com.amazon.mShop.net.ServiceCallIdentifier;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil, AccountCookiesSyncManager

public class DistributedSSOLogoutActivity extends AmazonActivity
    implements SSOUtil.FetchUserFullNameListener
{

    private AmazonAlertDialog mLogoutMessageDialog;
    private ProgressDialog mProgressDialog;

    public DistributedSSOLogoutActivity()
    {
    }

    private void createSignOutDialog(String s)
    {
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final DistributedSSOLogoutActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                switch (i)
                {
                default:
                    return;

                case -2: 
                    dialoginterface.dismiss();
                    logout();
                    return;

                case -1: 
                    dialoginterface.dismiss();
                    break;
                }
                finish();
            }

            
            {
                this$0 = DistributedSSOLogoutActivity.this;
                super();
            }
        };
        String s1 = null;
        String s2 = SSOUtil.getCurrentAccount(getApplicationContext());
        if (s2 != null)
        {
            if (s2.equals(SSOUtil.getMAPAccountManager(getApplicationContext()).getPrimaryAccount()))
            {
                if (AppUtils.isAppInstalled(this, getString(com.amazon.mShop.android.lib.R.string.amazon_appstore_package_name)))
                {
                    s1 = getString(com.amazon.mShop.android.lib.R.string.sign_out_confirm_message_with_appstore_installed, new Object[] {
                        s
                    });
                } else
                {
                    s1 = getString(com.amazon.mShop.android.lib.R.string.sign_out_confirm_message, new Object[] {
                        s
                    });
                }
            } else
            {
                s1 = getString(com.amazon.mShop.android.lib.R.string.sign_out_your_app_confirm_message, new Object[] {
                    s
                });
            }
        }
        mLogoutMessageDialog = (new com.amazon.mShop.AmazonAlertDialog.Builder(this)).setTitle(getString(com.amazon.mShop.android.lib.R.string.sign_out_confirm_title)).setMessage(s1).setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_cancel_button, onclicklistener).setNegativeButton(com.amazon.mShop.android.lib.R.string.sign_out_button, onclicklistener).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final DistributedSSOLogoutActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                dialoginterface.dismiss();
                finish();
            }

            
            {
                this$0 = DistributedSSOLogoutActivity.this;
                super();
            }
        }).create();
        mLogoutMessageDialog.show();
    }

    private ProgressDialog getProgressDialog()
    {
        if (mProgressDialog == null)
        {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setProgressStyle(0);
            mProgressDialog.setIndeterminate(true);
        }
        return mProgressDialog;
    }

    private void logout()
    {
        SSOUtil.setLogoutTriggeredFromApplication(true);
        String s = SSOUtil.getCurrentAccount(getApplicationContext());
        getProgressDialog().setMessage(getString(com.amazon.mShop.android.lib.R.string.signout_progress_message));
        getProgressDialog().show();
        MAPAccountManager mapaccountmanager = SSOUtil.getMAPAccountManager(getApplicationContext());
        if (!Util.isEmpty(s))
        {
            boolean flag = s.equals(mapaccountmanager.getPrimaryAccount());
            mapaccountmanager.deregisterAccount(s, new Callback() {

                final DistributedSSOLogoutActivity this$0;
                final CallObserver val$deregisterDeviceCall;
                final CallObserver val$deregisterDeviceTotal;
                final boolean val$isPrimaryAccount;

                public void onError(Bundle bundle)
                {
                    Object obj = null;
                    CallObserver callobserver = deregisterDeviceCall;
                    String s1;
                    if (bundle != null)
                    {
                        s1 = bundle.toString();
                    } else
                    {
                        s1 = null;
                    }
                    callobserver.onFailed(s1);
                    callobserver = deregisterDeviceTotal;
                    s1 = obj;
                    if (bundle != null)
                    {
                        s1 = bundle.toString();
                    }
                    callobserver.onFailed(s1);
                    SSOUtil.setLogoutTriggeredFromApplication(false);
                    runOnUiThread(new Runnable() {

                        final _cls3 this$1;

                        public void run()
                        {
                            setResult(0);
                            if (mProgressDialog != null)
                            {
                                mProgressDialog.dismiss();
                            }
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                }

                public void onSuccess(Bundle bundle)
                {
                    deregisterDeviceCall.onComplete();
                    SSOUtil.clearMapSSOUserDataInAllLocales(getApplicationContext());
                    if (!isPrimaryAccount)
                    {
                        bundle = SSOUtil.getAuthPoolForCurrentLocale();
                        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("ignoreOptOutFirstLaunch", false, bundle);
                    }
                    AccountCookiesSyncManager.fetchNonAuthCookies(getApplicationContext());
                    AppUtils.clearUserCoinBalance();
                    KiangController.getInstance().kiangUpdate(getApplicationContext());
                    com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                        final _cls3 this$1;

                        public void run()
                        {
                            User.userSignedOut();
                            setResult(-1);
                            AppUtils.restartApp();
                            if (MShopPushNotificationUtils.isPushNotificationAvailable())
                            {
                                PushNotificationManager.getInstance().enbleNotificationForAnonymousCustomer();
                            }
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                    deregisterDeviceTotal.onComplete();
                }

            
            {
                this$0 = DistributedSSOLogoutActivity.this;
                deregisterDeviceCall = callobserver;
                isPrimaryAccount = flag;
                deregisterDeviceTotal = callobserver1;
                super();
            }
            });
        }
    }

    public void afterFullnameFetched(String s)
    {
        getProgressDialog().dismiss();
        createSignOutDialog(s);
    }

    public void beforeFetchingFullname()
    {
        getProgressDialog().setMessage(getString(com.amazon.mShop.android.lib.R.string.loading));
        getProgressDialog().show();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        (new SSOUtil.FetchUserFullNameTask(this)).execute(new Void[0]);
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (mProgressDialog != null && mProgressDialog.isShowing())
        {
            mProgressDialog.dismiss();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return false;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return false;
    }

    public boolean onSearchRequested()
    {
        return false;
    }


}
