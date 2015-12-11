// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.dialogs.LanguageDialog;
import com.gotv.crackle.helpers.ChromeCastHelper;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.helpers.StarRatingLayoutHelper;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.DateTimeFormatter;
import com.gotv.crackle.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.gotv.crackle:
//            BaseMediaDetailsActivity, Application, ApplicationConstants, DetailsActivityResolver

public class ChromeCastingDetailsActivity extends BaseMediaDetailsActivity
    implements android.view.View.OnClickListener, com.gotv.crackle.dialogs.LanguageDialog.LanguageDialogListener
{

    private static final String TAG = "ChromeCastingDetailsActivity";
    private TextView mAudioText;
    private ImageButton mButtonPausePlay;
    private boolean mDragging;
    private int mDurationInMilliSec;
    private int mDurationInSeconds;
    private TextView mDurationText;
    private TextView mExpiresText;
    private Handler mHandler;
    private MediaDetailsItem mPendingMediaDetails;
    private SeekBar mSeekBar;
    private android.widget.SeekBar.OnSeekBarChangeListener mSeekListener;
    private View mStarRatingView;
    private Runnable mStatusChecker;
    private MenuItem mSubtitleMenuItem;
    private boolean mSubtitleMenuItemVisible;
    private TextView mSubtitlesText;
    private TextView mTimePlayed;
    private TextView mTimeRemaining;
    private VideoDubSubtitleProcessor mVideoDubSubtitleProcessor;
    private android.widget.SeekBar.OnSeekBarChangeListener mVolumeSeekListener;
    private SeekBar mVolumeSlider;

    public ChromeCastingDetailsActivity()
    {
        mStatusChecker = new Runnable() {

            final ChromeCastingDetailsActivity this$0;

            public void run()
            {
                updateStatus();
                mHandler.postDelayed(mStatusChecker, 1000L);
            }

            
            {
                this$0 = ChromeCastingDetailsActivity.this;
                super();
            }
        };
        mSeekListener = new android.widget.SeekBar.OnSeekBarChangeListener() {

            int newposition;
            final ChromeCastingDetailsActivity this$0;

            public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
            {
                if (flag)
                {
                    newposition = i;
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
                mDragging = true;
                stopStatusChecker();
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                mDragging = false;
                seekTo(newposition);
                startStatusChecker(15000);
                updatePausePlayButton();
            }

            
            {
                this$0 = ChromeCastingDetailsActivity.this;
                super();
            }
        };
        mVolumeSeekListener = new android.widget.SeekBar.OnSeekBarChangeListener() ;
    }

    private void loadSubtitleInfo(MediaDetailsItem mediadetailsitem)
    {
        mVideoDubSubtitleProcessor = new VideoDubSubtitleProcessor();
        mVideoDubSubtitleProcessor.getData(new com.gotv.crackle.data.DataRequest.DataRequestListener() {

            final ChromeCastingDetailsActivity this$0;

            public void onDataFailed(String s, String s1)
            {
            }

            public void onDataSuccess(String s)
            {
                s = mVideoDubSubtitleProcessor.getCurrentItem();
                mVideoDubSubtitleProcessor.setCurrentLanguage(s.getLocalizedLanguage());
                if (s.getClosedCaptionFiles().size() > 0 || mVideoDubSubtitleProcessor.getCurrentItem().IsDubbed())
                {
                    runOnUiThread(new Runnable() {

                        final _cls2 this$1;

                        public void run()
                        {
                            mSubtitleMenuItem.setVisible(true);
                            mSubtitleMenuItemVisible = true;
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = ChromeCastingDetailsActivity.this;
                super();
            }
        }, mediadetailsitem.getID());
    }

    private void showResumeDialog()
    {
        AlertDialog alertdialog = (new Builder(this)).setIcon(0x1080027).setMessage(getResources().getString(0x7f0b00ba)).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ChromeCastingDetailsActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                finish();
            }

            
            {
                this$0 = ChromeCastingDetailsActivity.this;
                super();
            }
        }).setNegativeButton(getResources().getString(0x7f0b00bb), new android.content.DialogInterface.OnClickListener() ).setPositiveButton(getResources().getString(0x7f0b00bc), new android.content.DialogInterface.OnClickListener() ).create();
        alertdialog.setCancelable(false);
        alertdialog.show();
    }

    private void startChromeCast(final MediaDetailsItem media, final boolean forceResume)
    {
        runOnUiThread(new Runnable() {

            final ChromeCastingDetailsActivity this$0;
            final boolean val$forceResume;
            final MediaDetailsItem val$media;

            public void run()
            {
                fillData();
                mDurationInSeconds = Integer.parseInt(media.getDurationInSeconds());
                mDurationInMilliSec = (int)((long)mDurationInSeconds * 1000L);
                mSeekBar.setMax(mDurationInMilliSec);
                mButtonPausePlay.setEnabled(true);
                mButtonPausePlay.setImageResource(0x7f02010c);
                MediaDetailsItem mediadetailsitem = loadMedia.getMediaDetails();
                if (mediadetailsitem == null || !mediadetailsitem.getID().equals(media.getID()))
                {
                    float f = SharedPrefsManager.getPlayProgressForItem(media.getID());
                    if (f > 0.0F && (double)(f / 1000F) < (double)mDurationInSeconds - (double)mDurationInSeconds * 0.10000000000000001D && !mSuppressResumePrompt && !forceResume && SharedPrefsManager.getShowResumePrompt())
                    {
                        mPendingMediaDetails = media;
                        showResumeDialog();
                    } else
                    {
                        loadMedia.loadMedia(media, true);
                    }
                }
                startStatusChecker(0);
                loadSubtitleInfo(media);
            }

            
            {
                this$0 = ChromeCastingDetailsActivity.this;
                media = mediadetailsitem;
                forceResume = flag;
                super();
            }
        });
    }

    private void startStatusChecker(int i)
    {
        stopStatusChecker();
        if (i != 0)
        {
            mHandler.postDelayed(mStatusChecker, i);
            return;
        } else
        {
            mStatusChecker.run();
            return;
        }
    }

    private void stopStatusChecker()
    {
        mHandler.removeCallbacks(mStatusChecker);
    }

    private void updatePausePlayButton()
    {
        if (mChromeCastHelper.isPlaying())
        {
            mButtonPausePlay.setImageResource(0x7f02010c);
            return;
        } else
        {
            mButtonPausePlay.setImageResource(0x7f02010d);
            return;
        }
    }

    private void updateStatus()
    {
        int j = mChromeCastHelper.getCurrentPosition();
        int k = 0;
        int i = j;
        if (mDurationInMilliSec > 0)
        {
            i = j;
            if (j > mDurationInMilliSec)
            {
                i = mDurationInMilliSec;
            }
            k = mDurationInMilliSec - i;
        }
        mChromeCastHelper.savePosition(i);
        mTimePlayed.setText(DateTimeFormatter.getPlayerTimeFromMs(i));
        mTimeRemaining.setText(DateTimeFormatter.getPlayerTimeFromMs(k));
        if (!mDragging && mSeekBar != null)
        {
            mSeekBar.setProgress(i);
        }
        mVolumeSlider.setProgress((int)(100D * mChromeCastHelper.getVolume()));
        updatePausePlayButton();
        View view = findViewById(0x7f0a009c);
        if (mChromeCastHelper.isPlayingAd())
        {
            i = 4;
        } else
        {
            i = 0;
        }
        view.setVisibility(i);
    }

    public void fillData()
    {
        super.fillData();
        if (mDetailsProvider.getStarRating() == null)
        {
            mStarRatingView.setVisibility(8);
        } else
        {
            StarRatingLayoutHelper.setStarRating(mStarRatingView, mDetailsProvider.getStarRating().intValue());
        }
        if (mDetailsProvider.getExpires() == null)
        {
            mExpiresText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mExpiresText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00a7)).append(" ").append(mDetailsProvider.getExpires()).toString());
        } else
        {
            mExpiresText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00a7)).append(" ").toString(), mDetailsProvider.getExpires()));
        }
        if (mDetailsProvider.getDuration() == null)
        {
            mDurationText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mDurationText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00a9)).append(" ").append(mDetailsProvider.getDuration()).toString());
        } else
        {
            mDurationText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00a9)).append(" ").toString(), mDetailsProvider.getDuration()));
        }
        if (mDetailsProvider.getAudio() == null || Application.isFanhattan())
        {
            mAudioText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mAudioText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00fa)).append(" ").append(mDetailsProvider.getAudio()).toString());
        } else
        {
            mAudioText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00fa)).append(" ").toString(), mDetailsProvider.getAudio()));
        }
        if (mDetailsProvider.getSubtitles() == null || Application.isFanhattan())
        {
            mSubtitlesText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mSubtitlesText.setText((new StringBuilder()).append(getResources().getString(0x7f0b0106)).append(" ").append(mDetailsProvider.getSubtitles()).toString());
            return;
        } else
        {
            mSubtitlesText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b0106)).append(" ").toString(), mDetailsProvider.getSubtitles()));
            return;
        }
    }

    public String getSectionName()
    {
        return ApplicationConstants.getFreeWheelHomeSiteSection();
    }

    public void initViews()
    {
        super.initViews();
        mStarRatingView = findViewById(0x7f0a00ff);
        mExpiresText = (TextView)findViewById(0x7f0a007d);
        mDurationText = (TextView)findViewById(0x7f0a0101);
        mAudioText = (TextView)findViewById(0x7f0a0102);
        mSubtitlesText = (TextView)findViewById(0x7f0a0103);
        mSeekBar = (SeekBar)findViewById(0x7f0a009e);
        mVolumeSlider = (SeekBar)findViewById(0x7f0a009b);
        mButtonPausePlay = (ImageButton)findViewById(0x7f0a009a);
        mTimePlayed = (TextView)findViewById(0x7f0a009d);
        mTimeRemaining = (TextView)findViewById(0x7f0a009f);
        mButtonPausePlay.setOnClickListener(this);
        mSeekBar.setOnSeekBarChangeListener(mSeekListener);
        mVolumeSlider.setOnSeekBarChangeListener(mVolumeSeekListener);
        mVolumeSlider.setMax(100);
        mVolumeSlider.setProgress(50);
    }

    protected void loadThumbnail()
    {
        mImageLoader.displayImage(mDetailsProvider.getLargeThumbnailUrl(), mThumbnailView, mImageOptions);
    }

    protected void onChannelDataSuccess()
    {
        Object obj = mDetailsProvider.getMediaDetailsItem();
        if (obj != null)
        {
            startChromeCast(((MediaDetailsItem) (obj)), false);
            return;
        }
        String s = mMediaID;
        obj = s;
        if (s == null)
        {
            obj = mDetailsProvider.getMediaId();
        }
        mDetailsProvider.getDataWithMediaId(new com.gotv.crackle.data.DataRequest.DataRequestListener() {

            final ChromeCastingDetailsActivity this$0;

            public void onDataFailed(String s1, String s2)
            {
                onDataFailed(s1, s2);
            }

            public void onDataSuccess(String s1)
            {
                startChromeCast(mDetailsProvider.getMediaDetailsItem(), false);
            }

            
            {
                this$0 = ChromeCastingDetailsActivity.this;
                super();
            }
        }, ((String) (obj)));
    }

    public void onClick(View view)
    {
label0:
        {
            if (view.getId() == 0x7f0a009a)
            {
                if (!mChromeCastHelper.isPlaying())
                {
                    break label0;
                }
                pausePlayback(false);
            }
            return;
        }
        startPlayback();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002c);
        getIntentExtras();
        mHandler = new Handler();
        initViews();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        mSubtitleMenuItem = menu.findItem(0x7f0a01c2);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 24)
        {
            mChromeCastHelper.incrementVolume(0.050000000000000003D);
        } else
        if (i == 25)
        {
            mChromeCastHelper.incrementVolume(-0.050000000000000003D);
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
        return true;
    }

    protected void onPause()
    {
        stopStatusChecker();
        super.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        mSubtitleMenuItem.setVisible(mSubtitleMenuItemVisible);
        return true;
    }

    protected void onResume()
    {
        if (mDetailsProvider != null && mDetailsProvider.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE)
        {
            fillData();
        }
        startStatusChecker(1000);
        super.onResume();
    }

    public void pausePlayback(boolean flag)
    {
        Log.d("ChromeCastingDetailsActivity", "pausePlayback");
        stopStatusChecker();
        mChromeCastHelper.pause();
        mButtonPausePlay.setImageResource(0x7f02010d);
    }

    protected void performMenuAction(int i)
    {
        if (i == 0x7f0a01c2)
        {
            showLanguageDialog();
            return;
        } else
        {
            super.performMenuAction(i);
            return;
        }
    }

    protected void refreshData()
    {
        MediaDetailsItem mediadetailsitem = mChromeCastHelper.getMediaDetails();
        if (mediadetailsitem != null && mediadetailsitem.getID().equals(mMediaID))
        {
            return;
        } else
        {
            Intent intent = new Intent(this, com/gotv/crackle/DetailsActivityResolver);
            intent.putExtra("MEDIA_ITEM_ID", mediadetailsitem.getID());
            intent.putExtra("START_PLAYING", true);
            startActivity(intent);
            finish();
            return;
        }
    }

    public void seekTo(int i)
    {
        if (mChromeCastHelper.getDuration() > 0)
        {
            mChromeCastHelper.seekTo(i);
        }
    }

    protected void setMovieThumbnailSize()
    {
    }

    protected void showLanguageDialog()
    {
        android.support.v4.app.FragmentManager fragmentmanager = getSupportFragmentManager();
        LanguageDialog languagedialog = new LanguageDialog();
        languagedialog.setIsChromecast(true);
        languagedialog.setVideoDubSubtitleProcessor(mVideoDubSubtitleProcessor);
        languagedialog.setSelectedSubtitles(mChromeCastHelper.getSelectedSubtitles());
        languagedialog.setLanguageDialogListener(this);
        languagedialog.show(fragmentmanager, "language_dialog");
    }

    public void startPlayback()
    {
        Log.d("ChromeCastingDetailsActivity", "startPlayback");
        mChromeCastHelper.play();
        mButtonPausePlay.setImageResource(0x7f02010c);
        startStatusChecker(1000);
    }

    public void updateLanguageCancelled()
    {
    }

    public void updateLanguageSettings(Map map, String s, String s1, List list, String s2)
    {
        mChromeCastHelper.selectSubtitles(s2);
        mVideoDubSubtitleProcessor.setCurrentCaptions(s1);
        s1 = mVideoDubSubtitleProcessor.getCurrentItem();
        if (!s.equals(mVideoDubSubtitleProcessor.getCurrentLanguage()))
        {
            mVideoDubSubtitleProcessor.setCurrentLanguage(s);
            float f = mChromeCastHelper.getCurrentPosition();
            mChromeCastHelper.updateMedia(s1, map, s2, f);
        }
    }



/*
    static int access$002(ChromeCastingDetailsActivity chromecastingdetailsactivity, int i)
    {
        chromecastingdetailsactivity.mDurationInSeconds = i;
        return i;
    }

*/




/*
    static int access$102(ChromeCastingDetailsActivity chromecastingdetailsactivity, int i)
    {
        chromecastingdetailsactivity.mDurationInMilliSec = i;
        return i;
    }

*/



/*
    static boolean access$1202(ChromeCastingDetailsActivity chromecastingdetailsactivity, boolean flag)
    {
        chromecastingdetailsactivity.mSubtitleMenuItemVisible = flag;
        return flag;
    }

*/






/*
    static boolean access$1702(ChromeCastingDetailsActivity chromecastingdetailsactivity, boolean flag)
    {
        chromecastingdetailsactivity.mDragging = flag;
        return flag;
    }

*/











/*
    static MediaDetailsItem access$502(ChromeCastingDetailsActivity chromecastingdetailsactivity, MediaDetailsItem mediadetailsitem)
    {
        chromecastingdetailsactivity.mPendingMediaDetails = mediadetailsitem;
        return mediadetailsitem;
    }

*/




}
