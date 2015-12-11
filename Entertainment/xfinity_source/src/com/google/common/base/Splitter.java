// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.Iterator;

// Referenced classes of package com.google.common.base:
//            CharMatcher, Preconditions, AbstractIterator

public final class Splitter
{
    private static abstract class SplittingIterator extends AbstractIterator
    {

        int limit;
        int offset;
        final boolean omitEmptyStrings;
        final CharSequence toSplit;
        final CharMatcher trimmer;

        protected volatile Object computeNext()
        {
            return computeNext();
        }

        protected String computeNext()
        {
            while (offset != -1) 
            {
                int l = offset;
                int k = separatorStart(offset);
                int i;
                if (k == -1)
                {
                    i = toSplit.length();
                    offset = -1;
                } else
                {
                    i = k;
                    offset = separatorEnd(k);
                }
                do
                {
                    k = i;
                    if (l >= i)
                    {
                        break;
                    }
                    k = i;
                    if (!trimmer.matches(toSplit.charAt(l)))
                    {
                        break;
                    }
                    l++;
                } while (true);
                for (; k > l && trimmer.matches(toSplit.charAt(k - 1)); k--) { }
                if (!omitEmptyStrings || l != k)
                {
                    if (limit == 1)
                    {
                        int j = toSplit.length();
                        offset = -1;
                        do
                        {
                            k = j;
                            if (j <= l)
                            {
                                break;
                            }
                            k = j;
                            if (!trimmer.matches(toSplit.charAt(j - 1)))
                            {
                                break;
                            }
                            j--;
                        } while (true);
                    } else
                    {
                        limit = limit - 1;
                    }
                    return toSplit.subSequence(l, k).toString();
                }
            }
            return (String)endOfData();
        }

        abstract int separatorEnd(int i);

        abstract int separatorStart(int i);

        protected SplittingIterator(Splitter splitter, CharSequence charsequence)
        {
            offset = 0;
            trimmer = splitter.trimmer;
            omitEmptyStrings = splitter.omitEmptyStrings;
            limit = splitter.limit;
            toSplit = charsequence;
        }
    }

    private static interface Strategy
    {

        public abstract Iterator iterator(Splitter splitter, CharSequence charsequence);
    }


    private final int limit;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;
    private final CharMatcher trimmer;

    private Splitter(Strategy strategy1)
    {
        this(strategy1, false, CharMatcher.NONE, 0x7fffffff);
    }

    private Splitter(Strategy strategy1, boolean flag, CharMatcher charmatcher, int i)
    {
        strategy = strategy1;
        omitEmptyStrings = flag;
        trimmer = charmatcher;
        limit = i;
    }

    public static Splitter on(char c)
    {
        return on(CharMatcher.is(c));
    }

    public static Splitter on(CharMatcher charmatcher)
    {
        Preconditions.checkNotNull(charmatcher);
        return new Splitter(new Strategy(charmatcher) {

            final CharMatcher val$separatorMatcher;

            public SplittingIterator iterator(Splitter splitter, CharSequence charsequence)
            {
                return new SplittingIterator(splitter, charsequence) {

                    final _cls1 this$0;

                    int separatorEnd(int i)
                    {
                        return i + 1;
                    }

                    int separatorStart(int i)
                    {
                        return separatorMatcher.indexIn(toSplit, i);
                    }

            
            {
                this$0 = _cls1.this;
                super(splitter, charsequence);
            }
                };
            }

            public volatile Iterator iterator(Splitter splitter, CharSequence charsequence)
            {
                return iterator(splitter, charsequence);
            }

            
            {
                separatorMatcher = charmatcher;
                super();
            }
        });
    }

    private Iterator spliterator(CharSequence charsequence)
    {
        return strategy.iterator(this, charsequence);
    }

    public Iterable split(final CharSequence sequence)
    {
        Preconditions.checkNotNull(sequence);
        return new Iterable() {

            final Splitter this$0;
            final CharSequence val$sequence;

            public Iterator iterator()
            {
                return spliterator(sequence);
            }

            
            {
                this$0 = Splitter.this;
                sequence = charsequence;
                super();
            }
        };
    }




}
