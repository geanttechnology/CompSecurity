// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.ui.util.al;
import com.target.ui.view.a;
import java.util.List;

// Referenced classes of package com.target.ui.view.product:
//            PlpCardView

public class PlpCardViewDealsOnly extends PlpCardView
{
    static class Views extends a
    {

        View dealsTag;

        public Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public PlpCardViewDealsOnly(Context context)
    {
        super(context);
        a();
    }

    public PlpCardViewDealsOnly(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public PlpCardViewDealsOnly(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        mViews = new Views(this);
    }

    protected int getLayoutResource()
    {
        return 0x7f0301a3;
    }

    public void setItemData(ProductDetails productdetails)
    {
        super.setItemData(productdetails);
        boolean flag;
        if (productdetails.x().size() > 0 || productdetails.n().size() > 0 || productdetails.c().g().size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        al.a(mViews.dealsTag, flag);
    }
}
