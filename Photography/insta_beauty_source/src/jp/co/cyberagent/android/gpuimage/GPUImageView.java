// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import bya;
import byh;
import java.io.File;

// Referenced classes of package jp.co.cyberagent.android.gpuimage:
//            GPUImage

public class GPUImageView extends GLSurfaceView
{

    private byh mFilter;
    private GPUImage mGPUImage;
    private float mRatio;

    public GPUImageView(Context context)
    {
        super(context);
        mRatio = 0.0F;
        init();
    }

    public GPUImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mRatio = 0.0F;
        init();
    }

    private void init()
    {
        mGPUImage = new GPUImage(getContext());
        mGPUImage.a(this);
    }

    public byh getFilter()
    {
        return mFilter;
    }

    protected void onMeasure(int i, int j)
    {
        if (mRatio == 0.0F)
        {
            super.onMeasure(i, j);
            return;
        }
        i = android.view.View.MeasureSpec.getSize(i);
        j = android.view.View.MeasureSpec.getSize(j);
        if ((float)i / mRatio < (float)j)
        {
            j = Math.round((float)i / mRatio);
        } else
        {
            i = Math.round((float)j * mRatio);
        }
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000));
    }

    public void saveToPictures(String s, String s1, bya bya)
    {
        mGPUImage.a(s, s1, bya);
    }

    public void setFilter(byh byh)
    {
        mFilter = byh;
        mGPUImage.a(byh);
        requestRender();
    }

    public void setImage(Bitmap bitmap)
    {
        mGPUImage.a(bitmap);
    }

    public void setImage(Uri uri)
    {
        mGPUImage.a(uri);
    }

    public void setImage(File file)
    {
        mGPUImage.a(file);
    }

    public void setRatio(float f)
    {
        mRatio = f;
        requestLayout();
        mGPUImage.b();
    }
}
