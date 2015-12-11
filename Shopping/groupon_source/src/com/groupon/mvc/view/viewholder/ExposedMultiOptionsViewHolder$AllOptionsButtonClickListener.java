// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import com.groupon.callbacks.OnExposedOptionsEventListener;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            ExposedMultiOptionsViewHolder

private class <init>
    implements android.view.uttonClickListener
{

    final ExposedMultiOptionsViewHolder this$0;

    public void onClick(View view)
    {
        if (callback != null)
        {
            ((OnExposedOptionsEventListener)callback).onAllOptionsButtonClick(view);
        }
    }

    private a()
    {
        this$0 = ExposedMultiOptionsViewHolder.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
