// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageCodecJNI, an, x

public class ba
{

    protected boolean a;
    private long b;

    public ba()
    {
        this(UIImageCodecJNI.new_UIMetadata(), true);
    }

    protected ba(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(ba ba1)
    {
        if (ba1 == null)
        {
            return 0L;
        } else
        {
            return ba1.b;
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
                UIImageCodecJNI.delete_UIMetadata(b);
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

    public an b()
    {
        long l = UIImageCodecJNI.UIMetadata_fileInfo_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new an(l, false);
        }
    }

    public x c()
    {
        long l = UIImageCodecJNI.UIMetadata_exifInfo_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new x(l, false);
        }
    }

    protected void finalize()
    {
        a();
    }
}
