// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.InputStream;

class cy
{

    char a[];
    int b;
    int c;

    cy(InputStream inputstream)
    {
        StringBuilder stringbuilder = new StringBuilder(inputstream.available());
        int i = inputstream.read();
        while (i != -1) 
        {
            if (i >= 32 && i <= 126 || i == 10)
            {
                stringbuilder.append((char)i);
            } else
            if ((i & 0x80) != 0)
            {
                if ((i & 0xe0) == 192)
                {
                    stringbuilder.append((char)((i & 0x1f) << 6 | inputstream.read() & 0x3f));
                } else
                {
                    stringbuilder.append((char)((i & 0xf) << 12 | (inputstream.read() & 0x3f) << 6 | inputstream.read() & 0x3f));
                }
            } else
            {
                stringbuilder.append(' ');
            }
            i = inputstream.read();
        }
        inputstream.close();
        c = stringbuilder.length();
        a = new char[c];
        stringbuilder.getChars(0, c, a, 0);
    }

    cy(String s)
    {
        c = s.length();
        StringBuilder stringbuilder = new StringBuilder(c);
        int i = 0;
        while (i < c) 
        {
            char c1 = s.charAt(i);
            if (c1 >= ' ' && c1 <= '~' || c1 == '\n')
            {
                stringbuilder.append(c1);
            } else
            if ((c1 & 0x80) != 0)
            {
                if ((c1 & 0xe0) == 192 && i + 1 < c)
                {
                    stringbuilder.append((char)((c1 & 0x1f) << 6 | s.charAt(i + 1) & 0x3f));
                    i++;
                } else
                if (i + 2 < c)
                {
                    stringbuilder.append((char)((c1 & 0xf) << 12 | (s.charAt(i + 1) & 0x3f) << 6 | s.charAt(i + 2) & 0x3f));
                    i += 2;
                } else
                {
                    stringbuilder.append('?');
                }
            } else
            {
                stringbuilder.append(' ');
            }
            i++;
        }
        c = stringbuilder.length();
        a = new char[c];
        stringbuilder.getChars(0, c, a, 0);
    }

    boolean a()
    {
        return b < c;
    }

    boolean a(char c1)
    {
        if (b == c || a[b] != c1)
        {
            return false;
        } else
        {
            b = b + 1;
            return true;
        }
    }

    char b()
    {
        if (b == c)
        {
            return '\0';
        } else
        {
            return a[b];
        }
    }

    char c()
    {
        char ac[] = a;
        int i = b;
        b = i + 1;
        return ac[i];
    }
}
