// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.common.model.local.Availability;
import com.ebay.common.model.local.AvailabilityIdentifier;
import com.ebay.nautilus.domain.EbayCountry;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.common.net.api.local:
//            EbayNowInventoryLookupRequest, EbayNowInventoryLookupResponse

public class EbayNowInventoryLookupDataManager extends UserContextObservingDataManager
{
    public static final class KeyParams extends com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return EbayNowInventoryLookupDataManager.KEY;
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

        protected EbayNowInventoryLookupDataManager create(EbayContext ebaycontext)
        {
            return new EbayNowInventoryLookupDataManager(ebaycontext, this);
        }

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            return obj != null && obj.getClass() == getClass();
        }


        public KeyParams()
        {
        }
    }

    final class LoadTask extends AsyncTask
    {

        final EbayNowInventoryLookupDataManager this$0;

        protected transient Content doInBackground(AvailabilityIdentifier aavailabilityidentifier[])
        {
            if (EbayNowInventoryLookupDataManager.logger.isLoggable)
            {
                EbayNowInventoryLookupDataManager.logger.log("load task");
            }
            if (EbayNowInventoryLookupDataManager.logger.isLoggable)
            {
                EbayNowInventoryLookupDataManager.logger.log((new StringBuilder()).append("load task: params=").append(Arrays.asList(aavailabilityidentifier)).toString());
            }
            Object obj = new EbayNowInventoryLookupRequest(aavailabilityidentifier);
            aavailabilityidentifier = new ResultStatusOwner();
            obj = (EbayNowInventoryLookupResponse)safeSendRequest(((Request) (obj)), aavailabilityidentifier);
            aavailabilityidentifier = aavailabilityidentifier.getResultStatus();
            if (aavailabilityidentifier == ResultStatus.CANCELED)
            {
                return null;
            }
            if (aavailabilityidentifier.hasError())
            {
                return new Content(aavailabilityidentifier);
            } else
            {
                return new Content(((EbayNowInventoryLookupResponse) (obj)).getResult(), aavailabilityidentifier);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((AvailabilityIdentifier[])aobj);
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

        LoadTask()
        {
            this$0 = EbayNowInventoryLookupDataManager.this;
            super();
        }
    }

    public static interface Observer
    {

        public abstract void onInventoryLookupComplete(EbayNowInventoryLookupDataManager ebaynowinventorylookupdatamanager, ResultStatus resultstatus);
    }


    public static final KeyParams KEY = new KeyParams();
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("EBNInventoryDataManager", 3, "EBN inventory lookup data manager logger");
    private final Map cache = new HashMap();
    private EbayCountry country;
    private String userId;

    EbayNowInventoryLookupDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/common/net/api/local/EbayNowInventoryLookupDataManager$Observer, keyparams);
        if (logger.isLoggable)
        {
            logger.log("constructed new instance");
        }
    }

    private void handleLoadResult(LoadTask loadtask, Content content)
    {
        if (logger.isLoggable)
        {
            logger.log("handle load result");
        }
        if (content != null)
        {
            if (logger.isLoggable)
            {
                logger.log((new StringBuilder()).append("handle load result: status=").append(content.getStatus()).append(" data=").append(content.getData()).toString());
            }
            if (content.getStatus().hasError())
            {
                if (logger.isLoggable)
                {
                    logger.log("handle load result: error, terminated");
                }
            } else
            {
                loadtask = ((EbayNowInventoryLookupResponse.Availabilities)content.getData()).availabilities.iterator();
                while (loadtask.hasNext()) 
                {
                    Availability availability = (Availability)loadtask.next();
                    AvailabilityIdentifier availabilityidentifier = new AvailabilityIdentifier(availability.countryCode, availability.postalCode, availability.sellerID, availability.sku);
                    cache.put(availabilityidentifier, availability);
                }
            }
            ((Observer)dispatcher).onInventoryLookupComplete(this, content.getStatus());
        } else
        if (logger.isLoggable)
        {
            logger.log("handle load result: null result, terminated");
            return;
        }
    }

    public Availability checkAvailability(AvailabilityIdentifier availabilityidentifier)
    {
        return (Availability)cache.get(availabilityidentifier);
    }

    public Availability checkAvailability(String s, String s1, String s2, String s3)
    {
        return checkAvailability(new AvailabilityIdentifier(s, s1, s2, s3));
    }

    public void clearData()
    {
        cache.clear();
    }

    public void forceReloadData()
    {
        if (logger.isLoggable)
        {
            logger.log("force reload data");
        }
        NautilusKernel.verifyMain();
        int i = cache.size();
        if (i > 0)
        {
            AvailabilityIdentifier aavailabilityidentifier[] = (AvailabilityIdentifier[])cache.keySet().toArray(new AvailabilityIdentifier[i]);
            cache.clear();
            executeOnThreadPool(new LoadTask(), aavailabilityidentifier);
            return;
        }
        if (logger.isLoggable)
        {
            logger.log("force reload data: no availabilities, ignored");
        }
        ((Observer)dispatcher).onInventoryLookupComplete(this, ResultStatus.SUCCESS);
    }

    public void getAvailability(String s, String s1, String s2, String s3)
    {
        getAvailability(s, s1, s2, s3, 1);
    }

    public void getAvailability(String s, String s1, String s2, String s3, int i)
    {
        getAvailability(new AvailabilityIdentifier[] {
            new AvailabilityIdentifier(s, s1, s2, s3, i)
        });
    }

    public void getAvailability(Set set)
    {
        getAvailability((AvailabilityIdentifier[])set.toArray(new AvailabilityIdentifier[set.size()]));
    }

    public transient void getAvailability(AvailabilityIdentifier aavailabilityidentifier[])
    {
        NautilusKernel.verifyMain();
        if (aavailabilityidentifier == null || aavailabilityidentifier.length == 0)
        {
            throw new IllegalArgumentException("invalid input");
        }
        boolean flag1 = true;
        int j = aavailabilityidentifier.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    AvailabilityIdentifier availabilityidentifier = aavailabilityidentifier[i];
                    if (cache.containsKey(availabilityidentifier))
                    {
                        break label0;
                    }
                    flag = false;
                }
                if (logger.isLoggable)
                {
                    logger.log((new StringBuilder()).append("getAvailability: availability is cached? ").append(flag).toString());
                }
                if (flag)
                {
                    ((Observer)dispatcher).onInventoryLookupComplete(this, ResultStatus.SUCCESS);
                    return;
                } else
                {
                    executeOnThreadPool(new LoadTask(), aavailabilityidentifier);
                    return;
                }
            }
            i++;
        } while (true);
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        if (logger.isLoggable)
        {
            logger.log("on current country changed");
        }
        if (country == null)
        {
            country = ebaycountry;
        } else
        if (!country.equals(ebaycountry))
        {
            if (logger.isLoggable)
            {
                logger.log("country changed, clearing cache");
            }
            cache.clear();
            return;
        }
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        if (logger.isLoggable)
        {
            logger.log("on current user changed");
        }
        if (userId == null)
        {
            userId = s;
        } else
        if (!userId.equals(s))
        {
            if (logger.isLoggable)
            {
                logger.log("user changed, clearing cache");
            }
            cache.clear();
            return;
        }
    }



}
