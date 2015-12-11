// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.bestbuy.android.api.lib.models.dnm.DNMFacetFilter;
import fe;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMPLPNarrowFacetFragment

class b
    implements android.view.NarrowFacetFragment._cls4
{

    final String a;
    final DNMFacetFilter b;
    final DNMPLPNarrowFacetFragment c;

    public void onClick(View view)
    {
        DNMPLPNarrowFacetFragment.a(c, a, b);
        DNMPLPNarrowFacetFragment.g(c).setBackground(new ColorDrawable(0xff0067ab));
        DNMPLPNarrowFacetFragment.g(c).setOnClickListener(c);
        DNMPLPNarrowFacetFragment.h(c).notifyDataSetChanged();
    }

    (DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment, String s, DNMFacetFilter dnmfacetfilter)
    {
        c = dnmplpnarrowfacetfragment;
        a = s;
        b = dnmfacetfilter;
        super();
    }
}
