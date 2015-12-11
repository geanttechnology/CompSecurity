// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            hk, hv, ht, hw

public abstract class es
{

    public es()
    {
    }

    protected static Object a(a a1, Object obj)
    {
        Object obj1 = obj;
        if (a.a(a1) != null)
        {
            obj1 = a1.k.a(obj);
        }
        return obj1;
    }

    private static void a(StringBuilder stringbuilder, a a1, Object obj)
    {
        if (a1.a() == 11)
        {
            stringbuilder.append(((es)a1.g().cast(obj)).toString());
            return;
        }
        if (a1.a() == 7)
        {
            stringbuilder.append("\"");
            stringbuilder.append(hv.a((String)obj));
            stringbuilder.append("\"");
            return;
        } else
        {
            stringbuilder.append(obj);
            return;
        }
    }

    private static void a(StringBuilder stringbuilder, a a1, ArrayList arraylist)
    {
        stringbuilder.append("[");
        int i = 0;
        for (int j = arraylist.size(); i < j; i++)
        {
            if (i > 0)
            {
                stringbuilder.append(",");
            }
            Object obj = arraylist.get(i);
            if (obj != null)
            {
                a(stringbuilder, a1, obj);
            }
        }

        stringbuilder.append("]");
    }

    protected boolean a(a a1)
    {
        if (a1.c() == 11)
        {
            if (a1.d())
            {
                a1.e();
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            } else
            {
                a1.e();
                throw new UnsupportedOperationException("Concrete types not supported");
            }
        } else
        {
            a1.e();
            return d();
        }
    }

    protected Object b(a a1)
    {
        String s = a1.e();
        if (a1.g() != null)
        {
            a1.e();
            c();
            (new StringBuilder("Concrete field shouldn't be value object: ")).append(a1.e());
            a1.d();
            try
            {
                a1 = (new StringBuilder("get")).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
                a1 = ((a) (getClass().getMethod(a1, new Class[0]).invoke(this, new Object[0])));
            }
            // Misplaced declaration of an exception variable
            catch (a a1)
            {
                throw new RuntimeException(a1);
            }
            return a1;
        } else
        {
            a1.e();
            return c();
        }
    }

    public abstract HashMap b();

    protected abstract Object c();

    protected abstract boolean d();

    public String toString()
    {
        HashMap hashmap = b();
        StringBuilder stringbuilder = new StringBuilder(100);
        Iterator iterator = hashmap.keySet().iterator();
label0:
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                a a1 = (a)hashmap.get(s);
                if (a(a1))
                {
                    Object obj = a(a1, b(a1));
                    if (stringbuilder.length() == 0)
                    {
                        stringbuilder.append("{");
                    } else
                    {
                        stringbuilder.append(",");
                    }
                    stringbuilder.append("\"").append(s).append("\":");
                    if (obj == null)
                    {
                        stringbuilder.append("null");
                    } else
                    {
                        switch (a1.c())
                        {
                        default:
                            if (a1.b())
                            {
                                a(stringbuilder, a1, (ArrayList)obj);
                            } else
                            {
                                a(stringbuilder, a1, obj);
                            }
                            break;

                        case 8: // '\b'
                            stringbuilder.append("\"").append(ht.a((byte[])(byte[])obj)).append("\"");
                            break;

                        case 9: // '\t'
                            stringbuilder.append("\"").append(ht.b((byte[])(byte[])obj)).append("\"");
                            break;

                        case 10: // '\n'
                            hw.a(stringbuilder, (HashMap)obj);
                            break;
                        }
                        continue label0;
                    }
                }
            } while (true);
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("}");
            } else
            {
                stringbuilder.append("{}");
            }
            return stringbuilder.toString();
        } while (true);
    }

    private class a
        implements SafeParcelable
    {

        public static final hl CREATOR = new hl();
        final int a;
        protected final int b;
        protected final boolean c;
        protected final int d;
        protected final boolean e;
        protected final String f;
        protected final int g;
        protected final Class h;
        protected final String i;
        ev j;
        hk k;

        public static a a(String s)
        {
            return new a(7, true, 7, true, s, 3, null, null);
        }

        public static a a(String s, int l)
        {
            return new a(0, false, 0, false, s, l, null, null);
        }

        public static a a(String s, int l, hk hk1)
        {
            return new a(7, false, 0, false, s, l, null, hk1);
        }

        public static a a(String s, int l, Class class1)
        {
            return new a(11, false, 11, false, s, l, class1, null);
        }

        static hk a(a a1)
        {
            return a1.k;
        }

        public static a b(String s, int l)
        {
            return new a(4, false, 4, false, s, l, null, null);
        }

        public static a b(String s, int l, Class class1)
        {
            return new a(11, true, 11, true, s, l, class1, null);
        }

        public static a c(String s, int l)
        {
            return new a(6, false, 6, false, s, l, null, null);
        }

        public static a d(String s, int l)
        {
            return new a(7, false, 7, false, s, l, null, null);
        }

        public final int a()
        {
            return b;
        }

        public final boolean b()
        {
            return c;
        }

        public final int c()
        {
            return d;
        }

        public final boolean d()
        {
            return e;
        }

        public int describeContents()
        {
            return 0;
        }

        public final String e()
        {
            return f;
        }

        public final int f()
        {
            return g;
        }

        public final Class g()
        {
            return h;
        }

        final String h()
        {
            if (i == null)
            {
                return null;
            } else
            {
                return i;
            }
        }

        public final HashMap i()
        {
            ha.a(i);
            ha.a(j);
            return j.a(i);
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("Field\n");
            stringbuilder.append("            versionCode=").append(a).append('\n');
            stringbuilder.append("                 typeIn=").append(b).append('\n');
            stringbuilder.append("            typeInArray=").append(c).append('\n');
            stringbuilder.append("                typeOut=").append(d).append('\n');
            stringbuilder.append("           typeOutArray=").append(e).append('\n');
            stringbuilder.append("        outputFieldName=").append(f).append('\n');
            stringbuilder.append("      safeParcelFieldId=").append(g).append('\n');
            stringbuilder.append("       concreteTypeName=").append(h()).append('\n');
            if (h != null)
            {
                stringbuilder.append("     concreteType.class=").append(h.getCanonicalName()).append('\n');
            }
            StringBuilder stringbuilder1 = stringbuilder.append("          converterName=");
            String s;
            if (k == null)
            {
                s = "null";
            } else
            {
                s = k.getClass().getCanonicalName();
            }
            stringbuilder1.append(s).append('\n');
            return stringbuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int l)
        {
            hl.a(this, parcel, l);
        }


        a(int l, int i1, boolean flag, int j1, boolean flag1, String s, int k1, 
                String s1, en en1)
        {
            Object obj = null;
            super();
            a = l;
            b = i1;
            c = flag;
            d = j1;
            e = flag1;
            f = s;
            g = k1;
            if (s1 == null)
            {
                h = null;
                i = null;
            } else
            {
                h = com/google/android/gms/internal/ey;
                i = s1;
            }
            if (en1 == null)
            {
                s = obj;
            } else
            if (en1.b != null)
            {
                s = en1.b;
            } else
            {
                throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
            }
            k = s;
        }

        private a(int l, boolean flag, int i1, boolean flag1, String s, int j1, Class class1, 
                hk hk1)
        {
            a = 1;
            b = l;
            c = flag;
            d = i1;
            e = flag1;
            f = s;
            g = j1;
            h = class1;
            if (class1 == null)
            {
                i = null;
            } else
            {
                i = class1.getCanonicalName();
            }
            k = hk1;
        }
    }

}
