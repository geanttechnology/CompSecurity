// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.callbacks.DefaultOnExposedOptionsEventListener;
import com.groupon.db.models.Option;
import com.groupon.mvc.controller.BottomBarController;
import java.util.Map;

// Referenced classes of package com.groupon.activity:
//            DealDetails

private class <init> extends DefaultOnExposedOptionsEventListener
{

    final DealDetails this$0;

    public void onOptionSelectionChange(String s)
    {
        DealDetails.access$1702(DealDetails.this, s);
        s = DealDetails.access$1800(DealDetails.this).remoteId;
        DealDetails.access$2002(DealDetails.this, new String[] {
            DealDetails.access$1700(DealDetails.this), s
        });
        DealDetails.access$1802(DealDetails.this, (Option)DealDetails.access$1500(DealDetails.this).get(DealDetails.access$1700(DealDetails.this)));
        DealDetails.access$3000(DealDetails.this).setDealAndOption(DealDetails.access$1400(DealDetails.this), DealDetails.access$1800(DealDetails.this));
        DealDetails.access$4900(DealDetails.this);
        DealDetails.access$5000(DealDetails.this);
        DealDetails.access$5100(DealDetails.this);
    }

    private ()
    {
        this$0 = DealDetails.this;
        super();
    }

    t>(t> t>)
    {
        this();
    }
}
