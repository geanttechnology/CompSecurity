// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.common;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GifImageView extends View
{

    private Movie a;
    private long b;
    private int c;
    private int d;
    private float e;
    private float f;
    private boolean g;

    public GifImageView(Context context)
    {
        super(context);
        a = null;
        e = 1.0F;
        f = 1.0F;
        g = false;
        setLayerType(1, null);
    }

    public GifImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        e = 1.0F;
        f = 1.0F;
        g = false;
        setLayerType(1, null);
    }

    public GifImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = null;
        e = 1.0F;
        f = 1.0F;
        g = false;
        setLayerType(1, null);
    }

    private byte[] a(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        bytearrayoutputstream = new ByteArrayOutputStream(1024);
        abyte0 = new byte[1024];
_L1:
        int i = inputstream.read(abyte0);
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        bytearrayoutputstream.write(abyte0, 0, i);
          goto _L1
        inputstream;
        return bytearrayoutputstream.toByteArray();
    }

    public void a()
    {
        g = true;
    }

    public void b()
    {
        g = false;
        b = 0L;
    }

    protected void onDraw(Canvas canvas)
    {
label0:
        {
            canvas.drawColor(-1);
            if (a != null)
            {
                if (!g)
                {
                    long l = SystemClock.uptimeMillis();
                    if (b == 0L)
                    {
                        b = l;
                    }
                    int i = (int)((l - b) % (long)a.duration());
                    a.setTime(i);
                } else
                {
                    a.setTime(0);
                }
                canvas.save();
                canvas.scale(e, f);
                a.draw(canvas, 0.0F, 0.0F);
                canvas.restore();
                if (!g)
                {
                    if (android.os.Build.VERSION.SDK_INT < 16)
                    {
                        break label0;
                    }
                    postInvalidateOnAnimation();
                }
            }
            return;
        }
        invalidate();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
    }

    protected void onMeasure(int i, int j)
    {
        int k;
        int l;
        int i1 = android.view.View.MeasureSpec.getMode(i);
        i = android.view.View.MeasureSpec.getSize(i);
        l = android.view.View.MeasureSpec.getMode(j);
        k = android.view.View.MeasureSpec.getSize(j);
        if (a != null)
        {
            c = a.width();
            d = a.height();
        }
        if (i1 == 0x40000000)
        {
            j = i;
            if (a != null)
            {
                e = (float)i / (float)c;
                j = i;
            }
        } else
        if (i1 == 0x80000000)
        {
            if (a != null)
            {
                j = i;
                if (i > c)
                {
                    j = c;
                }
                e = (float)j / (float)c;
            } else
            {
                j = i;
            }
        } else
        {
            j = c;
            e = 1.0F;
        }
        if (l != 0x40000000) goto _L2; else goto _L1
_L1:
        i = k;
        if (a != null)
        {
            f = (float)k / (float)d;
            i = k;
        }
_L4:
        setMeasuredDimension(j, i);
        return;
_L2:
        if (l == 0x80000000)
        {
            i = k;
            if (a != null)
            {
                if (k > d)
                {
                    i = d;
                } else
                {
                    i = k;
                }
                if (k > d)
                {
                    if (e != 1.0F)
                    {
                        i = Math.round((float)d * e);
                        f = e;
                    } else
                    {
                        i = d;
                        f = (float)i / (float)d;
                    }
                }
            }
        } else
        if (e != 1.0F)
        {
            i = Math.round((float)d * e);
            f = e;
        } else
        {
            i = d;
            f = 1.0F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setGifImage(ByteArrayOutputStream bytearrayoutputstream)
    {
        bytearrayoutputstream = bytearrayoutputstream.toByteArray();
        a = Movie.decodeByteArray(bytearrayoutputstream, 0, bytearrayoutputstream.length);
        b = 0L;
        g = false;
        setLayerType(1, null);
        requestLayout();
    }

    public void setGifImage(File file)
    {
        if (file == null || file.toString().length() == 0)
        {
            return;
        }
        try
        {
            file = new FileInputStream(file.toString());
            setGifImage(((InputStream) (file)));
            file.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            file.printStackTrace();
        }
    }

    public void setGifImage(InputStream inputstream)
    {
        inputstream = a(inputstream);
        a = Movie.decodeByteArray(inputstream, 0, inputstream.length);
        b = 0L;
        g = false;
        setLayerType(1, null);
        requestLayout();
    }

    public void setGifImage(String s)
    {
        s = getResources().getAssets().open(s);
        if (s == null)
        {
            return;
        }
        try
        {
            setGifImage(((InputStream) (s)));
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
    }
}
