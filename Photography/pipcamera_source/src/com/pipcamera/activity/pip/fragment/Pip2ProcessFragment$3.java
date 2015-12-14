// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.pipcamera.activity.pip.Pip2FragmentActivity;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            Pip2ProcessFragment

class a extends Handler
{

    final Pip2ProcessFragment a;

    public void handleMessage(Message message)
    {
        if (message != null)
        {
            message = (Bitmap)message.obj;
            Pip2ProcessFragment.a(a, message);
            return;
        } else
        {
            Pip2ProcessFragment.a(a).b();
            return;
        }
    }

    (Pip2ProcessFragment pip2processfragment)
    {
        a = pip2processfragment;
        super();
    }
}
