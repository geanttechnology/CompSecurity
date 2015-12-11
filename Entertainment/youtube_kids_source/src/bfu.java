// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.util.regex.Pattern;

public class bfu
    implements Parcelable, bn
{

    public static final android.os.Parcelable.Creator CREATOR = new bfv();
    public static final bfu a = new bfu("^invalidurl$", false, false);
    public final Pattern b;
    private final boolean c;
    private final boolean d;

    public bfu(Parcel parcel)
    {
        boolean flag1 = true;
        String s = parcel.readString();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (parcel.readInt() != 1)
        {
            flag1 = false;
        }
        this(s, flag, flag1);
    }

    public bfu(String s, boolean flag, boolean flag1)
    {
        b = Pattern.compile((String)b.b(s, "urlMatchRegex cannot be null"));
        d = flag1;
        c = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            obj = (bfu)obj;
            if (b.a(b.pattern(), ((bfu) (obj)).b.pattern()) && b.a(Boolean.valueOf(c), Boolean.valueOf(((bfu) (obj)).c)) && b.a(Boolean.valueOf(d), Boolean.valueOf(((bfu) (obj)).d)))
            {
                return true;
            }
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(b.pattern());
        if (c)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (d)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

    static 
    {
        new bfw();
    }
}
