// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.b.a;

import java.io.Writer;

// Referenced classes of package android.support.b.a:
//            a

static final class  extends Writer
{

    private final StringBuilder a = new StringBuilder();

    private void a()
    {
        if (a.length() > 0)
        {
            a.delete(0, a.length());
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
                a.append(c);
            }
            k++;
        }
    }

    ()
    {
    }
}
