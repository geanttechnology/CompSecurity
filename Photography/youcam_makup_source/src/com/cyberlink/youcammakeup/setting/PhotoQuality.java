// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.setting;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.database.r;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.o;
import com.cyberlink.youcammakeup.kernelctrl.y;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.m;

public abstract class PhotoQuality extends Enum
{

    public static final PhotoQuality a;
    public static final PhotoQuality b;
    public static final PhotoQuality c;
    public static final PhotoQuality d;
    private static Integer e = null;
    private static final PhotoQuality f[];
    private static final PhotoQuality g[];
    private static final PhotoQuality h[];

    private PhotoQuality(String s, int k)
    {
        super(s, k);
    }


    public static PhotoQuality a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("name == null");
        }
        PhotoQuality aphotoquality[] = values();
        int l = aphotoquality.length;
        for (int k = 0; k < l; k++)
        {
            PhotoQuality photoquality = aphotoquality[k];
            if (photoquality.toString().equals(s))
            {
                return photoquality;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append(s).append(" is not a constant in ").append(com/cyberlink/youcammakeup/setting/PhotoQuality.getName()).toString());
    }

    public static boolean a(long l)
    {
        if (b() == a)
        {
            long l1 = l;
            if (l == -5L)
            {
                l1 = StatusManager.j().l();
            }
            Object obj = com.cyberlink.youcammakeup.c.f();
            if (obj != null)
            {
                obj = ((p) (obj)).d(l1);
                int k;
                int i1;
                if (obj == null)
                {
                    obj = ViewEngine.a().a(l1);
                    i1 = (int)((d) (obj)).b.a;
                    k = (int)((d) (obj)).b.b;
                } else
                {
                    i1 = ((r) (obj)).j();
                    k = ((r) (obj)).i();
                }
                if (i1 > 1600 || k > 1600)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static PhotoQuality b()
    {
        return a(z.b("PHOTO_QUALITY", y.c, Globals.d()));
    }

    public static final int c()
    {
        PhotoQuality photoquality = b();
        class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[PhotoQuality.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.setting.PhotoQuality.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[PhotoQuality.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls4.a[photoquality.ordinal()])
        {
        default:
            return g();

        case 1: // '\001'
            return f();
        }
    }

    public static final int d()
    {
        PhotoQuality photoquality = b();
        switch (_cls4.a[photoquality.ordinal()])
        {
        default:
            return h();

        case 1: // '\001'
            return f();

        case 2: // '\002'
            return g();
        }
    }

    public static PhotoQuality[] e()
    {
        if (j())
        {
            return g;
        } else
        {
            return f;
        }
    }

    private static int f()
    {
        return 800;
    }

    private static int g()
    {
        Integer integer = Globals.d().e();
        return integer == null || integer.intValue() >= 0xc3500 ? 1600 : 1024;
    }

    private static int h()
    {
        if (e != null)
        {
            return e.intValue();
        }
        int k = i();
        if (k <= 0)
        {
            k = 2048;
        }
        if (k <= 1600)
        {
            k = 1600;
        }
        e = Integer.valueOf(k);
        return e.intValue();
    }

    private static int i()
    {
        int k = z.b("TEXTURE_MAX_SIZE", 2048, Globals.d());
        int l = m.b();
        if (m.b() > 0)
        {
            k = l;
        }
        int i1 = z.b("CAMERA_MAX_SIZE", 2048, Globals.d());
        l = k;
        if (k > 4096)
        {
            l = 4096;
        }
        return Math.min(l, i1);
    }

    private static boolean j()
    {
        boolean flag = true;
        if (i() <= 1600)
        {
            flag = false;
        }
        Integer integer = Globals.d().e();
        boolean flag1 = flag;
        if (integer != null)
        {
            flag1 = flag;
            if (integer.intValue() < 0xbb800)
            {
                flag1 = false;
            }
        }
        if (m.a())
        {
            return false;
        } else
        {
            return flag1;
        }
    }

    public static PhotoQuality valueOf(String s)
    {
        return (PhotoQuality)Enum.valueOf(com/cyberlink/youcammakeup/setting/PhotoQuality, s);
    }

    public static PhotoQuality[] values()
    {
        return (PhotoQuality[])h.clone();
    }

    public abstract int a();

    static 
    {
        a = new PhotoQuality("UltraHigh", 0) {

            public int a()
            {
                return 0x7f07064f;
            }

            public String toString()
            {
                return "UltraHigh";
            }

        };
        b = new PhotoQuality("High", 1) {

            public int a()
            {
                return 0x7f07064d;
            }

            public String toString()
            {
                return "High";
            }

        };
        c = new PhotoQuality("Normal", 2) {

            public int a()
            {
                return 0x7f07064e;
            }

            public String toString()
            {
                return "Normal";
            }

        };
        h = (new PhotoQuality[] {
            a, b, c
        });
        d = b;
        f = (new PhotoQuality[] {
            b, c
        });
        g = (new PhotoQuality[] {
            a, b, c
        });
    }
}
