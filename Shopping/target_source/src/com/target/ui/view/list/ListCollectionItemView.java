// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.util.o;
import com.target.ui.e.g;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.util.a;
import com.target.ui.view.TargetImeEditText;

public class ListCollectionItemView extends RelativeLayout
{
    public static interface a
    {

        public abstract void b(boolean flag);

        public abstract void e(ListCollectionItem listcollectionitem);

        public abstract void f(ListCollectionItem listcollectionitem);

        public abstract void g(ListCollectionItem listcollectionitem);

        public abstract boolean i();
    }

    private static class b
    {

        private TargetImeEditText mEditTitleText;
        private ImageView mGripper;
        private View mLayoutView;
        private TextView mMetadataView;
        private TextView mTitleView;

        static View a(b b1)
        {
            return b1.mLayoutView;
        }

        static TextView b(b b1)
        {
            return b1.mTitleView;
        }

        static TextView c(b b1)
        {
            return b1.mMetadataView;
        }

        static TargetImeEditText d(b b1)
        {
            return b1.mEditTitleText;
        }

        static ImageView e(b b1)
        {
            return b1.mGripper;
        }

        public b(View view)
        {
            mLayoutView = view.findViewById(0x7f1002a8);
            mTitleView = (TextView)view.findViewById(0x7f1002aa);
            mMetadataView = (TextView)view.findViewById(0x7f1002ab);
            mEditTitleText = (TargetImeEditText)view.findViewById(0x7f1000e8);
            mGripper = (ImageView)view.findViewById(0x7f1002a9);
        }
    }


    private static final long DELAY_LIST_EDIT_MODE = 3000L;
    private static final long INTERVAL_300_MSEC = 300L;
    private Context mContext;
    private a mListener;
    private g mTouchListener;
    private com.e.a.a.b mViewHolder;
    private b mViews;

    public ListCollectionItemView(Context context)
    {
        super(context);
        a(context);
    }

    public ListCollectionItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public ListCollectionItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a()
    {
        b.d(mViews).setVisibility(0);
        com.target.ui.view.list.b.a(mViews).setFocusable(true);
        b.b(mViews).setTranslationX(0.0F);
        b.c(mViews).setTranslationX(0.0F);
        b.d(mViews).setAlpha(0.0F);
        AnimatorSet animatorset = new AnimatorSet();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(b.b(mViews), View.TRANSLATION_X, new float[] {
            0.0F, (float)getWidth()
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(b.c(mViews), View.TRANSLATION_X, new float[] {
            0.0F, (float)getWidth()
        });
        ObjectAnimator objectanimator2 = ObjectAnimator.ofFloat(b.e(mViews), View.TRANSLATION_X, new float[] {
            0.0F, (float)(-getWidth())
        });
        ObjectAnimator objectanimator3 = ObjectAnimator.ofFloat(b.d(mViews), View.ALPHA, new float[] {
            0.0F, 1.0F
        });
        animatorset.play(objectanimator).with(objectanimator1).with(objectanimator2).before(objectanimator3);
        animatorset.setDuration(300L);
        animatorset.start();
        animatorset.addListener(new android.animation.Animator.AnimatorListener() {

            final ListCollectionItemView this$0;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                b.d(ListCollectionItemView.c(ListCollectionItemView.this)).requestFocus();
                com.target.ui.util.e.a.c(b.d(ListCollectionItemView.c(ListCollectionItemView.this)));
                com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this, true);
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = ListCollectionItemView.this;
                super();
            }
        });
    }

    private void a(Context context)
    {
        mViews = new b(LayoutInflater.from(context).inflate(0x7f0300d4, this, true));
        mContext = context;
    }

    static void a(ListCollectionItemView listcollectionitemview, String s)
    {
        listcollectionitemview.d(s);
    }

    static void a(ListCollectionItemView listcollectionitemview, boolean flag)
    {
        listcollectionitemview.setEditMode(flag);
    }

    private void a(String s)
    {
        s = String.format(getContext().getString(0x7f09038a), new Object[] {
            s
        });
        b.d(mViews).setContentDescription("");
        com.target.ui.util.a.a(getContext(), this, s, 3000L);
    }

    static boolean a(ListCollectionItemView listcollectionitemview)
    {
        return listcollectionitemview.d();
    }

    private void b()
    {
        b(b.d(mViews).getText().toString());
        int i = com.target.ui.view.list.b.a(mViews).getWidth();
        b.b(mViews).setTranslationX(-i);
        b.c(mViews).setTranslationX(-i);
        b.b(mViews).setAlpha(1.0F);
        b.c(mViews).setAlpha(1.0F);
        AnimatorSet animatorset = new AnimatorSet();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(b.b(mViews), View.TRANSLATION_X, new float[] {
            (float)i, 0.0F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(b.c(mViews), View.TRANSLATION_X, new float[] {
            (float)i, 0.0F
        });
        ObjectAnimator objectanimator2 = ObjectAnimator.ofFloat(b.e(mViews), View.TRANSLATION_X, new float[] {
            (float)(-i), 0.0F
        });
        ObjectAnimator objectanimator3 = ObjectAnimator.ofFloat(b.d(mViews), View.ALPHA, new float[] {
            1.0F, 0.0F
        });
        animatorset.play(objectanimator).with(objectanimator1).with(objectanimator2).after(objectanimator3);
        animatorset.setStartDelay(200L);
        animatorset.start();
        animatorset.addListener(new android.animation.Animator.AnimatorListener() {

            final ListCollectionItemView this$0;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                b.d(ListCollectionItemView.c(ListCollectionItemView.this)).setVisibility(8);
                b.d(ListCollectionItemView.c(ListCollectionItemView.this)).setAlpha(1.0F);
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = ListCollectionItemView.this;
                super();
            }
        });
    }

    static void b(ListCollectionItemView listcollectionitemview)
    {
        listcollectionitemview.b();
    }

    static void b(ListCollectionItemView listcollectionitemview, String s)
    {
        listcollectionitemview.c(s);
    }

    private void b(String s)
    {
        s = String.format(getContext().getString(0x7f09038b), new Object[] {
            s
        });
        b.d(mViews).setContentDescription("");
        com.target.ui.util.a.a(getContext(), this, s, 3000L);
    }

    static b c(ListCollectionItemView listcollectionitemview)
    {
        return listcollectionitemview.mViews;
    }

    private void c()
    {
        b.b(mViews).setTranslationX(0.0F);
        b.c(mViews).setTranslationX(0.0F);
        b.b(mViews).setAlpha(1.0F);
        b.c(mViews).setAlpha(1.0F);
        b.d(mViews).setAlpha(1.0F);
        b.d(mViews).setVisibility(8);
    }

    static void c(ListCollectionItemView listcollectionitemview, String s)
    {
        listcollectionitemview.a(s);
    }

    private void c(String s)
    {
        s = String.format(getContext().getString(0x7f09038e), new Object[] {
            s
        });
        com.target.ui.util.a.a(getContext(), this, s);
    }

    static a d(ListCollectionItemView listcollectionitemview)
    {
        return listcollectionitemview.mListener;
    }

    private void d(String s)
    {
        s = String.format(getResources().getString(0x7f0903b1), new Object[] {
            s
        });
        com.target.ui.util.a.a(getContext(), this, s);
    }

    private boolean d()
    {
        if (mListener != null)
        {
            return mListener.i();
        } else
        {
            return false;
        }
    }

    static g e(ListCollectionItemView listcollectionitemview)
    {
        return listcollectionitemview.mTouchListener;
    }

    static void f(ListCollectionItemView listcollectionitemview)
    {
        listcollectionitemview.a();
    }

    static com.e.a.a.b g(ListCollectionItemView listcollectionitemview)
    {
        return listcollectionitemview.mViewHolder;
    }

    private void setEditMode(final boolean editMode)
    {
        if (mListener != null)
        {
            (new Handler()).postDelayed(new Runnable() {

                final ListCollectionItemView this$0;
                final boolean val$editMode;

                public void run()
                {
                    ListCollectionItemView.d(ListCollectionItemView.this).b(editMode);
                }

            
            {
                this$0 = ListCollectionItemView.this;
                editMode = flag;
                super();
            }
            }, 300L);
        }
    }

    private void setupCompletedReorderContentDescription(String s)
    {
        s = String.format(getContext().getString(0x7f09038c), new Object[] {
            s
        });
        com.target.ui.util.a.a(getContext(), this, s);
    }

    private void setupContentDescription(ListCollectionItem listcollectionitem)
    {
        listcollectionitem = String.format(getContext().getString(0x7f090389), new Object[] {
            listcollectionitem.b(), listcollectionitem.c(), listcollectionitem.a()
        });
        com.target.ui.view.list.b.a(mViews).setContentDescription(listcollectionitem);
    }

    private void setupInitiateReorderContentDescription(String s)
    {
        s = String.format(getContext().getString(0x7f09038d), new Object[] {
            s
        });
        com.target.ui.util.a.a(getContext(), this, s);
    }

    public void a(final ListCollectionItem item, a a1, com.e.a.a.b b1)
    {
        mListener = a1;
        mViewHolder = b1;
        com.target.ui.view.list.b.a(mViews).setTranslationX(0.0F);
        com.target.ui.view.list.b.a(mViews).setAlpha(1.0F);
        b.b(mViews).setText(item.b());
        b.c(mViews).setText(getResources().getString(0x7f0903a9, new Object[] {
            item.c(), item.a()
        }));
        setupContentDescription(item);
        b.d(mViews).setImeListener(new com.target.ui.view.TargetImeEditText.a() {

            final ListCollectionItemView this$0;

            public boolean a(int i, KeyEvent keyevent)
            {
                boolean flag1 = false;
                boolean flag = flag1;
                if (com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this))
                {
                    flag = flag1;
                    if (keyevent.getAction() == 0)
                    {
                        flag = flag1;
                        if (i == 4)
                        {
                            com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this, false);
                            ListCollectionItemView.b(ListCollectionItemView.this);
                            com.target.ui.util.e.a.a(ListCollectionItemView.this);
                            flag = true;
                        }
                    }
                }
                return flag;
            }

            
            {
                this$0 = ListCollectionItemView.this;
                super();
            }
        });
        b.d(mViews).setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final ListCollectionItemView this$0;
            final ListCollectionItem val$item;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i != 6 && keyevent != null && keyevent.getAction() != 0)
                {
                    return false;
                }
                com.target.ui.util.e.a.a(ListCollectionItemView.this);
                ListCollectionItemView.b(ListCollectionItemView.this);
                textview = b.d(ListCollectionItemView.c(ListCollectionItemView.this)).getText().toString();
                if (!o.e(textview) && ListCollectionItemView.d(ListCollectionItemView.this) != null)
                {
                    com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this, textview);
                    item.a(textview);
                    ListCollectionItemView.d(ListCollectionItemView.this).g(item);
                }
                com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this, false);
                return true;
            }

            
            {
                this$0 = ListCollectionItemView.this;
                item = listcollectionitem;
                super();
            }
        });
        mTouchListener = new g(com.target.ui.view.list.b.a(mViews), null, new com.target.ui.e.g.a() {

            final ListCollectionItemView this$0;
            final ListCollectionItem val$item;

            public void a()
            {
                ListCollectionItemView.b(ListCollectionItemView.this, b.b(ListCollectionItemView.c(ListCollectionItemView.this)).getText().toString());
            }

            public void a(View view, Object obj)
            {
                if (ListCollectionItemView.d(ListCollectionItemView.this) != null)
                {
                    ListCollectionItemView.d(ListCollectionItemView.this).f(item);
                }
            }

            public boolean a(Object obj)
            {
                return !item.d().isDefaultList() && !com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this);
            }

            
            {
                this$0 = ListCollectionItemView.this;
                item = listcollectionitem;
                super();
            }
        });
        com.target.ui.view.list.b.a(mViews).setOnTouchListener(mTouchListener);
        com.target.ui.view.list.b.a(mViews).setOnClickListener(new android.view.View.OnClickListener() {

            final ListCollectionItemView this$0;
            final ListCollectionItem val$item;

            public void onClick(View view)
            {
                if (!ListCollectionItemView.e(ListCollectionItemView.this).a() && !com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this) && ListCollectionItemView.d(ListCollectionItemView.this) != null)
                {
                    ListCollectionItemView.d(ListCollectionItemView.this).e(item);
                }
            }

            
            {
                this$0 = ListCollectionItemView.this;
                item = listcollectionitem;
                super();
            }
        });
        com.target.ui.view.list.b.a(mViews).setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final ListCollectionItemView this$0;
            final ListCollectionItem val$item;

            public boolean onLongClick(View view)
            {
                if (ListCollectionItemView.e(ListCollectionItemView.this).a() || com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this) || item.d().isDefaultList())
                {
                    return true;
                } else
                {
                    ListCollectionItemView.c(ListCollectionItemView.this, b.b(ListCollectionItemView.c(ListCollectionItemView.this)).getText().toString());
                    ListCollectionItemView.f(ListCollectionItemView.this);
                    b.d(ListCollectionItemView.c(ListCollectionItemView.this)).setText(b.b(ListCollectionItemView.c(ListCollectionItemView.this)).getText());
                    return true;
                }
            }

            
            {
                this$0 = ListCollectionItemView.this;
                item = listcollectionitem;
                super();
            }
        });
        b.e(mViews).setOnTouchListener(new android.view.View.OnTouchListener() {

            final ListCollectionItemView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 0)
                {
                    com.target.ui.view.list.ListCollectionItemView.g(ListCollectionItemView.this).w();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = ListCollectionItemView.this;
                super();
            }
        });
    }

    public void a(boolean flag)
    {
        View view = com.target.ui.view.list.b.a(mViews);
        float f1;
        if (flag)
        {
            f1 = 0.0F;
        } else
        {
            f1 = 1.0F;
        }
        view.setAlpha(f1);
    }

    public void onVisibilityChanged(View view, int i)
    {
        if (i == 4)
        {
            setEditMode(false);
            c();
        }
    }
}
