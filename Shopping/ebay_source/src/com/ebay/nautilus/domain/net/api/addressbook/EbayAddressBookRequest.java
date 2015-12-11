// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.addressbook:
//            EbayAddressBookApi

public abstract class EbayAddressBookRequest extends EbaySoaRequest
{

    protected EbayAddressBookRequest()
    {
    }

    public EbayAddressBookRequest(EbayAddressBookApi ebayaddressbookapi, String s)
    {
        super("AddressBookService", true, s);
        super.dataFormat = "JSON";
        super.soaContentType = "application/json";
        super.isConvertedToAlternateHttpFaultStatus = true;
        if (ebayaddressbookapi != null)
        {
            super.iafToken = ebayaddressbookapi.iafToken;
            super.soaGlobalId = ebayaddressbookapi.site.idString;
        }
    }

    protected String getErrorLanguage()
    {
        return null;
    }

    public final URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.addressBookServiceUrl);
    }
}
