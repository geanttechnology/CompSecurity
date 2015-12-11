// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class czi
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new czj();
    public final Map a;

    public czi(Parcel parcel)
    {
        ClassLoader classloader = getClass().getClassLoader();
        int j = parcel.readInt();
        a = new HashMap();
        for (int i = 0; i < j; i++)
        {
            String s = parcel.readString();
            Parcelable parcelable = parcel.readParcelable(classloader);
            a.put(s, parcelable);
        }

    }

    public czi(Map map)
    {
        a = (Map)b.a(map);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); parcel.writeParcelable((Parcelable)entry.getValue(), 0))
        {
            entry = (java.util.Map.Entry)iterator.next();
            parcel.writeString((String)entry.getKey());
        }

    }

}
