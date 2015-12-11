// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.groupon.activity.IntentFactory;
import com.groupon.db.events.DialogCallbackEvent;
import com.groupon.models.country.Country;
import com.groupon.models.error.GrouponException;
import com.groupon.network.HttpResponseException;
import com.groupon.service.LoginService;
import com.squareup.otto.Bus;
import commonlib.manager.SyncManager;
import java.io.IOException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.util:
//            Function2, CountryNotSupportedException, DialogManager, CountryUtil, 
//            Function1, CheckedFunction0, GrouponDialogListener

public class LoaderCallbacksUtil
{
    protected static class AskLoginAgainOnExceptionFunction
        implements Function1
    {

        protected final Context context;
        private final Country country;
        private final CountryUtil countryUtil;
        protected final IntentFactory intentFactory;

        public void execute(Exception exception)
        {
            Toast.makeText(context.getApplicationContext(), String.format(context.getString(0x7f08017d), new Object[] {
                countryUtil.getDisplayNameByIsoName(country)
            }), 1).show();
            context.startActivity(intentFactory.newLoginIntentWithBackNavigationToCarousel(context, intentFactory.newCarouselIntent()));
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((Exception)obj);
        }

        public AskLoginAgainOnExceptionFunction(Context context1, CountryUtil countryutil, Country country1, IntentFactory intentfactory)
        {
            context = context1;
            countryUtil = countryutil;
            country = country1;
            intentFactory = intentfactory;
        }
    }

    protected static class RetryTaskWhenLoginFunction
        implements CheckedFunction0
    {

        protected final SyncManager syncManager;
        protected final Runnable taskToRetry;

        public void execute()
            throws Exception
        {
            syncManager.execute(taskToRetry);
        }

        public RetryTaskWhenLoginFunction(SyncManager syncmanager, Runnable runnable)
        {
            syncManager = syncmanager;
            taskToRetry = runnable;
        }
    }


    public LoaderCallbacksUtil()
    {
    }

    public static void handleSyncError(Runnable runnable, Exception exception, Context context, LoginService loginservice, CountryUtil countryutil, Country country, SyncManager syncmanager, IntentFactory intentfactory, 
            Function2 function2)
    {
        int i;
        if (exception instanceof HttpResponseException)
        {
            i = ((HttpResponseException)exception).getStatusCode();
        } else
        {
            i = 0;
        }
        if (!(exception instanceof GrouponException)) goto _L2; else goto _L1
_L1:
        if (function2 != null)
        {
            function2.execute(runnable, exception);
        }
_L4:
        return;
_L2:
        if (exception instanceof CountryNotSupportedException) goto _L4; else goto _L3
_L3:
        switch (i)
        {
        default:
            if (function2 != null)
            {
                function2.execute(runnable, exception);
                return;
            }
            break;

        case 401: 
            loginservice.relogin(new RetryTaskWhenLoginFunction(syncmanager, runnable), new AskLoginAgainOnExceptionFunction(context, countryutil, country, intentfactory), null);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static void showGenericErrorMessage(Runnable runnable, Exception exception, Context context, DialogManager dialogmanager, SyncManager syncmanager, Function2 function2, Function2 function2_1)
    {
        Bus bus = (Bus)RoboGuice.getInjector(context).getInstance(Key.get(com/squareup/otto/Bus, Names.named("GlobalEventManager")));
        if (exception instanceof GrouponException)
        {
            dialogmanager.showAlertDialog((GrouponException)exception, new android.content.DialogInterface.OnClickListener(syncmanager, function2_1, runnable, exception, bus) {

                final Exception val$e;
                final Bus val$globalBus;
                final SyncManager val$syncManager;
                final Function2 val$taskCanceled;
                final Runnable val$taskToRetry;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    syncManager.clearRetryTasks();
                    if (taskCanceled != null)
                    {
                        taskCanceled.execute(taskToRetry, e);
                    }
                    globalBus.post(new DialogCallbackEvent("negative_click"));
                }

            
            {
                syncManager = syncmanager;
                taskCanceled = function2;
                taskToRetry = runnable;
                e = exception;
                globalBus = bus;
                super();
            }
            });
            return;
        }
        String s;
        String s1;
        if (exception instanceof HttpResponseException)
        {
            s = context.getString(0x7f0801a1);
        } else
        if (exception instanceof IOException)
        {
            s = context.getString(0x7f080165);
        } else
        {
            s = context.getString(0x7f0801a6);
        }
        s1 = s;
        if (Ln.isDebugEnabled())
        {
            s1 = (new StringBuilder()).append(s).append("\n<a href='internal:///logviewer'>Show Logs</a>").toString();
        }
        dialogmanager.showAlertDialog(null, s1, Integer.valueOf(0x7f080336), new android.content.DialogInterface.OnClickListener(function2, runnable, exception, syncmanager, context, bus) {

            final Context val$context;
            final Exception val$e;
            final Bus val$globalBus;
            final SyncManager val$syncManager;
            final Function2 val$taskRetried;
            final Runnable val$taskToRetry;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (taskRetried != null)
                {
                    taskRetried.execute(taskToRetry, e);
                }
                syncManager.retryTasks();
                if (context instanceof GrouponDialogListener)
                {
                    ((GrouponDialogListener)context).onDialogPositiveButtonClick("", dialoginterface);
                }
                globalBus.post(new DialogCallbackEvent("positive_click"));
            }

            
            {
                taskRetried = function2;
                taskToRetry = runnable;
                e = exception;
                syncManager = syncmanager;
                context = context1;
                globalBus = bus;
                super();
            }
        }, Integer.valueOf(0x7f080084), new android.content.DialogInterface.OnClickListener(syncmanager, function2_1, runnable, exception, context, bus) {

            final Context val$context;
            final Exception val$e;
            final Bus val$globalBus;
            final SyncManager val$syncManager;
            final Function2 val$taskCanceled;
            final Runnable val$taskToRetry;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                syncManager.clearRetryTasks();
                if (taskCanceled != null)
                {
                    taskCanceled.execute(taskToRetry, e);
                }
                if (context instanceof GrouponDialogListener)
                {
                    ((GrouponDialogListener)context).onDialogNegativeButtonClick("", dialoginterface);
                }
                globalBus.post(new DialogCallbackEvent("negative_click"));
            }

            
            {
                syncManager = syncmanager;
                taskCanceled = function2;
                taskToRetry = runnable;
                e = exception;
                context = context1;
                globalBus = bus;
                super();
            }
        }, false, true);
    }
}
