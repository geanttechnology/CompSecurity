// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package at.technikum.mti.fancycoverflow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Adapter;
import android.widget.Gallery;
import android.widget.SpinnerAdapter;

// Referenced classes of package at.technikum.mti.fancycoverflow:
//            a

public class FancyCoverFlow extends Gallery
{

    private float a;
    private float b;
    private float c;
    private int d;

    public FancyCoverFlow(Context context)
    {
        super(context);
        c = 0.5F;
        setSpacing(0);
    }

    public FancyCoverFlow(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = 0.5F;
        setSpacing(0);
        a(attributeset);
    }

    public FancyCoverFlow(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c = 0.5F;
        setSpacing(0);
        a(attributeset);
    }

    private void a(AttributeSet attributeset)
    {
        attributeset = getContext().obtainStyledAttributes(attributeset, com.shazam.android.b.a.FancyCoverFlow);
        d = attributeset.getInteger(5, 0x7fffffff);
        c = attributeset.getFloat(4, 1.0F);
        a = attributeset.getFloat(0, 0.3F);
        b = attributeset.getFloat(2, 0.75F);
        attributeset.recycle();
    }

    protected boolean getChildStaticTransformation(View view, Transformation transformation)
    {
        int i = getWidth();
        int j = i / 2;
        int k = view.getWidth();
        int l = view.getHeight();
        int i1 = view.getLeft();
        int j1 = k / 2;
        float f;
        if (d == 0x7fffffff)
        {
            i = (int)((float)(i + k) / 2.0F);
        } else
        {
            i = d;
        }
        f = Math.min(1.0F, Math.max(-1F, (1.0F / (float)i) * (float)((i1 + j1) - j)));
        transformation.clear();
        transformation.setTransformationType(3);
        if (a != 1.0F)
        {
            transformation.setAlpha((a - 1.0F) * Math.abs(f) + 1.0F);
        }
        view = transformation.getMatrix();
        if (b != 1.0F)
        {
            float f1 = b;
            f = Math.abs(f) * (f1 - 1.0F) + 1.0F;
            f1 = (float)k / 2.0F;
            float f2 = (float)l * c;
            view.preTranslate(-f1, -f2);
            view.postScale(f, f);
            view.postTranslate(f1, f2);
        }
        return true;
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((SpinnerAdapter)adapter);
    }

    public void setAdapter(SpinnerAdapter spinneradapter)
    {
        if (!(spinneradapter instanceof a))
        {
            throw new ClassCastException((new StringBuilder()).append(at/technikum/mti/fancycoverflow/FancyCoverFlow.getSimpleName()).append(" only works in conjunction with a ").append(at/technikum/mti/fancycoverflow/a.getSimpleName()).toString());
        } else
        {
            super.setAdapter(spinneradapter);
            return;
        }
    }

    public void setSelection(int i)
    {
        super.setSelection(i);
        for (i = 0; i < getChildCount(); i++)
        {
            View view = getChildAt(i);
            if (view != null)
            {
                view.offsetLeftAndRight(0);
            }
        }

    }

    public void setUnselectedAlpha(float f)
    {
        super.setUnselectedAlpha(f);
        a = f;
    }
}
