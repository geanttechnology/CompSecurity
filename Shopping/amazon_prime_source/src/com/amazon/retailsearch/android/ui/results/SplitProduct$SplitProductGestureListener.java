// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.view.MotionEvent;
import android.widget.ImageView;
import com.amazon.retailsearch.android.ui.results.views.ArrowView;
import com.amazon.retailsearch.interaction.UserInteractionListener;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            SplitProduct

private class <init> extends android.view.t.SplitProductGestureListener
{

    final SplitProduct this$0;

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        if (SplitProduct.access$300(SplitProduct.this) != null)
        {
            SplitProduct.access$300(SplitProduct.this).setImageDrawable(SplitProduct.access$500(SplitProduct.this).getArrow(SplitProduct.access$400(SplitProduct.this)));
        }
        userInteractionListener.addListener(new init>(SplitProduct.this, SplitProduct.access$100(SplitProduct.this)));
        return super.nSingleTapUp(motionevent);
    }

    private Y()
    {
        this$0 = SplitProduct.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
