// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.cast:
//            zza

public final class ApplicationMetadata
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    String mName;
    private final int mVersionCode;
    String zzSX;
    List zzSY;
    String zzSZ;
    Uri zzTa;
    List zzvL;

    private ApplicationMetadata()
    {
        mVersionCode = 1;
        zzvL = new ArrayList();
        zzSY = new ArrayList();
    }

    ApplicationMetadata(int i, String s, String s1, List list, List list1, String s2, Uri uri)
    {
        mVersionCode = i;
        zzSX = s;
        mName = s1;
        zzvL = list;
        zzSY = list1;
        zzSZ = s2;
        zzTa = uri;
    }

    public boolean areNamespacesSupported(List list)
    {
        return zzSY != null && zzSY.containsAll(list);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ApplicationMetadata))
            {
                return false;
            }
            obj = (ApplicationMetadata)obj;
            if (!zzf.zza(zzSX, ((ApplicationMetadata) (obj)).zzSX) || !zzf.zza(zzvL, ((ApplicationMetadata) (obj)).zzvL) || !zzf.zza(mName, ((ApplicationMetadata) (obj)).mName) || !zzf.zza(zzSY, ((ApplicationMetadata) (obj)).zzSY) || !zzf.zza(zzSZ, ((ApplicationMetadata) (obj)).zzSZ) || !zzf.zza(zzTa, ((ApplicationMetadata) (obj)).zzTa))
            {
                return false;
            }
        }
        return true;
    }

    public String getApplicationId()
    {
        return zzSX;
    }

    public List getImages()
    {
        return zzvL;
    }

    public String getName()
    {
        return mName;
    }

    public String getSenderAppIdentifier()
    {
        return zzSZ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(mVersionCode), zzSX, mName, zzvL, zzSY, zzSZ, zzTa
        });
    }

    public boolean isNamespaceSupported(String s)
    {
        return zzSY != null && zzSY.contains(s);
    }

    public String toString()
    {
        boolean flag = false;
        StringBuilder stringbuilder = (new StringBuilder()).append("applicationId: ").append(zzSX).append(", name: ").append(mName).append(", images.count: ");
        int i;
        if (zzvL == null)
        {
            i = 0;
        } else
        {
            i = zzvL.size();
        }
        stringbuilder = stringbuilder.append(i).append(", namespaces.count: ");
        if (zzSY == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = zzSY.size();
        }
        return stringbuilder.append(i).append(", senderAppIdentifier: ").append(zzSZ).append(", senderAppLaunchUrl: ").append(zzTa).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public Uri zzlM()
    {
        return zzTa;
    }

}
