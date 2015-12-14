// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.os;

import android.os.Parcel;

// Referenced classes of package android.support.v4.os:
//            ResultReceiver

final class 
    implements android.os.r
{

    public final ResultReceiver createFromParcel(Parcel parcel)
    {
        return new ResultReceiver(parcel);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final ResultReceiver[] newArray(int i)
    {
        return new ResultReceiver[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
