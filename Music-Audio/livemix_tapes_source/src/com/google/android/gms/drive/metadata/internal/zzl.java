// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            zzi, ParentDriveIdSet, PartialDriveId

public class zzl extends zzi
    implements SearchableCollectionMetadataField
{

    public zzl(int i)
    {
        super("parents", Collections.emptySet(), Arrays.asList(new String[] {
            "parentsExtra", "dbInstanceId", "parentsExtraHolder"
        }), i);
    }

    private void zzc(DataHolder dataholder)
    {
        dataholder;
        JVM INSTR monitorenter ;
        Object obj = (DataHolder)dataholder.zznP().getParcelable("parentsExtraHolder");
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        dataholder;
        JVM INSTR monitorexit ;
        return;
        ArrayList arraylist;
        HashMap hashmap;
        int j;
        j = dataholder.getCount();
        arraylist = new ArrayList(j);
        hashmap = new HashMap(j);
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        int k = dataholder.zzbo(i);
        ParentDriveIdSet parentdriveidset = new ParentDriveIdSet();
        arraylist.add(parentdriveidset);
        hashmap.put(Long.valueOf(dataholder.zzb("sqlId", i, k)), parentdriveidset);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        Object obj1;
        obj1 = ((DataHolder) (obj)).zznP();
        s = ((Bundle) (obj1)).getString("childSqlIdColumn");
        s1 = ((Bundle) (obj1)).getString("parentSqlIdColumn");
        obj1 = ((Bundle) (obj1)).getString("parentResIdColumn");
        j = ((DataHolder) (obj)).getCount();
        i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        int l = ((DataHolder) (obj)).zzbo(i);
        ((ParentDriveIdSet)hashmap.get(Long.valueOf(((DataHolder) (obj)).zzb(s, i, l)))).zza(new PartialDriveId(((DataHolder) (obj)).zzd(((String) (obj1)), i, l), ((DataHolder) (obj)).zzb(s1, i, l), 1));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        dataholder.zznP().putParcelableArrayList("parentsExtra", arraylist);
        ((DataHolder) (obj)).close();
        dataholder.zznP().remove("parentsExtraHolder");
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
        dataholder.zznP().remove("parentsExtraHolder");
        throw exception;
    }

    protected Object zzc(DataHolder dataholder, int i, int j)
    {
        return zzd(dataholder, i, j);
    }

    protected Collection zzd(DataHolder dataholder, int i, int j)
    {
        Bundle bundle = dataholder.zznP();
        ArrayList arraylist = bundle.getParcelableArrayList("parentsExtra");
        ArrayList arraylist1 = arraylist;
        if (arraylist == null)
        {
            if (bundle.getParcelable("parentsExtraHolder") != null)
            {
                zzc(dataholder);
                arraylist = bundle.getParcelableArrayList("parentsExtra");
            }
            arraylist1 = arraylist;
            if (arraylist == null)
            {
                return null;
            }
        }
        long l = bundle.getLong("dbInstanceId");
        return ((ParentDriveIdSet)arraylist1.get(i)).zzC(l);
    }

    public void zzd(DataHolder dataholder)
    {
        Bundle bundle;
        bundle = dataholder.zznP();
        if (bundle == null)
        {
            return;
        }
        dataholder;
        JVM INSTR monitorenter ;
        DataHolder dataholder1 = (DataHolder)bundle.getParcelable("parentsExtraHolder");
        if (dataholder1 == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        dataholder1.close();
        bundle.remove("parentsExtraHolder");
        dataholder;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        dataholder;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected Object zzk(Bundle bundle)
    {
        return zzp(bundle);
    }

    protected Collection zzp(Bundle bundle)
    {
        bundle = super.zzp(bundle);
        if (bundle == null)
        {
            return null;
        } else
        {
            return new HashSet(bundle);
        }
    }
}
