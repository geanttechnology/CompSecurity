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
    String zzUM;
    List zzUN;
    String zzUO;
    Uri zzUP;
    List zzwp;

    private ApplicationMetadata()
    {
        mVersionCode = 1;
        zzwp = new ArrayList();
        zzUN = new ArrayList();
    }

    ApplicationMetadata(int i, String s, String s1, List list, List list1, String s2, Uri uri)
    {
        mVersionCode = i;
        zzUM = s;
        mName = s1;
        zzwp = list;
        zzUN = list1;
        zzUO = s2;
        zzUP = uri;
    }

    public boolean areNamespacesSupported(List list)
    {
        return zzUN != null && zzUN.containsAll(list);
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
            if (!zzf.zza(zzUM, ((ApplicationMetadata) (obj)).zzUM) || !zzf.zza(zzwp, ((ApplicationMetadata) (obj)).zzwp) || !zzf.zza(mName, ((ApplicationMetadata) (obj)).mName) || !zzf.zza(zzUN, ((ApplicationMetadata) (obj)).zzUN) || !zzf.zza(zzUO, ((ApplicationMetadata) (obj)).zzUO) || !zzf.zza(zzUP, ((ApplicationMetadata) (obj)).zzUP))
            {
                return false;
            }
        }
        return true;
    }

    public String getApplicationId()
    {
        return zzUM;
    }

    public List getImages()
    {
        return zzwp;
    }

    public String getName()
    {
        return mName;
    }

    public String getSenderAppIdentifier()
    {
        return zzUO;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(mVersionCode), zzUM, mName, zzwp, zzUN, zzUO, zzUP
        });
    }

    public boolean isNamespaceSupported(String s)
    {
        return zzUN != null && zzUN.contains(s);
    }

    public String toString()
    {
        boolean flag = false;
        StringBuilder stringbuilder = (new StringBuilder()).append("applicationId: ").append(zzUM).append(", name: ").append(mName).append(", images.count: ");
        int i;
        if (zzwp == null)
        {
            i = 0;
        } else
        {
            i = zzwp.size();
        }
        stringbuilder = stringbuilder.append(i).append(", namespaces.count: ");
        if (zzUN == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = zzUN.size();
        }
        return stringbuilder.append(i).append(", senderAppIdentifier: ").append(zzUO).append(", senderAppLaunchUrl: ").append(zzUP).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public Uri zzmj()
    {
        return zzUP;
    }

}
