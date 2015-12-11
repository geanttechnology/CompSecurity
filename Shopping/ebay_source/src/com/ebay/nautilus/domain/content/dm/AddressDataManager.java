// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.net.api.addressbook.AddAddressRequest;
import com.ebay.nautilus.domain.net.api.addressbook.AddAddressResponse;
import com.ebay.nautilus.domain.net.api.addressbook.AddressResponseData;
import com.ebay.nautilus.domain.net.api.addressbook.DeleteAddressRequest;
import com.ebay.nautilus.domain.net.api.addressbook.EbayAddressBookApi;
import com.ebay.nautilus.domain.net.api.addressbook.GetAddressesRequest;
import com.ebay.nautilus.domain.net.api.addressbook.GetAddressesResponse;
import com.ebay.nautilus.domain.net.api.addressbook.SetPrimaryAddressRequest;
import com.ebay.nautilus.domain.net.api.addressbook.UpdateAddressRequest;
import com.ebay.nautilus.domain.net.api.addressbook.UpdateAddressResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.GsonBuilder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager

public final class AddressDataManager extends UserContextObservingDataManager
{
    private final class AddAddressTask extends AsyncTask
    {

        private final String addressType;
        final AddressDataManager this$0;
        private final boolean validate;

        protected transient Content doInBackground(Address aaddress[])
        {
            aaddress = aaddress[0];
            Object obj;
            if (addressType == null)
            {
                aaddress = new AddAddressRequest(new EbayAddressBookApi(country.site, auth.iafToken), aaddress, validate);
            } else
            {
                aaddress = new AddAddressRequest(new EbayAddressBookApi(country.site, auth.iafToken), aaddress, validate, addressType);
            }
            obj = new ResultStatusOwner();
            aaddress = (AddAddressResponse)safeSendRequest(aaddress, ((ResultStatusOwner) (obj)));
            obj = ((ResultStatusOwner) (obj)).getResultStatus();
            if (obj == ResultStatus.CANCELED)
            {
                return null;
            } else
            {
                return new Content(aaddress.getResponseData(), ((ResultStatus) (obj)));
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Address[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleUpdateAddressResult(content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public AddAddressTask(boolean flag, String s)
        {
            this$0 = AddressDataManager.this;
            super();
            validate = flag;
            addressType = s;
        }
    }

    private static final class AddressCollection extends BaseDataMapped
    {

        public List content;
        public long ttl;

        public boolean isStale()
        {
            return System.currentTimeMillis() > ttl;
        }

        public AddressCollection()
        {
            content = null;
        }

        public AddressCollection(Content content1)
        {
            content = null;
            content = (List)content1.getData();
            ttl = System.currentTimeMillis() + 0x5265c00L;
            if (Log.isLoggable("AddressDataManagerTtl", 3))
            {
                ttl = System.currentTimeMillis() + 0x927c0L;
                AddressDataManager.logger.log("overriding TTL to ten minutes");
            }
        }
    }

    public class ConsultCacheTask extends AsyncTask
    {

        private final Authentication auth;
        private final EbayCountry country;
        final AddressDataManager this$0;

        protected transient AddressCollection doInBackground(Void avoid[])
        {
            avoid = null;
            String s = getCacheKey(auth);
            if (s != null)
            {
                if (AddressDataManager.logger.isLoggable)
                {
                    AddressDataManager.logger.log((new StringBuilder()).append("cache lookup ").append(s).toString());
                }
                avoid = (AddressCollection)AddressDataManager.cacheManager.get(s);
            } else
            if (AddressDataManager.logger.isLoggable)
            {
                AddressDataManager.logger.log("lookup aborted, invalid key");
                return null;
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(AddressCollection addresscollection)
        {
            super.onPostExecute(addresscollection);
            if (addresscollection != null && flushCacheTask == null) goto _L2; else goto _L1
_L1:
            if (AddressDataManager.logger.isLoggable)
            {
                AddressDataManager.logger.log("cache miss, forcing update");
            }
            if (loadTask == null)
            {
                getAddressesAsync(auth, country, false);
            } else
            if (AddressDataManager.logger.isLoggable)
            {
                AddressDataManager.logger.log("aborting update, already in progress");
            }
_L4:
            consultCacheTask = null;
            return;
_L2:
            if (!addresscollection.isStale())
            {
                break; /* Loop/switch isn't completed */
            }
            if (AddressDataManager.logger.isLoggable)
            {
                AddressDataManager.logger.log("cache hit but entry is stale, forcing update");
            }
            if (loadTask == null)
            {
                getAddressesAsync(auth, country, true);
            } else
            if (AddressDataManager.logger.isLoggable)
            {
                AddressDataManager.logger.log("aborting update, already in progress");
            }
_L6:
            handleLoadDataResult(new Content(addresscollection.content), false, false);
            if (true) goto _L4; else goto _L3
_L3:
            if (!AddressDataManager.logger.isLoggable) goto _L6; else goto _L5
_L5:
            AddressDataManager.logger.log("cache hit");
              goto _L6
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((AddressCollection)obj);
        }

        protected ConsultCacheTask(Authentication authentication, EbayCountry ebaycountry)
        {
            this$0 = AddressDataManager.this;
            super();
            auth = authentication;
            country = ebaycountry;
        }
    }

    private final class DeleteAddressTask extends AsyncTask
    {

        final AddressDataManager this$0;

        protected transient Content doInBackground(String as[])
        {
            as = as[0];
            as = new DeleteAddressRequest(new EbayAddressBookApi(country.site, auth.iafToken), as);
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
            handleDeleteAddressResult(content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        private DeleteAddressTask()
        {
            this$0 = AddressDataManager.this;
            super();
        }

    }

    public class FlushCacheTask extends AsyncTask
    {

        final AddressDataManager this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            AddressDataManager.cacheManager.clear();
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            flushCacheTask = null;
        }

        public FlushCacheTask()
        {
            this$0 = AddressDataManager.this;
            super();
        }
    }

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
        public final String addressType;

        protected AddressDataManager create(EbayContext ebaycontext)
        {
            return new AddressDataManager(ebaycontext, this);
        }

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj == null || obj.getClass() != getClass())
            {
                return false;
            } else
            {
                obj = (KeyParams)obj;
                return addressType.equals(((KeyParams) (obj)).addressType);
            }
        }

        public int hashCode()
        {
            int j = super.hashCode();
            int i;
            if (addressType == null)
            {
                i = 0;
            } else
            {
                i = addressType.hashCode();
            }
            return j * 31 + i;
        }

        public String toString()
        {
            return (new StringBuilder()).append("AddressDMKeyParams [addressType=").append(addressType).append("]").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(addressType);
        }


        public KeyParams(String s)
        {
            addressType = s;
        }
    }

    private final class LoadTask extends AsyncTask
    {

        private final Authentication auth;
        private final EbayCountry country;
        private final boolean passiveUpdate;
        final AddressDataManager this$0;

        private boolean containsDefaultAddress(List list)
        {
label0:
            {
                if (list == null)
                {
                    break label0;
                }
                list = list.iterator();
                do
                {
                    if (!list.hasNext())
                    {
                        break label0;
                    }
                } while (!((Address)list.next()).isDefault());
                return true;
            }
            return false;
        }

        protected transient Content doInBackground(Void avoid[])
        {
            if (country == null || auth == null)
            {
                return new Content(null, ResultStatus.SUCCESS);
            }
            Object obj = new GetAddressesRequest(new EbayAddressBookApi(country.site, auth.iafToken), false, ((KeyParams)getParams()).addressType);
            avoid = new ResultStatusOwner();
            obj = (GetAddressesResponse)safeSendRequest(((Request) (obj)), avoid);
            avoid = avoid.getResultStatus();
            if (avoid == ResultStatus.CANCELED)
            {
                return null;
            }
            if (avoid.hasError())
            {
                return new Content(avoid);
            }
            obj = ((GetAddressesResponse) (obj)).getAddresses();
            if (!containsDefaultAddress(((List) (obj))))
            {
                Object obj2 = new GetAddressesRequest(new EbayAddressBookApi(country.site, auth.iafToken), true, ((KeyParams)getParams()).addressType);
                Object obj1 = new ResultStatusOwner();
                obj2 = (GetAddressesResponse)safeSendRequest(((Request) (obj2)), ((ResultStatusOwner) (obj1)));
                obj1 = ((ResultStatusOwner) (obj1)).getResultStatus();
                if (obj1 == ResultStatus.CANCELED)
                {
                    return null;
                }
                if (((ResultStatus) (obj1)).hasError())
                {
                    return new Content(((ResultStatus) (obj1)));
                }
                obj1 = ((GetAddressesResponse) (obj2)).getAddresses();
                if (obj1 != null)
                {
                    for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add((Address)((Iterator) (obj1)).next())) { }
                }
            }
            avoid = new Content(obj, avoid);
            AddressDataManager.cacheManager.put(getCacheKey(auth), new AddressCollection(avoid));
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleLoadDataResult(content, passiveUpdate, true);
            loadTask = null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        protected LoadTask(boolean flag, Authentication authentication, EbayCountry ebaycountry)
        {
            this$0 = AddressDataManager.this;
            super();
            country = ebaycountry;
            auth = authentication;
            passiveUpdate = flag;
        }
    }

    public static interface Observer
    {

        public abstract void onAddressDeleted(AddressDataManager addressdatamanager, Content content);

        public abstract void onAddressPrimary(AddressDataManager addressdatamanager, Content content);

        public abstract void onAddressUpdated(AddressDataManager addressdatamanager, Content content);

        public abstract void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag);
    }

    private final class SetPrimaryAddressTask extends AsyncTask
    {

        final AddressDataManager this$0;

        protected transient Content doInBackground(String as[])
        {
            String s = as[0];
            as = as[1];
            as = new SetPrimaryAddressRequest(new EbayAddressBookApi(country.site, auth.iafToken), s, as);
            ResultStatusOwner resultstatusowner = new ResultStatusOwner();
            safeSendRequest(as, resultstatusowner);
            as = resultstatusowner.getResultStatus();
            if (as == ResultStatus.CANCELED)
            {
                return null;
            } else
            {
                return new Content(s, as);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleSetPrimaryAddressResult(content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        private SetPrimaryAddressTask()
        {
            this$0 = AddressDataManager.this;
            super();
        }

    }

    public static class SimpleObserver
        implements Observer
    {

        public void onAddressDeleted(AddressDataManager addressdatamanager, Content content)
        {
        }

        public void onAddressPrimary(AddressDataManager addressdatamanager, Content content)
        {
        }

        public void onAddressUpdated(AddressDataManager addressdatamanager, Content content)
        {
        }

        public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
        {
        }

        public SimpleObserver()
        {
        }
    }

    private final class UpdateAddressTask extends AsyncTask
    {

        final AddressDataManager this$0;
        private final boolean validate;

        protected transient Content doInBackground(Address aaddress[])
        {
            aaddress = aaddress[0];
            Object obj = new UpdateAddressRequest(new EbayAddressBookApi(country.site, auth.iafToken), aaddress, validate);
            aaddress = new ResultStatusOwner();
            obj = (UpdateAddressResponse)safeSendRequest(((Request) (obj)), aaddress);
            aaddress = aaddress.getResultStatus();
            if (aaddress == ResultStatus.CANCELED)
            {
                return null;
            } else
            {
                return new Content(((UpdateAddressResponse) (obj)).getResponseData(), aaddress);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Address[])aobj);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleUpdateAddressResult(content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public UpdateAddressTask(boolean flag)
        {
            this$0 = AddressDataManager.this;
            super();
            validate = flag;
        }
    }


    public static final String CACHE_KEY = "addresses";
    public static final long MAX_CACHE_TTL = 0x3ffffffffffffffeL;
    public static final long STALE_TTL = 0x5265c00L;
    private static CacheManager cacheManager;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("AddressDataManager", 3, "Log address data manager");
    private Authentication auth;
    private ConsultCacheTask consultCacheTask;
    private EbayCountry country;
    private FlushCacheTask flushCacheTask;
    private LoadTask loadTask;

    AddressDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/AddressDataManager$Observer, keyparams);
        loadTask = null;
        consultCacheTask = null;
        flushCacheTask = null;
        if (cacheManager == null)
        {
            ebaycontext = (new GsonBuilder()).registerTypeAdapter(java/util/Date, new EbayDateAdapter()).create();
            cacheManager = new CacheManager(getContext(), JsonPersistenceMapper.create(ebaycontext), com/ebay/nautilus/domain/content/dm/AddressDataManager$AddressCollection, "addressBookCache", 1, 1, 1L, 0x3ffffffffffffffeL, true);
        }
    }

    private void cancelTasks(boolean flag)
    {
        if (consultCacheTask != null)
        {
            consultCacheTask.cancel(true);
            consultCacheTask = null;
        }
        if (loadTask != null)
        {
            loadTask.cancel(true);
            loadTask = null;
        }
        if (!flag && flushCacheTask != null)
        {
            flushCacheTask.cancel(true);
            flushCacheTask = null;
        }
    }

    private String getCacheKey(Authentication authentication)
    {
        String s = null;
        if (authentication != null)
        {
            s = (new StringBuilder()).append("addresses-").append(authentication.user).append("-").append(((KeyParams)getParams()).addressType).toString();
        }
        return s;
    }

    private void handleDeleteAddressResult(Content content)
    {
        if (content == null)
        {
            return;
        } else
        {
            ((Observer)dispatcher).onAddressDeleted(this, content);
            return;
        }
    }

    private void handleSetPrimaryAddressResult(Content content)
    {
        if (content == null)
        {
            return;
        } else
        {
            ((Observer)dispatcher).onAddressPrimary(this, content);
            return;
        }
    }

    private void handleUpdateAddressResult(Content content)
    {
        Content content1;
label0:
        {
            if (content == null)
            {
                return;
            }
            Object obj = content.getStatus();
            AddressResponseData addressresponsedata = (AddressResponseData)content.getData();
            content1 = content;
            if (!((ResultStatus) (obj)).hasError())
            {
                break label0;
            }
            content1 = content;
            if (addressresponsedata == null)
            {
                break label0;
            }
            content1 = content;
            if (!addressresponsedata.addressModified)
            {
                break label0;
            }
            obj = ((ResultStatus) (obj)).getMessages();
            content1 = content;
            if (obj == null)
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            do
            {
                content1 = content;
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!"ADDR_RECORD_ALREADY_EXISTS".equals(((com.ebay.nautilus.kernel.content.ResultStatus.Message)((Iterator) (obj)).next()).getShortMessage(getEbayContext())));
            content1 = new Content(addressresponsedata, ResultStatus.SUCCESS);
        }
        ((Observer)dispatcher).onAddressUpdated(this, content1);
    }

    public void addAddress(Address address, boolean flag)
    {
        NautilusKernel.verifyMain();
        executeOnThreadPool(new AddAddressTask(flag, ((KeyParams)getParams()).addressType), new Address[] {
            address
        });
    }

    public void addAddress(Address address, boolean flag, String s)
    {
        NautilusKernel.verifyMain();
        executeOnThreadPool(new AddAddressTask(flag, s), new Address[] {
            address
        });
    }

    public void deleteAddress(String s)
    {
        NautilusKernel.verifyMain();
        executeOnThreadPool(new DeleteAddressTask(), new String[] {
            s
        });
    }

    public void flush()
    {
        NautilusKernel.verifyMain();
        cancelTasks(true);
        if (flushCacheTask == null)
        {
            FlushCacheTask flushcachetask = new FlushCacheTask();
            flushCacheTask = flushcachetask;
            executeOnThreadPool(flushcachetask, new Void[0]);
            if (logger.isLoggable)
            {
                logger.log("flushing cache");
            }
        }
    }

    public void forceReloadData()
    {
        NautilusKernel.verifyMain();
        flush();
        loadData(((Observer) (null)));
        if (logger.isLoggable)
        {
            logger.log("force reload data");
        }
    }

    protected void getAddressesAsync(Authentication authentication, EbayCountry ebaycountry, boolean flag)
    {
        NautilusKernel.verifyMain();
        if (loadTask == null)
        {
            authentication = new LoadTask(flag, authentication, ebaycountry);
            loadTask = authentication;
            executeOnThreadPool(authentication, new Void[0]);
        }
    }

    void handleLoadDataResult(Content content, boolean flag, boolean flag1)
    {
        while (content == null || flag) 
        {
            return;
        }
        ((Observer)dispatcher).onAddressesChanged(this, content, flag1);
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
        if (auth == null)
        {
            observer = (Observer)getSafeCallback(observer);
            if (observer != null)
            {
                observer.onAddressesChanged(this, new Content(null, ResultStatus.SUCCESS), false);
            }
        } else
        if (consultCacheTask == null)
        {
            observer = new ConsultCacheTask(auth, country);
            consultCacheTask = observer;
            executeOnThreadPool(observer, new Void[0]);
            return;
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        country = ebaycountry;
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            auth = new Authentication(s, s1);
            loadData(((Observer) (null)));
            return;
        } else
        {
            auth = null;
            return;
        }
    }

    protected void onLastObserverUnregistered()
    {
        cancelTasks(false);
    }

    public void setPrimaryAddress(String s)
    {
        NautilusKernel.verifyMain();
        executeOnThreadPool(new SetPrimaryAddressTask(), new String[] {
            s, ((KeyParams)getParams()).addressType
        });
    }

    public void updateAddress(Address address, boolean flag)
    {
        NautilusKernel.verifyMain();
        executeOnThreadPool(new UpdateAddressTask(flag), new Address[] {
            address
        });
    }










/*
    static FlushCacheTask access$1602(AddressDataManager addressdatamanager, FlushCacheTask flushcachetask)
    {
        addressdatamanager.flushCacheTask = flushcachetask;
        return flushcachetask;
    }

*/


/*
    static ConsultCacheTask access$1702(AddressDataManager addressdatamanager, ConsultCacheTask consultcachetask)
    {
        addressdatamanager.consultCacheTask = consultcachetask;
        return consultcachetask;
    }

*/







/*
    static LoadTask access$602(AddressDataManager addressdatamanager, LoadTask loadtask)
    {
        addressdatamanager.loadTask = loadtask;
        return loadtask;
    }

*/



}
