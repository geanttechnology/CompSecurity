// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.addressbook.EbayAddressBookApi;
import com.ebay.nautilus.domain.net.api.addressbook.SetPrimaryAddressRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            AddressDataManager

private final class <init> extends AsyncTask
{

    final AddressDataManager this$0;

    protected transient Content doInBackground(String as[])
    {
        String s = as[0];
        as = as[1];
        as = new SetPrimaryAddressRequest(new EbayAddressBookApi(AddressDataManager.access$700(AddressDataManager.this).site, AddressDataManager.access$800(AddressDataManager.this).iafToken), s, as);
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        AddressDataManager.access$1100(AddressDataManager.this, as, resultstatusowner);
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
        AddressDataManager.access$1200(AddressDataManager.this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    private ()
    {
        this$0 = AddressDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
