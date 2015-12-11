// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.Arrays;

// Referenced classes of package com.google.common.base:
//            Preconditions

public final class Objects
{
    public static final class ToStringHelper
    {

        private final String className;
        private ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        private ValueHolder addHolder()
        {
            ValueHolder valueholder = new ValueHolder();
            holderTail.next = valueholder;
            holderTail = valueholder;
            return valueholder;
        }

        private ToStringHelper addHolder(String s, Object obj)
        {
            ValueHolder valueholder = addHolder();
            valueholder.value = obj;
            valueholder.name = (String)Preconditions.checkNotNull(s);
            return this;
        }

        public ToStringHelper add(String s, int i)
        {
            return addHolder(s, String.valueOf(i));
        }

        public ToStringHelper add(String s, Object obj)
        {
            return addHolder(s, obj);
        }

        public String toString()
        {
            boolean flag = omitNullValues;
            StringBuilder stringbuilder = (new StringBuilder(32)).append(className).append('{');
            ValueHolder valueholder = holderHead.next;
            String s1;
            for (String s = ""; valueholder != null; s = s1)
            {
label0:
                {
                    if (flag)
                    {
                        s1 = s;
                        if (valueholder.value == null)
                        {
                            break label0;
                        }
                    }
                    stringbuilder.append(s);
                    s1 = ", ";
                    if (valueholder.name != null)
                    {
                        stringbuilder.append(valueholder.name).append('=');
                    }
                    stringbuilder.append(valueholder.value);
                }
                valueholder = valueholder.next;
            }

            return stringbuilder.append('}').toString();
        }

        private ToStringHelper(String s)
        {
            holderHead = new ValueHolder();
            holderTail = holderHead;
            omitNullValues = false;
            className = (String)Preconditions.checkNotNull(s);
        }

    }

    private static final class ToStringHelper.ValueHolder
    {

        String name;
        ToStringHelper.ValueHolder next;
        Object value;

        private ToStringHelper.ValueHolder()
        {
        }

    }


    private Objects()
    {
    }

    public static boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static Object firstNonNull(Object obj, Object obj1)
    {
        if (obj != null)
        {
            return obj;
        } else
        {
            return Preconditions.checkNotNull(obj1);
        }
    }

    public static transient int hashCode(Object aobj[])
    {
        return Arrays.hashCode(aobj);
    }

    private static String simpleName(Class class1)
    {
        class1 = class1.getName().replaceAll("\\$[0-9]+", "\\$");
        int j = class1.lastIndexOf('$');
        int i = j;
        if (j == -1)
        {
            i = class1.lastIndexOf('.');
        }
        return class1.substring(i + 1);
    }

    public static ToStringHelper toStringHelper(Class class1)
    {
        return new ToStringHelper(simpleName(class1));
    }
}
