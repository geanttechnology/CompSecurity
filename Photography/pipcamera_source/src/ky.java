// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ky
{

    static String a = "cache_";
    static String b = "AsyncImageLoader";
    private ExecutorService c;
    private final Handler d = new Handler();

    public ky()
    {
        c = Executors.newFixedThreadPool(5);
    }

    static Handler a(ky ky1)
    {
        return ky1.d;
    }

    public static String a()
    {
        File file = PIPCameraApplication.a.getExternalFilesDir(null);
        if (!file.exists())
        {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    public Bitmap a(Context context, String s, kz kz)
    {
        String s1 = (new StringBuilder()).append(a).append(s).toString();
        String s2 = la.a(context, b, s1);
        if (s2 == null)
        {
            c.submit(new Runnable(s, context, s1, kz) {

                final String a;
                final Context b;
                final String c;
                final kz d;
                final ky e;

                public void run()
                {
                    String s3;
                    s3 = UUID.randomUUID().toString();
                    s3 = (new StringBuilder()).append(ky.a()).append("/").append(s3).toString();
                    e.a(a, s3);
                    la.a(b, ky.b, c, s3);
                    ky.a(e).post(new Runnable(this, s3) {

                        final String a;
                        final _cls1 b;

                        public void run()
                        {
                            if (b.d == null)
                            {
                                break MISSING_BLOCK_LABEL_31;
                            }
                            Bitmap bitmap = BitmapFactory.decodeFile(a);
                            b.d.a(bitmap);
                            return;
                            Exception exception;
                            exception;
                            Crashlytics.logException(exception);
                            return;
                        }

            
            {
                b = _pcls1;
                a = s;
                super();
            }
                    });
_L1:
                    return;
                    Exception exception;
                    exception;
                    if (d != null)
                    {
                        d.a(exception);
                        return;
                    }
                      goto _L1
                }

            
            {
                e = ky.this;
                a = s;
                b = context;
                c = s1;
                d = kz1;
                super();
            }
            });
            return null;
        }
        try
        {
            context = BitmapFactory.decodeFile(s2);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
            context = null;
        }
        return context;
    }

    public void a(String s, String s1)
    {
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setConnectTimeout(5000);
        s.setRequestMethod("GET");
        s.setDoInput(true);
        if (s.getResponseCode() == 200)
        {
            s = s.getInputStream();
            s1 = new FileOutputStream(s1);
            byte abyte0[] = new byte[1024];
            do
            {
                int i = s.read(abyte0);
                if (i != -1)
                {
                    s1.write(abyte0, 0, i);
                } else
                {
                    s.close();
                    s1.close();
                    return;
                }
            } while (true);
        } else
        {
            throw new RuntimeException(String.valueOf(s.getResponseCode()));
        }
    }

}
