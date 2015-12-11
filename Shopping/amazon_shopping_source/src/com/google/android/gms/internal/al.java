// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            am

public final class al
    implements SafeParcelable
{

    public static final am CREATOR = new am();
    public final int height;
    public final int heightPixels;
    public final String me;
    public final boolean mf;
    public final al mg[];
    public final int versionCode;
    public final int width;
    public final int widthPixels;

    public al()
    {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }

    al(int i, String s, int j, int k, boolean flag, int l, int i1, 
            al aal[])
    {
        versionCode = i;
        me = s;
        height = j;
        heightPixels = k;
        mf = flag;
        width = l;
        widthPixels = i1;
        mg = aal;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        am.a(this, parcel, i);
    }

}
