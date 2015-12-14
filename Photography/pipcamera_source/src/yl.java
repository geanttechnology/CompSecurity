// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import com.pipcamera.application.PIPCameraApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class yl
{

    private static yl a;
    private File b;
    private HashMap c;

    private yl()
    {
        c = new HashMap();
        b = d();
        if (!b.exists())
        {
            b.mkdir();
        }
    }

    public static String a(String s, Bitmap bitmap)
    {
        s = (new StringBuilder()).append(b()).append("/").append(s).toString();
        FileOutputStream fileoutputstream = new FileOutputStream(s);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileoutputstream);
        fileoutputstream.flush();
        fileoutputstream.close();
        Log.v("Imagekeeper", (new StringBuilder()).append(s).append(" has write successfully").toString());
        return s;
    }

    public static yl a()
    {
        if (a == null)
        {
            a = new yl();
        }
        return a;
    }

    public static String b()
    {
        return d().getAbsolutePath();
    }

    private static File d()
    {
        File file1 = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.tmp/").toString());
        File file = file1;
        if (!file1.exists())
        {
            file = file1;
            if (!file1.mkdir())
            {
                file = PIPCameraApplication.b().getDir("tmp", 0);
            }
        }
        return file;
    }

    public String a(String s)
    {
        return (new StringBuilder()).append(b.getAbsolutePath()).append("/").append(s).toString();
    }

    public Bitmap b(String s)
    {
        s = a(s);
        if (s == null)
        {
            return null;
        } else
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inScaled = false;
            return BitmapFactory.decodeFile(s, options);
        }
    }

    public void c()
    {
        Iterator iterator = c.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)((java.util.Map.Entry)iterator.next()).getValue();
            if (obj == null)
            {
                return;
            }
            obj = new File(((String) (obj)));
            if (((File) (obj)).exists())
            {
                ((File) (obj)).delete();
            }
        } while (true);
        c.clear();
    }
}
