// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoViewController, VastVideoConfig

class this._cls0
    implements android.view.ller._cls5
{

    final VastVideoViewController this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i;
        if (VastVideoViewController.access$200(VastVideoViewController.this))
        {
            i = VastVideoViewController.access$300(VastVideoViewController.this);
        } else
        {
            i = getCurrentPosition();
        }
        if (motionevent.getAction() == 1)
        {
            VastVideoViewController.access$102(VastVideoViewController.this, true);
            VastVideoViewController.access$400(VastVideoViewController.this).handleClose(getContext(), i);
            getBaseVideoViewControllerListener().onFinish();
        }
        return true;
    }

    seVideoViewControllerListener()
    {
        this$0 = VastVideoViewController.this;
        super();
    }
}
