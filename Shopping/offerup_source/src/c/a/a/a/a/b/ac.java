// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;

import java.io.InputStream;

// Referenced classes of package c.a.a.a.a.b:
//            af, ab

final class ac
    implements af
{

    private boolean a;
    private StringBuilder b;

    ac(ab ab, StringBuilder stringbuilder)
    {
        b = stringbuilder;
        super();
        a = true;
    }

    public final void read(InputStream inputstream, int i)
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
