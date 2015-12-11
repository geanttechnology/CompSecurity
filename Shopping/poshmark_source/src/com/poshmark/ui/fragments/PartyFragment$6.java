// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.widget.LinearLayout;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.utils.view_holders.PartyHeaderViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            PartyFragment

class this._cls0
    implements PMApiResponseHandler
{

    final PartyFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded())
        {
            PartyFragment.access$200(PartyFragment.this, pmapiresponse, false);
            hideFilterButtonsForSingleFacet();
            PartyFragment.access$300(PartyFragment.this).filterWidgetLayout.setVisibility(0);
        }
    }

    rViewHolder()
    {
        this$0 = PartyFragment.this;
        super();
    }
}
