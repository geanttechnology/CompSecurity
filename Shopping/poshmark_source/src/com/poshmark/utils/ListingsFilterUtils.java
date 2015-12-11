// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.PMColor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListingsFilterUtils
{

    public ListingsFilterUtils()
    {
    }

    public static List getScrubbedColorList(List list, List list1)
    {
        if (list != null)
        {
            ArrayList arraylist = new ArrayList();
            if (list1 == null || list1.size() == 0)
            {
                arraylist.addAll(list);
            } else
            {
                Iterator iterator = list.iterator();
                list = list1.iterator();
                while (iterator.hasNext()) 
                {
                    PMColor pmcolor = (PMColor)iterator.next();
                    do
                    {
                        if (!list.hasNext())
                        {
                            break;
                        }
                        if (!((com.poshmark.data_model.models.Facets.FacetItem)list.next()).getName().equals(pmcolor.getName()))
                        {
                            continue;
                        }
                        arraylist.add(pmcolor);
                        break;
                    } while (true);
                    list = list1.iterator();
                }
            }
            return arraylist;
        } else
        {
            return null;
        }
    }

    public static List getScrubbedList(List list, List list1)
    {
        if (list != null)
        {
            ArrayList arraylist = new ArrayList();
            if (list1 == null || list1.size() == 0)
            {
                arraylist.addAll(list);
            } else
            {
                Iterator iterator = list.iterator();
                list = list1.iterator();
                while (iterator.hasNext()) 
                {
                    MetaItem metaitem = (MetaItem)iterator.next();
                    do
                    {
                        if (!list.hasNext())
                        {
                            break;
                        }
                        com.poshmark.data_model.models.Facets.FacetItem facetitem = (com.poshmark.data_model.models.Facets.FacetItem)list.next();
                        if (!facetitem.getName().equals(metaitem.getId()) && !facetitem.getDisplay().equals(metaitem.getDisplay()))
                        {
                            continue;
                        }
                        arraylist.add(metaitem);
                        list1.iterator();
                        break;
                    } while (true);
                    list = list1.iterator();
                }
            }
            return arraylist;
        } else
        {
            return null;
        }
    }

    public static List getScrubbedMetaItemList(List list, List list1)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
label0:
        for (list = list1.iterator(); iterator.hasNext(); list = list1.iterator())
        {
            MetaItem metaitem = (MetaItem)iterator.next();
            MetaItem metaitem1;
            do
            {
                if (!list.hasNext())
                {
                    continue label0;
                }
                metaitem1 = (MetaItem)list.next();
            } while (!metaitem1.getId().equals(metaitem.getId()) && !metaitem1.getDisplay().equals(metaitem.getDisplay()));
            arraylist.add(metaitem);
            list1.iterator();
        }

        return arraylist;
    }
}
