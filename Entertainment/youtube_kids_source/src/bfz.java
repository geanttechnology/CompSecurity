// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class bfz
    implements Parcelable, bn
{

    public static final android.os.Parcelable.Creator CREATOR = new bga();
    public final bfp a;
    public final String b;
    public final String c;
    public final byte d[];
    public final List e;
    public final List f;
    public final List g;
    public final List h;
    public final List i;
    public final bfu j;
    public final String k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    public bfz(Parcel parcel)
    {
        bfp bfp1 = new bfp(bft.values()[parcel.readInt()], parcel.readLong());
        String s;
        String s1;
        byte abyte0[];
        Object obj;
        List list;
        List list1;
        List list2;
        Object obj1;
        bfu bfu1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (parcel.readInt() == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (parcel.readInt() == 1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        s = parcel.readString();
        s1 = parcel.readString();
        abyte0 = new byte[parcel.readInt()];
        parcel.readByteArray(abyte0);
        obj = new ArrayList();
        parcel.readTypedList(((List) (obj)), buz.CREATOR);
        obj = Collections.unmodifiableList(((List) (obj)));
        list = a(parcel);
        list1 = a(parcel);
        list2 = a(parcel);
        obj1 = new ArrayList();
        parcel.readTypedList(((List) (obj1)), bfp.CREATOR);
        obj1 = Collections.unmodifiableList(((List) (obj1)));
        bfu1 = (bfu)parcel.readParcelable(bfu.getClassLoader());
        if (parcel.readInt() == 1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        this(bfp1, flag, flag1, flag2, s, s1, abyte0, ((List) (obj)), list, list1, list2, ((List) (obj1)), bfu1, flag3, parcel.readString());
    }

    bfz(bfp bfp1, boolean flag, boolean flag1, boolean flag2, String s, String s1, byte abyte0[], 
            List list, List list1, List list2, List list3, List list4, bfu bfu1, boolean flag3, 
            String s2)
    {
        a = (bfp)b.a(bfp1);
        f = a.a(list1);
        g = a.a(list2);
        h = a.a(list3);
        i = a.a(list4);
        j = bfu1;
        l = flag;
        m = flag1;
        n = flag2;
        b = b.a(s, "adBreakId must not be empty");
        c = (String)b.b(s1, "originalVideoId must not be null");
        d = (byte[])b.a(abyte0);
        e = a.a(list);
        o = flag3;
        k = s2;
    }

    private static List a(Parcel parcel)
    {
        ArrayList arraylist = new ArrayList();
        parcel.readTypedList(arraylist, Uri.CREATOR);
        return Collections.unmodifiableList(arraylist);
    }

    public final bgc a()
    {
        bgc bgc1 = new bgc();
        bgc1.b = a;
        bgc1.c = l;
        bgc1.d = m;
        bgc1.e = n;
        bgc1.a = b;
        bgc1.f = c;
        bgc1 = bgc1.a(d);
        bgc1.g = e;
        bgc1.k = i;
        bgc1.m = o;
        bgc1.n = k;
        bgc.a(bgc1, f);
        bgc.b(bgc1, g);
        bgc.c(bgc1, h);
        return bgc1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            if (a.a == ((bfz) (obj = (bfz)obj)).a.a && a.b == ((bfz) (obj)).a.b && l == ((bfz) (obj)).l && m == ((bfz) (obj)).m && n == ((bfz) (obj)).n && b.a(b, ((bfz) (obj)).b) && b.a(c, ((bfz) (obj)).c) && b.a(e, ((bfz) (obj)).e) && b.a(f, ((bfz) (obj)).f) && b.a(g, ((bfz) (obj)).g) && b.a(h, ((bfz) (obj)).h) && b.a(i, ((bfz) (obj)).i) && b.a(j, ((bfz) (obj)).j) && o == ((bfz) (obj)).o && Arrays.equals(d, ((bfz) (obj)).d))
            {
                return true;
            }
        }
        return false;
    }

    public final String toString()
    {
        String s1 = b;
        bft bft1 = a.a;
        long l1 = a.b;
        boolean flag = l;
        boolean flag1 = m;
        boolean flag2 = n;
        String s;
        if (e != null)
        {
            s = Arrays.toString(e.toArray());
        } else
        {
            s = "none";
        }
        return String.format("VastAdBreak: [id=%s, offsetType=%s, offset:%s, allow:[l:%s , nl:%s, da:%s] ads: %s]", new Object[] {
            s1, bft1, Long.valueOf(l1), Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(flag2), s
        });
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        parcel.writeInt(a.a.ordinal());
        parcel.writeLong(a.b);
        if (l)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
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
        parcel.writeString(b);
        parcel.writeString(c);
        parcel.writeInt(d.length);
        parcel.writeByteArray(d);
        parcel.writeTypedList(e);
        parcel.writeTypedList(f);
        parcel.writeTypedList(g);
        parcel.writeTypedList(h);
        parcel.writeTypedList(i);
        parcel.writeParcelable(j, 0);
        if (o)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeString(k);
    }

    static 
    {
        new bgd();
    }
}
