// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.util.ArrayList;

// Referenced classes of package com.poshmark.data_model.models:
//            MetaItem

public class IndexedMetaItem
{

    int index;
    boolean isRecentItem;
    MetaItem item;

    public IndexedMetaItem(MetaItem metaitem, int i)
    {
        index = i;
        item = metaitem;
    }

    public IndexedMetaItem(MetaItem metaitem, int i, boolean flag)
    {
        index = i;
        item = metaitem;
        isRecentItem = flag;
    }

    public static ArrayList convertIndexedBrandsToIndexMetaItemList(ArrayList arraylist, ArrayList arraylist1)
    {
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        arraylist1 = new ArrayList();
_L4:
        return arraylist1;
_L2:
        ArrayList arraylist2 = new ArrayList();
        int i;
        for (i = 0; i < arraylist1.size(); i++)
        {
            arraylist2.add(i, new IndexedMetaItem((MetaItem)arraylist1.get(i), i));
        }

        int k = arraylist.size();
        int j = 0;
        do
        {
            arraylist1 = arraylist2;
            if (j >= k)
            {
                continue;
            }
            arraylist2.add(i + j, (IndexedMetaItem)arraylist.get(j));
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ArrayList convertRecentBrandsToIndexMetaItemList(ArrayList arraylist, ArrayList arraylist1)
    {
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        arraylist1 = new ArrayList();
_L4:
        return arraylist1;
_L2:
        int k = 0;
        ArrayList arraylist2 = new ArrayList();
        if (arraylist1 != null)
        {
            int i = 0;
            do
            {
                k = i;
                if (i >= arraylist1.size())
                {
                    break;
                }
                arraylist2.add(i, new IndexedMetaItem((MetaItem)arraylist1.get(i), i));
                i++;
            } while (true);
        }
        int l = arraylist.size();
        int j = 0;
        do
        {
            arraylist1 = arraylist2;
            if (j >= l)
            {
                continue;
            }
            arraylist2.add(k + j, new IndexedMetaItem((MetaItem)arraylist.get(j), k + j));
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ArrayList convertToIndexMetaItemList(ArrayList arraylist)
    {
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist1 = new ArrayList();
_L4:
        return arraylist1;
_L2:
        ArrayList arraylist2 = new ArrayList();
        int j = arraylist.size();
        int i = 0;
        do
        {
            arraylist1 = arraylist2;
            if (i >= j)
            {
                continue;
            }
            arraylist2.add(i, new IndexedMetaItem((MetaItem)arraylist.get(i), i));
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int getIndex()
    {
        return index;
    }

    public MetaItem getMetaItem()
    {
        return item;
    }
}
