// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile.ADBScene7;

import android.graphics.BitmapFactory;
import android.util.Log;
import java.net.URL;

// Referenced classes of package com.adobe.mobile.ADBScene7:
//            S7CachedResource

class _callback
    implements Runnable
{

    private _callback _callback;
    private String _url;
    final S7CachedResource this$0;

    public void run()
    {
        Object obj = null;
        android.graphics.Bitmap bitmap;
        Log.d("ADBMobile", String.format("Scene 7 - About to get image %s", new Object[] {
            _url
        }));
        bitmap = BitmapFactory.decodeStream((new URL(_url)).openStream());
_L2:
        if (_callback != null)
        {
            _callback._callback(bitmap);
        }
        return;
        Exception exception;
        exception;
        Log.e("ADBMobile", String.format("Scene 7 - %s", new Object[] {
            exception.getLocalizedMessage()
        }));
        exception.printStackTrace();
        exception = obj;
        if (_callback != null)
        {
            _callback._callback(null);
            exception = obj;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public (String s,  )
    {
        this$0 = S7CachedResource.this;
        super();
        _url = s;
        _callback = ;
    }
}
