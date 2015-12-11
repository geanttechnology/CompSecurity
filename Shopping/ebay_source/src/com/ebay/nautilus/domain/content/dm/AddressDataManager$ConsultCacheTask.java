// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            AddressDataManager

public class country extends AsyncTask
{

    private final Authentication auth;
    private final EbayCountry country;
    final AddressDataManager this$0;

    protected transient  doInBackground(Void avoid[])
    {
        avoid = null;
        String s = AddressDataManager.access$400(AddressDataManager.this, auth);
        if (s != null)
        {
            if (AddressDataManager.logger.auth)
            {
                AddressDataManager.logger.auth((new StringBuilder()).append("cache lookup ").append(s).toString());
            }
            avoid = ()AddressDataManager.access$500().get(s);
        } else
        if (AddressDataManager.logger.ection)
        {
            AddressDataManager.logger.ection("lookup aborted, invalid key");
            return null;
        }
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute( )
    {
        super.onPostExecute();
        if ( != null && AddressDataManager.access$1600(AddressDataManager.this) == null) goto _L2; else goto _L1
_L1:
        if (AddressDataManager.logger._fld0)
        {
            AddressDataManager.logger._mth0("cache miss, forcing update");
        }
        if (AddressDataManager.access$600(AddressDataManager.this) == null)
        {
            getAddressesAsync(auth, country, false);
        } else
        if (AddressDataManager.logger.country)
        {
            AddressDataManager.logger.country("aborting update, already in progress");
        }
_L4:
        AddressDataManager.access$1702(AddressDataManager.this, null);
        return;
_L2:
        if (!.isStale())
        {
            break; /* Loop/switch isn't completed */
        }
        if (AddressDataManager.logger.isStale)
        {
            AddressDataManager.logger.isStale("cache hit but entry is stale, forcing update");
        }
        if (AddressDataManager.access$600(AddressDataManager.this) == null)
        {
            getAddressesAsync(auth, country, true);
        } else
        if (AddressDataManager.logger.country)
        {
            AddressDataManager.logger.country("aborting update, already in progress");
        }
_L6:
        handleLoadDataResult(new Content(.content), false, false);
        if (true) goto _L4; else goto _L3
_L3:
        if (!AddressDataManager.logger.content) goto _L6; else goto _L5
_L5:
        AddressDataManager.logger.content("cache hit");
          goto _L6
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute(()obj);
    }

    protected (Authentication authentication, EbayCountry ebaycountry)
    {
        this$0 = AddressDataManager.this;
        super();
        auth = authentication;
        country = ebaycountry;
    }
}
