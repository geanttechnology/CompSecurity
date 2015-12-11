// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.MotionEvent;
import android.view.View;
import com.groupon.callbacks.OnDealImageEventListener;

// Referenced classes of package com.groupon.view:
//            DealImageView

private class <init>
    implements android.view.ner
{

    final DealImageView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (DealImageView.access$1700(DealImageView.this))
        {
            DealImageView.access$1802(DealImageView.this, true);
            doStopImageRotation();
        }
        if (DealImageView.access$900(DealImageView.this) != null)
        {
            DealImageView.access$900(DealImageView.this).onUserInteraction();
        }
        return false;
    }

    private A()
    {
        this$0 = DealImageView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
