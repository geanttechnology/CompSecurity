// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;


// Referenced classes of package com.ebay.mobile.photomanager:
//            PhotoManagerView

class this._cls0 extends Thread
{

    final PhotoManagerView this$0;

    public void run()
    {
        try
        {
            Thread.sleep(250L);
        }
        catch (Exception exception) { }
        PhotoManagerView.access$002(PhotoManagerView.this, true);
    }

    ()
    {
        this$0 = PhotoManagerView.this;
        super();
    }
}
