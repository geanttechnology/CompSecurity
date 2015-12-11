// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            es, hp, ha, ev, 
//            hv, ht, hw, hs

public class ey extends es
    implements SafeParcelable
{

    public static final hp CREATOR = new hp();
    final int a;
    final int b = 2;
    final ev c;
    private final Parcel d;
    private final String e;
    private int f;
    private int g;

    ey(int i, Parcel parcel, ev ev1)
    {
        a = i;
        d = (Parcel)com.google.android.gms.internal.ha.a(parcel);
        c = ev1;
        if (c == null)
        {
            e = null;
        } else
        {
            e = c.c;
        }
        f = 2;
    }

    private static HashMap a(Bundle bundle)
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); hashmap.put(s, bundle.getString(s)))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }

    private static void a(StringBuilder stringbuilder, int i, Object obj)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Unknown type = ")).append(i).toString());

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
            stringbuilder.append("\"").append(com.google.android.gms.internal.hv.a(obj.toString())).append("\"");
            return;

        case 8: // '\b'
            stringbuilder.append("\"").append(com.google.android.gms.internal.ht.a((byte[])(byte[])obj)).append("\"");
            return;

        case 9: // '\t'
            stringbuilder.append("\"").append(com.google.android.gms.internal.ht.b((byte[])(byte[])obj));
            stringbuilder.append("\"");
            return;

        case 10: // '\n'
            com.google.android.gms.internal.hw.a(stringbuilder, (HashMap)obj);
            return;

        case 11: // '\013'
            throw new IllegalArgumentException("Method does not accept concrete type.");
        }
    }

    private void a(StringBuilder stringbuilder, es.a a1, Parcel parcel, int i)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        boolean flag;
        int k1;
        obj1 = null;
        obj2 = null;
        obj3 = null;
        obj4 = null;
        obj = null;
        k1 = 0;
        flag = false;
        if (!a1.d()) goto _L2; else goto _L1
_L1:
        stringbuilder.append("[");
        a1.c();
        JVM INSTR tableswitch 0 11: default 100
    //                   0 110
    //                   1 197
    //                   2 291
    //                   3 338
    //                   4 351
    //                   5 398
    //                   6 411
    //                   7 458
    //                   8 471
    //                   9 471
    //                   10 471
    //                   11 481;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L12 _L12 _L13
_L3:
        throw new IllegalStateException("Unknown field type out.");
_L4:
        i = com.google.android.gms.common.internal.safeparcel.a.a(parcel, i);
        k1 = parcel.dataPosition();
        if (i == 0)
        {
            a1 = obj;
        } else
        {
            a1 = parcel.createIntArray();
            parcel.setDataPosition(i + k1);
        }
        k1 = a1.length;
        i = ((flag) ? 1 : 0);
        do
        {
            if (i >= k1)
            {
                break; /* Loop/switch isn't completed */
            }
            if (i != 0)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append(Integer.toString(a1[i]));
            i++;
        } while (true);
_L5:
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel, i);
        int l1 = parcel.dataPosition();
        if (j == 0)
        {
            a1 = obj1;
        } else
        {
            int i2 = parcel.readInt();
            a1 = new BigInteger[i2];
            for (i = k1; i < i2; i++)
            {
                a1[i] = new BigInteger(parcel.createByteArray());
            }

            parcel.setDataPosition(j + l1);
        }
        com.google.android.gms.internal.hs.a(stringbuilder, a1);
_L14:
        stringbuilder.append("]");
        return;
_L6:
        i = com.google.android.gms.common.internal.safeparcel.a.a(parcel, i);
        int k = parcel.dataPosition();
        if (i == 0)
        {
            a1 = obj2;
        } else
        {
            a1 = parcel.createLongArray();
            parcel.setDataPosition(i + k);
        }
        com.google.android.gms.internal.hs.a(stringbuilder, a1);
        continue; /* Loop/switch isn't completed */
_L7:
        com.google.android.gms.internal.hs.a(stringbuilder, com.google.android.gms.common.internal.safeparcel.a.o(parcel, i));
        continue; /* Loop/switch isn't completed */
_L8:
        i = com.google.android.gms.common.internal.safeparcel.a.a(parcel, i);
        int l = parcel.dataPosition();
        if (i == 0)
        {
            a1 = obj3;
        } else
        {
            a1 = parcel.createDoubleArray();
            parcel.setDataPosition(i + l);
        }
        com.google.android.gms.internal.hs.a(stringbuilder, a1);
        continue; /* Loop/switch isn't completed */
_L9:
        com.google.android.gms.internal.hs.a(stringbuilder, com.google.android.gms.common.internal.safeparcel.a.p(parcel, i));
        continue; /* Loop/switch isn't completed */
_L10:
        i = com.google.android.gms.common.internal.safeparcel.a.a(parcel, i);
        int i1 = parcel.dataPosition();
        if (i == 0)
        {
            a1 = obj4;
        } else
        {
            a1 = parcel.createBooleanArray();
            parcel.setDataPosition(i + i1);
        }
        com.google.android.gms.internal.hs.a(stringbuilder, a1);
        continue; /* Loop/switch isn't completed */
_L11:
        com.google.android.gms.internal.hs.a(stringbuilder, com.google.android.gms.common.internal.safeparcel.a.q(parcel, i));
        if (true) goto _L14; else goto _L12
_L12:
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
_L13:
        parcel = com.google.android.gms.common.internal.safeparcel.a.t(parcel, i);
        int j1 = parcel.length;
        i = 0;
        while (i < j1) 
        {
            if (i > 0)
            {
                stringbuilder.append(",");
            }
            parcel[i].setDataPosition(0);
            a(stringbuilder, a1.i(), parcel[i]);
            i++;
        }
        if (true) goto _L14; else goto _L2
_L2:
        switch (a1.c())
        {
        default:
            throw new IllegalStateException("Unknown field type out");

        case 0: // '\0'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.e(parcel, i));
            return;

        case 1: // '\001'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.g(parcel, i));
            return;

        case 2: // '\002'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.f(parcel, i));
            return;

        case 3: // '\003'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.h(parcel, i));
            return;

        case 4: // '\004'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.i(parcel, i));
            return;

        case 5: // '\005'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.j(parcel, i));
            return;

        case 6: // '\006'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.a.c(parcel, i));
            return;

        case 7: // '\007'
            a1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i);
            stringbuilder.append("\"").append(com.google.android.gms.internal.hv.a(a1)).append("\"");
            return;

        case 8: // '\b'
            a1 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, i);
            stringbuilder.append("\"").append(com.google.android.gms.internal.ht.a(a1)).append("\"");
            return;

        case 9: // '\t'
            a1 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, i);
            stringbuilder.append("\"").append(com.google.android.gms.internal.ht.b(a1));
            stringbuilder.append("\"");
            return;

        case 10: // '\n'
            a1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i);
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
                stringbuilder.append("\"").append(com.google.android.gms.internal.hv.a(a1.getString(s))).append("\"");
            }

            stringbuilder.append("}");
            return;

        case 11: // '\013'
            parcel = com.google.android.gms.common.internal.safeparcel.a.s(parcel, i);
            parcel.setDataPosition(0);
            a(stringbuilder, a1.i(), parcel);
            return;
        }
    }

    private static void a(StringBuilder stringbuilder, es.a a1, Object obj)
    {
        if (a1.b())
        {
            obj = (ArrayList)obj;
            stringbuilder.append("[");
            int j = ((ArrayList) (obj)).size();
            for (int i = 0; i < j; i++)
            {
                if (i != 0)
                {
                    stringbuilder.append(",");
                }
                a(stringbuilder, a1.a(), ((ArrayList) (obj)).get(i));
            }

            stringbuilder.append("]");
            return;
        } else
        {
            a(stringbuilder, a1.a(), obj);
            return;
        }
    }

    private void a(StringBuilder stringbuilder, HashMap hashmap, Parcel parcel)
    {
        HashMap hashmap1;
        boolean flag;
        int i;
        hashmap1 = new HashMap();
        java.util.Map.Entry entry;
        for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext(); hashmap1.put(Integer.valueOf(((es.a)entry.getValue()).f()), entry))
        {
            entry = (java.util.Map.Entry)hashmap.next();
        }

        stringbuilder.append('{');
        i = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        flag = false;
_L14:
        Object obj;
        int j;
        do
        {
            if (parcel.dataPosition() >= i)
            {
                break MISSING_BLOCK_LABEL_535;
            }
            j = parcel.readInt();
            obj = (java.util.Map.Entry)hashmap1.get(Integer.valueOf(0xffff & j));
        } while (obj == null);
        if (flag)
        {
            stringbuilder.append(",");
        }
        hashmap = (String)((java.util.Map.Entry) (obj)).getKey();
        obj = (es.a)((java.util.Map.Entry) (obj)).getValue();
        stringbuilder.append("\"").append(hashmap).append("\":");
        if (((es.a) (obj)).k != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_522;
        }
        ((es.a) (obj)).c();
        JVM INSTR tableswitch 0 11: default 256
    //                   0 291
    //                   1 317
    //                   2 337
    //                   3 360
    //                   4 383
    //                   5 406
    //                   6 426
    //                   7 449
    //                   8 469
    //                   9 469
    //                   10 489
    //                   11 512;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L10 _L11 _L12
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown field out type = ")).append(((es.a) (obj)).c()).toString());
_L2:
        a(stringbuilder, ((es.a) (obj)), a(((es.a) (obj)), Integer.valueOf(com.google.android.gms.common.internal.safeparcel.a.e(parcel, j))));
_L15:
        flag = true;
        if (true) goto _L14; else goto _L13
_L13:
        a(stringbuilder, ((es.a) (obj)), a(((es.a) (obj)), com.google.android.gms.common.internal.safeparcel.a.g(parcel, j)));
          goto _L15
_L4:
        a(stringbuilder, ((es.a) (obj)), a(((es.a) (obj)), Long.valueOf(com.google.android.gms.common.internal.safeparcel.a.f(parcel, j))));
          goto _L15
_L5:
        a(stringbuilder, ((es.a) (obj)), a(((es.a) (obj)), Float.valueOf(com.google.android.gms.common.internal.safeparcel.a.h(parcel, j))));
          goto _L15
_L6:
        a(stringbuilder, ((es.a) (obj)), a(((es.a) (obj)), Double.valueOf(com.google.android.gms.common.internal.safeparcel.a.i(parcel, j))));
          goto _L15
_L7:
        a(stringbuilder, ((es.a) (obj)), a(((es.a) (obj)), com.google.android.gms.common.internal.safeparcel.a.j(parcel, j)));
          goto _L15
_L8:
        a(stringbuilder, ((es.a) (obj)), a(((es.a) (obj)), Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.a.c(parcel, j))));
          goto _L15
_L9:
        a(stringbuilder, ((es.a) (obj)), a(((es.a) (obj)), com.google.android.gms.common.internal.safeparcel.a.k(parcel, j)));
          goto _L15
_L10:
        a(stringbuilder, ((es.a) (obj)), a(((es.a) (obj)), com.google.android.gms.common.internal.safeparcel.a.n(parcel, j)));
          goto _L15
_L11:
        a(stringbuilder, ((es.a) (obj)), a(((es.a) (obj)), a(com.google.android.gms.common.internal.safeparcel.a.m(parcel, j))));
          goto _L15
_L12:
        throw new IllegalArgumentException("Method does not accept concrete type.");
        a(stringbuilder, ((es.a) (obj)), parcel, j);
          goto _L15
        if (parcel.dataPosition() != i)
        {
            throw new b((new StringBuilder("Overread allowed size end=")).append(i).toString(), parcel);
        } else
        {
            stringbuilder.append('}');
            return;
        }
    }

    public final Parcel a()
    {
        f;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 33
    //                   1 47;
           goto _L1 _L2 _L3
_L1:
        return d;
_L2:
        g = com.google.android.gms.common.internal.safeparcel.c.a(d, 20293);
_L3:
        com.google.android.gms.common.internal.safeparcel.c.b(d, g);
        f = 2;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final HashMap b()
    {
        if (c == null)
        {
            return null;
        } else
        {
            return c.a(e);
        }
    }

    protected final Object c()
    {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected final boolean d()
    {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        com.google.android.gms.internal.ha.a(c, "Cannot convert to JSON on client side.");
        Parcel parcel = a();
        parcel.setDataPosition(0);
        StringBuilder stringbuilder = new StringBuilder(100);
        a(stringbuilder, c.a(e), parcel);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.internal.hp.a(this, parcel, i);
    }

}
