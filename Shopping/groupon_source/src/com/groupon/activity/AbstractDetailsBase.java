// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.DialogInterface;
import android.widget.ImageView;
import com.groupon.Channel;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CountryUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.LoaderCallbacksUtil;
import com.groupon.util.LoggingUtils;
import com.squareup.picasso.Callback;
import commonlib.manager.SyncManager;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity, IntentFactory

public abstract class AbstractDetailsBase extends GrouponFragmentActivity
    implements GrouponDialogListener, Callback, commonlib.manager.SyncManager.SyncUiCallbacks
{

    protected static final int DETAIL_LOADER_ID = 0;
    protected static final String HTTP_DEEPLINK_ERROR_DIALOG = "http_deeplink_error_dialog";
    protected static final int SCREEN_HEIGHT_CUTOFF = 450;
    protected static final int SCREEN_HEIGHT_OVER_IMAGE_HEIGHT_RATIO = 3;
    Channel channel;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    protected DialogManager dialogManager;
    protected IntentFactory intentFactory;
    private boolean isOnPause;
    protected LoggingUtils loggingUtils;
    protected LoginService loginService;

    public AbstractDetailsBase()
    {
        isOnPause = false;
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
    }

    public abstract android.app.LoaderManager.LoaderCallbacks getLoaderCallBack();

    public abstract SyncManager getSyncManager();

    protected void handleDeepLinkError()
    {
        GrouponDialogFragment groupondialogfragment = dialogManager.getDialogFragment(Integer.valueOf(0x7f080165));
        groupondialogfragment.setCancelable(false);
        GrouponDialogFragment.show(getFragmentManager(), groupondialogfragment, "http_deeplink_error_dialog");
    }

    public void handleException(Exception exception)
    {
        exception = dialogManager.getDialogFragment(Integer.valueOf(0x7f080165));
        exception.setCancelable(false);
        GrouponDialogFragment.show(getFragmentManager(), exception, "http_error_dialog");
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        LoaderCallbacksUtil.handleSyncError(runnable, exception, this, loginService, countryUtil, currentCountryManager.getCurrentCountry(), getSyncManager(), intentFactory, new Function2() {

            final AbstractDetailsBase this$0;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((Runnable)obj, (Exception)obj1);
            }

            public void execute(Runnable runnable1, Exception exception1)
            {
                if (isOnPause)
                {
                    return;
                }
                if (isDeepLinked)
                {
                    handleDeepLinkError();
                    return;
                } else
                {
                    handleException(exception1);
                    return;
                }
            }

            
            {
                this$0 = AbstractDetailsBase.this;
                super();
            }
        });
    }

    protected boolean hasCartIcon()
    {
        return true;
    }

    protected void initLoaderManager()
    {
        getLoaderManager().initLoader(0, null, getLoaderCallBack());
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        finish();
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    public void onError(ImageView imageview)
    {
    }

    protected void onPause()
    {
        super.onPause();
        isOnPause = true;
        if (getSyncManager() != null)
        {
            getSyncManager().stopAutomaticSyncs();
        }
    }

    protected void onResume()
    {
        super.onResume();
        isOnPause = false;
        if (shouldStartAutomaticSyncsOnResume())
        {
            startAutomaticSyncs();
        }
    }

    public void onSuccess(ImageView imageview)
    {
    }

    protected boolean shouldStartAutomaticSyncsOnResume()
    {
        return true;
    }

    protected void startAutomaticSyncs()
    {
        SyncManager syncmanager = getSyncManager();
        if (syncmanager != null)
        {
            syncmanager.startAutomaticSyncs(this, null);
        }
    }

}
