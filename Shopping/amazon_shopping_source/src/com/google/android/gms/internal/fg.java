// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            fh, fk

public class fg
    implements SafeParcelable
{

    public static final fh CREATOR = new fh();
    final int xM;
    final fk xN[];
    public final String xO;
    public final boolean xP;

    fg(int i, fk afk[], String s, boolean flag)
    {
        xM = i;
        xN = afk;
        xO = s;
        xP = flag;
    }

    public int describeContents()
    {
        fh fh1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        fh fh1 = CREATOR;
        fh.a(this, parcel, i);
    }

}
