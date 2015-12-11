// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.models.PriceInfo;
import com.poshmark.data_model.models.SizeFilter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.utils:
//            SearchFilterModel

public class size
{

    List brand;
    List category_feature;
    List category_v2;
    List color;
    List condition;
    List inventory_status;
    List price_range;
    SizeFilter size;
    final SearchFilterModel this$0;

    public void addAvailability(String s)
    {
        if (inventory_status == null)
        {
            inventory_status = new ArrayList();
        } else
        {
            inventory_status.clear();
        }
        inventory_status.add(s);
    }

    public void addBrand(String s)
    {
        if (brand == null)
        {
            brand = new ArrayList();
        } else
        {
            brand.clear();
        }
        brand.add(s);
    }

    public void addCategory(String s)
    {
        if (category_v2 == null)
        {
            category_v2 = new ArrayList();
        } else
        {
            category_v2.clear();
        }
        category_v2.add(s);
    }

    public void addColor(String s)
    {
        if (color == null)
        {
            color = new ArrayList();
        }
        color.add(s);
    }

    public void addCondition(String s)
    {
        if (condition == null)
        {
            condition = new ArrayList();
        } else
        {
            condition.clear();
        }
        condition.add(s);
    }

    public void addPriceRange(PriceInfo priceinfo)
    {
        if (price_range == null)
        {
            price_range = new ArrayList();
        }
        price_range.add(priceinfo);
    }

    public void addSize(String s)
    {
        if (size == null)
        {
            size = new SizeFilter();
        }
        size.addSize(s);
    }

    public void addSubCategory(String s)
    {
        if (category_feature == null)
        {
            category_feature = new ArrayList();
        }
        category_feature.add(s);
    }

    public void clearAvailabilityList()
    {
        if (inventory_status != null)
        {
            inventory_status.clear();
            inventory_status = null;
        }
    }

    public void clearBrandList()
    {
        if (brand != null)
        {
            brand.clear();
            brand = null;
        }
    }

    public void clearCategoryList()
    {
        if (category_v2 != null)
        {
            category_v2.clear();
            category_v2 = null;
        }
    }

    public void clearColorList()
    {
        if (color != null)
        {
            color.clear();
            color = null;
        }
    }

    public void clearConditionList()
    {
        if (condition != null)
        {
            condition.clear();
            condition = null;
        }
    }

    public void clearInventoryStatusList()
    {
        if (inventory_status != null)
        {
            inventory_status.clear();
        }
    }

    public void clearPriceRangeList()
    {
        if (price_range != null)
        {
            price_range.clear();
            price_range = null;
        }
    }

    public void clearSizeList()
    {
        if (size != null)
        {
            List list = size.getSizes();
            if (list != null)
            {
                list.clear();
            }
        }
    }

    public void clearSubCategoryList()
    {
        if (category_feature != null)
        {
            category_feature.clear();
            category_feature = null;
        }
    }

    public void enableMySize(boolean flag)
    {
        if (size == null)
        {
            size = new SizeFilter();
        }
        size.enableMySize(flag);
    }

    public void enableNWTOption(boolean flag)
    {
        if (flag)
        {
            if (condition == null)
            {
                condition = new ArrayList();
            } else
            {
                condition.clear();
            }
            condition.add("nwt");
            return;
        } else
        {
            condition = null;
            return;
        }
    }

    public void enableRetailOption(boolean flag)
    {
        if (flag)
        {
            if (condition == null)
            {
                condition = new ArrayList();
            } else
            {
                condition.clear();
            }
            condition.add("ret");
            return;
        } else
        {
            condition = null;
            return;
        }
    }

    public void enableUnsoldOption(boolean flag)
    {
        if (flag)
        {
            if (inventory_status == null)
            {
                inventory_status = new ArrayList();
            } else
            {
                inventory_status.clear();
            }
            inventory_status.add("available");
            return;
        } else
        {
            inventory_status = null;
            return;
        }
    }

    public List getAvailabilityList()
    {
        return inventory_status;
    }

    public String getBrand()
    {
        if (brand != null)
        {
            return (String)brand.get(0);
        } else
        {
            return null;
        }
    }

    public List getBrandList()
    {
        return brand;
    }

    public String getCategoryFeature()
    {
        if (category_feature != null)
        {
            return (String)category_feature.get(0);
        } else
        {
            return null;
        }
    }

    public List getCategoryList()
    {
        return category_v2;
    }

    public String getCategory_v2()
    {
        if (category_v2 != null)
        {
            return (String)category_v2.get(0);
        } else
        {
            return null;
        }
    }

    public List getColorList()
    {
        return color;
    }

    public String getCondition()
    {
        if (condition != null)
        {
            return (String)condition.get(0);
        } else
        {
            return null;
        }
    }

    public List getConditionList()
    {
        return condition;
    }

    public String getInventory_status()
    {
        if (inventory_status != null)
        {
            return (String)inventory_status.get(0);
        } else
        {
            return null;
        }
    }

    public List getPriceRangeDisplayList()
    {
        if (price_range != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((List) (obj));
_L2:
        ArrayList arraylist = new ArrayList();
        int i = 0;
        do
        {
            obj = arraylist;
            if (i >= price_range.size())
            {
                continue;
            }
            arraylist.add(((PriceInfo)price_range.get(i)).getDisplay());
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List getPriceRangeList()
    {
        return price_range;
    }

    public List getSizeList()
    {
        if (size != null)
        {
            return size.getSizes();
        } else
        {
            return null;
        }
    }

    public List getSubCategoryList()
    {
        return category_feature;
    }

    public boolean isMySizeEnabled()
    {
        if (size != null)
        {
            return size.getMySizeFlag();
        } else
        {
            return false;
        }
    }

    public void setSubCategories(List list)
    {
        if (category_feature == null)
        {
            category_feature = new ArrayList();
        }
        category_feature.clear();
        category_feature.addAll(list);
    }

    public ()
    {
        this$0 = SearchFilterModel.this;
        super();
        size = new SizeFilter();
    }
}
