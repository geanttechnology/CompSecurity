// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.html:
//            IMRAIDPresentation, MRAIDBackgroundView, HTMLRenderer, Parameters, 
//            MRAIDWebView

abstract class MRAIDBasePresentation
    implements IMRAIDPresentation
{

    protected Activity activity;
    protected HTMLRenderer bridge;
    protected ImageButton closeButton;
    protected Boolean enableMRAID;
    protected MRAIDBackgroundView fullScreenBaseView;
    private boolean isCloseButtonVisible;
    private Logger logger;
    private FrameLayout viewHolder;
    private View viewOnFullScreen;

    MRAIDBasePresentation(Activity activity1, HTMLRenderer htmlrenderer, boolean flag)
    {
        enableMRAID = Boolean.valueOf(true);
        fullScreenBaseView = null;
        isCloseButtonVisible = true;
        closeButton = null;
        logger = Logger.getLogger(this);
        activity = activity1;
        bridge = htmlrenderer;
        enableMRAID = Boolean.valueOf(flag);
        fullScreenBaseView = new MRAIDBackgroundView(activity1);
        viewHolder = new FrameLayout(fullScreenBaseView.getContext());
        if (htmlrenderer.parameters().shouldBackgroundTransparent != null && htmlrenderer.parameters().shouldBackgroundTransparent.booleanValue())
        {
            viewHolder.setBackgroundColor(0);
        }
        if (enableMRAID.booleanValue())
        {
            closeButton = new ImageButton(activity1);
            closeButton.setImageResource(0x108005a);
            closeButton.setBackgroundColor(0);
            closeButton.setPadding(0, 0, 0, 0);
        }
    }

    protected void addView(View view, int i, int j)
    {
        logger.debug("addView");
        fullScreenBaseView.showFullScreenBackground();
        if (i >= getFullScreenWidth())
        {
            i = -1;
        }
        if (j >= getFullScreenHeight())
        {
            j = -1;
        }
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(i, j);
        layoutparams.gravity = 17;
        fullScreenBaseView.addView(viewHolder, 0, layoutparams);
        viewHolder.addView(view, -1, -1);
        if (enableMRAID.booleanValue())
        {
            closeButton.setOnClickListener(new android.view.View.OnClickListener() {

                final MRAIDBasePresentation this$0;

                public void onClick(View view1)
                {
                    bridge.mraidClose();
                }

            
            {
                this$0 = MRAIDBasePresentation.this;
                super();
            }
            });
            android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(50, 50);
            layoutparams1.gravity = 53;
            viewHolder.addView(closeButton, layoutparams1);
        }
        viewHolder.bringToFront();
        view.requestFocus();
        viewOnFullScreen = view;
    }

    protected void addView(MRAIDWebView mraidwebview)
    {
        addView(((View) (mraidwebview)), getFullScreenWidth(), getFullScreenHeight());
    }

    protected int getFullScreenHeight()
    {
        return activity.getResources().getDisplayMetrics().heightPixels;
    }

    protected int getFullScreenWidth()
    {
        return activity.getResources().getDisplayMetrics().widthPixels;
    }

    protected void removeView()
    {
        logger.debug("removeView");
        fullScreenBaseView.hideFullScreenBackground();
        fullScreenBaseView.removeView(viewHolder);
        if (enableMRAID.booleanValue())
        {
            closeButton.setOnClickListener(null);
            viewHolder.removeView(closeButton);
        }
        viewHolder.removeView(viewOnFullScreen);
    }

    public void resize(int i, int j, int k, int l, String s, boolean flag)
    {
        bridge.dispatchMraidError("Not supported", "resize");
    }

    public void setCloseButtonVisibility(boolean flag)
    {
        logger.info((new StringBuilder()).append("setCloseButtonVisibility(").append(flag).append(")").toString());
        if (enableMRAID.booleanValue())
        {
            if (isCloseButtonVisible != flag)
            {
                isCloseButtonVisible = flag;
                if (isCloseButtonVisible)
                {
                    closeButton.setAlpha(255);
                    closeButton.invalidate();
                    return;
                } else
                {
                    closeButton.setAlpha(0);
                    closeButton.invalidate();
                    return;
                }
            } else
            {
                logger.debug("The closeButtonVisibility is the same as the value set by outside, ignored.");
                return;
            }
        } else
        {
            logger.info("setCloseButtonVisibility doesn't work when MRAID disabled.");
            return;
        }
    }

    protected void setEnableSync(final View view, final boolean isResized)
    {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final MRAIDBasePresentation this$0;
            final boolean val$isResized;
            final View val$view;

            public void onGlobalLayout()
            {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                bridge.synchStateToPresentation(isResized);
            }

            
            {
                this$0 = MRAIDBasePresentation.this;
                view = view1;
                isResized = flag;
                super();
            }
        });
    }

    public boolean supportsInlineVideo()
    {
        MRAIDWebView mraidwebview = getCurrentView();
        if (mraidwebview == null)
        {
            return false;
        } else
        {
            return mraidwebview.supportsInlineVideo();
        }
    }
}
