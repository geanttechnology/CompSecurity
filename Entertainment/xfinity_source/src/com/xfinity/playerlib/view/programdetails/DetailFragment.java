// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.AlternateInterfaceUtil;
import com.comcast.cim.android.accessibility.DefaultSpeechListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.common.ConnectivityRequiredOnClickListener;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.android.util.view.widget.LoadingIndicator;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.cmasl.utils.i18n.Iso629Util;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.downloads.DownloadFile;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.cim.downloads.DownloadServiceListener;
import com.comcast.cim.model.Rating;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.comcast.cim.utils.UIPresentationUtil;
import com.comcast.cim.utils.UIUtil;
import com.google.common.collect.Sets;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.image.ProgramDetailArtImageLoader;
import com.xfinity.playerlib.model.consumable.VideoComparator;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.consumable.hal.HalReview;
import com.xfinity.playerlib.model.consumable.hal.HalVideoProfile;
import com.xfinity.playerlib.model.database.CachingVideoBookmarkDAO;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.view.AnimatedFragment;
import com.xfinity.playerlib.view.BaseInstanceState;
import com.xfinity.playerlib.view.common.UpsellDialog;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            FetchCanceledListener, BabyGuideMovieActivity, BabyGuideEpisodeDetailActivity, BabyGuideSeriesEntityActivity, 
//            PreDownloadFlowFragment

public abstract class DetailFragment extends AuthenticatingFragment
    implements DownloadServiceListener, AnimatedFragment, FetchCanceledListener
{
    protected class DetailFragmentSpeechListener extends DefaultSpeechListener
    {

        final DetailFragment this$0;

        public boolean onSpeechResponsePlay(String as[])
        {
            if (as.length == 0)
            {
                as = getFirstPlayButton();
                if (as != null)
                {
                    as.callOnClick();
                }
                return true;
            } else
            {
                return false;
            }
        }

        protected DetailFragmentSpeechListener()
        {
            this$0 = DetailFragment.this;
            super();
        }
    }

    private class FlowEventListener
        implements PreDownloadFlowFragment.PreDownloadFlowEventListener
    {

        final DetailFragment this$0;

        public void onPreDownloadFlowCompleted(VideoFacade videofacade)
        {
            Object obj = getVideoItemViewContainer();
            if (obj != null)
            {
                obj = ((View) (obj)).findViewWithTag(Long.valueOf(videofacade.getVideoId()));
                toggleProgressState(true, ((View) (obj)));
                showCustomDownloadWaitingState(downloadManager.findFileWithVideoId(videofacade.getVideoId()), ((View) (obj)));
            }
        }

        private FlowEventListener()
        {
            this$0 = DetailFragment.this;
            super();
        }

    }

    public static class InstanceState extends BaseInstanceState
    {

        protected static final String EXTRA_BUNDLE_PARAMS = com/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState.getCanonicalName();

        public static InstanceState fromBundle(Bundle bundle)
        {
            return (InstanceState)bundle.getSerializable(EXTRA_BUNDLE_PARAMS);
        }

        public Bundle addToBundle(Bundle bundle)
        {
            bundle.putSerializable(EXTRA_BUNDLE_PARAMS, this);
            return bundle;
        }


        public InstanceState()
        {
        }
    }

    public static interface PlayPressedListener
    {

        public abstract void onPlayOrResumePressed(VideoFacade videofacade, Watchable watchable);
    }

    protected class VideoItemAdapter
    {

        final DetailFragment this$0;

        private void setupDownloadButton(VideoFacade videofacade, final Watchable watchable, boolean flag, PlayerDownloadFile playerdownloadfile, ViewGroup viewgroup, boolean flag1)
        {
            if (videofacade.isDownloadable() && flag1)
            {
                viewgroup.findViewById(com.xfinity.playerlib.R.id.d2g_section).setVisibility(0);
                LinearLayout linearlayout = showDownloadAvailableState(videofacade, viewgroup);
                TextView textview = (TextView)linearlayout.findViewById(com.xfinity.playerlib.R.id.button_caption);
                if (flag)
                {
                    linearlayout.setOnClickListener(videofacade. new android.view.View.OnClickListener() {

                        final VideoItemAdapter this$1;
                        final VideoFacade val$video;
                        final Watchable val$watchable;

                        public void onClick(View view)
                        {
                            view = getActivity().getFragmentManager();
                            FragmentTransaction fragmenttransaction = view.beginTransaction();
                            if (view.findFragmentByTag(PreDownloadFlowFragment.FRAGMENT_TAG) == null)
                            {
                                fragmenttransaction.add(new PreDownloadFlowFragment(watchable, video, new FlowEventListener()), PreDownloadFlowFragment.FRAGMENT_TAG);
                            }
                            fragmenttransaction.commit();
                        }

            
            {
                this$1 = final_videoitemadapter;
                watchable = watchable1;
                video = VideoFacade.this;
                super();
            }
                    });
                    setupCancelDownloadButton(videofacade, viewgroup);
                    if (playerdownloadfile != null)
                    {
                        toggleProgressState(true, viewgroup);
                        showDownloadState(playerdownloadfile, viewgroup, getEngineStatus());
                    }
                    textview.setContentDescription(getResources().getString(com.xfinity.playerlib.R.string.content_description_download_button));
                    return;
                }
                if (!inBabyGuide())
                {
                    setupUpsellButton(linearlayout, textview, videofacade. new android.view.View.OnClickListener() {

                        final VideoItemAdapter this$1;
                        final VideoFacade val$video;

                        public void onClick(View view)
                        {
                            view = getActivity().getFragmentManager();
                            UpsellDialog.newInstance(com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.DOWNLOAD, video).show(view, "upsell_dialog");
                        }

            
            {
                this$1 = final_videoitemadapter;
                video = VideoFacade.this;
                super();
            }
                    });
                    return;
                }
            }
        }

        private void setupPlayButton(VideoFacade videofacade, VideoBookmark videobookmark, Watchable watchable, boolean flag, PlayPressedListener playpressedlistener, ViewGroup viewgroup)
        {
            viewgroup = (LinearLayout)viewgroup.findViewById(com.xfinity.playerlib.R.id.playback_button);
            if (videofacade.getNetworkInfo().getCompanyId() != 0L)
            {
                viewgroup.setVisibility(0);
                TextView textview = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.button_caption);
                if (flag)
                {
                    if (videobookmark.getPosition() > 0 && !videobookmark.isFinished())
                    {
                        textview.setText(getActivity().getResources().getString(com.xfinity.playerlib.R.string.resume).toUpperCase(Locale.US));
                        textview.setContentDescription(getResources().getString(com.xfinity.playerlib.R.string.content_description_resume_button));
                    } else
                    {
                        textview.setContentDescription(getResources().getString(com.xfinity.playerlib.R.string.content_description_play_button));
                    }
                    viewgroup.setOnClickListener(buildPlayLaunchClickListener(videofacade, watchable, playpressedlistener));
                    return;
                } else
                {
                    setupUpsellButton(viewgroup, textview, videofacade. new android.view.View.OnClickListener() {

                        final VideoItemAdapter this$1;
                        final VideoFacade val$video;

                        public void onClick(View view)
                        {
                            view = getActivity().getFragmentManager();
                            UpsellDialog.newInstance(com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK, video).show(view, "upsell_dialog");
                        }

            
            {
                this$1 = final_videoitemadapter;
                video = VideoFacade.this;
                super();
            }
                    });
                    return;
                }
            } else
            {
                viewgroup.setVisibility(8);
                return;
            }
        }

        private void setupUpsellButton(LinearLayout linearlayout, TextView textview, android.view.View.OnClickListener onclicklistener)
        {
            linearlayout.setVisibility(0);
            ((ImageView)linearlayout.findViewById(com.xfinity.playerlib.R.id.button_art)).setImageResource(com.xfinity.playerlib.R.drawable.icn_upsell_btn);
            textview.setTextColor(getActivity().getResources().getColor(com.xfinity.playerlib.R.color.white));
            Resources resources = getResources();
            int i;
            if (linearlayout.getId() == com.xfinity.playerlib.R.id.play_button)
            {
                i = com.xfinity.playerlib.R.string.content_description_play_button_unentitled;
            } else
            {
                i = com.xfinity.playerlib.R.string.content_description_download_button_unentitled;
            }
            textview.setContentDescription(resources.getString(i));
            linearlayout.setBackgroundResource(com.xfinity.playerlib.R.drawable.play_button_unentitled);
            linearlayout.setOnClickListener(onclicklistener);
        }

        public View createUnavailableView(LayoutInflater layoutinflater, ViewGroup viewgroup)
        {
            return layoutinflater.inflate(com.xfinity.playerlib.R.layout.video_item_unavailable, viewgroup, false);
        }

        public View createView(VideoFacade videofacade, VideoBookmark videobookmark, Watchable watchable, PlayerDownloadFile playerdownloadfile, boolean flag, LayoutInflater layoutinflater, ViewGroup viewgroup, 
                PlayPressedListener playpressedlistener, boolean flag1, boolean flag2, int i, int j)
        {
            ViewGroup viewgroup1 = (ViewGroup)layoutinflater.inflate(com.xfinity.playerlib.R.layout.video_item, viewgroup, false);
            viewgroup1.setTag(Long.valueOf(videofacade.getVideoId()));
            viewgroup = (ImageView)viewgroup1.findViewById(com.xfinity.playerlib.R.id.network_logo);
            Object obj = (TextView)viewgroup1.findViewById(com.xfinity.playerlib.R.id.network_name);
            TextView textview;
            if (!shouldSuppressNetworkLogos)
            {
                Object obj1;
                String s;
                Iterator iterator;
                if (videofacade.getNetworkInfo().isPremium())
                {
                    logoImageLoader.loadNetworkLogoSmall(videofacade.getNetworkInfo().getCompanyId(), viewgroup);
                    viewgroup.setVisibility(0);
                    ((TextView) (obj)).setVisibility(8);
                } else
                {
                    viewgroup.setVisibility(8);
                    layoutinflater = videofacade.getNetworkInfo().getName();
                    if (layoutinflater != null && layoutinflater.length() > 0)
                    {
                        ((TextView) (obj)).setText(layoutinflater);
                        ((TextView) (obj)).setVisibility(0);
                    } else
                    {
                        ((TextView) (obj)).setVisibility(8);
                    }
                }
                layoutinflater = "";
                if (j > 1)
                {
                    layoutinflater = getString(com.xfinity.playerlib.R.string.content_description_video_number_of, new Object[] {
                        Integer.valueOf(i), Integer.valueOf(j)
                    });
                }
                layoutinflater = getString(com.xfinity.playerlib.R.string.content_description_on_network, new Object[] {
                    layoutinflater, videofacade.getNetworkInfo().getName()
                });
                ((TextView) (obj)).setContentDescription(layoutinflater);
                viewgroup.setContentDescription(layoutinflater);
            } else
            {
                viewgroup.setVisibility(8);
                ((TextView) (obj)).setVisibility(8);
            }
            layoutinflater = videofacade.getVideoRating();
            viewgroup = null;
            if (layoutinflater != null)
            {
                layoutinflater = layoutinflater.getRating().replaceAll(".(?=.)", "$0 ");
                viewgroup = getString(com.xfinity.playerlib.R.string.content_description_rated, new Object[] {
                    layoutinflater
                });
            }
            textview = (TextView)viewgroup1.findViewById(com.xfinity.playerlib.R.id.indicators);
            obj1 = videofacade.getLanguageCodes();
            obj = null;
            layoutinflater = ((LayoutInflater) (obj));
            if (obj1 != null)
            {
                layoutinflater = ((LayoutInflater) (obj));
                if (!Sets.difference(Sets.newHashSet(((Iterable) (obj1))), Sets.newHashSet(new String[] {
        "en"
    })).isEmpty())
                {
                    layoutinflater = "";
                    for (iterator = ((List) (obj1)).iterator(); iterator.hasNext();)
                    {
                        obj1 = (String)iterator.next();
                        s = Iso629Util.getDisplayNameForLanguageCode(((String) (obj1)));
                        obj = s;
                        if (s == null)
                        {
                            obj = obj1;
                        }
                        obj1 = layoutinflater;
                        if (!layoutinflater.isEmpty())
                        {
                            obj1 = (new StringBuilder()).append(layoutinflater).append(", ").toString();
                        }
                        layoutinflater = (new StringBuilder()).append(((String) (obj1))).append(((String) (obj))).toString();
                    }

                    layoutinflater = getString(com.xfinity.playerlib.R.string.content_description_languages, new Object[] {
                        layoutinflater
                    });
                }
            }
            obj = getUnicodeIndicatorString(videofacade);
            if (((String) (obj)).length() > 0)
            {
                textview.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/XFINITYIndicators-Regular.otf"));
                textview.setText(((CharSequence) (obj)));
                textview.setVisibility(0);
                StringBuilder stringbuilder;
                if (videofacade.isCC())
                {
                    obj = getString(com.xfinity.playerlib.R.string.content_description_video_options_announcement, new Object[] {
                        getString(com.xfinity.playerlib.R.string.content_description_cc), getString(com.xfinity.playerlib.R.string.content_description_available)
                    });
                } else
                {
                    obj = "";
                }
                stringbuilder = new StringBuilder();
                if (viewgroup != null)
                {
                    viewgroup = (new StringBuilder()).append(viewgroup).append(".").toString();
                } else
                {
                    viewgroup = "";
                }
                viewgroup = stringbuilder.append(viewgroup);
                if (layoutinflater != null)
                {
                    layoutinflater = (new StringBuilder()).append(layoutinflater).append(".").toString();
                } else
                {
                    layoutinflater = "";
                }
                textview.setContentDescription(viewgroup.append(layoutinflater).append(((String) (obj))).toString());
            }
            if (videobookmark.getCategories().contains(com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory.CATEGORY_RECENT) && videobookmark.getPosition() > 0)
            {
                layoutinflater = (TextView)viewgroup1.findViewById(com.xfinity.playerlib.R.id.progressIndicator);
                layoutinflater.setText(UIPresentationUtil.getRemainingTime(getActivity(), videobookmark.getDuration(), videobookmark.getPosition()));
                layoutinflater.setContentDescription((new StringBuilder()).append(UIPresentationUtil.getTimeForPlayer(getActivity(), (videobookmark.getDuration() - videobookmark.getPosition()) / 1000)).append(getString(com.xfinity.playerlib.R.string.content_description_remaining)).toString());
                layoutinflater.setVisibility(0);
            }
            if (flag2)
            {
                viewgroup1.findViewById(com.xfinity.playerlib.R.id.on_now_button).setVisibility(0);
            } else
            {
                setupPlayButton(videofacade, videobookmark, watchable, flag, playpressedlistener, viewgroup1);
            }
            setupDownloadButton(videofacade, watchable, flag, playerdownloadfile, viewgroup1, flag1);
            return viewgroup1;
        }

        String getUnicodeIndicatorString(VideoFacade videofacade)
        {
            String s1 = "";
            Object obj = videofacade.getVideoRating();
            String s = s1;
            if (obj != null)
            {
                obj = ((Rating) (obj)).getRating();
                if (((String) (obj)).equalsIgnoreCase("g"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_g)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("pg"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_pg)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("pg-13"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_pg13)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("r"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_r)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("nr"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_nr)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("tv-y7"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_tvy7)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("tv-y"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_tvy)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("tv-g"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_tvg)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("tv-pg"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_tvpg)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("tv-14"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_tv14)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("tv-ma"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_tvma)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("tv-nr"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_tvnr)).toString();
                } else
                if (((String) (obj)).equalsIgnoreCase("nc-17"))
                {
                    s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_nc17)).toString();
                } else
                {
                    s = s1;
                    if (((String) (obj)).equalsIgnoreCase("adult"))
                    {
                        s = (new StringBuilder()).append("").append(getResources().getString(com.xfinity.playerlib.R.string.unicode_adult)).toString();
                    }
                }
            }
            obj = videofacade.getLanguageCodes();
            if (((List) (obj)).size() == 1 && ((String)((List) (obj)).get(0)).equals("es"))
            {
                s1 = s;
                if (s.length() > 0)
                {
                    s1 = (new StringBuilder()).append(s).append(" ").toString();
                }
                s1 = (new StringBuilder()).append(s1).append(getResources().getString(com.xfinity.playerlib.R.string.unicode_esp)).toString();
            } else
            {
                s1 = s;
                if (((List) (obj)).size() > 1)
                {
                    s1 = s;
                    if (s.length() > 0)
                    {
                        s1 = (new StringBuilder()).append(s).append(" ").toString();
                    }
                    s1 = (new StringBuilder()).append(s1).append(getResources().getString(com.xfinity.playerlib.R.string.unicode_sap)).toString();
                }
            }
            s = s1;
            if (videofacade.isCC())
            {
                videofacade = s1;
                if (s1.length() > 0)
                {
                    videofacade = (new StringBuilder()).append(s1).append(" ").toString();
                }
                s = (new StringBuilder()).append(videofacade).append(getResources().getString(com.xfinity.playerlib.R.string.unicode_cc)).toString();
            }
            return s;
        }

        protected VideoItemAdapter()
        {
            this$0 = DetailFragment.this;
            super();
        }
    }


    protected final AccessibilityUtil accessibilityUtil = PlayerContainer.getInstance().getAccessibilityUtil();
    protected AlternateInterfaceListener alternateInterfaceListener;
    protected AlternateInterfaceUtil alternateInterfaceUtil;
    protected PlayerAndroidDevice androidDevice;
    private boolean animationsEnabled;
    protected View bodyContainer;
    protected CachingVideoBookmarkDAO bookmarkDAO;
    private TextView commonSenseMediaLabel;
    private TextView commonSenseMediaTargetRating;
    protected DibicResource dibicResource;
    protected PlayerDownloadServiceManager downloadManager;
    protected FetchCanceledListener fetchCanceledListener;
    protected boolean filterByNetwork;
    protected boolean inBabyGuide;
    protected InstanceState instanceState;
    private final InternetConnection internetConnection = PlayerContainer.getInstance().getInternetConnection();
    protected boolean isFullScreen;
    private DefaultLoadingViewDelegate loadingViewDelegate;
    protected final NetworkLogoImageLoader logoImageLoader = PlayerContainer.getInstance().createNetworkLogoImageLoader();
    protected PlayPressedListener playPressedListener;
    protected PlayerAndroidDevice playerAndroidDevice;
    protected final ProgramDetailArtImageLoader programDetailArtImageLoader = PlayerContainer.getInstance().createProgramDetailArtImageLoader();
    private ImageView rottenTomatoesCriticIcon;
    private TextView rottenTomatoesCriticScore;
    private ImageView rottenTomatoesFanIcon;
    private TextView rottenTomatoesFanScore;
    protected boolean shouldSuppressNetworkLogos;
    private DetailFragmentSpeechListener speechListener;
    protected UIUtil uiUtil;
    protected boolean wantsSubscriptionOnly;

    public DetailFragment()
    {
        bookmarkDAO = PlayerContainer.getInstance().getVideoBookmarkDAO();
        uiUtil = PlayerContainer.getInstance().getUIUtil();
        shouldSuppressNetworkLogos = PlayerContainer.getInstance().getConfiguration().shouldSuppressNetworkLogos();
        alternateInterfaceUtil = CALContainer.getInstance().getAlternateInterfaceUtil();
        playerAndroidDevice = PlayerContainer.getInstance().getAndroidDevice();
        downloadManager = PlayerContainer.getInstance().getDownloadServiceManager();
        androidDevice = PlayerContainer.getInstance().getAndroidDevice();
        animationsEnabled = true;
        speechListener = new DetailFragmentSpeechListener();
    }

    private ConnectivityRequiredOnClickListener buildPlayLaunchClickListener(final VideoFacade video, final Watchable watchable, final PlayPressedListener playPressedListener)
    {
        return new ConnectivityRequiredOnClickListener(uiUtil, new Runnable() {

            final DetailFragment this$0;
            final PlayPressedListener val$playPressedListener;
            final VideoFacade val$video;
            final Watchable val$watchable;

            public void run()
            {
                playPressedListener.onPlayOrResumePressed(video, watchable);
            }

            
            {
                this$0 = DetailFragment.this;
                playPressedListener = playpressedlistener;
                video = videofacade;
                watchable = watchable1;
                super();
            }
        });
    }

    private android.view.View.OnClickListener buildPlayLaunchDownloadClickListener(final VideoFacade video, final Watchable watchable, final PlayPressedListener playPressedListener)
    {
        return new android.view.View.OnClickListener() {

            final DetailFragment this$0;
            final PlayPressedListener val$playPressedListener;
            final VideoFacade val$video;
            final Watchable val$watchable;

            public void onClick(View view)
            {
                playPressedListener.onPlayOrResumePressed(video, watchable);
            }

            
            {
                this$0 = DetailFragment.this;
                playPressedListener = playpressedlistener;
                video = videofacade;
                watchable = watchable1;
                super();
            }
        };
    }

    private com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus getEngineStatus()
    {
        com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus evirtuosodownloadenginestatus;
        try
        {
            evirtuosodownloadenginestatus = downloadManager.getDownloadEngineStatus().status();
        }
        catch (DownloadServiceException downloadserviceexception)
        {
            LOG.error(downloadserviceexception.getMessage(), downloadserviceexception);
            return com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Errors;
        }
        return evirtuosodownloadenginestatus;
    }

    private boolean inBabyGuide()
    {
        return inBabyGuide || getActivity().getClass().equals(com/xfinity/playerlib/view/videoplay/VideoPlayerActivity) || getActivity().getClass().equals(com/xfinity/playerlib/view/programdetails/BabyGuideMovieActivity) || getActivity().getClass().equals(com/xfinity/playerlib/view/programdetails/BabyGuideEpisodeDetailActivity) || getActivity().getClass().equals(com/xfinity/playerlib/view/programdetails/BabyGuideSeriesEntityActivity);
    }

    private void setProgessBarEnabledState(View view, boolean flag)
    {
        view.findViewById(com.xfinity.playerlib.R.id.progress_bar).setEnabled(flag);
    }

    private void setupCancelDownloadButton(final VideoFacade video, final View layout)
    {
        ((ImageView)layout.findViewById(com.xfinity.playerlib.R.id.cancel_download)).setOnClickListener(new android.view.View.OnClickListener() );
    }

    private void showCustomDownloadWaitingState(PlayerDownloadFile playerdownloadfile, View view)
    {
        if (view == null)
        {
            return;
        } else
        {
            setProgessBarEnabledState(view, false);
            updateDownloadState(playerdownloadfile, getResources().getString(com.xfinity.playerlib.R.string.download_header_waiting), view, false);
            return;
        }
    }

    private LinearLayout showDownloadAvailableState(VideoFacade videofacade, View view)
    {
        LinearLayout linearlayout = (LinearLayout)view.findViewById(com.xfinity.playerlib.R.id.download_item_button);
        TextView textview = (TextView)view.findViewById(com.xfinity.playerlib.R.id.d2g_status);
        TextView textview1 = (TextView)view.findViewById(com.xfinity.playerlib.R.id.d2g_progress);
        String s;
        if (inBabyGuide())
        {
            view.setLayerType(1, null);
            String s1 = getResources().getString(com.xfinity.playerlib.R.string.download_header_babyguide_avail);
            s = s1;
            if (!accessibilityUtil.isAccessibilityEnabled())
            {
                textview.setSelected(true);
                s = s1;
            }
        } else
        {
            s = getResources().getString(com.xfinity.playerlib.R.string.available_for_download);
            linearlayout.setVisibility(0);
        }
        view = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.d2g_graphic);
        view.setImageResource(com.xfinity.playerlib.R.drawable.icn_downloadable_metadata);
        view.setVisibility(0);
        if (videofacade.isDownloadable() && !inBabyGuide())
        {
            updateVideoSize(textview1, textview, Integer.valueOf((int)UIPresentationUtil.bytesToMB(videofacade.getDefaultDownloadProfile().getContentSizeInBytes())), s);
            return linearlayout;
        } else
        {
            updateVideoSize(textview1, textview, null, s);
            textview1.setText(null);
            textview1.setContentDescription(null);
            return linearlayout;
        }
    }

    private void showDownloadErrorState(PlayerDownloadFile playerdownloadfile, View view)
    {
        if (view == null)
        {
            return;
        } else
        {
            setProgessBarEnabledState(view, false);
            ((TextView)view.findViewById(com.xfinity.playerlib.R.id.d2g_status)).setText(getResources().getString(com.xfinity.playerlib.R.string.download_header_blocked));
            ((TextView)view.findViewById(com.xfinity.playerlib.R.id.d2g_progress)).setText(null);
            updateDownloadState(playerdownloadfile, getResources().getString(com.xfinity.playerlib.R.string.download_header_blocked), view, false);
            return;
        }
    }

    private void showDownloadFinishedState(PlayerDownloadFile playerdownloadfile, View view)
    {
        if (view != null)
        {
            view.findViewById(com.xfinity.playerlib.R.id.progress_layout).setVisibility(8);
            view.findViewById(com.xfinity.playerlib.R.id.buttons_layout).setVisibility(0);
            Object obj = (TextView)view.findViewById(com.xfinity.playerlib.R.id.d2g_status);
            updateVideoSize((TextView)view.findViewById(com.xfinity.playerlib.R.id.d2g_progress), ((TextView) (obj)), Integer.valueOf(playerdownloadfile.getExpectedFileSizeInMb()), getResources().getString(com.xfinity.playerlib.R.string.download_header_complete));
            ((TextView) (obj)).setTextColor(getResources().getColor(com.xfinity.playerlib.R.color.LightBlue));
            obj = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.d2g_graphic);
            ((ImageView) (obj)).setImageResource(com.xfinity.playerlib.R.drawable.icn_downloaded_metadata);
            ((ImageView) (obj)).setVisibility(0);
            view.findViewById(com.xfinity.playerlib.R.id.playback_button).setOnClickListener(buildPlayLaunchDownloadClickListener(playerdownloadfile.getVideo(), playerdownloadfile.getWatchable(), playPressedListener));
            view.findViewById(com.xfinity.playerlib.R.id.download_item_button).setVisibility(8);
            view.findViewById(com.xfinity.playerlib.R.id.d2g_section).setBackgroundColor(getResources().getColor(com.xfinity.playerlib.R.color.black));
            if (playerdownloadfile.getExpirationStatus() != com.xfinity.playerlib.model.downloads.PlayerDownloadFile.ExpirationStatus.NOT_EXPIRED)
            {
                showDownloadOVPState(view);
                return;
            }
        }
    }

    private void showDownloadOVPState(View view)
    {
        if (view == null)
        {
            return;
        } else
        {
            view.findViewById(com.xfinity.playerlib.R.id.progress_layout).setVisibility(8);
            view.findViewById(com.xfinity.playerlib.R.id.video_details).setVisibility(8);
            view.findViewById(com.xfinity.playerlib.R.id.download_item_button).setVisibility(8);
            view.findViewById(com.xfinity.playerlib.R.id.playback_button).setVisibility(8);
            view.findViewById(com.xfinity.playerlib.R.id.buttons_layout).setVisibility(0);
            view.findViewById(com.xfinity.playerlib.R.id.expired_state).setVisibility(0);
            return;
        }
    }

    private void showDownloadPausedState(PlayerDownloadFile playerdownloadfile, View view)
    {
        showDownloadState(playerdownloadfile, view, com.xfinity.playerlib.R.string.download_header_paused, false);
    }

    private void showDownloadProgressState(PlayerDownloadFile playerdownloadfile, View view, boolean flag)
    {
        if (view == null)
        {
            return;
        } else
        {
            setProgessBarEnabledState(view, true);
            updateDownloadState(playerdownloadfile, getResources().getString(com.xfinity.playerlib.R.string.download_header_in_progress_ind), view, flag);
            return;
        }
    }

    private void showDownloadState(PlayerDownloadFile playerdownloadfile, View view, int i, boolean flag)
    {
        if (view == null)
        {
            return;
        } else
        {
            setProgessBarEnabledState(view, false);
            updateDownloadState(playerdownloadfile, getResources().getString(i), view, flag);
            return;
        }
    }

    private void showDownloadState(PlayerDownloadFile playerdownloadfile, View view, com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus evirtuosodownloadenginestatus)
    {
        if (view == null)
        {
            return;
        }
        com.penthera.virtuososdk.Common.EFileDownloadStatus efiledownloadstatus = playerdownloadfile.getAsset().downloadStatus();
        if (efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.KvDE_Download_Complete)
        {
            showDownloadFinishedState(playerdownloadfile, view);
            return;
        }
        if (efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Downloading || efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending)
        {
            if (evirtuosodownloadenginestatus.equals(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused))
            {
                showDownloadPausedState(playerdownloadfile, view);
                return;
            }
            if (evirtuosodownloadenginestatus.equals(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked))
            {
                showDownloadErrorState(playerdownloadfile, view);
                return;
            }
            if (efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending)
            {
                showDownloadWaitingState(playerdownloadfile, view);
                return;
            } else
            {
                showDownloadProgressState(playerdownloadfile, view, true);
                return;
            }
        } else
        {
            showDownloadErrorState(playerdownloadfile, view);
            return;
        }
    }

    private void showDownloadWaitingState(PlayerDownloadFile playerdownloadfile, View view)
    {
        showDownloadState(playerdownloadfile, view, com.xfinity.playerlib.R.string.download_header_waiting, false);
    }

    private void toggleProgressState(boolean flag, View view)
    {
        boolean flag1 = false;
        if (view == null)
        {
            return;
        }
        View view1 = view.findViewById(com.xfinity.playerlib.R.id.buttons_layout);
        view = view.findViewById(com.xfinity.playerlib.R.id.progress_layout);
        int i;
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        view1.setVisibility(i);
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void updateDownloadState(PlayerDownloadFile playerdownloadfile, String s, View view, boolean flag)
    {
        if (view != null)
        {
            ((TextView)view.findViewById(com.xfinity.playerlib.R.id.d2g_status)).setText(s);
            s = (ProgressBar)view.findViewById(com.xfinity.playerlib.R.id.progress_bar);
            if (playerdownloadfile != null && playerdownloadfile.getPercentComplete() > 1)
            {
                s.setProgress(playerdownloadfile.getPercentComplete());
            } else
            {
                int i;
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                s.setProgress(i);
            }
            s.setEnabled(flag);
            if (playerdownloadfile != null)
            {
                s = (TextView)view.findViewById(com.xfinity.playerlib.R.id.d2g_progress);
                s.setFocusable(false);
                s.setContentDescription(null);
                s.setText(getResources().getString(com.xfinity.playerlib.R.string.download_MB_text, new Object[] {
                    Integer.valueOf(playerdownloadfile.getExpectedFileSizeInMb())
                }));
                return;
            }
        }
    }

    protected void addVideoItems(Map map, VideoEntitlement videoentitlement, Watchable watchable, SortedSet sortedset, ViewGroup viewgroup, LayoutInflater layoutinflater, PlayPressedListener playpressedlistener, 
            Long long1)
    {
        VideoItemAdapter videoitemadapter = new VideoItemAdapter();
        viewgroup.removeAllViews();
        if (!sortedset.isEmpty())
        {
            int j = 0;
            int i = 0;
            Iterator iterator = sortedset.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((VideoFacade)iterator.next()).getNetworkInfo() != null)
                {
                    j++;
                }
            } while (true);
            if (j > 1)
            {
                i = 1;
            }
            sortedset = sortedset.iterator();
            do
            {
                if (!sortedset.hasNext())
                {
                    break;
                }
                VideoFacade videofacade = (VideoFacade)sortedset.next();
                if (videofacade.getNetworkInfo() != null)
                {
                    VideoBookmark videobookmark = (VideoBookmark)map.get(videofacade);
                    boolean flag2 = videoentitlement.isEntitled(videofacade.getProviderCode());
                    if ((flag2 || !flag2 && !wantsSubscriptionOnly) && (!filterByNetwork || filterByNetwork && videofacade.getNetworkInfo().getCompanyId() == instanceState.companyId.longValue()))
                    {
                        PlayerDownloadFile playerdownloadfile = downloadManager.findFileWithVideoId(videofacade.getVideoId());
                        boolean flag;
                        boolean flag1;
                        if (long1 != null && videofacade.getVideoId() == long1.longValue())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (long1 != null)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        inBabyGuide = flag1;
                        viewgroup.addView(videoitemadapter.createView(videofacade, videobookmark, watchable, playerdownloadfile, flag2, layoutinflater, viewgroup, playpressedlistener, videofacade.isDownloadable(), flag, i, j));
                    }
                }
                if (j > 1)
                {
                    viewgroup.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_videos_to_choose_from, new Object[] {
                        Integer.valueOf(j)
                    }));
                    viewgroup.setFocusable(true);
                    viewgroup.setFocusableInTouchMode(true);
                    accessibilityUtil.setImportantForAccessibility(viewgroup, 1);
                    i++;
                }
            } while (true);
        } else
        {
            viewgroup.addView(videoitemadapter.createUnavailableView(layoutinflater, viewgroup));
        }
    }

    public void extractDataFromBundle(Bundle bundle)
    {
        instanceState = InstanceState.fromBundle(bundle);
        boolean flag;
        if (instanceState.companyId != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        filterByNetwork = flag;
        wantsSubscriptionOnly = instanceState.wantsSubscriptionOnly;
    }

    protected String formatAvailability(Date date)
    {
        Validate.notNull(date);
        date = FastDateFormat.getInstance(getResources().getString(com.xfinity.playerlib.R.string.month_day_year_format)).format(date);
        return getResources().getString(com.xfinity.playerlib.R.string.available_until_date_display_format, new Object[] {
            date
        });
    }

    abstract int getDetailLayoutId();

    public LinearLayout getFirstPlayButton()
    {
        return (LinearLayout)bodyContainer.findViewById(com.xfinity.playerlib.R.id.playback_button);
    }

    protected DefaultLoadingViewDelegate getLoadingViewDelegate()
    {
        return loadingViewDelegate;
    }

    protected SortedSet getSortedVideos(VideoEntitlement videoentitlement, Watchable watchable)
    {
        videoentitlement = new TreeSet(new VideoComparator(videoentitlement));
        videoentitlement.addAll(watchable.getVideos());
        return videoentitlement;
    }

    public abstract ViewGroup getVideoItemViewContainer();

    public abstract void loadScreenInfo();

    public void onActivityCreated(Bundle bundle)
    {
        onActivityCreated(bundle);
        alternateInterfaceListener.addSpeechListener(speechListener);
        if (accessibilityUtil.isAccessibilityEnabled() && playerAndroidDevice.isTabletDevice())
        {
            getActivity().getActionBar().hide();
        }
    }

    public void onAttach(Activity activity)
    {
        onAttach(activity);
        PreDownloadFlowFragment predownloadflowfragment;
        if (activity instanceof FetchCanceledListener)
        {
            fetchCanceledListener = (FetchCanceledListener)activity;
        } else
        {
            fetchCanceledListener = this;
        }
        playPressedListener = (PlayPressedListener)activity;
        predownloadflowfragment = (PreDownloadFlowFragment)activity.getFragmentManager().findFragmentByTag(PreDownloadFlowFragment.FRAGMENT_TAG);
        if (predownloadflowfragment != null)
        {
            LOG.debug("Reattached to pre download flow fragment in progress");
            predownloadflowfragment.setFlowEventListener(new FlowEventListener());
        }
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        showFailureState(null);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Bundle bundle1 = getActivity().getIntent().getExtras();
        if (getArguments() != null)
        {
            bundle1.putAll(getArguments());
        }
        if (bundle != null)
        {
            bundle1.putAll(bundle);
        }
        extractDataFromBundle(bundle1);
        layoutinflater = (ViewGroup)layoutinflater.inflate(getDetailLayoutId(), viewgroup, false);
        viewgroup = (ViewGroup)layoutinflater.findViewById(com.xfinity.playerlib.R.id.body_container);
        bundle = (LoadingIndicator)layoutinflater.findViewById(com.xfinity.playerlib.R.id.loading_indicator);
        loadingViewDelegate = new DefaultLoadingViewDelegate(getActivity(), viewgroup, bundle, internetConnection, new com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate.ReadyListener() {

            final DetailFragment this$0;

            public void onReady()
            {
                loadScreenInfo();
            }

            
            {
                this$0 = DetailFragment.this;
                super();
            }
        });
        alternateInterfaceListener.setupPassiveGestureDetector(layoutinflater, com.xfinity.playerlib.R.id.touchy_parent);
        return layoutinflater;
    }

    public void onDetach()
    {
        onDetach();
        alternateInterfaceListener.removeSpeechListener(speechListener);
    }

    public void onDownloadEngineStatusChanged(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
    {
        PlayerDownloadFile playerdownloadfile;
        for (Iterator iterator = downloadManager.getFilesList().iterator(); iterator.hasNext(); showDownloadState(playerdownloadfile, getVideoItemViewContainer().findViewWithTag(Long.valueOf(playerdownloadfile.getVideoId())), ivirtuosodownloadenginestatus.status()))
        {
            playerdownloadfile = (PlayerDownloadFile)iterator.next();
        }

    }

    public void onDownloadServiceConnected()
    {
    }

    public volatile void onFileDownloadError(DownloadFile downloadfile)
    {
        onFileDownloadError((PlayerDownloadFile)downloadfile);
    }

    public void onFileDownloadError(PlayerDownloadFile playerdownloadfile)
    {
        if (loadingViewDelegate.resourcesLoaded())
        {
            showDownloadErrorState(playerdownloadfile, getVideoItemViewContainer().findViewWithTag(Long.valueOf(playerdownloadfile.getVideoId())));
        }
    }

    public volatile void onFileDownloadFinished(DownloadFile downloadfile)
    {
        onFileDownloadFinished((PlayerDownloadFile)downloadfile);
    }

    public void onFileDownloadFinished(PlayerDownloadFile playerdownloadfile)
    {
        if (loadingViewDelegate.resourcesLoaded())
        {
            showDownloadFinishedState(playerdownloadfile, getVideoItemViewContainer().findViewWithTag(Long.valueOf(playerdownloadfile.getVideoId())));
        }
    }

    public volatile void onFileDownloadStarted(DownloadFile downloadfile)
    {
        onFileDownloadStarted((PlayerDownloadFile)downloadfile);
    }

    public void onFileDownloadStarted(PlayerDownloadFile playerdownloadfile)
    {
        if (loadingViewDelegate.resourcesLoaded())
        {
            showDownloadProgressState(playerdownloadfile, getVideoItemViewContainer().findViewWithTag(Long.valueOf(playerdownloadfile.getVideoId())), true);
        }
    }

    public void onFileListUpdated()
    {
        if (loadingViewDelegate.firstTimeLoadStarted()) goto _L2; else goto _L1
_L1:
        loadScreenInfo();
_L4:
        return;
_L2:
        if (loadingViewDelegate.resourcesLoaded())
        {
            com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus evirtuosodownloadenginestatus = getEngineStatus();
            Iterator iterator = downloadManager.getFilesList().iterator();
            while (iterator.hasNext()) 
            {
                DownloadFile downloadfile = (DownloadFile)iterator.next();
                showDownloadState((PlayerDownloadFile)downloadfile, getVideoItemViewContainer().findViewWithTag(Long.valueOf(((PlayerDownloadFile)downloadfile).getVideoId())), evirtuosodownloadenginestatus);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile void onFileProgressUpdated(DownloadFile downloadfile)
    {
        onFileProgressUpdated((PlayerDownloadFile)downloadfile);
    }

    public void onFileProgressUpdated(PlayerDownloadFile playerdownloadfile)
    {
        if (loadingViewDelegate.resourcesLoaded())
        {
            showDownloadProgressState(playerdownloadfile, getVideoItemViewContainer().findViewWithTag(Long.valueOf(playerdownloadfile.getVideoId())), true);
        }
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        onInflate(activity, attributeset, bundle);
        activity = activity.obtainStyledAttributes(attributeset, com.xfinity.playerlib.R.styleable.com_xfinity_playerlib_view_programdetails_DetailFragment);
        isFullScreen = activity.getBoolean(com.xfinity.playerlib.R.styleable.com_xfinity_playerlib_view_programdetails_DetailFragment_isFullScreen, true);
        activity.recycle();
    }

    protected void onLoadingFailed()
    {
        loadingViewDelegate.onLoadingFailed();
    }

    protected void onLoadingFailed(int i)
    {
        loadingViewDelegate.onLoadingFailed(i);
    }

    protected void onLoadingFinished()
    {
        loadingViewDelegate.onLoadingFinished();
        alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.id.ACCESSIBILITY_ANNOUNCE_LOADED);
    }

    public void onStartInternal()
    {
        onStartInternal();
        loadingViewDelegate.onStart();
        if (getVideoItemViewContainer() != null)
        {
            downloadManager.addDownloadServiceListener(this);
        }
    }

    public void onStop()
    {
        onStop();
        loadingViewDelegate.onStop();
        downloadManager.removeDownloadServiceListener(this);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        onViewCreated(view, bundle);
    }

    protected void presentReviews(List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            HalReview halreview = (HalReview)list.next();
            if (halreview.isRottenTomatoes())
            {
                int i = halreview.getRottenTomatoesCriticScore();
                int k = halreview.getRottenTomatoesFanScore();
                if (i >= 0)
                {
                    rottenTomatoesCriticScore.setVisibility(0);
                    rottenTomatoesCriticScore.setText(getString(com.xfinity.playerlib.R.string.rotten_tomatoes_score, new Object[] {
                        Integer.valueOf(i)
                    }));
                    rottenTomatoesCriticIcon.setVisibility(0);
                    ImageView imageview = rottenTomatoesCriticIcon;
                    if (halreview.isRottenTomatoesCriticFresh())
                    {
                        i = com.xfinity.playerlib.R.drawable.icn_rt_tomato_fresh;
                    } else
                    {
                        i = com.xfinity.playerlib.R.drawable.icn_rt_tomato_rotten;
                    }
                    imageview.setImageResource(i);
                }
                if (k >= 0)
                {
                    rottenTomatoesFanScore.setVisibility(0);
                    rottenTomatoesFanScore.setText(getString(com.xfinity.playerlib.R.string.rotten_tomatoes_score, new Object[] {
                        Integer.valueOf(k)
                    }));
                    rottenTomatoesFanIcon.setVisibility(0);
                    imageview = rottenTomatoesFanIcon;
                    if (halreview.isRottenTomatoesFanFresh())
                    {
                        i = com.xfinity.playerlib.R.drawable.icn_rt_popcorn_full;
                    } else
                    {
                        i = com.xfinity.playerlib.R.drawable.icn_rt_popcorn_spilled;
                    }
                    imageview.setImageResource(i);
                }
            } else
            if (halreview.isCommonSenseMedia())
            {
                int j = halreview.getCommonSenseMediaTargetAge();
                if (j > 0)
                {
                    commonSenseMediaLabel.setVisibility(0);
                    commonSenseMediaTargetRating.setVisibility(0);
                    commonSenseMediaTargetRating.setText(String.valueOf(j));
                }
            }
        } while (true);
    }

    public void setAnimationEnabled(Boolean boolean1)
    {
        animationsEnabled = boolean1.booleanValue();
    }

    protected void setDisplayTitle(String s, TextView textview)
    {
        if (isFullScreen)
        {
            Activity activity = getActivity();
            if (activity != null)
            {
                activity.setTitle(s);
            }
            textview.setVisibility(8);
            return;
        } else
        {
            textview.setText(s);
            textview.setContentDescription((new StringBuilder()).append(s).append(".").toString());
            textview.setVisibility(0);
            return;
        }
    }

    protected void setupReviews(View view)
    {
        rottenTomatoesCriticScore = (TextView)view.findViewById(com.xfinity.playerlib.R.id.rotten_tomatoes_critic_score);
        rottenTomatoesFanScore = (TextView)view.findViewById(com.xfinity.playerlib.R.id.rotten_tomatoes_fan_score);
        rottenTomatoesCriticIcon = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.rotten_tomatoes_critic_score_icon);
        rottenTomatoesFanIcon = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.rotten_tomatoes_fan_score_icon);
        commonSenseMediaTargetRating = (TextView)view.findViewById(com.xfinity.playerlib.R.id.common_sense_media_rating);
        commonSenseMediaLabel = (TextView)view.findViewById(com.xfinity.playerlib.R.id.common_sense_media_age);
    }

    public void showDuration(VideoFacade videofacade)
    {
        TextView textview;
label0:
        {
            textview = (TextView)getView().findViewById(com.xfinity.playerlib.R.id.duration);
            if (textview != null)
            {
                if (videofacade != null && videofacade.getDurationInSeconds() != 0)
                {
                    break label0;
                }
                textview.setVisibility(8);
            }
            return;
        }
        textview.setVisibility(0);
        textview.setText(UIPresentationUtil.getDuration(getActivity(), videofacade.getDurationInSeconds()));
        textview.setContentDescription(UIPresentationUtil.getDurationSpoken(getActivity(), videofacade.getDurationInSeconds()));
    }

    abstract void showFailureState(CimException cimexception);

    protected transient void updateCompoundTextView(TextView textview, Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = aobj[i];
            if (obj == null)
            {
                continue;
            }
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(" | ");
            }
            stringbuilder.append(obj.toString());
        }

        if (stringbuilder.length() > 0)
        {
            textview.setVisibility(0);
            textview.setText(stringbuilder.toString());
        } else
        {
            textview.setVisibility(8);
        }
        textview.setContentDescription(UIPresentationUtil.getSeriesStringSpoken(stringbuilder.toString(), getResources().getString(com.xfinity.playerlib.R.string.content_description_season), getResources().getString(com.xfinity.playerlib.R.string.content_description_episode)));
    }

    protected void updateVideoSize(TextView textview, TextView textview1, Integer integer, String s)
    {
        String s1;
        if (integer == null)
        {
            s1 = getString(com.xfinity.playerlib.R.string.content_description_add_pause, new Object[] {
                s
            });
        } else
        {
            s1 = getString(com.xfinity.playerlib.R.string.content_description_avail_for_download, new Object[] {
                s, integer
            });
        }
        textview.setFocusable(false);
        if (integer != null)
        {
            integer = (new StringBuilder()).append(integer).append(" MB").toString();
        } else
        {
            integer = "";
        }
        textview.setText(integer);
        textview.setContentDescription(null);
        textview1.setFocusable(true);
        textview1.setText(s);
        textview1.setContentDescription(s1);
    }









}
