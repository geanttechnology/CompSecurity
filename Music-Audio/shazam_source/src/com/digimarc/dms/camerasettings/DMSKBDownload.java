// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.camerasettings;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

// Referenced classes of package com.digimarc.dms.camerasettings:
//            DMSCameraSettingsKB

public class DMSKBDownload
    implements Runnable
{

    private static final String TAG = com/digimarc/dms/camerasettings/DMSKBDownload.getName();
    private static DMSKBDownload _instance = null;
    private static final String kCachedKBFile = "CameraSettingsKB_Android.json";
    private static final String kCachedKBFolder = "camerasettings";
    private static Context mContext = null;
    private static boolean mLastDownloadSuccesful = false;
    private Object mDownloadKBLock;

    public DMSKBDownload(Context context)
    {
        mContext = context;
        mDownloadKBLock = new Object();
    }

    private boolean cacheKB(String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (!s.isEmpty())
            {
                flag = flag1;
                if (DMSCameraSettingsKB.getInstance(mContext, null).parseKB(s) != null)
                {
                    writeKB(s, (new StringBuilder()).append(getExternalFilesDir()).append("/CameraSettingsKB_Android.json").toString());
                    flag = true;
                }
            }
        }
        return flag;
    }

    private String downloadKB(String s)
    {
        String s3 = "";
        Object obj = mDownloadKBLock;
        obj;
        JVM INSTR monitorenter ;
        String s1;
        String s2;
        s1 = s3;
        s2 = s3;
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s1 = s3;
        s2 = s3;
        s.setRequestMethod("GET");
        s1 = s3;
        s2 = s3;
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
        s = s3;
_L2:
        s1 = s;
        s2 = s;
        s3 = bufferedreader.readLine();
        if (s3 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        s2 = s;
        s = (new StringBuilder()).append(s).append(s3).toString();
        if (true) goto _L2; else goto _L1
_L1:
        s1 = s;
        s2 = s;
        bufferedreader.close();
_L3:
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        s.printStackTrace();
        s = s1;
          goto _L3
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s;
        s.printStackTrace();
        s = s2;
          goto _L3
    }

    private String getExternalFilesDir()
    {
        String s;
        try
        {
            s = mContext.getDir("camerasettings", 0).getAbsolutePath();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return "";
        }
        return s;
    }

    public static DMSKBDownload getInstance(Context context)
    {
        if (_instance == null)
        {
            _instance = new DMSKBDownload(context);
        }
        return _instance;
    }

    private boolean writeKB(String s, String s1)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        s1 = new FileOutputStream(s1);
        s1.write(s.getBytes(Charset.defaultCharset()));
        s1.close();
        flag = true;
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        s.printStackTrace();
          goto _L1
        s;
        throw s;
        s;
        s.printStackTrace();
          goto _L1
    }

    public String getDownloadedKBContents()
    {
        return readKB();
    }

    public boolean isLastDownloadSuccesful()
    {
        return mLastDownloadSuccesful;
    }

    public String readKB()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj2 = new File((new StringBuilder()).append(getExternalFilesDir()).append("/CameraSettingsKB_Android.json").toString());
        byte abyte0[] = new byte[(int)((File) (obj2)).length()];
        obj2 = new FileInputStream(((File) (obj2)));
        ((FileInputStream) (obj2)).read(abyte0);
        ((FileInputStream) (obj2)).close();
        obj = new String(abyte0);
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        obj;
        ((Exception) (obj)).printStackTrace();
_L3:
        obj = "";
        if (true) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1;
        throw obj1;
        obj1;
          goto _L3
    }

    public void run()
    {
        mLastDownloadSuccesful = cacheKB(downloadKB(DMSCameraSettingsKB.getInstance(mContext, null).getKBUrl()));
    }

}
