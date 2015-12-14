// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class aqr
{

    static String a = "cache_";
    static String b = "AsyncImageLoader";
    private ExecutorService c;
    private final Handler d = new Handler();

    public aqr()
    {
        c = Executors.newFixedThreadPool(5);
    }

    static Handler a(aqr aqr1)
    {
        return aqr1.d;
    }

    public static String a()
    {
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.tmp/").toString());
        if (!file.exists())
        {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    public Bitmap a(Context context, String s, aqu aqu)
    {
        String s1 = (new StringBuilder()).append(a).append(s).toString();
        String s2 = aqx.b(context, b, s1);
        if (s2 == null)
        {
            c.submit(new aqs(this, s, context, s1, aqu));
            return null;
        } else
        {
            return BitmapFactory.decodeFile(s2);
        }
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
