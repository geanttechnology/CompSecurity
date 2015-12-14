// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.view.LayoutInflater;
import android.view.View;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.services.IAviaryController;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractOptionPanel

abstract class AbstractContentPanel extends AbstractOptionPanel
    implements AbstractPanel.ContentPanel
{

    protected AbstractPanel.OnContentReadyListener mContentReadyListener;
    protected View mDrawingPanel;
    protected ImageViewTouch mImageView;

    public AbstractContentPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry);
    }

    protected void contentReady()
    {
        if (mContentReadyListener != null && isActive())
        {
            mContentReadyListener.onReady(this);
        }
    }

    protected abstract View generateContentView(LayoutInflater layoutinflater);

    public final View getContentView()
    {
        return mDrawingPanel;
    }

    public final View getContentView(LayoutInflater layoutinflater)
    {
        mDrawingPanel = generateContentView(layoutinflater);
        return mDrawingPanel;
    }

    public boolean isRendering()
    {
        return true;
    }

    protected void onDispose()
    {
        mContentReadyListener = null;
        super.onDispose();
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        getContentView().setEnabled(flag);
    }

    public final void setOnReadyListener(AbstractPanel.OnContentReadyListener oncontentreadylistener)
    {
        mContentReadyListener = oncontentreadylistener;
    }
}
