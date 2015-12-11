// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            es, ez, eg, ev, 
//            fe, fb, ff, fa

public class ey extends es
    implements SafeParcelable
{

    public static final ez CREATOR = new ez();
    private final int kg;
    private final String mClassName;
    private int qA;
    private int qB;
    private final ev qq;
    private final Parcel qy;
    private final int qz;

    ey(int i, Parcel parcel, ev ev1)
    {
        kg = i;
        qy = (Parcel)eg.f(parcel);
        qz = 2;
        qq = ev1;
        if (qq == null)
        {
            mClassName = null;
        } else
        {
            mClassName = qq.cz();
        }
        qA = 2;
    }

    private ey(SafeParcelable safeparcelable, ev ev1, String s)
    {
        kg = 1;
        qy = Parcel.obtain();
        safeparcelable.writeToParcel(qy, 0);
        qz = 1;
        qq = (ev)eg.f(ev1);
        mClassName = (String)eg.f(s);
        qA = 2;
    }

    public static ey a(es es1)
    {
        String s = es1.getClass().getCanonicalName();
        ev ev1 = b(es1);
        return new ey((SafeParcelable)es1, ev1, s);
    }

    private static void a(ev ev1, es es1)
    {
        Object obj = es1.getClass();
        if (!ev1.b(((Class) (obj))))
        {
            HashMap hashmap = es1.cj();
            ev1.a(((Class) (obj)), es1.cj());
            obj = hashmap.keySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                es1 = (es.a)hashmap.get((String)((Iterator) (obj)).next());
                Class class1 = es1.cr();
                if (class1 != null)
                {
                    try
                    {
                        a(ev1, (es)class1.newInstance());
                    }
                    // Misplaced declaration of an exception variable
                    catch (ev ev1)
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Could not instantiate an object of type ").append(es1.cr().getCanonicalName()).toString(), ev1);
                    }
                    // Misplaced declaration of an exception variable
                    catch (ev ev1)
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Could not access object of type ").append(es1.cr().getCanonicalName()).toString(), ev1);
                    }
                }
            } while (true);
        }
    }

    private void a(StringBuilder stringbuilder, int i, Object obj)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown type = ").append(i).toString());

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            stringbuilder.append(obj);
            return;

        case 7: // '\007'
            stringbuilder.append("\"").append(fe.aa(obj.toString())).append("\"");
            return;

        case 8: // '\b'
            stringbuilder.append("\"").append(com.google.android.gms.internal.fb.b((byte[])(byte[])obj)).append("\"");
            return;

        case 9: // '\t'
            stringbuilder.append("\"").append(fb.c((byte[])(byte[])obj));
            stringbuilder.append("\"");
            return;

        case 10: // '\n'
            com.google.android.gms.internal.ff.a(stringbuilder, (HashMap)obj);
            return;

        case 11: // '\013'
            throw new IllegalArgumentException("Method does not accept concrete type.");
        }
    }

    private void a(StringBuilder stringbuilder, es.a a1, Parcel parcel, int i)
    {
        switch (a1.ci())
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown field out type = ").append(a1.ci()).toString());

        case 0: // '\0'
            b(stringbuilder, a1, a(a1, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.a.g(parcel, i))));
            return;

        case 1: // '\001'
            b(stringbuilder, a1, a(a1, com.google.android.gms.common.internal.safeparcel.a.i(parcel, i)));
            return;

        case 2: // '\002'
            b(stringbuilder, a1, a(a1, Long.valueOf(com.google.android.gms.common.internal.safeparcel.a.h(parcel, i))));
            return;

        case 3: // '\003'
            b(stringbuilder, a1, a(a1, Float.valueOf(com.google.android.gms.common.internal.safeparcel.a.j(parcel, i))));
            return;

        case 4: // '\004'
            b(stringbuilder, a1, a(a1, Double.valueOf(com.google.android.gms.common.internal.safeparcel.a.k(parcel, i))));
            return;

        case 5: // '\005'
            b(stringbuilder, a1, a(a1, com.google.android.gms.common.internal.safeparcel.a.l(parcel, i)));
            return;

        case 6: // '\006'
            b(stringbuilder, a1, a(a1, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.a.c(parcel, i))));
            return;

        case 7: // '\007'
            b(stringbuilder, a1, a(a1, com.google.android.gms.common.internal.safeparcel.a.m(parcel, i)));
            return;

        case 8: // '\b'
        case 9: // '\t'
            b(stringbuilder, a1, a(a1, com.google.android.gms.common.internal.safeparcel.a.p(parcel, i)));
            return;

        case 10: // '\n'
            b(stringbuilder, a1, a(a1, c(com.google.android.gms.common.internal.safeparcel.a.o(parcel, i))));
            return;

        case 11: // '\013'
            throw new IllegalArgumentException("Method does not accept concrete type.");
        }
    }

    private void a(StringBuilder stringbuilder, String s, es.a a1, Parcel parcel, int i)
    {
        stringbuilder.append("\"").append(s).append("\":");
        if (a1.ct())
        {
            a(stringbuilder, a1, parcel, i);
            return;
        } else
        {
            b(stringbuilder, a1, parcel, i);
            return;
        }
    }

    private void a(StringBuilder stringbuilder, HashMap hashmap, Parcel parcel)
    {
        hashmap = c(hashmap);
        stringbuilder.append('{');
        int i = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        boolean flag = false;
        do
        {
            if (parcel.dataPosition() >= i)
            {
                break;
            }
            int j = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
            java.util.Map.Entry entry = (java.util.Map.Entry)hashmap.get(Integer.valueOf(com.google.android.gms.common.internal.safeparcel.a.M(j)));
            if (entry != null)
            {
                if (flag)
                {
                    stringbuilder.append(",");
                }
                a(stringbuilder, (String)entry.getKey(), (es.a)entry.getValue(), parcel, j);
                flag = true;
            }
        } while (true);
        if (parcel.dataPosition() != i)
        {
            throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(i).toString(), parcel);
        } else
        {
            stringbuilder.append('}');
            return;
        }
    }

    private static ev b(es es1)
    {
        ev ev1 = new ev(es1.getClass());
        a(ev1, es1);
        ev1.cx();
        ev1.cw();
        return ev1;
    }

    private void b(StringBuilder stringbuilder, es.a a1, Parcel parcel, int i)
    {
        if (!a1.co()) goto _L2; else goto _L1
_L1:
        stringbuilder.append("[");
        a1.ci();
        JVM INSTR tableswitch 0 11: default 80
    //                   0 91
    //                   1 110
    //                   2 123
    //                   3 136
    //                   4 149
    //                   5 162
    //                   6 175
    //                   7 188
    //                   8 201
    //                   9 201
    //                   10 201
    //                   11 212;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L12 _L12 _L13
_L3:
        throw new IllegalStateException("Unknown field type out.");
_L4:
        com.google.android.gms.internal.fa.a(stringbuilder, com.google.android.gms.common.internal.safeparcel.a.r(parcel, i));
_L14:
        stringbuilder.append("]");
        return;
_L5:
        com.google.android.gms.internal.fa.a(stringbuilder, com.google.android.gms.common.internal.safeparcel.a.t(parcel, i));
        continue; /* Loop/switch isn't completed */
_L6:
        com.google.android.gms.internal.fa.a(stringbuilder, com.google.android.gms.common.internal.safeparcel.a.s(parcel, i));
        continue; /* Loop/switch isn't completed */
_L7:
        com.google.android.gms.internal.fa.a(stringbuilder, com.google.android.gms.common.internal.safeparcel.a.u(parcel, i));
        continue; /* Loop/switch isn't completed */
_L8:
        com.google.android.gms.internal.fa.a(stringbuilder, com.google.android.gms.common.internal.safeparcel.a.v(parcel, i));
        continue; /* Loop/switch isn't completed */
_L9:
        com.google.android.gms.internal.fa.a(stringbuilder, com.google.android.gms.common.internal.safeparcel.a.w(parcel, i));
        continue; /* Loop/switch isn't completed */
_L10:
        com.google.android.gms.internal.fa.a(stringbuilder, com.google.android.gms.common.internal.safeparcel.a.q(parcel, i));
        continue; /* Loop/switch isn't completed */
_L11:
        com.google.android.gms.internal.fa.a(stringbuilder, com.google.android.gms.common.internal.safeparcel.a.x(parcel, i));
        if (true) goto _L14; else goto _L12
_L12:
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
_L13:
        parcel = com.google.android.gms.common.internal.safeparcel.a.A(parcel, i);
        int j = parcel.length;
        i = 0;
        while (i < j) 
        {
            if (i > 0)
            {
                stringbuilder.append(",");
            }
            parcel[i].setDataPosition(0);
            a(stringbuilder, a1.cv(), parcel[i]);
            i++;
        }
        if (true) goto _L14; else goto _L2
_L2:
        switch (a1.ci())
        {
        default:
            throw new IllegalStateException("Unknown field type out");

        case 0: // '\0'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.g(parcel, i));
            return;

        case 1: // '\001'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.i(parcel, i));
            return;

        case 2: // '\002'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.h(parcel, i));
            return;

        case 3: // '\003'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.j(parcel, i));
            return;

        case 4: // '\004'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.k(parcel, i));
            return;

        case 5: // '\005'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.l(parcel, i));
            return;

        case 6: // '\006'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.c(parcel, i));
            return;

        case 7: // '\007'
            a1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i);
            stringbuilder.append("\"").append(fe.aa(a1)).append("\"");
            return;

        case 8: // '\b'
            a1 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, i);
            stringbuilder.append("\"").append(com.google.android.gms.internal.fb.b(a1)).append("\"");
            return;

        case 9: // '\t'
            a1 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, i);
            stringbuilder.append("\"").append(fb.c(a1));
            stringbuilder.append("\"");
            return;

        case 10: // '\n'
            a1 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, i);
            parcel = a1.keySet();
            parcel.size();
            stringbuilder.append("{");
            parcel = parcel.iterator();
            for (i = 1; parcel.hasNext(); i = 0)
            {
                String s = (String)parcel.next();
                if (i == 0)
                {
                    stringbuilder.append(",");
                }
                stringbuilder.append("\"").append(s).append("\"");
                stringbuilder.append(":");
                stringbuilder.append("\"").append(fe.aa(a1.getString(s))).append("\"");
            }

            stringbuilder.append("}");
            return;

        case 11: // '\013'
            parcel = com.google.android.gms.common.internal.safeparcel.a.z(parcel, i);
            parcel.setDataPosition(0);
            a(stringbuilder, a1.cv(), parcel);
            return;
        }
    }

    private void b(StringBuilder stringbuilder, es.a a1, Object obj)
    {
        if (a1.cn())
        {
            b(stringbuilder, a1, (ArrayList)obj);
            return;
        } else
        {
            a(stringbuilder, a1.ch(), obj);
            return;
        }
    }

    private void b(StringBuilder stringbuilder, es.a a1, ArrayList arraylist)
    {
        stringbuilder.append("[");
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            if (i != 0)
            {
                stringbuilder.append(",");
            }
            a(stringbuilder, a1.ch(), arraylist.get(i));
        }

        stringbuilder.append("]");
    }

    public static HashMap c(Bundle bundle)
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); hashmap.put(s, bundle.getString(s)))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }

    private static HashMap c(HashMap hashmap)
    {
        HashMap hashmap1 = new HashMap();
        java.util.Map.Entry entry;
        for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext(); hashmap1.put(Integer.valueOf(((es.a)entry.getValue()).cq()), entry))
        {
            entry = (java.util.Map.Entry)hashmap.next();
        }

        return hashmap1;
    }

    protected Object V(String s)
    {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean W(String s)
    {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Parcel cB()
    {
        qA;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 33
    //                   1 63;
           goto _L1 _L2 _L3
_L1:
        return qy;
_L2:
        qB = com.google.android.gms.common.internal.safeparcel.b.o(qy);
        com.google.android.gms.common.internal.safeparcel.b.D(qy, qB);
        qA = 2;
        continue; /* Loop/switch isn't completed */
_L3:
        com.google.android.gms.common.internal.safeparcel.b.D(qy, qB);
        qA = 2;
        if (true) goto _L1; else goto _L4
_L4:
    }

    ev cC()
    {
        switch (qz)
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Invalid creation type: ").append(qz).toString());

        case 0: // '\0'
            return null;

        case 1: // '\001'
            return qq;

        case 2: // '\002'
            return qq;
        }
    }

    public HashMap cj()
    {
        if (qq == null)
        {
            return null;
        } else
        {
            return qq.Z(mClassName);
        }
    }

    public int describeContents()
    {
        ez ez1 = CREATOR;
        return 0;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public String toString()
    {
        com.google.android.gms.internal.eg.b(qq, "Cannot convert to JSON on client side.");
        Parcel parcel = cB();
        parcel.setDataPosition(0);
        StringBuilder stringbuilder = new StringBuilder(100);
        a(stringbuilder, qq.Z(mClassName), parcel);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ez ez1 = CREATOR;
        com.google.android.gms.internal.ez.a(this, parcel, i);
    }

}
