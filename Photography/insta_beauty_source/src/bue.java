// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageManager;

class bue
    implements btg
{

    final bud a;

    bue(bud bud)
    {
        a = bud;
        super();
    }

    public String a(Context context)
    {
        String s = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        context = s;
        if (s == null)
        {
            context = "";
        }
        return context;
    }

    public Object load(Context context)
    {
        return a(context);
    }
}
