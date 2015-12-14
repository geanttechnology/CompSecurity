// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.view.View;

// Referenced classes of package com.mopub.mobileads:
//            AdViewController, MoPubView

class val.view
    implements Runnable
{

    final AdViewController this$0;
    final View val$view;

    public void run()
    {
        MoPubView mopubview = getMoPubView();
        if (mopubview == null)
        {
            return;
        } else
        {
            mopubview.removeAllViews();
            mopubview.addView(val$view, AdViewController.access$100(AdViewController.this, val$view));
            return;
        }
    }

    ()
    {
        this$0 = final_adviewcontroller;
        val$view = View.this;
        super();
    }
}
