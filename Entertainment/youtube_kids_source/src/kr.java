// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.TintImageView;

final class kr extends TintImageView
    implements ku
{

    final kn a;
    private final float b[] = new float[2];

    public kr(kn kn1, Context context)
    {
        a = kn1;
        super(context, null, 0x7f01008c);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new ks(this, this, kn1));
    }

    public final boolean c()
    {
        return false;
    }

    public final boolean d()
    {
        return false;
    }

    public final boolean performClick()
    {
        if (super.performClick())
        {
            return true;
        } else
        {
            playSoundEffect(0);
            a.b();
            return true;
        }
    }

    protected final boolean setFrame(int i, int j, int k, int l)
    {
        boolean flag = super.setFrame(i, j, k, l);
        Drawable drawable = getDrawable();
        Drawable drawable1 = getBackground();
        if (drawable != null && drawable1 != null)
        {
            float af[] = b;
            af[0] = drawable.getBounds().centerX();
            getImageMatrix().mapPoints(af);
            i = (int)af[0] - getWidth() / 2;
            ca.a(drawable1, i, 0, getWidth() + i, getHeight());
        }
        return flag;
    }
}
