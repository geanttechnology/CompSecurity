// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.inner_models.Inventory;
import com.poshmark.data_model.models.inner_models.ListingFeature;
import com.poshmark.utils.FeatureManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.poshmark.data_model.models:
//            MetaItem, PMColor, ListingDetails

public class NewListing
{

    String brand;
    MetaItem category_v2;
    List colors;
    String condition;
    String description;
    String inventory_status;
    HashMap listingInfoHash;
    String original_price;
    String price;
    String size;
    List subcategories;
    String title;
    String web_command_info;

    public NewListing()
    {
        price = "";
        size = "";
        original_price = "";
        description = "";
        subcategories = new ArrayList();
        colors = new ArrayList();
        brand = "";
        condition = "";
        title = "";
        inventory_status = "";
        listingInfoHash = new HashMap();
        web_command_info = "";
    }

    public void clearSubCategories()
    {
        if (subcategories != null)
        {
            subcategories.clear();
        }
    }

    public String getBrand()
    {
        return brand;
    }

    public MetaItem getCategory()
    {
        return category_v2;
    }

    public List getColors()
    {
        return colors;
    }

    public String getCondition()
    {
        return condition;
    }

    public String getConditionDisplayString(Context context)
    {
        if (condition == null || condition.length() == 0)
        {
            return "";
        }
        if (condition.toLowerCase().equals("nwt"))
        {
            return context.getString(0x7f0602cd);
        }
        if (condition.toLowerCase().equals("ret"))
        {
            return context.getString(0x7f0602ce);
        } else
        {
            return context.getString(0x7f0601ce);
        }
    }

    public String getDescription()
    {
        return description;
    }

    public MetaItem getFirstSubCategory()
    {
        if (!subcategories.isEmpty())
        {
            return (MetaItem)subcategories.get(0);
        } else
        {
            return null;
        }
    }

    public String getInputError()
    {
        String s2;
label0:
        {
            s2 = "";
            if (title.length() == 0)
            {
                s2 = (new StringBuilder()).append("").append(PMApplication.getContext().getString(0x7f06017d)).toString();
            }
            String s = s2;
            if (description.length() == 0)
            {
                s = (new StringBuilder()).append(s2).append("\n").append(PMApplication.getContext().getString(0x7f060179)).toString();
            }
            if (category_v2 != null)
            {
                s2 = s;
                if (category_v2.getId() != null)
                {
                    break label0;
                }
            }
            s2 = (new StringBuilder()).append(s).append("\n").append(PMApplication.getContext().getString(0x7f060178)).toString();
        }
        String s1 = s2;
        if (size.length() == 0)
        {
            s1 = (new StringBuilder()).append(s2).append("\n").append(PMApplication.getContext().getString(0x7f06017c)).toString();
        }
        s2 = s1;
        if (original_price.length() == 0)
        {
            s2 = (new StringBuilder()).append(s1).append("\n").append(PMApplication.getContext().getString(0x7f06017a)).toString();
        }
        s1 = s2;
        if (price.length() == 0)
        {
            s1 = (new StringBuilder()).append(s2).append("\n").append(PMApplication.getContext().getString(0x7f06017b)).toString();
        }
        return s1;
    }

    public String getInventoryStatus()
    {
        return inventory_status;
    }

    public String getInventoryStatusDisplayString(Context context)
    {
        if (inventory_status != null && inventory_status.equals("not_for_sale"))
        {
            return context.getString(0x7f0601d4);
        } else
        {
            return context.getString(0x7f060135);
        }
    }

    public Map getListingInfoHash()
    {
        Gson gson = (new GsonBuilder()).create();
        listingInfoHash.put("title", title);
        listingInfoHash.put("description", description);
        listingInfoHash.put("category_v2", category_v2.getId());
        Object obj = new ArrayList();
        if (!subcategories.isEmpty())
        {
            ((ArrayList) (obj)).add(((MetaItem)subcategories.get(0)).getId());
        }
        if (!(gson instanceof Gson))
        {
            obj = gson.toJson(obj, java/util/List);
        } else
        {
            obj = GsonInstrumentation.toJson((Gson)gson, obj, java/util/List);
        }
        listingInfoHash.put("category_features", obj);
        obj = new ArrayList();
        for (Iterator iterator = colors.iterator(); iterator.hasNext(); ((ArrayList) (obj)).add(((PMColor)iterator.next()).name)) { }
        if (!(gson instanceof Gson))
        {
            obj = gson.toJson(obj, java/util/List);
        } else
        {
            obj = GsonInstrumentation.toJson((Gson)gson, obj, java/util/List);
        }
        listingInfoHash.put("size", size);
        listingInfoHash.put("brand", brand);
        listingInfoHash.put("condition", condition);
        listingInfoHash.put("original_price", original_price);
        listingInfoHash.put("price", price);
        listingInfoHash.put("inventory_status", inventory_status);
        listingInfoHash.put("colors", obj);
        return listingInfoHash;
    }

    public String getOriginalPrice()
    {
        return original_price;
    }

    public String getPrice()
    {
        return price;
    }

    public String getSize()
    {
        return size;
    }

    public List getSubCategoryList()
    {
        return subcategories;
    }

    public String getTitle()
    {
        return title;
    }

    public String getWebCommandInfo()
    {
        return web_command_info;
    }

    public boolean isValidListing()
    {
        if (title.length() != 0 && description.length() != 0 && category_v2 != null && category_v2.getId() != null && size.length() != 0 && original_price.length() != 0 && price.length() != 0)
        {
            ListingFeature listingfeature = FeatureManager.getGlobalFeatureManager().getListingFeature();
            if (listingfeature == null || listingfeature.isValidListingPrice(price))
            {
                return true;
            }
        }
        return false;
    }

    public void setBrand(String s)
    {
        brand = s;
    }

    public void setCategory(MetaItem metaitem)
    {
        category_v2 = metaitem;
    }

    public void setColors(List list)
    {
        colors = list;
    }

    public void setCondition(String s)
    {
        condition = s;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setInventoryStatus(String s)
    {
        inventory_status = s;
    }

    public void setKeyValuePair(String s, String s1)
    {
        listingInfoHash.put(s, s1);
    }

    public void setListingPrice(String s)
    {
        price = s;
    }

    public void setOriginalPrice(String s)
    {
        original_price = s;
    }

    public void setSize(String s)
    {
        size = s;
    }

    public void setSubcategories(MetaItem metaitem)
    {
        if (subcategories == null)
        {
            subcategories = new ArrayList();
        }
        subcategories.clear();
        subcategories.add(metaitem);
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setWebCommandInfo(String s)
    {
        web_command_info = s;
    }

    public void updateFromListingDetails(ListingDetails listingdetails)
    {
        if (listingdetails.getTitle() != null)
        {
            title = listingdetails.getTitle();
        }
        if (listingdetails.getDescription() != null)
        {
            description = listingdetails.getDescription();
        }
        if (listingdetails.getCategoryLabel() != null)
        {
            category_v2 = listingdetails.getCategory();
        }
        if (listingdetails.getSubCategoryList() != null)
        {
            subcategories.addAll(listingdetails.getSubCategoryList());
        }
        if (listingdetails.getColorList() != null)
        {
            colors.addAll(listingdetails.getColorList());
        }
        CharSequence charsequence = listingdetails.getSize();
        if (charsequence != null)
        {
            size = charsequence.toString();
        }
        if (listingdetails.getCondition() != null)
        {
            condition = listingdetails.getCondition();
        }
        if (listingdetails.getOriginalPrice() != null)
        {
            original_price = listingdetails.getOriginalPrice().toString();
        }
        if (listingdetails.getPrice() != null)
        {
            price = listingdetails.getPrice().toString();
        }
        if (listingdetails.getBrand() != null)
        {
            brand = listingdetails.getBrand();
        }
        if (listingdetails.getInventory() != null)
        {
            inventory_status = listingdetails.getInventory().status;
        }
    }
}
