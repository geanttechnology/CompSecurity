// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class bsv
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new bsw();
    public final dto a;
    private Uri b;

    public bsv(dto dto1)
    {
        a = (dto)b.a(dto1);
    }

    public final Uri a()
    {
        if (b == null && a.a != null)
        {
            String s = String.valueOf(a.a);
            if (s.length() != 0)
            {
                s = "?".concat(s);
            } else
            {
                s = new String("?");
            }
            b = Uri.parse(s);
        }
        return b;
    }

    public final boolean a(String s)
    {
        return a() != null && a().getQueryParameter(s) != null;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !getClass().equals(obj.getClass())) 
        {
            return false;
        }
        obj = (bsv)obj;
        return eun.a(a, ((bsv) (obj)).a);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        a.a(parcel, a);
    }

}
