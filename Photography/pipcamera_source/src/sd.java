// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class sd
{

    private static String a = "CameraActivityTool";
    private static int b = 1;

    public static File a(boolean flag, Context context)
    {
        if (flag)
        {
            flag = sc.a(sc.b, context, true);
        } else
        {
            flag = sc.a(sc.c, context, false);
        }
        if (flag)
        {
            File file = b(context);
            context = file;
            if (!file.exists())
            {
                context = file;
                if (!file.mkdirs())
                {
                    return null;
                }
            }
        } else
        {
            context = new File((new StringBuilder()).append(a(context)).append("/camera_photo_temp").toString());
            if (!context.exists() && !context.mkdirs())
            {
                return null;
            }
            (new File(context.getAbsolutePath(), ".nomedia")).createNewFile();
        }
        String s = (new StringBuilder()).append("IMG_").append(String.valueOf(System.currentTimeMillis())).append("_").append(b).toString();
        b++;
        return new File((new StringBuilder()).append(context.getAbsolutePath()).append(File.separator).append("IMG_").append(s).append(".jpg").toString());
    }

    public static String a(Context context)
    {
        return gb.a(context).getAbsolutePath();
    }

    public static File b(Context context)
    {
        boolean flag = false;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            flag = true;
        }
        if (flag)
        {
            return new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/DCIM/Camera").toString());
        } else
        {
            return new File(context.getDir("FOTORUS", 1).getAbsolutePath());
        }
    }

}
