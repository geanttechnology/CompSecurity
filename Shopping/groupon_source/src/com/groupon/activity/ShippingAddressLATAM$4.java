// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.network.HttpResponseException;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressLATAM

class this._cls0
    implements ReturningFunction1
{

    final ShippingAddressLATAM this$0;

    public Boolean execute(Exception exception)
        throws RuntimeException
    {
        if ((exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 404)
        {
            Toast.makeText(getApplicationContext(), getString(0x7f080181), 1).show();
            return Boolean.valueOf(false);
        } else
        {
            ShippingAddressLATAM.access$200(ShippingAddressLATAM.this).setVisibility(0);
            ShippingAddressLATAM.access$400(ShippingAddressLATAM.this).setVisibility(8);
            ShippingAddressLATAM.access$300(ShippingAddressLATAM.this).setVisibility(8);
            return Boolean.valueOf(true);
        }
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    ()
    {
        this$0 = ShippingAddressLATAM.this;
        super();
    }
}
