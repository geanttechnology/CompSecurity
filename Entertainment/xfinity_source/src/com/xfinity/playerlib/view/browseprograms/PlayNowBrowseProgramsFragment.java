// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.common.FilterableProgramCollectionFragment;
import com.comcast.cim.android.view.common.Searchable;
import com.comcast.cim.android.view.flow.FilterRequestObserver;
import com.comcast.cim.cmasl.android.util.view.common.FilterChangeListener;
import com.comcast.cim.cmasl.android.util.view.widget.BreadcrumbAdapter;
import com.comcast.cim.cmasl.android.util.view.widget.BreadcrumbContainer;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.android.util.view.widget.EntityGridView;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.container.PlayerContainer;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            DibicProgramFilter, SortPolicy

public abstract class PlayNowBrowseProgramsFragment extends FilterableProgramCollectionFragment
    implements FilterChangeListener
{
    private class ProgramAdapter extends com.comcast.cim.cmasl.android.util.view.widget.EntityGridView.EntityGridViewAdapter
    {

        final PlayNowBrowseProgramsFragment this$0;
        private VideoEntitlement videoEntitlement;

        protected void bindItem(ProgramViewHolder programviewholder, DibicProgram dibicprogram)
        {
            boolean flag = true;
            LOG.debug((new StringBuilder()).append("Binding for: ").append(dibicprogram.getMerlinId()).toString());
            Network network = null;
            Object obj = null;
            String s = dibicprogram.getTitle();
            if (programviewholder.title != null)
            {
                programviewholder.title.setText(s);
            }
            com.comcast.cim.android.image.CimImageLoader.OnLoadListener onloadlistener;
            final boolean placeHolderTitleIsPresent;
            boolean flag1;
            if (programviewholder.placeholderTitle != null)
            {
                placeHolderTitleIsPresent = true;
            } else
            {
                placeHolderTitleIsPresent = false;
            }
            if (placeHolderTitleIsPresent)
            {
                programviewholder.placeholderTitle.setText(s);
            }
            onloadlistener = programviewholder. new com.comcast.cim.android.image.CimImageLoader.OnLoadListener() {

                final ProgramAdapter this$1;
                final ProgramViewHolder val$holder;
                final boolean val$placeHolderTitleIsPresent;

                public void onLoad(ImageView imageview, String s, Bitmap bitmap)
                {
                    if (placeHolderTitleIsPresent)
                    {
                        holder.placeholderTitle.setText(null);
                    }
                }

                public void onLoadError(ImageView imageview, String s)
                {
                }

            
            {
                this$1 = final_programadapter;
                placeHolderTitleIsPresent = flag;
                holder = ProgramViewHolder.this;
                super();
            }
            };
            flag1 = coverArtImageLoader.loadImageFromMemory(dibicprogram, programviewholder.coverArt, onloadlistener);
            if (networkLogoLoader.isFlinging())
            {
                programviewholder.coverArt.setTag(null);
                if (!flag1)
                {
                    programviewholder.coverArt.setImageDrawable(null);
                }
            } else
            {
                programviewholder.coverArt.setImageDrawable(null);
                coverArtImageLoader.loadImage(dibicprogram, programviewholder.coverArt, onloadlistener);
            }
            if (dibicprogram.isDownloadable())
            {
                programviewholder.downloadIndicator.setVisibility(0);
            } else
            {
                programviewholder.downloadIndicator.setVisibility(8);
            }
            if (!shouldSuppressNetworkLogos)
            {
                network = obj;
                if (dibicprogram.getNetworks().size() == 1)
                {
                    network = (Network)dibicprogram.getNetworks().iterator().next();
                }
                programviewholder.networkLogo.setImageDrawable(null);
                if (network != null && network.isPremium())
                {
                    programviewholder.networkLogo.setVisibility(0);
                    networkLogoLoader.loadNetworkLogoSmall(network.getCompanyId(), programviewholder.networkLogo);
                } else
                {
                    programviewholder.networkLogo.setVisibility(8);
                }
            }
            if (programviewholder.year != null)
            {
                if (dibicprogram.getReleaseYear() > 0)
                {
                    programviewholder.year.setText(Integer.toString(dibicprogram.getReleaseYear()));
                    programviewholder.year.setVisibility(0);
                } else
                {
                    programviewholder.year.setVisibility(8);
                }
            }
            if (!videoEntitlement.isEntitled(dibicprogram))
            {
                programviewholder.lockedIndicator.setVisibility(0);
            } else
            {
                programviewholder.lockedIndicator.setVisibility(8);
            }
            if (programviewholder.newIcon != null)
            {
                if (dibicprogram.isNew() && !dibicprogram.isMovie())
                {
                    programviewholder.newIcon.setVisibility(0);
                } else
                {
                    programviewholder.newIcon.setVisibility(8);
                }
            }
            if (placeHolderTitleIsPresent && isAccessibilityEnabled)
            {
                if (network != null && network.isPremium())
                {
                    dibicprogram = network.getName();
                } else
                {
                    dibicprogram = "";
                }
                if (programviewholder.downloadIndicator.getVisibility() == 0)
                {
                    placeHolderTitleIsPresent = flag;
                } else
                {
                    placeHolderTitleIsPresent = false;
                }
                programviewholder.placeholderTitle.setContentDescription(getContainerDescription(s, dibicprogram, placeHolderTitleIsPresent));
            }
        }

        protected volatile void bindItem(Object obj, Object obj1)
        {
            bindItem((ProgramViewHolder)obj, (DibicProgram)obj1);
        }

        protected ProgramViewHolder createViewHolder()
        {
            return new ProgramViewHolder();
        }

        protected volatile Object createViewHolder()
        {
            return createViewHolder();
        }

        public String getContainerDescription(String s, String s1, boolean flag)
        {
            String s2 = getString(com.xfinity.playerlib.R.string.content_description_entity_list_view_grid);
            s2 = getString(com.xfinity.playerlib.R.string.content_description_container_for_entity, new Object[] {
                s, networkLogoLoader.getContentDescription(), s2
            });
            s = s2;
            if (s1.length() > 0)
            {
                s = getString(com.xfinity.playerlib.R.string.content_description_container_for_entity_with_network, new Object[] {
                    s2, s1
                });
            }
            s1 = s;
            if (flag)
            {
                s1 = getString(com.xfinity.playerlib.R.string.content_description_container_for_entity_with_available_for_download, new Object[] {
                    s
                });
            }
            return s1;
        }

        protected int getViewLayoutId()
        {
            return com.xfinity.playerlib.R.layout.browse_program_item;
        }

        protected void initializeViewHolder(View view, ViewGroup viewgroup, ProgramViewHolder programviewholder)
        {
            programviewholder.coverArt = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.cover_art);
            programviewholder.networkLogo = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.network_logo);
            programviewholder.lockedIndicator = view.findViewById(com.xfinity.playerlib.R.id.locked_indicator);
            programviewholder.downloadIndicator = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.download_indicator);
            programviewholder.year = (TextView)view.findViewById(com.xfinity.playerlib.R.id.year);
            programviewholder.title = (TextView)view.findViewById(com.xfinity.playerlib.R.id.title);
            programviewholder.placeholderTitle = (TextView)view.findViewById(com.xfinity.playerlib.R.id.placeholder_title);
            programviewholder.newIcon = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.new_indicator);
        }

        protected volatile void initializeViewHolder(View view, ViewGroup viewgroup, Object obj)
        {
            initializeViewHolder(view, viewgroup, (ProgramViewHolder)obj);
        }

        public void setVideoEntitlement(VideoEntitlement videoentitlement)
        {
            videoEntitlement = videoentitlement;
        }

        public ProgramAdapter(LayoutInflater layoutinflater)
        {
            this$0 = PlayNowBrowseProgramsFragment.this;
            super(layoutinflater);
        }
    }

    private static class ProgramViewHolder
    {

        public ImageView coverArt;
        public ImageView downloadIndicator;
        public View lockedIndicator;
        public ImageView networkLogo;
        public ImageView newIcon;
        public TextView placeholderTitle;
        public TextView title;
        public TextView year;

        private ProgramViewHolder()
        {
        }

    }

    protected class SortButtonOnTouchListener
        implements android.view.View.OnTouchListener
    {

        private final SortPolicy.SortType sortType;
        final PlayNowBrowseProgramsFragment this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 0)
            {
                return true;
            }
            if (motionevent.getAction() != 1)
            {
                return false;
            } else
            {
                getSortPolicy().setCurrentSortType(sortType);
                updateSortButtonStates(sortType);
                alternateInterfaceListener.getTalkDelegate().speak(((ViewGroup)view).getChildAt(0).getContentDescription().toString());
                applyFilter();
                return true;
            }
        }

        public SortButtonOnTouchListener(SortPolicy.SortType sorttype)
        {
            this$0 = PlayNowBrowseProgramsFragment.this;
            super();
            sortType = sorttype;
        }
    }


    private final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment);
    protected final AccessibilityUtil accessibilityUtil = PlayerContainer.getInstance().getAccessibilityUtil();
    protected ViewGroup alphaSortButton;
    protected AlternateInterfaceListener alternateInterfaceListener;
    protected BookmarkUtils bookmarkUtils;
    protected BreadcrumbContainer breadcrumbContainer;
    protected final CoverArtImageLoader coverArtImageLoader = PlayerContainer.getInstance().createCoverArtImageLoader();
    private boolean isAccessibilityEnabled;
    private SortPolicy.SortType lastSort;
    protected final NetworkLogoImageLoader networkLogoLoader = PlayerContainer.getInstance().createNetworkLogoImageLoader();
    protected ViewGroup otherSortButton;
    protected ViewGroup popularityButton;
    private ProgramAdapter programAdapter;
    protected boolean shouldShowFilterButton;
    private final boolean shouldSuppressNetworkLogos = PlayerContainer.getInstance().getConfiguration().shouldSuppressNetworkLogos();
    private HashMap sortButtonContentDescriptions;
    protected final PlayNowTrackingService trackingService = PlayerContainer.getInstance().getTrackingService();
    protected final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();

    public PlayNowBrowseProgramsFragment()
    {
        bookmarkUtils = PlayerContainer.getInstance().getBookmarkUtils();
        shouldShowFilterButton = true;
        sortButtonContentDescriptions = new HashMap();
    }

    private BreadcrumbAdapter getBreadcrumbAdapter()
    {
        return new BreadcrumbAdapter() {

            final PlayNowBrowseProgramsFragment this$0;

            protected void addItemsForFilterMap(LayoutInflater layoutinflater, LinearLayout linearlayout, final DibicProgramFilter filterValue, Map map, DibicProgramFilter.FilterCategory filtercategory)
            {
                View view;
                for (map = map.entrySet().iterator(); map.hasNext(); linearlayout.addView(view))
                {
                    final java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                    view = layoutinflater.inflate(getItemLayoutId(), null);
                    TextView textview = (TextView)view.findViewById(getItemLabelViewId());
                    textview.setText((CharSequence)entry.getValue());
                    textview.setContentDescription(linearlayout.getContext().getString(com.xfinity.playerlib.R.string.content_description_button_state_selected, new Object[] {
                        textview.getText().toString()
                    }));
                    view.setOnClickListener(filtercategory. new android.view.View.OnClickListener() {

                        final _cls2 this$1;
                        final java.util.Map.Entry val$entry;
                        final DibicProgramFilter val$filterValue;
                        final DibicProgramFilter.FilterCategory val$searchCategory;

                        public void onClick(View view)
                        {
                            filterValue.removeFromSelectedList((String)entry.getKey(), searchCategory);
                        }

            
            {
                this$1 = final__pcls2;
                filterValue = dibicprogramfilter;
                entry = entry1;
                searchCategory = DibicProgramFilter.FilterCategory.this;
                super();
            }
                    });
                }

            }

            public void addViews(LayoutInflater layoutinflater, ViewGroup viewgroup, DibicProgramFilter dibicprogramfilter)
            {
                if (dibicprogramfilter.empty())
                {
                    return;
                }
                viewgroup = (LinearLayout)layoutinflater.inflate(com.xfinity.playerlib.R.layout.breadcrumb_scroll, viewgroup).findViewById(com.xfinity.playerlib.R.id.breadcrumb_scroller);
                addLeadIfApplicable(layoutinflater, viewgroup);
                if (dibicprogramfilter.isHideLockOn())
                {
                    View view = layoutinflater.inflate(com.xfinity.playerlib.R.layout.breadcrumb_item, null);
                    TextView textview = (TextView)view.findViewById(com.xfinity.playerlib.R.id.label);
                    textview.setText(getResources().getText(com.xfinity.playerlib.R.string.filter_hide_locked));
                    textview.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_button_state_selected, new Object[] {
                        textview.getText().toString()
                    }));
                    view.setOnClickListener(dibicprogramfilter. new android.view.View.OnClickListener() {

                        final _cls2 this$1;
                        final DibicProgramFilter val$filterValue;

                        public void onClick(View view)
                        {
                            filterValue.setHideLockOn(false);
                        }

            
            {
                this$1 = final__pcls2;
                filterValue = DibicProgramFilter.this;
                super();
            }
                    });
                    viewgroup.addView(view);
                }
                if (dibicprogramfilter.isDownloadableOn())
                {
                    View view1 = layoutinflater.inflate(com.xfinity.playerlib.R.layout.breadcrumb_item, null);
                    TextView textview1 = (TextView)view1.findViewById(com.xfinity.playerlib.R.id.label);
                    textview1.setText(getResources().getText(com.xfinity.playerlib.R.string.filter_downloadable));
                    textview1.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_button_state_selected, new Object[] {
                        textview1.getText().toString()
                    }));
                    view1.setOnClickListener(dibicprogramfilter. new android.view.View.OnClickListener() {

                        final _cls2 this$1;
                        final DibicProgramFilter val$filterValue;

                        public void onClick(View view)
                        {
                            filterValue.setDownloadableOn(false);
                        }

            
            {
                this$1 = final__pcls2;
                filterValue = DibicProgramFilter.this;
                super();
            }
                    });
                    viewgroup.addView(view1);
                }
                addItemsForFilterMap(layoutinflater, viewgroup, dibicprogramfilter, dibicprogramfilter.getCurrentGenreFilters(), DibicProgramFilter.FilterCategory.GENRE);
                addItemsForFilterMap(layoutinflater, viewgroup, dibicprogramfilter, dibicprogramfilter.getCurrentNetworkFilters(), DibicProgramFilter.FilterCategory.NETWORK);
                addItemsForFilterMap(layoutinflater, viewgroup, dibicprogramfilter, dibicprogramfilter.getCurrentAlphaFilters(), DibicProgramFilter.FilterCategory.ALPHA);
                addItemsForFilterMap(layoutinflater, viewgroup, dibicprogramfilter, dibicprogramfilter.getCurrentProgramTypeFilters(), DibicProgramFilter.FilterCategory.PROGRAM_TYPE);
                addCommasAndSpacing(viewgroup);
                viewgroup.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_filter_breadcrumb_container, new Object[] {
                    Integer.valueOf(viewgroup.getChildCount())
                }));
            }

            public volatile void addViews(LayoutInflater layoutinflater, ViewGroup viewgroup, Object obj)
            {
                addViews(layoutinflater, viewgroup, (DibicProgramFilter)obj);
            }

            protected int getItemLabelViewId()
            {
                return com.xfinity.playerlib.R.id.label;
            }

            protected int getItemLayoutId()
            {
                return com.xfinity.playerlib.R.layout.breadcrumb_item;
            }

            
            {
                this$0 = PlayNowBrowseProgramsFragment.this;
                super();
            }
        };
    }

    private void makeSortButtonAccessible(View view)
    {
        accessibilityUtil.setImportantForAccessibility(view, 1);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
    }

    private void setApplicableBreadcrumbContainerVisibility(DibicProgramFilter dibicprogramfilter)
    {
        if (sortBar != null)
        {
            int j = breadcrumbContainer.getVisibility();
            int i;
            if (dibicprogramfilter.empty())
            {
                i = 8;
            } else
            {
                i = 0;
            }
            breadcrumbContainer.setVisibility(i);
            if (j != i)
            {
                if (i == 0)
                {
                    i = 1;
                } else
                {
                    i = -1;
                }
                adjustQuickReturnView(getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.breadcrumb_container_height) * i);
                layout.requestLayout();
            }
        }
    }

    private void updateBreadcrumbs(DibicProgramFilter dibicprogramfilter)
    {
        breadcrumbContainer.update(dibicprogramfilter);
        setApplicableBreadcrumbContainerVisibility(dibicprogramfilter);
    }

    protected void applyFilter()
    {
        LOG.debug("applyFilter: Start");
        getLoadingViewDelegate().onLoadingStarted();
        getTaskExecutor().execute(getTaskExecutionListener());
    }

    protected void displayPrograms(List list, VideoEntitlement videoentitlement)
    {
        SortPolicy sortpolicy = getSortPolicy();
        Object obj = list;
        if (sortpolicy.getCurrentSortComparator() != null)
        {
            obj = Lists.newArrayList(list);
            Collections.sort(((List) (obj)), sortpolicy.getCurrentSortComparator());
        }
        list = getFilterValue().getFilteredPrograms(((List) (obj)), videoentitlement);
        programAdapter.setEntities(list);
        programAdapter.setVideoEntitlement(videoentitlement);
        videoentitlement = sortpolicy.getCurrentSortType();
        if (lastSort == null || videoentitlement.equals(lastSort))
        {
            entityGridView.update();
        } else
        {
            entityGridView.reset();
        }
        lastSort = videoentitlement;
        LOG.debug((new StringBuilder()).append("displayPrograms() programs.size()=").append(list.size()).toString());
        if (list.isEmpty())
        {
            hideSortButtons();
        } else
        if (videoentitlement != SortPolicy.SortType.NONE)
        {
            showSortButtons();
        } else
        {
            hideSortButtons();
        }
        getLoadingViewDelegate().onLoadingFinished();
        enableFilterButton();
    }

    protected int getBodyContainerId()
    {
        return com.xfinity.playerlib.R.id.body_container;
    }

    protected abstract CharSequence getContentDescriptionForAccessibility();

    protected abstract Bundle getFilterBundle();

    protected int getFilterButtonId()
    {
        return com.xfinity.playerlib.R.id.filter_btn;
    }

    protected android.view.View.OnClickListener getFilterButtonOnClickListener()
    {
        return new android.view.View.OnClickListener() ;
    }

    protected abstract DibicProgramFilter getFilterValue();

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.browse;
    }

    protected int getListViewHeaderId()
    {
        return com.xfinity.playerlib.R.id.sort_bar;
    }

    protected int getListViewId()
    {
        return com.xfinity.playerlib.R.id.listView;
    }

    protected int getLoadingIndicatorId()
    {
        return com.xfinity.playerlib.R.id.loading_indicator;
    }

    protected BaseAdapter getProgramAdapter(LayoutInflater layoutinflater)
    {
        if (programAdapter == null)
        {
            programAdapter = new ProgramAdapter(layoutinflater);
        }
        return programAdapter;
    }

    protected View getQuickReturnView(View view)
    {
        View view2 = view.findViewById(com.xfinity.playerlib.R.id.sort_bar);
        View view1 = view2;
        if (view2 == null)
        {
            view1 = view.findViewById(com.xfinity.playerlib.R.id.FilterSubNavBar);
        }
        return view1;
    }

    protected abstract SortPolicy getSortPolicy();

    protected abstract TaskExecutionListener getTaskExecutionListener();

    protected abstract TaskExecutor getTaskExecutor();

    protected int getTopScrollingShadowId()
    {
        return com.xfinity.playerlib.R.id.topScrollingShadow;
    }

    protected abstract void hideSortButtons();

    protected boolean isSortable()
    {
        return true;
    }

    public void onAttach(Activity activity)
    {
        onAttach(activity);
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public void onCreate(Bundle bundle)
    {
        onCreate(bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        onCreateOptionsMenu(menu, menuinflater);
        if ((searchable == null || !searchable.isSearching()) && getResources().getBoolean(com.xfinity.playerlib.R.bool.actionbar_show_filter_item) && shouldShowFilterButton)
        {
            menuinflater.inflate(com.xfinity.playerlib.R.menu.filter_menu, menu);
            menu.findItem(com.xfinity.playerlib.R.id.menu_item_filter).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() );
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = onCreateView(layoutinflater, viewgroup, bundle);
        breadcrumbContainer = (BreadcrumbContainer)CommonUtils.uncheckedCast(layoutinflater.findViewById(com.xfinity.playerlib.R.id.breadcrumb_container));
        breadcrumbContainer.setAdapter(getBreadcrumbAdapter());
        if (accessibilityUtil.isAccessibilityEnabled())
        {
            entityGridView.setContentDescription(getContentDescriptionForAccessibility());
        }
        return layoutinflater;
    }

    public void onFilterChange(DibicProgramFilter dibicprogramfilter)
    {
        updateBreadcrumbs(dibicprogramfilter);
        applyFilter();
    }

    public volatile void onFilterChange(Object obj)
    {
        onFilterChange((DibicProgramFilter)obj);
    }

    public void onPause()
    {
        DibicProgramFilter dibicprogramfilter;
        onPause();
        dibicprogramfilter = null;
        DibicProgramFilter dibicprogramfilter1 = getFilterValue();
        dibicprogramfilter = dibicprogramfilter1;
_L2:
        if (dibicprogramfilter != null)
        {
            dibicprogramfilter.unregisterOnChangeListener(this);
            dibicprogramfilter.unregisterOnChangeListener(breadcrumbContainer);
        }
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        LOG.error("userSettings is null when I don't expect it to be.", illegalstateexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
        menu = menu.findItem(com.xfinity.playerlib.R.id.menu_item_filter);
        if (menu != null)
        {
            menu.setEnabled(getLoadingViewDelegate().resourcesLoaded());
        }
    }

    public void onResumeInternal()
    {
        onResumeInternal();
        DibicProgramFilter dibicprogramfilter = getFilterValue();
        dibicprogramfilter.registerOnChangeListener(this);
        dibicprogramfilter.registerOnChangeListener(breadcrumbContainer);
        onFilterChange(dibicprogramfilter);
        updateSortButtonStates(getSortPolicy().getCurrentSortType());
        isAccessibilityEnabled = accessibilityUtil.isAccessibilityEnabled();
        entityGridView.setAccessibilityEnabled(isAccessibilityEnabled);
    }

    public void onStop()
    {
        onStop();
        getTaskExecutor().cancelNotificationsFor(getTaskExecutionListener());
        coverArtImageLoader.purgeJobs();
        networkLogoLoader.purgeJobs();
    }

    protected void select(ViewGroup viewgroup)
    {
        viewgroup.setSelected(true);
        updateButtonStateContentDescription(viewgroup, true);
    }

    protected void setupOtherButton(ViewGroup viewgroup, Button button, String s, String s1)
    {
        button.setText(s);
        button.setContentDescription(s1);
        sortButtonContentDescriptions.remove(viewgroup);
        updateButtonStateContentDescription(viewgroup, viewgroup.isSelected());
    }

    protected void setupSortButtons(ViewGroup viewgroup, List list)
    {
        if (sortBar != null) goto _L2; else goto _L1
_L1:
        popularityButton = (ViewGroup)viewgroup.findViewById(com.xfinity.playerlib.R.id.popularitySort);
        otherSortButton = (ViewGroup)viewgroup.findViewById(com.xfinity.playerlib.R.id.otherSort);
        alphaSortButton = (ViewGroup)viewgroup.findViewById(com.xfinity.playerlib.R.id.alphabetSort);
_L4:
        if (list != null)
        {
            if (!list.contains(SortPolicy.SortType.POPULAR))
            {
                break; /* Loop/switch isn't completed */
            }
            popularityButton.setOnTouchListener(new SortButtonOnTouchListener((SortPolicy.SortType)list.get(0)));
            otherSortButton.setOnTouchListener(new SortButtonOnTouchListener((SortPolicy.SortType)list.get(1)));
            alphaSortButton.setOnTouchListener(new SortButtonOnTouchListener((SortPolicy.SortType)list.get(2)));
        }
        return;
_L2:
        popularityButton = (ViewGroup)sortBar.findViewById(com.xfinity.playerlib.R.id.popularitySort);
        otherSortButton = (ViewGroup)sortBar.findViewById(com.xfinity.playerlib.R.id.otherSort);
        alphaSortButton = (ViewGroup)sortBar.findViewById(com.xfinity.playerlib.R.id.alphabetSort);
        if (accessibilityUtil.isAccessibilityEnabled())
        {
            if (list.contains(SortPolicy.SortType.POPULAR))
            {
                makeSortButtonAccessible(popularityButton);
            }
            makeSortButtonAccessible(otherSortButton);
            makeSortButtonAccessible(alphaSortButton);
        }
        if (true) goto _L4; else goto _L3
_L3:
        popularityButton.setVisibility(8);
        otherSortButton.setOnTouchListener(new SortButtonOnTouchListener((SortPolicy.SortType)list.get(0)));
        alphaSortButton.setOnTouchListener(new SortButtonOnTouchListener((SortPolicy.SortType)list.get(1)));
        return;
    }

    protected void showFilterButton()
    {
        shouldShowFilterButton = true;
        if (filterButton != null)
        {
            filterButton.setVisibility(0);
            return;
        } else
        {
            setHasOptionsMenu(true);
            return;
        }
    }

    protected abstract void showSortButtons();

    protected void unselect(ViewGroup viewgroup)
    {
        viewgroup.setSelected(false);
        updateButtonStateContentDescription(viewgroup, false);
    }

    protected void updateButtonStateContentDescription(ViewGroup viewgroup, boolean flag)
    {
        Button button = (Button)viewgroup.getChildAt(0);
        if (!sortButtonContentDescriptions.containsKey(viewgroup))
        {
            sortButtonContentDescriptions.put(viewgroup, button.getContentDescription().toString());
        }
        int i;
        if (flag)
        {
            i = com.xfinity.playerlib.R.string.content_description_button_state_selected;
        } else
        {
            i = com.xfinity.playerlib.R.string.content_description_button_state_not_selected;
        }
        button.setContentDescription(getString(i, new Object[] {
            sortButtonContentDescriptions.get(viewgroup)
        }));
    }

    protected abstract void updateSortButtonStates(SortPolicy.SortType sorttype);








}
