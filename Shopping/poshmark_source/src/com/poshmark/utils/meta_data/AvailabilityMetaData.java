// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.MetaItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvailabilityMetaData
{
    public static final class AVAILABILITY_TYPE extends Enum
    {

        private static final AVAILABILITY_TYPE $VALUES[];
        public static final AVAILABILITY_TYPE ALL;
        public static final AVAILABILITY_TYPE SOLD;
        public static final AVAILABILITY_TYPE UNSOLD;

        public static AVAILABILITY_TYPE valueOf(String s)
        {
            return (AVAILABILITY_TYPE)Enum.valueOf(com/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE, s);
        }

        public static AVAILABILITY_TYPE[] values()
        {
            return (AVAILABILITY_TYPE[])$VALUES.clone();
        }

        static 
        {
            ALL = new AVAILABILITY_TYPE("ALL", 0);
            UNSOLD = new AVAILABILITY_TYPE("UNSOLD", 1);
            SOLD = new AVAILABILITY_TYPE("SOLD", 2);
            $VALUES = (new AVAILABILITY_TYPE[] {
                ALL, UNSOLD, SOLD
            });
        }

        private AVAILABILITY_TYPE(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String ALL_ITEMS = "all_items";
    public static final String AVAILABLE = "available";
    public static final String NOT_FOR_SALE = "not_for_sale";
    public static final String SOLD_OUT = "sold_out";
    List availabilityOptions;

    public AvailabilityMetaData()
    {
        availabilityOptions = new ArrayList();
        availabilityOptions.add(new MetaItem("all_items", PMApplication.getContext().getString(0x7f060040)));
        availabilityOptions.add(new MetaItem("available", PMApplication.getContext().getString(0x7f0602ae)));
        availabilityOptions.add(new MetaItem("sold_out", PMApplication.getContext().getString(0x7f060287)));
    }

    public static MetaItem getAvailabilityMetaItemFromLabel(String s)
    {
label0:
        {
            MetaItem metaitem = null;
            if (s != null)
            {
                if (!s.equalsIgnoreCase("sold_out"))
                {
                    break label0;
                }
                metaitem = new MetaItem("sold_out", PMApplication.getContext().getString(0x7f060287));
            }
            return metaitem;
        }
        if (s.equalsIgnoreCase("available"))
        {
            return new MetaItem("available", PMApplication.getContext().getString(0x7f0602ae));
        } else
        {
            return new MetaItem("all_items", PMApplication.getContext().getString(0x7f060040));
        }
    }

    MetaItem getAvailabilityItem(String s)
    {
        for (Iterator iterator = availabilityOptions.iterator(); iterator.hasNext();)
        {
            MetaItem metaitem = (MetaItem)iterator.next();
            if (metaitem.getId().equals(s))
            {
                return metaitem;
            }
        }

        return null;
    }

    public List getAvailabilityList()
    {
        return availabilityOptions;
    }

    public MetaItem getAvailabilityMetaItem(AVAILABILITY_TYPE availability_type)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$utils$meta_data$AvailabilityMetaData$AVAILABILITY_TYPE[];

            static 
            {
                $SwitchMap$com$poshmark$utils$meta_data$AvailabilityMetaData$AVAILABILITY_TYPE = new int[AVAILABILITY_TYPE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$meta_data$AvailabilityMetaData$AVAILABILITY_TYPE[AVAILABILITY_TYPE.ALL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$meta_data$AvailabilityMetaData$AVAILABILITY_TYPE[AVAILABILITY_TYPE.SOLD.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$meta_data$AvailabilityMetaData$AVAILABILITY_TYPE[AVAILABILITY_TYPE.UNSOLD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.poshmark.utils.meta_data.AvailabilityMetaData.AVAILABILITY_TYPE[availability_type.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 38
    //                   2 56
    //                   3 74;
           goto _L1 _L2 _L3 _L4
_L1:
        return null;
_L2:
        return new MetaItem("all_items", PMApplication.getContext().getString(0x7f060040));
_L3:
        return new MetaItem("sold_items", PMApplication.getContext().getString(0x7f060287));
_L4:
        new MetaItem("unsold_items", PMApplication.getContext().getString(0x7f0602ae));
        if (true) goto _L1; else goto _L5
_L5:
    }
}
