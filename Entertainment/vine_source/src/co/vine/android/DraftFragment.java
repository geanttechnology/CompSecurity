// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.player.SdkVideoView;
import co.vine.android.player.VideoViewInterface;
import co.vine.android.recorder.ProgressView;
import java.io.File;

// Referenced classes of package co.vine.android:
//            BaseFragment, AbstractRecordingActivity

public class DraftFragment extends BaseFragment
    implements co.vine.android.player.VideoViewInterface.OnPreparedListener, co.vine.android.player.VideoViewInterface.OnErrorListener, co.vine.android.player.SdkVideoView.SurfaceReadyListener
{
    public static class DraftPageViewHolder
    {

        public ViewGroup containerView;
        public RelativeLayout draftContainer;
        public ProgressView progressView;
        public ImageView thumb;
        public String videoUrl;
        public SdkVideoView videoView;

        public DraftPageViewHolder(View view, String s)
        {
            videoView = (SdkVideoView)view.findViewById(0x7f0a0075);
            videoUrl = s;
            containerView = (ViewGroup)view.findViewById(0x7f0a00d6);
            progressView = (ProgressView)view.findViewById(0x7f0a00b2);
            thumb = (ImageView)view.findViewById(0x7f0a00d8);
            draftContainer = (RelativeLayout)view.findViewById(0x7f0a00d5);
        }
    }


    private static final int VISIBILITY_DELAY = 100;
    private Bitmap mBitmap;
    public boolean mCanUnhide;
    private int mDimen;
    private boolean mExpired;
    private Animation mFadeIn;
    private File mFolder;
    private DraftPageViewHolder mHolder;
    private int mIndex;
    private android.view.View.OnClickListener mListener;
    private int mProgress;
    private Animation mQuickFadeOut;
    private boolean mSelected;
    private final Runnable mStartPlayingRunnable;
    private String mThumbUrl;
    private String mVideoUrl;
    private SdkVideoView mVideoView;

    public DraftFragment()
    {
        mCanUnhide = true;
        mStartPlayingRunnable = new Runnable() {

            final DraftFragment this$0;

            public void run()
            {
                if (mVideoView.getVisibility() != 0 && mCanUnhide)
                {
                    mVideoView.setVisibility(0);
                }
            }

            
            {
                this$0 = DraftFragment.this;
                super();
            }
        };
    }

    public DraftFragment(boolean flag, int i, String s, String s1, File file, int j, int k)
    {
        mCanUnhide = true;
        mStartPlayingRunnable = new _cls1();
        mIndex = i;
        mSelected = flag;
        mVideoUrl = s;
        mFolder = file;
        mProgress = j;
        mThumbUrl = s1;
        mDimen = k;
        mExpired = false;
    }

    private void onSelected()
    {
        resumePlayer();
    }

    private void onUnselected()
    {
        mVideoView.pause();
    }

    public View getProgressView()
    {
        return mHolder.progressView;
    }

    public View getThumbnailView()
    {
        return mHolder.thumb;
    }

    public boolean isExpired()
    {
        return mExpired;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = getResources();
        layoutinflater = layoutinflater.inflate(0x7f030036, viewgroup, false);
        viewgroup = new DraftPageViewHolder(layoutinflater, mVideoUrl);
        int i = bundle.getDimensionPixelOffset(0x7f0b006a);
        int j = bundle.getDimensionPixelOffset(0x7f0b0033);
        bundle = (android.widget.RelativeLayout.LayoutParams)((DraftPageViewHolder) (viewgroup)).draftContainer.getLayoutParams();
        bundle.topMargin = i + j;
        ((DraftPageViewHolder) (viewgroup)).draftContainer.setLayoutParams(bundle);
        bundle = (RelativeLayout)layoutinflater.findViewById(0x7f0a00d6);
        bundle.setDrawingCacheEnabled(true);
        android.view.ViewGroup.LayoutParams layoutparams = bundle.getLayoutParams();
        layoutparams.height = mDimen;
        layoutparams.width = mDimen;
        bundle.setLayoutParams(layoutparams);
        bundle.setTag(mFolder);
        bundle.setOnClickListener(mListener);
        bundle = ((DraftPageViewHolder) (viewgroup)).progressView.getLayoutParams();
        bundle.width = mDimen;
        ((DraftPageViewHolder) (viewgroup)).progressView.setLayoutParams(bundle);
        ((DraftPageViewHolder) (viewgroup)).progressView.setProgressRatio((float)mProgress / 6000F);
        bundle = layoutinflater.findViewById(0x7f0a00d4);
        layoutparams = bundle.getLayoutParams();
        layoutparams.width = mDimen;
        layoutparams.height = ((AbstractRecordingActivity)getActivity()).getScreenSize().y;
        bundle.setLayoutParams(layoutparams);
        mBitmap = BitmapFactory.decodeFile(mThumbUrl);
        bundle = ((DraftPageViewHolder) (viewgroup)).thumb.getLayoutParams();
        bundle.height = mDimen;
        bundle.width = mDimen;
        ((DraftPageViewHolder) (viewgroup)).thumb.setLayoutParams(bundle);
        ((DraftPageViewHolder) (viewgroup)).thumb.setImageDrawable(new RecyclableBitmapDrawable(getActivity().getResources(), mBitmap));
        ((DraftPageViewHolder) (viewgroup)).thumb.setVisibility(0);
        mHolder = viewgroup;
        mVideoView = ((DraftPageViewHolder) (viewgroup)).videoView;
        ((AbstractRecordingActivity)getActivity()).addPlayerToPool(mVideoView);
        mVideoView.setOnPreparedListener(this);
        mVideoView.setKeepScreenOn(true);
        mVideoView.setLooping(true);
        mVideoView.setOnErrorListener(this);
        mVideoView.setSurfaceReadyListener(this);
        mFadeIn = AnimationUtils.loadAnimation(getActivity(), 0x7f04000d);
        mQuickFadeOut = AnimationUtils.loadAnimation(getActivity(), 0x7f040013);
        layoutinflater.setDrawingCacheEnabled(true);
        layoutinflater.setDrawingCacheQuality(0x100000);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (mBitmap != null)
        {
            mBitmap.recycle();
        }
        if (mVideoView != null)
        {
            mVideoView.suspend();
        }
    }

    public boolean onError(VideoViewInterface videoviewinterface, int i, int j)
    {
        videoviewinterface = (AbstractRecordingActivity)getActivity();
        if (videoviewinterface != null)
        {
            videoviewinterface.releaseOtherPlayers(mVideoView);
            mVideoView.retryOpenVideo(false);
        }
        return true;
    }

    public void onPause()
    {
        super.onPause();
        if (mVideoView != null)
        {
            mVideoView.pause();
        }
    }

    public void onPrepared(VideoViewInterface videoviewinterface)
    {
        if (mSelected && !videoviewinterface.isPlaying())
        {
            videoviewinterface.start();
            mVideoView.postDelayed(mStartPlayingRunnable, 100L);
        }
    }

    public void onSurfaceTextureAvailable(SdkVideoView sdkvideoview)
    {
        sdkvideoview.setVisibility(4);
        mVideoView.startOpenVideo();
    }

    public void pausePlayer()
    {
        if (mSelected && mVideoView.canPause())
        {
            mVideoView.pause();
        }
    }

    public void release()
    {
        mVideoView.suspend();
    }

    public void resumePlayer()
    {
        if (mVideoView.isInPlaybackState() && mVideoView.isPathPlaying(mVideoUrl))
        {
            mVideoView.start();
            return;
        }
        if (mVideoView.isSurfaceReady())
        {
            mVideoView.setVisibility(4);
            mVideoView.setVideoPath(mVideoUrl);
            return;
        } else
        {
            mVideoView.setVideoPath(mVideoUrl);
            mVideoView.setVisibility(0);
            return;
        }
    }

    public void setExpired(boolean flag)
    {
        mExpired = flag;
    }

    public void setListener(android.view.View.OnClickListener onclicklistener)
    {
        mListener = onclicklistener;
    }

    public void setSelected(boolean flag)
    {
        mSelected = flag;
        if (flag)
        {
            onSelected();
            return;
        } else
        {
            onUnselected();
            return;
        }
    }

    public void showImage()
    {
        mHolder.thumb.setVisibility(0);
        mHolder.videoView.setVisibility(8);
    }

}
