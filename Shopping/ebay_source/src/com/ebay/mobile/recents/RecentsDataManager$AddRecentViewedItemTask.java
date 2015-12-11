// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.recents;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.PdsViewItemAttribute;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.pds.PdsSetAttrRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.recents:
//            RecentsDataManager

private final class categoryId extends categoryId
{

    final long categoryId;
    final long itemId;
    final RecentsDataManager this$0;

    protected volatile EbayRequest getRequest()
    {
        return getRequest();
    }

    protected PdsSetAttrRequest getRequest()
    {
        PdsViewItemAttribute pdsviewitemattribute = new PdsViewItemAttribute(itemId, categoryId, site.id);
        return new PdsSetAttrRequest(iafToken, cguid, site.idString, "10297", pdsviewitemattribute.toString());
    }

    protected void onCancelled(ResultStatus resultstatus)
    {
        super.elled(resultstatus);
        RecentsDataManager.access$300(RecentsDataManager.this, this, null);
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((ResultStatus)obj);
    }

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.Execute(resultstatus);
        RecentsDataManager.access$300(RecentsDataManager.this, this, resultstatus);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    (long l, long l1)
    {
        this$0 = RecentsDataManager.this;
        super(RecentsDataManager.this, RecentsDataManager.access$200(RecentsDataManager.this).);
        itemId = l;
        categoryId = l1;
    }
}
