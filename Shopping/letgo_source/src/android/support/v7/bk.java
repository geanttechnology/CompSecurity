// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            be, bl, bm

public class bk
{
    static interface a
    {

        public abstract Object a(bk bk1);
    }

    static class b extends d
    {

        public Object a(bk bk1)
        {
            return bl.a(new bl.a(this, bk1) {

                final bk a;
                final b b;

                public Object a(int i)
                {
                    be be1 = a.a(i);
                    if (be1 == null)
                    {
                        return null;
                    } else
                    {
                        return be1.a();
                    }
                }

                public List a(String s, int i)
                {
                    s = a.a(s, i);
                    ArrayList arraylist = new ArrayList();
                    int j = s.size();
                    for (i = 0; i < j; i++)
                    {
                        arraylist.add(((be)s.get(i)).a());
                    }

                    return arraylist;
                }

                public boolean a(int i, int j, Bundle bundle)
                {
                    return a.a(i, j, bundle);
                }

            
            {
                b = b1;
                a = bk1;
                super();
            }
            });
        }

        b()
        {
        }
    }

    static class c extends d
    {

        public Object a(bk bk1)
        {
            return bm.a(new bm.a(this, bk1) {

                final bk a;
                final c b;

                public Object a(int i)
                {
                    be be1 = a.a(i);
                    if (be1 == null)
                    {
                        return null;
                    } else
                    {
                        return be1.a();
                    }
                }

                public List a(String s, int i)
                {
                    s = a.a(s, i);
                    ArrayList arraylist = new ArrayList();
                    int j = s.size();
                    for (i = 0; i < j; i++)
                    {
                        arraylist.add(((be)s.get(i)).a());
                    }

                    return arraylist;
                }

                public boolean a(int i, int j, Bundle bundle)
                {
                    return a.a(i, j, bundle);
                }

                public Object b(int i)
                {
                    be be1 = a.b(i);
                    if (be1 == null)
                    {
                        return null;
                    } else
                    {
                        return be1.a();
                    }
                }

            
            {
                b = c1;
                a = bk1;
                super();
            }
            });
        }

        c()
        {
        }
    }

    static class d
        implements a
    {

        public Object a(bk bk1)
        {
            return null;
        }

        d()
        {
        }
    }


    private static final a a;
    private final Object b;

    public bk()
    {
        b = a.a(this);
    }

    public bk(Object obj)
    {
        b = obj;
    }

    public be a(int i)
    {
        return null;
    }

    public Object a()
    {
        return b;
    }

    public List a(String s, int i)
    {
        return null;
    }

    public boolean a(int i, int j, Bundle bundle)
    {
        return false;
    }

    public be b(int i)
    {
        return null;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new c();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new b();
        } else
        {
            a = new d();
        }
    }
}
