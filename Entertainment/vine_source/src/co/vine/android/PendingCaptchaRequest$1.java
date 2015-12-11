// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Parcel;

// Referenced classes of package co.vine.android:
//            PendingCaptchaRequest

static final class 
    implements android.os.st._cls1
{

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

    ()
    {
    }
}
