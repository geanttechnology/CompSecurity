// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            fe, eg, fb, ff, 
//            et, ey, en, ev

public abstract class es
{
    public static class a
        implements SafeParcelable
    {

        public static final et CREATOR = new et();
        private final int kg;
        protected final int qi;
        protected final boolean qj;
        protected final int qk;
        protected final boolean ql;
        protected final String qm;
        protected final int qn;
        protected final Class qo;
        protected final String qp;
        private ev qq;
        private b qr;

        public static a a(String s, int i, b b1, boolean flag)
        {
            return new a(b1.ch(), flag, b1.ci(), false, s, i, null, b1);
        }

        public static a a(String s, int i, Class class1)
        {
            return new a(11, false, 11, false, s, i, class1, null);
        }

        public static a b(String s, int i, Class class1)
        {
            return new a(11, true, 11, true, s, i, class1, null);
        }

        static b c(a a1)
        {
            return a1.qr;
        }

        public static a d(String s, int i)
        {
            return new a(0, false, 0, false, s, i, null, null);
        }

        public static a e(String s, int i)
        {
            return new a(4, false, 4, false, s, i, null, null);
        }

        public static a f(String s, int i)
        {
            return new a(6, false, 6, false, s, i, null, null);
        }

        public static a g(String s, int i)
        {
            return new a(7, false, 7, false, s, i, null, null);
        }

        public static a h(String s, int i)
        {
            return new a(7, true, 7, true, s, i, null, null);
        }

        public void a(ev ev1)
        {
            qq = ev1;
        }

        public int ch()
        {
            return qi;
        }

        public int ci()
        {
            return qk;
        }

        public a cm()
        {
            return new a(kg, qi, qj, qk, ql, qm, qn, qp, cu());
        }

        public boolean cn()
        {
            return qj;
        }

        public boolean co()
        {
            return ql;
        }

        public String cp()
        {
            return qm;
        }

        public int cq()
        {
            return qn;
        }

        public Class cr()
        {
            return qo;
        }

        String cs()
        {
            if (qp == null)
            {
                return null;
            } else
            {
                return qp;
            }
        }

        public boolean ct()
        {
            return qr != null;
        }

        en cu()
        {
            if (qr == null)
            {
                return null;
            } else
            {
                return en.a(qr);
            }
        }

        public HashMap cv()
        {
            eg.f(qp);
            eg.f(qq);
            return qq.Z(qp);
        }

        public int describeContents()
        {
            et et1 = CREATOR;
            return 0;
        }

        public Object g(Object obj)
        {
            return qr.g(obj);
        }

        public int getVersionCode()
        {
            return kg;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("Field\n");
            stringbuilder.append("            versionCode=").append(kg).append('\n');
            stringbuilder.append("                 typeIn=").append(qi).append('\n');
            stringbuilder.append("            typeInArray=").append(qj).append('\n');
            stringbuilder.append("                typeOut=").append(qk).append('\n');
            stringbuilder.append("           typeOutArray=").append(ql).append('\n');
            stringbuilder.append("        outputFieldName=").append(qm).append('\n');
            stringbuilder.append("      safeParcelFieldId=").append(qn).append('\n');
            stringbuilder.append("       concreteTypeName=").append(cs()).append('\n');
            if (cr() != null)
            {
                stringbuilder.append("     concreteType.class=").append(cr().getCanonicalName()).append('\n');
            }
            StringBuilder stringbuilder1 = stringbuilder.append("          converterName=");
            String s;
            if (qr == null)
            {
                s = "null";
            } else
            {
                s = qr.getClass().getCanonicalName();
            }
            stringbuilder1.append(s).append('\n');
            return stringbuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            et et1 = CREATOR;
            et.a(this, parcel, i);
        }


        a(int i, int j, boolean flag, int k, boolean flag1, String s, int l, 
                String s1, en en1)
        {
            kg = i;
            qi = j;
            qj = flag;
            qk = k;
            ql = flag1;
            qm = s;
            qn = l;
            if (s1 == null)
            {
                qo = null;
                qp = null;
            } else
            {
                qo = com/google/android/gms/internal/ey;
                qp = s1;
            }
            if (en1 == null)
            {
                qr = null;
                return;
            } else
            {
                qr = en1.cf();
                return;
            }
        }

        protected a(int i, boolean flag, int j, boolean flag1, String s, int k, Class class1, 
                b b1)
        {
            kg = 1;
            qi = i;
            qj = flag;
            qk = j;
            ql = flag1;
            qm = s;
            qn = k;
            qo = class1;
            if (class1 == null)
            {
                qp = null;
            } else
            {
                qp = class1.getCanonicalName();
            }
            qr = b1;
        }
    }

    public static interface b
    {

        public abstract int ch();

        public abstract int ci();

        public abstract Object g(Object obj);
    }


    public es()
    {
    }

    private void a(StringBuilder stringbuilder, a a1, Object obj)
    {
        if (a1.ch() == 11)
        {
            stringbuilder.append(((es)a1.cr().cast(obj)).toString());
            return;
        }
        if (a1.ch() == 7)
        {
            stringbuilder.append("\"");
            stringbuilder.append(fe.aa((String)obj));
            stringbuilder.append("\"");
            return;
        } else
        {
            stringbuilder.append(obj);
            return;
        }
    }

    private void a(StringBuilder stringbuilder, a a1, ArrayList arraylist)
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

    protected abstract Object V(String s);

    protected abstract boolean W(String s);

    protected boolean X(String s)
    {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean Y(String s)
    {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    protected Object a(a a1, Object obj)
    {
        Object obj1 = obj;
        if (a.c(a1) != null)
        {
            obj1 = a1.g(obj);
        }
        return obj1;
    }

    protected boolean a(a a1)
    {
        if (a1.ci() == 11)
        {
            if (a1.co())
            {
                return Y(a1.cp());
            } else
            {
                return X(a1.cp());
            }
        } else
        {
            return W(a1.cp());
        }
    }

    protected Object b(a a1)
    {
        boolean flag = true;
        String s = a1.cp();
        if (a1.cr() != null)
        {
            if (V(a1.cp()) != null)
            {
                flag = false;
            }
            eg.a(flag, (new StringBuilder()).append("Concrete field shouldn't be value object: ").append(a1.cp()).toString());
            if (a1.co())
            {
                a1 = cl();
            } else
            {
                a1 = ck();
            }
            if (a1 != null)
            {
                return a1.get(s);
            }
            try
            {
                a1 = (new StringBuilder()).append("get").append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
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
            return V(a1.cp());
        }
    }

    public abstract HashMap cj();

    public HashMap ck()
    {
        return null;
    }

    public HashMap cl()
    {
        return null;
    }

    public String toString()
    {
        HashMap hashmap = cj();
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
                        switch (a1.ci())
                        {
                        default:
                            if (a1.cn())
                            {
                                a(stringbuilder, a1, (ArrayList)obj);
                            } else
                            {
                                a(stringbuilder, a1, obj);
                            }
                            break;

                        case 8: // '\b'
                            stringbuilder.append("\"").append(fb.b((byte[])(byte[])obj)).append("\"");
                            break;

                        case 9: // '\t'
                            stringbuilder.append("\"").append(fb.c((byte[])(byte[])obj)).append("\"");
                            break;

                        case 10: // '\n'
                            ff.a(stringbuilder, (HashMap)obj);
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
}
