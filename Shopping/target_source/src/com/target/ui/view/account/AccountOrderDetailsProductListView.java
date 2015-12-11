// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;
import com.target.ui.util.al;
import java.util.List;

// Referenced classes of package com.target.ui.view.account:
//            AccountOrderDetailsProductDetailsView

public class AccountOrderDetailsProductListView extends LinearLayout
{

    public AccountOrderDetailsProductListView(Context context)
    {
        super(context);
        a();
    }

    public AccountOrderDetailsProductListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public AccountOrderDetailsProductListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private AccountOrderDetailsProductDetailsView b()
    {
        return (AccountOrderDetailsProductDetailsView)((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300f6, this, false);
    }

    public void a()
    {
        setOrientation(1);
    }

    public void a(List list, AccountOrderDetailsProductDetailsView.a a1)
    {
        if (list.isEmpty())
        {
            al.c(this);
        } else
        {
            int i = 0;
            while (i < list.size()) 
            {
                AccountOrderDetailsProductDetailsView accountorderdetailsproductdetailsview = b();
                accountorderdetailsproductdetailsview.a((OrderDetailsProduct)list.get(i), a1);
                boolean flag;
                if (i != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                accountorderdetailsproductdetailsview.a(flag);
                addView(accountorderdetailsproductdetailsview);
                i++;
            }
        }
    }
}
