// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.application.AppUpgradeHelper;
import com.comcast.cim.android.authentication.AuthenticationStrategy;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.exception.CimUpgradeException;
import com.comcast.cim.model.user.UserManager;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            AuthenticationLauncher, LaunchStrategy

public class AuthenticatingActivityDelegate
    implements AuthenticationLauncher
{
    public static interface InternalLifecycleRunner
    {

        public abstract void onResumeInternal();

        public abstract void onStartInternal();
    }


    private final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/launch/AuthenticatingActivityDelegate);
    private final Activity activity;
    private AlertDialog alertDialog;
    private final AppUpgradeHelper appUpgradeHelper;
    private final AuthenticationStrategy authStrategy;
    private final InternalLifecycleRunner internalLifecycleRunner;
    private final LaunchStrategy launchStrategy;
    private boolean launchingAuthentication;
    private final Task minVersionCheckCache;
    private TaskExecutionListener minVersionCheckListener;
    private TaskExecutor minVersionCheckTaskExecutor;
    private final TaskExecutorFactory taskExecutorFactory;
    private final Executor uiThreadExecutor;
    private final UserManager userManager;
    private final int versionCode;

    public AuthenticatingActivityDelegate(Activity activity1, InternalLifecycleRunner internallifecyclerunner, UserManager usermanager, LaunchStrategy launchstrategy, AuthenticationStrategy authenticationstrategy, AppUpgradeHelper appupgradehelper, Executor executor, 
            Task task, TaskExecutorFactory taskexecutorfactory, int i)
    {
        activity = activity1;
        internalLifecycleRunner = internallifecyclerunner;
        userManager = usermanager;
        launchStrategy = launchstrategy;
        authStrategy = authenticationstrategy;
        appUpgradeHelper = appupgradehelper;
        uiThreadExecutor = executor;
        minVersionCheckCache = task;
        taskExecutorFactory = taskexecutorfactory;
        versionCode = i;
    }

    private void startActivityForResultWithNoAnimation(Class class1, int i)
    {
        class1 = new Intent(activity, class1);
        class1.addFlags(0x10000);
        activity.startActivityForResult(class1, i);
    }

    public void checkForUserUpgrade()
    {
        try
        {
            appUpgradeHelper.onUserLoadedOrSignedIn();
            internalLifecycleRunner.onResumeInternal();
            return;
        }
        catch (CimUpgradeException cimupgradeexception)
        {
            alertDialog = new AlertDialog(activity) {

                final AuthenticatingActivityDelegate this$0;

                public boolean onSearchRequested()
                {
                    return false;
                }

            
            {
                this$0 = AuthenticatingActivityDelegate.this;
                super(context);
            }
            };
        }
        alertDialog.setMessage(activity.getResources().getString(com.comcast.cim.android.R.string.failed_upgrade));
        alertDialog.setButton(-3, "Exit", new android.content.DialogInterface.OnClickListener() {

            final AuthenticatingActivityDelegate this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                activity.finish();
            }

            
            {
                this$0 = AuthenticatingActivityDelegate.this;
                super();
            }
        });
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    public void doMinVersionCheck()
    {
        minVersionCheckTaskExecutor = taskExecutorFactory.create(minVersionCheckCache);
        minVersionCheckListener = new DefaultTaskExecutionListener() {

            final AuthenticatingActivityDelegate this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
            }

            public void onPostExecute(Integer integer)
            {
                LOG.debug((new StringBuilder()).append("Min Version Check: Current App Version is ").append(versionCode).append(", Server Minimum Version is ").append(integer).toString());
                if (integer.intValue() > versionCode)
                {
                    integer = new Bundle();
                    CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("messageDlg");
                    integer.putString("description", activity.getResources().getString(com.comcast.cim.android.R.string.version_too_low_desc));
                    integer.putString("title", activity.getResources().getString(com.comcast.cim.android.R.string.version_too_low_title));
                    caldialogfragment.addArguments(integer);
                    caldialogfragment.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

                        final _cls3 this$1;

                        public void onDismiss(DialogInterface dialoginterface)
                        {
                            launchStrategy.exitApp(activity);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                    caldialogfragment.show(activity.getFragmentManager(), "caldialogfragment");
                }
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((Integer)obj);
            }

            
            {
                this$0 = AuthenticatingActivityDelegate.this;
                super();
            }
        };
        minVersionCheckTaskExecutor.execute(minVersionCheckListener);
    }

    public boolean isAuthenticated()
    {
        return authStrategy.isAuthenticated();
    }

    public void launchAuthentication()
    {
        startActivityForResultWithNoAnimation(authStrategy.getAuthenticationActivityClass(), 2929);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 3939 || i == 2929)
        {
            if (j == 0)
            {
                LOG.debug("User cancelled, close shop");
                launchStrategy.exitApp(activity);
                return;
            }
            if (i == 2929)
            {
                switch (j)
                {
                default:
                    return;

                case 2: // '\002'
                    launchStrategy.restartAppFlow(activity);
                    break;
                }
                return;
            }
        }
    }

    public void onPause()
    {
        userManager.saveUserAsync();
        if (alertDialog != null)
        {
            alertDialog.dismiss();
            alertDialog = null;
        }
        if (minVersionCheckTaskExecutor != null)
        {
            minVersionCheckTaskExecutor.cancelNotificationsFor(minVersionCheckListener);
        }
    }

    public void onResume()
    {
        LOG.debug("onResume: Check the minimum version and whether we need to update the user or have them sign-in");
        doMinVersionCheck();
        if (launchingAuthentication)
        {
            launchingAuthentication = false;
            return;
        }
        if (!activity.isFinishing() && !isAuthenticated())
        {
            launchAuthentication();
            return;
        } else
        {
            uiThreadExecutor.execute(new Runnable() {

                final AuthenticatingActivityDelegate this$0;

                public void run()
                {
                    checkForUserUpgrade();
                }

            
            {
                this$0 = AuthenticatingActivityDelegate.this;
                super();
            }
            });
            LOG.debug("onResume: We are finishing or not authenticated, call through to onResumeInternal");
            return;
        }
    }

    public void onStart()
    {
        LOG.debug("onStart: Check to see if we need to update the user or have them authenticate");
        if (!activity.isFinishing() && !isAuthenticated())
        {
            launchingAuthentication = true;
            launchAuthentication();
            return;
        } else
        {
            internalLifecycleRunner.onStartInternal();
            return;
        }
    }




}
