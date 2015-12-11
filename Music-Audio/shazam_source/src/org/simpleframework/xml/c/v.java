// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.c;

import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

// Referenced classes of package org.simpleframework.xml.c:
//            am, ab, ae, ai, 
//            j, al, z, r, 
//            w, i, ag, o, 
//            g

public final class v
{

    private static al a = am.a();

    public static ag a(Writer writer, i i)
    {
        i = new ab(writer, i);
        writer = new ae(i, ((ab) (i)).a);
        if (((ab) (i)).a.isEmpty())
        {
            i = ((ab) (i)).b;
            if (((j) (i)).e != null)
            {
                i.a(((j) (i)).e);
                i.a("\n");
            }
        }
        return writer;
    }

    public static o a(InputStream inputstream)
    {
        return a(a.a(inputstream));
    }

    public static o a(Reader reader)
    {
        return a(a.a(reader));
    }

    private static o a(g g)
    {
        Object obj = null;
        z z1 = new z(g);
        g = obj;
        if (z1.c.isEmpty())
        {
            o o = z1.a(null);
            g = o;
            if (o == null)
            {
                throw new w("Document has no root element");
            }
        }
        return g;
    }

}
