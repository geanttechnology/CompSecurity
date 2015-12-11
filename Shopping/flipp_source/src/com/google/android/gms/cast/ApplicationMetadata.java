// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.cast:
//            a

public final class ApplicationMetadata
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new a();
    final int a;
    String b;
    String c;
    List d;
    List e;
    String f;
    Uri g;

    private ApplicationMetadata()
    {
        a = 1;
        d = new ArrayList();
        e = new ArrayList();
    }

    ApplicationMetadata(int i, String s, String s1, List list, List list1, String s2, Uri uri)
    {
        a = i;
        b = s;
        c = s1;
        d = list;
        e = list1;
        f = s2;
        g = uri;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        return c;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.cast.a.a(this, parcel, i);
    }

}
