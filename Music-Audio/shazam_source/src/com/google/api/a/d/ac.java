// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.a.a;
import com.google.api.a.g.h;
import com.google.api.a.g.k;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.api.a.d:
//            a, ad

public final class ac extends com.google.api.a.d.a
{

    public Object b;

    public ac(Object obj)
    {
        super(com.google.api.a.d.ad.a);
        b = c.a(obj);
    }

    private static boolean a(boolean flag, Writer writer, String s, Object obj)
    {
        boolean flag1 = flag;
        if (obj != null)
        {
            if (h.a(obj))
            {
                flag1 = flag;
            } else
            {
                if (flag)
                {
                    flag = false;
                } else
                {
                    writer.write("&");
                }
                writer.write(s);
                if (obj instanceof Enum)
                {
                    s = k.a((Enum)obj).c;
                } else
                {
                    s = obj.toString();
                }
                s = com.google.api.a.g.a.a.a(s);
                flag1 = flag;
                if (s.length() != 0)
                {
                    writer.write("=");
                    writer.write(s);
                    return flag;
                }
            }
        }
        return flag1;
    }

    public final void a(OutputStream outputstream)
    {
        outputstream = new BufferedWriter(new OutputStreamWriter(outputstream, b()));
        Iterator iterator = h.b(b).entrySet().iterator();
        boolean flag = true;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = (java.util.Map.Entry)iterator.next();
            Object obj = ((java.util.Map.Entry) (obj1)).getValue();
            if (obj != null)
            {
                obj1 = com.google.api.a.g.a.a.a((String)((java.util.Map.Entry) (obj1)).getKey());
                Class class1 = obj.getClass();
                if ((obj instanceof Iterable) || class1.isArray())
                {
                    obj = com.google.api.a.g.ac.a(obj).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        flag = a(flag, ((Writer) (outputstream)), ((String) (obj1)), ((Iterator) (obj)).next());
                    }
                } else
                {
                    flag = a(flag, ((Writer) (outputstream)), ((String) (obj1)), obj);
                }
            }
        } while (true);
        outputstream.flush();
    }
}
