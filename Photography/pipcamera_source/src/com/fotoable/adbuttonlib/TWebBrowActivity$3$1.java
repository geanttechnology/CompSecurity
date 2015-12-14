// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.net.Uri;
import android.webkit.WebView;
import java.io.FileNotFoundException;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TWebBrowActivity

class this._cls1
    implements Runnable
{

    final etBitmapString this$1;

    public void run()
    {
        TWebBrowActivity.access$600(_fld0);
        if (webGetBitmapString != null)
        {
            TWebBrowActivity.access$300(_fld0).loadUrl(String.format("javascript:%s('%s')", new Object[] {
                "showBase64Image", webGetBitmapString
            }));
        }
    }

    l.imageUri()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/fotoable/adbuttonlib/TWebBrowActivity$3

/* anonymous class */
    class TWebBrowActivity._cls3
        implements Runnable
    {

        final TWebBrowActivity this$0;
        final Uri val$imageUri;

        public void run()
        {
            int i = TWebBrowActivity.access$900(TWebBrowActivity.this);
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
                bitmap = CropItemImage(imageUri, i);
            }
            catch (FileNotFoundException filenotfoundexception)
            {
                filenotfoundexception.printStackTrace();
                filenotfoundexception = null;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                exception = null;
            }
            if (bitmap != null)
            {
                webGetBitmapString = bitmaptoString(bitmap);
            }
            runOnUiThread(new TWebBrowActivity._cls3._cls1());
        }

            
            {
                this$0 = final_twebbrowactivity;
                imageUri = Uri.this;
                super();
            }
    }

}
