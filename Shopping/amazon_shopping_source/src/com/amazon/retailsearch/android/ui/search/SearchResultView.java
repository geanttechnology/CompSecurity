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
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.resultheader.ResultsInfoBar;
import com.amazon.retailsearch.android.ui.results.ViewSelector;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.android.ui.results.layout.FlipBookLayout;
import com.amazon.retailsearch.android.ui.results.layout.GalleryLayout;
import com.amazon.retailsearch.android.ui.results.layout.GridLayout;
import com.amazon.retailsearch.android.ui.results.layout.ListLayout;
import com.amazon.retailsearch.android.ui.results.layout.SearchLayout;
import com.amazon.retailsearch.android.ui.results.layout.SearchLayoutType;
import com.amazon.retailsearch.android.ui.results.layout.SplitLayout;
import com.amazon.retailsearch.android.ui.results.layout.UserState;
import com.amazon.retailsearch.data.SearchTask;
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
            if (displaysettings != null && !hasViewType && DisplaySettingsUtil.displaySettingsEnabled(getResources(), featureConfig))
            {
                if ((displaysettings = ViewType.findByNameIgnoreCase(displaysettings.getResultLayout())) != null)
                {
                    hasViewType = true;
                    preferencesManager.setViewType(displaysettings);
                    return;
                }
            }
        }

        public void endPage()
        {
            ViewSelector viewselector = infoBar.getViewSelector();
            if (viewselector != null && !hasViewType && DisplaySettingsUtil.displaySettingsEnabled(getResources(), featureConfig))
            {
                hasViewType = true;
                viewselector.updateView(preferencesManager.getViewType());
            }
        }

        private TaskListener()
        {
            this$0 = SearchResultView.this;
            super();
        }

    }


    public static final String TAG = com/amazon/retailsearch/android/ui/search/SearchResultView.getSimpleName();
    private AsinImpressionTracker asinImpressionTracker;
    private DetailDisplayInterface detailInterface;
    private int entryIndex;
    FeatureConfiguration featureConfig;
    private boolean hasViewType;
    private ResultsInfoBar infoBar;
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
        oldOrientation = -1;
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        init();
    }

    private void adjustViewForOrientation(int i)
    {
        Object obj;
label0:
        {
            if (layout != null)
            {
                layout.changeOrientation(i, userState);
            }
            if (isInSplitView())
            {
                obj = (FrameLayout)getParent();
                if (obj != null)
                {
                    break label0;
                }
                retailSearchLogger.error((new StringBuilder()).append(TAG).append(": Cannot find the parent layout for the Split View").toString(), null);
            }
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
                layoutparams.setMargins((int)(getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_land_layout_width) - getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_split_view_divider_right_margin)), 0, 0, 0);
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
        inflate(getContext(), com.amazon.retailsearch.R.layout.result_header, this);
        infoBar = (ResultsInfoBar)findViewById(com.amazon.retailsearch.R.id.results_info_bar);
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
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[];

            static 
            {
                $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType = new int[SearchLayoutType.values().length];
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.List.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.Grid.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.Gallery.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.FlipBook.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.Split.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.retailsearch.android.ui.results.layout.SearchLayoutType[searchlayouttype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new ListLayout(this, numColumnsListPortrait, numColumnsListLandscape, resourceProvider, asinImpressionTracker);

        case 2: // '\002'
            return new GridLayout(this, numColumnsGridPortrait, numColumnsGridLandscape, resourceProvider, asinImpressionTracker);

        case 3: // '\003'
            return new GalleryLayout(this, numColumnsGalleryPortrait, numColumnsGalleryLandscape, resourceProvider, asinImpressionTracker);

        case 4: // '\004'
            return new FlipBookLayout(this, resourceProvider, asinImpressionTracker);

        case 5: // '\005'
            return new SplitLayout(this, resourceProvider, asinImpressionTracker, entryIndex);
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
        if (!isInSplitView() || previousLayoutType == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        if (detailInterface == null || !detailInterface.canGoBack()) goto _L2; else goto _L1
_L1:
        detailInterface.goBack();
_L4:
        return true;
_L2:
        closeSplitView();
        if (detailInterface == null) goto _L4; else goto _L3
_L3:
        detailInterface.clearBackstack();
        return true;
        return false;
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

    public boolean isInSplitView()
    {
        return layoutType == SearchLayoutType.Split;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (configuration == null || oldOrientation == configuration.orientation)
        {
            return;
        }
        if (isInSplitView())
        {
            userState = layout.getUserState();
        }
        adjustViewForOrientation(configuration.orientation);
        oldOrientation = configuration.orientation;
    }

    public void onNewSearch(SearchTask searchtask)
    {
        closeLayout();
        hasViewType = false;
        resetSearchState();
        asinImpressionTracker.recordImpressions();
        searchDataSource.getCurrentSearch().addListener(taskListener);
        searchDataSource.getCurrentSearch().addListener(asinImpressionTracker.getSearchTaskListener());
        searchDataSource.getCurrentSearch().addListener(infoBar.getSearchTaskListener());
        openLayout(SearchLayoutType.valueOf(preferencesManager.getViewType().getName()));
    }

    public void onPause()
    {
        if (layout != null)
        {
            layout.pause();
        }
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

    public void onViewTypeUpdated(ViewType viewtype)
    {
        openLayout(SearchLayoutType.valueOf(viewtype.getName()));
    }

    public void openSplitView(String s)
    {
        int i = getResources().getConfiguration().orientation;
        boolean flag;
        boolean flag1;
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
        if (flag || flag1)
        {
            adjustViewForOrientation(i);
        }
        oldOrientation = i;
    }

    public void setDetailDisplayInterface(DetailDisplayInterface detaildisplayinterface)
    {
        detailInterface = detaildisplayinterface;
    }




/*
    static boolean access$102(SearchResultView searchresultview, boolean flag)
    {
        searchresultview.hasViewType = flag;
        return flag;
    }

*/

}
