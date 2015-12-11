// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import com.ebay.common.UserCache;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.collections.CollectionDetailsActivity;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.dm.FollowingContentDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.content.dm.UssFeedDataManager;
import com.ebay.nautilus.domain.data.FollowingContent;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.TrackingSupport;
import com.ebay.nautilus.shell.widget.CompositeArrayAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.mobile.following:
//            AlphabeticalInterestSort, BrowseFollowingCollectionsFragmentAdapter, BrowseFollowingMembersFragmentAdapter, BrowseFollowingSearchesFragmentAdapter, 
//            FollowingContentListAdapter, FollowedSearchViewModel, FollowedMemberViewModel, FollowedCollectionViewModel, 
//            VerticalDividerItemDecoration, HorizontalDividerSearchItemDecoration, EditFollowingActivity

public class BrowseFollowingFragment extends BaseFragment
    implements com.ebay.mobile.common.view.ViewModel.OnClickListener, com.ebay.nautilus.domain.content.dm.FollowingContentDataManager.Observer, com.ebay.nautilus.domain.content.dm.UssFeedDataManager.Observer, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.OnRequestMoreListener
{
    private class EditOnClickListener
        implements android.view.View.OnClickListener
    {

        final BrowseFollowingFragment this$0;

        public void onClick(View view)
        {
            Intent intent = new Intent(getActivity(), com/ebay/mobile/following/EditFollowingActivity);
            view.getId();
            JVM INSTR lookupswitch 3: default 56
        //                       2131755217: 87
        //                       2131755225: 76
        //                       2131755235: 65;
               goto _L1 _L2 _L3 _L4
_L1:
            startActivity(intent);
            return;
_L4:
            intent.putExtra("followType", 1);
            continue; /* Loop/switch isn't completed */
_L3:
            intent.putExtra("followType", 2);
            continue; /* Loop/switch isn't completed */
_L2:
            intent.putExtra("followType", 3);
            if (true) goto _L1; else goto _L5
_L5:
        }

        private EditOnClickListener()
        {
            this$0 = BrowseFollowingFragment.this;
            super();
        }

    }

    private class ImageOnClickListener
        implements android.view.View.OnClickListener
    {

        final BrowseFollowingFragment this$0;

        public void onClick(View view)
        {
            view = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing)view.getTag();
            if (view == null)
            {
                break MISSING_BLOCK_LABEL_53;
            }
            long l = Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing) (view)).listingId).longValue();
            ItemViewActivity.StartActivity(getActivity(), l, com.ebay.common.ConstantsCommon.ItemKind.Unknown, addSourceIdTracking(new Intent(), "feed"));
            return;
            view;
        }

        private ImageOnClickListener()
        {
            this$0 = BrowseFollowingFragment.this;
            super();
        }

    }

    private class SeeAllOnClickListener
        implements android.view.View.OnClickListener
    {

        final BrowseFollowingFragment this$0;

        public void onClick(View view)
        {
            boolean flag;
            boolean flag3;
            boolean flag4;
            flag3 = true;
            flag4 = true;
            flag = true;
            view.getId();
            JVM INSTR lookupswitch 3: default 44
        //                       2131755219: 147
        //                       2131755227: 95
        //                       2131755237: 45;
               goto _L1 _L2 _L3 _L4
_L1:
            return;
_L4:
            view = BrowseFollowingFragment.this;
            if (isSearchesExpanded)
            {
                flag = false;
            }
            view.expandCollapseSearches(flag);
            if (!isSearchesExpanded)
            {
                scrollToHeader(searchesLayout);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            view = BrowseFollowingFragment.this;
            boolean flag1;
            if (!isMembersExpanded)
            {
                flag1 = flag3;
            } else
            {
                flag1 = false;
            }
            view.expandCollapseMembers(flag1);
            if (!isMembersExpanded)
            {
                scrollToHeader(membersLayout);
                return;
            }
            if (true) goto _L1; else goto _L2
_L2:
            view = BrowseFollowingFragment.this;
            boolean flag2;
            if (!isCollectionsExpanded)
            {
                flag2 = flag4;
            } else
            {
                flag2 = false;
            }
            view.expandCollapseCollections(flag2);
            if (!isCollectionsExpanded)
            {
                scrollToHeader(collectionsLayout);
                return;
            }
            if (true) goto _L1; else goto _L5
_L5:
        }

        private SeeAllOnClickListener()
        {
            this$0 = BrowseFollowingFragment.this;
            super();
        }

    }


    private static final int MAX_COLLECTIONS_COLLAPSED = 2;
    private static final int MAX_COLLECTIONS_COLLAPSED_TABLET = 2;
    private static final int MAX_MEMBERS_COLLAPSED = 4;
    private static final int MAX_MEMBERS_COLLAPSED_TABLET_LANDSCAPE = 9;
    private static final int MAX_MEMBERS_COLLAPSED_TABLET_PORTRAIT = 6;
    private static final int MAX_SEARCHES_COLLAPSED = 6;
    private static final int MAX_SEARCHES_COLLAPSED_TABLET_LANDSCAPE = 12;
    private static final int MAX_SEARCHES_COLLAPSED_TABLET_PORTAIT = 8;
    public static final String PARAM_SEARCH_ONLY = "searchOnly";
    private List collections;
    private BrowseFollowingCollectionsFragmentAdapter collectionsAdapter;
    protected View collectionsLayout;
    private boolean displaySearchOnly;
    protected UssFeedDataManager feedDataManager;
    protected FollowingContentDataManager followingContentDataManager;
    private boolean haveInitialFeedResponse;
    private boolean haveInitialFollowingResponse;
    private List interests;
    protected boolean isCollectionsExpanded;
    private boolean isListFourAcross;
    protected boolean isMembersExpanded;
    private boolean isPortrait;
    protected boolean isSearchesExpanded;
    private boolean isTablet;
    private ItemCache itemCache;
    protected ListView list;
    private FollowingContentListAdapter listAdapter;
    private BrowseFollowingMembersFragmentAdapter membersAdapter;
    protected View membersLayout;
    private NotificationPreferenceManager notificationPrefs;
    private View progressContainer;
    protected SwipeRefreshLayout refreshLayout;
    private ScrollView scrollView;
    private BrowseFollowingSearchesFragmentAdapter searchesAdapter;
    protected View searchesLayout;
    private Button seeAllCollectionsButton;
    private Button seeAllMembersButton;
    private Button seeAllSearchesButton;
    private boolean sendPageImpressionOnUssContentLoaded;
    private UserContextDataManager userContextDataManager;
    private List users;

    public BrowseFollowingFragment()
    {
    }

    private SourceIdentification getSourceIdentification(String s)
    {
        SourceIdentification sourceidentification = null;
        Activity activity = getActivity();
        if (activity instanceof TrackingSupport)
        {
            sourceidentification = new SourceIdentification(((TrackingSupport)activity).getTrackingEventName(), s);
        }
        return sourceidentification;
    }

    private void handleCollectionsContentChanged(List list1)
    {
        if (collectionsLayout != null)
        {
            collections = list1;
            expandCollapseCollections(isCollectionsExpanded);
        }
    }

    private void handleInterestsContentChanged(List list1)
    {
        if (searchesLayout != null)
        {
            Object obj = list1;
            if (list1 != null)
            {
                obj = new ArrayList(list1);
                Collections.sort(((List) (obj)), new AlphabeticalInterestSort());
            }
            interests = ((List) (obj));
            expandCollapseSearches(isSearchesExpanded);
        }
    }

    private void handleMembersContentChanged(List list1)
    {
        if (membersLayout != null)
        {
            users = list1;
            expandCollapseMembers(isMembersExpanded);
        }
    }

    private void sendPageImpression()
    {
label0:
        {
            if (!displaySearchOnly)
            {
                if (interests != null || users != null || collections != null)
                {
                    break label0;
                }
                sendPageImpressionOnUssContentLoaded = true;
            }
            return;
        }
        sendPageImpressionOnUssContentLoaded = false;
        int i;
        int j;
        int k;
        if (interests != null)
        {
            i = interests.size();
        } else
        {
            i = 0;
        }
        if (users != null)
        {
            j = users.size();
        } else
        {
            j = 0;
        }
        if (collections != null)
        {
            k = collections.size();
        } else
        {
            k = 0;
        }
        sendPageImpression(i, j, k);
    }

    private void sendPageImpression(int i, int j, int k)
    {
        Activity activity = getActivity();
        if (activity instanceof TrackingSupport)
        {
            TrackingData trackingdata = new TrackingData(((TrackingSupport)activity).getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
            trackingdata.addSourceIdentification(activity.getIntent());
            trackingdata.addKeyValuePair("intrstcnt", Integer.toString(i));
            trackingdata.addKeyValuePair("memcnt", Integer.toString(j));
            trackingdata.addKeyValuePair("colcnt", Integer.toString(k));
            trackingdata.send(activity);
        }
    }

    private void setListShown(boolean flag)
    {
        boolean flag1 = false;
        int i;
        if (list != null)
        {
            Object obj = list;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((ListView) (obj)).setVisibility(i);
        } else
        if (scrollView != null)
        {
            ScrollView scrollview = scrollView;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            scrollview.setVisibility(i);
        }
        obj = progressContainer;
        if (!flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    protected final Intent addSourceIdTracking(Intent intent, String s)
    {
        s = getSourceIdentification(s);
        if (s != null)
        {
            intent.putExtra("com.ebay.mobile.analytics.sid", s);
        }
        return intent;
    }

    protected final void expandCollapseCollections(boolean flag)
    {
        isCollectionsExpanded = flag;
        if (collections == null || collections.size() == 0)
        {
            collectionsLayout.setVisibility(8);
            collectionsAdapter.setContents(null);
            return;
        }
        collectionsLayout.setVisibility(0);
        int i = collections.size();
        if (!isTablet);
        i = Math.min(i, 2);
        if (flag)
        {
            collectionsAdapter.setContents(collections);
        } else
        {
            collectionsAdapter.setContents(collections.subList(0, i));
        }
        if (collections.size() <= i)
        {
            seeAllCollectionsButton.setVisibility(8);
            return;
        }
        seeAllCollectionsButton.setVisibility(0);
        Button button = seeAllCollectionsButton;
        Object obj;
        if (flag)
        {
            obj = getString(0x7f070998);
        } else
        {
            obj = getString(0x7f070995, new Object[] {
                Integer.valueOf(collections.size())
            });
        }
        button.setText(((CharSequence) (obj)));
        obj = getResources();
        if (flag)
        {
            i = 0x7f020256;
        } else
        {
            i = 0x7f020252;
        }
        obj = ((Resources) (obj)).getDrawable(i);
        seeAllCollectionsButton.setCompoundDrawablesWithIntrinsicBounds(null, null, ((android.graphics.drawable.Drawable) (obj)), null);
    }

    protected final void expandCollapseMembers(boolean flag)
    {
        isMembersExpanded = flag;
        if (users == null || users.size() == 0)
        {
            membersLayout.setVisibility(8);
            membersAdapter.setContents(null);
            return;
        }
        membersLayout.setVisibility(0);
        int j = users.size();
        int i;
        if (isTablet)
        {
            if (isPortrait)
            {
                i = 6;
            } else
            {
                i = 9;
            }
        } else
        {
            i = 4;
        }
        i = Math.min(j, i);
        if (flag)
        {
            membersAdapter.setContents(users);
        } else
        {
            membersAdapter.setContents(users.subList(0, i));
        }
        if (users.size() <= i)
        {
            seeAllMembersButton.setVisibility(8);
            return;
        }
        seeAllMembersButton.setVisibility(0);
        Button button = seeAllMembersButton;
        Object obj;
        if (flag)
        {
            obj = getString(0x7f070998);
        } else
        {
            obj = getString(0x7f070995, new Object[] {
                Integer.valueOf(users.size())
            });
        }
        button.setText(((CharSequence) (obj)));
        obj = getResources();
        if (flag)
        {
            i = 0x7f020256;
        } else
        {
            i = 0x7f020252;
        }
        obj = ((Resources) (obj)).getDrawable(i);
        seeAllMembersButton.setCompoundDrawablesWithIntrinsicBounds(null, null, ((android.graphics.drawable.Drawable) (obj)), null);
    }

    protected final void expandCollapseSearches(boolean flag)
    {
        isSearchesExpanded = flag;
        if (interests == null || interests.size() == 0)
        {
            searchesLayout.setVisibility(8);
            searchesAdapter.setContents(null);
            return;
        }
        searchesLayout.setVisibility(0);
        int j = interests.size();
        int i;
        if (isTablet)
        {
            if (isPortrait)
            {
                i = 8;
            } else
            {
                i = 12;
            }
        } else
        {
            i = 6;
        }
        i = Math.min(j, i);
        if (flag)
        {
            searchesAdapter.setContents(interests, itemCache, notificationPrefs, userContextDataManager.getCurrentUser());
        } else
        {
            searchesAdapter.setContents(interests.subList(0, i), itemCache, notificationPrefs, userContextDataManager.getCurrentUser());
        }
        if (interests.size() <= i || displaySearchOnly)
        {
            seeAllSearchesButton.setVisibility(8);
            return;
        }
        seeAllSearchesButton.setVisibility(0);
        Button button = seeAllSearchesButton;
        Object obj;
        if (flag)
        {
            obj = getString(0x7f070998);
        } else
        {
            obj = getString(0x7f070995, new Object[] {
                Integer.valueOf(interests.size())
            });
        }
        button.setText(((CharSequence) (obj)));
        obj = getResources();
        if (flag)
        {
            i = 0x7f020256;
        } else
        {
            i = 0x7f020252;
        }
        obj = ((Resources) (obj)).getDrawable(i);
        seeAllSearchesButton.setCompoundDrawablesWithIntrinsicBounds(null, null, ((android.graphics.drawable.Drawable) (obj)), null);
    }

    protected void initAdapter(Context context)
    {
        boolean flag1 = false;
        if (listAdapter != null)
        {
            listAdapter.setOnRequestMoreListener(null);
        }
        int i;
        boolean flag;
        if (!DeviceInfoUtil.isPortrait(context))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        flag = flag1;
        if (isTablet)
        {
            flag = flag1;
            if (i != 0)
            {
                flag = true;
            }
        }
        isListFourAcross = flag;
        if (isListFourAcross)
        {
            i = 0x7f0300a8;
        } else
        {
            i = 0x7f0300a7;
        }
        listAdapter = new FollowingContentListAdapter(context, i, new ImageOnClickListener());
        listAdapter.setOnRequestMoreListener(this);
        listAdapter.setEmptyViewResource(0x7f03016c);
        listAdapter.setLoadingViewResource(0x7f03016e);
        list.setFastScrollEnabled(true);
        list.setAdapter(listAdapter);
    }

    public void onClick(View view, ViewModel viewmodel)
    {
        view = getActivity();
        FwActivity fwactivity = getFwActivity();
        if (viewmodel instanceof FollowedSearchViewModel)
        {
            viewmodel = (FollowedSearchViewModel)viewmodel;
            ActivityStarter.startSavedSearch(view, fwactivity.getEbayContext(), ((FollowedSearchViewModel) (viewmodel)).id, null, getSourceIdentification("search"));
        } else
        {
            if (viewmodel instanceof FollowedMemberViewModel)
            {
                viewmodel = (FollowedMemberViewModel)viewmodel;
                SearchParameters searchparameters = eBayDictionaryProvider.getLockedSearchParameters(view, null);
                searchparameters.sellerId = ((FollowedMemberViewModel) (viewmodel)).username;
                startActivity(addSourceIdTracking(ActivityStarter.getSearchResultListIntent(view, searchparameters, null), "member"));
                return;
            }
            if (viewmodel instanceof FollowedCollectionViewModel)
            {
                CollectionDetailsActivity.startActivity(view, ((FollowedCollectionViewModel)viewmodel).id, null, getSourceIdentification("collection"));
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        boolean flag;
        if (bundle != null && bundle.getBoolean("searchOnly"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displaySearchOnly = flag;
        isTablet = getResources().getBoolean(0x7f0b0006);
        bundle = getActivity();
        itemCache = new ItemCache(bundle);
        notificationPrefs = new NotificationPreferenceManager(bundle);
        isPortrait = DeviceInfoUtil.isPortrait(bundle);
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (displaySearchOnly)
        {
            return layoutinflater.inflate(0x7f030035, viewgroup, false);
        } else
        {
            return layoutinflater.inflate(0x7f030030, viewgroup, false);
        }
    }

    public void onFollowingContentChanged(FollowingContentDataManager followingcontentdatamanager, Content content)
    {
        haveInitialFollowingResponse = true;
        if (refreshLayout != null)
        {
            refreshLayout.setRefreshing(false);
        }
        followingcontentdatamanager = content.getStatus();
        if (followingcontentdatamanager.hasError())
        {
            EbayErrorHandler.handleResultStatus(this, 0, followingcontentdatamanager);
            if (haveInitialFeedResponse)
            {
                setListShown(true);
            }
        } else
        {
            followingcontentdatamanager = (FollowingContent)content.getData();
            if (followingcontentdatamanager != null && ((FollowingContent) (followingcontentdatamanager)).followedEntities != null)
            {
                handleInterestsContentChanged(((FollowingContent) (followingcontentdatamanager)).followedEntities.interests);
                handleMembersContentChanged(((FollowingContent) (followingcontentdatamanager)).followedEntities.users);
                handleCollectionsContentChanged(((FollowingContent) (followingcontentdatamanager)).followedEntities.collections);
            } else
            {
                handleInterestsContentChanged(null);
                handleMembersContentChanged(null);
                handleCollectionsContentChanged(null);
            }
            setListShown(true);
            if (sendPageImpressionOnUssContentLoaded)
            {
                sendPageImpression();
                return;
            }
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        userContextDataManager = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, null);
        if (!displaySearchOnly)
        {
            feedDataManager = (UssFeedDataManager)datamanagercontainer.initialize(UssFeedDataManager.KEY, this);
            feedDataManager.loadPage(1, this);
        }
        followingContentDataManager = (FollowingContentDataManager)datamanagercontainer.initialize(FollowingContentDataManager.KEY, this);
    }

    public void onRequestMore(CompositeArrayAdapter compositearrayadapter, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i, int j)
    {
        feedDataManager.loadPage(j, this);
    }

    public void onResume()
    {
        super.onResume();
        sendPageImpression();
    }

    public void onSetFollowedEntityIsHiddenComplete(FollowingContentDataManager followingcontentdatamanager, Content content)
    {
    }

    public void onStreamListChanged(UssFeedDataManager ussfeeddatamanager, ListContent listcontent)
    {
        haveInitialFeedResponse = true;
        ussfeeddatamanager = listcontent.getStatus();
        if (ussfeeddatamanager.hasError())
        {
            EbayErrorHandler.handleResultStatus(this, 0, ussfeeddatamanager);
        } else
        {
            List list1 = listcontent.getList();
            int k;
            int j1;
            int k1;
            if (list1 != null && !list1.isEmpty())
            {
                k = listcontent.getTotalItemCount();
            } else
            {
                k = 0;
            }
            k1 = listcontent.getUnfilteredItemsLoaded();
            j1 = listcontent.getPagesLoaded();
            ussfeeddatamanager = null;
            float f;
            int j;
            if (list1 != null)
            {
                int l1 = list1.size();
                ussfeeddatamanager = new ArrayList((int)Math.ceil((double)l1 / 3D));
                int i1;
                if (isListFourAcross)
                {
                    int l = 0;
                    int i = 0;
                    while (l < l1) 
                    {
                        com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord;
                        com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord2;
                        com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord4;
                        com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord6;
                        com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord7;
                        if (i == 5)
                        {
                            i = 4;
                        } else
                        {
                            i = 5;
                        }
                        feedvaluerecord7 = (com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord)list1.get(l);
                        if (l + 1 < l1)
                        {
                            feedvaluerecord = (com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord)list1.get(l + 1);
                        } else
                        {
                            feedvaluerecord = null;
                        }
                        if (l + 2 < l1)
                        {
                            feedvaluerecord2 = (com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord)list1.get(l + 2);
                        } else
                        {
                            feedvaluerecord2 = null;
                        }
                        if (l + 3 < l1)
                        {
                            feedvaluerecord4 = (com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord)list1.get(l + 3);
                        } else
                        {
                            feedvaluerecord4 = null;
                        }
                        if (i == 5 && l + 4 < l1)
                        {
                            feedvaluerecord6 = (com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord)list1.get(l + 4);
                        } else
                        {
                            feedvaluerecord6 = null;
                        }
                        ussfeeddatamanager.add(new FollowingContentListAdapter.FeedRow(feedvaluerecord7, feedvaluerecord, feedvaluerecord2, feedvaluerecord4, feedvaluerecord6));
                        l += i;
                    }
                } else
                {
                    j = 0;
                    while (j < l1) 
                    {
                        com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord5 = (com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord)list1.get(j);
                        com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord1;
                        com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord feedvaluerecord3;
                        if (j + 1 < l1)
                        {
                            feedvaluerecord1 = (com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord)list1.get(j + 1);
                        } else
                        {
                            feedvaluerecord1 = null;
                        }
                        if (j + 2 < l1)
                        {
                            feedvaluerecord3 = (com.ebay.nautilus.domain.content.dm.UssFeedDataManager.FeedValueRecord)list1.get(j + 2);
                        } else
                        {
                            feedvaluerecord3 = null;
                        }
                        ussfeeddatamanager.add(new FollowingContentListAdapter.FeedRow(feedvaluerecord5, feedvaluerecord1, feedvaluerecord3, null, null));
                        j += 3;
                    }
                }
            }
            if (isListFourAcross)
            {
                f = 4.5F;
            } else
            {
                f = 3F;
            }
            k = (int)Math.ceil((double)k / (double)f);
            i1 = (int)Math.ceil((double)k1 / (double)f);
            if (!listcontent.getStatus().hasError())
            {
                j = 25;
            } else
            {
                j = -1;
            }
            listAdapter.clear();
            listAdapter.add(listAdapter.newSection(0, "Feed", ussfeeddatamanager, k, i1, -1, j1, j));
            if (haveInitialFollowingResponse)
            {
                setListShown(true);
                return;
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        Activity activity = getActivity();
        bundle = view;
        progressContainer = view.findViewById(0x7f1000ca);
        EditOnClickListener editonclicklistener = new EditOnClickListener();
        RecyclerView recyclerview;
        int i;
        if (displaySearchOnly)
        {
            scrollView = (ScrollView)view.findViewById(0x7f1000e0);
        } else
        {
            list = (ListView)view.findViewById(0x102000a);
            bundle = activity.getLayoutInflater().inflate(0x7f030031, list, false);
            list.addHeaderView(bundle);
        }
        searchesLayout = bundle.findViewById(0x7f1000e1);
        seeAllSearchesButton = (Button)searchesLayout.findViewById(0x7f1000e5);
        searchesAdapter = new BrowseFollowingSearchesFragmentAdapter(activity, false);
        recyclerview = (RecyclerView)searchesLayout.findViewById(0x7f1000e4);
        recyclerview.setLayoutManager(searchesAdapter.createLayoutManager());
        recyclerview.setAdapter(searchesAdapter);
        searchesAdapter.setOnClickListener(this, new int[0]);
        searchesLayout.findViewById(0x7f1000e3).setOnClickListener(editonclicklistener);
        i = searchesAdapter.getNumSpans();
        if (i > 1)
        {
            recyclerview.addItemDecoration(new VerticalDividerItemDecoration(activity, i));
        } else
        {
            recyclerview.addItemDecoration(new HorizontalDividerSearchItemDecoration(activity));
        }
        if (displaySearchOnly)
        {
            seeAllSearchesButton.setVisibility(8);
            isSearchesExpanded = true;
        } else
        {
            membersLayout = bundle.findViewById(0x7f1000d7);
            seeAllMembersButton = (Button)membersLayout.findViewById(0x7f1000db);
            membersAdapter = new BrowseFollowingMembersFragmentAdapter(activity, false);
            RecyclerView recyclerview1 = (RecyclerView)membersLayout.findViewById(0x7f1000da);
            recyclerview1.setLayoutManager(membersAdapter.createLayoutManager());
            recyclerview1.setAdapter(membersAdapter);
            membersAdapter.setOnClickListener(this, new int[0]);
            membersLayout.findViewById(0x7f1000d9).setOnClickListener(editonclicklistener);
            int j = membersAdapter.getNumSpans();
            if (j > 1)
            {
                recyclerview1.addItemDecoration(new VerticalDividerItemDecoration(activity, j));
            } else
            {
                recyclerview1.addItemDecoration(new HorizontalDividerSearchItemDecoration(activity));
            }
            collectionsLayout = bundle.findViewById(0x7f1000cf);
            seeAllCollectionsButton = (Button)collectionsLayout.findViewById(0x7f1000d3);
            collectionsAdapter = new BrowseFollowingCollectionsFragmentAdapter(activity, false);
            bundle = (RecyclerView)collectionsLayout.findViewById(0x7f1000d2);
            bundle.setLayoutManager(collectionsAdapter.createLayoutManager());
            bundle.setAdapter(collectionsAdapter);
            collectionsAdapter.setOnClickListener(this, new int[0]);
            collectionsLayout.findViewById(0x7f1000d1).setOnClickListener(editonclicklistener);
            bundle = new SeeAllOnClickListener();
            seeAllSearchesButton.setOnClickListener(bundle);
            seeAllMembersButton.setOnClickListener(bundle);
            seeAllCollectionsButton.setOnClickListener(bundle);
            isSearchesExpanded = true;
            initAdapter(activity);
        }
        setListShown(false);
        refreshLayout = (SwipeRefreshLayout)view.findViewById(0x7f1000d4);
        if (refreshLayout != null)
        {
            refreshLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

                final BrowseFollowingFragment this$0;

                public void onRefresh()
                {
                    if (followingContentDataManager != null)
                    {
                        refreshLayout.setRefreshing(true);
                        followingContentDataManager.invalidateAndForceReloadData();
                    }
                    if (feedDataManager != null)
                    {
                        feedDataManager.invalidateAndForceReloadData();
                    }
                    (new UserCache(getBaseActivity())).refreshSavedSearchList();
                }

            
            {
                this$0 = BrowseFollowingFragment.this;
                super();
            }
            });
        }
    }

    protected final void scrollToHeader(final View headerLayout)
    {
        list.post(new Runnable() {

            final BrowseFollowingFragment this$0;
            final View val$headerLayout;

            public void run()
            {
                list.smoothScrollToPositionFromTop(0, -headerLayout.getTop());
            }

            
            {
                this$0 = BrowseFollowingFragment.this;
                headerLayout = view;
                super();
            }
        });
    }
}
