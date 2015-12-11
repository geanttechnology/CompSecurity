// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.api.display.DetailDisplayInterface;
import com.amazon.retailsearch.android.api.display.externalwidgets.ExternalSearchWidgetSlot;
import com.amazon.retailsearch.android.api.display.results.ResultsInfoBarWidgetType;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.externalwidgets.ExternalWidgetSlotController;
import com.amazon.retailsearch.android.ui.externalwidgets.ExternalWidgetsManager;
import com.amazon.retailsearch.android.ui.resultheader.ResultsInfoBar;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.ViewSelector;
import com.amazon.retailsearch.android.ui.results.layout.FilterRequestListener;
import com.amazon.retailsearch.android.ui.results.layout.GalleryLayout;
import com.amazon.retailsearch.android.ui.results.layout.GridLayout;
import com.amazon.retailsearch.android.ui.results.layout.ListLayout;
import com.amazon.retailsearch.android.ui.results.layout.SearchLayout;
import com.amazon.retailsearch.android.ui.results.layout.SearchLayoutType;
import com.amazon.retailsearch.android.ui.results.layout.SplitLayout;
import com.amazon.retailsearch.android.ui.results.layout.StackViewContainer;
import com.amazon.retailsearch.android.ui.results.layout.UserState;
import com.amazon.retailsearch.data.IRetailSearchDataProvider;
import com.amazon.retailsearch.data.SearchTask;
import com.amazon.retailsearch.data.stores.StoreManager;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.DisplaySettingsUtil;
import com.amazon.retailsearch.interaction.SearchChangeListener;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.impressions.AsinImpressionTracker;
import com.amazon.retailsearch.userpreferences.UserPreferenceChangeListener;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.searchapp.retailsearch.model.DisplaySettings;
import java.util.HashMap;
import java.util.Map;

public class SearchResultView extends LinearLayout
    implements SearchChangeListener, UserPreferenceChangeListener
{
    private class TaskListener extends com.amazon.retailsearch.data.SearchTask.SearchTaskListener
    {

        final SearchResultView this$0;

        public void displaySettings(DisplaySettings displaysettings)
        {
            if (displaysettings != null && !hasResultLayoutType && DisplaySettingsUtil.displaySettingsEnabled(getResources(), featureConfig))
            {
                if ((displaysettings = ResultLayoutType.findByNameIgnoreCase(displaysettings.getResultLayout())) != null)
                {
                    hasResultLayoutType = true;
                    preferencesManager.setResultLayoutType(displaysettings);
                    return;
                }
            }
        }

        public void endPage()
        {
            ViewSelector viewselector = infoBar.getViewSelector();
            if (viewselector != null && !hasResultLayoutType && DisplaySettingsUtil.displaySettingsEnabled(getResources(), featureConfig))
            {
                hasResultLayoutType = true;
                viewselector.updateView(preferencesManager.getResultLayoutType());
            }
        }

        private TaskListener()
        {
            this$0 = SearchResultView.this;
            super();
        }

    }


    public static final boolean IS_WEBVIEW_MARGIN_SUPPORTED;
    public static final String TAG = com/amazon/retailsearch/android/ui/search/SearchResultView.getSimpleName();
    private AsinImpressionTracker asinImpressionTracker;
    IRetailSearchDataProvider dataProvider;
    private DetailDisplayInterface detailInterface;
    private int entryIndex;
    private ExternalWidgetsManager externalWidgetsManager;
    FeatureConfiguration featureConfig;
    private boolean hasResultLayoutType;
    private ResultsInfoBar infoBar;
    private boolean isDetailPageOpened;
    private final boolean isImmersiveViewSupportedGallery;
    private SearchLayout layout;
    private SearchLayoutType layoutType;
    private final Map layouts;
    private final int numColumnsGalleryLandscape;
    private final int numColumnsGalleryPortrait;
    private final int numColumnsGridLandscape;
    private final int numColumnsGridPortrait;
    private final int numColumnsListLandscape;
    private final int numColumnsListPortrait;
    private int oldOrientation;
    ResourceProvider parentResourceProvider;
    UserPreferenceManager preferencesManager;
    private SearchLayoutType previousLayoutType;
    private ResourceProvider resourceProvider;
    private RetailSearchLogger retailSearchLogger;
    SearchDataSource searchDataSource;
    private StackViewContainer stackViewContainer;
    private TaskListener taskListener;
    UserInteractionListener userInteractionListener;
    private UserState userState;

    public SearchResultView(Context context)
    {
        super(context);
        layouts = new HashMap(5);
        taskListener = new TaskListener();
        userState = new UserState();
        asinImpressionTracker = new AsinImpressionTracker();
        numColumnsGridLandscape = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_grid_columns_landscape);
        numColumnsGridPortrait = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_grid_columns_portrait);
        numColumnsGalleryLandscape = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_gallery_columns_landscape);
        numColumnsGalleryPortrait = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_gallery_columns_portrait);
        numColumnsListLandscape = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_list_columns_landscape);
        numColumnsListPortrait = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_list_columns_portrait);
        isImmersiveViewSupportedGallery = getResources().getBoolean(com.amazon.retailsearch.R.bool.config_rs_support_immersive_view_gallery);
        oldOrientation = -1;
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        init();
    }

    public SearchResultView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        layouts = new HashMap(5);
        taskListener = new TaskListener();
        userState = new UserState();
        asinImpressionTracker = new AsinImpressionTracker();
        numColumnsGridLandscape = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_grid_columns_landscape);
        numColumnsGridPortrait = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_grid_columns_portrait);
        numColumnsGalleryLandscape = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_gallery_columns_landscape);
        numColumnsGalleryPortrait = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_gallery_columns_portrait);
        numColumnsListLandscape = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_list_columns_landscape);
        numColumnsListPortrait = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_list_columns_portrait);
        isImmersiveViewSupportedGallery = getResources().getBoolean(com.amazon.retailsearch.R.bool.config_rs_support_immersive_view_gallery);
        oldOrientation = -1;
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        init();
    }

    private void adjustViewForOrientation(int i)
    {
        if (layout != null)
        {
            layout.changeOrientation(i, userState);
        }
        if (isInSplitView())
        {
            adjustViewForSplitView(i);
        }
    }

    private void adjustViewForSplitView(int i)
    {
        Object obj = (FrameLayout)getParent();
        if (obj == null)
        {
            retailSearchLogger.error((new StringBuilder()).append(TAG).append(": Cannot find the parent layout for the Split View").toString(), null);
            return;
        }
        obj = ((FrameLayout) (obj)).getChildAt(0);
        switch (i)
        {
        default:
            retailSearchLogger.error((new StringBuilder()).append(TAG).append(": received and invalid value for orientation").toString(), null);
            return;

        case 2: // '\002'
            if (obj != null)
            {
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                if (IS_WEBVIEW_MARGIN_SUPPORTED)
                {
                    i = getSplitViewLeftSpacing();
                } else
                {
                    i = 0;
                }
                layoutparams.setMargins(i, 0, 0, 0);
                ((View) (obj)).setLayoutParams(layoutparams);
            }
            obj = getLayoutParams();
            obj.width = (int)getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_land_layout_width);
            obj.height = -1;
            return;

        case 1: // '\001'
            break;
        }
        if (obj != null)
        {
            android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(-1, -1);
            layoutparams1.setMargins(0, (int)(getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_port_layout_height) - getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_divider_bottom_margin)), 0, 0);
            ((View) (obj)).setLayoutParams(layoutparams1);
        }
        obj = getLayoutParams();
        obj.width = -1;
        obj.height = (int)getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_port_layout_height);
    }

    private void buildInfoBar()
    {
        inflate(getContext(), com.amazon.retailsearch.R.layout.rs_external_widget_slot_nav_bar_above_rib, this);
        inflate(getContext(), com.amazon.retailsearch.R.layout.result_header, this);
        infoBar = (ResultsInfoBar)findViewById(com.amazon.retailsearch.R.id.results_info_bar);
        infoBar.setVisibilityListener(new com.amazon.retailsearch.android.ui.resultheader.ResultsInfoBar.InfoBarVisibilityListener() {

            final SearchResultView this$0;

            public void onVisibilityChanged(boolean flag)
            {
                ResultsInfoBar resultsinfobar = infoBar;
                int i;
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                resultsinfobar.setVisibility(i);
            }

            
            {
                this$0 = SearchResultView.this;
                super();
            }
        });
    }

    private void closeLayout()
    {
        if (layout != null)
        {
            previousLayoutType = layoutType;
            userState = layout.disable();
            entryIndex = userState.getEntryIndex();
            layout = null;
            layoutType = null;
        }
    }

    private SearchLayout createLayout(SearchLayoutType searchlayouttype, boolean flag)
    {
        static class _cls3
        {

            static final int $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[];

            static 
            {
                $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType = new int[SearchLayoutType.values().length];
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.List.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.Grid.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.Gallery.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.Split.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.amazon.retailsearch.android.ui.results.layout.SearchLayoutType[searchlayouttype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new ListLayout(stackViewContainer, numColumnsListPortrait, numColumnsListLandscape, resourceProvider, asinImpressionTracker);

        case 2: // '\002'
            return new GridLayout(stackViewContainer, numColumnsGridPortrait, numColumnsGridLandscape, resourceProvider, asinImpressionTracker);

        case 3: // '\003'
            return new GalleryLayout(stackViewContainer, numColumnsGalleryPortrait, numColumnsGalleryLandscape, resourceProvider, asinImpressionTracker, isImmersiveViewSupportedGallery);

        case 4: // '\004'
            return new SplitLayout(stackViewContainer, resourceProvider, asinImpressionTracker, entryIndex);
        }
    }

    private SearchLayout getLayout(SearchLayoutType searchlayouttype)
    {
        SearchLayout searchlayout1 = (SearchLayout)layouts.get(searchlayouttype);
        SearchLayout searchlayout;
        boolean flag;
        if (oldOrientation == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        searchlayout = searchlayout1;
        if (searchlayout1 == null)
        {
            searchlayout = createLayout(searchlayouttype, flag);
            searchlayout.setFilterRequestListener(new FilterRequestListener() {

                final SearchResultView this$0;

                public void onFilterApplied(String s, boolean flag1)
                {
                    infoBar.openFilter(s, flag1);
                }

            
            {
                this$0 = SearchResultView.this;
                super();
            }
            });
            layouts.put(searchlayouttype, searchlayout);
        }
        userState.setEntryIndex(entryIndex);
        return searchlayout;
    }

    private void init()
    {
        RetailSearchDaggerGraphController.inject(this);
        resourceProvider = new ResourceProvider(parentResourceProvider);
        searchDataSource.clear();
        searchDataSource.addSearchChangeListener(this);
        preferencesManager.clear();
        preferencesManager.addUserPreferenceChangeListener(this);
        buildInfoBar();
        inflate(getContext(), com.amazon.retailsearch.R.layout.rs_stack_view_container, this);
        stackViewContainer = (StackViewContainer)findViewById(com.amazon.retailsearch.R.id.rs_stack_view_container);
        setOrientation(1);
        try
        {
            oldOrientation = getResources().getConfiguration().orientation;
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private boolean isDetailPageOpened()
    {
        return isDetailPageOpened;
    }

    private boolean isInSplitView()
    {
        return layoutType == SearchLayoutType.Split;
    }

    private void openLayout(SearchLayoutType searchlayouttype)
    {
        if (searchlayouttype == null || searchlayouttype == layoutType)
        {
            return;
        } else
        {
            closeLayout();
            layoutType = searchlayouttype;
            layout = getLayout(searchlayouttype);
            layout.enable(userState);
            return;
        }
    }

    private void resetSearchState()
    {
        userState = new UserState();
    }

    public boolean backPressed()
    {
        if (isDetailPageOpened)
        {
            isDetailPageOpened = false;
            closeDetailPage();
        } else
        if (isInSplitView() && previousLayoutType != null)
        {
            if (detailInterface != null && detailInterface.canGoBack())
            {
                detailInterface.goBack();
                return true;
            }
            closeSplitView();
            if (detailInterface != null)
            {
                detailInterface.clearBackstack();
                return true;
            }
        } else
        {
            return false;
        }
        return true;
    }

    public void closeDetailPage()
    {
        infoBar.setVisibility(0);
        setVisibility(0);
        detailInterface.clearBackstack();
    }

    public void closeSplitView()
    {
        openLayout(previousLayoutType);
        infoBar.setVisibility(0);
        setVisibility(0);
        detailInterface.clearBackstack();
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        layoutparams.width = -1;
        layoutparams.height = -1;
    }

    public int getSplitViewLeftSpacing()
    {
        return getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_split_view_land_layout_width) - getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_split_view_divider_right_margin);
    }

    public StoreManager getStoreManager()
    {
        return dataProvider.getStoreManager();
    }

    public void linkExternalWidgetsManager(ExternalWidgetsManager externalwidgetsmanager)
    {
        if (externalwidgetsmanager != null && externalWidgetsManager == null)
        {
            externalWidgetsManager = externalwidgetsmanager;
            if (searchDataSource != null)
            {
                searchDataSource.addSearchChangeListener(externalwidgetsmanager);
            }
            FrameLayout framelayout = (FrameLayout)findViewById(com.amazon.retailsearch.R.id.rs_external_widget_slot_nav_bar_above_rib);
            externalwidgetsmanager = externalwidgetsmanager.getSlotController(ExternalSearchWidgetSlot.NAV_BAR_ABOVE_RIB);
            if (externalwidgetsmanager != null)
            {
                externalwidgetsmanager.setWidgetContainer(framelayout);
                return;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (configuration == null || oldOrientation == configuration.orientation)
        {
            return;
        }
        if (isInSplitView())
        {
            int i = userState.getEntryIndex();
            userState = layout.getUserState();
            userState.setEntryIndex(i);
        }
        adjustViewForOrientation(configuration.orientation);
        oldOrientation = configuration.orientation;
    }

    public void onNewSearch(SearchTask searchtask)
    {
        closeLayout();
        hasResultLayoutType = false;
        resetSearchState();
        asinImpressionTracker.recordImpressions();
        searchDataSource.getCurrentSearch().addListener(taskListener);
        searchDataSource.getCurrentSearch().addListener(externalWidgetsManager.getSearchTaskListener());
        searchDataSource.getCurrentSearch().addListener(asinImpressionTracker.getSearchTaskListener());
        searchDataSource.getCurrentSearch().addListener(infoBar.getSearchTaskListener());
        openLayout(SearchLayoutType.valueOf(preferencesManager.getResultLayoutType().getName()));
    }

    public void onPause()
    {
        if (layout != null)
        {
            layout.pause();
        }
    }

    public void onResultLayoutTypeUpdated(ResultLayoutType resultlayouttype)
    {
        openLayout(SearchLayoutType.valueOf(resultlayouttype.getName()));
    }

    public void onResume()
    {
        if (layout != null)
        {
            layout.resume();
        }
    }

    public void onStart()
    {
    }

    public void onStop()
    {
    }

    public void openDetailPage()
    {
        isDetailPageOpened = true;
        infoBar.setVisibility(8);
        setVisibility(8);
    }

    public void openSplitView(String s)
    {
        boolean flag1;
        int i;
        i = getResources().getConfiguration().orientation;
        boolean flag;
        if (!isInSplitView())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i != oldOrientation)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag)
        {
            layout.setEntryGroupAsin(s);
        }
        openLayout(SearchLayoutType.Split);
        infoBar.setVisibility(8);
        if (!flag) goto _L2; else goto _L1
_L1:
        adjustViewForSplitView(i);
_L4:
        oldOrientation = i;
        return;
_L2:
        if (flag1)
        {
            adjustViewForOrientation(i);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void resetViews()
    {
        if (isInSplitView())
        {
            closeSplitView();
        } else
        if (isDetailPageOpened())
        {
            closeDetailPage();
            return;
        }
    }

    public void setDetailDisplayInterface(DetailDisplayInterface detaildisplayinterface)
    {
        detailInterface = detaildisplayinterface;
    }

    public void setResultsInfoBarWidgetType(ResultsInfoBarWidgetType resultsinfobarwidgettype, View view)
    {
        if (infoBar != null)
        {
            infoBar.setWidgetType(resultsinfobarwidgettype, view);
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        IS_WEBVIEW_MARGIN_SUPPORTED = flag;
    }




/*
    static boolean access$202(SearchResultView searchresultview, boolean flag)
    {
        searchresultview.hasResultLayoutType = flag;
        return flag;
    }

*/
}
