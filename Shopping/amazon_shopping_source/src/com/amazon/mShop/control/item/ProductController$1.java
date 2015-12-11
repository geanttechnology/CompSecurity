// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.mShop.control.ObjectSubscriber;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController

class this._cls0
    implements ObjectSubscriber
{

    final ProductController this$0;

    public void onAvailableCountReceived(int i)
    {
        ProductController.access$300(ProductController.this);
    }

    public void onCancelled()
    {
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        ProductController.access$1000(ProductController.this, exception, servicecall);
    }

    public void onObjectReceived(Object obj, int i)
    {
label0:
        {
            if (ProductController.access$400(ProductController.this).getCurrentIndex() == i)
            {
                if (!(obj instanceof byte[]))
                {
                    break label0;
                }
                ProductController.access$500(ProductController.this);
            }
            return;
        }
        ProductController.access$600(ProductController.this, obj);
        ProductController.access$700(ProductController.this);
    }

    public void onObjectsReceived()
    {
    }

    public void onPageComplete()
    {
        ProductController.access$800(ProductController.this);
        ProductController.access$900(ProductController.this);
    }

    ()
    {
        this$0 = ProductController.this;
        super();
    }
}
