// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.PriceInfo;
import com.poshmark.data_model.models.SizeFilter;
import com.poshmark.utils.meta_data.AvailabilityMetaData;
import com.poshmark.utils.meta_data.NWTOptionsMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.utils:
//            StringUtils

public class SearchFilterModel
{
    public class PriceRange
    {

        String max;
        String min;
        final SearchFilterModel this$0;

        public String getDisplay()
        {
            String s1 = "";
            String s = s1;
            if (min != null)
            {
                s = s1;
                if (min.length() > 0)
                {
                    s = (new StringBuilder()).append("").append(min).toString();
                }
            }
            if (s.length() > 0)
            {
                min = (new StringBuilder()).append(min).append("-").toString();
            }
            s1 = s;
            if (max != null)
            {
                s1 = s;
                if (max.length() > 0)
                {
                    s1 = (new StringBuilder()).append(s).append(max).toString();
                }
            }
            return s1;
        }

        protected PriceRange(String s, String s1)
        {
            this$0 = SearchFilterModel.this;
            super();
            if (s != null && s.length() > 0)
            {
                min = s;
            }
            if (s1 != null && s1.length() > 0)
            {
                max = s1;
            }
        }
    }

    public class PrimaryFilters
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

        public PrimaryFilters()
        {
            this$0 = SearchFilterModel.this;
            super();
        }
    }

    public class SearchFilters
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

        public SearchFilters()
        {
            this$0 = SearchFilterModel.this;
            super();
            size = new SizeFilter();
        }
    }


    String collection;
    String count;
    List facets;
    SearchFilters filters;
    String max_id;
    String query;
    PrimaryFilters query_and_facet_filters;
    transient String searchTrigger;
    String sort_by;

    public SearchFilterModel()
    {
        filters = new SearchFilters();
        query_and_facet_filters = new PrimaryFilters();
        facets = new ArrayList();
        searchTrigger = new String("");
    }

    public SearchFilterModel(SearchFilterModel searchfiltermodel)
    {
        filters = new SearchFilters();
        query_and_facet_filters = new PrimaryFilters();
        facets = new ArrayList();
        searchTrigger = new String("");
        if (searchfiltermodel.collection != null)
        {
            collection = new String(searchfiltermodel.collection);
        }
        if (searchfiltermodel.count != null)
        {
            count = new String(searchfiltermodel.count);
        }
        if (searchfiltermodel.query != null)
        {
            query = new String(searchfiltermodel.query);
        }
        if (searchfiltermodel.filters.category_v2 != null)
        {
            filters.category_v2 = new ArrayList(searchfiltermodel.filters.category_v2);
        }
        if (searchfiltermodel.filters.brand != null)
        {
            filters.brand = new ArrayList(searchfiltermodel.filters.brand);
        }
        if (searchfiltermodel.filters.condition != null)
        {
            filters.condition = new ArrayList(searchfiltermodel.filters.condition);
        }
        if (searchfiltermodel.filters.inventory_status != null)
        {
            filters.inventory_status = new ArrayList(searchfiltermodel.filters.inventory_status);
        }
        if (searchfiltermodel.filters.price_range != null)
        {
            filters.price_range = new ArrayList(searchfiltermodel.filters.price_range);
        }
        if (searchfiltermodel.filters.color != null)
        {
            filters.color = new ArrayList(searchfiltermodel.filters.color);
        }
        if (searchfiltermodel.filters.category_feature != null)
        {
            filters.category_feature = new ArrayList(searchfiltermodel.filters.category_feature);
        }
        if (searchfiltermodel.filters.size != null)
        {
            filters.size = new SizeFilter(searchfiltermodel.filters.size);
        }
        if (searchfiltermodel.query_and_facet_filters.brand != null)
        {
            query_and_facet_filters.brand = new ArrayList(searchfiltermodel.query_and_facet_filters.brand);
        }
        if (searchfiltermodel.query_and_facet_filters.category_v2 != null)
        {
            query_and_facet_filters.category_v2 = new ArrayList(searchfiltermodel.query_and_facet_filters.category_v2);
        }
        if (searchfiltermodel.query_and_facet_filters.category_feature != null)
        {
            query_and_facet_filters.category_feature = new ArrayList(searchfiltermodel.query_and_facet_filters.category_feature);
        }
        if (searchfiltermodel.query_and_facet_filters.color != null)
        {
            query_and_facet_filters.color = new ArrayList(searchfiltermodel.query_and_facet_filters.color);
        }
        if (searchfiltermodel.query_and_facet_filters.condition != null)
        {
            query_and_facet_filters.condition = new ArrayList(searchfiltermodel.query_and_facet_filters.condition);
        }
        if (searchfiltermodel.query_and_facet_filters.availability != null)
        {
            query_and_facet_filters.availability = new ArrayList(searchfiltermodel.query_and_facet_filters.availability);
        }
        if (searchfiltermodel.query_and_facet_filters.event != null)
        {
            query_and_facet_filters.event = new ArrayList(searchfiltermodel.query_and_facet_filters.event);
        }
        if (searchfiltermodel.query_and_facet_filters.creator_id != null)
        {
            query_and_facet_filters.creator_id = new ArrayList(searchfiltermodel.query_and_facet_filters.creator_id);
        }
        if (facets != null)
        {
            facets.addAll(searchfiltermodel.facets);
        }
        max_id = searchfiltermodel.max_id;
        searchTrigger = searchfiltermodel.searchTrigger;
        sort_by = searchfiltermodel.sort_by;
    }

    public void addColor(String s)
    {
        if (searchTrigger.equals("clr"))
        {
            query_and_facet_filters.setColor(s);
            return;
        } else
        {
            filters.clearColorList();
            filters.addColor(s);
            return;
        }
    }

    public void adjustCategorySubCategory()
    {
        if (searchTrigger.equals("ct"))
        {
            List list = query_and_facet_filters.getSubCategoryList();
            if (list != null && !list.isEmpty())
            {
                filters.addCategory(query_and_facet_filters.getCategory());
                query_and_facet_filters.clearCategoryList();
            }
        }
    }

    public void clearAllFacets()
    {
        if (facets != null)
        {
            facets.clear();
        }
    }

    public void clearAvailability()
    {
        filters.clearAvailabilityList();
    }

    public void clearBrand()
    {
        if (searchTrigger.equals("br") || searchTrigger.equals("brj") || searchTrigger.equals("brpd"))
        {
            query_and_facet_filters.clearBrandList();
            return;
        } else
        {
            filters.clearBrandList();
            return;
        }
    }

    public void clearCategory()
    {
        if (searchTrigger.equals("ct"))
        {
            query_and_facet_filters.clearCategoryList();
            return;
        } else
        {
            filters.clearCategoryList();
            return;
        }
    }

    public void clearColors()
    {
        if (searchTrigger.equals("clr"))
        {
            query_and_facet_filters.clearColorList();
            return;
        } else
        {
            filters.clearColorList();
            return;
        }
    }

    public void clearCondition()
    {
        filters.clearConditionList();
    }

    public void clearCount()
    {
        count = null;
    }

    public void clearNextPageId()
    {
        max_id = null;
    }

    public void clearPrices()
    {
        filters.clearPriceRangeList();
    }

    public void clearSizes()
    {
        filters.clearSizeList();
    }

    public void clearSortBy()
    {
        sort_by = null;
    }

    public void clearSubCategories()
    {
        if (searchTrigger.equals("ct"))
        {
            query_and_facet_filters.clearSubCategoryList();
            return;
        } else
        {
            filters.clearSubCategoryList();
            return;
        }
    }

    public void enableMySizeFilter(boolean flag)
    {
        filters.enableMySize(flag);
    }

    public void enableUnsoldOption(boolean flag)
    {
        filters.enableUnsoldOption(flag);
    }

    public String getAvailability()
    {
        return filters.getInventory_status();
    }

    public MetaItem getAvailabilityAsMetaItem()
    {
        AvailabilityMetaData availabilitymetadata = new AvailabilityMetaData();
        String s = filters.getInventory_status();
        if (s != null)
        {
            return AvailabilityMetaData.getAvailabilityMetaItemFromLabel(s);
        } else
        {
            return availabilitymetadata.getAvailabilityMetaItem(com.poshmark.utils.meta_data.AvailabilityMetaData.AVAILABILITY_TYPE.ALL);
        }
    }

    public String getBrand()
    {
        if (searchTrigger.equals("br") || searchTrigger.equals("brj") || searchTrigger.equals("brpd"))
        {
            return query_and_facet_filters.getBrand();
        } else
        {
            return filters.getBrand();
        }
    }

    public String getCategory()
    {
        if (searchTrigger.equals("ct"))
        {
            return query_and_facet_filters.getCategory();
        } else
        {
            return filters.getCategory_v2();
        }
    }

    public String getCollectionString()
    {
        return collection;
    }

    public List getColorList()
    {
        if (searchTrigger.equals("clr"))
        {
            return query_and_facet_filters.getColors();
        } else
        {
            return filters.getColorList();
        }
    }

    public String getCommaSeparatedSizes()
    {
        if (filters != null)
        {
            List list = filters.getSizeList();
            if (list != null && list.size() > 0)
            {
                return StringUtils.join(list, ",");
            }
        }
        return "";
    }

    public String getCommaSeparatedTags()
    {
        if (filters != null)
        {
            List list = filters.getSubCategoryList();
            if (list != null && list.size() > 0)
            {
                return StringUtils.join(list, ",");
            }
        }
        return "";
    }

    public String getCondition()
    {
        return filters.getCondition();
    }

    public MetaItem getConditionAsMetaItem()
    {
        NWTOptionsMetaData nwtoptionsmetadata = new NWTOptionsMetaData();
        String s = filters.getCondition();
        if (s != null)
        {
            return NWTOptionsMetaData.getConditionMetaItemForFilters(s);
        } else
        {
            return nwtoptionsmetadata.getAllConditionMetaItemForFilters();
        }
    }

    public SearchFilters getFilters()
    {
        return filters;
    }

    public String getLabelForAnalytics()
    {
        String s1 = "";
        String s = s1;
        if (query != null)
        {
            s = s1;
            if (query.length() > 0)
            {
                s = (new StringBuilder()).append("").append(query).toString();
            }
        }
        s1 = s;
        if (collection != null)
        {
            s1 = s;
            if (collection.length() > 0)
            {
                s1 = (new StringBuilder()).append(s).append(collection).toString();
            }
        }
        s = s1;
        if (filters.getCategoryList() != null)
        {
            s = s1;
            if (filters.getCategoryList().size() > 0)
            {
                s = (new StringBuilder()).append(s1).append("category_v2/").append((String)filters.getCategoryList().get(0)).append("/").toString();
            }
        }
        s1 = s;
        if (filters.getSizeList() != null)
        {
            s1 = s;
            if (filters.getSizeList().size() > 0)
            {
                s1 = (new StringBuilder()).append(s).append("size/").append(StringUtils.join(filters.getSizeList(), ",")).append("/").toString();
            }
        }
        s = s1;
        if (filters.getBrandList() != null)
        {
            s = s1;
            if (filters.getBrandList().size() > 0)
            {
                s = (new StringBuilder()).append(s1).append("brand/").append(StringUtils.join(filters.getBrandList(), ",")).append("/").toString();
            }
        }
        s1 = s;
        if (filters.getPriceRangeDisplayList() != null)
        {
            s1 = s;
            if (filters.getPriceRangeDisplayList().size() > 0)
            {
                s1 = (new StringBuilder()).append(s).append("price/").append(StringUtils.join(filters.getPriceRangeDisplayList(), ",")).append("/").toString();
            }
        }
        s = s1;
        if (filters.getConditionList() != null)
        {
            s = s1;
            if (filters.getConditionList().size() > 0)
            {
                s = (new StringBuilder()).append(s1).append("condition/").append(StringUtils.join(filters.getConditionList(), ",")).append("/").toString();
            }
        }
        s1 = s;
        if (filters.getAvailabilityList() != null)
        {
            s1 = s;
            if (filters.getAvailabilityList().size() > 0)
            {
                s1 = (new StringBuilder()).append(s).append("inventory_status/").append(StringUtils.join(filters.getAvailabilityList(), ",")).append("/").toString();
            }
        }
        return s1;
    }

    public PrimaryFilters getPrimaryFilters()
    {
        return query_and_facet_filters;
    }

    public String getQueryText()
    {
        return query;
    }

    public String getSearchTrigger()
    {
        return searchTrigger;
    }

    public String getSortBy()
    {
        return sort_by;
    }

    public List getSubCategories()
    {
        if (searchTrigger.equals("ct"))
        {
            return query_and_facet_filters.getSubCategoryList();
        } else
        {
            return filters.getSubCategoryList();
        }
    }

    public String getSubCategory()
    {
        if (searchTrigger.equals("ct"))
        {
            return query_and_facet_filters.getSubCategory();
        } else
        {
            return filters.getCategoryFeature();
        }
    }

    public void setAvailability(String s)
    {
        filters.addAvailability(s);
    }

    public void setBrand(String s)
    {
        if (searchTrigger.equals("br") || searchTrigger.equals("brj") || searchTrigger.equals("brpd"))
        {
            query_and_facet_filters.addBrand(s);
            return;
        } else
        {
            filters.addBrand(s);
            return;
        }
    }

    public void setBrand(List list)
    {
        if (list != null && list.size() > 0)
        {
            for (list = list.iterator(); list.hasNext();)
            {
                String s = (String)list.next();
                if (searchTrigger.equals("br") || searchTrigger.equals("brj") || searchTrigger.equals("brpd"))
                {
                    query_and_facet_filters.addBrand(s);
                } else
                {
                    filters.addBrand(s);
                }
            }

        }
    }

    public void setCategory(String s)
    {
        if (searchTrigger.equals("ct"))
        {
            query_and_facet_filters.addCategory(s);
            return;
        } else
        {
            filters.addCategory(s);
            return;
        }
    }

    public void setCategory(List list)
    {
        if (list != null && list.size() > 0)
        {
            for (list = list.iterator(); list.hasNext(); setCategory((String)list.next())) { }
        }
    }

    public void setCollectionString(String s)
    {
        collection = s;
    }

    public void setCondition(String s)
    {
        filters.addCondition(s);
    }

    public void setCount(String s)
    {
        count = s;
    }

    public void setFacet(String s)
    {
        if (facets == null)
        {
            facets = new ArrayList();
        }
        if (!facets.contains(s))
        {
            facets.add(s);
        }
    }

    public void setNextPageId(String s)
    {
        if (max_id == null)
        {
            max_id = new String(s);
            return;
        } else
        {
            max_id = s;
            return;
        }
    }

    public void setQueryText(String s)
    {
        query = s;
    }

    public void setSearchTrigger(String s)
    {
        searchTrigger = s;
    }

    public void setSingleFacet(String s)
    {
        if (facets == null)
        {
            facets = new ArrayList();
        }
        facets.clear();
        facets.add(s);
    }

    public void setSortBy(String s)
    {
        sort_by = s;
    }

    public void setSubCategories(List list)
    {
        if (list != null && list.size() > 0)
        {
            for (list = list.iterator(); list.hasNext();)
            {
                MetaItem metaitem = (MetaItem)list.next();
                if (searchTrigger.equals("ct"))
                {
                    query_and_facet_filters.addSubCategory(metaitem.getId());
                } else
                {
                    filters.addSubCategory(metaitem.getId());
                }
            }

        }
    }

    public void setSubCategoryList(List list)
    {
        filters.setSubCategories(list);
    }
}
