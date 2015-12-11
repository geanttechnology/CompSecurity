// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.mcoupons;

import android.view.MenuItem;

// Referenced classes of package com.target.ui.view.mcoupons:
//            CouponsOverflowView

class this._cls0
    implements android.support.v7.widget._cls1
{

    final CouponsOverflowView this$0;

    public boolean a(MenuItem menuitem)
    {
        if (CouponsOverflowView.a(CouponsOverflowView.this) == null)
        {
            return false;
        }
        switch (menuitem.getItemId())
        {
        default:
            return false;

        case 2131756547: 
            CouponsOverflowView.a(CouponsOverflowView.this).a();
            break;
        }
        return false;
    }

    ()
    {
        this$0 = CouponsOverflowView.this;
        super();
    }
}
