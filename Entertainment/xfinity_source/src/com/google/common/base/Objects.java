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

        private final StringBuilder builder;
        private boolean needsSeparator;

        private StringBuilder checkNameAndAppend(String s)
        {
            Preconditions.checkNotNull(s);
            return maybeAppendSeparator().append(s).append('=');
        }

        private StringBuilder maybeAppendSeparator()
        {
            if (needsSeparator)
            {
                return builder.append(", ");
            } else
            {
                needsSeparator = true;
                return builder;
            }
        }

        public ToStringHelper add(String s, int i)
        {
            checkNameAndAppend(s).append(i);
            return this;
        }

        public ToStringHelper add(String s, long l)
        {
            checkNameAndAppend(s).append(l);
            return this;
        }

        public ToStringHelper add(String s, Object obj)
        {
            checkNameAndAppend(s).append(obj);
            return this;
        }

        public ToStringHelper addValue(Object obj)
        {
            maybeAppendSeparator().append(obj);
            return this;
        }

        public String toString()
        {
            String s = builder.append('}').toString();
            builder.setLength(builder.length() - 1);
            return s;
            Exception exception;
            exception;
            builder.setLength(builder.length() - 1);
            throw exception;
        }

        private ToStringHelper(String s)
        {
            needsSeparator = false;
            Preconditions.checkNotNull(s);
            builder = (new StringBuilder(32)).append(s).append('{');
        }

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

    public static ToStringHelper toStringHelper(Object obj)
    {
        return new ToStringHelper(simpleName(obj.getClass()));
    }
}
