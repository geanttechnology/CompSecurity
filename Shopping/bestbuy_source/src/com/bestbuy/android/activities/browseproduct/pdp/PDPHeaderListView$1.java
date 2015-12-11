// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.view.View;
import android.widget.AdapterView;
import by;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPHeaderListView

public class a
    implements android.widget.ickListener
{

    final PDPHeaderListView a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (PDPHeaderListView.a(a) != null)
        {
            PDPHeaderListView.a(a).onItemClick(adapterview, view, i, l);
        }
    }

    (PDPHeaderListView pdpheaderlistview)
    {
        a = pdpheaderlistview;
        super();
    }
}
