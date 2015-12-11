// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.dialog.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.MediaRouteControllerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.sample.castcompanionlibrary.cast.VideoCastManager;
import com.google.sample.castcompanionlibrary.cast.callbacks.VideoCastConsumerImpl;
import com.google.sample.castcompanionlibrary.cast.exceptions.CastException;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import java.net.URL;
import java.util.List;

public class VideoMediaRouteControllerDialog extends MediaRouteControllerDialog
{

    private static final String TAG = LogUtils.makeLogTag(com/google/sample/castcompanionlibrary/cast/dialog/video/VideoMediaRouteControllerDialog);
    private VideoCastConsumerImpl castConsumerImpl;
    private VideoCastManager mCastManager;
    private boolean mClosed;
    private Context mContext;
    private TextView mEmptyText;
    private ImageView mIcon;
    private View mIconContainer;
    private Uri mIconUri;
    private ProgressBar mLoading;
    private Drawable mPauseDrawable;
    private ImageView mPausePlay;
    private Drawable mPlayDrawable;
    protected int mState;
    private TextView mSubTitle;
    private TextView mTitle;

    public VideoMediaRouteControllerDialog(Context context)
    {
        super(context, com.google.sample.castcompanionlibrary.R.style.CastDialog);
        try
        {
            mContext = context;
            mCastManager = VideoCastManager.getInstance();
            mState = mCastManager.getPlaybackStatus();
            castConsumerImpl = new VideoCastConsumerImpl() {

                final VideoMediaRouteControllerDialog this$0;

                public void onRemoteMediaPlayerMetadataUpdated()
                {
                    updateMetadata();
                }

                public void onRemoteMediaPlayerStatusUpdated()
                {
                    mState = mCastManager.getPlaybackStatus();
                    updatePlayPauseState(mState);
                }

            
            {
                this$0 = VideoMediaRouteControllerDialog.this;
                super();
            }
            };
            mCastManager.addVideoCastConsumer(castConsumerImpl);
            mPauseDrawable = context.getResources().getDrawable(com.google.sample.castcompanionlibrary.R.drawable.ic_av_pause_sm_dark);
            mPlayDrawable = context.getResources().getDrawable(com.google.sample.castcompanionlibrary.R.drawable.ic_av_play_sm_dark);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            LogUtils.LOGE(TAG, "Failed to update the content of dialog", context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            LogUtils.LOGE(TAG, "Failed to update the content of dialog", context);
        }
    }

    public VideoMediaRouteControllerDialog(Context context, int i)
    {
        super(context, i);
    }

    private void hideControls(boolean flag, int i)
    {
        boolean flag1 = false;
        TextView textview;
        int j;
        if (flag)
        {
            j = 8;
        } else
        {
            j = 0;
        }
        mIcon.setVisibility(j);
        mIconContainer.setVisibility(j);
        mPausePlay.setVisibility(j);
        mTitle.setVisibility(j);
        mSubTitle.setVisibility(j);
        textview = mEmptyText;
        j = i;
        if (i == 0)
        {
            j = com.google.sample.castcompanionlibrary.R.string.no_media_info;
        }
        textview.setText(j);
        textview = mEmptyText;
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }

    private void loadViews(View view)
    {
        mIcon = (ImageView)view.findViewById(com.google.sample.castcompanionlibrary.R.id.iconView);
        mIconContainer = view.findViewById(com.google.sample.castcompanionlibrary.R.id.iconContainer);
        mPausePlay = (ImageView)view.findViewById(com.google.sample.castcompanionlibrary.R.id.playPauseView);
        mTitle = (TextView)view.findViewById(com.google.sample.castcompanionlibrary.R.id.titleView);
        mSubTitle = (TextView)view.findViewById(com.google.sample.castcompanionlibrary.R.id.subTitleView);
        mLoading = (ProgressBar)view.findViewById(com.google.sample.castcompanionlibrary.R.id.loadingView);
        mEmptyText = (TextView)view.findViewById(com.google.sample.castcompanionlibrary.R.id.emptyView);
    }

    private void setLoadingVisibility(boolean flag)
    {
        ProgressBar progressbar = mLoading;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        progressbar.setVisibility(i);
    }

    private void setupCallbacks()
    {
        mPausePlay.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoMediaRouteControllerDialog this$0;

            public void onClick(View view)
            {
                if (mCastManager == null)
                {
                    return;
                }
                try
                {
                    mCastManager.togglePlayback();
                    setLoadingVisibility(true);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    setLoadingVisibility(false);
                    LogUtils.LOGE(VideoMediaRouteControllerDialog.TAG, "Failed to toggle playback", view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    setLoadingVisibility(false);
                    LogUtils.LOGE(VideoMediaRouteControllerDialog.TAG, "Failed to toggle playback due to network issues", view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    setLoadingVisibility(false);
                }
                LogUtils.LOGE(VideoMediaRouteControllerDialog.TAG, "Failed to toggle playback due to network issues", view);
            }

            
            {
                this$0 = VideoMediaRouteControllerDialog.this;
                super();
            }
        });
        mIcon.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoMediaRouteControllerDialog this$0;

            public void onClick(View view)
            {
                if (mCastManager != null && mCastManager.getTargetActivity() != null)
                {
                    try
                    {
                        mCastManager.onTargetActivityInvoked(mContext);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        LogUtils.LOGE(VideoMediaRouteControllerDialog.TAG, "Failed to start the target activity due to network issues", view);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        LogUtils.LOGE(VideoMediaRouteControllerDialog.TAG, "Failed to start the target activity due to network issues", view);
                    }
                    cancel();
                }
            }

            
            {
                this$0 = VideoMediaRouteControllerDialog.this;
                super();
            }
        });
    }

    private void updateMetadata()
    {
        Object obj = null;
        MediaInfo mediainfo = mCastManager.getRemoteMediaInformation();
        obj = mediainfo;
_L2:
        if (obj == null)
        {
            hideControls(true, com.google.sample.castcompanionlibrary.R.string.no_media_info);
            return;
        }
        break; /* Loop/switch isn't completed */
        obj;
        hideControls(true, com.google.sample.castcompanionlibrary.R.string.failed_no_connection_short);
        return;
        Exception exception;
        exception;
        LogUtils.LOGE(TAG, "Failed to get media information", exception);
        if (true) goto _L2; else goto _L1
_L1:
        hideControls(false, 0);
        obj = ((MediaInfo) (obj)).getMetadata();
        mTitle.setText(((MediaMetadata) (obj)).getString("com.google.android.gms.cast.metadata.TITLE"));
        String s = ((MediaMetadata) (obj)).getString("com.google.android.gms.cast.metadata.SUBTITLE");
        if (s == null || s.length() == 0)
        {
            mSubTitle.setVisibility(8);
        } else
        {
            mSubTitle.setText(s);
        }
        setIcon(((WebImage)((MediaMetadata) (obj)).getImages().get(0)).getUrl());
        return;
    }

    private void updatePlayPauseState(int i)
    {
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
                        if (mPausePlay != null)
                        {
                            switch (i)
                            {
                            default:
                                mPausePlay.setVisibility(4);
                                setLoadingVisibility(false);
                                break;

                            case 1: // '\001'
                                break label1;

                            case 2: // '\002'
                                break label3;

                            case 3: // '\003'
                                break label2;

                            case 4: // '\004'
                                break label0;
                            }
                        }
                        return;
                    }
                    mPausePlay.setVisibility(0);
                    mPausePlay.setImageDrawable(mPauseDrawable);
                    setLoadingVisibility(false);
                    return;
                }
                mPausePlay.setVisibility(0);
                mPausePlay.setImageDrawable(mPlayDrawable);
                setLoadingVisibility(false);
                return;
            }
            mPausePlay.setVisibility(4);
            setLoadingVisibility(false);
            return;
        }
        mPausePlay.setVisibility(4);
        setLoadingVisibility(true);
    }

    public View onCreateMediaControlView(Bundle bundle)
    {
        bundle = getLayoutInflater().inflate(com.google.sample.castcompanionlibrary.R.layout.custom_media_route_controller_controls_dialog, null);
        loadViews(bundle);
        mState = mCastManager.getPlaybackStatus();
        updatePlayPauseState(mState);
        updateMetadata();
        setupCallbacks();
        return bundle;
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (castConsumerImpl != null)
        {
            mCastManager.removeVideoCastConsumer(castConsumerImpl);
        }
        mClosed = true;
    }

    protected void onStop()
    {
        if (mCastManager != null)
        {
            mCastManager.removeVideoCastConsumer(castConsumerImpl);
        }
        super.onStop();
    }

    public void setIcon(Uri uri)
    {
        if (mIconUri != null && mIconUri.equals(uri))
        {
            return;
        } else
        {
            mIconUri = uri;
            (new Thread(new Runnable() {

                Bitmap bm;
                final VideoMediaRouteControllerDialog this$0;

                public void run()
                {
                    try
                    {
                        bm = BitmapFactory.decodeStream((new URL(mIconUri.toString())).openStream());
                    }
                    catch (Exception exception)
                    {
                        LogUtils.LOGE(VideoMediaRouteControllerDialog.TAG, (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(mIconUri).append(", using the default one").toString(), exception);
                        bm = BitmapFactory.decodeResource(mContext.getResources(), com.google.sample.castcompanionlibrary.R.drawable.video_placeholder_200x200);
                    }
                    if (mClosed)
                    {
                        return;
                    } else
                    {
                        mIcon.post(new Runnable() {

                            final _cls2 this$1;

                            public void run()
                            {
                                mIcon.setImageBitmap(bm);
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        });
                        return;
                    }
                }

            
            {
                this$0 = VideoMediaRouteControllerDialog.this;
                super();
                bm = null;
            }
            })).start();
            return;
        }
    }










}
