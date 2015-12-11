// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;


// Referenced classes of package com.ebay.mobile.myebay:
//            ReminderItemsActivity

class this._cls0
    implements com.ebay.common.vity._cls1
{

    final ReminderItemsActivity this$0;

    public void OnTimer()
    {
        android.widget.ListAdapter listadapter = getListAdapter();
        if (listadapter != null)
        {
            ((tificationListAdapter)listadapter).refresh(getListView());
        }
    }

    tificationListAdapter()
    {
        this$0 = ReminderItemsActivity.this;
        super();
    }
}
