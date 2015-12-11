// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoViewController, VastVideoConfig

class val.activity
    implements android.view.ller._cls1
{

    final VastVideoViewController this$0;
    final Activity val$activity;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 && VastVideoViewController.access$000(VastVideoViewController.this))
        {
            VastVideoViewController.access$102(VastVideoViewController.this, true);
            broadcastAction("com.mopub.action.interstitial.click");
            view = VastVideoViewController.access$400(VastVideoViewController.this);
            motionevent = val$activity;
            int i;
            if (VastVideoViewController.access$200(VastVideoViewController.this))
            {
                i = VastVideoViewController.access$300(VastVideoViewController.this);
            } else
            {
                i = getCurrentPosition();
            }
            view.handleClick(motionevent, i, 1);
        }
        return true;
    }

    ()
    {
        this$0 = final_vastvideoviewcontroller;
        val$activity = Activity.this;
        super();
    }
}
