// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import com.amazon.gallery.framework.gallery.view.NoOpViewStateListener;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.ui.ActivityIndicatorCheckThread;
import com.amazon.gallery.framework.kindle.ui.NetworkIndicator;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            BaseFragment

class ner extends NoOpViewStateListener
{

    final BaseFragment this$0;

    public void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag)
    {
        if (viewdescriptor.getMediaProperty() == CommonMediaProperty.CAMERA)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mActivityIndicatorCheckThread.getNetworkIndicator().setIsLocalView(flag);
        getActivity().getWindow().getDecorView().sendAccessibilityEvent(32);
    }

    kThread()
    {
        this$0 = BaseFragment.this;
        super();
    }
}
