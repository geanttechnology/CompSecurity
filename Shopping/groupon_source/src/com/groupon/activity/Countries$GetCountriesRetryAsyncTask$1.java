// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.country.Country;
import com.groupon.util.CountryUtil;
import com.groupon.util.DeviceInfoUtil;
import java.text.Collator;
import java.util.Comparator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            Countries

class this._cls1
    implements Comparator
{

    final compare this$1;

    public int compare(Country country, Country country1)
    {
        country = Strings.toString(cess._mth200(this._cls1.this).getDisplayName(country.shortName));
        country1 = Strings.toString(cess._mth300(this._cls1.this).getDisplayName(country1.shortName));
        return Collator.getInstance(Countries.access$400(_fld0).getDeviceLocale()).compare(country, country1);
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Country)obj, (Country)obj1);
    }

    A()
    {
        this$1 = this._cls1.this;
        super();
    }
}
