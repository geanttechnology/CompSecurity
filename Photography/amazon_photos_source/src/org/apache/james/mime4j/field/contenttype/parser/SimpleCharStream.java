// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field.contenttype.parser;

import java.io.IOException;
import java.io.Reader;

public class SimpleCharStream
{

    int available;
    protected int bufcolumn[];
    protected char buffer[];
    protected int bufline[];
    public int bufpos;
    int bufsize;
    protected int column;
    protected int inBuf;
    protected Reader inputStream;
    protected int line;
    protected int maxNextCharInd;
    protected boolean prevCharIsCR;
    protected boolean prevCharIsLF;
    protected int tabSize;
    int tokenBegin;

    public SimpleCharStream(Reader reader, int i, int j)
    {
        this(reader, i, j, 4096);
    }

    public SimpleCharStream(Reader reader, int i, int j, int k)
    {
        bufpos = -1;
        column = 0;
        line = 1;
        prevCharIsCR = false;
        prevCharIsLF = false;
        maxNextCharInd = 0;
        inBuf = 0;
        tabSize = 8;
        inputStream = reader;
        line = i;
        column = j - 1;
        bufsize = k;
        available = k;
        buffer = new char[k];
        bufline = new int[k];
        bufcolumn = new int[k];
    }

    public char BeginToken()
        throws IOException
    {
        tokenBegin = -1;
        char c = readChar();
        tokenBegin = bufpos;
        return c;
    }

    protected void ExpandBuff(boolean flag)
    {
        char ac[] = new char[bufsize + 2048];
        int ai[] = new int[bufsize + 2048];
        int ai1[] = new int[bufsize + 2048];
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        int j;
        try
        {
            System.arraycopy(buffer, tokenBegin, ac, 0, bufsize - tokenBegin);
            System.arraycopy(buffer, 0, ac, bufsize - tokenBegin, bufpos);
            buffer = ac;
            System.arraycopy(bufline, tokenBegin, ai, 0, bufsize - tokenBegin);
            System.arraycopy(bufline, 0, ai, bufsize - tokenBegin, bufpos);
            bufline = ai;
            System.arraycopy(bufcolumn, tokenBegin, ai1, 0, bufsize - tokenBegin);
            System.arraycopy(bufcolumn, 0, ai1, bufsize - tokenBegin, bufpos);
            bufcolumn = ai1;
            int i = bufpos + (bufsize - tokenBegin);
            bufpos = i;
            maxNextCharInd = i;
        }
        catch (Throwable throwable)
        {
            throw new Error(throwable.getMessage());
        }
        bufsize = bufsize + 2048;
        available = bufsize;
        tokenBegin = 0;
        return;
        System.arraycopy(buffer, tokenBegin, ac, 0, bufsize - tokenBegin);
        buffer = ac;
        System.arraycopy(bufline, tokenBegin, ai, 0, bufsize - tokenBegin);
        bufline = ai;
        System.arraycopy(bufcolumn, tokenBegin, ai1, 0, bufsize - tokenBegin);
        bufcolumn = ai1;
        j = bufpos - tokenBegin;
        bufpos = j;
        maxNextCharInd = j;
        break MISSING_BLOCK_LABEL_216;
    }

    protected void FillBuff()
        throws IOException
    {
        int i;
        if (maxNextCharInd == available)
        {
            if (available == bufsize)
            {
                if (tokenBegin > 2048)
                {
                    maxNextCharInd = 0;
                    bufpos = 0;
                    available = tokenBegin;
                } else
                if (tokenBegin < 0)
                {
                    maxNextCharInd = 0;
                    bufpos = 0;
                } else
                {
                    ExpandBuff(false);
                }
            } else
            if (available > tokenBegin)
            {
                available = bufsize;
            } else
            if (tokenBegin - available < 2048)
            {
                ExpandBuff(true);
            } else
            {
                available = tokenBegin;
            }
        }
        try
        {
            i = inputStream.read(buffer, maxNextCharInd, available - maxNextCharInd);
        }
        catch (IOException ioexception)
        {
            bufpos = bufpos - 1;
            backup(0);
            if (tokenBegin == -1)
            {
                tokenBegin = bufpos;
            }
            throw ioexception;
        }
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        inputStream.close();
        throw new IOException();
        maxNextCharInd = maxNextCharInd + i;
        return;
    }

    public String GetImage()
    {
        if (bufpos >= tokenBegin)
        {
            return new String(buffer, tokenBegin, (bufpos - tokenBegin) + 1);
        } else
        {
            return (new StringBuilder()).append(new String(buffer, tokenBegin, bufsize - tokenBegin)).append(new String(buffer, 0, bufpos + 1)).toString();
        }
    }

    public char[] GetSuffix(int i)
    {
        char ac[] = new char[i];
        if (bufpos + 1 >= i)
        {
            System.arraycopy(buffer, (bufpos - i) + 1, ac, 0, i);
            return ac;
        } else
        {
            System.arraycopy(buffer, bufsize - (i - bufpos - 1), ac, 0, i - bufpos - 1);
            System.arraycopy(buffer, 0, ac, i - bufpos - 1, bufpos + 1);
            return ac;
        }
    }

    protected void UpdateLineColumn(char c)
    {
        column = column + 1;
        if (prevCharIsLF)
        {
            prevCharIsLF = false;
            int i = line;
            column = 1;
            line = i + 1;
        } else
        if (prevCharIsCR)
        {
            prevCharIsCR = false;
            if (c == '\n')
            {
                prevCharIsLF = true;
            } else
            {
                int j = line;
                column = 1;
                line = j + 1;
            }
        }
        c;
        JVM INSTR tableswitch 9 13: default 76
    //                   9 165
    //                   10 157
    //                   11 76
    //                   12 76
    //                   13 149;
           goto _L1 _L2 _L3 _L1 _L1 _L4
_L1:
        bufline[bufpos] = line;
        bufcolumn[bufpos] = column;
        return;
_L4:
        prevCharIsCR = true;
        continue; /* Loop/switch isn't completed */
_L3:
        prevCharIsLF = true;
        continue; /* Loop/switch isn't completed */
_L2:
        column = column - 1;
        column = column + (tabSize - column % tabSize);
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void backup(int i)
    {
        inBuf = inBuf + i;
        i = bufpos - i;
        bufpos = i;
        if (i < 0)
        {
            bufpos = bufpos + bufsize;
        }
    }

    public int getBeginColumn()
    {
        return bufcolumn[tokenBegin];
    }

    public int getBeginLine()
    {
        return bufline[tokenBegin];
    }

    public int getEndColumn()
    {
        return bufcolumn[bufpos];
    }

    public int getEndLine()
    {
        return bufline[bufpos];
    }

    public char readChar()
        throws IOException
    {
        if (inBuf > 0)
        {
            inBuf = inBuf - 1;
            int i = bufpos + 1;
            bufpos = i;
            if (i == bufsize)
            {
                bufpos = 0;
            }
            return buffer[bufpos];
        }
        int j = bufpos + 1;
        bufpos = j;
        if (j >= maxNextCharInd)
        {
            FillBuff();
        }
        char c = buffer[bufpos];
        UpdateLineColumn(c);
        return c;
    }
}
