// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zznd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            zzh, zze

public final class MetadataBundle
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    final int mVersionCode;
    final Bundle zzamG;

    MetadataBundle(int i, Bundle bundle)
    {
        mVersionCode = i;
        zzamG = (Bundle)zzx.zzw(bundle);
        zzamG.setClassLoader(getClass().getClassLoader());
        bundle = new ArrayList();
        Iterator iterator = zzamG.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            if (zze.zzcF(s1) == null)
            {
                bundle.add(s1);
                zzz.zzy("MetadataBundle", (new StringBuilder()).append("Ignored unknown metadata field in bundle: ").append(s1).toString());
            }
        } while (true);
        String s;
        for (bundle = bundle.iterator(); bundle.hasNext(); zzamG.remove(s))
        {
            s = (String)bundle.next();
        }

    }

    private MetadataBundle(Bundle bundle)
    {
        this(1, bundle);
    }

    public static MetadataBundle zza(MetadataField metadatafield, Object obj)
    {
        MetadataBundle metadatabundle = zzrM();
        metadatabundle.zzb(metadatafield, obj);
        return metadatabundle;
    }

    public static MetadataBundle zza(MetadataBundle metadatabundle)
    {
        return new MetadataBundle(new Bundle(metadatabundle.zzamG));
    }

    public static MetadataBundle zzrM()
    {
        return new MetadataBundle(new Bundle());
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof MetadataBundle))
        {
            return false;
        }
        obj = (MetadataBundle)obj;
        Object obj1 = zzamG.keySet();
        if (!((Set) (obj1)).equals(((MetadataBundle) (obj)).zzamG.keySet()))
        {
            return false;
        }
        for (obj1 = ((Set) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            String s = (String)((Iterator) (obj1)).next();
            if (!zzw.equal(zzamG.get(s), ((MetadataBundle) (obj)).zzamG.get(s)))
            {
                return false;
            }
        }

        return true;
    }

    public int hashCode()
    {
        Iterator iterator = zzamG.keySet().iterator();
        String s;
        int i;
        for (i = 1; iterator.hasNext(); i = zzamG.get(s).hashCode() + i * 31)
        {
            s = (String)iterator.next();
        }

        return i;
    }

    public void setContext(Context context)
    {
        BitmapTeleporter bitmapteleporter = (BitmapTeleporter)zza(zznd.zzano);
        if (bitmapteleporter != null)
        {
            bitmapteleporter.zzc(context.getCacheDir());
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("MetadataBundle [values=").append(zzamG).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

    public Object zza(MetadataField metadatafield)
    {
        return metadatafield.zzj(zzamG);
    }

    public void zzb(MetadataField metadatafield, Object obj)
    {
        if (zze.zzcF(metadatafield.getName()) == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unregistered field: ").append(metadatafield.getName()).toString());
        } else
        {
            metadatafield.zza(obj, zzamG);
            return;
        }
    }

    public boolean zzc(MetadataField metadatafield)
    {
        return zzamG.containsKey(metadatafield.getName());
    }

    public Set zzrN()
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = zzamG.keySet().iterator(); iterator.hasNext(); hashset.add(zze.zzcF((String)iterator.next()))) { }
        return hashset;
    }

}
