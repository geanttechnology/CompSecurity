// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import c.a.a.a.a.a.c;

// Referenced classes of package c.a.a.a.a.b:
//            z

final class aa
    implements c
{

    aa(z z)
    {
    }

    public final Object load(Context context)
    {
        String s = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        context = s;
        if (s == null)
        {
            context = "";
        }
        return context;
    }
}
