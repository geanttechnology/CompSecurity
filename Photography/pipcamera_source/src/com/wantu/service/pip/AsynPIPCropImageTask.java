// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.pip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import ev;
import ye;

public class AsynPIPCropImageTask extends AsyncTask
{

    public int a;
    private int b;
    private AsynPIPCropType c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Bitmap h;
    private ye i;

    public AsynPIPCropImageTask(Bitmap bitmap)
    {
        a = 180;
        h = null;
        h = bitmap;
    }

    protected Bitmap a(Bitmap bitmap, int j, int k)
    {
        if (c == null || c == AsynPIPCropType.THUMBNAIL)
        {
            return ev.a(bitmap, j, k);
        } else
        {
            Matrix matrix = new Matrix();
            return Bitmap.createBitmap(bitmap, d, e, f, g, matrix, true);
        }
    }

    protected transient Bitmap a(Context acontext[])
    {
        acontext = acontext[0];
        Log.v("AsynPIPCropImageTasK ", "AsynPIPCropImageTasK doInBackground");
        try
        {
            acontext = a(h, a, a);
        }
        // Misplaced declaration of an exception variable
        catch (Context acontext[])
        {
            Crashlytics.logException(acontext);
            return null;
        }
        return acontext;
    }

    public void a(int j)
    {
        b = j;
    }

    public void a(int j, AsynPIPCropType asynpipcroptype, int k, int l, int i1, int j1)
    {
        b = j;
        c = asynpipcroptype;
        d = k;
        e = l;
        f = i1;
        g = j1;
    }

    protected void a(Bitmap bitmap)
    {
        super.onPostExecute(bitmap);
        Log.v("AsynPIPCropImageTasK ", "AsynPIPCropImageTasK onPostExecute");
        if (i != null)
        {
            if (bitmap != null)
            {
                i.a(bitmap, b);
            } else
            {
                Log.v("AsynPIPCropImageTasK ", "AsynPIPCropImageTasK onPostExecute result is null");
                bitmap = new Exception("result is null");
                i.a(bitmap);
            }
        } else
        {
            Log.v("AsynPIPCropImageTasK ", "AsynPIPCropImageTasK onPostExecute mListener is null");
        }
        i = null;
    }

    public void a(ye ye1)
    {
        i = ye1;
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
        if (i != null)
        {
            i.a_(b);
        }
    }

    private class AsynPIPCropType extends Enum
    {

        private static final AsynPIPCropType $VALUES[];
        public static final AsynPIPCropType NORMALCROP;
        public static final AsynPIPCropType THUMBNAIL;

        public static AsynPIPCropType valueOf(String s)
        {
            return (AsynPIPCropType)Enum.valueOf(com/wantu/service/pip/AsynPIPCropImageTask$AsynPIPCropType, s);
        }

        public static AsynPIPCropType[] values()
        {
            return (AsynPIPCropType[])$VALUES.clone();
        }

        static 
        {
            THUMBNAIL = new AsynPIPCropType("THUMBNAIL", 0);
            NORMALCROP = new AsynPIPCropType("NORMALCROP", 1);
            $VALUES = (new AsynPIPCropType[] {
                THUMBNAIL, NORMALCROP
            });
        }

        private AsynPIPCropType(String s, int j)
        {
            super(s, j);
        }
    }

}
