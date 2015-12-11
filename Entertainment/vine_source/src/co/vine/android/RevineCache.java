// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            ActionCache

public class RevineCache extends ActionCache
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RevineCache createFromParcel(Parcel parcel)
        {
            return new RevineCache(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RevineCache[] newArray(int i)
        {
            return new RevineCache[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    HashMap mRepostIdMap;

    public RevineCache()
    {
        mRepostIdMap = new HashMap();
    }

    public RevineCache(Parcel parcel)
    {
        super(parcel);
        mRepostIdMap = (HashMap)parcel.readSerializable();
    }

    public int describeContents()
    {
        return 0;
    }

    public long getMyRepostId(long l)
    {
        if (mRepostIdMap.containsKey(Long.valueOf(l)))
        {
            return ((Long)mRepostIdMap.get(Long.valueOf(l))).longValue();
        } else
        {
            return 0L;
        }
    }

    public boolean isRevined(long l)
    {
        Boolean boolean1 = (Boolean)mCache.get(Long.valueOf(l));
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public void putMyRepostId(long l, long l1)
    {
        mRepostIdMap.put(Long.valueOf(l), Long.valueOf(l1));
    }

    public void removeMyRepostId(long l)
    {
        mRepostIdMap.remove(Long.valueOf(l));
    }

    public void revine(long l)
    {
        mCache.put(Long.valueOf(l), Boolean.valueOf(true));
    }

    public void unRevine(long l)
    {
        mCache.put(Long.valueOf(l), Boolean.valueOf(false));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeSerializable(mRepostIdMap);
    }

}
