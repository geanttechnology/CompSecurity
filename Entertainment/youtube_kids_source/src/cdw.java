// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class cdw
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new cdx();
    private static SparseArray b;
    private static final SparseIntArray c;
    public final int a;
    private final int d;
    private Uri e;
    private String f;
    private boolean g;
    private boolean h;
    private String i;
    private long j;

    cdw(int k, Uri uri, String s, int l, String s1, long l1)
    {
        boolean flag1 = true;
        super();
        a = k;
        b.a(uri);
        Uri uri1 = uri;
        if (s != null)
        {
            uri1 = bnf.a(uri).a("dnc", "1").a.build();
        }
        e = uri1;
        f = s;
        i = s1;
        boolean flag;
        if (l1 >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        j = l1;
        h = "video/wvm".equals(s1);
        uri = (cdz)b.get(k);
        if (l >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        k = l;
        if (uri != null)
        {
            k = l;
            if (l == 0)
            {
                k = ((cdz) (uri)).a;
            }
        }
        d = k;
        if (uri != null && ((cdz) (uri)).c)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        g = flag;
    }

    public cdw(Parcel parcel)
    {
        this(parcel.readInt(), (Uri)parcel.readParcelable(android/net/Uri.getClassLoader()), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readLong());
    }

    public static SparseIntArray a()
    {
        return c;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        throw new InvalidObjectException("builder required");
    }

    private Object writeReplace()
    {
        cdy cdy1 = new cdy();
        cdy1.b = e;
        cdy1.f = f;
        cdy1.c = d;
        cdy1.e = j;
        cdy1.d = i;
        cdy1.a = a;
        return cdy1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof cdw))
            {
                return false;
            }
            obj = (cdw)obj;
            if (a != ((cdw) (obj)).a || d != ((cdw) (obj)).d || !e.equals(((cdw) (obj)).e) || !b.a(f, ((cdw) (obj)).f) || g != ((cdw) (obj)).g || h != ((cdw) (obj)).h || !b.a(i, ((cdw) (obj)).i))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return e.hashCode();
    }

    public final String toString()
    {
        String s = String.valueOf(e);
        String s1 = f;
        int k = d;
        String s2 = i;
        int l = a;
        long l1 = j;
        return (new StringBuilder(String.valueOf(s).length() + 54 + String.valueOf(s1).length() + String.valueOf(s2).length())).append("[").append(s).append(", ").append(s1).append(", ").append(k).append(", ").append(s2).append(", ").append(l).append(", ").append(l1).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int k)
    {
        parcel.writeInt(a);
        parcel.writeParcelable(e, 0);
        parcel.writeString(f);
        parcel.writeInt(d);
        parcel.writeString(i);
        parcel.writeLong(j);
    }

    static 
    {
        int k = 0;
        SparseArray sparsearray = new SparseArray();
        b = sparsearray;
        sparsearray.append(5, new cdz(7, 426, 240, false, false));
        b.append(17, new cdz(2, 176, 144, false, false));
        b.append(18, new cdz(3, 640, 360, false, false));
        b.append(22, new cdz(8, 1280, 720, false, false));
        b.append(36, new cdz(9, 320, 240, false, false));
        b.append(37, new cdz(30, 1920, 1080, false, false));
        b.append(62, new cdz(14, 0, 480, false, false));
        b.append(64, new cdz(31, 0, 1080, false, false));
        b.append(80, new cdz(11, 0, 405, false, false));
        b.append(81, new cdz(12, 0, 360, false, false));
        b.append(82, new cdz(21, 640, 360, false, true));
        b.append(83, new cdz(22, 854, 480, false, true));
        b.append(84, new cdz(23, 1280, 720, false, true));
        b.append(88, new cdz(13, 0, 720, false, false));
        b.append(100, new cdz(24, 640, 360, false, true));
        b.append(101, new cdz(25, 854, 480, false, true));
        b.append(102, new cdz(26, 1280, 720, false, true));
        b.append(113, new cdz(16, 0, 720, true, false));
        b.append(114, new cdz(15, 0, 480, true, false));
        b.append(119, new cdz(20, 0, 240, false, false));
        b.append(159, new cdz(32, 0, 1080, true, false));
        b.append(180, new cdz(35, 0, 1080, true, false));
        b.append(186, new cdz(34, 0, 720, true, false));
        b.append(193, new cdz(38, 0, 405, false, false));
        b.append(93, new cdz(28, 0, 0, false, false));
        c = new SparseIntArray();
        for (; k < b.size(); k++)
        {
            c.put(((cdz)b.valueAt(k)).b, b.keyAt(k));
        }

    }
}
