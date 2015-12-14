// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.AthenaStrokeType;
import com.cyberlink.youcammakeup.jniproxy.e;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import java.nio.ByteBuffer;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            b

public class a
{

    private long a;
    private e b;

    public a()
    {
        a = -1L;
        b = new e(Globals.d().l());
    }

    public static a a()
    {
        return com.cyberlink.youcammakeup.kernelctrl.b.a();
    }

    public ByteBuffer a(boolean flag)
    {
        return (ByteBuffer)b.a(flag);
    }

    public boolean a(float f1, float f2)
    {
        return b.a(f1, f2);
    }

    public boolean a(long l, ImageBufferWrapper imagebufferwrapper)
    {
        a = l;
        return b.a(imagebufferwrapper.j());
    }

    public boolean a(AthenaStrokeType athenastroketype, int i)
    {
        return b.a(athenastroketype, i);
    }

    public boolean b()
    {
        a = -1L;
        return b.b();
    }

    public boolean c()
    {
        return b.c();
    }

    public boolean d()
    {
        return b.d();
    }

    public boolean e()
    {
        return b.e();
    }

    public long f()
    {
        return a;
    }
}
