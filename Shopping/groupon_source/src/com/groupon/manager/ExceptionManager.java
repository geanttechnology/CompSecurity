// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.widget.Toast;
import com.crittercism.app.Crittercism;
import com.groupon.activity.IntentFactory;
import com.groupon.models.error.GrouponException;
import com.groupon.network.HttpResponseException;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.CountryUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import java.io.IOException;
import roboguice.util.Ln;

public class ExceptionManager
{
    protected static class ExecuteFunctionClickListener
        implements android.content.DialogInterface.OnClickListener
    {

        protected final Function0 function;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (function != null)
            {
                function.execute();
            }
        }

        public ExecuteFunctionClickListener(Function0 function0)
        {
            function = function0;
        }
    }

    protected class InvalidLoginExceptionFunction
        implements Function1
    {

        final ExceptionManager this$0;

        public void execute(Exception exception)
        {
            Toast.makeText(context.getApplicationContext(), String.format(context.getString(0x7f08017d), new Object[] {
                countryUtil.getDisplayNameByIsoName(currentCountryManager.getCurrentCountry())
            }), 1).show();
            context.startActivity(intentFactory.newLoginIntent(context, intentFactory.newCarouselIntent()));
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((Exception)obj);
        }

        protected InvalidLoginExceptionFunction()
        {
            this$0 = ExceptionManager.this;
            super();
        }
    }

    protected class ShowAlertDialogRunnable
        implements Runnable
    {

        protected final Function0 cancelFunction;
        protected final String msgCopy;
        protected final Function0 retryFunction;
        final ExceptionManager this$0;

        public void run()
        {
            dialogManager.showAlertDialog(null, msgCopy, Integer.valueOf(0x7f080336), new ExecuteFunctionClickListener(retryFunction), Integer.valueOf(0x7f080084), new ExecuteFunctionClickListener(cancelFunction), false, true);
        }

        public ShowAlertDialogRunnable(String s, Function0 function0, Function0 function0_1)
        {
            this$0 = ExceptionManager.this;
            super();
            msgCopy = s;
            retryFunction = function0;
            cancelFunction = function0_1;
        }
    }

    protected class ShowGrouponExceptionDialogRunnable
        implements Runnable
    {

        protected final Function0 cancelFunction;
        protected final GrouponException grouponException;
        final ExceptionManager this$0;

        public void run()
        {
            dialogManager.showAlertDialog(grouponException, new ExecuteFunctionClickListener(cancelFunction));
        }

        public ShowGrouponExceptionDialogRunnable(GrouponException grouponexception, Function0 function0)
        {
            this$0 = ExceptionManager.this;
            super();
            grouponException = grouponexception;
            cancelFunction = function0;
        }
    }


    private Context context;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private DialogManager dialogManager;
    private Handler handler;
    private IntentFactory intentFactory;
    private LoginService loginService;

    public ExceptionManager()
    {
    }

    public void handleException(Throwable throwable, Function0 function0, Function0 function0_1)
    {
        int i;
        if (throwable instanceof HttpResponseException)
        {
            i = ((HttpResponseException)throwable).getStatusCode();
        } else
        {
            i = 0;
        }
        if (!(throwable instanceof IOException))
        {
            Crittercism.logHandledException(throwable);
        }
        if (throwable instanceof GrouponException)
        {
            handler.post(new ShowGrouponExceptionDialogRunnable((GrouponException)throwable, function0_1));
        } else
        if (!(throwable instanceof CountryNotSupportedException))
        {
            switch (i)
            {
            default:
                Object obj;
                if (throwable instanceof HttpResponseException)
                {
                    throwable = context.getString(0x7f0801a1);
                } else
                if (throwable instanceof IOException)
                {
                    throwable = context.getString(0x7f080165);
                } else
                {
                    throwable = context.getString(0x7f0801a6);
                }
                obj = throwable;
                if (Ln.isDebugEnabled())
                {
                    obj = (new StringBuilder()).append(throwable).append("\n<a href='internal:///logviewer'>Show Logs</a>").toString();
                }
                handler.post(new ShowAlertDialogRunnable(((String) (obj)), function0, function0_1));
                return;

            case 401: 
                loginService.relogin(function0, new InvalidLoginExceptionFunction(), null);
                return;
            }
        }
    }





}
