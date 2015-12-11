// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.wearable.Asset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class agk
{

    private static int a(String s, ago aago[])
    {
        int i;
        int j;
        int l;
        l = aago.length;
        i = 0;
        j = 14;
_L5:
        ago ago1;
        if (i >= l)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        ago1 = aago[i];
        if (j != 14) goto _L2; else goto _L1
_L1:
        if (ago1.a != 9 && ago1.a != 2 && ago1.a != 6) goto _L4; else goto _L3
_L3:
        int k = ago1.a;
_L7:
        i++;
        j = k;
          goto _L5
_L4:
        k = j;
        if (ago1.a == 14) goto _L7; else goto _L6
_L6:
        throw new IllegalArgumentException((new StringBuilder()).append("Unexpected TypedValue type: ").append(ago1.a).append(" for key ").append(s).toString());
_L2:
        k = j;
        if (ago1.a == j) goto _L7; else goto _L8
_L8:
        throw new IllegalArgumentException((new StringBuilder()).append("The ArrayList elements should all be the same type, but ArrayList with key ").append(s).append(" contains items of type ").append(j).append(" and ").append(ago1.a).toString());
        return j;
    }

    static int a(List list, Asset asset)
    {
        list.add(asset);
        return list.size() - 1;
    }

    public static agl a(atz atz1)
    {
        agm agm1 = new agm();
        ArrayList arraylist = new ArrayList();
        agm1.a = a(atz1, ((List) (arraylist)));
        return new agl(agm1, arraylist);
    }

    private static ago a(List list, Object obj)
    {
        ago ago1;
        ago1 = new ago();
        if (obj == null)
        {
            ago1.a = 14;
            return ago1;
        }
        ago1.b = new agp();
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        ago1.a = 2;
        ago1.b.b = (String)obj;
_L8:
        return ago1;
_L2:
        ArrayList arraylist;
        ago aago[];
        int j;
        int k;
        int l;
        if (obj instanceof Integer)
        {
            ago1.a = 6;
            ago1.b.f = ((Integer)obj).intValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Long)
        {
            ago1.a = 5;
            ago1.b.e = ((Long)obj).longValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Double)
        {
            ago1.a = 3;
            ago1.b.c = ((Double)obj).doubleValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Float)
        {
            ago1.a = 4;
            ago1.b.d = ((Float)obj).floatValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Boolean)
        {
            ago1.a = 8;
            ago1.b.h = ((Boolean)obj).booleanValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Byte)
        {
            ago1.a = 7;
            ago1.b.g = ((Byte)obj).byteValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof byte[])
        {
            ago1.a = 1;
            ago1.b.a = (byte[])(byte[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof String[])
        {
            ago1.a = 11;
            ago1.b.k = (String[])(String[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof long[])
        {
            ago1.a = 12;
            ago1.b.l = (long[])(long[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof float[])
        {
            ago1.a = 15;
            ago1.b.m = (float[])(float[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Asset)
        {
            ago1.a = 13;
            ago1.b.n = a(list, (Asset)obj);
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof atz)
        {
            ago1.a = 9;
            obj = (atz)obj;
            Object obj2 = ((atz) (obj)).b();
            agn aagn[] = new agn[((Set) (obj2)).size()];
            obj2 = ((Set) (obj2)).iterator();
            for (int i = 0; ((Iterator) (obj2)).hasNext(); i++)
            {
                String s = (String)((Iterator) (obj2)).next();
                aagn[i] = new agn();
                aagn[i].a = s;
                aagn[i].b = a(list, ((atz) (obj)).b(s));
            }

            ago1.b.i = aagn;
            continue; /* Loop/switch isn't completed */
        }
        if (!(obj instanceof ArrayList))
        {
            break; /* Loop/switch isn't completed */
        }
        ago1.a = 10;
        arraylist = (ArrayList)obj;
        aago = new ago[arraylist.size()];
        obj = null;
        l = arraylist.size();
        k = 0;
        j = 14;
_L4:
        Object obj1;
        ago ago2;
        if (k >= l)
        {
            break MISSING_BLOCK_LABEL_740;
        }
        obj1 = arraylist.get(k);
        ago2 = a(list, obj1);
        if (ago2.a != 14 && ago2.a != 2 && ago2.a != 6 && ago2.a != 9)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a ").append(obj1.getClass()).toString());
        }
        if (j != 14 || ago2.a == 14)
        {
            break; /* Loop/switch isn't completed */
        }
        j = ago2.a;
        obj = obj1;
_L6:
        aago[k] = ago2;
        k++;
        if (true) goto _L4; else goto _L3
_L3:
        if (ago2.a == j) goto _L6; else goto _L5
_L5:
        throw new IllegalArgumentException((new StringBuilder()).append("ArrayList elements must all be of the sameclass, but this one contains a ").append(obj.getClass()).append(" and a ").append(obj1.getClass()).toString());
        ago1.b.j = aago;
        if (true) goto _L8; else goto _L7
_L7:
        throw new RuntimeException((new StringBuilder()).append("newFieldValueFromValue: unexpected value ").append(obj.getClass().getSimpleName()).toString());
    }

    public static atz a(agl agl1)
    {
        atz atz1 = new atz();
        agn aagn[] = agl1.a.a;
        int j = aagn.length;
        for (int i = 0; i < j; i++)
        {
            agn agn1 = aagn[i];
            a(agl1.b, atz1, agn1.a, agn1.b);
        }

        return atz1;
    }

    private static ArrayList a(List list, agp agp1, int i)
    {
        ArrayList arraylist = new ArrayList(agp1.j.length);
        agp1 = agp1.j;
        int l = agp1.length;
        int j = 0;
        while (j < l) 
        {
            agn aagn[] = agp1[j];
            if (((ago) (aagn)).a == 14)
            {
                arraylist.add(null);
            } else
            if (i == 9)
            {
                atz atz1 = new atz();
                aagn = ((ago) (aagn)).b.i;
                int i1 = aagn.length;
                for (int k = 0; k < i1; k++)
                {
                    agn agn1 = aagn[k];
                    a(list, atz1, agn1.a, agn1.b);
                }

                arraylist.add(atz1);
            } else
            if (i == 2)
            {
                arraylist.add(((ago) (aagn)).b.b);
            } else
            if (i == 6)
            {
                arraylist.add(Integer.valueOf(((ago) (aagn)).b.f));
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unexpected typeOfArrayList: ").append(i).toString());
            }
            j++;
        }
        return arraylist;
    }

    private static void a(List list, atz atz1, String s, ago ago1)
    {
        int i = ago1.a;
        if (i == 14)
        {
            atz1.a(s, null);
            return;
        }
        Object obj = ago1.b;
        if (i == 1)
        {
            atz1.a(s, ((agp) (obj)).a);
            return;
        }
        if (i == 11)
        {
            atz1.a(s, ((agp) (obj)).k);
            return;
        }
        if (i == 12)
        {
            atz1.a(s, ((agp) (obj)).l);
            return;
        }
        if (i == 15)
        {
            atz1.a(s, ((agp) (obj)).m);
            return;
        }
        if (i == 2)
        {
            atz1.a(s, ((agp) (obj)).b);
            return;
        }
        if (i == 3)
        {
            atz1.a(s, ((agp) (obj)).c);
            return;
        }
        if (i == 4)
        {
            atz1.a(s, ((agp) (obj)).d);
            return;
        }
        if (i == 5)
        {
            atz1.a(s, ((agp) (obj)).e);
            return;
        }
        if (i == 6)
        {
            atz1.a(s, ((agp) (obj)).f);
            return;
        }
        if (i == 7)
        {
            atz1.a(s, (byte)((agp) (obj)).g);
            return;
        }
        if (i == 8)
        {
            atz1.a(s, ((agp) (obj)).h);
            return;
        }
        if (i == 13)
        {
            if (list == null)
            {
                throw new RuntimeException((new StringBuilder()).append("populateBundle: unexpected type for: ").append(s).toString());
            } else
            {
                atz1.a(s, (Asset)list.get((int)((agp) (obj)).n));
                return;
            }
        }
        if (i == 9)
        {
            ago1 = new atz();
            obj = ((agp) (obj)).i;
            int j = obj.length;
            for (i = 0; i < j; i++)
            {
                Object obj1 = obj[i];
                a(list, ((atz) (ago1)), ((agn) (obj1)).a, ((agn) (obj1)).b);
            }

            atz1.a(s, ago1);
            return;
        }
        if (i == 10)
        {
            i = a(s, ((agp) (obj)).j);
            list = a(list, ((agp) (obj)), i);
            if (i == 14)
            {
                atz1.c(s, list);
                return;
            }
            if (i == 9)
            {
                atz1.a(s, list);
                return;
            }
            if (i == 2)
            {
                atz1.c(s, list);
                return;
            }
            if (i == 6)
            {
                atz1.b(s, list);
                return;
            } else
            {
                throw new IllegalStateException((new StringBuilder()).append("Unexpected typeOfArrayList: ").append(i).toString());
            }
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("populateBundle: unexpected type ").append(i).toString());
        }
    }

    private static agn[] a(atz atz1, List list)
    {
        Object obj = atz1.b();
        agn aagn[] = new agn[((Set) (obj)).size()];
        obj = ((Set) (obj)).iterator();
        for (int i = 0; ((Iterator) (obj)).hasNext(); i++)
        {
            String s = (String)((Iterator) (obj)).next();
            Object obj1 = atz1.b(s);
            aagn[i] = new agn();
            aagn[i].a = s;
            aagn[i].b = a(list, obj1);
        }

        return aagn;
    }
}
