// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.pipcamera.activity.pip.PipStyleBaseActivity;
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipProcessFragment

class a extends Handler
{

    final PipProcessFragment a;

    public void handleMessage(Message message)
    {
        PipProcessFragment.a(a).b();
        if (message != null)
        {
            message = (Bitmap)message.obj;
            PipProcessFragment.b(a).setImageBitmap(message, false);
        }
    }

    ViewTouch(PipProcessFragment pipprocessfragment)
    {
        a = pipprocessfragment;
        super();
    }
}
