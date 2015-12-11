// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.PersonName;
import com.target.mothership.util.o;
import com.target.ui.util.aj;
import com.target.ui.util.validation.a.k;
import com.target.ui.util.validation.g;
import com.target.ui.util.validation.validator.a;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.account.b;
import com.target.ui.view.account.c;

public class NameView extends FrameLayout
    implements android.view.View.OnFocusChangeListener
{
    static class Views extends com.target.ui.view.a
    {

        EditText firstName;
        CustomErrorViewWrapper firstNameWrapper;
        EditText lastName;
        CustomErrorViewWrapper lastNameWrapper;
        View root;

        Views(View view)
        {
            super(view);
        }
    }

    private final class a
        implements TextWatcher
    {

        private int beforeCharCount;
        final NameView this$0;

        public void afterTextChanged(Editable editable)
        {
            int i = com.target.ui.view.common.NameView.c(NameView.this).firstName.getText().length();
            com.target.ui.view.common.NameView.a(NameView.this, beforeCharCount, i);
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int l)
        {
            beforeCharCount = com.target.ui.view.common.NameView.c(NameView.this).firstName.getText().length();
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int l)
        {
        }

        private a()
        {
            this$0 = NameView.this;
            super();
            beforeCharCount = 0;
        }

    }

    private static final class b
        implements com.target.ui.util.validation.validator.a
    {

        private static final k sEmptyReport = new k() {

            public boolean a()
            {
                return true;
            }

            public String b()
            {
                return null;
            }

        };

        public k a(String s)
        {
            return sEmptyReport;
        }


        private b()
        {
        }

    }

    private final class c extends com.target.ui.k.b
    {

        final NameView this$0;
        private boolean wasValid;

        public void a(Editable editable)
        {
            editable = com.target.ui.view.common.NameView.a(NameView.this);
            com.target.ui.view.common.NameView.a(NameView.this, editable, wasValid);
            com.target.ui.view.common.NameView.a(NameView.this, editable);
            com.target.ui.view.common.NameView.a(NameView.this, NameView.this.a());
        }

        public void a(CharSequence charsequence, int i, int j, int l)
        {
            wasValid = com.target.ui.view.common.NameView.a(NameView.this).a();
        }

        public void b(CharSequence charsequence, int i, int j, int l)
        {
        }

        private c()
        {
            this$0 = NameView.this;
            super();
        }

    }

    private final class d
        implements android.widget.TextView.OnEditorActionListener
    {

        final NameView this$0;

        public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
        {
            if (i == 6)
            {
                textview = com.target.ui.view.common.NameView.b(NameView.this);
                if (o.g(textview.b()))
                {
                    com.target.ui.view.common.NameView.c(NameView.this).lastNameWrapper.setErrorState(textview.b());
                }
            }
            return false;
        }

        private d()
        {
            this$0 = NameView.this;
            super();
        }

    }

    private final class e extends com.target.ui.k.b
    {

        final NameView this$0;
        private boolean wasValid;

        public void a(Editable editable)
        {
            editable = com.target.ui.view.common.NameView.b(NameView.this);
            com.target.ui.view.common.NameView.a(NameView.this, editable, wasValid);
            com.target.ui.view.common.NameView.b(NameView.this, editable);
            com.target.ui.view.common.NameView.a(NameView.this, NameView.this.a());
        }

        public void a(CharSequence charsequence, int i, int j, int l)
        {
            wasValid = com.target.ui.view.common.NameView.b(NameView.this).a();
        }

        public void b(CharSequence charsequence, int i, int j, int l)
        {
        }

        private e()
        {
            this$0 = NameView.this;
            super();
        }

    }

    public static interface f
    {

        public abstract void a();

        public abstract void a(String s, String s1);
    }


    private static final String TAG = com/target/ui/view/common/NameView.getSimpleName();
    private com.target.ui.util.validation.validator.a mFirstNameValidator;
    private com.target.ui.view.account.c mInputChangeListener;
    private com.target.ui.util.validation.validator.a mLastNameValidator;
    private int mStartingWidth;
    private com.target.ui.view.account.b mValidationListener;
    private Views mViews;

    public NameView(Context context)
    {
        super(context);
        mStartingWidth = 0;
        a(context);
    }

    public NameView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mStartingWidth = 0;
        a(context);
    }

    public NameView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mStartingWidth = 0;
        a(context);
    }

    static k a(NameView nameview)
    {
        return nameview.e();
    }

    private void a(int i, int j)
    {
        if (i == 0 && j > 0)
        {
            g();
        } else
        if (i > 0 && j == 0)
        {
            h();
            return;
        }
    }

    private void a(Context context)
    {
        inflate(context, 0x7f030147, this);
        mViews = new Views(this);
        mViews.firstName.addTextChangedListener(new a());
        mViews.firstName.addTextChangedListener(new c());
        mViews.firstName.setOnFocusChangeListener(this);
        mViews.lastName.addTextChangedListener(new e());
        mViews.lastName.setOnFocusChangeListener(this);
        mViews.lastName.setOnEditorActionListener(new d());
        context = new b();
        mFirstNameValidator = context;
        mLastNameValidator = context;
    }

    private void a(k k1, EditText edittext, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (com.target.ui.util.validation.g.a(k1, edittext, customerrorviewwrapper))
        {
            customerrorviewwrapper.setErrorState(k1.b());
            return;
        } else
        {
            customerrorviewwrapper.b();
            return;
        }
    }

    private void a(k k1, boolean flag)
    {
        boolean flag1 = k1.a();
        if (flag != flag1)
        {
            a(flag1);
        }
    }

    static void a(NameView nameview, int i, int j)
    {
        nameview.a(i, j);
    }

    static void a(NameView nameview, k k1)
    {
        nameview.setFirstNameErrorState(k1);
    }

    static void a(NameView nameview, k k1, boolean flag)
    {
        nameview.a(k1, flag);
    }

    static void a(NameView nameview, boolean flag)
    {
        nameview.b(flag);
    }

    private void a(boolean flag)
    {
label0:
        {
            if (mValidationListener != null)
            {
                if (!flag)
                {
                    break label0;
                }
                mValidationListener.a(this, a());
            }
            return;
        }
        mValidationListener.a(this, a());
    }

    static k b(NameView nameview)
    {
        return nameview.f();
    }

    static void b(NameView nameview, k k1)
    {
        nameview.setLastNameErrorState(k1);
    }

    private void b(boolean flag)
    {
        if (mInputChangeListener != null)
        {
            mInputChangeListener.a(flag, mViews.firstName.getText().toString(), mViews.lastName.getText().toString());
        }
    }

    static Views c(NameView nameview)
    {
        return nameview.mViews;
    }

    private void c()
    {
        setFirstNameErrorState(e());
    }

    static int d(NameView nameview)
    {
        return nameview.mStartingWidth;
    }

    private void d()
    {
        setLastNameErrorState(f());
    }

    private k e()
    {
        String s = mViews.firstName.getText().toString();
        return mFirstNameValidator.a(s);
    }

    private k f()
    {
        String s = mViews.lastName.getText().toString();
        return mLastNameValidator.a(s);
    }

    private void g()
    {
        mViews.firstNameWrapper.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

            final NameView this$0;

            public boolean onPreDraw()
            {
                com.target.ui.view.common.NameView.c(NameView.this).root.getViewTreeObserver().removeOnPreDrawListener(this);
                int i = NameView.d(NameView.this) / 2;
                int j = com.target.ui.view.common.NameView.c(NameView.this).lastNameWrapper.getPaddingLeft() / 2;
                com.target.ui.a.b b1 = new com.target.ui.a.b(com.target.ui.view.common.NameView.c(NameView.this).firstNameWrapper, NameView.d(NameView.this), i - j);
                AnimatorSet animatorset = aj.b(com.target.ui.view.common.NameView.c(NameView.this).lastNameWrapper);
                com.target.ui.view.common.NameView.c(NameView.this).firstNameWrapper.startAnimation(b1);
                animatorset.addListener(new AnimatorListenerAdapter() {

                    final _cls1 this$1;

                    public void onAnimationStart(Animator animator)
                    {
                        com.target.ui.view.common.NameView.c(_fld0).lastName.setEnabled(true);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                animatorset.start();
                return true;
            }

            
            {
                this$0 = NameView.this;
                super();
            }
        });
        mViews.lastNameWrapper.setVisibility(0);
    }

    private void h()
    {
        int i = mViews.firstNameWrapper.getWidth();
        final com.target.ui.a.b growFirstNameAnimation = new com.target.ui.a.b(mViews.firstNameWrapper, i, mStartingWidth);
        AnimatorSet animatorset = aj.c(mViews.lastNameWrapper);
        mViews.root.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

            final NameView this$0;
            final com.target.ui.a.b val$growFirstNameAnimation;

            public boolean onPreDraw()
            {
                com.target.ui.view.common.NameView.c(NameView.this).root.getViewTreeObserver().removeOnPreDrawListener(this);
                com.target.ui.view.common.NameView.c(NameView.this).firstNameWrapper.startAnimation(growFirstNameAnimation);
                return true;
            }

            
            {
                this$0 = NameView.this;
                growFirstNameAnimation = b1;
                super();
            }
        });
        animatorset.addListener(new AnimatorListenerAdapter() {

            final NameView this$0;

            public void onAnimationEnd(Animator animator)
            {
                com.target.ui.view.common.NameView.c(NameView.this).lastName.setEnabled(false);
            }

            
            {
                this$0 = NameView.this;
                super();
            }
        });
        animatorset.start();
    }

    private void setFirstNameErrorState(k k1)
    {
        a(k1, mViews.firstName, mViews.firstNameWrapper);
    }

    private void setLastNameErrorState(k k1)
    {
        a(k1, mViews.lastName, mViews.lastNameWrapper);
    }

    public void a(GuestAddress guestaddress)
    {
        if (guestaddress.c().b())
        {
            guestaddress = (PersonName)guestaddress.c().c();
            mViews.firstName.setText(guestaddress.a());
            mViews.lastName.setText(guestaddress.c());
        }
    }

    public void a(f f1)
    {
        k k1 = e();
        k k2 = f();
        setFirstNameErrorState(k1);
        setLastNameErrorState(k2);
        if (k1.a() && k2.a())
        {
            f1.a(mViews.firstName.getText().toString(), mViews.lastName.getText().toString());
            return;
        } else
        {
            f1.a();
            return;
        }
    }

    public void a(String s, String s1)
    {
        mViews.firstName.setText(s);
        mViews.lastName.setText(s1);
        a(a());
    }

    public boolean a()
    {
        boolean flag = mFirstNameValidator.a(mViews.firstName.getText().toString()).a();
        boolean flag1 = mLastNameValidator.a(mViews.lastName.getText().toString()).a();
        return flag && flag1;
    }

    public void b()
    {
        k k1 = e();
        k k2 = f();
        setFirstNameErrorState(k1);
        setLastNameErrorState(k2);
    }

    public void onFocusChange(View view, boolean flag)
    {
        view.getId();
        JVM INSTR tableswitch 2131756053 2131756055: default 32
    //                   2131756053 33
    //                   2131756054 32
    //                   2131756055 42;
           goto _L1 _L2 _L1 _L3
_L1:
        return;
_L2:
        if (!flag)
        {
            c();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (!flag)
        {
            d();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onLayout(boolean flag, int i, int j, int l, int i1)
    {
        super.onLayout(flag, i, j, l, i1);
        if (mStartingWidth == 0)
        {
            mStartingWidth = mViews.firstNameWrapper.getWidth();
        }
    }

    public void setFirstNameValidator(com.target.ui.util.validation.validator.a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("firstNameValidator must not be null");
        } else
        {
            mFirstNameValidator = a1;
            return;
        }
    }

    public void setHintText(String s)
    {
        mViews.firstName.setHint(s);
    }

    public void setInputChangeListener(com.target.ui.view.account.c c1)
    {
        mInputChangeListener = c1;
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }

    public void setLastNameValidator(com.target.ui.util.validation.validator.a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("lastNameValidator must not be null");
        } else
        {
            mLastNameValidator = a1;
            return;
        }
    }

}
