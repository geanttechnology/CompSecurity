// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Intent;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity

class val.barcodeFormat
    implements Runnable
{

    final ViewItActivity this$0;
    final String val$barcode;
    final String val$barcodeFormat;

    public void run()
    {
        Intent intent = new Intent();
        if (!Util.isEmpty(val$barcode))
        {
            intent.putExtra("BARCODE_STRING", val$barcode);
            intent.putExtra("BARCODE_FORMAT", val$barcodeFormat);
            setResult(-1, intent);
        } else
        {
            setResult(-1, intent);
        }
        finish();
        UIUtils.vibrate(ViewItActivity.this, 100L);
    }

    ()
    {
        this$0 = final_viewitactivity;
        val$barcode = s;
        val$barcodeFormat = String.this;
        super();
    }
}
