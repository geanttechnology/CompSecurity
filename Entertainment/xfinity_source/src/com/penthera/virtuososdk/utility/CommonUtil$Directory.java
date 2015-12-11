// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.penthera.virtuososdk.monitor.ExternalStorageInfo;
import java.io.File;

// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class 
{

    public static String NOMEDIA_FILENAME = ".nomedia";

    public static boolean createMediaRoot(Context context)
    {
        StringBuffer stringbuffer = new StringBuffer();
        context = getRoot(context);
        if (TextUtils.isEmpty(context))
        {
            return false;
        }
        stringbuffer.append(context);
        stringbuffer.append("/");
        stringbuffer.append("media");
        stringbuffer.append("/");
        context = new File(stringbuffer.toString());
        if (context.exists())
        {
            return true;
        } else
        {
            return context.mkdirs();
        }
    }

    public static boolean createRoot(Context context)
    {
        context = getExternalPath(context, "virtuoso");
        if (context == null)
        {
            return false;
        }
        if (context.exists())
        {
            return true;
        } else
        {
            return context.mkdirs();
        }
    }

    private static File getExternalPath(Context context, String s)
    {
        return getExternalPath(context, s, true);
    }

    private static File getExternalPath(Context context, String s, boolean flag)
    {
        Object obj;
        obj = ExternalStorageInfo.getInstance();
        ((ExternalStorageInfo) (obj)).update();
        if (((ExternalStorageInfo) (obj)).isMounted() || ((ExternalStorageInfo) (obj)).isWritable()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj1;
        StringBuilder stringbuilder;
        boolean flag1;
        stringbuilder = new StringBuilder();
        obj1 = null;
        obj = obj1;
        flag1 = flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (context == null)
        {
            sWritable("Directory", "getExternalPath: context is null");
            return null;
        }
        obj = context.getExternalFilesDir(null);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = flag;
_L4:
        if (!flag1)
        {
            obj = Environment.getExternalStorageDirectory();
        }
        if (obj != null)
        {
            stringbuilder.append(((File) (obj)).getAbsolutePath());
            stringbuilder.append("/");
            if (s != null)
            {
                stringbuilder.append(s);
                stringbuilder.append("/");
            }
            return new File(stringbuilder.toString());
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        flag1 = false;
        obj = obj1;
          goto _L4
    }

    public static String getMediaRoot(Context context)
    {
        context = getExternalPath(context, "virtuoso/media");
        if (context != null)
        {
            return context.getAbsolutePath();
        } else
        {
            return "";
        }
    }

    public static String getRoot(Context context)
    {
        context = getExternalPath(context, "virtuoso");
        if (context != null)
        {
            return context.getAbsolutePath();
        } else
        {
            return "";
        }
    }

}
