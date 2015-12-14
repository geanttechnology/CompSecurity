// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            e

public class ad
{

    private static String a;

    public ad()
    {
    }

    public static String a(Context context)
    {
        if (TextUtils.isEmpty(a))
        {
            a = (new StringBuilder()).append(e.a().a(context)).append("waitingforinstall.apk").toString();
        }
        return a;
    }

    public static void a(Context context, String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(c(context, s))), "application/vnd.android.package-archive");
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }

    public static void b(Context context, String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(s)), "application/vnd.android.package-archive");
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }

    public static String c(Context context, String s)
    {
        try
        {
            context = new File(a(context));
            s = new File(s);
            if (s.exists())
            {
                if (context.exists())
                {
                    context.delete();
                }
                s.renameTo(context);
            }
            context = context.getAbsolutePath();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return context;
    }
}
