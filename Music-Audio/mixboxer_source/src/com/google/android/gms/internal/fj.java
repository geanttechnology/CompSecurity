// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.f;
import java.util.Arrays;

public class fj extends f
{

    public static final fj rN = new fj();

    private fj()
    {
        super("driveId", Arrays.asList(new String[] {
            "sqlId", "resourceId"
        }));
    }

    protected Object b(DataHolder dataholder, int i, int j)
    {
        return g(dataholder, i, j);
    }

    protected DriveId g(DataHolder dataholder, int i, int j)
    {
        long l = dataholder.getMetadata().getLong("dbInstanceId");
        String s1 = dataholder.getString("resourceId", i, j);
        String s = s1;
        if (s1 != null)
        {
            s = s1;
            if (s1.startsWith("generated-android-"))
            {
                s = null;
            }
        }
        return new DriveId(s, Long.valueOf(dataholder.getLong("sqlId", i, j)).longValue(), l);
    }

}
