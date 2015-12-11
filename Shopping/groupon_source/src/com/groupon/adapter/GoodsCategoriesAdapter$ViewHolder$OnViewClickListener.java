// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.view.View;
import com.groupon.adapter.listener.OnCategoryItemClickListener;

// Referenced classes of package com.groupon.adapter:
//            GoodsCategoriesAdapter

private class <init>
    implements android.view.stener
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
        if (listener != null)
        {
            listener.onItemClick(this._cls1.this.<init>, _mth1());
        }
    }

    private ()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
