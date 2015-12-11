// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.events.ResetFilterSheetEvent;
import com.squareup.otto.Bus;

// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultFragment

class this._cls0
    implements android.view.gment._cls3
{

    final RapiSearchResultFragment this$0;

    public void onClick(View view)
    {
        bus.post(new ResetFilterSheetEvent());
    }

    ()
    {
        this$0 = RapiSearchResultFragment.this;
        super();
    }
}
