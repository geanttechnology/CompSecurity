// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet
{
    public static class Builder
    {

        private final MetadataBundle zzagS = MetadataBundle.zzrb();
        private com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza zzagT;

        private int zzcE(String s)
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

        private com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza zzqq()
        {
            if (zzagT == null)
            {
                zzagT = new com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza();
            }
            return zzagT;
        }

        public MetadataChangeSet build()
        {
            if (zzagT != null)
            {
                zzagS.zzb(zzmb.zzakq, zzagT.zzqY());
            }
            return new MetadataChangeSet(zzagS);
        }

        public Builder deleteCustomProperty(CustomPropertyKey custompropertykey)
        {
            zzx.zzb(custompropertykey, "key");
            zzqq().zza(custompropertykey, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey custompropertykey, String s)
        {
            zzx.zzb(custompropertykey, "key");
            zzx.zzb(s, "value");
            zzk("The total size of key string and value string of a custom property", 124, zzcE(custompropertykey.getKey()) + zzcE(s));
            zzqq().zza(custompropertykey, s);
            return this;
        }

        public Builder setDescription(String s)
        {
            zzagS.zzb(zzmb.zzakr, s);
            return this;
        }

        public Builder setIndexableText(String s)
        {
            zzk("Indexable text size", 0x20000, zzcE(s));
            zzagS.zzb(zzmb.zzakx, s);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date)
        {
            zzagS.zzb(zzmd.zzale, date);
            return this;
        }

        public Builder setMimeType(String s)
        {
            zzagS.zzb(zzmb.zzakL, s);
            return this;
        }

        public Builder setPinned(boolean flag)
        {
            zzagS.zzb(zzmb.zzakD, Boolean.valueOf(flag));
            return this;
        }

        public Builder setStarred(boolean flag)
        {
            zzagS.zzb(zzmb.zzakS, Boolean.valueOf(flag));
            return this;
        }

        public Builder setTitle(String s)
        {
            zzagS.zzb(zzmb.zzakU, s);
            return this;
        }

        public Builder setViewed(boolean flag)
        {
            zzagS.zzb(zzmb.zzakK, Boolean.valueOf(flag));
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
    public static final MetadataChangeSet zzagR = new MetadataChangeSet(MetadataBundle.zzrb());
    private final MetadataBundle zzagS;

    public MetadataChangeSet(MetadataBundle metadatabundle)
    {
        zzagS = MetadataBundle.zza(metadatabundle);
    }

    public Map getCustomPropertyChangeMap()
    {
        AppVisibleCustomProperties appvisiblecustomproperties = (AppVisibleCustomProperties)zzagS.zza(zzmb.zzakq);
        if (appvisiblecustomproperties == null)
        {
            return Collections.emptyMap();
        } else
        {
            return appvisiblecustomproperties.zzqX();
        }
    }

    public String getDescription()
    {
        return (String)zzagS.zza(zzmb.zzakr);
    }

    public String getIndexableText()
    {
        return (String)zzagS.zza(zzmb.zzakx);
    }

    public Date getLastViewedByMeDate()
    {
        return (Date)zzagS.zza(zzmd.zzale);
    }

    public String getMimeType()
    {
        return (String)zzagS.zza(zzmb.zzakL);
    }

    public String getTitle()
    {
        return (String)zzagS.zza(zzmb.zzakU);
    }

    public Boolean isPinned()
    {
        return (Boolean)zzagS.zza(zzmb.zzakD);
    }

    public Boolean isStarred()
    {
        return (Boolean)zzagS.zza(zzmb.zzakS);
    }

    public Boolean isViewed()
    {
        return (Boolean)zzagS.zza(zzmb.zzakK);
    }

    public MetadataBundle zzqp()
    {
        return zzagS;
    }

}
