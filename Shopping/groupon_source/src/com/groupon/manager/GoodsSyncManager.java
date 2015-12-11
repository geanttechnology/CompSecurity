// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.models.FilterCategory;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CarouselExecutorManager;
import com.groupon.util.CategoriesUtil;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.PausableThreadPoolExecutor;
import java.util.Arrays;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            AnyChannelSyncManager, WidgetOnGoodsSyncHelper

public class GoodsSyncManager extends AnyChannelSyncManager
{
    protected static class CategoryFilter
    {

        private String categoryId;
        private int level;

        public String getCategoryId()
        {
            return categoryId;
        }

        public int getLevel()
        {
            return level;
        }


        public CategoryFilter(String s, int i)
        {
            categoryId = s;
            level = i;
        }
    }


    private CategoriesUtil categoriesUtil;
    private CategoryFilter categoryFilter;
    private FilterCategory filterCategory;
    protected boolean isRtrGoods1408INTL;
    private WidgetOnGoodsSyncHelper widgetOnGoodsSyncHelper;

    public GoodsSyncManager(Context context)
    {
        super(context, "GOODS");
        filterCategory = new FilterCategory();
    }

    public GoodsSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, CarouselExecutorManager carouselexecutormanager)
    {
        super(context, pausablethreadpoolexecutor, "GOODS", carouselexecutormanager);
        filterCategory = new FilterCategory();
    }

    public GoodsSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, String s, CarouselExecutorManager carouselexecutormanager)
    {
        super(context, pausablethreadpoolexecutor, s, carouselexecutormanager);
        filterCategory = new FilterCategory();
    }

    public GoodsSyncManager(Context context, String s)
    {
        super(context, s);
        filterCategory = new FilterCategory();
    }

    public String getChannelName()
    {
        return channel;
    }

    public FilterCategory getFilterCategory()
    {
        return filterCategory;
    }

    protected List getNameValueParams(int i, int j)
    {
        List list = super.getNameValueParams(i, j);
        if (!Strings.notEmpty(filterCategory.getCategoryId())) goto _L2; else goto _L1
_L1:
        list.addAll(Arrays.asList(new String[] {
            "filters", Strings.join(":", new String[] {
                "category", filterCategory.getCategoryId()
            })
        }));
_L4:
        if (Strings.notEmpty(filterCategory.getFacetGroupFiltersForCategory()))
        {
            list.addAll(Arrays.asList(new String[] {
                "facet_group_filters", filterCategory.getFacetGroupFiltersForCategory()
            }));
        }
        list.addAll(getRelevanceContextNameValueParams());
        return list;
_L2:
        if (categoryFilter != null)
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("category");
            Object obj;
            if (categoryFilter.getLevel() > 1)
            {
                obj = Integer.valueOf(categoryFilter.getLevel());
            } else
            {
                obj = "";
            }
            list.addAll(Arrays.asList(new String[] {
                "filters", Strings.join(":", new String[] {
                    stringbuilder.append(obj).toString(), categoryFilter.categoryId
                })
            }));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected List getRelevanceContextNameValueParams()
    {
        return Arrays.asList(new String[] {
            "relevance_context", "mobile_goods"
        });
    }

    protected String getSuperUrl(int i, int j)
        throws CountryNotSupportedException
    {
        return super.getUrl(i, j);
    }

    protected String getUrl(int i, int j)
        throws CountryNotSupportedException
    {
        boolean flag;
        if (Strings.notEmpty(filterCategory.getCategoryId()) || categoryFilter != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && flag)
        {
            return String.format("%s?offset=%s&limit=%s", new Object[] {
                "https:/deals/search", Integer.valueOf(i), Integer.valueOf(j)
            });
        } else
        {
            return getSuperUrl(i, j);
        }
    }

    public void init()
    {
        boolean flag;
        if (!currentCountryManager.getCurrentCountry().isUSACompatible() && abTestService.isINTLVariantEnabled("rtrGoods1408%s", "on"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isRtrGoods1408INTL = flag;
        initializeWidgetsIfSupported();
    }

    protected void initializeWidgetsIfSupported()
    {
        boolean flag;
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && Strings.notEmpty(abTestService.getVariant("megamindOnGoods1407USCA")) && !abTestService.isVariantEnabled("megamindOnGoods1407USCA", "Original"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        widgetsSupported = flag;
        if (widgetsSupported)
        {
            widgetOnGoodsSyncHelper.setScenarioIdVariantPostfix(abTestService.getVariant("megamindOnGoods1407USCA"));
            widgetOnGoodsSyncHelper.setFragmentName(fragmentName);
            setWidgetsSyncHelper(widgetOnGoodsSyncHelper);
        }
    }

    public void refreshCategoryFilter()
    {
        filterCategory = categoriesUtil.getCategoriesFilter(Channel.GOODS.name());
    }

    public void setCategoryFilterParam(String s, int i)
    {
        if (s != null)
        {
            s = new CategoryFilter(s, i);
        } else
        {
            s = null;
        }
        categoryFilter = s;
    }
}
