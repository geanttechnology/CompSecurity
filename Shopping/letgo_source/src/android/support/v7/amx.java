// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.pm.PackageManager;

// Referenced classes of package android.support.v7:
//            amf, alt, amc, amh

public class amx
{

    private final amh a = new amh() {

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

            
            {
                a = amx.this;
                super();
            }
    };
    private final amf b = new amf();

    public amx()
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
            alt.h().e("Fabric", "Failed to determine installer package name", context);
            return null;
        }
        if (flag)
        {
            context = null;
        }
        return context;
    }
}
