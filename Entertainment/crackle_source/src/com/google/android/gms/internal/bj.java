// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            bi

public final class bj
    implements SafeParcelable
{

    public static final bi CREATOR = new bi();
    public final String gn;
    public final String go;
    public final String gp;
    public final String gq;
    public final String gr;
    public final String mimeType;
    public final String packageName;
    public final int versionCode;

    public bj(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6)
    {
        versionCode = i;
        gn = s;
        go = s1;
        mimeType = s2;
        packageName = s3;
        gp = s4;
        gq = s5;
        gr = s6;
    }

    public bj(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        this(1, s, s1, s2, s3, s4, s5, s6);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        bi.a(this, parcel, i);
    }

}
