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
//            zzme, zzmc

public class zzmb
{
    public static class zza extends zzmc
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
                arraylist.add(DriveSpace.zzagH);
            }
            if (dataholder.zze("isAppData", i, j))
            {
                arraylist.add(DriveSpace.zzagI);
            }
            if (dataholder.zze("inGooglePhotosSpace", i, j))
            {
                arraylist.add(DriveSpace.zzagJ);
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


    public static final MetadataField zzakA = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 0x3e8fa0);
    public static final MetadataField zzakB = new com.google.android.gms.drive.metadata.internal.zzb("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 0x6acfc0) {

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
    public static final MetadataField zzakC = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 0x7704c0);
    public static final zzb zzakD = new zzb("isPinned", 0x3e8fa0);
    public static final MetadataField zzakE = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 0x6ddd00);
    public static final MetadataField zzakF = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 0x419ce0);
    public static final MetadataField zzakG = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 0x419ce0);
    public static final MetadataField zzakH = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 0x6acfc0);
    public static final MetadataField zzakI = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 0x6acfc0);
    public static final MetadataField zzakJ = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 0x432380);
    public static final MetadataField zzakK = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 0x419ce0);
    public static final zzc zzakL = new zzc(0x3e8fa0);
    public static final MetadataField zzakM = new zzo("originalFilename", 0x419ce0);
    public static final com.google.android.gms.drive.metadata.zzb zzakN = new zzn("ownerNames", 0x419ce0);
    public static final zzp zzakO = new zzp("lastModifyingUser", 0x5b8d80);
    public static final zzp zzakP = new zzp("sharingUser", 0x5b8d80);
    public static final zzl zzakQ = new zzl(0x3e8fa0);
    public static final zzd zzakR = new zzd("quotaBytesUsed", 0x419ce0);
    public static final zzf zzakS = new zzf("starred", 0x3e8fa0);
    public static final MetadataField zzakT = new zzj("thumbnail", Collections.emptySet(), Collections.emptySet(), 0x432380) {

        protected Object zzc(DataHolder dataholder, int i, int j)
        {
            return zzk(dataholder, i, j);
        }

        protected BitmapTeleporter zzk(DataHolder dataholder, int i, int j)
        {
            throw new IllegalStateException("Thumbnail field is write only");
        }

    };
    public static final zzg zzakU = new zzg("title", 0x3e8fa0);
    public static final zzh zzakV = new zzh("trashed", 0x3e8fa0);
    public static final MetadataField zzakW = new zzo("webContentLink", 0x419ce0);
    public static final MetadataField zzakX = new zzo("webViewLink", 0x419ce0);
    public static final MetadataField zzakY = new zzo("uniqueIdentifier", 0x4c4b40);
    public static final com.google.android.gms.drive.metadata.internal.zzb zzakZ = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 0x5b8d80);
    public static final MetadataField zzako;
    public static final MetadataField zzakp = new zzo("alternateLink", 0x419ce0);
    public static final zza zzakq = new zza(0x4c4b40);
    public static final MetadataField zzakr = new zzo("description", 0x419ce0);
    public static final MetadataField zzaks = new zzo("embedLink", 0x419ce0);
    public static final MetadataField zzakt = new zzo("fileExtension", 0x419ce0);
    public static final MetadataField zzaku = new com.google.android.gms.drive.metadata.internal.zzg("fileSize", 0x419ce0);
    public static final MetadataField zzakv = new zzo("folderColorRgb", 0x7270e0);
    public static final MetadataField zzakw = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 0x419ce0);
    public static final MetadataField zzakx = new zzo("indexableText", 0x419ce0);
    public static final MetadataField zzaky = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 0x419ce0);
    public static final MetadataField zzakz = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 0x419ce0);
    public static final MetadataField zzala = new zzo("role", 0x5b8d80);
    public static final MetadataField zzalb = new zzo("md5Checksum", 0x6acfc0);
    public static final zze zzalc = new zze(0x6acfc0);

    static 
    {
        zzako = zzme.zzali;
    }
}
