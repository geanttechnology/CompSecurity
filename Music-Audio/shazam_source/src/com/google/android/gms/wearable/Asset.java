// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.wearable:
//            s

public class Asset
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new s();
    final int a;
    public byte b[];
    public String c;
    public ParcelFileDescriptor d;
    public Uri e;

    Asset(int i, byte abyte0[], String s1, ParcelFileDescriptor parcelfiledescriptor, Uri uri)
    {
        a = i;
        b = abyte0;
        c = s1;
        d = parcelfiledescriptor;
        e = uri;
    }

    public static Asset a(ParcelFileDescriptor parcelfiledescriptor)
    {
        if (parcelfiledescriptor == null)
        {
            throw new IllegalArgumentException("Asset fd cannot be null");
        } else
        {
            return new Asset(1, null, null, parcelfiledescriptor, null);
        }
    }

    public static Asset a(String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("Asset digest cannot be null");
        } else
        {
            return new Asset(1, null, s1, null, null);
        }
    }

    public static Asset a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Asset data cannot be null");
        } else
        {
            return new Asset(1, abyte0, null, null, null);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Asset))
            {
                return false;
            }
            obj = (Asset)obj;
            if (!v.a(b, ((Asset) (obj)).b) || !v.a(c, ((Asset) (obj)).c) || !v.a(d, ((Asset) (obj)).d) || !v.a(e, ((Asset) (obj)).e))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            b, c, d, e
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Asset[@");
        stringbuilder.append(Integer.toHexString(hashCode()));
        if (c == null)
        {
            stringbuilder.append(", nodigest");
        } else
        {
            stringbuilder.append(", ");
            stringbuilder.append(c);
        }
        if (b != null)
        {
            stringbuilder.append(", size=");
            stringbuilder.append(b.length);
        }
        if (d != null)
        {
            stringbuilder.append(", fd=");
            stringbuilder.append(d);
        }
        if (e != null)
        {
            stringbuilder.append(", uri=");
            stringbuilder.append(e);
        }
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        s.a(this, parcel, i | 1);
    }

}
