// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;


// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            c, u

public class LiveDemoConfigHelper extends c
{

    private Integer c;
    private Boolean d;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private String h;
    private Boolean i;
    private String j;
    private Integer k;
    private String l;

    public LiveDemoConfigHelper()
    {
    }

    private static com.cyberlink.clgpuimage.CLMakeupLiveFilter.FLIP_MODE a(String s)
    {
        if ("L".equalsIgnoreCase(s))
        {
            return com.cyberlink.clgpuimage.CLMakeupLiveFilter.FLIP_MODE.c;
        }
        if ("P".equalsIgnoreCase(s))
        {
            return com.cyberlink.clgpuimage.CLMakeupLiveFilter.FLIP_MODE.b;
        } else
        {
            return com.cyberlink.clgpuimage.CLMakeupLiveFilter.FLIP_MODE.a;
        }
    }

    public static LiveDemoConfigHelper h()
    {
        return u.a();
    }

    public String a()
    {
        return "livelandscape.config";
    }

    public String a(Configs configs)
    {
        return null;
    }

    public volatile String a(Enum enum)
    {
        return a((Configs)enum);
    }

    public Class b()
    {
        return com/cyberlink/youcammakeup/kernelctrl/LiveDemoConfigHelper$Configs;
    }

    public int i()
    {
        if (c != null)
        {
            return c.intValue();
        } else
        {
            Integer integer = Integer.valueOf(super.a(Configs.a, 5));
            c = integer;
            return integer.intValue();
        }
    }

    public boolean j()
    {
        if (d != null)
        {
            return d.booleanValue();
        } else
        {
            Boolean boolean1 = Boolean.valueOf(super.a(Configs.b, false));
            d = boolean1;
            return boolean1.booleanValue();
        }
    }

    public boolean k()
    {
        if (e != null)
        {
            return e.booleanValue();
        } else
        {
            Boolean boolean1 = Boolean.valueOf(super.a(Configs.c, false));
            e = boolean1;
            return boolean1.booleanValue();
        }
    }

    public boolean l()
    {
        if (f != null)
        {
            return f.booleanValue();
        } else
        {
            Boolean boolean1 = Boolean.valueOf(super.a(Configs.d, false));
            f = boolean1;
            return boolean1.booleanValue();
        }
    }

    public boolean m()
    {
        if (g != null)
        {
            return g.booleanValue();
        } else
        {
            Boolean boolean1 = Boolean.valueOf(super.a(Configs.e, false));
            g = boolean1;
            return boolean1.booleanValue();
        }
    }

    public String n()
    {
        if (h != null)
        {
            return h;
        } else
        {
            String s = super.a(Configs.f, "");
            h = s;
            return s;
        }
    }

    public boolean o()
    {
        if (i != null)
        {
            return i.booleanValue();
        } else
        {
            Boolean boolean1 = Boolean.valueOf(super.a(Configs.g, false));
            i = boolean1;
            return boolean1.booleanValue();
        }
    }

    public String p()
    {
        if (j != null)
        {
            return j;
        } else
        {
            String s = super.a(Configs.h, "");
            j = s;
            return s;
        }
    }

    public int q()
    {
        Integer integer;
        if (k != null)
        {
            integer = k;
        } else
        {
            integer = Integer.valueOf(super.a(Configs.i, 100));
            k = integer;
        }
        return integer.intValue();
    }

    public com.cyberlink.clgpuimage.CLMakeupLiveFilter.FLIP_MODE r()
    {
        if (l != null)
        {
            return a(l);
        } else
        {
            l = super.a(Configs.j, "N");
            return a(l);
        }
    }

    private class Configs extends Enum
    {

        public static final Configs a;
        public static final Configs b;
        public static final Configs c;
        public static final Configs d;
        public static final Configs e;
        public static final Configs f;
        public static final Configs g;
        public static final Configs h;
        public static final Configs i;
        public static final Configs j;
        private static final Configs k[];

        public static Configs valueOf(String s)
        {
            return (Configs)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/LiveDemoConfigHelper$Configs, s);
        }

        public static Configs[] values()
        {
            return (Configs[])k.clone();
        }

        static 
        {
            a = new Configs("LookChangePeriod", 0);
            b = new Configs("CameraSwitch", 1);
            c = new Configs("EnableAutoFocus", 2);
            d = new Configs("EnableFaceAutoFocus", 3);
            e = new Configs("AutoEnterMakeupCam", 4);
            f = new Configs("AutoExitMakeupCamTime", 5);
            g = new Configs("EnableLiveFPS", 6);
            h = new Configs("LookGuidOrder", 7);
            i = new Configs("ZoomLevel", 8);
            j = new Configs("FlipMode", 9);
            k = (new Configs[] {
                a, b, c, d, e, f, g, h, i, j
            });
        }

        private Configs(String s, int i1)
        {
            super(s, i1);
        }
    }

}
