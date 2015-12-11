// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.ums.GetMetadataRequest;
import com.ebay.nautilus.domain.net.api.ums.GetMetadataResponse;
import com.ebay.nautilus.domain.net.api.ums.Metadata;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ListingCategoryInfoManager

private final class categoryId extends AsyncTask
{

    private final String categoryId;
    private final EbaySite site;
    final ListingCategoryInfoManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        try
        {
            avoid = (GetMetadataResponse)ListingCategoryInfoManager.access$000(ListingCategoryInfoManager.this, new GetMetadataRequest(site, categoryId));
            ResultStatus resultstatus = avoid.getResultStatus();
            if (resultstatus.hasError())
            {
                return new Content(resultstatus);
            }
            avoid = new Content(Metadata.convertMetadataToSpecifics(((GetMetadataResponse) (avoid)).metadata), resultstatus);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return null;
        }
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        tegoryInfo tegoryinfo = ListingCategoryInfoManager.access$100(ListingCategoryInfoManager.this);
        tegoryinfo;
        JVM INSTR monitorenter ;
        if (ListingCategoryInfoManager.access$200(ListingCategoryInfoManager.this) == this)
        {
            ListingCategoryInfoManager.access$202(ListingCategoryInfoManager.this, null);
        }
        if (content != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        tegoryinfo;
        JVM INSTR monitorexit ;
        return;
        if (!content.getStatus().hasError())
        {
            ListingCategoryInfoManager.access$100(ListingCategoryInfoManager.this).content = content;
        }
        ((tegoryInfo.content)ListingCategoryInfoManager.access$300(ListingCategoryInfoManager.this)).onItemSpecificsChanged(content);
        tegoryinfo;
        JVM INSTR monitorexit ;
        return;
        content;
        tegoryinfo;
        JVM INSTR monitorexit ;
        throw content;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public tegoryInfo(EbaySite ebaysite, String s)
    {
        this$0 = ListingCategoryInfoManager.this;
        super();
        site = ebaysite;
        categoryId = s;
    }
}
