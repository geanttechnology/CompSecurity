// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import android.content.Context;
import android.content.ContextWrapper;

// Referenced classes of package com.amazon.geo.mapsv2.pvt:
//            RemoteContextUtils

private static class mClassLoader extends ContextWrapper
{

    final ClassLoader mClassLoader;
    final Context mParentContext;

    public Context getApplicationContext()
    {
        return mParentContext.getApplicationContext();
    }

    public ClassLoader getClassLoader()
    {
        return mClassLoader;
    }

    (Context context, Context context1, ClassLoader classloader)
    {
        super(context1);
        mParentContext = context;
        mClassLoader = classloader;
    }
}
