// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.support.v4.media.session:
//            a

public final class a
    implements Parcelable
{

    public static final android.os.iaSessionCompat.Token.a CREATOR = new a();
    private final Parcelable a;

    public final int describeContents()
    {
        return a.describeContents();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(a, i);
    }


    (Parcelable parcelable)
    {
        a = parcelable;
    }
}
