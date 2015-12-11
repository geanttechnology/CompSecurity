// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            amy

class a
    implements a
{

    boolean a;
    final StringBuilder b;
    final amy c;

    public void read(InputStream inputstream, int i)
        throws IOException
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

    (amy amy1, StringBuilder stringbuilder)
    {
        c = amy1;
        b = stringbuilder;
        super();
        a = true;
    }
}
