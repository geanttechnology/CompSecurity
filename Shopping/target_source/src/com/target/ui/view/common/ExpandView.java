// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.ui.util.aj;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view.common:
//            i

public class ExpandView extends LinearLayout
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a(boolean flag);
    }

    private class b
    {

        final ViewGroup childContainer;
        final ImageView dropDownBtn;
        final ViewGroup headerLayout;
        boolean isAnimating;
        boolean isExpanded;
        final ExpandView this$0;
        final TextView title;

        public void a(boolean flag)
        {
            isAnimating = flag;
        }

        public boolean a()
        {
            return isAnimating;
        }

        public void b(boolean flag)
        {
            isExpanded = flag;
        }

        public boolean b()
        {
            return isExpanded;
        }

        public b(View view)
        {
            this$0 = ExpandView.this;
            super();
            isAnimating = false;
            isExpanded = false;
            title = (TextView)view.findViewById(0x7f10043e);
            dropDownBtn = (ImageView)view.findViewById(0x7f10043f);
            headerLayout = (ViewGroup)view.findViewById(0x7f10043d);
            childContainer = (ViewGroup)view.findViewById(0x7f100440);
        }
    }


    private static final float ARROW_ROTATION_COLLAPSED = 0F;
    private static final float ARROW_ROTATION_EXPANDED = 180F;
    private static final int DEFAULT_CHILD_POS = 0;
    public static final String TAG = com/target/ui/view/common/ExpandView.getSimpleName();
    private a mListener;
    private b mViews;

    public ExpandView(Context context)
    {
        super(context);
        b();
    }

    public ExpandView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public ExpandView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        b();
    }

    static b a(ExpandView expandview)
    {
        return expandview.mViews;
    }

    private void a(View view)
    {
        if (view == null)
        {
            return;
        } else
        {
            mViews.childContainer.removeAllViews();
            mViews.childContainer.addView(view, 0);
            al.c(mViews.childContainer);
            return;
        }
    }

    static a b(ExpandView expandview)
    {
        return expandview.mListener;
    }

    private void b()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f03015c, this);
        mViews = new b(this);
        mViews.headerLayout.setOnClickListener(this);
    }

    private void c()
    {
        if (mViews == null || mViews.a())
        {
            return;
        } else
        {
            AnimatorSet animatorset = aj.a(mViews.childContainer, mViews.dropDownBtn, mViews.b());
            animatorset.addListener(new AnimatorListenerAdapter() {

                final ExpandView this$0;

                public void onAnimationEnd(Animator animator)
                {
                    boolean flag1 = true;
                    super.onAnimationEnd(animator);
                    animator = ExpandView.a(ExpandView.this);
                    boolean flag;
                    if (!ExpandView.a(ExpandView.this).a())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    animator.a(flag);
                    animator = ExpandView.a(ExpandView.this);
                    if (!ExpandView.a(ExpandView.this).b())
                    {
                        flag = flag1;
                    } else
                    {
                        flag = false;
                    }
                    animator.b(flag);
                    if (ExpandView.b(ExpandView.this) != null)
                    {
                        ExpandView.b(ExpandView.this).a(ExpandView.a(ExpandView.this).b());
                    }
                }

                public void onAnimationStart(Animator animator)
                {
                    super.onAnimationStart(animator);
                    animator = ExpandView.a(ExpandView.this);
                    boolean flag;
                    if (!ExpandView.a(ExpandView.this).a())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    animator.a(flag);
                }

            
            {
                this$0 = ExpandView.this;
                super();
            }
            });
            animatorset.start();
            return;
        }
    }

    public boolean a()
    {
        if (mViews == null)
        {
            return false;
        } else
        {
            return mViews.b();
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131756093: 
            c();
            break;
        }
    }

    protected void setChildView(i j)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            a(j.getView());
            return;
        }
    }

    public void setExpandClickListener(a a1)
    {
        mListener = a1;
    }

    protected void setExpanded(boolean flag)
    {
        while (mViews == null || flag == mViews.b()) 
        {
            return;
        }
        if (flag)
        {
            al.b(mViews.childContainer);
            mViews.dropDownBtn.setRotation(180F);
        } else
        {
            al.c(mViews.childContainer);
            mViews.dropDownBtn.setRotation(0.0F);
        }
        mViews.b(flag);
    }

    protected void setTitle(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.title.setText(s);
            return;
        }
    }

    protected void setTitleColor(int j)
    {
        if (mViews == null || mViews.title == null)
        {
            return;
        } else
        {
            mViews.title.setTextColor(j);
            return;
        }
    }

}
