// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.app.activity;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;
import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.file.MimeTypeUtil;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.log.Logger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreHelper;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreScanHelper;
import com.amazon.gallery.framework.data.senna.SennaMediaType;
import com.amazon.gallery.framework.data.store.Asset;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.gallery.actions.SelectionAction;
import com.amazon.gallery.framework.gallery.video.GalleryVideoView;
import com.amazon.gallery.framework.gallery.video.player.VideoQuality;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.transcoder.VideoProperties;
import com.amazon.gallery.thor.app.service.VideoTranscodeService;
import com.amazon.gallery.thor.app.ui.cab.GalleryContextBar;
import com.amazon.gallery.thor.app.ui.cab.VideoTrimmerContextBar;
import com.amazon.gallery.thor.di.GalleryActivityBeans;
import com.amazon.gallery.thor.widget.RangeSeekBar;
import com.amazon.gallery.thor.widget.SeekBarThumbnailStore;
import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.common.base.Optional;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FilenameUtils;

public class VideoTrimmerActivity extends BeanAwareActivity
    implements android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnSeekCompleteListener, com.amazon.gallery.thor.app.service.VideoTranscodeService.OnUpdateListener, com.amazon.gallery.thor.widget.RangeSeekBar.OnRangeSeekBarChangeListener, com.amazon.gallery.thor.widget.SeekBarThumbnailStore.SeekBarThumbnailListener
{

    private static final String TAG = com/amazon/gallery/app/activity/VideoTrimmerActivity.getName();
    private boolean autoPlay;
    private boolean automaticTrim;
    private GalleryContextBar contextBar;
    private String currentRequestId;
    private DiskStore diskStore;
    private int end;
    private boolean framesLoaded;
    private Handler handler;
    private boolean isBound;
    private boolean isSeeking;
    private Optional maxFileSize;
    private int maxVideoLength;
    private MediaItemDao mediaItemDao;
    private MediaPlayer mediaPlayer;
    private MediaStoreHelper mediaStoreHelper;
    private NetworkConnectivity networkConnectivity;
    private Dialog networkDialog;
    private ObjectID objectId;
    private ImageView pauseButton;
    private ImageView playButton;
    private Handler playbackProgressHandler;
    private Optional preSeekPos;
    private RestClient restClient;
    private boolean restartPlayback;
    private RangeSeekBar seekBar;
    private final Runnable seekVideo = new Runnable() {

        final VideoTrimmerActivity this$0;

        public void run()
        {
label0:
            {
                if (videoView != null)
                {
                    isSeeking = true;
                    preSeekPos = Optional.of(Integer.valueOf(videoView.getCurrentPosition()));
                    if (!startChanged)
                    {
                        break label0;
                    }
                    videoView.seekTo(start);
                }
                return;
            }
            videoView.seekTo(end);
        }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
    };
    private int start;
    private boolean startChanged;
    private ImageView thumbnail;
    private SeekBarThumbnailStore thumbnailStore;
    private Video video;
    private com.amazon.gallery.thor.app.service.VideoTranscodeService.Container videoContainer;
    private VideoTranscodeService videoTranscodeService;
    private ServiceConnection videoTranscodeServiceConnection;
    private Uri videoUri;
    private GalleryVideoView videoView;

    public VideoTrimmerActivity()
    {
        super(new GalleryActivityBeans());
        preSeekPos = Optional.absent();
        autoPlay = false;
        isSeeking = false;
        automaticTrim = false;
        framesLoaded = false;
        isBound = false;
        videoTranscodeServiceConnection = new ServiceConnection() {

            final VideoTrimmerActivity this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                componentname = (com.amazon.gallery.thor.app.service.VideoTranscodeService.LocalBinder)ibinder;
                videoTranscodeService = componentname.getService();
                videoTranscodeService.addOnUpdateListener(VideoTrimmerActivity.this);
                if (automaticTrim)
                {
                    createRequest();
                }
                if (isTranscoding())
                {
                    showTrimmingProgress(true);
                }
                isBound = true;
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                if (isBound)
                {
                    videoTranscodeService.removeOnUpdateListener(VideoTrimmerActivity.this);
                    isBound = false;
                }
            }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
        };
        playbackProgressHandler = new Handler() {

            final VideoTrimmerActivity this$0;

            public void handleMessage(Message message)
            {
                if (message.what == 0)
                {
                    updatePlaybackProgress();
                    playbackProgressHandler.sendEmptyMessage(0);
                } else
                if (message.what == 1)
                {
                    removeMessages(0);
                    return;
                }
            }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
        };
    }

    private void animatePauseButton()
    {
        pauseButton.setVisibility(0);
        ViewPropertyAnimator viewpropertyanimator = pauseButton.animate();
        viewpropertyanimator.alpha(0.0F);
        viewpropertyanimator.setDuration(getResources().getInteger(0x10e0001));
        viewpropertyanimator.withEndAction(new Runnable() {

            final VideoTrimmerActivity this$0;

            public void run()
            {
                pauseButton.setVisibility(8);
                pauseButton.setAlpha(1.0F);
            }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
        });
        viewpropertyanimator.start();
    }

    private void attachResultAndFinishAsync(int i, File file)
    {
        final Intent mResultIntent = new Intent();
        if (-1 == i)
        {
            final String mimeType = MimeTypeUtil.getMimeType(file.getAbsolutePath());
            MediaStoreScanHelper mediastorescanhelper = new MediaStoreScanHelper();
            file = file.getAbsolutePath();
            mResultIntent = new com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreScanHelper.OnCompleteCallback() {

                final VideoTrimmerActivity this$0;
                final Intent val$mResultIntent;
                final String val$mimeType;

                public void onComplete(String s, Uri uri)
                {
                    mResultIntent.setDataAndType(uri, mimeType);
                    setResult(-1, mResultIntent);
                    finish();
                }

            
            {
                this$0 = VideoTrimmerActivity.this;
                mResultIntent = intent;
                mimeType = s;
                super();
            }
            };
            mediastorescanhelper.scan(this, new String[] {
                file
            }, mResultIntent);
            return;
        } else
        {
            setResult(i);
            finish();
            return;
        }
    }

    private void cancelRequest()
    {
        videoTranscodeService.cancelRequest(currentRequestId);
        currentRequestId = null;
    }

    private void createRequest()
    {
        if (video == null || videoTranscodeService == null)
        {
            return;
        }
        startService(new Intent(this, com/amazon/gallery/thor/app/service/VideoTranscodeService));
        com.amazon.gallery.thor.app.service.VideoTranscodeService.TranscodeRequest.Builder builder = new com.amazon.gallery.thor.app.service.VideoTranscodeService.TranscodeRequest.Builder(video);
        builder.withBounds(start / 1000, end / 1000);
        Object obj;
        long l;
        if (maxFileSize.isPresent())
        {
            l = ((Long)maxFileSize.get()).longValue();
        } else
        {
            l = 0xa00000L;
        }
        builder.withMaxFileSize(l);
        obj = null;
        if (videoContainer != null)
        {
            builder.withVideoContainer(videoContainer);
            obj = videoContainer.ext;
        }
        builder.withOutputFile(getOutputFile(((String) (obj))));
        obj = builder.build();
        videoTranscodeService.addRequest(((com.amazon.gallery.thor.app.service.VideoTranscodeService.TranscodeRequest) (obj)));
        currentRequestId = ((com.amazon.gallery.thor.app.service.VideoTranscodeService.TranscodeRequest) (obj)).getId();
        showTrimmingProgress(true);
        GLogger.i(TAG, (new StringBuilder()).append("Video transcode requested ").append(video.getLocalPath()).append("\tstartTime:").append(start).append("\tendTime:").append(end).toString(), new Object[0]);
    }

    private File getOutputFile(String s)
    {
        if (getIntent().hasExtra("outputPath"))
        {
            return new File(getIntent().getStringExtra("outputPath"));
        } else
        {
            return getUniqueFile((File)getApplicationBean(Keys.SHARED_FILES_DIRECTORY), (new StringBuilder()).append("TRIM_").append(video.getName()).toString(), s);
        }
    }

    private File getUniqueFile(File file, String s, String s1)
    {
        s = new File(file, s);
        String s2 = FilenameUtils.getBaseName(s.getAbsolutePath());
        if (s1 != null)
        {
            s = s1;
        } else
        {
            s = FilenameUtils.getExtension(s.getAbsolutePath());
        }
        file = new File(file, (new StringBuilder()).append(s2).append(".").append(s).toString());
        for (int i = 1; file.exists(); i++)
        {
            file = new File(file.getParentFile(), String.format("%s_%d.%s", new Object[] {
                s2, Integer.valueOf(i), s
            }));
        }

        return file;
    }

    private Video getVideo()
    {
        Object obj1;
        Uri uri;
        uri = getIntent().getData();
        obj1 = null;
        if (!"content".equals(uri.getScheme())) goto _L2; else goto _L1
_L1:
        if (!"com.amazon.gallery.provider".equals(uri.getAuthority())) goto _L4; else goto _L3
_L3:
        Object obj;
        objectId = ObjectID.parseString(uri.getLastPathSegment());
        MediaItem mediaitem = mediaItemDao.getItemById(objectId);
        obj = obj1;
        if (MediaType.VIDEO == mediaitem.getType())
        {
            obj = (Video)mediaitem;
        }
_L6:
        if (obj == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L4:
        obj = obj1;
        if ("media".equals(uri.getAuthority()))
        {
            obj = (Video)mediaStoreHelper.createMediaItemFromMediaStoreUri(uri);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        obj = obj1;
        if ("file".equals(uri.getScheme()))
        {
            obj = uri.getPath();
            Object obj2 = mediaItemDao.getItemsByLocalPath(((String) (obj)));
            if (obj2 != null && ((MediaItemCollection) (obj2)).getMediaItems().size() > 0)
            {
                obj2 = ((MediaItemCollection) (obj2)).getMediaItems();
                obj = obj1;
                if (((List) (obj2)).size() == 1)
                {
                    obj = (MediaItem)((List) (obj2)).get(0);
                    objectId = ((MediaItem) (obj)).getObjectId();
                    obj = (Video)obj;
                }
            } else
            {
                obj = getVideoFromLocalPath(((String) (obj)));
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (MediaItemUtil.isLocalMediaItem(((MediaItem) (obj))))
        {
            videoUri = Uri.fromFile(new File(((Video) (obj)).getLocalPath()));
            return ((Video) (obj));
        } else
        {
            promptIfOffline();
            videoUri = uri;
            return ((Video) (obj));
        }
    }

    private Video getVideoFromLocalPath(String s)
    {
        Video video1;
        VideoProperties videoproperties;
        try
        {
            videoproperties = new VideoProperties(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            GLogger.e(TAG, (new StringBuilder()).append("Could not find video at: ").append(s).toString(), new Object[0]);
            return null;
        }
        video1 = null;
        if (videoproperties != null)
        {
            video1 = (Video)mediaItemDao.create(MediaType.VIDEO);
            video1.setLocalPath(s);
            video1.setWidth(videoproperties.getWidth());
            video1.setHeight(videoproperties.getHeight());
            video1.setName(FilenameUtils.getName(s));
            video1.setDuration(videoproperties.getDuration());
        }
        return video1;
    }

    private void initSeekBarThumbnailStore()
    {
        thumbnailStore = SeekBarThumbnailStore.getInstance(getApplicationContext(), (RestClient)getApplicationBean(Keys.REST_CLIENT));
        thumbnailStore.attachListener(this);
    }

    private boolean isTranscoding()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (currentRequestId == null)
            {
                break label0;
            }
            flag = flag1;
            if (videoTranscodeService == null)
            {
                break label0;
            }
            com.amazon.gallery.thor.app.service.VideoTranscodeService.WorkState workstate = videoTranscodeService.getRequestWorkState(currentRequestId);
            if (workstate != com.amazon.gallery.thor.app.service.VideoTranscodeService.WorkState.STARTED)
            {
                flag = flag1;
                if (workstate != com.amazon.gallery.thor.app.service.VideoTranscodeService.WorkState.NOT_STARTED)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private void loadVideoURL(final VideoView videoView, final Video video, int i, int j)
    {
        int k;
        int l;
        videoView = new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() {

            final VideoTrimmerActivity this$0;
            final Video val$video;
            final VideoView val$videoView;

            public void onFailure(TerminalException terminalexception)
            {
                videoView.post(new Runnable() {

                    final _cls6 this$1;

                    public void run()
                    {
                        if (video.getType() == MediaType.VIDEO && video.getDuration() >= TimeUnit.MINUTES.toMillis(20L))
                        {
                            GLogger.i(VideoTrimmerActivity.TAG, "Failed to load video URL from Cloud Drive because video duration > 20 minutes", new Object[0]);
                            return;
                        } else
                        {
                            GLogger.i(VideoTrimmerActivity.TAG, "Failed to load video URL from Cloud Drive", new Object[0]);
                            return;
                        }
                    }

            
            {
                this$1 = _cls6.this;
                super();
            }
                });
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((String)obj);
            }

            public void onSuccess(String s)
            {
                videoView.post(s. new Runnable() {

                    final _cls6 this$1;
                    final String val$url;

                    public void run()
                    {
                        videoView.setVideoURI(Uri.parse(url));
                        videoView.start();
                    }

            
            {
                this$1 = final__pcls6;
                url = String.this;
                super();
            }
                });
            }

            
            {
                this$0 = VideoTrimmerActivity.this;
                videoView = videoview;
                video = video1;
                super();
            }
        };
        k = i;
        l = j;
        static class _cls15
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality = new int[VideoQuality.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._360P.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._480P.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._720P.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._AUTO.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls15..SwitchMap.com.amazon.gallery.framework.gallery.video.player.VideoQuality[VideoQuality.CURRENT_QUALITY.ordinal()];
        JVM INSTR tableswitch 1 4: default 132
    //                   1 94
    //                   2 94
    //                   3 94
    //                   4 60;
           goto _L1 _L2 _L2 _L2 _L3
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        break MISSING_BLOCK_LABEL_132;
_L4:
        video = restClient.getMediaItemURLOperation(video.getObjectId(), SennaMediaType.VIDEO, k, l, ScaleMode.SCALE_TO_FIT);
        NetworkExecutor.getInstance().executeForeground(video, videoView);
        return;
_L2:
        try
        {
            k = VideoQuality.CURRENT_QUALITY.getWidth();
            l = VideoQuality.CURRENT_QUALITY.getHeight();
        }
        // Misplaced declaration of an exception variable
        catch (final VideoView videoView)
        {
            Logger.e(TAG, "Can't get video URL", new Object[] {
                videoView
            });
            return;
        }
          goto _L4
        k = i;
        l = j;
          goto _L4
    }

    private void pause()
    {
        if (mediaPlayer != null && videoView.isPlaying())
        {
            if (pauseButton != null && pauseButton.getVisibility() == 0)
            {
                pauseButton.setVisibility(8);
            }
            if (playButton != null && playButton.getVisibility() != 0)
            {
                playButton.setVisibility(0);
            }
            videoView.pause();
        }
    }

    private void play()
    {
        if (mediaPlayer == null)
        {
            playButton.setVisibility(8);
            ((ProgressBar)findViewById(0x7f0c020a)).setVisibility(0);
            autoPlay = true;
        }
        if (mediaPlayer == null || videoView.isPlaying()) goto _L2; else goto _L1
_L1:
        handler.removeCallbacks(seekVideo);
        if (playButton != null && playButton.getVisibility() == 0)
        {
            playButton.setVisibility(8);
            animatePauseButton();
        }
        if (!restartPlayback) goto _L4; else goto _L3
_L3:
        setSelectedProgress(start);
        videoView.seekTo(start);
        restartPlayback = false;
_L6:
        if (seekBar != null)
        {
            seekBar.showProgressMarker();
        }
        videoView.start();
_L2:
        return;
_L4:
        if (preSeekPos.isPresent())
        {
            setSelectedProgress(((Integer)preSeekPos.get()).intValue());
            videoView.seekTo(((Integer)preSeekPos.get()).intValue());
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void promptIfOffline()
    {
        if (!networkConnectivity.isNetworkConnected())
        {
            networkDialog = networkConnectivity.promptNoWifi(this);
            networkDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final VideoTrimmerActivity this$0;

                public void onCancel(DialogInterface dialoginterface)
                {
                    attachResultAndFinishAsync(0, null);
                }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
            });
            networkDialog.show();
        }
    }

    private void setSelectedProgress(int i)
    {
        if (!automaticTrim)
        {
            seekBar.setSelectedProgress(i);
        }
    }

    private void setupContextBar()
    {
        contextBar = new VideoTrimmerContextBar(this, 0x7f100016);
        contextBar.addAction(0x7f0c0292, new SelectionAction() {

            final VideoTrimmerActivity this$0;

            public boolean canExecute(List list)
            {
                return true;
            }

            public boolean canExecuteTags(List list)
            {
                return true;
            }

            public void execute(List list)
            {
                if (video == null)
                {
                    return;
                } else
                {
                    pause();
                    restartPlayback = true;
                    createRequest();
                    return;
                }
            }

            public void executeTags(List list)
            {
            }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
        });
        contextBar.show();
    }

    private void setupPauseButton()
    {
        pauseButton = (ImageView)findViewById(0x7f0c0212);
        pauseButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoTrimmerActivity this$0;

            public void onClick(View view)
            {
                pause();
            }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
        });
    }

    private void setupPlayButton()
    {
        playButton = (ImageView)findViewById(0x7f0c0211);
        playButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoTrimmerActivity this$0;

            public void onClick(View view)
            {
                play();
            }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
        });
        if (!videoView.isPlaying())
        {
            playButton.setVisibility(0);
        }
    }

    private void setupRangeSeekBar()
    {
        seekBar = (RangeSeekBar)findViewById(0x7f0c020f);
        seekBar.setNotifyWhileDragging(false);
        seekBar.showProgressMarker();
        seekBar.registerOnRangeSeekBarChangeListener(this);
        com.amazon.gallery.thor.widget.VideoFramesParams videoframesparams = (new com.amazon.gallery.thor.widget.VideoFramesParams.Builder()).withMin(start).withMax((int)video.getDuration()).withVideoUri(videoUri).withMaxVideoDuration(maxVideoLength).build();
        seekBar.setVideoFramesParams(videoframesparams);
        initSeekBarThumbnailStore();
        seekBar.setFrames(thumbnailStore.getFrameThumbnails(video));
        seekBar.setOnTouchListener(new android.view.View.OnTouchListener() {

            final VideoTrimmerActivity this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 0: default 24
            //                           0 26;
                   goto _L1 _L2
_L1:
                return false;
_L2:
                pause();
                seekBar.hideProgressMarker();
                isSeeking = true;
                handler.removeCallbacks(seekVideo);
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
        });
    }

    private void setupThumbnail()
    {
        thumbnail = (ImageView)findViewById(0x7f0c020d);
        if (objectId != null)
        {
            Asset asset = diskStore.getAsset(video, video.getWidth(), video.getHeight(), com.amazon.gallery.framework.data.store.Asset.AssetType.JPG);
            if (asset != null && asset.getAsset().exists())
            {
                Glide.with(this).load(asset.getAsset()).asBitmap().into(thumbnail);
            }
            return;
        } else
        {
            Glide.with(this).load(videoUri).asBitmap().into(thumbnail);
            return;
        }
    }

    private void setupTrimmerUI(Bundle bundle)
    {
        if (getIntent().hasExtra("maxFileSize"))
        {
            maxFileSize = Optional.of(Long.valueOf(getIntent().getLongExtra("maxFileSize", 0x7fffffffffffffffL)));
        } else
        {
            maxFileSize = Optional.absent();
        }
        maxVideoLength = (int)VideoTranscodeService.getMaxVideoLength(video, maxFileSize);
        videoContainer = com.amazon.gallery.thor.app.service.VideoTranscodeService.Container.getFormat(getIntent().getStringExtra("videoContainer"));
        if (bundle != null)
        {
            start = bundle.getInt("startTime", 0);
            end = bundle.getInt("endTime", maxVideoLength);
            currentRequestId = bundle.getString("currentRequestId");
        } else
        {
            start = 0;
            end = maxVideoLength;
        }
        if (VideoTranscodeService.shouldAutoTranscode(video, maxFileSize, videoContainer))
        {
            automaticTrim = true;
            setupThumbnail();
            showTrimmingProgress(true);
            return;
        } else
        {
            setupContextBar();
            showTrimToast();
            setupRangeSeekBar();
            setupThumbnail();
            setupVideoView();
            return;
        }
    }

    private void setupVideoView()
    {
        videoView = (GalleryVideoView)findViewById(0x7f0c020c);
        videoView.setOnPreparedListener(this);
        setupVideoViewTouchListeners();
        if (MediaItemUtil.isLocalMediaItem(video))
        {
            videoView.setVideoURI(videoUri);
        } else
        {
            loadVideoURL(videoView, video, video.getWidth(), video.getHeight());
        }
        setupPlayButton();
        setupPauseButton();
    }

    private void setupVideoViewTouchListeners()
    {
        videoView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final VideoTrimmerActivity this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    togglePlayback();
                }
                return true;
            }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
        });
    }

    private void showErrorDialog(int i)
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(getString(i)).setCancelable(false).setPositiveButton(0x7f0e0093, new android.content.DialogInterface.OnClickListener() {

            final VideoTrimmerActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                attachResultAndFinishAsync(2, null);
            }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
        }).setIcon(0x1080027).show();
    }

    private void showTrimToast()
    {
        Toast.makeText(this, getResources().getString(0x7f0e0225), 1).show();
    }

    private void showTrimmingProgress(boolean flag)
    {
        boolean flag1 = false;
        Object obj = (RelativeLayout)findViewById(0x7f0c020e);
        int i;
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((RelativeLayout) (obj)).setVisibility(i);
        obj = (FrameLayout)findViewById(0x7f0c0210);
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((FrameLayout) (obj)).setVisibility(i);
    }

    private void togglePlayback()
    {
        if (mediaPlayer != null && videoView.isPlaying())
        {
            pause();
            return;
        } else
        {
            play();
            return;
        }
    }

    private void updatePlaybackProgress()
    {
        if (seekBar != null && !isSeeking && mediaPlayer != null && videoView.isPlaying())
        {
            int i = videoView.getCurrentPosition();
            seekBar.setSelectedProgress(i);
            preSeekPos = Optional.absent();
            if (i >= end)
            {
                pause();
                restartPlayback = true;
                return;
            }
        }
    }

    public void onBackPressed()
    {
        if (video != null && isTranscoding())
        {
            pause();
            cancelRequest();
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300f4);
        restClient = (RestClient)getApplicationBean(Keys.REST_CLIENT);
        mediaItemDao = (MediaItemDao)getApplicationBean(Keys.MEDIA_ITEM_DAO);
        diskStore = (DiskStore)getApplicationBean(Keys.DISK_STORE);
        mediaStoreHelper = (MediaStoreHelper)getApplicationBean(Keys.MEDIA_STORE_HELPER);
        networkConnectivity = (NetworkConnectivity)getApplicationBean(Keys.NETWORK_CONNECTIVITY);
        handler = new Handler();
        video = getVideo();
        if (video == null)
        {
            GLogger.e(TAG, "Unable to retrieve video for trimming.", new Object[0]);
            showErrorDialog(0x7f0e0221);
        } else
        if (video != null && networkDialog == null)
        {
            setupTrimmerUI(bundle);
            return;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mediaPlayer != null)
        {
            mediaPlayer.setOnPreparedListener(null);
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if (videoView != null)
        {
            videoView.stopPlayback();
            videoView.clearPlaybackListeners();
        }
        if (networkDialog != null)
        {
            networkDialog.dismiss();
        }
        if (thumbnailStore != null)
        {
            thumbnailStore.detachListener();
        }
        if (seekBar != null)
        {
            seekBar.unregisterOnRangeSeekBarChangeListener(this);
        }
    }

    public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        if (i == 3)
        {
            if (thumbnail != null)
            {
                thumbnail.setImageURI(null);
                thumbnail.setVisibility(8);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void onPause()
    {
        super.onPause();
        playbackProgressHandler.sendEmptyMessage(1);
        contextBar.onPause();
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        mediaPlayer = mediaplayer;
        mediaplayer.setOnInfoListener(this);
        mediaplayer.setOnSeekCompleteListener(this);
        ((ProgressBar)findViewById(0x7f0c020a)).setVisibility(8);
        if (autoPlay)
        {
            play();
        }
    }

    public void onRangeSeekBarFramesLoaded(RangeSeekBar rangeseekbar)
    {
        framesLoaded = true;
    }

    public void onRangeSeekBarValuesChanged(RangeSeekBar rangeseekbar, int i, int j, int k, com.amazon.gallery.thor.widget.RangeSeekBar.Thumb thumb)
    {
        GLogger.v(TAG, "User selected new range: min=%s, max=%d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        if (i == start && j != end)
        {
            startChanged = false;
        } else
        {
            startChanged = true;
        }
        handler.removeCallbacks(seekVideo);
        handler.postDelayed(seekVideo, 200L);
        start = i;
        end = j;
        i = videoView.getCurrentPosition();
        if (start > i || end < i)
        {
            restartPlayback = true;
        }
    }

    public void onResume()
    {
        super.onResume();
        overridePendingTransition(0, 0);
        playbackProgressHandler.sendEmptyMessage(0);
        contextBar.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("startTime", start);
        bundle.putInt("endTime", end);
        bundle.putString("currentRequestId", currentRequestId);
    }

    public void onSeekComplete(MediaPlayer mediaplayer)
    {
        isSeeking = false;
    }

    public void onStart()
    {
        super.onStart();
        bindService(new Intent(this, com/amazon/gallery/thor/app/service/VideoTranscodeService), videoTranscodeServiceConnection, 1);
    }

    public void onStop()
    {
        super.onStop();
        if (isBound)
        {
            isBound = false;
            unbindService(videoTranscodeServiceConnection);
            videoTranscodeService.removeOnUpdateListener(this);
        }
        setRequestedOrientation(-1);
    }

    public void onThumbnailLoaded(Bitmap bitmap, int i)
    {
        seekBar.setFrame(i, bitmap, true);
    }

    public void onVideoTranscodeCancelled(String s)
    {
    }

    public void onVideoTranscodeCompleted(String s, File file)
    {
        if (s.equals(currentRequestId))
        {
            currentRequestId = null;
            showTrimmingProgress(true);
            GLogger.i(TAG, (new StringBuilder()).append("Video transcode completed").append(video.getLocalPath()).append("\tstartTime:").append(start).append("\tendTime:").append(end).toString(), new Object[0]);
            attachResultAndFinishAsync(-1, file);
        }
    }

    public void onVideoTranscodeFailed(String s)
    {
        if (s.equals(currentRequestId))
        {
            Toast.makeText(this, getString(0x7f0e0222), 1).show();
            showTrimmingProgress(false);
            attachResultAndFinishAsync(2, null);
        }
    }

    public void onVideoTranscodeStarted(String s)
    {
    }

    public void onWindowFocusChanged(boolean flag)
    {
label0:
        {
            if (flag && seekBar != null)
            {
                if (framesLoaded)
                {
                    break label0;
                }
                ViewPropertyAnimator viewpropertyanimator = seekBar.animate();
                viewpropertyanimator.translationYBy(-seekBar.getHeight());
                viewpropertyanimator.setDuration(0L);
                viewpropertyanimator.withEndAction(new Runnable() {

                    final VideoTrimmerActivity this$0;

                    public void run()
                    {
                        seekBar.setVisibility(0);
                        seekBar.animate().translationY(0.0F).setStartDelay(1500L).setDuration(400L);
                    }

            
            {
                this$0 = VideoTrimmerActivity.this;
                super();
            }
                });
            }
            return;
        }
        seekBar.setVisibility(0);
    }






/*
    static boolean access$1102(VideoTrimmerActivity videotrimmeractivity, boolean flag)
    {
        videotrimmeractivity.isSeeking = flag;
        return flag;
    }

*/


/*
    static Optional access$1202(VideoTrimmerActivity videotrimmeractivity, Optional optional)
    {
        videotrimmeractivity.preSeekPos = optional;
        return optional;
    }

*/










/*
    static boolean access$202(VideoTrimmerActivity videotrimmeractivity, boolean flag)
    {
        videotrimmeractivity.restartPlayback = flag;
        return flag;
    }

*/









/*
    static VideoTranscodeService access$502(VideoTrimmerActivity videotrimmeractivity, VideoTranscodeService videotranscodeservice)
    {
        videotrimmeractivity.videoTranscodeService = videotranscodeservice;
        return videotranscodeservice;
    }

*/






/*
    static boolean access$902(VideoTrimmerActivity videotrimmeractivity, boolean flag)
    {
        videotrimmeractivity.isBound = flag;
        return flag;
    }

*/
}
