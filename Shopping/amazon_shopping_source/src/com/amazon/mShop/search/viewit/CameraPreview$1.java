// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            CameraPreview

class this._cls0 extends Handler
{

    final CameraPreview this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            Log.w("CameraPreview", "Run scheduled restart");
            break;
        }
        CameraPreview.access$000(CameraPreview.this);
    }

    ()
    {
        this$0 = CameraPreview.this;
        super();
    }
}
