// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPHeaderListView

public class a extends ListView
{

    final PDPHeaderListView a;

    public int computeVerticalScrollExtent()
    {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset()
    {
        return super.computeVerticalScrollOffset();
    }

    public int computeVerticalScrollRange()
    {
        return super.computeVerticalScrollRange();
    }

    public Y(PDPHeaderListView pdpheaderlistview, Context context, AttributeSet attributeset)
    {
        a = pdpheaderlistview;
        super(context, attributeset);
    }
}
