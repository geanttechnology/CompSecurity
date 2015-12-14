// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.util.AttributeSet;
import com.huewu.pla.lib.MultiColumnListView;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.d;

public class CLMultiColumnListView extends MultiColumnListView
    implements d
{

    private d ah;

    public CLMultiColumnListView(Context context)
    {
        super(context);
        a(context, ((AttributeSet) (null)));
    }

    public CLMultiColumnListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context, attributeset);
    }

    public CLMultiColumnListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context, attributeset);
    }

    private void a(Context context, AttributeSet attributeset)
    {
        super.setOnScrollListener(this);
    }

    public void a(PLA_AbsListView pla_abslistview, int i)
    {
        if (ah != null)
        {
            ah.a(pla_abslistview, i);
        }
    }

    public void a(PLA_AbsListView pla_abslistview, int i, int j, int k)
    {
        if (ah != null)
        {
            ah.a(pla_abslistview, i, j, k);
        }
    }

    public void setOnScrollListener(d d1)
    {
        ah = d1;
    }
}
