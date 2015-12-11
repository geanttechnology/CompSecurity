// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            c, g, RegisterSectionInfo

public class DocumentSection
    implements SafeParcelable
{

    public static final c CREATOR = new c();
    public static final int a = Integer.parseInt("-1");
    private static final RegisterSectionInfo g = (new RegisterSectionInfo.a("SsbContext")).a(true).a("blob").a();
    final int b;
    public final String c;
    final RegisterSectionInfo d;
    public final int e;
    public final byte f[];

    DocumentSection(int i, String s, RegisterSectionInfo registersectioninfo, int j, byte abyte0[])
    {
        boolean flag;
        if (j == a || com.google.android.gms.appdatasearch.g.a(j) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        u.b(flag, (new StringBuilder()).append("Invalid section type ").append(j).toString());
        b = i;
        c = s;
        d = registersectioninfo;
        e = j;
        f = abyte0;
        s = a();
        if (s != null)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }

    public String a()
    {
        if (e != a && com.google.android.gms.appdatasearch.g.a(e) == null)
        {
            return (new StringBuilder()).append("Invalid section type ").append(e).toString();
        }
        if (c != null && f != null)
        {
            return "Both content and blobContent set";
        } else
        {
            return null;
        }
    }

    public int describeContents()
    {
        c c1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        c c1 = CREATOR;
        com.google.android.gms.appdatasearch.c.a(this, parcel, i);
    }

}
