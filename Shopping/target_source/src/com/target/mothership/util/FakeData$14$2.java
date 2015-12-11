// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.PersonName;
import com.target.mothership.model.common.PhoneNumber;
import com.target.mothership.model.common.a;
import com.target.mothership.model.common.c;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.util:
//            g

class this._cls0
    implements PhoneNumber
{

    final  this$0;

    public String a()
    {
        return "555-555-5555";
    }

    public c b()
    {
        return c.Home;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

    this._cls0()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/target/mothership/util/FakeData$14

/* anonymous class */
    static final class FakeData._cls14
        implements GuestAddress
    {

        public String a()
        {
            return "12345";
        }

        public a b()
        {
            return a.Shipping;
        }

        public e c()
        {
            return com.google.a.a.e.c(new FakeData._cls14._cls1());
        }

        public PhoneNumber d()
        {
            return new FakeData._cls14._cls2();
        }

        public int describeContents()
        {
            return 0;
        }

        public Boolean e()
        {
            return Boolean.valueOf(true);
        }

        public List getAddressLines()
        {
            ArrayList arraylist = new ArrayList(1);
            arraylist.add("123 Main Street");
            return arraylist;
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
            return "55401";
        }

        public String getStateOrProvince()
        {
            return "MN";
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }


        // Unreferenced inner class com/target/mothership/util/FakeData$14$1

/* anonymous class */
        class FakeData._cls14._cls1
            implements PersonName
        {

            final FakeData._cls14 this$0;

            public String a()
            {
                return "George";
            }

            public String b()
            {
                return null;
            }

            public String c()
            {
                return "Herman";
            }

            public int describeContents()
            {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i)
            {
            }

                    
                    {
                        this$0 = FakeData._cls14.this;
                        super();
                    }
        }

    }

}
