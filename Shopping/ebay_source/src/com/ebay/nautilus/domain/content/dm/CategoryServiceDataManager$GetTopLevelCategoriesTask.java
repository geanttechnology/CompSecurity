// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.data.EbayCategoryNode;
import com.ebay.nautilus.domain.net.api.categoryservice.GetTopLevelCategoriesRequest;
import com.ebay.nautilus.domain.net.api.categoryservice.GetTopLevelCategoriesResponse;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.NumberUtil;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            CategoryServiceDataManager

protected final class needsMotors extends needsMotors
{

    private final boolean needsMotors;
    final CategoryServiceDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        int i;
        Object obj;
        LinkedList linkedlist;
        com.ebay.nautilus.domain.net.api.categoryservice. ;
        int j;
        long l;
        try
        {
            avoid = (EbayCategoryNode)cacheManager.get("topLevel");
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            if (!isCancelled())
            {
                cancel(false);
            }
            return null;
        }
        if (avoid == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        return new Content(avoid);
        avoid = new GetTopLevelCategoriesRequest(null, ebaySite);
        obj = (GetTopLevelCategoriesResponse)CategoryServiceDataManager.access$200(CategoryServiceDataManager.this, avoid);
        avoid = ((GetTopLevelCategoriesResponse) (obj)).getResultStatus();
        if (avoid.hasError() || ((GetTopLevelCategoriesResponse) (obj)).data == null) goto _L2; else goto _L1
_L1:
        obj = ((GetTopLevelCategoriesResponse) (obj)).data;
        if (((com.ebay.nautilus.domain.net.api.categoryservice.) (obj)).ails == null) goto _L2; else goto _L3
_L3:
        j = ((com.ebay.nautilus.domain.net.api.categoryservice.ails) (obj)).ails.size();
        linkedlist = new LinkedList();
        i = 0;
_L12:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_234;
        }
         = (com.ebay.nautilus.domain.net.api.categoryservice.ails)((com.ebay.nautilus.domain.net.api.categoryservice.ails) (obj)).ails.get(i);
        l = NumberUtil.safeParseLong(., -1L);
        if (. != null)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        avoid = "";
_L4:
        avoid = new EbayCategory(l, avoid);
        avoid.level = .;
        avoid.isLeaf = false;
        avoid.idPath = .;
        avoid.namePath = .;
        linkedlist.add(new EbayCategoryNode(avoid, new EbayCategoryNode[0]));
        i++;
        continue; /* Loop/switch isn't completed */
        avoid = .;
          goto _L4
        if (!needsMotors) goto _L6; else goto _L5
_L5:
        avoid = new EbayCategory(6000L, "eBay Motors");
        avoid.level = 1;
        avoid.isLeaf = false;
        avoid.idPath = Long.toString(6000L);
        avoid.namePath = "eBay Motors";
        j = linkedlist.size();
        i = 0;
_L10:
        if (i >= j) goto _L6; else goto _L7
_L7:
        if ("eBay Motors".compareToIgnoreCase(((EbayCategoryNode)linkedlist.get(i)).category.name) >= 0) goto _L9; else goto _L8
_L8:
        linkedlist.add(i, new EbayCategoryNode(avoid, new EbayCategoryNode[0]));
_L6:
        avoid = new EbayCategoryNode(new EbayCategory(-1L, ""), (EbayCategoryNode[])linkedlist.toArray(new EbayCategoryNode[linkedlist.size()]));
        cacheManager.put("topLevel", avoid);
        avoid = new Content(avoid);
        return avoid;
_L9:
        i++;
        if (true) goto _L10; else goto _L2
_L2:
        avoid = new Content(avoid);
        return avoid;
        if (true) goto _L12; else goto _L11
_L11:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    public il(EbaySite ebaysite)
    {
        this$0 = CategoryServiceDataManager.this;
        super(CategoryServiceDataManager.this, -1L, ebaysite);
        boolean flag;
        if (ebaysite == EbaySite.US)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        needsMotors = flag;
    }
}
