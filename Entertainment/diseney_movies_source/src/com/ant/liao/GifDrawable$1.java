// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ant.liao;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.ant.liao:
//            GifDrawable

class this._cls0 extends Handler
{

    final GifDrawable this$0;

    public void handleMessage(Message message)
    {
        try
        {
            GifDrawable.access$0(GifDrawable.this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.e("GifView", message.toString());
        }
    }

    ()
    {
        this$0 = GifDrawable.this;
        super();
    }
}
