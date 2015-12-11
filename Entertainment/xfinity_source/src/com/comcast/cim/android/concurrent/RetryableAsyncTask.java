// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.concurrent;

import android.app.Activity;
import android.os.AsyncTask;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.utils.UIUtil;
import java.lang.ref.WeakReference;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class RetryableAsyncTask extends AsyncTask
{

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private WeakReference activityWeakReference;
    private android.content.DialogInterface.OnCancelListener errorDialogCancelListener;
    protected final ErrorDialogFactory errorDialogFactory;
    private Exception exception;
    private InternetConnection internetConnection;
    private Object originalParams[];
    private boolean requiresNetworkConnectivity;
    private UIUtil uiUtil;

    protected RetryableAsyncTask(Activity activity, boolean flag, InternetConnection internetconnection, android.content.DialogInterface.OnCancelListener oncancellistener, ErrorDialogFactory errordialogfactory)
    {
        requiresNetworkConnectivity = false;
        Validate.notNull(activity);
        Validate.notNull(oncancellistener);
        setActivity(activity);
        requiresNetworkConnectivity = flag;
        errorDialogCancelListener = oncancellistener;
        internetConnection = internetconnection;
        if (internetconnection != null)
        {
            uiUtil = new UIUtil(internetconnection);
        }
        errorDialogFactory = errordialogfactory;
    }

    private void setActivity(Activity activity)
    {
        activityWeakReference = new WeakReference(activity);
    }

    protected final transient Object doInBackground(Object aobj[])
    {
        originalParams = aobj;
        try
        {
            if (requiresNetworkConnectivity && !internetConnection.isConnected())
            {
                throw new CimException("network not available; present retry dialog");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            LOG.warn((new StringBuilder()).append("Exception during background operation of ").append(getClass().getSimpleName()).toString(), ((Throwable) (aobj)));
            exception = ((Exception) (aobj));
            return null;
        }
        aobj = ((Object []) (doInBackgroundWrapped(aobj)));
        return ((Object) (aobj));
    }

    protected abstract Object doInBackgroundWrapped(Object aobj[]);

    protected Activity getActivity()
    {
        return (Activity)activityWeakReference.get();
    }

    protected InternetConnection getInternetConnection()
    {
        return internetConnection;
    }

    protected abstract RetryableAsyncTask getNewInstance(Activity activity);

    protected final void onPostExecute(Object obj)
    {
        final Activity activity = getActivity();
        if (activity != null && !isCancelled())
        {
            if (exception != null)
            {
                if (retryOnException(exception) && uiUtil != null)
                {
                    uiUtil.tryToShowDialog(new Runnable() {

                        final RetryableAsyncTask this$0;
                        final Activity val$activity;

                        public void run()
                        {
                            CALDialogFragment caldialogfragment = errorDialogFactory.createErrorDialogForThrowable(exception, new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

                                final _cls1 this$1;

                                public void tryAgain()
                                {
                                    getNewInstance(activity).execute(originalParams);
                                }

            
            {
                this$1 = _cls1.this;
                super();
            }
                            });
                            caldialogfragment.setOnCancelListener(errorDialogCancelListener);
                            caldialogfragment.show(activity.getFragmentManager(), "caldialogfragment");
                        }

            
            {
                this$0 = RetryableAsyncTask.this;
                activity = activity1;
                super();
            }
                    });
                    return;
                }
            } else
            {
                onPostExecuteWrapped(obj);
                return;
            }
        }
    }

    protected abstract void onPostExecuteWrapped(Object obj);

    protected abstract boolean retryOnException(Exception exception1);



}
