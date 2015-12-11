// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.Iterator;

// Referenced classes of package com.google.common.base:
//            CharMatcher, Preconditions, AbstractIterator, Joiner

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
            int j = offset;
            do
            {
                if (offset == -1)
                {
                    break;
                }
                int i = separatorStart(offset);
                if (i == -1)
                {
                    i = toSplit.length();
                    offset = -1;
                } else
                {
                    offset = separatorEnd(i);
                }
                if (offset == j)
                {
                    offset = offset + 1;
                    if (offset >= toSplit.length())
                    {
                        offset = -1;
                    }
                } else
                {
                    for (; j < i && trimmer.matches(toSplit.charAt(j)); j++) { }
                    for (; i > j && trimmer.matches(toSplit.charAt(i - 1)); i--) { }
                    if (omitEmptyStrings && j == i)
                    {
                        j = offset;
                    } else
                    {
                        int k;
                        if (limit == 1)
                        {
                            i = toSplit.length();
                            offset = -1;
                            do
                            {
                                k = i;
                                if (i <= j)
                                {
                                    break;
                                }
                                k = i;
                                if (!trimmer.matches(toSplit.charAt(i - 1)))
                                {
                                    break;
                                }
                                i--;
                            } while (true);
                        } else
                        {
                            limit = limit - 1;
                            k = i;
                        }
                        return toSplit.subSequence(j, k).toString();
                    }
                }
            } while (true);
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

    private Iterator splittingIterator(CharSequence charsequence)
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
                return splittingIterator(sequence);
            }

            public String toString()
            {
                return Joiner.on(", ").appendTo((new StringBuilder()).append('['), this).append(']').toString();
            }

            
            {
                this$0 = Splitter.this;
                sequence = charsequence;
                super();
            }
        };
    }




}
