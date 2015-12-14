// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Iterator;

// Referenced classes of package com.google.common.base:
//            Preconditions

public class Joiner
{
    public static final class MapJoiner
    {

        private final Joiner joiner;
        private final String keyValueSeparator;

        private MapJoiner(Joiner joiner1, String s)
        {
            joiner = joiner1;
            keyValueSeparator = (String)Preconditions.checkNotNull(s);
        }

    }


    private final String separator;

    private Joiner(Joiner joiner)
    {
        separator = joiner.separator;
    }


    private Joiner(String s)
    {
        separator = (String)Preconditions.checkNotNull(s);
    }

    private static Iterable iterable(Object obj, Object obj1, Object aobj[])
    {
        Preconditions.checkNotNull(((Object) (aobj)));
        return new AbstractList(aobj, obj, obj1) {

            final Object val$first;
            final Object val$rest[];
            final Object val$second;

            public Object get(int i)
            {
                switch (i)
                {
                default:
                    return rest[i - 2];

                case 0: // '\0'
                    return first;

                case 1: // '\001'
                    return second;
                }
            }

            public int size()
            {
                return rest.length + 2;
            }

            
            {
                rest = aobj;
                first = obj;
                second = obj1;
                super();
            }
        };
    }

    public static Joiner on(String s)
    {
        return new Joiner(s);
    }

    public Appendable appendTo(Appendable appendable, Iterator iterator)
        throws IOException
    {
        Preconditions.checkNotNull(appendable);
        if (iterator.hasNext())
        {
            appendable.append(toString(iterator.next()));
            for (; iterator.hasNext(); appendable.append(toString(iterator.next())))
            {
                appendable.append(separator);
            }

        }
        return appendable;
    }

    public final StringBuilder appendTo(StringBuilder stringbuilder, Iterator iterator)
    {
        try
        {
            appendTo(((Appendable) (stringbuilder)), iterator);
        }
        // Misplaced declaration of an exception variable
        catch (StringBuilder stringbuilder)
        {
            throw new AssertionError(stringbuilder);
        }
        return stringbuilder;
    }

    public final String join(Iterable iterable1)
    {
        return join(iterable1.iterator());
    }

    public final transient String join(Object obj, Object obj1, Object aobj[])
    {
        return join(iterable(obj, obj1, aobj));
    }

    public final String join(Iterator iterator)
    {
        return appendTo(new StringBuilder(), iterator).toString();
    }

    CharSequence toString(Object obj)
    {
        Preconditions.checkNotNull(obj);
        if (obj instanceof CharSequence)
        {
            return (CharSequence)obj;
        } else
        {
            return obj.toString();
        }
    }

    public Joiner useForNull(String s)
    {
        Preconditions.checkNotNull(s);
        return new Joiner(s) {

            final Joiner this$0;
            final String val$nullText;

            CharSequence toString(Object obj)
            {
                if (obj == null)
                {
                    return nullText;
                } else
                {
                    return Joiner.this.toString(obj);
                }
            }

            public Joiner useForNull(String s1)
            {
                Preconditions.checkNotNull(s1);
                throw new UnsupportedOperationException("already specified useForNull");
            }

            
            {
                this$0 = Joiner.this;
                nullText = s;
                super(final_joiner1, null);
            }
        };
    }

    public MapJoiner withKeyValueSeparator(String s)
    {
        return new MapJoiner(this, s);
    }
}
