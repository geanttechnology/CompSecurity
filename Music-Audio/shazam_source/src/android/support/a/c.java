// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

// Referenced classes of package android.support.a:
//            d

final class c
{

    private static Method a;

    private static SharedPreferences a(Context context)
    {
        int i;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        return context.getSharedPreferences("multidex.version", i);
    }

    static List a(Context context, ApplicationInfo applicationinfo, File file, boolean flag)
    {
        File file1;
        boolean flag1;
        long l;
        flag1 = false;
        (new StringBuilder("MultiDexExtractor.load(")).append(applicationinfo.sourceDir).append(", ").append(flag).append(")");
        file1 = new File(applicationinfo.sourceDir);
        long l1 = d.a(file1);
        l = l1;
        if (l1 == -1L)
        {
            l = l1 - 1L;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        applicationinfo = a(context);
        if (applicationinfo.getLong("timestamp", -1L) != b(file1) || applicationinfo.getLong("crc", -1L) != l)
        {
            flag1 = true;
        }
        if (flag1) goto _L2; else goto _L3
_L3:
        applicationinfo = a(context, file1, file);
        context = applicationinfo;
_L4:
        (new StringBuilder("load found ")).append(context.size()).append(" secondary dex files");
        return context;
        applicationinfo;
_L2:
        applicationinfo = a(file1, file);
        long l2 = b(file1);
        int i = applicationinfo.size();
        context = a(context).edit();
        context.putLong("timestamp", l2);
        context.putLong("crc", l);
        context.putInt("dex.number", i + 1);
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        a.invoke(context, new Object[0]);
        context = applicationinfo;
          goto _L4
        file;
_L5:
        context.commit();
        context = applicationinfo;
          goto _L4
        file;
          goto _L5
    }

    private static List a(Context context, File file, File file1)
    {
        file = (new StringBuilder()).append(file.getName()).append(".classes").toString();
        int j = a(context).getInt("dex.number", 1);
        context = new ArrayList(j);
        for (int i = 2; i <= j; i++)
        {
            File file2 = new File(file1, (new StringBuilder()).append(file).append(i).append(".zip").toString());
            if (file2.isFile())
            {
                context.add(file2);
                if (!a(file2))
                {
                    (new StringBuilder("Invalid zip file: ")).append(file2);
                    throw new IOException("Invalid ZIP file.");
                }
            } else
            {
                throw new IOException((new StringBuilder("Missing extracted secondary dex file '")).append(file2.getPath()).append("'").toString());
            }
        }

        return context;
    }

    private static List a(File file, File file1)
    {
        ArrayList arraylist;
        String s1;
        ZipFile zipfile;
        s1 = (new StringBuilder()).append(file.getName()).append(".classes").toString();
        a(file1, s1);
        arraylist = new ArrayList();
        zipfile = new ZipFile(file);
        file = zipfile.getEntry("classes2.dex");
        int j = 2;
_L4:
        if (file == null)
        {
            break; /* Loop/switch isn't completed */
        }
        File file2;
        file2 = new File(file1, (new StringBuilder()).append(s1).append(j).append(".zip").toString());
        arraylist.add(file2);
        (new StringBuilder("Extraction is needed for file ")).append(file2);
        int i;
        boolean flag;
        flag = false;
        i = 0;
_L2:
        if (i >= 3 || flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        StringBuilder stringbuilder;
        a(zipfile, ((ZipEntry) (file)), file2, s1);
        flag = a(file2);
        stringbuilder = new StringBuilder("Extraction ");
        String s;
        if (flag)
        {
            s = "success";
        } else
        {
            s = "failed";
        }
        stringbuilder.append(s).append(" - length ").append(file2.getAbsolutePath()).append(": ").append(file2.length());
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        file2.delete();
        if (file2.exists())
        {
            (new StringBuilder("Failed to delete corrupted secondary dex '")).append(file2.getPath()).append("'");
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        throw new IOException((new StringBuilder("Could not create zip file ")).append(file2.getAbsolutePath()).append(" for secondary dex (").append(j).append(")").toString());
        file;
        try
        {
            zipfile.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file1) { }
        throw file;
        j++;
        file = zipfile.getEntry((new StringBuilder("classes")).append(j).append(".dex").toString());
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            zipfile.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return arraylist;
        }
        return arraylist;
    }

    private static void a(Closeable closeable)
    {
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            return;
        }
    }

    private static void a(File file, String s)
    {
        c(file.getParentFile());
        c(file);
        s = file.listFiles(new FileFilter(s) {

            final String a;

            public final boolean accept(File file1)
            {
                return !file1.getName().startsWith(a);
            }

            
            {
                a = s;
                super();
            }
        });
        if (s == null)
        {
            (new StringBuilder("Failed to list secondary dex dir content (")).append(file.getPath()).append(").");
        } else
        {
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                file = s[i];
                (new StringBuilder("Trying to delete old file ")).append(file.getPath()).append(" of size ").append(file.length());
                if (!file.delete())
                {
                    (new StringBuilder("Failed to delete old file ")).append(file.getPath());
                } else
                {
                    (new StringBuilder("Deleted old file ")).append(file.getPath());
                }
                i++;
            }
        }
    }

    private static void a(ZipFile zipfile, ZipEntry zipentry, File file, String s)
    {
        zipfile = zipfile.getInputStream(zipentry);
        s = File.createTempFile(s, ".zip", file.getParentFile());
        (new StringBuilder("Extracting ")).append(s.getPath());
        ZipOutputStream zipoutputstream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(s)));
        int i;
        ZipEntry zipentry1 = new ZipEntry("classes.dex");
        zipentry1.setTime(zipentry.getTime());
        zipoutputstream.putNextEntry(zipentry1);
        zipentry = new byte[16384];
        i = zipfile.read(zipentry);
_L1:
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        zipoutputstream.write(zipentry, 0, i);
        i = zipfile.read(zipentry);
          goto _L1
        zipoutputstream.closeEntry();
        zipoutputstream.close();
        (new StringBuilder("Renaming to ")).append(file.getPath());
        if (!s.renameTo(file))
        {
            throw new IOException((new StringBuilder("Failed to rename \"")).append(s.getAbsolutePath()).append("\" to \"").append(file.getAbsolutePath()).append("\"").toString());
        }
        break MISSING_BLOCK_LABEL_228;
        zipentry;
        a(((Closeable) (zipfile)));
        s.delete();
        throw zipentry;
        zipentry;
        zipoutputstream.close();
        throw zipentry;
        a(((Closeable) (zipfile)));
        s.delete();
        return;
    }

    static boolean a(File file)
    {
        ZipFile zipfile = new ZipFile(file);
        try
        {
            zipfile.close();
        }
        catch (IOException ioexception)
        {
            try
            {
                (new StringBuilder("Failed to close zip file: ")).append(file.getAbsolutePath());
            }
            catch (ZipException zipexception)
            {
                (new StringBuilder("File ")).append(file.getAbsolutePath()).append(" is not a valid zip file.");
            }
            catch (IOException ioexception1)
            {
                (new StringBuilder("Got an IOException trying to open zip file: ")).append(file.getAbsolutePath());
            }
            return false;
        }
        return true;
    }

    private static long b(File file)
    {
        long l1 = file.lastModified();
        long l = l1;
        if (l1 == -1L)
        {
            l = l1 - 1L;
        }
        return l;
    }

    private static void c(File file)
    {
        file.mkdir();
        if (!file.isDirectory())
        {
            File file1 = file.getParentFile();
            if (file1 == null)
            {
                Log.e("MultiDex", (new StringBuilder("Failed to create dir ")).append(file.getPath()).append(". Parent file is null.").toString());
            } else
            {
                Log.e("MultiDex", (new StringBuilder("Failed to create dir ")).append(file.getPath()).append(". parent file is a dir ").append(file1.isDirectory()).append(", a file ").append(file1.isFile()).append(", exists ").append(file1.exists()).append(", readable ").append(file1.canRead()).append(", writable ").append(file1.canWrite()).toString());
            }
            throw new IOException((new StringBuilder("Failed to create cache directory ")).append(file.getPath()).toString());
        } else
        {
            return;
        }
    }

    static 
    {
        try
        {
            a = android/content/SharedPreferences$Editor.getMethod("apply", new Class[0]);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            a = null;
        }
    }
}
