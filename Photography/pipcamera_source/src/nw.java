// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class nw
{

    public static boolean a(Context context)
    {
label0:
        {
            boolean flag2 = true;
            boolean flag;
            boolean flag1;
            long l;
            if (((ActivityManager)context.getApplicationContext().getSystemService("activity")).getMemoryClass() <= 32)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            try
            {
                context = new StatFs(Environment.getDataDirectory().getPath());
                l = context.getBlockSize();
                l = ((long)context.getAvailableBlocks() * l) / 0x100000L;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                flag = false;
                if (false)
                {
                } else
                {
                    break label0;
                }
            }
            if (l < 50L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (flag1 || flag)
        {
            flag2 = false;
        }
        return flag2;
    }
}
