// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.ui.util.aj;

// Referenced classes of package com.target.ui.view.common:
//            a

public class CheckableFormItemCompat extends FrameLayout
    implements com.target.ui.view.common.a
{
    private class a
    {

        ImageView checkMark;
        TextView text;
        final CheckableFormItemCompat this$0;

        a(View view)
        {
            this$0 = CheckableFormItemCompat.this;
            super();
            checkMark = (ImageView)view.findViewById(0x7f10035a);
            text = (TextView)view.findViewById(0x7f10035b);
        }
    }


    private static final float ALPHA_BLEND = 0.5F;
    private static final int ANIM_DURATION_MS = 100;
    private static final float SCALE_FACTOR = 0.5F;
    private boolean mChecked;
    private Drawable mCheckedImage;
    private android.view.View.OnClickListener mClickListener = new android.view.View.OnClickListener() {

        final CheckableFormItemCompat this$0;

        public void onClick(View view)
        {
            toggle();
        }

            
            {
                this$0 = CheckableFormItemCompat.this;
                super();
            }
    };
    private Drawable mNotCheckedImage;
    private a mViews;

    public CheckableFormItemCompat(Context context)
    {
        super(context);
        mChecked = true;
        a(context);
    }

    public CheckableFormItemCompat(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mChecked = true;
        a(context);
    }

    public CheckableFormItemCompat(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mChecked = true;
        a(context);
    }

    private Animator a(View view)
    {
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            a(view, true), b(view, true)
        });
        return animatorset;
    }

    private Animator a(View view, boolean flag)
    {
        float f1 = 1.0F;
        float f;
        if (flag)
        {
            f = 0.5F;
        } else
        {
            f = 1.0F;
        }
        if (!flag)
        {
            f1 = 0.5F;
        }
        return aj.a(view, f, f1, 100);
    }

    static a a(CheckableFormItemCompat checkableformitemcompat)
    {
        return checkableformitemcompat.mViews;
    }

    private void a()
    {
        mChecked = false;
        c();
    }

    private void a(Context context)
    {
        inflate(context, 0x7f030121, this);
        mViews = new a(this);
        setClickable(true);
        setOnClickListener(mClickListener);
        mNotCheckedImage = getResources().getDrawable(0x7f02005e);
        mCheckedImage = getResources().getDrawable(0x7f02005f);
    }

    private Animator b(View view)
    {
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            a(view, false), b(view, false)
        });
        return animatorset;
    }

    private Animator b(View view, boolean flag)
    {
        float f1 = 1.0F;
        float f;
        if (flag)
        {
            f = 0.5F;
        } else
        {
            f = 1.0F;
        }
        if (!flag)
        {
            f1 = 0.5F;
        }
        return aj.c(view, f, f1, 100);
    }

    private void b()
    {
        mChecked = true;
        d();
    }

    private void c()
    {
        getCheckAnimation().start();
    }

    private void d()
    {
        getCheckAnimation().start();
    }

    private Animator getCheckAnimation()
    {
        final Object flipTo;
        Animator animator;
        Animator animator1;
        if (mChecked)
        {
            flipTo = mCheckedImage;
        } else
        {
            flipTo = mNotCheckedImage;
        }
        animator = b(mViews.checkMark);
        animator1 = a(mViews.checkMark);
        animator1.addListener(new AnimatorListenerAdapter() {

            final CheckableFormItemCompat this$0;
            final Drawable val$flipTo;

            public void onAnimationStart(Animator animator2)
            {
                if (CheckableFormItemCompat.a(CheckableFormItemCompat.this) != null)
                {
                    CheckableFormItemCompat.a(CheckableFormItemCompat.this).checkMark.setImageDrawable(flipTo);
                }
            }

            
            {
                this$0 = CheckableFormItemCompat.this;
                flipTo = drawable;
                super();
            }
        });
        flipTo = new AnimatorSet();
        ((AnimatorSet) (flipTo)).play(animator).before(animator1);
        return ((Animator) (flipTo));
    }

    public View getView()
    {
        return this;
    }

    public boolean isChecked()
    {
        return mChecked;
    }

    public void setChecked(boolean flag)
    {
        if (flag != mChecked)
        {
            toggle();
        }
    }

    public void setText(String s)
    {
        mViews.text.setText(s);
    }

    public void toggle()
    {
        if (mChecked)
        {
            a();
            return;
        } else
        {
            b();
            return;
        }
    }
}
