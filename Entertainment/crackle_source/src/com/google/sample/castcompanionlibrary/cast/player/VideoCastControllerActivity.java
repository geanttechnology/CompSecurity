// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.player;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.sample.castcompanionlibrary.cast.VideoCastManager;
import com.google.sample.castcompanionlibrary.cast.callbacks.VideoCastConsumerImpl;
import com.google.sample.castcompanionlibrary.cast.exceptions.CastException;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import com.google.sample.castcompanionlibrary.utils.Utils;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class VideoCastControllerActivity extends ActionBarActivity
{
    class MyCastConsumer extends VideoCastConsumerImpl
    {

        final VideoCastControllerActivity this$0;

        public void onApplicationDisconnected(int i)
        {
            finish();
        }

        public void onConnectionSuspended(int i)
        {
            updateControlersStatus(false);
        }

        public void onConnectivityRecovered()
        {
            updateControlersStatus(true);
        }

        public void onDisconnected()
        {
            finish();
        }

        public void onRemoteMediaPlayerMetadataUpdated()
        {
            try
            {
                mSelectedMedia = mCastManager.getRemoteMediaInformation();
                updateMetadata();
                return;
            }
            catch (TransientNetworkDisconnectionException transientnetworkdisconnectionexception)
            {
                LogUtils.LOGE(VideoCastControllerActivity.TAG, "Failed to update the metadata due to network issues", transientnetworkdisconnectionexception);
                return;
            }
            catch (NoConnectionException noconnectionexception)
            {
                LogUtils.LOGE(VideoCastControllerActivity.TAG, "Failed to update the metadata due to network issues", noconnectionexception);
            }
        }

        public void onRemoteMediaPlayerStatusUpdated()
        {
            int i;
            i = mCastManager.getPlaybackStatus();
            LogUtils.LOGD(VideoCastControllerActivity.TAG, (new StringBuilder()).append("onRemoteMediaPlayerStatusUpdated(), status: ").append(i).toString());
            i;
            JVM INSTR tableswitch 1 4: default 68
        //                       1 174
        //                       2 69
        //                       3 104
        //                       4 139;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            return;
_L3:
            if (mPlaybackState != 2)
            {
                mPlaybackState = 2;
                updatePlayButton(mPlaybackState);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (mPlaybackState != 3)
            {
                mPlaybackState = 3;
                updatePlayButton(mPlaybackState);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (mPlaybackState != 4)
            {
                mPlaybackState = 4;
                updatePlayButton(mPlaybackState);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L2:
            if (mCastManager.getIdleReason() == 1)
            {
                finish();
                return;
            }
            if (true) goto _L1; else goto _L6
_L6:
        }

        MyCastConsumer()
        {
            this$0 = VideoCastControllerActivity.this;
            super();
        }
    }

    private class UpdateSeekbarTask extends TimerTask
    {

        final VideoCastControllerActivity this$0;

        public void run()
        {
            mHandler.post(new Runnable() {

                final UpdateSeekbarTask this$1;

                public void run()
                {
_L2:
                    return;
                    if (mPlaybackState == 4 || !mCastManager.isConnected()) goto _L2; else goto _L1
_L1:
                    double d = mCastManager.getMediaDuration();
                    if (d <= 0.0D) goto _L2; else goto _L3
_L3:
                    int i = (int)mCastManager.getCurrentMediaPosition();
                    updateSeekbar(i, (int)d);
                    return;
                    Exception exception;
                    exception;
                    try
                    {
                        LogUtils.LOGE(VideoCastControllerActivity.TAG, "Failed to get current media position");
                        return;
                    }
                    catch (TransientNetworkDisconnectionException transientnetworkdisconnectionexception)
                    {
                        LogUtils.LOGE(VideoCastControllerActivity.TAG, "Failed to update the progress bar due to network issues", transientnetworkdisconnectionexception);
                        return;
                    }
                    catch (NoConnectionException noconnectionexception)
                    {
                        LogUtils.LOGE(VideoCastControllerActivity.TAG, "Failed to update the progress bar due to network issues", noconnectionexception);
                    }
                    return;
                }

            
            {
                this$1 = UpdateSeekbarTask.this;
                super();
            }
            });
        }

        private UpdateSeekbarTask()
        {
            this$0 = VideoCastControllerActivity.this;
            super();
        }

    }


    private static final String TAG = LogUtils.makeLogTag(com/google/sample/castcompanionlibrary/cast/player/VideoCastControllerActivity);
    private MyCastConsumer mCastConsumer;
    private VideoCastManager mCastManager;
    private View mControllers;
    private TextView mEnd;
    private final Handler mHandler = new Handler();
    private AsyncTask mImageAsyncTask;
    private boolean mIsFresh;
    private TextView mLine1;
    private TextView mLine2;
    private ProgressBar mLoading;
    private View mPageView;
    private ImageView mPlayPause;
    private int mPlaybackState;
    private SeekBar mSeekbar;
    private Timer mSeekbarTimer;
    private MediaInfo mSelectedMedia;
    private boolean mShouldStartPlayback;
    private TextView mStart;
    private float mVolumeIncrement;

    public VideoCastControllerActivity()
    {
        mPlaybackState = 1;
        mIsFresh = false;
    }

    private void loadViews()
    {
        mPageView = findViewById(com.google.sample.castcompanionlibrary.R.id.pageView);
        mPlayPause = (ImageView)findViewById(com.google.sample.castcompanionlibrary.R.id.imageView1);
        mStart = (TextView)findViewById(com.google.sample.castcompanionlibrary.R.id.startText);
        mEnd = (TextView)findViewById(com.google.sample.castcompanionlibrary.R.id.endText);
        mSeekbar = (SeekBar)findViewById(com.google.sample.castcompanionlibrary.R.id.seekBar1);
        mLine1 = (TextView)findViewById(com.google.sample.castcompanionlibrary.R.id.textView1);
        mLine2 = (TextView)findViewById(com.google.sample.castcompanionlibrary.R.id.textView2);
        mLoading = (ProgressBar)findViewById(com.google.sample.castcompanionlibrary.R.id.progressBar1);
        mControllers = findViewById(com.google.sample.castcompanionlibrary.R.id.controllers);
    }

    private void onVolumeChange(double d)
    {
        if (mCastManager == null)
        {
            return;
        }
        try
        {
            mCastManager.incrementVolume(d);
            return;
        }
        catch (Exception exception)
        {
            LogUtils.LOGE(TAG, "onVolumeChange() Failed to change volume", exception);
        }
        Utils.showErrorDialog(this, com.google.sample.castcompanionlibrary.R.string.failed_setting_volume);
    }

    private void restartTrickplayTimer()
    {
        stopTrickplayTimer();
        mSeekbarTimer = new Timer();
        mSeekbarTimer.scheduleAtFixedRate(new UpdateSeekbarTask(), 100L, 1000L);
        LogUtils.LOGD(TAG, "Restarted TrickPlay Timer");
    }

    private void setupActionBar()
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(com.google.sample.castcompanionlibrary.R.drawable.actionbar_bg_gradient_light));
    }

    private void setupSeekBar()
    {
        mSeekbar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final VideoCastControllerActivity this$0;

            public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
            {
                mStart.setText(Utils.formatMillis(i));
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
                stopTrickplayTimer();
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                if (mPlaybackState != 2) goto _L2; else goto _L1
_L1:
                mPlaybackState = 4;
                updatePlayButton(mPlaybackState);
                mCastManager.play(seekbar.getProgress());
_L4:
                restartTrickplayTimer();
                return;
_L2:
                if (mPlaybackState == 3)
                {
                    mCastManager.seek(seekbar.getProgress());
                }
                if (true) goto _L4; else goto _L3
_L3:
                seekbar;
                LogUtils.LOGE(VideoCastControllerActivity.TAG, "Failed to complete seek", seekbar);
                finish();
                return;
            }

            
            {
                this$0 = VideoCastControllerActivity.this;
                super();
            }
        });
    }

    private void stopTrickplayTimer()
    {
        LogUtils.LOGD(TAG, "Stopped TrickPlay Timer");
        if (mSeekbarTimer != null)
        {
            mSeekbarTimer.cancel();
        }
    }

    private void togglePlayback()
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        mPlaybackState;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 75
    //                   2 60
    //                   3 41;
           goto _L1 _L2 _L3 _L4
_L1:
        updatePlayButton(mPlaybackState);
        return;
_L4:
        mCastManager.play();
        mPlaybackState = 4;
        restartTrickplayTimer();
        continue; /* Loop/switch isn't completed */
_L3:
        mCastManager.pause();
        mPlaybackState = 4;
        continue; /* Loop/switch isn't completed */
_L2:
        mCastManager.loadMedia(mSelectedMedia, true, 0);
        mPlaybackState = 4;
        restartTrickplayTimer();
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void updateControlersStatus(boolean flag)
    {
        View view = mControllers;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        view.setVisibility(i);
    }

    private void updateMetadata()
    {
        MediaMetadata mediametadata = mSelectedMedia.getMetadata();
        mLine1.setText(mediametadata.getString("com.google.android.gms.cast.metadata.TITLE"));
        if (mImageAsyncTask != null)
        {
            mImageAsyncTask.cancel(true);
        }
        mImageAsyncTask = new AsyncTask() {

            final VideoCastControllerActivity this$0;

            protected transient Bitmap doInBackground(String as[])
            {
                as = as[0];
                Bitmap bitmap;
                try
                {
                    bitmap = BitmapFactory.decodeStream((new URL(as)).openStream());
                }
                catch (Exception exception)
                {
                    LogUtils.LOGE(VideoCastControllerActivity.TAG, (new StringBuilder()).append("Failed to load the image with url: ").append(as).toString(), exception);
                    return null;
                }
                return bitmap;
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((String[])aobj);
            }

            protected void onPostExecute(Bitmap bitmap)
            {
                if (bitmap != null)
                {
                    mPageView.setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Bitmap)obj);
            }

            
            {
                this$0 = VideoCastControllerActivity.this;
                super();
            }
        };
        mImageAsyncTask.execute(new String[] {
            Utils.getImageUrl(mSelectedMedia, 1)
        });
    }

    private void updatePlayButton(int i)
    {
        switch (i)
        {
        default:
            return;

        case 2: // '\002'
            mLoading.setVisibility(4);
            mPlayPause.setVisibility(0);
            mPlayPause.setImageDrawable(getResources().getDrawable(com.google.sample.castcompanionlibrary.R.drawable.ic_av_pause_dark));
            mLine2.setText(getString(com.google.sample.castcompanionlibrary.R.string.casting_to_device, new Object[] {
                mCastManager.getDeviceName()
            }));
            mControllers.setVisibility(0);
            return;

        case 3: // '\003'
            mControllers.setVisibility(0);
            mLoading.setVisibility(4);
            mPlayPause.setVisibility(0);
            mPlayPause.setImageDrawable(getResources().getDrawable(com.google.sample.castcompanionlibrary.R.drawable.ic_av_play_dark));
            mLine2.setText(getString(com.google.sample.castcompanionlibrary.R.string.casting_to_device, new Object[] {
                mCastManager.getDeviceName()
            }));
            return;

        case 1: // '\001'
            mLoading.setVisibility(4);
            mPlayPause.setVisibility(0);
            mPlayPause.setImageDrawable(getResources().getDrawable(com.google.sample.castcompanionlibrary.R.drawable.ic_av_play_dark));
            mLine2.setText(getString(com.google.sample.castcompanionlibrary.R.string.casting_to_device, new Object[] {
                mCastManager.getDeviceName()
            }));
            return;

        case 4: // '\004'
            mPlayPause.setVisibility(4);
            break;
        }
        mLoading.setVisibility(0);
        mLine2.setText(getString(com.google.sample.castcompanionlibrary.R.string.loading));
    }

    private void updateSeekbar(int i, int j)
    {
        mSeekbar.setProgress(i);
        mSeekbar.setMax(j);
        mStart.setText(Utils.formatMillis(i));
        mEnd.setText(Utils.formatMillis(j));
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mIsFresh = true;
        setContentView(com.google.sample.castcompanionlibrary.R.layout.cast_activity);
        mVolumeIncrement = Utils.getFloatFromPreference(this, "volume-increment");
        Bundle bundle1;
        try
        {
            mCastManager = VideoCastManager.getInstance(this);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        loadViews();
        setupActionBar();
        bundle = getIntent().getExtras();
        bundle1 = bundle.getBundle("media");
        if (bundle == null || bundle1 == null)
        {
            finish();
        }
        mShouldStartPlayback = bundle.getBoolean("shouldStart");
        mCastConsumer = new MyCastConsumer();
        mSelectedMedia = Utils.toMediaInfo(bundle1);
        if (!mShouldStartPlayback) goto _L2; else goto _L1
_L1:
        mPlaybackState = 4;
        updatePlayButton(mPlaybackState);
        bundle1.getInt("startPoint", 0);
        mCastManager.loadMedia(mSelectedMedia, true, bundle1.getInt("startPoint", 0));
_L3:
        updateMetadata();
        setupSeekBar();
        mPlayPause.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoCastControllerActivity this$0;

            public void onClick(View view)
            {
                LogUtils.LOGD(VideoCastControllerActivity.TAG, (new StringBuilder()).append("isConnected returning: ").append(mCastManager.isConnected()).toString());
                try
                {
                    togglePlayback();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    LogUtils.LOGE(VideoCastControllerActivity.TAG, "Failed to toggle playback due to temporary network issue", view);
                    Utils.showErrorDialog(VideoCastControllerActivity.this, com.google.sample.castcompanionlibrary.R.string.failed_no_connection_trans);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    LogUtils.LOGE(VideoCastControllerActivity.TAG, "Failed to toggle playback due to network issues", view);
                    Utils.showErrorDialog(VideoCastControllerActivity.this, com.google.sample.castcompanionlibrary.R.string.failed_no_connection);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    LogUtils.LOGE(VideoCastControllerActivity.TAG, "Failed to toggle playback due to other issues", view);
                }
                Utils.showErrorDialog(VideoCastControllerActivity.this, com.google.sample.castcompanionlibrary.R.string.failed_perform_action);
            }

            
            {
                this$0 = VideoCastControllerActivity.this;
                super();
            }
        });
        restartTrickplayTimer();
        return;
_L2:
        if (!mCastManager.isRemoteMoviePlaying())
        {
            break MISSING_BLOCK_LABEL_224;
        }
        mPlaybackState = 2;
_L4:
        updatePlayButton(mPlaybackState);
          goto _L3
        bundle;
        LogUtils.LOGE(TAG, "Failed to get playback and media information", bundle);
        finish();
          goto _L3
        mPlaybackState = 3;
          goto _L4
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(com.google.sample.castcompanionlibrary.R.menu.cast_player_menu, menu);
        mCastManager.addMediaRouterButton(menu, com.google.sample.castcompanionlibrary.R.id.media_route_menu_item);
        return true;
    }

    protected void onDestroy()
    {
        LogUtils.LOGD(TAG, "onDestroy is called");
        stopTrickplayTimer();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (mVolumeIncrement == 1.401298E-45F)
        {
            return false;
        }
        if (i == 24)
        {
            onVolumeChange(mVolumeIncrement);
        } else
        if (i == 25)
        {
            onVolumeChange(-(double)mVolumeIncrement);
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return true;
    }

    protected void onPause()
    {
        mCastManager.removeVideoCastConsumer(mCastConsumer);
        mCastManager.decrementUiCounter();
        mIsFresh = false;
        super.onPause();
    }

    protected void onResume()
    {
        boolean flag1;
        flag1 = true;
        LogUtils.LOGD(TAG, "onResume() was called");
        mCastManager = VideoCastManager.getInstance(this);
        boolean flag = flag1;
        if (mCastManager.isConnected())
        {
            if (mCastManager.getPlaybackStatus() == 1 && mCastManager.getIdleReason() == 1 && !mIsFresh)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        if (flag)
        {
            try
            {
                finish();
            }
            catch (CastException castexception) { }
        }
        mCastManager.addVideoCastConsumer(mCastConsumer);
        mCastManager.incrementUiCounter();
        super.onResume();
        return;
    }











/*
    static int access$302(VideoCastControllerActivity videocastcontrolleractivity, int i)
    {
        videocastcontrolleractivity.mPlaybackState = i;
        return i;
    }

*/






/*
    static MediaInfo access$802(VideoCastControllerActivity videocastcontrolleractivity, MediaInfo mediainfo)
    {
        videocastcontrolleractivity.mSelectedMedia = mediainfo;
        return mediainfo;
    }

*/

}
