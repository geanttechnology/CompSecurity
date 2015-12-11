// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.IOException;
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

    private Joiner(String s)
    {
        separator = (String)Preconditions.checkNotNull(s);
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

    public MapJoiner withKeyValueSeparator(String s)
    {
        return new MapJoiner(this, s);
    }

    // Unreferenced inner class com/google/common/base/Joiner$1

/* anonymous class */
    class _cls1 extends Joiner
    {

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
    }

}
