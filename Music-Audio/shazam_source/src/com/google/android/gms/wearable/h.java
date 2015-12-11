// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.wearable:
//            Asset

public final class h
{

    public final HashMap a = new HashMap();

    public h()
    {
    }

    private static void a(String s, Object obj, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Key ");
        stringbuilder.append(s);
        stringbuilder.append(" expected ");
        stringbuilder.append(s1);
        stringbuilder.append(" but value was a ");
        stringbuilder.append(obj.getClass().getName());
        stringbuilder.append(".  The default value ");
        stringbuilder.append("<null>");
        stringbuilder.append(" was returned.");
    }

    private int e(String s)
    {
        Object obj = a.get(s);
        if (obj == null)
        {
            return 0;
        }
        int i;
        try
        {
            i = ((Integer)obj).intValue();
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "Integer");
            return 0;
        }
        return i;
    }

    public final Object a(String s)
    {
        return a.get(s);
    }

    public final void a(String s, Asset asset)
    {
        a.put(s, asset);
    }

    public final void a(String s, String s1)
    {
        a.put(s, s1);
    }

    public final void a(String s, ArrayList arraylist)
    {
        a.put(s, arraylist);
    }

    public final int b(String s)
    {
        return e(s);
    }

    public final String c(String s)
    {
        Object obj = a.get(s);
        if (obj == null)
        {
            return null;
        }
        String s1;
        try
        {
            s1 = (String)obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "String");
            return null;
        }
        return s1;
    }

    public final byte[] d(String s)
    {
        Object obj = a.get(s);
        if (obj == null)
        {
            return null;
        }
        byte abyte0[];
        try
        {
            abyte0 = (byte[])(byte[])obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "byte[]");
            return null;
        }
        return abyte0;
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof h))
        {
            return false;
        }
        obj = (h)obj;
        if (a.size() != ((h) (obj)).a.size())
        {
            return false;
        }
        Iterator iterator = a.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj2 = (String)iterator.next();
            Object obj1 = a(((String) (obj2)));
            obj2 = ((h) (obj)).a(((String) (obj2)));
            if (obj1 instanceof Asset)
            {
                if (!(obj2 instanceof Asset))
                {
                    return false;
                }
                obj1 = (Asset)obj1;
                obj2 = (Asset)obj2;
                boolean flag;
                if (obj1 == null || obj2 == null)
                {
                    if (obj1 == obj2)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                } else
                if (!TextUtils.isEmpty(((Asset) (obj1)).c))
                {
                    flag = ((Asset) (obj1)).c.equals(((Asset) (obj2)).c);
                } else
                {
                    flag = Arrays.equals(((Asset) (obj1)).b, ((Asset) (obj2)).b);
                }
                if (!flag)
                {
                    return false;
                }
                continue;
            }
            if (obj1 instanceof String[])
            {
                if (!(obj2 instanceof String[]))
                {
                    return false;
                }
                if (!Arrays.equals((String[])(String[])obj1, (String[])(String[])obj2))
                {
                    return false;
                }
                continue;
            }
            if (obj1 instanceof long[])
            {
                if (!(obj2 instanceof long[]))
                {
                    return false;
                }
                if (!Arrays.equals((long[])(long[])obj1, (long[])(long[])obj2))
                {
                    return false;
                }
                continue;
            }
            if (obj1 instanceof float[])
            {
                if (!(obj2 instanceof float[]))
                {
                    return false;
                }
                if (!Arrays.equals((float[])(float[])obj1, (float[])(float[])obj2))
                {
                    return false;
                }
                continue;
            }
            if (obj1 instanceof byte[])
            {
                if (!(obj2 instanceof byte[]))
                {
                    return false;
                }
                if (!Arrays.equals((byte[])(byte[])obj1, (byte[])(byte[])obj2))
                {
                    return false;
                }
                continue;
            }
            if (obj1 == null || obj2 == null)
            {
                if (obj1 != obj2)
                {
                    return false;
                }
                break;
            }
            if (!obj1.equals(obj2))
            {
                return false;
            }
        } while (true);
        return true;
    }

    public final int hashCode()
    {
        return a.hashCode() * 29;
    }

    public final String toString()
    {
        return a.toString();
    }
}
