// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.tips;

import com.groupon.db.models.Tip;
import com.groupon.util.HumanReadableDateTimeDifferenceFormat;
import com.groupon.util.LongDateFormat;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.models.tips:
//            MerchantTip

public class MerchantTipsConverter
{

    private HumanReadableDateTimeDifferenceFormat humanReadableDateTimeDifferenceFormat;
    private LongDateFormat longDateFormat;

    public MerchantTipsConverter()
    {
    }

    private String getFormattedDate(Date date)
    {
        if (date != null)
        {
            String s;
            try
            {
                s = humanReadableDateTimeDifferenceFormat.getReadableTimer(date);
            }
            catch (InvalidParameterException invalidparameterexception)
            {
                return longDateFormat.format(date);
            }
            return s;
        } else
        {
            return null;
        }
    }

    public MerchantTip convertFrom(Tip tip)
    {
        MerchantTip merchanttip = null;
        if (tip != null)
        {
            merchanttip = new MerchantTip();
            merchanttip.likes = tip.likes;
            merchanttip.text = tip.text;
            merchanttip.maskedName = tip.maskedName;
            merchanttip.createdAtString = getFormattedDate(tip.createdAt);
            merchanttip.updatedAtString = getFormattedDate(tip.updatedAt);
        }
        return merchanttip;
    }

    public List convertFrom(Collection collection)
    {
        ArrayList arraylist = null;
        if (collection != null)
        {
            ArrayList arraylist1 = new ArrayList(collection.size());
            collection = collection.iterator();
            do
            {
                arraylist = arraylist1;
                if (!collection.hasNext())
                {
                    break;
                }
                arraylist1.add(convertFrom((Tip)collection.next()));
            } while (true);
        }
        return arraylist;
    }
}
