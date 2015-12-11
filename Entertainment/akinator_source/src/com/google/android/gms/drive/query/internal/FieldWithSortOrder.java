// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.drive.query.internal:
//            zzc

public class FieldWithSortOrder
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    final String zzamv;
    final boolean zzanY;

    FieldWithSortOrder(int i, String s, boolean flag)
    {
        mVersionCode = i;
        zzamv = s;
        zzanY = flag;
    }

    public FieldWithSortOrder(String s, boolean flag)
    {
        this(1, s, flag);
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        Locale locale = Locale.US;
        String s1 = zzamv;
        String s;
        if (zzanY)
        {
            s = "ASC";
        } else
        {
            s = "DESC";
        }
        return String.format(locale, "FieldWithSortOrder[%s %s]", new Object[] {
            s1, s
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

}
