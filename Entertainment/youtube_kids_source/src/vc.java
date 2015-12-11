// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public final class vc
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new vd();
    public final bsv a;
    public final Uri b;
    public final int c;
    public final String d;
    public final int e;
    public final boolean f;

    public vc(Parcel parcel)
    {
        ClassLoader classloader = getClass().getClassLoader();
        a = (bsv)parcel.readParcelable(classloader);
        b = (Uri)parcel.readParcelable(classloader);
        c = parcel.readInt();
        d = parcel.readString();
        e = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
    }

    public vc(bsv bsv1, Uri uri, int i, String s, int j, boolean flag)
    {
        a = (bsv)b.a(bsv1);
        b = (Uri)b.a(uri);
        c = i;
        d = (String)b.a(s);
        e = j;
        f = flag;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        String s = String.valueOf(Integer.toHexString(System.identityHashCode(this)));
        String s1 = String.valueOf(b);
        int i = c;
        String s2 = d;
        int j = e;
        boolean flag = f;
        return (new StringBuilder(String.valueOf(s).length() + 105 + String.valueOf(s1).length() + String.valueOf(s2).length())).append("AtrClient.AtrClientState{").append(s).append(" baseAtrUri=").append(s1).append(" delaySeconds=").append(i).append(" cpn=").append(s2).append(" length=").append(j).append(" atrPingSent=").append(flag).append("}").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        i = 0;
        parcel.writeParcelable(a, 0);
        parcel.writeParcelable(b, 0);
        parcel.writeInt(c);
        parcel.writeString(d);
        parcel.writeInt(e);
        if (f)
        {
            i = 1;
        }
        parcel.writeInt(i);
    }

}
