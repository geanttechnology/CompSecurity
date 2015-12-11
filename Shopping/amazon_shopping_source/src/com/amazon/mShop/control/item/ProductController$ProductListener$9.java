// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController, Variations

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (!cess._mth1300(this._cls1.this))
        {
            ProductController.access$1900(_fld0, true);
            ProductController.access$700(_fld0);
            if (!Util.isEmpty(cess._mth2000(this._cls1.this)) && !Util.isEmpty(cess._mth2100(this._cls1.this)))
            {
                ProductController.access$2202(_fld0, new Variations(_fld0, cess._mth2000(this._cls1.this), cess._mth2100(this._cls1.this), cess._mth2300(this._cls1.this)));
                ProductController.access$1102(_fld0, ProductController.access$2400(_fld0, cess._mth2000(this._cls1.this), cess._mth2100(this._cls1.this), cess._mth2300(this._cls1.this)));
            }
        }
        if (getDealId() == null)
        {
            if (ProductController.access$2500(_fld0) != null)
            {
                ProductController.access$2500(_fld0).l();
            }
            setDeal(null);
        }
        ProductController.access$2602(_fld0, null);
        ProductController.access$800(_fld0);
        ProductController.access$900(_fld0);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
