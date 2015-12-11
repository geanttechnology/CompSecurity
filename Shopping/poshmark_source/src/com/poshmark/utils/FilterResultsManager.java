// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.PMApplication;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.models.Facets;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.data_model.models.PriceInfo;
import com.poshmark.db.DbApi;
import com.poshmark.notifications.PMNotificationManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.utils:
//            SearchFilterModel, StringUtils

public class FilterResultsManager
{

    List currentColors;
    List currentPrices;
    List currentSizes;
    List currentSubCategories;
    Facets facets;
    SearchFilterModel model;

    public FilterResultsManager()
    {
        currentSizes = new ArrayList();
        currentPrices = new ArrayList();
        currentColors = new ArrayList();
        currentSubCategories = new ArrayList();
        model = new SearchFilterModel();
    }

    public void clearPriceSelection()
    {
        currentPrices.clear();
        model.clearPrices();
    }

    public void clearSizeSelection()
    {
        currentSizes.clear();
        model.clearSizes();
    }

    public void clearsubCategories()
    {
        currentSubCategories.clear();
        model.clearSubCategories();
    }

    public String getCommaSeparatedColors()
    {
        String s = "";
        if (currentColors != null && currentColors.size() > 0)
        {
            for (Iterator iterator = currentColors.iterator(); iterator.hasNext();)
            {
                PMColor pmcolor = (PMColor)iterator.next();
                s = (new StringBuilder()).append(s).append(pmcolor.getName()).toString();
            }

            return s;
        } else
        {
            return "";
        }
    }

    public String getCommaSeparatedPrices()
    {
        String s = "";
        if (currentPrices != null && currentPrices.size() > 0)
        {
            for (Iterator iterator = currentPrices.iterator(); iterator.hasNext();)
            {
                PriceInfo priceinfo = (PriceInfo)iterator.next();
                s = (new StringBuilder()).append(s).append(priceinfo.getDisplay()).toString();
            }

            return s;
        } else
        {
            return "";
        }
    }

    public MetaItem getCurrentAvailability()
    {
        return model.getAvailabilityAsMetaItem();
    }

    public MetaItem getCurrentBrand()
    {
        MetaItem metaitem = null;
        String s = model.getBrand();
        if (s != null)
        {
            metaitem = new MetaItem(s, s);
        }
        return metaitem;
    }

    public MetaItem getCurrentCategory()
    {
        MetaItem metaitem = null;
        String s = model.getCategory();
        if (s != null)
        {
            metaitem = DbApi.getCurrentCategoryFromId(s);
        }
        return metaitem;
    }

    public List getCurrentColorSelections()
    {
        return currentColors;
    }

    public MetaItem getCurrentCondition()
    {
        return model.getConditionAsMetaItem();
    }

    public List getCurrentPriceSelections()
    {
        return currentPrices;
    }

    public List getCurrentSizeSelections()
    {
        return currentSizes;
    }

    public List getCurrentSubCategories()
    {
        return currentSubCategories;
    }

    public MetaItem getCurrentSubCategory()
    {
        MetaItem metaitem = null;
        String s = model.getSubCategory();
        if (s != null)
        {
            metaitem = DbApi.getSubCategoryFromId(s);
        }
        return metaitem;
    }

    public SearchFilterModel getSearchModel()
    {
        return model;
    }

    public String getSearchRequestString()
    {
        SearchFilterModel searchfiltermodel = new SearchFilterModel(model);
        searchfiltermodel.adjustCategorySubCategory();
        Gson gson = (new GsonBuilder()).create();
        if (!(gson instanceof Gson))
        {
            return gson.toJson(searchfiltermodel);
        } else
        {
            return GsonInstrumentation.toJson((Gson)gson, searchfiltermodel);
        }
    }

    public boolean isMySizeEnabled()
    {
        return model.getFilters().isMySizeEnabled();
    }

    public void pullFromBundle(Bundle bundle)
    {
        model = (SearchFilterModel)StringUtils.fromJson(bundle.getString("SAVED_FILTER_MODEL_JSON"), com/poshmark/utils/SearchFilterModel);
        model.setSearchTrigger(bundle.getString("SAVED_SEARCH_TRIGGER"));
    }

    public void saveToBundle(Bundle bundle)
    {
        bundle.putString("SAVED_FILTER_MODEL_JSON", StringUtils.toJson(model));
        bundle.putString("SAVED_SEARCH_TRIGGER", model.getSearchTrigger());
    }

    public void setFacet(String s)
    {
        model.setFacet(s);
    }

    public void setSearchModel(SearchFilterModel searchfiltermodel)
    {
        model = searchfiltermodel;
        Object obj = searchfiltermodel.getFilters().getSizeList();
        if (obj != null && ((List) (obj)).size() > 0)
        {
            String s;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); currentSizes.add(new MetaItem(s, s)))
            {
                s = (String)((Iterator) (obj)).next();
            }

        }
        obj = searchfiltermodel.getFilters().getPriceRangeList();
        if (obj != null && ((List) (obj)).size() > 0)
        {
            PriceInfo priceinfo;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); currentPrices.add(new PriceInfo(priceinfo.getMin(), priceinfo.getMax())))
            {
                priceinfo = (PriceInfo)((Iterator) (obj)).next();
            }

        }
        obj = searchfiltermodel.getColorList();
        if (obj != null && ((List) (obj)).size() > 0)
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Object obj2 = (String)((Iterator) (obj)).next();
                obj2 = GlobalDbController.getGlobalDbController().getColorFromName(((String) (obj2)));
                if (obj2 != null)
                {
                    currentColors.add(obj2);
                }
            } while (true);
        }
        searchfiltermodel = searchfiltermodel.getSubCategories();
        if (searchfiltermodel != null && searchfiltermodel.size() > 0)
        {
            searchfiltermodel = searchfiltermodel.iterator();
            do
            {
                if (!searchfiltermodel.hasNext())
                {
                    break;
                }
                Object obj1 = (String)searchfiltermodel.next();
                obj1 = GlobalDbController.getGlobalDbController().getSubCategoryFromId(((String) (obj1)));
                if (obj1 != null)
                {
                    currentSubCategories.add(obj1);
                }
            } while (true);
        }
    }

    public void toggleMySize()
    {
        boolean flag = model.getFilters().isMySizeEnabled();
        SearchFilterModel.SearchFilters searchfilters = model.getFilters();
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        searchfilters.enableMySize(flag);
    }

    public void updateAvailability(MetaItem metaitem)
    {
        if (model != null)
        {
            model.clearAvailability();
            if (!metaitem.getDisplay().equalsIgnoreCase(PMApplication.getContext().getString(0x7f060040)))
            {
                model.setAvailability(metaitem.getId());
            }
        }
    }

    public void updateBrand(MetaItem metaitem)
    {
        if (model != null)
        {
            model.clearBrand();
            model.setBrand(metaitem.getDisplay());
        }
    }

    public void updateCategory(MetaItem metaitem)
    {
        if (model != null)
        {
            model.clearCategory();
            model.setCategory(metaitem.getId());
        }
    }

    public void updateColors(List list)
    {
        if (model != null)
        {
            model.clearColors();
            currentColors.clear();
            if (list != null && list.size() > 0)
            {
                currentColors = list;
                PMColor pmcolor;
                for (list = list.iterator(); list.hasNext(); model.addColor(pmcolor.getName()))
                {
                    pmcolor = (PMColor)list.next();
                }

            }
        }
    }

    public void updateCondition(MetaItem metaitem)
    {
        if (model != null)
        {
            model.clearCondition();
            if (!metaitem.getId().equals("not_nwt"))
            {
                model.setCondition(metaitem.getId());
            }
        }
    }

    public void updatePrices(List list)
    {
        if (model != null)
        {
            model.getFilters().clearPriceRangeList();
            currentPrices.clear();
            if (list.size() > 0)
            {
                currentPrices = list;
                PriceInfo priceinfo;
                for (list = list.iterator(); list.hasNext(); model.getFilters().addPriceRange(priceinfo))
                {
                    priceinfo = (PriceInfo)list.next();
                }

            }
        }
    }

    public void updateSizes(List list)
    {
        if (model != null)
        {
            model.getFilters().clearSizeList();
            currentSizes.clear();
            if (list != null && list.size() > 0)
            {
                currentSizes = list;
                MetaItem metaitem;
                for (list = list.iterator(); list.hasNext(); model.getFilters().addSize(metaitem.getId()))
                {
                    metaitem = (MetaItem)list.next();
                }

            }
        }
    }

    public void updateSubCatogories(List list)
    {
        if (model != null)
        {
            model.clearSubCategories();
            currentSubCategories.clear();
            if (list != null && list.size() > 0)
            {
                currentSubCategories = list;
                model.setSubCategories(currentSubCategories);
            }
        }
    }

    public void updateViews()
    {
        PMNotificationManager.fireNotification("com.poshmark.intents.UPDATE_SEARCH_DRAWER", null);
    }
}
