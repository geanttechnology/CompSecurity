// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;
import java.util.Date;

// Referenced classes of package com.google.android.gms.drive:
//            MetadataChangeSet

public static class 
{

    private final MetadataBundle zzajd = MetadataBundle.zzrM();
    private com.google.android.gms.drive.metadata.internal..zza zzaje;

    private int zzcD(String s)
    {
        if (s == null)
        {
            return 0;
        } else
        {
            return s.getBytes().length;
        }
    }

    private String zzj(String s, int i, int j)
    {
        return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    private void zzk(String s, int i, int j)
    {
        boolean flag;
        if (j <= i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, zzj(s, i, j));
    }

    private com.google.android.gms.drive.metadata.internal..zza zzqX()
    {
        if (zzaje == null)
        {
            zzaje = new com.google.android.gms.drive.metadata.internal..zza();
        }
        return zzaje;
    }

    public MetadataChangeSet build()
    {
        if (zzaje != null)
        {
            zzajd.zzb(zznd.zzamL, zzaje.zzrI());
        }
        return new MetadataChangeSet(zzajd);
    }

    public  deleteCustomProperty(CustomPropertyKey custompropertykey)
    {
        zzx.zzb(custompropertykey, "key");
        zzqX().zza(custompropertykey, null);
        return this;
    }

    public  setCustomProperty(CustomPropertyKey custompropertykey, String s)
    {
        zzx.zzb(custompropertykey, "key");
        zzx.zzb(s, "value");
        zzk("The total size of key string and value string of a custom property", 124, zzcD(custompropertykey.getKey()) + zzcD(s));
        zzqX().zza(custompropertykey, s);
        return this;
    }

    public  setDescription(String s)
    {
        zzajd.zzb(zznd.zzamM, s);
        return this;
    }

    public Bundle.zzb setIndexableText(String s)
    {
        zzk("Indexable text size", 0x20000, zzcD(s));
        zzajd.zzb(zznd.zzamS, s);
        return this;
    }

    public Bundle.zzb setLastViewedByMeDate(Date date)
    {
        zzajd.zzb(zznf.zzanC, date);
        return this;
    }

    public Bundle.zzb setMimeType(String s)
    {
        zzajd.zzb(zznd.zzang, s);
        return this;
    }

    public Bundle.zzb setPinned(boolean flag)
    {
        zzajd.zzb(zznd.zzamY, Boolean.valueOf(flag));
        return this;
    }

    public Bundle.zzb setStarred(boolean flag)
    {
        zzajd.zzb(zznd.zzann, Boolean.valueOf(flag));
        return this;
    }

    public Bundle.zzb setTitle(String s)
    {
        zzajd.zzb(zznd.zzanp, s);
        return this;
    }

    public Bundle.zzb setViewed(boolean flag)
    {
        zzajd.zzb(zznd.zzanf, Boolean.valueOf(flag));
        return this;
    }

    public ()
    {
    }
}
