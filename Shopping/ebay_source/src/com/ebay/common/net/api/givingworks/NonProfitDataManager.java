// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            GetFavoritesRequest, FindNonProfitResponse, SetUserDonationDetailsRequest

public final class NonProfitDataManager extends UserContextObservingDataManager
{
    public static final class KeyParams extends com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return NonProfitDataManager.KEY;
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

        protected NonProfitDataManager create(EbayContext ebaycontext)
        {
            return new NonProfitDataManager(ebaycontext, this);
        }

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }


        KeyParams()
        {
        }
    }

    private final class LoadTask extends AsyncTask
    {

        final NonProfitDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            avoid = null;
            if (country == null || auth == null)
            {
                avoid = new Content(null, ResultStatus.SUCCESS);
            } else
            {
                Object obj = new GetFavoritesRequest(auth, country.site);
                Object obj1 = new ResultStatusOwner();
                obj = (FindNonProfitResponse)safeSendRequest(((Request) (obj)), ((ResultStatusOwner) (obj1)));
                obj1 = ((ResultStatusOwner) (obj1)).getResultStatus();
                if (obj1 != ResultStatus.CANCELED)
                {
                    if (((ResultStatus) (obj1)).hasError())
                    {
                        return new Content(((ResultStatus) (obj1)));
                    } else
                    {
                        return new Content(((FindNonProfitResponse) (obj)).getNonprofits(), ((ResultStatus) (obj1)));
                    }
                }
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
            handleLoadResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        private LoadTask()
        {
            this$0 = NonProfitDataManager.this;
            super();
        }

    }

    private static final class NonprofitCollection
    {

        public Content content;

        public boolean addFavorite(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
        {
            if (NonProfitDataManager.logger.isLoggable)
            {
                NonProfitDataManager.logger.log((new StringBuilder()).append(".addNewFavorite: ").append(nonprofit).toString());
            }
            if (content == null) goto _L2; else goto _L1
_L1:
            List list = (List)content.getData();
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                if (((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)iterator.next()).externalId.equals(nonprofit.externalId))
                {
                    return false;
                }
            }

            list.add(nonprofit);
            Collections.sort(list);
            content = new Content(list, content.getStatus());
_L4:
            return true;
_L2:
            ArrayList arraylist = new ArrayList();
            arraylist.add(nonprofit);
            content = new Content(arraylist, ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[0]));
            if (true) goto _L4; else goto _L3
_L3:
        }

        public String[] getFavoriteNonprofitIds()
        {
            ArrayList arraylist = new ArrayList();
            if (content != null)
            {
                Object obj = (List)content.getData();
                if (obj != null)
                {
                    for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)((Iterator) (obj)).next()).externalId)) { }
                }
            }
            if (NonProfitDataManager.logger.isLoggable)
            {
                NonProfitDataManager.logger.log((new StringBuilder()).append(".getFavoriteNonprofitIds: ").append(arraylist).toString());
            }
            return (String[])arraylist.toArray(new String[arraylist.size()]);
        }

        public boolean removeFavorite(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
        {
label0:
            {
                if (NonProfitDataManager.logger.isLoggable)
                {
                    NonProfitDataManager.logger.log((new StringBuilder()).append(".removeFavorite: ").append(nonprofit).toString());
                }
                if (content == null)
                {
                    break label0;
                }
                List list = (List)content.getData();
                Iterator iterator = list.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                } while (!nonprofit.externalId.equals(((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)iterator.next()).externalId));
                iterator.remove();
                content = new Content(list, content.getStatus());
                return true;
            }
            return false;
        }

        private NonprofitCollection()
        {
            content = null;
        }

    }

    public static interface Observer
    {

        public abstract void onNonProfitsChanged(NonProfitDataManager nonprofitdatamanager, Content content);
    }

    private final class UpdateTask extends AsyncTask
    {

        final NonProfitDataManager this$0;

        protected transient Content doInBackground(String as[])
        {
            as = new SetUserDonationDetailsRequest(auth, country.site, as);
            ResultStatusOwner resultstatusowner = new ResultStatusOwner();
            safeSendRequest(as, resultstatusowner);
            as = resultstatusowner.getResultStatus();
            if (as == ResultStatus.CANCELED)
            {
                return null;
            } else
            {
                return new Content(as);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleUpdateResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        private UpdateTask()
        {
            this$0 = NonProfitDataManager.this;
            super();
        }

    }


    public static final KeyParams KEY = new KeyParams();
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("NonprofitDataManager", 3, "Log non profit data manager");
    private Authentication auth;
    private final NonprofitCollection collection = new NonprofitCollection();
    private EbayCountry country;
    private LoadTask loadTask;

    NonProfitDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/common/net/api/givingworks/NonProfitDataManager$Observer, keyparams);
        loadTask = null;
    }

    private void handleLoadResult(LoadTask loadtask, Content content)
    {
        if (content != null)
        {
            ResultStatus resultstatus = content.getStatus();
            List list = (List)content.getData();
            if (logger.isLoggable)
            {
                logger.log((new StringBuilder()).append(".handleLoadDataResult: result:").append(resultstatus.toString()).append(", result:").append(list).toString());
            }
        }
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
            collection.content = content;
        }
        ((Observer)dispatcher).onNonProfitsChanged(this, content);
    }

    private void handleUpdateResult(UpdateTask updatetask, Content content)
    {
        if (content != null)
        {
            updatetask = content.getStatus();
            if (logger.isLoggable)
            {
                logger.log((new StringBuilder()).append(".handleUpdateResult: result:").append(updatetask.toString()).toString());
            }
        }
        while (content == null || collection.content == null) 
        {
            return;
        }
        ((Observer)dispatcher).onNonProfitsChanged(this, collection.content);
    }

    public void addNonprofit(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
    {
        if (logger.isLoggable)
        {
            logger.log(".addNonprofit");
        }
        NautilusKernel.verifyMain();
        if (collection.addFavorite(nonprofit))
        {
            executeOnThreadPool(new UpdateTask(), collection.getFavoriteNonprofitIds());
        }
    }

    public void forceReloadData()
    {
        if (logger.isLoggable)
        {
            logger.log(".forceReloadData");
        }
        NautilusKernel.verifyMain();
        if (loadTask != null)
        {
            loadTask.cancel(true);
            loadTask = null;
        }
        collection.content = null;
        loadData(((Observer) (null)));
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
        if (logger.isLoggable)
        {
            logger.log(".loadData");
        }
        if (loadTask != null)
        {
            if (logger.isLoggable)
            {
                logger.log(".loadData - TASK ALREADY RUNNING");
            }
        } else
        {
            Content content = collection.content;
            if (content == null)
            {
                loadTask = new LoadTask();
                if (logger.isLoggable)
                {
                    logger.log(".loadData - TASK ALLOCATED");
                }
                executeOnThreadPool(loadTask, new Void[0]);
                return;
            }
            if (observer != null)
            {
                observer.onNonProfitsChanged(this, content);
                return;
            }
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append(".onCurrentCountryChanged country=").append(ebaycountry.toString()).toString());
        }
        country = ebaycountry;
        forceReloadData();
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append(".onCurrentUserChanged userId=").append(s).append(" iafToken=").append(s1).toString());
        }
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            auth = new Authentication(s, s1);
            forceReloadData();
            return;
        } else
        {
            collection.content = null;
            return;
        }
    }

    protected void onLastObserverUnregistered()
    {
        if (logger.isLoggable)
        {
            logger.log(".onLastObserverUnregistered");
        }
        synchronized (collection)
        {
            if (loadTask != null)
            {
                loadTask.cancel(true);
                loadTask = null;
            }
        }
        return;
        exception;
        nonprofitcollection;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void removeNonprofit(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
    {
        if (logger.isLoggable)
        {
            logger.log(".removeNonprofit");
        }
        NautilusKernel.verifyMain();
        if (collection.removeFavorite(nonprofit))
        {
            executeOnThreadPool(new UpdateTask(), collection.getFavoriteNonprofitIds());
        }
    }







}
