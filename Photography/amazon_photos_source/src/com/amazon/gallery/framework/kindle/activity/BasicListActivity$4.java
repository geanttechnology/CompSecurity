// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import com.amazon.gallery.framework.gallery.view.NoOpViewStateListener;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.ui.ActivityIndicatorCheckThread;
import com.amazon.gallery.framework.kindle.ui.NetworkIndicator;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            BasicListActivity

class init> extends NoOpViewStateListener
{

    final BasicListActivity this$0;

    public void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag)
    {
        if (viewdescriptor.getMediaProperty() == CommonMediaProperty.CAMERA)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        BasicListActivity.access$000(BasicListActivity.this).getNetworkIndicator().setIsLocalView(flag);
    }

    ad()
    {
        this$0 = BasicListActivity.this;
        super();
    }
}
