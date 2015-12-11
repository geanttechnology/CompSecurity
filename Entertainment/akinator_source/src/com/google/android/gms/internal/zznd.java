// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.zzb;
import com.google.android.gms.drive.metadata.internal.zzg;
import com.google.android.gms.drive.metadata.internal.zzi;
import com.google.android.gms.drive.metadata.internal.zzj;
import com.google.android.gms.drive.metadata.internal.zzl;
import com.google.android.gms.drive.metadata.internal.zzn;
import com.google.android.gms.drive.metadata.internal.zzo;
import com.google.android.gms.drive.metadata.internal.zzp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzng, zzne

public class zznd
{
    public static class zza extends zzne
        implements SearchableMetadataField
    {

        public zza(int i)
        {
            super(i);
        }
    }

    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzb
        implements SearchableMetadataField
    {

        public zzb(String s, int i)
        {
            super(s, i);
        }
    }

    public static class zzc extends zzo
        implements SearchableMetadataField
    {

        public zzc(int i)
        {
            super("mimeType", i);
        }
    }

    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzg
        implements SortableMetadataField
    {

        public zzd(String s, int i)
        {
            super(s, i);
        }
    }

    public static class zze extends zzi
    {

        protected Object zzc(DataHolder dataholder, int i, int j)
        {
            return zzd(dataholder, i, j);
        }

        protected Collection zzd(DataHolder dataholder, int i, int j)
        {
            ArrayList arraylist = new ArrayList();
            if (dataholder.zze("inDriveSpace", i, j))
            {
                arraylist.add(DriveSpace.zzaiR);
            }
            if (dataholder.zze("isAppData", i, j))
            {
                arraylist.add(DriveSpace.zzaiS);
            }
            if (dataholder.zze("inGooglePhotosSpace", i, j))
            {
                arraylist.add(DriveSpace.zzaiT);
            }
            return arraylist;
        }

        public zze(int i)
        {
            super("spaces", Arrays.asList(new String[] {
                "inDriveSpace", "isAppData", "inGooglePhotosSpace"
            }), Collections.emptySet(), i);
        }
    }

    public static class zzf extends com.google.android.gms.drive.metadata.internal.zzb
        implements SearchableMetadataField
    {

        public zzf(String s, int i)
        {
            super(s, i);
        }
    }

    public static class zzg extends zzo
        implements SearchableMetadataField, SortableMetadataField
    {

        public zzg(String s, int i)
        {
            super(s, i);
        }
    }

    public static class zzh extends com.google.android.gms.drive.metadata.internal.zzb
        implements SearchableMetadataField
    {

        protected Object zzc(DataHolder dataholder, int i, int j)
        {
            return zze(dataholder, i, j);
        }

        protected Boolean zze(DataHolder dataholder, int i, int j)
        {
            boolean flag;
            if (dataholder.zzc(getName(), i, j) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return Boolean.valueOf(flag);
        }

        public zzh(String s, int i)
        {
            super(s, i);
        }
    }


    public static final MetadataField zzamJ;
    public static final MetadataField zzamK = new zzo("alternateLink", 0x419ce0);
    public static final zza zzamL = new zza(0x4c4b40);
    public static final MetadataField zzamM = new zzo("description", 0x419ce0);
    public static final MetadataField zzamN = new zzo("embedLink", 0x419ce0);
    public static final MetadataField zzamO = new zzo("fileExtension", 0x419ce0);
    public static final MetadataField zzamP = new com.google.android.gms.drive.metadata.internal.zzg("fileSize", 0x419ce0);
    public static final MetadataField zzamQ = new zzo("folderColorRgb", 0x7270e0);
    public static final MetadataField zzamR = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 0x419ce0);
    public static final MetadataField zzamS = new zzo("indexableText", 0x419ce0);
    public static final MetadataField zzamT = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 0x419ce0);
    public static final MetadataField zzamU = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 0x419ce0);
    public static final MetadataField zzamV = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 0x3e8fa0);
    public static final MetadataField zzamW = new com.google.android.gms.drive.metadata.internal.zzb("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 0x6acfc0) {

        protected Object zzc(DataHolder dataholder, int i, int j)
        {
            return zze(dataholder, i, j);
        }

        protected Boolean zze(DataHolder dataholder, int i, int j)
        {
            boolean flag;
            if (dataholder.zzc("trashed", i, j) == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return Boolean.valueOf(flag);
        }

    };
    public static final MetadataField zzamX = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 0x7704c0);
    public static final zzb zzamY = new zzb("isPinned", 0x3e8fa0);
    public static final MetadataField zzamZ = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 0x6ddd00);
    public static final MetadataField zzana = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 0x419ce0);
    public static final MetadataField zzanb = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 0x419ce0);
    public static final MetadataField zzanc = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 0x6acfc0);
    public static final MetadataField zzand = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 0x6acfc0);
    public static final MetadataField zzane = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 0x432380);
    public static final MetadataField zzanf = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 0x419ce0);
    public static final zzc zzang = new zzc(0x3e8fa0);
    public static final MetadataField zzanh = new zzo("originalFilename", 0x419ce0);
    public static final com.google.android.gms.drive.metadata.zzb zzani = new zzn("ownerNames", 0x419ce0);
    public static final zzp zzanj = new zzp("lastModifyingUser", 0x5b8d80);
    public static final zzp zzank = new zzp("sharingUser", 0x5b8d80);
    public static final zzl zzanl = new zzl(0x3e8fa0);
    public static final zzd zzanm = new zzd("quotaBytesUsed", 0x419ce0);
    public static final zzf zzann = new zzf("starred", 0x3e8fa0);
    public static final MetadataField zzano = new zzj("thumbnail", Collections.emptySet(), Collections.emptySet(), 0x432380) {

        protected Object zzc(DataHolder dataholder, int i, int j)
        {
            return zzk(dataholder, i, j);
        }

        protected BitmapTeleporter zzk(DataHolder dataholder, int i, int j)
        {
            throw new IllegalStateException("Thumbnail field is write only");
        }

    };
    public static final zzg zzanp = new zzg("title", 0x3e8fa0);
    public static final zzh zzanq = new zzh("trashed", 0x3e8fa0);
    public static final MetadataField zzanr = new zzo("webContentLink", 0x419ce0);
    public static final MetadataField zzans = new zzo("webViewLink", 0x419ce0);
    public static final MetadataField zzant = new zzo("uniqueIdentifier", 0x4c4b40);
    public static final com.google.android.gms.drive.metadata.internal.zzb zzanu = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 0x5b8d80);
    public static final MetadataField zzanv = new zzo("role", 0x5b8d80);
    public static final MetadataField zzanw = new zzo("md5Checksum", 0x6acfc0);
    public static final zze zzanx = new zze(0x6acfc0);
    public static final MetadataField zzany = new zzo("recencyReason", 0x7a1200);
    public static final MetadataField zzanz = new com.google.android.gms.drive.metadata.internal.zzb("subscribed", 0x7a1200);

    static 
    {
        zzamJ = zzng.zzanH;
    }
}
