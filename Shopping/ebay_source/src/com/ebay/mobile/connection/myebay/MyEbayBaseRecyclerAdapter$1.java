// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;


// Referenced classes of package com.ebay.mobile.connection.myebay:
//            MyEbayBaseRecyclerAdapter

class this._cls0
    implements com.ebay.mobile.common.ChangeListener
{

    final MyEbayBaseRecyclerAdapter this$0;

    public void onSelectionModeChanged(boolean flag)
    {
        for (int i = 0; i < getItemCount(); i++)
        {
            notifyItemChanged(i);
        }

    }

    ner()
    {
        this$0 = MyEbayBaseRecyclerAdapter.this;
        super();
    }
}
