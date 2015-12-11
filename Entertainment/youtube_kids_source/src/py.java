// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public final class py
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new pz();
    public final Uri a;
    public final Uri b;
    public final Uri c;
    public final long d;
    public final long e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final int k;
    public final int l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final int s;
    public final ctn t;
    public final String u;

    public py(Uri uri, Uri uri1, Uri uri2, long l1, long l2, 
            String s1, String s2, String s3, String s4, String s5, int i1, int j1, 
            boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, int k1, 
            ctn ctn1, String s6)
    {
        a = uri;
        b = uri1;
        c = uri2;
        d = l1;
        e = l2;
        f = s1;
        g = s2;
        h = s3;
        i = s4;
        j = s5;
        k = i1;
        l = j1;
        m = flag;
        n = flag1;
        o = flag2;
        q = flag3;
        p = flag4;
        r = flag5;
        s = k1;
        t = ctn1;
        u = s6;
    }

    public py(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        a = (Uri)parcel.readParcelable(null);
        b = (Uri)parcel.readParcelable(null);
        c = (Uri)parcel.readParcelable(null);
        d = parcel.readLong();
        e = parcel.readLong();
        f = parcel.readString();
        g = parcel.readString();
        h = parcel.readString();
        i = parcel.readString();
        t = ctn.a(parcel.readInt());
        k = parcel.readInt();
        l = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        m = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        n = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        o = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        q = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        p = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        r = flag;
        s = parcel.readInt();
        u = parcel.readString();
        j = parcel.readString();
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        String s1 = String.valueOf(Integer.toHexString(System.identityHashCode(this)));
        String s2 = String.valueOf(a);
        String s3 = String.valueOf(b);
        String s4 = String.valueOf(c);
        long l1 = d;
        long l2 = e;
        String s5 = f;
        String s6 = g;
        String s7 = h;
        String s8 = i;
        int i1 = k;
        int j1 = l;
        boolean flag = m;
        boolean flag1 = n;
        boolean flag2 = o;
        boolean flag3 = q;
        boolean flag4 = p;
        boolean flag5 = r;
        int k1 = s;
        String s9 = String.valueOf(t);
        String s10 = u;
        return (new StringBuilder(String.valueOf(s1).length() + 427 + String.valueOf(s2).length() + String.valueOf(s3).length() + String.valueOf(s4).length() + String.valueOf(s5).length() + String.valueOf(s6).length() + String.valueOf(s7).length() + String.valueOf(s8).length() + String.valueOf(s9).length() + String.valueOf(s10).length())).append("VideoStats2Client.VideoStats2ClientState{").append(s1).append(" basePlaybackUri=").append(s2).append(" baseDelayplayUri=").append(s3).append(" baseWatchtimeUri=").append(s4).append(" sessionStartTimestamp=").append(l1).append(" currentPlaybackPosition=").append(l2).append(" adformat=").append(s5).append(" length=").append(s6).append(" videoId=").append(s7).append(" cpn=").append(s8).append(" delay=").append(i1).append(" watchTimeMillis=").append(j1).append(" autoplay=").append(flag).append(" scriptedPlayback=").append(flag1).append(" delayedPingSent=").append(flag2).append(" finalPingSent=").append(flag3).append(" initialPingSent=").append(flag4).append(" throttled=").append(flag5).append(" videoItag=").append(k1).append(" feature=").append(s9).append(" subtitleTrackId=").append(s10).append("}").toString();
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        parcel.writeParcelable(a, 0);
        parcel.writeParcelable(b, 0);
        parcel.writeParcelable(c, 0);
        parcel.writeLong(d);
        parcel.writeLong(e);
        parcel.writeString(f);
        parcel.writeString(g);
        parcel.writeString(h);
        parcel.writeString(i);
        parcel.writeInt(t.ordinal());
        parcel.writeInt(k);
        parcel.writeInt(l);
        if (m)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (n)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (o)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (q)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (p)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (r)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeInt(s);
        parcel.writeString(u);
        parcel.writeString(j);
    }

}
