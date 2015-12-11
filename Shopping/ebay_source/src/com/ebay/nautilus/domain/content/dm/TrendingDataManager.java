// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.net.api.trend.TrendContentRequest;
import com.ebay.nautilus.domain.net.api.trend.TrendContentResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.Arrays;

public final class TrendingDataManager extends DataManager
{
    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return TrendingDataManager.KEY;
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public TrendingDataManager createManager(EbayContext ebaycontext)
        {
            return new TrendingDataManager(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            return obj == this || (obj instanceof KeyParams);
        }


        protected KeyParams()
        {
        }
    }

    private final class LoadTask extends AsyncTask
    {

        final TrendingDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            if (TrendingDataManager.log.isLoggable)
            {
                TrendingDataManager.log.log((new StringBuilder()).append("Starting background task: ").append(this).toString());
            }
            try
            {
                avoid = (TrendContentResponse)sendRequest(new TrendContentRequest());
                ResultStatus resultstatus = avoid.getResultStatus();
                if (resultstatus.hasError())
                {
                    return new Content(resultstatus);
                }
                avoid = new Content(Arrays.asList(((TrendContentResponse) (avoid)).trends), resultstatus);
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

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(this, null);
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
            this$0 = TrendingDataManager.this;
            super();
        }

    }

    public static interface Observer
    {

        public abstract void onTrendsContentChanged(TrendingDataManager trendingdatamanager, Content content);
    }


    public static final KeyParams KEY = new KeyParams();
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Trend", 3, "TrendingDataManager");
    private LoadTask loadTask;

    TrendingDataManager(EbayContext ebaycontext)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/TrendingDataManager$Observer);
    }

    public Object getParams()
    {
        return KEY;
    }

    void handleLoadDataResult(LoadTask loadtask, Content content)
    {
        if (loadTask == loadtask)
        {
            loadTask = null;
        }
        if (content == null)
        {
            return;
        } else
        {
            ((Observer)dispatcher).onTrendsContentChanged(this, content);
            return;
        }
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
        if (loadTask != null)
        {
            return;
        } else
        {
            loadTask = new LoadTask();
            executeOnThreadPool(loadTask, new Void[0]);
            return;
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    protected void onLastObserverUnregistered()
    {
        if (log.isLoggable)
        {
            log.log(".onLastObserverUnregistered");
        }
        if (loadTask != null)
        {
            loadTask.cancel(true);
            loadTask = null;
        }
    }


}
