// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.android.util.view.widget.LoadingIndicator;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.container.Option;
import com.comcast.cim.cmasl.utils.container.Tuple4;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.database.VideoBookmarkDAO;
import com.xfinity.playerlib.model.editorial.FeaturedResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class FeaturedFragment extends AuthenticatingFragment
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/featured/FeaturedFragment);
    protected static final Map premiumNetworks = new HashMap();
    private AlternateInterfaceListener alternateInterfaceListener;
    protected final Task bookmarkFetcher = new NonCachingBaseTask() {

        final FeaturedFragment this$0;

        public Option execute()
        {
            Object obj = videoBookmarkDAO.getLastWatchedBookmark();
            LiveStreamBookmark livestreambookmark = liveStreamBookmarkDAO.getLastWatchedBookmark();
            if (obj == null || livestreambookmark != null && ((VideoBookmark) (obj)).getTimestamp().compareTo(livestreambookmark.getTimestamp()) <= 0)
            {
                obj = livestreambookmark;
            }
            return new Option(obj);
        }

        public volatile Object execute()
        {
            return execute();
        }

            
            {
                this$0 = FeaturedFragment.this;
                super();
            }
    };
    protected BookmarkUtils bookmarkUtils;
    protected final CoverArtImageLoader coverArtImageLoader = PlayerContainer.getInstance().createCoverArtImageLoader();
    protected FeaturedResource featuredResource;
    protected TaskExecutionListener fetchListener;
    protected boolean firstTimeLoadStarted;
    private final InternetConnection internetConnection = PlayerContainer.getInstance().getInternetConnection();
    protected LayoutInflater layoutInflator;
    protected LiveStreamBookmarkDAO liveStreamBookmarkDAO;
    private DefaultLoadingViewDelegate loadingViewDelegate;
    protected final NetworkLogoImageLoader networkLogoLoader = PlayerContainer.getInstance().createNetworkLogoImageLoader();
    protected TaskExecutor programProvider;
    protected TaskExecutor provider;
    protected TagsRoot tagsRoot;
    protected PlayNowTrackingService trackingService;
    protected PlayNowUserManager userManager;
    protected VideoBookmarkDAO videoBookmarkDAO;
    protected VideoEntitlement videoEntitlement;

    public FeaturedFragment()
    {
        trackingService = PlayerContainer.getInstance().getTrackingService();
        videoBookmarkDAO = PlayerContainer.getInstance().getVideoBookmarkDAO();
        liveStreamBookmarkDAO = PlayerContainer.getInstance().getLiveStreamBookmarkDAO();
        userManager = PlayerContainer.getInstance().getUserManager();
        bookmarkUtils = PlayerContainer.getInstance().getBookmarkUtils();
        provider = PlayerContainer.getInstance().getTaskExecutorFactory().create(PlayerContainer.getInstance().getVideoEntitlementCache(), PlayerContainer.getInstance().getFeaturedResourceCache(), PlayerContainer.getInstance().getTagsRootCache(), bookmarkFetcher);
        programProvider = PlayerContainer.getInstance().getDibicCombinedTaskExecutor();
        featuredResource = new FeaturedResource(null, null);
        firstTimeLoadStarted = false;
    }

    protected abstract int getLayoutId();

    protected void getPremiumNetworks(List list)
    {
        if (premiumNetworks.keySet().size() <= 0)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                Network network = (Network)list.next();
                if (network.isPremium())
                {
                    premiumNetworks.put(Long.valueOf(network.getCompanyId()), network);
                }
            }
        }
    }

    public void loadResources()
    {
        fetchListener = provider.execute(new DefaultTaskExecutionListener() {

            final FeaturedFragment this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                loadingViewDelegate.onLoadingFailed();
            }

            public void onPostExecute(Tuple4 tuple4)
            {
                setupResources(tuple4);
                postOnResourceFetched(tuple4);
                loadingViewDelegate.onLoadingFinished();
                alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.id.ACCESSIBILITY_ANNOUNCE_LOADED);
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((Tuple4)obj);
            }

            public void onPreAsynchronousExecute()
            {
                alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.string.loading);
            }

            
            {
                this$0 = FeaturedFragment.this;
                super();
            }
        });
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutInflator = layoutinflater;
        layoutinflater = layoutinflater.inflate(getLayoutId(), viewgroup, false);
        viewgroup = (ViewGroup)layoutinflater.findViewById(com.xfinity.playerlib.R.id.body_container);
        bundle = (LoadingIndicator)layoutinflater.findViewById(com.xfinity.playerlib.R.id.loading_indicator);
        loadingViewDelegate = new DefaultLoadingViewDelegate(getActivity(), viewgroup, bundle, internetConnection, new com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate.ReadyListener() {

            final FeaturedFragment this$0;

            public void onReady()
            {
                loadResources();
            }

            
            {
                this$0 = FeaturedFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onStartInternal()
    {
        super.onStartInternal();
        loadingViewDelegate.onStart();
    }

    public void onStop()
    {
        super.onStop();
        loadingViewDelegate.onStop();
        if (fetchListener != null)
        {
            provider.cancelNotificationsFor(fetchListener);
        }
        coverArtImageLoader.purgeJobs();
        networkLogoLoader.purgeJobs();
    }

    protected abstract void postOnResourceFetched(Tuple4 tuple4);

    protected void setupResources(Tuple4 tuple4)
    {
        videoEntitlement = (VideoEntitlement)tuple4.e1;
        featuredResource = (FeaturedResource)tuple4.e2;
        tagsRoot = (TagsRoot)tuple4.e3;
        getPremiumNetworks(tagsRoot.getNetworks());
    }

    protected void showDetail(MerlinId merlinid)
    {
        showDetail(merlinid, null);
    }

    protected void showDetail(MerlinId merlinid, MerlinId merlinid1)
    {
        startActivity((new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(merlinid)).showDetail(true).episodeId(merlinid1).build().getIntent(getActivity()));
    }



}
