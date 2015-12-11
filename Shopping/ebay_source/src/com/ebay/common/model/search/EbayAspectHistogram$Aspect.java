// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.model.search:
//            EbayAspectHistogram

public static final class name extends ArrayList
    implements Cloneable
{

    public String name;
    public String serviceName;
    public boolean suppressDisplay;

    public static name createWithValue(String s, String s1, boolean flag)
    {
        return createWithValues(s, Arrays.asList(new String[] {
            s1
        }), flag);
    }

    public static createWithValues createWithValues(String s, List list, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            String s1 = (String)list.next();
            if (!TextUtils.isEmpty(s1))
            {
                alue alue = new alue();
                alue.value = s1;
                alue.serviceValue = s1;
                alue.checked = flag;
                arraylist.add(alue);
            }
        } while (true);
        list = new <init>(s, arraylist);
        list.serviceName = s;
        return list;
    }

    public serviceName clone()
    {
        serviceName servicename = (serviceName)super.clone();
        int j = size();
        for (int i = 0; i < j; i++)
        {
            servicename.set(i, ((alue)servicename.get(i)).clone());
        }

        return servicename;
    }

    public volatile Object clone()
    {
        return clone();
    }

    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj instanceof clone)
        {
            obj = (clone)obj;
            if (name == null)
            {
                if (((name) (obj)).name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(((name) (obj)).name))
            {
                return false;
            }
            if (serviceName == null)
            {
                if (((serviceName) (obj)).serviceName != null)
                {
                    return false;
                }
            } else
            if (!serviceName.equals(((serviceName) (obj)).serviceName))
            {
                return false;
            }
            int j = size();
            if (j != ((size) (obj)).size())
            {
                return false;
            }
            for (int i = 0; i < j; i++)
            {
                if (!((alue)get(i)).equals(((alue.equals) (obj)).get(i)))
                {
                    return false;
                }
            }

            return true;
        } else
        {
            return false;
        }
    }

    public final boolean hasCheck()
    {
        for (Iterator iterator = iterator(); iterator.hasNext();)
        {
            if (((alue)iterator.next()).checked)
            {
                return true;
            }
        }

        return false;
    }

    public String toString()
    {
        return name;
    }

    public alue()
    {
        suppressDisplay = false;
        name = null;
    }

    public name(String s, int i)
    {
        super(i);
        suppressDisplay = false;
        name = s;
    }

    public name(String s, Collection collection)
    {
        super(collection);
        suppressDisplay = false;
        name = s;
    }
}
