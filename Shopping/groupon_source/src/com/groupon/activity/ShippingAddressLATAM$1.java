// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.widget.ArrayAdapter;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressLATAM

class this._cls0 extends ArrayAdapter
{

    final ShippingAddressLATAM this$0;

    public long getItemId(int i)
    {
        return (long)(i + 1);
    }

    (Context context, int i, String as[])
    {
        this$0 = ShippingAddressLATAM.this;
        super(context, i, as);
    }
}
