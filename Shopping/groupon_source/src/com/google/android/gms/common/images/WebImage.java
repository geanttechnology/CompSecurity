// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

// Referenced classes of package com.google.android.gms.common.images:
//            zzb

public final class WebImage
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int zzCY;
    private final Uri zzZn;
    private final int zznM;
    private final int zznN;

    WebImage(int i, Uri uri, int j, int k)
    {
        zzCY = i;
        zzZn = uri;
        zznM = j;
        zznN = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof WebImage))
            {
                return false;
            }
            obj = (WebImage)obj;
            if (!zzt.equal(zzZn, ((WebImage) (obj)).zzZn) || zznM != ((WebImage) (obj)).zznM || zznN != ((WebImage) (obj)).zznN)
            {
                return false;
            }
        }
        return true;
    }

    public int getHeight()
    {
        return zznN;
    }

    public Uri getUrl()
    {
        return zzZn;
    }

    int getVersionCode()
    {
        return zzCY;
    }

    public int getWidth()
    {
        return zznM;
    }

    public int hashCode()
    {
        return zzt.hashCode(new Object[] {
            zzZn, Integer.valueOf(zznM), Integer.valueOf(zznN)
        });
    }

    public String toString()
    {
        return String.format("Image %dx%d %s", new Object[] {
            Integer.valueOf(zznM), Integer.valueOf(zznN), zzZn.toString()
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
