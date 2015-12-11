// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.GetCategoryFeaturesRequest;
import com.ebay.nautilus.domain.net.api.trading.GetCategoryFeaturesResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.io.Serializable;
import java.util.List;

public class CategoriesDataManager extends DataManager
{
    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams((EbaySite)parcel.readParcelable(com/ebay/nautilus/domain/EbaySite.getClassLoader()));
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
        public final EbaySite site;

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public CategoriesDataManager createManager(EbayContext ebaycontext)
        {
            return new CategoriesDataManager(ebaycontext, this);
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (KeyParams)obj;
                if (site == null)
                {
                    if (((KeyParams) (obj)).site != null)
                    {
                        return false;
                    }
                } else
                {
                    return site.equals(((KeyParams) (obj)).site);
                }
            }
            return true;
        }

        public int hashCode()
        {
            int j = super.hashCode();
            int i;
            if (site != null)
            {
                i = site.hashCode();
            } else
            {
                i = 0;
            }
            return j * 31 + i;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeParcelable(site, i);
        }


        public KeyParams(EbaySite ebaysite)
        {
            if (CategoriesDataManager.logTag.isLoggable)
            {
                CategoriesDataManager.logTag.log((new StringBuilder()).append("KeyParams: site=").append(ebaysite).toString());
            }
            site = ebaysite;
        }
    }

    private final class LoadTask extends AsyncTask
    {

        private final EbayTradingApi api;
        final CategoriesDataManager this$0;

        protected transient Content doInBackground(KeyParams akeyparams[])
        {
            Object obj;
            Object obj1;
            obj = null;
            obj1 = null;
            if (akeyparams[0].site == null) goto _L2; else goto _L1
_L1:
            SiteCategories sitecategories1;
            ResultStatusOwner resultstatusowner;
            sitecategories1 = (SiteCategories)CategoriesDataManager.cacheManager.get(CategoriesDataManager.getCacheKey(akeyparams[0].site));
            resultstatusowner = new ResultStatusOwner();
            if (sitecategories1 != null && sitecategories1.categoriesIdsRequiringConsent != null) goto _L4; else goto _L3
_L3:
            SiteCategories sitecategories;
            if (CategoriesDataManager.logTag.isLoggable)
            {
                CategoriesDataManager.logTag.log((new StringBuilder()).append("cache miss on site ").append(akeyparams[0].site).toString());
            }
            obj = new GetCategoryFeaturesRequest(api);
            GetCategoryFeaturesResponse getcategoryfeaturesresponse = (GetCategoryFeaturesResponse)safeSendRequest(((Request) (obj)), resultstatusowner);
            sitecategories = sitecategories1;
            obj = obj1;
            if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
            {
                if (!resultstatusowner.getResultStatus().hasError())
                {
                    if (CategoriesDataManager.logTag.isLoggable)
                    {
                        CategoriesDataManager.logTag.log((new StringBuilder()).append("caching site ").append(akeyparams[0].site).toString());
                    }
                    sitecategories = new SiteCategories();
                    sitecategories.categoriesIdsRequiringConsent = getcategoryfeaturesresponse.categoriesRequiringConsent;
                    CategoriesDataManager.cacheManager.put(CategoriesDataManager.getCacheKey(akeyparams[0].site), sitecategories);
                    obj = obj1;
                } else
                {
                    obj = new Content(null, resultstatusowner.getResultStatus());
                    sitecategories = sitecategories1;
                }
            }
_L6:
            if (sitecategories != null)
            {
                obj = new Content(sitecategories, resultstatusowner.getResultStatus());
            }
_L2:
            return ((Content) (obj));
_L4:
            sitecategories = sitecategories1;
            obj = obj1;
            if (CategoriesDataManager.logTag.isLoggable)
            {
                CategoriesDataManager.logTag.log((new StringBuilder()).append("cache hit on site ").append(akeyparams[0].site).toString());
                sitecategories = sitecategories1;
                obj = obj1;
            }
            if (true) goto _L6; else goto _L5
_L5:
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

        public LoadTask(EbayTradingApi ebaytradingapi)
        {
            this$0 = CategoriesDataManager.this;
            super();
            api = ebaytradingapi;
        }
    }

    public static interface Observer
    {

        public abstract void onCategoriesChanged(CategoriesDataManager categoriesdatamanager, Content content);
    }

    public static class SiteCategories
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public List categoriesIdsRequiringConsent;

        public SiteCategories()
        {
        }
    }


    private static final long MAX_CACHE_TTL = 0x5265c00L;
    private static volatile CacheManager cacheManager;
    private static final Object configLock = new Object();
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CategoriesDM", 3, "Log Categories DM");
    private Content _content;
    private LoadTask loadTask;
    private final KeyParams params;

    CategoriesDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/CategoriesDataManager$Observer);
        _content = null;
        params = keyparams;
        synchronized (configLock)
        {
            if (cacheManager == null)
            {
                cacheManager = new CacheManager(getContext(), JsonPersistenceMapper.create(DataMapperFactory.getDefaultMapper()), com/ebay/nautilus/domain/content/dm/CategoriesDataManager$SiteCategories, "categoryCache", 1, 1, 23L, 0x5265c00L, true);
            }
        }
        return;
        keyparams;
        ebaycontext;
        JVM INSTR monitorexit ;
        throw keyparams;
    }

    private static String getCacheKey(EbaySite ebaysite)
    {
        return TextUtils.join("-", new String[] {
            "ebayCategory", ebaysite.idString
        });
    }

    public void flush()
    {
        NautilusKernel.verifyNotMain();
        cacheManager.clear();
    }

    public Object getParams()
    {
        return params;
    }

    void handleLoadDataResult(LoadTask loadtask, Content content)
    {
        loadTask = null;
        if (content == null)
        {
            return;
        } else
        {
            _content = content;
            ((Observer)dispatcher).onCategoriesChanged(this, _content);
            return;
        }
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
    }

    public void loadData(Observer observer, EbayTradingApi ebaytradingapi)
    {
        NautilusKernel.verifyMain();
        if (ebaytradingapi != null && _content == null)
        {
            if (loadTask == null)
            {
                loadTask = new LoadTask(ebaytradingapi);
                executeOnThreadPool(loadTask, new KeyParams[] {
                    params
                });
            }
        } else
        if (observer != null)
        {
            observer.onCategoriesChanged(this, _content);
            return;
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }




}
