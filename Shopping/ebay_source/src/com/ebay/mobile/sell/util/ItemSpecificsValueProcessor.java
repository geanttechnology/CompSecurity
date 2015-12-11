// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.util;

import android.content.Context;
import android.content.res.Resources;
import com.ebay.nautilus.domain.data.ItemSpecific;
import com.ebay.nautilus.domain.data.LdsField;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemSpecificsValueProcessor
{

    private ItemSpecific clickedSpecific;
    private Context context;
    private ArrayList selectedItemSpecifics;
    public ArrayList selectedPositions;
    public CharSequence stringValues[];
    public ArrayList values;

    public ItemSpecificsValueProcessor(Context context1, ItemSpecific itemspecific, ArrayList arraylist)
    {
        context = context1;
        clickedSpecific = itemspecific;
        selectedItemSpecifics = arraylist;
        values = getValuesForSpecific(itemspecific);
        stringValues = new CharSequence[values.size()];
        for (int i = 0; i < values.size(); i++)
        {
            stringValues[i] = ((com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue)values.get(i)).name;
        }

        selectedPositions = selectedPositions();
    }

    private LdsField getSelection()
    {
        for (Iterator iterator = selectedItemSpecifics.iterator(); iterator.hasNext();)
        {
            LdsField ldsfield = (LdsField)iterator.next();
            if (ldsfield.getIdIndex().equals(clickedSpecific.name))
            {
                return ldsfield;
            }
        }

        return null;
    }

    private boolean isCustomValue(String s, ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            if (s.equals(((com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue)arraylist.next()).name))
            {
                return false;
            }
        }

        return true;
    }

    private boolean meetsAnyDependency(ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            if (meetsDependency((com.ebay.nautilus.domain.data.ItemSpecific.ValueDependency)arraylist.next()))
            {
                return true;
            }
        }

        return false;
    }

    private boolean meetsDependency(com.ebay.nautilus.domain.data.ItemSpecific.ValueDependency valuedependency)
    {
        Iterator iterator = selectedItemSpecifics.iterator();
label0:
        do
        {
            if (iterator.hasNext())
            {
                Object obj = (LdsField)iterator.next();
                if (!valuedependency.name.equals(((LdsField) (obj)).getIdIndex()))
                {
                    continue;
                }
                obj = ((LdsField) (obj)).getSelectedValues().iterator();
                String s;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue label0;
                    }
                    s = (String)((Iterator) (obj)).next();
                } while (!valuedependency.value.equals(s));
                break;
            } else
            {
                return false;
            }
        } while (true);
        return true;
    }

    private ArrayList selectedPositions()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = getSelection();
        if (obj != null)
        {
            for (obj = ((LdsField) (obj)).getSelectedValues().iterator(); ((Iterator) (obj)).hasNext();)
            {
                String s = (String)((Iterator) (obj)).next();
                int i = 0;
                while (i < values.size()) 
                {
                    if (s.equals(((com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue)values.get(i)).name))
                    {
                        arraylist.add(Integer.valueOf(i));
                    }
                    i++;
                }
            }

        }
        return arraylist;
    }

    public ArrayList getValuesForSpecific(ItemSpecific itemspecific)
    {
        ArrayList arraylist = new ArrayList();
        if (itemspecific.maxValues == 1 && !itemspecific.isRequired())
        {
            com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue itemspecificvalue = new com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue();
            itemspecificvalue.name = "-";
            arraylist.add(itemspecificvalue);
        }
        Object obj = itemspecific.values.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue itemspecificvalue1 = (com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue)((Iterator) (obj)).next();
            if (itemspecificvalue1.dependencies.size() == 0)
            {
                arraylist.add(itemspecificvalue1);
            } else
            if (meetsAnyDependency(itemspecificvalue1.dependencies))
            {
                arraylist.add(itemspecificvalue1);
            }
        } while (true);
        obj = getSelection();
        if (obj != null)
        {
            obj = ((LdsField) (obj)).getSelectedValues().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = (String)((Iterator) (obj)).next();
                if (isCustomValue(s, arraylist))
                {
                    com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue itemspecificvalue2 = new com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue();
                    itemspecificvalue2.name = s;
                    arraylist.add(itemspecificvalue2);
                }
            } while (true);
        }
        if (itemspecific.selectionMode != null && itemspecific.selectionMode.equals("FreeText") && itemspecific.maxValues == 1)
        {
            itemspecific = new com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue();
            itemspecific.name = context.getResources().getString(0x7f070545);
            itemspecific.custom = true;
            arraylist.add(itemspecific);
        }
        return arraylist;
    }
}
