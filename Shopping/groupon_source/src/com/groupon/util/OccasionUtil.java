// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.models.collections.Collections;
import com.groupon.models.country.Country;
import com.groupon.models.country.EnabledFeatures;
import com.groupon.service.core.CollectionsService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class OccasionUtil
{

    Lazy collectionsService;
    private Context context;
    Lazy currentCountryManager;
    private DateFormat dateFormat;
    private final Date now;

    public OccasionUtil()
    {
        now = new Date();
    }

    public OccasionUtil(Date date, DateFormat dateformat)
    {
        now = date;
        dateFormat = dateformat;
    }

    public String getOccasionsTitle()
    {
        String s;
        s = null;
        collectionsService = new Lazy(context) {

            final OccasionUtil this$0;

            
            {
                this$0 = OccasionUtil.this;
                super(context1);
            }
        };
        currentCountryManager = new Lazy(context) {

            final OccasionUtil this$0;

            
            {
                this$0 = OccasionUtil.this;
                super(context1);
            }
        };
        if (!((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible()) goto _L2; else goto _L1
_L1:
        com.groupon.models.collections.Collections.Occasion occasion = getValidOccasion(((CollectionsService)collectionsService.get()).getCollections());
        if (occasion == null) goto _L4; else goto _L3
_L3:
        s = occasion.shortName;
        if (!Strings.notEmpty(s)) goto _L5; else goto _L4
_L4:
        return s;
_L5:
        return context.getString(0x7f0802bb);
_L2:
        if (((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isIntlOccasionsChannelEnabled())
        {
            String s1 = ((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().enabledFeatures.activePromotion;
            s = s1;
            if (!Strings.notEmpty(s1))
            {
                return context.getString(0x7f0802bc);
            }
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public com.groupon.models.collections.Collections.Occasion getValidOccasion(Collections collections)
    {
        if (collections == null || collections.occasion == null)
        {
            return null;
        }
        collections = collections.occasion.iterator();
_L2:
        com.groupon.models.collections.Collections.Occasion occasion;
        if (!collections.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        occasion = (com.groupon.models.collections.Collections.Occasion)collections.next();
        if (occasion == null || !Strings.notEmpty(occasion.startTime) || !Strings.notEmpty(occasion.endTime))
        {
            continue; /* Loop/switch isn't completed */
        }
        Date date;
        Date date1;
        date = dateFormat.parse(occasion.startTime);
        date1 = dateFormat.parse(occasion.endTime);
        if (now.before(date1) && now.after(date))
        {
            return occasion;
        }
        continue; /* Loop/switch isn't completed */
        ParseException parseexception;
        parseexception;
        Ln.d(parseexception, (new StringBuilder()).append("Impossible to parse date of occasion : ").append(Strings.toString(occasion)).toString(), new Object[0]);
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }
}
