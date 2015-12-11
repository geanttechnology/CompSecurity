// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            em, ee

public final class el
    implements SafeParcelable
{

    public static final em CREATOR = new em();
    private final int kg;
    private final Bundle nN;
    private final int os;
    private final int pX;
    private final String pY;
    private final String pZ;
    private final String qa;
    private final String qb;

    el(int i, int j, int k, String s, String s1, String s2, String s3, 
            Bundle bundle)
    {
        kg = i;
        os = j;
        pX = k;
        pY = s;
        pZ = s1;
        qa = s2;
        qb = s3;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        nN = bundle;
    }

    public int bY()
    {
        return pX;
    }

    public String bZ()
    {
        return pY;
    }

    public String ca()
    {
        return pZ;
    }

    public String cb()
    {
        return qb;
    }

    public boolean cc()
    {
        return os == 1 && pX == -1;
    }

    public boolean cd()
    {
        return os == 2;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof el)
        {
            if (kg == ((el) (obj = (el)obj)).kg && os == ((el) (obj)).os && pX == ((el) (obj)).pX && ee.equal(pY, ((el) (obj)).pY) && ee.equal(pZ, ((el) (obj)).pZ))
            {
                return true;
            }
        }
        return false;
    }

    public String getDisplayName()
    {
        return qa;
    }

    public Bundle getMetadata()
    {
        return nN;
    }

    public int getType()
    {
        return os;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            Integer.valueOf(kg), Integer.valueOf(os), Integer.valueOf(pX), pY, pZ
        });
    }

    public String toString()
    {
        if (cd())
        {
            return String.format("Person [%s] %s", new Object[] {
                ca(), getDisplayName()
            });
        }
        if (cc())
        {
            return String.format("Circle [%s] %s", new Object[] {
                bZ(), getDisplayName()
            });
        } else
        {
            return String.format("Group [%s] %s", new Object[] {
                bZ(), getDisplayName()
            });
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        em.a(this, parcel, i);
    }

}
