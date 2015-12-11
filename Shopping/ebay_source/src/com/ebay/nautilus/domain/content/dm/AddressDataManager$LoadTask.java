// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.net.api.addressbook.EbayAddressBookApi;
import com.ebay.nautilus.domain.net.api.addressbook.GetAddressesRequest;
import com.ebay.nautilus.domain.net.api.addressbook.GetAddressesResponse;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            AddressDataManager

private final class passiveUpdate extends AsyncTask
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
        Object obj = new GetAddressesRequest(new EbayAddressBookApi(country.site, auth.iafToken), false, (()getParams()).addressType);
        avoid = new ResultStatusOwner();
        obj = (GetAddressesResponse)AddressDataManager.access$200(AddressDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), avoid);
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
            Object obj2 = new GetAddressesRequest(new EbayAddressBookApi(country.site, auth.iafToken), true, (()getParams()).addressType);
            Object obj1 = new ResultStatusOwner();
            obj2 = (GetAddressesResponse)AddressDataManager.access$300(AddressDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj2)), ((ResultStatusOwner) (obj1)));
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
        AddressDataManager.access$500().put(AddressDataManager.access$400(AddressDataManager.this, auth), new llection(avoid));
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
        AddressDataManager.access$602(AddressDataManager.this, null);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    protected llection(boolean flag, Authentication authentication, EbayCountry ebaycountry)
    {
        this$0 = AddressDataManager.this;
        super();
        country = ebaycountry;
        auth = authentication;
        passiveUpdate = flag;
    }
}
