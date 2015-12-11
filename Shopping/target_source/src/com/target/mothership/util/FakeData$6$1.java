// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.common.Address;
import com.target.mothership.model.common.Geofence;
import com.target.mothership.model.store.interfaces.StoreSummary;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.target.mothership.util:
//            g

class this._cls0
    implements Address
{

    final ss this$0;

    public int describeContents()
    {
        return 0;
    }

    public List getAddressLines()
    {
        return Arrays.asList(new String[] {
            "1100 Nicollet Ave"
        });
    }

    public String getCity()
    {
        return "Minneapolis";
    }

    public String getCountry()
    {
        return "USA";
    }

    public String getPostalCode()
    {
        return "55123";
    }

    public String getStateOrProvince()
    {
        return "MN";
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

    Identifier()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/target/mothership/util/FakeData$6

/* anonymous class */
    static final class FakeData._cls6
        implements StoreSummary
    {

        public int describeContents()
        {
            return 0;
        }

        public Address getAddress()
        {
            return new FakeData._cls6._cls1();
        }

        public Geofence getGeofence()
        {
            return g.FAKE_GEOFENCE;
        }

        public String getName()
        {
            return "Nicollet Mall";
        }

        public StoreIdentifier getStoreId()
        {
            return new StoreIdentifier("52");
        }

        public boolean hasRequestATeamMember()
        {
            return false;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }

}
