// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.google.a.a.e;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.model.common.GuestAddress;
import com.target.ui.util.validation.a.a;
import com.target.ui.util.validation.a.b;
import com.target.ui.util.validation.a.d;
import com.target.ui.util.validation.a.j;
import com.target.ui.util.validation.a.m;
import com.target.ui.util.validation.g;
import com.target.ui.view.CustomErrorViewWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.target.ui.view.checkout:
//            a

public class AddressView extends LinearLayout
    implements android.view.View.OnFocusChangeListener
{
    static class Views extends com.target.ui.view.a
    {

        EditText addressLine;
        CustomErrorViewWrapper addressLineWrapper;
        EditText apartmentNumber;
        CustomErrorViewWrapper apartmentNumberWrapper;
        EditText city;
        CustomErrorViewWrapper cityWrapper;
        Spinner stateSpinner;
        CustomErrorViewWrapper stateWrapper;
        EditText zipCode;
        CustomErrorViewWrapper zipCodeWrapper;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(String s, String s1, String s2, String s3, String s4);
    }

    private final class b extends com.target.ui.k.b
    {

        final AddressView this$0;
        private boolean wasValid;

        public void a(Editable editable)
        {
            editable = com.target.ui.view.checkout.AddressView.a(AddressView.this);
            if (wasValid != ((com.target.ui.util.validation.a.a) (editable)).isValid)
            {
                com.target.ui.view.checkout.AddressView.a(AddressView.this, ((com.target.ui.util.validation.a.a) (editable)).isValid);
            }
            com.target.ui.view.checkout.AddressView.a(AddressView.this, editable);
        }

        public void a(CharSequence charsequence, int i1, int j1, int k1)
        {
            wasValid = com.target.ui.view.checkout.AddressView.a(AddressView.this).isValid;
        }

        public void b(CharSequence charsequence, int i1, int j1, int k1)
        {
        }

        private b()
        {
            this$0 = AddressView.this;
            super();
        }

    }

    private final class c extends com.target.ui.k.b
    {

        final AddressView this$0;
        private boolean wasValid;

        public void a(Editable editable)
        {
            editable = com.target.ui.view.checkout.AddressView.b(AddressView.this);
            if (wasValid != ((com.target.ui.util.validation.a.b) (editable)).isValid)
            {
                com.target.ui.view.checkout.AddressView.a(AddressView.this, ((com.target.ui.util.validation.a.b) (editable)).isValid);
            }
            com.target.ui.view.checkout.AddressView.a(AddressView.this, editable);
        }

        public void a(CharSequence charsequence, int i1, int j1, int k1)
        {
            wasValid = com.target.ui.view.checkout.AddressView.b(AddressView.this).isValid;
        }

        public void b(CharSequence charsequence, int i1, int j1, int k1)
        {
        }

        private c()
        {
            this$0 = AddressView.this;
            super();
        }

    }

    private final class d extends com.target.ui.k.b
    {

        final AddressView this$0;
        private boolean wasValid;

        public void a(Editable editable)
        {
            editable = AddressView.c(AddressView.this);
            if (wasValid != ((com.target.ui.util.validation.a.d) (editable)).isValid)
            {
                com.target.ui.view.checkout.AddressView.a(AddressView.this, ((com.target.ui.util.validation.a.d) (editable)).isValid);
            }
            com.target.ui.view.checkout.AddressView.a(AddressView.this, editable);
        }

        public void a(CharSequence charsequence, int i1, int j1, int k1)
        {
            wasValid = AddressView.c(AddressView.this).isValid;
        }

        public void b(CharSequence charsequence, int i1, int j1, int k1)
        {
        }

        private d()
        {
            this$0 = AddressView.this;
            super();
        }

    }

    private final class e
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        final AddressView this$0;
        private boolean wasAutoSelected;
        private boolean wasValid;

        public void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
        {
            if (wasAutoSelected)
            {
                wasAutoSelected = false;
                return;
            }
            adapterview = com.target.ui.view.checkout.AddressView.d(AddressView.this);
            if (wasValid != ((j) (adapterview)).isValid)
            {
                com.target.ui.view.checkout.AddressView.a(AddressView.this, ((j) (adapterview)).isValid);
            }
            if (i1 == 0 && wasValid || adapterview.a())
            {
                com.target.ui.view.checkout.AddressView.a(AddressView.this, adapterview);
            }
            wasValid = com.target.ui.view.checkout.AddressView.d(AddressView.this).isValid;
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

        private e()
        {
            this$0 = AddressView.this;
            super();
            wasAutoSelected = true;
        }

    }

    private final class f extends com.target.ui.k.b
    {

        final AddressView this$0;
        private boolean wasValid;

        public void a(Editable editable)
        {
            m m1 = com.target.ui.view.checkout.AddressView.e(AddressView.this);
            if (m1.isValid)
            {
                com.target.ui.view.checkout.AddressView.a(AddressView.this, editable.toString());
            }
            if (wasValid != m1.isValid)
            {
                com.target.ui.view.checkout.AddressView.a(AddressView.this, m1.isValid);
            }
            com.target.ui.view.checkout.AddressView.a(AddressView.this, m1);
        }

        public void a(CharSequence charsequence, int i1, int j1, int k1)
        {
            wasValid = com.target.ui.view.checkout.AddressView.e(AddressView.this).isValid;
        }

        public void b(CharSequence charsequence, int i1, int j1, int k1)
        {
        }

        private f()
        {
            this$0 = AddressView.this;
            super();
        }

    }


    private static final int ADDRESS_LINE_1_INDEX = 0;
    private static final int ADDRESS_LINE_2_INDEX = 1;
    private com.target.mothership.model.c.c.a mGeoCode;
    private com.target.ui.view.checkout.a mListener;
    private com.target.ui.adapter.checkout.a mStateAdapter;
    private com.target.ui.view.account.b mValidationListener;
    private Views mViews;

    public AddressView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public AddressView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public AddressView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        mViews = null;
        a(context);
    }

    static com.target.ui.util.validation.a.a a(AddressView addressview)
    {
        return addressview.h();
    }

    private void a(com.target.ui.util.validation.a.a a1, EditText edittext, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (com.target.ui.util.validation.g.a(a1, edittext, customerrorviewwrapper))
        {
            a(a1.reasons, customerrorviewwrapper);
            return;
        } else
        {
            customerrorviewwrapper.b();
            return;
        }
    }

    private void a(com.target.ui.util.validation.a.b b1, EditText edittext, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (com.target.ui.util.validation.g.a(b1, edittext, customerrorviewwrapper))
        {
            b(b1.reasons, customerrorviewwrapper);
            return;
        } else
        {
            customerrorviewwrapper.b();
            return;
        }
    }

    private void a(com.target.ui.util.validation.a.d d1, EditText edittext, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (com.target.ui.util.validation.g.a(d1, edittext, customerrorviewwrapper))
        {
            c(d1.reasons, customerrorviewwrapper);
            return;
        } else
        {
            customerrorviewwrapper.b();
            return;
        }
    }

    private void a(j j1, Spinner spinner, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (com.target.ui.util.validation.g.a(j1, spinner, customerrorviewwrapper))
        {
            d(j1.reasons, customerrorviewwrapper);
            return;
        } else
        {
            customerrorviewwrapper.b();
            return;
        }
    }

    static void a(AddressView addressview, com.target.ui.util.validation.a.a a1)
    {
        addressview.setAddressLineErrorState(a1);
    }

    static void a(AddressView addressview, com.target.ui.util.validation.a.b b1)
    {
        addressview.setApartmentErrorState(b1);
    }

    static void a(AddressView addressview, com.target.ui.util.validation.a.d d1)
    {
        addressview.setCityErrorState(d1);
    }

    static void a(AddressView addressview, j j1)
    {
        addressview.setStateErrorState(j1);
    }

    static void a(AddressView addressview, m m1)
    {
        addressview.setZipCodeErrorState(m1);
    }

    static void a(AddressView addressview, String s)
    {
        addressview.a(s);
    }

    static void a(AddressView addressview, boolean flag)
    {
        addressview.a(flag);
    }

    private void a(String s)
    {
        if (mListener != null)
        {
            mListener.c(s);
        }
    }

    private void a(List list, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (list != null && !list.isEmpty())
        {
            Resources resources = getResources();
            if (list.contains(com.target.ui.util.validation.a.a.a.TOO_SHORT) || list.contains(com.target.ui.util.validation.a.a.a.ONLY_SPACES))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f3));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.a.a.TOO_LONG))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f1));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.a.a.SPECIAL_CHAR_NOT_ALLOWED))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f2));
                return;
            }
        }
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
        mValidationListener.a(this, flag);
    }

    static com.target.ui.util.validation.a.b b(AddressView addressview)
    {
        return addressview.i();
    }

    private void b()
    {
        ArrayList arraylist = new ArrayList(Arrays.asList(getContext().getResources().getStringArray(0x7f0e0000)));
        mStateAdapter = new com.target.ui.adapter.checkout.a(getContext(), arraylist);
        mViews.stateSpinner.setAdapter(mStateAdapter);
    }

    private void b(List list, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (list != null && !list.isEmpty())
        {
            Resources resources = getResources();
            if (list.contains(com.target.ui.util.validation.a.b.a.TOO_LONG))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f1));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.b.a.SPECIAL_CHAR_NOT_ALLOWED))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f2));
                return;
            }
        }
    }

    static com.target.ui.util.validation.a.d c(AddressView addressview)
    {
        return addressview.j();
    }

    private void c()
    {
        setAddressLineErrorState(h());
    }

    private void c(List list, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (list != null && !list.isEmpty())
        {
            Resources resources = getResources();
            if (list.contains(com.target.ui.util.validation.a.d.a.TOO_SHORT) || list.contains(com.target.ui.util.validation.a.d.a.ONLY_SPACES))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f3));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.d.a.TOO_LONG))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f1));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.d.a.SPECIAL_CHAR_NOT_ALLOWED))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f2));
                return;
            }
        }
    }

    static j d(AddressView addressview)
    {
        return addressview.k();
    }

    private void d()
    {
        setApartmentErrorState(i());
    }

    private void d(List list, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (list != null && !list.isEmpty())
        {
            Resources resources = getResources();
            if (list.contains(com.target.ui.util.validation.a.j.a.STATE_INVALID))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f7));
                return;
            }
        }
    }

    static m e(AddressView addressview)
    {
        return addressview.l();
    }

    private void e()
    {
        setCityErrorState(j());
    }

    private void f()
    {
        setStateErrorState(k());
    }

    private void g()
    {
        setZipCodeErrorState(l());
    }

    private com.target.ui.util.validation.a.a h()
    {
        return com.target.ui.util.validation.b.a(mViews.addressLine.getText().toString());
    }

    private com.target.ui.util.validation.a.b i()
    {
        return com.target.ui.util.validation.b.b(mViews.apartmentNumber.getText().toString());
    }

    private com.target.ui.util.validation.a.d j()
    {
        return com.target.ui.util.validation.b.c(mViews.city.getText().toString());
    }

    private j k()
    {
        String s = "";
        if (mViews.stateSpinner.getSelectedItem() != null)
        {
            s = mViews.stateSpinner.getSelectedItem().toString();
        }
        return com.target.ui.util.validation.b.d(s);
    }

    private m l()
    {
        return com.target.ui.util.validation.b.e(mViews.zipCode.getText().toString());
    }

    private void setAddressLineErrorState(com.target.ui.util.validation.a.a a1)
    {
        a(a1, mViews.addressLine, mViews.addressLineWrapper);
    }

    private void setApartmentErrorState(com.target.ui.util.validation.a.b b1)
    {
        a(b1, mViews.apartmentNumber, mViews.apartmentNumberWrapper);
    }

    private void setCityErrorState(com.target.ui.util.validation.a.d d1)
    {
        a(d1, mViews.city, mViews.cityWrapper);
    }

    private void setStateErrorState(j j1)
    {
        a(j1, mViews.stateSpinner, mViews.stateWrapper);
    }

    private void setStateSelection(String s)
    {
        mViews.stateSpinner.setSelection(mStateAdapter.getPosition(s));
    }

    private void setZipCodeErrorState(m m1)
    {
        com.target.ui.util.validation.b.a(getContext(), m1, mViews.zipCode, mViews.zipCodeWrapper);
    }

    public void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f030122, this);
        mViews = new Views(this);
        mViews.addressLine.addTextChangedListener(new b());
        mViews.apartmentNumber.addTextChangedListener(new c());
        mViews.city.addTextChangedListener(new d());
        mViews.stateSpinner.setOnItemSelectedListener(new e());
        mViews.zipCode.addTextChangedListener(new f());
        b();
        mViews.addressLine.setOnFocusChangeListener(this);
        mViews.apartmentNumber.setOnFocusChangeListener(this);
        mViews.stateSpinner.setOnFocusChangeListener(this);
        mViews.city.setOnFocusChangeListener(this);
        mViews.zipCode.setOnFocusChangeListener(this);
    }

    public void a(AddressParams addressparams)
    {
        List list = addressparams.a();
        if (list != null && !list.isEmpty())
        {
            mViews.addressLine.setText((CharSequence)list.get(0));
            if (list.size() >= 2)
            {
                mViews.apartmentNumber.setText((CharSequence)list.get(1));
            }
        }
        mViews.city.setText(addressparams.b());
        mViews.zipCode.setText(com.target.ui.util.d.b.f(addressparams.d()));
        setStateSelection(addressparams.c());
    }

    public void a(GuestAddress guestaddress)
    {
        List list = guestaddress.getAddressLines();
        if (list != null && !list.isEmpty())
        {
            mViews.addressLine.setText((CharSequence)list.get(0));
            if (list.size() >= 2)
            {
                mViews.apartmentNumber.setText((CharSequence)list.get(1));
            }
        }
        mViews.city.setText(guestaddress.getCity());
        mViews.zipCode.setText(com.target.ui.util.d.b.f(guestaddress.getPostalCode()));
        setStateSelection(guestaddress.getStateOrProvince());
    }

    public void a(a a1)
    {
        com.target.ui.util.validation.a.a a2 = h();
        com.target.ui.util.validation.a.b b1 = i();
        com.target.ui.util.validation.a.d d1 = j();
        j j1 = k();
        m m1 = l();
        setAddressLineErrorState(a2);
        setApartmentErrorState(b1);
        setCityErrorState(d1);
        setStateErrorState(j1);
        setZipCodeErrorState(m1);
        if (a2.isValid && b1.isValid && d1.isValid && j1.isValid && m1.isValid)
        {
            String s;
            if (mGeoCode != null && mGeoCode.c().b())
            {
                s = (String)mGeoCode.c().c();
            }
            a1.a(a2.addressLine, b1.apartment, d1.city, m1.zipCode, j1.state);
            return;
        } else
        {
            a1.a();
            return;
        }
    }

    public boolean a()
    {
        boolean flag = com.target.ui.util.validation.b.a(mViews.addressLine.getText().toString()).isValid;
        boolean flag1 = com.target.ui.util.validation.b.b(mViews.apartmentNumber.getText().toString()).isValid;
        boolean flag2 = com.target.ui.util.validation.b.c(mViews.city.getText().toString()).isValid;
        boolean flag3 = com.target.ui.util.validation.b.e(mViews.zipCode.getText().toString()).isValid;
        boolean flag4 = k().a();
        return flag && flag1 && flag2 && flag3 && flag4;
    }

    public void onFocusChange(View view, boolean flag)
    {
        view.getId();
        JVM INSTR tableswitch 2131755869 2131755878: default 60
    //                   2131755869 61
    //                   2131755870 70
    //                   2131755871 60
    //                   2131755872 88
    //                   2131755873 60
    //                   2131755874 79
    //                   2131755875 60
    //                   2131755876 60
    //                   2131755877 60
    //                   2131755878 97;
           goto _L1 _L2 _L3 _L1 _L4 _L1 _L5 _L1 _L1 _L1 _L6
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
        continue; /* Loop/switch isn't completed */
_L5:
        if (!flag)
        {
            e();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!flag)
        {
            g();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (!flag)
        {
            f();
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void setAddressHint(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.addressLine.setHint(s);
            return;
        }
    }

    public void setCheckoutAddressFormListener(com.target.ui.view.checkout.a a1)
    {
        mListener = a1;
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }

    public void setZipCodeSearchResult(com.target.mothership.model.c.c.a a1)
    {
        while (mViews == null || !com.target.ui.util.validation.b.a(a1)) 
        {
            return;
        }
        mGeoCode = a1;
        if (a1.b().b())
        {
            mViews.city.setText((CharSequence)a1.b().c());
        } else
        {
            mViews.city.setText("");
        }
        if (a1.a().b())
        {
            setStateSelection((String)a1.a().c());
            return;
        } else
        {
            mViews.stateSpinner.setSelection(0);
            return;
        }
    }
}
