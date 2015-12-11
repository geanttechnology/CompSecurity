// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.shippingFields.converter;

import com.groupon.models.shippingFields.ShippingField;
import com.groupon.models.shippingFields.json.ShippingSelectValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import roboguice.util.Strings;

public class ShippingFieldsConverter
{

    public ShippingFieldsConverter()
    {
    }

    private List fromJson(List list)
    {
        ArrayList arraylist = new ArrayList();
        com.groupon.models.shippingFields.ShippingSelectValue shippingselectvalue1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(shippingselectvalue1))
        {
            ShippingSelectValue shippingselectvalue = (ShippingSelectValue)list.next();
            shippingselectvalue1 = new com.groupon.models.shippingFields.ShippingSelectValue();
            shippingselectvalue1.value = shippingselectvalue.value;
            shippingselectvalue1.label = shippingselectvalue.label;
        }

        return arraylist;
    }

    public ShippingField fromJson(com.groupon.models.shippingFields.json.ShippingField shippingfield)
    {
        Object obj1 = null;
        ShippingField shippingfield1 = new ShippingField();
        shippingfield1.name = shippingfield.name;
        shippingfield1.label = shippingfield.label;
        shippingfield1.type = shippingfield.type;
        shippingfield1.required = shippingfield.required;
        Object obj;
        if (shippingfield.selectValues != null)
        {
            obj = fromJson(shippingfield.selectValues);
        } else
        {
            obj = null;
        }
        shippingfield1.selectValues = ((List) (obj));
        if (shippingfield.parentField != null)
        {
            obj = shippingfield.parentField;
        } else
        {
            obj = null;
        }
        shippingfield1.parentField = ((String) (obj));
        obj = obj1;
        if (shippingfield.dynamicSelectValues != null)
        {
            obj = fromJson(shippingfield.dynamicSelectValues);
        }
        shippingfield1.dynamicSelectValues = ((HashMap) (obj));
        return shippingfield1;
    }

    public HashMap fromJson(HashMap hashmap)
    {
        HashMap hashmap1 = new HashMap();
        String s;
        for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); hashmap1.put(s, fromJson((List)hashmap.get(s))))
        {
            s = (String)iterator.next();
        }

        return hashmap1;
    }

    public List fromJson(com.groupon.models.shippingFields.json.ShippingField.List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.shippingFields.iterator(); list.hasNext();)
        {
            Iterator iterator = ((List)list.next()).iterator();
            while (iterator.hasNext()) 
            {
                com.groupon.models.shippingFields.json.ShippingField shippingfield = (com.groupon.models.shippingFields.json.ShippingField)iterator.next();
                if (Strings.notEmpty(shippingfield.name))
                {
                    arraylist.add(fromJson(shippingfield));
                }
            }
        }

        return arraylist;
    }
}
