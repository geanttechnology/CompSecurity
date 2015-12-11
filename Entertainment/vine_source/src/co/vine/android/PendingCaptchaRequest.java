// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class PendingCaptchaRequest
    implements Parcelable
{

    public static final int CAPTCHA_STATE_FAIL_REQUEST = 3;
    public static final int CAPTCHA_STATE_RETRY_REQUEST = 2;
    public static final int CAPTCHA_STATE_UNHANDLED = 1;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PendingCaptchaRequest createFromParcel(Parcel parcel)
        {
            return new PendingCaptchaRequest(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public PendingCaptchaRequest[] newArray(int i)
        {
            return new PendingCaptchaRequest[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final int actionCode;
    public final Bundle bundle;
    public final String reqId;
    public int state;

    public PendingCaptchaRequest(Parcel parcel)
    {
        reqId = parcel.readString();
        actionCode = parcel.readInt();
        bundle = parcel.readBundle();
        state = parcel.readInt();
    }

    public PendingCaptchaRequest(String s, int i, Bundle bundle1)
    {
        reqId = s;
        actionCode = i;
        bundle = bundle1;
        state = 1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(reqId);
        parcel.writeInt(actionCode);
        parcel.writeBundle(bundle);
        parcel.writeInt(state);
    }

}
