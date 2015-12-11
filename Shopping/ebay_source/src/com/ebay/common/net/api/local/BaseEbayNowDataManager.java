// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.common.net.api.local:
//            BaseEbayNowResponse, EbayNowMappedException, BaseEbayNowRequest

public abstract class BaseEbayNowDataManager extends DataManager
{
    private final class LoadTask extends AsyncTask
    {

        final BaseEbayNowDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            try
            {
                avoid = load();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleLoadDataResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        private LoadTask()
        {
            this$0 = BaseEbayNowDataManager.this;
            super();
        }

    }


    private LoadTask loadTask;
    private final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("EbayNowLookupDM", 3, "Log eBay Now data manager");
    private EbayNowMappedException mappedException;
    private Content result;

    protected BaseEbayNowDataManager(EbayContext ebaycontext, Class class1)
    {
        super(ebaycontext, class1);
    }

    private void handleLoadDataResult(LoadTask loadtask, Content content)
    {
        if (loadTask == loadtask)
        {
            loadTask = null;
        }
        if (content == null)
        {
            return;
        }
        if (!content.getStatus().hasError())
        {
            result = content;
        }
        observerCallback(dispatcher, content);
    }

    private Content load()
        throws InterruptedException
    {
        BaseEbayNowResponse baseebaynowresponse = (BaseEbayNowResponse)sendRequest(createRequest());
        mappedException = baseebaynowresponse.getMappedException();
        ResultStatus resultstatus = baseebaynowresponse.getResultStatus();
        if (resultstatus.hasError())
        {
            return new Content(resultstatus);
        } else
        {
            return new Content(getResponseResult(baseebaynowresponse), resultstatus);
        }
    }

    protected abstract BaseEbayNowRequest createRequest();

    public boolean forceReloadData()
    {
        NautilusKernel.verifyMain();
        if (loadTask != null)
        {
            return false;
        } else
        {
            loadTask = new LoadTask();
            executeOnThreadPool(loadTask, new Void[0]);
            return true;
        }
    }

    public EbayNowMappedException getMappedException()
    {
        return mappedException;
    }

    protected abstract Object getResponseResult(BaseEbayNowResponse baseebaynowresponse);

    public Content getResult()
    {
        return result;
    }

    public void loadData(Object obj)
    {
        NautilusKernel.verifyMain();
        Content content = result;
        if (loadTask != null)
        {
            if (logger.isLoggable)
            {
                logger.log(".loadData - TASK ALREADY RUNNING");
            }
        } else
        {
            if (content == null)
            {
                loadTask = new LoadTask();
                executeOnThreadPool(loadTask, new Void[0]);
            }
            if (obj != null && content != null)
            {
                observerCallback(obj, content);
                return;
            }
        }
    }

    protected abstract void observerCallback(Object obj, Content content);

    protected void onLastObserverUnregistered()
    {
        if (logger.isLoggable)
        {
            logger.log(".onLastObserverUnregistered");
        }
        this;
        JVM INSTR monitorenter ;
        if (loadTask != null)
        {
            loadTask.cancel(true);
            loadTask = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }


}
