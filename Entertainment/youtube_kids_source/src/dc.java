// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Writer;

public final class dc extends Writer
{

    private final String a;
    private StringBuilder b;

    public dc(String s)
    {
        b = new StringBuilder(128);
        a = s;
    }

    private void a()
    {
        if (b.length() > 0)
        {
            Object obj = a;
            obj = b;
            b.delete(0, b.length());
        }
    }

    public final void close()
    {
        a();
    }

    public final void flush()
    {
        a();
    }

    public final void write(char ac[], int i, int j)
    {
        int k = 0;
        while (k < j) 
        {
            char c = ac[i + k];
            if (c == '\n')
            {
                a();
            } else
            {
                b.append(c);
            }
            k++;
        }
    }
}
