// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ant.liao;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.ant.liao:
//            GifView

class t> extends Handler
{

    final GifView this$0;

    public void handleMessage(Message message)
    {
        try
        {
            GifView.access$0(GifView.this);
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
        this$0 = GifView.this;
        super();
    }
}
