// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.cmasl.utils.collections.CollectionUtils;
import com.comcast.cim.cmasl.utils.container.Tuple4;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.utils.UIPresentationUtil;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.model.CoverVideo;
import com.xfinity.playerlib.model.EditorialMovie;
import com.xfinity.playerlib.model.EditorialProgram;
import com.xfinity.playerlib.model.EditorialTVSeries;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.editorial.FeaturedResource;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            FeaturedFragment, PhoneCoverAdapter, FeaturedSection

public class PhoneFeaturedFragment extends FeaturedFragment
{
    protected class AccessibleOnScrollListener
        implements android.widget.AbsListView.OnScrollListener
    {

        private String description;
        final PhoneFeaturedFragment this$0;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
            abslistview.setContentDescription(UIPresentationUtil.getAbsListStateDescription(abslistview, description, i, j, k));
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
        }

        public void setDescription(String s)
        {
            description = s;
        }

        protected AccessibleOnScrollListener()
        {
            this$0 = PhoneFeaturedFragment.this;
            super();
        }
    }

    private class EntityTabFactory
        implements android.widget.TabHost.TabContentFactory
    {

        final PhoneFeaturedFragment this$0;

        public View createTabContent(String s)
        {
            s = new View(getActivity());
            s.setMinimumHeight(0);
            s.setMinimumWidth(0);
            return s;
        }

        private EntityTabFactory()
        {
            this$0 = PhoneFeaturedFragment.this;
            super();
        }

    }

    private class FeaturedPagerAdapter extends PagerAdapter
    {

        private List labels;
        private List programLists;
        final PhoneFeaturedFragment this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            viewgroup.removeView((View)obj);
        }

        public int getCount()
        {
            return labels.size();
        }

        public CharSequence getPageTitle(int i)
        {
            return (CharSequence)labels.get(i);
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            return buildCoverView(viewgroup, FeaturedSection.values()[i], (List)programLists.get(i), getPageTitle(i).toString());
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view == obj;
        }

        public void setData(FeaturedResource featuredresource)
        {
            labels = Lists.newArrayList(new String[] {
                featuredresource.getCoverVideoCollectionTitle(), featuredresource.getSeriesCollectionTitle(), featuredresource.getMovieCollectionTitle()
            });
            programLists = CollectionUtils.createList(featuredresource.getCoverVideos(), featuredresource.getSeries(), featuredresource.getMovies());
            notifyDataSetChanged();
        }

        public FeaturedPagerAdapter()
        {
            this$0 = PhoneFeaturedFragment.this;
            super();
            labels = Lists.newArrayList();
            programLists = Lists.newArrayList();
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/featured/PhoneFeaturedFragment);
    private AlternateInterfaceListener alternateInterfaceListener;
    private final PlayerConfiguration configuration = PlayerContainer.getInstance().getConfiguration();
    private FeaturedPagerAdapter pagerAdapter;
    private TabHost tabHost;
    private ViewPager viewPager;

    public PhoneFeaturedFragment()
    {
    }

    private View buildCoverView(ViewGroup viewgroup, final FeaturedSection featuredSection, List list, String s)
    {
        View view = View.inflate(getActivity(), com.xfinity.playerlib.R.layout.featured_cover, null);
        final ListView gallery = (ListView)view.findViewById(com.xfinity.playerlib.R.id.coverList);
        setupAccessibleScrollListener(gallery, s);
        s = new PhoneCoverAdapter(layoutInflator, coverArtImageLoader, networkLogoLoader, configuration, s);
        s.setData(list, videoEntitlement, premiumNetworks);
        gallery.setAdapter(s);
        gallery.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PhoneFeaturedFragment this$0;
            final FeaturedSection val$featuredSection;
            final ListView val$gallery;

            public void onItemClick(AdapterView adapterview, View view1, int i, long l)
            {
                if (featuredSection == FeaturedSection.TV_SERIES)
                {
                    showDetail(((EditorialTVSeries)gallery.getAdapter().getItem(i)).getMerlinId());
                    return;
                }
                if (featuredSection == FeaturedSection.MOVIES)
                {
                    showDetail(((EditorialMovie)gallery.getAdapter().getItem(i)).getMerlinId());
                    return;
                } else
                {
                    adapterview = (CoverVideo)gallery.getAdapter().getItem(i);
                    showDetail(adapterview.getParentMerlinIdIfApplicable(), adapterview.getEpisodeMerlinId());
                    return;
                }
            }

            
            {
                this$0 = PhoneFeaturedFragment.this;
                featuredSection = featuredsection;
                gallery = listview;
                super();
            }
        });
        gallery.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() {

            final PhoneFeaturedFragment this$0;
            final FeaturedSection val$featuredSection;
            final ListView val$gallery;

            public boolean onItemLongClick(AdapterView adapterview, View view1, int i, long l)
            {
                if (featuredSection != FeaturedSection.TV_SERIES) goto _L2; else goto _L1
_L1:
                adapterview = (EditorialTVSeries)gallery.getAdapter().getItem(i);
                bookmarkUtils.promptBookmarkDialog(PhoneFeaturedFragment.this, new VideoFavorite(adapterview.getParentMerlinIdIfApplicable(), adapterview.getTitle()));
_L4:
                return true;
_L2:
                if (featuredSection == FeaturedSection.MOVIES)
                {
                    adapterview = (EditorialMovie)gallery.getAdapter().getItem(i);
                    bookmarkUtils.promptBookmarkDialog(PhoneFeaturedFragment.this, new VideoFavorite(adapterview.getMerlinId(), adapterview.getTitle()));
                } else
                {
                    adapterview = (CoverVideo)adapterview.getItemAtPosition(i);
                    if (adapterview.getEntityType().equalsIgnoreCase("Movie"))
                    {
                        bookmarkUtils.promptBookmarkDialog(PhoneFeaturedFragment.this, new VideoFavorite(adapterview.getMerlinId(), adapterview.getTitle()));
                    } else
                    if (adapterview.getEntityType().equalsIgnoreCase("TvSeries"))
                    {
                        bookmarkUtils.promptBookmarkDialog(PhoneFeaturedFragment.this, new VideoFavorite(adapterview.getParentMerlinIdIfApplicable(), adapterview.getTitle()));
                    }
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = PhoneFeaturedFragment.this;
                featuredSection = featuredsection;
                gallery = listview;
                super();
            }
        });
        viewgroup.addView(view);
        return view;
    }

    private void prepareTabHost(List list)
    {
        tabHost.clearAllTabs();
        String s;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); tabHost.addTab(tabHost.newTabSpec(s).setIndicator(s).setContent(new EntityTabFactory())))
        {
            s = (String)iterator.next();
        }

        tabHost.setOnTabChangedListener(new android.widget.TabHost.OnTabChangeListener() {

            final PhoneFeaturedFragment this$0;

            public void onTabChanged(String s1)
            {
                int j = tabHost.getCurrentTab();
                viewPager.setCurrentItem(j);
            }

            
            {
                this$0 = PhoneFeaturedFragment.this;
                super();
            }
        });
        for (int i = 0; i < list.size(); i++)
        {
            ((TextView)tabHost.getTabWidget().getChildAt(i).findViewById(0x1020016)).setAllCaps(false);
        }

    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.new_featured;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        viewPager = (ViewPager)layoutinflater.findViewById(com.xfinity.playerlib.R.id.pager);
        tabHost = (TabHost)layoutinflater.findViewById(com.xfinity.playerlib.R.id.tabs);
        tabHost.setup();
        pagerAdapter = new FeaturedPagerAdapter();
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final PhoneFeaturedFragment this$0;

            public void onPageScrollStateChanged(int i)
            {
            }

            public void onPageScrolled(int i, float f, int j)
            {
            }

            public void onPageSelected(int i)
            {
                tabHost.setCurrentTab(i);
                if (alternateInterfaceListener.isAccessibilityEnabled())
                {
                    tabHost.getRootView().findViewById(com.xfinity.playerlib.R.id.coverList).requestFocus();
                }
            }

            
            {
                this$0 = PhoneFeaturedFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
    }

    protected void postOnResourceFetched(Tuple4 tuple4)
    {
        tuple4 = (FeaturedResource)tuple4.e2;
        pagerAdapter.setData(tuple4);
        prepareTabHost(Lists.newArrayList(new String[] {
            tuple4.getCoverVideoCollectionTitle(), tuple4.getSeriesCollectionTitle(), tuple4.getMovieCollectionTitle()
        }));
    }

    protected void setupAccessibleScrollListener(AbsListView abslistview, String s)
    {
        AccessibleOnScrollListener accessibleonscrolllistener = new AccessibleOnScrollListener();
        accessibleonscrolllistener.setDescription(s);
        abslistview.setOnScrollListener(accessibleonscrolllistener);
    }





}
