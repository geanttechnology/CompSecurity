// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package co.vine.android.service:
//            VineServiceResponder

public class VineServiceCallback
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineServiceCallback createFromParcel(Parcel parcel)
        {
            return new VineServiceCallback(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineServiceCallback[] newArray(int i)
        {
            return new VineServiceCallback[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final VineServiceResponder mResponder;

    public VineServiceCallback(Parcel parcel)
    {
        mResponder = (VineServiceResponder)parcel.readStrongBinder();
    }

    public VineServiceCallback(VineServiceResponder vineserviceresponder)
    {
        mResponder = vineserviceresponder;
    }

    public int describeContents()
    {
        return 0;
    }

    public VineServiceResponder getResponder()
    {
        return mResponder;
    }

    public void onServiceResponse(Bundle bundle)
    {
        mResponder.onServiceResponse(bundle.getInt("action_code", 0), bundle.getInt("resp_code", 0), bundle.getString("reason_phrase"), bundle);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeStrongBinder(mResponder);
    }

}
