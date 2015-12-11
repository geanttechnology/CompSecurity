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

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil, AccountCookiesSyncManager

public class CentralSSOLogoutActivity extends AmazonActivity
{

    private AmazonAlertDialog mLogoutMessageDialog;
    private ProgressDialog mProgressDialog;

    public CentralSSOLogoutActivity()
    {
    }

    private void createSignOutDialog()
    {
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final CentralSSOLogoutActivity this$0;

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
                this$0 = CentralSSOLogoutActivity.this;
                super();
            }
        };
        String s = SSOUtil.peekCustomerAttribute(getApplicationContext(), "com.amazon.dcp.sso.property.username");
        if (AppUtils.isAppInstalled(this, getString(com.amazon.mShop.android.lib.R.string.amazon_appstore_package_name)))
        {
            s = getString(com.amazon.mShop.android.lib.R.string.sign_out_confirm_message_with_appstore_installed, new Object[] {
                s
            });
        } else
        {
            s = getString(com.amazon.mShop.android.lib.R.string.sign_out_confirm_message, new Object[] {
                s
            });
        }
        mLogoutMessageDialog = (new com.amazon.mShop.AmazonAlertDialog.Builder(this)).setTitle(getString(com.amazon.mShop.android.lib.R.string.sign_out_confirm_title)).setMessage(s).setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_cancel_button, onclicklistener).setNegativeButton(com.amazon.mShop.android.lib.R.string.sign_out_button, onclicklistener).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final CentralSSOLogoutActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                dialoginterface.dismiss();
                finish();
            }

            
            {
                this$0 = CentralSSOLogoutActivity.this;
                super();
            }
        }).create();
        mLogoutMessageDialog.show();
    }

    private void logout()
    {
        String s = SSOUtil.getCurrentAccount(getApplicationContext());
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(getString(com.amazon.mShop.android.lib.R.string.signout_progress_message));
        mProgressDialog.setProgressStyle(0);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
        MAPAccountManager mapaccountmanager = SSOUtil.getMAPAccountManager(getApplicationContext());
        if (!Util.isEmpty(s))
        {
            SSOUtil.setLogoutTriggeredFromApplication(true);
            mapaccountmanager.deregisterAccount(s, new Callback() {

                final CentralSSOLogoutActivity this$0;
                final CallObserver val$callObserver;

                public void onError(Bundle bundle)
                {
                    CallObserver callobserver = callObserver;
                    if (bundle != null)
                    {
                        bundle = bundle.toString();
                    } else
                    {
                        bundle = null;
                    }
                    callobserver.onFailed(bundle);
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
                    callObserver.onComplete();
                    SSOUtil.clearMShopUserDataInWorldwideAuthPool(getApplicationContext());
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
                }

            
            {
                this$0 = CentralSSOLogoutActivity.this;
                callObserver = callobserver;
                super();
            }
            });
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        createSignOutDialog();
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
