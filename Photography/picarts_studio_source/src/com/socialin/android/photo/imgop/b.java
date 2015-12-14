// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipFile;

public class b
{

    private static boolean a = false;
    private static boolean b;

    public b()
    {
    }

    private static File a(Context context, String s)
    {
        s = System.mapLibraryName(s);
        return new File(context.getDir("lib", 0), s);
    }

    public static HashMap a(Context context, ArrayList arraylist)
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!a(context, s, arraylist))
            {
                break;
            }
            hashmap.put(s, Boolean.valueOf(true));
        } while (true);
        return hashmap;
    }

    private static void a(File file)
    {
        File afile[] = file.listFiles();
        if (afile == null) goto _L2; else goto _L1
_L1:
        int j = afile.length;
        int i = 0;
_L6:
        if (i >= j) goto _L2; else goto _L3
_L3:
        File file1 = afile[i];
        if (!file1.delete())
        {
            Log.e("LibraryLoaderHelper", (new StringBuilder("Failed to remove ")).append(file1.getAbsolutePath()).toString());
        }
          goto _L4
_L2:
        try
        {
            if (!file.delete())
            {
                Log.w("LibraryLoaderHelper", (new StringBuilder("Failed to remove ")).append(file.getAbsolutePath()).toString());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Log.e("LibraryLoaderHelper", "Failed to remove old libs, ", file);
        }
        return;
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static boolean a(Context context, String s, ArrayList arraylist)
    {
        if (!b && context == null)
        {
            throw new AssertionError();
        }
        s = a(context, s);
        if (!s.exists() && !b(context, arraylist))
        {
            return false;
        }
        try
        {
            System.load(s.getAbsolutePath());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    private static boolean b(Context context, ArrayList arraylist)
    {
        ArrayList arraylist1;
        File file;
        arraylist1 = null;
        if (a)
        {
            return false;
        }
        a = true;
        file = context.getDir("lib", 0);
        a(file);
        ApplicationInfo applicationinfo;
        ZipFile zipfile;
        Iterator iterator;
        applicationinfo = context.getApplicationInfo();
        zipfile = new ZipFile(new File(applicationinfo.sourceDir), 1);
        iterator = arraylist.iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj2;
        obj = (String)iterator.next();
        obj2 = (new StringBuilder("lib/")).append(Build.CPU_ABI).append("/").append(System.mapLibraryName(((String) (obj)))).toString();
        arraylist = zipfile.getEntry(((String) (obj2)));
        if (arraylist == null)
        {
            try
            {
                Log.e("LibraryLoaderHelper", (new StringBuilder()).append(applicationinfo.sourceDir).append(" doesn't have file ").append(((String) (obj2))).toString());
                zipfile.close();
                a(file);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.e("LibraryLoaderHelper", "Failed to unpack native libraries", context);
                a(file);
                return false;
            }
            return false;
        }
        obj2 = a(context, ((String) (obj)));
        Log.i("LibraryLoaderHelper", (new StringBuilder("Extracting native libraries into ")).append(((File) (obj2)).getAbsolutePath()).toString());
        if (!b && ((File) (obj2)).exists())
        {
            throw new AssertionError();
        }
        if (!((File) (obj2)).createNewFile())
        {
            throw new IOException();
        }
          goto _L3
_L8:
        if (((File) (obj2)).exists() && !((File) (obj2)).delete())
        {
            Log.e("LibraryLoaderHelper", (new StringBuilder("Failed to delete ")).append(((File) (obj2)).getAbsolutePath()).toString());
        }
        zipfile.close();
        throw context;
_L3:
        arraylist = zipfile.getInputStream(arraylist);
        obj = new FileOutputStream(((File) (obj2)));
        byte abyte0[] = new byte[16384];
_L6:
        int i = arraylist.read(abyte0);
        if (i <= 0) goto _L5; else goto _L4
_L4:
        ((FileOutputStream) (obj)).write(abyte0, 0, i);
          goto _L6
        Exception exception;
        exception;
        context = ((Context) (obj));
        arraylist1 = arraylist;
        arraylist = context;
        context = exception;
_L9:
        if (arraylist1 == null)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        arraylist1.close();
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_387;
        }
        arraylist.close();
        throw context;
_L5:
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_397;
        }
        arraylist.close();
        ((FileOutputStream) (obj)).close();
        ((File) (obj2)).setReadable(true, false);
        ((File) (obj2)).setExecutable(true, false);
        ((File) (obj2)).setWritable(true);
          goto _L7
        context;
        try
        {
            ((FileOutputStream) (obj)).close();
            throw context;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
          goto _L8
        context;
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_443;
        }
        arraylist.close();
        throw context;
_L2:
        zipfile.close();
        return true;
        context;
        arraylist = null;
          goto _L9
        context;
        Object obj1 = null;
        arraylist1 = arraylist;
        arraylist = obj1;
          goto _L9
    }

    static 
    {
        boolean flag;
        if (!com/socialin/android/photo/imgop/b.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }
}
