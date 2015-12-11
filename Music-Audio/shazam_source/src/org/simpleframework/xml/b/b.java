// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.b;


class b
{

    b()
    {
    }

    public static Class a(String s)
    {
        ClassLoader classloader1 = Thread.currentThread().getContextClassLoader();
        ClassLoader classloader = classloader1;
        if (classloader1 == null)
        {
            classloader = org/simpleframework/xml/b/b.getClassLoader();
        }
        return classloader.loadClass(s);
    }
}
