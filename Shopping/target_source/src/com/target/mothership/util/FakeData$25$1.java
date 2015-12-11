// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import com.target.mothership.model.common.Coordinates;
import com.target.mothership.model.common.Geofence;

// Referenced classes of package com.target.mothership.util:
//            g

class this._cls0
    implements Coordinates
{

    final nates this$0;

    public int describeContents()
    {
        return 0;
    }

    public double getLatitude()
    {
        return 45D;
    }

    public double getLongitude()
    {
        return -90D;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

    nates()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/target/mothership/util/FakeData$25

/* anonymous class */
    static final class FakeData._cls25
        implements Geofence
    {

        public int describeContents()
        {
            return 0;
        }

        public Coordinates getCenter()
        {
            return new FakeData._cls25._cls1();
        }

        public double getRadius()
        {
            return 500D;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

    }

}
