// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.Toast;
import com.groupon.network.HttpResponseException;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressEu

class this._cls0
    implements Function1
{

    final ShippingAddressEu this$0;

    public void execute(Exception exception)
    {
        if (exception instanceof HttpResponseException)
        {
            Toast.makeText(getApplicationContext(), getString(0x7f0801a3), 1).show();
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Exception)obj);
    }

    ()
    {
        this$0 = ShippingAddressEu.this;
        super();
    }
}
