// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type;

import com.ebay.nautilus.domain.data.experience.type.base.IModule;
import com.ebay.nautilus.domain.data.experience.type.base.Presentities;
import com.ebay.nautilus.domain.data.experience.type.base.ServiceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExperienceData
{

    public ServiceMeta meta;
    public Map modules;
    public Presentities presentities;

    public ExperienceData()
    {
    }

    public List getModuleList()
    {
        ArrayList arraylist1 = null;
        ArrayList arraylist = null;
        if (modules != null)
        {
            arraylist1 = null;
            Object obj = arraylist1;
            if (meta != null)
            {
                obj = arraylist1;
                if (meta.sequence != null)
                {
                    obj = arraylist1;
                    if (!meta.sequence.isEmpty())
                    {
                        obj = meta.sequence;
                    }
                }
            }
            if (obj != null)
            {
                int i = 0;
                do
                {
                    arraylist1 = arraylist;
                    if (i >= ((List) (obj)).size())
                    {
                        break;
                    }
                    IModule imodule = (IModule)modules.get(((List) (obj)).get(i));
                    arraylist1 = arraylist;
                    if (imodule != null)
                    {
                        arraylist1 = arraylist;
                        if (arraylist == null)
                        {
                            arraylist1 = new ArrayList(((List) (obj)).size());
                        }
                        arraylist1.add(imodule);
                    }
                    i++;
                    arraylist = arraylist1;
                } while (true);
            } else
            {
                arraylist1 = new ArrayList(modules.values());
            }
        }
        return arraylist1;
    }
}
