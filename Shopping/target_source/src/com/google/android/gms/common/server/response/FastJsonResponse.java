// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.b.cy;
import com.google.android.gms.b.dg;
import com.google.android.gms.b.dh;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.server.response:
//            a, SafeParcelResponse, FieldMappingDictionary

public abstract class FastJsonResponse
{
    public static class Field
        implements SafeParcelable
    {

        public static final com.google.android.gms.common.server.response.a CREATOR = new com.google.android.gms.common.server.response.a();
        protected final int a;
        protected final boolean b;
        protected final int c;
        protected final boolean d;
        protected final String e;
        protected final int f;
        protected final Class g;
        protected final String h;
        private final int i;
        private FieldMappingDictionary j;
        private a k;

        static a a(Field field)
        {
            return field.k;
        }

        public int a()
        {
            return i;
        }

        public Object a(Object obj)
        {
            return k.a(obj);
        }

        public void a(FieldMappingDictionary fieldmappingdictionary)
        {
            j = fieldmappingdictionary;
        }

        public int b()
        {
            return a;
        }

        public boolean c()
        {
            return b;
        }

        public int d()
        {
            return c;
        }

        public int describeContents()
        {
            com.google.android.gms.common.server.response.a a1 = CREATOR;
            return 0;
        }

        public boolean e()
        {
            return d;
        }

        public String f()
        {
            return e;
        }

        public int g()
        {
            return f;
        }

        public Class h()
        {
            return g;
        }

        String i()
        {
            if (h == null)
            {
                return null;
            } else
            {
                return h;
            }
        }

        public boolean j()
        {
            return k != null;
        }

        ConverterWrapper k()
        {
            if (k == null)
            {
                return null;
            } else
            {
                return ConverterWrapper.a(k);
            }
        }

        public Map l()
        {
            u.a(h);
            u.a(j);
            return j.a(h);
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("Field\n");
            stringbuilder.append("            versionCode=").append(i).append('\n');
            stringbuilder.append("                 typeIn=").append(a).append('\n');
            stringbuilder.append("            typeInArray=").append(b).append('\n');
            stringbuilder.append("                typeOut=").append(c).append('\n');
            stringbuilder.append("           typeOutArray=").append(d).append('\n');
            stringbuilder.append("        outputFieldName=").append(e).append('\n');
            stringbuilder.append("      safeParcelFieldId=").append(f).append('\n');
            stringbuilder.append("       concreteTypeName=").append(i()).append('\n');
            if (h() != null)
            {
                stringbuilder.append("     concreteType.class=").append(h().getCanonicalName()).append('\n');
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

        public void writeToParcel(Parcel parcel, int i1)
        {
            com.google.android.gms.common.server.response.a a1 = CREATOR;
            com.google.android.gms.common.server.response.a.a(this, parcel, i1);
        }


        Field(int i1, int j1, boolean flag, int k1, boolean flag1, String s, int l1, 
                String s1, ConverterWrapper converterwrapper)
        {
            i = i1;
            a = j1;
            b = flag;
            c = k1;
            d = flag1;
            e = s;
            f = l1;
            if (s1 == null)
            {
                g = null;
                h = null;
            } else
            {
                g = com/google/android/gms/common/server/response/SafeParcelResponse;
                h = s1;
            }
            if (converterwrapper == null)
            {
                k = null;
                return;
            } else
            {
                k = converterwrapper.c();
                return;
            }
        }
    }

    public static interface a
    {

        public abstract Object a(Object obj);
    }


    public FastJsonResponse()
    {
    }

    private void a(StringBuilder stringbuilder, Field field, Object obj)
    {
        if (field.b() == 11)
        {
            stringbuilder.append(((FastJsonResponse)field.h().cast(obj)).toString());
            return;
        }
        if (field.b() == 7)
        {
            stringbuilder.append("\"");
            stringbuilder.append(dg.a((String)obj));
            stringbuilder.append("\"");
            return;
        } else
        {
            stringbuilder.append(obj);
            return;
        }
    }

    private void a(StringBuilder stringbuilder, Field field, ArrayList arraylist)
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
                a(stringbuilder, field, obj);
            }
        }

        stringbuilder.append("]");
    }

    protected Object a(Field field, Object obj)
    {
        Object obj1 = obj;
        if (Field.a(field) != null)
        {
            obj1 = field.a(obj);
        }
        return obj1;
    }

    protected abstract Object a(String s);

    public abstract Map a();

    protected boolean a(Field field)
    {
        if (field.d() == 11)
        {
            if (field.e())
            {
                return d(field.f());
            } else
            {
                return c(field.f());
            }
        } else
        {
            return b(field.f());
        }
    }

    protected Object b(Field field)
    {
        String s = field.f();
        if (field.h() != null)
        {
            boolean flag;
            if (a(field.f()) == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            u.a(flag, "Concrete field shouldn't be value object: %s", new Object[] {
                field.f()
            });
            if (field.e())
            {
                field = c();
            } else
            {
                field = b();
            }
            if (field != null)
            {
                return field.get(s);
            }
            try
            {
                field = (new StringBuilder()).append("get").append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
                field = ((Field) (getClass().getMethod(field, new Class[0]).invoke(this, new Object[0])));
            }
            // Misplaced declaration of an exception variable
            catch (Field field)
            {
                throw new RuntimeException(field);
            }
            return field;
        } else
        {
            return a(field.f());
        }
    }

    public HashMap b()
    {
        return null;
    }

    protected abstract boolean b(String s);

    public HashMap c()
    {
        return null;
    }

    protected boolean c(String s)
    {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean d(String s)
    {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public String toString()
    {
        Map map = a();
        StringBuilder stringbuilder = new StringBuilder(100);
        Iterator iterator = map.keySet().iterator();
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
                Field field = (Field)map.get(s);
                if (a(field))
                {
                    Object obj = a(field, b(field));
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
                        switch (field.d())
                        {
                        default:
                            if (field.c())
                            {
                                a(stringbuilder, field, (ArrayList)obj);
                            } else
                            {
                                a(stringbuilder, field, obj);
                            }
                            break;

                        case 8: // '\b'
                            stringbuilder.append("\"").append(cy.a((byte[])(byte[])obj)).append("\"");
                            break;

                        case 9: // '\t'
                            stringbuilder.append("\"").append(cy.b((byte[])(byte[])obj)).append("\"");
                            break;

                        case 10: // '\n'
                            dh.a(stringbuilder, (HashMap)obj);
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
