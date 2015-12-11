// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.a.b;
import org.simpleframework.xml.a.d;
import org.simpleframework.xml.b.e;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.c.o;
import org.simpleframework.xml.c.v;
import org.simpleframework.xml.d.z;
import org.simpleframework.xml.p;

// Referenced classes of package org.simpleframework.xml.core:
//            bc, ej, ea, es, 
//            eg, s, du

public final class de
    implements p
{

    private final ea a;
    private final org.simpleframework.xml.b.d b;
    private final ej c;
    private final i d;

    public de()
    {
        this(((Map) (new HashMap())));
    }

    private de(Map map)
    {
        this(((b) (new d(map))));
    }

    private de(b b1)
    {
        this(((org.simpleframework.xml.b.d) (new e())), b1);
    }

    private de(org.simpleframework.xml.b.d d1, b b1)
    {
        this(d1, b1, new i());
    }

    private de(org.simpleframework.xml.b.d d1, b b1, i j)
    {
        this(d1, b1, ((z) (new bc())), j);
    }

    private de(org.simpleframework.xml.b.d d1, b b1, z z, i j)
    {
        c = new ej(b1, z, j);
        a = new ea();
        b = d1;
        d = j;
    }

    private Object a(Class class1, Reader reader, boolean flag)
    {
        return a(class1, v.a(reader), flag);
    }

    private Object a(Class class1, o o, boolean flag)
    {
        dz dz = a.a(flag);
        class1 = ((Class) ((new es(new eg(b, c, dz))).a(o, class1)));
        a.a();
        return class1;
        class1;
        a.a();
        throw class1;
    }

    private Object a(Object obj, o o)
    {
        Object obj1 = a.a(false);
        obj1 = new es(new eg(b, c, ((dz) (obj1))));
        Class class1 = obj.getClass();
        obj = ((es) (obj1)).a(class1, ((es) (obj1)).a(class1).a(o, obj));
        a.a();
        return obj;
        obj;
        a.a();
        throw obj;
    }

    public final Object a(Class class1, InputStream inputstream)
    {
        return a(class1, v.a(inputstream), false);
    }

    public final Object a(Class class1, Reader reader)
    {
        return a(class1, reader, true);
    }

    public final Object a(Class class1, String s1)
    {
        return a(class1, ((Reader) (new StringReader(s1))), false);
    }

    public final Object a(Object obj, String s1)
    {
        return a(obj, v.a(new StringReader(s1)));
    }

    public final void a(Object obj, OutputStream outputstream)
    {
        a(obj, ((Writer) (new OutputStreamWriter(outputstream, "utf-8"))));
    }

    public final void a(Object obj, Writer writer)
    {
        Object obj1;
        writer = v.a(writer, d);
        obj1 = a.a(true);
        Class class1;
        Class class2;
        String s1;
        obj1 = new es(new eg(b, c, ((dz) (obj1))));
        class1 = obj.getClass();
        class2 = obj.getClass();
        s1 = ((es) (obj1)).b(class2);
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        throw new du("Root annotation required for %s", new Object[] {
            class2
        });
        obj;
        a.a();
        throw obj;
        ((es) (obj1)).a(writer, obj, class1, s1);
        a.a();
        return;
    }
}
