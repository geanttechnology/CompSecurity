// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.net.URLEncoder;

public final class cxu
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new cxv();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;
    public final String h;
    private final String i;

    cxu(Parcel parcel)
    {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
    }

    private cxu(String s, String s1, String s2, String s3, int j, String s4, String s5)
    {
        s4 = (new StringBuilder("http://video.google.com/timedtext?hl=")).append(s).append("&v=").append(s3).append("&type=track&lang=").append(s).append("&name=").append(URLEncoder.encode(s2)).append("&format=").append(j).toString();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s1);
        if (s2 != null && !s2.isEmpty() && !s2.equalsIgnoreCase(s1))
        {
            stringbuilder.append(" - ").append(s2);
        }
        this(s, s1, s2, s3, j, null, s5, s4, stringbuilder.toString());
    }

    private cxu(String s, String s1, String s2, String s3, int j, String s4, String s5, 
            String s6, String s7)
    {
        a = (String)b.b(s, "languageCode cannot be null");
        b = s1;
        c = (String)b.b(s2, "trackName cannot be null");
        d = s3;
        e = j;
        f = s4;
        g = (String)b.a(s5);
        h = (String)b.a(s6);
        i = (String)b.a(s7);
    }

    public static cxu a(String s)
    {
        return new cxu("", s, "", "", 1, null, "-");
    }

    public static cxu a(String s, String s1, String s2, int j, String s3)
    {
        return new cxu(s, s1, s2, null, j, null, s3);
    }

    public static cxu a(String s, String s1, String s2, String s3, int j)
    {
        return new cxu(s, s1, s2, s3, j, null, "-");
    }

    public static cxu a(String s, String s1, String s2, String s3, int j, String s4)
    {
        b.a(s1);
        b.a(s3);
        return new cxu(s, s1, s2, s3, j, null, s4);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof cxu)
        {
            if (a.equals(((cxu) (obj = (cxu)obj)).a) && c.equals(((cxu) (obj)).c) && (d == null && ((cxu) (obj)).d == null || d.equals(((cxu) (obj)).d)))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        int k = ((a.hashCode() + 527) * 31 + c.hashCode()) * 31;
        int j = k;
        if (d != null)
        {
            j = k + d.hashCode();
        }
        return j;
    }

    public final String toString()
    {
        return i;
    }

    public final void writeToParcel(Parcel parcel, int j)
    {
        parcel.writeString(a);
        parcel.writeString(b);
        parcel.writeString(c);
        parcel.writeString(d);
        parcel.writeInt(e);
        parcel.writeString(f);
        parcel.writeString(g);
        parcel.writeString(h);
        parcel.writeString(i);
    }

}
