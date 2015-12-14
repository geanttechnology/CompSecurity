// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.github.hiteshsondhi88.libffmpeg.FFmpegExecuteResponseHandler;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.utils.FFmpegUtil;
import my.googlemusic.play.utils.FacebookUtil;
import my.googlemusic.play.utils.InstagramUtil;
import my.googlemusic.play.utils.TwitterUtil;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

public class DabbShareActivity extends AppCompatActivity
    implements android.view.View.OnClickListener, android.view.SurfaceHolder.Callback
{
    private static class ViewHolder
    {

        ImageButton back;
        CircularProgressView dialogProgress;
        ImageButton play;
        View saveDabb;
        View shareFacebook;
        View shareInstagram;
        View shareTwitter;
        RelativeLayout videoContainer;
        SurfaceView videoSurface;

        private ViewHolder()
        {
        }

    }


    private String mAudioPath;
    private int mCameraOrientation;
    private Dialog mDialog;
    private String mFinalVideoPath;
    private ViewHolder mHolder;
    private MediaPlayer mMediaPlayer;
    private int mOverlaySize;
    private Server mServer;
    private Song mSong;
    private String mSourceVideoPath;
    private int mVideoDuration;
    private int mVideoProcessProgress;
    private int mVideoWidth;

    public DabbShareActivity()
    {
        mAudioPath = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/MyMixtapez/").append("temporaryAudio.mp3").toString();
        mVideoProcessProgress = -2;
    }

    private void adjustVideoContainer()
    {
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        int i = displaymetrics.widthPixels;
        int j = convertDpToPx(28);
        mHolder.videoContainer.getLayoutParams().width = displaymetrics.widthPixels;
        mHolder.videoContainer.getLayoutParams().height = i - j;
    }

    private int convertDpToPx(int i)
    {
        return (int)((float)i * getResources().getDisplayMetrics().density);
    }

    private void createVideoProcessingDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(new ContextThemeWrapper(this, 0x7f0800e7));
        View view = LayoutInflater.from(this).inflate(0x7f030054, null, false);
        ((TextView)view.findViewById(0x7f0d01bd)).setText("Your video is being processed");
        mHolder.dialogProgress = (CircularProgressView)view.findViewById(0x7f0d0190);
        mHolder.dialogProgress.setColor(getResources().getColor(0x7f0c0020));
        mHolder.dialogProgress.setIndeterminate(true);
        mHolder.dialogProgress.startAnimation();
        builder.setView(view);
        mDialog = builder.create();
        mDialog.show();
        mDialog.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

            final DabbShareActivity this$0;

            public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
            {
                if (i != 4);
                return true;
            }

            
            {
                this$0 = DabbShareActivity.this;
                super();
            }
        });
    }

    private void initData()
    {
        Bundle bundle = getIntent().getExtras();
        String s = bundle.getString("song");
        mSong = (Song)App.getGson().fromJson(s, my/googlemusic/play/model/Song);
        mOverlaySize = (int)bundle.getFloat("overlay_size");
        mVideoWidth = bundle.getInt("video_width");
        mCameraOrientation = bundle.getInt("camera_orientation");
        mVideoDuration = bundle.getInt("video_duration");
        mSourceVideoPath = bundle.getString("source_video_path");
        mServer = ((App)getApplication()).getServer();
    }

    private void initMediaPlayer()
    {
        try
        {
            mMediaPlayer.setDataSource(mFinalVideoPath);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {

                final DabbShareActivity this$0;

                public void onPrepared(MediaPlayer mediaplayer)
                {
                    mediaplayer.setLooping(true);
                    mHolder.play.setVisibility(0);
                    if (mMediaPlayer != null && !mMediaPlayer.isPlaying())
                    {
                        mMediaPlayer.setVolume(0.0F, 0.0F);
                        mMediaPlayer.start();
                /* block-local class not found */
                class _cls1 {}

                        (new Handler()).postDelayed(new _cls1(), 300L);
                    }
                }

            
            {
                this$0 = DabbShareActivity.this;
                super();
            }
            });
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    private void initView()
    {
        setContentView(0x7f030023);
        mMediaPlayer = new MediaPlayer();
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        mHolder = new ViewHolder();
        mHolder.videoContainer = (RelativeLayout)findViewById(0x7f0d00c6);
        adjustVideoContainer();
        mHolder.videoSurface = (SurfaceView)findViewById(0x7f0d00c7);
        mHolder.videoSurface.getHolder().addCallback(this);
        mHolder.videoSurface.setOnTouchListener(new android.view.View.OnTouchListener() {

            final DabbShareActivity this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (mMediaPlayer.isPlaying())
                {
                    onVideoClick();
                }
                return true;
            }

            
            {
                this$0 = DabbShareActivity.this;
                super();
            }
        });
        mHolder.play = (ImageButton)findViewById(0x7f0d00c8);
        mHolder.back = (ImageButton)findViewById(0x7f0d00c5);
        mHolder.play.setOnClickListener(this);
        mHolder.back.setOnClickListener(this);
        mHolder.shareInstagram = findViewById(0x7f0d00c9);
        mHolder.shareTwitter = findViewById(0x7f0d00cc);
        mHolder.shareFacebook = findViewById(0x7f0d00cf);
        mHolder.saveDabb = findViewById(0x7f0d00d2);
        mHolder.shareInstagram.setOnClickListener(this);
        mHolder.shareTwitter.setOnClickListener(this);
        mHolder.shareFacebook.setOnClickListener(this);
        mHolder.saveDabb.setOnClickListener(this);
        processVideo();
    }

    private void onPlayClick()
    {
        mHolder.play.setVisibility(8);
        mMediaPlayer.start();
    }

    private void onSaveDabb()
    {
        final String outputPath = (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)).append("/My Mixtapez").toString();
        File file = new File(outputPath);
        if (!file.exists())
        {
            file.mkdirs();
        }
        outputPath = (new StringBuilder()).append(outputPath).append("/").append(mSong.getAlbum().getArtist().getName()).append(" - ").append(mSong.getName()).append(".mp4").toString();
        mServer.moveFile(mFinalVideoPath, outputPath, new my.googlemusic.play.interfaces.Server.Callback() {

            final DabbShareActivity this$0;
            final String val$outputPath;

            public void onFailure(Response response)
            {
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                Toast.with(DabbShareActivity.this).message((String)obj).show();
                scanFile(new File(outputPath));
            }

            
            {
                this$0 = DabbShareActivity.this;
                outputPath = s;
                super();
            }
        });
    }

    private void onShareFacebook()
    {
        FacebookUtil.with(this).shareVideo(mSong, mFinalVideoPath);
    }

    private void onShareInstagram()
    {
        (new InstagramUtil(this, mSong, null, mFinalVideoPath)).shareInstagram();
    }

    private void onShareTwitter()
    {
        TwitterUtil.with(this).shareVideo(mSong, mFinalVideoPath);
    }

    private void onVideoClick()
    {
        mMediaPlayer.pause();
        mHolder.play.setVisibility(0);
    }

    private void processVideo()
    {
        createVideoProcessingDialog();
        System.out.println((new StringBuilder()).append("comecou video: ").append(System.currentTimeMillis() / 1000L).toString());
        (new FFmpegUtil(this)).generateDubVideo(mAudioPath, mSourceVideoPath, mOverlaySize, mVideoWidth, mCameraOrientation, mVideoDuration, new FFmpegExecuteResponseHandler() {

            final DabbShareActivity this$0;

            public void onFailure(String s)
            {
                if (mDialog.isShowing())
                {
                    mDialog.dismiss();
                }
            }

            public void onFinish()
            {
            }

            public void onProgress(String s)
            {
                System.out.println(s);
                updateProgress(s);
            }

            public void onStart()
            {
                mHolder.dialogProgress.setIndeterminate(false);
                mHolder.dialogProgress.setMaxProgress(mVideoDuration + 1);
            }

            public void onSuccess(String s)
            {
                System.out.println((new StringBuilder()).append("terminou video: ").append(System.currentTimeMillis() / 1000L).toString());
                if (mDialog.isShowing())
                {
                    mDialog.dismiss();
                }
                mFinalVideoPath = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/MyMixtapez/").append("temporaryVideo.mp4").toString();
                initMediaPlayer();
            }

            
            {
                this$0 = DabbShareActivity.this;
                super();
            }
        });
    }

    private void releaseMediaPlayer()
    {
        if (mMediaPlayer.isPlaying())
        {
            onVideoClick();
        }
    }

    private void scanFile(File file)
    {
label0:
        {
            if (file != null)
            {
                if (android.os.Build.VERSION.SDK_INT >= 16)
                {
                    break label0;
                }
                sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse((new StringBuilder()).append("file://").append(Environment.getExternalStorageDirectory()).toString())));
            }
            return;
        }
        android.content.Context context = getApplicationContext();
        file = file.getAbsolutePath();
        android.media.MediaScannerConnection.OnScanCompletedListener onscancompletedlistener = new android.media.MediaScannerConnection.OnScanCompletedListener() {

            final DabbShareActivity this$0;

            public void onScanCompleted(String s, Uri uri)
            {
            }

            
            {
                this$0 = DabbShareActivity.this;
                super();
            }
        };
        MediaScannerConnection.scanFile(context, new String[] {
            file
        }, null, onscancompletedlistener);
    }

    private void updateProgress(String s)
    {
        if (mVideoProcessProgress == -1) goto _L2; else goto _L1
_L1:
        if (!s.contains("frame=")) goto _L2; else goto _L3
_L3:
        int j;
        s = s.split(" ");
        j = s.length;
        int i = 0;
_L4:
        String s1;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s[i];
        if (s1.contains("time"))
        {
            int k = s1.lastIndexOf(":");
            mVideoProcessProgress = Integer.parseInt(s1.substring(k + 1, k + 3));
            mHolder.dialogProgress.setProgress(mVideoProcessProgress + 1);
        }
        i++;
        if (true) goto _L4; else goto _L2
        s;
        mVideoProcessProgress = -1;
        mHolder.dialogProgress.setIndeterminate(true);
_L2:
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131558598: 
        case 2131558599: 
        case 2131558602: 
        case 2131558603: 
        case 2131558605: 
        case 2131558606: 
        case 2131558608: 
        case 2131558609: 
        default:
            return;

        case 2131558600: 
            onPlayClick();
            return;

        case 2131558597: 
            onBackPressed();
            return;

        case 2131558601: 
            onShareInstagram();
            return;

        case 2131558604: 
            onShareTwitter();
            return;

        case 2131558607: 
            onShareFacebook();
            return;

        case 2131558610: 
            onSaveDabb();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initData();
        initView();
    }

    protected void onPause()
    {
        super.onPause();
        releaseMediaPlayer();
    }

    protected void onResume()
    {
        super.onResume();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        mMediaPlayer.setDisplay(surfaceholder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }





/*
    static String access$402(DabbShareActivity dabbshareactivity, String s)
    {
        dabbshareactivity.mFinalVideoPath = s;
        return s;
    }

*/





}
