// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.common.base:
//            Preconditions

public class Joiner
{
    public static final class MapJoiner
    {

        private final Joiner joiner;
        private final String keyValueSeparator;

        public Appendable appendTo(Appendable appendable, Iterator iterator)
            throws IOException
        {
            Preconditions.checkNotNull(appendable);
            if (iterator.hasNext())
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                appendable.append(joiner.toString(entry.getKey()));
                appendable.append(keyValueSeparator);
                appendable.append(joiner.toString(entry.getValue()));
                java.util.Map.Entry entry1;
                for (; iterator.hasNext(); appendable.append(joiner.toString(entry1.getValue())))
                {
                    appendable.append(joiner.separator);
                    entry1 = (java.util.Map.Entry)iterator.next();
                    appendable.append(joiner.toString(entry1.getKey()));
                    appendable.append(keyValueSeparator);
                }

            }
            return appendable;
        }

        public StringBuilder appendTo(StringBuilder stringbuilder, Iterable iterable)
        {
            return appendTo(stringbuilder, iterable.iterator());
        }

        public StringBuilder appendTo(StringBuilder stringbuilder, Iterator iterator)
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

        public StringBuilder appendTo(StringBuilder stringbuilder, Map map)
        {
            return appendTo(stringbuilder, ((Iterable) (map.entrySet())));
        }

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

    public static Joiner on(char c)
    {
        return new Joiner(String.valueOf(c));
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

    public final StringBuilder appendTo(StringBuilder stringbuilder, Iterable iterable)
    {
        return appendTo(stringbuilder, iterable.iterator());
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

    public final String join(Iterable iterable)
    {
        return join(iterable.iterator());
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
