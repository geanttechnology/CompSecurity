// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            lw

public final class lv
{
    public static class a
    {

        public final lw amp;
        public final List amq;

        public a(lw lw1, List list)
        {
            amp = lw1;
            amq = list;
        }
    }


    private static int a(String s, lw.a.a aa[])
    {
        int i;
        int j;
        int l;
        l = aa.length;
        i = 0;
        j = 14;
_L5:
        lw.a.a a1;
        if (i >= l)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        a1 = aa[i];
        if (j != 14) goto _L2; else goto _L1
_L1:
        if (a1.type != 9 && a1.type != 2 && a1.type != 6) goto _L4; else goto _L3
_L3:
        int k = a1.type;
_L7:
        i++;
        j = k;
          goto _L5
_L4:
        k = j;
        if (a1.type == 14) goto _L7; else goto _L6
_L6:
        throw new IllegalArgumentException((new StringBuilder()).append("Unexpected TypedValue type: ").append(a1.type).append(" for key ").append(s).toString());
_L2:
        k = j;
        if (a1.type == j) goto _L7; else goto _L8
_L8:
        throw new IllegalArgumentException((new StringBuilder()).append("The ArrayList elements should all be the same type, but ArrayList with key ").append(s).append(" contains items of type ").append(j).append(" and ").append(a1.type).toString());
        return j;
    }

    public static DataMap a(a a1)
    {
        DataMap datamap = new DataMap();
        lw.a aa[] = a1.amp.amr;
        int j = aa.length;
        for (int i = 0; i < j; i++)
        {
            lw.a a2 = aa[i];
            a(a1.amq, datamap, a2.name, a2.amt);
        }

        return datamap;
    }

    private static ArrayList a(List list, lw.a.a.a a1, int i)
    {
        ArrayList arraylist = new ArrayList(a1.amF.length);
        a1 = a1.amF;
        int l = a1.length;
        int j = 0;
        while (j < l) 
        {
            lw.a aa[] = a1[j];
            if (((lw.a.a) (aa)).type == 14)
            {
                arraylist.add(null);
            } else
            if (i == 9)
            {
                DataMap datamap = new DataMap();
                aa = ((lw.a.a) (aa)).amv.amE;
                int i1 = aa.length;
                for (int k = 0; k < i1; k++)
                {
                    lw.a a2 = aa[k];
                    a(list, datamap, a2.name, a2.amt);
                }

                arraylist.add(datamap);
            } else
            if (i == 2)
            {
                arraylist.add(((lw.a.a) (aa)).amv.amx);
            } else
            if (i == 6)
            {
                arraylist.add(Integer.valueOf(((lw.a.a) (aa)).amv.amB));
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unexpected typeOfArrayList: ").append(i).toString());
            }
            j++;
        }
        return arraylist;
    }

    private static void a(List list, DataMap datamap, String s, lw.a.a a1)
    {
        int i = a1.type;
        if (i == 14)
        {
            datamap.putString(s, null);
            return;
        }
        Object obj = a1.amv;
        if (i == 1)
        {
            datamap.putByteArray(s, ((lw.a.a.a) (obj)).amw);
            return;
        }
        if (i == 11)
        {
            datamap.putStringArray(s, ((lw.a.a.a) (obj)).amG);
            return;
        }
        if (i == 12)
        {
            datamap.putLongArray(s, ((lw.a.a.a) (obj)).amH);
            return;
        }
        if (i == 15)
        {
            datamap.putFloatArray(s, ((lw.a.a.a) (obj)).amI);
            return;
        }
        if (i == 2)
        {
            datamap.putString(s, ((lw.a.a.a) (obj)).amx);
            return;
        }
        if (i == 3)
        {
            datamap.putDouble(s, ((lw.a.a.a) (obj)).amy);
            return;
        }
        if (i == 4)
        {
            datamap.putFloat(s, ((lw.a.a.a) (obj)).amz);
            return;
        }
        if (i == 5)
        {
            datamap.putLong(s, ((lw.a.a.a) (obj)).amA);
            return;
        }
        if (i == 6)
        {
            datamap.putInt(s, ((lw.a.a.a) (obj)).amB);
            return;
        }
        if (i == 7)
        {
            datamap.putByte(s, (byte)((lw.a.a.a) (obj)).amC);
            return;
        }
        if (i == 8)
        {
            datamap.putBoolean(s, ((lw.a.a.a) (obj)).amD);
            return;
        }
        if (i == 13)
        {
            if (list == null)
            {
                throw new RuntimeException((new StringBuilder()).append("populateBundle: unexpected type for: ").append(s).toString());
            } else
            {
                datamap.putAsset(s, (Asset)list.get((int)((lw.a.a.a) (obj)).amJ));
                return;
            }
        }
        if (i == 9)
        {
            a1 = new DataMap();
            obj = ((lw.a.a.a) (obj)).amE;
            int j = obj.length;
            for (i = 0; i < j; i++)
            {
                Object obj1 = obj[i];
                a(list, ((DataMap) (a1)), ((lw.a) (obj1)).name, ((lw.a) (obj1)).amt);
            }

            datamap.putDataMap(s, a1);
            return;
        }
        if (i == 10)
        {
            i = a(s, ((lw.a.a.a) (obj)).amF);
            list = a(list, ((lw.a.a.a) (obj)), i);
            if (i == 14)
            {
                datamap.putStringArrayList(s, list);
                return;
            }
            if (i == 9)
            {
                datamap.putDataMapArrayList(s, list);
                return;
            }
            if (i == 2)
            {
                datamap.putStringArrayList(s, list);
                return;
            }
            if (i == 6)
            {
                datamap.putIntegerArrayList(s, list);
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
}
