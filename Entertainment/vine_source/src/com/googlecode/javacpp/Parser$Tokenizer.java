// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// Referenced classes of package com.googlecode.javacpp:
//            Parser

static class reader
    implements Closeable
{

    StringBuilder buffer;
    File file;
    int lastChar;
    int lineNumber;
    String lineSeparator;
    Reader reader;

    public void close()
        throws IOException
    {
        reader.close();
    }

    public reader nextToken()
        throws IOException
    {
        Object obj = new t>();
        int j = readChar();
        buffer.setLength(0);
        int i = j;
        if (Character.isWhitespace(j))
        {
            buffer.append((char)j);
            do
            {
                int k = readChar();
                i = k;
                if (k == -1)
                {
                    break;
                }
                i = k;
                if (!Character.isWhitespace(k))
                {
                    break;
                }
                buffer.append((char)k);
            } while (true);
        }
        obj. = file;
        obj.Number = lineNumber;
        obj.ing = buffer.toString();
        buffer.setLength(0);
        if (Character.isLetter(i) || i == 95)
        {
            obj. = 5;
            buffer.append((char)i);
            do
            {
                i = readChar();
                if (i == -1 || !Character.isDigit(i) && !Character.isLetter(i) && i != 95)
                {
                    break;
                }
                buffer.append((char)i);
            } while (true);
            obj.e = buffer.toString();
            lastChar = i;
        } else
        if (Character.isDigit(i) || i == 46 || i == 45 || i == 43)
        {
            int l;
            if (i == 46)
            {
                l = 2;
            } else
            {
                l = 1;
            }
            obj. = l;
            buffer.append((char)i);
            i = 0;
            do
            {
                l = readChar();
                if (l == -1 || !Character.isDigit(l) && l != 46 && l != 45 && l != 43 && (l < 97 || l > 102) && l != 108 && l != 117 && l != 120 && (l < 65 || l > 70) && l != 76 && l != 85 && l != 88)
                {
                    break;
                }
                if (l == 46)
                {
                    obj. = 2;
                }
                if (l != 117 && l != 85)
                {
                    buffer.append((char)l);
                }
                i = l;
            } while (true);
            if (i == 102 || i == 70)
            {
                obj. = 2;
            }
            obj.e = buffer.toString();
            if (((buffer) (obj)). == 1 && (() (obj)).e.endsWith("LL"))
            {
                obj.e = ((e) (obj)).e.substring(0, ((e) (obj)).e.length() - 1);
            }
            lastChar = l;
        } else
        if (i == 34)
        {
            obj. = 3;
            buffer.append('"');
            i = 0;
            do
            {
                int i1 = readChar();
                if (i1 == -1 || i != 92 && i1 == 34)
                {
                    break;
                }
                buffer.append((char)i1);
                i = i1;
            } while (true);
            buffer.append('"');
            obj.e = buffer.toString();
        } else
        if (i == 47)
        {
            i = readChar();
            if (i == 47)
            {
                obj. = 4;
                buffer.append('/').append('/');
                i = 0;
                int j1;
                do
                {
                    j1 = readChar();
                    if (j1 == -1 || i != 92 && j1 == 10)
                    {
                        break;
                    }
                    buffer.append((char)j1);
                    i = j1;
                } while (true);
                obj.e = buffer.toString();
                lastChar = j1;
            } else
            if (i == 42)
            {
                obj. = 4;
                buffer.append('/').append('*');
                i = 0;
                do
                {
                    int k1 = readChar();
                    if (k1 == -1 || i == 42 && k1 == 47)
                    {
                        break;
                    }
                    buffer.append((char)k1);
                    i = k1;
                } while (true);
                buffer.append('/');
                obj.e = buffer.toString();
            } else
            {
                lastChar = i;
                obj. = 47;
            }
        } else
        {
            if (i == 92)
            {
                int l1 = readChar();
                if (l1 == 10)
                {
                    obj = ((readChar) (obj)).ing;
                    reader reader1 = nextToken();
                    reader1.ing = ((String) (obj));
                    return reader1;
                }
                lastChar = l1;
            }
            obj. = i;
        }
        return (() (obj));
    }

    int readChar()
        throws IOException
    {
label0:
        {
            byte byte0 = -1;
            if (lastChar != -1)
            {
                int i = lastChar;
                lastChar = -1;
                return i;
            }
            int k = reader.read();
            int j;
            if (k != 13)
            {
                j = k;
                if (k != 10)
                {
                    break label0;
                }
            }
            lineNumber = lineNumber + 1;
            j = byte0;
            if (k == 13)
            {
                j = reader.read();
            }
            if (lineSeparator == null)
            {
                String s;
                if (k == 13 && j == 10)
                {
                    s = "\r\n";
                } else
                if (k == 13)
                {
                    s = "\r";
                } else
                {
                    s = "\n";
                }
                lineSeparator = s;
            }
            if (j != 10)
            {
                lastChar = j;
            }
            j = 10;
        }
        return j;
    }

    (File file1)
        throws FileNotFoundException
    {
        file = null;
        reader = null;
        lineSeparator = null;
        lastChar = -1;
        lineNumber = 1;
        buffer = new StringBuilder();
        file = file1;
        reader = new BufferedReader(new FileReader(file1));
    }

    reader(Reader reader1)
    {
        file = null;
        reader = null;
        lineSeparator = null;
        lastChar = -1;
        lineNumber = 1;
        buffer = new StringBuilder();
        reader = reader1;
    }
}
