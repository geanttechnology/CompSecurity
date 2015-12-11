// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.AttributeSet;
import android.view.View;
import com.comcast.cim.android.authentication.AuthenticationStrategy;
import com.comcast.cim.android.view.common.OrientationStrategy;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.model.user.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            LaunchStrategy

public abstract class AuthenticatingPreferenceActivity extends PreferenceActivity
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity);
    private AuthenticationStrategy authStrategy;
    private android.view.LayoutInflater.Factory customLayoutInflaterFactory;
    private LaunchStrategy launchStrategy;
    private Task minVersionCheckCache;
    private TaskExecutionListener minVersionCheckListener;
    private TaskExecutor minVersionCheckProvider;
    private OrientationStrategy orientationStrategy;
    private TaskExecutorFactory taskExecutorFactory;
    private int versionCode;

    public AuthenticatingPreferenceActivity()
    {
        launchStrategy = CALContainer.getInstance().getLaunchStrategy();
        authStrategy = CALContainer.getInstance().getAuthenticationStrategy();
        orientationStrategy = CALContainer.getInstance().getDefaultOrientationStrategy();
        customLayoutInflaterFactory = CALContainer.getInstance().getLayoutInflatorFactory();
        minVersionCheckCache = CALContainer.getInstance().getGracefullyDegradingMinVersionCheckCache();
        taskExecutorFactory = CALContainer.getInstance().getTaskExecutorFactory();
        versionCode = CALContainer.getInstance().getVersionCode().intValue();
    }

    private OrientationStrategy getOrientationStrategy()
    {
        return orientationStrategy;
    }

    private void startActivityForResultWithNoAnimation(Class class1, int i)
    {
        class1 = new Intent(this, class1);
        class1.addFlags(0x10000);
        startActivityForResult(class1, i);
    }

    public abstract UserManager getUserManager();

    protected boolean isAuthenticated()
    {
        return authStrategy.isAuthenticated();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 3939 || i == 2929)
        {
            if (j == 0)
            {
                LOG.debug("User cancelled, close shop");
                launchStrategy.exitApp(this);
                return;
            }
            if (i == 2929)
            {
                switch (j)
                {
                default:
                    return;

                case 2: // '\002'
                    launchStrategy.restartAppFlow(this);
                    break;
                }
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRequestedOrientation(getOrientationStrategy().getAppropriateOrientation());
        bundle = getActionBar();
        if (bundle != null)
        {
            bundle.setHomeButtonEnabled(true);
        }
    }

    public View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        View view = customLayoutInflaterFactory.onCreateView(s, context, attributeset);
        if (view != null)
        {
            return view;
        } else
        {
            return super.onCreateView(s, context, attributeset);
        }
    }

    protected void onPause()
    {
        super.onPause();
        getUserManager().saveUserAsync();
        if (minVersionCheckProvider != null)
        {
            minVersionCheckProvider.cancelNotificationsFor(minVersionCheckListener);
        }
    }

    public final void onResume()
    {
        super.onResume();
        LOG.debug("onResume");
        LOG.debug("Check to see if we need to update the user or have them sign-in");
        if (!isFinishing() && !isAuthenticated())
        {
            startActivityForResultWithNoAnimation(authStrategy.getAuthenticationActivityClass(), 2929);
            return;
        } else
        {
            onResumeInternal();
            minVersionCheckProvider = taskExecutorFactory.create(minVersionCheckCache);
            minVersionCheckListener = new DefaultTaskExecutionListener() {

                final AuthenticatingPreferenceActivity this$0;

                public void onError(TaskExecutionException taskexecutionexception)
                {
                }

                public void onPostExecute(Integer integer)
                {
                    if (integer.intValue() > versionCode)
                    {
                        integer = new android.app.AlertDialog.Builder(AuthenticatingPreferenceActivity.this);
                        integer.setMessage(com.comcast.cim.android.R.string.version_too_low_desc).setTitle(com.comcast.cim.android.R.string.version_too_low_title).setPositiveButton(com.comcast.cim.android.R.string.dlg_btn_ok, new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                launchStrategy.exitApp(_fld0);
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                            final _cls1 this$1;

                            public void onCancel(DialogInterface dialoginterface)
                            {
                                launchStrategy.exitApp(_fld0);
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                        integer.create().show();
                    }
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Integer)obj);
                }

            
            {
                this$0 = AuthenticatingPreferenceActivity.this;
                super();
            }
            };
            minVersionCheckProvider.execute(minVersionCheckListener);
            return;
        }
    }

    protected void onResumeInternal()
    {
    }

    public final void onStart()
    {
        super.onStart();
        LOG.debug("onStart");
        LOG.debug("Check to see if we need to update the user or have them sign-in");
        if (!isFinishing() && !isAuthenticated())
        {
            return;
        } else
        {
            onStartInternal();
            return;
        }
    }

    protected void onStartInternal()
    {
    }



}
