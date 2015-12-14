// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;


public class w
{

    public Object a;
    public Object b;

    public w(Object obj, Object obj1)
    {
        a = obj;
        b = obj1;
    }

    public static w a(Object obj, Object obj1)
    {
        return new w(obj, obj1);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof w))
            {
                return false;
            }
            try
            {
                obj = (w)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            if (!a.equals(((w) (obj)).a) || !b.equals(((w) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (a.hashCode() + 527) * 31 + b.hashCode();
    }
}
