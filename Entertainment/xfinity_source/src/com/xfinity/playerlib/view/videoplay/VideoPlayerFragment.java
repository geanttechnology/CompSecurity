// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.DefaultSpeechListener;
import com.comcast.cim.android.accessibility.SpeechListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.android.view.common.SAPSelectionListDialogFragment;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.comcast.cim.cmasl.analytics.AnalyticsLogger;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.android.util.view.widget.ResponsiveRelativeLayout;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.model.Rating;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.comcast.cim.utils.BroadcastReceiverUtil;
import com.comcast.cim.utils.UIPresentationUtil;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.primetime.TimelineMarker;
import com.xfinity.playerlib.PlayerApplication;
import com.xfinity.playerlib.VideoPlayUtil;
import com.xfinity.playerlib.authorization.SMILResource;
import com.xfinity.playerlib.authorization.VideoAuthManager;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.LiveStreamFavorite;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.SeriesWatchableInfo;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.WatchableCodec;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.database.VideoBookmarkDAO;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.model.videoplay.PlayerConfigUtil;
import com.xfinity.playerlib.model.videoplay.adobeplayer.CimAssetFactory;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.AnimatedFragment;
import com.xfinity.playerlib.view.CustomStateImageView;
import com.xfinity.playerlib.view.VerticalSeekBar;
import com.xfinity.playerlib.view.browsehistory.BabyGuideHistoryActivity;
import com.xfinity.playerlib.view.browsehistory.HistoryFragment;
import com.xfinity.playerlib.view.browsehistory.MultiDeleteBrowseFragment;
import com.xfinity.playerlib.view.browseprograms.BabyGuideLiveStreamsActivity;
import com.xfinity.playerlib.view.browseprograms.LiveStreamsFragment;
import com.xfinity.playerlib.view.common.ParentalControlPinFragment;
import com.xfinity.playerlib.view.favorite.BabyGuideBookmarksActivity;
import com.xfinity.playerlib.view.favorite.BookmarksFragment;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            PlayerPlatformMediaPlayer, TimelineSeekBar, RemoteControlReceiver, RatingsBug

public class VideoPlayerFragment extends AuthenticatingFragment
    implements com.xfinity.playerlib.view.browsehistory.HistoryFragment.HistoryListener, com.xfinity.playerlib.view.browsehistory.HistoryFragment.LiveStreamPlayOrResumePressedListener, com.xfinity.playerlib.view.browsehistory.HistoryFragment.VideoPlayOrResumePressedListener, com.xfinity.playerlib.view.browseprograms.LiveStreamsFragment.LiveStreamOnClickListener, com.xfinity.playerlib.view.favorite.BookmarksFragment.FavoriteListener, com.xfinity.playerlib.view.programdetails.DetailFragment.PlayPressedListener, com.xfinity.playerlib.view.programdetails.SeriesEpisodeListFragment.SeriesEpisodeListContainer
{
    private class AdobePlayerFragmentSpeechListener extends DefaultSpeechListener
    {

        final VideoPlayerFragment this$0;

        public boolean onSpeechResponsePause()
        {
            handler.postDelayed(new PauseRunnable(), 200L);
            return true;
        }

        public boolean onSpeechResponsePlay(String as[])
        {
            if (as.length == 0)
            {
                if (!videoPlayingBeforeSpeechSwipe)
                {
                    handler.postDelayed(new PlayRunnable(), 200L);
                } else
                {
                    alternateInterfaceListener.getTalkDelegate().speak(com.xfinity.playerlib.R.string.video_already_playing);
                }
                return true;
            } else
            {
                return false;
            }
        }

        public boolean onSpeechResponseSeek(String as[])
        {
            seek(0x1b7740);
            return true;
        }

        private AdobePlayerFragmentSpeechListener()
        {
            this$0 = VideoPlayerFragment.this;
            super();
        }

    }

    private static final class BabyGuideType extends Enum
    {

        private static final BabyGuideType $VALUES[];
        public static final BabyGuideType BOOKMARKS;
        public static final BabyGuideType HISTORY;
        public static final BabyGuideType INFO;
        private final int resStringCaptionId;

        public static BabyGuideType valueOf(String s)
        {
            return (BabyGuideType)Enum.valueOf(com/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType, s);
        }

        public static BabyGuideType[] values()
        {
            return (BabyGuideType[])$VALUES.clone();
        }

        public int getCaptionResId()
        {
            return resStringCaptionId;
        }

        static 
        {
            INFO = new BabyGuideType("INFO", 0, com.xfinity.playerlib.R.string.details);
            HISTORY = new BabyGuideType("HISTORY", 1, com.xfinity.playerlib.R.string.history);
            BOOKMARKS = new BabyGuideType("BOOKMARKS", 2, com.xfinity.playerlib.R.string.favorite);
            $VALUES = (new BabyGuideType[] {
                INFO, HISTORY, BOOKMARKS
            });
        }

        private BabyGuideType(String s, int i, int j)
        {
            super(s, i);
            resStringCaptionId = j;
        }
    }

    class BrightnessSliderOnSeekBarChangeListener
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        final VideoPlayerFragment this$0;

        public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            seekbar = getActivity().getWindow().getAttributes();
            seekbar.screenBrightness = getAdjustedBrightness(i);
            getActivity().getWindow().setAttributes(seekbar);
            if (isPhone)
            {
                seekbar = brightnessIndicator;
                if (i > 3)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                seekbar.setAppearEnabled(flag);
            }
        }

        public void onStartTrackingTouch(SeekBar seekbar)
        {
            playerUIController.removeMainControlTimeout();
        }

        public void onStopTrackingTouch(SeekBar seekbar)
        {
            ((PlayerUserSettings)userManager.getUserSettings()).setBrightnessValue(seekbar.getProgress());
            if (videoStateController.getMediaPlayer().getPlayerStatus().equals(PlayerStatus.PLAYING))
            {
                playerUIController.startMainControlTimeout();
            }
        }

        BrightnessSliderOnSeekBarChangeListener()
        {
            this$0 = VideoPlayerFragment.this;
            super();
        }
    }

    private class PauseRunnable
        implements Runnable
    {

        final VideoPlayerFragment this$0;

        public void run()
        {
            speechTriggerPause();
            alternateInterfaceListener.getTalkDelegate().speak(com.xfinity.playerlib.R.string.video_paused);
        }

        private PauseRunnable()
        {
            this$0 = VideoPlayerFragment.this;
            super();
        }

    }

    private class PhonePlayerUIController extends PlayerUIController
    {

        final VideoPlayerFragment this$0;

        public void hideInfoPanel()
        {
            showActionBarMenus();
        }

        public boolean showCurrentVideoInfo(String s)
        {
            hideActionBarMenus();
            s = getCurrentVideoIntent();
            startActivity(s);
            return true;
        }

        public boolean showFavorite(String s)
        {
            hideActionBarMenus();
            startActivity(getFavoriteIntent());
            return true;
        }

        public void showFavoriteDetail(VideoFavorite videofavorite, String s)
        {
        }

        public boolean showHistory(String s)
        {
            hideActionBarMenus();
            startActivity(getHistoryIntent());
            return true;
        }

        public void showHistoryItemDetail(VideoBookmark videobookmark, String s)
        {
        }

        public void showSeriesWatchableDetail(SeriesWatchable serieswatchable, String s)
        {
        }

        private PhonePlayerUIController()
        {
            this$0 = VideoPlayerFragment.this;
            super();
        }

    }

    private class PlayRunnable
        implements Runnable
    {

        final VideoPlayerFragment this$0;

        public void run()
        {
            speechTriggerPlay();
            alternateInterfaceListener.getTalkDelegate().speak(com.xfinity.playerlib.R.string.video_resuming);
        }

        private PlayRunnable()
        {
            this$0 = VideoPlayerFragment.this;
            super();
        }

    }

    public abstract class PlayerUIController
        implements android.view.SurfaceHolder.Callback, android.widget.SeekBar.OnSeekBarChangeListener
    {

        protected boolean allowSeek;
        private Runnable clearPlayerControlsRunner;
        private Runnable clearVolumeControlRunner;
        protected boolean hasShownRatingsBug;
        boolean isSeeking;
        protected final int mAllowSeekMargin = 200;
        protected final int mMaxProgress = 1000;
        private Runnable moveUpAdsActionBarRunner;
        private ParentalControlPinFragment parentalControlPinFragment;
        protected RatingsBug ratingsBug;
        protected int seekLastProgress;
        android.content.DialogInterface.OnCancelListener selectionDialogOnCancelListener;
        android.content.DialogInterface.OnKeyListener selectionDialogOnKeyListener;
        final VideoPlayerFragment this$0;

        private void announceAdState(String s)
        {
            String s1 = videoStateController.getWatchable().getTitle();
            Object obj = s1;
            if (!videoStateController.getVideoFacade().isMovie())
            {
                obj = s1;
                if (videoStateController.getWatchable().getSeriesInfoIfApplicable() != null)
                {
                    obj = new StringBuffer();
                    ((StringBuffer) (obj)).append(videoStateController.getWatchable().getSeriesInfoIfApplicable().getSeriesTitle());
                    ((StringBuffer) (obj)).append(", episode: ");
                    ((StringBuffer) (obj)).append(s1);
                    obj = ((StringBuffer) (obj)).toString();
                }
            }
            s = s.replaceFirst("Your video", ((String) (obj)));
            alternateInterfaceListener.getTalkDelegate().speak(s);
        }

        private void configureControlsForLiveStream()
        {
            programProgressBar.setVisibility(8);
            videoDuration.setVisibility(8);
            currentTime.setVisibility(8);
            networkLogo.setVisibility(0);
            Object obj = playerControls.findViewById(com.xfinity.playerlib.R.id.play_pause_button_layout);
            if (obj != null)
            {
                ((View) (obj)).setVisibility(8);
            } else
            {
                playButton.setVisibility(8);
                pauseButton.setVisibility(8);
            }
            progressBarLayout.setEnabled(false);
            obj = (android.widget.RelativeLayout.LayoutParams)progressBarLayout.getLayoutParams();
            obj.width = -2;
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(14);
            progressBarLayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            progressBarLayout.invalidate();
        }

        private void configureControlsForVOD()
        {
            programProgressBar.setVisibility(0);
            videoDuration.setVisibility(0);
            currentTime.setVisibility(0);
            networkLogo.setVisibility(8);
            networkName.setVisibility(8);
            programProgressBar.setThumb(getResources().getDrawable(com.xfinity.playerlib.R.drawable.scrubber_control_selector_holo));
            programProgressBar.setEnabled(true);
            progressBarLayout.setEnabled(true);
            Object obj = playerControls.findViewById(com.xfinity.playerlib.R.id.play_pause_button_layout);
            if (obj != null)
            {
                ((View) (obj)).setVisibility(0);
            }
            obj = (android.widget.RelativeLayout.LayoutParams)progressBarLayout.getLayoutParams();
            if (android.os.Build.VERSION.SDK_INT >= 17)
            {
                ((android.widget.RelativeLayout.LayoutParams) (obj)).removeRule(14);
            } else
            {
                ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(14, 0);
            }
            obj.width = -1;
            progressBarLayout.invalidate();
        }

        private int getProgressTime(long l, long l1)
        {
            return (int)((double)l1 * ((double)l / 1000D));
        }

        private boolean isDownloadedVideo()
        {
            return videoStateController.getDownloadedFile() != null;
        }

        private void setLandscapeOrientation()
        {
            getActivity().setRequestedOrientation(androidDevice.getLandscapeOrientation());
        }

        private void setThumbTimeView(int i)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams.leftMargin = (int)(60D + (double)i * ((double)programProgressBar.getWidth() / 1000D));
            layoutparams.bottomMargin = 10;
            layoutparams.addRule(2, com.xfinity.playerlib.R.id.progressbar_layout);
            thumbTime.setLayoutParams(layoutparams);
            long l = videoStateController.getMediaPlayer().getDuration();
            thumbTime.setText(videoPlayUtil.getDisplayTime(getProgressTime(i, l), (int)l));
        }

        private void showActionBar()
        {
            showActionBarMenus();
            getActivity().getActionBar().show();
        }

        private void showMainControlsAndActionBar(boolean flag)
        {
label0:
            {
label1:
                {
                    turnLightsOn();
                    showMainControls(flag);
                    showActionBar();
                    if (accessibilityUtil.isAccessibilityEnabled())
                    {
                        if (!isPlaying())
                        {
                            break label0;
                        }
                        if (!manualControlToggleOn)
                        {
                            break label1;
                        }
                        changeAccessibilityControlToggleContentDescription(com.xfinity.playerlib.R.string.content_description_toggle_control_instructions_off);
                    }
                    return;
                }
                changeAccessibilityControlToggleContentDescription(com.xfinity.playerlib.R.string.content_description_toggle_control_instructions_on);
                return;
            }
            changeAccessibilityControlToggleContentDescription(com.xfinity.playerlib.R.string.content_description_toggle_controls_are_visible);
        }

        private void updateProgressInfo(long l, long l1)
        {
            currentTime.setText(videoPlayUtil.getDisplayTime((int)l, (int)l1));
            String s = UIPresentationUtil.getTimeForPlayer(getActivity(), (int)(l / 1000L));
            currentTime.setContentDescription((new StringBuilder()).append(getResources().getString(com.xfinity.playerlib.R.string.content_description_time_played)).append(s).toString());
            if (programProgressBar.getVisibility() == 0)
            {
                programProgressBar.setProgress(getProgress(l, l1));
            }
        }

        public void announceBabyGuideClosed(BabyGuideType babyguidetype)
        {
            if (babyguidetype != null)
            {
                babyguidetype = (new StringBuilder()).append(getString(babyguidetype.getCaptionResId())).append(" closed").toString();
                alternateInterfaceListener.getTalkDelegate().speak(babyguidetype);
            }
            selectedBabyGuideMenu = null;
        }

        public void announceSapAndCcStates(boolean flag, boolean flag1)
        {
            Object obj = new StringBuilder();
            VideoPlayerFragment videoplayerfragment = VideoPlayerFragment.this;
            int j = com.xfinity.playerlib.R.string.content_description_video_options_announcement;
            String s = getString(com.xfinity.playerlib.R.string.content_description_cc);
            VideoPlayerFragment videoplayerfragment1 = VideoPlayerFragment.this;
            int i;
            if (flag)
            {
                i = com.xfinity.playerlib.R.string.content_description_available;
            } else
            {
                i = com.xfinity.playerlib.R.string.content_description_not_available;
            }
            obj = ((StringBuilder) (obj)).append(videoplayerfragment.getString(j, new Object[] {
                s, videoplayerfragment1.getString(i)
            })).append(" ");
            videoplayerfragment = VideoPlayerFragment.this;
            j = com.xfinity.playerlib.R.string.content_description_video_options_announcement;
            s = getString(com.xfinity.playerlib.R.string.content_description_sap);
            videoplayerfragment1 = VideoPlayerFragment.this;
            if (flag1)
            {
                i = com.xfinity.playerlib.R.string.content_description_available;
            } else
            {
                i = com.xfinity.playerlib.R.string.content_description_not_available;
            }
            obj = ((StringBuilder) (obj)).append(videoplayerfragment.getString(j, new Object[] {
                s, videoplayerfragment1.getString(i)
            })).toString();
            alternateInterfaceListener.getTalkDelegate().speak(((String) (obj)));
        }

        public void clearBackStack()
        {
        }

        public void configurePlaybackControls()
        {
            if (isLiveStream())
            {
                configureControlsForLiveStream();
                return;
            } else
            {
                configureControlsForVOD();
                return;
            }
        }

        public void dismissDialog(String s)
        {
            s = (DialogFragment)getFragmentManager().findFragmentByTag(s);
            if (s != null && s.isVisible())
            {
                s.dismiss();
            }
        }

        public void dismissDialogs()
        {
            dismissDialog("ccselectionlistdialog");
            dismissDialog("sapselectionlistdialog");
        }

        public RelativeLayout getCContainer()
        {
            return ccContainer;
        }

        protected int getProgress(long l, long l1)
        {
            return (int)(1000D * ((double)l / (double)l1));
        }

        public boolean hasShownRatingsBug()
        {
            return hasShownRatingsBug;
        }

        public void hideActionBar()
        {
            getActivity().getActionBar().hide();
        }

        protected void hideActionBarMenus()
        {
            menuTabs.setVisibility(4);
        }

        public void hideAdControls()
        {
            adsActionBar.setVisibility(8);
        }

        public void hideAdView()
        {
            adView.setVisibility(8);
            if (!isClickableAdsButtonVisibile())
            {
                startMainControlTimeout();
            }
            videoStateController.getMediaPlayer().play();
        }

        public void hideAllControls()
        {
            if (accessibilityUtil.isAccessibilityEnabled() && manualControlToggleOn)
            {
                return;
            } else
            {
                changeAccessibilityControlToggleContentDescription(com.xfinity.playerlib.R.string.content_description_toggle_control_instructions_on);
                hideMainControls();
                hideActionBar();
                turnLightsOut();
                return;
            }
        }

        public void hideClickableAdButton()
        {
            clickableAdButton.setVisibility(8);
        }

        public abstract void hideInfoPanel();

        public void hideLaunchMaturityRating()
        {
            startupMatureContentWarning.setVisibility(8);
            startupMatureContentRating.setVisibility(8);
        }

        public void hideLaunchScreen()
        {
            startupDialog.setVisibility(8);
        }

        public void hideMainControls()
        {
            progressBarLayout.setVisibility(4);
            thumbTime.setVisibility(8);
            volumeSliderLayout.setVisibility(4);
            brightnessSliderLayout.setVisibility(8);
        }

        public void hideMainControlsAndActionBar()
        {
            hideMainControls();
            hideActionBar();
        }

        public void hidePinPadFragment(com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener)
        {
            pinvalidationcompletedlistener.onPinValidationComplete(true);
            setLandscapeOrientation();
            parentalControlPinFragment = null;
        }

        public void hideSpinner()
        {
            alternateInterfaceListener.getTalkDelegate().cancelAllMessages();
            bufferingProgress.setVisibility(8);
        }

        public boolean isAccessibilityModeOn()
        {
            return accessibilityUtil.isAccessibilityEnabled();
        }

        public boolean isAdViewVisible()
        {
            return adView.getVisibility() == 0;
        }

        public boolean isAdsActionBarAdjustedForStatusBar()
        {
            return VideoPlayerFragment.this.isAdsActionBarAdjustedForStatusBar;
        }

        public boolean isClickableAdsButtonVisibile()
        {
            return clickableAdButton.getVisibility() == 0;
        }

        public boolean isDialogShowing()
        {
            SAPSelectionListDialogFragment sapselectionlistdialogfragment = (SAPSelectionListDialogFragment)getFragmentManager().findFragmentByTag("sapselectionlistdialog");
            return sapselectionlistdialogfragment != null && sapselectionlistdialogfragment.isVisible();
        }

        public boolean isMainControlShowing()
        {
            return progressBarLayout.getVisibility() == 0;
        }

        public boolean isManualControlToggleOn()
        {
            return manualControlToggleOn;
        }

        public void moveAdsActionBarDown(boolean flag)
        {
            if (flag)
            {
                adsActionBar.animate().y(adsActionBar.getTranslationY() + (float)adsActionBar.getStatusBarHeight()).setDuration(150L);
            } else
            {
                adsActionBar.adjustForStatusBar();
            }
            VideoPlayerFragment.this.isAdsActionBarAdjustedForStatusBar = true;
        }

        public void moveAdsActionBarUp(boolean flag)
        {
            if (flag)
            {
                adsActionBar.animate().y(adsActionBar.getTranslationY() - (float)adsActionBar.getStatusBarHeight()).setDuration(500L);
            } else
            {
                adsActionBar.adjustForFullScreen();
            }
            VideoPlayerFragment.this.isAdsActionBarAdjustedForStatusBar = false;
        }

        public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
label0:
            {
                if (flag)
                {
                    if (Math.abs(i - seekLastProgress) <= 200)
                    {
                        allowSeek = true;
                    }
                    if (!allowSeek)
                    {
                        break label0;
                    }
                    videoStateController.onUserMovedSeekBar(i);
                    seekLastProgress = i;
                }
                return;
            }
            seekbar.setProgress(seekLastProgress);
        }

        public void onStartTrackingTouch(SeekBar seekbar)
        {
            videoStateController.onUserSeekStarted();
            allowSeek = false;
            seekLastProgress = seekbar.getProgress();
        }

        public void onStopTrackingTouch(SeekBar seekbar)
        {
            if (allowSeek)
            {
                long l = videoStateController.getMediaPlayer().getDuration();
                int i = getProgressTime(seekbar.getProgress(), l);
                thumbTime.setVisibility(8);
                videoStateController.onSeekRequest(i);
            }
            videoStateController.onUserSeekEnded(allowSeek);
        }

        public void popFragmentFromBackStack(String s)
        {
            getActivity().getFragmentManager().popBackStack(s, 1);
        }

        public void removeMainControlTimeout()
        {
            VideoPlayerFragment.LOG.debug("#@@@UIController: removeMainControlTimeout");
            handler.removeCallbacks(clearPlayerControlsRunner);
        }

        public void removeVideoView()
        {
            playerFrame.removeAllViews();
        }

        public void removeVolumeControlTimeout()
        {
            VideoPlayerFragment.LOG.debug("#@@@UIController: removeVolumeControlTimeout");
            handler.removeCallbacks(clearVolumeControlRunner);
        }

        public void reset()
        {
            resetProgressInfo();
            hideInfoPanel();
            hideAllControls();
            hideAdControls();
            hideSpinner();
            hideLaunchMaturityRating();
            stopRatingsBug();
            hasShownRatingsBug = false;
            removeVideoView();
            setLaunchScreenMessage(com.xfinity.playerlib.R.string.player_launch_starting);
            showLaunchScreen();
            setSAPButtonSelected(false);
        }

        public void resetProgressInfo()
        {
            isSeeking = false;
            allowSeek = false;
            updateProgressInfo(0L, 0L);
        }

        public void setCCButtonEnabled(boolean flag)
        {
            ccButton.setEnabled(flag);
            ccButton.setClickable(flag);
        }

        public void setCCButtonSelected(boolean flag)
        {
            ccButton.setSelected(flag);
            Object obj = ccButton;
            VideoPlayerFragment videoplayerfragment = VideoPlayerFragment.this;
            int i;
            if (flag)
            {
                i = com.xfinity.playerlib.R.string.content_description_cc_selected;
            } else
            {
                i = com.xfinity.playerlib.R.string.content_description_cc_button;
            }
            ((ImageView) (obj)).setContentDescription(videoplayerfragment.getString(i));
            obj = alternateInterfaceListener.getTalkDelegate();
            if (flag)
            {
                i = com.xfinity.playerlib.R.string.content_description_cc_on;
            } else
            {
                i = com.xfinity.playerlib.R.string.content_description_cc_off;
            }
            ((TalkDelegate) (obj)).speak(i);
        }

        public void setCCButtonVisibility(int i)
        {
            ccButton.setVisibility(i);
        }

        public void setInfoTabIcon()
        {
            ImageView imageview = (ImageView)babyGuideMenu.findViewById(com.xfinity.playerlib.R.id.menu_guide_icon);
            if (isLiveStream())
            {
                imageview.setImageResource(com.xfinity.playerlib.R.drawable.ico_guide_streaming);
                return;
            } else
            {
                imageview.setImageResource(com.xfinity.playerlib.R.drawable.ico_guide_playback);
                return;
            }
        }

        public void setIsSeeking(Boolean boolean1)
        {
            isSeeking = boolean1.booleanValue();
        }

        public void setLaunchMaturityRating(VideoFacade videofacade)
        {
            if (videofacade != null)
            {
                videofacade = videofacade.getVideoRating();
                if (videofacade != null && videofacade.isMature())
                {
                    startupMatureContentWarning.setVisibility(0);
                    startupMatureContentRating.setVisibility(0);
                    startupMatureContentRating.setText((new StringBuilder()).append("Video Rated ").append(videofacade.getRating().toUpperCase(Locale.US)).toString());
                }
            }
        }

        public void setLaunchScreenMessage(int i)
        {
            startupMessaging.setText(i);
            alternateInterfaceListener.getTalkDelegate().speak(i);
        }

        public void setNetworkInfo(String s, String s1)
        {
            networkName.setText(s1);
            networkName.setVisibility(0);
            if (s != null)
            {
                int i = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.network_logo_live_src_width);
                int j = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.network_logo_live_src_height);
                networkLogoLoader.loadImage(HalLiveStream.getArtworkUrl(s, i, j), networkLogo, new com.comcast.cim.android.image.CimImageLoader.OnLoadListener() {

                    final PlayerUIController this$1;

                    public void onLoad(ImageView imageview, String s, Bitmap bitmap)
                    {
                        networkName.setVisibility(8);
                        networkLogo.setVisibility(0);
                    }

                    public void onLoadError(ImageView imageview, String s)
                    {
                        networkLogo.setVisibility(8);
                        networkName.setVisibility(0);
                    }

            
            {
                this$1 = PlayerUIController.this;
                super();
            }
                });
                return;
            } else
            {
                networkLogo.setVisibility(8);
                networkName.setVisibility(0);
                return;
            }
        }

        public void setSAPButtonEnabled(boolean flag)
        {
            sapButton.setEnabled(flag);
            sapButton.setClickable(flag);
        }

        public void setSAPButtonSelected(boolean flag)
        {
            sapButton.setSelected(flag);
        }

        public void setSAPButtonVisibility(int i)
        {
            sapButton.setVisibility(i);
        }

        public void setVideoDuration(long l)
        {
            if (videoStateController.isLiveStream())
            {
                videoDuration.setText(getString(com.xfinity.playerlib.R.string.placeholder_live));
                videoDuration.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_live));
                return;
            } else
            {
                String s = videoPlayUtil.getDisplayTime((int)l, (int)l);
                videoDuration.setText(s);
                s = UIPresentationUtil.getTimeForPlayer(getActivity(), (int)(l / 1000L));
                videoDuration.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_duration, new Object[] {
                    s
                }));
                return;
            }
        }

        public void setVideoTitle(String s)
        {
            boolean flag = isLiveStream();
            View view;
            StringBuilder stringbuilder;
            if (flag)
            {
                onNow.setText(com.xfinity.playerlib.R.string.live_tv);
            } else
            {
                onNow.setText(com.xfinity.playerlib.R.string.on_now);
            }
            view = title.getRootView().findViewById(com.xfinity.playerlib.R.id.watching_speech);
            stringbuilder = new StringBuilder((String)onNow.getText());
            if (flag)
            {
                title.setVisibility(8);
            } else
            {
                title.setVisibility(0);
                title.setText(s);
                stringbuilder.append(s);
            }
            view.setContentDescription(stringbuilder.toString());
        }

        public void setWaitingForInternetText()
        {
            bufferingText.setText(com.xfinity.playerlib.R.string.waiting_for_internet);
            alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.string.waiting_for_internet);
        }

        public void setupAccessibilityControlToggle()
        {
            if (!firstTimePlayed)
            {
                firstTimePlayed = true;
                manualControlToggleOn = true;
                if (videoStateController.getMediaPlayer().getView() != null)
                {
                    accessibilityUtil.setImportantForAccessibility(videoStateController.getMediaPlayer().getView(), 1);
                }
                changeAccessibilityControlToggleContentDescription(com.xfinity.playerlib.R.string.content_description_toggle_control_instructions_off);
            }
        }

        public void setupAdBreaks(PlayerTimeline playertimeline)
        {
            if (!videoStateController.shouldUseDownloadFile() && videoStateController.getVideoAuthManager().getSmil().getAdsType() != com.xfinity.playerlib.authorization.SMILResource.AdsType.C3_ADS && playertimeline != null)
            {
                Iterator iterator = playertimeline.timelineMarkers();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    if (((TimelineMarker)iterator.next()).getTime() == 0L)
                    {
                        iterator.remove();
                    }
                } while (true);
            }
            programProgressBar.setMarkersAndDuration(playertimeline, videoStateController.getMediaPlayer().getDuration());
        }

        public void setupRatingsBug(VideoFacade videofacade)
        {
            if (videofacade != null && videofacade.getVideoRating() != null)
            {
                ratingsBug = new RatingsBug(getActivity(), videofacade);
                return;
            } else
            {
                ratingsBug = null;
                return;
            }
        }

        public void setupVideoView()
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(displaymetrics);
            } else
            {
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            }
            videoStateController.getMediaPlayer().setDimensionsOfVideo(displaymetrics.widthPixels, displaymetrics.heightPixels);
            VideoPlayerFragment.LOG.error((new StringBuilder()).append("Dimensions of player are : ").append(displaymetrics.widthPixels).append("w, ").append(displaymetrics.heightPixels).append("h").toString());
            playerFrame.addView(videoStateController.getMediaPlayer().getView());
            playerFrame.setOnClickListener(playerOnClickListener);
            videoStateController.getMediaPlayer().getView().setOnClickListener(new android.view.View.OnClickListener() {

                final PlayerUIController this$1;

                public void onClick(View view)
                {
                    if (accessibilityUtil.isAccessibilityEnabled())
                    {
                        if (videoStateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING)
                        {
                            view = _fld0;
                            boolean flag;
                            if (!manualControlToggleOn)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            view.manualControlToggleOn = flag;
                            if (manualControlToggleOn)
                            {
                                showMainControlsAndActionBar(false);
                                alternateInterfaceListener.getTalkDelegate().speak(com.xfinity.playerlib.R.string.content_description_toggle_control_instructions_off);
                                return;
                            } else
                            {
                                hideAllControls();
                                hideInfoPanel();
                                alternateInterfaceListener.getTalkDelegate().speak(com.xfinity.playerlib.R.string.content_description_toggle_control_instructions_on);
                                return;
                            }
                        } else
                        {
                            alternateInterfaceListener.getTalkDelegate().speak(com.xfinity.playerlib.R.string.content_description_toggle_controls_only_available_when_playing);
                            return;
                        }
                    } else
                    {
                        videoStateController.onScreenTouch();
                        return;
                    }
                }

            
            {
                this$1 = PlayerUIController.this;
                super();
            }
            });
        }

        protected void showActionBarMenus()
        {
            menuTabs.setVisibility(0);
        }

        public void showAdControls()
        {
            adsActionBar.setVisibility(0);
        }

        public void showAdControlsWithTimeLeft(long l)
        {
            showAdControls();
            updateAdTimeLeft(l);
        }

        public void showBuffering()
        {
            int i = com.xfinity.playerlib.R.string.buffering;
            boolean flag;
            if (!isDownloadedVideo())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showSpinnerWithText(i, flag);
        }

        public void showClickableAdButtonForUrl(String s, String s1)
        {
            clickableAdButton.setVisibility(0);
            clickableAdButton.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final PlayerUIController this$1;
                final String val$url;

                public void onClick(View view)
                {
                    removeMainControlTimeout();
                    videoStateController.getMediaPlayer().pause();
                    adView.setWebViewClient(new WebViewClient() {

                        boolean isFirstUrl;
                        final PlayerUIController._cls1 this$2;

                        public boolean shouldOverrideUrlLoading(WebView webview, String s)
                        {
                            if (isFirstUrl)
                            {
                                isFirstUrl = false;
                                webview.loadUrl(s);
                                return true;
                            } else
                            {
                                webview = new Intent("android.intent.action.VIEW");
                                webview.setData(Uri.parse(s));
                                startActivity(webview);
                                hideAdViewOnResume = true;
                                return true;
                            }
                        }

            
            {
                this$2 = PlayerUIController._cls1.this;
                super();
                isFirstUrl = true;
            }
                    });
                    adView.setVisibility(0);
                    adView.bringToFront();
                    adView.loadUrl(url);
                }

            
            {
                this$1 = final_playeruicontroller;
                url = String.this;
                super();
            }
            });
            if (s != null && s.length() > 0)
            {
                clickableAdButton.setText(s);
                return;
            } else
            {
                clickableAdButton.setText(com.xfinity.playerlib.R.string.clickable_ad_more_info);
                return;
            }
        }

        public abstract boolean showCurrentVideoInfo(String s);

        public void showErrorInPinPadFragment(com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener)
        {
            pinvalidationcompletedlistener.onPinValidationComplete(false);
        }

        public abstract boolean showFavorite(String s);

        public abstract void showFavoriteDetail(VideoFavorite videofavorite, String s);

        public abstract boolean showHistory(String s);

        public abstract void showHistoryItemDetail(VideoBookmark videobookmark, String s);

        public void showLaunchScreen()
        {
            startupDialog.setVisibility(0);
        }

        protected void showMainControls(boolean flag)
        {
            progressBarLayout.setVisibility(0);
            if (((PlayerUserSettings)userManager.getUserSettings()).getWantsVolumeControl())
            {
                volumeSliderLayout.setVisibility(0);
            }
            if (((PlayerUserSettings)userManager.getUserSettings()).getWantsBrightnessControl())
            {
                brightnessSliderLayout.setVisibility(0);
            }
            if (isLiveStream())
            {
                playButton.setVisibility(8);
                pauseButton.setVisibility(8);
            } else
            if (flag)
            {
                playButton.setVisibility(0);
                pauseButton.setVisibility(8);
                playButton.requestFocus();
            } else
            {
                playButton.setVisibility(8);
                pauseButton.setVisibility(0);
                pauseButton.requestFocus();
            }
            playerFrame.requestFocus();
        }

        public void showMainControlsWithPauseButton()
        {
            showMainControlsAndActionBar(false);
        }

        public void showMainControlsWithPlayButton()
        {
            showMainControlsAndActionBar(true);
        }

        public void showPinPadFragment()
        {
            FragmentTransaction fragmenttransaction;
            if (parentalControlPinFragment != null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            parentalControlPinFragment = new ParentalControlPinFragment();
            parentalControlPinFragment.setPinValidator(new com.comcast.cim.android.view.common.PinKeypadFragment.PinValidator() {

                final PlayerUIController this$1;

                public void validatePin(String s, com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener)
                {
                    VideoPlayerFragment.LOG.info((new StringBuilder()).append("User input pin: ").append(s).toString());
                    videoStateController.onValidatePin(s, pinvalidationcompletedlistener);
                }

            
            {
                this$1 = PlayerUIController.this;
                super();
            }
            });
            parentalControlPinFragment.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final PlayerUIController this$1;

                public void onCancel(DialogInterface dialoginterface)
                {
                    VideoPlayerFragment.LOG.debug("Pinpad canceled");
                    videoStateController.onPinCanceled();
                }

            
            {
                this$1 = PlayerUIController.this;
                super();
            }
            });
            fragmenttransaction = getActivity().getFragmentManager().beginTransaction();
            fragmenttransaction.addToBackStack(null);
            parentalControlPinFragment.show(fragmenttransaction, "dialog");
            return;
            IllegalStateException illegalstateexception;
            illegalstateexception;
            VideoPlayerFragment.LOG.error("Caught IllegalStateException when trying to show PinKeypadFragment, fragment manager is likely no longer valid because user has moved on", illegalstateexception);
            return;
        }

        public void showSAPSelectionDialog()
        {
            handler.post(new Runnable() {

                final PlayerUIController this$1;

                public void run()
                {
                    Object obj = videoStateController.getMediaPlayer();
                    Object obj1 = ((_cls1) (obj)). new com.comcast.cim.android.view.common.SelectionListDialogFragment.OnSelectionChangedListener() {

                        final PlayerUIController._cls7 this$2;
                        final PlayerPlatformMediaPlayer val$mediaPlayer;

                        public void onSelectionChanged(int i)
                        {
                            mediaPlayer.setLanguage(i);
                            ImageView imageview = sapButton;
                            boolean flag;
                            if (i != 0)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            imageview.setSelected(flag);
                        }

            
            {
                this$2 = final__pcls7;
                mediaPlayer = PlayerPlatformMediaPlayer.this;
                super();
            }
                    };
                    List list = videoStateController.getMediaPlayer().getAvailableLanguages();
                    obj = new SAPSelectionListDialogFragment(list.indexOf(((PlayerPlatformMediaPlayer) (obj)).getLanguage()), sapButton, ((com.comcast.cim.android.view.common.SelectionListDialogFragment.OnSelectionChangedListener) (obj1)), selectionDialogOnCancelListener, selectionDialogOnKeyListener, getActivity().getActionBar().getHeight());
                    obj1 = getActivity().getFragmentManager().beginTransaction();
                    ((FragmentTransaction) (obj1)).addToBackStack(null);
                    try
                    {
                        Bundle bundle = new Bundle();
                        bundle.putStringArray("data", (String[])list.toArray(new String[list.size()]));
                        ((SAPSelectionListDialogFragment) (obj)).setArguments(bundle);
                        ((SAPSelectionListDialogFragment) (obj)).show(((FragmentTransaction) (obj1)), "sapselectionlistdialog");
                        return;
                    }
                    catch (IllegalStateException illegalstateexception)
                    {
                        VideoPlayerFragment.LOG.error("Caught IllegalStateException when trying to show SAPSelectionListDialogFragment, fragment manager is likely no longer valid because user has moved on", illegalstateexception);
                    }
                }

            
            {
                this$1 = PlayerUIController.this;
                super();
            }
            });
        }

        public void showSeeking()
        {
            int i = com.xfinity.playerlib.R.string.seeking;
            boolean flag;
            if (!isDownloadedVideo())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showSpinnerWithText(i, flag);
        }

        public abstract void showSeriesWatchableDetail(SeriesWatchable serieswatchable, String s);

        public void showSpinnerWithText(int i, boolean flag)
        {
            if (!flag || videoStateController.getInternetConnection().isConnected())
            {
                bufferingText.setText(i);
                alternateInterfaceListener.getTalkDelegate().speakManagedMessage(i);
            } else
            {
                setWaitingForInternetText();
            }
            bufferingProgress.setVisibility(0);
        }

        public void showThumbTimeView(int i)
        {
            thumbTime.setVisibility(0);
            setThumbTimeView(i);
        }

        public void startAdsActionBarTimeout()
        {
            VideoPlayerFragment.LOG.debug("#@@@UIController: startAdsActionBarTimeout");
            if (!VideoPlayerFragment.this.isAdsActionBarAdjustedForStatusBar)
            {
                moveAdsActionBarDown(true);
            }
            handler.removeCallbacks(moveUpAdsActionBarRunner);
            handler.postDelayed(moveUpAdsActionBarRunner, 3000L);
        }

        public void startMainControlTimeout()
        {
            VideoPlayerFragment.LOG.debug("#@@@UIController: startMainControlTimeout");
            if (!accessibilityUtil.isAccessibilityEnabled())
            {
                handler.removeCallbacks(clearPlayerControlsRunner);
                handler.postDelayed(clearPlayerControlsRunner, 3000L);
            }
        }

        public void startRatingsBug()
        {
            hasShownRatingsBug = true;
            if (ratingsBug != null)
            {
                ratingsBug.start();
            }
        }

        public void startVolumeControlTimeout()
        {
            VideoPlayerFragment.LOG.debug("#@@@UIController: startVolumeControlTimeout");
            if (!accessibilityUtil.isAccessibilityEnabled())
            {
                handler.removeCallbacks(clearVolumeControlRunner);
                handler.postDelayed(clearVolumeControlRunner, 3000L);
            }
        }

        public void stopRatingsBug()
        {
            if (ratingsBug != null)
            {
                ratingsBug.stop();
            }
        }

        public void styleClosedCaptions()
        {
label0:
            {
                if (videoStateController != null && videoStateController.getMediaPlayer() != null)
                {
                    if (android.os.Build.VERSION.SDK_INT < 19)
                    {
                        break label0;
                    }
                    CaptioningManager captioningmanager = (CaptioningManager)getActivity().getSystemService("captioning");
                    videoStateController.getMediaPlayer().styleClosedCaptions(captioningmanager);
                }
                return;
            }
            videoStateController.getMediaPlayer().styleClosedCaptions((PlayerUserSettings)userManager.getUserSettings());
        }

        public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
        {
        }

        public void surfaceCreated(SurfaceHolder surfaceholder)
        {
            videoStateController.onPlayerSurfaceCreated(surfaceholder);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceholder)
        {
        }

        public void toggleStats()
        {
            if (statsView.getVisibility() == 0)
            {
                statsView.setVisibility(8);
                return;
            } else
            {
                statsView.setVisibility(0);
                return;
            }
        }

        public void turnLightsOn()
        {
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                playerLayout.setSystemUiVisibility(256);
                return;
            } else
            {
                getActivity().getWindow().getDecorView().setSystemUiVisibility(0);
                return;
            }
        }

        public void turnLightsOut()
        {
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                playerLayout.setSystemUiVisibility(262);
                return;
            } else
            {
                getActivity().getWindow().getDecorView().setSystemUiVisibility(2);
                return;
            }
        }

        public void updateAdTimeLeft(long l)
        {
            if (!isSeeking) goto _L2; else goto _L1
_L1:
            adsCountDown.setText("");
_L4:
            return;
_L2:
            int j;
            j = (int)(l / 1000L);
            if (j != 0)
            {
                break; /* Loop/switch isn't completed */
            }
            adsCountDown.setText(com.xfinity.playerlib.R.string.ad_resuming);
            adAnnouced = false;
            if (accessibilityUtil.isAccessibilityEnabled() && !adZeroSeconds)
            {
                adZeroSeconds = true;
                announceAdState(adsCountDown.getText().toString());
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (j <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            adZeroSeconds = false;
            if (j >= 60)
            {
                int i = j / 60;
                j %= 60;
                if (j == 0)
                {
                    adsCountDown.setText(getResources().getQuantityString(com.xfinity.playerlib.R.plurals.ad_minutes_time_left, i, new Object[] {
                        Integer.valueOf(i), ""
                    }));
                } else
                {
                    adsCountDown.setText(getResources().getQuantityString(com.xfinity.playerlib.R.plurals.ad_minutes_time_left, i, new Object[] {
                        Integer.valueOf(i), getResources().getQuantityString(com.xfinity.playerlib.R.plurals.ad_extra_seconds_left, j, new Object[] {
                            Integer.valueOf(j)
                        })
                    }));
                }
            } else
            {
                adsCountDown.setText(getResources().getQuantityString(com.xfinity.playerlib.R.plurals.ad_time_left, j, new Object[] {
                    Integer.valueOf(j)
                }));
            }
            if (accessibilityUtil.isAccessibilityEnabled() && !adAnnouced)
            {
                adAnnouced = true;
                announceAdState(adsCountDown.getText().toString());
                return;
            }
            if (true) goto _L4; else goto _L5
_L5:
            adsCountDown.setText(com.xfinity.playerlib.R.string.ad_unknown_time_left);
            if (accessibilityUtil.isAccessibilityEnabled() && !adAnnouced)
            {
                adAnnouced = true;
                announceAdState(adsCountDown.getText().toString());
                return;
            }
            if (true) goto _L4; else goto _L6
_L6:
        }

        public void updateCurrentBitrate(long l)
        {
            bitrateTextView.setText((new StringBuilder()).append("bitrate: ").append(l).toString());
        }

        public void updateProgress()
        {
            if (!isSeeking && !videoStateController.isLiveStream())
            {
                updateProgressInfo(videoStateController.getMediaPlayer().getPosition(), videoStateController.getMediaPlayer().getDuration());
            }
        }


        public PlayerUIController()
        {
            this$0 = VideoPlayerFragment.this;
            super();
            isSeeking = false;
            moveUpAdsActionBarRunner = new _cls2();
            clearPlayerControlsRunner = new _cls3();
            clearVolumeControlRunner = new _cls4();
            selectionDialogOnCancelListener = new _cls10();
            selectionDialogOnKeyListener = new _cls11();
            programProgressBar.setMax(1000);
            programProgressBar.setOnSeekBarChangeListener(this);
        }
    }

    private class TabletPlayerUIController extends PlayerUIController
    {

        Fragment infoFragment;
        final VideoPlayerFragment this$0;

        private View getMenuLayout(BabyGuideType babyguidetype)
        {
            LinearLayout linearlayout = null;
            if (babyguidetype == null) goto _L2; else goto _L1
_L1:
            if (!babyguidetype.equals(BabyGuideType.BOOKMARKS)) goto _L4; else goto _L3
_L3:
            linearlayout = favoriteMenu;
_L5:
            return linearlayout.getChildAt(0);
_L4:
            if (babyguidetype.equals(BabyGuideType.HISTORY))
            {
                linearlayout = historyMenu;
            } else
            if (babyguidetype.equals(BabyGuideType.INFO))
            {
                linearlayout = babyGuideMenu;
            }
            if (true) goto _L5; else goto _L2
_L2:
            return null;
        }

        private boolean isFragmentInBackStack(String s)
        {
            FragmentManager fragmentmanager = getActivity().getFragmentManager();
            for (int i = 0; i < fragmentmanager.getBackStackEntryCount(); i++)
            {
                if (s.equals(fragmentmanager.getBackStackEntryAt(i).getName()))
                {
                    return true;
                }
            }

            return false;
        }

        private void selectBabyGuideItem(BabyGuideType babyguidetype)
        {
            selectedBabyGuideMenu = babyguidetype;
            if (accessibilityUtil.isAccessibilityEnabled())
            {
                Object obj = getMenuLayout(selectedBabyGuideMenu);
                if (obj != null)
                {
                    ((View) (obj)).setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_x_button, new Object[] {
                        getString(selectedBabyGuideMenu.getCaptionResId())
                    }));
                }
                babyguidetype = getMenuLayout(babyguidetype);
                obj = getString(com.xfinity.playerlib.R.string.content_description_button_state_selected, new Object[] {
                    getString(selectedBabyGuideMenu.getCaptionResId())
                });
                babyguidetype.setContentDescription(((CharSequence) (obj)));
                alternateInterfaceListener.getTalkDelegate().speak(((String) (obj)));
            }
        }

        private void showItem(String s, Fragment fragment)
        {
            infoFragment = fragment;
            FragmentManager fragmentmanager = getActivity().getFragmentManager();
            FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
            Object obj = infoFragment.getArguments();
            fragment = ((Fragment) (obj));
            if (obj == null)
            {
                fragment = new Bundle();
            }
            obj = videoStateController.getVideoFacade();
            if (obj != null)
            {
                fragment.putLong("EXTRA_CURRENT_WATCH_VIDEO_ID", ((VideoFacade) (obj)).getVideoId());
            }
            fragment.putBoolean(HistoryFragment.EXTRA_BABY_GUIDE_MODE, true);
            infoFragment.setArguments(fragment);
            fragmenttransaction.replace(com.xfinity.playerlib.R.id.info_panel, infoFragment);
            fragmenttransaction.addToBackStack(s);
            fragmenttransaction.commit();
            fragmentmanager.executePendingTransactions();
            infoPanel.setVisibility(0);
            if (accessibilityUtil.isAccessibilityEnabled())
            {
                accessibilityUtil.setImportantForAccessibility(videoStateController.getMediaPlayer().getView(), 2);
            }
        }

        private void showItemDetail(String s, Fragment fragment)
        {
            if (!isFragmentInBackStack(s))
            {
                FragmentTransaction fragmenttransaction = getActivity().getFragmentManager().beginTransaction();
                fragmenttransaction.setCustomAnimations(com.xfinity.playerlib.R.anim.slide_in_right, com.xfinity.playerlib.R.anim.slide_out_left, com.xfinity.playerlib.R.anim.slide_in_left, com.xfinity.playerlib.R.anim.slide_out_right);
                fragmenttransaction.replace(com.xfinity.playerlib.R.id.info_panel, fragment);
                fragmenttransaction.addToBackStack(s);
                fragmenttransaction.commit();
            }
        }

        public void clearBackStack()
        {
            FragmentManager fragmentmanager = getActivity().getFragmentManager();
            Fragment fragment = fragmentmanager.findFragmentById(com.xfinity.playerlib.R.id.info_panel);
            if (fragment instanceof AnimatedFragment)
            {
                ((AnimatedFragment)fragment).setAnimationEnabled(Boolean.valueOf(false));
            }
            fragmentmanager.popBackStack(null, 1);
        }

        public void hideInfoPanel()
        {
            babyGuideMenu.setSelected(false);
            historyMenu.setSelected(false);
            favoriteMenu.setSelected(false);
            clearBackStack();
            handler.post(new Runnable() {

                final TabletPlayerUIController this$1;

                public void run()
                {
                    handler.post(new Runnable() {

                        final TabletPlayerUIController._cls1 this$2;

                        public void run()
                        {
                            infoPanel.setVisibility(8);
                        }

            
            {
                this$2 = TabletPlayerUIController._cls1.this;
                super();
            }
                    });
                }

            
            {
                this$1 = TabletPlayerUIController.this;
                super();
            }
            });
            if (accessibilityUtil.isAccessibilityEnabled())
            {
                accessibilityUtil.setImportantForAccessibility(videoStateController.getMediaPlayer().getView(), 1);
                announceBabyGuideClosed(selectedBabyGuideMenu);
            }
            selectedBabyGuideMenu = null;
        }

        public void hideMainControls()
        {
            super.hideMainControls();
            pauseButton.setVisibility(8);
            playButton.setVisibility(8);
        }

        public boolean showCurrentVideoInfo(String s)
        {
            babyGuideMenu.setSelected(true);
            historyMenu.setSelected(false);
            favoriteMenu.setSelected(false);
            selectBabyGuideItem(BabyGuideType.INFO);
            Object obj = videoStateController.getVideoFacade();
            if (obj != null)
            {
                com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder builder = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(((VideoFacade) (obj)))).currentlyPlayingVideo(Long.valueOf(((VideoFacade) (obj)).getVideoId())).showPanelFittedLayout(true);
                if (((VideoFacade) (obj)).getProgramId().getNamespace().equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie))
                {
                    obj = com.xfinity.playerlib.model.MerlinId.Namespace.Movie;
                } else
                {
                    obj = com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries;
                }
                obj = builder.overrideNamespace(((com.xfinity.playerlib.model.MerlinId.Namespace) (obj))).build().getFragment();
            } else
            {
                Bundle bundle = new Bundle();
                bundle.putInt("numColumns", 1);
                bundle.putBoolean("inBabyGuide", true);
                obj = new LiveStreamsFragment();
                ((Fragment) (obj)).setArguments(bundle);
            }
            s = (new StringBuilder()).append(s).append("_info").toString();
            if (!isFragmentInBackStack(s))
            {
                clearBackStack();
                showItem(s, ((Fragment) (obj)));
            }
            return false;
        }

        public boolean showFavorite(String s)
        {
            favoriteMenu.setSelected(true);
            babyGuideMenu.setSelected(false);
            historyMenu.setSelected(false);
            selectBabyGuideItem(BabyGuideType.BOOKMARKS);
            s = (new StringBuilder()).append(s).append("_favorites").toString();
            if (!isFragmentInBackStack(s))
            {
                clearBackStack();
                showItem(s, new BookmarksFragment());
            }
            return false;
        }

        public void showFavoriteDetail(VideoFavorite videofavorite, String s)
        {
            VideoFacade videofacade = videoStateController.getVideoFacade();
            videofavorite = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(videofavorite)).showPanelFittedLayout(true);
            if (videofacade != null)
            {
                videofavorite.currentlyPlayingVideo(Long.valueOf(videofacade.getVideoId()));
            }
            infoFragment = videofavorite.build().getFragment();
            showItemDetail(s, infoFragment);
        }

        public boolean showHistory(String s)
        {
            historyMenu.setSelected(true);
            babyGuideMenu.setSelected(false);
            favoriteMenu.setSelected(false);
            selectBabyGuideItem(BabyGuideType.HISTORY);
            s = (new StringBuilder()).append(s).append("_history").toString();
            if (!isFragmentInBackStack(s))
            {
                clearBackStack();
                showItem(s, new HistoryFragment());
            }
            return false;
        }

        public void showHistoryItemDetail(VideoBookmark videobookmark, String s)
        {
            VideoFacade videofacade = videoStateController.getVideoFacade();
            com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder builder = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(videobookmark)).shouldHideSeriesTitle(false).showPanelFittedLayout(true);
            if (videobookmark.getMerlinId().getNamespace().equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie))
            {
                videobookmark = com.xfinity.playerlib.model.MerlinId.Namespace.Movie;
            } else
            {
                videobookmark = com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries;
            }
            videobookmark = builder.overrideNamespace(videobookmark);
            if (videofacade != null)
            {
                videobookmark.currentlyPlayingVideo(Long.valueOf(videofacade.getVideoId()));
            }
            infoFragment = videobookmark.build().getFragment();
            showItemDetail(s, infoFragment);
        }

        public void showSeriesWatchableDetail(SeriesWatchable serieswatchable, String s)
        {
            infoPanel.setVisibility(0);
            FragmentTransaction fragmenttransaction = getActivity().getFragmentManager().beginTransaction();
            infoPanel.clearAnimation();
            fragmenttransaction.setCustomAnimations(com.xfinity.playerlib.R.anim.slide_in_right, com.xfinity.playerlib.R.anim.slide_out_left, com.xfinity.playerlib.R.anim.slide_in_left, com.xfinity.playerlib.R.anim.slide_out_right);
            serieswatchable = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(serieswatchable)).shouldHideSeriesTitle(true).overrideNamespace(com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode);
            if (videoStateController.getVideoFacade() != null)
            {
                serieswatchable.currentlyPlayingVideo(Long.valueOf(videoStateController.getVideoFacade().getVideoId()));
            } else
            {
                serieswatchable.isInBabyGuide(true);
            }
            infoFragment = serieswatchable.build().getFragment();
            fragmenttransaction.replace(com.xfinity.playerlib.R.id.info_panel, infoFragment);
            fragmenttransaction.addToBackStack(s);
            fragmenttransaction.commit();
        }

        public TabletPlayerUIController()
        {
            this$0 = VideoPlayerFragment.this;
            super();
        }
    }

    class VolumeSliderOnSeekBarChangeListener
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private int startVolume;
        final VideoPlayerFragment this$0;

        public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            flag = false;
            if (!isMuted)
            {
                mAudioManager.setStreamVolume(3, i, 0);
                if (isPhone)
                {
                    seekbar = volumeIndicator;
                    if (i > 0)
                    {
                        flag = true;
                    }
                    seekbar.setAppearEnabled(flag);
                }
                return;
            } else
            {
                mutedVolume = seekbar.getProgress();
                return;
            }
        }

        public void onStartTrackingTouch(SeekBar seekbar)
        {
            int i = seekbar.getProgress();
            playerUIController.removeMainControlTimeout();
            startVolume = i;
        }

        public void onStopTrackingTouch(SeekBar seekbar)
        {
            if (seekbar.getProgress() > startVolume && isMuted)
            {
                setMuteState(false);
            }
            videoStateController.onVolumeChanged();
        }

        VolumeSliderOnSeekBarChangeListener()
        {
            this$0 = VideoPlayerFragment.this;
            super();
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/videoplay/VideoPlayerFragment);
    private final AccessibilityUtil accessibilityUtil = PlayerContainer.getInstance().getAccessibilityUtil();
    private boolean adAnnouced;
    private WebView adView;
    private boolean adZeroSeconds;
    private ResponsiveRelativeLayout adsActionBar;
    private TextView adsCountDown;
    private android.media.AudioManager.OnAudioFocusChangeListener afChangeListener;
    private AlternateInterfaceListener alternateInterfaceListener;
    private final PlayerAndroidDevice androidDevice = PlayerContainer.getInstance().getAndroidDevice();
    private TextView audioOnlyView;
    private LinearLayout babyGuideMenu;
    private TextView bitrateTextView;
    protected CustomStateImageView brightnessIndicator;
    protected VerticalSeekBar brightnessSlider;
    protected LinearLayout brightnessSliderLayout;
    private LinearLayout bufferingProgress;
    private TextView bufferingText;
    private ImageView ccButton;
    private RelativeLayout ccContainer;
    private CimAssetFactory cimAssetFactory;
    private Button clickableAdButton;
    private BroadcastReceiver connectionTypeChangeReceiver;
    protected TextView currentTime;
    private final ErrorDialogFactory errorDialogFactory = PlayerContainer.getInstance().getErrorDialogFactory();
    private final ErrorFormatter errorFormatter = PlayerContainer.getInstance().getPlayerErrorFormatter();
    private LinearLayout favoriteMenu;
    private boolean firstTimePlayed;
    private final AnalyticsLogger foxLogger = PlayerContainer.getInstance().getFoxAnalyticsLogger();
    protected Handler handler;
    private BroadcastReceiver headsetNoiseReceiver;
    private boolean hideAdViewOnResume;
    private LinearLayout historyMenu;
    private final HttpClient httpClient = PlayerContainer.getInstance().getHttpClient();
    private LinearLayout infoPanel;
    private final InternetConnection internetConnection = PlayerContainer.getInstance().getInternetConnection();
    private boolean isAdsActionBarAdjustedForStatusBar;
    private boolean isMuted;
    private boolean isPhone;
    private ViewGroup layout;
    private final LiveStreamBookmarkDAO liveStreamBookmarkDAO = PlayerContainer.getInstance().getLiveStreamBookmarkDAO();
    private final TaskFactory liveStreamMetaDataResourceFactory = PlayerContainer.getInstance().getLiveStreamMetaDataResourceFactory();
    private final Task liveStreamResourceCache = PlayerContainer.getInstance().getLiveStreamResourceCache();
    private AudioManager mAudioManager;
    private int mLastSystemVisibility;
    private ComponentName mRemoteControlResponder;
    private boolean manualControlToggleOn;
    private LinearLayout menuTabs;
    private final TaskFactory movieCacheMap = PlayerContainer.getInstance().getMovieCacheMap();
    protected CustomStateImageView muteButton;
    private int mutedVolume;
    private ImageView networkLogo;
    private final NetworkLogoImageLoader networkLogoLoader = PlayerContainer.getInstance().createNetworkLogoImageLoader();
    private TextView networkName;
    private TextView onNow;
    private final Task parentalControlsCache = PlayerContainer.getInstance().getParentalControlsCache();
    protected ImageView pauseButton;
    protected ImageView playButton;
    private final PlayerApplication playerApplication = PlayerContainer.getInstance().getApplication();
    private final PlayerConfigUtil playerConfigUtil = PlayerContainer.getInstance().getPlayerConfigUtil();
    private ViewGroup playerControls;
    private final PlayerDownloadServiceManager playerDownloadServiceManager = PlayerContainer.getInstance().getDownloadServiceManager();
    private FrameLayout playerFrame;
    private RelativeLayout playerLayout;
    private android.view.View.OnClickListener playerOnClickListener;
    private android.view.View.OnSystemUiVisibilityChangeListener playerOnSystemUiVisibilityChangeListener;
    private PlayerUIController playerUIController;
    protected TimelineSeekBar programProgressBar;
    private LinearLayout progressBarLayout;
    private BroadcastReceiver remoteControlKeyReceiver;
    private ImageView sapButton;
    private BabyGuideType selectedBabyGuideMenu;
    private final TaskFactory seriesCacheMap = PlayerContainer.getInstance().getSeriesCacheMap();
    private SpeechListener speechListener;
    private final AnalyticsLogger splunker = PlayerContainer.getInstance().getSplunkLogger();
    ViewGroup startupDialog;
    TextView startupMatureContentRating;
    TextView startupMatureContentWarning;
    TextView startupMessaging;
    private View statsView;
    private final TaskExecutorFactory taskExecutorFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
    private TextView thumbTime;
    private TextView title;
    private PlayNowTrackingService trackingService;
    private final Executor uiThreadExecutor = PlayerContainer.getInstance().getUiThreadExecutor();
    private final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();
    private final VideoAuthManager videoAuthManager = PlayerContainer.getInstance().getVideoAuthManager();
    private final VideoBookmarkDAO videoBookmarkDAO = PlayerContainer.getInstance().getVideoBookmarkDAO();
    protected TextView videoDuration;
    private final Task videoEntitlementCache = PlayerContainer.getInstance().getVideoEntitlementCache();
    private final VideoPlayUtil videoPlayUtil = PlayerContainer.getInstance().getVideoPlayUtil();
    private boolean videoPlayingBeforeSpeechSwipe;
    private VideoStateController videoStateController;
    protected CustomStateImageView volumeIndicator;
    protected VerticalSeekBar volumeSlider;
    protected LinearLayout volumeSliderLayout;
    private final WatchableCodec watchableCodec = PlayerContainer.getInstance().getWatchableCodec();

    public VideoPlayerFragment()
    {
        mLastSystemVisibility = -1;
        cimAssetFactory = PlayerContainer.getInstance().getCimAssetFactory();
        trackingService = PlayerContainer.getInstance().getTrackingService();
        adAnnouced = false;
        adZeroSeconds = false;
        handler = new Handler();
        selectedBabyGuideMenu = null;
        manualControlToggleOn = true;
        firstTimePlayed = false;
        isMuted = false;
        videoPlayingBeforeSpeechSwipe = false;
        speechListener = new AdobePlayerFragmentSpeechListener();
        afChangeListener = new android.media.AudioManager.OnAudioFocusChangeListener() {

            final VideoPlayerFragment this$0;

            public void onAudioFocusChange(int i)
            {
                while (i == -2 || i == 1 || i != -1) 
                {
                    return;
                }
                mAudioManager.unregisterMediaButtonEventReceiver(mRemoteControlResponder);
                mAudioManager.abandonAudioFocus(afChangeListener);
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        };
        connectionTypeChangeReceiver = new BroadcastReceiver() {

            final VideoPlayerFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                VideoPlayerFragment.LOG.debug("@###CONNECTIVITY intent received");
                if (videoStateController != null && videoStateController.getDownloadedFile() == null)
                {
                    videoStateController.onConnectivityChanged();
                }
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        };
        remoteControlKeyReceiver = new BroadcastReceiver() {

            final VideoPlayerFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                if ("com.xfinity.playerlib.videoplay.KEY_PRESSED".equals(intent.getAction()) && videoStateController != null)
                {
                    context = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                    if (context.getAction() == 1)
                    {
                        videoStateController.onHeadsetButtonEvent(context.getKeyCode());
                    }
                }
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        };
        headsetNoiseReceiver = new BroadcastReceiver() {

            final VideoPlayerFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction()) && videoStateController != null)
                {
                    videoStateController.onHeadsetNoiseDetected();
                }
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        };
        playerOnClickListener = new android.view.View.OnClickListener() {

            final VideoPlayerFragment this$0;

            public void onClick(View view)
            {
                videoStateController.onScreenTouch();
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        };
        playerOnSystemUiVisibilityChangeListener = new android.view.View.OnSystemUiVisibilityChangeListener() {

            final VideoPlayerFragment this$0;

            public void onSystemUiVisibilityChange(int i)
            {
                if (mLastSystemVisibility != i)
                {
                    if ((i & 4) == 0)
                    {
                        videoStateController.onScreenTouch();
                    }
                    mLastSystemVisibility = i;
                }
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        };
    }

    private void changeAccessibilityControlToggleContentDescription(int i)
    {
        if (videoStateController.getMediaPlayer() != null && videoStateController.getMediaPlayer().getView() != null)
        {
            videoStateController.getMediaPlayer().getView().setContentDescription(getString(i));
        }
    }

    private void configureActionBar()
    {
        Activity activity = getActivity();
        menuTabs = (LinearLayout)activity.findViewById(com.xfinity.playerlib.R.id.menu_tabs);
        babyGuideMenu = (LinearLayout)activity.findViewById(com.xfinity.playerlib.R.id.menu_guide);
        babyGuideMenu.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoPlayerFragment this$0;

            public void onClick(View view)
            {
                if (selectedBabyGuideMenu == BabyGuideType.INFO)
                {
                    videoStateController.onBackButton();
                    return;
                } else
                {
                    videoStateController.onBabyGuideButton();
                    return;
                }
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        });
        historyMenu = (LinearLayout)activity.findViewById(com.xfinity.playerlib.R.id.menu_history);
        historyMenu.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoPlayerFragment this$0;

            public void onClick(View view)
            {
                if (selectedBabyGuideMenu == BabyGuideType.HISTORY)
                {
                    videoStateController.onBackButton();
                    return;
                } else
                {
                    videoStateController.onHistoryButton();
                    return;
                }
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        });
        favoriteMenu = (LinearLayout)activity.findViewById(com.xfinity.playerlib.R.id.menu_favorite);
        favoriteMenu.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoPlayerFragment this$0;

            public void onClick(View view)
            {
                if (selectedBabyGuideMenu == BabyGuideType.BOOKMARKS)
                {
                    videoStateController.onBackButton();
                    return;
                } else
                {
                    videoStateController.onFavoritesButton();
                    return;
                }
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        });
        title = (TextView)activity.findViewById(com.xfinity.playerlib.R.id.video_title);
        onNow = (TextView)activity.findViewById(com.xfinity.playerlib.R.id.on_now);
        onNow.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoPlayerFragment this$0;

            public void onClick(View view)
            {
                playerUIController.toggleStats();
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        });
    }

    private void configurePlayerControls()
    {
        Object obj1 = new AccelerateDecelerateInterpolator();
        Object obj = new AccelerateDecelerateInterpolator();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(null, "alpha", new float[] {
            0.0F, 1.0F
        });
        objectanimator.setDuration(400L);
        objectanimator.setStartDelay(0L);
        objectanimator.setInterpolator(((android.animation.TimeInterpolator) (obj1)));
        obj1 = ObjectAnimator.ofFloat(null, "alpha", new float[] {
            1.0F, 0.0F
        });
        ((ObjectAnimator) (obj1)).setDuration(400L);
        ((ObjectAnimator) (obj1)).setStartDelay(0L);
        ((ObjectAnimator) (obj1)).setInterpolator(((android.animation.TimeInterpolator) (obj)));
        obj = new LayoutTransition();
        ((LayoutTransition) (obj)).setAnimator(2, objectanimator);
        ((LayoutTransition) (obj)).setAnimator(0, null);
        ((LayoutTransition) (obj)).setAnimator(1, null);
        ((LayoutTransition) (obj)).setAnimator(3, ((android.animation.Animator) (obj1)));
        playerControls.setLayoutTransition(((LayoutTransition) (obj)));
        playButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoPlayerFragment this$0;

            public void onClick(View view)
            {
                videoStateController.onPlayButton();
                if (accessibilityUtil.isAccessibilityEnabled())
                {
                    alternateInterfaceListener.getTalkDelegate().speak(com.xfinity.playerlib.R.string.content_description_play_selected);
                }
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        });
        pauseButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoPlayerFragment this$0;

            public void onClick(View view)
            {
                videoStateController.onPauseButton();
                if (accessibilityUtil.isAccessibilityEnabled())
                {
                    alternateInterfaceListener.getTalkDelegate().speak(com.xfinity.playerlib.R.string.content_description_pause_selected);
                    changeAccessibilityControlToggleContentDescription(com.xfinity.playerlib.R.string.content_description_toggle_controls_are_visible);
                }
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        });
        playerUIController.configurePlaybackControls();
    }

    private void configureVolumeAndBrightnessControls()
    {
        currentTime.setLongClickable(true);
        currentTime.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final VideoPlayerFragment this$0;

            public boolean onLongClick(View view)
            {
                view = (PlayerUserSettings)userManager.getUserSettings();
                boolean flag;
                if (!((PlayerUserSettings)userManager.getUserSettings()).getWantsBrightnessControl())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setWantsBrightnessControl(flag);
                if (((PlayerUserSettings)userManager.getUserSettings()).getWantsBrightnessControl() && progressBarLayout.getVisibility() == 0)
                {
                    brightnessSliderLayout.setVisibility(0);
                } else
                if (!((PlayerUserSettings)userManager.getUserSettings()).getWantsBrightnessControl() && brightnessSliderLayout.getVisibility() == 0)
                {
                    brightnessSliderLayout.setVisibility(8);
                    return false;
                }
                return false;
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        });
        videoDuration.setLongClickable(true);
        videoDuration.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final VideoPlayerFragment this$0;

            public boolean onLongClick(View view)
            {
                view = (PlayerUserSettings)userManager.getUserSettings();
                boolean flag;
                if (!((PlayerUserSettings)userManager.getUserSettings()).getWantsVolumeControl())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setWantsVolumeControl(flag);
                updateVolumeSlider();
                if (((PlayerUserSettings)userManager.getUserSettings()).getWantsVolumeControl() && progressBarLayout.getVisibility() == 0)
                {
                    volumeSliderLayout.setVisibility(0);
                } else
                if (!((PlayerUserSettings)userManager.getUserSettings()).getWantsVolumeControl() && volumeSliderLayout.getVisibility() == 0)
                {
                    volumeSliderLayout.setVisibility(4);
                    return false;
                }
                return false;
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        });
        volumeSlider.setMax(mAudioManager.getStreamMaxVolume(3));
        updateVolumeSlider();
        volumeSlider.setOnVerticalSeekBarChangeListener(new VolumeSliderOnSeekBarChangeListener());
        muteButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoPlayerFragment this$0;

            public void onClick(View view)
            {
                view = VideoPlayerFragment.this;
                boolean flag;
                if (!isMuted)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setMuteState(flag);
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        });
        brightnessSlider.setOnVerticalSeekBarChangeListener(new BrightnessSliderOnSeekBarChangeListener());
    }

    private float getAdjustedBrightness(int i)
    {
        int j = i;
        if (i < 3)
        {
            j = 3;
        }
        return (float)j / 255F;
    }

    private boolean isLiveStream()
    {
        if (videoStateController != null)
        {
            return videoStateController.isLiveStream();
        } else
        {
            return getActivity().getIntent().getExtras().containsKey("liveStreamID");
        }
    }

    private void preventVolumeViewFromAnnouncingStateChanges()
    {
        accessibilityUtil.setImportantForAccessibility(volumeSlider, 2);
    }

    public void adjustVolume(int i)
    {
        volumeSliderLayout.setVisibility(0);
        if (isMuted)
        {
            if (i == 1)
            {
                setMuteState(false);
                return;
            }
            VerticalSeekBar verticalseekbar = volumeSlider;
            i = mutedVolume - 1;
            mutedVolume = i;
            verticalseekbar.setProgress(i);
        } else
        {
            int j = mAudioManager.getStreamVolume(3);
            if (i == 1)
            {
                i = 1;
            } else
            {
                i = -1;
            }
            volumeSlider.setProgress(j + i);
        }
        getActivity().getWindow().getDecorView().setSystemUiVisibility(1);
        videoStateController.onVolumeChanged();
    }

    protected Intent getCurrentVideoIntent()
    {
        if (videoStateController.isLiveStream())
        {
            Intent intent = new Intent(getActivity(), com/xfinity/playerlib/view/browseprograms/BabyGuideLiveStreamsActivity);
            intent.setFlags(0x50000000);
            return intent;
        }
        Object obj = videoStateController.getVideoFacade();
        com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder builder = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(((VideoFacade) (obj)))).loadAsActivity(true).currentlyPlayingVideo(Long.valueOf(((VideoFacade) (obj)).getVideoId()));
        if (((VideoFacade) (obj)).getProgramId().getNamespace().equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie))
        {
            obj = com.xfinity.playerlib.model.MerlinId.Namespace.Movie;
        } else
        {
            obj = com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries;
        }
        return builder.overrideNamespace(((com.xfinity.playerlib.model.MerlinId.Namespace) (obj))).build().getIntent(getActivity());
    }

    protected Intent getFavoriteIntent()
    {
        VideoFacade videofacade = videoStateController.getVideoFacade();
        Intent intent = new Intent(getActivity(), com/xfinity/playerlib/view/favorite/BabyGuideBookmarksActivity);
        intent.putExtra(BookmarksFragment.EXTRA_BABY_GUIDE_MODE, true);
        long l;
        if (videofacade != null)
        {
            l = videofacade.getVideoId();
        } else
        {
            l = 0L;
        }
        intent.putExtra("EXTRA_CURRENT_WATCH_VIDEO_ID", l);
        return intent;
    }

    protected Intent getHistoryIntent()
    {
        VideoFacade videofacade = videoStateController.getVideoFacade();
        Intent intent = new Intent(getActivity(), com/xfinity/playerlib/view/browsehistory/BabyGuideHistoryActivity);
        intent.putExtra(MultiDeleteBrowseFragment.EXTRA_BABY_GUIDE_MODE, true);
        long l;
        if (videofacade != null)
        {
            l = videofacade.getVideoId();
        } else
        {
            l = 0L;
        }
        intent.putExtra("EXTRA_CURRENT_WATCH_VIDEO_ID", l);
        return intent;
    }

    public boolean isPlaying()
    {
        return videoStateController.getMediaPlayer().getPlayerStatus() != PlayerStatus.PAUSED;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        alternateInterfaceListener.addSpeechListener(speechListener);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public void onBackPressed()
    {
        videoStateController.onBackButton();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layout = (ViewGroup)layoutinflater.inflate(com.xfinity.playerlib.R.layout.video_player_fragment, viewgroup, false);
        statsView = layout.findViewById(com.xfinity.playerlib.R.id.stat);
        bitrateTextView = (TextView)layout.findViewById(com.xfinity.playerlib.R.id.stat_bitrate);
        playerLayout = (RelativeLayout)layout.findViewById(com.xfinity.playerlib.R.id.player_fragment_layout);
        playerFrame = (FrameLayout)layout.findViewById(com.xfinity.playerlib.R.id.player_frame);
        bufferingProgress = (LinearLayout)layout.findViewById(com.xfinity.playerlib.R.id.buffering_progress);
        bufferingText = (TextView)layout.findViewById(com.xfinity.playerlib.R.id.buffering_text);
        audioOnlyView = (TextView)layout.findViewById(com.xfinity.playerlib.R.id.audio_only);
        ccContainer = (RelativeLayout)layout.findViewById(com.xfinity.playerlib.R.id.cc_container);
        clickableAdButton = (Button)layout.findViewById(com.xfinity.playerlib.R.id.clickable_ad_more_info_button);
        adView = (WebView)layout.findViewById(com.xfinity.playerlib.R.id.clickable_ad_more_info);
        playerControls = (ViewGroup)layout.findViewById(com.xfinity.playerlib.R.id.player_controls);
        progressBarLayout = (LinearLayout)playerControls.findViewById(com.xfinity.playerlib.R.id.progressbar_layout);
        programProgressBar = (TimelineSeekBar)progressBarLayout.findViewById(com.xfinity.playerlib.R.id.progress_bar);
        playButton = (ImageView)playerControls.findViewById(com.xfinity.playerlib.R.id.play_button);
        pauseButton = (ImageView)playerControls.findViewById(com.xfinity.playerlib.R.id.pause_button);
        currentTime = (TextView)playerControls.findViewById(com.xfinity.playerlib.R.id.current_time);
        videoDuration = (TextView)playerControls.findViewById(com.xfinity.playerlib.R.id.duration);
        thumbTime = (TextView)playerControls.findViewById(com.xfinity.playerlib.R.id.thumb_time);
        volumeSlider = (VerticalSeekBar)playerControls.findViewById(com.xfinity.playerlib.R.id.volume_slider);
        volumeSliderLayout = (LinearLayout)playerControls.findViewById(com.xfinity.playerlib.R.id.volume_slider_layout);
        volumeIndicator = (CustomStateImageView)playerControls.findViewById(com.xfinity.playerlib.R.id.volume_indicator);
        muteButton = (CustomStateImageView)playerControls.findViewById(com.xfinity.playerlib.R.id.mute_button);
        brightnessSlider = (VerticalSeekBar)playerControls.findViewById(com.xfinity.playerlib.R.id.brightness_slider);
        brightnessSliderLayout = (LinearLayout)playerControls.findViewById(com.xfinity.playerlib.R.id.brightness_slider_layout);
        brightnessIndicator = (CustomStateImageView)playerControls.findViewById(com.xfinity.playerlib.R.id.brightness_indicator);
        networkLogo = (ImageView)playerControls.findViewById(com.xfinity.playerlib.R.id.network_logo);
        networkName = (TextView)playerControls.findViewById(com.xfinity.playerlib.R.id.network_name);
        ccButton = (ImageView)playerControls.findViewById(com.xfinity.playerlib.R.id.cc);
        ccButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoPlayerFragment this$0;

            public void onClick(View view)
            {
                videoStateController.onCCButton();
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        });
        ccButton.setEnabled(false);
        sapButton = (ImageView)playerControls.findViewById(com.xfinity.playerlib.R.id.sap);
        sapButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoPlayerFragment this$0;

            public void onClick(View view)
            {
                videoStateController.onSAPButton();
            }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
        });
        sapButton.setEnabled(false);
        isPhone = getResources().getBoolean(com.xfinity.playerlib.R.bool.player_behavior_as_phone);
        if (!isPhone)
        {
            infoPanel = (LinearLayout)playerControls.findViewById(com.xfinity.playerlib.R.id.info_panel);
            infoPanel.setOnTouchListener(new android.view.View.OnTouchListener() {

                final VideoPlayerFragment this$0;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return true;
                }

            
            {
                this$0 = VideoPlayerFragment.this;
                super();
            }
            });
        }
        adsActionBar = (ResponsiveRelativeLayout)playerLayout.findViewById(com.xfinity.playerlib.R.id.ads_top_bar);
        adsCountDown = (TextView)playerLayout.findViewById(com.xfinity.playerlib.R.id.ads_count_down);
        isAdsActionBarAdjustedForStatusBar = false;
        startupDialog = (ViewGroup)layout.findViewById(com.xfinity.playerlib.R.id.startup_dialog);
        startupMessaging = (TextView)startupDialog.findViewById(com.xfinity.playerlib.R.id.message);
        startupMatureContentRating = (TextView)startupDialog.findViewById(com.xfinity.playerlib.R.id.mature_content_rating);
        startupMatureContentWarning = (TextView)startupDialog.findViewById(com.xfinity.playerlib.R.id.mature_content_warning);
        if (!isPhone)
        {
            playerUIController = new TabletPlayerUIController();
        } else
        {
            playerUIController = new PhonePlayerUIController();
        }
        configureActionBar();
        configurePlayerControls();
        playerUIController.hideActionBar();
        videoStateController = new VideoStateController(getActivity(), playerUIController, playerDownloadServiceManager, taskExecutorFactory, movieCacheMap, seriesCacheMap, liveStreamMetaDataResourceFactory, videoEntitlementCache, liveStreamResourceCache, watchableCodec, internetConnection, userManager, androidDevice, videoAuthManager, uiThreadExecutor, parentalControlsCache, videoBookmarkDAO, liveStreamBookmarkDAO, playerApplication, httpClient, cimAssetFactory, playerConfigUtil, splunker, foxLogger, trackingService, errorFormatter, errorDialogFactory);
        mAudioManager = (AudioManager)getActivity().getSystemService("audio");
        configureVolumeAndBrightnessControls();
        mRemoteControlResponder = new ComponentName(getActivity().getPackageName(), com/xfinity/playerlib/view/videoplay/RemoteControlReceiver.getName());
        getActivity().setVolumeControlStream(3);
        playerUIController.turnLightsOut();
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            playerFrame.setSystemUiVisibility(1792);
            getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(playerOnSystemUiVisibilityChangeListener);
        }
        preventVolumeViewFromAnnouncingStateChanges();
        alternateInterfaceListener.setupPassiveGestureDetector(layout, com.xfinity.playerlib.R.id.touchy_parent);
        if (bundle != null)
        {
            isMuted = bundle.getBoolean("isMuted", false);
            manualControlToggleOn = bundle.getBoolean("STATE_IS_CONTROLS_ON", true);
        }
        return layout;
    }

    public void onDestroy()
    {
        videoStateController.onFragmentDestroyed();
        super.onDestroy();
    }

    public void onDetach()
    {
        super.onDetach();
        alternateInterfaceListener.removeSpeechListener(speechListener);
    }

    public void onLiveEventClick(HalLiveStream hallivestream, String s)
    {
    }

    public void onLiveStreamClick(HalLiveStream hallivestream)
    {
        if (hallivestream != null && hallivestream.getStreamId() != null && !hallivestream.getStreamId().equals(videoStateController.getLiveStream().getStreamId()))
        {
            videoStateController.onLiveStreamPlaySelected(hallivestream);
            return;
        } else
        {
            playerUIController.hideInfoPanel();
            playerUIController.hideAllControls();
            return;
        }
    }

    public void onLiveStreamPlayOrResumePressed(String s)
    {
        videoStateController.onLiveStreamPlayOrResumePressed(s);
    }

    public void onPause()
    {
        super.onPause();
        videoStateController.unpauseDownloads();
        BroadcastReceiverUtil.unregisterBroadcastReceiversQuietly(getActivity(), new BroadcastReceiver[] {
            connectionTypeChangeReceiver
        });
        BroadcastReceiverUtil.unregisterBroadcastReceiversQuietly(getActivity(), new BroadcastReceiver[] {
            headsetNoiseReceiver
        });
        BroadcastReceiverUtil.unregisterBroadcastReceiversQuietly(getActivity(), new BroadcastReceiver[] {
            remoteControlKeyReceiver
        });
        mAudioManager.abandonAudioFocus(afChangeListener);
        mAudioManager.unregisterMediaButtonEventReceiver(mRemoteControlResponder);
        videoStateController.onActivityPaused();
        preventVolumeViewFromAnnouncingStateChanges();
        if (isMuted)
        {
            mAudioManager.setStreamVolume(3, mutedVolume, 0);
        }
        mAudioManager.setStreamMute(3, false);
    }

    public void onPlayOrResumePressed(VideoFacade videofacade, Watchable watchable)
    {
        videoStateController.onNewVideoPlayOrResumeSelected(videofacade, watchable);
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        videoStateController.checkShouldPauseDownloads();
        playerUIController.dismissDialogs();
        if (accessibilityUtil.isAccessibilityEnabled())
        {
            accessibilityUtil.setImportantForAccessibility(programProgressBar, 1);
        }
        getActivity().registerReceiver(connectionTypeChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        getActivity().registerReceiver(headsetNoiseReceiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        getActivity().registerReceiver(remoteControlKeyReceiver, new IntentFilter("com.xfinity.playerlib.videoplay.KEY_PRESSED"));
        if (mAudioManager.requestAudioFocus(afChangeListener, 3, 1) == 1)
        {
            mAudioManager.registerMediaButtonEventReceiver(mRemoteControlResponder);
        }
        videoStateController.onActivityResumed();
        mutedVolume = mAudioManager.getStreamVolume(3);
        setMuteState(isMuted);
        accessibilityUtil.setImportantForAccessibility(volumeSlider, 1);
        updateBrightnessControl();
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            playerUIController.styleClosedCaptions();
        }
        if (hideAdViewOnResume)
        {
            playerUIController.hideAdView();
            hideAdViewOnResume = false;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isMuted", isMuted);
        bundle.putBoolean("STATE_IS_CONTROLS_ON", manualControlToggleOn);
    }

    public void onSpeechSwiped()
    {
        videoPlayingBeforeSpeechSwipe = isPlaying();
    }

    public void onVideoPlayOrResumePressed(VideoBookmark videobookmark)
    {
        videoStateController.onNewVideoPlayOrResumeSelected(videobookmark);
    }

    public boolean onVolumeHardwareKeyPressed(int i)
    {
        if (((PlayerUserSettings)userManager.getUserSettings()).getWantsVolumeControl() && (i == 25 || i == 24))
        {
            if (i == 24)
            {
                i = 1;
            } else
            {
                i = -1;
            }
            adjustVolume(i);
            return true;
        } else
        {
            return false;
        }
    }

    public void playLiveStream(LiveStreamFavorite livestreamfavorite)
    {
        onLiveStreamPlayOrResumePressed(livestreamfavorite.getStreamId());
    }

    public void reset()
    {
        videoStateController.resetVideoAndWatchable();
        videoStateController.resetLiveStream();
        videoStateController.reset();
    }

    public boolean seek(int i)
    {
        long l = videoStateController.getMediaPlayer().getPosition() + (long)i;
        videoStateController.getMediaPlayer().setPosition(l, false);
        alternateInterfaceListener.getTalkDelegate().speak((new StringBuilder()).append("position now at ").append(UIPresentationUtil.getTimeForPlayer(getActivity(), (int)(l / 1000L))).toString());
        return true;
    }

    void setMuteState(boolean flag)
    {
        boolean flag2 = true;
        boolean flag1;
        if (flag)
        {
            mutedVolume = mAudioManager.getStreamVolume(3);
            mAudioManager.setStreamMute(3, flag);
        } else
        {
            mAudioManager.setStreamMute(3, flag);
            mAudioManager.setStreamVolume(3, mutedVolume, 0);
        }
        if (flag || !flag && isPhone && mAudioManager.getStreamVolume(3) > 0)
        {
            Object obj = volumeIndicator;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ((CustomStateImageView) (obj)).setAppearEnabled(flag1);
        }
        obj = volumeSlider;
        if (!flag)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        ((VerticalSeekBar) (obj)).setAppearEnabled(flag1);
        volumeSlider.setProgress(mutedVolume);
        muteButton.setAppearEnabled(flag);
        isMuted = flag;
    }

    public boolean shouldShowSeriesListItemsChecked()
    {
        return false;
    }

    public void showDetail(VideoBookmark videobookmark, Long long1)
    {
        videoStateController.onHistoryItemDetailSelected(videobookmark);
    }

    public void showDetail(VideoFavorite videofavorite)
    {
        videoStateController.onFavoriteItemDetailSelected(videofavorite);
    }

    public void showSeriesDetail()
    {
    }

    public void showSeriesWatchableDetail(SeriesWatchable serieswatchable)
    {
        videoStateController.onSeriesWatchableDetailSelected(serieswatchable);
    }

    public boolean speechTriggerPause()
    {
        videoStateController.onPauseButton();
        return !videoStateController.isAdPlaying() && videoStateController.getMediaPlayer().getPlayerStatus() != PlayerStatus.PAUSED;
    }

    public boolean speechTriggerPlay()
    {
        videoStateController.onPlayButton();
        return !videoStateController.isAdPlaying() && videoStateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PAUSED;
    }

    void updateBrightnessControl()
    {
        int j = ((PlayerUserSettings)userManager.getUserSettings()).getBrightnessValue();
        Object obj = getActivity().getContentResolver();
        int i = j;
        if (j < 0)
        {
            i = android.provider.Settings.System.getInt(((android.content.ContentResolver) (obj)), "screen_brightness", 1);
            ((PlayerUserSettings)userManager.getUserSettings()).setBrightnessValue(i);
        }
        brightnessSlider.setMax(255);
        brightnessSlider.setProgress(i);
        obj = getActivity().getWindow().getAttributes();
        if (((PlayerUserSettings)userManager.getUserSettings()).getWantsBrightnessControl())
        {
            obj.screenBrightness = getAdjustedBrightness(i);
        } else
        {
            obj.screenBrightness = -1F;
        }
        getActivity().getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
    }

    public void updateVolumeSlider()
    {
        boolean flag = false;
        int i = mAudioManager.getStreamVolume(3);
        if (isPhone)
        {
            CustomStateImageView customstateimageview = volumeIndicator;
            if (i > 0)
            {
                flag = true;
            }
            customstateimageview.setAppearEnabled(flag);
        } else
        {
            volumeIndicator.setAppearEnabled(false);
        }
        volumeSlider.setProgress(i);
    }













/*
    static boolean access$1802(VideoPlayerFragment videoplayerfragment, boolean flag)
    {
        videoplayerfragment.adAnnouced = flag;
        return flag;
    }

*/



/*
    static boolean access$1902(VideoPlayerFragment videoplayerfragment, boolean flag)
    {
        videoplayerfragment.adZeroSeconds = flag;
        return flag;
    }

*/





/*
    static boolean access$2202(VideoPlayerFragment videoplayerfragment, boolean flag)
    {
        videoplayerfragment.hideAdViewOnResume = flag;
        return flag;
    }

*/




/*
    static boolean access$2402(VideoPlayerFragment videoplayerfragment, boolean flag)
    {
        videoplayerfragment.isAdsActionBarAdjustedForStatusBar = flag;
        return flag;
    }

*/



/*
    static boolean access$2502(VideoPlayerFragment videoplayerfragment, boolean flag)
    {
        videoplayerfragment.manualControlToggleOn = flag;
        return flag;
    }

*/
























/*
    static boolean access$4602(VideoPlayerFragment videoplayerfragment, boolean flag)
    {
        videoplayerfragment.firstTimePlayed = flag;
        return flag;
    }

*/










/*
    static int access$5402(VideoPlayerFragment videoplayerfragment, int i)
    {
        videoplayerfragment.mutedVolume = i;
        return i;
    }

*/




/*
    static int access$602(VideoPlayerFragment videoplayerfragment, int i)
    {
        videoplayerfragment.mLastSystemVisibility = i;
        return i;
    }

*/



/*
    static BabyGuideType access$802(VideoPlayerFragment videoplayerfragment, BabyGuideType babyguidetype)
    {
        videoplayerfragment.selectedBabyGuideMenu = babyguidetype;
        return babyguidetype;
    }

*/


    // Unreferenced inner class com/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$10

/* anonymous class */
    class PlayerUIController._cls10
        implements android.content.DialogInterface.OnCancelListener
    {

        final PlayerUIController this$1;

        public void onCancel(DialogInterface dialoginterface)
        {
            if (videoStateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING)
            {
                startMainControlTimeout();
            }
        }

            
            {
                this$1 = PlayerUIController.this;
                super();
            }
    }


    // Unreferenced inner class com/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$11

/* anonymous class */
    class PlayerUIController._cls11
        implements android.content.DialogInterface.OnKeyListener
    {

        final PlayerUIController this$1;

        public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
        {
            return onVolumeHardwareKeyPressed(i);
        }

            
            {
                this$1 = PlayerUIController.this;
                super();
            }
    }


    // Unreferenced inner class com/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$2

/* anonymous class */
    class PlayerUIController._cls2
        implements Runnable
    {

        final PlayerUIController this$1;

        public void run()
        {
            moveAdsActionBarUp(true);
        }

            
            {
                this$1 = PlayerUIController.this;
                super();
            }
    }


    // Unreferenced inner class com/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$3

/* anonymous class */
    class PlayerUIController._cls3
        implements Runnable
    {

        final PlayerUIController this$1;

        public void run()
        {
            VideoPlayerFragment.LOG.debug("Calling hide from runnable");
            hideAllControls();
        }

            
            {
                this$1 = PlayerUIController.this;
                super();
            }
    }


    // Unreferenced inner class com/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$4

/* anonymous class */
    class PlayerUIController._cls4
        implements Runnable
    {

        final PlayerUIController this$1;

        public void run()
        {
            VideoPlayerFragment.LOG.debug("Calling hide volume from runnable");
            volumeSliderLayout.setVisibility(4);
        }

            
            {
                this$1 = PlayerUIController.this;
                super();
            }
    }

}
