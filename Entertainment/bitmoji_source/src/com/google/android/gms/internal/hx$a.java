// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            hx, hw, ep

public static final class Ou
    implements SafeParcelable
{
    public static class a
    {

        private final String LE;
        private String Ot;
        private int Ou;
        private final String mTag;

        public a aK(String s)
        {
            Ot = s;
            return this;
        }

        public a bv(int i)
        {
            Ou = i;
            return this;
        }

        public hx.a gJ()
        {
            return new hx.a(0, LE, mTag, Ot, Ou);
        }

        public a(String s, String s1)
        {
            LE = s;
            mTag = s1;
        }
    }


    public static final hw CREATOR = new hw();
    private final String LE;
    private final String Ot;
    private final int Ou;
    private final String mTag;
    final int wj;

    public int describeContents()
    {
        hw hw1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof CREATOR))
            {
                return false;
            }
            obj = (CREATOR)obj;
            if (!LE.equals(((LE) (obj)).LE) || !ep.equal(mTag, ((mTag) (obj)).mTag))
            {
                return false;
            }
        }
        return true;
    }

    public String gH()
    {
        return Ot;
    }

    public int gI()
    {
        return Ou;
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
            LE, mTag, Ot, Integer.valueOf(Ou)
        });
    }

    public String toString()
    {
        return ep.e(this).a("placeId", LE).a("tag", mTag).a("callingAppPackageName", Ot).a("callingAppVersionCode", Integer.valueOf(Ou)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hw hw1 = CREATOR;
        hw.a(this, parcel, i);
    }


    a.mTag(int i, String s, String s1, String s2, int j)
    {
        wj = i;
        LE = s;
        mTag = s1;
        Ot = s2;
        Ou = j;
    }
}
