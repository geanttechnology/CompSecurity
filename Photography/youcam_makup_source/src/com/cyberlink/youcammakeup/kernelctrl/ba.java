// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.graphics.Bitmap;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.jniproxy.bl;
import com.cyberlink.youcammakeup.utility.aa;

class ba
{

    bl a;
    bi b;
    Bitmap c;

    private ba()
    {
        a = null;
        b = null;
        c = null;
    }

    ba(VenusHelper._cls1 _pcls1)
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
        if (b != null)
        {
            b.a();
        }
        b = null;
        aa.a(c);
        c = null;
    }
}
