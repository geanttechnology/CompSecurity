// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.webkit.WebView;

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

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
