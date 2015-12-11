// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import java.io.File;

// Referenced classes of package android.support.v7:
//            j, l, k

public class i
{

    public i()
    {
    }

    public static final Drawable a(Context context, int i1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return j.a(context, i1);
        } else
        {
            return context.getResources().getDrawable(i1);
        }
    }

    private static File a(File file)
    {
        android/support/v7/i;
        JVM INSTR monitorenter ;
        File file1 = file;
        if (file.exists()) goto _L2; else goto _L1
_L1:
        file1 = file;
        if (file.mkdirs()) goto _L2; else goto _L3
_L3:
        boolean flag = file.exists();
        if (!flag) goto _L5; else goto _L4
_L4:
        file1 = file;
_L2:
        android/support/v7/i;
        JVM INSTR monitorexit ;
        return file1;
_L5:
        Log.w("ContextCompat", (new StringBuilder()).append("Unable to create files subdir ").append(file.getPath()).toString());
        file1 = null;
        if (true) goto _L2; else goto _L6
_L6:
        file;
        throw file;
    }

    public static boolean a(Context context, Intent aintent[], Bundle bundle)
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
        if (i1 >= 16)
        {
            l.a(context, aintent, bundle);
            return true;
        }
        if (i1 >= 11)
        {
            k.a(context, aintent);
            return true;
        } else
        {
            return false;
        }
    }

    public final File a(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return j.a(context);
        } else
        {
            return a(new File(context.getApplicationInfo().dataDir, "no_backup"));
        }
    }
}
