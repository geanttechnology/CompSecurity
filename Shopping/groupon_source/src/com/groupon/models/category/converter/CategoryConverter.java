// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.category.converter;

import com.groupon.models.category.Category;
import com.groupon.models.category.json.FacetsContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

public class CategoryConverter
{

    public CategoryConverter()
    {
    }

    public Category fromJson(com.groupon.models.category.json.Category category)
    {
        Category category1 = new Category();
        category1.id = category.id;
        String s;
        if (Strings.notEmpty(category.name))
        {
            s = category.name;
        } else
        {
            s = category.friendlyName;
        }
        category1.name = s;
        category1.friendlyName = category.friendlyName;
        category1.count = category.count;
        category1.friendlyNameShort = category.friendlyNameShort;
        category1.guid = category.guid;
        category1.children = fromJson(category.children);
        return category1;
    }

    public List fromJson(com.groupon.models.category.json.Category.List list)
    {
        Object obj = new ArrayList();
        if (list.categories != null)
        {
            obj = fromJson(list.categories);
        }
        return ((List) (obj));
    }

    public List fromJson(FacetsContainer facetscontainer, int i)
    {
        Object obj = new ArrayList();
        if (facetscontainer.getCategories(i) != null)
        {
            obj = fromJson(facetscontainer.getCategories(i));
        }
        return ((List) (obj));
    }

    public List fromJson(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            com.groupon.models.category.json.Category category = (com.groupon.models.category.json.Category)list.next();
            if ((Strings.notEmpty(category.name) || Strings.notEmpty(category.friendlyName)) && Strings.notEmpty(category.id))
            {
                arraylist.add(fromJson(category));
            }
        } while (true);
        return arraylist;
    }
}
