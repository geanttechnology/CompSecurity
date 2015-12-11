// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.Upc;
import com.target.mothership.util.o;
import com.target.ui.util.al;
import com.target.ui.view.a;

public class ProductAdditionalInfoView extends LinearLayout
{
    static class Views extends a
    {

        TextView dpci;
        TextView tcin;
        TextView title;
        TextView upc;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public ProductAdditionalInfoView(Context context)
    {
        super(context);
        a();
    }

    public ProductAdditionalInfoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ProductAdditionalInfoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f030190, this);
        mViews = new Views(this);
    }

    public void a(Tcin tcin, Dpci dpci, Upc upc)
    {
        if (o.g(tcin.b()))
        {
            tcin = String.format(getResources().getString(0x7f090418), new Object[] {
                tcin.b()
            });
            mViews.tcin.setText(tcin);
            al.b(mViews.tcin);
        } else
        {
            al.c(mViews.tcin);
        }
        if (upc != null)
        {
            tcin = String.format(getResources().getString(0x7f09041a), new Object[] {
                upc.b()
            });
            mViews.upc.setText(tcin);
            al.b(mViews.upc);
        } else
        {
            al.c(mViews.upc);
        }
        if (dpci != null)
        {
            tcin = String.format(getResources().getString(0x7f090417), new Object[] {
                dpci.b()
            });
            mViews.dpci.setText(tcin);
            al.b(mViews.dpci);
            return;
        } else
        {
            al.c(mViews.dpci);
            return;
        }
    }
}
