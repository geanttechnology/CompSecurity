// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

// Referenced classes of package com.google.android.gms.common.images:
//            b

public final class WebImage
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new b();
    private final Uri Fu;
    private final int ku;
    private final int kv;
    private final int xM;

    WebImage(int i, Uri uri, int j, int k)
    {
        xM = i;
        Fu = uri;
        ku = j;
        kv = k;
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
            if (!hk.equal(Fu, ((WebImage) (obj)).Fu) || ku != ((WebImage) (obj)).ku || kv != ((WebImage) (obj)).kv)
            {
                return false;
            }
        }
        return true;
    }

    public int getHeight()
    {
        return kv;
    }

    public Uri getUrl()
    {
        return Fu;
    }

    int getVersionCode()
    {
        return xM;
    }

    public int getWidth()
    {
        return ku;
    }

    public int hashCode()
    {
        return hk.hashCode(new Object[] {
            Fu, Integer.valueOf(ku), Integer.valueOf(kv)
        });
    }

    public String toString()
    {
        return String.format("Image %dx%d %s", new Object[] {
            Integer.valueOf(ku), Integer.valueOf(kv), Fu.toString()
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        b.a(this, parcel, i);
    }

}
