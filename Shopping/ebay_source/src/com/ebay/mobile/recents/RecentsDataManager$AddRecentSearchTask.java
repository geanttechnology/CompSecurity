// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.recents;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.PdsSearchItemAttribute;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.pds.PdsSetAttrRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.mobile.recents:
//            RecentsDataManager

private final class productPrefix extends productPrefix
{

    final long categoryId;
    final boolean isSellerPrefix;
    final boolean isSpelledCorrectly;
    final String keyword;
    final List list = null;
    final String productPrefix;
    final int searchResultCount;
    final RecentsDataManager this$0;

    protected volatile EbayRequest getRequest()
    {
        return getRequest();
    }

    protected PdsSetAttrRequest getRequest()
    {
        PdsSearchItemAttribute pdssearchitemattribute = new PdsSearchItemAttribute(keyword, categoryId, searchResultCount, isSpelledCorrectly, isSellerPrefix, productPrefix);
        return new PdsSetAttrRequest(iafToken, cguid, site.idString, "10203", pdssearchitemattribute.toString());
    }

    protected void onCancelled(ResultStatus resultstatus)
    {
        super.Cancelled(resultstatus);
        RecentsDataManager.access$500(RecentsDataManager.this, this, null);
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((ResultStatus)obj);
    }

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.PostExecute(resultstatus);
        RecentsDataManager.access$500(RecentsDataManager.this, this, resultstatus);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    (String s, boolean flag, long l, int i, boolean flag1, 
            String s1)
    {
        Object obj = null;
        this$0 = RecentsDataManager.this;
        super(RecentsDataManager.this, RecentsDataManager.access$200(RecentsDataManager.this).nit>);
        categoryId = l;
        searchResultCount = i;
        isSpelledCorrectly = flag1;
        isSellerPrefix = flag;
        keyword = s;
        recentsdatamanager = obj;
        if (!TextUtils.isEmpty(s1))
        {
            recentsdatamanager = (new StringBuilder()).append(s1).append(":").toString();
        }
        productPrefix = RecentsDataManager.this;
    }
}
