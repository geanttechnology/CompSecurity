// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.app.Presentation;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.drm.DrmErrorEvent;
import android.drm.DrmEvent;
import android.drm.DrmManagerClient;
import android.hardware.display.DisplayManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.conviva.LivePass;
import com.fanhattan.services.contextualmenu.api.ContextualMenu;
import com.fanhattan.services.contextualmenu.api.ContextualMenuItem;
import com.fanhattan.services.contextualmenu.api.ContextualMenuSection;
import com.fanhattan.services.contextualmenu.api.ContextualMenuService;
import com.freewheel.ad.AdFetcher;
import com.freewheel.ad.ITemporalAdHolder;
import com.google.util.SystemUiHider;
import com.gotv.crackle.adapters.DeviceListAdapter;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.captions.CaptionWindow;
import com.gotv.crackle.captions.model.CaptionSettings;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.data.ItemsListRequest;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.data.SocialOnAPI;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.dialogs.LanguageDialog;
import com.gotv.crackle.fragments.SeekIndicatorFragment;
import com.gotv.crackle.helpers.ChromeCastHelper;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.BrowseModel;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.model.MediaUrlItem;
import com.gotv.crackle.model.SubtitleTimeCode;
import com.gotv.crackle.smarttv.SmartTV;
import com.gotv.crackle.smarttv.SmartTVListener;
import com.gotv.crackle.util.ComscoreTracker;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.util.OmnitureWrapper;
import com.gotv.crackle.views.CrackleVideoView;
import com.gotv.crackle.views.FanhattanVideoView;
import com.gotv.crackle.views.MediaControllerView;
import com.gotv.crackle.views.MidRollSeekBar;
import com.mobileapptracker.MobileAppTracker;
import com.nielsen.app.sdk.AppSdk;
import com.sessionm.api.SessionM;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.cybergarage.upnp.Device;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.gotv.crackle:
//            Application, ApplicationConstants, VideoPlayerActivityFlash, WidevineDrm, 
//            TwitterWebActivity

public class VideoPlayerActivity extends BaseActivity
    implements com.fanhattan.services.contextualmenu.api.ContextualMenuService.ContextualMenuCallback, ITemporalAdHolder, SmartTVListener, com.gotv.crackle.dialogs.LanguageDialog.LanguageDialogListener
{
    private final class DisplayListAdapter extends ArrayAdapter
    {

        private int curIndex;
        final Context mContext;
        final VideoPlayerActivity this$0;

        public int getCurIndex()
        {
            return curIndex;
        }

        public Display getCurrentItem()
        {
            if (getCount() > 0)
            {
                return (Display)getItem(curIndex);
            } else
            {
                return null;
            }
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            view = viewgroup;
            if (viewgroup == null)
            {
                view = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x7f030042, null);
            }
            viewgroup = (TextView)view.findViewById(0x7f0a00d2);
            if (viewgroup != null)
            {
                viewgroup.setText(((Display)getItem(i)).getName());
            }
            viewgroup = (ImageView)view.findViewById(0x7f0a00d4);
            viewgroup.setVisibility(4);
            view.setClickable(false);
            if (i == curIndex)
            {
                viewgroup.setVisibility(0);
            }
            return view;
        }

        public void setCurIndex(int i)
        {
            curIndex = i;
        }

        public void unselectItem()
        {
            curIndex = -1;
        }

        public DisplayListAdapter(Context context, Display adisplay[])
        {
            this$0 = VideoPlayerActivity.this;
            super(context, 0x7f030042, adisplay);
            curIndex = -1;
            mContext = context;
        }
    }

    private class MidrollHandler extends Handler
    {

        private static final int MSG_MIDROLL_CHECK = 1000;
        private static final int MSG_SCRUBBING_FORGIVENESS = 1001;
        final VideoPlayerActivity this$0;

        public void cancel()
        {
            removeMessages(1000);
        }

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 1000: 
                removeMessages(1000);
                Log.d("VideoPlayer", (new StringBuilder()).append("CHECK FOR AD forgiveness ").append(mScrubbingForgiveness).toString());
                if (mVideoHelper.isPlaying())
                {
                    int i = mVideoHelper.getCurrentPosition();
                    if ((i / 1000) % 15 == 0 && i != 0 && findViewById(0x7f0a019f).getVisibility() == 0)
                    {
                        saveTime(i, "Every 15 Seconds");
                    }
                }
                if (!mScrubbingForgiveness)
                {
                    checkIfAdNeedsToRun(mVideoHelper.getCurrentPosition(), true);
                } else
                if (mVideoHelper.getCurrentPosition() > 0)
                {
                    mLastAdTimeCode = mVideoHelper.getCurrentPosition() / 1000;
                }
                if (mComscoreTracker != null && mVideoHelper.getCurrentPosition() != 0)
                {
                    mComscoreTracker.setTimeRecentlyObserved(mVideoHelper.getCurrentPosition());
                }
                sendEmptyMessageDelayed(1000, 1000L);
                return;

            case 1001: 
                mScrubbingForgiveness = false;
                return;
            }
        }

        public void start()
        {
            cancel();
            sendEmptyMessage(1000);
        }

        public void startScrubbingForgivenessPeriod()
        {
            if (mVideoDubSubtitleProcessor.getCurrentItem().getScrubbingForgiveness() != null)
            {
                mScrubbingForgiveness = true;
                sendEmptyMessageDelayed(1001, mVideoDubSubtitleProcessor.getCurrentItem().getScrubbingForgiveness().intValue() * 1000);
            }
        }

        private MidrollHandler()
        {
            this$0 = VideoPlayerActivity.this;
            super();
        }

    }

    private final class RemotePresentation extends Presentation
    {

        final VideoPlayerActivity this$0;

        protected void onCreate(Bundle bundle)
        {
            super.onCreate(bundle);
            int i;
            if (Application.isFanhattan())
            {
                i = 0x7f03007c;
            } else
            {
                i = 0x7f03007b;
            }
            setContentView(i);
            isOnTV = true;
            findViewById(0x7f0a019f).setVisibility(8);
            if (mNetworkID != null)
            {
                mNetworkID.setVisibility(8);
            }
            mToTvBackground.setVisibility(0);
            findVideoView();
            mNetworkID = findViewById(0x7f0a019e);
            adContext.registerVideoDisplayBase(mVideoFrame);
            mVideoPlayerControlsView.init(mVideoHelper, mProgressView);
            playFromLastPosition();
        }

        public RemotePresentation(Context context, Display display)
        {
            this$0 = VideoPlayerActivity.this;
            super(context, display);
        }
    }

    private class SubtitleHandler extends Handler
    {

        private static final int MSG_SUBTITLE_CHECK = 2000;
        final VideoPlayerActivity this$0;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 2000: 
                updateSubtTitles(mVideoHelper.getCurrentPosition());
                break;
            }
            mSubTitleHandler.sendEmptyMessageDelayed(2000, 100L);
        }

        private SubtitleHandler()
        {
            this$0 = VideoPlayerActivity.this;
            super();
        }

    }

    private class TimeoutHandler extends Handler
    {

        final VideoPlayerActivity this$0;

        public void handleMessage(Message message)
        {
            onYosemiteTimeout();
        }

        private TimeoutHandler()
        {
            this$0 = VideoPlayerActivity.this;
            super();
        }

    }


    public static final String AMAZON_LINK_EXTRA = "AMAZON_LINK";
    public static final String FANHATTAN_MENU_ID_SUBTITLES = "FAN_ID_SUBTITLES";
    public static final String MEDIA_ID_EXTRA = "MEDIA_ID";
    public static final String MEDIA_THUMBNAIL_URL = "MEDIA_THUMBNAIL_URL";
    public static final String MSG_NOT_FOUND = "Can not open this video. Video not found.";
    public static final String RESUME_EXTRA = "RESUME_EXTRA";
    private static final int TEN_SECONDS = 10000;
    public static final String VIDEO_DIMENSION = "VIDEO_DIMENSION";
    public static final String VIDEO_DURATION_EXTRA = "VIDEO_DURATION";
    public static final String VIDEO_URL_EXTRA = "VIDEO_URL";
    public static final String VIDEO_URL_EXTRA_FLASH = "VIDEO_URL_FLASH";
    public static MediaDetailsItem mConvivaMediaDetailsItem;
    public static String mConvivaMediaUrl;
    public static int mConvivaSessionID;
    private String TAG;
    private IAdContext adContext;
    private String control;
    private boolean isOnTV;
    private ActionBar mActionBar;
    private AdFetcher mAdFetcher;
    private boolean mAdIsPlaying;
    private int mAdPodIndex;
    private int mAdPodNumber;
    private AlertDialog mAlertDeviceList;
    private AlertDialog mAlertMessageDialog;
    private String mAmazonLink;
    private boolean mBumperIsRunning;
    private CaptionWindow mCaptionWindow;
    private ComscoreTracker mComscoreTracker;
    private ContextualMenuService mContextualMenuService;
    private ISlot mCurrentAdSlot;
    private DeviceListAdapter mDeviceListAdapter;
    private ListView mDeviceListView;
    private LinearLayout mDeviceListlayout;
    private DisplayListAdapter mDisplayListAdapter;
    private DisplayManager mDisplayManager;
    private WidevineDrm mDrm;
    private int mDurationInSeconds;
    private android.media.MediaPlayer.OnErrorListener mErrorListener;
    private Handler mGeneralHandler;
    Handler mHideHandler;
    Runnable mHideRunnable;
    private boolean mIsSendData;
    private int mLastAdTimeCode;
    private int mLastOmnitureReportTimeInSeconds;
    private boolean mLoadingFromSession;
    protected Dialog mLowBandwidthDialog;
    private String mMediaID;
    private MenuItem mMenuItemBuy;
    private MenuItem mMenuItemPlayOn;
    private MenuItem mMenuItemUnpost;
    private MidRollSeekBar mMidRollSeekBar;
    private MidrollHandler mMidrollHandler;
    private List mMidrollKeys;
    private HashMap mMidrolls;
    private View mNetworkID;
    private String mNextMediaIdToPlay;
    private int mNextPosition;
    private int mNielsenCallByPass;
    private RelativeLayout mNoDeviceMessageBlock;
    private boolean mPassed25;
    private boolean mPassed50;
    private boolean mPassed75;
    private boolean mPassed95;
    private boolean mPassedCompletion;
    private boolean mPassedTenSeconds;
    private List mPlayedMidrollKeys;
    private ISlot mPrerollAdSlot;
    private boolean mPrerollRunning;
    private RemotePresentation mPresentation;
    private View mProgressView;
    private String mResume;
    protected Dialog mResumeDialog;
    private boolean mResumedInLock;
    private boolean mScrubbingForgiveness;
    private View mSeekIndicatorContainer;
    private SeekIndicatorFragment mSeekIndicatorFragment;
    private Device mSelectedDevice;
    protected Dialog mShareDialog;
    private boolean mShouldReportVideoStart;
    private SocialOnAPI mSocialOnAPI;
    private SubtitleHandler mSubTitleHandler;
    private String mSubTitleSelected;
    private List mSubtitleTimeCodes;
    private SystemUiHider mSystemUiHider;
    private String mThumbnailUrl;
    private int mTimePlayingCounter;
    private View mToTvBackground;
    private boolean mTriedWithHTTPLive;
    private AlertDialog mTurnOffMiracastDialog;
    private RelativeLayout mVideoBase;
    private VideoDubSubtitleProcessor mVideoDubSubtitleProcessor;
    protected AlertDialog mVideoErrorDialog;
    private FrameLayout mVideoFrame;
    private CrackleVideoHelper mVideoHelper;
    private MediaControllerView mVideoPlayerControlsView;
    protected int mVideoPosition;
    private String mVideoUrl;
    private android.view.View.OnClickListener shareItemClickListener;
    private TimeoutHandler timeoutHandler;
    private android.os.PowerManager.WakeLock wakeLock;

    public VideoPlayerActivity()
    {
        mMidrolls = new HashMap();
        mMidrollKeys = new ArrayList();
        mPlayedMidrollKeys = new ArrayList();
        mLastAdTimeCode = 0;
        mAdPodNumber = 0;
        mAdPodIndex = 0;
        mSubTitleSelected = null;
        mPrerollRunning = false;
        mAdIsPlaying = false;
        mScrubbingForgiveness = false;
        wakeLock = null;
        mResume = "false";
        mLoadingFromSession = false;
        mTriedWithHTTPLive = false;
        mPassed25 = false;
        mPassed50 = false;
        mPassed75 = false;
        mPassed95 = false;
        mPassedTenSeconds = false;
        mPassedCompletion = false;
        TAG = "VideoPlayerActivity:";
        mSelectedDevice = null;
        mVideoPosition = 0;
        mNielsenCallByPass = 1;
        isOnTV = false;
        mSocialOnAPI = new SocialOnAPI();
        mGeneralHandler = new Handler();
        mShouldReportVideoStart = false;
        mErrorListener = new android.media.MediaPlayer.OnErrorListener() {

            final VideoPlayerActivity this$0;

            public boolean onError(MediaPlayer mediaplayer, int i, int j)
            {
                if (mTriedWithHTTPLive && android.os.Build.VERSION.SDK_INT < 11 && !Application.isNookTablet())
                {
                    forwardToFlashPlayer();
                    return true;
                }
                if (i == 1 && !mTriedWithHTTPLive)
                {
                    mVideoUrl = mVideoUrl.replace("http:", "httplive:");
                    mTriedWithHTTPLive = true;
                    playFromLastPosition();
                    return true;
                } else
                {
                    mVideoErrorDialog.show();
                    return true;
                }
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        };
        mResumedInLock = false;
        shareItemClickListener = new android.view.View.OnClickListener() {

            final VideoPlayerActivity this$0;

            public void onClick(View view)
            {
                MediaDetailsItem mediadetailsitem = mVideoDubSubtitleProcessor.getCurrentItem();
                if (view.getId() == 0x7f0a0169)
                {
                    mShareDialog.dismiss();
                    postToFacebook(false, mVideoDubSubtitleProcessor.getCurrentItem());
                    if (mVideoHelper.isPlaying())
                    {
                        mVideoHelper.pause();
                    }
                    Application.getInstance().getOmnitureTracker().onVideoShare("Facebook", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", mSubTitleSelected, mediadetailsitem.getDuration());
                } else
                {
                    if (view.getId() == 0x7f0a016a)
                    {
                        mShareDialog.dismiss();
                        view = new Intent(VideoPlayerActivity.this, com/gotv/crackle/TwitterWebActivity);
                        view.putExtra("share_link", mVideoDubSubtitleProcessor.getCurrentItem().getPermaLink());
                        view.putExtra("share_title", mVideoDubSubtitleProcessor.getCurrentItem().getTitle());
                        startActivity(view);
                        Application.getInstance().getOmnitureTracker().onVideoShare("Twitter", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", mSubTitleSelected, mediadetailsitem.getDuration());
                        return;
                    }
                    if (view.getId() == 0x7f0a0165)
                    {
                        try
                        {
                            shareMailClicked(mVideoDubSubtitleProcessor.getCurrentItem());
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            view.printStackTrace();
                        }
                        mShareDialog.dismiss();
                        Application.getInstance().getOmnitureTracker().onVideoShare("Email", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", mSubTitleSelected, mediadetailsitem.getDuration());
                        return;
                    }
                    if (view.getId() == 0x7f0a0167)
                    {
                        mShareDialog.dismiss();
                        shareSMSClicked(mVideoDubSubtitleProcessor.getCurrentItem());
                        Application.getInstance().getOmnitureTracker().onVideoShare("SMS", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", mSubTitleSelected, mediadetailsitem.getDuration());
                        return;
                    }
                }
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        };
        mSubTitleHandler = new SubtitleHandler();
        mMidrollHandler = new MidrollHandler();
        mIsSendData = false;
        mHideHandler = new Handler();
        mHideRunnable = new Runnable() {

            final VideoPlayerActivity this$0;

            public void run()
            {
                mSystemUiHider.hide();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        };
    }

    private void addActionBar()
    {
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowTitleEnabled(true);
        mActionBar.setNavigationMode(0);
        mActionBar.setDisplayHomeAsUpEnabled(true);
    }

    private AlertDialog buildMessageDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        final String dataSent = formatDataSent();
        builder.setPositiveButton(getString(0x7f0b00e0), new android.content.DialogInterface.OnClickListener() {

            final VideoPlayerActivity this$0;
            final String val$dataSent;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (mIsSendData)
                {
                    mIsSendData = false;
                    SmartTV.getInstance().sendData(dataSent);
                }
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                dataSent = s;
                super();
            }
        });
        return builder.create();
    }

    private boolean checkIfAdNeedsToRun(int i, boolean flag)
    {
        Object obj;
        mNielsenCallByPass = mNielsenCallByPass + 1;
        if (mNielsenAppSdk != null && mNielsenCallByPass % 2 == 0)
        {
            long l1 = i / 1000;
            mNielsenAppSdk.setPlayheadPosition(l1);
        }
        if (mAdIsPlaying || mVideoPlayerControlsView.shouldHoldAd())
        {
            break MISSING_BLOCK_LABEL_384;
        }
        if (!mVideoPlayerControlsView.isBuffering() && mVideoHelper.isPlaying())
        {
            mTimePlayingCounter = mTimePlayingCounter + 1;
        }
        obj = mMidrollKeys.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Integer integer = (Integer)((Iterator) (obj)).next();
            if (integer.intValue() <= mLastAdTimeCode && !mPlayedMidrollKeys.contains(integer))
            {
                mPlayedMidrollKeys.add(integer);
            }
        } while (true);
        obj = new Handler(getMainLooper());
        int i1 = i / 1000;
        int l = 0;
        int j1 = mMidrollKeys.size();
        int k = 1;
        for (int j = 0; j < j1; j++)
        {
            Integer integer1 = (Integer)mMidrollKeys.get(j);
            if (i1 > integer1.intValue())
            {
                k = mMidrollKeys.indexOf(integer1);
                l = integer1.intValue();
            }
        }

        mAdPodNumber = k + 1;
        mAdPodIndex = 0;
        if (mPlayedMidrollKeys.contains(Integer.valueOf(l)))
        {
            break MISSING_BLOCK_LABEL_382;
        }
        mLastAdTimeCode = l;
        mCurrentAdSlot = adContext.getSlotByCustomId((String)mMidrolls.get(Integer.valueOf(mLastAdTimeCode)));
        mPlayedMidrollKeys.add(Integer.valueOf(mLastAdTimeCode));
        saveTime(i, "chekcIfAd");
        if (mCurrentAdSlot == null)
        {
            break MISSING_BLOCK_LABEL_382;
        }
        mVideoPlayerControlsView.hideControls();
        ((Handler) (obj)).post(new Runnable() {

            final VideoPlayerActivity this$0;

            public void run()
            {
                Log.d(TAG, (new StringBuilder()).append(TAG).append("runMidRoll").toString());
                mMenuItemPlayOn.setVisible(false);
                try
                {
                    LivePass.pauseMonitor(VideoPlayerActivity.mConvivaSessionID);
                }
                catch (Exception exception1) { }
                mVideoPlayerControlsView.stopPlayback(false);
                mSystemUiHider.hide();
                adContext.setVideoState(adContext.getConstants().VIDEO_STATE_PAUSED());
                mNetworkID.setVisibility(4);
                mVideoHelper.setVisibility(8);
                mCaptionWindow.setText("");
                mAdIsPlaying = true;
                mCurrentAdSlot.play();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        return true;
        Exception exception;
        exception;
        return false;
        return false;
    }

    private void delayedHide(int i)
    {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, i);
    }

    private void findNextFeaturedMovieToPlay(final MediaDetailsItem parentChannelID)
    {
        parentChannelID = parentChannelID.getParentChannelID();
        final ItemsListRequest req = new ItemsListRequest();
        req.start(new com.gotv.crackle.data.DataRequest.DataRequestListener() {

            final VideoPlayerActivity this$0;
            final String val$parentChannelID;
            final ItemsListRequest val$req;

            public void onDataFailed(String s, String s1)
            {
                Log.w(TAG, "Failed to get featured movie list for auto-play");
            }

            public void onDataSuccess(String s)
            {
                s = null;
                boolean flag = false;
                Iterator iterator = req.getItems().iterator();
                do
                {
                    String s1;
                    BrowseModel browsemodel;
label0:
                    {
                        s1 = s;
                        if (iterator.hasNext())
                        {
                            browsemodel = (BrowseModel)iterator.next();
                            s1 = s;
                            if (s == null)
                            {
                                s1 = s;
                                if (!browsemodel.getID().equals(parentChannelID))
                                {
                                    s1 = browsemodel.getID();
                                }
                            }
                            if (!flag)
                            {
                                break label0;
                            }
                            s1 = browsemodel.getID();
                        }
                        if (s1 != null)
                        {
                            s = new DetailsProvider();
                            s.getDataWithChannelId(s. new com.gotv.crackle.data.DataRequest.DataRequestListener() {

                                final _cls23 this$1;
                                final DetailsProvider val$detailsProvider;

                                public void onDataFailed(String s, String s1)
                                {
                                    Log.w(TAG, "Failed to get channel details loading next featured movie");
                                }

                                public void onDataSuccess(String s)
                                {
                                    mNextMediaIdToPlay = detailsProvider.getMediaId();
                                }

            
            {
                this$1 = final__pcls23;
                detailsProvider = DetailsProvider.this;
                super();
            }
                            }, s1);
                        }
                        return;
                    }
                    s = s1;
                    if (browsemodel.getID().equals(parentChannelID))
                    {
                        flag = true;
                        s = null;
                    }
                } while (true);
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                req = itemslistrequest;
                parentChannelID = s;
                super();
            }
        }, com.gotv.crackle.data.ItemsListRequest.ItemsListType.Featured, "all", 4);
    }

    private void findNextMediaToPlay(final MediaDetailsItem mediaItem)
    {
        String s = mediaItem.getParentChannelID();
        if (s != null && s.length() > 0)
        {
            final DetailsProvider detailsProvider = new DetailsProvider();
            detailsProvider.getDataWithChannelId(new com.gotv.crackle.data.DataRequest.DataRequestListener() {

                final VideoPlayerActivity this$0;
                final DetailsProvider val$detailsProvider;
                final MediaDetailsItem val$mediaItem;

                public void onDataFailed(String s1, String s2)
                {
                    Log.w(TAG, "Failed to get channel data to load next media in playlist");
                }

                public void onDataSuccess(String s1)
                {
                    mNextMediaIdToPlay = detailsProvider.getNextMediaIdAfter(mMediaID);
                    if (mNextMediaIdToPlay == null && mediaItem.getRootChannel().equalsIgnoreCase("movies"))
                    {
                        findNextFeaturedMovieToPlay(mediaItem);
                    }
                }

            
            {
                this$0 = VideoPlayerActivity.this;
                detailsProvider = detailsprovider;
                mediaItem = mediadetailsitem;
                super();
            }
            }, s);
        }
    }

    private void findVideoView()
    {
        if (mVideoHelper == null)
        {
            mVideoHelper = CrackleVideoHelper.getInstance();
        }
        if (Application.isFanhattan())
        {
            mVideoHelper.fanhattanVideoView = (FanhattanVideoView)findViewById(0x7f0a019d);
            return;
        } else
        {
            mVideoHelper.crackleVideoView = (CrackleVideoView)findViewById(0x7f0a019d);
            return;
        }
    }

    private String formatDataSent()
    {
        control = getIntent().getStringExtra("CONTROL");
        Object obj = getIntent().getStringExtra("SEEKTO");
        Integer integer;
        if (obj != null && !"".equals(obj))
        {
            obj = Integer.valueOf(Integer.parseInt(getIntent().getStringExtra("SEEKTO")));
        } else
        {
            obj = Integer.valueOf(mVideoHelper.getCurrentPosition());
        }
        integer = ((Integer) (obj));
        if (((Integer) (obj)).intValue() > 0)
        {
            integer = Integer.valueOf(((Integer) (obj)).intValue() / 1000);
        }
        Log.w(TAG, (new StringBuilder()).append(mMediaID).append(" | ").append(integer.toString()).toString());
        try
        {
            obj = URLEncoder.encode((new StringBuilder()).append("{\"contentid\":\"").append(mMediaID).append("\",\"resume\":\"").append(integer.toString()).append("\"}").toString(), "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return "";
        }
        return ((String) (obj));
    }

    private String getChannelInfoForNielsen()
    {
        return (new StringBuilder()).append("{ \"channelName\" : \"").append(getPlayingMedia().getShowName()).append("\" }").toString();
    }

    private String getMetadataInfoForNielsen()
    {
        String s = (new StringBuilder()).append("{\"type\" : \"content\",\"assetid\":\"").append(getPlayingMedia().getID()).append("\", ").append("\"tv\" : \"true\",").append("\"title\":\"").append(getPlayingMedia().getTitle()).append("\", ").append("\"dataSrc\" : \"cms\",").append("\"category\":\"").append(getPlayingMedia().getRootChannel()).append("\", ").toString();
        return (new StringBuilder()).append(s).append("\"length\":\"").append(getPlayingMedia().getDurationInSeconds()).append("\"").append("}").toString();
    }

    private void hideSearchingProgressBar()
    {
        ProgressBar progressbar = (ProgressBar)mDeviceListlayout.findViewById(0x7f0a00d6);
        TextView textview = (TextView)mDeviceListlayout.findViewById(0x7f0a00d7);
        textview.setText(0x7f0b00e9);
        if (mDeviceListAdapter.getCount() > 0)
        {
            progressbar.setVisibility(8);
            textview.setVisibility(8);
            return;
        } else
        {
            progressbar.setVisibility(0);
            textview.setVisibility(0);
            return;
        }
    }

    private void initDeviceAdapter(List list)
    {
        mDeviceListAdapter = new DeviceListAdapter(this, 0x7f030042, list);
        mDeviceListAdapter.clear();
        mDeviceListAdapter.setNotifyOnChange(true);
        mDeviceListView.setAdapter(mDeviceListAdapter);
        mDeviceListView.setChoiceMode(1);
        mDeviceListView.setItemsCanFocus(true);
        mDeviceListView.setClickable(true);
        mDeviceListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final VideoPlayerActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                mSelectedDevice = mDeviceListAdapter.getItem(i);
                mDeviceListAdapter.setCurIndex(i);
                mDeviceListAdapter.notifyDataSetChanged();
                mAlertDeviceList.getButton(-1).setEnabled(true);
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
    }

    private void onAdPause(IEvent ievent)
    {
        Log.d("comscore", (new StringBuilder()).append("EVENT_AD_PAUSE: ").append(mCurrentAdSlot.getPlayheadTime()).toString());
        if (mComscoreTracker != null)
        {
            mComscoreTracker.trackPause(mCurrentAdSlot);
        }
    }

    private void onAdResume(IEvent ievent)
    {
        Log.d("comscore", (new StringBuilder()).append("EVENT_AD_RESUME: ").append(mCurrentAdSlot.getPlayheadTime()).toString());
        if (mComscoreTracker != null)
        {
            mComscoreTracker.trackAdResume();
        }
    }

    private void onCompletion()
    {
        Log.d(TAG, (new StringBuilder()).append(TAG).append("onCompletion").toString());
        finish();
        if (mNextMediaIdToPlay != null)
        {
            (new Handler()).postDelayed(new Runnable() {

                final VideoPlayerActivity this$0;

                public void run()
                {
                    BaseActivity.mAccountManager.setItemProgress(mNextMediaIdToPlay, 0, null);
                    playMediaItem(mNextMediaIdToPlay);
                    mNextMediaIdToPlay = null;
                }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
            }, 100L);
            return;
        } else
        {
            control = getIntent().getStringExtra("CONTROL");
            backToYosemite(control);
            return;
        }
    }

    private void onYosemiteTimeout()
    {
        timeoutHandler.postDelayed(new Runnable() {

            final VideoPlayerActivity this$0;

            public void run()
            {
label0:
                {
label1:
                    {
                        if (SmartTV.getInstance().getDeviceList() != null && SmartTV.getInstance().getDeviceList().size() <= 0)
                        {
                            if (android.os.Build.VERSION.SDK_INT < 17)
                            {
                                break label0;
                            }
                            mDisplayManager = (DisplayManager)getSystemService("display");
                            Display adisplay[] = mDisplayManager.getDisplays();
                            ArrayList arraylist = new ArrayList();
                            int j = adisplay.length;
                            for (int i = 0; i < j; i++)
                            {
                                Display display = adisplay[i];
                                if (display.getDisplayId() != 0)
                                {
                                    arraylist.add(display);
                                }
                            }

                            adisplay = (Display[])arraylist.toArray(new Display[arraylist.size()]);
                            if (adisplay.length <= 0)
                            {
                                break label1;
                            }
                            ((ProgressBar)mDeviceListlayout.findViewById(0x7f0a00d6)).setVisibility(8);
                            ((TextView)mDeviceListlayout.findViewById(0x7f0a00d7)).setVisibility(8);
                            mDisplayListAdapter = new DisplayListAdapter(VideoPlayerActivity.this, adisplay);
                            mDeviceListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final _cls41 this$1;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    adapterview = (Display)mDisplayListAdapter.getItem(i);
                                    mDisplayListAdapter.setCurIndex(i);
                                    mDisplayListAdapter.notifyDataSetChanged();
                                    mDeviceListView.setAdapter(null);
                                    mDeviceListView.setAdapter(mDisplayListAdapter);
                                    mAlertDeviceList.getButton(-1).setEnabled(true);
                                    mAlertDeviceList.getButton(-1).setOnClickListener(adapterview. new android.view.View.OnClickListener() {

                                        final _cls1 this$2;
                                        final Display val$display;

                                        public void onClick(View view)
                                        {
                                            saveTime(mVideoHelper.getCurrentPosition(), "Transfer to TV");
                                            mVideoHelper.setVisibility(8);
                                            mPresentation = new RemotePresentation(_fld0, display);
                                            mPresentation.show();
                                            mAlertDeviceList.dismiss();
                                        }

            
            {
                this$2 = final__pcls1;
                display = Display.this;
                super();
            }
                                    });
                                }

            
            {
                this$1 = _cls41.this;
                super();
            }
                            });
                            mDeviceListView.setAdapter(mDisplayListAdapter);
                        }
                        return;
                    }
                    mDeviceListView.setAdapter(null);
                    ((ProgressBar)mDeviceListlayout.findViewById(0x7f0a00d6)).setVisibility(8);
                    TextView textview = (TextView)mDeviceListlayout.findViewById(0x7f0a00d7);
                    textview.setText(0x7f0b00ea);
                    textview.setVisibility(0);
                    return;
                }
                mDeviceListView.setAdapter(null);
                ((ProgressBar)mDeviceListlayout.findViewById(0x7f0a00d6)).setVisibility(8);
                TextView textview1 = (TextView)mDeviceListlayout.findViewById(0x7f0a00d7);
                textview1.setText(0x7f0b00ea);
                textview1.setVisibility(0);
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        }, 5000L);
    }

    private void playBumperIfExists()
    {
        final MediaDetailsItem item = mVideoDubSubtitleProcessor.getCurrentItem();
        if (item.getSplashVideoUrl() != null && !item.getSplashVideoUrl().isEmpty() && !item.getSplashVideoUrl().equalsIgnoreCase("null"))
        {
            mBumperIsRunning = true;
            runOnUiThread(new Runnable() {

                final VideoPlayerActivity this$0;

                public void run()
                {
                    adContext.setVideoState(adContext.getConstants().VIDEO_STATE_PLAYING());
                    mVideoHelper.setVisibility(0);
                    mVideoPlayerControlsView.stopPlayback(true);
                    mVideoPlayerControlsView.stopBufferingDetector();
                    System.gc();
                }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
            });
            (new Handler()).postDelayed(new Runnable() {

                final VideoPlayerActivity this$0;
                final MediaDetailsItem val$item;

                public void run()
                {
                    mVideoHelper.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                        final _cls28 this$1;

                        public void onCompletion(MediaPlayer mediaplayer)
                        {
                            mVideoPlayerControlsView.stopBufferingDetector();
                            mVideoPlayerControlsView.stopPlayback(true);
                            mMidrollHandler.start();
                            playFromLastPosition();
                            mBumperIsRunning = false;
                        }

            
            {
                this$1 = _cls28.this;
                super();
            }
                    });
                    mVideoPlayerControlsView.playVideo(item.getSplashVideoUrl(), 0);
                    mVideoPlayerControlsView.hideControls();
                }

            
            {
                this$0 = VideoPlayerActivity.this;
                item = mediadetailsitem;
                super();
            }
            }, 3000L);
            return;
        } else
        {
            mMidrollHandler.start();
            playFromLastPosition();
            return;
        }
    }

    private void playFromLastPosition()
    {
        runOnUiThread(new Runnable() );
        (new Handler()).postDelayed(new Runnable() {

            final VideoPlayerActivity this$0;

            public void run()
            {
                if (VideoPlayerActivity.mConvivaSessionID < 0)
                {
                    Log.d("CONVIVA", (new StringBuilder()).append("SESSIONID = ").append(VideoPlayerActivity.mConvivaSessionID).toString());
                    VideoPlayerActivity.mConvivaMediaDetailsItem = mVideoDubSubtitleProcessor.getCurrentItem();
                    VideoPlayerActivity.mConvivaMediaUrl = mVideoUrl;
                    if (mVideoHelper.getCurrentPosition() == 0);
                }
                int i = SharedPrefsManager.getPlayProgressForItem(mMediaID);
                mComscoreTracker.setTimeRecentlyObserved(i);
                mComscoreTracker.setClipToMediaItem();
                mVideoPlayerControlsView.playVideo(mVideoUrl, mDurationInSeconds);
                Log.v(TAG, (new StringBuilder()).append(TAG).append("Resume to ").append(i).toString());
                if (i > 0)
                {
                    mVideoPlayerControlsView.seekTo(i);
                }
                if (!Application.isLeanBack())
                {
                    mMenuItemPlayOn.setVisible(true);
                }
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        }, 3000L);
    }

    private void playResume()
    {
        runOnUiThread(new Runnable() );
    }

    private void prepareMidRoll()
    {
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist = adContext.getSlotsByTimePositionClass(adContext.getConstants().TIME_POSITION_CLASS_MIDROLL());
        Integer integer;
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); arraylist1.add(integer))
        {
            ISlot islot = (ISlot)iterator.next();
            integer = Integer.valueOf((int)Math.round(islot.getTimePosition()));
            mMidrolls.put(integer, islot.getCustomId());
            mMidrollKeys.add(integer);
        }

        Integer integer1;
        for (Iterator iterator1 = adContext.getSlotsByTimePositionClass(adContext.getConstants().TIME_POSITION_CLASS_OVERLAY()).iterator(); iterator1.hasNext(); arraylist1.add(integer1))
        {
            ISlot islot1 = (ISlot)iterator1.next();
            integer1 = Integer.valueOf((int)Math.round(islot1.getTimePosition()));
            mMidrolls.put(integer1, islot1.getCustomId());
            mMidrollKeys.add(integer1);
        }

        ArrayList arraylist2 = adContext.getSlotsByTimePositionClass(adContext.getConstants().TIME_POSITION_CLASS_PREROLL());
        for (Iterator iterator2 = arraylist2.iterator(); iterator2.hasNext();)
        {
            mPrerollAdSlot = (ISlot)iterator2.next();
        }

        Collections.sort(mMidrollKeys);
        mMidRollSeekBar.setMidRollKeys(arraylist1, mDurationInSeconds);
        arraylist1 = adContext.getSlotsByTimePositionClass(adContext.getConstants().TIME_POSITION_CLASS_POSTROLL());
        mComscoreTracker.setSlots(arraylist2, arraylist, arraylist1);
        if (mPrerollAdSlot != null && !mLoadingFromSession && "true".compareToIgnoreCase(mResume) != 0)
        {
            mPrerollRunning = true;
            (new Handler(getMainLooper())).post(new Runnable() {

                final VideoPlayerActivity this$0;

                public void run()
                {
                    mMenuItemPlayOn.setVisible(false);
                    Log.d(TAG, (new StringBuilder()).append(TAG).append("runPreRoll").toString());
                    mVideoPlayerControlsView.hideControls();
                    mNetworkID.setVisibility(4);
                    mVideoHelper.setVisibility(8);
                    mPrerollAdSlot.play();
                    mCurrentAdSlot = mPrerollAdSlot;
                }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
            });
            return;
        }
        if (!mLoadingFromSession && "true".compareToIgnoreCase(mResume) != 0)
        {
            playBumperIfExists();
            return;
        } else
        {
            mMidrollHandler.start();
            playFromLastPosition();
            return;
        }
    }

    private void saveTime(int i, String s)
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append("Time: saved as ").append(i).append(" : ").append(s).toString());
        mAccountManager.setItemProgress(mMediaID, i, mThumbnailUrl);
    }

    private void setVisibilityNoDeviceMessage(List list)
    {
        if (list == null)
        {
            mNoDeviceMessageBlock.setVisibility(0);
        } else
        if (!list.isEmpty())
        {
            mNoDeviceMessageBlock.setVisibility(4);
            return;
        }
    }

    private void showDeviceList(List list)
    {
        mNoDeviceMessageBlock = (RelativeLayout)findViewById(0x7f0a01a4);
        mDeviceListlayout = (LinearLayout)LayoutInflater.from(this).inflate(0x7f030043, null);
        mDeviceListView = (ListView)mDeviceListlayout.findViewById(0x7f0a00d5);
        android.app.AlertDialog.Builder builder = new Builder(this);
        builder.setTitle(0x7f0b00dd);
        initDeviceAdapter(list);
        builder.setView(mDeviceListlayout);
        builder.setPositiveButton(0x7f0b00e0, new android.content.DialogInterface.OnClickListener() {

            final VideoPlayerActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                SmartTV.getInstance().stopDiscovery();
                i = mDeviceListAdapter.getCurIndex();
                if (i >= 0 && i < mDeviceListAdapter.getCount())
                {
                    SmartTV.getInstance().connectToTV(mDeviceListAdapter.getCurIndex(), formatDataSent());
                    finish();
                } else
                {
                    showMessageDialog(getString(0x7f0b00de));
                }
                if (!mVideoHelper.isPlaying())
                {
                    mVideoHelper.start();
                    mVideoPlayerControlsView.updatePausePlayButton();
                    adContext.setVideoState(adContext.getConstants().VIDEO_STATE_PLAYING());
                    adContext.setActivityState(adContext.getConstants().ACTIVITY_STATE_RESUME());
                }
                mDeviceListAdapter.unselectItem();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        builder.setNegativeButton(0x7f0b00ce, new android.content.DialogInterface.OnClickListener() {

            final VideoPlayerActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                SmartTV.getInstance().stopDiscovery();
                if (!mVideoHelper.isPlaying())
                {
                    mVideoHelper.start();
                    mVideoPlayerControlsView.updatePausePlayButton();
                    adContext.setVideoState(adContext.getConstants().VIDEO_STATE_PLAYING());
                    adContext.setActivityState(adContext.getConstants().ACTIVITY_STATE_RESUME());
                }
                mDeviceListAdapter.unselectItem();
                mAlertDeviceList.cancel();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        mAlertDeviceList = builder.create();
        mAlertDeviceList.show();
        mAlertDeviceList.getButton(-1).setEnabled(false);
    }

    private void showLowBandwidthDialog()
    {
        mVideoPlayerControlsView.pausePlayback(false);
        mLowBandwidthDialog = (new android.app.AlertDialog.Builder(this)).setIcon(0x1080027).setMessage(getResources().getString(0x7f0b00b8)).setNegativeButton(getResources().getString(0x7f0b00b2), new android.content.DialogInterface.OnClickListener() {

            final VideoPlayerActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                try
                {
                    mVideoPlayerControlsView.pausePlayback(false);
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface) { }
                mLowBandwidthDialog.dismiss();
                finish();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        }).create();
        mLowBandwidthDialog.show();
    }

    private void showMessageDialog(String s)
    {
        if (!isFinishing())
        {
            if (s.contains("send data"))
            {
                mIsSendData = true;
            }
            if (mAlertMessageDialog == null)
            {
                mAlertMessageDialog = buildMessageDialog();
            }
            mAlertMessageDialog.setMessage(s);
            mAlertMessageDialog.show();
        }
    }

    private void showResumeDialog()
    {
        mResumeDialog = (new android.app.AlertDialog.Builder(this)).setIcon(0x1080027).setMessage(getResources().getString(0x7f0b00ba)).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final VideoPlayerActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                finish();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        }).setNegativeButton(getResources().getString(0x7f0b00bb), new android.content.DialogInterface.OnClickListener() {

            final VideoPlayerActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                mResumeDialog.dismiss();
                i = SharedPrefsManager.getPlayProgressForItem(mMediaID);
                mLastAdTimeCode = i / 1000;
                mResume = "true";
                if ((double)mLastAdTimeCode > (double)mDurationInSeconds * 0.25D)
                {
                    mPassed25 = true;
                }
                if ((double)mLastAdTimeCode > (double)mDurationInSeconds * 0.5D)
                {
                    mPassed50 = true;
                }
                if ((double)mLastAdTimeCode > (double)mDurationInSeconds * 0.75D)
                {
                    mPassed75 = true;
                }
                prepareMidRoll();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        }).setPositiveButton(getResources().getString(0x7f0b00bc), new android.content.DialogInterface.OnClickListener() {

            final VideoPlayerActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                mVideoDubSubtitleProcessor.getCurrentItem();
                mShouldReportVideoStart = true;
                mResumeDialog.dismiss();
                saveTime(0, "START_OVER");
                prepareMidRoll();
                mResume = "false";
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        }).create();
        mResumeDialog.setCancelable(true);
        mResumeDialog.show();
    }

    private void startPlayer()
    {
        if (mVideoDubSubtitleProcessor.getCurrentItem().getRootChannelID().compareTo("82") == 0)
        {
            mAdFetcher.loadAd(ApplicationConstants.getFreeWheelMoviesSiteSection());
            return;
        }
        if (mVideoDubSubtitleProcessor.getCurrentItem().getRootChannelID().compareTo("82") == 0 || mVideoDubSubtitleProcessor.getCurrentItem().getRootChannelID().compareTo("114") == 0 || mVideoDubSubtitleProcessor.getCurrentItem().getRootChannelID().compareTo("46") == 0)
        {
            mAdFetcher.loadAd(ApplicationConstants.getFreeWheelShowsSiteSection());
            return;
        } else
        {
            mAdFetcher.loadAd();
            return;
        }
    }

    private void switchBacktoDefaultScreen()
    {
        mPresentation.dismiss();
        isOnTV = false;
        if (mNetworkID != null)
        {
            mNetworkID.setVisibility(8);
        }
        mToTvBackground.setVisibility(8);
        findVideoView();
        mNetworkID = findViewById(0x7f0a019e);
        adContext.registerVideoDisplayBase(mVideoFrame);
        mVideoPlayerControlsView.init(mVideoHelper, mProgressView);
        playFromLastPosition();
    }

    private void updateCaptionSettings()
    {
        Object obj = null;
        if (mVideoDubSubtitleProcessor != null)
        {
            obj = mVideoDubSubtitleProcessor.getCurrentItem();
        }
        obj = CaptionSettings.getCaptionSettingsForMediaDetails(((MediaDetailsItem) (obj)));
        mCaptionWindow.setCaptionSettings(((CaptionSettings) (obj)));
    }

    private void updateSubtTitles(double d)
    {
        if (!mVideoHelper.isPlaying()) goto _L2; else goto _L1
_L1:
        MediaDetailsItem mediadetailsitem;
        int i;
        mediadetailsitem = mVideoDubSubtitleProcessor.getCurrentItem();
        i = (int)(d / 1000D);
        if (i <= mDurationInSeconds - 3 || mPassedCompletion) goto _L4; else goto _L3
_L3:
        mPassedCompletion = true;
        if (!mChromeCastHelper.isConnected())
        {
            mVideoHelper.pause();
        }
        onCompletion();
_L6:
        return;
_L4:
        if ((double)i > (double)mDurationInSeconds * 0.25D && !mPassed25)
        {
            mPassed25 = true;
            mLastOmnitureReportTimeInSeconds = Application.getInstance().getOmnitureTracker().onVideo25Percent(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", mSubTitleSelected, mediadetailsitem.getDuration(), mTimePlayingCounter, mLastOmnitureReportTimeInSeconds);
        }
        if ((double)i > (double)mDurationInSeconds * 0.5D && !mPassed50)
        {
            mPassed50 = true;
            mLastOmnitureReportTimeInSeconds = Application.getInstance().getOmnitureTracker().onVideo50Percent(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", mSubTitleSelected, mediadetailsitem.getDuration(), mTimePlayingCounter, mLastOmnitureReportTimeInSeconds);
        }
        if ((double)i > (double)mDurationInSeconds * 0.75D && !mPassed75)
        {
            mPassed75 = true;
            mLastOmnitureReportTimeInSeconds = Application.getInstance().getOmnitureTracker().onVideo75Percent(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", mSubTitleSelected, mediadetailsitem.getDuration(), mTimePlayingCounter, mLastOmnitureReportTimeInSeconds);
            Iterator iterator;
            SubtitleTimeCode subtitletimecode;
            if (mVideoDubSubtitleProcessor.getCurrentItem().getRootChannelID().compareTo("82") == 0)
            {
                SessionM.getInstance().logAction("completeMovie");
            } else
            {
                SessionM.getInstance().logAction("completeShow");
            }
            if (!SharedPrefsManager.getWatchedFirstVideoToCompletion())
            {
                SharedPrefsManager.setWatchedFirstVideoToCompletion(true);
                Application.getInstance().getHasOffersTracking().measureAction("75completion");
            }
        }
        if ((double)i > (double)mDurationInSeconds * 0.94999999999999996D && !mPassed95)
        {
            mPassed95 = true;
            mLastOmnitureReportTimeInSeconds = Application.getInstance().getOmnitureTracker().onVideoComplete(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", mSubTitleSelected, mediadetailsitem.getDuration(), mTimePlayingCounter, mLastOmnitureReportTimeInSeconds);
        }
_L2:
        if (mSubtitleTimeCodes != null)
        {
            String s = null;
            iterator = mSubtitleTimeCodes.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                subtitletimecode = (SubtitleTimeCode)iterator.next();
                if (d <= subtitletimecode.timeStart)
                {
                    break;
                }
                s = subtitletimecode.text;
                if (d > subtitletimecode.timeEnd)
                {
                    s = "";
                }
            } while (true);
            if (s != null)
            {
                mCaptionWindow.setText(Html.fromHtml(s));
                return;
            }
        } else
        {
            mCaptionWindow.setText("");
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void backToYosemite(String s)
    {
        if ("START_BY_YOSEMITE".equals(s))
        {
            s = new Intent();
            s.setClassName("com.example.pocvideoplayer", "com.example.pocvideoplayer.MainActivity");
            startActivity(s);
            finish();
        }
    }

    public void beforeSubmitRequest(String s)
    {
        adContext.setVideoAsset(getVideoAssetId(), getVideoDurationInSec(), null, true, 0, 0, 0, 0);
        adContext.addEventListener(adContext.getConstants().EVENT_AD_IMPRESSION(), new IEventListener() {

            final VideoPlayerActivity this$0;

            public void run(IEvent ievent)
            {
                onAdStarted(ievent);
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        adContext.addEventListener(adContext.getConstants().EVENT_AD_PAUSE(), new IEventListener() {

            final VideoPlayerActivity this$0;

            public void run(IEvent ievent)
            {
                onAdPause(ievent);
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        adContext.addEventListener(adContext.getConstants().EVENT_AD_RESUME(), new IEventListener() {

            final VideoPlayerActivity this$0;

            public void run(IEvent ievent)
            {
                onAdResume(ievent);
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        adContext.addEventListener(adContext.getConstants().EVENT_SLOT_ENDED(), new IEventListener() {

            final VideoPlayerActivity this$0;

            public void run(IEvent ievent)
            {
                onSlotEnded(ievent);
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        adContext.addEventListener(adContext.getConstants().EVENT_REQUEST_CONTENT_VIDEO_PAUSE(), new IEventListener() {

            final VideoPlayerActivity this$0;

            public void run(IEvent ievent)
            {
                onRequestContentVideoPause(ievent);
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        adContext.addEventListener(adContext.getConstants().EVENT_REQUEST_CONTENT_VIDEO_RESUME(), new IEventListener() {

            final VideoPlayerActivity this$0;

            public void run(IEvent ievent)
            {
                onRequestContentVideoResume(ievent);
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        adContext.addSiteSectionNonTemporalSlot("234x60", null, 234, 60, null, true, null, null);
        adContext.registerVideoDisplayBase(mVideoFrame);
    }

    public boolean checkConnectivity()
    {
        boolean flag = false;
        ConnectivityManager connectivitymanager = (ConnectivityManager)getSystemService("connectivity");
        if (connectivitymanager.getNetworkInfo(1).isConnected() || connectivitymanager.getNetworkInfo(0).isConnected())
        {
            flag = true;
        }
        return flag;
    }

    public ContextualMenu createContextualMenu()
    {
        ContextualMenu contextualmenu = new ContextualMenu(getPackageName());
        ContextualMenuSection contextualmenusection = new ContextualMenuSection(getString(0x7f0b002d));
        contextualmenusection.add(new ContextualMenuItem("FAN_ID_SUBTITLES", getString(0x7f0b012d)));
        contextualmenu.add(contextualmenusection);
        return contextualmenu;
    }

    public void forwardToFlashPlayer()
    {
        SharedPrefsManager.setSupportsHLS(false);
        Intent intent = new Intent(this, com/gotv/crackle/VideoPlayerActivityFlash);
        intent.putExtra("MEDIA_ID", mMediaID);
        if (mResume != null)
        {
            intent.putExtra("RESUME_EXTRA", mResume);
        }
        startActivity(intent);
        finish();
    }

    public Activity getBaseActivity()
    {
        return this;
    }

    public int getCurrentPosition()
    {
        return mVideoHelper.getCurrentPosition();
    }

    public MediaDetailsItem getPlayingMedia()
    {
        return mVideoDubSubtitleProcessor.getCurrentItem();
    }

    public String getVideoAssetId()
    {
        return mMediaID;
    }

    public int getVideoDurationInSec()
    {
        return mDurationInSeconds;
    }

    public String getVideoTitle()
    {
        return null;
    }

    public void onAdContextCreated(IAdContext iadcontext)
    {
        adContext = iadcontext;
    }

    public void onAdManagerLoadFailed()
    {
        runOnUiThread(new Runnable() {

            final VideoPlayerActivity this$0;

            public void run()
            {
                Toast.makeText(getBaseContext(), getString(0x7f0b0142), 1).show();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
    }

    public void onAdStarted(IEvent ievent)
    {
        MediaDetailsItem mediadetailsitem = mVideoDubSubtitleProcessor.getCurrentItem();
        String s1 = (String)ievent.getData().get(adContext.getConstants().INFO_KEY_CUSTOM_ID());
        String s = s1;
        if (s1 == null)
        {
            s = "";
        }
        mAdPodIndex = mAdPodIndex + 1;
        mLastOmnitureReportTimeInSeconds = Application.getInstance().getOmnitureTracker().onAdStart(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", mSubTitleSelected, mediadetailsitem.getDuration(), mTimePlayingCounter, mLastOmnitureReportTimeInSeconds, mAdPodNumber, mAdPodIndex, s);
        ievent = (Integer)ievent.getData().get(adContext.getConstants().INFO_KEY_AD_ID());
        if (ievent != null)
        {
            mComscoreTracker.setClipToAdInstance(s, ievent.intValue());
        }
    }

    public void onAppSdkEvent(long l, int i, String s)
    {
    }

    public void onBackPressed()
    {
        stopMHandler();
        control = getIntent().getStringExtra("CONTROL");
        backToYosemite(control);
        super.onBackPressed();
    }

    public void onCloseContextualMenu()
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        Log.v(TAG, (new StringBuilder()).append(TAG).append("                   onConfigChange").toString());
    }

    public boolean onContextualMenuSelected(String s)
    {
        if ("FAN_ID_SUBTITLES".equals(s))
        {
            performMenuAction(0x7f0a0006);
            return true;
        } else
        {
            return false;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.v(TAG, (new StringBuilder()).append(TAG).append("onCreate").toString());
        mConvivaSessionID = -1;
        requestWindowFeature(9);
        mBumperIsRunning = false;
        if (Application.isLeanBack())
        {
            getWindow().setBackgroundDrawableResource(0x7f020132);
            mRootView = findViewById(0x1020002);
            mRootView.setBackgroundColor(getResources().getColor(0x7f07001a));
        }
        int i;
        if (Application.isFanhattan())
        {
            i = 0x7f03007c;
        } else
        {
            i = 0x7f03007b;
        }
        setContentView(i);
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            getWindow().setFlags(1024, 1024);
        }
        mVideoErrorDialog = (new android.app.AlertDialog.Builder(this)).setIcon(0x1080027).setMessage(getResources().getString(0x7f0b0141)).setNegativeButton(getResources().getString(0x7f0b00b2), new android.content.DialogInterface.OnClickListener() {

            final VideoPlayerActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface.dismiss();
                finish();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        }).create();
        mVideoErrorDialog.setCancelable(false);
        try
        {
            LivePass.init("d8cfa9b855476b04fa2d1dfa7c9154c09b55f9ca", this);
            LivePass.toggleTraces(true);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            try
            {
                mDrm = new WidevineDrm(this);
                mDrm.registerPortal("crackle");
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                mDrm = null;
            }
        }
        addActionBar();
        findVideoView();
        if (Application.isFanhattan())
        {
            mContextualMenuService = new ContextualMenuService(this, this);
        }
        bundle = findViewById(0x7f0a010d);
        if (Application.isLeanBack())
        {
            bundle.setPadding(Application.dpToPx(30), bundle.getPaddingTop(), Application.dpToPx(30), bundle.getPaddingBottom() + Application.dpToPx(20));
        }
        mVideoHelper.setOnErrorListener(mErrorListener);
        mNetworkID = findViewById(0x7f0a019e);
        mProgressView = findViewById(0x7f0a019f);
        mToTvBackground = findViewById(0x7f0a019b);
        mVideoPlayerControlsView = (MediaControllerView)findViewById(0x7f0a010b);
        mVideoPlayerControlsView.init(mVideoHelper, mProgressView);
        mSeekIndicatorContainer = findViewById(0x7f0a010c);
        mSeekIndicatorFragment = (SeekIndicatorFragment)getSupportFragmentManager().findFragmentById(0x7f0a010e);
        mVideoBase = (RelativeLayout)findViewById(0x7f0a019a);
        mVideoBase.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoPlayerActivity this$0;

            public void onClick(View view)
            {
                mSystemUiHider.toggle();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        mVideoFrame = (FrameLayout)findViewById(0x7f0a019c);
        mVideoFrame.setOnTouchListener(new android.view.View.OnTouchListener() {

            final VideoPlayerActivity this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        mSystemUiHider = SystemUiHider.getInstance(this, mVideoBase, 6);
        mSystemUiHider.setup();
        mSystemUiHider.setOnVisibilityChangeListener(new com.google.util.SystemUiHider.OnVisibilityChangeListener() {

            final VideoPlayerActivity this$0;

            public void onVisibilityChange(boolean flag)
            {
                if (flag)
                {
                    mActionBar.show();
                    if (!mVideoPlayerControlsView.isShowing() && !mBumperIsRunning)
                    {
                        mVideoPlayerControlsView.showControls();
                    }
                    delayedHide(6000);
                    return;
                } else
                {
                    mNextPosition = -1;
                    mVideoPlayerControlsView.setSecondaryProgress(0);
                    mActionBar.hide();
                    mVideoPlayerControlsView.hideControls();
                    return;
                }
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        delayedHide(2000);
        if (Application.isDualScreenDevice())
        {
            ((android.widget.LinearLayout.LayoutParams)mVideoBase.getLayoutParams()).height = 480;
        }
        mSystemUiHider.hide();
        mVideoHelper.setOnTouchListener(new android.view.View.OnTouchListener() {

            final VideoPlayerActivity this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                mSystemUiHider.show();
                return false;
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        mMediaID = getIntent().getStringExtra("MEDIA_ID");
        mMidRollSeekBar = (MidRollSeekBar)findViewById(0x7f0a009e);
        mVideoPlayerControlsView.setControllerListener(new com.gotv.crackle.views.MediaControllerView.ControllerListener() );
        mVideoHelper.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            final VideoPlayerActivity this$0;

            public void onCompletion(MediaPlayer mediaplayer)
            {
                VideoPlayerActivity.this.onCompletion();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        });
        mCaptionWindow = (CaptionWindow)findViewById(0x7f0a01a0);
        updateCaptionSettings();
        mAdFetcher = new AdFetcher(this);
        mSubTitleHandler.sendEmptyMessageDelayed(2000, 100L);
        mAlertMessageDialog = buildMessageDialog();
        SmartTV.getInstance().addSmartTVListener(this);
        if (SharedPrefsManager.getWifiOnlyEnabled())
        {
            bundle = new IntentFilter();
            bundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(new BroadcastReceiver() {

                final VideoPlayerActivity this$0;

                public void onReceive(Context context, Intent intent)
                {
                    if (!((ConnectivityManager)getSystemService("connectivity")).getNetworkInfo(1).isConnected() && SharedPrefsManager.getWifiOnlyEnabled())
                    {
                        if (mVideoHelper.isPlaying())
                        {
                            mVideoPlayerControlsView.pausePlayback(false);
                        }
                        showDialogFragment(0xcb51c);
                    }
                }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
            }, bundle);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0f0007, menu);
        mMenuItemUnpost = menu.findItem(0x7f0a01c6);
        mMenuItemUnpost.setVisible(false);
        mMenuItemBuy = menu.findItem(0x7f0a01c9);
        if (mAmazonLink != null) goto _L2; else goto _L1
_L1:
        mMenuItemBuy.setVisible(false);
_L4:
        mMenuItemPlayOn = menu.findItem(0x7f0a01ca);
        mMenuItemPlayOn.setVisible(false);
        MenuItem menuitem = menu.findItem(0x7f0a01c8);
        MenuItem menuitem1 = menu.findItem(0x7f0a01c7);
        if (Application.isLeanBack())
        {
            mMenuItemBuy.setVisible(false);
            menuitem.setVisible(false);
            menuitem1.setVisible(false);
            mMenuItemPlayOn.setVisible(false);
        }
        mChromeCastHelper.setupMenuItem(menu);
        return true;
_L2:
        if (mAmazonLink.isEmpty() || mAmazonLink.equalsIgnoreCase("null"))
        {
            mMenuItemBuy.setVisible(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onDataFailed(String s, String s1)
    {
        if (s.compareTo("MediaDetails") == 0)
        {
            runOnUiThread(new Runnable() {

                final VideoPlayerActivity this$0;

                public void run()
                {
                    mVideoErrorDialog.show();
                }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
            });
            return;
        } else
        {
            super.onDataFailed(s, s1);
            return;
        }
    }

    public void onDataSuccess(String s)
    {
label0:
        {
            if (!isFinishing())
            {
                if (s.compareTo("VideoDubSubtitleProcessor") != 0)
                {
                    break label0;
                }
                runOnUiThread(new Runnable() {

                    final VideoPlayerActivity this$0;

                    public void run()
                    {
                        MediaDetailsItem mediadetailsitem = mVideoDubSubtitleProcessor.getCurrentItem();
                        Log.v(TAG, (new StringBuilder()).append(TAG).append("onDataSuccess").toString());
                        Object obj;
                        if (mediadetailsitem.getRootChannelID().compareTo("82") == 0)
                        {
                            BaseActivity.mJustPlayedMovie = true;
                        } else
                        {
                            BaseActivity.mJustPlayedShow = true;
                        }
                        mThumbnailUrl = mediadetailsitem.getThumbnailOneSheet185x277();
                        Exception exception;
                        try
                        {
                            mDurationInSeconds = Integer.parseInt(mediadetailsitem.getDurationInSeconds());
                        }
                        catch (Exception exception1) { }
                        mAmazonLink = mediadetailsitem.getAmazonLink();
                        if (mMenuItemBuy != null)
                        {
                            if (mAmazonLink == null || mAmazonLink.isEmpty() || mAmazonLink.equalsIgnoreCase("null") || Application.getInstance().getLocalization().isLatinAmericaUI() || Application.isNookTablet() || Application.isLeanBack())
                            {
                                mMenuItemBuy.setVisible(false);
                            } else
                            {
                                mMenuItemBuy.setVisible(true);
                            }
                        }
                        obj = (ImageButton)findViewById(0x7f0a010f);
                        if (!Application.isLeanBack() && (mediadetailsitem.getClosedCaptionFiles().size() > 0 || mVideoDubSubtitleProcessor.getCurrentItem().IsDubbed()))
                        {
                            ((ImageButton) (obj)).setVisibility(0);
                            ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                                final _cls19 this$1;

                                public void onClick(View view)
                                {
                                    showLanguageDialog();
                                }

            
            {
                this$1 = _cls19.this;
                super();
            }
                            });
                            String s1 = SharedPrefsManager.getLastSubtitles();
                            obj = s1;
                            if (TextUtils.isEmpty(s1))
                            {
                                obj = mediadetailsitem.getDefaultLang();
                            }
                            if (obj != null)
                            {
                                mSubTitleSelected = ((String) (obj));
                                mSubtitleTimeCodes = (List)mVideoDubSubtitleProcessor.getCurrentItem().getClosedCaptionFiles().get(obj);
                            }
                        } else
                        {
                            ((ImageButton) (obj)).setVisibility(8);
                        }
                        mVideoDubSubtitleProcessor.setCurrentLanguage(mediadetailsitem.getLocalizedLanguage());
                        if (!setMediaUrlAndReturnIfDRM(mediadetailsitem, mediadetailsitem.getMediaUrls())) goto _L2; else goto _L1
_L1:
                        if (mVideoUrl == null)
                        {
                            try
                            {
                                Uri.parse(mVideoUrl);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Exception exception)
                            {
                                Log.d("Crackle Stoped", "URL not Found");
                                Toast.makeText(getBaseContext(), "Can not open this video. Video not found.", 1).show();
                                finish();
                                return;
                            }
                        }
                        mDrm.setOnEventListener(new android.drm.DrmManagerClient.OnEventListener() {

                            final _cls19 this$1;

                            public void onEvent(DrmManagerClient drmmanagerclient, DrmEvent drmevent)
                            {
                                switch (drmevent.getType())
                                {
                                default:
                                    return;

                                case 1002: 
                                    startPlayer();
                                    break;
                                }
                            }

            
            {
                this$1 = _cls19.this;
                super();
            }
                        });
                        mDrm.setOnErrorListener(new android.drm.DrmManagerClient.OnErrorListener() {

                            final _cls19 this$1;

                            public void onError(DrmManagerClient drmmanagerclient, DrmErrorEvent drmerrorevent)
                            {
                                runOnUiThread(new Runnable() {

                                    final _cls3 this$2;

                                    public void run()
                                    {
                                        mVideoErrorDialog.show();
                                    }

            
            {
                this$2 = _cls3.this;
                super();
            }
                                });
                            }

            
            {
                this$1 = _cls19.this;
                super();
            }
                        });
                        mDrm.acquireRights(mVideoUrl);
_L4:
                        mComscoreTracker = new ComscoreTracker(mediadetailsitem, mVideoUrl, adContext);
                        if (!SharedPrefsManager.getIsParentalLockEnabled(com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl.RESTRICT_MATURE_CONTENT) && !SharedPrefsManager.getIsParentalLockEnabled(com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl.RESTRICT_ALL_CONTENT))
                        {
                            findNextMediaToPlay(mediadetailsitem);
                        }
                        return;
_L2:
                        if (mVideoUrl == null)
                        {
                            try
                            {
                                Uri.parse(mVideoUrl);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Exception exception)
                            {
                                Log.d("Crackle Stoped", "URL not Found");
                                Toast.makeText(getBaseContext(), "Can not open this video. Video not found.", 1).show();
                                finish();
                                return;
                            }
                        }
                        startPlayer();
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
                });
            }
            return;
        }
        if (s.equalsIgnoreCase("SOCIAL_PUBLISH"))
        {
            runOnUiThread(new Runnable() {

                final VideoPlayerActivity this$0;

                public void run()
                {
                    mMenuItemUnpost.setVisible(true);
                    Toast.makeText(VideoPlayerActivity.this, getString(0x7f0b013b), 1).show();
                }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
            });
            return;
        } else
        {
            super.onDataSuccess(s);
            return;
        }
    }

    protected void onDestroy()
    {
        try
        {
            if (mAdFetcher != null)
            {
                mAdFetcher.dispose();
            }
            if (adContext != null)
            {
                adContext.dispose();
                adContext = null;
            }
            if (mComscoreTracker != null)
            {
                mComscoreTracker.trackEnd();
            }
            if (mNielsenAppSdk != null)
            {
                mNielsenAppSdk.stop();
            }
            if (mConvivaSessionID >= 0)
            {
                LivePass.cleanupSession(mConvivaSessionID);
                mConvivaSessionID = -1;
                mConvivaMediaDetailsItem = null;
                mConvivaMediaUrl = null;
            }
        }
        catch (NullPointerException nullpointerexception)
        {
            nullpointerexception.printStackTrace();
        }
        SmartTV.getInstance().removeSmartTVListener(this);
        SmartTV.getInstance().disconnect();
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        mSystemUiHider.show();
        Log.d("KEYCODES", (new StringBuilder()).append("KEYCODE = ").append(i).toString());
        if ((i == 66 || i == 85 || i == 23) && mVideoHelper.isVideoSetup())
        {
            if (mVideoHelper.isPlaying() && !mAdIsPlaying)
            {
                if (mNextPosition >= 0)
                {
                    findViewById(0x7f0a009a).setVisibility(0);
                    mSeekIndicatorContainer.setVisibility(4);
                    mVideoPlayerControlsView.seekTo(mNextPosition);
                    mNextPosition = -1;
                } else
                {
                    mVideoPlayerControlsView.pausePlayback(false);
                }
                return true;
            }
            if (!mAdIsPlaying)
            {
                mVideoPlayerControlsView.startPlayback();
            }
        }
        int j;
        if ((i == 90 || i == 22) && mVideoHelper.isVideoSetup() && mVideoHelper.isPlaying() && !mAdIsPlaying)
        {
            int k = mDurationInSeconds * 1000;
            if (mNextPosition >= 0)
            {
                j = mNextPosition;
            } else
            {
                j = mVideoHelper.getCurrentPosition();
            }
            mNextPosition = j + (int)Math.round((double)mDurationInSeconds * 0.050000000000000003D) * 1000;
            if (mNextPosition > k)
            {
                mNextPosition = k;
            }
            findViewById(0x7f0a009a).setVisibility(4);
            mSeekIndicatorContainer.setVisibility(0);
            mSeekIndicatorFragment.setTime(mNextPosition);
            mVideoPlayerControlsView.setSecondaryProgress(mNextPosition);
        }
        if ((i == 89 || i == 21) && mVideoHelper.isVideoSetup() && mVideoHelper.isPlaying() && !mAdIsPlaying)
        {
            if (mNextPosition >= 0)
            {
                j = mNextPosition;
            } else
            {
                j = mVideoHelper.getCurrentPosition();
            }
            mNextPosition = j - (int)Math.round((double)mDurationInSeconds * 0.050000000000000003D) * 1000;
            if (mNextPosition <= 0)
            {
                mNextPosition = 1;
                mSeekIndicatorFragment.setTime(0);
            } else
            {
                mSeekIndicatorFragment.setTime(mNextPosition);
            }
            findViewById(0x7f0a009a).setVisibility(4);
            mSeekIndicatorContainer.setVisibility(0);
            mVideoPlayerControlsView.setSecondaryProgress(mNextPosition);
        }
        if (i == 4 && mNextPosition > 0)
        {
            mNextPosition = -1;
            findViewById(0x7f0a009a).setVisibility(0);
            mSeekIndicatorContainer.setVisibility(4);
            return true;
        }
        if (Application.isLeanBack() && i == 82)
        {
            showLanguageDialog();
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        performMenuAction(menuitem.getItemId());
        return true;
    }

    protected void onPause()
    {
        releaseWakeMode(this);
        mMidrollHandler.cancel();
        Log.d(TAG, (new StringBuilder()).append(TAG).append("onPause").toString());
        int i = mVideoHelper.getCurrentPosition();
        if (i > 10000)
        {
            saveTime(i, "onPause");
        } else
        if (i != 0 || !mLoadingFromSession);
        if (adContext != null)
        {
            Log.d(TAG, (new StringBuilder()).append(TAG).append("onPause:setPauseState").toString());
            adContext.setActivityState(adContext.getConstants().ACTIVITY_STATE_PAUSE());
        }
        if (mVideoHelper.isPlaying())
        {
            mVideoPlayerControlsView.pausePlayback(false);
        }
        if (Application.isNookTablet() || Application.isLeanBack())
        {
            if (mVideoHelper.isPlaying())
            {
                mVideoPlayerControlsView.stopPlayback(false);
            }
            finish();
        }
        if (Application.isFanhattan())
        {
            mContextualMenuService.onPause();
        }
        if (mComscoreTracker != null)
        {
            mComscoreTracker.trackPause(mCurrentAdSlot);
        }
        super.onPause();
    }

    public void onRequestComplete(IEvent ievent)
    {
        playResume();
    }

    public void onRequestContentVideoPause(IEvent ievent)
    {
        Log.d(TAG, (new StringBuilder()).append(TAG).append("onRequestContentVideoPause").toString());
        if (mVideoHelper.isPlaying())
        {
            mVideoPlayerControlsView.pausePlayback(true);
        }
        adContext.setVideoState(adContext.getConstants().VIDEO_STATE_PAUSED());
    }

    public void onRequestContentVideoResume(IEvent ievent)
    {
        Log.d(TAG, (new StringBuilder()).append(TAG).append("onRequestContentVideoResume").toString());
        adContext.setVideoState(adContext.getConstants().VIDEO_STATE_PLAYING());
    }

    protected void onRestart()
    {
        super.onRestart();
        if (mConvivaSessionID >= 0)
        {
            LivePass.cleanupSession(mConvivaSessionID);
            mConvivaSessionID = -1;
            mConvivaMediaDetailsItem = null;
            mConvivaMediaUrl = null;
        }
        mConvivaMediaDetailsItem = mVideoDubSubtitleProcessor.getCurrentItem();
        mConvivaMediaUrl = mVideoUrl;
        mVideoHelper.crackleVideoView.initializeConviva(mVideoDubSubtitleProcessor.getCurrentItem(), mVideoUrl);
        if (adContext != null)
        {
            adContext.setActivityState(adContext.getConstants().ACTIVITY_STATE_RESTART());
        }
    }

    protected void onResume()
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append("onResume").toString());
        if (!((KeyguardManager)getSystemService("keyguard")).inKeyguardRestrictedInputMode() || Application.isFanhattan())
        {
            if (Application.getInstance().getOmnitureTracker() == null)
            {
                Application.getInstance().mOmnitureTracker = new OmnitureWrapper("crackleprod");
            }
            if (mBumperIsRunning)
            {
                mVideoHelper.start();
            } else
            if (mVideoDubSubtitleProcessor == null)
            {
                Log.d(TAG, (new StringBuilder()).append(TAG).append("onResume:mediaNOTRetreived").toString());
                mVideoDubSubtitleProcessor = new VideoDubSubtitleProcessor();
                mVideoDubSubtitleProcessor.getData(this, mMediaID);
            } else
            if (mVideoDubSubtitleProcessor.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE)
            {
                Log.d(TAG, (new StringBuilder()).append(TAG).append("onResume:mediaRetrieved").toString());
                mMidrollHandler.cancel();
                mMidrollHandler.start();
                if (adContext != null)
                {
                    adContext.setActivityState(adContext.getConstants().ACTIVITY_STATE_RESUME());
                }
                int i = SharedPrefsManager.getPlayProgressForItem(mMediaID);
                if (i > 0 && !mAdIsPlaying)
                {
                    Log.v(TAG, (new StringBuilder()).append(TAG).append("Resume to ").append(i).toString());
                    adContext.setVideoState(adContext.getConstants().VIDEO_STATE_PLAYING());
                    mVideoHelper.setVisibility(0);
                    mVideoPlayerControlsView.seekTo(i);
                }
            }
            if (mSystemUiHider != null)
            {
                mSystemUiHider.hide();
            }
            if (Application.isFanhattan())
            {
                mContextualMenuService.onResume();
            }
        } else
        {
            mResumedInLock = true;
        }
        super.onResume();
    }

    public void onSlotEnded(IEvent ievent)
    {
        Log.d(TAG, (new StringBuilder()).append(TAG).append("onSlotEnded").toString());
        mAdIsPlaying = false;
        if (mPrerollRunning)
        {
            mPrerollRunning = false;
            playBumperIfExists();
        } else
        {
            playFromLastPosition();
        }
        mMidrollHandler.startScrubbingForgivenessPeriod();
    }

    public void onSmartTVConnect(int i)
    {
        StringBuffer stringbuffer = new StringBuffer();
        i;
        JVM INSTR lookupswitch 4: default 52
    //                   200: 79
    //                   401: 94
    //                   404: 109
    //                   503: 124;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        stringbuffer.append(getString(0x7f0b00e6));
        stringbuffer.append(i);
_L7:
        showMessageDialog(stringbuffer.toString());
        return;
_L2:
        stringbuffer.append(getString(0x7f0b00df));
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuffer.append(getString(0x7f0b00e1));
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuffer.append(getString(0x7f0b00e2));
        continue; /* Loop/switch isn't completed */
_L5:
        stringbuffer.append(getString(0x7f0b00e7));
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onSmartTVDataSent(int i)
    {
        StringBuffer stringbuffer = new StringBuffer();
        i;
        JVM INSTR lookupswitch 3: default 44
    //                   200: 71
    //                   401: 86
    //                   403: 101;
           goto _L1 _L2 _L3 _L4
_L1:
        stringbuffer.append(getString(0x7f0b00e5));
        stringbuffer.append(i);
_L6:
        showMessageDialog(stringbuffer.toString());
        return;
_L2:
        stringbuffer.append(getString(0x7f0b00e3));
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuffer.append(getString(0x7f0b00e1));
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuffer.append(getString(0x7f0b00e4));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onSmartTVDeviceListUpdate(List list)
    {
        if (mDeviceListAdapter == null)
        {
            Log.e(TAG, "Unexpected: deviceListAdapter is null");
            return;
        }
        if (mSelectedDevice != null)
        {
            if (mDeviceListAdapter.getCurrentItem() != null && mDeviceListAdapter.getCurrentItem().getFriendlyName().equals(mSelectedDevice.getFriendlyName()))
            {
                mAlertDeviceList.getButton(-1).setEnabled(true);
            } else
            {
                mAlertDeviceList.getButton(-1).setEnabled(false);
                mSelectedDevice = null;
                mDeviceListAdapter.unselectItem();
            }
        }
        mDeviceListAdapter.notifyDataSetChanged();
        setVisibilityNoDeviceMessage(list);
        hideSearchingProgressBar();
        timeoutHandler.sendMessage(new Message());
    }

    public void onSmartTVDisconnect(int i)
    {
    }

    public void onSmartTVLauncher(int i)
    {
        StringBuffer stringbuffer = new StringBuffer();
        i;
        JVM INSTR lookupswitch 4: default 52
    //                   200: 79
    //                   401: 94
    //                   404: 109
    //                   503: 124;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        stringbuffer.append(getString(0x7f0b00e6));
        stringbuffer.append(i);
_L7:
        showMessageDialog(stringbuffer.toString());
        return;
_L2:
        stringbuffer.append(getString(0x7f0b00df));
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuffer.append(getString(0x7f0b00e1));
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuffer.append(getString(0x7f0b00e2));
        continue; /* Loop/switch isn't completed */
_L5:
        stringbuffer.append(getString(0x7f0b00e7));
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onSmartTVRequestInfo(int i)
    {
        if (i == 0)
        {
            showMessageDialog(getString(0x7f0b00eb));
        }
    }

    protected void onStart()
    {
        super.onStart();
        Log.v(TAG, (new StringBuilder()).append(TAG).append("         onStart").toString());
        requestWakeMode();
        if (adContext != null)
        {
            Log.d(TAG, (new StringBuilder()).append(TAG).append("onStart:setStartState").toString());
            adContext.setActivityState(adContext.getConstants().ACTIVITY_STATE_START());
        }
    }

    protected void onStop()
    {
        releaseWakeMode(this);
        if (mConvivaSessionID >= 0)
        {
            LivePass.cleanupSession(mConvivaSessionID);
            mConvivaSessionID = -1;
            mConvivaMediaDetailsItem = null;
            mConvivaMediaUrl = null;
        }
        if (adContext != null)
        {
            Log.d(TAG, (new StringBuilder()).append(TAG).append("onStop:setStopState").toString());
            adContext.setActivityState(adContext.getConstants().ACTIVITY_STATE_PAUSE());
        }
        super.onStop();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        if (mResumedInLock)
        {
            mResumedInLock = false;
            onResume();
        }
        super.onWindowFocusChanged(flag);
    }

    protected void performMenuAction(int i)
    {
        if (i != 0x7f0a0006) goto _L2; else goto _L1
_L1:
        showLanguageDialog();
_L4:
        return;
_L2:
        MediaDetailsItem mediadetailsitem = mVideoDubSubtitleProcessor.getCurrentItem();
        if (mediadetailsitem == null) goto _L4; else goto _L3
_L3:
        if (i == 0x102002c)
        {
            finish();
            return;
        }
        if (i == 0x7f0a01c6)
        {
            mMenuItemUnpost.setVisible(false);
            mSocialOnAPI.unpublishLastPost(this);
            return;
        }
        if (i == 0x7f0a01c7)
        {
            Log.d(TAG, (new StringBuilder()).append(TAG).append("ShareButtonClick").toString());
            Application.getInstance().getOmnitureTracker().onVideoShare("ShareGeneral", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "", "", mediadetailsitem.getDuration());
            SessionM.getInstance().presentActivity(com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT);
            showShareDialog();
            return;
        }
        if (i == 0x7f0a01c8)
        {
            Application.getInstance().getOmnitureTracker().onVideoShare("FacebookLike", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "", "", mediadetailsitem.getDuration());
            postToFacebook(true, mediadetailsitem);
            return;
        }
        if (i != 0x7f0a01c9)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mAmazonLink == null || mAmazonLink.isEmpty() || mAmazonLink.equalsIgnoreCase("null")) goto _L4; else goto _L5
_L5:
        Application.getInstance().getOmnitureTracker().onVideoBuy(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannel(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Native", mSubTitleSelected, mediadetailsitem.getDuration());
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(mAmazonLink)));
        return;
        if (i != 0x7f0a01ca) goto _L4; else goto _L6
_L6:
        Log.d(TAG, (new StringBuilder()).append(TAG).append("TransferToTVButtonClick").toString());
        if (mVideoHelper.isPlaying())
        {
            mVideoHelper.pause();
            mVideoPlayerControlsView.updatePausePlayButton();
        } else
        {
            mVideoPlayerControlsView.ifNotPreparedDontStartPlayback();
        }
        adContext.setVideoState(adContext.getConstants().VIDEO_STATE_PAUSED());
        if (!isOnTV)
        {
            if (checkConnectivity())
            {
                SmartTV.getInstance().startDiscovery();
                timeoutHandler = new TimeoutHandler();
                timeoutHandler.sendMessage(new Message());
                showDeviceList(SmartTV.getInstance().getDeviceList());
                onYosemiteTimeout();
                return;
            } else
            {
                showMessageDialog(getString(0x7f0b00e8));
                return;
            }
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage(getResources().getString(0x7f0b013c));
            builder.setPositiveButton(getResources().getString(0x7f0b00b0), new android.content.DialogInterface.OnClickListener() {

                final VideoPlayerActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    switchBacktoDefaultScreen();
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
            });
            builder.setNegativeButton(getResources().getString(0x7f0b00ce), new android.content.DialogInterface.OnClickListener() {

                final VideoPlayerActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    if (!mVideoHelper.isPlaying())
                    {
                        mVideoHelper.start();
                        mVideoPlayerControlsView.updatePausePlayButton();
                        adContext.setVideoState(adContext.getConstants().VIDEO_STATE_PLAYING());
                        adContext.setActivityState(adContext.getConstants().ACTIVITY_STATE_RESUME());
                    }
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
            });
            mTurnOffMiracastDialog = builder.create();
            mTurnOffMiracastDialog.show();
            return;
        }
    }

    public void releaseWakeMode(Context context)
    {
        if (wakeLock != null)
        {
            if (wakeLock.isHeld())
            {
                wakeLock.release();
            }
            wakeLock = null;
        }
    }

    public void requestWakeMode()
    {
        if (wakeLock == null)
        {
            wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(0x2000000a, com/gotv/crackle/VideoPlayerActivity.getName());
            wakeLock.setReferenceCounted(false);
            wakeLock.acquire();
        }
    }

    public boolean setMediaUrlAndReturnIfDRM(MediaDetailsItem mediadetailsitem, Map map)
    {
        String s = mediadetailsitem.getShowName();
        String s1 = mediadetailsitem.getSeason();
        String s2 = mediadetailsitem.getEpisode();
        boolean flag;
        if (s != null && !s.equalsIgnoreCase("") && s1 != null && !s1.equalsIgnoreCase("") && s2 != null && !s2.equalsIgnoreCase(""))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (Application.isFanhattan() && flag)
        {
            setActionBarTitle((new StringBuilder()).append(mediadetailsitem.getShowName()).append(": ").append("S").append(mediadetailsitem.getSeason()).append(" E").append(mediadetailsitem.getEpisode()).append(": ").append(mediadetailsitem.getTitle()).toString());
        } else
        {
            setActionBarTitle(mediadetailsitem.getTitle());
        }
        mediadetailsitem = (ConnectivityManager)getSystemService("connectivity");
        new MediaUrlItem();
        if (Application.isAmazonFireTV() || Application.isFanhattan())
        {
            mediadetailsitem = (MediaUrlItem)map.get("PS3_Trilithium.m3u8");
        } else
        if (mediadetailsitem.getNetworkInfo(1).isConnected())
        {
            if (Application.getInstance().isTablet())
            {
                mediadetailsitem = (MediaUrlItem)map.get("AndroidTablet_Wifi.m3u8");
            } else
            {
                mediadetailsitem = (MediaUrlItem)map.get("AndroidHandset_Wifi.m3u8");
            }
        } else
        if (Application.getInstance().isTablet())
        {
            mediadetailsitem = (MediaUrlItem)map.get("AndroidTablet_3G.m3u8");
        } else
        {
            mediadetailsitem = (MediaUrlItem)map.get("AndroidHandset_3G.m3u8");
        }
        if (android.os.Build.VERSION.SDK_INT >= 13 && ((MediaUrlItem) (mediadetailsitem)).useDrm && mDrm != null)
        {
            mVideoUrl = ((MediaUrlItem) (mediadetailsitem)).drmPath;
            return true;
        } else
        {
            mVideoUrl = ((MediaUrlItem) (mediadetailsitem)).path;
            return false;
        }
    }

    protected void showLanguageDialog()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        LanguageDialog languagedialog = new LanguageDialog();
        languagedialog.setVideoDubSubtitleProcessor(mVideoDubSubtitleProcessor);
        languagedialog.setSelectedSubtitles(mSubTitleSelected);
        languagedialog.setLanguageDialogListener(this);
        languagedialog.show(fragmentmanager, "language_dialog");
        mVideoPlayerControlsView.pausePlayback(false);
        saveTime(mVideoHelper.getCurrentPosition(), "LanguageDialog");
    }

    protected void showShareDialog()
    {
        mVideoPlayerControlsView.pausePlayback(false);
        mShareDialog = new Dialog(this);
        mShareDialog.setTitle(0x7f0b00b6);
        mShareDialog.setCanceledOnTouchOutside(true);
        View view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03006b, null, false);
        View view1 = view.findViewById(0x7f0a0169);
        View view2 = view.findViewById(0x7f0a016a);
        View view3 = view.findViewById(0x7f0a0165);
        View view4 = view.findViewById(0x7f0a0167);
        if (Application.isNookTablet() || Application.getInstance().isTabletSizedScreen())
        {
            view4.setVisibility(8);
            view.findViewById(0x7f0a0168).setVisibility(8);
        }
        view1.setOnClickListener(shareItemClickListener);
        view2.setOnClickListener(shareItemClickListener);
        view3.setOnClickListener(shareItemClickListener);
        view4.setOnClickListener(shareItemClickListener);
        mShareDialog.setContentView(view);
        mShareDialog.getWindow().setLayout(Application.getDisplayIndependantPixelSize(300), -2);
        mShareDialog.show();
    }

    public void stopMHandler()
    {
        if (timeoutHandler != null)
        {
            timeoutHandler.removeMessages(0);
        }
    }

    public void updateLanguageCancelled()
    {
        mVideoHelper.start();
        updateCaptionSettings();
    }

    public void updateLanguageSettings(Map map, String s, String s1, List list, String s2)
    {
        if (map != null)
        {
            mVideoDubSubtitleProcessor.setCurrentCaptions(s1);
            if (!mVideoDubSubtitleProcessor.getCurrentLanguage().equalsIgnoreCase(s))
            {
                mVideoDubSubtitleProcessor.setCurrentLanguage(s);
                mTriedWithHTTPLive = false;
                mVideoPlayerControlsView.stopPlayback(true);
                mVideoHelper.setVisibility(8);
                setMediaUrlAndReturnIfDRM(mVideoDubSubtitleProcessor.getCurrentItem(), map);
                playFromLastPosition();
            } else
            {
                mVideoPlayerControlsView.startPlayback();
            }
        } else
        {
            mVideoPlayerControlsView.startPlayback();
        }
        if (list == null)
        {
            mSubtitleTimeCodes = null;
            Application.getInstance().getOmnitureTracker().subtitlesOff();
            mSubTitleSelected = null;
        } else
        {
            mSubtitleTimeCodes = list;
            Application.getInstance().getOmnitureTracker().subtitlesOn();
            mSubTitleSelected = s1;
        }
        SharedPrefsManager.setLastSubtitles(mSubTitleSelected);
        updateCaptionSettings();
    }



/*
    static boolean access$002(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.mTriedWithHTTPLive = flag;
        return flag;
    }

*/




/*
    static String access$102(VideoPlayerActivity videoplayeractivity, String s)
    {
        videoplayeractivity.mVideoUrl = s;
        return s;
    }

*/



/*
    static boolean access$1102(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.mBumperIsRunning = flag;
        return flag;
    }

*/



/*
    static int access$1302(VideoPlayerActivity videoplayeractivity, int i)
    {
        videoplayeractivity.mNextPosition = i;
        return i;
    }

*/





/*
    static boolean access$1602(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.mScrubbingForgiveness = flag;
        return flag;
    }

*/




/*
    static ComscoreTracker access$1802(VideoPlayerActivity videoplayeractivity, ComscoreTracker comscoretracker)
    {
        videoplayeractivity.mComscoreTracker = comscoretracker;
        return comscoretracker;
    }

*/



/*
    static int access$1902(VideoPlayerActivity videoplayeractivity, int i)
    {
        videoplayeractivity.mDurationInSeconds = i;
        return i;
    }

*/



/*
    static boolean access$2002(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.mPassed25 = flag;
        return flag;
    }

*/


/*
    static boolean access$2102(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.mPassed50 = flag;
        return flag;
    }

*/


/*
    static boolean access$2202(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.mPassed75 = flag;
        return flag;
    }

*/


/*
    static boolean access$2302(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.mPassed95 = flag;
        return flag;
    }

*/








/*
    static boolean access$2902(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.mShouldReportVideoStart = flag;
        return flag;
    }

*/




/*
    static int access$3102(VideoPlayerActivity videoplayeractivity, int i)
    {
        videoplayeractivity.mLastOmnitureReportTimeInSeconds = i;
        return i;
    }

*/



/*
    static String access$3202(VideoPlayerActivity videoplayeractivity, String s)
    {
        videoplayeractivity.mSubTitleSelected = s;
        return s;
    }

*/




/*
    static View access$3402(VideoPlayerActivity videoplayeractivity, View view)
    {
        videoplayeractivity.mNetworkID = view;
        return view;
    }

*/



/*
    static boolean access$3502(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.mPassedTenSeconds = flag;
        return flag;
    }

*/

















/*
    static String access$4902(VideoPlayerActivity videoplayeractivity, String s)
    {
        videoplayeractivity.control = s;
        return s;
    }

*/







/*
    static int access$5302(VideoPlayerActivity videoplayeractivity, int i)
    {
        videoplayeractivity.mLastAdTimeCode = i;
        return i;
    }

*/


/*
    static String access$5402(VideoPlayerActivity videoplayeractivity, String s)
    {
        videoplayeractivity.mResume = s;
        return s;
    }

*/




/*
    static String access$5802(VideoPlayerActivity videoplayeractivity, String s)
    {
        videoplayeractivity.mThumbnailUrl = s;
        return s;
    }

*/



/*
    static String access$5902(VideoPlayerActivity videoplayeractivity, String s)
    {
        videoplayeractivity.mAmazonLink = s;
        return s;
    }

*/




/*
    static List access$6102(VideoPlayerActivity videoplayeractivity, List list)
    {
        videoplayeractivity.mSubtitleTimeCodes = list;
        return list;
    }

*/







/*
    static boolean access$6702(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.mAdIsPlaying = flag;
        return flag;
    }

*/



/*
    static ISlot access$6802(VideoPlayerActivity videoplayeractivity, ISlot islot)
    {
        videoplayeractivity.mCurrentAdSlot = islot;
        return islot;
    }

*/










/*
    static boolean access$7602(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.mIsSendData = flag;
        return flag;
    }

*/







/*
    static String access$802(VideoPlayerActivity videoplayeractivity, String s)
    {
        videoplayeractivity.mNextMediaIdToPlay = s;
        return s;
    }

*/


/*
    static Device access$8102(VideoPlayerActivity videoplayeractivity, Device device)
    {
        videoplayeractivity.mSelectedDevice = device;
        return device;
    }

*/




/*
    static DisplayManager access$8302(VideoPlayerActivity videoplayeractivity, DisplayManager displaymanager)
    {
        videoplayeractivity.mDisplayManager = displaymanager;
        return displaymanager;
    }

*/




/*
    static DisplayListAdapter access$8502(VideoPlayerActivity videoplayeractivity, DisplayListAdapter displaylistadapter)
    {
        videoplayeractivity.mDisplayListAdapter = displaylistadapter;
        return displaylistadapter;
    }

*/




/*
    static RemotePresentation access$8702(VideoPlayerActivity videoplayeractivity, RemotePresentation remotepresentation)
    {
        videoplayeractivity.mPresentation = remotepresentation;
        return remotepresentation;
    }

*/


/*
    static boolean access$8802(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.isOnTV = flag;
        return flag;
    }

*/






    // Unreferenced inner class com/gotv/crackle/VideoPlayerActivity$10$1

/* anonymous class */
    class _cls1
        implements Runnable
    {

        final _cls10 this$1;

        public void run()
        {
            if (SharedPrefsManager.getSocialOnEnabled() && CrackleAccountManager.isLoggedIn() && mMenuItemUnpost != null)
            {
                String s = CrackleAccountManager.getUserID();
                mSocialOnAPI.publishWatchedhMediaItem(_fld0, s, mMediaID);
            }
        }

            
            {
                this$1 = _cls10.this;
                super();
            }
    }

}
