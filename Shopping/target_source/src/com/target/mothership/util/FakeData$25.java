// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import com.target.mothership.model.common.Coordinates;
import com.target.mothership.model.common.Geofence;

// Referenced classes of package com.target.mothership.util:
//            g

static final class _cls1.this._cls0
    implements Geofence
{

    public int describeContents()
    {
        return 0;
    }

    public Coordinates getCenter()
    {
        return new Coordinates() {

            final FakeData._cls25 this$0;

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

            
            {
                this$0 = FakeData._cls25.this;
                super();
            }
        };
    }

    public double getRadius()
    {
        return 500D;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

    _cls1.this._cls0()
    {
    }
}
