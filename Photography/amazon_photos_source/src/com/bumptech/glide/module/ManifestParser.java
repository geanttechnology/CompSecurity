// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.bumptech.glide.module:
//            GlideModule

public final class ManifestParser
{

    private final Context context;

    public ManifestParser(Context context1)
    {
        context = context1;
    }

    private static GlideModule parseModule(String s)
    {
        Object obj;
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", s);
        }
        try
        {
            obj = s.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException((new StringBuilder()).append("Unable to instantiate GlideModule implementation for ").append(s).toString(), ((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException((new StringBuilder()).append("Unable to instantiate GlideModule implementation for ").append(s).toString(), ((Throwable) (obj)));
        }
        if (!(obj instanceof GlideModule))
        {
            throw new RuntimeException((new StringBuilder()).append("Expected instanceof GlideModule, but found: ").append(obj).toString());
        } else
        {
            return (GlideModule)obj;
        }
    }

    public List parse()
    {
        Object obj = new ArrayList();
        try
        {
            ApplicationInfo applicationinfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
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
                        ((List) (obj)).add(parseModule(s));
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
