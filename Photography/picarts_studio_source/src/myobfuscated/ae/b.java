// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ae;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package myobfuscated.ae:
//            a

public final class b
{

    private final Context a;

    public b(Context context)
    {
        a = context;
    }

    private static a a(String s)
    {
        Class class1;
        try
        {
            class1 = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", s);
        }
        s = ((String) (class1.newInstance()));
        if (!(s instanceof a))
        {
            throw new RuntimeException((new StringBuilder("Expected instanceof GlideModule, but found: ")).append(s).toString());
        } else
        {
            return (a)s;
        }
        s;
_L2:
        throw new RuntimeException((new StringBuilder("Unable to instantiate GlideModule implementation for ")).append(class1).toString(), s);
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final List a()
    {
        Object obj = new ArrayList();
        try
        {
            ApplicationInfo applicationinfo = a.getPackageManager().getApplicationInfo(a.getPackageName(), 128);
            if (applicationinfo.metaData != null)
            {
                Iterator iterator = applicationinfo.metaData.keySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator.next();
                    if ("GlideModule".equals(applicationinfo.metaData.get(s)))
                    {
                        ((List) (obj)).add(a(s));
                    }
                } while (true);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", ((Throwable) (obj)));
        }
        return ((List) (obj));
    }
}
