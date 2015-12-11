// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.VideoView;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.html:
//            MRAIDWebView, MRAIDBackgroundView

class customSurfaceView extends WebChromeClient
{

    private SurfaceView customSurfaceView;
    private android.webkit..CustomViewCallback customViewCallback;
    private ViewGroup holder;
    final MRAIDWebView this$0;

    public View getVideoLoadingProgressView()
    {
        MRAIDWebView.access$000(MRAIDWebView.this).debug("getVideoLoadingProgressView");
        return new ProgressBar(getContext());
    }

    public void onConsoleMessage(String s, int i, String s1)
    {
        MRAIDWebView.access$000(MRAIDWebView.this).debug((new StringBuilder()).append(s).append(" -- From line ").append(i).append(" of ").append(s1).toString());
    }

    public void onHideCustomView()
    {
        MRAIDWebView.access$000(MRAIDWebView.this).debug("onHideCustomView");
        if (MRAIDWebView.access$200(MRAIDWebView.this) == null)
        {
            return;
        }
        setVisibility(0);
        customViewCallback.onCustomViewHidden();
        if (holder != null)
        {
            holder.removeView(MRAIDWebView.access$200(MRAIDWebView.this));
        }
        MRAIDWebView.access$202(MRAIDWebView.this, null);
        MRAIDWebView.access$102(MRAIDWebView.this, null);
        holder = null;
        customViewCallback = null;
        if (android.os.DK_INT >= 11)
        {
            MRAIDWebView.access$300(MRAIDWebView.this).hideFullScreenBackground();
        }
        requestFocus();
    }

    public void onShowCustomView(View view, android.webkit..CustomViewCallback customviewcallback)
    {
        MRAIDWebView.access$000(MRAIDWebView.this).debug("onShowCustomView");
        super.onShowCustomView(view, customviewcallback);
        if (MRAIDWebView.access$100(MRAIDWebView.this) != null)
        {
            MRAIDWebView.access$000(MRAIDWebView.this).debug("The custom video is alive, no need to show it again");
            return;
        }
        if (view instanceof FrameLayout)
        {
            FrameLayout framelayout = (FrameLayout)view;
            View view1 = framelayout.getFocusedChild();
            int i;
            if (view1 instanceof VideoView)
            {
                MRAIDWebView.access$102(MRAIDWebView.this, (VideoView)framelayout.getFocusedChild());
                MRAIDWebView.access$100(MRAIDWebView.this).setOnCompletionListener(MRAIDWebView.this);
                MRAIDWebView.access$100(MRAIDWebView.this).setOnErrorListener(MRAIDWebView.this);
            } else
            {
                if (view1 instanceof SurfaceView)
                {
                    MRAIDWebView.access$000(MRAIDWebView.this).debug("The custom view is surface view.");
                    customSurfaceView = (SurfaceView)view1;
                    customSurfaceView.setZOrderMediaOverlay(true);
                } else
                {
                    customSurfaceView = null;
                }
                MRAIDWebView.access$102(MRAIDWebView.this, null);
            }
        } else
        {
            MRAIDWebView.access$102(MRAIDWebView.this, null);
        }
        MRAIDWebView.access$202(MRAIDWebView.this, view);
        customViewCallback = customviewcallback;
        holder = (ViewGroup)getParent();
        i = 1;
        if (android.os.DK_INT >= 11)
        {
            MRAIDWebView.access$300(MRAIDWebView.this).showFullScreenBackground();
            holder = MRAIDWebView.access$300(MRAIDWebView.this);
            i = 0;
        }
        customviewcallback = new android.widget.outParams(-1, -1);
        setVisibility(4);
        holder.addView(view, i, customviewcallback);
        holder.bringToFront();
    }

    llback()
    {
        this$0 = MRAIDWebView.this;
        super();
        holder = null;
        customViewCallback = null;
        customSurfaceView = null;
    }
}
