// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageManager;

final class cnu extends bmr
{

    private cnq a;

    cnu(cnq cnq1)
    {
        a = cnq1;
        super();
    }

    public final Object a()
    {
        Object obj = a.a;
        b.a(obj);
        if (a.i == null)
        {
            b.a(obj);
            if (a.h == null)
            {
                a.h = Boolean.valueOf(((Context) (obj)).getPackageManager().hasSystemFeature("com.google.android.tv"));
            }
            boolean flag;
            if (a.h.booleanValue() || ((Context) (obj)).getPackageManager().hasSystemFeature("android.hardware.type.television"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a.i = Boolean.valueOf(flag);
        }
        if (a.i.booleanValue())
        {
            obj = cng.b;
        } else
        if (a.c(a.a))
        {
            obj = cng.c;
        } else
        {
            obj = cng.a;
        }
        return new cnf(a.a.getPackageName(), a.g(a.a), ((cng) (obj)), a.a());
    }
}
