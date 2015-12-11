// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.pm.PackageManager;

// Referenced classes of package android.support.v7:
//            amh, amx

class a
    implements amh
{

    final amx a;

    public String a(Context context)
        throws Exception
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
        throws Exception
    {
        return a(context);
    }

    eManager(amx amx1)
    {
        a = amx1;
        super();
    }
}
