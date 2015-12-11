// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.events.FilterDataChangedLocallyEvent;
import com.squareup.otto.Bus;

// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultFragment

class taObserver extends android.support.v7.widget.erver
{

    final RapiSearchResultFragment this$0;

    public void onChanged()
    {
        bus.post(new FilterDataChangedLocallyEvent());
    }

    ()
    {
        this$0 = RapiSearchResultFragment.this;
        super();
    }
}
