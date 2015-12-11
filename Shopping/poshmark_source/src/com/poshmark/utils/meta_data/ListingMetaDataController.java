// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.db.DbApi;
import java.util.List;

// Referenced classes of package com.poshmark.utils.meta_data:
//            AvailabilityMetaData, NWTOptionsMetaData

public class ListingMetaDataController
{

    private MetaItem currentAvailability;
    private MetaItem currentBrand;
    private MetaItem currentCategory;
    private MetaItem currentNWTOption;
    private MetaItem currentSize;
    private List currentSubCategories;

    public ListingMetaDataController()
    {
    }

    public MetaItem getCurrentAvailability()
    {
        return currentAvailability;
    }

    public MetaItem getCurrentBrand()
    {
        return currentBrand;
    }

    public MetaItem getCurrentCategory()
    {
        return currentCategory;
    }

    public MetaItem getCurrentNWTOption()
    {
        return currentNWTOption;
    }

    public MetaItem getCurrentSize()
    {
        return currentSize;
    }

    public List getSizeListForCurrentCategory()
    {
        if (currentCategory != null)
        {
            return GlobalDbController.getGlobalDbController().getAllSizesForCategory(currentCategory.getId());
        } else
        {
            return null;
        }
    }

    public void setCurrentAvailability(MetaItem metaitem)
    {
        currentAvailability = metaitem;
    }

    public void setCurrentAvailabilityOption(String s)
    {
        currentAvailability = DbApi.availabilityMetaData.getAvailabilityItem(s);
    }

    public void setCurrentBrand(MetaItem metaitem)
    {
        currentBrand = metaitem;
    }

    public void setCurrentBrand(String s)
    {
        s = GlobalDbController.getGlobalDbController().getBrandCanonicalName(s);
        if (s != null)
        {
            if (currentBrand == null)
            {
                currentBrand = new MetaItem();
            }
            currentBrand.setDisplay(s);
            currentBrand.setId(s);
        }
    }

    public void setCurrentCategory(MetaItem metaitem)
    {
        if (currentCategory == null || !currentCategory.getId().equals(metaitem.getId()))
        {
            currentCategory = metaitem;
            currentSize = null;
            currentNWTOption = null;
        }
    }

    public void setCurrentCategory(String s)
    {
        currentCategory = GlobalDbController.getGlobalDbController().getCategoryFromLabel(s);
    }

    public void setCurrentNWTOption(MetaItem metaitem)
    {
        currentNWTOption = metaitem;
    }

    public void setCurrentNWTOption(String s)
    {
        NWTOptionsMetaData nwtoptionsmetadata = DbApi.nwtOptionsMetaData;
        currentNWTOption = NWTOptionsMetaData.getConditionMetaItemForFilters(s);
    }

    public MetaItem setCurrentSize(String s)
    {
        currentSize = GlobalDbController.getGlobalDbController().getSizeForCategoryFromLabel(currentCategory.getId(), s);
        return currentSize;
    }

    public void setCurrentSize(MetaItem metaitem)
    {
        currentSize = metaitem;
    }

    public void setCurrentSubCategories(List list)
    {
        currentSubCategories = list;
    }
}
