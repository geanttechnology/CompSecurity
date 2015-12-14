// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
import java.io.File;

public class oa
{

    ob a;
    String b;
    String c;
    ru d;
    Context e;

    public oa(Context context)
    {
        b = "";
        c = "";
        e = context;
    }

    private boolean a(String s)
    {
        try
        {
            s = PIPCameraApplication.b().c().getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
            s = null;
        }
        return s != null;
    }

    private void b()
    {
        b = "instamag_test.apk";
        c = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Download/").toString();
        d = new ru(e, false, b, c);
        d.a(new rv() {

            final oa a;

            public void a(int i)
            {
                File file;
                Log.i("CopyFile", (new StringBuilder()).append("CopyFileFinished..  state ...").append(i).toString());
                file = new File((new StringBuilder()).append(a.c).append(a.b).toString());
                if (!file.exists()) goto _L2; else goto _L1
_L1:
                i;
                JVM INSTR tableswitch 1 1: default 88
            //                           1 124;
                   goto _L3 _L4
_L3:
                file.delete();
                if (a.a != null)
                {
                    a.a.a();
                }
_L6:
                a.d = null;
                return;
_L4:
                if (a.a != null)
                {
                    a.a.a(file);
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (a.a != null)
                {
                    a.a.a();
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                a = oa.this;
                super();
            }
        });
        d.b = false;
        d.execute(new Void[0]);
    }

    public void a()
    {
        if (!a("com.instamag.activity"))
        {
            Log.i("create shorcut", "create shrtcut");
            b();
        } else
        if (a != null)
        {
            a.a();
            return;
        }
    }

    public void a(ob ob1)
    {
        a = ob1;
    }
}
