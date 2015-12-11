// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.view.View;
import com.poshmark.utils.BundleItemRemoveClickListener;

// Referenced classes of package com.poshmark.data_model.adapters:
//            BundleListAdapter

class this._cls0
    implements android.view.
{

    final BundleListAdapter this$0;

    public void onClick(View view)
    {
        view = (Integer)view.getTag();
        if (removeItemListener != null)
        {
            removeItemListener.removeItemFromBundle(view.intValue());
        }
    }

    ()
    {
        this$0 = BundleListAdapter.this;
        super();
    }
}
