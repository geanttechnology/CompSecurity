// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.graphics.Bitmap;
import android.webkit.WebView;
import java.io.File;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TWebBrowActivity

class val.file
    implements Runnable
{

    final TWebBrowActivity this$0;
    final Bitmap val$bitmap;
    final File val$file;

    public void run()
    {
        if (val$bitmap != null && !val$bitmap.isRecycled())
        {
            val$bitmap.recycle();
        }
        if (val$file != null)
        {
            TWebBrowActivity.access$300(TWebBrowActivity.this).loadUrl(String.format("javascript:%s(%b,'%s')", new Object[] {
                "showSaveTip", Boolean.valueOf(true), val$file.getAbsolutePath()
            }));
            return;
        } else
        {
            TWebBrowActivity.access$300(TWebBrowActivity.this).loadUrl(String.format("javascr+ipt:%s(%b,'%s')", new Object[] {
                "showSaveTip", Boolean.valueOf(false), "error"
            }));
            return;
        }
    }

    ()
    {
        this$0 = final_twebbrowactivity;
        val$bitmap = bitmap1;
        val$file = File.this;
        super();
    }
}
