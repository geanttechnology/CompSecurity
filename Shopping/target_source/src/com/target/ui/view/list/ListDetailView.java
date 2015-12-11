// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.ui.adapter.list.ListDetailAdapter;
import com.target.ui.adapter.list.c;
import com.target.ui.model.list.ListDetailCompletedItem;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.util.a;
import com.target.ui.util.al;
import com.target.ui.view.RecyclerViewScroll;
import com.target.ui.view.TargetImeEditText;
import java.util.List;

// Referenced classes of package com.target.ui.view.list:
//            ListItemSuggestionsView

public class ListDetailView extends RelativeLayout
    implements com.target.ui.adapter.list.ListDetailAdapter.b
{
    static class Views extends com.target.ui.view.a
    {

        View addItemBlockingView;
        TargetImeEditText addItemEditText;
        View clearTextView;
        View itemsMaskView;
        ListItemSuggestionsView listItemSuggestionView;
        View mListDetailView;
        View progressBar;
        RecyclerViewScroll recyclerView;
        ImageView scanImageView;

        public Views(View view)
        {
            super(view);
        }
    }

    private static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a FADE_IN;
        public static final a FADE_OUT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/view/list/ListDetailView$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            FADE_IN = new a("FADE_IN", 0);
            FADE_OUT = new a("FADE_OUT", 1);
            $VALUES = (new a[] {
                FADE_IN, FADE_OUT
            });
        }

        private a(String s, int i1)
        {
            super(s, i1);
        }
    }

    public static interface b
    {

        public abstract void a(ListDetailCompletedItem listdetailcompleteditem);

        public abstract void a(ListDetailItem listdetailitem);

        public abstract void a(ListDetailItem listdetailitem, int i1);

        public abstract void a(ListDetailItem listdetailitem, View view);

        public abstract void a(String s);

        public abstract void a(boolean flag);

        public abstract void b();

        public abstract void b(ListDetailItem listdetailitem);

        public abstract void b(ListDetailItem listdetailitem, int i1);

        public abstract void b(String s);

        public abstract void c();

        public abstract void c(ListDetailItem listdetailitem);

        public abstract void c(ListDetailItem listdetailitem, int i1);

        public abstract void d(ListDetailItem listdetailitem);
    }


    private static final int FADE_OUT_DURATION = 300;
    private static final int FASTER_MOVE_DURATION = 50;
    private static final int FOCUS_DELAY = 300;
    private static final float OPAQUE = 1F;
    public static final int POSITION_UNSPECIFIED = -1;
    private static final int SLOWER_MOVE_DURATION = 250;
    private static final float TRANSPARENT = 0F;
    private ListDetailAdapter mAdapter;
    private com.target.ui.adapter.list.a mAnimationsFinishedListener;
    private String mListName;
    private b mListener;
    private Views mViews;

    public ListDetailView(Context context)
    {
        super(context);
        j();
    }

    public ListDetailView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        j();
    }

    public ListDetailView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        j();
    }

    static Views a(ListDetailView listdetailview)
    {
        return listdetailview.mViews;
    }

    private void a(a a1)
    {
        final float end = 0.0F;
        if (mViews.addItemEditText.hasFocus() || a1 != a.FADE_IN)
        {
            float f1;
            if (a1 == a.FADE_IN)
            {
                f1 = 0.0F;
            } else
            {
                f1 = 1.0F;
            }
            if (a1 == a.FADE_IN)
            {
                end = 1.0F;
            }
            if (mViews.itemsMaskView.getAlpha() != end)
            {
                if (end == 1.0F)
                {
                    al.b(mViews.itemsMaskView);
                }
                a1 = ObjectAnimator.ofFloat(mViews.itemsMaskView, View.ALPHA, new float[] {
                    f1, end
                });
                a1.addListener(new android.animation.Animator.AnimatorListener() {

                    final ListDetailView this$0;
                    final float val$end;

                    public void onAnimationCancel(Animator animator)
                    {
                    }

                    public void onAnimationEnd(Animator animator)
                    {
                        if (end == 0.0F)
                        {
                            al.c(com.target.ui.view.list.ListDetailView.a(ListDetailView.this).itemsMaskView);
                        }
                    }

                    public void onAnimationRepeat(Animator animator)
                    {
                    }

                    public void onAnimationStart(Animator animator)
                    {
                    }

            
            {
                this$0 = ListDetailView.this;
                end = f1;
                super();
            }
                });
                a1.start();
                return;
            }
        }
    }

    static void a(ListDetailView listdetailview, a a1)
    {
        listdetailview.a(a1);
    }

    static void a(ListDetailView listdetailview, String s)
    {
        listdetailview.a(s);
    }

    private void a(String s)
    {
        b(s);
        mViews.addItemEditText.setText("");
        if (mListener != null)
        {
            mListener.a(s);
        }
    }

    static void b(ListDetailView listdetailview)
    {
        listdetailview.q();
    }

    private void b(String s)
    {
        s = String.format(getResources().getString(0x7f090398), new Object[] {
            s
        });
        com.target.ui.util.a.a(getContext().getApplicationContext(), getRootView(), s);
    }

    static b c(ListDetailView listdetailview)
    {
        return listdetailview.mListener;
    }

    private void c(String s)
    {
        if (!com.target.ui.util.a.a(getContext()))
        {
            return;
        } else
        {
            s = String.format(getResources().getString(0x7f0903a3), new Object[] {
                s
            });
            com.target.ui.util.a.a(getContext(), this, s);
            return;
        }
    }

    static com.target.ui.adapter.list.a d(ListDetailView listdetailview)
    {
        return listdetailview.mAnimationsFinishedListener;
    }

    static void e(ListDetailView listdetailview)
    {
        listdetailview.n();
    }

    static void f(ListDetailView listdetailview)
    {
        listdetailview.l();
    }

    private void j()
    {
        mViews = new Views(LayoutInflater.from(getContext()).inflate(0x7f030165, this, true));
        k();
        m();
        if (!com.target.ui.util.b.a.a() || com.target.ui.util.a.a(getContext()))
        {
            mViews.scanImageView.setVisibility(8);
        }
        mViews.clearTextView.setOnClickListener(new android.view.View.OnClickListener() {

            final ListDetailView this$0;

            public void onClick(View view)
            {
                com.target.ui.view.list.ListDetailView.a(ListDetailView.this).addItemEditText.setText("");
                ListDetailView.b(ListDetailView.this);
            }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
        });
        mViews.scanImageView.setOnClickListener(new android.view.View.OnClickListener() {

            final ListDetailView this$0;

            public void onClick(View view)
            {
                if (com.target.ui.view.list.ListDetailView.c(ListDetailView.this) != null)
                {
                    com.target.ui.view.list.ListDetailView.a(ListDetailView.this).mListDetailView.requestFocus();
                    com.target.ui.util.e.a.a(ListDetailView.this);
                    com.target.ui.view.list.ListDetailView.a(ListDetailView.this).listItemSuggestionView.setVisibility(8);
                    com.target.ui.view.list.ListDetailView.c(ListDetailView.this).b();
                }
            }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
        });
        mAdapter = new ListDetailAdapter(this, mViews.recyclerView, getContext().getString(0x7f09039b));
        mViews.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mViews.recyclerView.setAdapter(mAdapter);
        com.target.ui.a.a a1 = new com.target.ui.a.a();
        a1.b(new android.support.v7.widget.RecyclerView.d.a() {

            final ListDetailView this$0;

            public void a()
            {
                if (ListDetailView.d(ListDetailView.this) == null)
                {
                    return;
                } else
                {
                    ListDetailView.d(ListDetailView.this).a();
                    return;
                }
            }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
        });
        a1.a(250L);
        mViews.recyclerView.setItemAnimator(a1);
        mViews.recyclerView.a(new c(getContext(), 1, getResources().getDimensionPixelSize(0x7f0a00c1), getResources().getDimensionPixelOffset(0x7f0a01d0)));
    }

    private void k()
    {
        mViews.addItemEditText.setOnDragListener(new android.view.View.OnDragListener() {

            final ListDetailView this$0;

            public boolean onDrag(View view, DragEvent dragevent)
            {
                return true;
            }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
        });
        mViews.addItemEditText.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final ListDetailView this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    ListDetailView.e(ListDetailView.this);
                    return;
                } else
                {
                    com.target.ui.view.list.ListDetailView.a(ListDetailView.this).addItemEditText.setText("");
                    ListDetailView.f(ListDetailView.this);
                    return;
                }
            }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
        });
        mViews.addItemEditText.setImeListener(new com.target.ui.view.TargetImeEditText.a() {

            final ListDetailView this$0;

            public boolean a(int i1, KeyEvent keyevent)
            {
                if (keyevent.getAction() == 0 && i1 == 4)
                {
                    al.c(com.target.ui.view.list.ListDetailView.a(ListDetailView.this).listItemSuggestionView);
                    com.target.ui.view.list.ListDetailView.a(ListDetailView.this).mListDetailView.postDelayed(new Runnable() {

                        final _cls9 this$1;

                        public void run()
                        {
                            com.target.ui.view.list.ListDetailView.a(_fld0).mListDetailView.requestFocus();
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    }, 300L);
                }
                return false;
            }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
        });
        mViews.addItemEditText.addTextChangedListener(new TextWatcher() {

            final ListDetailView this$0;

            public void afterTextChanged(Editable editable)
            {
                if (com.target.ui.view.list.ListDetailView.a(ListDetailView.this).addItemEditText.hasFocus())
                {
                    ListDetailView.e(ListDetailView.this);
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
        });
        mViews.addItemEditText.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final ListDetailView this$0;

            public boolean onEditorAction(TextView textview, int i1, KeyEvent keyevent)
            {
                if (i1 == 6 || i1 == 5 || keyevent.getAction() == 0)
                {
                    com.target.ui.view.list.ListDetailView.a(ListDetailView.this, textview.getText().toString());
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
        });
        mViews.addItemEditText.setOnKeyListener(new android.view.View.OnKeyListener() {

            final ListDetailView this$0;

            public boolean onKey(View view, int i1, KeyEvent keyevent)
            {
                if (keyevent.getAction() == 0 && i1 == 66)
                {
                    com.target.ui.view.list.ListDetailView.a(ListDetailView.this, com.target.ui.view.list.ListDetailView.a(ListDetailView.this).addItemEditText.getText().toString());
                    com.target.ui.view.list.ListDetailView.a(ListDetailView.this).addItemEditText.requestFocus();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
        });
        mViews.addItemBlockingView.setOnClickListener(new android.view.View.OnClickListener() {

            final ListDetailView this$0;

            public void onClick(View view)
            {
                if (com.target.ui.view.list.ListDetailView.c(ListDetailView.this) != null)
                {
                    com.target.ui.view.list.ListDetailView.c(ListDetailView.this).c();
                }
            }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
        });
    }

    private void l()
    {
        a(a.FADE_OUT);
        al.a(new View[] {
            mViews.clearTextView, mViews.listItemSuggestionView
        });
        if (mViews.itemsMaskView.hasFocus())
        {
            com.target.ui.util.e.a.a(mViews.addItemEditText);
        }
    }

    private void m()
    {
        mViews.listItemSuggestionView.setListener(new ListItemSuggestionsView.a() {

            final ListDetailView this$0;

            public void a(String s)
            {
                com.target.ui.view.list.ListDetailView.a(ListDetailView.this, s);
            }

            public void a(boolean flag)
            {
                ListDetailView listdetailview = ListDetailView.this;
                a a1;
                if (flag)
                {
                    a1 = a.FADE_OUT;
                } else
                {
                    a1 = a.FADE_IN;
                }
                com.target.ui.view.list.ListDetailView.a(listdetailview, a1);
            }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
        });
    }

    private void n()
    {
        String s = mViews.addItemEditText.getText().toString();
        if (mListener != null)
        {
            mListener.b(s);
        }
        View view = mViews.clearTextView;
        boolean flag;
        if (s.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        al.a(view, flag);
        al.b(mViews.listItemSuggestionView);
    }

    private void o()
    {
        if (mViews.addItemEditText.hasFocus())
        {
            com.target.ui.util.e.a.b(mViews.addItemEditText);
            n();
        }
    }

    private void p()
    {
        if (!com.target.ui.util.a.a(getContext()))
        {
            return;
        } else
        {
            String s = getResources().getString(0x7f0903a5);
            int i1 = mAdapter.a();
            String s1 = getResources().getQuantityString(0x7f110006, i1, new Object[] {
                Integer.valueOf(i1)
            });
            s = String.format(s, new Object[] {
                mListName, s1
            });
            mViews.recyclerView.setContentDescription(s);
            mViews.recyclerView.requestFocus();
            return;
        }
    }

    private void q()
    {
        if (!com.target.ui.util.a.a(getContext()))
        {
            return;
        } else
        {
            String s = getResources().getString(0x7f090385);
            com.target.ui.util.a.a(getContext(), this, s);
            return;
        }
    }

    public void a()
    {
        mViews.recyclerView.getItemAnimator().a(50L);
    }

    public void a(int i1)
    {
        if (i1 < mAdapter.a())
        {
            mViews.recyclerView.a_(i1);
        }
    }

    public void a(ListDetailCompletedItem listdetailcompleteditem)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.a(listdetailcompleteditem);
            return;
        }
    }

    public void a(ListDetailItem listdetailitem)
    {
        if (mListener != null)
        {
            mListener.a(listdetailitem);
        }
    }

    public void a(ListDetailItem listdetailitem, int i1)
    {
        c(listdetailitem.b());
        if (mListener != null)
        {
            mListener.c(listdetailitem);
        }
    }

    public void a(ListDetailItem listdetailitem, View view)
    {
        if (mListener != null)
        {
            mListener.a(listdetailitem, view);
        }
    }

    public void a(List list)
    {
        mViews.listItemSuggestionView.a(list);
    }

    public void a(boolean flag)
    {
        boolean flag2 = true;
        if (mListener != null)
        {
            mListener.a(flag);
        }
        mViews.recyclerView.b(flag);
        Object obj = mViews.listItemSuggestionView;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((ListItemSuggestionsView) (obj)).setEnabled(flag1);
        obj = mViews.scanImageView;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((ImageView) (obj)).setEnabled(flag1);
        obj = mViews.addItemEditText;
        if (!flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        ((TargetImeEditText) (obj)).setEnabled(flag);
        l();
    }

    public void b()
    {
        mViews.recyclerView.getItemAnimator().a(250L);
    }

    public void b(ListDetailCompletedItem listdetailcompleteditem)
    {
        mAdapter.b(listdetailcompleteditem);
    }

    public void b(ListDetailItem listdetailitem)
    {
    }

    public void b(ListDetailItem listdetailitem, int i1)
    {
        if (mListener != null)
        {
            mListener.a(listdetailitem, i1);
        }
    }

    public void c()
    {
        mAdapter.h();
    }

    public void c(ListDetailItem listdetailitem)
    {
        if (mListener != null)
        {
            mListener.b(listdetailitem);
        }
    }

    public void c(ListDetailItem listdetailitem, int i1)
    {
        if (mListener != null)
        {
            mListener.b(listdetailitem, i1);
        }
    }

    public void d()
    {
        o();
    }

    public void d(ListDetailItem listdetailitem)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.d(listdetailitem);
            return;
        }
    }

    public void d(ListDetailItem listdetailitem, int i1)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.c(listdetailitem, i1);
            return;
        }
    }

    public int e(ListDetailItem listdetailitem)
    {
        return e(listdetailitem, -1);
    }

    public int e(ListDetailItem listdetailitem, int i1)
    {
        if (i1 == -1)
        {
            return mAdapter.a(listdetailitem);
        } else
        {
            mAdapter.a(listdetailitem, i1);
            return i1;
        }
    }

    public void e()
    {
        mAdapter.i();
        i();
    }

    public void f()
    {
        mAdapter.j();
    }

    public void f(ListDetailItem listdetailitem)
    {
        mAdapter.c(listdetailitem);
    }

    public void g()
    {
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.play(ObjectAnimator.ofFloat(mViews.recyclerView, View.ALPHA, new float[] {
            1.0F, 0.0F
        }));
        animatorset.setDuration(300L);
        animatorset.start();
    }

    public List getListItems()
    {
        p();
        return mAdapter.k();
    }

    public void h()
    {
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.play(ObjectAnimator.ofFloat(mViews.recyclerView, View.ALPHA, new float[] {
            0.0F, 1.0F
        }));
        animatorset.setDuration(300L);
        animatorset.start();
    }

    public void i()
    {
        if (!com.target.ui.util.a.a(getContext()))
        {
            return;
        } else
        {
            String s = getResources().getString(0x7f0903a7);
            int i1 = mAdapter.a();
            String s1 = getResources().getQuantityString(0x7f110006, i1, new Object[] {
                Integer.valueOf(i1)
            });
            s = String.format(s, new Object[] {
                mListName, s1
            });
            mViews.recyclerView.setContentDescription(s);
            mViews.recyclerView.requestFocus();
            return;
        }
    }

    public void setAnimationsFinishedListener(com.target.ui.adapter.list.a a1)
    {
        mAnimationsFinishedListener = a1;
    }

    public void setCompletedItems(List list)
    {
        mAdapter.a(list);
    }

    public void setListDetailViewListener(b b1)
    {
        mListener = b1;
    }

    public void setListName(String s)
    {
        mListName = s;
    }

    public void setPromotionsOpen(boolean flag)
    {
        if (flag)
        {
            mViews.addItemBlockingView.setVisibility(0);
            return;
        } else
        {
            mViews.addItemBlockingView.setVisibility(8);
            return;
        }
    }
}
