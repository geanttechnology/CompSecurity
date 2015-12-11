// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.v;
import com.target.mothership.model.cart.interfaces.InitiatedPayPal;
import com.target.mothership.model.cart.interfaces.a.q;
import com.target.mothership.model.d;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.y;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTInitiatedPayPal

public class af extends b
{

    private static final String TAG = com/target/mothership/model/cart/handler/af.getSimpleName();
    private aa mTransformer;

    public af(d d)
    {
        super(d);
        mTransformer = new aa() {

            private static final String APPEND_TOKEN = "&token=";
            final af this$0;

            public InitiatedPayPal a(y y1)
            {
                TGTInitiatedPayPal tgtinitiatedpaypal = new TGTInitiatedPayPal();
                tgtinitiatedpaypal.b(y1.c());
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append(y1.b());
                stringbuilder.append(y1.a());
                stringbuilder.append("&token=");
                stringbuilder.append(y1.c());
                tgtinitiatedpaypal.a(stringbuilder.toString());
                return tgtinitiatedpaypal;
            }

            public volatile Object a(Object obj)
            {
                return a((y)obj);
            }

            
            {
                this$0 = af.this;
                super();
            }
        };
    }

    protected InitiatedPayPal a(y y1)
    {
        return (InitiatedPayPal)mTransformer.a(y1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((y)obj);
    }

    protected q b(x x)
    {
        return (new v()).a(x);
    }

}
