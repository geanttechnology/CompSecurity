// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.container.Tuple4;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.utils.UIUtil;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.model.Favorite;
import com.xfinity.playerlib.model.LiveStreamFavorite;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.database.FavoriteDAO;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.tracking.PlayNowTab;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.browsehistory.MultiDeleteBrowseAdapter;
import com.xfinity.playerlib.view.browsehistory.MultiDeleteBrowseFragment;
import com.xfinity.playerlib.view.common.UpsellDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.favorite:
//            BookmarksAdapter

public class BookmarksFragment extends MultiDeleteBrowseFragment
{
    public static interface FavoriteListener
    {

        public abstract void playLiveStream(LiveStreamFavorite livestreamfavorite);

        public abstract void showDetail(VideoFavorite videofavorite);
    }


    private final AndroidDevice androidDevice = PlayerContainer.getInstance().getAndroidDevice();
    protected final CoverArtImageLoader coverArtImageLoader = PlayerContainer.getInstance().createCoverArtImageLoader();
    private final Task dibicResourceCache = PlayerContainer.getInstance().getDibicCombinedCache();
    private FavoriteDAO favoriteDAO;
    private FavoriteListener favoriteListener;
    private LiveStreamBookmarkDAO liveStreamBookmarkDAO;
    private HalLiveStreamResource liveStreamResource;
    private final Task liveStreamResourceCache = PlayerContainer.getInstance().getLiveStreamResourceCache();
    private final TaskExecutorFactory providerFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
    private final Task resourceFetcher = new NonCachingBaseTask() {

        final BookmarksFragment this$0;

        public Tuple4 execute()
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(favoriteDAO.getAllFavorite());
            for (Iterator iterator = liveStreamBookmarkDAO.getFavorites().iterator(); iterator.hasNext(); arraylist.add(new LiveStreamFavorite((LiveStreamBookmark)iterator.next()))) { }
            Collections.sort(arraylist, new Comparator() {

                final _cls1 this$1;

                public int compare(Favorite favorite, Favorite favorite1)
                {
                    return favorite1.getCreated().compareTo(favorite.getCreated());
                }

                public volatile int compare(Object obj, Object obj1)
                {
                    return compare((Favorite)obj, (Favorite)obj1);
                }

            
            {
                this$1 = _cls1.this;
                super();
            }
            });
            return new Tuple4(dibicResourceCache.execute(), videoEntitlementCache.execute(), liveStreamResourceCache.execute(), arraylist);
        }

        public volatile Object execute()
        {
            return execute();
        }

            
            {
                this$0 = BookmarksFragment.this;
                super();
            }
    };
    private final TaskExecutor taskExecutor;
    protected final PlayNowTrackingService trackingService = PlayerContainer.getInstance().getTrackingService();
    protected UIUtil uiUtil;
    private VideoEntitlement videoEntitlement;
    private final Task videoEntitlementCache = PlayerContainer.getInstance().getVideoEntitlementCache();

    public BookmarksFragment()
    {
        uiUtil = PlayerContainer.getInstance().getUIUtil();
        favoriteDAO = PlayerContainer.getInstance().getFavoriteDAO();
        liveStreamBookmarkDAO = PlayerContainer.getInstance().getLiveStreamBookmarkDAO();
        taskExecutor = providerFactory.create(resourceFetcher);
    }

    private void onLiveStreamPlayRequested(final LiveStreamFavorite liveStreamFavorite)
    {
        Object obj = liveStreamResource.getLiveStream(liveStreamFavorite.getStreamId());
        if (obj == null || ((HalLiveStream) (obj)).getPlaybackLink() == null)
        {
            Object obj1 = new Bundle();
            ((Bundle) (obj1)).putString("title", getString(com.xfinity.playerlib.R.string.unavailable));
            ((Bundle) (obj1)).putString("description", (new StringBuilder()).append(getString(com.xfinity.playerlib.R.string.error_stream_not_available_text)).append(getString(com.xfinity.playerlib.R.string.remove_item_prompt, new Object[] {
                "bookmarks"
            })).toString());
            obj = CALDialogFragment.newInstance("inputPromptDlg");
            ((CALDialogFragment) (obj)).addArguments(((Bundle) (obj1)));
            obj1 = new ArrayList();
            ((List) (obj1)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getString(com.xfinity.playerlib.R.string.dlg_btn_yes), new android.content.DialogInterface.OnClickListener() ));
            ((List) (obj1)).add(new CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_no), new android.content.DialogInterface.OnClickListener() {

                final BookmarksFragment this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.cancel();
                }

            
            {
                this$0 = BookmarksFragment.this;
                super();
            }
            }));
            ((CALDialogFragment) (obj)).setButtonList(((List) (obj1)));
            ((CALDialogFragment) (obj)).show(getFragmentManager(), "caldialogfragment");
            return;
        }
        List list = ((HalLiveStream) (obj)).getProviderCodes();
        if (videoEntitlement.isEntitledToList((String[])list.toArray(new String[list.size()])))
        {
            uiUtil.ensureConnectivityBeforeExecuting(getActivity(), new Runnable() {

                final BookmarksFragment this$0;
                final LiveStreamFavorite val$liveStreamFavorite;

                public void run()
                {
                    favoriteListener.playLiveStream(liveStreamFavorite);
                }

            
            {
                this$0 = BookmarksFragment.this;
                liveStreamFavorite = livestreamfavorite;
                super();
            }
            });
            return;
        } else
        {
            liveStreamFavorite = getFragmentManager();
            UpsellDialog.newInstance(com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAY_FROM_HISTORY, ((HalLiveStream) (obj))).show(liveStreamFavorite, "upsell_dialog");
            return;
        }
    }

    protected volatile MultiDeleteBrowseAdapter createAdapter(LayoutInflater layoutinflater)
    {
        return createAdapter(layoutinflater);
    }

    protected BookmarksAdapter createAdapter(LayoutInflater layoutinflater)
    {
        return new BookmarksAdapter(layoutinflater, coverArtImageLoader, inBabyGuideMode);
    }

    protected void deleteItem(Favorite favorite)
    {
        if (favorite instanceof VideoFavorite)
        {
            favoriteDAO.deleteFavorite((VideoFavorite)favorite);
            return;
        } else
        {
            favorite = (LiveStreamFavorite)favorite;
            liveStreamBookmarkDAO.deleteFavorite(favorite.getStreamId());
            return;
        }
    }

    protected volatile void deleteItem(Object obj)
    {
        deleteItem((Favorite)obj);
    }

    protected List getData(Tuple4 tuple4)
    {
        return (List)tuple4.e4;
    }

    protected volatile List getData(Object obj)
    {
        return getData((Tuple4)obj);
    }

    protected TaskExecutor getDataTaskExecutor()
    {
        return taskExecutor;
    }

    protected com.xfinity.playerlib.view.browsehistory.MultiDeleteBrowseFragment.ItemClickListener getItemClickListener()
    {
        return new com.xfinity.playerlib.view.browsehistory.MultiDeleteBrowseFragment.ItemClickListener() {

            final BookmarksFragment this$0;

            public void onItemClicked(Favorite favorite)
            {
                if (favorite instanceof VideoFavorite)
                {
                    favoriteListener.showDetail((VideoFavorite)favorite);
                    return;
                } else
                {
                    onLiveStreamPlayRequested((LiveStreamFavorite)favorite);
                    return;
                }
            }

            public volatile void onItemClicked(Object obj)
            {
                onItemClicked((Favorite)obj);
            }

            
            {
                this$0 = BookmarksFragment.this;
                super();
            }
        };
    }

    protected CharSequence getListHeaderText()
    {
        return getResources().getString(com.xfinity.playerlib.R.string.favorite);
    }

    protected int getListViewId()
    {
        return com.xfinity.playerlib.R.id.bookmarks_grid;
    }

    protected int getViewLayoutId()
    {
        if (inBabyGuideMode && androidDevice.isTabletDevice())
        {
            return com.xfinity.playerlib.R.layout.bookmarks_babyguide;
        } else
        {
            return com.xfinity.playerlib.R.layout.bookmarks;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        favoriteListener = (FavoriteListener)activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        trackingService.trackTabRendered(PlayNowTab.BOOKMARKS);
        boolean flag = true;
        int i = ((flag) ? 1 : 0);
        if (androidDevice.isTabletDevice())
        {
            i = ((flag) ? 1 : 0);
            if (!inBabyGuideMode)
            {
                i = getResources().getInteger(com.xfinity.playerlib.R.integer.browse_grid_columns);
            }
        }
        ((GridView)layoutinflater.findViewById(getListViewId())).setNumColumns(i);
        return layoutinflater;
    }

    protected void onResourceFetched(Tuple4 tuple4)
    {
        ((BookmarksAdapter)adapter).setDibicResource((DibicResource)tuple4.e1);
        BookmarksAdapter bookmarksadapter = (BookmarksAdapter)adapter;
        Object obj = (VideoEntitlement)tuple4.e2;
        videoEntitlement = ((VideoEntitlement) (obj));
        bookmarksadapter.setVideoEntitlement(((VideoEntitlement) (obj)));
        bookmarksadapter = (BookmarksAdapter)adapter;
        obj = (HalLiveStreamResource)tuple4.e3;
        liveStreamResource = ((HalLiveStreamResource) (obj));
        bookmarksadapter.setLiveStreamResource(((HalLiveStreamResource) (obj)));
        super.setData((List)tuple4.e4);
    }

    protected volatile void onResourceFetched(Object obj)
    {
        onResourceFetched((Tuple4)obj);
    }








}
