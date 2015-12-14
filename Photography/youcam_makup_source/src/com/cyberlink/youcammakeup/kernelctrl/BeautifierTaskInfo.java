// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;

public class BeautifierTaskInfo
{

    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private String e;
    private ResultBufferType f;
    private boolean g;
    private ImageBufferWrapper h;

    public BeautifierTaskInfo(BeautifierTaskInfo beautifiertaskinfo)
    {
        a = beautifiertaskinfo.a;
        b = beautifiertaskinfo.b;
        c = beautifiertaskinfo.c;
        d = beautifiertaskinfo.d;
        g = beautifiertaskinfo.g;
        e = beautifiertaskinfo.e;
        f = beautifiertaskinfo.f;
        if (beautifiertaskinfo.h != null)
        {
            h = new ImageBufferWrapper();
            h.a(beautifiertaskinfo.h);
            return;
        } else
        {
            h = null;
            return;
        }
    }

    public BeautifierTaskInfo(boolean flag)
    {
        a = flag;
        b = true;
        c = false;
        d = false;
        g = false;
        e = null;
        f = ResultBufferType.b;
        h = null;
    }

    public BeautifierTaskInfo(boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        a = flag;
        b = flag1;
        c = flag2;
        d = flag3;
        g = false;
        e = null;
        f = ResultBufferType.b;
        h = null;
    }

    public void a(ImageBufferWrapper imagebufferwrapper)
    {
        h = imagebufferwrapper;
    }

    public void a(String s, ResultBufferType resultbuffertype)
    {
        e = s;
        f = resultbuffertype;
    }

    public void a(boolean flag)
    {
        g = flag;
    }

    public boolean a()
    {
        return g;
    }

    public void b(boolean flag)
    {
        b = flag;
    }

    public boolean b()
    {
        return b;
    }

    public boolean c()
    {
        return a;
    }

    public boolean d()
    {
        return d;
    }

    public String e()
    {
        return e;
    }

    public ResultBufferType f()
    {
        return f;
    }

    public ImageBufferWrapper g()
    {
        return h;
    }

    private class ResultBufferType extends Enum
    {

        public static final ResultBufferType a;
        public static final ResultBufferType b;
        private static final ResultBufferType c[];

        public static ResultBufferType valueOf(String s)
        {
            return (ResultBufferType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/BeautifierTaskInfo$ResultBufferType, s);
        }

        public static ResultBufferType[] values()
        {
            return (ResultBufferType[])c.clone();
        }

        static 
        {
            a = new ResultBufferType("VenusDst", 0);
            b = new ResultBufferType("AccessoryDst", 1);
            c = (new ResultBufferType[] {
                a, b
            });
        }

        private ResultBufferType(String s, int i)
        {
            super(s, i);
        }
    }

}
