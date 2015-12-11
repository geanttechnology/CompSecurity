// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

final class ot extends bmr
{

    private os a;

    ot(os os1)
    {
        a = os1;
        super();
    }

    public final Object a()
    {
        long l1;
        long l2;
        long l3;
        l1 = 0L;
        l2 = bnh.a(a.a.a.b().b, 0x4000000L);
        l3 = bnh.a(a.a.a.b().a, 0x10000000L);
        if ("mounted".equals(Environment.getExternalStorageState())) goto _L2; else goto _L1
_L1:
        long l = l1;
_L4:
        return Long.valueOf(bnh.a(l2, l3, l));
_L2:
        Object obj = Environment.getExternalStorageDirectory();
        l = l1;
        if (obj != null)
        {
            l = l1;
            if (((File) (obj)).exists())
            {
                obj = new StatFs(((File) (obj)).getAbsolutePath());
                if (android.os.Build.VERSION.SDK_INT >= 18)
                {
                    l = ((StatFs) (obj)).getAvailableBlocksLong();
                    l = ((StatFs) (obj)).getBlockSizeLong() * l;
                } else
                {
                    l = ((StatFs) (obj)).getAvailableBlocks();
                    l = (long)((StatFs) (obj)).getBlockSize() * l;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
