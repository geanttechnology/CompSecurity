// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.net;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import com.socialin.android.d;
import com.socialin.android.util.FileUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FileDownloadService extends Service
    implements android.os.Handler.Callback
{

    private final String a = com/socialin/android/net/FileDownloadService.getSimpleName();
    private HandlerThread b;
    private Handler c;

    public FileDownloadService()
    {
        b = new HandlerThread("FileDownloadServiceThread", 10);
        c = null;
    }

    private int a(String s, String s1)
    {
        if (!FileUtils.a()) goto _L2; else goto _L1
_L1:
        File file = new File(s1);
        if (!file.exists()) goto _L4; else goto _L3
_L3:
        int i = 1;
_L10:
        Object obj;
        Object obj1;
        Object obj2;
        File file1;
        int j;
        if (i != 1)
        {
            try
            {
                if (file.exists())
                {
                    file.delete();
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
                });
                return i;
            }
        }
        return i;
_L4:
        obj = null;
        s1 = null;
        obj2 = null;
        obj1 = null;
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setReadTimeout(20000);
        s.setConnectTimeout(20000);
        s.setRequestMethod("GET");
        s.setRequestProperty("Content-Type", "application/octet-stream");
        s.connect();
        obj = new BufferedInputStream(s.getInputStream(), 8192);
        file1 = new File((new StringBuilder()).append(file.getPath()).append(".tmp").toString());
        if (!FileUtils.a()) goto _L6; else goto _L5
_L5:
        file1.getParentFile().mkdirs();
        s1 = new FileOutputStream(file1);
        obj1 = new byte[8192];
_L9:
        i = ((InputStream) (obj)).read(((byte []) (obj1)));
        if (i == -1) goto _L8; else goto _L7
_L7:
        s1.write(((byte []) (obj1)), 0, i);
          goto _L9
        obj2;
        obj1 = obj;
        obj = s;
        s = ((String) (obj1));
        obj1 = obj2;
_L16:
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((MalformedURLException) (obj1)).getMessage()).toString()
        });
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        ((HttpURLConnection) (obj)).disconnect();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_277;
        }
        s1.close();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        s.close();
        i = -1;
          goto _L10
_L8:
        s1.flush();
        if (file.exists())
        {
            file.delete();
        }
        file1.renameTo(file);
        i = 1;
_L11:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_328;
        }
        s.disconnect();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        s1.close();
        ((InputStream) (obj)).close();
          goto _L10
_L6:
        i = -2;
        s1 = null;
          goto _L11
        s;
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
        });
          goto _L10
        s;
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
        });
        i = -1;
          goto _L10
        s;
        obj = null;
_L15:
        i = -1;
        j = s1.getResponseCode();
        i = j;
_L12:
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
        });
        if (i == 200)
        {
            i = -2;
        } else
        {
            i = -1;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_501;
        }
        s1.disconnect();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_511;
        }
        ((OutputStream) (obj1)).close();
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
                });
            }
        }
          goto _L10
        obj2;
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj2)).getMessage()).toString()
        });
          goto _L12
        s;
_L14:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_571;
        }
        s1.disconnect();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_581;
        }
        ((OutputStream) (obj1)).close();
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(s1.getMessage()).toString()
                });
            }
        }
        throw s;
_L2:
        return -2;
        s;
        obj1 = null;
        s1 = ((String) (obj));
        obj = obj1;
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj = null;
        s1 = s;
        s = ((String) (obj1));
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
        obj1;
        s1 = s;
        s = ((String) (obj1));
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
        Object obj3;
        obj3;
        obj1 = s1;
        s1 = s;
        s = ((String) (obj3));
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj1 = s1;
        String s2 = s;
        s1 = ((String) (obj));
        s = exception;
        obj = s2;
        if (true) goto _L14; else goto _L13
_L13:
        s2;
        obj = null;
        s1 = s;
        s = s2;
          goto _L15
        s2;
        s1 = s;
        s = s2;
          goto _L15
        s2;
        obj1 = s1;
        s1 = s;
        s = s2;
          goto _L15
        obj1;
        s1 = null;
        obj = null;
        s = null;
          goto _L16
        obj1;
        s1 = null;
        obj = s;
        s = null;
          goto _L16
        obj1;
        String s3 = s;
        s = ((String) (obj));
        s1 = null;
        obj = s3;
          goto _L16
    }

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 26;
           goto _L1 _L2
_L1:
        return false;
_L2:
        Object obj = (Intent)message.obj;
        message = ((Intent) (obj)).getStringExtra("download_file_path");
        obj = ((Intent) (obj)).getStringExtra("download_file_url");
        int i = a(((String) (obj)), message);
        Intent intent = new Intent("intent.action.download.complete");
        intent.putExtra("download_status", i);
        intent.putExtra("download_file_path", message);
        intent.putExtra("download_file_url", ((String) (obj)));
        sendBroadcast(intent);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        b.start();
        c = new Handler(b.getLooper(), this);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if (intent != null)
        {
            Message message = c.obtainMessage(1);
            message.obj = intent;
            if (intent.getBooleanExtra("add_to_front", false))
            {
                c.sendMessageAtFrontOfQueue(message);
            } else
            {
                c.sendMessage(message);
            }
        }
        return 2;
    }
}
