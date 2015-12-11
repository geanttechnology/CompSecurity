// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.shipping.AddressEu;
import com.groupon.models.shipping.Location;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressLATAM

class this._cls0 extends Http
{

    final ShippingAddressLATAM this$0;

    protected void onSuccess(AddressEu addresseu)
        throws Exception
    {
        super.onSuccess(addresseu);
        setResultAndFinish(-1, addresseu.location.id);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((AddressEu)obj);
    }

    transient (Context context, Class class1, String s, Object aobj[])
    {
        this$0 = ShippingAddressLATAM.this;
        super(context, class1, s, aobj);
    }
}
