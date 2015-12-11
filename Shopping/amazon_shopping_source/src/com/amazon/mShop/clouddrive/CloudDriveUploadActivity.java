// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.clouddrive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.error.AmazonErrorBox;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.UIUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CloudDriveUploadActivity extends AmazonActivity
{

    private View mUploadView;

    public CloudDriveUploadActivity()
    {
    }

    private void initActivity()
    {
        if (!NetInfo.hasNetworkConnection())
        {
            showNetworkErrorView();
        } else
        {
            Runnable runnable = null;
            if (!SSOUtil.hasAmazonAccount())
            {
                runnable = new Runnable() {

                    final CloudDriveUploadActivity this$0;

                    public void run()
                    {
                        SSOUtil.getCurrentIdentityType().handleSSOLogin(CloudDriveUploadActivity.this);
                    }

            
            {
                this$0 = CloudDriveUploadActivity.this;
                super();
            }
                };
            }
            try
            {
                mUploadView = (View)Class.forName("com.amazon.clouddrive.library.display.CloudDriveUploadView", true, SecondDexEntry.getInstance().getClassLoader()).getConstructor(new Class[] {
                    android/support/v4/app/FragmentActivity, java/lang/Runnable
                }).newInstance(new Object[] {
                    this, runnable
                });
                setRootView(mUploadView);
                return;
            }
            catch (Exception exception)
            {
                if (DebugSettings.isDebugEnabled())
                {
                    Log.e("CloudDriveUploadActivity", "Exception occurred using reflection to construct CloudDriveUploadView", exception);
                    return;
                }
            }
        }
    }

    private void showNetworkErrorView()
    {
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            final CloudDriveUploadActivity this$0;

            public void onClick(View view)
            {
                initActivity();
            }

            
            {
                this$0 = CloudDriveUploadActivity.this;
                super();
            }
        };
        String s = UIUtils.formatErrorMessage(getString(com.amazon.mShop.android.lib.R.string.error_network_no_connection_message), 1);
        AmazonErrorBox amazonerrorbox = new AmazonErrorBox(this);
        amazonerrorbox.setMessage(s);
        amazonerrorbox.setButtonOnClick(1, onclicklistener);
        setRootView(amazonerrorbox);
    }

    public ClassLoader getClassLoader()
    {
        return SecondDexEntry.getInstance().getClassLoader();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        intent = Class.forName("com.amazon.clouddrive.library.display.CloudDriveUploadView", true, SecondDexEntry.getInstance().getClassLoader());
        if (SSOUtil.hasAmazonAccount())
        {
            intent.getDeclaredMethod("onSignInSuccess", (Class[])null).invoke(mUploadView, (Object[])null);
            return;
        }
        try
        {
            intent.getDeclaredMethod("onSignInFailure", (Class[])null).invoke(mUploadView, (Object[])null);
            finish();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent) { }
        if (DebugSettings.isDebugEnabled())
        {
            Log.e("CloudDriveUploadActivity", "Exception occurred using reflection to invoke CloudDriveUploadView.onSignInSuccess/Failure", intent);
        }
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initActivity();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        initActivity();
    }

}
