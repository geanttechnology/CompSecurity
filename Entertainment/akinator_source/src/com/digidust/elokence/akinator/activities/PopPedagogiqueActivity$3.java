// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.widget.Button;
import android.widget.TextView;
import com.digidust.elokence.akinator.billing.AkInappManager;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            PopPedagogiqueActivity

class this._cls0
    implements Runnable
{

    final PopPedagogiqueActivity this$0;

    public void run()
    {
        PopPedagogiqueActivity.access$500(PopPedagogiqueActivity.this).setText(AkInappManager.getInstance().getNomInappGeniz(0));
        PopPedagogiqueActivity.access$600(PopPedagogiqueActivity.this).setText(AkInappManager.getInstance().getNomInappGeniz(1));
        PopPedagogiqueActivity.access$700(PopPedagogiqueActivity.this).setText(AkInappManager.getInstance().getNomInappGeniz(2));
        PopPedagogiqueActivity.access$800(PopPedagogiqueActivity.this).setText(AkInappManager.getInstance().getNomInappGeniz(3));
        PopPedagogiqueActivity.access$900(PopPedagogiqueActivity.this).setText(AkInappManager.getInstance().getNomInappGeniz(4));
        PopPedagogiqueActivity.access$000(PopPedagogiqueActivity.this).setText(AkInappManager.getInstance().getPriceInappGeniz(0));
        PopPedagogiqueActivity.access$100(PopPedagogiqueActivity.this).setText(AkInappManager.getInstance().getPriceInappGeniz(1));
        PopPedagogiqueActivity.access$200(PopPedagogiqueActivity.this).setText(AkInappManager.getInstance().getPriceInappGeniz(2));
        PopPedagogiqueActivity.access$300(PopPedagogiqueActivity.this).setText(AkInappManager.getInstance().getPriceInappGeniz(3));
        PopPedagogiqueActivity.access$400(PopPedagogiqueActivity.this).setText(AkInappManager.getInstance().getPriceInappGeniz(4));
    }

    ()
    {
        this$0 = PopPedagogiqueActivity.this;
        super();
    }
}
