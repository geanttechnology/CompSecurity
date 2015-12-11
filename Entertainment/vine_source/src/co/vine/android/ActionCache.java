// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public class ActionCache
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ActionCache createFromParcel(Parcel parcel)
        {
            return new ActionCache(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ActionCache[] newArray(int i)
        {
            return new ActionCache[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    protected final HashMap mCache;

    public ActionCache()
    {
        mCache = new HashMap();
    }

    public ActionCache(Parcel parcel)
    {
        mCache = (HashMap)parcel.readSerializable();
    }

    public void clear()
    {
        mCache.clear();
    }

    public boolean contains(long l)
    {
        return mCache.containsKey(Long.valueOf(l));
    }

    public int describeContents()
    {
        return 0;
    }

    public void removeEntry(long l)
    {
        mCache.remove(Long.valueOf(l));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mCache);
    }

}
