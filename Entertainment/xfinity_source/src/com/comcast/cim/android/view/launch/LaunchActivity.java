// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import com.comcast.cim.android.application.AppUpgradeHelper;
import com.comcast.cim.android.view.common.BaseActivity;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.container.CALContainer;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            LaunchIntentInterceptor, LaunchStrategy

public class LaunchActivity extends BaseActivity
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/launch/LaunchActivity);
    private AppUpgradeHelper appUpgradeHelper;
    private LaunchIntentInterceptor intentInterceptor;
    private LaunchStrategy launchStrategy;
    private boolean shouldFinishIfResumed;

    public LaunchActivity()
    {
        launchStrategy = CALContainer.getInstance().getLaunchStrategy();
        intentInterceptor = CALContainer.getInstance().getLaunchIntentInterceptor();
        appUpgradeHelper = CALContainer.getInstance().getAppUpgradeHelper();
        shouldFinishIfResumed = false;
    }

    public final void finish()
    {
        shouldFinishIfResumed = false;
        if (getIntent() != null && getIntent().hasExtra("exit"))
        {
            getIntent().removeExtra("exit");
        }
        super.finish();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 1 && j == 0)
        {
            LOG.debug("Initialization got cancelled");
            shouldFinishIfResumed = true;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        LOG.debug("onCreate");
        if (bundle != null)
        {
            shouldFinishIfResumed = bundle.getBoolean("shouldFinishIfResumed", false);
        }
        try
        {
            appUpgradeHelper.onLaunch();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle = new AlertDialog(this) {

                final LaunchActivity this$0;

                public boolean onSearchRequested()
                {
                    return false;
                }

            
            {
                this$0 = LaunchActivity.this;
                super(context);
            }
            };
        }
        bundle.setMessage(getResources().getString(com.comcast.cim.android.R.string.failed_upgrade));
        bundle.setButton(-3, "Exit", new android.content.DialogInterface.OnClickListener() {

            final LaunchActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                finish();
            }

            
            {
                this$0 = LaunchActivity.this;
                super();
            }
        });
        bundle.setCancelable(false);
        bundle.setCanceledOnTouchOutside(false);
        bundle.show();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        LOG.debug("onNewIntent");
        setIntent(intent);
        shouldFinishIfResumed = intent.getBooleanExtra("exit", false);
    }

    protected void onResume()
    {
        super.onResume();
        LOG.debug("onResume");
        if (!shouldFinishIfResumed) goto _L2; else goto _L1
_L1:
        finish();
_L4:
        return;
_L2:
        Object obj;
        Bundle bundle;
        Intent intent;
        bundle = new Bundle();
        intent = getIntent();
        if (intent != null && intent.getExtras() != null)
        {
            bundle.putAll(intent.getExtras());
        }
        if (bundle.containsKey("exit"))
        {
            finish();
            return;
        }
        Object obj2 = null;
        obj = null;
        if (intentInterceptor == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        obj = obj2;
        List list = intentInterceptor.intercept(intent);
        obj = list;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        obj = list;
        bundle.putParcelableArray("flowStates", (android.os.Parcelable[])list.toArray(new Intent[list.size()]));
        obj = list;
_L5:
        shouldFinishIfResumed = true;
        Exception exception = null;
        if (obj != null && ((List) (obj)).size() > 0)
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                startActivity((Intent)((Iterator) (obj)).next());
            }
        } else
        {
            Object obj1 = exception;
            if (isTaskRoot())
            {
                obj1 = new Intent(this, launchStrategy.getDefaultActivityClass());
            }
            if (obj1 != null)
            {
                ((Intent) (obj1)).putExtras(bundle);
                startActivityForResult(((Intent) (obj1)), 0);
                return;
            }
            finish();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        exception;
        LOG.error("failed during intercept", exception);
        Toast.makeText(this, getString(com.comcast.cim.android.R.string.dlg_dive_error), 1).show();
          goto _L5
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("shouldFinishIfResumed", shouldFinishIfResumed);
    }

}
