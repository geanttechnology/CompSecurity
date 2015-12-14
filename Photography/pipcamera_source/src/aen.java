// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class aen extends AsyncTask
{

    final GPUImage a;
    private final Bitmap b;
    private final String c;
    private final String d;
    private final ael e;
    private final Handler f = new Handler();

    public aen(GPUImage gpuimage, Bitmap bitmap, String s, String s1, ael ael)
    {
        a = gpuimage;
        super();
        b = bitmap;
        c = s;
        d = s1;
        e = ael;
    }

    static ael a(aen aen1)
    {
        return aen1.e;
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
            bitmap = new android.media.MediaScannerConnection.OnScanCompletedListener() {

                final aen a;

                public void onScanCompleted(String s2, Uri uri)
                {
                    if (aen.a(a) != null)
                    {
                        aen.b(a).post(new Runnable(this, uri) {

                            final Uri a;
                            final _cls1 b;

                            public void run()
                            {
                                aen.a(b.a).a(a);
                            }

            
            {
                b = _pcls1;
                a = uri;
                super();
            }
                        });
                    }
                }

            
            {
                a = aen.this;
                super();
            }
            };
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

    static Handler b(aen aen1)
    {
        return aen1.f;
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
