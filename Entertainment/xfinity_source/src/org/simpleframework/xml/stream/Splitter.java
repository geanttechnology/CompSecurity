// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


abstract class Splitter
{

    protected StringBuilder builder;
    protected int count;
    protected int off;
    protected char text[];

    public Splitter(String s)
    {
        builder = new StringBuilder();
        text = s.toCharArray();
        count = text.length;
    }

    private boolean acronym()
    {
        int i = off;
        int j = 0;
        for (; i < count && isUpper(text[i]); i++)
        {
            j++;
        }

        if (j > 1)
        {
            int k = i;
            if (i < count)
            {
                k = i;
                if (isUpper(text[i - 1]))
                {
                    k = i - 1;
                }
            }
            commit(text, off, k - off);
            off = k;
        }
        return j > 1;
    }

    private boolean isDigit(char c)
    {
        return Character.isDigit(c);
    }

    private boolean isLetter(char c)
    {
        return Character.isLetter(c);
    }

    private boolean isSpecial(char c)
    {
        return !Character.isLetterOrDigit(c);
    }

    private boolean isUpper(char c)
    {
        return Character.isUpperCase(c);
    }

    private boolean number()
    {
        int i = off;
        int j = 0;
        for (; i < count && isDigit(text[i]); i++)
        {
            j++;
        }

        if (j > 0)
        {
            commit(text, off, i - off);
        }
        off = i;
        return j > 0;
    }

    private void token()
    {
        int i = off;
        do
        {
            char c;
            if (i < count)
            {
                c = text[i];
                break MISSING_BLOCK_LABEL_20;
            }
            do
            {
                if (i > off)
                {
                    parse(text, off, i - off);
                    commit(text, off, i - off);
                }
                off = i;
                return;
            } while (!isLetter(c) || i > off && isUpper(c));
            i++;
        } while (true);
    }

    protected abstract void commit(char ac[], int i, int j);

    protected abstract void parse(char ac[], int i, int j);

    public String process()
    {
label0:
        do
        {
            if (off < count)
            {
                do
                {
                    if (off >= count || !isSpecial(text[off]))
                    {
                        if (!acronym())
                        {
                            token();
                            number();
                        }
                        continue label0;
                    }
                    off = off + 1;
                } while (true);
            }
            return builder.toString();
        } while (true);
    }

    protected char toLower(char c)
    {
        return Character.toLowerCase(c);
    }

    protected char toUpper(char c)
    {
        return Character.toUpperCase(c);
    }
}
