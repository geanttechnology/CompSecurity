// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.graphics.Bitmap;
import com.amazon.android.webkit.AmazonIconListener;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebIconDatabase

class val.amazonIconlistener
    implements android.webkit.ner
{

    final AndroidWebIconDatabase this$0;
    final AmazonIconListener val$amazonIconlistener;

    public void onReceivedIcon(String s, Bitmap bitmap)
    {
        val$amazonIconlistener.onReceivedIcon(s, bitmap);
    }

    ()
    {
        this$0 = final_androidwebicondatabase;
        val$amazonIconlistener = AmazonIconListener.this;
        super();
    }
}
