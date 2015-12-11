// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.model.c.c.a;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.PhoneNumber;
import com.target.ui.util.validation.a.g;
import com.target.ui.util.validation.e;
import com.target.ui.util.validation.validator.FirstNameValidator;
import com.target.ui.util.validation.validator.LastNameValidator;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.account.b;
import com.target.ui.view.account.c;
import com.target.ui.view.common.NameView;

// Referenced classes of package com.target.ui.view.checkout:
//            AddressView, a

public class AddressFormView extends LinearLayout
    implements com.target.ui.view.account.b
{
    static class Views extends com.target.ui.view.a
    {

        AddressView addressView;
        NameView nameView;
        EditText phoneNumber;
        CustomErrorViewWrapper phoneNumberWrapper;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
                String s7);
    }

    private final class b
        implements AddressView.a
    {

        String addressLine;
        String apartment;
        String city;
        boolean isValid;
        String state;
        final AddressFormView this$0;
        String zipCode;

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1, String s2, String s3, String s4)
        {
            addressLine = s;
            apartment = s1;
            city = s2;
            state = s4;
            zipCode = s3;
            isValid = true;
        }

        private b()
        {
            this$0 = AddressFormView.this;
            super();
        }

    }

    private class c
    {

        boolean addressValid;
        boolean nameValid;
        boolean phoneNumberValid;
        final AddressFormView this$0;

        private c()
        {
            this$0 = AddressFormView.this;
            super();
            nameValid = false;
            addressValid = false;
            phoneNumberValid = false;
        }

    }

    private final class d
        implements com.target.ui.view.common.NameView.f
    {

        String firstName;
        boolean isValid;
        String lastName;
        final AddressFormView this$0;

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1)
        {
            firstName = s;
            lastName = s1;
            isValid = true;
        }

        private d()
        {
            this$0 = AddressFormView.this;
            super();
        }

    }


    private c mFormState;
    private final android.view.View.OnFocusChangeListener mPhoneNumberFocusListener;
    private e mPhoneNumberValidationHelper;
    private com.target.ui.view.account.b mValidationListener;
    private Views mViews;

    public AddressFormView(Context context)
    {
        super(context);
        mViews = null;
        mPhoneNumberFocusListener = new android.view.View.OnFocusChangeListener() {

            final AddressFormView this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (!flag)
                {
                    com.target.ui.view.checkout.AddressFormView.a(AddressFormView.this);
                }
            }

            
            {
                this$0 = AddressFormView.this;
                super();
            }
        };
        a(context);
    }

    public AddressFormView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        mPhoneNumberFocusListener = new _cls1();
        a(context);
    }

    public AddressFormView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        mPhoneNumberFocusListener = new _cls1();
        a(context);
    }

    private void a(c c1)
    {
        c1.nameValid = mViews.nameView.a();
        c1.addressValid = mViews.addressView.a();
        c1.phoneNumberValid = mPhoneNumberValidationHelper.a().a();
    }

    static void a(AddressFormView addressformview)
    {
        addressformview.b();
    }

    private void a(boolean flag)
    {
        if (mValidationListener != null)
        {
            mValidationListener.a(this, flag);
        }
    }

    private void b()
    {
        g g1 = mPhoneNumberValidationHelper.a();
        mPhoneNumberValidationHelper.a(g1);
    }

    private boolean b(c c1)
    {
        return c1.nameValid && c1.addressValid && c1.phoneNumberValid;
    }

    public void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f030123, this);
        mViews = new Views(this);
        mPhoneNumberValidationHelper = new e(mViews.phoneNumber, mViews.phoneNumberWrapper, this, null);
        mViews.phoneNumber.setOnFocusChangeListener(mPhoneNumberFocusListener);
        mViews.phoneNumber.addTextChangedListener(mPhoneNumberValidationHelper);
        mViews.addressView.setInputValidationListener(this);
        mViews.nameView.setFirstNameValidator(new FirstNameValidator(getContext()));
        mViews.nameView.setLastNameValidator(new LastNameValidator(getContext()));
        mViews.nameView.setInputValidationListener(this);
        mFormState = new c();
    }

    public void a(View view, boolean flag)
    {
        int i = view.getId();
        if (i != mViews.nameView.getId()) goto _L2; else goto _L1
_L1:
        mFormState.nameValid = flag;
_L4:
        a(b(mFormState));
        return;
_L2:
        if (i == mViews.addressView.getId())
        {
            mFormState.addressValid = flag;
        } else
        if (i == mViews.phoneNumber.getId())
        {
            mFormState.phoneNumberValid = flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(AddressParams addressparams)
    {
        mViews.nameView.a(addressparams.f(), addressparams.h());
        mViews.addressView.a(addressparams);
        mViews.phoneNumber.setText("");
        mViews.phoneNumber.setText(com.target.ui.util.d.b.h(addressparams.i()));
        a(mFormState);
        a(a());
    }

    public void a(GuestAddress guestaddress)
    {
        mViews.nameView.a(guestaddress);
        mViews.addressView.a(guestaddress);
        if (guestaddress.d() != null)
        {
            mViews.phoneNumber.setText("");
            mViews.phoneNumber.setText(com.target.ui.util.d.b.h(guestaddress.d().a()));
        }
        a(mFormState);
        a(a());
    }

    public void a(a a1)
    {
        d d1 = new d();
        b b1 = new b();
        mViews.nameView.a(d1);
        mViews.addressView.a(b1);
        if (a())
        {
            a1.a(d1.firstName, d1.lastName, b1.addressLine, b1.apartment, b1.city, b1.zipCode, b1.state, mViews.phoneNumber.getText().toString());
            return;
        } else
        {
            a1.a();
            return;
        }
    }

    public boolean a()
    {
        boolean flag = mViews.nameView.a();
        boolean flag1 = mViews.addressView.a();
        boolean flag2 = mPhoneNumberValidationHelper.a().a();
        return flag && flag1 && flag2;
    }

    public void setAddressHint(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.addressView.setAddressHint(s);
            return;
        }
    }

    public void setCheckoutAddressFormListener(com.target.ui.view.checkout.a a1)
    {
        mViews.addressView.setCheckoutAddressFormListener(a1);
    }

    public void setGeoCodeDetails(com.target.mothership.model.c.c.a a1)
    {
        mViews.addressView.setZipCodeSearchResult(a1);
    }

    public void setInputChangeListener(com.target.ui.view.account.c c1)
    {
        mViews.nameView.setInputChangeListener(c1);
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }
}
