// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import com.poshmark.data_model.models.PMColor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColorPickerInfo
{

    public List allItems;
    public List colorFacetList;
    public List selectedColors;

    public ColorPickerInfo()
    {
        allItems = new ArrayList();
        selectedColors = new ArrayList();
    }

    public void clearSelectionList()
    {
        selectedColors.clear();
    }

    public List getSelectedColorLabels()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = selectedColors.iterator(); iterator.hasNext(); arraylist.add(((PMColor)iterator.next()).getName())) { }
        return arraylist;
    }

    public boolean isColorInSelectColorList(PMColor pmcolor)
    {
        for (Iterator iterator = selectedColors.iterator(); iterator.hasNext();)
        {
            if (((PMColor)iterator.next()).getName().equalsIgnoreCase(pmcolor.getName()))
            {
                return true;
            }
        }

        return false;
    }

    public void removeColorFromSelectedColorList(PMColor pmcolor)
    {
        Iterator iterator = selectedColors.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (!((PMColor)iterator.next()).getName().equalsIgnoreCase(pmcolor.getName()))
            {
                continue;
            }
            iterator.remove();
            break;
        } while (true);
    }
}
