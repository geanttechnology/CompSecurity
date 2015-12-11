// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            KeyValue

public class RequestContext
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RequestContext createFromParcel(Parcel parcel)
        {
            return new RequestContext(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RequestContext[] newArray(int i)
        {
            return new RequestContext[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public List keyValues;

    public RequestContext()
    {
        keyValues = new ArrayList();
    }

    RequestContext(Parcel parcel)
    {
        parcel.readTypedList(keyValues, KeyValue.CREATOR);
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("RequestContext(").append(keyValues).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeTypedList(keyValues);
    }

}
