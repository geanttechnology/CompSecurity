// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.c;
import com.google.a.a.d;
import com.google.a.a.f;
import com.google.a.a.g;
import com.google.a.a.h;
import com.google.a.a.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.a.c:
//            bk, k, bl, a, 
//            b, bj

public final class ap
{

    static final bl a = new bl() {

        public final boolean hasNext()
        {
            return false;
        }

        public final boolean hasPrevious()
        {
            return false;
        }

        public final Object next()
        {
            throw new NoSuchElementException();
        }

        public final int nextIndex()
        {
            return 0;
        }

        public final Object previous()
        {
            throw new NoSuchElementException();
        }

        public final int previousIndex()
        {
            return -1;
        }

    };
    private static final Iterator b = new Iterator() {

        public final boolean hasNext()
        {
            return false;
        }

        public final Object next()
        {
            throw new NoSuchElementException();
        }

        public final void remove()
        {
            g.b(false, "no calls to next() since the last call to remove()");
        }

    };

    public static bk a()
    {
        return a;
    }

    public static bk a(Object obj)
    {
        return new bk(obj) {

            boolean a;
            final Object b;

            public final boolean hasNext()
            {
                return !a;
            }

            public final Object next()
            {
                if (a)
                {
                    throw new NoSuchElementException();
                } else
                {
                    a = true;
                    return b;
                }
            }

            
            {
                b = obj;
                super();
            }
        };
    }

    public static bk a(Iterator iterator)
    {
        g.a(iterator);
        if (iterator instanceof bk)
        {
            return (bk)iterator;
        } else
        {
            return new bk(iterator) {

                final Iterator a;

                public final boolean hasNext()
                {
                    return a.hasNext();
                }

                public final Object next()
                {
                    return a.next();
                }

            
            {
                a = iterator;
                super();
            }
            };
        }
    }

    public static bk a(Iterator iterator, h h1)
    {
        g.a(iterator);
        g.a(h1);
        return new b(iterator, h1) {

            final Iterator b;
            final h c;

            protected final Object a()
            {
                while (b.hasNext()) 
                {
                    Object obj = b.next();
                    if (c.a(obj))
                    {
                        return obj;
                    }
                }
                super.a = com.google.a.c.b.a.c;
                return null;
            }

            
            {
                b = iterator;
                c = h1;
                super();
            }
        };
    }

    public static transient bk a(Object aobj[])
    {
        return a(aobj, 0, aobj.length, 0);
    }

    static bl a(Object aobj[], int j, int l, int i1)
    {
        boolean flag;
        if (l >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g.a(flag);
        g.a(j, j + l, aobj.length);
        g.b(i1, l);
        if (l == 0)
        {
            return a;
        } else
        {
            return new a(l, i1, aobj, j) {

                final Object a[];
                final int b;

                protected final Object a(int j1)
                {
                    return a[b + j1];
                }

            
            {
                a = aobj;
                b = i1;
                super(j, l);
            }
            };
        }
    }

    public static Iterator a(Iterator iterator, c c1)
    {
        g.a(c1);
        return new bj(iterator, c1) {

            final c a;

            final Object a(Object obj)
            {
                return a.a(obj);
            }

            
            {
                a = c1;
                super(iterator);
            }
        };
    }

    public static boolean a(Collection collection, Iterator iterator)
    {
        g.a(collection);
        g.a(iterator);
        boolean flag;
        for (flag = false; iterator.hasNext(); flag |= collection.add(iterator.next())) { }
        return flag;
    }

    public static boolean a(Iterator iterator, Object obj)
    {
        int j;
        boolean flag;
        flag = false;
        obj = i.a(obj);
        g.a(obj, "predicate");
        j = 0;
_L3:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_56;
        }
        if (!((h) (obj)).a(iterator.next())) goto _L2; else goto _L1
_L1:
        if (j != -1)
        {
            flag = true;
        }
        return flag;
_L2:
        j++;
          goto _L3
        j = -1;
          goto _L1
    }

    public static boolean a(Iterator iterator, Collection collection)
    {
        collection = i.a(collection);
        g.a(collection);
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (collection.a(iterator.next()))
            {
                iterator.remove();
                flag = true;
            }
        } while (true);
        return flag;
    }

    public static boolean a(Iterator iterator, Iterator iterator1)
    {
        do
        {
            if (iterator.hasNext())
            {
                if (iterator1.hasNext())
                {
                    continue;
                }
            } else
            if (!iterator1.hasNext())
            {
                return true;
            }
            return false;
        } while (f.a(iterator.next(), iterator1.next()));
        return false;
    }

    public static String b(Iterator iterator)
    {
        return k.a.a(new StringBuilder("["), iterator).append(']').toString();
    }

    static Iterator b()
    {
        return b;
    }

    public static Object c(Iterator iterator)
    {
        Object obj = iterator.next();
        if (!iterator.hasNext())
        {
            return obj;
        }
        StringBuilder stringbuilder = new StringBuilder();
        obj = String.valueOf(String.valueOf(obj));
        stringbuilder.append((new StringBuilder(((String) (obj)).length() + 31)).append("expected one element but was: <").append(((String) (obj))).toString());
        for (int j = 0; j < 4 && iterator.hasNext(); j++)
        {
            String s = String.valueOf(String.valueOf(iterator.next()));
            stringbuilder.append((new StringBuilder(s.length() + 2)).append(", ").append(s).toString());
        }

        if (iterator.hasNext())
        {
            stringbuilder.append(", ...");
        }
        stringbuilder.append('>');
        throw new IllegalArgumentException(stringbuilder.toString());
    }

    public static Object d(Iterator iterator)
    {
        if (iterator.hasNext())
        {
            return iterator.next();
        } else
        {
            return null;
        }
    }

    static void e(Iterator iterator)
    {
        g.a(iterator);
        for (; iterator.hasNext(); iterator.remove())
        {
            iterator.next();
        }

    }

}
