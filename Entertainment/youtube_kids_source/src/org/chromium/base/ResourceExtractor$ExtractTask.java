// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Trace;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package org.chromium.base:
//            ResourceExtractor, LocaleUtils

class ception extends AsyncTask
{

    private ResourceExtractor a;

    private String a(File file)
    {
        Object obj = ResourceExtractor.d(a).getPackageManager();
        try
        {
            obj = ((PackageManager) (obj)).getPackageInfo(ResourceExtractor.d(a).getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return "pak_timestamp-";
        }
        if (obj == null)
        {
            file = "pak_timestamp-";
        } else
        {
            obj = (new StringBuilder("pak_timestamp-")).append(((PackageInfo) (obj)).versionCode).append("-").append(((PackageInfo) (obj)).lastUpdateTime).toString();
            class _cls1
                implements FilenameFilter
            {

                public boolean accept(File file1, String s)
                {
                    return s.startsWith("pak_timestamp-");
                }

            _cls1()
            {
            }
            }

            String as[] = file.list(new _cls1());
            file = ((File) (obj));
            if (as.length == 1)
            {
                file = ((File) (obj));
                if (((String) (obj)).equals(as[0]))
                {
                    return null;
                }
            }
        }
        return file;
    }

    private transient Void a()
    {
        a("ResourceExtractor.ExtractTask.doInBackground");
        Object obj2;
        File file;
        obj2 = ResourceExtractor.a(a);
        file = ResourceExtractor.b(a);
        if (((File) (obj2)).exists() || ((File) (obj2)).mkdirs()) goto _L2; else goto _L1
_L1:
        Log.e("ResourceExtractor", "Unable to create pak resources directory!");
_L23:
        b();
        return null;
_L2:
        a("checkPakTimeStamp");
        String s = a(((File) (obj2)));
        b();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ResourceExtractor.c(a);
        Object obj;
        Object obj1;
        obj = PreferenceManager.getDefaultSharedPreferences(ResourceExtractor.d(a));
        obj1 = LocaleUtils.getDefaultLocale().split("-", 2)[0];
        if (!((SharedPreferences) (obj)).getString("Last language", "").equals(obj1)) goto _L4; else goto _L3
_L3:
        int k = 1;
        String as[];
        int l;
        as = ResourceExtractor.a();
        l = as.length;
        int i = 0;
_L11:
        int j = k;
        if (i >= l) goto _L6; else goto _L5
_L5:
        Object obj3 = as[i];
        if (ResourceExtractor.a(((String) (obj3))))
        {
            obj = file;
        } else
        {
            obj = obj2;
        }
        if ((new File(((File) (obj)), ((String) (obj3)))).exists()) goto _L8; else goto _L7
_L7:
        j = 0;
          goto _L6
_L12:
        obj = new StringBuilder();
        as = ResourceExtractor.a();
        j = as.length;
        i = 0;
_L10:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = as[i];
        if (((StringBuilder) (obj)).length() > 0)
        {
            ((StringBuilder) (obj)).append('|');
        }
        ((StringBuilder) (obj)).append((new StringBuilder("\\Q")).append(((String) (obj3))).append("\\E").toString());
        i++;
        if (true) goto _L10; else goto _L9
        obj;
        b();
        throw obj;
_L8:
        i++;
          goto _L11
_L4:
        ((SharedPreferences) (obj)).edit().ring("Last language", ((String) (obj1))).();
          goto _L12
_L9:
        Pattern pattern;
        AssetManager assetmanager;
        if (ResourceExtractor.b())
        {
            if (((StringBuilder) (obj)).length() > 0)
            {
                ((StringBuilder) (obj)).append('|');
            }
            ((StringBuilder) (obj)).append(((String) (obj1)));
            ((StringBuilder) (obj)).append("(-\\w+)?\\.pak");
        }
        pattern = Pattern.compile(((StringBuilder) (obj)).toString());
        assetmanager = ResourceExtractor.d(a).getResources().getAssets();
        a("WalkAssets");
        String as1[];
        as1 = assetmanager.list("");
        j = as1.length;
        i = 0;
        obj = null;
_L24:
        if (i >= j) goto _L14; else goto _L13
_L13:
        String s1;
        s1 = as1[i];
        obj1 = obj;
        if (!pattern.matcher(s1).matches()) goto _L16; else goto _L15
_L15:
        InputStream inputstream;
        File file1;
        if (ResourceExtractor.a(s1))
        {
            obj1 = file;
        } else
        {
            obj1 = obj2;
        }
        file1 = new File(((File) (obj1)), s1);
        obj1 = obj;
        if (file1.exists()) goto _L16; else goto _L17
_L17:
        a("ExtractResource");
        inputstream = assetmanager.open(s1);
        obj3 = new FileOutputStream(file1);
        (new StringBuilder("Extracting resource ")).append(s1);
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_511;
        }
        obj1 = new byte[16384];
_L20:
        k = inputstream.read(((byte []) (obj1)), 0, 16384);
        if (k == -1) goto _L19; else goto _L18
_L18:
        ((OutputStream) (obj3)).write(((byte []) (obj1)), 0, k);
          goto _L20
        obj;
        obj2 = inputstream;
        obj1 = obj3;
_L22:
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_556;
        }
        ((InputStream) (obj2)).close();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_564;
        }
        ((OutputStream) (obj1)).close();
        b();
        throw obj;
_L21:
        Log.w("ResourceExtractor", (new StringBuilder("Exception unpacking required pak resources: ")).append(((IOException) (obj)).getMessage()).toString());
        ResourceExtractor.c(a);
        b();
        break; /* Loop/switch isn't completed */
_L19:
        ((OutputStream) (obj3)).flush();
        if (file1.length() == 0L)
        {
            throw new IOException((new StringBuilder()).append(s1).append(" extracted with 0 length!").toString());
        }
        if (ResourceExtractor.a(s1))
        {
            file1.setReadable(true, false);
        }
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_683;
        }
        inputstream.close();
        ((OutputStream) (obj3)).close();
        b();
        break; /* Loop/switch isn't completed */
        obj;
        try
        {
            ((OutputStream) (obj3)).close();
            b();
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
        if (true) goto _L21; else goto _L16
        b();
        throw obj;
        obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_720;
        }
        ((OutputStream) (obj1)).close();
        b();
        throw obj;
_L14:
        b();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            (new File(((File) (obj2)), s)).createNewFile();
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            b();
            throw obj;
        }
        Log.w("ResourceExtractor", "Failed to write resource pak timestamp!");
        break; /* Loop/switch isn't completed */
        obj;
        obj2 = null;
        obj1 = null;
          goto _L22
        obj;
        obj1 = null;
        obj2 = inputstream;
          goto _L22
_L6:
        if (j != 0) goto _L23; else goto _L12
_L16:
        i++;
        obj = obj1;
          goto _L24
    }

    private static void a(String s)
    {
        if (android.os.ctTask.b < 18)
        {
            return;
        } else
        {
            Trace.beginSection(s);
            return;
        }
    }

    private static void b()
    {
        if (android.os.ctTask.b < 18)
        {
            return;
        } else
        {
            Trace.endSection();
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a();
    }
}
