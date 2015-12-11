// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.apprupt.sdk.adview.CloseButtonPosition;
import com.apprupt.sdk.adview.ExpandProperties;
import com.apprupt.sdk.adview.OrientationProperties;
import com.apprupt.sdk.mediation.Adapter;
import com.apprupt.sdk.mediation.InlineAdWrapper;
import com.apprupt.sdk.mediation.Mediator;
import com.apprupt.sdk.mediation.Size;

// Referenced classes of package com.apprupt.sdk:
//            CvAdWrapper, CvMediator, CvExpandActivity, MRAIDView, 
//            CvViewHelper, CvCloseButton, CvContext

public class CvInlineAdWrapper extends CvAdWrapper
    implements InlineAdWrapper
{

    private CvCloseButton closeButton;
    private RelativeLayout containerView;
    private CvExpandActivity expandActivity;
    private com.apprupt.sdk.mediation.InlineAdWrapper.Listener listener;
    private MRAIDView mraidView;

    CvInlineAdWrapper(Adapter adapter, CvMediator cvmediator)
    {
        super(adapter, cvmediator);
        mraidView = null;
        containerView = null;
        listener = null;
        closeButton = null;
        expandActivity = null;
        setListener((com.apprupt.sdk.mediation.InlineAdWrapper.Listener)cvmediator.getListener());
    }

    private void afterPrepare(Runnable runnable)
    {
        containerView = new RelativeLayout(getMediator().getContext());
        containerView.addView(mraidView);
        setupSize(getSize());
        runnable.run();
    }

    void adResponseProcessed()
    {
        getMediator().adDidFinishLoading(this);
    }

    public void changeCloseButtonVisibility(boolean flag)
    {
        if (expandActivity != null)
        {
            CvExpandActivity cvexpandactivity = expandActivity;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            cvexpandactivity.changeCloseButtonVisibility(flag);
        }
    }

    Runnable closeButtonHandler()
    {
        return mraidView.closeButtonHandler();
    }

    void expand()
    {
        CvViewHelper.runOnUIThread(new _cls3());
    }

    ExpandProperties getExpandProperties()
    {
        return mraidView.getExpandProperties();
    }

    View getExpandView()
    {
        try
        {
            android.view.ViewParent viewparent = mraidView.getParent();
            if (viewparent instanceof ViewGroup)
            {
                ((ViewGroup)viewparent).removeView(mraidView);
            }
        }
        catch (Exception exception) { }
        return mraidView;
    }

    public com.apprupt.sdk.mediation.InlineAdWrapper.Listener getListener()
    {
        return listener;
    }

    OrientationProperties getOrientationProperties()
    {
        return mraidView.getOrientationProperties();
    }

    public Size getSize()
    {
        return getAdSize();
    }

    public View getView()
    {
        return containerView;
    }

    void hideCloseButton()
    {
        try
        {
            if (closeButton != null)
            {
                closeButton.setListener(null);
                containerView.removeView(closeButton);
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public boolean isBusy()
    {
        return mraidView.isBusy();
    }

    public void onDestroy()
    {
        try
        {
            if (expandActivity != null)
            {
                expandActivity.finish();
            }
        }
        catch (Exception exception) { }
        listener = null;
        mraidView.cancel();
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public void prepare(Runnable runnable)
    {
        CvViewHelper.runOnUIThread(new _cls1(runnable), true);
    }

    void restoreView(Size size)
    {
        ((ViewGroup)mraidView.getParent()).removeView(mraidView);
        containerView.addView(mraidView);
        setupSize(getSize());
        containerView.invalidate();
        try
        {
            if (expandActivity != null)
            {
                ((CvContext)mraidView.getContext()).popContext();
                expandActivity.finish();
            }
            expandActivity = null;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Size size)
        {
            return;
        }
    }

    public void setBackgroundColor(int i)
    {
        if (expandActivity != null)
        {
            expandActivity.setBackgroundColor(i);
        }
    }

    void setExpandActivity(CvExpandActivity cvexpandactivity)
    {
        expandActivity = cvexpandactivity;
    }

    public void setListener(com.apprupt.sdk.mediation.InlineAdWrapper.Listener listener1)
    {
        listener = listener1;
    }

    public void setMediator(Mediator mediator)
    {
        super.setMediator(mediator);
        setListener((com.apprupt.sdk.mediation.InlineAdWrapper.Listener)getMediator().getListener());
    }

    void setupSize(Size size)
    {
        android.content.Context context = getMediator().getContext();
        int i = size.computedWidth(context);
        int j = size.computedHeight(context, false);
        size = new android.widget.RelativeLayout.LayoutParams(i, j);
        size.addRule(13);
        int k = CvViewHelper.dp2px(50F);
        mraidView.setLayoutParams(size);
        mraidView.setMinimumHeight(k);
        if (!mraidView.isExpanded())
        {
            size = new android.widget.RelativeLayout.LayoutParams(i, j);
            size.addRule(13);
            containerView.setLayoutParams(size);
            containerView.setMinimumHeight(k);
        }
    }

    void showCloseButton(CloseButtonPosition closebuttonposition, Runnable runnable)
    {
        runnable = new _cls2(runnable);
        if (closeButton == null)
        {
            closeButton = new CvCloseButton(getMediator().getContext(), closebuttonposition);
        } else
        {
            closeButton.setupPosition(closebuttonposition);
        }
        closeButton.setListener(runnable);
        containerView.addView(closeButton);
    }


/*
    static MRAIDView access$002(CvInlineAdWrapper cvinlineadwrapper, MRAIDView mraidview)
    {
        cvinlineadwrapper.mraidView = mraidview;
        return mraidview;
    }

*/


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
