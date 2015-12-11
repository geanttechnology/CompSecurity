// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            ie, ep

public class id
    implements SafeParcelable
{

    public static final ie CREATOR = new ie();
    public final String OG;
    public final String OH;
    public final int versionCode;

    public id(int i, String s, String s1)
    {
        versionCode = i;
        OG = s;
        OH = s1;
    }

    public id(Context context, Locale locale)
    {
        versionCode = 0;
        OG = context.getPackageName();
        OH = locale.toString();
    }

    public int describeContents()
    {
        ie ie1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof id))
            {
                return false;
            }
            obj = (id)obj;
            if (!OH.equals(((id) (obj)).OH) || !OG.equals(((id) (obj)).OG))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return ep.hashCode(new Object[] {
            OG, OH
        });
    }

    public String toString()
    {
        return ep.e(this).a("clientPackageName", OG).a("locale", OH).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ie ie1 = CREATOR;
        ie.a(this, parcel, i);
    }

}
