// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;


// Referenced classes of package com.amazon.mShop.gno:
//            GNOItemAdapter, GNODrawerItemAppstoreHeader, GNODrawerItemHideable

class this._cls0
    implements Runnable
{

    final GNOItemAdapter this$0;

    public void run()
    {
        if ((GNODrawerItemAppstoreHeader)getItem("mshop:appstore") != null)
        {
            GNODrawerItemHideable gnodraweritemhideable = (GNODrawerItemHideable)getItem("mshop:appstore/coins");
            if (gnodraweritemhideable != null)
            {
                gnodraweritemhideable.setIsHiddenCallable(createAppstoreCoinTabCallable());
            }
            GNOItemAdapter.access$200(GNOItemAdapter.this);
            notifyDataSetChanged();
        }
    }

    able()
    {
        this$0 = GNOItemAdapter.this;
        super();
    }
}
