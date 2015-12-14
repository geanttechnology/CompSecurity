// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package in.srain.cube.views;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package in.srain.cube.views:
//            GridViewWithHeaderAndFooter

private class <init>
    implements android.widget.dler, android.widget.dler
{

    final GridViewWithHeaderAndFooter this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (GridViewWithHeaderAndFooter.access$200(GridViewWithHeaderAndFooter.this) != null)
        {
            i -= getHeaderViewCount() * GridViewWithHeaderAndFooter.access$300(GridViewWithHeaderAndFooter.this);
            if (i >= 0)
            {
                GridViewWithHeaderAndFooter.access$200(GridViewWithHeaderAndFooter.this)._mth0(adapterview, view, i, l);
            }
        }
    }

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        if (GridViewWithHeaderAndFooter.access$400(GridViewWithHeaderAndFooter.this) != null)
        {
            i -= getHeaderViewCount() * GridViewWithHeaderAndFooter.access$300(GridViewWithHeaderAndFooter.this);
            if (i >= 0)
            {
                GridViewWithHeaderAndFooter.access$400(GridViewWithHeaderAndFooter.this).gClick(adapterview, view, i, l);
            }
        }
        return true;
    }

    private ()
    {
        this$0 = GridViewWithHeaderAndFooter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
