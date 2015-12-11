// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;

import android.content.Context;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.db.DbApi;
import com.poshmark.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Theme
{

    List brands;
    List categories;
    List categories_v2;
    List category_features;
    List colors;
    float max_price;
    float min_price;
    List sizes;

    public Theme()
    {
        categories = Collections.synchronizedList(new ArrayList());
        categories_v2 = Collections.synchronizedList(new ArrayList());
        category_features = Collections.synchronizedList(new ArrayList());
        colors = Collections.synchronizedList(new ArrayList());
        sizes = Collections.synchronizedList(new ArrayList());
        brands = Collections.synchronizedList(new ArrayList());
        max_price = -1F;
        min_price = -1F;
    }

    public List getBrands()
    {
        return brands;
    }

    public List getCategories()
    {
        return categories;
    }

    public String getCommaSeparatedBrands(Context context)
    {
        if (brands.size() == 0)
        {
            return context.getString(0x7f06003c);
        }
        context = new ArrayList();
        Iterator iterator = brands.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MetaItem metaitem = DbApi.getBrandItemFromLabel((String)iterator.next());
            if (metaitem != null)
            {
                context.add(metaitem.getDisplay());
            }
        } while (true);
        return StringUtils.join(context, ",");
    }

    public String getCommaSeparatedCategories(Context context)
    {
        if (categories_v2.size() == 0)
        {
            return context.getString(0x7f06003c);
        }
        context = new ArrayList();
        Iterator iterator = categories_v2.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MetaItem metaitem = DbApi.getCurrentCategoryFromId((String)iterator.next());
            if (metaitem != null)
            {
                context.add(metaitem.getDisplay());
            }
        } while (true);
        return StringUtils.join(context, ",");
    }

    public String getCommaSeparatedSizes(Context context)
    {
        if (sizes.size() == 0)
        {
            return context.getString(0x7f06003c);
        } else
        {
            return StringUtils.join(sizes, ",");
        }
    }

    public float getMaxPrice()
    {
        return max_price;
    }

    public float getMinPrice()
    {
        return min_price;
    }

    public List getSizes()
    {
        return sizes;
    }

    public boolean isMatchingBrand(String s)
    {
label0:
        {
            boolean flag;
label1:
            {
                boolean flag1 = false;
                if (brands == null || brands.size() <= 0)
                {
                    break label0;
                }
                flag = flag1;
                if (s == null)
                {
                    break label1;
                }
                Iterator iterator = brands.iterator();
                do
                {
                    flag = flag1;
                    if (!iterator.hasNext())
                    {
                        break label1;
                    }
                } while (!((String)iterator.next()).equalsIgnoreCase(s));
                flag = true;
            }
            return flag;
        }
        return true;
    }

    public boolean isMatchingCategory(String s)
    {
label0:
        {
            boolean flag;
label1:
            {
                boolean flag1 = false;
                if (categories_v2 == null || categories_v2.size() <= 0)
                {
                    break label0;
                }
                flag = flag1;
                if (s == null)
                {
                    break label1;
                }
                Iterator iterator = categories_v2.iterator();
                do
                {
                    flag = flag1;
                    if (!iterator.hasNext())
                    {
                        break label1;
                    }
                } while (!((String)iterator.next()).equalsIgnoreCase(s));
                flag = true;
            }
            return flag;
        }
        return true;
    }

    public boolean isMatchingColor(List list)
    {
        if (colors != null && colors.size() > 0)
        {
            if (list != null && !list.isEmpty())
            {
                boolean flag1 = true;
                list = list.iterator();
                boolean flag;
                do
                {
                    flag = flag1;
                    if (!list.hasNext())
                    {
                        break;
                    }
                    PMColor pmcolor = (PMColor)list.next();
                    if (colors.contains(pmcolor.name))
                    {
                        continue;
                    }
                    flag = false;
                    break;
                } while (true);
                return flag;
            } else
            {
                return true;
            }
        } else
        {
            return true;
        }
    }

    public boolean isMatchingPrice(String s)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        if (max_price > 0.0F || min_price > 0.0F)
        {
            if (s != null)
            {
                float f = Float.valueOf(s).floatValue();
                boolean flag = flag2;
                if (max_price > 0.0F)
                {
                    flag = flag2;
                    if (f <= max_price)
                    {
                        flag = true;
                    }
                }
                flag1 = flag;
                if (min_price > 0.0F)
                {
                    flag1 = flag;
                    if (f >= min_price)
                    {
                        flag1 = true;
                    }
                }
            }
            return flag1;
        } else
        {
            return true;
        }
    }

    public boolean isMatchingSize(CharSequence charsequence)
    {
label0:
        {
            boolean flag;
label1:
            {
                boolean flag1 = false;
                if (sizes == null || sizes.size() <= 0)
                {
                    break label0;
                }
                flag = flag1;
                if (charsequence == null)
                {
                    break label1;
                }
                Iterator iterator = sizes.iterator();
                do
                {
                    flag = flag1;
                    if (!iterator.hasNext())
                    {
                        break label1;
                    }
                } while (!((String)iterator.next()).equalsIgnoreCase(charsequence.toString()));
                flag = true;
            }
            return flag;
        }
        return true;
    }

    public boolean isMatchingSubCategory(List list)
    {
        if (category_features != null && category_features.size() > 0)
        {
            if (list != null && !list.isEmpty())
            {
                boolean flag1 = true;
                list = list.iterator();
                boolean flag;
                do
                {
                    flag = flag1;
                    if (!list.hasNext())
                    {
                        break;
                    }
                    MetaItem metaitem = (MetaItem)list.next();
                    if (category_features.contains(metaitem.getId()))
                    {
                        continue;
                    }
                    flag = false;
                    break;
                } while (true);
                return flag;
            } else
            {
                return true;
            }
        } else
        {
            return true;
        }
    }
}
