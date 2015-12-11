// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.util.FwLog;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class EbayAsyncTask extends AsyncTask
{
    public static interface TaskHandler
    {

        public abstract void onError(int i, List list);

        public abstract void onTaskComplete(Object obj);
    }


    public static final int ERROR_INTERNAL = -3;
    public static final int ERROR_NETWORK = -2;
    public static final int ERROR_SERVER = -4;
    public static final int ERROR_USER = -1;
    public static final int SUCCESS = 0;
    private ArrayList errors;
    private WeakReference handler;
    com.ebay.nautilus.kernel.util.FwLog.LogInfo logInfo;
    private int response;

    protected EbayAsyncTask()
    {
        logInfo = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(com/ebay/common/util/EbayAsyncTask.getSimpleName(), 3, "Log network errors from tasks");
        response = 0;
        errors = null;
        handler = null;
    }

    protected EbayAsyncTask(TaskHandler taskhandler)
    {
        logInfo = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(com/ebay/common/util/EbayAsyncTask.getSimpleName(), 3, "Log network errors from tasks");
        response = 0;
        errors = null;
        setHandler(taskhandler);
    }

    private void log(Exception exception)
    {
        if (logInfo.isLoggable)
        {
            String s1 = exception.getMessage();
            String s = s1;
            if (TextUtils.isEmpty(s1))
            {
                s = exception.getClass().getName();
            }
            FwLog.println(logInfo, s, exception);
        }
    }

    protected final transient Object doInBackground(Object aobj[])
    {
        if (aobj.length > 0)
        {
            aobj = ((Object []) (aobj[0]));
        } else
        {
            aobj = null;
        }
        try
        {
            aobj = ((Object []) (doInBackgroundInternal(((Object) (aobj)))));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            log(((Exception) (aobj)));
            response = -3;
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            log(((Exception) (aobj)));
            response = -3;
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            log(((Exception) (aobj)));
            response = -1;
            errors = ((com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException) (aobj)).getErrors();
            return null;
        }
        catch (com.ebay.nautilus.kernel.net.Connector.HostErrorException hosterrorexception)
        {
            log(hosterrorexception);
            String s;
            if (hosterrorexception.getResponseCode() == 500)
            {
                response = -4;
            } else
            {
                response = -2;
            }
            aobj = new EbayResponseError();
            aobj.code = String.valueOf(hosterrorexception.getResponseCode());
            s = hosterrorexception.getLocalizedMessage();
            aobj.longMessage = s;
            aobj.shortMessage = s;
            errors = new ArrayList(1);
            errors.add(((Object) (aobj)));
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            log(((Exception) (aobj)));
            response = -2;
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            log(((Exception) (aobj)));
            return null;
        }
        return ((Object) (aobj));
    }

    protected abstract Object doInBackgroundInternal(Object obj)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException;

    public final ArrayList getErrors()
    {
        return errors;
    }

    public final int getResponseCode()
    {
        return response;
    }

    protected final void notifyCompleted(TaskHandler taskhandler, Object obj)
    {
label0:
        {
            if (taskhandler != null)
            {
                if (response != 0)
                {
                    break label0;
                }
                taskhandler.onTaskComplete(obj);
            }
            return;
        }
        taskhandler.onError(response, errors);
    }

    protected void onCancelled()
    {
        if (handler != null)
        {
            notifyCompleted((TaskHandler)handler.get(), null);
            return;
        } else
        {
            super.onCancelled();
            return;
        }
    }

    protected void onPostExecute(Object obj)
    {
        if (handler != null)
        {
            notifyCompleted((TaskHandler)handler.get(), obj);
            return;
        } else
        {
            super.onPostExecute(obj);
            return;
        }
    }

    protected final void setHandler(TaskHandler taskhandler)
    {
        handler = new WeakReference(taskhandler);
    }
}
