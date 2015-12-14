// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class byc extends AsyncTask
{

    final GPUImage a;
    private final Bitmap b;
    private final String c;
    private final String d;
    private final bya e;
    private final Handler f = new Handler();

    public byc(GPUImage gpuimage, Bitmap bitmap, String s, String s1, bya bya)
    {
        a = gpuimage;
        super();
        b = bitmap;
        c = s;
        d = s1;
        e = bya;
    }

    static bya a(byc byc1)
    {
        return byc1.e;
    }

    private void a(String s, String s1, Bitmap bitmap)
    {
        s1 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), (new StringBuilder()).append(s).append("/").append(s1).toString());
        try
        {
            s1.getParentFile().mkdirs();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(s1));
            s = GPUImage.b(a);
            s1 = s1.toString();
            bitmap = new byd(this);
            MediaScannerConnection.scanFile(s, new String[] {
                s1
            }, null, bitmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    static Handler b(byc byc1)
    {
        return byc1.f;
    }

    protected transient Void a(Void avoid[])
    {
        avoid = a.b(b);
        a(c, d, ((Bitmap) (avoid)));
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }
}
