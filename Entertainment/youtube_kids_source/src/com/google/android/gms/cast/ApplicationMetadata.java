// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import a;
import android.net.Uri;
import android.os.Parcel;
import avn;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ApplicationMetadata
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new avn();
    public final int a;
    public String b;
    public String c;
    public List d;
    public List e;
    public String f;
    public Uri g;

    private ApplicationMetadata()
    {
        a = 1;
        d = new ArrayList();
        e = new ArrayList();
    }

    public ApplicationMetadata(int i, String s, String s1, List list, List list1, String s2, Uri uri)
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

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ApplicationMetadata))
            {
                return false;
            }
            obj = (ApplicationMetadata)obj;
            if (!a.g(b, ((ApplicationMetadata) (obj)).b) || !a.g(d, ((ApplicationMetadata) (obj)).d) || !a.g(c, ((ApplicationMetadata) (obj)).c) || !a.g(e, ((ApplicationMetadata) (obj)).e) || !a.g(f, ((ApplicationMetadata) (obj)).f) || !a.g(g, ((ApplicationMetadata) (obj)).g))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(a), b, c, d, e, f, g
        });
    }

    public final String toString()
    {
        return c;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        avn.a(this, parcel, i);
    }

}
