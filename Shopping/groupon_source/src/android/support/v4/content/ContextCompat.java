// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import java.io.File;

// Referenced classes of package android.support.v4.content:
//            ContextCompatApi21, ContextCompatJellybean, ContextCompatHoneycomb

public class ContextCompat
{

    public ContextCompat()
    {
    }

    private static File createFilesDir(File file)
    {
        android/support/v4/content/ContextCompat;
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
        android/support/v4/content/ContextCompat;
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

    public static final Drawable getDrawable(Context context, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return ContextCompatApi21.getDrawable(context, i);
        } else
        {
            return context.getResources().getDrawable(i);
        }
    }

    public static boolean startActivities(Context context, Intent aintent[], Bundle bundle)
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 16)
        {
            ContextCompatJellybean.startActivities(context, aintent, bundle);
            return true;
        }
        if (i >= 11)
        {
            ContextCompatHoneycomb.startActivities(context, aintent);
            return true;
        } else
        {
            return false;
        }
    }

    public final File getNoBackupFilesDir(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return ContextCompatApi21.getNoBackupFilesDir(context);
        } else
        {
            return createFilesDir(new File(context.getApplicationInfo().dataDir, "no_backup"));
        }
    }
}
