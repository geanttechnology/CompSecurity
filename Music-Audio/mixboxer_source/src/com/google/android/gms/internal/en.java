// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            eo, ep

public class en
    implements SafeParcelable
{

    public static final eo CREATOR = new eo();
    private final int kg;
    private final ep qc;

    en(int i, ep ep1)
    {
        kg = i;
        qc = ep1;
    }

    private en(ep ep1)
    {
        kg = 1;
        qc = ep1;
    }

    public static en a(es.b b)
    {
        if (b instanceof ep)
        {
            return new en((ep)b);
        } else
        {
            throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        }
    }

    ep ce()
    {
        return qc;
    }

    public es.b cf()
    {
        if (qc != null)
        {
            return qc;
        } else
        {
            throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        }
    }

    public int describeContents()
    {
        eo eo1 = CREATOR;
        return 0;
    }

    int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        eo eo1 = CREATOR;
        eo.a(this, parcel, i);
    }

}
