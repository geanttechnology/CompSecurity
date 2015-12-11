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
    private final int kg;
    String kh;
    List ki;
    List kj;
    String kk;
    Uri kl;
    String mName;

    private ApplicationMetadata()
    {
        kg = 1;
        ki = new ArrayList();
        kj = new ArrayList();
    }

    ApplicationMetadata(int i, String s, String s1, List list, List list1, String s2, Uri uri)
    {
        kg = i;
        kh = s;
        mName = s1;
        ki = list;
        kj = list1;
        kk = s2;
        kl = uri;
    }

    public Uri aN()
    {
        return kl;
    }

    public boolean areNamespacesSupported(List list)
    {
        return kj != null && kj.containsAll(list);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getApplicationId()
    {
        return kh;
    }

    public List getImages()
    {
        return ki;
    }

    public String getName()
    {
        return mName;
    }

    public String getSenderAppIdentifier()
    {
        return kk;
    }

    int getVersionCode()
    {
        return kg;
    }

    public boolean isNamespaceSupported(String s)
    {
        return kj != null && kj.contains(s);
    }

    public String toString()
    {
        return mName;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        a.a(this, parcel, i);
    }

}
