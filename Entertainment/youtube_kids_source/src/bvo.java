// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;

final class bvo
    implements android.os.Parcelable.Creator
{

    bvo()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int i = parcel.readInt();
        Uri uri = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        String s = parcel.readString();
        ArrayList arraylist = new ArrayList();
        parcel.readTypedList(arraylist, Uri.CREATOR);
        return new bvn(i, uri, s, Collections.unmodifiableList(arraylist));
    }

    public final Object[] newArray(int i)
    {
        return new bvn[i];
    }
}
