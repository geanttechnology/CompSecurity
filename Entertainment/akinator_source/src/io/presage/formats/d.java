// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import io.presage.Presage;
import io.presage.do.e;
import io.presage.utils.f;

// Referenced classes of package io.presage.formats:
//            c, h, f, e, 
//            a

public final class d
{

    private static d a = null;

    private d()
    {
    }

    public static a a(String s, String s1, io.presage.ads.d d1, e e1)
    {
        if (s1.equals("webviews"))
        {
            if (!Presage.getInstance().getPackageHelper().a(8))
            {
                throw new c(1);
            } else
            {
                return new h(s, s1, d1, e1);
            }
        }
        if (s1.equals("launch_activity"))
        {
            return new io.presage.formats.f(s, s1, d1, e1);
        }
        if (s1.equals("hidden"))
        {
            return new io.presage.formats.e(s, s1, d1, e1);
        } else
        {
            throw new c(0);
        }
    }

    public static d a()
    {
        if (a == null)
        {
            a = new d();
        }
        return a;
    }

}
