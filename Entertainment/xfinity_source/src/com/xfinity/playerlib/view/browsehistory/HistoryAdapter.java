// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.android.util.view.widget.CheckableLinearLayout;
import com.comcast.cim.downloads.DownloadFile;
import com.comcast.cim.downloads.DownloadServiceListener;
import com.comcast.cim.downloads.SimpleDownloadServiceListener;
import com.comcast.cim.utils.UIPresentationUtil;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.xfinity.playerlib.bookmarks.Bookmark;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.view.ScrollStateTracker;
import com.xfinity.playerlib.view.downloads.DownloadsItemListener;
import com.xfinity.playerlib.view.widget.DownloadProgressBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            MultiDeleteBrowseAdapter

public class HistoryAdapter extends MultiDeleteBrowseAdapter
    implements com.comcast.cim.downloads.DownloadServiceListener
{
    class DownloadServiceListener extends SimpleDownloadServiceListener
    {

        final HistoryAdapter this$0;
        Map viewHolderMap;

        public void add(ViewHolder viewholder, PlayerDownloadFile playerdownloadfile)
        {
            if (!viewHolderMap.containsKey(playerdownloadfile))
            {
                viewHolderMap.put(playerdownloadfile, viewholder);
            }
        }

        public void onDownloadEngineStatusChanged(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
        {
            java.util.Map.Entry entry;
            for (ivirtuosodownloadenginestatus = viewHolderMap.entrySet().iterator(); ivirtuosodownloadenginestatus.hasNext(); ((ViewHolder)entry.getValue()).inProgressLayout.setProgress((PlayerDownloadFile)entry.getKey(), downloadManager, internetConnection))
            {
                entry = (java.util.Map.Entry)ivirtuosodownloadenginestatus.next();
            }

        }

        public volatile void onFileProgressUpdated(DownloadFile downloadfile)
        {
            onFileProgressUpdated((PlayerDownloadFile)downloadfile);
        }

        public void onFileProgressUpdated(PlayerDownloadFile playerdownloadfile)
        {
            ViewHolder viewholder = (ViewHolder)viewHolderMap.get(playerdownloadfile);
            if (viewholder != null)
            {
                viewholder.inProgressLayout.setProgress(playerdownloadfile, downloadManager, internetConnection);
            }
        }

        DownloadServiceListener()
        {
            this$0 = HistoryAdapter.this;
            super();
            viewHolderMap = new HashMap();
        }
    }

    protected static class ViewHolder
    {

        public LinearLayout button;
        public ImageView buttonArt;
        public TextView buttonCaption;
        public ImageView coverArt;
        public View downloadedLayout;
        public TextView expirationText;
        public DownloadProgressBar inProgressLayout;
        public CheckableLinearLayout itemContainerLayout;
        public TextView progressIndicator;
        public TextView seriesInfo;
        public TextView title;
        public LinearLayout watchingButton;

        protected ViewHolder()
        {
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browsehistory/HistoryAdapter);
    private static final FastDateFormat sdf = FastDateFormat.getInstance("MM/dd/yyyy");
    private List bookmarks;
    protected Context context;
    private CoverArtImageLoader coverArtImageLoader;
    Long currentlyPlayingVideoId;
    private DibicResource dibicResource;
    private PlayerDownloadServiceManager downloadManager;
    private DownloadServiceListener downloadServiceListener;
    private DownloadsItemListener downloadsItemListener;
    private Handler handler;
    private InternetConnection internetConnection;
    private final boolean isTabletDevice;
    int itemViewLayoutId;
    private android.view.View.OnClickListener liveStreamPlayButtonOnClickListener;
    private HalLiveStreamResource liveStreamResource;
    private final ScrollStateTracker scrollStateTracker;
    private VideoEntitlement videoEntitlement;
    private android.view.View.OnClickListener videoPlayButtonOnClickListener;

    public HistoryAdapter(LayoutInflater layoutinflater, CoverArtImageLoader coverartimageloader, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1, PlayerDownloadServiceManager playerdownloadservicemanager, DownloadsItemListener downloadsitemlistener, int i, 
            Long long1, boolean flag, ScrollStateTracker scrollstatetracker, InternetConnection internetconnection)
    {
        super(layoutinflater);
        bookmarks = new ArrayList();
        itemViewLayoutId = com.xfinity.playerlib.R.layout.history_item;
        handler = new Handler();
        downloadServiceListener = new DownloadServiceListener();
        coverArtImageLoader = coverartimageloader;
        videoPlayButtonOnClickListener = onclicklistener;
        liveStreamPlayButtonOnClickListener = onclicklistener1;
        downloadManager = playerdownloadservicemanager;
        downloadsItemListener = downloadsitemlistener;
        itemViewLayoutId = i;
        isTabletDevice = flag;
        scrollStateTracker = scrollstatetracker;
        internetConnection = internetconnection;
        currentlyPlayingVideoId = long1;
        context = layoutinflater.getContext();
    }

    private void presentEntitledVideo(ViewHolder viewholder, VideoBookmark videobookmark)
    {
        PlayerDownloadFile playerdownloadfile;
        if (videobookmark.getPosition() > 0 && !videobookmark.isFinished())
        {
            viewholder.buttonCaption.setText(context.getResources().getString(com.xfinity.playerlib.R.string.resume).toUpperCase(Locale.US));
            viewholder.buttonCaption.setContentDescription(context.getString(com.xfinity.playerlib.R.string.content_description_resume_button));
        } else
        {
            viewholder.buttonCaption.setText(context.getResources().getString(com.xfinity.playerlib.R.string.play).toUpperCase(Locale.US));
            viewholder.buttonCaption.setContentDescription(context.getString(com.xfinity.playerlib.R.string.content_description_play_button));
        }
        playerdownloadfile = downloadManager.findFileWithVideoId(videobookmark.getVideoId());
        if (playerdownloadfile == null)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        if (!playerdownloadfile.isDownloadComplete()) goto _L2; else goto _L1
_L1:
        showDownloadedInfo(viewholder, playerdownloadfile, videobookmark);
_L3:
        if (currentlyPlayingVideoId != null && currentlyPlayingVideoId.longValue() == videobookmark.getVideoId())
        {
            viewholder.watchingButton.setVisibility(0);
            viewholder.button.setVisibility(8);
        } else
        {
            viewholder.watchingButton.setVisibility(8);
            viewholder.button.setVisibility(0);
            if (isEditMode)
            {
                viewholder.button.setEnabled(false);
                viewholder.button.setClickable(false);
            } else
            if (playerdownloadfile != null && playerdownloadfile.getExpirationStatus() == com.xfinity.playerlib.model.downloads.PlayerDownloadFile.ExpirationStatus.OVP_EXPIRED)
            {
                viewholder.button.setEnabled(false);
                viewholder.button.setClickable(false);
            } else
            {
                viewholder.button.setEnabled(true);
                viewholder.button.setClickable(true);
            }
        }
        viewholder.buttonArt.setImageResource(com.xfinity.playerlib.R.drawable.play_button_entitled_graphic);
        viewholder.button.setBackgroundResource(com.xfinity.playerlib.R.drawable.play_button_entitled_background);
        return;
_L2:
        showInProgressInfo(viewholder, playerdownloadfile);
        return;
        viewholder.downloadedLayout.setVisibility(8);
        viewholder.inProgressLayout.setVisibility(8);
        viewholder.button.setVisibility(0);
          goto _L3
    }

    private void presentLiveStream(ViewHolder viewholder, boolean flag, boolean flag1)
    {
        viewholder.watchingButton.setVisibility(8);
        viewholder.button.setVisibility(0);
        viewholder.downloadedLayout.setVisibility(8);
        viewholder.inProgressLayout.setVisibility(8);
        viewholder.seriesInfo.setVisibility(8);
        if (isEditMode)
        {
            viewholder.button.setEnabled(false);
            viewholder.button.setClickable(false);
        } else
        {
            viewholder.button.setEnabled(true);
            viewholder.button.setClickable(true);
        }
        if (flag)
        {
            viewholder.buttonCaption.setText(context.getResources().getString(com.xfinity.playerlib.R.string.play).toUpperCase(Locale.US));
            viewholder.buttonCaption.setContentDescription(context.getString(com.xfinity.playerlib.R.string.content_description_play_button));
            if (flag1)
            {
                viewholder.buttonArt.setImageResource(com.xfinity.playerlib.R.drawable.play_button_entitled_graphic);
                viewholder.button.setBackgroundResource(com.xfinity.playerlib.R.drawable.play_button_entitled_background);
                return;
            } else
            {
                viewholder.buttonArt.setImageResource(com.xfinity.playerlib.R.drawable.icn_upsell_btn);
                viewholder.button.setBackgroundResource(com.xfinity.playerlib.R.drawable.play_button_unentitled_not_pressed);
                return;
            }
        } else
        {
            viewholder.buttonArt.setVisibility(8);
            viewholder.buttonCaption.setText(context.getResources().getString(com.xfinity.playerlib.R.string.no_longer_available).toUpperCase(Locale.US));
            viewholder.buttonCaption.setTextColor(context.getResources().getColor(com.xfinity.playerlib.R.color.MediumLightGray));
            viewholder.buttonCaption.setContentDescription(context.getResources().getString(com.xfinity.playerlib.R.string.content_description_play_button_unentitled));
            viewholder.button.setBackgroundResource(0);
            return;
        }
    }

    private void presentUnentitledVideo(ViewHolder viewholder)
    {
        viewholder.downloadedLayout.setVisibility(8);
        viewholder.inProgressLayout.setVisibility(8);
        viewholder.watchingButton.setVisibility(8);
        viewholder.buttonArt.setImageResource(com.xfinity.playerlib.R.drawable.icn_upsell_btn);
        viewholder.buttonCaption.setText(context.getResources().getString(com.xfinity.playerlib.R.string.play).toUpperCase(Locale.US));
        viewholder.buttonCaption.setContentDescription(context.getResources().getString(com.xfinity.playerlib.R.string.content_description_play_button_unentitled));
        viewholder.button.setBackgroundResource(com.xfinity.playerlib.R.drawable.play_button_unentitled);
    }

    private void showDownloadedInfo(ViewHolder viewholder, PlayerDownloadFile playerdownloadfile, Bookmark bookmark)
    {
        viewholder.downloadedLayout.setVisibility(0);
        viewholder.inProgressLayout.setVisibility(8);
        viewholder.watchingButton.setVisibility(8);
        viewholder.button.setVisibility(0);
        TextView textview = viewholder.buttonCaption;
        Resources resources = context.getResources();
        int i;
        if (bookmark.getPosition() > 0 && !bookmark.isFinished())
        {
            i = com.xfinity.playerlib.R.string.resume;
        } else
        {
            i = com.xfinity.playerlib.R.string.play;
        }
        textview.setText(resources.getString(i).toUpperCase(Locale.US));
        if (playerdownloadfile.getExpirationStatus() == com.xfinity.playerlib.model.downloads.PlayerDownloadFile.ExpirationStatus.AAW_EXPIRED)
        {
            viewholder.expirationText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            viewholder.expirationText.setTextColor(context.getResources().getColor(com.xfinity.playerlib.R.color.MediumLightGray));
            viewholder.expirationText.setText(context.getResources().getString(com.xfinity.playerlib.R.string.unavailable));
            viewholder.button.setVisibility(8);
            return;
        }
        if (playerdownloadfile.getAssetExpirationDate() != null && UIPresentationUtil.getDaysLeft(playerdownloadfile.getAssetExpirationDate()) < 14)
        {
            viewholder.expirationText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            viewholder.expirationText.setTextColor(context.getResources().getColor(com.xfinity.playerlib.R.color.MediumLightGray));
            viewholder.expirationText.setText(context.getResources().getString(com.xfinity.playerlib.R.string.available_until, new Object[] {
                sdf.format(playerdownloadfile.getAssetExpirationDate())
            }));
            viewholder.expirationText.setVisibility(0);
            return;
        } else
        {
            viewholder.expirationText.setVisibility(8);
            return;
        }
    }

    private void showInProgressInfo(ViewHolder viewholder, final PlayerDownloadFile playerDownloadFile)
    {
        viewholder.inProgressLayout.setVisibility(0);
        viewholder.downloadedLayout.setVisibility(8);
        viewholder.watchingButton.setVisibility(8);
        viewholder.button.setVisibility(8);
        viewholder.inProgressLayout.setProgress(playerDownloadFile, downloadManager, internetConnection);
        viewholder.inProgressLayout.setOnCancelListener(new android.view.View.OnClickListener() {

            final HistoryAdapter this$0;
            final PlayerDownloadFile val$playerDownloadFile;

            public void onClick(View view)
            {
                downloadsItemListener.onCancelDownloadPressed(context, playerDownloadFile);
            }

            
            {
                this$0 = HistoryAdapter.this;
                playerDownloadFile = playerdownloadfile;
                super();
            }
        });
        viewholder.inProgressLayout.setOnHotwireDownloadClickListener(new android.view.View.OnClickListener() {

            final HistoryAdapter this$0;
            final PlayerDownloadFile val$playerDownloadFile;

            public void onClick(View view)
            {
                downloadsItemListener.onHotwireDownloadPressed(context, playerDownloadFile);
            }

            
            {
                this$0 = HistoryAdapter.this;
                playerDownloadFile = playerdownloadfile;
                super();
            }
        });
        viewholder.inProgressLayout.setOnRetryDownloadClickListener(new android.view.View.OnClickListener() {

            final HistoryAdapter this$0;
            final PlayerDownloadFile val$playerDownloadFile;

            public void onClick(View view)
            {
                downloadsItemListener.onRetryDownloadPressed(context, playerDownloadFile);
            }

            
            {
                this$0 = HistoryAdapter.this;
                playerDownloadFile = playerdownloadfile;
                super();
            }
        });
        downloadServiceListener.add(viewholder, playerDownloadFile);
    }

    protected void bindItem(ViewHolder viewholder, Bookmark bookmark)
    {
        String s = bookmark.getTitle();
        boolean flag = false;
        int i = 0;
        Object obj;
        if (bookmark instanceof VideoBookmark)
        {
            VideoBookmark videobookmark = (VideoBookmark)bookmark;
            viewholder.button.setOnClickListener(videoPlayButtonOnClickListener);
            obj = videobookmark.getParentMerlinIdIfApplicable();
            boolean flag1 = coverArtImageLoader.loadImageFromMemory(((com.xfinity.playerlib.model.MerlinId) (obj)), viewholder.coverArt, null);
            DibicProgram dibicprogram;
            if (scrollStateTracker.isFlinging())
            {
                viewholder.coverArt.setTag(null);
                if (!flag1)
                {
                    viewholder.coverArt.setImageDrawable(null);
                }
            } else
            {
                viewholder.coverArt.setImageDrawable(null);
                coverArtImageLoader.loadImage(((com.xfinity.playerlib.model.MerlinId) (obj)), viewholder.coverArt, null);
            }
            if (videobookmark.isMovie() || UIPresentationUtil.getSeriesString(Integer.valueOf(videobookmark.getSeasonNumber()), Integer.valueOf(videobookmark.getEpisodeNumber())).isEmpty())
            {
                viewholder.seriesInfo.setVisibility(8);
            } else
            {
                obj = UIPresentationUtil.getSeriesString(Integer.valueOf(videobookmark.getSeasonNumber()), Integer.valueOf(videobookmark.getEpisodeNumber()));
                viewholder.seriesInfo.setText(((CharSequence) (obj)));
                obj = UIPresentationUtil.getSeriesStringSpoken(((String) (obj)), viewholder.title.getContext().getResources().getString(com.xfinity.playerlib.R.string.content_description_season), viewholder.title.getContext().getResources().getString(com.xfinity.playerlib.R.string.content_description_episode));
                viewholder.seriesInfo.setContentDescription(((CharSequence) (obj)));
                viewholder.seriesInfo.setVisibility(0);
            }
            viewholder.buttonCaption.setVisibility(0);
            if (videobookmark.isMovie())
            {
                dibicprogram = dibicResource.getProgramByMerlinId(videobookmark.getMerlinId());
                obj = s;
            } else
            {
                DibicProgram dibicprogram1 = dibicResource.getProgramByMerlinId(videobookmark.getParentMerlinIdIfApplicable());
                flag = true;
                i = ((flag) ? 1 : 0);
                dibicprogram = dibicprogram1;
                obj = s;
                if (!isTabletDevice)
                {
                    i = ((flag) ? 1 : 0);
                    dibicprogram = dibicprogram1;
                    obj = s;
                    if (dibicprogram1 != null)
                    {
                        obj = dibicprogram1.getTitle();
                        i = ((flag) ? 1 : 0);
                        dibicprogram = dibicprogram1;
                    }
                }
            }
            if (dibicprogram == null)
            {
                viewholder.downloadedLayout.setVisibility(8);
                viewholder.inProgressLayout.setVisibility(8);
                viewholder.watchingButton.setVisibility(8);
                viewholder.buttonArt.setVisibility(8);
                viewholder.progressIndicator.setVisibility(8);
                viewholder.buttonCaption.setText(context.getResources().getString(com.xfinity.playerlib.R.string.no_longer_available).toUpperCase(Locale.US));
                viewholder.buttonCaption.setTextColor(context.getResources().getColor(com.xfinity.playerlib.R.color.MediumLightGray));
                viewholder.buttonCaption.setContentDescription(context.getResources().getString(com.xfinity.playerlib.R.string.content_description_play_button_unentitled));
                viewholder.button.setBackgroundResource(0);
            } else
            {
                viewholder.buttonArt.setVisibility(0);
                viewholder.buttonCaption.setTextColor(context.getResources().getColor(com.xfinity.playerlib.R.color.white));
                if (videoEntitlement.isEntitled(dibicprogram))
                {
                    presentEntitledVideo(viewholder, videobookmark);
                } else
                {
                    presentUnentitledVideo(viewholder);
                }
            }
        } else
        {
            obj = (LiveStreamBookmark)bookmark;
            viewholder.button.setOnClickListener(liveStreamPlayButtonOnClickListener);
            i = context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.cover_art_src_width);
            int j = context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.cover_art_src_height);
            String s1 = HalLiveStream.getArtworkUrl(((LiveStreamBookmark) (obj)).getArtworkUrl(), i, j);
            boolean flag2 = coverArtImageLoader.loadImageFromMemory(s1, null, viewholder.coverArt);
            boolean flag3;
            if (scrollStateTracker.isFlinging())
            {
                viewholder.coverArt.setTag(null);
                if (!flag2)
                {
                    viewholder.coverArt.setImageDrawable(null);
                }
            } else
            {
                viewholder.coverArt.setImageDrawable(null);
                coverArtImageLoader.loadImage(s1, viewholder.coverArt);
            }
            flag2 = false;
            obj = liveStreamResource.getLiveStream(((LiveStreamBookmark) (obj)).getStreamId());
            if (obj != null && ((HalLiveStream) (obj)).getPlaybackLink() != null)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (flag3)
            {
                if (((HalLiveStream) (obj)).getProviderCodes() != null && videoEntitlement.isEntitledToList((String[])((HalLiveStream) (obj)).getProviderCodes().toArray(new String[((HalLiveStream) (obj)).getProviderCodes().size()])))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
            }
            presentLiveStream(viewholder, flag3, flag2);
            i = ((flag) ? 1 : 0);
            obj = s;
            if (viewholder.progressIndicator != null)
            {
                viewholder.progressIndicator.setVisibility(8);
                i = ((flag) ? 1 : 0);
                obj = s;
            }
        }
        if (viewholder.progressIndicator != null && viewholder.progressIndicator.getVisibility() == 0)
        {
            viewholder.progressIndicator.setText(UIPresentationUtil.getRemainingTime(context, bookmark.getDuration(), bookmark.getPosition()));
            if (bookmark.isFinished())
            {
                viewholder.progressIndicator.setContentDescription(context.getResources().getString(com.xfinity.playerlib.R.string.finished));
            } else
            {
                viewholder.progressIndicator.setContentDescription((new StringBuilder()).append(UIPresentationUtil.getTimeForPlayer(context, (bookmark.getDuration() - bookmark.getPosition()) / 1000)).append(context.getString(com.xfinity.playerlib.R.string.content_description_remaining)).toString());
            }
        }
        viewholder.button.setTag(bookmark);
        if (!isTabletDevice && i != 0)
        {
            viewholder.title.setContentDescription((new StringBuilder()).append(((String) (obj))).append(": ").append(bookmark.getTitle()).toString());
        } else
        {
            viewholder.title.setContentDescription(((CharSequence) (obj)));
        }
        viewholder.title.setText(((CharSequence) (obj)));
    }

    protected volatile void bindItem(Object obj, Object obj1)
    {
        bindItem((ViewHolder)obj, (Bookmark)obj1);
    }

    protected ViewHolder createViewHolder()
    {
        return new ViewHolder();
    }

    protected volatile Object createViewHolder()
    {
        return createViewHolder();
    }

    public int getCount()
    {
        return bookmarks.size();
    }

    public List getData()
    {
        return bookmarks;
    }

    public Bookmark getItem(int i)
    {
        return (Bookmark)bookmarks.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    protected int getViewLayoutId()
    {
        return itemViewLayoutId;
    }

    protected void initializeViewHolder(View view, ViewGroup viewgroup, ViewHolder viewholder)
    {
        viewholder.itemContainerLayout = (CheckableLinearLayout)view.getRootView();
        viewholder.title = (TextView)view.findViewById(com.xfinity.playerlib.R.id.title);
        viewholder.coverArt = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.cover_art);
        viewholder.seriesInfo = (TextView)view.findViewById(com.xfinity.playerlib.R.id.series_info);
        viewholder.progressIndicator = (TextView)view.findViewById(com.xfinity.playerlib.R.id.progressIndicator);
        viewholder.expirationText = (TextView)view.findViewById(com.xfinity.playerlib.R.id.expiration_text);
        viewholder.button = (LinearLayout)view.findViewById(com.xfinity.playerlib.R.id.play_button);
        viewholder.buttonCaption = (TextView)view.findViewById(com.xfinity.playerlib.R.id.button_caption);
        viewholder.buttonArt = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.button_art);
        viewholder.watchingButton = (LinearLayout)view.findViewById(com.xfinity.playerlib.R.id.on_now_button);
        viewholder.inProgressLayout = (DownloadProgressBar)view.findViewById(com.xfinity.playerlib.R.id.in_progress_layout);
        viewholder.downloadedLayout = view.findViewById(com.xfinity.playerlib.R.id.downloaded_layout);
    }

    protected volatile void initializeViewHolder(View view, ViewGroup viewgroup, Object obj)
    {
        initializeViewHolder(view, viewgroup, (ViewHolder)obj);
    }

    public void onDownloadEngineStatusChanged(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
    {
        downloadServiceListener.onDownloadEngineStatusChanged(ivirtuosodownloadenginestatus);
    }

    public void onDownloadServiceConnected()
    {
        LOG.debug("Connected to the download Service!!!");
    }

    public volatile void onFileDownloadError(DownloadFile downloadfile)
    {
        onFileDownloadError((PlayerDownloadFile)downloadfile);
    }

    public void onFileDownloadError(PlayerDownloadFile playerdownloadfile)
    {
    }

    public volatile void onFileDownloadFinished(DownloadFile downloadfile)
    {
        onFileDownloadFinished((PlayerDownloadFile)downloadfile);
    }

    public void onFileDownloadFinished(PlayerDownloadFile playerdownloadfile)
    {
    }

    public volatile void onFileDownloadStarted(DownloadFile downloadfile)
    {
        onFileDownloadStarted((PlayerDownloadFile)downloadfile);
    }

    public void onFileDownloadStarted(PlayerDownloadFile playerdownloadfile)
    {
    }

    public void onFileListUpdated()
    {
    }

    public volatile void onFileProgressUpdated(DownloadFile downloadfile)
    {
        onFileProgressUpdated((PlayerDownloadFile)downloadfile);
    }

    public void onFileProgressUpdated(PlayerDownloadFile playerdownloadfile)
    {
        downloadServiceListener.onFileProgressUpdated(playerdownloadfile);
    }

    public void removeItems(List list)
    {
        bookmarks.removeAll(list);
        notifyDataSetChanged();
    }

    public void setData(List list)
    {
        bookmarks = list;
        notifyDataSetChanged();
    }

    public void setDibicResource(DibicResource dibicresource)
    {
        dibicResource = dibicresource;
    }

    public void setLiveStreamResource(HalLiveStreamResource hallivestreamresource)
    {
        liveStreamResource = hallivestreamresource;
    }

    public void setVideoEntitlement(VideoEntitlement videoentitlement)
    {
        videoEntitlement = videoentitlement;
    }




}
