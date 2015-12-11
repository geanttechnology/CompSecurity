// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.downloads.DownloadFile;
import com.comcast.cim.downloads.DownloadServiceListener;
import com.comcast.cim.downloads.SimpleDownloadServiceListener;
import com.comcast.cim.utils.UIPresentationUtil;
import com.google.common.collect.Sets;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.consumable.SeriesWatchableInfo;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.view.ScrollStateTracker;
import com.xfinity.playerlib.view.widget.DownloadProgressBar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.downloads:
//            DownloadsItemListener

public class DownloadsArrayAdapter extends ArrayAdapter
    implements DownloadServiceListener
{
    private class DownloadableItemHolder
    {

        protected ImageView coverArt;
        protected LinearLayout downloadedLayout;
        protected TextView episodeNumText;
        protected TextView expirationText;
        protected DownloadProgressBar inProgressLayout;
        protected ImageView networkLogo;
        protected TextView networkText;
        protected LinearLayout playButton;
        public ImageView playButtonArt;
        public TextView playButtonCaption;
        protected PlayerDownloadFile playerDownloadFile;
        protected TextView progressIndicator;
        final DownloadsArrayAdapter this$0;
        protected TextView titleText;

        private DownloadableItemHolder()
        {
            this$0 = DownloadsArrayAdapter.this;
            super();
        }

    }

    class PlayButtonOnClickListener
        implements android.view.View.OnClickListener
    {

        final PlayerDownloadFile playerDownloadFile;
        final DownloadsArrayAdapter this$0;
        final VideoFacade videoFacade;

        public void onClick(View view)
        {
            view = view.getContext();
            if (videoEntitlement.isEntitled(videoFacade.getProviderCode()))
            {
                listener.onPlayEntitledDownloadPressed(view, playerDownloadFile);
            } else
            if (view instanceof FragmentActivity)
            {
                view = ((FragmentActivity)view).getFragmentManager();
                listener.onPlayUnentitledDownloadPressed(view, videoFacade);
                return;
            }
        }

        public PlayButtonOnClickListener(VideoFacade videofacade, PlayerDownloadFile playerdownloadfile)
        {
            this$0 = DownloadsArrayAdapter.this;
            super();
            videoFacade = videofacade;
            playerDownloadFile = playerdownloadfile;
        }
    }


    protected final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/downloads/DownloadsArrayAdapter);
    private final Activity activity;
    protected final CoverArtImageLoader coverArtImageLoader;
    protected final PlayerDownloadServiceManager downloadManager;
    private Set downloadServiceListeners;
    private Handler handler;
    private LayoutInflater inflater;
    protected final InternetConnection internetConnection;
    private boolean isEditMode;
    protected final DownloadsItemListener listener;
    protected final NetworkLogoImageLoader logoImageLoader;
    private final ScrollStateTracker scrollStateTracker;
    private final FastDateFormat sdf;
    private Map videoBookmarks;
    private VideoEntitlement videoEntitlement;

    public DownloadsArrayAdapter(Activity activity1, List list, LayoutInflater layoutinflater, CoverArtImageLoader coverartimageloader, DownloadsItemListener downloadsitemlistener, PlayerDownloadServiceManager playerdownloadservicemanager, NetworkLogoImageLoader networklogoimageloader, 
            InternetConnection internetconnection, ScrollStateTracker scrollstatetracker, FastDateFormat fastdateformat)
    {
        super(activity1, 0, list);
        handler = new Handler();
        isEditMode = false;
        downloadServiceListeners = Sets.newHashSet();
        activity = activity1;
        inflater = layoutinflater;
        coverArtImageLoader = coverartimageloader;
        listener = downloadsitemlistener;
        downloadManager = playerdownloadservicemanager;
        logoImageLoader = networklogoimageloader;
        internetConnection = internetconnection;
        scrollStateTracker = scrollstatetracker;
        sdf = fastdateformat;
    }

    private void showDownloadedInfo(DownloadableItemHolder downloadableitemholder, PlayerDownloadFile playerdownloadfile, VideoBookmark videobookmark)
    {
        downloadableitemholder.downloadedLayout.setVisibility(0);
        downloadableitemholder.inProgressLayout.setVisibility(8);
        downloadableitemholder.playButton.setVisibility(0);
        if (videoEntitlement.isEntitled(playerdownloadfile.getVideo().getProviderCode()))
        {
            if (videobookmark != null)
            {
                TextView textview = downloadableitemholder.playButtonCaption;
                Resources resources = getContext().getResources();
                int i;
                if (videobookmark.getPosition() > 0 && !videobookmark.isFinished())
                {
                    i = com.xfinity.playerlib.R.string.resume;
                } else
                {
                    i = com.xfinity.playerlib.R.string.play;
                }
                textview.setText(resources.getString(i).toUpperCase(Locale.US));
            }
            if (playerdownloadfile.getExpirationStatus() == com.xfinity.playerlib.model.downloads.PlayerDownloadFile.ExpirationStatus.AAW_EXPIRED)
            {
                downloadableitemholder.expirationText.setVisibility(0);
                downloadableitemholder.expirationText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                downloadableitemholder.expirationText.setTextColor(activity.getResources().getColor(com.xfinity.playerlib.R.color.MediumLightGray));
                downloadableitemholder.expirationText.setText(activity.getResources().getString(com.xfinity.playerlib.R.string.unavailable));
                downloadableitemholder.playButton.setVisibility(8);
            } else
            if (playerdownloadfile.getAssetExpirationDate() != null && UIPresentationUtil.getDaysLeft(playerdownloadfile.getAssetExpirationDate()) < 14)
            {
                downloadableitemholder.expirationText.setVisibility(0);
                downloadableitemholder.expirationText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                downloadableitemholder.expirationText.setTextColor(activity.getResources().getColor(com.xfinity.playerlib.R.color.MediumLightGray));
                downloadableitemholder.expirationText.setText(activity.getResources().getString(com.xfinity.playerlib.R.string.available_until, new Object[] {
                    sdf.format(playerdownloadfile.getAssetExpirationDate())
                }));
                downloadableitemholder.expirationText.setVisibility(0);
            } else
            {
                downloadableitemholder.expirationText.setVisibility(8);
            }
            downloadableitemholder.playButtonArt.setImageResource(com.xfinity.playerlib.R.drawable.play_button_entitled_graphic);
            downloadableitemholder.playButton.setBackgroundResource(com.xfinity.playerlib.R.drawable.play_button_entitled_background);
            return;
        } else
        {
            downloadableitemholder.playButtonArt.setImageResource(com.xfinity.playerlib.R.drawable.icn_upsell_btn);
            downloadableitemholder.playButtonCaption.setTextColor(activity.getResources().getColor(com.xfinity.playerlib.R.color.white));
            downloadableitemholder.playButtonCaption.setContentDescription(activity.getResources().getString(com.xfinity.playerlib.R.string.content_description_play_button_unentitled));
            downloadableitemholder.playButton.setBackgroundResource(com.xfinity.playerlib.R.drawable.play_button_unentitled);
            downloadableitemholder.expirationText.setVisibility(8);
            return;
        }
    }

    private void showInProgressInfo(DownloadableItemHolder downloadableitemholder, PlayerDownloadFile playerdownloadfile)
    {
        downloadableitemholder.inProgressLayout.setVisibility(0);
        downloadableitemholder.downloadedLayout.setVisibility(8);
        downloadableitemholder.playButton.setVisibility(8);
        downloadableitemholder.inProgressLayout.setProgress(playerdownloadfile, downloadManager, internetConnection);
    }

    private void updateWithEditMode(VideoFacade videofacade, DownloadableItemHolder downloadableitemholder)
    {
        if (isEditMode)
        {
            downloadableitemholder.inProgressLayout.setButtonsEnable(false);
            downloadableitemholder.playButton.setClickable(false);
            downloadableitemholder.playButton.setOnClickListener(null);
            downloadableitemholder.playButton.setEnabled(false);
            return;
        }
        downloadableitemholder.inProgressLayout.setButtonsEnable(true);
        if (downloadableitemholder.playerDownloadFile.getExpirationStatus() == com.xfinity.playerlib.model.downloads.PlayerDownloadFile.ExpirationStatus.OVP_EXPIRED)
        {
            downloadableitemholder.playButton.setEnabled(false);
            downloadableitemholder.playButton.setOnClickListener(null);
            return;
        } else
        {
            downloadableitemholder.playButton.setEnabled(true);
            downloadableitemholder.playButton.setOnClickListener(new PlayButtonOnClickListener(videofacade, downloadableitemholder.playerDownloadFile));
            return;
        }
    }

    public View getView(int i, View view, final ViewGroup holder)
    {
        PlayerDownloadFile playerdownloadfile = (PlayerDownloadFile)getItem(i);
        Object obj = playerdownloadfile.getWatchable();
        VideoFacade videofacade = ((Watchable) (obj)).findVideoById(playerdownloadfile.getVideoId());
        SeriesWatchableInfo serieswatchableinfo;
        if (view == null)
        {
            view = inflater.inflate(com.xfinity.playerlib.R.layout.downloads_list_item, null);
            holder = new DownloadableItemHolder();
            holder.coverArt = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.cover_art);
            holder.titleText = (TextView)view.findViewById(com.xfinity.playerlib.R.id.title_text);
            holder.episodeNumText = (TextView)view.findViewById(com.xfinity.playerlib.R.id.season_episode_text);
            holder.networkLogo = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.network_logo);
            holder.networkText = (TextView)view.findViewById(com.xfinity.playerlib.R.id.network_name);
            holder.progressIndicator = (TextView)view.findViewById(com.xfinity.playerlib.R.id.progress_indicator);
            holder.inProgressLayout = (DownloadProgressBar)view.findViewById(com.xfinity.playerlib.R.id.in_progress_layout);
            holder.downloadedLayout = (LinearLayout)view.findViewById(com.xfinity.playerlib.R.id.downloaded_layout);
            holder.expirationText = (TextView)view.findViewById(com.xfinity.playerlib.R.id.expiration_text);
            holder.playButton = (LinearLayout)view.findViewById(com.xfinity.playerlib.R.id.play_button);
            holder.playButtonCaption = (TextView)view.findViewById(com.xfinity.playerlib.R.id.button_caption);
            holder.playButtonArt = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.button_art);
            ((DownloadableItemHolder) (holder)).inProgressLayout.setOnCancelListener(new android.view.View.OnClickListener() {

                final DownloadsArrayAdapter this$0;
                final DownloadableItemHolder val$holder;

                public void onClick(View view1)
                {
                    listener.onCancelDownloadPressed(view1.getContext(), holder.playerDownloadFile);
                }

            
            {
                this$0 = DownloadsArrayAdapter.this;
                holder = downloadableitemholder;
                super();
            }
            });
            ((DownloadableItemHolder) (holder)).inProgressLayout.setOnHotwireDownloadClickListener(new android.view.View.OnClickListener() {

                final DownloadsArrayAdapter this$0;
                final DownloadableItemHolder val$holder;

                public void onClick(View view1)
                {
                    listener.onHotwireDownloadPressed(view1.getContext(), holder.playerDownloadFile);
                }

            
            {
                this$0 = DownloadsArrayAdapter.this;
                holder = downloadableitemholder;
                super();
            }
            });
            ((DownloadableItemHolder) (holder)).inProgressLayout.setOnRetryDownloadClickListener(new android.view.View.OnClickListener() {

                final DownloadsArrayAdapter this$0;
                final DownloadableItemHolder val$holder;

                public void onClick(View view1)
                {
                    listener.onRetryDownloadPressed(view1.getContext(), holder.playerDownloadFile);
                }

            
            {
                this$0 = DownloadsArrayAdapter.this;
                holder = downloadableitemholder;
                super();
            }
            });
            ((DownloadableItemHolder) (holder)).playButton.setOnClickListener(new PlayButtonOnClickListener(videofacade, ((DownloadableItemHolder) (holder)).playerDownloadFile));
            SimpleDownloadServiceListener simpledownloadservicelistener = new SimpleDownloadServiceListener() {

                final DownloadsArrayAdapter this$0;
                final DownloadableItemHolder val$holder;

                public void onDownloadEngineStatusChanged(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
                {
                    holder.inProgressLayout.setProgress(holder.playerDownloadFile, downloadManager, internetConnection);
                }

                public volatile void onFileProgressUpdated(DownloadFile downloadfile)
                {
                    onFileProgressUpdated((PlayerDownloadFile)downloadfile);
                }

                public void onFileProgressUpdated(PlayerDownloadFile playerdownloadfile1)
                {
                    if (holder.playerDownloadFile.equals(playerdownloadfile1))
                    {
                        holder.inProgressLayout.setProgress(playerdownloadfile1, downloadManager, internetConnection);
                    }
                }

            
            {
                this$0 = DownloadsArrayAdapter.this;
                holder = downloadableitemholder;
                super();
            }
            };
            downloadServiceListeners.add(simpledownloadservicelistener);
            view.setTag(holder);
        } else
        {
            holder = (DownloadableItemHolder)view.getTag();
        }
        holder.playerDownloadFile = playerdownloadfile;
        new com.comcast.cim.android.image.CimImageLoader.OnLoadListener() {

            final DownloadsArrayAdapter this$0;

            public void onLoad(ImageView imageview, String s, Bitmap bitmap)
            {
            }

            public void onLoadError(ImageView imageview, String s)
            {
            }

            
            {
                this$0 = DownloadsArrayAdapter.this;
                super();
            }
        };
        serieswatchableinfo = ((Watchable) (obj)).getSeriesInfoIfApplicable();
        if (((DownloadableItemHolder) (holder)).coverArt != null)
        {
            com.xfinity.playerlib.model.MerlinId merlinid = ((Watchable) (obj)).getParentMerlinIdIfApplicable();
            boolean flag = coverArtImageLoader.loadImageFromMemory(merlinid, ((DownloadableItemHolder) (holder)).coverArt, null);
            if (scrollStateTracker.isFlinging())
            {
                ((DownloadableItemHolder) (holder)).coverArt.setTag(null);
                if (!flag)
                {
                    ((DownloadableItemHolder) (holder)).coverArt.setImageDrawable(null);
                }
            } else
            {
                ((DownloadableItemHolder) (holder)).coverArt.setImageDrawable(null);
                coverArtImageLoader.loadImage(merlinid, ((DownloadableItemHolder) (holder)).coverArt, null);
            }
            if (serieswatchableinfo != null)
            {
                ((DownloadableItemHolder) (holder)).titleText.setText(UIPresentationUtil.addQuotesToString(((Watchable) (obj)).getDisplayTitle()));
            } else
            {
                ((DownloadableItemHolder) (holder)).titleText.setText(((Watchable) (obj)).getDisplayTitle());
            }
        } else
        if (serieswatchableinfo != null)
        {
            ((DownloadableItemHolder) (holder)).titleText.setText(serieswatchableinfo.getSeriesTitle());
        } else
        {
            ((DownloadableItemHolder) (holder)).titleText.setText(((Watchable) (obj)).getDisplayTitle());
        }
        if (serieswatchableinfo != null)
        {
            obj = UIPresentationUtil.getSeriesString(serieswatchableinfo.getSeasonNumber(), serieswatchableinfo.getEpisodeNumber());
            if (!((String) (obj)).isEmpty())
            {
                ((DownloadableItemHolder) (holder)).episodeNumText.setVisibility(0);
                ((DownloadableItemHolder) (holder)).episodeNumText.setText(((CharSequence) (obj)));
                ((DownloadableItemHolder) (holder)).episodeNumText.setContentDescription(UIPresentationUtil.getSeriesStringSpoken(((String) (obj)), getContext().getString(com.xfinity.playerlib.R.string.content_description_season), getContext().getString(com.xfinity.playerlib.R.string.content_description_episode)));
            } else
            {
                ((DownloadableItemHolder) (holder)).episodeNumText.setVisibility(8);
            }
        } else
        {
            ((DownloadableItemHolder) (holder)).episodeNumText.setVisibility(8);
        }
        if (videofacade.getNetworkInfo().isPremium())
        {
            logoImageLoader.loadNetworkLogoSmall(videofacade.getNetworkInfo().getCompanyId(), ((DownloadableItemHolder) (holder)).networkLogo);
            ((DownloadableItemHolder) (holder)).networkLogo.setVisibility(0);
            ((DownloadableItemHolder) (holder)).networkText.setVisibility(8);
        } else
        {
            ((DownloadableItemHolder) (holder)).networkText.setText(videofacade.getNetworkInfo().getName());
            ((DownloadableItemHolder) (holder)).networkLogo.setVisibility(8);
            ((DownloadableItemHolder) (holder)).networkText.setVisibility(0);
        }
        obj = getContext().getString(com.xfinity.playerlib.R.string.content_description_on_network, new Object[] {
            "", videofacade.getNetworkInfo().getName()
        });
        ((DownloadableItemHolder) (holder)).networkLogo.setContentDescription(((CharSequence) (obj)));
        ((DownloadableItemHolder) (holder)).networkText.setContentDescription(((CharSequence) (obj)));
        obj = (VideoBookmark)videoBookmarks.get(videofacade);
        if (obj != null && ((VideoBookmark) (obj)).getPosition() > 0)
        {
            if (((VideoBookmark) (obj)).getCategories().contains(com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory.CATEGORY_RECENT))
            {
                ((DownloadableItemHolder) (holder)).progressIndicator.setText(UIPresentationUtil.getRemainingTime(getContext(), ((VideoBookmark) (obj)).getDuration(), ((VideoBookmark) (obj)).getPosition()));
                ((DownloadableItemHolder) (holder)).progressIndicator.setVisibility(0);
            }
        } else
        {
            ((DownloadableItemHolder) (holder)).progressIndicator.setVisibility(8);
        }
        if (playerdownloadfile.isDownloadComplete())
        {
            showDownloadedInfo(holder, playerdownloadfile, ((VideoBookmark) (obj)));
        } else
        {
            showInProgressInfo(holder, playerdownloadfile);
        }
        updateWithEditMode(videofacade, holder);
        return view;
    }

    public void onDownloadEngineStatusChanged(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
    {
        for (Iterator iterator = downloadServiceListeners.iterator(); iterator.hasNext(); ((DownloadServiceListener)iterator.next()).onDownloadEngineStatusChanged(ivirtuosodownloadenginestatus)) { }
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
        for (Iterator iterator = downloadServiceListeners.iterator(); iterator.hasNext(); ((DownloadServiceListener)iterator.next()).onFileProgressUpdated(playerdownloadfile)) { }
    }

    public void setEditMode(boolean flag)
    {
        isEditMode = flag;
        notifyDataSetChanged();
    }

    public void setVideoBookmarks(Map map)
    {
        videoBookmarks = map;
    }

    public void setVideoEntitlement(VideoEntitlement videoentitlement)
    {
        videoEntitlement = videoentitlement;
    }

}
