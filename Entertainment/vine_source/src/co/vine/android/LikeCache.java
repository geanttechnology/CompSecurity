// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            ActionCache

public class LikeCache extends ActionCache
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LikeCache createFromParcel(Parcel parcel)
        {
            return new LikeCache(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LikeCache[] newArray(int i)
        {
            return new LikeCache[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    public LikeCache()
    {
    }

    public LikeCache(Parcel parcel)
    {
        super(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean isLike(long l)
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

    public void like(long l)
    {
        mCache.put(Long.valueOf(l), Boolean.valueOf(true));
    }

    public void unlike(long l)
    {
        mCache.put(Long.valueOf(l), Boolean.valueOf(false));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
    }

}
