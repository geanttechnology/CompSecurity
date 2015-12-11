// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import a;
import android.os.Parcel;
import azp;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class il
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new azp();
    public final int a;
    public double b;
    public boolean c;
    public int d;
    public ApplicationMetadata e;
    public int f;

    public il()
    {
        this(3, (0.0D / 0.0D), false, -1, null, -1);
    }

    public il(int i, double d1, boolean flag, int j, ApplicationMetadata applicationmetadata, int k)
    {
        a = i;
        b = d1;
        c = flag;
        d = j;
        e = applicationmetadata;
        f = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof il))
            {
                return false;
            }
            obj = (il)obj;
            if (b != ((il) (obj)).b || c != ((il) (obj)).c || d != ((il) (obj)).d || !a.g(e, ((il) (obj)).e) || f != ((il) (obj)).f)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Double.valueOf(b), Boolean.valueOf(c), Integer.valueOf(d), e, Integer.valueOf(f)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        azp.a(this, parcel, i);
    }

}
