// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            hd, ha, ee

public static final class Be
    implements SafeParcelable
{
    public static class a
    {

        private final String Bc;
        private String Bd;
        private int Be;
        private final String mTag;

        public a as(String s)
        {
            Bd = s;
            return this;
        }

        public a bd(int i)
        {
            Be = i;
            return this;
        }

        public hd.a ek()
        {
            return new hd.a(0, Bc, mTag, Bd, Be);
        }

        public a(String s, String s1)
        {
            Bc = s;
            mTag = s1;
        }
    }


    public static final ha CREATOR = new ha();
    private final String Bc;
    private final String Bd;
    private final int Be;
    final int kg;
    private final String mTag;

    public int describeContents()
    {
        ha ha1 = CREATOR;
        return 0;
    }

    public String eh()
    {
        return Bc;
    }

    public String ei()
    {
        return Bd;
    }

    public int ej()
    {
        return Be;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Be))
            {
                return false;
            }
            obj = (Be)obj;
            if (!Bc.equals(((Bc) (obj)).Bc) || !ee.equal(mTag, ((mTag) (obj)).mTag))
            {
                return false;
            }
        }
        return true;
    }

    public String getTag()
    {
        return mTag;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            Bc, mTag, Bd, Integer.valueOf(Be)
        });
    }

    public String toString()
    {
        return ee.e(this).a("placeId", Bc).a("tag", mTag).a("callingAppPackageName", Bd).a("callingAppVersionCode", Integer.valueOf(Be)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ha ha1 = CREATOR;
        ha.a(this, parcel, i);
    }


    a.mTag(int i, String s, String s1, String s2, int j)
    {
        kg = i;
        Bc = s;
        mTag = s1;
        Bd = s2;
        Be = j;
    }
}
