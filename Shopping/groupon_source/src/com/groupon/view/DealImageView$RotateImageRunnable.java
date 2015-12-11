// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.os.Handler;
import android.support.v4.view.ViewPager;

// Referenced classes of package com.groupon.view:
//            DealImageView

private class <init>
    implements Runnable
{

    final DealImageView this$0;

    public void run()
    {
        if (DealImageView.access$800(DealImageView.this) < DealImageView.access$000(DealImageView.this))
        {
            if (DealImageView.access$1400(DealImageView.this).getLocalVisibleRect(DealImageView.access$1300(DealImageView.this)))
            {
                DealImageView.access$1400(DealImageView.this).setCurrentItem(DealImageView.access$804(DealImageView.this));
            }
            DealImageView.access$1600(DealImageView.this).postDelayed(this, DealImageView.access$1500());
            return;
        } else
        {
            DealImageView.access$1600(DealImageView.this).removeCallbacks(this);
            DealImageView.access$1702(DealImageView.this, false);
            return;
        }
    }

    private ()
    {
        this$0 = DealImageView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
