// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import com.amazon.gallery.framework.gallery.view.NoOpViewStateListener;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;

// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            NavigationBar

class enabled extends NoOpViewStateListener
{

    boolean enabled;
    final NavigationBar this$0;

    public void onEnterFullScreen()
    {
        if (!enabled)
        {
            return;
        } else
        {
            enterFullScreen();
            return;
        }
    }

    public void onExitFullScreen()
    {
        if (!enabled)
        {
            return;
        } else
        {
            exitFullScreen();
            return;
        }
    }

    public void onFocusedGained(ViewDescriptor viewdescriptor)
    {
        if (!enabled)
        {
            return;
        } else
        {
            updateRefineSubtitleState(viewdescriptor);
            return;
        }
    }

    public void onRotation()
    {
        super.onRotation();
        executeOnRotation();
    }

    public void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag)
    {
        if (!enabled)
        {
            return;
        } else
        {
            viewStateChanged(viewdescriptor);
            return;
        }
    }

    r()
    {
        this$0 = NavigationBar.this;
        super();
        enabled = true;
    }
}
