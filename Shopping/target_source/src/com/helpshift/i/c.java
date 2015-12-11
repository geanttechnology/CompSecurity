// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.helpshift.h.e;
import com.helpshift.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class c
{

    private static final String a = (new StringBuilder()).append(".backups/").append(v.a().getPackageName()).append("/helpshift/databases/").toString();

    private static void a()
    {
        e.a();
    }

    public static void a(String s)
    {
        if (c(s))
        {
            try
            {
                File file = Environment.getExternalStoragePublicDirectory(a);
                if (!file.exists())
                {
                    file.mkdirs();
                }
                if (file.canWrite())
                {
                    Object obj = new File(v.a().getDatabasePath(s).getPath());
                    s = new File(file, s);
                    obj = (new FileInputStream(((File) (obj)))).getChannel();
                    s = (new FileOutputStream(s)).getChannel();
                    s.transferFrom(((java.nio.channels.ReadableByteChannel) (obj)), 0L, ((FileChannel) (obj)).size());
                    ((FileChannel) (obj)).close();
                    s.close();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.d("HelpShiftDebug", "backupDatabase", s);
                return;
            }
        }
    }

    public static void b(String s)
    {
        if (!c(s))
        {
            a();
            try
            {
                File file = Environment.getExternalStoragePublicDirectory(a);
                if (file.canRead())
                {
                    Object obj = v.a().getDatabasePath(s).getPath();
                    s = new File(file, s);
                    obj = new File(((String) (obj)));
                    s = (new FileInputStream(s)).getChannel();
                    obj = (new FileOutputStream(((File) (obj)))).getChannel();
                    ((FileChannel) (obj)).transferFrom(s, 0L, s.size());
                    s.close();
                    ((FileChannel) (obj)).close();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.d("HelpShiftDebug", "restoreDatabaseBackup", s);
                return;
            }
        }
    }

    private static boolean c(String s)
    {
        return v.a().getDatabasePath(s).exists();
    }

}
