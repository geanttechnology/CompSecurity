// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.net.api.addressbook.AddAddressRequest;
import com.ebay.nautilus.domain.net.api.addressbook.AddAddressResponse;
import com.ebay.nautilus.domain.net.api.addressbook.EbayAddressBookApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            AddressDataManager

private final class addressType extends AsyncTask
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
            aaddress = new AddAddressRequest(new EbayAddressBookApi(AddressDataManager.access$700(AddressDataManager.this).site, AddressDataManager.access$800(AddressDataManager.this).iafToken), aaddress, validate);
        } else
        {
            aaddress = new AddAddressRequest(new EbayAddressBookApi(AddressDataManager.access$700(AddressDataManager.this).site, AddressDataManager.access$800(AddressDataManager.this).iafToken), aaddress, validate, addressType);
        }
        obj = new ResultStatusOwner();
        aaddress = (AddAddressResponse)AddressDataManager.access$1300(AddressDataManager.this, aaddress, ((ResultStatusOwner) (obj)));
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
        AddressDataManager.access$1400(AddressDataManager.this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (boolean flag, String s)
    {
        this$0 = AddressDataManager.this;
        super();
        validate = flag;
        addressType = s;
    }
}
