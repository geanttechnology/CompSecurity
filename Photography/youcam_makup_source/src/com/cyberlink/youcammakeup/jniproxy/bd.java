// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageCodecJNI, bf

public class bd
{

    protected boolean a;
    private long b;

    public bd()
    {
        this(UIImageCodecJNI.new_UIThumbnailProperty(), true);
    }

    protected bd(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(bd bd1)
    {
        if (bd1 == null)
        {
            return 0L;
        } else
        {
            return bd1.b;
        }
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
                UIImageCodecJNI.delete_UIThumbnailProperty(b);
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

    public bf b()
    {
        long l = UIImageCodecJNI.UIThumbnailProperty_items_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new bf(l, false);
        }
    }

    protected void finalize()
    {
        a();
    }
}
