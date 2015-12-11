// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet
{
    public static class Builder
    {

        private final MetadataBundle zzajd = MetadataBundle.zzrM();
        private com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza zzaje;

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

        private com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza zzqX()
        {
            if (zzaje == null)
            {
                zzaje = new com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza();
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

        public Builder deleteCustomProperty(CustomPropertyKey custompropertykey)
        {
            zzx.zzb(custompropertykey, "key");
            zzqX().zza(custompropertykey, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey custompropertykey, String s)
        {
            zzx.zzb(custompropertykey, "key");
            zzx.zzb(s, "value");
            zzk("The total size of key string and value string of a custom property", 124, zzcD(custompropertykey.getKey()) + zzcD(s));
            zzqX().zza(custompropertykey, s);
            return this;
        }

        public Builder setDescription(String s)
        {
            zzajd.zzb(zznd.zzamM, s);
            return this;
        }

        public Builder setIndexableText(String s)
        {
            zzk("Indexable text size", 0x20000, zzcD(s));
            zzajd.zzb(zznd.zzamS, s);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date)
        {
            zzajd.zzb(zznf.zzanC, date);
            return this;
        }

        public Builder setMimeType(String s)
        {
            zzajd.zzb(zznd.zzang, s);
            return this;
        }

        public Builder setPinned(boolean flag)
        {
            zzajd.zzb(zznd.zzamY, Boolean.valueOf(flag));
            return this;
        }

        public Builder setStarred(boolean flag)
        {
            zzajd.zzb(zznd.zzann, Boolean.valueOf(flag));
            return this;
        }

        public Builder setTitle(String s)
        {
            zzajd.zzb(zznd.zzanp, s);
            return this;
        }

        public Builder setViewed(boolean flag)
        {
            zzajd.zzb(zznd.zzanf, Boolean.valueOf(flag));
            return this;
        }

        public Builder()
        {
        }
    }


    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 0x20000;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzajc = new MetadataChangeSet(MetadataBundle.zzrM());
    private final MetadataBundle zzajd;

    public MetadataChangeSet(MetadataBundle metadatabundle)
    {
        zzajd = MetadataBundle.zza(metadatabundle);
    }

    public Map getCustomPropertyChangeMap()
    {
        AppVisibleCustomProperties appvisiblecustomproperties = (AppVisibleCustomProperties)zzajd.zza(zznd.zzamL);
        if (appvisiblecustomproperties == null)
        {
            return Collections.emptyMap();
        } else
        {
            return appvisiblecustomproperties.zzrH();
        }
    }

    public String getDescription()
    {
        return (String)zzajd.zza(zznd.zzamM);
    }

    public String getIndexableText()
    {
        return (String)zzajd.zza(zznd.zzamS);
    }

    public Date getLastViewedByMeDate()
    {
        return (Date)zzajd.zza(zznf.zzanC);
    }

    public String getMimeType()
    {
        return (String)zzajd.zza(zznd.zzang);
    }

    public String getTitle()
    {
        return (String)zzajd.zza(zznd.zzanp);
    }

    public Boolean isPinned()
    {
        return (Boolean)zzajd.zza(zznd.zzamY);
    }

    public Boolean isStarred()
    {
        return (Boolean)zzajd.zza(zznd.zzann);
    }

    public Boolean isViewed()
    {
        return (Boolean)zzajd.zza(zznd.zzanf);
    }

    public MetadataBundle zzqW()
    {
        return zzajd;
    }

}
