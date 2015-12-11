// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.utils:
//            SearchFilterModel

public class this._cls0
{

    List availability;
    List brand;
    List category_feature;
    List category_v2;
    List color;
    List condition;
    List creator_id;
    List event;
    final SearchFilterModel this$0;

    public void addAvailability(String s)
    {
        if (availability == null)
        {
            availability = new ArrayList();
        } else
        {
            availability.clear();
        }
        availability.add(s);
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

    public void addEvent(String s)
    {
        if (event == null)
        {
            event = new ArrayList();
        } else
        {
            event.clear();
        }
        event.add(s);
    }

    public void addSubCategory(String s)
    {
        if (category_feature == null)
        {
            category_feature = new ArrayList();
        } else
        {
            category_feature.clear();
        }
        category_feature.add(s);
    }

    public void addUser(String s)
    {
        if (creator_id == null)
        {
            creator_id = new ArrayList();
        } else
        {
            creator_id.clear();
        }
        creator_id.add(s);
    }

    public void clearAvailabilityList()
    {
        if (availability != null)
        {
            availability.clear();
            availability = null;
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

    public void clearSubCategoryList()
    {
        if (category_feature != null)
        {
            category_feature.clear();
            category_feature = null;
        }
    }

    public String getAvailability()
    {
        if (availability != null)
        {
            return (String)availability.get(0);
        } else
        {
            return null;
        }
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

    public String getCategory()
    {
        if (category_v2 != null)
        {
            return (String)category_v2.get(0);
        } else
        {
            return null;
        }
    }

    public List getColors()
    {
        return color;
    }

    public String getSubCategory()
    {
        if (category_feature != null)
        {
            return (String)category_feature.get(0);
        } else
        {
            return null;
        }
    }

    public List getSubCategoryList()
    {
        return category_feature;
    }

    public void setColor(String s)
    {
        if (color == null)
        {
            color = new ArrayList();
        } else
        {
            color.clear();
        }
        color.add(s);
    }

    public _cls9()
    {
        this$0 = SearchFilterModel.this;
        super();
    }
}
