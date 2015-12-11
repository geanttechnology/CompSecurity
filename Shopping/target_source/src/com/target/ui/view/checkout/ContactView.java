// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.util.o;
import com.target.ui.model.checkout.DeliveryTypedProducts;
import com.target.ui.util.al;
import com.target.ui.util.validation.a.g;
import com.target.ui.util.validation.e;
import com.target.ui.util.validation.h;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.account.a;
import com.target.ui.view.account.b;
import java.util.List;

public class ContactView extends LinearLayout
    implements android.view.View.OnFocusChangeListener, com.target.ui.view.account.a, com.target.ui.view.account.b
{
    static class Views extends com.target.ui.view.a
    {

        public View contactContainer;
        EditText email;
        public CustomErrorViewWrapper emailWrapper;
        public EditText phone;
        public CustomErrorViewWrapper phoneWrapper;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(String s, String s1);
    }

    private final class b extends com.target.ui.k.b
    {

        final ContactView this$0;
        boolean wasValid;

        public void a(Editable editable)
        {
            boolean flag = com.target.ui.view.checkout.ContactView.a(ContactView.this);
            if (wasValid != flag)
            {
                ContactView.this.a(com.target.ui.view.checkout.ContactView.b(ContactView.this).email, flag);
            }
            ContactView.this.b(com.target.ui.view.checkout.ContactView.b(ContactView.this).email, flag);
            com.target.ui.view.checkout.ContactView.a(ContactView.this, flag);
        }

        public void a(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = com.target.ui.view.checkout.ContactView.a(ContactView.this);
        }

        public void b(CharSequence charsequence, int i, int j, int k)
        {
        }

        private b()
        {
            this$0 = ContactView.this;
            super();
        }

    }

    private class c
    {

        boolean emailValid;
        boolean phoneNumberValid;
        final ContactView this$0;

        private c()
        {
            this$0 = ContactView.this;
            super();
            emailValid = false;
            phoneNumberValid = false;
        }

    }


    private b mEmailTextWatcher;
    private c mFormState;
    private com.target.ui.view.account.a mInputChangeListener;
    private e mPhoneNumberValidationHelper;
    private com.target.ui.view.account.b mValidationListener;
    private Views mViews;

    public ContactView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public ContactView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public ContactView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    private void a(c c1)
    {
        c1.emailValid = e();
        if (mViews.contactContainer.getVisibility() == 0)
        {
            c1.phoneNumberValid = mPhoneNumberValidationHelper.a().a();
            return;
        } else
        {
            c1.phoneNumberValid = true;
            return;
        }
    }

    static void a(ContactView contactview, boolean flag)
    {
        contactview.setEmailIdErrorState(flag);
    }

    private void a(boolean flag)
    {
        if (mValidationListener != null)
        {
            mValidationListener.a(this, flag);
        }
    }

    static boolean a(ContactView contactview)
    {
        return contactview.e();
    }

    static Views b(ContactView contactview)
    {
        return contactview.mViews;
    }

    private void b(OrderReview orderreview)
    {
        Guest guest = getCurrentGuest();
        if (guest == null)
        {
            return;
        }
        if (guest.isAnonymous())
        {
            c();
            return;
        }
        if (o.g(orderreview.o()))
        {
            mViews.email.setText(orderreview.o());
            mViews.email.setEnabled(false);
            a(mViews.email, e());
            return;
        } else
        {
            c();
            return;
        }
    }

    private void b(boolean flag)
    {
        if (mInputChangeListener != null)
        {
            mInputChangeListener.b(this, flag);
        }
    }

    private boolean b(c c1)
    {
        return c1.emailValid && c1.phoneNumberValid;
    }

    private void c()
    {
        if (mEmailTextWatcher == null)
        {
            mViews.email.setEnabled(true);
            mViews.email.setOnFocusChangeListener(this);
            mEmailTextWatcher = new b();
            mViews.email.addTextChangedListener(mEmailTextWatcher);
        }
    }

    private void c(OrderReview orderreview)
    {
        orderreview = com.target.ui.util.e.a(orderreview);
        if (orderreview == null)
        {
            al.c(mViews.contactContainer);
            return;
        }
        if (orderreview.d().isEmpty())
        {
            al.c(mViews.contactContainer);
            return;
        } else
        {
            d();
            return;
        }
    }

    private void d()
    {
        if (mPhoneNumberValidationHelper == null)
        {
            mPhoneNumberValidationHelper = new e(mViews.phone, mViews.phoneWrapper, this, this);
            mViews.phone.addTextChangedListener(mPhoneNumberValidationHelper);
            mViews.phone.setOnFocusChangeListener(this);
        }
    }

    private boolean e()
    {
        return h.i(mViews.email.getText().toString());
    }

    private Guest getCurrentGuest()
    {
        com.target.ui.service.a a1 = com.target.ui.service.a.a();
        if (a1.c().b())
        {
            return (Guest)a1.c().c();
        } else
        {
            return null;
        }
    }

    private void setEmailIdErrorState(boolean flag)
    {
        if (flag)
        {
            mViews.emailWrapper.b();
            return;
        }
        if (!mViews.email.hasFocus() && !flag)
        {
            mViews.emailWrapper.setErrorState(getResources().getString(0x7f0901f4));
            return;
        }
        if (mViews.emailWrapper.a())
        {
            mViews.emailWrapper.setErrorState(getResources().getString(0x7f0901f4));
            return;
        } else
        {
            mViews.emailWrapper.b();
            return;
        }
    }

    public void a()
    {
        if (!b())
        {
            setEmailIdErrorState(e());
            if (!mFormState.phoneNumberValid && mPhoneNumberValidationHelper != null)
            {
                g g1 = mPhoneNumberValidationHelper.a();
                mPhoneNumberValidationHelper.a(g1);
                return;
            }
        }
    }

    public void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f03012a, this);
        mViews = new Views(this);
        mFormState = new c();
    }

    public void a(View view, boolean flag)
    {
        int i = view.getId();
        if (i != mViews.email.getId()) goto _L2; else goto _L1
_L1:
        mFormState.emailValid = flag;
_L4:
        a(b(mFormState));
        return;
_L2:
        if (i == mViews.phone.getId())
        {
            mFormState.phoneNumberValid = flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(OrderReview orderreview)
    {
        if (mViews == null || orderreview == null)
        {
            return;
        } else
        {
            b(orderreview);
            c(orderreview);
            a(mFormState);
            a(b());
            return;
        }
    }

    public void a(a a1)
    {
        if (b())
        {
            a1.a(mViews.email.getText().toString(), mViews.phone.getText().toString());
            return;
        } else
        {
            a1.a();
            return;
        }
    }

    public void b(View view, boolean flag)
    {
        int i = view.getId();
        if (i != mViews.email.getId()) goto _L2; else goto _L1
_L1:
        mFormState.emailValid = flag;
_L4:
        b(b(mFormState));
        return;
_L2:
        if (i == mViews.phone.getId())
        {
            mFormState.phoneNumberValid = flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean b()
    {
        boolean flag1 = e();
        boolean flag;
        if (al.a(mViews.contactContainer) && mPhoneNumberValidationHelper != null)
        {
            flag = mPhoneNumberValidationHelper.a().a();
        } else
        {
            flag = true;
        }
        return flag1 && flag;
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (mViews != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        view.getId();
        JVM INSTR lookupswitch 2: default 40
    //                   2131755912: 41
    //                   2131755916: 54;
           goto _L3 _L4 _L5
_L5:
        continue; /* Loop/switch isn't completed */
_L3:
        return;
_L4:
        if (flag) goto _L1; else goto _L6
_L6:
        setEmailIdErrorState(e());
        return;
        if (flag) goto _L1; else goto _L7
_L7:
        view = mPhoneNumberValidationHelper.a();
        mPhoneNumberValidationHelper.a(view);
        return;
    }

    public void setInputChangeListener(com.target.ui.view.account.a a1)
    {
        mInputChangeListener = a1;
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }
}
