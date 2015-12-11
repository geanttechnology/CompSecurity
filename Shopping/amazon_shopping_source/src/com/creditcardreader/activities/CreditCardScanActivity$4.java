// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.activities;

import com.creditcardreader.camera.CreditCardCameraPreview;
import java.util.List;

// Referenced classes of package com.creditcardreader.activities:
//            CreditCardScanActivity

class val.edges
    implements Runnable
{

    final CreditCardScanActivity this$0;
    final List val$edges;

    public void run()
    {
        CreditCardScanActivity.access$200(CreditCardScanActivity.this).setEdges(val$edges);
    }

    ()
    {
        this$0 = final_creditcardscanactivity;
        val$edges = List.this;
        super();
    }
}
