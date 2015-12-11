// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.os.SystemClock;
import android.view.View;
import com.groupon.db.models.Option;

// Referenced classes of package com.groupon.util:
//            TwoTraitOptionAdapter

class val.option
    implements android.view.r._cls1
{

    final this._cls1 this$1;
    final Option val$option;

    public void onClick(View view)
    {
        if (TwoTraitOptionAdapter.access$100(_fld0) != null)
        {
            long l = SystemClock.elapsedRealtime();
            if (l - cess._mth200(this._cls1.this) > 1500L)
            {
                TwoTraitOptionAdapter.access$100(_fld0).nOptionClick(val$option, view, cess._mth300(this._cls1.this));
            }
            cess._mth202(this._cls1.this, l);
        }
    }

    A()
    {
        this$1 = final_a;
        val$option = Option.this;
        super();
    }
}
