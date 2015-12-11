// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;


// Referenced classes of package org.simpleframework.xml.d:
//            ag

final class k
    implements ag
{

    k()
    {
    }

    public final Object a(String s)
    {
        Object obj;
        Object obj1;
        if (s.equals("byte"))
        {
            obj = Byte.TYPE;
        } else
        if (s.equals("short"))
        {
            obj = Short.TYPE;
        } else
        if (s.equals("int"))
        {
            obj = Integer.TYPE;
        } else
        if (s.equals("long"))
        {
            obj = Long.TYPE;
        } else
        if (s.equals("char"))
        {
            obj = Character.TYPE;
        } else
        if (s.equals("float"))
        {
            obj = Float.TYPE;
        } else
        if (s.equals("double"))
        {
            obj = Double.TYPE;
        } else
        if (s.equals("boolean"))
        {
            obj = Boolean.TYPE;
        } else
        if (s.equals("void"))
        {
            obj = Void.TYPE;
        } else
        {
            obj = null;
        }
        obj1 = obj;
        if (obj == null)
        {
            obj1 = Thread.currentThread().getContextClassLoader();
            obj = obj1;
            if (obj1 == null)
            {
                obj = getClass().getClassLoader();
            }
            obj1 = ((ClassLoader) (obj)).loadClass(s);
        }
        return obj1;
    }

    public final String a(Object obj)
    {
        return ((Class)obj).getName();
    }
}
