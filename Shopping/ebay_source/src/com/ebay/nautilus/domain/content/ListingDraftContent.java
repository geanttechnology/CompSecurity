// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ebay.nautilus.domain.data.ItemSpecific;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.data.ShippingRecommendation;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            Content

public class ListingDraftContent extends Content
{

    public SparseArray conditionDefinitions;
    public boolean hasSpecificsGuidance;
    public boolean isGuaranteeSelectedThisSession;
    public ArrayList itemSpecificsForCategory;
    public String productDescription;
    public ArrayList shippingEstimates;
    public ShippingRecommendation shippingRecommendation;

    public ListingDraftContent(ListingDraft listingdraft, ResultStatus resultstatus)
    {
        super(listingdraft, resultstatus);
    }

    public boolean haveRequiredSpecifics()
    {
        if (itemSpecificsForCategory == null || getData() == null)
        {
            return false;
        }
        for (Iterator iterator = itemSpecificsForCategory.iterator(); iterator.hasNext();)
        {
            ItemSpecific itemspecific = (ItemSpecific)iterator.next();
            if (itemspecific.isRequired())
            {
                boolean flag1 = false;
                Iterator iterator1 = ((ListingDraft)getData()).productSpecifics.iterator();
                boolean flag;
                do
                {
                    flag = flag1;
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    if (!((LdsField)iterator1.next()).getIdIndex().equals(itemspecific.name))
                    {
                        continue;
                    }
                    flag = true;
                    break;
                } while (true);
                flag1 = flag;
                if (!flag)
                {
                    Iterator iterator2 = ((ListingDraft)getData()).selectedItemSpecifics.iterator();
                    do
                    {
                        flag1 = flag;
                        if (!iterator2.hasNext())
                        {
                            break;
                        }
                        Object obj = (LdsField)iterator2.next();
                        if (((LdsField) (obj)).getIdIndex().equals(itemspecific.name))
                        {
                            StringBuilder stringbuilder = new StringBuilder();
                            obj = ((LdsField) (obj)).getSelectedValues().iterator();
                            do
                            {
                                if (!((Iterator) (obj)).hasNext())
                                {
                                    break;
                                }
                                stringbuilder.append((String)((Iterator) (obj)).next());
                                if (((Iterator) (obj)).hasNext())
                                {
                                    stringbuilder.append(", ");
                                }
                            } while (true);
                            if (!TextUtils.isEmpty(stringbuilder.toString()))
                            {
                                flag = true;
                            }
                        }
                    } while (true);
                }
                if (!flag1)
                {
                    return false;
                }
            }
        }

        return true;
    }
}
