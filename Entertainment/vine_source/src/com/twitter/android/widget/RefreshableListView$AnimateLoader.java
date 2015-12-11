// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.android.widget;

import android.os.Handler;
import android.widget.ImageView;

// Referenced classes of package com.twitter.android.widget:
//            RefreshableListView

class mView
    implements Runnable
{

    int mRotate;
    private ImageView mView;
    final RefreshableListView this$0;

    public void cancel()
    {
        Handler handler = getHandler();
        if (handler != null)
        {
            handler.removeCallbacks(this);
        }
    }

    public void run()
    {
        mRotate = mRotate + 500;
        if (mRotate > 10000)
        {
            mRotate = 0;
        }
        mView.setImageLevel(mRotate);
        postDelayed(this, 32L);
    }

    public (ImageView imageview)
    {
        this$0 = RefreshableListView.this;
        super();
        mView = imageview;
    }
}
