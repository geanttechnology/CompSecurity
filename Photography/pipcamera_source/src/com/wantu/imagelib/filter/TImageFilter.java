// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.fotoable.comlib.util.AsyncTask;
import com.pipcamera.application.PIPCameraApplication;
import java.util.List;

// Referenced classes of package com.wantu.imagelib.filter:
//            TImageFilterInfo, TImageProcessingDelegate, commenProcess

public class TImageFilter extends AsyncTask
{

    private static final String TAG = "TImageFilter";
    private TImageProcessingDelegate mDelegate;
    private TImageFilterInfo mInfo;
    private Bitmap mSourceBmp;

    public TImageFilter()
    {
    }

    protected transient Bitmap doInBackground(String as[])
    {
        return process();
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    public Bitmap getSourceBmp()
    {
        return mSourceBmp;
    }

    public TImageProcessingDelegate getmDelegate()
    {
        return mDelegate;
    }

    public TImageFilterInfo getmInfo()
    {
        return mInfo;
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        Log.v("TImageFilter", "End processing");
        if (mDelegate != null)
        {
            mDelegate.imageDidProcessed(bitmap, mInfo.filterName);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }

    protected void onPreExecute()
    {
        Log.v("TImageFilter", "start processing");
        if (mDelegate != null)
        {
            mDelegate.imageStartProcessing();
        }
    }

    public Bitmap process()
    {
        Bitmap bitmap = Bitmap.createBitmap(mSourceBmp.getWidth(), mSourceBmp.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        for (int i = 0; i < mInfo.processes.size(); i++)
        {
            commenProcess commenprocess = (commenProcess)mInfo.processes.get(i);
            commenprocess.sourceImage = mSourceBmp;
            commenprocess.canvasBitmap = bitmap;
            commenprocess.context = PIPCameraApplication.a;
            commenprocess.process(canvas, paint);
            commenprocess.sourceImage = null;
            commenprocess.canvasBitmap = null;
            commenprocess.context = null;
        }

        return bitmap;
    }

    public void setSourceBmp(Bitmap bitmap)
    {
        mSourceBmp = bitmap;
    }

    public void setmDelegate(TImageProcessingDelegate timageprocessingdelegate)
    {
        mDelegate = timageprocessingdelegate;
    }

    public void setmInfo(TImageFilterInfo timagefilterinfo)
    {
        mInfo = timagefilterinfo;
    }
}
