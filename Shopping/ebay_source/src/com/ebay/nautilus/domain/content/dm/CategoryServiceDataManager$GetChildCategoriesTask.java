// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.data.EbayCategoryNode;
import com.ebay.nautilus.domain.net.api.categoryservice.GetChildrenCategoriesRequest;
import com.ebay.nautilus.domain.net.api.categoryservice.GetChildrenCategoriesResponse;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.NumberUtil;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            CategoryServiceDataManager

protected final class categoryLevel extends categoryLevel
{

    private final int categoryLevel;
    final CategoryServiceDataManager this$0;

    private EbayCategoryNode persistCategoryNodes(com.ebay.nautilus.domain.net.api.categoryservice. , String s, String s1)
    {
        if ( != null && .NodeDetail != null)
        {
            String s2 = s;
            EbayCategory ebaycategory;
            int i;
            boolean flag3;
            if (s == null)
            {
                if (.NodeDetail.yId == null)
                {
                    s2 = Long.toString(-1L);
                } else
                {
                    s2 = .NodeDetail.yId;
                }
            }
            s = s1;
            if (s1 == null)
            {
                if (.NodeDetail.NodeDetail == null)
                {
                    s = "";
                } else
                {
                    s = .NodeDetail.NodeDetail;
                }
            }
            ebaycategory = new EbayCategory(NumberUtil.safeParseLong(.NodeDetail.yId, -1L), .NodeDetail.NodeDetail);
            ebaycategory.level = .NodeDetail.NodeDetail;
            if (.eChildCategories == null || .eChildCategories.isEmpty())
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            ebaycategory.isLeaf = flag3;
            ebaycategory.idPath = s2;
            ebaycategory.namePath = s;
            ebaycategory.parentId = NumberUtil.safeParseLong(.NodeDetail.ategoryId, -1L);
            if (.eChildCategories == null)
            {
                i = 0;
            } else
            {
                i = .eChildCategories.size();
            }
            s1 = new EbayCategoryNode[i];
            for (int j = 0; j < i; j++)
            {
                com.ebay.nautilus.domain.net.api.categoryservice. 1 = (com.ebay.nautilus.domain.net.api.categoryservice.eChildCategories).eChildCategories.get(j);
                s1[j] = persistCategoryNodes(1, (new StringBuilder()).append(s2).append(":").append(1.NodeDetail.yId).toString(), (new StringBuilder()).append(s).append(":").append(1.NodeDetail.NodeDetail).toString());
            }

            s = new EbayCategoryNode(ebaycategory, s1);
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (.NodeDetail.NodeDetail == categoryLevel)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (categoryLevel == -1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (s1.length > 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if ((flag || flag1 && flag2) && !TextUtils.isEmpty(.NodeDetail.yId))
            {
                cacheManager.put((new StringBuilder()).append("childrenFor-").append(.NodeDetail.yId).toString(), s);
            }
            return s;
        } else
        {
            return null;
        }
    }

    protected transient Content doInBackground(Void avoid[])
    {
        ResultStatus resultstatus;
        long l;
        try
        {
            avoid = (EbayCategoryNode)cacheManager.get((new StringBuilder()).append("childrenFor-").append(categoryId).toString());
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
            break MISSING_BLOCK_LABEL_49;
        }
        return new Content(avoid);
        l = categoryId;
        if (categoryLevel <= -1)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        avoid = Integer.valueOf(categoryLevel + 2);
_L1:
        avoid = new GetChildrenCategoriesRequest(l, avoid, null, null, ebaySite);
        avoid = (GetChildrenCategoriesResponse)CategoryServiceDataManager.access$100(CategoryServiceDataManager.this, avoid);
        resultstatus = avoid.getResultStatus();
        if (resultstatus.hasError() || ((GetChildrenCategoriesResponse) (avoid)).data == null || ((GetChildrenCategoriesResponse) (avoid)).data.s == null || ((GetChildrenCategoriesResponse) (avoid)).data.s.isEmpty())
        {
            break MISSING_BLOCK_LABEL_197;
        }
        avoid = new Content(persistCategoryNodes((com.ebay.nautilus.domain.net.api.categoryservice.ryNodes)((GetChildrenCategoriesResponse) (avoid)).data.s.get(0), null, null));
        return avoid;
        avoid = null;
          goto _L1
        avoid = new Content(resultstatus);
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    public Node(long l, int i, EbaySite ebaysite)
    {
        this$0 = CategoryServiceDataManager.this;
        super(CategoryServiceDataManager.this, l, ebaysite);
        categoryLevel = i;
    }
}
