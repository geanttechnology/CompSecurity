// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;
import java.io.File;
import myobfuscated.av.b;
import myobfuscated.aw.d;

// Referenced classes of package com.photo.gpu:
//            f, GPUImage, e, c, 
//            a

public class GPUImageView extends FrameLayout
{

    public GLSurfaceView a;
    public GPUImage b;
    private float c;

    public GPUImageView(Context context)
    {
        super(context);
        c = 0.0F;
        a(context, null);
    }

    public GPUImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = 0.0F;
        a(context, attributeset);
    }

    private void a(Context context, AttributeSet attributeset)
    {
        a = new f(this, context, attributeset);
        addView(a);
        b = new GPUImage(getContext());
        attributeset = b;
        attributeset.c = a;
        ((GPUImage) (attributeset)).c.setEGLContextClientVersion(2);
        ((GPUImage) (attributeset)).c.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        ((GPUImage) (attributeset)).c.getHolder().setFormat(1);
        ((GPUImage) (attributeset)).c.setRenderer(((GPUImage) (attributeset)).b);
        ((GPUImage) (attributeset)).c.setRenderMode(0);
        ((GPUImage) (attributeset)).c.requestRender();
        attributeset.f = new b(context);
        ((GPUImage) (attributeset)).c.setOnTouchListener(new GPUImage._cls1(attributeset));
        ((GPUImage) (attributeset)).b.g = ((GPUImage) (attributeset)).f;
        ((GPUImage) (attributeset)).f.g = attributeset;
    }

    protected void onMeasure(int i, int j)
    {
        if (c != 0.0F)
        {
            i = android.view.View.MeasureSpec.getSize(i);
            j = android.view.View.MeasureSpec.getSize(j);
            if ((float)i / c < (float)j)
            {
                j = Math.round((float)i / c);
            } else
            {
                i = Math.round((float)j * c);
            }
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000));
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public void setFilter(d d)
    {
        GPUImage gpuimage = b;
        gpuimage.d = d;
        gpuimage.b.a(gpuimage.d);
        gpuimage.b();
        a.requestRender();
    }

    public void setImage(Bitmap bitmap)
    {
        b.c();
        b.a(bitmap);
    }

    public void setImage(Uri uri)
    {
        GPUImage gpuimage = b;
        (new c(gpuimage, gpuimage, uri)).execute(new Void[0]);
    }

    public void setImage(File file)
    {
        GPUImage gpuimage = b;
        (new a(gpuimage, gpuimage, file)).execute(new Void[0]);
    }

    public void setRatio(float f1)
    {
        c = f1;
        a.requestLayout();
        b.c();
    }
}
