// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import com.target.mothership.model.common.Address;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.target.mothership.util:
//            g

static final class ess
    implements Address
{

    public int describeContents()
    {
        return 0;
    }

    public List getAddressLines()
    {
        return Arrays.asList(new String[] {
            "4380 Lawehana St"
        });
    }

    public String getCity()
    {
        return "Honolulu";
    }

    public String getCountry()
    {
        return "USA";
    }

    public String getPostalCode()
    {
        return "96818";
    }

    public String getStateOrProvince()
    {
        return "HI";
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

    ess()
    {
    }
}
