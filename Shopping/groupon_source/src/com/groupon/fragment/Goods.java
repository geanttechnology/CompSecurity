// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.groupon.Channel;
import com.groupon.activity.Carousel;
import com.groupon.activity.IntentFactory;
import com.groupon.adapter.BaseGoodsCategoryAdapter;
import com.groupon.adapter.GoodsCategoriesAdapter;
import com.groupon.adapter.GoodsCategoryDecoration;
import com.groupon.adapter.listener.OnCategoryImpressionEventListener;
import com.groupon.adapter.listener.OnCategoryItemClickListener;
import com.groupon.adapter.listener.OnRecyclerItemTouchListener;
import com.groupon.adapter.widget.DealListHeaderAdapter;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.adapter.widget.GoodsWidgetMergeAdapter;
import com.groupon.db.models.DealSummary;
import com.groupon.manager.AnyChannelSyncManager;
import com.groupon.manager.GoodsSyncManager;
import com.groupon.models.FilterCategory;
import com.groupon.models.category.Category;
import com.groupon.models.country.Country;
import com.groupon.service.CategoryService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CategoriesUtil;
import com.groupon.util.DealCardMultiColumnListAdapter;
import com.groupon.util.Function1;
import com.groupon.util.LoggingUtils;
import com.groupon.util.OnViewCreatedListener;
import com.groupon.view.BrowseByCategoryBar;
import com.groupon.view.FilterBar;
import com.groupon.view.InAppToast;
import commonlib.manager.PaginatedSyncManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseDealsWithOptionalWidgetsListFragment, DataTransformer, DealCardEndlessAdapter, BaseCardListFragment

public class Goods extends BaseDealsWithOptionalWidgetsListFragment
{
    private class OnCategoryBarClickListener
        implements android.view.View.OnClickListener
    {

        final Goods this$0;

        public void onClick(View view)
        {
            loggingUtils.logCategoryBarClick("browse_by_category", nstChannel, Channel.GOODS.toString());
            view = ((IntentFactory)intentFactory.get()).newGlobalSearchIntent(getChannel());
            view.putExtra("browse_by_category", isSingleGoodsCategorySelector);
            startActivity(view);
        }

        private OnCategoryBarClickListener()
        {
            this$0 = Goods.this;
            super();
        }

    }

    private class OnFilterBarClickListener
        implements android.view.View.OnClickListener
    {

        final Goods this$0;

        public void onClick(View view)
        {
            startActivityForResult(((IntentFactory)intentFactory.get()).newGoodsCategoriesIntent(0, 0), 10101);
        }

        private OnFilterBarClickListener()
        {
            this$0 = Goods.this;
            super();
        }
    }

    private class OnGoodsCategoryImpressionEventListener
        implements OnCategoryImpressionEventListener
    {

        final Goods this$0;

        public void onImpressionEvent(Category category)
        {
            loggingUtils.logGoodsCategoryImpression(category.id);
        }

        private OnGoodsCategoryImpressionEventListener()
        {
            this$0 = Goods.this;
            super();
        }

    }

    private class OnGoodsCategoryItemClickListener
        implements OnCategoryItemClickListener
    {

        final Goods this$0;

        public void onItemClick(View view, int i)
        {
            view = (Category)goodsCategories.get(i);
            loggingUtils.logCategoryCarouselClick("category_click", nstChannel, Channel.GOODS.toString(), view);
            startActivity(((IntentFactory)intentFactory.get()).newCategoryCarouselGlobalSearchResultIntent(channel, view, 1, true, false));
        }

        private OnGoodsCategoryItemClickListener()
        {
            this$0 = Goods.this;
            super();
        }

    }

    private class OnRecyclerScrollListener extends android.support.v7.widget.RecyclerView.OnScrollListener
    {

        final Goods this$0;

        public void onScrollStateChanged(RecyclerView recyclerview, int i)
        {
            boolean flag = true;
            recyclerview = Goods.this;
            if (i == 1)
            {
                flag = false;
            }
            recyclerview.setPullToRefreshEnabled(flag);
        }

        private OnRecyclerScrollListener()
        {
            this$0 = Goods.this;
            super();
        }

    }


    private static final String GOODS_CATEGORY_DEPTH_LEVEL_PARAM = "goods_category_depth_level_param";
    private static final String GOODS_CATEGORY_DISABLE_SCROLL_HELPER = "goods_category_disable_scroll_helper";
    private boolean animationDisplayed;
    private BrowseByCategoryBar browseByCategoryBar;
    private View categoriesContainer;
    private RecyclerView categoriesList;
    private CategoriesUtil categoriesUtil;
    private Lazy categoryService;
    private Context context;
    private int depthLevel;
    FilterBar filterBar;
    private List goodsCategories;
    private boolean goodsCategoryAnimationDisplayed;
    private LayoutInflater inflater;
    private boolean isCarouselGoodsCategorySelector;
    private boolean isPaused;
    private boolean isSingleGoodsCategorySelector;
    protected OnViewCreatedListener listener;
    private GoodsWidgetMergeAdapter mergeAdapter;
    private Category selectedCategory;
    private GoodsSyncManager syncManager;

    public Goods()
    {
        super(Channel.GOODS);
        listener = null;
    }

    public Goods(Channel channel)
    {
        super(channel);
        listener = null;
    }

    private void doStartCategoryCarouselAnimation()
    {
        if (!goodsCategoryAnimationDisplayed && getUserVisibleHint() && isAdded())
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(categoriesList, "x", new float[] {
                0.0F, getResources().getDimension(0x7f0b0152) / 2.0F
            });
            objectanimator.setInterpolator(new DecelerateInterpolator());
            objectanimator.setDuration(400L);
            objectanimator.setRepeatCount(1);
            objectanimator.setRepeatMode(2);
            objectanimator.setStartDelay(200L);
            objectanimator.start();
            goodsCategoryAnimationDisplayed = true;
        }
    }

    private void getCategories()
    {
        ((CategoryService)categoryService.get()).getGoodsCategories(getActivity().getApplicationContext(), null);
    }

    private void setCategoryCarouselVisible(boolean flag)
    {
        if (categoriesList != null)
        {
            RecyclerView recyclerview = categoriesList;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            recyclerview.setVisibility(i);
        }
    }

    protected void afterOnLoadFinished(List list)
    {
        byte byte0 = 0;
        super.afterOnLoadFinished(list);
        boolean flag;
        if (list == null || list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isCarouselGoodsCategorySelector)
        {
            boolean flag1;
            if (isCarouselGoodsCategorySelector && !flag && selectedCategory == null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            setCategoryCarouselVisible(flag1);
        }
        if (isSingleGoodsCategorySelector)
        {
            list = browseByCategoryBar;
            if (flag)
            {
                byte0 = 8;
            }
            list.setVisibility(byte0);
        }
    }

    protected View createHeaderView()
    {
        if (!isSingleGoodsCategorySelector)
        {
            return null;
        } else
        {
            LinearLayout linearlayout = (LinearLayout)LayoutInflater.from(context).inflate(0x7f030116, null);
            browseByCategoryBar = (BrowseByCategoryBar)linearlayout.findViewById(0x7f10032b);
            linearlayout.addView((new InAppToast(activity)).getView());
            return linearlayout;
        }
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
        super.enableSyncProgressIndicator(flag);
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setFilterBarEnabled(flag);
    }

    public DataTransformer getDataTransformer()
    {
        return new DataTransformer();
    }

    protected DealCardEndlessAdapter getDealCardEndlessAdapter(BaseAdapter baseadapter, BaseCardListFragment basecardlistfragment)
    {
        if (activity.getResources().getInteger(0x7f0d0001) != 1 || !widgetsSupported || !currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            return super.getDealCardEndlessAdapter(baseadapter, this);
        } else
        {
            basecardlistfragment = new ArrayList();
            String s = getClass().getSimpleName();
            widgetListAdapter = new FilterableWidgetListAdapter(getActivity(), this, null, null, loggingUtils, s, Channel.GOODS, new String[] {
                "topSlot"
            });
            basecardlistfragment.add(widgetListAdapter);
            s = getString(0x7f080060);
            basecardlistfragment.add(new DealListHeaderAdapter(activity, s, null));
            basecardlistfragment.add(baseadapter);
            mergeAdapter = new GoodsWidgetMergeAdapter((Adapter[])basecardlistfragment.toArray(new Adapter[basecardlistfragment.size()]));
            return new DealCardEndlessAdapter(this, this, new DealCardMultiColumnListAdapter(mergeAdapter, getDealListColumns()) {

                final Goods this$0;

                public void onDealCardClicked(int i, View view, DealSummary dealsummary)
                {
                    int j = widgetListAdapter.getCount();
                    Goods.this.onDealCardClicked(i - j - 1, view, dealsummary);
                }

                public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
                {
                    onMemberClick(view, dealsummary);
                }

            
            {
                this$0 = Goods.this;
                super(listadapter, i);
            }
            });
        }
    }

    protected void getGoodsCategories()
    {
        int i = 3;
        CategoryService categoryservice = (CategoryService)categoryService.get();
        Context context1 = getActivity().getApplicationContext();
        if (depthLevel <= 3)
        {
            i = depthLevel;
        }
        categoryservice.getGlobalCategories(context1, "goods", "mobile_goods", i, new Function1() {

            final Goods this$0;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                boolean flag = true;
                setCategoryCarouselVisible(true);
                goodsCategories = categoriesUtil.getGoodsCategories(list);
                getArguments().putParcelableArrayList("categories_list", (ArrayList)goodsCategories);
                if (goodsCategories.size() < 2)
                {
                    flag = false;
                }
                if (flag)
                {
                    Collections.sort(goodsCategories, new com.groupon.util.CategoriesUtil.CategoryComparator());
                    list = new GoodsCategoriesAdapter(getActivity(), goodsCategories);
                    list.setOnItemClickListener(new OnGoodsCategoryItemClickListener());
                    categoriesList.setAdapter(list);
                    categoriesContainer.getLayoutParams().height = (int)getResources().getDimension(0x7f0b0148);
                    return;
                } else
                {
                    categoriesContainer.getLayoutParams().height = -2;
                    return;
                }
            }

            
            {
                this$0 = Goods.this;
                super();
            }
        }, null);
    }

    public volatile AnyChannelSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public GoodsSyncManager getSyncManager()
    {
        return syncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    protected String getWidgetNstChannelName()
    {
        return "goods";
    }

    public void onActivityCreated(Bundle bundle)
    {
        Object obj;
        ArrayList arraylist;
        if (bundle != null)
        {
            obj = bundle;
        } else
        {
            obj = getArguments();
        }
        if (!isCarouselGoodsCategorySelector) goto _L2; else goto _L1
_L1:
        arraylist = new ArrayList();
        categoriesContainer = LayoutInflater.from(getActivity()).inflate(0x7f030114, getListView(), false);
        categoriesList = (RecyclerView)categoriesContainer.findViewById(0x7f100328);
        if (obj == null) goto _L4; else goto _L3
_L3:
        ArrayList arraylist1 = ((Bundle) (obj)).getParcelableArrayList("categories_list");
        obj = arraylist;
        if (arraylist1 != null)
        {
            obj = arraylist;
            if (!arraylist1.isEmpty())
            {
                obj = arraylist1;
            }
        }
_L6:
        categoriesList.setAdapter(new GoodsCategoriesAdapter(getActivity(), ((List) (obj))));
        categoriesList.addItemDecoration(new GoodsCategoryDecoration(getActivity()));
        categoriesList.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        categoriesList.setOnScrollListener(new OnRecyclerScrollListener());
        categoriesList.addOnItemTouchListener(new OnRecyclerItemTouchListener((Carousel)activity));
        getListView().addHeaderView(categoriesContainer);
_L2:
        super.onActivityCreated(bundle);
        categoryService = new Lazy(getActivity()) {

            final Goods this$0;

            
            {
                this$0 = Goods.this;
                super(context1);
            }
        };
        if (filterBar != null)
        {
            filterBar.setVisibility(8);
        }
        if (isCarouselGoodsCategorySelector)
        {
            if (categoriesList.getAdapter() != null && categoriesList.getAdapter().getItemCount() > 2)
            {
                setCategoryCarouselVisible(true);
            }
            getGoodsCategories();
        }
        if (browseByCategoryBar != null)
        {
            browseByCategoryBar.setOnClickListener(new OnCategoryBarClickListener());
        }
        return;
_L4:
        obj = arraylist;
        if (goodsCategories != null)
        {
            obj = arraylist;
            if (!goodsCategories.isEmpty())
            {
                obj = goodsCategories;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 10101 && j == -1)
        {
            updateHeader();
            refresh();
        }
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag;
        if (bundle != null)
        {
            selectedCategory = (Category)bundle.getParcelable("selected_category_item");
            depthLevel = bundle.getInt("goods_category_depth_level_param");
            disableScrollHelper = bundle.getBoolean("goods_category_disable_scroll_helper");
        } else
        {
            selectedCategory = (Category)getArguments().getParcelable("selected_category_item");
            depthLevel = getArguments().getInt("goods_category_depth_level_param");
            disableScrollHelper = getArguments().getBoolean("goods_category_disable_scroll_helper");
        }
        inflater = LayoutInflater.from(getActivity());
        syncManager = (GoodsSyncManager)RoboGuice.getInjector(getActivity()).getInstance(com/groupon/manager/GoodsSyncManager);
        if (selectedCategory != null)
        {
            setChannelName(syncManager.getChannelName());
            syncManager.setCategoryFilterParam(selectedCategory.id, depthLevel);
        }
        super.onCreate(bundle);
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && Strings.notEmpty(abTestService.getVariant("megamindOnGoods1407USCA")) && !abTestService.isVariantEnabled("megamindOnGoods1407USCA", "Original") && selectedCategory == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        widgetsSupported = flag;
        isSingleGoodsCategorySelector = categoriesUtil.isSingleGoodsCategorySelectorEnabled();
        isCarouselGoodsCategorySelector = categoriesUtil.isCarouselGoodsCategorySelectorEnabled();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03002d, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        listener = null;
    }

    public void onPause()
    {
        isPaused = true;
        super.onPause();
    }

    public void onResume()
    {
        isPaused = false;
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (isCarouselGoodsCategorySelector && categoriesList != null && categoriesList.getAdapter() != null)
        {
            ArrayList arraylist = (ArrayList)((GoodsCategoriesAdapter)categoriesList.getAdapter()).getItems();
            if (arraylist != null && !arraylist.isEmpty())
            {
                bundle.putParcelableArrayList("categories_list", arraylist);
            }
        }
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (listener != null)
        {
            listener.execute(view);
        }
    }

    protected void refresh()
    {
        forceReload();
        setEmptyView();
    }

    protected void setEmptyView()
    {
        boolean flag = Strings.equalsIgnoreCase(getSyncManager().getFilterCategory().getMode(), com.groupon.models.FilterCategory.Mode.EVERYTHING);
        ListView listview = getListView();
        View view;
        if (flag)
        {
            view = inflater.inflate(0x7f03002b, null, false);
        } else
        {
            view = inflater.inflate(0x7f03002e, null, false);
        }
        listview.setEmptyView(view);
    }

    protected void setFilterBarEnabled(boolean flag)
    {
        if (filterBar != null && filterBar.getVisibility() == 0)
        {
            filterBar.setEnabled(flag);
        }
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag)
        {
            String s = getClass().getSimpleName();
            logger.logPageView("", s, Logger.NULL_NST_FIELD);
        }
        if (flag && !animationDisplayed)
        {
            startWidgetAnimation();
            animationDisplayed = true;
        } else
        {
            animationDisplayed = false;
        }
        if (categoriesUtil != null && isCarouselGoodsCategorySelector && categoriesList != null && categoriesList.getAdapter() != null)
        {
            BaseGoodsCategoryAdapter basegoodscategoryadapter = (BaseGoodsCategoryAdapter)categoriesList.getAdapter();
            OnGoodsCategoryImpressionEventListener ongoodscategoryimpressioneventlistener;
            if (flag)
            {
                ongoodscategoryimpressioneventlistener = new OnGoodsCategoryImpressionEventListener();
            } else
            {
                ongoodscategoryimpressioneventlistener = null;
            }
            basegoodscategoryadapter.setOnImpressionEventListener(ongoodscategoryimpressioneventlistener);
            basegoodscategoryadapter.notifyDataSetChanged();
            if (flag && categoriesList.getAdapter().getItemCount() >= 2)
            {
                doStartCategoryCarouselAnimation();
            }
        }
    }

    protected void startWidgetAnimation()
    {
        while (isPaused || getView() == null || widgetListAdapter == null) 
        {
            return;
        }
        widgetListAdapter.resetAnimation();
    }

    protected void updateHeader()
    {
        getSyncManager().refreshCategoryFilter();
        String s = getSyncManager().getFilterCategory().getCategoryName();
        FilterBar filterbar = filterBar;
        if (!Strings.notEmpty(s))
        {
            s = getString(0x7f08005e);
        }
        filterbar.setText(s);
    }




/*
    static List access$402(Goods goods, List list)
    {
        goods.goodsCategories = list;
        return list;
    }

*/




}
