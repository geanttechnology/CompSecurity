// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.bestbuy.android.api.lib.models.dnm.DNMSortOption;
import com.bestbuy.android.bbyobjects.BBYTextView;
import fj;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMPLPNarrowFacetFragment

class a
    implements android.widget.ner
{

    final DNMPLPNarrowFacetFragment a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        DNMPLPNarrowFacetFragment.a(a, ((DNMSortOption)DNMPLPNarrowFacetFragment.a(a).get(i)).getValue());
        DNMPLPNarrowFacetFragment.b(a).setText(((DNMSortOption)DNMPLPNarrowFacetFragment.a(a).get(i)).getDisplayName());
        DNMPLPNarrowFacetFragment.c(a).findViewById(0x7f0c0313).setVisibility(8);
        DNMPLPNarrowFacetFragment.c(a).findViewById(0x7f0c0311).setVisibility(0);
        DNMPLPNarrowFacetFragment.d(a).setBackgroundResource(0x7f020021);
        DNMPLPNarrowFacetFragment.f(a).a(DNMPLPNarrowFacetFragment.e(a).getDisplayName());
        DNMPLPNarrowFacetFragment.g(a).setBackground(new ColorDrawable(0xff0067ab));
        DNMPLPNarrowFacetFragment.g(a).setClickable(true);
        DNMPLPNarrowFacetFragment.g(a).setOnClickListener(a);
    }

    (DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        a = dnmplpnarrowfacetfragment;
        super();
    }
}
