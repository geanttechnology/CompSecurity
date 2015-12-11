// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.support.v4.b.a.a;
import android.support.v7.internal.view.menu.k;
import android.support.v7.internal.widget.TintImageView;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            a, s

private final class a extends TintImageView
    implements onMenuView.a
{

    final android.support.v7.widget.a a;
    private final float b[] = new float[2];

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
            a.d();
            return true;
        }
    }

    protected final boolean setFrame(int i, int j, int k, int l)
    {
        boolean flag = super.setFrame(i, j, k, l);
        android.graphics.drawable.Drawable drawable = getDrawable();
        android.graphics.drawable.Drawable drawable1 = getBackground();
        if (drawable != null && drawable1 != null)
        {
            int i1 = getWidth();
            j = getHeight();
            i = Math.max(i1, j) / 2;
            int j1 = getPaddingLeft();
            int k1 = getPaddingRight();
            k = getPaddingTop();
            l = getPaddingBottom();
            i1 = (i1 + (j1 - k1)) / 2;
            j = (j + (k - l)) / 2;
            android.support.v4.b.a.a.a(drawable1, i1 - i, j - i, i1 + i, j + i);
        }
        return flag;
    }

    public ner(android.support.v7.widget.a a1, Context context)
    {
        a = a1;
        super(context, null, android.support.v7.b.actionOverflowButtonStyle);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new s.b(this, a1) {

            final android.support.v7.widget.a a;
            final a.d b;

            public final s a()
            {
                if (b.a.m == null)
                {
                    return null;
                } else
                {
                    return ((k) (b.a.m)).c;
                }
            }

            public final boolean b()
            {
                b.a.d();
                return true;
            }

            public final boolean c()
            {
                if (b.a.o != null)
                {
                    return false;
                } else
                {
                    b.a.e();
                    return true;
                }
            }

            
            {
                b = a.d.this;
                a = a1;
                super(view);
            }
        });
    }
}
