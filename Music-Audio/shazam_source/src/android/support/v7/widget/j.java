// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.b.a.c;
import android.support.v4.view.w;
import android.support.v7.internal.widget.q;
import android.support.v7.internal.widget.r;
import android.util.AttributeSet;
import android.widget.RatingBar;

public final class j extends RatingBar
{

    private static final int a[] = {
        0x101013b, 0x101013c
    };
    private Bitmap b;

    public j(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.b.a.a.ratingBarStyle);
    }

    private j(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (q.a)
        {
            context = r.a(getContext(), attributeset, a, i);
            attributeset = context.b(0);
            if (attributeset != null)
            {
                setIndeterminateDrawable(a(attributeset));
            }
            attributeset = context.b(1);
            if (attributeset != null)
            {
                setProgressDrawable(a(attributeset, false));
            }
            ((r) (context)).a.recycle();
        }
    }

    private Drawable a(Drawable drawable)
    {
        Object obj = drawable;
        if (drawable instanceof AnimationDrawable)
        {
            drawable = (AnimationDrawable)drawable;
            int k = drawable.getNumberOfFrames();
            obj = new AnimationDrawable();
            ((AnimationDrawable) (obj)).setOneShot(drawable.isOneShot());
            for (int i = 0; i < k; i++)
            {
                Drawable drawable1 = a(drawable.getFrame(i), true);
                drawable1.setLevel(10000);
                ((AnimationDrawable) (obj)).addFrame(drawable1, drawable.getDuration(i));
            }

            ((AnimationDrawable) (obj)).setLevel(10000);
        }
        return ((Drawable) (obj));
    }

    private Drawable a(Drawable drawable, boolean flag)
    {
        boolean flag1 = false;
        if (drawable instanceof c)
        {
            Drawable drawable1 = ((c)drawable).a();
            if (drawable1 != null)
            {
                drawable1 = a(drawable1, flag);
                ((c)drawable).a(drawable1);
            }
        } else
        {
            if (drawable instanceof LayerDrawable)
            {
                drawable = (LayerDrawable)drawable;
                int l = drawable.getNumberOfLayers();
                Drawable adrawable[] = new Drawable[l];
                int i = 0;
                while (i < l) 
                {
                    int i1 = drawable.getId(i);
                    Drawable drawable2 = drawable.getDrawable(i);
                    if (i1 == 0x102000d || i1 == 0x102000f)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    adrawable[i] = a(drawable2, flag);
                    i++;
                }
                LayerDrawable layerdrawable = new LayerDrawable(adrawable);
                for (int k = ((flag1) ? 1 : 0); k < l; k++)
                {
                    layerdrawable.setId(k, drawable.getId(k));
                }

                return layerdrawable;
            }
            if (drawable instanceof BitmapDrawable)
            {
                Object obj = ((BitmapDrawable)drawable).getBitmap();
                if (b == null)
                {
                    b = ((Bitmap) (obj));
                }
                drawable = new ShapeDrawable(getDrawableShape());
                obj = new BitmapShader(((Bitmap) (obj)), android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.CLAMP);
                drawable.getPaint().setShader(((android.graphics.Shader) (obj)));
                if (flag)
                {
                    return new ClipDrawable(drawable, 3, 1);
                } else
                {
                    return drawable;
                }
            }
        }
        return drawable;
    }

    private Shape getDrawableShape()
    {
        return new RoundRectShape(new float[] {
            5F, 5F, 5F, 5F, 5F, 5F, 5F, 5F
        }, null, null);
    }

    protected final void onMeasure(int i, int k)
    {
        this;
        JVM INSTR monitorenter ;
        super.onMeasure(i, k);
        if (b != null)
        {
            setMeasuredDimension(w.a(b.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
