// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.appsearch.patchupdate.GDiffPatcher;
import com.baidu.appsearch.patchupdate.Utility;
import com.baidu.autoupdatesdk.AppUpdateInfo;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            e, aj

public class i extends AsyncTask
{

    private static b a;
    private static boolean b = false;
    private static Context c;
    private String d;
    private String e;
    private String f;
    private a g;

    public i(Context context, String s, String s1, AppUpdateInfo appupdateinfo, a a1)
    {
        c = context;
        d = s;
        e = s1;
        f = (new StringBuilder()).append(com.baidu.autoupdatesdk.obf.e.a().a(context)).append(appupdateinfo.getAppPackage()).append("-").append(appupdateinfo.getAppVersionCode()).append(".apk").toString();
        g = a1;
    }

    public static boolean a()
    {
        return b;
    }

    private void b()
    {
        File file = new File(com.baidu.autoupdatesdk.obf.e.a().a(c));
        if (file.exists() && file.isDirectory())
        {
            File afile[] = file.listFiles(c());
            if (afile != null && afile.length > 0)
            {
                for (int j = 0; j < afile.length; j++)
                {
                    afile[j].delete();
                }

            }
        }
    }

    private b c()
    {
        if (a == null)
        {
            a = new b();
        }
        return a;
    }

    protected transient Boolean a(Void avoid[])
    {
        b = true;
        avoid = new GDiffPatcher();
        if (!Utility.isGzipFile(e)) goto _L2; else goto _L1
_L1:
        String s;
        s = (new StringBuilder()).append(com.baidu.autoupdatesdk.obf.e.a().a(c)).append("ungzip.xdt").toString();
        GDiffPatcher.unGZip(e, s);
        try
        {
            avoid.patch(new File(d), new File(s), new File(f));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            try
            {
                avoid.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                return Boolean.valueOf(false);
            }
        }
_L3:
        return Boolean.valueOf(true);
_L2:
        avoid.patch(new File(d), new File(e), new File(f));
          goto _L3
        avoid;
        avoid.printStackTrace();
          goto _L3
    }

    protected void a(Boolean boolean1)
    {
        b = false;
        if (boolean1.booleanValue())
        {
            aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("merge success: ").append(f).toString());
        } else
        {
            aj.a("BDAutoUpdateSDK", "merge failed.");
        }
        if (g != null)
        {
            g.a(boolean1.booleanValue(), f);
        }
        b();
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }


    private class b
        implements FilenameFilter
    {

        public boolean accept(File file, String s)
        {
            return !TextUtils.isEmpty(s) && s.endsWith(".xdt");
        }

        private b()
        {
        }

    }


    private class a
    {

        public abstract void a(boolean flag, String s);
    }

}
