// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

public class zzne extends zzj
{

    public static final com.google.android.gms.drive.metadata.internal.zze.zza zzanA = new com.google.android.gms.drive.metadata.internal.zze.zza() {

        public void zzb(DataHolder dataholder)
        {
            zzne.zze(dataholder);
        }

        public String zzrL()
        {
            return "customPropertiesExtraHolder";
        }

    };

    public zzne(int i)
    {
        super("customProperties", Arrays.asList(new String[] {
            "hasCustomProperties", "sqlId"
        }), Arrays.asList(new String[] {
            "customPropertiesExtra", "customPropertiesExtraHolder"
        }), i);
    }

    private static void zzc(DataHolder dataholder)
    {
        dataholder;
        JVM INSTR monitorenter ;
        Object obj = (DataHolder)dataholder.zzor().getParcelable("customPropertiesExtraHolder");
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        dataholder;
        JVM INSTR monitorexit ;
        return;
        LongSparseArray longsparsearray;
        SparseArray sparsearray;
        longsparsearray = zzf(((DataHolder) (obj)));
        sparsearray = new SparseArray();
        int i = 0;
_L2:
        com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza zza;
        if (i >= dataholder.getCount())
        {
            break MISSING_BLOCK_LABEL_89;
        }
        zza = (com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza)longsparsearray.get(dataholder.zzb("sqlId", i, dataholder.zzbt(i)));
        if (zza == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        sparsearray.append(i, zza.zzrI());
        break MISSING_BLOCK_LABEL_136;
        dataholder.zzor().putSparseParcelableArray("customPropertiesExtra", sparsearray);
        ((DataHolder) (obj)).close();
        dataholder.zzor().remove("customPropertiesExtraHolder");
        dataholder;
        JVM INSTR monitorexit ;
        return;
        obj;
        dataholder;
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception;
        exception;
        ((DataHolder) (obj)).close();
        dataholder.zzor().remove("customPropertiesExtraHolder");
        throw exception;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void zzd(DataHolder dataholder)
    {
        Bundle bundle;
        bundle = dataholder.zzor();
        if (bundle == null)
        {
            return;
        }
        dataholder;
        JVM INSTR monitorenter ;
        DataHolder dataholder1 = (DataHolder)bundle.getParcelable("customPropertiesExtraHolder");
        if (dataholder1 == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        dataholder1.close();
        bundle.remove("customPropertiesExtraHolder");
        dataholder;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        dataholder;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void zze(DataHolder dataholder)
    {
        zzd(dataholder);
    }

    private static LongSparseArray zzf(DataHolder dataholder)
    {
        Bundle bundle = dataholder.zzor();
        String s = bundle.getString("entryIdColumn");
        String s1 = bundle.getString("keyColumn");
        String s2 = bundle.getString("visibilityColumn");
        String s3 = bundle.getString("valueColumn");
        LongSparseArray longsparsearray = new LongSparseArray();
        for (int i = 0; i < dataholder.getCount(); i++)
        {
            int j = dataholder.zzbt(i);
            long l = dataholder.zzb(s, i, j);
            Object obj = dataholder.zzd(s1, i, j);
            int k = dataholder.zzc(s2, i, j);
            Object obj1 = dataholder.zzd(s3, i, j);
            CustomProperty customproperty = new CustomProperty(new CustomPropertyKey(((String) (obj)), k), ((String) (obj1)));
            obj1 = (com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza)longsparsearray.get(l);
            obj = obj1;
            if (obj1 == null)
            {
                obj = new com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza();
                longsparsearray.put(l, obj);
            }
            ((com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza) (obj)).zza(customproperty);
        }

        return longsparsearray;
    }

    protected Object zzc(DataHolder dataholder, int i, int j)
    {
        return zzl(dataholder, i, j);
    }

    protected AppVisibleCustomProperties zzl(DataHolder dataholder, int i, int j)
    {
        Bundle bundle = dataholder.zzor();
        SparseArray sparsearray = bundle.getSparseParcelableArray("customPropertiesExtra");
        SparseArray sparsearray1 = sparsearray;
        if (sparsearray == null)
        {
            if (bundle.getParcelable("customPropertiesExtraHolder") != null)
            {
                zzc(dataholder);
                sparsearray = bundle.getSparseParcelableArray("customPropertiesExtra");
            }
            sparsearray1 = sparsearray;
            if (sparsearray == null)
            {
                return AppVisibleCustomProperties.zzamA;
            }
        }
        return (AppVisibleCustomProperties)sparsearray1.get(i, AppVisibleCustomProperties.zzamA);
    }

}
