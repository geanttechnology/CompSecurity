// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            AbstractIterator, Splitter, CharMatcher

private static abstract class toSplit extends AbstractIterator
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

    protected (Splitter splitter, CharSequence charsequence)
    {
        offset = 0;
        trimmer = Splitter.access$200(splitter);
        omitEmptyStrings = Splitter.access$300(splitter);
        limit = Splitter.access$400(splitter);
        toSplit = charsequence;
    }
}
