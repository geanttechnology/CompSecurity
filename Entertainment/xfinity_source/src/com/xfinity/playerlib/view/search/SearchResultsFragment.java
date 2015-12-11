// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.AlternateInterfaceUtil;
import com.comcast.cim.android.accessibility.DefaultSpeechListener;
import com.comcast.cim.android.accessibility.SpeechListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.model.provider.RetryingTaskExecutionListener;
import com.emilsjolander.components.StickyListHeaders.StickyListHeadersBaseAdapter;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.alt.PlayerSearchTalkListHelper;
import com.xfinity.playerlib.model.comparator.DibicProgramTitleComparator;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import com.xfinity.playerlib.model.tags.Tag;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            EmbeddedTagFinder, SearchQuery

public class SearchResultsFragment extends Fragment
    implements android.view.MenuItem.OnActionExpandListener
{
    private static class HeaderViewHolder
    {

        private TextView text;



/*
        static TextView access$2202(HeaderViewHolder headerviewholder, TextView textview)
        {
            headerviewholder.text = textview;
            return textview;
        }

*/

        private HeaderViewHolder()
        {
        }

    }

    public static interface HostingActivity
    {

        public abstract EditText getSearchEditText();
    }

    public static final class ListSection extends Enum
    {

        private static final ListSection $VALUES[];
        public static final ListSection FULL;
        public static final ListSection NEW;

        public static ListSection valueOf(String s)
        {
            return (ListSection)Enum.valueOf(com/xfinity/playerlib/view/search/SearchResultsFragment$ListSection, s);
        }

        public static ListSection[] values()
        {
            return (ListSection[])$VALUES.clone();
        }

        static 
        {
            NEW = new ListSection("NEW", 0);
            FULL = new ListSection("FULL", 1);
            $VALUES = (new ListSection[] {
                NEW, FULL
            });
        }

        private ListSection(String s, int i)
        {
            super(s, i);
        }
    }

    private class SearchResultsAccessibleAdapter extends BaseAdapter
    {

        private Context context;
        private LayoutInflater inflater;
        private List searchResults;
        final SearchResultsFragment this$0;

        public int getCount()
        {
            return searchResults.size();
        }

        public Object getItem(int i)
        {
            return searchResults.get(i);
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            Tuple tuple;
            DibicProgram dibicprogram;
            int j;
            if (view == null)
            {
                view = inflater.inflate(com.xfinity.playerlib.R.layout.search_results_item, null);
                viewgroup = new SearchResultsViewHolder();
                viewgroup.title = (TextView)view.findViewById(com.xfinity.playerlib.R.id.program_title);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (SearchResultsViewHolder)view.getTag();
            }
            tuple = (Tuple)CommonUtils.uncheckedCast(getItem(i));
            dibicprogram = (DibicProgram)tuple.e2;
            ((SearchResultsViewHolder) (viewgroup)).title.setText(dibicprogram.getTitle());
            if (dibicprogram.isMovie())
            {
                j = com.xfinity.playerlib.R.drawable.icn_search_movies;
            } else
            {
                j = com.xfinity.playerlib.R.drawable.icn_search_tv_series;
            }
            ((SearchResultsViewHolder) (viewgroup)).title.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(j), null, null, null);
            ((SearchResultsViewHolder) (viewgroup)).title.setContentDescription(getVideoContentDescription(tuple, i, getCount()));
            return view;
        }

        public void setSearchResults(List list)
        {
            searchResults = list;
        }

        public SearchResultsAccessibleAdapter(Context context1)
        {
            this$0 = SearchResultsFragment.this;
            super();
            searchResults = Lists.newArrayList();
            context = context1;
            inflater = LayoutInflater.from(context1);
        }
    }

    private static class SearchResultsAdapter extends StickyListHeadersBaseAdapter
    {

        private final String fullResultsHeader;
        private LayoutInflater inflater;
        private final String newResultsHeader;
        private List searchResults;

        public int getCount()
        {
            return searchResults.size();
        }

        public long getHeaderId(int i)
        {
            return !((ListSection)((Tuple)CommonUtils.uncheckedCast(getItem(i))).e1).equals(ListSection.NEW) ? 2L : 1L;
        }

        public View getHeaderView(int i, View view)
        {
            Object obj;
            TextView textview;
            Tuple tuple;
            if (view == null)
            {
                obj = new HeaderViewHolder();
                view = inflater.inflate(com.xfinity.playerlib.R.layout.search_results_header, null);
                obj.text = (TextView)view.findViewById(com.xfinity.playerlib.R.id.search_header);
                view.setTag(obj);
            } else
            {
                obj = (HeaderViewHolder)view.getTag();
            }
            tuple = (Tuple)CommonUtils.uncheckedCast(getItem(i));
            textview = ((HeaderViewHolder) (obj)).text;
            if (((ListSection)tuple.e1).equals(ListSection.NEW))
            {
                obj = newResultsHeader;
            } else
            {
                obj = fullResultsHeader;
            }
            textview.setText(((CharSequence) (obj)));
            return view;
        }

        public Object getItem(int i)
        {
            return searchResults.get(i);
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        protected View getView(int i, View view)
        {
            SearchResultsViewHolder searchresultsviewholder;
            DibicProgram dibicprogram;
            if (view == null)
            {
                view = inflater.inflate(com.xfinity.playerlib.R.layout.search_results_item, null);
                searchresultsviewholder = new SearchResultsViewHolder();
                searchresultsviewholder.title = (TextView)view.findViewById(com.xfinity.playerlib.R.id.program_title);
                view.setTag(searchresultsviewholder);
            } else
            {
                searchresultsviewholder = (SearchResultsViewHolder)view.getTag();
            }
            dibicprogram = (DibicProgram)((Tuple)CommonUtils.uncheckedCast(getItem(i))).e2;
            searchresultsviewholder.title.setText(dibicprogram.getTitle());
            if (dibicprogram.isMovie())
            {
                i = com.xfinity.playerlib.R.drawable.icn_search_movies;
            } else
            {
                i = com.xfinity.playerlib.R.drawable.icn_search_tv_series;
            }
            searchresultsviewholder.title.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(i), null, null, null);
            return view;
        }

        public void setSearchResults(List list)
        {
            searchResults = list;
        }

        public SearchResultsAdapter(Context context)
        {
            super(context);
            searchResults = Lists.newArrayList();
            inflater = LayoutInflater.from(context);
            newResultsHeader = context.getResources().getString(com.xfinity.playerlib.R.string.search_new_results_header);
            fullResultsHeader = context.getResources().getString(com.xfinity.playerlib.R.string.search_full_results_header);
        }
    }

    private class SearchResultsFragmentSpeechListener extends DefaultSpeechListener
    {

        final SearchResultsFragment this$0;

        public boolean onSpeechResponseClear()
        {
            alternateInterfaceListener.getTalkDelegate().speak(searchEditText.getContext().getString(com.xfinity.playerlib.R.string.content_description_search_cleared));
            playNowSearchTalkHelper = new PlayerSearchTalkListHelper(getActivity());
            clearSearchQuery();
            handler.postDelayed(new UpdateSearchRunnable(""), 200L);
            return true;
        }

        public boolean onSpeechResponseLess()
        {
            alternateInterfaceListener.getTalkDelegate().speak(playNowSearchTalkHelper.getLessResults());
            return true;
        }

        public boolean onSpeechResponseMore()
        {
            alternateInterfaceListener.getTalkDelegate().speak(playNowSearchTalkHelper.getMoreResults());
            return true;
        }

        public boolean onSpeechResponseRepeat()
        {
            alternateInterfaceListener.getTalkDelegate().speak(playNowSearchTalkHelper.speakResults());
            return true;
        }

        public boolean onSpeechResponseSearch(String as[])
        {
            if (as == null || as.length == 0)
            {
                alternateInterfaceListener.getTalkDelegate().speak(com.xfinity.playerlib.R.string.speech_search_instructions);
                ignoreSearchOnResume = false;
                return false;
            } else
            {
                as = StringUtils.join(as, " ");
                handler.postDelayed(new UpdateSearchRunnable(as), 200L);
                return false;
            }
        }

        private SearchResultsFragmentSpeechListener()
        {
            this$0 = SearchResultsFragment.this;
            super();
        }

    }

    private static class SearchResultsViewHolder
    {

        private TextView title;



/*
        static TextView access$2402(SearchResultsViewHolder searchresultsviewholder, TextView textview)
        {
            searchresultsviewholder.title = textview;
            return textview;
        }

*/

        private SearchResultsViewHolder()
        {
        }

    }

    private class SpeakResultsRunnable
        implements Runnable
    {

        final List results;
        final SearchResultsFragment this$0;

        public void run()
        {
            playNowSearchTalkHelper = new PlayerSearchTalkListHelper(SearchResultsFragment.this, searchQueryProvider, results);
            alternateInterfaceListener.getTalkDelegate().speak(playNowSearchTalkHelper.speakResults());
        }

        SpeakResultsRunnable(List list)
        {
            this$0 = SearchResultsFragment.this;
            super();
            results = list;
        }
    }

    private abstract class TagBreadcrumbClickListener
        implements android.view.View.OnClickListener
    {

        final SearchResultsFragment this$0;

        protected abstract void onBreadcrumbClicked();

        public void onClick(View view)
        {
            onBreadcrumbClicked();
            view.setVisibility(8);
            performSearchIfReady();
        }

        private TagBreadcrumbClickListener()
        {
            this$0 = SearchResultsFragment.this;
            super();
        }

    }

    private abstract class TagCalloutClickListener
        implements android.view.View.OnClickListener
    {

        private final Tag tagMatch;
        final SearchResultsFragment this$0;

        public void onClick(View view)
        {
            onTagSelected(tagMatch);
            String s1 = tagMatch.getName();
            view = searchEditText.getEditableText();
            String s = view.toString();
            int i = StringUtils.indexOfIgnoreCase(s, s1);
            s1 = StringUtils.normalizeSpace(s.replace(s.substring(i, i + s1.length()), ""));
            tagCalloutContainer.setVisibility(8);
            view.replace(0, s.length(), s1);
            searchEditText.setSelection(s1.length());
        }

        protected abstract void onTagSelected(Tag tag);

        public TagCalloutClickListener(Tag tag)
        {
            this$0 = SearchResultsFragment.this;
            super();
            tagMatch = tag;
        }
    }

    private static interface TagMatcher
    {

        public abstract boolean programMatchesTag(DibicProgram dibicprogram, Tag tag);
    }

    private class UpdateSearchRunnable
        implements Runnable
    {

        final String searchTerms;
        final SearchResultsFragment this$0;

        public void run()
        {
            searchEditText.setText(searchTerms);
        }

        UpdateSearchRunnable(String s)
        {
            this$0 = SearchResultsFragment.this;
            super();
            searchTerms = s;
        }
    }


    public static final List EMPTY_SEARCH_RESULTS = new ArrayList();
    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/search/SearchResultsFragment);
    protected final AccessibilityUtil accessibilityUtil = CALContainer.getInstance().getAccessibilityUtil();
    private HostingActivity activity;
    private AlternateInterfaceListener alternateInterfaceListener;
    private final AlternateInterfaceUtil alternateInterfaceUtil = CALContainer.getInstance().getAlternateInterfaceUtil();
    private DibicResource dibicResource;
    private boolean dropDownEnabled;
    private final ErrorDialogFactory errorDialogFactory = PlayerContainer.getInstance().getErrorDialogFactory();
    private EmbeddedTagFinder genreFinder;
    private final TagMatcher genreMatcher = new TagMatcher() {

        final SearchResultsFragment this$0;

        public boolean programMatchesTag(DibicProgram dibicprogram, OrderedTag orderedtag)
        {
            return dibicprogram.getGenres().contains(orderedtag);
        }

        public volatile boolean programMatchesTag(DibicProgram dibicprogram, Tag tag)
        {
            return programMatchesTag(dibicprogram, (OrderedTag)tag);
        }

            
            {
                this$0 = SearchResultsFragment.this;
                super();
            }
    };
    private Handler handler;
    private boolean ignoreSearchOnResume;
    private LayoutInflater layoutInflater;
    private boolean menuItemExpanded;
    private EmbeddedTagFinder networkFinder;
    private final TagMatcher networkMatcher = new TagMatcher() {

        final SearchResultsFragment this$0;

        public boolean programMatchesTag(DibicProgram dibicprogram, Network network)
        {
            return dibicprogram.getNetworks().contains(network);
        }

        public volatile boolean programMatchesTag(DibicProgram dibicprogram, Tag tag)
        {
            return programMatchesTag(dibicprogram, (Network)tag);
        }

            
            {
                this$0 = SearchResultsFragment.this;
                super();
            }
    };
    private View noResultsView;
    private int numResultsAsOfLastListUpdate;
    private boolean optionsMenuCreated;
    private PlayerSearchTalkListHelper playNowSearchTalkHelper;
    private PopupWindow popupWindow;
    private EditText searchEditText;
    private Provider searchQueryProvider;
    private SearchResultsAdapter searchResultsAdapter;
    private SearchResultsAccessibleAdapter searchResultsAdapterAccessible;
    private ListView searchResultsListView;
    private ListView searchResultsListViewAccessible;
    private View searchingView;
    protected List sharedResults;
    private SpeakResultsRunnable speakResultsRunnable;
    private SpeechListener speechListener;
    private View tagBreadcrumbBottomDivider;
    private ViewGroup tagBreadcrumbContainer;
    private View tagBreadcrumbOuterContainer;
    private TextView tagCallout;
    private View tagCalloutBottomDivider;
    private View tagCalloutContainer;
    private TagsRoot tagsRoot;
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;

    public SearchResultsFragment()
    {
        playNowSearchTalkHelper = new PlayerSearchTalkListHelper(getActivity());
        ignoreSearchOnResume = false;
        taskExecutor = PlayerContainer.getInstance().getTagsAndProgramsTaskExecutor();
        searchQueryProvider = PlayerContainer.getInstance().getSearchQueryProvider();
        handler = new Handler();
        sharedResults = null;
        speechListener = new SearchResultsFragmentSpeechListener();
    }

    private void addBreadcrumbView(Tag tag, TagBreadcrumbClickListener tagbreadcrumbclicklistener)
    {
        TextView textview = (TextView)layoutInflater.inflate(com.xfinity.playerlib.R.layout.search_results_breadcrumb, tagBreadcrumbContainer, false);
        textview.setText(tag.getName());
        textview.setOnClickListener(tagbreadcrumbclicklistener);
        tagBreadcrumbContainer.addView(textview);
    }

    private transient boolean anyAreVisible(View aview[])
    {
        boolean flag1 = false;
        int j = aview.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (aview[i].getVisibility() != 0)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    private void clearViews()
    {
        searchingView.setVisibility(8);
        noResultsView.setVisibility(8);
        searchResultsListView.setVisibility(8);
        searchResultsListViewAccessible.setVisibility(8);
        updateSectionDividerVisibilities();
    }

    private Tag findMostRelevantEmbeddedTag(String s, EmbeddedTagFinder embeddedtagfinder, Set set)
    {
        for (s = embeddedtagfinder.getResults(s).iterator(); s.hasNext();)
        {
            embeddedtagfinder = (Tag)s.next();
            if (!set.contains(embeddedtagfinder))
            {
                return embeddedtagfinder;
            }
        }

        return null;
    }

    private int getDesiredPopupWindowHeight()
    {
        return -2;
    }

    private int getDesiredPopupWindowWidth()
    {
        if (getResources().getBoolean(com.xfinity.playerlib.R.bool.search_drop_down_is_full_width))
        {
            return -1;
        } else
        {
            return searchEditText.getWidth();
        }
    }

    private boolean isReadyToPerformSearch()
    {
        return isResumed() && optionsMenuCreated && menuItemExpanded;
    }

    private void performSearchIfReady()
    {
        if (!isReadyToPerformSearch())
        {
            return;
        }
        String s = searchEditText.getText().toString().trim();
        SearchQuery searchquery = (SearchQuery)searchQueryProvider.get();
        searchquery.setTitleFilter(s);
        taskExecutor.cancelNotificationsFor(taskExecutionListener);
        if (searchquery.isEmpty())
        {
            LOG.debug("Query is empty, clearing results and dismissing dropdown");
            if (searchResultsAdapter != null || searchResultsAdapterAccessible != null)
            {
                clearViews();
            }
            dismissDropDownIfApplicable();
            return;
        } else
        {
            LOG.debug("Showing progress indicator before fetching tags and dibic data");
            showDropDownIfApplicable();
            updateBreadcrumbViews();
            showSearching();
            alternateInterfaceListener.getTalkDelegate().speak(getString(com.xfinity.playerlib.R.string.speech_search_for_x, new Object[] {
                s
            }));
            android.content.DialogInterface.OnCancelListener oncancellistener = new android.content.DialogInterface.OnCancelListener() {

                final SearchResultsFragment this$0;

                public void onCancel(DialogInterface dialoginterface)
                {
                    showNoResults();
                }

            
            {
                this$0 = SearchResultsFragment.this;
                super();
            }
            };
            taskExecutionListener = taskExecutor.execute(new RetryingTaskExecutionListener(errorDialogFactory, oncancellistener, searchquery, s) {

                final SearchResultsFragment this$0;
                final SearchQuery val$searchQuery;
                final String val$titleQuery;

                public void onPostExecute(Tuple tuple)
                {
                    Object obj = (TagsRoot)tuple.e1;
                    if (!obj.equals(tagsRoot))
                    {
                        tagsRoot = ((TagsRoot) (obj));
                        genreFinder = new EmbeddedTagFinder(tagsRoot.getAllPublicGenres());
                        networkFinder = new EmbeddedTagFinder(tagsRoot.getNetworks());
                    }
                    dibicResource = (DibicResource)tuple.e2;
                    Object obj1 = searchQuery.getNetworkFilters();
                    Set set = searchQuery.getGenreFilters();
                    Object obj2 = searchQuery.getTagFilters();
                    Object obj3;
                    if (((Set) (obj2)).size() < 3)
                    {
                        tuple = (Network)findMostRelevantEmbeddedTag(titleQuery, networkFinder, ((Set) (obj1)));
                        if (tuple != null)
                        {
                            obj = getResources().getString(com.xfinity.playerlib.R.string.search_network_callout);
                            TagCalloutClickListener tagcalloutclicklistener = tuple. new TagCalloutClickListener(((Set) (obj1))) {

                                final _cls4 this$1;
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
                this$1 = final__pcls4;
                networkFilters = set;
                final__pcls4._fld0. super(Network.this);
            }
                            };
                            setUpTagCallout(tuple, ((String) (obj)), tagcalloutclicklistener);
                        } else
                        {
                            tuple = (OrderedTag)findMostRelevantEmbeddedTag(titleQuery, genreFinder, set);
                            if (tuple != null)
                            {
                                obj = getResources().getString(com.xfinity.playerlib.R.string.search_genre_callout);
                                obj3 = tuple. new TagCalloutClickListener(set) {

                                    final _cls4 this$1;
                                    final Set val$genreFilters;

                                    protected void onTagSelected(OrderedTag orderedtag)
                                    {
                                        genreFilters.add(orderedtag);
                                    }

                                    protected volatile void onTagSelected(Tag tag)
                                    {
                                        onTagSelected((OrderedTag)tag);
                                    }

            
            {
                this$1 = final__pcls4;
                genreFilters = set;
                final__pcls4._fld0. super(OrderedTag.this);
            }
                                };
                                setUpTagCallout(tuple, ((String) (obj)), ((TagCalloutClickListener) (obj3)));
                            } else
                            {
                                tagCalloutContainer.setVisibility(8);
                            }
                        }
                    } else
                    {
                        tagCalloutContainer.setVisibility(8);
                    }
                    obj3 = new StopWatch();
                    ((StopWatch) (obj3)).start();
                    tuple = dibicResource.getProgramsMatchingTitleFilter(titleQuery);
                    obj = tuple;
                    if (!((Set) (obj2)).isEmpty())
                    {
                        if (titleQuery.isEmpty())
                        {
                            tuple = dibicResource.getPrograms();
                        }
                        obj2 = tuple.iterator();
                        do
                        {
                            obj = tuple;
                            if (!((Iterator) (obj2)).hasNext())
                            {
                                break;
                            }
                            obj = (DibicProgram)((Iterator) (obj2)).next();
                            if (!((Set) (obj1)).isEmpty() && !programMatchesAny(((DibicProgram) (obj)), ((Set) (obj1)), networkMatcher) || !set.isEmpty() && !programMatchesAny(((DibicProgram) (obj)), set, genreMatcher))
                            {
                                ((Iterator) (obj2)).remove();
                            }
                        } while (true);
                    }
                    Collections.sort(((List) (obj)), new DibicProgramTitleComparator(true));
                    ((StopWatch) (obj3)).stop();
                    SearchResultsFragment.LOG.debug((new StringBuilder()).append("Search performed in ").append(obj3).toString());
                    obj1 = Lists.newArrayList();
                    tuple = Lists.newArrayList();
                    DibicProgram dibicprogram;
                    for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); tuple.add(new Tuple(ListSection.FULL, dibicprogram)))
                    {
                        dibicprogram = (DibicProgram)((Iterator) (obj)).next();
                        if (dibicprogram.isNew())
                        {
                            ((List) (obj1)).add(new Tuple(ListSection.NEW, dibicprogram));
                        }
                    }

                    obj = Lists.newArrayList(((Iterable) (obj1)));
                    ((List) (obj)).addAll(tuple);
                    showResults(((List) (obj)));
                    if (accessibilityUtil.isAccessibilityEnabled())
                    {
                        speakResultsRunnable = new SpeakResultsRunnable(((List) (obj)));
                        handler.postDelayed(speakResultsRunnable, 500L);
                    }
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Tuple)obj);
                }

            
            {
                this$0 = SearchResultsFragment.this;
                searchQuery = searchquery;
                titleQuery = s;
                super(final_taskexecutor, final_context, errordialogfactory, oncancellistener);
            }
            });
            return;
        }
    }

    private boolean programMatchesAny(DibicProgram dibicprogram, Set set, TagMatcher tagmatcher)
    {
        for (set = set.iterator(); set.hasNext();)
        {
            if (tagmatcher.programMatchesTag(dibicprogram, (Tag)set.next()))
            {
                return true;
            }
        }

        return false;
    }

    private void setUpTagCallout(Tag tag, String s, TagCalloutClickListener tagcalloutclicklistener)
    {
        tagCallout.setText(String.format(Locale.US, s, new Object[] {
            tag.getName()
        }));
        tagCallout.setOnClickListener(tagcalloutclicklistener);
        tagCalloutContainer.setVisibility(0);
    }

    private void showNoResults()
    {
        showResults(EMPTY_SEARCH_RESULTS);
    }

    private void showResults(List list)
    {
        int i = 8;
        sharedResults = list;
        searchingView.setVisibility(8);
        View view = noResultsView;
        if (list.isEmpty())
        {
            i = 0;
        }
        view.setVisibility(i);
        searchResultsAdapterAccessible.setSearchResults(list);
        searchResultsAdapterAccessible.notifyDataSetChanged();
        searchResultsAdapter.setSearchResults(list);
        searchResultsAdapter.notifyDataSetChanged();
        i = list.size();
        if (i != numResultsAsOfLastListUpdate)
        {
            numResultsAsOfLastListUpdate = i;
            searchResultsListView.setSelection(0);
        }
        if (accessibilityUtil.isAccessibilityEnabled())
        {
            list = searchResultsListViewAccessible.getContext().getString(com.xfinity.playerlib.R.string.content_description_search_results);
            searchResultsListViewAccessible.setVisibility(0);
            accessibilityUtil.setupAccessibleScrollListener(searchResultsListViewAccessible, list);
            searchResultsListViewAccessible.setTag(list);
            searchResultsListViewAccessible.setAccessibilityDelegate(new android.view.View.AccessibilityDelegate() {

                final SearchResultsFragment this$0;

                public boolean performAccessibilityAction(View view1, int j, Bundle bundle)
                {
                    return super.performAccessibilityAction(view1, j, bundle);
                }

            
            {
                this$0 = SearchResultsFragment.this;
                super();
            }
            });
        } else
        {
            searchResultsListView.setVisibility(0);
        }
        updateSectionDividerVisibilities();
    }

    private void showSearching()
    {
        searchingView.setVisibility(0);
        noResultsView.setVisibility(8);
        searchResultsListView.setVisibility(8);
        searchResultsListViewAccessible.setVisibility(8);
        updateSectionDividerVisibilities();
    }

    private void updateBreadcrumbViews()
    {
        tagBreadcrumbContainer.removeAllViews();
        final Set networkFilters = ((SearchQuery)searchQueryProvider.get()).getNetworkFilters();
        final Network networkFilter;
        for (Iterator iterator = networkFilters.iterator(); iterator.hasNext(); addBreadcrumbView(networkFilter, new TagBreadcrumbClickListener() {

        final SearchResultsFragment this$0;
        final Network val$networkFilter;
        final Set val$networkFilters;

        protected void onBreadcrumbClicked()
        {
            networkFilters.remove(networkFilter);
        }

            
            {
                this$0 = SearchResultsFragment.this;
                networkFilters = set;
                networkFilter = network;
                super();
            }
    }))
        {
            networkFilter = (Network)iterator.next();
        }

        final Set genreFilters = ((SearchQuery)searchQueryProvider.get()).getGenreFilters();
        final OrderedTag genreFilter;
        for (Iterator iterator1 = genreFilters.iterator(); iterator1.hasNext(); addBreadcrumbView(genreFilter, new TagBreadcrumbClickListener() {

        final SearchResultsFragment this$0;
        final OrderedTag val$genreFilter;
        final Set val$genreFilters;

        protected void onBreadcrumbClicked()
        {
            genreFilters.remove(genreFilter);
        }

            
            {
                this$0 = SearchResultsFragment.this;
                genreFilters = set;
                genreFilter = orderedtag;
                super();
            }
    }))
        {
            genreFilter = (OrderedTag)iterator1.next();
        }

        genreFilters = tagBreadcrumbOuterContainer;
        byte byte0;
        if (((SearchQuery)searchQueryProvider.get()).getTagFilters().isEmpty())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        genreFilters.setVisibility(byte0);
        updateSectionDividerVisibilities();
    }

    private void updateSectionDividerVisibilities()
    {
        boolean flag = false;
        View view = tagCalloutBottomDivider;
        int i;
        if (anyAreVisible(new View[] {
    tagBreadcrumbOuterContainer, noResultsView, searchingView
}))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = tagBreadcrumbBottomDivider;
        if (anyAreVisible(new View[] {
    noResultsView, searchingView
}))
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void clearSearchQuery()
    {
        ((SearchQuery)searchQueryProvider.get()).clear();
        searchEditText.setText("");
        searchResultsListViewAccessible.setTag(null);
        updateBreadcrumbViews();
    }

    public void dismissDropDownIfApplicable()
    {
        if (dropDownEnabled && popupWindow != null)
        {
            popupWindow.dismiss();
        }
    }

    public List getFullResults()
    {
        return sharedResults;
    }

    public String getVideoContentDescription(Tuple tuple, int i, int j)
    {
        DibicProgram dibicprogram = (DibicProgram)tuple.e2;
        String s;
        String s1;
        if (((ListSection)tuple.e1).equals(ListSection.NEW))
        {
            tuple = getActivity().getString(com.xfinity.playerlib.R.string.content_description_new_indicator);
        } else
        {
            tuple = "";
        }
        if (dibicprogram.isMovie())
        {
            s = getActivity().getString(com.xfinity.playerlib.R.string.content_description_video_item_movie);
        } else
        {
            s = getActivity().getString(com.xfinity.playerlib.R.string.content_description_video_item_tv_series);
        }
        if (i == j - 1)
        {
            s1 = getActivity().getString(com.xfinity.playerlib.R.string.content_description_video_item_last_list_announce);
        } else
        {
            s1 = "";
        }
        return getActivity().getString(com.xfinity.playerlib.R.string.content_description_search_video_list_item, new Object[] {
            Integer.valueOf(i + 1), tuple, s, dibicprogram.getTitle(), s1
        });
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getView();
        if (bundle.getParent() == null)
        {
            dropDownEnabled = true;
            popupWindow = new PopupWindow(getActivity(), null, com.xfinity.playerlib.R.style.xfinity_remote_theme);
            popupWindow.setSoftInputMode(16);
            popupWindow.setContentView(bundle);
        }
        alternateInterfaceListener.addSpeechListener(speechListener);
    }

    public void onAttach(Activity activity1)
    {
        super.onAttach(activity1);
        activity = (HostingActivity)activity1;
        layoutInflater = activity1.getLayoutInflater();
        alternateInterfaceListener = (AlternateInterfaceListener)activity1;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (bundle != null)
        {
            numResultsAsOfLastListUpdate = bundle.getInt("EXTRA_NUM_RESULTS_AS_OF_LAST_LIST_UPDATE");
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        searchEditText = activity.getSearchEditText();
        searchEditText.addTextChangedListener(new TextWatcher() {

            final SearchResultsFragment this$0;

            public void afterTextChanged(Editable editable)
            {
                performSearchIfReady();
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = SearchResultsFragment.this;
                super();
            }
        });
        optionsMenuCreated = true;
        resumeSearchIfReady();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(com.xfinity.playerlib.R.layout.search_results, viewgroup, false);
        viewgroup = new android.widget.AdapterView.OnItemClickListener() {

            final SearchResultsFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (Tuple)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i));
                showProgramDetail((DibicProgram)((Tuple) (adapterview)).e2);
            }

            
            {
                this$0 = SearchResultsFragment.this;
                super();
            }
        };
        searchResultsListViewAccessible = (ListView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.search_results_list_accessible);
        searchResultsAdapterAccessible = new SearchResultsAccessibleAdapter(getActivity());
        searchResultsListViewAccessible.setOnItemClickListener(viewgroup);
        searchResultsListViewAccessible.setAdapter(searchResultsAdapterAccessible);
        searchResultsListView = (ListView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.search_results_list);
        searchResultsAdapter = new SearchResultsAdapter(getActivity());
        searchResultsListView.setOnItemClickListener(viewgroup);
        searchResultsListView.setAdapter(searchResultsAdapter);
        noResultsView = layoutinflater.findViewById(com.xfinity.playerlib.R.id.no_results);
        searchingView = layoutinflater.findViewById(com.xfinity.playerlib.R.id.searching);
        tagCalloutContainer = layoutinflater.findViewById(com.xfinity.playerlib.R.id.tag_callout_container);
        tagCallout = (TextView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.tag_callout);
        tagCalloutBottomDivider = layoutinflater.findViewById(com.xfinity.playerlib.R.id.tag_callout_bottom_divider);
        tagBreadcrumbOuterContainer = layoutinflater.findViewById(com.xfinity.playerlib.R.id.tag_breadcrumb_outer_container);
        tagBreadcrumbContainer = (ViewGroup)layoutinflater.findViewById(com.xfinity.playerlib.R.id.tag_breadcrumb_container);
        tagBreadcrumbBottomDivider = layoutinflater.findViewById(com.xfinity.playerlib.R.id.tag_breadcrumb_bottom_divider);
        alternateInterfaceListener.setupPassiveGestureDetector(layoutinflater, com.xfinity.playerlib.R.id.touchy_parent);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        dismissDropDownIfApplicable();
    }

    public void onDetach()
    {
        super.onDetach();
        alternateInterfaceListener.removeSpeechListener(speechListener);
    }

    public boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        menuItemExpanded = false;
        clearViews();
        dismissDropDownIfApplicable();
        return true;
    }

    public boolean onMenuItemActionExpand(MenuItem menuitem)
    {
        menuItemExpanded = true;
        resumeSearchIfReady();
        return true;
    }

    public void onPause()
    {
        super.onPause();
        LOG.debug("onPause(): cancelling any in-progress search");
        if (taskExecutor != null)
        {
            taskExecutor.cancelNotificationsFor(taskExecutionListener);
        }
        handler.removeCallbacks(speakResultsRunnable);
    }

    public void onResume()
    {
        super.onResume();
        resumeSearchIfReady();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (numResultsAsOfLastListUpdate != 0)
        {
            bundle.putInt("EXTRA_NUM_RESULTS_AS_OF_LAST_LIST_UPDATE", numResultsAsOfLastListUpdate);
        }
    }

    public void onSpeechSwiped()
    {
        ignoreSearchOnResume = true;
    }

    public void resumeSearchIfReady()
    {
        while (accessibilityUtil.isAccessibilityEnabled() && ignoreSearchOnResume || !isReadyToPerformSearch()) 
        {
            return;
        }
        String s = ((SearchQuery)searchQueryProvider.get()).getTitleFilter();
        searchEditText.setText(s);
        searchEditText.setSelection(s.length());
    }

    public void showDropDownIfApplicable()
    {
        if (dropDownEnabled && popupWindow != null)
        {
            handler.post(new Runnable() {

                final SearchResultsFragment this$0;

                public void run()
                {
label0:
                    {
                        if (isAdded())
                        {
                            if (!popupWindow.isShowing())
                            {
                                popupWindow.setInputMethodMode(1);
                            }
                            popupWindow.setWidth(getDesiredPopupWindowWidth());
                            popupWindow.setHeight(getDesiredPopupWindowHeight());
                            if (searchEditText.getWindowToken() != null)
                            {
                                if (popupWindow.isShowing())
                                {
                                    break label0;
                                }
                                popupWindow.showAsDropDown(searchEditText);
                            }
                        }
                        return;
                    }
                    popupWindow.update(searchEditText, 0, 0, getDesiredPopupWindowWidth(), getDesiredPopupWindowHeight());
                }

            
            {
                this$0 = SearchResultsFragment.this;
                super();
            }
            });
        }
    }

    public void showProgramDetail(DibicProgram dibicprogram)
    {
        dibicprogram = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(dibicprogram)).build().getIntent(getActivity());
        if (accessibilityUtil.isAccessibilityEnabled())
        {
            dibicprogram.putExtra("KEY_ANNOUNCE_EPISODES", true);
        }
        startActivity(dibicprogram);
    }










/*
    static SpeakResultsRunnable access$1502(SearchResultsFragment searchresultsfragment, SpeakResultsRunnable speakresultsrunnable)
    {
        searchresultsfragment.speakResultsRunnable = speakresultsrunnable;
        return speakresultsrunnable;
    }

*/









/*
    static PlayerSearchTalkListHelper access$2602(SearchResultsFragment searchresultsfragment, PlayerSearchTalkListHelper playersearchtalklisthelper)
    {
        searchresultsfragment.playNowSearchTalkHelper = playersearchtalklisthelper;
        return playersearchtalklisthelper;
    }

*/




/*
    static boolean access$2902(SearchResultsFragment searchresultsfragment, boolean flag)
    {
        searchresultsfragment.ignoreSearchOnResume = flag;
        return flag;
    }

*/



/*
    static TagsRoot access$302(SearchResultsFragment searchresultsfragment, TagsRoot tagsroot)
    {
        searchresultsfragment.tagsRoot = tagsroot;
        return tagsroot;
    }

*/



/*
    static EmbeddedTagFinder access$402(SearchResultsFragment searchresultsfragment, EmbeddedTagFinder embeddedtagfinder)
    {
        searchresultsfragment.genreFinder = embeddedtagfinder;
        return embeddedtagfinder;
    }

*/



/*
    static EmbeddedTagFinder access$502(SearchResultsFragment searchresultsfragment, EmbeddedTagFinder embeddedtagfinder)
    {
        searchresultsfragment.networkFinder = embeddedtagfinder;
        return embeddedtagfinder;
    }

*/



/*
    static DibicResource access$602(SearchResultsFragment searchresultsfragment, DibicResource dibicresource)
    {
        searchresultsfragment.dibicResource = dibicresource;
        return dibicresource;
    }

*/



}
