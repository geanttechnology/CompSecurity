// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            zznd

public class zzng extends zzj
{

    public static final zzng zzanH = new zzng();

    private zzng()
    {
        super("driveId", Arrays.asList(new String[] {
            "sqlId", "resourceId", "mimeType"
        }), Arrays.asList(new String[] {
            "dbInstanceId"
        }), 0x3e8fa0);
    }

    protected boolean zzb(DataHolder dataholder, int i, int j)
    {
        for (Iterator iterator = zzrG().iterator(); iterator.hasNext();)
        {
            if (!dataholder.zzce((String)iterator.next()))
            {
                return false;
            }
        }

        return true;
    }

    protected Object zzc(DataHolder dataholder, int i, int j)
    {
        return zzm(dataholder, i, j);
    }

    protected DriveId zzm(DataHolder dataholder, int i, int j)
    {
        long l = dataholder.zzor().getLong("dbInstanceId");
        String s;
        int k;
        long l1;
        if ("application/vnd.google-apps.folder".equals(dataholder.zzd(zznd.zzang.getName(), i, j)))
        {
            k = 1;
        } else
        {
            k = 0;
        }
        s = dataholder.zzd("resourceId", i, j);
        l1 = dataholder.zzb("sqlId", i, j);
        dataholder = s;
        if ("generated-android-null".equals(s))
        {
            dataholder = null;
        }
        return new DriveId(dataholder, Long.valueOf(l1).longValue(), l, k);
    }

}
