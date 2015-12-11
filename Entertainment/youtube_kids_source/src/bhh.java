// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageManager;

final class bhh extends bmr
{

    private bgv a;

    bhh(bgv bgv1)
    {
        a = bgv1;
        super();
    }

    public final Object a()
    {
        bgv bgv1 = a;
        android.content.pm.ApplicationInfo applicationinfo = bgv1.b.getApplicationInfo();
        return bgv1.b.getPackageManager().getApplicationLabel(applicationinfo).toString();
    }
}
