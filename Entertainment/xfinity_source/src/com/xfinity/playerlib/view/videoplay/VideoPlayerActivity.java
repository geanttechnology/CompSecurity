// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
import com.comcast.cim.android.accessibility.PassiveStateChangeListener;
import com.comcast.cim.android.accessibility.SpeechDelegate;
import com.comcast.cim.android.view.common.OrientationStrategy;
import com.comcast.cim.android.view.launch.AuthenticatingActivity;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.model.user.UserManager;
import com.ijsbrandslob.appirater.Appirater;
import com.xfinity.playerlib.PlayerApplication;
import com.xfinity.playerlib.alt.speechrecognizers.PlayerSpeechRecognizer;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.model.LiveStreamFavorite;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.view.search.SearchActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            PlayerVideoIntent, VideoPlayerFragment

public class VideoPlayerActivity extends AuthenticatingActivity
    implements PassiveStateChangeListener, com.xfinity.playerlib.view.browsehistory.HistoryFragment.HistoryListener, com.xfinity.playerlib.view.browsehistory.HistoryFragment.LiveStreamPlayOrResumePressedListener, com.xfinity.playerlib.view.browsehistory.HistoryFragment.VideoPlayOrResumePressedListener, com.xfinity.playerlib.view.browseprograms.LiveStreamsFragment.LiveStreamOnClickListener, com.xfinity.playerlib.view.favorite.BookmarksFragment.FavoriteListener, com.xfinity.playerlib.view.programdetails.DetailFragment.PlayPressedListener, com.xfinity.playerlib.view.programdetails.SeriesEpisodeListFragment.SeriesEpisodeListContainer
{
    private class AdobePlayerActivitySpeechRecognizer extends com.comcast.cim.android.view.common.BaseActivity.ActivitySpeechListener
    {

        final VideoPlayerActivity this$0;

        public boolean onSpeechResponseSearch(String as[])
        {
            getSpeechDelegate().startSearch(com/xfinity/playerlib/view/search/SearchActivity, as);
            return false;
        }

        private AdobePlayerActivitySpeechRecognizer()
        {
            this$0 = VideoPlayerActivity.this;
            super(VideoPlayerActivity.this);
        }

    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/videoplay/VideoPlayerActivity);
    private final AndroidDevice androidDevice = PlayerContainer.getInstance().getAndroidDevice();
    private final Appirater appirater = PlayerContainer.getInstance().getAppirater();
    private Runnable appiraterCallback;
    private Handler handler;
    private OrientationStrategy orientationStrategy;
    private final PlayerConfiguration playerConfiguration = PlayerContainer.getInstance().getConfiguration();
    private final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();

    public VideoPlayerActivity()
    {
        orientationStrategy = new OrientationStrategy() {

            final VideoPlayerActivity this$0;

            public int getAppropriateOrientation()
            {
                return androidDevice.getLandscapeOrientation();
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        };
    }

    public static Bundle createBundle(MerlinId merlinid, MerlinId merlinid1, long l, long l1)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("merlinId", merlinid);
        bundle.putSerializable("parentMerlinId", merlinid1);
        if (l > 0L)
        {
            bundle.putLong("companyId", l);
        }
        if (l1 > 0L)
        {
            bundle.putLong(PlayerVideoIntent.POSITION.name(), l1);
        }
        return bundle;
    }

    public static Bundle createBundle(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("liveStreamName", s);
        return bundle;
    }

    public static Bundle createBundle(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("liveStreamName", s);
        bundle.putString("liveEventID", s1);
        return bundle;
    }

    public static Bundle createBundleForPlayer(MerlinId merlinid, long l)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("parentMerlinId", merlinid);
        bundle.putLong("videoId", l);
        return bundle;
    }

    public static Bundle createBundleForPlayer(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("liveStreamID", s);
        return bundle;
    }

    public static Bundle createBundleForPlayer(String s, String s1)
    {
        s = createBundleForPlayer(s);
        s.putString("liveEventID", s1);
        return s;
    }

    public static Intent createIntentForPlayer(VideoBookmark videobookmark)
    {
        return createIntentForPlayer(videobookmark.getParentMerlinIdIfApplicable(), videobookmark.getVideoId());
    }

    public static Intent createIntentForPlayer(MerlinId merlinid, long l)
    {
        Intent intent = new Intent(PlayerApplication.getInstance(), com/xfinity/playerlib/view/videoplay/VideoPlayerActivity);
        intent.putExtras(createBundleForPlayer(merlinid, l));
        return intent;
    }

    public static Intent createIntentForPlayer(VideoFacade videofacade, Watchable watchable)
    {
        return createIntentForPlayer(watchable.getParentMerlinIdIfApplicable(), videofacade.getVideoId());
    }

    public static Intent createIntentForPlayer(String s)
    {
        Intent intent = new Intent(PlayerApplication.getInstance(), com/xfinity/playerlib/view/videoplay/VideoPlayerActivity);
        intent.putExtras(createBundleForPlayer(s));
        return intent;
    }

    public static Intent createIntentForPlayer(String s, String s1)
    {
        Intent intent = new Intent(PlayerApplication.getInstance(), com/xfinity/playerlib/view/videoplay/VideoPlayerActivity);
        intent.putExtras(createBundleForPlayer(s, s1));
        return intent;
    }

    protected void addDefaultActivitySpeechListener()
    {
        addSpeechListener(new AdobePlayerActivitySpeechRecognizer());
    }

    public OrientationStrategy getOrientationStrategy()
    {
        return orientationStrategy;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;
    }

    protected UserManager getUserManager()
    {
        return userManager;
    }

    public void onBackPressed()
    {
        LOG.debug("Back system button hit");
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null)
        {
            videoplayerfragment.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (androidDevice.isKindle())
        {
            getWindow().addFlags(1024);
        }
        setContentView(com.xfinity.playerlib.R.layout.video_player);
        handler = new Handler();
        appiraterCallback = new Runnable() {

            final VideoPlayerActivity this$0;

            public void run()
            {
                appirater.userDidSignificantEvent(false, VideoPlayerActivity.this);
            }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
        };
        handler.postDelayed(appiraterCallback, playerConfiguration.getTimeElapsedWithoutLeavingThePlayerBeforeRatingsPrompt());
    }

    protected void onDestroy()
    {
        super.onDestroy();
        handler.removeCallbacks(appiraterCallback);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null && videoplayerfragment.onVolumeHardwareKeyPressed(i))
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onLiveEventClick(HalLiveStream hallivestream, String s)
    {
    }

    public void onLiveStreamClick(HalLiveStream hallivestream)
    {
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null)
        {
            videoplayerfragment.onLiveStreamClick(hallivestream);
        }
    }

    public void onLiveStreamPlayOrResumePressed(String s)
    {
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null)
        {
            videoplayerfragment.onLiveStreamPlayOrResumePressed(s);
        }
    }

    public void onNewIntent(Intent intent)
    {
        String s = intent.getAction();
        if (s != null && s.equals("reset"))
        {
            setIntent(intent);
            intent = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
            if (intent != null)
            {
                intent.reset();
            }
        }
    }

    public void onPause()
    {
        super.onPause();
        LOG.debug("onPause");
    }

    public void onPlayOrResumePressed(VideoFacade videofacade, Watchable watchable)
    {
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null)
        {
            videoplayerfragment.onPlayOrResumePressed(videofacade, watchable);
        }
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        LOG.debug("onResume");
        Intent intent = getIntent();
        intent.setAction("reset");
        intent.setFlags(0x4000000);
        checkTalkBackModeOnResume(intent);
    }

    public void onSpeechSwipe()
    {
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null)
        {
            videoplayerfragment.onSpeechSwiped();
        }
        super.onSpeechSwipe();
    }

    public void onVideoPlayOrResumePressed(VideoBookmark videobookmark)
    {
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null)
        {
            videoplayerfragment.onVideoPlayOrResumePressed(videobookmark);
        }
    }

    public void playLiveStream(LiveStreamFavorite livestreamfavorite)
    {
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null)
        {
            videoplayerfragment.playLiveStream(livestreamfavorite);
        }
    }

    public boolean shouldShowSeriesListItemsChecked()
    {
        return false;
    }

    public void showDetail(VideoBookmark videobookmark, Long long1)
    {
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null)
        {
            videoplayerfragment.showDetail(videobookmark, long1);
        }
    }

    public void showDetail(VideoFavorite videofavorite)
    {
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null)
        {
            videoplayerfragment.showDetail(videofavorite);
        }
    }

    public void showSeriesDetail()
    {
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null)
        {
            videoplayerfragment.showSeriesDetail();
        }
    }

    public void showSeriesWatchableDetail(SeriesWatchable serieswatchable)
    {
        VideoPlayerFragment videoplayerfragment = (VideoPlayerFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_player_fragment);
        if (videoplayerfragment != null)
        {
            videoplayerfragment.showSeriesWatchableDetail(serieswatchable);
        }
    }



}
