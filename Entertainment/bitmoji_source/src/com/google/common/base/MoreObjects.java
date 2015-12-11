// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.Arrays;

// Referenced classes of package com.google.common.base:
//            Preconditions

public final class MoreObjects
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

        private ToStringHelper addHolder(Object obj)
        {
            addHolder().value = obj;
            return this;
        }

        private ToStringHelper addHolder(String s, Object obj)
        {
            ValueHolder valueholder = addHolder();
            valueholder.value = obj;
            valueholder.name = (String)Preconditions.checkNotNull(s);
            return this;
        }

        public ToStringHelper add(String s, char c)
        {
            return addHolder(s, String.valueOf(c));
        }

        public ToStringHelper add(String s, double d)
        {
            return addHolder(s, String.valueOf(d));
        }

        public ToStringHelper add(String s, float f)
        {
            return addHolder(s, String.valueOf(f));
        }

        public ToStringHelper add(String s, int i)
        {
            return addHolder(s, String.valueOf(i));
        }

        public ToStringHelper add(String s, long l)
        {
            return addHolder(s, String.valueOf(l));
        }

        public ToStringHelper add(String s, Object obj)
        {
            return addHolder(s, obj);
        }

        public ToStringHelper add(String s, boolean flag)
        {
            return addHolder(s, String.valueOf(flag));
        }

        public ToStringHelper addValue(char c)
        {
            return addHolder(String.valueOf(c));
        }

        public ToStringHelper addValue(double d)
        {
            return addHolder(String.valueOf(d));
        }

        public ToStringHelper addValue(float f)
        {
            return addHolder(String.valueOf(f));
        }

        public ToStringHelper addValue(int i)
        {
            return addHolder(String.valueOf(i));
        }

        public ToStringHelper addValue(long l)
        {
            return addHolder(String.valueOf(l));
        }

        public ToStringHelper addValue(Object obj)
        {
            return addHolder(obj);
        }

        public ToStringHelper addValue(boolean flag)
        {
            return addHolder(String.valueOf(flag));
        }

        public ToStringHelper omitNullValues()
        {
            omitNullValues = true;
            return this;
        }

        public String toString()
        {
            boolean flag = omitNullValues;
            String s = "";
            StringBuilder stringbuilder = (new StringBuilder(32)).append(className).append('{');
            ValueHolder valueholder = holderHead.next;
            while (valueholder != null) 
            {
label0:
                {
                    Object obj = valueholder.value;
                    String s1;
                    if (flag)
                    {
                        s1 = s;
                        if (obj == null)
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
                    if (obj != null && obj.getClass().isArray())
                    {
                        s = Arrays.deepToString(new Object[] {
                            obj
                        });
                        stringbuilder.append(s.substring(1, s.length() - 1));
                    } else
                    {
                        stringbuilder.append(obj);
                    }
                }
                valueholder = valueholder.next;
                s = s1;
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


    private MoreObjects()
    {
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

    public static ToStringHelper toStringHelper(Class class1)
    {
        return new ToStringHelper(class1.getSimpleName());
    }

    public static ToStringHelper toStringHelper(Object obj)
    {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(String s)
    {
        return new ToStringHelper(s);
    }
}
