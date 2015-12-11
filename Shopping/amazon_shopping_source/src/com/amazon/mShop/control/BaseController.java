// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control;

import com.amazon.mShop.model.auth.UserSubscriber;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ApplicationException;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control:
//            Cancellable, TaskCallback, GenericSubscriber

public abstract class BaseController
    implements Cancellable, com.amazon.mShop.model.auth.UserSubscriber.Callback
{

    private ServiceCall serviceCall;
    private TaskCallback taskCallback;

    public BaseController()
    {
    }

    public void cancel()
    {
        if (serviceCall != null)
        {
            serviceCall.cancel();
            serviceCallCompleted();
        }
    }

    public void cancelled(ServiceCall servicecall)
    {
    }

    public void error(final Exception e, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final BaseController this$0;
            final Exception val$e;
            final ServiceCall val$sc;

            public void run()
            {
                GenericSubscriber genericsubscriber;
label0:
                {
                    if (isRunningServiceCall(sc))
                    {
                        genericsubscriber = getSubscriber();
                        if (!(e instanceof ApplicationException) || !ApplicationException.USER_NOT_AUTHENTICATED.equals(((ApplicationException)e).getErrorCode()) || !(genericsubscriber instanceof UserSubscriber))
                        {
                            break label0;
                        }
                        ((UserSubscriber)genericsubscriber).onRequiresUserLogin(BaseController.this);
                    }
                    return;
                }
                handleServiceCallError();
                genericsubscriber.onError(e, sc);
            }

            
            {
                this$0 = BaseController.this;
                sc = servicecall;
                e = exception;
                super();
            }
        });
    }

    protected abstract GenericSubscriber getSubscriber();

    protected TaskCallback getTaskCallback()
    {
        return taskCallback;
    }

    protected void handleServiceCallError()
    {
        serviceCallCompleted();
    }

    public boolean hasServiceCallRunning()
    {
        return serviceCall != null;
    }

    protected boolean isRunningServiceCall(ServiceCall servicecall)
    {
        return serviceCall == servicecall;
    }

    protected void serviceCallCompleted()
    {
        if (taskCallback != null)
        {
            taskCallback.endTask();
            taskCallback = null;
        }
        serviceCall = null;
    }

    protected void serviceCallStarted(ServiceCall servicecall, TaskCallback taskcallback)
    {
        if (serviceCall != null)
        {
            throw new IllegalStateException("serviceCallStarted() called when a service call is already running");
        }
        serviceCall = servicecall;
        if (taskcallback != null)
        {
            taskCallback = taskcallback;
            taskcallback.beginTask();
        }
    }

    protected void setServiceCall(ServiceCall servicecall)
    {
        serviceCall = servicecall;
    }

    protected void setTaskCallback(TaskCallback taskcallback)
    {
        taskCallback = taskcallback;
    }

    public void userCancelledSignIn()
    {
        serviceCallCompleted();
    }

    public void userSuccessfullySignedIn()
    {
        if (serviceCall != null)
        {
            serviceCall.replay();
        }
    }
}
