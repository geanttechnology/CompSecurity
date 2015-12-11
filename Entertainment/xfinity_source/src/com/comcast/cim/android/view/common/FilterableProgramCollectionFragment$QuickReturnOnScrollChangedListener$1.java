// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.comcast.cim.android.view.common:
//            FilterableProgramCollectionFragment

class val.quickReturnView
    implements android.view.crollChangedListener._cls1
{

    final val.quickReturnView this$1;
    final View val$quickReturnView;
    final FilterableProgramCollectionFragment val$this$0;

    public void onGlobalLayout()
    {
label0:
        {
            val$quickReturnView.getGlobalVisibleRect(cess._mth000(this._cls1.this));
            cess._mth102(this._cls1.this, cess._mth000(this._cls1.this).bottom - cess._mth000(this._cls1.this).top);
            if (cess._mth100(this._cls1.this) > 0)
            {
                if (android.os.nScrollChangedListener < 16)
                {
                    break label0;
                }
                val$quickReturnView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            return;
        }
        val$quickReturnView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    ()
    {
        this$1 = final_;
        val$this$0 = filterableprogramcollectionfragment;
        val$quickReturnView = View.this;
        super();
    }
}
