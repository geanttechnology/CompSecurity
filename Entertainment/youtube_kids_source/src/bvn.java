// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bvn
    implements Parcelable, bn
{

    public static final android.os.Parcelable.Creator CREATOR = new bvo();
    private final int a;
    private final Uri b;
    private final String c;
    private final List d;

    public bvn(int i, Uri uri, String s, List list)
    {
        a = i;
        b = uri;
        c = s;
        if (list == null)
        {
            list = new ArrayList();
        }
        d = Collections.unmodifiableList(list);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            obj = (bvn)obj;
            if (b.a(Integer.valueOf(a), Integer.valueOf(((bvn) (obj)).a)) && b.a(b, ((bvn) (obj)).b) && b.a(c, ((bvn) (obj)).c) && b.a(d, ((bvn) (obj)).d))
            {
                return true;
            }
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a);
        parcel.writeParcelable(b, 0);
        parcel.writeString(c);
        parcel.writeTypedList(d);
    }

    static 
    {
        new bvq();
    }
}
