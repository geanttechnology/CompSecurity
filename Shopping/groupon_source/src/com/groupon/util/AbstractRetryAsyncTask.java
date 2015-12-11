// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import com.crittercism.app.Crittercism;
import com.groupon.activity.IntentFactory;
import com.groupon.http.Http;
import com.groupon.http.RetryQueue;
import com.groupon.models.error.GrouponException;
import com.groupon.network.HttpResponseException;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.view.DisableCountMap;
import com.groupon.view.HideCountMap;
import com.groupon.view.SpinnerCountMap;
import java.io.IOException;
import java.net.ConnectException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            GrouponRoboAsyncTask, DialogManager, CountryNotSupportedException, CountryUtil, 
//            CheckedFunction0, Function1

public abstract class AbstractRetryAsyncTask extends GrouponRoboAsyncTask
{
    public static interface OnRetryListener
    {

        public abstract void onRetry();
    }


    protected CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private DialogManager dialogManager;
    private View disableViews[];
    private DisableCountMap disabledCounts;
    private HideCountMap hideCounts;
    private View hideViews[];
    private boolean ignoreHttpError;
    protected IntentFactory intentFactory;
    private LoginService loginService;
    private OnRetryListener onRetryListener;
    private Object progressView;
    private RetryQueue retryQueue;
    private SpinnerCountMap spinnerCounts;

    public AbstractRetryAsyncTask(Context context)
    {
        super(context);
        ignoreHttpError = false;
    }

    public AbstractRetryAsyncTask(Context context, Handler handler)
    {
        super(context, handler);
        ignoreHttpError = false;
    }

    public AbstractRetryAsyncTask(Context context, Handler handler, Executor executor)
    {
        super(context, handler, executor);
        ignoreHttpError = false;
    }

    public AbstractRetryAsyncTask(Context context, Executor executor)
    {
        super(context, executor);
        ignoreHttpError = false;
    }

    public transient AbstractRetryAsyncTask disableViews(View aview[])
    {
        disableViews = aview;
        return this;
    }

    protected void hideProgressView()
    {
        boolean flag = false;
        spinnerCounts.decrement(progressView);
        if (disableViews != null)
        {
            View aview[] = disableViews;
            int k = aview.length;
            for (int i = 0; i < k; i++)
            {
                View view = aview[i];
                disabledCounts.decrement(view);
            }

        }
        if (hideViews != null)
        {
            View aview1[] = hideViews;
            int l = aview1.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                View view1 = aview1[j];
                hideCounts.decrement(view1);
            }

        }
    }

    public AbstractRetryAsyncTask ignoreHttpErrors()
    {
        ignoreHttpError = true;
        return this;
    }

    protected void onException(Exception exception)
    {
        int i = 0;
        if (!(exception instanceof IOException))
        {
            Crittercism.logHandledException(exception);
        }
        if (!ignoreHttpError || !(exception instanceof HttpResponseException) && !(exception instanceof ConnectException))
        {
            android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

                final AbstractRetryAsyncTask this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    onUserCancelRetry();
                }

            
            {
                this$0 = AbstractRetryAsyncTask.this;
                super();
            }
            };
            if (exception instanceof GrouponException)
            {
                dialogManager.showAlertDialog((GrouponException)exception, onclicklistener);
                return;
            }
            if (!(exception instanceof CountryNotSupportedException))
            {
                Object obj;
                if (this instanceof Http)
                {
                    obj = ((Http)this).uri();
                } else
                {
                    obj = null;
                }
                Ln.w(exception, Strings.toString(obj), new Object[0]);
                if (exception instanceof HttpResponseException)
                {
                    i = ((HttpResponseException)exception).getStatusCode();
                }
                switch (i)
                {
                default:
                    if (shouldRetry())
                    {
                        retryQueue.add(this, exception);
                        return;
                    } else
                    {
                        dialogManager.showAlertDialog(null, Integer.valueOf(0x7f080165), Integer.valueOf(0x7f080139), onclicklistener);
                        return;
                    }

                case 401: 
                    relogin();
                    return;
                }
            }
        }
    }

    protected void onFinally()
    {
        hideProgressView();
    }

    protected void onPreExecute()
        throws Exception
    {
        super.onPreExecute();
        showProgressView();
    }

    public void onUserCancelRetry()
    {
    }

    public AbstractRetryAsyncTask progressView(int i)
    {
        if (i > 0)
        {
            progressView = ((Activity)context).findViewById(i);
            return this;
        } else
        {
            progressView = null;
            return this;
        }
    }

    public AbstractRetryAsyncTask progressView(View view)
    {
        progressView = view;
        return this;
    }

    protected void relogin()
    {
        loginService.relogin(new CheckedFunction0() {

            final AbstractRetryAsyncTask this$0;

            public void execute()
                throws Exception
            {
                retry();
            }

            
            {
                this$0 = AbstractRetryAsyncTask.this;
                super();
            }
        }, new Function1() {

            final AbstractRetryAsyncTask this$0;

            public void execute(Exception exception)
            {
                Toast.makeText(
// JavaClassFileOutputException: get_constant: invalid tag

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

            
            {
                this$0 = AbstractRetryAsyncTask.this;
                super();
            }
        }, null);
    }

    public void retry()
    {
        if (!((ExecutorService)executor).isShutdown())
        {
            future = new FutureTask(newTask(), null);
            execute();
            if (onRetryListener != null)
            {
                onRetryListener.onRetry();
            }
        }
    }

    public AbstractRetryAsyncTask setOnRetryListener(OnRetryListener onretrylistener)
    {
        onRetryListener = onretrylistener;
        return this;
    }

    protected boolean shouldRetry()
    {
        return true;
    }

    protected void showProgressView()
    {
        boolean flag = false;
        spinnerCounts.increment(progressView);
        if (disableViews != null)
        {
            View aview[] = disableViews;
            int k = aview.length;
            for (int i = 0; i < k; i++)
            {
                View view = aview[i];
                disabledCounts.increment(view);
            }

        }
        if (hideViews != null)
        {
            View aview1[] = hideViews;
            int l = aview1.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                View view1 = aview1[j];
                hideCounts.increment(view1);
            }

        }
    }





}
