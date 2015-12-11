// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.sell.lists.SellingListActivity;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.kListener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        int i = view.getId();
        view = new SourceIdentification("HomePage", "sellingoverview", "activity");
        viewmodel = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
        viewmodel.putExtra("com.ebay.mobile.analytics.sid", view);
        if (i == 0x7f1002a6)
        {
            viewmodel.putExtra("listType", com.ebay.mobile.sell.lists.ity.ListType.SOLD);
            startActivity(viewmodel);
        } else
        {
            if (i == 0x7f1002a9)
            {
                viewmodel.putExtra("listType", com.ebay.mobile.sell.lists.ity.ListType.UNSOLD);
                startActivity(viewmodel);
                return;
            }
            if (i == 0x7f1002a5 && StartFragment.access$600(StartFragment.this) != null)
            {
                view = getActivity();
                if (view != null)
                {
                    (new TrackingData("StartSelling", TrackingType.EVENT)).send(view);
                }
                view = (artChannelHost)StartFragment.access$600(StartFragment.this).get();
                if (view != null)
                {
                    view.navigateToChannel(ChannelEnum.SELL, true, true);
                    return;
                }
            }
        }
    }

    ()
    {
        this$0 = StartFragment.this;
        super();
    }
}
