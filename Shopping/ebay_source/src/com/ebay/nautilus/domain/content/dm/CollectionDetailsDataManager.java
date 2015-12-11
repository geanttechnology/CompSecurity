// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.CollectionDetail;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.api.collections.CollectionDetailsRequest;
import com.ebay.nautilus.domain.net.api.collections.CollectionDetailsResponse;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager

public final class CollectionDetailsDataManager extends UserContextObservingDataManager
{
    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams(parcel.readString());
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
        public final String collectionId;

        protected CollectionDetailsDataManager create(EbayContext ebaycontext)
        {
            return new CollectionDetailsDataManager(ebaycontext, this);
        }

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            return (obj instanceof KeyParams) && ((KeyParams)obj).collectionId.equals(collectionId);
        }

        public int hashCode()
        {
            return super.hashCode() * 31 + collectionId.hashCode();
        }

        public String toString()
        {
            return (new StringBuilder()).append("collectionId:").append(collectionId).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(collectionId);
        }


        public KeyParams(String s)
        {
            collectionId = s;
            if (s == null)
            {
                throw new IllegalStateException("collectionId must be non-null.");
            } else
            {
                return;
            }
        }
    }

    private final class LoadTask extends AsyncTask
    {

        private final Authentication auth;
        private final EbayCountry country;
        private final String iafToken;
        private final String limit;
        private final String offset;
        final CollectionDetailsDataManager this$0;

        protected transient Content doInBackground(KeyParams akeyparams[])
        {
            String s;
            akeyparams = String.valueOf(akeyparams[0].collectionId);
            s = CollectionDetailsDataManager.cacheKeyFor(akeyparams, limit, offset, auth, country);
            CollectionDetail collectiondetail;
            synchronized (CollectionDetailsDataManager.cacheManager)
            {
                collectiondetail = (CollectionDetail)CollectionDetailsDataManager.cacheManager.get(s);
            }
            if (collectiondetail != null)
            {
                return new Content(collectiondetail);
            }
            break MISSING_BLOCK_LABEL_71;
            akeyparams;
            cachemanager;
            JVM INSTR monitorexit ;
            throw akeyparams;
            obj = new ResultStatusOwner();
            akeyparams = new CollectionDetailsRequest(iafToken, country, akeyparams, limit, offset);
            try
            {
                akeyparams = (CollectionDetailsResponse)sendRequest(akeyparams);
            }
            // Misplaced declaration of an exception variable
            catch (KeyParams akeyparams[])
            {
                akeyparams = null;
            }
            if (akeyparams != null && ((CollectionDetailsResponse) (akeyparams)).collectionDetail != null)
            {
                CollectionDetail collectiondetail1 = ((CollectionDetailsResponse) (akeyparams)).collectionDetail;
                synchronized (CollectionDetailsDataManager.cacheManager)
                {
                    CollectionDetailsDataManager.cacheManager.put(s, collectiondetail1);
                }
                return new Content(collectiondetail1, akeyparams.getResultStatus());
            } else
            {
                return new Content(((ResultStatusOwner) (obj)).getResultStatus());
            }
            akeyparams;
            obj;
            JVM INSTR monitorexit ;
            throw akeyparams;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((KeyParams[])aobj);
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

        public LoadTask(String s, String s1)
        {
            this$0 = CollectionDetailsDataManager.this;
            super();
            auth = getCurrentUser();
            String s2;
            if (auth != null)
            {
                s2 = auth.iafToken;
            } else
            {
                s2 = null;
            }
            iafToken = s2;
            country = getCurrentCountry();
            offset = s1;
            limit = s;
        }
    }

    public static interface Observer
    {

        public abstract void onCollectionChanged(CollectionDetailsDataManager collectiondetailsdatamanager, Content content);
    }


    public static int COLLECTION_ITEM_PAGE_SIZE = 24;
    private static volatile CacheManager cacheManager;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CollectionDeetsDM", 3, "CollectionDetails DataManager");
    private Content data;
    private boolean isMorePages;
    private boolean isUserInitialized;
    private LoadTask loadTask;
    private String nextPageParams;
    private int pageOffset;

    CollectionDetailsDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/CollectionDetailsDataManager$Observer, keyparams);
        loadTask = null;
        data = null;
        pageOffset = 0;
        isMorePages = true;
        if (cacheManager == null)
        {
            cacheManager = new CacheManager(getContext(), JsonPersistenceMapper.create(DataMapperFactory.getDefaultMapper()), com/ebay/nautilus/domain/data/CollectionDetail, "collectionDetailsCache", 1024, 1024, 2048L, 43200L, true);
        }
    }

    private static String cacheKeyFor(String s, String s1, String s2, Authentication authentication, EbayCountry ebaycountry)
    {
        String s3 = "";
        String s4 = "";
        if (authentication != null)
        {
            s3 = authentication.user;
        }
        authentication = s4;
        if (ebaycountry != null)
        {
            authentication = ebaycountry.getCountryCode();
        }
        return String.format("collection_%s_%s_%s_%s_%s", new Object[] {
            s3, authentication, s, s1, s2
        });
    }

    void handleLoadDataResult(LoadTask loadtask, Content content)
    {
        boolean flag = false;
        if (loadTask == loadtask)
        {
            loadTask = null;
        }
        if (content == null)
        {
            return;
        }
        data = content;
        loadtask = (CollectionDetail)data.getData();
        nextPageParams = null;
        isMorePages = false;
        if (loadtask != null)
        {
            if (((CollectionDetail) (loadtask)).next != null)
            {
                nextPageParams = ((CollectionDetail) (loadtask)).next;
            }
            if (nextPageParams != null)
            {
                flag = true;
            }
            isMorePages = flag;
            if (isMorePages)
            {
                pageOffset = pageOffset + ((CollectionDetail) (loadtask)).collection.entries.size();
            }
        }
        ((Observer)dispatcher).onCollectionChanged(this, content);
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public boolean loadNextPage(boolean flag)
    {
        if (flag)
        {
            onLastObserverUnregistered();
        }
        if (!isMorePages)
        {
            return false;
        }
        if (loadTask != null)
        {
            return false;
        } else
        {
            loadTask = new LoadTask(String.valueOf(COLLECTION_ITEM_PAGE_SIZE), String.valueOf(pageOffset));
            executeOnThreadPool(loadTask, new KeyParams[] {
                (KeyParams)getParams()
            });
            return true;
        }
    }

    protected void onLastObserverUnregistered()
    {
        if (loadTask != null)
        {
            loadTask.cancel(true);
            loadTask = null;
        }
        pageOffset = 0;
        isMorePages = true;
        data = null;
        nextPageParams = null;
    }




}
