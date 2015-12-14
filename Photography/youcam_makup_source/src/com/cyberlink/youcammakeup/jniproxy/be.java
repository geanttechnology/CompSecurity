// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageCodecJNI, UIThumbnailType, UIImageOrientation

public class be
{

    protected boolean a;
    private long b;

    public be()
    {
        this(UIImageCodecJNI.new_UIThumbnailPropertyItem(), true);
    }

    protected be(long l, boolean flag)
    {
        a = flag;
        b = l;
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
                UIImageCodecJNI.delete_UIThumbnailPropertyItem(b);
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

    public UIThumbnailType b()
    {
        return UIThumbnailType.a(UIImageCodecJNI.UIThumbnailPropertyItem_nType_get(b, this));
    }

    public long c()
    {
        return UIImageCodecJNI.UIThumbnailPropertyItem_nWidth_get(b, this);
    }

    public long d()
    {
        return UIImageCodecJNI.UIThumbnailPropertyItem_nHeight_get(b, this);
    }

    public UIImageOrientation e()
    {
        return UIImageOrientation.a(UIImageCodecJNI.UIThumbnailPropertyItem_nOrientation_get(b, this));
    }

    protected void finalize()
    {
        a();
    }
}
