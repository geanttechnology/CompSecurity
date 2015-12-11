// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.model.provider.RetryingTaskExecutionListener;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.model.comparator.DibicProgramTitleComparator;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import com.xfinity.playerlib.model.tags.Tag;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment, EmbeddedTagFinder, SearchQuery

class is._cls0 extends alloutClickListener
{

    final onTagSelected this$1;
    final Set val$genreFilters;

    protected void onTagSelected(OrderedTag orderedtag)
    {
        val$genreFilters.add(orderedtag);
    }

    protected volatile void onTagSelected(Tag tag)
    {
        onTagSelected((OrderedTag)tag);
    }

    (Set set)
    {
        this$1 = final_;
        val$genreFilters = set;
        super(final_._fld0, OrderedTag.this);
    }

    // Unreferenced inner class com/xfinity/playerlib/view/search/SearchResultsFragment$4

/* anonymous class */
    class SearchResultsFragment._cls4 extends RetryingTaskExecutionListener
    {

        final SearchResultsFragment this$0;
        final SearchQuery val$searchQuery;
        final String val$titleQuery;

        public void onPostExecute(final Tuple final_network)
        {
            Object obj = (TagsRoot)final_network.e1;
            if (!obj.equals(SearchResultsFragment.access$300(SearchResultsFragment.this)))
            {
                SearchResultsFragment.access$302(SearchResultsFragment.this, ((TagsRoot) (obj)));
                SearchResultsFragment.access$402(SearchResultsFragment.this, new EmbeddedTagFinder(SearchResultsFragment.access$300(SearchResultsFragment.this).getAllPublicGenres()));
                SearchResultsFragment.access$502(SearchResultsFragment.this, new EmbeddedTagFinder(SearchResultsFragment.access$300(SearchResultsFragment.this).getNetworks()));
            }
            SearchResultsFragment.access$602(SearchResultsFragment.this, (DibicResource)final_network.e2);
            Object obj1 = searchQuery.getNetworkFilters();
            Set set = searchQuery.getGenreFilters();
            Object obj2 = searchQuery.getTagFilters();
            Object obj3;
            if (((Set) (obj2)).size() < 3)
            {
                final_network = (Network)SearchResultsFragment.access$700(SearchResultsFragment.this, titleQuery, SearchResultsFragment.access$500(SearchResultsFragment.this), ((Set) (obj1)));
                if (final_network != null)
                {
                    obj = getResources().getString(com.xfinity.playerlib.R.string.search_network_callout);
                    SearchResultsFragment.TagCalloutClickListener tagcalloutclicklistener = new SearchResultsFragment._cls4._cls1(((Set) (obj1)));
                    SearchResultsFragment.access$800(SearchResultsFragment.this, final_network, ((String) (obj)), tagcalloutclicklistener);
                } else
                {
                    final_network = (OrderedTag)SearchResultsFragment.access$700(SearchResultsFragment.this, titleQuery, SearchResultsFragment.access$400(SearchResultsFragment.this), set);
                    if (final_network != null)
                    {
                        obj = getResources().getString(com.xfinity.playerlib.R.string.search_genre_callout);
                        obj3 = final_network. new SearchResultsFragment._cls4._cls2(set);
                        SearchResultsFragment.access$800(SearchResultsFragment.this, final_network, ((String) (obj)), ((SearchResultsFragment.TagCalloutClickListener) (obj3)));
                    } else
                    {
                        SearchResultsFragment.access$900(SearchResultsFragment.this).setVisibility(8);
                    }
                }
            } else
            {
                SearchResultsFragment.access$900(SearchResultsFragment.this).setVisibility(8);
            }
            obj3 = new StopWatch();
            ((StopWatch) (obj3)).start();
            final_network = SearchResultsFragment.access$600(SearchResultsFragment.this).getProgramsMatchingTitleFilter(titleQuery);
            obj = final_network;
            if (!((Set) (obj2)).isEmpty())
            {
                if (titleQuery.isEmpty())
                {
                    final_network = SearchResultsFragment.access$600(SearchResultsFragment.this).getPrograms();
                }
                obj2 = final_network.iterator();
                do
                {
                    obj = final_network;
                    if (!((Iterator) (obj2)).hasNext())
                    {
                        break;
                    }
                    obj = (DibicProgram)((Iterator) (obj2)).next();
                    if (!((Set) (obj1)).isEmpty() && !SearchResultsFragment.access$1100(SearchResultsFragment.this, ((DibicProgram) (obj)), ((Set) (obj1)), SearchResultsFragment.access$1000(SearchResultsFragment.this)) || !set.isEmpty() && !SearchResultsFragment.access$1100(SearchResultsFragment.this, ((DibicProgram) (obj)), set, SearchResultsFragment.access$1200(SearchResultsFragment.this)))
                    {
                        ((Iterator) (obj2)).remove();
                    }
                } while (true);
            }
            Collections.sort(((List) (obj)), new DibicProgramTitleComparator(true));
            ((StopWatch) (obj3)).stop();
            SearchResultsFragment.access$1300().debug((new StringBuilder()).append("Search performed in ").append(obj3).toString());
            obj1 = Lists.newArrayList();
            final_network = Lists.newArrayList();
            DibicProgram dibicprogram;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); final_network.add(new Tuple(SearchResultsFragment.ListSection.FULL, dibicprogram)))
            {
                dibicprogram = (DibicProgram)((Iterator) (obj)).next();
                if (dibicprogram.isNew())
                {
                    ((List) (obj1)).add(new Tuple(SearchResultsFragment.ListSection.NEW, dibicprogram));
                }
            }

            obj = Lists.newArrayList(((Iterable) (obj1)));
            ((List) (obj)).addAll(final_network);
            SearchResultsFragment.access$1400(SearchResultsFragment.this, ((List) (obj)));
            if (accessibilityUtil.isAccessibilityEnabled())
            {
                SearchResultsFragment.access$1502(SearchResultsFragment.this, new SearchResultsFragment.SpeakResultsRunnable(SearchResultsFragment.this, ((List) (obj))));
                SearchResultsFragment.access$1600(SearchResultsFragment.this).postDelayed(SearchResultsFragment.access$1500(SearchResultsFragment.this), 500L);
            }
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((Tuple)obj);
        }

            
            {
                this$0 = final_searchresultsfragment;
                searchQuery = searchquery;
                titleQuery = s;
                super(final_taskexecutor, Context.this, errordialogfactory, oncancellistener);
            }

        // Unreferenced inner class com/xfinity/playerlib/view/search/SearchResultsFragment$4$1

/* anonymous class */
        class SearchResultsFragment._cls4._cls1 extends SearchResultsFragment.TagCalloutClickListener
        {

            final SearchResultsFragment._cls4 this$1;
            final Set val$networkFilters;

            protected void onTagSelected(Network network)
            {
                networkFilters.add(network);
            }

            protected volatile void onTagSelected(Tag tag)
            {
                onTagSelected((Network)tag);
            }

                    
                    {
                        this$1 = SearchResultsFragment._cls4.this;
                        networkFilters = set;
                        super(this$0, final_network);
                    }
        }

    }

}
