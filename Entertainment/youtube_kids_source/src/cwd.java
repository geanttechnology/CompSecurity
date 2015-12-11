// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;

public class cwd
    implements cwh
{

    public static final android.os.Parcelable.Creator CREATOR = new cwe();
    public final String a;
    public final bzi b;
    public final cwi c;

    public cwd(Parcel parcel)
    {
        Object obj = (Uri)parcel.readParcelable(getClass().getClassLoader());
        if (obj != null)
        {
            obj = bzi.a(((Uri) (obj)));
        } else
        {
            obj = null;
        }
        b = ((bzi) (obj));
        a = parcel.readString();
        c = (cwi)parcel.readParcelable(getClass().getClassLoader());
    }

    public cwd(bzi bzi1, String s, cwi cwi1)
    {
        a = (String)b.a(s);
        b = bzi1;
        c = cwi1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        Uri uri;
        if (b != null)
        {
            uri = b.a;
        } else
        {
            uri = null;
        }
        parcel.writeParcelable(uri, 0);
        parcel.writeString(a);
        parcel.writeParcelable(c, 0);
    }

}
