// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.util.Log;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TWebBrowActivity

class val.bitmapString
    implements Runnable
{

    final val.bitmapString this$1;
    final String val$bitmapString;

    public void run()
    {
        Log.i("TWebBrowActivity", (new StringBuilder()).append("saveWebPhoto ").append(val$bitmapString).toString());
        android.graphics.Bitmap bitmap = stringtoBitmap(val$bitmapString);
        saveBitmap(bitmap);
    }

    ()
    {
        this$1 = final_;
        val$bitmapString = String.this;
        super();
    }
}
