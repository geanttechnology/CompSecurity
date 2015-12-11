// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.CollectionDetail;
import com.ebay.nautilus.domain.net.api.collections.CollectionDetailsRequest;
import com.ebay.nautilus.domain.net.api.collections.CollectionDetailsResponse;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            CollectionDetailsDataManager

private final class limit extends AsyncTask
{

    private final Authentication auth;
    private final EbayCountry country;
    private final String iafToken;
    private final String limit;
    private final String offset;
    final CollectionDetailsDataManager this$0;

    protected transient Content doInBackground( a[])
    {
        String s;
        a = String.valueOf(a[0].collectionId);
        s = CollectionDetailsDataManager.access$000(a, limit, offset, auth, country);
        CollectionDetail collectiondetail;
        synchronized (CollectionDetailsDataManager.access$100())
        {
            collectiondetail = (CollectionDetail)CollectionDetailsDataManager.access$100().get(s);
        }
        if (collectiondetail != null)
        {
            return new Content(collectiondetail);
        }
        break MISSING_BLOCK_LABEL_71;
        a;
        cachemanager;
        JVM INSTR monitorexit ;
        throw a;
        obj = new ResultStatusOwner();
        a = new CollectionDetailsRequest(iafToken, country, a, limit, offset);
        try
        {
            a = (CollectionDetailsResponse)CollectionDetailsDataManager.access$200(CollectionDetailsDataManager.this, a);
        }
        // Misplaced declaration of an exception variable
        catch ( a[])
        {
            a = null;
        }
        if (a != null && ((CollectionDetailsResponse) (a)).collectionDetail != null)
        {
            CollectionDetail collectiondetail1 = ((CollectionDetailsResponse) (a)).collectionDetail;
            synchronized (CollectionDetailsDataManager.access$100())
            {
                CollectionDetailsDataManager.access$100().put(s, collectiondetail1);
            }
            return new Content(collectiondetail1, a.getResultStatus());
        } else
        {
            return new Content(((ResultStatusOwner) (obj)).getResultStatus());
        }
        a;
        obj;
        JVM INSTR monitorexit ;
        throw a;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground(([])aobj);
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

    public (String s, String s1)
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
