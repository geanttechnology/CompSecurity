// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class bvr
    implements Parcelable, bn
{

    public static final android.os.Parcelable.Creator CREATOR = new bvs();
    private final String a;
    private final Uri b;
    private final String c;
    private final boolean d;
    private final float e;
    private final int f;
    private final Uri g;
    private final String h;

    public bvr(String s, String s1, Uri uri, String s2, boolean flag, float f1, Uri uri1, 
            int i)
    {
        a = s;
        h = s1;
        b = uri;
        c = s2;
        d = flag;
        e = f1;
        g = uri1;
        f = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            obj = (bvr)obj;
            if (b.a(a, ((bvr) (obj)).a) && b.a(h, ((bvr) (obj)).h) && b.a(b, ((bvr) (obj)).b) && b.a(c, ((bvr) (obj)).c) && b.a(Float.valueOf(e), Float.valueOf(((bvr) (obj)).e)) && b.a(g, ((bvr) (obj)).g) && b.a(Integer.valueOf(f), Integer.valueOf(((bvr) (obj)).f)))
            {
                return true;
            }
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeString(h);
        parcel.writeParcelable(b, 0);
        parcel.writeString(c);
        if (d)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeFloat(e);
        parcel.writeParcelable(g, 0);
        parcel.writeInt(f);
    }

    static 
    {
        new bvu();
    }
}
