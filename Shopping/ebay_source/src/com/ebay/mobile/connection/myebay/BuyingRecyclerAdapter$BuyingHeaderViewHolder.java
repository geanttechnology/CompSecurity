// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.ebay.common.model.cart.Incentive;
import com.ebay.mobile.common.EbayCurrencyUtil;
import java.text.DateFormat;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            BuyingRecyclerAdapter

public class topCardBackground extends com.ebay.mobile.widget.r
{

    private final View bucksContainer;
    private final View headerContainer;
    private final View marginView;
    final BuyingRecyclerAdapter this$0;
    private final Drawable topCardBackground;

    protected void onBindView(int i, CharSequence charsequence)
    {
        if (getSectionFromItemPosition(i).sition() == 0)
        {
            textView.setVisibility(8);
            if (bucksContainer != null)
            {
                bucksContainer.setVisibility(8);
            }
            if (marginView != null)
            {
                if (getListCount() == getListIndexFromItemPosition(i) + 1)
                {
                    marginView.setVisibility(0);
                } else
                {
                    marginView.setVisibility(8);
                }
            }
            if (headerContainer != null)
            {
                headerContainer.setVisibility(8);
            }
        } else
        if (marginView == null && bucksContainer == null)
        {
            textView.setVisibility(8);
            if (headerContainer != null)
            {
                headerContainer.setVisibility(8);
                return;
            }
        } else
        {
            if (marginView != null)
            {
                marginView.setVisibility(0);
            }
            headerContainer.setVisibility(0);
            textView.setVisibility(0);
            headerContainer.setBackground(topCardBackground);
            if (bucksContainer != null)
            {
                if (bucks != null && (bucksPosition == -1 || bucksPosition == i))
                {
                    bucksPosition = i;
                    setupBucksView();
                } else
                {
                    bucksContainer.setVisibility(8);
                }
            }
            textView.setText(charsequence);
            return;
        }
    }

    protected void setupBucksView()
    {
        Object obj = (TextView)bucksContainer.findViewById(0x7f1000ea);
        TextView textview = (TextView)bucksContainer.findViewById(0x7f1000eb);
        String s = null;
        java.util.Date date = bucks.expiration;
        if (date != null)
        {
            s = DateFormat.getDateTimeInstance(2, 3).format(date);
        }
        if (obj != null && textview != null)
        {
            ((TextView) (obj)).setText(EbayCurrencyUtil.formatDisplay(bucks.discountAmount, 0));
            obj = s;
            if (s == null)
            {
                obj = "";
            }
            textview.setText(((CharSequence) (obj)));
            bucksContainer.setVisibility(0);
            return;
        } else
        {
            bucksContainer.setVisibility(8);
            return;
        }
    }

    public (View view)
    {
        this$0 = BuyingRecyclerAdapter.this;
        super(view);
        bucksContainer = view.findViewById(0x7f1003ae);
        marginView = view.findViewById(0x7f1003af);
        headerContainer = view.findViewById(0x7f1003b0);
        topCardBackground = getContext().getResources().getDrawable(0x7f020269);
    }
}
