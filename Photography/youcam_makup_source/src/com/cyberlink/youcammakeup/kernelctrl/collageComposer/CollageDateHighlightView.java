// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            a

public class CollageDateHighlightView extends View
{

    private List a;
    private AnimatorSet b;
    private NinePatchDrawable c;
    private boolean d;
    private boolean e;

    public CollageDateHighlightView(Context context)
    {
        super(context);
        a = null;
        b = new AnimatorSet();
        c = null;
        d = true;
        e = false;
        b();
    }

    public CollageDateHighlightView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = null;
        b = new AnimatorSet();
        c = null;
        d = true;
        e = false;
        b();
    }

    static boolean a(CollageDateHighlightView collagedatehighlightview, boolean flag)
    {
        collagedatehighlightview.d = flag;
        return flag;
    }

    private void b()
    {
        android.graphics.drawable.Drawable drawable;
        if (isInEditMode())
        {
            return;
        }
        a = new ArrayList();
        drawable = null;
        android.graphics.drawable.Drawable drawable1 = getResources().getDrawable(0x7f0208af);
        drawable = drawable1;
_L2:
        if (drawable instanceof NinePatchDrawable)
        {
            c = (NinePatchDrawable)drawable;
        }
        c();
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void c()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = ObjectAnimator.ofFloat(this, "alpha", new float[] {
            0.0F, 1.0F
        });
        ((ValueAnimator) (obj)).setDuration(500L);
        ((ValueAnimator) (obj)).setInterpolator(new LinearInterpolator());
        arraylist.add(obj);
        obj = ValueAnimator.ofInt(new int[] {
            0
        });
        ((ValueAnimator) (obj)).setDuration(750L);
        ((ValueAnimator) (obj)).setInterpolator(new LinearInterpolator());
        arraylist.add(obj);
        obj = ObjectAnimator.ofFloat(this, "alpha", new float[] {
            1.0F, 0.0F
        });
        ((ValueAnimator) (obj)).setDuration(250L);
        ((ValueAnimator) (obj)).setInterpolator(new LinearInterpolator());
        arraylist.add(obj);
        b.playSequentially(arraylist);
        b.addListener(new a() {

            final CollageDateHighlightView a;

            public void onAnimationEnd(Animator animator)
            {
                CollageDateHighlightView.a(a, true);
                a.invalidate();
            }

            
            {
                a = CollageDateHighlightView.this;
                super(CollageDateHighlightView.this);
            }
        });
    }

    public void a()
    {
        if (e)
        {
            return;
        } else
        {
            e = true;
            b.cancel();
            d = false;
            invalidate();
            b.start();
            return;
        }
    }

    protected void a(Rect rect)
    {
        a.add(rect);
    }

    protected void onDraw(Canvas canvas)
    {
        if (!d && c != null)
        {
            Iterator iterator = a.iterator();
            while (iterator.hasNext()) 
            {
                Rect rect = (Rect)iterator.next();
                int i = rect.left;
                int j = rect.top;
                int k = rect.right;
                int l = rect.bottom;
                c.setBounds(i - 3, j - 3, k + 3, l + 3);
                c.draw(canvas);
            }
        }
    }
}
