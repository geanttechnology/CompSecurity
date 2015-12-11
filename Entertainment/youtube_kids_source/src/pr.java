// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public final class pr
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ps();
    public final Uri a;
    public final int b;
    public final String c;
    public final int d;
    public final String e;
    public final long f;
    public final boolean g;

    public pr(Uri uri, int i, String s, int j, String s1, long l, 
            boolean flag)
    {
        a = uri;
        b = i;
        c = s;
        d = j;
        e = s1;
        f = l;
        g = flag;
    }

    pr(Parcel parcel)
    {
        a = (Uri)parcel.readParcelable(null);
        b = parcel.readInt();
        c = parcel.readString();
        d = parcel.readInt();
        e = parcel.readString();
        f = parcel.readLong();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = flag;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        String s = String.valueOf(Integer.toHexString(System.identityHashCode(this)));
        String s1 = String.valueOf(a);
        int i = b;
        String s2 = c;
        int j = d;
        String s3 = e;
        long l = f;
        boolean flag = g;
        return (new StringBuilder(String.valueOf(s).length() + 176 + String.valueOf(s1).length() + String.valueOf(s2).length() + String.valueOf(s3).length())).append("QoeStatsClient.QoeStatsClientState{").append(s).append(" baseQoeUri=").append(s1).append(" videoItag=").append(i).append(" videoXtags=").append(s2).append(" audioItag=").append(j).append(" audioXtags=").append(s3).append(" startPlaybackTimeMillis=").append(l).append(" wasEnded=").append(flag).append("}").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        i = 0;
        parcel.writeParcelable(a, 0);
        parcel.writeInt(b);
        parcel.writeString(c);
        parcel.writeInt(d);
        parcel.writeString(e);
        parcel.writeLong(f);
        if (g)
        {
            i = 1;
        }
        parcel.writeInt(i);
    }

}
