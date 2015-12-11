// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.content.Context;
import com.ebay.mobile.search.SavedSearchList;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.common:
//            UserCache

class val.list
    implements Runnable
{

    final art this$0;
    final SavedSearchList val$list;

    public void run()
    {
        cess._mth1800(this._cls0.this).earch(val$list);
        if (!cess._mth1900(this._cls0.this))
        {
            (new nit>(cess._mth1800(this._cls0.this), (Context)cess._mth2000(this._cls0.this).get(), cess._mth2100(this._cls0.this), cess._mth2200(this._cls0.this), true, null)).art();
        }
    }

    ()
    {
        this$0 = final_;
        val$list = SavedSearchList.this;
        super();
    }
}
