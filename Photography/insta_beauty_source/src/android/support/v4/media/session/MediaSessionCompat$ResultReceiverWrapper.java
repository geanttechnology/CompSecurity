// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;

final class mResultReceiver
    implements Parcelable
{

    public static final android.os.ResultReceiverWrapper._cls1 CREATOR = new _cls1();
    private ResultReceiver mResultReceiver;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        mResultReceiver.writeToParcel(parcel, i);
    }



    _cls1(Parcel parcel)
    {
        mResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.mResultReceiver(parcel);
    }

    public mResultReceiver(ResultReceiver resultreceiver)
    {
        mResultReceiver = resultreceiver;
    }

    class _cls1
        implements android.os.Parcelable.Creator
    {

        public MediaSessionCompat.ResultReceiverWrapper createFromParcel(Parcel parcel)
        {
            return new MediaSessionCompat.ResultReceiverWrapper(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public MediaSessionCompat.ResultReceiverWrapper[] newArray(int i)
        {
            return new MediaSessionCompat.ResultReceiverWrapper[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

            _cls1()
            {
            }
    }

}
