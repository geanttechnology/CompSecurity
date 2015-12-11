// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.sellsmartbox.SmartboxActivity;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.Listener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        view = new Intent(getActivity(), com/ebay/mobile/sellsmartbox/SmartboxActivity);
        view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "listanitem", "sell"));
        getActivity().startActivity(view);
    }

    Identification()
    {
        this$0 = StartFragment.this;
        super();
    }
}
