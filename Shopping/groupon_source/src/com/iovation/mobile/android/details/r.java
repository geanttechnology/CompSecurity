// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class r
    implements i
{

    public r()
    {
    }

    public void a(Context context, j j1)
    {
        long l2;
        long l3;
        Environment.getExternalStorageState();
        context = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        long l = context.getBlockSize();
        l2 = (long)context.getBlockCount() * l;
        context = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        l = context.getBlockSize();
        l3 = (long)context.getBlockCount() * l;
        context = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (l2 == l3)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        long l1;
        if (context.contains("/mnt/sdcard"))
        {
            l1 = l2;
        } else
        {
            l1 = l2 + l3;
        }
_L1:
        try
        {
            j1.a("FSSZ", Long.toString(l1 / 0x100000L));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            j1.a("FSERR", "1");
        }
        break MISSING_BLOCK_LABEL_138;
        l1 = l2;
        if (l2 != l3)
        {
            l1 = 0L;
        }
          goto _L1
    }
}
