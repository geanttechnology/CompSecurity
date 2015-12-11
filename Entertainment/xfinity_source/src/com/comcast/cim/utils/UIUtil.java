// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import org.apache.commons.lang3.Validate;

public class UIUtil
{

    private static final String TAG = com/comcast/cim/utils/UIUtil.getSimpleName();
    private final InternetConnection internetConnection;

    public UIUtil(InternetConnection internetconnection)
    {
        internetConnection = internetconnection;
    }

    public void ensureConnectivityBeforeExecuting(final Context context, final Runnable runnable)
    {
        Validate.notNull(context);
        Validate.notNull(runnable);
        if (!internetConnection.isConnected())
        {
            Bundle bundle = new Bundle();
            bundle.putString("description", context.getResources().getString(com.comcast.cim.android.R.string.ALERT_INTERNET_UNREACHABLE));
            CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("errorDlgRetryable");
            caldialogfragment.setTryAgainListener(new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

                final UIUtil this$0;
                final Context val$context;
                final Runnable val$runnable;

                public void tryAgain()
                {
                    ensureConnectivityBeforeExecuting(context, runnable);
                }

            
            {
                this$0 = UIUtil.this;
                context = context1;
                runnable = runnable1;
                super();
            }
            });
            caldialogfragment.addArguments(bundle);
            caldialogfragment.show(((Activity)context).getFragmentManager(), "caldialogfragment");
            return;
        } else
        {
            runnable.run();
            return;
        }
    }

    public void tryToShowDialog(Runnable runnable)
    {
        try
        {
            runnable.run();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            return;
        }
    }

}
