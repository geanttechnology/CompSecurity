// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.search.image;

import java.util.List;

// Referenced classes of package com.amazon.mShop.control.search.image:
//            ImageSearchController, ImageSearchSubscriber

class val.value
    implements Runnable
{

    final ImageSearchController this$0;
    final List val$value;

    public void run()
    {
        ImageSearchController.access$000(ImageSearchController.this);
        int i = 0;
        for (int j = val$value.size(); i < j; i++)
        {
            ImageSearchController.access$100(ImageSearchController.this).add(val$value.get(i));
        }

        ImageSearchController.access$200(ImageSearchController.this).onCompleted();
    }

    ()
    {
        this$0 = final_imagesearchcontroller;
        val$value = List.this;
        super();
    }
}
