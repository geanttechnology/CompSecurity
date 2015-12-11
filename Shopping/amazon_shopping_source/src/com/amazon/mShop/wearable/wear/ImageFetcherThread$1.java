// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;


// Referenced classes of package com.amazon.mShop.wearable.wear:
//            ImageFetcherThread

class val.imageUrl
    implements Runnable
{

    final ImageFetcherThread this$0;
    final String val$imageUrl;
    final String val$node;

    public void run()
    {
        ImageFetcherThread.access$000(ImageFetcherThread.this, val$node, val$imageUrl);
    }

    _cls9()
    {
        this$0 = final_imagefetcherthread;
        val$node = s;
        val$imageUrl = String.this;
        super();
    }
}
