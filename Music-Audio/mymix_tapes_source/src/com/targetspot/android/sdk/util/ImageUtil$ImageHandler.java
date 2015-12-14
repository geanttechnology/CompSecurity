// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.targetspot.android.sdk.util:
//            ImageUtil

public static abstract class  extends Handler
{

    public static final int ERROR = 0;
    public static final int SUCCESS = 1;

    public abstract void handleError(Throwable throwable);

    public abstract void handleImage(Bitmap bitmap);

    public void handleMessage(Message message)
    {
        if (message.what != 0) goto _L2; else goto _L1
_L1:
        if (message.obj == null) goto _L4; else goto _L3
_L3:
        handleError((Throwable)message.obj);
_L6:
        return;
_L4:
        handleError(new NullPointerException("no error found"));
        return;
_L2:
        if (message.what == 1)
        {
            if (message.obj != null)
            {
                handleImage((Bitmap)message.obj);
                return;
            } else
            {
                handleError(new NullPointerException("no bitmap available"));
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public ()
    {
    }
}
