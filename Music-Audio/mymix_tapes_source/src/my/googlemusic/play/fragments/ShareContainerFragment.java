// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.google.gson.Gson;
import java.io.IOException;
import my.googlemusic.play.activities.DabbRecordActivity;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Connection;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.utils.FFmpegUtil;
import my.googlemusic.play.utils.InstagramUtil;
import my.googlemusic.play.utils.TwitterUtil;
import my.googlemusic.play.utils.animations.AnimationGeneric;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import my.googlemusic.play.utils.views.ProgressHintDelegate;
import my.googlemusic.play.utils.views.SeekBar;

public class ShareContainerFragment extends Fragment
    implements android.view.View.OnClickListener
{
    public static interface OnDabbDownloadListener
    {

        public abstract void onCloseDabb();

        public abstract void onStartDabbDownload();
    }


    public static final int SHARE_INSTAGRAM = 3;
    public static final int SHARE_TWITTER = 2;
    private String mAudioPath;
    private Dialog mDialog;
    private ViewHolder mHolder;
    private OnDabbDownloadListener mListener;
    private MediaPlayer mMediaPlayer;
    private Handler mPlayHandler;
    private Runnable mPlayRunnable;
    private Server mServer;
    private Song mSong;

    public ShareContainerFragment()
    {
    }

    private void adjustTrimBar()
    {
    /* block-local class not found */
    class ViewHolder {}

        mHolder.seekBar.getHintDelegate().getPopupView().setVisibility(0);
        int i = getSongDuration();
        mHolder.downloadSongProgress.setProgress(mHolder.downloadSongProgress.getMaxProgress());
        mHolder.seekBar.setMax(i - 10);
        mHolder.seekBar.setProgress(i / 2);
        mHolder.seekBar.getHintDelegate().setHintAdapter(new _cls4());
        mHolder.seekBar.setOnSeekBarChangeListener(new _cls5());
        AnimationGeneric.with(mHolder.downloadSongLayoutContainer).animation(1).duration(300).visibility(8).ready();
    }

    private void createAudioCropDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(new ContextThemeWrapper(getActivity(), 0x7f0800e7));
        View view = LayoutInflater.from(getActivity()).inflate(0x7f030054, null, false);
        ((TextView)view.findViewById(0x7f0d01bd)).setText("Your song is beign cropped");
        CircularProgressView circularprogressview = (CircularProgressView)view.findViewById(0x7f0d0190);
        circularprogressview.setColor(getResources().getColor(0x7f0c0020));
        circularprogressview.setIndeterminate(true);
        circularprogressview.startAnimation();
        builder.setView(view);
        mDialog = builder.create();
        mDialog.show();
        mDialog.setOnKeyListener(new _cls7());
    }

    private void downloadSong()
    {
        onDownloadSong();
        mServer.downloadDabbSong(mSong, new _cls2());
    }

    private int getSongDuration()
    {
        MediaMetadataRetriever mediametadataretriever = new MediaMetadataRetriever();
        mediametadataretriever.setDataSource(mAudioPath);
        return (int)(Long.parseLong(mediametadataretriever.extractMetadata(9)) / 1000L);
    }

    private void hideShareComponent()
    {
        mHolder.shareBox.post(new _cls10());
    }

    private void initData()
    {
        mServer = ((App)getActivity().getApplication()).getServer();
    }

    private void initMediaPlayer()
    {
        try
        {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(mAudioPath);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnPreparedListener(new _cls3());
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    private View initView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(0x7f030074, viewgroup, false);
        initData();
        initView(((View) (layoutinflater)));
        return layoutinflater;
    }

    private void initView(View view)
    {
        mHolder = new ViewHolder(null);
        mHolder.shareView = view.findViewById(0x7f0d026c);
        mHolder.shareBox = view.findViewById(0x7f0d026b);
        mHolder.shareTwitterImage = (ImageView)view.findViewById(0x7f0d00cd);
        mHolder.shareTwitterText = (TextView)view.findViewById(0x7f0d00ce);
        mHolder.shareInstagramImage = (ImageView)view.findViewById(0x7f0d00ca);
        mHolder.shareInstagramText = (TextView)view.findViewById(0x7f0d00cb);
        mHolder.shareInstagramContent = view.findViewById(0x7f0d00c9);
        mHolder.shareTwitterContent = view.findViewById(0x7f0d00cc);
        mHolder.shareDabbContent = view.findViewById(0x7f0d00d2);
        mHolder.shareDabbImage = (ImageView)view.findViewById(0x7f0d00d3);
        mHolder.shareDabbText = (TextView)view.findViewById(0x7f0d00d4);
        mHolder.shareView.setOnClickListener(this);
        mHolder.shareInstagramContent.setOnClickListener(this);
        mHolder.shareTwitterContent.setOnClickListener(this);
        mHolder.shareDabbContent.setOnClickListener(this);
        mHolder.shareBox.setOnClickListener(this);
        mHolder.dabbTrimLayoutContainer = view.findViewById(0x7f0d0191);
        mHolder.seekBar = (SeekBar)view.findViewById(0x7f0d0197);
        mHolder.seekBar.getHintDelegate().getPopupView().setVisibility(8);
        mHolder.confirmAudioTrim = (TextView)view.findViewById(0x7f0d0195);
        mHolder.cancelAudioTrim = (TextView)view.findViewById(0x7f0d0194);
        mHolder.mediaAction = (ImageButton)view.findViewById(0x7f0d0196);
        mHolder.mediaAction.setOnClickListener(this);
        mHolder.confirmAudioTrim.setOnClickListener(this);
        mHolder.cancelAudioTrim.setOnClickListener(this);
        mHolder.dabbTrimLayoutContainer.setOnClickListener(this);
        mHolder.downloadSongLayoutContainer = view.findViewById(0x7f0d018f);
        mHolder.downloadSongProgress = (CircularProgressView)view.findViewById(0x7f0d0190);
        mHolder.downloadSongProgress.setColor(getResources().getColor(0x7f0c0020));
        mHolder.downloadSongLayoutContainer.setOnClickListener(this);
    }

    public static ShareContainerFragment newInstance()
    {
        return new ShareContainerFragment();
    }

    private void onCancelDabbClick()
    {
        AnimationGeneric.with(mHolder.dabbTrimLayoutContainer).animation(1).duration(300).visibility(8).ready();
        mHolder.seekBar.getHintDelegate().getPopupView().setVisibility(8);
        releaseMediaPlayer();
        mListener.onCloseDabb();
    }

    private void onConfirmClick()
    {
        createAudioCropDialog();
        (new FFmpegUtil(getActivity())).cropAudio(mAudioPath, mHolder.seekBar.getProgress(), new _cls6());
    }

    private void onDabbClick()
    {
        if (Connection.with(getActivity()).isConnected())
        {
            mHolder.dabbTrimLayoutContainer.setVisibility(0);
            mHolder.downloadSongProgress.resetAnimation();
            mHolder.downloadSongProgress.startAnimation();
            downloadSong();
            return;
        } else
        {
            Toast.with(getActivity()).message("You don't have internet connection").show();
            return;
        }
    }

    private void onDownloadSong()
    {
        mListener.onStartDabbDownload();
        mHolder.downloadSongProgress.resetAnimation();
        mHolder.downloadSongLayoutContainer.setVisibility(0);
        mHolder.downloadSongProgress.setIndeterminate(true);
        mHolder.downloadSongProgress.startAnimation();
    }

    private void onInstagramClick()
    {
        if (Connection.with(getActivity()).isConnected())
        {
            (new InstagramUtil(getActivity(), mSong, null, null)).shareInstagram();
            return;
        } else
        {
            Toast.with(getActivity()).message("You don't have internet connection").show();
            return;
        }
    }

    private void onMediaActionClick()
    {
label0:
        {
            if (mMediaPlayer != null)
            {
                if (mMediaPlayer.isPlaying())
                {
                    break label0;
                }
                onMediaPlay();
            }
            return;
        }
        onMediaPause();
    }

    private void onMediaPause()
    {
        mHolder.mediaAction.setImageDrawable(getResources().getDrawable(0x7f0200ca));
        mMediaPlayer.pause();
    }

    private void onMediaPlay()
    {
        int i = mHolder.seekBar.getProgress() * 1000;
        if (mPlayHandler != null && mPlayRunnable != null)
        {
            mPlayHandler.removeCallbacks(mPlayRunnable);
        }
        mHolder.mediaAction.setImageDrawable(getResources().getDrawable(0x7f0200c9));
        mMediaPlayer.seekTo(i);
        mMediaPlayer.start();
        mPlayHandler = new Handler();
        mPlayRunnable = new _cls8(i);
        mPlayHandler.postDelayed(mPlayRunnable, 10000L);
    }

    private void onStartRecordActivity()
    {
        mMediaPlayer.pause();
        Intent intent = new Intent(getActivity(), my/googlemusic/play/activities/DabbRecordActivity);
        mSong.getAlbum().setSongs(null);
        intent.putExtra("song", App.getGson().toJson(mSong, my/googlemusic/play/model/Song));
        startActivity(intent);
    }

    private void onTwitterClick()
    {
        if (Connection.with(getActivity()).isConnected())
        {
            TwitterUtil.with(getActivity()).sharePicture(mSong);
            return;
        } else
        {
            Toast.with(getActivity()).message("You don't have internet connection").show();
            return;
        }
    }

    private void releaseMediaPlayer()
    {
        if (mMediaPlayer != null)
        {
            onMediaPause();
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    private void shareClick()
    {
        if (mHolder.shareTwitterImage.getVisibility() == 0)
        {
            hideShareComponent();
        } else
        if (mHolder.shareView.getVisibility() == 4)
        {
            showShareComponent();
            return;
        }
    }

    private void showShareComponent()
    {
        AnimationGeneric.with(mHolder.shareView).animation(0).duration(250).visibility(0).ready();
        mHolder.shareBox.postDelayed(new _cls9(), 250L);
    }

    public String convertValueToTime(int i)
    {
        int j = i / 3600;
        int k = (i % 3600) / 60;
        i %= 60;
        if (j == 0)
        {
            return String.format("%d:%02d", new Object[] {
                Integer.valueOf(k), Integer.valueOf(i)
            });
        } else
        {
            return String.format("%02d:%02d:%02d", new Object[] {
                Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i)
            });
        }
    }

    public void hideComponents()
    {
        if (mHolder.dabbTrimLayoutContainer.getVisibility() == 0)
        {
            hideShareComponent();
            mHolder.dabbTrimLayoutContainer.postDelayed(new _cls1(), 300L);
            releaseMediaPlayer();
            mListener.onCloseDabb();
            mHolder.seekBar.getHintDelegate().getPopupView().setVisibility(8);
            return;
        } else
        {
            hideShareComponent();
            return;
        }
    }

    public boolean isActive()
    {
        return mHolder.shareView.getVisibility() != 4;
    }

    public void onAttach(Activity activity)
    {
        try
        {
            mListener = (OnDabbDownloadListener)activity;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement OnDabbDownloadListener").toString());
        }
        super.onAttach(activity);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131559020: 
            hideComponents();
            return;

        case 2131558601: 
            onInstagramClick();
            return;

        case 2131558604: 
            onTwitterClick();
            return;

        case 2131558610: 
            onDabbClick();
            return;

        case 2131558805: 
            onConfirmClick();
            return;

        case 2131558804: 
            onCancelDabbClick();
            return;

        case 2131558806: 
            onMediaActionClick();
            return;
        }
    }

    public Animation onCreateAnimation(int i, boolean flag, int j)
    {
        return super.onCreateAnimation(i, flag, j);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return initView(layoutinflater, viewgroup);
    }

    public void onDestroy()
    {
        if (mMediaPlayer != null)
        {
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
        super.onDestroy();
    }

    public void share(Song song)
    {
        mSong = song;
        shareClick();
    }




/*
    static String access$202(ShareContainerFragment sharecontainerfragment, String s)
    {
        sharecontainerfragment.mAudioPath = s;
        return s;
    }

*/








    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls1 {}

}
