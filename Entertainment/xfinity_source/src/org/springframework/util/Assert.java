// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.util;

import java.util.Collection;

// Referenced classes of package org.springframework.util:
//            StringUtils, CollectionUtils

public abstract class Assert
{

    public static void hasLength(String s, String s1)
    {
        if (!StringUtils.hasLength(s))
        {
            throw new IllegalArgumentException(s1);
        } else
        {
            return;
        }
    }

    public static void isInstanceOf(Class class1, Object obj)
    {
        isInstanceOf(class1, obj, "");
    }

    public static void isInstanceOf(Class class1, Object obj, String s)
    {
        notNull(class1, "Type to check against must not be null");
        if (!class1.isInstance(obj))
        {
            s = (new StringBuilder()).append(s).append("Object of class [");
            if (obj != null)
            {
                obj = obj.getClass().getName();
            } else
            {
                obj = "null";
            }
            throw new IllegalArgumentException(s.append(((String) (obj))).append("] must be an instance of ").append(class1).toString());
        } else
        {
            return;
        }
    }

    public static void isTrue(boolean flag, String s)
    {
        if (!flag)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }

    public static void notEmpty(Collection collection, String s)
    {
        if (CollectionUtils.isEmpty(collection))
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }

    public static void notNull(Object obj, String s)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }

    public static void state(boolean flag, String s)
    {
        if (!flag)
        {
            throw new IllegalStateException(s);
        } else
        {
            return;
        }
    }
}
