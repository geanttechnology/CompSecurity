// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            hq, ep

public class hp
    implements SafeParcelable
{

    public static final hq CREATOR = new hq();
    private final String LE;
    private final String mTag;
    final int wj;

    hp(int i, String s, String s1)
    {
        wj = i;
        LE = s;
        mTag = s1;
    }

    public int describeContents()
    {
        hq hq1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof hp)
        {
            if (ep.equal(LE, ((hp) (obj = (hp)obj)).LE) && ep.equal(mTag, ((hp) (obj)).mTag))
            {
                return true;
            }
        }
        return false;
    }

    public String getTag()
    {
        return mTag;
    }

    public String gt()
    {
        return LE;
    }

    public int hashCode()
    {
        return ep.hashCode(new Object[] {
            LE, mTag
        });
    }

    public String toString()
    {
        return ep.e(this).a("mPlaceId", LE).a("mTag", mTag).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hq hq1 = CREATOR;
        hq.a(this, parcel, i);
    }

}
