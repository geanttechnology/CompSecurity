// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.persistance;


// Referenced classes of package com.gimbal.internal.persistance:
//            ApplicationConfiguration, f

public final class a
{

    public f a;
    private ApplicationConfiguration b;

    public a(f f1)
    {
        a = f1;
        a(a());
    }

    public final ApplicationConfiguration a()
    {
        if (b == null)
        {
            b = new ApplicationConfiguration();
            b.setAllowKitKat(a.a("allowKitKat", null));
            b.setSmoothingWindow(a.a("smoothingWindow"));
        }
        return b;
    }

    public final void a(ApplicationConfiguration applicationconfiguration)
    {
        if (applicationconfiguration != null)
        {
            b = applicationconfiguration;
            a.b("allowKitKat", applicationconfiguration.isAllowKitKat());
            a.a("smoothingWindow", applicationconfiguration.getSmoothingWindow());
        }
    }

    public final int b()
    {
        Integer integer = a().getSmoothingWindow();
        if (integer == null)
        {
            return 3;
        } else
        {
            return integer.intValue();
        }
    }
}
