// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.ui.fragments:
//            PartyFragment

class this._cls0
    implements android.view.ener
{

    final PartyFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "party", "refresh_party_clicked", null);
        PartyFragment.access$000(PartyFragment.this, false);
    }

    ()
    {
        this$0 = PartyFragment.this;
        super();
    }
}
