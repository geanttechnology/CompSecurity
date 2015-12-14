// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.internal.widget.TintImageView;
import android.support.v7.widget.ActionMenuPresenter;

public class el extends TintImageView
    implements er
{

    final ActionMenuPresenter a;
    private final float b[] = new float[2];

    public el(ActionMenuPresenter actionmenupresenter, Context context)
    {
        a = actionmenupresenter;
        super(context, null, r.actionOverflowButtonStyle);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new em(this, this, actionmenupresenter));
    }

    public boolean needsDividerAfter()
    {
        return false;
    }

    public boolean needsDividerBefore()
    {
        return false;
    }

    public boolean performClick()
    {
        if (super.performClick())
        {
            return true;
        } else
        {
            playSoundEffect(0);
            a.c();
            return true;
        }
    }

    protected boolean setFrame(int i, int j, int k, int l)
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
            DrawableCompat.setHotspotBounds(drawable1, i, 0, getWidth() + i, getHeight());
        }
        return flag;
    }
}
