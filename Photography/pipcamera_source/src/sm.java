// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;

public class sm extends AsyncTask
{

    public int a;
    private int b;
    private Bitmap c;
    private sn d;

    public sm(Bitmap bitmap)
    {
        a = 320;
        c = null;
        c = bitmap;
    }

    protected transient Bitmap a(Context acontext[])
    {
        Log.v("AsynPIPCropImageTasK ", "AsynPIPCropImageTasK doInBackground");
        try
        {
            acontext = b(c);
        }
        // Misplaced declaration of an exception variable
        catch (Context acontext[])
        {
            Log.e("AsynPIPCropImageTasK ", acontext.getMessage());
            Crashlytics.logException(acontext);
            return null;
        }
        return acontext;
    }

    protected void a(Bitmap bitmap)
    {
        super.onPostExecute(bitmap);
        Log.v("AsynPIPCropImageTasK ", "AsynPIPCropImageTasK onPostExecute");
        if (d != null)
        {
            if (bitmap != null)
            {
                d.a(bitmap, b);
            } else
            {
                Log.v("AsynPIPCropImageTasK ", "AsynPIPCropImageTasK onPostExecute result is null");
                bitmap = new Exception("result is null");
                d.a(bitmap);
            }
        } else
        {
            Log.v("AsynPIPCropImageTasK ", "AsynPIPCropImageTasK onPostExecute mListener is null");
        }
        d = null;
    }

    public void a(sn sn1)
    {
        d = sn1;
    }

    protected Bitmap b(Bitmap bitmap)
    {
label0:
        {
            if (bitmap == null)
            {
                return null;
            }
            int k = bitmap.getWidth();
            int i1 = bitmap.getHeight();
            Log.v("AsynPIPCropImageTasK ", (new StringBuilder()).append("AsynPIPCropImageTasK ori cropWidth:").append(k).append("ori cropHeight:").append(i1).toString());
            int i = k;
            int j = i1;
            if (bitmap != null)
            {
                i = k;
                j = i1;
                if (Math.max(bitmap.getWidth(), bitmap.getHeight()) > a)
                {
                    float f = (float)bitmap.getWidth() / (float)bitmap.getHeight();
                    int j1;
                    if (f > 1.0F)
                    {
                        i = k;
                        if (k > a)
                        {
                            i = a;
                        }
                        j = (int)((float)i / f);
                    } else
                    {
                        int l;
                        if (i1 > a)
                        {
                            i = a;
                        } else
                        {
                            i = i1;
                        }
                        l = (int)((float)i * f);
                        j = i;
                        i = l;
                    }
                }
            }
            if (i % 2 == 0)
            {
                i1 = i;
                j1 = j;
                if (j % 2 == 0)
                {
                    break label0;
                }
            }
            k = i;
            if (i % 2 != 0)
            {
                k = i - 1;
            }
            i1 = k;
            j1 = j;
            if (j % 2 != 0)
            {
                j1 = j - 1;
                i1 = k;
            }
        }
        bitmap = Bitmap.createScaledBitmap(bitmap, i1, j1, true);
        Log.v("AsynPIPCropImageTasK ", (new StringBuilder()).append("AsynPIPCropImageTasK cropWidth:").append(i1).append("cropHeight:").append(j1).toString());
        return bitmap;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Context[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Bitmap)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (d != null)
        {
            d.a(b);
        }
    }
}
