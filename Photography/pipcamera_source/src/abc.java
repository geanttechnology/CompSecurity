// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageManager;

public class abc
{

    private final aal a = new aal() {

        final abc a;

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

            
            {
                a = abc.this;
                super();
            }
    };
    private final aaj b = new aaj();

    public abc()
    {
    }

    public String a(Context context)
    {
        boolean flag;
        try
        {
            context = (String)b.a(context, a);
            flag = "".equals(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            zw.h().e("Fabric", "Failed to determine installer package name", context);
            return null;
        }
        if (flag)
        {
            context = null;
        }
        return context;
    }
}
