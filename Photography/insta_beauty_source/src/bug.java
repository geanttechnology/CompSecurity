// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;

class bug
    implements buj
{

    boolean a;
    final StringBuilder b;
    final buf c;

    bug(buf buf, StringBuilder stringbuilder)
    {
        c = buf;
        b = stringbuilder;
        super();
        a = true;
    }

    public void read(InputStream inputstream, int i)
    {
        if (a)
        {
            a = false;
        } else
        {
            b.append(", ");
        }
        b.append(i);
    }
}
