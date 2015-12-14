// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.net.Uri;
import java.io.IOException;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TWebBrowActivity

class val.imageUri
    implements Runnable
{

    final TWebBrowActivity this$0;
    final Uri val$imageUri;

    public void run()
    {
        int i = TWebBrowActivity.access$1000(TWebBrowActivity.this);
        class _cls1
            implements Runnable
        {

            final TWebBrowActivity._cls3 this$1;

            public void run()
            {
                TWebBrowActivity.access$600(this$0);
                if (webGetBitmapString != null)
                {
                    TWebBrowActivity.access$300(this$0).loadUrl(String.format("javascript:%s('%s')", new Object[] {
                        "showBase64Image", webGetBitmapString
                    }));
                }
            }

            _cls1()
            {
                this$1 = TWebBrowActivity._cls3.this;
                super();
            }
        }

        android.graphics.Bitmap bitmap;
        if (i < 900)
        {
            i = 640;
        } else
        if (i > 1200)
        {
            i = 1280;
        } else
        {
            i = 960;
        }
        try
        {
            bitmap = CropItemImage(val$imageUri, i);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            ioexception = null;
        }
        if (bitmap != null)
        {
            webGetBitmapString = bitmaptoString(bitmap);
        }
        runOnUiThread(new _cls1());
    }

    _cls1()
    {
        this$0 = final_twebbrowactivity;
        val$imageUri = Uri.this;
        super();
    }
}
