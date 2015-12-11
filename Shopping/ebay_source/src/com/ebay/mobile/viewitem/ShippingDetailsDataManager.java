// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.common.model.EbayDetail;
import com.ebay.common.net.api.trading.GetEbayDetailsRequest;
import com.ebay.common.net.api.trading.GetEbayDetailsResponse;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShippingDetailsDataManager extends DataManager
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

        public ShippingDetailsDataManager createManager(EbayContext ebaycontext)
        {
            ebaycontext = new ShippingDetailsDataManager(ebaycontext, this);
            ebaycontext.create();
            return ebaycontext;
        }

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (obj == null || obj.getClass() != getClass())
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
            if (ShippingDetailsDataManager.logTag.isLoggable)
            {
                ShippingDetailsDataManager.logTag.log((new StringBuilder()).append("KeyParams: site=").append(ebaysite).toString());
            }
            site = ebaysite;
        }
    }

    private final class LoadTask extends AsyncTask
    {

        private final EbayTradingApi api;
        private ArrayList details;
        final ShippingDetailsDataManager this$0;

        protected transient Content doInBackground(KeyParams akeyparams[])
        {
            Object obj2 = null;
            Object obj1 = null;
            if (akeyparams[0].site != null)
            {
                obj1 = (EbayDetail)ShippingDetailsDataManager.cacheManager.get(ShippingDetailsDataManager.getCacheKey(akeyparams[0].site));
            }
            ResultStatusOwner resultstatusowner = new ResultStatusOwner();
            Object obj;
            Content content;
            if (obj1 == null)
            {
                if (ShippingDetailsDataManager.logTag.isLoggable)
                {
                    ShippingDetailsDataManager.logTag.log((new StringBuilder()).append("cache miss on site ").append(akeyparams[0].site).toString());
                }
                obj = new GetEbayDetailsRequest(api, details);
                GetEbayDetailsResponse getebaydetailsresponse = (GetEbayDetailsResponse)safeSendRequest(((Request) (obj)), resultstatusowner);
                obj = obj1;
                content = obj2;
                if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
                {
                    if (!resultstatusowner.getResultStatus().hasError())
                    {
                        obj1 = getebaydetailsresponse.detail;
                        if (ShippingDetailsDataManager.logTag.isLoggable)
                        {
                            ShippingDetailsDataManager.logTag.log((new StringBuilder()).append("caching site ").append(akeyparams[0].site).toString());
                        }
                        obj = obj1;
                        content = obj2;
                        if (akeyparams[0].site != null)
                        {
                            ShippingDetailsDataManager.cacheManager.put(ShippingDetailsDataManager.getCacheKey(akeyparams[0].site), obj1);
                            content = obj2;
                            obj = obj1;
                        }
                    } else
                    {
                        content = new Content(null, resultstatusowner.getResultStatus());
                        obj = null;
                    }
                }
            } else
            {
                obj = obj1;
                content = obj2;
                if (ShippingDetailsDataManager.logTag.isLoggable)
                {
                    ShippingDetailsDataManager.logTag.log((new StringBuilder()).append("cache hit on site ").append(akeyparams[0].site).toString());
                    obj = obj1;
                    content = obj2;
                }
            }
            if (obj != null)
            {
                akeyparams = new HashMap();
                if (((EbayDetail) (obj)).shippingServiceDetails != null)
                {
                    for (obj = ((EbayDetail) (obj)).shippingServiceDetails.iterator(); ((Iterator) (obj)).hasNext(); akeyparams.put(((com.ebay.common.model.EbayDetail.ShippingServiceDetail) (obj1)).shippingService, obj1))
                    {
                        obj1 = (com.ebay.common.model.EbayDetail.ShippingServiceDetail)((Iterator) (obj)).next();
                    }

                }
                content = new Content(akeyparams, resultstatusowner.getResultStatus());
            }
            return content;
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

        public LoadTask(EbayTradingApi ebaytradingapi, ArrayList arraylist)
        {
            this$0 = ShippingDetailsDataManager.this;
            super();
            details = new ArrayList();
            api = ebaytradingapi;
            details = arraylist;
        }
    }

    public static interface Observer
    {

        public abstract void onShippingDetailsChanged(ShippingDetailsDataManager shippingdetailsdatamanager, Content content);
    }


    private static final long MAX_CACHE_TTL = 0x5265c00L;
    private static volatile CacheManager cacheManager;
    private static final Object configLock = new Object();
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ShippingDetailsDM", 4, "Log ShippingDetailsDataManager");
    private Content _content;
    private LoadTask loadTask;
    private final KeyParams params;

    ShippingDetailsDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/mobile/viewitem/ShippingDetailsDataManager$Observer);
        _content = null;
        params = keyparams;
        synchronized (configLock)
        {
            if (cacheManager == null)
            {
                cacheManager = new CacheManager((Context)ebaycontext.getExtension(android/content/Context), JsonPersistenceMapper.create(DataMapperFactory.getDefaultMapper()), com/ebay/common/model/EbayDetail, "ebayDetailsCache", 1, 1, 23L, 0x5265c00L, true);
            }
        }
        return;
        ebaycontext;
        keyparams;
        JVM INSTR monitorexit ;
        throw ebaycontext;
    }

    private static String getCacheKey(EbaySite ebaysite)
    {
        return TextUtils.join("-", new String[] {
            "ebayDetails", ebaysite.idString
        });
    }

    public void create()
    {
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
            ((Observer)dispatcher).onShippingDetailsChanged(this, _content);
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
        if (_content == null)
        {
            if (loadTask == null)
            {
                observer = new ArrayList();
                observer.add("ShippingCarrierDetails");
                observer.add("ShippingServiceDetails");
                loadTask = new LoadTask(ebaytradingapi, observer);
                executeOnThreadPool(loadTask, new KeyParams[] {
                    params
                });
            }
            return;
        } else
        {
            ((Observer)dispatcher).onShippingDetailsChanged(this, _content);
            return;
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }




}
