// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.graphics.Bitmap;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.utility.aa;

class ao
{

    bi a;
    Bitmap b;

    private ao()
    {
        a = null;
        b = null;
    }

    ao(VenusHelper._cls1 _pcls1)
    {
        this();
    }

    public void a()
    {
        if (a != null)
        {
            a.a();
        }
        a = null;
        aa.a(b);
        b = null;
    }

    public boolean b()
    {
        return a == null && b == null;
    }
}
