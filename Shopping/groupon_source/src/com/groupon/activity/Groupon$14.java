// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.Function0;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.activity:
//            Groupon

class this._cls0
    implements Function0
{

    final Groupon this$0;

    public void execute()
    {
        useGrouponView.setText(Groupon.access$900(Groupon.this));
        stopRefreshingViewVoucherButton();
    }

    ()
    {
        this$0 = Groupon.this;
        super();
    }
}
