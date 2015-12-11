// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.util.b;
import com.target.mothership.util.o;
import com.target.ui.adapter.list.a;
import com.target.ui.e.g;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.DealsBadgeView;
import com.target.ui.view.QuantitySpinnerView;
import com.target.ui.view.TargetImeEditText;
import java.util.ArrayList;

// Referenced classes of package com.target.ui.view.list:
//            BaseListItemView

public class ListItemView extends BaseListItemView
    implements android.view.View.OnLongClickListener, com.target.ui.adapter.list.a
{
    public static interface a
    {

        public abstract void a(com.target.ui.adapter.list.a a1);

        public abstract void a(ListDetailItem listdetailitem, View view);

        public abstract void a(boolean flag, ListItemView listitemview);

        public abstract void b(boolean flag);

        public abstract void d(ListDetailItem listdetailitem);

        public abstract void e(ListDetailItem listdetailitem);

        public abstract void f(ListDetailItem listdetailitem);

        public abstract void g(ListDetailItem listdetailitem);

        public abstract void h(ListDetailItem listdetailitem);

        public abstract void i(ListDetailItem listdetailitem);

        public abstract boolean l();
    }


    private static final int KEYBOARD_OPEN_DELAY = 300;
    private static final float MAX_VIEW_ALPHA_FLOAT = 1F;
    private int LEFT_SHIFT;
    private int RIGHT_SHIFT;
    private AnimatorSet mAnimatorSet;
    private a mListener;
    private g mTouchListener;
    private com.e.a.a.b mViewHolder;

    public ListItemView(Context context)
    {
        super(context);
        a(context);
    }

    public ListItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public ListItemView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a(context);
    }

    static AnimatorSet a(ListItemView listitemview, AnimatorSet animatorset)
    {
        listitemview.mAnimatorSet = animatorset;
        return animatorset;
    }

    static a a(ListItemView listitemview)
    {
        return listitemview.mListener;
    }

    private void a(Context context)
    {
        LEFT_SHIFT = context.getResources().getDimensionPixelOffset(0x7f0a01e1);
        RIGHT_SHIFT = context.getResources().getDimensionPixelOffset(0x7f0a01de);
    }

    static void a(ListItemView listitemview, ListDetailItem listdetailitem)
    {
        listitemview.setupContentDescription(listdetailitem);
    }

    static void a(ListItemView listitemview, String s)
    {
        listitemview.a(s);
    }

    static void a(ListItemView listitemview, boolean flag)
    {
        listitemview.setEditMode(flag);
    }

    private void a(String s)
    {
        s = String.format(getContext().getString(0x7f0903a2), new Object[] {
            mItem.b()
        });
        com.target.ui.util.a.a(getContext(), this, s);
    }

    static void b(ListItemView listitemview)
    {
        listitemview.i();
    }

    static com.e.a.a.b c(ListItemView listitemview)
    {
        return listitemview.mViewHolder;
    }

    static boolean d(ListItemView listitemview)
    {
        return listitemview.l();
    }

    private void e()
    {
        if (com.target.ui.util.a.a(getContext()))
        {
            mViews.gripper.setVisibility(4);
            return;
        } else
        {
            mViews.gripper.setOnTouchListener(new android.view.View.OnTouchListener() {

                final ListItemView this$0;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    if (motionevent.getAction() == 0)
                    {
                        ListItemView.c(ListItemView.this).w();
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            
            {
                this$0 = ListItemView.this;
                super();
            }
            });
            return;
        }
    }

    static boolean e(ListItemView listitemview)
    {
        return listitemview.getRecyclerEditMode();
    }

    static g f(ListItemView listitemview)
    {
        return listitemview.mTouchListener;
    }

    private void f()
    {
        mViews.editTitleText.setImeListener(new com.target.ui.view.TargetImeEditText.a() {

            final ListItemView this$0;

            public boolean a(int i1, KeyEvent keyevent)
            {
                if (ListItemView.d(ListItemView.this) && keyevent.getAction() == 0 && i1 == 4)
                {
                    com.target.ui.view.list.ListItemView.b(ListItemView.this);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = ListItemView.this;
                super();
            }
        });
        mViews.editTitleText.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final ListItemView this$0;

            public boolean onEditorAction(TextView textview, int i1, KeyEvent keyevent)
            {
                boolean flag = true;
                if (i1 != 6 && keyevent != null && keyevent.getAction() != 0)
                {
                    flag = false;
                } else
                {
                    com.target.ui.util.e.a.a(ListItemView.this);
                    com.target.ui.view.list.ListItemView.b(ListItemView.this);
                    ListItemView.this.a(true);
                    textview = mViews.editTitleText.getText().toString();
                    if (!o.e(textview))
                    {
                        mItem.a(textview);
                    }
                    if (com.target.ui.view.list.ListItemView.a(ListItemView.this) != null)
                    {
                        com.target.ui.view.list.ListItemView.a(ListItemView.this).g(mItem);
                        return true;
                    }
                }
                return flag;
            }

            
            {
                this$0 = ListItemView.this;
                super();
            }
        });
    }

    private void g()
    {
        mViews.aisleLocationView.setOnClickListener(new android.view.View.OnClickListener() {

            final ListItemView this$0;

            public void onClick(View view)
            {
                if (!com.target.mothership.util.b.a().b())
                {
                    ai.a(getContext(), 0x7f0903df);
                } else
                if (com.target.ui.view.list.ListItemView.a(ListItemView.this) != null && !ListItemView.e(ListItemView.this))
                {
                    com.target.ui.view.list.ListItemView.a(ListItemView.this).a(mItem, mViews.layout);
                    return;
                }
            }

            
            {
                this$0 = ListItemView.this;
                super();
            }
        });
        mViews.dealsBadge.setOnClickListener(new android.view.View.OnClickListener() {

            final ListItemView this$0;

            public void onClick(View view)
            {
                if (!com.target.mothership.util.b.a().b())
                {
                    ai.a(getContext(), 0x7f0903df);
                } else
                if (com.target.ui.view.list.ListItemView.a(ListItemView.this) != null)
                {
                    com.target.ui.view.list.ListItemView.a(ListItemView.this).i(mItem);
                    return;
                }
            }

            
            {
                this$0 = ListItemView.this;
                super();
            }
        });
    }

    static void g(ListItemView listitemview)
    {
        listitemview.k();
    }

    private boolean getRecyclerEditMode()
    {
        if (mListener != null)
        {
            return mListener.l();
        } else
        {
            return false;
        }
    }

    private void h()
    {
        mViews.layout.setOnClickListener(new android.view.View.OnClickListener() {

            final ListItemView this$0;

            public void onClick(View view)
            {
                if (ListItemView.f(ListItemView.this).a() || ListItemView.e(ListItemView.this) || mItem.k())
                {
                    return;
                } else
                {
                    d();
                    return;
                }
            }

            
            {
                this$0 = ListItemView.this;
                super();
            }
        });
        mViews.layout.setOnLongClickListener(this);
        mTouchListener = new g(mViews.layout, null, new com.target.ui.e.g.a() {

            final ListItemView this$0;

            public void a()
            {
                com.target.ui.view.list.ListItemView.a(ListItemView.this, mViews.titleTextView.getText().toString());
            }

            public void a(View view, Object obj)
            {
                com.target.ui.view.list.ListItemView.a(ListItemView.this).h(mItem);
            }

            public boolean a(Object obj)
            {
                return !ListItemView.e(ListItemView.this);
            }

            
            {
                this$0 = ListItemView.this;
                super();
            }
        });
        mViews.layout.setOnTouchListener(mTouchListener);
        setupContentDescription(mItem);
    }

    private void i()
    {
        if (mListener != null)
        {
            mListener.a(false, this);
        }
        setEditMode(false);
        a(true);
        com.target.ui.util.e.a.a(this);
    }

    private int j()
    {
        if (mItem.e().getDesiredQuantity() == 1)
        {
            return 0;
        } else
        {
            return (int)getContext().getResources().getDimension(0x7f0a01db);
        }
    }

    private void k()
    {
        al.b(new View[] {
            mViews.selectedCheckBox, mViews.titleTextView, mViews.gripper
        });
        al.a(new View[] {
            mViews.quantitySpinner, mViews.editTitleText
        });
        mViews.selectedCheckBox.setTranslationX(0.0F);
        mViews.titleTextView.setTranslationX(0.0F);
        mViews.dealsBadge.setTranslationX(0.0F);
        mViews.aisleLocationView.setTranslationX(0.0F);
        mViews.gripper.setTranslationX(0.0F);
        al.a(1.0F, new View[] {
            mViews.selectedCheckBox, mViews.titleTextView, mViews.dealsBadge, mViews.aisleLocationView, mViews.gripper
        });
        m();
    }

    private boolean l()
    {
        return mItem.i();
    }

    private void m()
    {
        AisleBadgeView aislebadgeview = mViews.aisleLocationView;
        boolean flag;
        if (!mViews.aisleLocationView.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        al.a(aislebadgeview, flag);
    }

    private void setEditMode(boolean flag)
    {
        mItem.b(flag);
        if (mListener != null)
        {
            mListener.b(flag);
        }
    }

    private void setupContentDescription(ListDetailItem listdetailitem)
    {
        listdetailitem = String.format(getContext().getString(0x7f090399), new Object[] {
            listdetailitem.b(), Integer.valueOf(listdetailitem.h())
        });
        mViews.layout.setContentDescription(listdetailitem);
    }

    private void setupDealsView(boolean flag)
    {
        if (flag || !mItem.j())
        {
            mViews.dealsBadge.setVisibility(8);
            return;
        } else
        {
            mViews.dealsBadge.setVisibility(0);
            return;
        }
    }

    private void setupQuantitySpinner(boolean flag)
    {
        if (flag)
        {
            mViews.quantitySpinner.setVisibility(0);
            mViews.editTitleText.setVisibility(0);
        } else
        {
            mViews.quantitySpinner.setVisibility(8);
            mViews.editTitleText.setVisibility(8);
        }
        mViews.quantitySpinner.setFocusable(true);
        mViews.quantitySpinner.setFocusableInTouchMode(true);
        mViews.quantitySpinner.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final ListItemView this$0;

            public void onFocusChange(View view, boolean flag1)
            {
                if (flag1)
                {
                    com.target.ui.util.e.a.a(ListItemView.this);
                    (new Handler()).postDelayed(new Runnable() {

                        final _cls5 this$1;

                        public void run()
                        {
                            mViews.quantitySpinner.performClick();
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    }, 600L);
                }
            }

            
            {
                this$0 = ListItemView.this;
                super();
            }
        });
    }

    public void a()
    {
        mViews.blockerView.setVisibility(8);
    }

    public void a(ListDetailItem listdetailitem, a a1, com.e.a.a.b b1)
    {
        super.a(listdetailitem);
        mViewHolder = b1;
        mListener = a1;
        if (mListener != null)
        {
            mListener.a(this);
        }
        setupQuantitySpinner(l());
        setupSelectedCheckboxView(l());
        setupAisleLocationView(l());
        setupDealsView(l());
        f();
        h();
        g();
        e();
    }

    public void a(boolean flag)
    {
        if (mAnimatorSet != null)
        {
            mAnimatorSet.cancel();
        }
        setEditMode(false);
        b();
        mViews.layout.setBackgroundColor(getResources().getColor(0x7f0f00ef));
        m();
        AnimatorSet animatorset = new AnimatorSet();
        ArrayList arraylist = new ArrayList();
        if (flag)
        {
            arraylist.add(ObjectAnimator.ofFloat(mViews.titleTextView, View.ALPHA, new float[] {
                0.0F, 1.0F
            }).setDuration(0L));
            arraylist.add(ObjectAnimator.ofFloat(mViews.quantitySpinner, View.TRANSLATION_X, new float[] {
                0.0F, (float)(-LEFT_SHIFT)
            }));
        }
        arraylist.add(ObjectAnimator.ofFloat(mViews.editTitleText, View.ALPHA, new float[] {
            1.0F, 0.0F
        }));
        animatorset.playTogether(arraylist);
        animatorset = new AnimatorSet();
        arraylist = new ArrayList();
        arraylist.add(ObjectAnimator.ofFloat(mViews.selectedCheckBox, View.TRANSLATION_X, new float[] {
            (float)(-LEFT_SHIFT), 0.0F
        }));
        arraylist.add(ObjectAnimator.ofFloat(mViews.dealsBadge, View.TRANSLATION_X, new float[] {
            (float)RIGHT_SHIFT, 0.0F
        }));
        arraylist.add(ObjectAnimator.ofFloat(mViews.aisleLocationView, View.TRANSLATION_X, new float[] {
            (float)RIGHT_SHIFT, 0.0F
        }));
        arraylist.add(ObjectAnimator.ofFloat(mViews.gripper, View.TRANSLATION_X, new float[] {
            (float)(-LEFT_SHIFT), 0.0F
        }));
        arraylist.add(ObjectAnimator.ofFloat(mViews.selectedCheckBox, View.ALPHA, new float[] {
            0.0F, 1.0F
        }));
        arraylist.add(ObjectAnimator.ofFloat(mViews.dealsBadge, View.ALPHA, new float[] {
            0.0F, 1.0F
        }));
        arraylist.add(ObjectAnimator.ofFloat(mViews.aisleLocationView, View.ALPHA, new float[] {
            0.0F, 1.0F
        }));
        arraylist.add(ObjectAnimator.ofFloat(mViews.gripper, View.ALPHA, new float[] {
            0.0F, 1.0F
        }));
        if (flag)
        {
            arraylist.add(ObjectAnimator.ofFloat(mViews.titleTextView, View.TRANSLATION_X, new float[] {
                (float)(-j()), 0.0F
            }));
        }
        animatorset.playTogether(arraylist);
        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.playTogether(new Animator[] {
            animatorset
        });
        mAnimatorSet.setDuration(100L);
        mAnimatorSet.start();
        mAnimatorSet.addListener(new AnimatorListenerAdapter() {

            final ListItemView this$0;

            public void onAnimationEnd(Animator animator)
            {
                com.target.ui.view.list.ListItemView.g(ListItemView.this);
                com.target.ui.view.list.ListItemView.a(ListItemView.this, null);
            }

            
            {
                this$0 = ListItemView.this;
                super();
            }
        });
    }

    public void b(final boolean editModeCell)
    {
        if (mAnimatorSet != null)
        {
            mAnimatorSet.cancel();
        }
        if (editModeCell)
        {
            mViews.layout.setBackgroundColor(getResources().getColor(0x7f0f00e4));
        }
        mViews.quantitySpinner.setTranslationX(-LEFT_SHIFT);
        mViews.editTitleText.setAlpha(0.0F);
        al.b(new View[] {
            mViews.quantitySpinner, mViews.editTitleText
        });
        AnimatorSet animatorset = new AnimatorSet();
        Object obj = new ArrayList();
        ((ArrayList) (obj)).add(ObjectAnimator.ofFloat(mViews.selectedCheckBox, View.TRANSLATION_X, new float[] {
            0.0F, (float)(-LEFT_SHIFT)
        }));
        ((ArrayList) (obj)).add(ObjectAnimator.ofFloat(mViews.dealsBadge, View.TRANSLATION_X, new float[] {
            0.0F, (float)RIGHT_SHIFT
        }));
        ((ArrayList) (obj)).add(ObjectAnimator.ofFloat(mViews.aisleLocationView, View.TRANSLATION_X, new float[] {
            0.0F, (float)RIGHT_SHIFT
        }));
        ((ArrayList) (obj)).add(ObjectAnimator.ofFloat(mViews.gripper, View.TRANSLATION_X, new float[] {
            0.0F, (float)(-LEFT_SHIFT)
        }));
        ((ArrayList) (obj)).add(ObjectAnimator.ofFloat(mViews.selectedCheckBox, View.ALPHA, new float[] {
            1.0F, 0.0F
        }));
        ((ArrayList) (obj)).add(ObjectAnimator.ofFloat(mViews.dealsBadge, View.ALPHA, new float[] {
            1.0F, 0.0F
        }));
        ((ArrayList) (obj)).add(ObjectAnimator.ofFloat(mViews.aisleLocationView, View.ALPHA, new float[] {
            1.0F, 0.0F
        }));
        ((ArrayList) (obj)).add(ObjectAnimator.ofFloat(mViews.gripper, View.ALPHA, new float[] {
            1.0F, 0.0F
        }));
        if (editModeCell)
        {
            ((ArrayList) (obj)).add(ObjectAnimator.ofFloat(mViews.titleTextView, View.TRANSLATION_X, new float[] {
                0.0F, (float)(-j())
            }));
        }
        animatorset.playTogether(((java.util.Collection) (obj)));
        obj = new AnimatorSet();
        ArrayList arraylist = new ArrayList();
        if (editModeCell)
        {
            arraylist.add(ObjectAnimator.ofFloat(mViews.titleTextView, View.ALPHA, new float[] {
                1.0F, 0.0F
            }));
            arraylist.add(ObjectAnimator.ofFloat(mViews.quantitySpinner, View.TRANSLATION_X, new float[] {
                (float)(-LEFT_SHIFT), 0.0F
            }));
            arraylist.add(ObjectAnimator.ofFloat(mViews.editTitleText, View.ALPHA, new float[] {
                0.0F, 1.0F
            }));
        }
        ((AnimatorSet) (obj)).playTogether(arraylist);
        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.playSequentially(new Animator[] {
            animatorset, obj
        });
        mAnimatorSet.setDuration(100L);
        mAnimatorSet.start();
        mAnimatorSet.addListener(new AnimatorListenerAdapter() {

            final ListItemView this$0;
            final boolean val$editModeCell;

            public void onAnimationEnd(Animator animator)
            {
                mViews.editTitleText.requestFocus();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls4 this$1;

                    public void run()
                    {
                        com.target.ui.util.e.a.c(mViews.editTitleText);
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                }, 300L);
                if (editModeCell)
                {
                    setDisabled(false);
                }
                if (editModeCell)
                {
                    com.target.ui.view.list.ListItemView.a(ListItemView.this, true);
                }
                com.target.ui.view.list.ListItemView.a(ListItemView.this, null);
            }

            
            {
                this$0 = ListItemView.this;
                editModeCell = flag;
                super();
            }
        });
    }

    protected void c()
    {
        mViews.blockerView.setVisibility(0);
        Object obj = mViews.titleTextView;
        mViews.titleTextView.setPaintFlags(((TextView) (obj)).getPaintFlags() | 0x10);
        mViews.selectedCheckBox.setChecked(true);
        obj = ObjectAnimator.ofFloat(mViews.layout, View.ALPHA, new float[] {
            1.0F, 0.0F
        });
        ((ObjectAnimator) (obj)).setStartDelay(300L);
        ((ObjectAnimator) (obj)).setDuration(600L);
        ((ObjectAnimator) (obj)).start();
        ((ObjectAnimator) (obj)).addListener(new android.animation.Animator.AnimatorListener() {

            final ListItemView this$0;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                if (com.target.ui.view.list.ListItemView.a(ListItemView.this) != null && !ListItemView.f(ListItemView.this).a() && !ListItemView.e(ListItemView.this))
                {
                    com.target.ui.view.list.ListItemView.a(ListItemView.this).d(mItem);
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = ListItemView.this;
                super();
            }
        });
    }

    public void c(boolean flag)
    {
        RelativeLayout relativelayout = mViews.layout;
        float f1;
        if (flag)
        {
            f1 = 0.0F;
        } else
        {
            f1 = 1.0F;
        }
        relativelayout.setAlpha(f1);
    }

    protected void d()
    {
        if (mListener != null)
        {
            mListener.e(mItem);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return mItem.k() && !mItem.i();
    }

    public boolean onLongClick(View view)
    {
        if (mTouchListener.a() || getRecyclerEditMode() || mItem.k())
        {
            return false;
        }
        mItem.d(true);
        b(true);
        if (mListener != null)
        {
            mListener.a(true, this);
        }
        mViews.editTitleText.setText(mItem.b());
        mViews.quantitySpinner.setValue(mItem.h());
        mViews.quantitySpinner.setQuantityChangedListener(new com.target.ui.view.QuantitySpinnerView.a() {

            final ListItemView this$0;

            public void a()
            {
                com.target.ui.view.list.ListItemView.b(ListItemView.this);
            }

            public void a(int i1)
            {
                ListDetailItem listdetailitem = mItem;
                if (i1 <= 0)
                {
                    i1 = -mItem.h();
                }
                listdetailitem.a(i1);
                if (com.target.ui.view.list.ListItemView.a(ListItemView.this) != null)
                {
                    com.target.ui.view.list.ListItemView.a(ListItemView.this).f(mItem);
                }
                com.target.ui.view.list.ListItemView.a(ListItemView.this, mItem);
            }

            
            {
                this$0 = ListItemView.this;
                super();
            }
        });
        return true;
    }

    public void onVisibilityChanged(View view, int i1)
    {
        if (i1 == 4)
        {
            if (mListener != null)
            {
                mListener.a(false, this);
            }
            setEditMode(false);
            b();
            k();
        }
    }

    public void setDisabled(boolean flag)
    {
        mItem.d(flag);
    }

    protected void setupAisleLocationView(boolean flag)
    {
        mViews.aisleLocationView.setLocation(mItem.f());
        if (flag || mViews.aisleLocationView.a())
        {
            mViews.aisleLocationView.setVisibility(8);
            return;
        } else
        {
            mViews.aisleLocationView.setVisibility(0);
            return;
        }
    }
}
