// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.g.ab;
import com.google.api.a.g.ac;
import com.google.api.a.g.b;
import com.google.api.a.g.f;
import com.google.api.a.g.h;
import com.google.api.a.g.k;
import com.google.api.a.g.l;
import com.google.api.a.g.w;
import com.google.api.a.g.z;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.api.a.d:
//            y, z

public final class m extends l
{
    private static final class a extends y
    {

        private final m e;
        private final b f;

        public final com.google.api.a.d.z a()
        {
            throw new UnsupportedOperationException();
        }

        public final void a(String s, String s1)
        {
            e.a(s, s1, f);
        }

        a(m m1, b b1)
        {
            e = m1;
            f = b1;
        }
    }

    private static final class b
    {

        final com.google.api.a.g.b a;
        final StringBuilder b;
        final f c;
        final List d;

        public b(m m1, StringBuilder stringbuilder)
        {
            Class class1 = m1.getClass();
            d = Arrays.asList(new Type[] {
                class1
            });
            c = f.a(class1, true);
            b = stringbuilder;
            a = new com.google.api.a.g.b(m1);
        }
    }


    private List accept;
    List acceptEncoding;
    private List age;
    public List authenticate;
    public List authorization;
    private List cacheControl;
    private List contentEncoding;
    public List contentLength;
    private List contentMD5;
    public List contentRange;
    List contentType;
    private List cookie;
    private List date;
    private List etag;
    private List expires;
    List ifMatch;
    List ifModifiedSince;
    List ifNoneMatch;
    List ifRange;
    List ifUnmodifiedSince;
    private List lastModified;
    private List location;
    private List mimeVersion;
    public List range;
    private List retryAfter;
    List userAgent;

    public m()
    {
        super(EnumSet.of(com.google.api.a.g.l.c.a));
        acceptEncoding = new ArrayList(Collections.singleton("gzip"));
    }

    private static Object a(Type type, List list, String s)
    {
        return h.a(h.a(list, type), s);
    }

    public static Object a(List list)
    {
        if (list == null)
        {
            return null;
        } else
        {
            return list.get(0);
        }
    }

    public static List a(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(obj);
            return arraylist;
        }
    }

    public static void a(m m1, Writer writer)
    {
        a(m1, null, null, null, null, writer);
    }

    static void a(m m1, StringBuilder stringbuilder, StringBuilder stringbuilder1, Logger logger, y y1)
    {
        a(m1, stringbuilder, stringbuilder1, logger, y1, null);
    }

    private static void a(m m1, StringBuilder stringbuilder, StringBuilder stringbuilder1, Logger logger, y y1, Writer writer)
    {
        HashSet hashset = new HashSet();
        Iterator iterator = m1.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)iterator.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            w.a(hashset.add(s), "multiple headers of the same name (headers are case insensitive): %s", new Object[] {
                s
            });
            obj = ((java.util.Map.Entry) (obj)).getValue();
            if (obj != null)
            {
                Object obj1 = m1.getClassInfo().a(s);
                if (obj1 != null)
                {
                    s = ((k) (obj1)).c;
                }
                obj1 = obj.getClass();
                if ((obj instanceof Iterable) || ((Class) (obj1)).isArray())
                {
                    obj = ac.a(obj).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        a(logger, stringbuilder, stringbuilder1, y1, s, ((Iterator) (obj)).next(), writer);
                    }
                } else
                {
                    a(logger, stringbuilder, stringbuilder1, y1, s, obj, writer);
                }
            }
        } while (true);
        if (writer != null)
        {
            writer.flush();
        }
    }

    private static void a(Logger logger, StringBuilder stringbuilder, StringBuilder stringbuilder1, y y1, String s, Object obj, Writer writer)
    {
        if (obj != null && !h.a(obj))
        {
            if (obj instanceof Enum)
            {
                obj = k.a((Enum)obj).c;
            } else
            {
                obj = obj.toString();
            }
            if (("Authorization".equalsIgnoreCase(s) || "Cookie".equalsIgnoreCase(s)) && (logger == null || !logger.isLoggable(Level.ALL)))
            {
                logger = "<Not Logged>";
            } else
            {
                logger = ((Logger) (obj));
            }
            if (stringbuilder != null)
            {
                stringbuilder.append(s).append(": ");
                stringbuilder.append(logger);
                stringbuilder.append(z.a);
            }
            if (stringbuilder1 != null)
            {
                stringbuilder1.append(" -H '").append(s).append(": ").append(logger).append("'");
            }
            if (y1 != null)
            {
                y1.a(s, ((String) (obj)));
            }
            if (writer != null)
            {
                writer.write(s);
                writer.write(": ");
                writer.write(((String) (obj)));
                writer.write("\r\n");
                return;
            }
        }
    }

    public final m a(Long long1)
    {
        contentLength = a(long1);
        return this;
    }

    public final m a(String s)
    {
        authorization = a(s);
        return this;
    }

    public final m a(String s, Object obj)
    {
        return (m)super.set(s, obj);
    }

    public final String a()
    {
        return (String)a(location);
    }

    public final void a(m m1)
    {
        try
        {
            b b1 = new b(this, null);
            a(m1, null, null, null, ((y) (new a(this, b1))));
            b1.a.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (m m1)
        {
            throw ab.a(m1);
        }
    }

    public final void a(com.google.api.a.d.z z1, StringBuilder stringbuilder)
    {
        clear();
        stringbuilder = new b(this, stringbuilder);
        int j = z1.g();
        for (int i = 0; i < j; i++)
        {
            a(z1.a(i), z1.b(i), ((b) (stringbuilder)));
        }

        ((b) (stringbuilder)).a.a();
    }

    final void a(String s, String s1, b b1)
    {
        Object obj = b1.d;
        Object obj1 = b1.c;
        com.google.api.a.g.b b2 = b1.a;
        b1 = b1.b;
        if (b1 != null)
        {
            String s2 = String.valueOf(String.valueOf(s));
            String s3 = String.valueOf(String.valueOf(s1));
            b1.append((new StringBuilder(s2.length() + 2 + s3.length())).append(s2).append(": ").append(s3).toString()).append(z.a);
        }
        obj1 = ((f) (obj1)).a(s);
        if (obj1 != null)
        {
            Type type = h.a(((List) (obj)), ((k) (obj1)).b.getGenericType());
            if (ac.a(type))
            {
                s = ac.a(((List) (obj)), ac.b(type));
                b2.a(((k) (obj1)).b, s, a(((Type) (s)), ((List) (obj)), s1));
                return;
            }
            if (ac.a(ac.a(((List) (obj)), type), java/lang/Iterable))
            {
                b1 = (Collection)((k) (obj1)).a(this);
                s = b1;
                if (b1 == null)
                {
                    s = h.b(type);
                    ((k) (obj1)).a(this, s);
                }
                if (type == java/lang/Object)
                {
                    b1 = null;
                } else
                {
                    b1 = ac.c(type);
                }
                s.add(a(((Type) (b1)), ((List) (obj)), s1));
                return;
            } else
            {
                ((k) (obj1)).a(this, a(type, ((List) (obj)), s1));
                return;
            }
        }
        obj = (ArrayList)get(s);
        b1 = ((b) (obj));
        if (obj == null)
        {
            b1 = new ArrayList();
            a(s, b1);
        }
        b1.add(s1);
    }

    public final m b(String s)
    {
        contentEncoding = a(s);
        return this;
    }

    public final m c(String s)
    {
        contentRange = a(s);
        return this;
    }

    public final volatile l clone()
    {
        return (m)super.clone();
    }

    public final volatile Object clone()
    {
        return (m)super.clone();
    }

    public final m d(String s)
    {
        contentType = a(s);
        return this;
    }

    public final m e(String s)
    {
        userAgent = a(s);
        return this;
    }

    public final l set(String s, Object obj)
    {
        return a(s, obj);
    }
}
