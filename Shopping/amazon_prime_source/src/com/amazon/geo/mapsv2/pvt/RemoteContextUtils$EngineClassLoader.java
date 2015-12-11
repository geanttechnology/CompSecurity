// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import dalvik.system.DexClassLoader;

// Referenced classes of package com.amazon.geo.mapsv2.pvt:
//            RemoteContextUtils

private static class  extends DexClassLoader
{

    protected Class loadClass(String s, boolean flag)
        throws ClassNotFoundException
    {
        Class class2 = super.findLoadedClass(s);
        Class class1 = class2;
        if (class2 == null)
        {
            try
            {
                class1 = super.findClass(s);
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                classnotfoundexception = class2;
            }
        }
        class2 = class1;
        if (class1 == null)
        {
            class2 = super.loadClass(s, flag);
        }
        return class2;
    }

    public (String s, String s1, String s2, ClassLoader classloader)
    {
        super(s, s1, s2, classloader);
    }
}
