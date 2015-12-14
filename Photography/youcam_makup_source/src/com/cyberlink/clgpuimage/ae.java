// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

// Referenced classes of package com.cyberlink.clgpuimage:
//            GPUImage, z, u

public class ae extends GLSurfaceView
{

    protected GPUImage a;
    protected u b;
    protected float c;

    public ae(Context context)
    {
        super(context);
        c = 0.0F;
        a();
    }

    public ae(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = 0.0F;
        a();
    }

    protected void a()
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            a = new GPUImage(getContext());
            a.a(this);
            return;
        }
    }

    public Bitmap getBitmap()
    {
        return a.e();
    }

    public u getFilter()
    {
        return b;
    }

    public Bitmap getImage()
    {
        return a.c();
    }

    public z getRender()
    {
        return getRenderer();
    }

    public z getRenderer()
    {
        if (a != null)
        {
            return a.a();
        } else
        {
            return null;
        }
    }

    protected void onMeasure(int i, int j)
    {
        if (c == 0.0F)
        {
            super.onMeasure(i, j);
            return;
        }
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
    }

    public void onResume()
    {
        super.onResume();
        if (getRenderer() != null)
        {
            getRenderer().a(a.c(), false);
        }
    }

    public void setFilter(u u)
    {
        b = u;
        a.a(u);
        requestRender();
    }

    public void setImage(Bitmap bitmap)
    {
        a.d();
        a.a(bitmap);
    }

    public void setImage(Uri uri)
    {
        a.a(uri);
    }

    public void setRatio(float f)
    {
        c = f;
        requestLayout();
        a.d();
    }

    public void setScaleType(GPUImage.ScaleType scaletype)
    {
        a.a(scaletype);
    }
}
