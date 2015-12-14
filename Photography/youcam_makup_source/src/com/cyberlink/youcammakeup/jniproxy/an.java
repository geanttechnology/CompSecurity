// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageCodecJNI, UIImageFormat, UIImageOrientation

public class an
{

    protected boolean a;
    private long b;

    public an()
    {
        this(UIImageCodecJNI.new_UIFileInfo(), true);
    }

    protected an(long l, boolean flag)
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
                UIImageCodecJNI.delete_UIFileInfo(b);
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

    public void a(long l)
    {
        UIImageCodecJNI.UIFileInfo_ulWidth_set(b, this, l);
    }

    public UIImageFormat b()
    {
        return UIImageFormat.a(UIImageCodecJNI.UIFileInfo_nFormat_get(b, this));
    }

    public void b(long l)
    {
        UIImageCodecJNI.UIFileInfo_ulHeight_set(b, this, l);
    }

    public long c()
    {
        return UIImageCodecJNI.UIFileInfo_ulWidth_get(b, this);
    }

    public long d()
    {
        return UIImageCodecJNI.UIFileInfo_ulHeight_get(b, this);
    }

    public UIImageOrientation e()
    {
        return UIImageOrientation.a(UIImageCodecJNI.UIFileInfo_nOrientation_get(b, this));
    }

    protected void finalize()
    {
        a();
    }
}
