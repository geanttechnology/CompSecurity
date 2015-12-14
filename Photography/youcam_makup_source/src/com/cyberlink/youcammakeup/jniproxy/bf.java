// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageCodecJNI, be

public class bf
{

    protected boolean a;
    private long b;

    public bf()
    {
        this(UIImageCodecJNI.new_UIThumbnailPropertyItemVector__SWIG_0(), true);
    }

    protected bf(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    public be a(int i)
    {
        return new be(UIImageCodecJNI.UIThumbnailPropertyItemVector_get(b, this, i), false);
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != 0L)
        {
            if (a)
            {
                a = false;
                UIImageCodecJNI.delete_UIThumbnailPropertyItemVector(b);
            }
            b = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long b()
    {
        return UIImageCodecJNI.UIThumbnailPropertyItemVector_size(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
