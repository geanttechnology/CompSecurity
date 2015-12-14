// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.Camera;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.google.gson.Gson;
import com.nhaarman.supertooltips.ToolTip;
import com.nhaarman.supertooltips.ToolTipRelativeLayout;
import com.nhaarman.supertooltips.ToolTipView;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import my.googlemusic.play.application.App;
import my.googlemusic.play.model.Song;

// Referenced classes of package my.googlemusic.play.activities:
//            DabbShareActivity

public class DabbRecordActivity extends AppCompatActivity
    implements android.view.SurfaceHolder.Callback, android.view.View.OnClickListener
{
    private static class ViewHolder
    {

        ImageButton back;
        LinearLayout bottomLayout;
        SurfaceView cameraContainer;
        ImageButton cameraOrientation;
        ImageButton doneRecording;
        RelativeLayout mainLayout;
        ImageButton record;
        ProgressBar recordingProgress;
        View topLayout;
        ToolTipRelativeLayout tutorialContainer;
        ToolTipView tutorialView;

        private ViewHolder()
        {
        }

    }


    private String mAudioPath;
    private Camera mCamera;
    private int mCameraID;
    private Handler mHandler;
    private long mHoldTime;
    private ViewHolder mHolder;
    private MediaPlayer mMediaPlayer;
    private MediaRecorder mMediaRecorder;
    private float mOverlaySize;
    private Handler mPlayerHandler;
    private Runnable mPlayerRunnable;
    private Runnable mRunnable;
    private Song mSong;
    private long mStartRecording;
    private long mStopRecording;
    private SurfaceHolder mSurfaceHolder;
    private Handler mTutorialHandler;
    private int mVideoHeight;
    private String mVideoPath;
    private int mVideoWidth;

    public DabbRecordActivity()
    {
        mVideoPath = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/MyMixtapez/").append("video.mp4").toString();
        mAudioPath = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/MyMixtapez/").append("temporaryAudio.mp3").toString();
        mTutorialHandler = null;
    }

    private void adjustLayout()
    {
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        mHolder.recordingProgress.getLayoutParams().width = displaymetrics.widthPixels;
        float f = (float)mVideoHeight / (float)mVideoWidth;
        float f1 = (float)displaymetrics.heightPixels / f;
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(displaymetrics.widthPixels, displaymetrics.heightPixels);
        android.widget.FrameLayout.LayoutParams layoutparams;
        if (f1 < (float)displaymetrics.widthPixels)
        {
            f1 = displaymetrics.widthPixels;
            layoutparams = new android.widget.FrameLayout.LayoutParams(displaymetrics.widthPixels, (int)(f1 * f));
        } else
        {
            layoutparams = new android.widget.FrameLayout.LayoutParams((int)f1, displaymetrics.heightPixels);
            layoutparams.leftMargin = (int)(0.0F - (f1 - (float)displaymetrics.widthPixels) / 2.0F);
            layoutparams1.leftMargin = (int)((f1 - (float)displaymetrics.widthPixels) / 2.0F);
        }
        if (mVideoHeight > displaymetrics.heightPixels)
        {
            layoutparams.topMargin = (int)(0.0F - (float)(mVideoHeight - displaymetrics.heightPixels) / 2.0F);
        }
        mHolder.mainLayout.setLayoutParams(layoutparams);
        adjustOverlays(displaymetrics.heightPixels, displaymetrics.widthPixels);
    }

    private void adjustOverlays(int i, int j)
    {
        float f = mVideoWidth / 2;
        mOverlaySize = (float)(mVideoHeight / 2) - f;
        i = (int)((mOverlaySize * (float)i) / (float)mVideoHeight);
        android.view.ViewGroup.LayoutParams layoutparams = mHolder.topLayout.getLayoutParams();
        layoutparams.height = i;
        layoutparams.width = j;
        mHolder.topLayout.setLayoutParams(layoutparams);
        layoutparams = mHolder.bottomLayout.getLayoutParams();
        layoutparams.height = i;
        layoutparams.width = j;
        mHolder.bottomLayout.setLayoutParams(layoutparams);
    }

    private void changeCameraOrientation()
    {
        if (mMediaPlayer == null || !mMediaPlayer.isPlaying())
        {
            releaseCamera();
            getCameraID();
            getCamera();
            startCameraPreview();
        }
    }

    private void deletePreviousVideo()
    {
        File file = new File(mVideoPath);
        if (file.exists())
        {
            file.delete();
        }
    }

    private int getBackCamera()
    {
        if (getPackageManager().hasSystemFeature("android.hardware.camera.front"))
        {
            mHolder.cameraOrientation.setImageDrawable(getResources().getDrawable(0x7f0200f6));
            return 1;
        } else
        {
            return getFrontCamera();
        }
    }

    private void getCamera()
    {
        try
        {
            mCamera = Camera.open(mCameraID);
            mCamera.setDisplayOrientation(90);
            return;
        }
        catch (Exception exception)
        {
            Log.d("CAMERA", (new StringBuilder()).append("Can't open camera with id ").append(mCameraID).toString());
            exception.printStackTrace();
            return;
        }
    }

    private void getCameraID()
    {
        if (mCameraID == 1)
        {
            mCameraID = getFrontCamera();
            return;
        } else
        {
            mCameraID = getBackCamera();
            return;
        }
    }

    private int getFrontCamera()
    {
        mHolder.cameraOrientation.setImageDrawable(getResources().getDrawable(0x7f0200f5));
        return 0;
    }

    private int getSongDuration()
    {
        MediaMetadataRetriever mediametadataretriever = new MediaMetadataRetriever();
        mediametadataretriever.setDataSource(mAudioPath);
        return Integer.parseInt(mediametadataretriever.extractMetadata(9));
    }

    private void initData()
    {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            mSong = (Song)App.getGson().fromJson(bundle.getString("song"), my/googlemusic/play/model/Song);
        }
    }

    private void initFlags()
    {
        getWindow().addFlags(0x600480);
        getWindow().setFormat(-2);
    }

    private void initMediaPlayer()
    {
        try
        {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(mAudioPath);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {

                final DabbRecordActivity this$0;

                public void onPrepared(MediaPlayer mediaplayer)
                {
                    deletePreviousVideo();
                    initMediaRecorder();
                    startRecording();
                }

            
            {
                this$0 = DabbRecordActivity.this;
                super();
            }
            });
            mMediaPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                final DabbRecordActivity this$0;

                public void onCompletion(MediaPlayer mediaplayer)
                {
                    mHolder.recordingProgress.setProgress(getSongDuration());
                    mStopRecording = System.currentTimeMillis();
                    stopRecording();
                }

            
            {
                this$0 = DabbRecordActivity.this;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void initMediaRecorder()
    {
        try
        {
            mMediaRecorder = new MediaRecorder();
            mCamera.unlock();
            mMediaRecorder.setCamera(mCamera);
            mMediaRecorder.setVideoSource(1);
            mMediaRecorder.setAudioSource(1);
            mMediaRecorder.setOutputFormat(2);
            mMediaRecorder.setAudioEncoder(1);
            mMediaRecorder.setVideoEncoder(2);
            mMediaRecorder.setVideoEncodingBitRate(0x6acfc0);
            mMediaRecorder.setVideoFrameRate(30);
            mMediaRecorder.setVideoSize(mVideoHeight, mVideoWidth);
            mMediaRecorder.setOrientationHint(270);
            mMediaRecorder.setOutputFile(mVideoPath);
            mMediaRecorder.prepare();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void initTutorial(String s, View view)
    {
        s = (new ToolTip()).withText(s).withColor(getResources().getColor(0x7f0c0025)).withTextColor(getResources().getColor(0x7f0c001a)).withShadow().withAnimationType(com.nhaarman.supertooltips.ToolTip.AnimationType.FROM_TOP);
        mHolder.tutorialView = mHolder.tutorialContainer.showToolTipForView(s, view);
    }

    private void initView()
    {
        mHolder = new ViewHolder();
        setContentView(0x7f030022);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        mHolder.back = (ImageButton)findViewById(0x7f0d00bc);
        mHolder.back.setOnClickListener(this);
        mHolder.record = (ImageButton)findViewById(0x7f0d00c0);
        mHolder.record.setOnTouchListener(new android.view.View.OnTouchListener() {

            final DabbRecordActivity this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 1: default 28
            //                           0 30
            //                           1 40;
                   goto _L1 _L2 _L3
_L1:
                return false;
_L2:
                onRecordHold();
                continue; /* Loop/switch isn't completed */
_L3:
                onRecordRelease();
                if (true) goto _L1; else goto _L4
_L4:
            }

            
            {
                this$0 = DabbRecordActivity.this;
                super();
            }
        });
        mHolder.recordingProgress = (ProgressBar)findViewById(0x7f0d00c2);
        mHolder.recordingProgress.setMax(getSongDuration());
        mHolder.cameraOrientation = (ImageButton)findViewById(0x7f0d00bf);
        mHolder.cameraOrientation.setOnClickListener(this);
        mHolder.doneRecording = (ImageButton)findViewById(0x7f0d00c1);
        mHolder.doneRecording.setOnClickListener(this);
        mHolder.tutorialContainer = (ToolTipRelativeLayout)findViewById(0x7f0d00c3);
        mHolder.cameraContainer = (SurfaceView)findViewById(0x7f0d00ba);
        mHolder.cameraContainer.getHolder().addCallback(this);
        mHolder.mainLayout = (RelativeLayout)findViewById(0x7f0d00b9);
        mHolder.topLayout = (LinearLayout)findViewById(0x7f0d00bb);
        mHolder.bottomLayout = (LinearLayout)findViewById(0x7f0d00be);
        mCameraID = getBackCamera();
        getCamera();
        mVideoHeight = 720;
        mVideoWidth = 480;
        adjustLayout();
        updateRecordingProgress();
        initTutorial("Keep pressed to record", mHolder.record);
    }

    private void onRecordClick()
    {
        mHolder.record.setImageDrawable(getResources().getDrawable(0x7f0201f9));
        if (mTutorialHandler == null)
        {
            initTutorial("Keep pressed to record", mHolder.record);
            mTutorialHandler = new Handler();
            mTutorialHandler.postDelayed(new Runnable() {

                final DabbRecordActivity this$0;

                public void run()
                {
                    if (mHolder.tutorialView.getVisibility() == 0)
                    {
                        mHolder.tutorialView.remove();
                        mTutorialHandler = null;
                    }
                }

            
            {
                this$0 = DabbRecordActivity.this;
                super();
            }
            }, 2000L);
        }
    }

    private void onRecordHold()
    {
        mHoldTime = System.currentTimeMillis();
        if (mHolder.tutorialView != null)
        {
            mHolder.tutorialView.remove();
        }
        mHolder.record.setImageDrawable(getResources().getDrawable(0x7f0201f8));
        if (mHandler != null && mRunnable != null)
        {
            mHandler.removeCallbacks(mRunnable);
        }
        mRunnable = new Runnable() {

            final DabbRecordActivity this$0;

            public void run()
            {
                mHolder.recordingProgress.setProgress(0);
                initMediaPlayer();
                if (mHolder.tutorialView != null)
                {
                    mHolder.tutorialView.remove();
                }
            }

            
            {
                this$0 = DabbRecordActivity.this;
                super();
            }
        };
        mHandler.postDelayed(mRunnable, 1000L);
    }

    private void onRecordRelease()
    {
        int i = (int)(System.currentTimeMillis() - mHoldTime);
        System.out.println((new StringBuilder()).append("CLICK ").append(i).toString());
        if (i < 1000)
        {
            mHandler.removeCallbacks(mRunnable);
            onRecordClick();
        } else
        if (mMediaRecorder != null)
        {
            mStopRecording = System.currentTimeMillis();
            stopRecording();
            return;
        }
    }

    private void onRecordStopFailed()
    {
        mHolder.record.setImageDrawable(getResources().getDrawable(0x7f0201f9));
        releaseMediaRecorder();
    }

    private void releaseCamera()
    {
        if (mCamera != null)
        {
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    private void releaseMediaPlayer()
    {
        if (mMediaPlayer != null)
        {
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    private void releaseMediaRecorder()
    {
        if (mMediaRecorder != null)
        {
            mMediaRecorder.reset();
            mMediaRecorder.release();
            mMediaRecorder = null;
        }
    }

    private void startCameraPreview()
    {
        try
        {
            mCamera.setPreviewDisplay(mSurfaceHolder);
            android.hardware.Camera.Parameters parameters = mCamera.getParameters();
            parameters.setPreviewSize(mVideoHeight, mVideoWidth);
            mCamera.setDisplayOrientation(90);
            mCamera.setParameters(parameters);
            mCamera.startPreview();
            return;
        }
        catch (IOException ioexception)
        {
            Log.d("CAMERA", (new StringBuilder()).append("Can't start camera preview due to IOException ").append(ioexception).toString());
            ioexception.printStackTrace();
            return;
        }
    }

    private void startRecording()
    {
        mMediaRecorder.start();
        mPlayerHandler = new Handler();
        mPlayerRunnable = new Runnable() {

            final DabbRecordActivity this$0;

            public void run()
            {
                mMediaPlayer.start();
                mHolder.recordingProgress.setProgress(mMediaPlayer.getCurrentPosition());
            }

            
            {
                this$0 = DabbRecordActivity.this;
                super();
            }
        };
        mPlayerHandler.postDelayed(mPlayerRunnable, 500L);
        mStartRecording = System.currentTimeMillis();
        mHolder.doneRecording.setVisibility(4);
    }

    private void startShareActivity()
    {
        releaseMediaPlayer();
        System.out.println((new StringBuilder()).append("tempo total").append((int)(mStopRecording - mStartRecording)).toString());
        Intent intent = new Intent(this, my/googlemusic/play/activities/DabbShareActivity);
        intent.putExtra("song", App.getGson().toJson(mSong));
        intent.putExtra("overlay_size", mOverlaySize);
        intent.putExtra("video_width", mVideoWidth);
        intent.putExtra("camera_orientation", mCameraID);
        intent.putExtra("source_video_path", mVideoPath);
        intent.putExtra("video_duration", (int)((mStopRecording - mStartRecording) / 1000L));
        startActivity(intent);
    }

    private void stopRecording()
    {
        if (mPlayerHandler != null && mPlayerRunnable != null)
        {
            mPlayerHandler.removeCallbacks(mPlayerRunnable);
            if (mMediaPlayer.isPlaying())
            {
                mMediaPlayer.stop();
            }
        }
        try
        {
            mMediaRecorder.stop();
            mHolder.record.setImageDrawable(getResources().getDrawable(0x7f0201f9));
            if (mStopRecording - mStartRecording >= 1000L)
            {
                mHolder.doneRecording.setVisibility(0);
                initTutorial("Next", mHolder.doneRecording);
            }
            releaseMediaRecorder();
            return;
        }
        catch (Exception exception)
        {
            onRecordStopFailed();
        }
    }

    private void updateRecordingProgress()
    {
        mHandler = new Handler();
        runOnUiThread(new Runnable() {

            final DabbRecordActivity this$0;

            public void run()
            {
                if (mMediaPlayer != null && mMediaPlayer.isPlaying())
                {
                    mHolder.recordingProgress.setProgress(mMediaPlayer.getCurrentPosition());
                }
                mHandler.postDelayed(this, 100L);
            }

            
            {
                this$0 = DabbRecordActivity.this;
                super();
            }
        });
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131558589: 
        case 2131558590: 
        case 2131558592: 
        default:
            return;

        case 2131558588: 
            onBackPressed();
            return;

        case 2131558591: 
            changeCameraOrientation();
            return;

        case 2131558593: 
            startShareActivity();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initFlags();
        initData();
        initView();
    }

    protected void onPause()
    {
        releaseMediaRecorder();
        mCamera.lock();
        releaseCamera();
        releaseMediaPlayer();
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        if (mCamera == null)
        {
            mCameraID = getBackCamera();
            getCamera();
        }
        mHolder.doneRecording.setVisibility(4);
        mHolder.recordingProgress.setProgress(0);
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        mSurfaceHolder = surfaceholder;
        startCameraPreview();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }





/*
    static long access$1202(DabbRecordActivity dabbrecordactivity, long l)
    {
        dabbrecordactivity.mStopRecording = l;
        return l;
    }

*/








/*
    static Handler access$702(DabbRecordActivity dabbrecordactivity, Handler handler)
    {
        dabbrecordactivity.mTutorialHandler = handler;
        return handler;
    }

*/


}
