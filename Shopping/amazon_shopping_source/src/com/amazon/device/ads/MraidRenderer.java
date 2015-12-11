// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.webkit.WebView;
import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            AdRenderer, MraidView, IAdController, Log, 
//            MraidDisplayController, AdUtils, AdData, AdLayout, 
//            AdProperties

class MraidRenderer extends AdRenderer
    implements MraidView.OnCloseListener, MraidView.OnExpandListener, MraidView.OnReadyListener, MraidView.OnSpecialUrlClickListener
{

    private static final String LOG_TAG = "MraidRenderer";
    protected MraidView mraidView_;
    private WebView webView_;

    protected MraidRenderer(AdData addata, IAdController iadcontroller, WebView webview, Context context)
    {
        super(addata, iadcontroller, context);
        webView_ = webview;
    }

    protected void adLoaded(AdProperties adproperties)
    {
        super.adLoaded(adproperties);
    }

    protected MraidView createNewMraidView()
    {
        return new MraidView(this, controller.getWindowWidth(), controller.getWindowHeight(), getScalingMultiplier(), context, webView_);
    }

    protected void destroy()
    {
        if (mraidView_ != null)
        {
            mraidView_.destroy();
            mraidView_ = null;
            isDestroyed = true;
        }
        webView_ = null;
    }

    protected boolean getAdState(AdRenderer.AdState adstate)
    {
        if (mraidView_ == null)
        {
            Log.w("MraidRenderer", "Unable to retrieve ad state.");
            return false;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$device$ads$AdRenderer$AdState[];

            static 
            {
                $SwitchMap$com$amazon$device$ads$AdRenderer$AdState = new int[AdRenderer.AdState.values().length];
                try
                {
                    $SwitchMap$com$amazon$device$ads$AdRenderer$AdState[AdRenderer.AdState.EXPANDED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.device.ads.AdRenderer.AdState[adstate.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            return mraidView_.getDisplayController().isExpanded();
        }
    }

    public boolean launchExternalBrowserForLink(String s)
    {
        if (isAdViewRenderable())
        {
            return AdUtils.launchActivityForIntentLink(s, context);
        } else
        {
            return false;
        }
    }

    public void onClose(MraidView mraidview, MraidView.ViewState viewstate)
    {
        if (!isAdViewRemoved())
        {
            controller.adClosedExpansion();
        }
    }

    public void onExpand(MraidView mraidview)
    {
        if (!isAdViewRemoved())
        {
            controller.adExpanded();
        }
    }

    public void onPageFinished()
    {
        if (mraidView_ == null)
        {
            Log.w("MraidRenderer", "Call to onPageFinished() ignored because view is null.");
            return;
        } else
        {
            mraidView_.onPageFinished();
            return;
        }
    }

    public void onReady(MraidView mraidview)
    {
        adLoaded(adData.getProperties());
    }

    public void onSpecialUrlClick(MraidView mraidview, String s)
    {
        if (isAdViewRenderable())
        {
            getSpecialUrlExecutor().execute(s);
        }
    }

    protected void prepareToGoAway()
    {
        if (mraidView_ != null)
        {
            mraidView_.prepareToGoAway();
        }
    }

    protected void removeView()
    {
        if (!viewRemoved && !isDestroyed)
        {
            try
            {
                controller.getAdLayout().removeAllViews();
            }
            catch (NullPointerException nullpointerexception) { }
            viewRemoved = true;
        }
    }

    protected boolean render()
    {
        if (!isAdViewDestroyed())
        {
            mraidView_ = createNewMraidView();
            if (!mraidView_.getShouldForceRenderFailure() && mraidView_.loadHtmlData(adData.getCreative()))
            {
                renderMraidView();
                return true;
            }
        }
        return false;
    }

    protected void renderMraidView()
    {
        mraidView_.setOnReadyListener(this);
        mraidView_.setOnSpecialUrlClickListener(this);
        mraidView_.setOnExpandListener(this);
        mraidView_.setOnCloseListener(this);
        controller.getAdLayout().removeAllViews();
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
        controller.getAdLayout().addView(mraidView_, layoutparams);
    }

    protected boolean sendCommand(String s, Map map)
    {
        Log.d("MraidRenderer", "sendCommand: %s", new Object[] {
            s
        });
        if (s.equals("close") && mraidView_ != null && mraidView_.getDisplayController().isExpanded())
        {
            mraidView_.getDisplayController().close();
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean shouldReuse()
    {
        return false;
    }
}
