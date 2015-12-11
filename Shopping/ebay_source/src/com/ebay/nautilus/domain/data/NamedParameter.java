// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class NamedParameter
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    protected String name;
    protected String nameAsFormat;
    protected String nameAsType;
    public String value;

    public NamedParameter()
    {
    }

    public static void addParameterListToMap(List list, Map map)
    {
        if (list != null && list.size() != 0 && map != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                NamedParameter namedparameter = (NamedParameter)list.next();
                map.put(namedparameter.getName(), namedparameter.value);
            }
        }
    }

    public String getName()
    {
        if (!TextUtils.isEmpty(name))
        {
            return name;
        }
        if (!TextUtils.isEmpty(nameAsType))
        {
            return nameAsType;
        }
        if (!TextUtils.isEmpty(nameAsFormat))
        {
            return nameAsFormat;
        } else
        {
            return null;
        }
    }
}
