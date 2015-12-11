// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.sample.castcompanionlibrary.cast.exceptions.CastException;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.OnFailedListener;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import java.net.URL;

// Referenced classes of package com.google.sample.castcompanionlibrary.widgets:
//            IMiniController

public class MiniController extends RelativeLayout
    implements IMiniController
{
    public static interface OnMiniControllerChangedListener
        extends OnFailedListener
    {

        public abstract void onPlayPauseClicked(View view)
            throws CastException, TransientNetworkDisconnectionException, NoConnectionException;

        public abstract void onTargetActivityInvoked(Context context)
            throws TransientNetworkDisconnectionException, NoConnectionException;
    }


    public static final int IDLE = 3;
    public static final int PAUSE = 2;
    public static final int PLAYBACK = 1;
    private static final String TAG = "MiniController";
    private OnMiniControllerChangedListener listener;
    private View mContainer;
    protected ImageView mIcon;
    private Uri mIconUri;
    protected ProgressBar mLoading;
    private Drawable mPauseDrawable;
    private Drawable mPlayDrawable;
    protected ImageView mPlayPause;
    protected TextView mSubTitle;
    protected TextView mTitle;

    public MiniController(Context context)
    {
        super(context);
        loadViews();
    }

    public MiniController(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        LayoutInflater.from(context).inflate(com.google.sample.castcompanionlibrary.R.layout.mini_controller, this);
        mPauseDrawable = getResources().getDrawable(com.google.sample.castcompanionlibrary.R.drawable.ic_av_pause_light);
        mPlayDrawable = getResources().getDrawable(com.google.sample.castcompanionlibrary.R.drawable.ic_av_play_light);
        loadViews();
        setupCallbacks();
    }

    private void loadViews()
    {
        mIcon = (ImageView)findViewById(com.google.sample.castcompanionlibrary.R.id.iconView);
        mTitle = (TextView)findViewById(com.google.sample.castcompanionlibrary.R.id.titleView);
        mSubTitle = (TextView)findViewById(com.google.sample.castcompanionlibrary.R.id.subTitleView);
        mPlayPause = (ImageView)findViewById(com.google.sample.castcompanionlibrary.R.id.playPauseView);
        mLoading = (ProgressBar)findViewById(com.google.sample.castcompanionlibrary.R.id.loadingView);
        mContainer = findViewById(com.google.sample.castcompanionlibrary.R.id.bigContainer);
    }

    private void setIcon(Bitmap bitmap)
    {
        mIcon.setImageBitmap(bitmap);
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
        mPlayPause.setOnClickListener(new android.view.View.OnClickListener() {

            final MiniController this$0;

            public void onClick(View view)
            {
                if (listener == null)
                {
                    break MISSING_BLOCK_LABEL_31;
                }
                setLoadingVisibility(true);
                listener.onPlayPauseClicked(view);
                return;
                view;
                listener.onFailed(com.google.sample.castcompanionlibrary.R.string.failed_perform_action, -1);
                return;
                view;
                listener.onFailed(com.google.sample.castcompanionlibrary.R.string.failed_no_connection_trans, -1);
                return;
                view;
                listener.onFailed(com.google.sample.castcompanionlibrary.R.string.failed_no_connection, -1);
                return;
            }

            
            {
                this$0 = MiniController.this;
                super();
            }
        });
        mContainer.setOnClickListener(new android.view.View.OnClickListener() {

            final MiniController this$0;

            public void onClick(View view)
            {
                if (listener == null)
                {
                    break MISSING_BLOCK_LABEL_40;
                }
                setLoadingVisibility(false);
                listener.onTargetActivityInvoked(mIcon.getContext());
                return;
                view;
                listener.onFailed(com.google.sample.castcompanionlibrary.R.string.failed_perform_action, -1);
                return;
            }

            
            {
                this$0 = MiniController.this;
                super();
            }
        });
    }

    public boolean isVisible()
    {
        return isShown();
    }

    public void removeOnMiniControllerChangedListener(OnMiniControllerChangedListener onminicontrollerchangedlistener)
    {
        if (onminicontrollerchangedlistener != null && listener == onminicontrollerchangedlistener)
        {
            listener = null;
        }
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
                final MiniController this$0;

                public void run()
                {
                    try
                    {
                        bm = BitmapFactory.decodeStream((new URL(mIconUri.toString())).openStream());
                    }
                    catch (Exception exception)
                    {
                        LogUtils.LOGE("MiniController", (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(mIconUri).append(", using the default one").toString(), exception);
                        bm = BitmapFactory.decodeResource(getResources(), com.google.sample.castcompanionlibrary.R.drawable.dummy_album_art);
                    }
                    mIcon.post(new Runnable() {

                        final _cls3 this$1;

                        public void run()
                        {
                            setIcon(bm);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                }

            
            {
                this$0 = MiniController.this;
                super();
                bm = null;
            }
            })).start();
            return;
        }
    }

    public void setOnMiniControllerChangedListener(OnMiniControllerChangedListener onminicontrollerchangedlistener)
    {
        if (onminicontrollerchangedlistener != null)
        {
            listener = onminicontrollerchangedlistener;
        }
    }

    public void setPlaybackStatus(int i)
    {
        if (i == 2)
        {
            mPlayPause.setVisibility(0);
            mPlayPause.setImageDrawable(mPauseDrawable);
            setLoadingVisibility(false);
            return;
        }
        if (i == 3)
        {
            mPlayPause.setVisibility(0);
            mPlayPause.setImageDrawable(mPlayDrawable);
            setLoadingVisibility(false);
            return;
        }
        if (i == 1)
        {
            mPlayPause.setVisibility(4);
            setLoadingVisibility(false);
            return;
        }
        if (i == 4)
        {
            mPlayPause.setVisibility(4);
            setLoadingVisibility(true);
            return;
        } else
        {
            mPlayPause.setVisibility(4);
            setLoadingVisibility(false);
            return;
        }
    }

    public void setSubTitle(String s)
    {
        mSubTitle.setText(s);
    }

    public void setTitle(String s)
    {
        mTitle.setText(s);
    }




}
