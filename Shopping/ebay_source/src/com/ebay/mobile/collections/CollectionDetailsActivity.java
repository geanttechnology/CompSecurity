// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.content.dm.CollectionDetailsDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.CollectionDetail;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.NumberUtil;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionDetailsAdapter, CollectionDetailsPageHeaderViewModel

public class CollectionDetailsActivity extends BaseActivity
    implements com.ebay.nautilus.domain.content.dm.CollectionDetailsDataManager.Observer
{
    private class FollowedCollectionDataManagerObserver extends com.ebay.common.content.dm.FollowedEntityDataManager.SimpleObserver
    {

        private boolean isFollowed;
        final CollectionDetailsActivity this$0;

        public void onCollectionFollowed(Content content)
        {
            if (followButton != null)
            {
                followButton.setEnabled(true);
            }
            isFollowed = true;
            content = userContextDataManager.getCurrentCountry().getSiteGlobalId();
            followedEntityDataManager.getFollowers(FollowType.COLLECTION, CollectionDetailsActivity.collectionId, content, followedCollectionObserver, true);
        }

        public void onFollowDeleted(FollowType followtype, String s, ResultStatus resultstatus)
        {
            if (followButton != null)
            {
                followButton.setEnabled(true);
            }
            if (followtype == FollowType.COLLECTION && s == CollectionDetailsActivity.collectionId)
            {
                isFollowed = false;
                followtype = userContextDataManager.getCurrentCountry().getSiteGlobalId();
                followedEntityDataManager.getFollowers(FollowType.COLLECTION, CollectionDetailsActivity.collectionId, followtype, followedCollectionObserver, true);
            }
        }

        public void onFollowedCollectionsLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
        {
            followedentitydatamanager = ((List)datedcontent.getData()).iterator();
            do
            {
                if (!followedentitydatamanager.hasNext())
                {
                    break;
                }
                if (!((FollowDescriptor)followedentitydatamanager.next()).collectionId.equals(CollectionDetailsActivity.collectionId))
                {
                    continue;
                }
                isFollowed = true;
                break;
            } while (true);
            followedentitydatamanager = userContextDataManager.getCurrentCountry().getSiteGlobalId();
            followedEntityDataManager.getFollowers(FollowType.COLLECTION, CollectionDetailsActivity.collectionId, followedentitydatamanager, followedCollectionObserver, true);
        }

        public void onFollowersLoaded(FollowType followtype, Content content)
        {
            followtype = (com.ebay.common.net.api.followinterest.GetFollowersLoadTask.FollowerSummary)content.getData();
            if (followtype != null)
            {
                followerCount = ((com.ebay.common.net.api.followinterest.GetFollowersLoadTask.FollowerSummary) (followtype)).followerCount.intValue();
                adapter.updateHeaderFollowedInfo(isFollowed, followerCount);
                if (trackPageImpressionWhenLoaded)
                {
                    trackPageImpressionWhenLoaded = false;
                    sendTracking(TrackingType.PAGE_IMPRESSION);
                    return;
                }
            }
        }

        private FollowedCollectionDataManagerObserver()
        {
            this$0 = CollectionDetailsActivity.this;
            super();
        }

    }


    private static final String EXTRA_CHANNEL_OR_DEPARTMENT = "channelOrDepartment";
    public static String EXTRA_COLLECTION_ID = "collectionId";
    private static String collectionId;
    private CollectionDetailsAdapter adapter;
    private String channelOrDepartment;
    private CollectionDetailsDataManager collectionDetailsDataManager;
    private String collectionName;
    private String collectionOwner;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener defaultClickListener;
    int firstVisibleItemIndex;
    private TextView followButton;
    private final FollowedCollectionDataManagerObserver followedCollectionObserver = new FollowedCollectionDataManagerObserver();
    private FollowedEntityDataManager followedEntityDataManager;
    private int followerCount;
    private boolean isFirstViewPageLoaded;
    private LinearLayoutManager layoutManager;
    int layoutManagerItemCount;
    private boolean loading;
    private final int pagingThreshold;
    private int previousItemCount;
    private View progressView;
    private RecyclerView recyclerView;
    int recyclerViewChildCount;
    private boolean trackPageImpressionWhenLoaded;
    private UserContextDataManager userContextDataManager;

    public CollectionDetailsActivity()
    {
        previousItemCount = 0;
        loading = true;
        pagingThreshold = CollectionDetailsDataManager.COLLECTION_ITEM_PAGE_SIZE / 2;
        defaultClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final CollectionDetailsActivity this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                String s;
                Authentication authentication;
                String s2;
                authentication = userContextDataManager.getCurrentUser();
                long l;
                if (authentication != null)
                {
                    s = authentication.iafToken;
                } else
                {
                    s = null;
                }
                s2 = userContextDataManager.getCurrentCountry().getSiteGlobalId();
                getResources().getString(0x7f070127);
                view.getId();
                JVM INSTR tableswitch 2131755309 2131755311: default 80
            //                           2131755309 113
            //                           2131755310 250
            //                           2131755311 434;
                   goto _L1 _L2 _L3 _L4
_L1:
                l = NumberUtil.safeParseLong((String)view.getTag()).longValue();
                ItemViewActivity.StartActivity(CollectionDetailsActivity.this, l, com.ebay.common.ConstantsCommon.ItemKind.Unknown);
_L6:
                return;
_L2:
                followButton = (TextView)view;
                if (followButton != null)
                {
                    if (authentication == null)
                    {
                        view = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), CollectionDetailsActivity.this);
                        startActivityForResult(view, 65);
                        return;
                    }
                    if (getResources().getString(0x7f070127).equals(followButton.getText()))
                    {
                        followedEntityDataManager.followCollection(CollectionDetailsActivity.collectionId, s2);
                        followButton.setEnabled(false);
                        return;
                    } else
                    {
                        followedEntityDataManager.deleteFollow(FollowType.COLLECTION, CollectionDetailsActivity.collectionId, s);
                        followButton.setEnabled(false);
                        return;
                    }
                }
                continue; /* Loop/switch isn't completed */
_L3:
                view = new Intent("android.intent.action.SEND");
                view.setType("text/plain");
                if (collectionName != null && collectionOwner != null)
                {
                    viewmodel = collectionName.replace("  ", " ").replace(" ", "-").toLowerCase(Locale.getDefault());
                    viewmodel = String.format("http://www.%s/cln/%s/%s/%s", new Object[] {
                        MyApp.getPrefs().getCurrentSite().getDomain(), collectionOwner, Uri.encode(viewmodel), CollectionDetailsActivity.collectionId
                    });
                    Resources resources = getResources();
                    String s1 = resources.getString(0x7f070282);
                    view.putExtra("android.intent.extra.SUBJECT", s1);
                    view.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(s1).append(" ").append(viewmodel).toString());
                    startActivity(Intent.createChooser(view, resources.getString(0x7f0704ef)));
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L4:
                view = (CollectionDetailsPageHeaderViewModel)viewmodel;
                if (view != null && ((CollectionDetailsPageHeaderViewModel) (view)).collection != null && ((CollectionDetailsPageHeaderViewModel) (view)).collection.creator != null && ((CollectionDetailsPageHeaderViewModel) (view)).collection.creator.userIdentifier != null)
                {
                    view = ((CollectionDetailsPageHeaderViewModel) (view)).collection.creator.userIdentifier.username;
                    if (view != null)
                    {
                        UserDetailActivity.StartActivity(CollectionDetailsActivity.this, null, view, null, null, false, true, false, false, null, false, null);
                        return;
                    }
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                this$0 = CollectionDetailsActivity.this;
                super();
            }
        };
    }

    private void sendTracking(TrackingType trackingtype)
    {
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), trackingtype);
        if (trackingtype.equals(TrackingType.PAGE_IMPRESSION))
        {
            trackingtype = getIntent();
            trackingdata.addKeyValuePair("collectionID", collectionId);
            trackingdata.addKeyValuePair("followers", String.valueOf(followerCount));
            trackingdata.addSourceIdentification(trackingtype);
        }
        trackingdata.send(this);
    }

    private void showProgress(boolean flag)
    {
        byte byte0 = 8;
        Object obj = progressView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        obj = recyclerView;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((RecyclerView) (obj)).setVisibility(i);
    }

    public static void startActivity(Activity activity, String s, String s1, SourceIdentification sourceidentification)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/collections/CollectionDetailsActivity);
        intent.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
        intent.putExtra(EXTRA_COLLECTION_ID, s);
        intent.putExtra("channelOrDepartment", s1);
        activity.startActivity(intent);
    }

    public String getTrackingEventName()
    {
        return "CollectionDetails";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        switch (i)
        {
        default:
            return;

        case 65: // 'A'
            break;
        }
        if (j == -1)
        {
            intent = userContextDataManager.getCurrentCountry().getSiteGlobalId();
            followedEntityDataManager.followCollection(collectionId, intent);
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onCollectionChanged(CollectionDetailsDataManager collectiondetailsdatamanager, Content content)
    {
        showProgress(false);
        collectiondetailsdatamanager = content.getStatus();
        if (!collectiondetailsdatamanager.hasError()) goto _L2; else goto _L1
_L1:
        EbayErrorHandler.handleResultStatus(this, 0, collectiondetailsdatamanager);
_L4:
        return;
_L2:
        if (content == null) goto _L4; else goto _L3
_L3:
        collectiondetailsdatamanager = (CollectionDetail)content.getData();
        if (collectiondetailsdatamanager == null) goto _L4; else goto _L5
_L5:
        collectiondetailsdatamanager = ((CollectionDetail) (collectiondetailsdatamanager)).collection;
        if (collectiondetailsdatamanager == null) goto _L4; else goto _L6
_L6:
        adapter.appendToCollection(collectiondetailsdatamanager);
        if (((com.ebay.nautilus.domain.data.CollectionDetail.Collection) (collectiondetailsdatamanager)).creator != null && ((com.ebay.nautilus.domain.data.CollectionDetail.Collection) (collectiondetailsdatamanager)).creator.userIdentifier != null)
        {
            collectionOwner = ((com.ebay.nautilus.domain.data.CollectionDetail.Collection) (collectiondetailsdatamanager)).creator.userIdentifier.username;
        }
        collectionName = ((com.ebay.nautilus.domain.data.CollectionDetail.Collection) (collectiondetailsdatamanager)).name;
        content = userContextDataManager.getCurrentUser();
        if (content == null) goto _L8; else goto _L7
_L7:
        followedEntityDataManager.getFollows(((Authentication) (content)).iafToken, userContextDataManager.getCurrentCountry().getSite(), false);
_L10:
        isFirstViewPageLoaded = true;
        return;
_L8:
        followerCount = ((com.ebay.nautilus.domain.data.CollectionDetail.Collection) (collectiondetailsdatamanager)).followersCount;
        adapter.updateHeaderFollowedInfo(false, ((com.ebay.nautilus.domain.data.CollectionDetail.Collection) (collectiondetailsdatamanager)).followersCount);
        if (trackPageImpressionWhenLoaded)
        {
            trackPageImpressionWhenLoaded = false;
            sendTracking(TrackingType.PAGE_IMPRESSION);
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        collectionId = bundle.getStringExtra(EXTRA_COLLECTION_ID);
        if (collectionId == null)
        {
            finish();
        }
        setContentView(0x7f030069);
        channelOrDepartment = bundle.getStringExtra("channelOrDepartment");
        recyclerView = (RecyclerView)findViewById(0x102000a);
        progressView = findViewById(0x7f1000ca);
        showProgress(true);
        adapter = new CollectionDetailsAdapter(this);
        adapter.setOnClickListener(defaultClickListener, new int[0]);
        layoutManager = new GridLayoutManager(this, adapter.getNumSpans());
        if (!getResources().getBoolean(0x7f0b0006))
        {
            ((GridLayoutManager)layoutManager).setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

                final CollectionDetailsActivity this$0;

                public int getSpanSize(int i)
                {
                    switch (adapter.getItemViewType(i))
                    {
                    default:
                        return 1;

                    case 5: // '\005'
                    case 6: // '\006'
                    case 7: // '\007'
                        return 2;
                    }
                }

            
            {
                this$0 = CollectionDetailsActivity.this;
                super();
            }
            });
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new android.support.v7.widget.RecyclerView.OnScrollListener() {

            final CollectionDetailsActivity this$0;
            public int totalScrolled;

            public void onScrolled(RecyclerView recyclerview, int i, int j)
            {
                totalScrolled = totalScrolled + j;
                recyclerViewChildCount = recyclerview.getChildCount();
                layoutManagerItemCount = layoutManager.getItemCount();
                firstVisibleItemIndex = layoutManager.findFirstVisibleItemPosition();
                if (loading && layoutManagerItemCount > previousItemCount)
                {
                    loading = false;
                    previousItemCount = layoutManagerItemCount;
                }
                if (!loading && layoutManagerItemCount - recyclerViewChildCount <= firstVisibleItemIndex + pagingThreshold)
                {
                    collectionDetailsDataManager.loadNextPage(false);
                    loading = true;
                }
            }

            
            {
                this$0 = CollectionDetailsActivity.this;
                super();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        collectionDetailsDataManager = (CollectionDetailsDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.CollectionDetailsDataManager.KeyParams(collectionId), this);
        if (!isFirstViewPageLoaded)
        {
            trackPageImpressionWhenLoaded = true;
            collectionDetailsDataManager.loadNextPage(true);
        } else
        {
            sendTracking(TrackingType.PAGE_IMPRESSION);
        }
        userContextDataManager = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, null);
        followedEntityDataManager = (FollowedEntityDataManager)datamanagercontainer.initialize(FollowedEntityDataManager.KEY, followedCollectionObserver);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString(EXTRA_COLLECTION_ID, collectionId);
        bundle.putString("channelOrDepartment", channelOrDepartment);
        super.onSaveInstanceState(bundle);
    }









/*
    static TextView access$1402(CollectionDetailsActivity collectiondetailsactivity, TextView textview)
    {
        collectiondetailsactivity.followButton = textview;
        return textview;
    }

*/






/*
    static boolean access$302(CollectionDetailsActivity collectiondetailsactivity, boolean flag)
    {
        collectiondetailsactivity.loading = flag;
        return flag;
    }

*/



/*
    static int access$402(CollectionDetailsActivity collectiondetailsactivity, int i)
    {
        collectiondetailsactivity.previousItemCount = i;
        return i;
    }

*/





/*
    static int access$702(CollectionDetailsActivity collectiondetailsactivity, int i)
    {
        collectiondetailsactivity.followerCount = i;
        return i;
    }

*/



/*
    static boolean access$802(CollectionDetailsActivity collectiondetailsactivity, boolean flag)
    {
        collectiondetailsactivity.trackPageImpressionWhenLoaded = flag;
        return flag;
    }

*/

}
