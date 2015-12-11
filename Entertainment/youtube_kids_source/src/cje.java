// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class cje
    implements ckv
{

    private final ckt d;
    private final bkn e;
    private final arp f;
    private final cnb g;
    private final int h;

    public cje(ckt ckt1, bkn bkn1, arp arp1, cnb cnb1, int i)
    {
        d = (ckt)b.a(ckt1);
        e = (bkn)b.a(bkn1);
        f = (arp)b.a(arp1);
        g = (cnb)b.a(cnb1);
        h = i;
    }

    private static List a(Collection collection, Set set)
    {
        if (set == null)
        {
            return new ArrayList(collection);
        }
        ArrayList arraylist = new ArrayList();
        if (set.isEmpty())
        {
            return arraylist;
        }
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            bwb bwb1 = (bwb)collection.next();
            if (set.contains(Integer.valueOf(bwb1.a.b)))
            {
                arraylist.add(bwb1);
            }
        } while (true);
        return arraylist;
    }

    private static List a(List list, String s)
    {
        boolean flag = TextUtils.isEmpty(s);
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            bwb bwb1 = (bwb)iterator.next();
            if (bwb1.a.p)
            {
                arraylist1.add(bwb1);
            }
            if (!flag && s.equals(bwb1.a.o))
            {
                arraylist.add(bwb1);
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            list = arraylist;
        } else
        if (!arraylist1.isEmpty())
        {
            return arraylist1;
        }
        return list;
    }

    private static void a(List list, int i, boolean flag)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            bwb bwb1 = (bwb)list.next();
            if (!flag || !bwb1.d())
            {
                int j = bwb1.c();
                if (j == -1 || j > i)
                {
                    list.remove();
                }
            }
        } while (true);
    }

    private static bwv[] a(List list, cks cks1)
    {
        SparseArray sparsearray = new SparseArray();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            bwb bwb1 = (bwb)list.next();
            int i = bwb1.c();
            if (i != -1 && (cks1 == null || cks1.a(i) == 0) && (sparsearray.indexOfKey(i) < 0 || bwb1.d()))
            {
                sparsearray.put(i, bwb1);
            }
        } while (true);
        list = new bwv[sparsearray.size()];
        for (int j = 0; j < list.length; j++)
        {
            list[j] = new bwv(sparsearray.keyAt(j), (bwb)sparsearray.valueAt(j));
        }

        Arrays.sort(list);
        return list;
    }

    private static List b(List list, cks cks1)
    {
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (list.hasNext())
            {
                bwb bwb1 = (bwb)list.next();
                switch (cks1.a(bwb1.c()))
                {
                case -1: 
                    arraylist2.add(bwb1);
                    break;

                case 0: // '\0'
                    arraylist1.add(bwb1);
                    break;

                case 1: // '\001'
                    arraylist.add(bwb1);
                    break;
                }
            } else
            {
                if (!arraylist1.isEmpty())
                {
                    return arraylist1;
                }
                if (!arraylist2.isEmpty())
                {
                    return arraylist2;
                }
                if (!arraylist.isEmpty())
                {
                    list = new ArrayList(1);
                    list.add(arraylist.get(arraylist.size() - 1));
                    return list;
                } else
                {
                    return Collections.emptyList();
                }
            }
        } while (true);
    }

    public final cku a(bwp bwp1, bww bww1, Set set, Set set1, boolean flag, boolean flag1, boolean flag2, 
            boolean flag3)
    {
        if (bww1.g || bww1.a())
        {
            bwp1 = bww1.f;
            if (set != null && !set.contains(Integer.valueOf(93)) || bwp1 == null)
            {
                throw new ckm("HLS not supported/available");
            } else
            {
                bww1 = a;
                set = b;
                set1 = c;
                cks cks1 = new cks(h, 0);
                return new cku(new bwb[] {
                    bwp1
                }, bww1, bwp1, set, set1, cks1, null);
            }
        } else
        {
            return a(bwp1, ((Collection) (bww1.b)), set, set1, false, true, false, false);
        }
    }

    public final cku a(bwp bwp1, Collection collection, Set set, Set set1, boolean flag, boolean flag1, boolean flag2, 
            boolean flag3)
    {
        b.a(bwp1);
        ckr ckr1 = d.a(flag);
        Object obj = a(collection, set);
        List list = a(collection, set1);
        boolean flag4 = ckr1.d;
        collection = ((List) (obj)).iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            set = (bwb)collection.next();
            if (((bwb) (set)).a.l)
            {
                if (!flag4)
                {
                    collection.remove();
                } else
                {
                    int i = set.c();
                    if (i != 360 && i != 720)
                    {
                        collection.remove();
                    }
                }
            }
        } while (true);
        if (((List) (obj)).size() != 1 || !((bwb)((List) (obj)).get(0)).d())
        {
            a(((List) (obj)), h, false);
        }
        if (e.b() && g.a.getBoolean("limit_mobile_data_usage", false))
        {
            a(((List) (obj)), 480, true);
        }
        collection = a(((List) (obj)), ((cks) (null)));
        set = ckr1.a;
        if (flag3)
        {
            bmo.e("Restricting to SD streams");
            if (!flag)
            {
                a(((List) (obj)), 480, false);
                collection = a(((List) (obj)), ((cks) (null)));
            } else
            {
                collection = a(((List) (obj)), new cks(480, 0));
                set = new cks(Math.min(((cks) (set)).a, 480), Math.min(((cks) (set)).b, 480));
            }
            if (collection.length == 0)
            {
                throw new ckm("Video not supported/available due to SD restriction");
            }
        }
        set1 = f;
        flag4 = ckr1.c;
        cjf cjf1;
        Iterator iterator;
        if (bwp1.a.j != null)
        {
            flag3 = bwp1.a.j.a;
        } else
        {
            flag3 = false;
        }
        cjf1 = new cjf(set1, flag4, flag3);
        cjf.a(cjf1, false);
        Collections.sort(((List) (obj)), cjf1);
        Collections.sort(list, cjf1);
        if (((List) (obj)).isEmpty())
        {
            bwp1 = null;
        } else
        {
            bwp1 = (bwb)((List) (obj)).get(0);
        }
        String as[];
        if (!flag)
        {
            set1 = b(((List) (obj)), ckr1.a);
        } else
        {
            set1 = ((Set) (obj));
        }
        list = b(list, ckr1.b);
        obj = new HashSet();
        iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = ((bwb)iterator.next()).a.o;
            if (!TextUtils.isEmpty(s))
            {
                ((Set) (obj)).add(s);
            }
        } while (true);
        as = (String[])((Set) (obj)).toArray(new String[((Set) (obj)).size()]);
        Arrays.sort(as);
        obj = list;
        if (!flag)
        {
            obj = a(list, ckr1.e);
        }
        if (set1.isEmpty() && flag1)
        {
            throw new ckm("Video not supported/available");
        }
        if (((List) (obj)).isEmpty() && flag2)
        {
            throw new ckm("Audio not supported/available");
        } else
        {
            cjf.a(cjf1, true);
            Collections.sort(set1, cjf1);
            Collections.sort(((List) (obj)), cjf1);
            return new cku((bwb[])set1.toArray(new bwb[set1.size()]), (bwb[])((List) (obj)).toArray(new bwb[((List) (obj)).size()]), bwp1, collection, as, set, ckr1.e);
        }
    }
}
