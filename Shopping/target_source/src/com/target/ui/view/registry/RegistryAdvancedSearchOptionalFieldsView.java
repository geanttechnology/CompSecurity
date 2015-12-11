// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.target.mothership.util.o;
import com.target.ui.adapter.e.c;
import com.target.ui.util.af;
import com.target.ui.util.validation.a.d;
import com.target.ui.util.validation.a.h;
import com.target.ui.util.validation.a.j;
import com.target.ui.util.validation.f;
import com.target.ui.util.validation.g;
import com.target.ui.view.CustomErrorViewWrapper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RegistryAdvancedSearchOptionalFieldsView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        EditText city;
        CustomErrorViewWrapper cityWrapper;
        EditText email;
        CustomErrorViewWrapper emailWrapper;
        EditText endDate;
        ImageView endDateDatePicker;
        CustomErrorViewWrapper endDateWrapper;
        Spinner registryTypeSpinner;
        CustomErrorViewWrapper registryTypeWrapper;
        EditText startDate;
        ImageView startDateDatePicker;
        CustomErrorViewWrapper startDateWrapper;
        Spinner stateSpinner;
        CustomErrorViewWrapper stateWrapper;

        Views(View view)
        {
            super(view);
        }
    }

    private final class a extends com.target.ui.k.b
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;

        public void a(Editable editable)
        {
            editable = RegistryAdvancedSearchOptionalFieldsView.a(RegistryAdvancedSearchOptionalFieldsView.this);
            RegistryAdvancedSearchOptionalFieldsView.a(RegistryAdvancedSearchOptionalFieldsView.this, editable);
        }

        public void a(CharSequence charsequence, int i1, int j1, int k1)
        {
        }

        public void b(CharSequence charsequence, int i1, int j1, int k1)
        {
        }

        private a()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
        }

    }

    private class b
        implements android.view.View.OnFocusChangeListener
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;

        public void onFocusChange(View view, boolean flag)
        {
            if (!flag)
            {
                RegistryAdvancedSearchOptionalFieldsView.e(RegistryAdvancedSearchOptionalFieldsView.this);
            }
        }

        private b()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
        }

    }

    private final class c
        implements android.view.View.OnFocusChangeListener
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;

        public void onFocusChange(View view, boolean flag)
        {
            if (!flag)
            {
                RegistryAdvancedSearchOptionalFieldsView.a(RegistryAdvancedSearchOptionalFieldsView.this, com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.h(RegistryAdvancedSearchOptionalFieldsView.this));
            }
        }

        private c()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
        }

    }

    private final class d
        implements TextWatcher
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;
        private boolean wasValid;

        public void afterTextChanged(Editable editable)
        {
            boolean flag = com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.h(RegistryAdvancedSearchOptionalFieldsView.this);
            RegistryAdvancedSearchOptionalFieldsView.a(RegistryAdvancedSearchOptionalFieldsView.this, flag);
            if (wasValid != flag || com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this) != null)
            {
                com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this).a(flag);
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
        {
            wasValid = com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.h(RegistryAdvancedSearchOptionalFieldsView.this);
        }

        public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
        {
        }

        private d()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
        }

    }

    private class e
        implements android.view.View.OnClickListener
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;

        public void onClick(View view)
        {
            com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.c(RegistryAdvancedSearchOptionalFieldsView.this);
            if (com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this) == null)
            {
                return;
            } else
            {
                com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this).d();
                return;
            }
        }

        private e()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
        }

    }

    private class f
        implements android.view.View.OnFocusChangeListener
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;

        public void onFocusChange(View view, boolean flag)
        {
            if (!flag)
            {
                return;
            } else
            {
                com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.c(RegistryAdvancedSearchOptionalFieldsView.this);
                return;
            }
        }

        private f()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
        }

    }

    private class g
        implements android.view.View.OnClickListener
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;

        public void onClick(View view)
        {
            if (com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this) == null)
            {
                return;
            } else
            {
                com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this).d();
                return;
            }
        }

        private g()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
        }

    }

    public static interface h
    {

        public abstract void a();

        public abstract void a(boolean flag);

        public abstract void b();

        public abstract void c();

        public abstract void d();
    }

    private final class i
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;
        private boolean wasAutoSelected;
        private boolean wasValid;

        public void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
        {
            if (wasAutoSelected)
            {
                wasAutoSelected = false;
                return;
            }
            adapterview = com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.g(RegistryAdvancedSearchOptionalFieldsView.this);
            if (i1 == 0 && wasValid || adapterview.a())
            {
                RegistryAdvancedSearchOptionalFieldsView.a(RegistryAdvancedSearchOptionalFieldsView.this, adapterview);
            }
            wasValid = com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.g(RegistryAdvancedSearchOptionalFieldsView.this).isValid;
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

        private i()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
            wasAutoSelected = true;
        }

    }

    private class j
        implements android.view.View.OnClickListener
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;

        public void onClick(View view)
        {
            RegistryAdvancedSearchOptionalFieldsView.b(RegistryAdvancedSearchOptionalFieldsView.this);
            if (com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this) == null)
            {
                return;
            } else
            {
                com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this).b();
                return;
            }
        }

        private j()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
        }

    }

    private class k
        implements android.view.View.OnFocusChangeListener
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;

        public void onFocusChange(View view, boolean flag)
        {
            if (!flag)
            {
                return;
            } else
            {
                RegistryAdvancedSearchOptionalFieldsView.b(RegistryAdvancedSearchOptionalFieldsView.this);
                return;
            }
        }

        private k()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
        }

    }

    private class l
        implements android.view.View.OnClickListener
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;

        public void onClick(View view)
        {
            if (com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this) == null)
            {
                return;
            } else
            {
                com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this).b();
                return;
            }
        }

        private l()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
        }

    }

    private final class m
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        final RegistryAdvancedSearchOptionalFieldsView this$0;
        private boolean wasAutoSelected;
        private boolean wasValid;

        public void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
        {
            if (wasAutoSelected)
            {
                wasAutoSelected = false;
                return;
            }
            adapterview = com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.f(RegistryAdvancedSearchOptionalFieldsView.this);
            if (i1 == 0 && wasValid || adapterview.a())
            {
                RegistryAdvancedSearchOptionalFieldsView.a(RegistryAdvancedSearchOptionalFieldsView.this, adapterview);
            }
            wasValid = com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.f(RegistryAdvancedSearchOptionalFieldsView.this).isValid;
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

        private m()
        {
            this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
            super();
            wasAutoSelected = true;
        }

    }


    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final String TAG = com/target/ui/view/registry/RegistryAdvancedSearchOptionalFieldsView.getSimpleName();
    private h mListener;
    private com.target.ui.adapter.e.c mRegistryTypeAdapter;
    private com.target.ui.adapter.e.c mStateAdapter;
    private Views mViews;

    public RegistryAdvancedSearchOptionalFieldsView(Context context)
    {
        super(context);
        e();
    }

    public RegistryAdvancedSearchOptionalFieldsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e();
    }

    public RegistryAdvancedSearchOptionalFieldsView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        e();
    }

    static com.target.ui.util.validation.a.d a(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview)
    {
        return registryadvancedsearchoptionalfieldsview.m();
    }

    private void a(int i1, CustomErrorViewWrapper customerrorviewwrapper)
    {
        Resources resources = getResources();
        if (i1 == 1)
        {
            customerrorviewwrapper.setErrorState(resources.getString(0x7f09049b));
        }
    }

    private void a(com.target.ui.util.validation.a.d d1, EditText edittext, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (com.target.ui.util.validation.g.a(d1, edittext, customerrorviewwrapper))
        {
            b(d1.reasons, customerrorviewwrapper);
            return;
        } else
        {
            customerrorviewwrapper.b();
            return;
        }
    }

    private void a(com.target.ui.util.validation.a.h h1, Spinner spinner, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (com.target.ui.util.validation.g.a(h1, spinner, customerrorviewwrapper))
        {
            a(h1.reason, customerrorviewwrapper);
            return;
        } else
        {
            customerrorviewwrapper.b();
            return;
        }
    }

    private void a(com.target.ui.util.validation.a.j j1, Spinner spinner, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (com.target.ui.util.validation.g.a(j1, spinner, customerrorviewwrapper))
        {
            a(j1.reasons, customerrorviewwrapper);
            return;
        } else
        {
            customerrorviewwrapper.b();
            return;
        }
    }

    static void a(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview, com.target.ui.util.validation.a.d d1)
    {
        registryadvancedsearchoptionalfieldsview.setCityErrorState(d1);
    }

    static void a(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview, com.target.ui.util.validation.a.h h1)
    {
        registryadvancedsearchoptionalfieldsview.setRegistryErrorState(h1);
    }

    static void a(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview, com.target.ui.util.validation.a.j j1)
    {
        registryadvancedsearchoptionalfieldsview.setStateErrorState(j1);
    }

    static void a(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview, boolean flag)
    {
        registryadvancedsearchoptionalfieldsview.setEmailIdErrorState(flag);
    }

    private void a(List list, CustomErrorViewWrapper customerrorviewwrapper)
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

    static void b(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview)
    {
        registryadvancedsearchoptionalfieldsview.n();
    }

    private void b(List list, CustomErrorViewWrapper customerrorviewwrapper)
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

    private String c(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return (new SimpleDateFormat("MM/dd/yyyy", Locale.US)).format(date);
        }
    }

    static void c(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview)
    {
        registryadvancedsearchoptionalfieldsview.o();
    }

    static h d(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview)
    {
        return registryadvancedsearchoptionalfieldsview.mListener;
    }

    private void e()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f0301d1, this);
        mViews = new Views(this);
        f();
        g();
        h();
    }

    static void e(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview)
    {
        registryadvancedsearchoptionalfieldsview.l();
    }

    static com.target.ui.util.validation.a.j f(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview)
    {
        return registryadvancedsearchoptionalfieldsview.i();
    }

    private void f()
    {
        List list = getEventTypes();
        mRegistryTypeAdapter = new com.target.ui.adapter.e.c(getContext(), list);
        mViews.registryTypeSpinner.setAdapter(mRegistryTypeAdapter);
    }

    static com.target.ui.util.validation.a.h g(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview)
    {
        return registryadvancedsearchoptionalfieldsview.j();
    }

    private void g()
    {
        ArrayList arraylist = new ArrayList(Arrays.asList(getContext().getResources().getStringArray(0x7f0e0000)));
        mStateAdapter = new com.target.ui.adapter.e.c(getContext(), arraylist);
        mViews.stateSpinner.setAdapter(mStateAdapter);
    }

    private List getEventTypes()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(getContext().getResources().getString(0x7f09049c));
        arraylist.add(af.a(com.target.mothership.common.registries.c.BABY.toString()));
        arraylist.add(af.a(com.target.mothership.common.registries.c.WEDDING.toString()));
        arraylist.add(af.a(com.target.mothership.common.registries.c.COLLEGE.toString()));
        return arraylist;
    }

    private void h()
    {
        mViews.registryTypeSpinner.setOnItemSelectedListener(new i());
        mViews.stateSpinner.setOnItemSelectedListener(new m());
        mViews.city.addTextChangedListener(new a());
        mViews.city.setOnFocusChangeListener(new b());
        mViews.startDate.setKeyListener(null);
        mViews.endDate.setKeyListener(null);
        mViews.startDate.setOnClickListener(new j());
        mViews.endDate.setOnClickListener(new e());
        mViews.startDate.setOnFocusChangeListener(new k());
        mViews.endDate.setOnFocusChangeListener(new f());
        mViews.startDateDatePicker.setOnClickListener(new l());
        mViews.endDateDatePicker.setOnClickListener(new g());
        mViews.email.setOnFocusChangeListener(new c());
        mViews.email.addTextChangedListener(new d());
    }

    static boolean h(RegistryAdvancedSearchOptionalFieldsView registryadvancedsearchoptionalfieldsview)
    {
        return registryadvancedsearchoptionalfieldsview.k();
    }

    private com.target.ui.util.validation.a.j i()
    {
        String s1 = "";
        String s = s1;
        if (mViews.stateSpinner.getSelectedItemPosition() != 0)
        {
            s = s1;
            if (mViews.stateSpinner.getSelectedItem() != null)
            {
                s = mViews.stateSpinner.getSelectedItem().toString();
            }
        }
        return com.target.ui.util.validation.f.b(s);
    }

    private com.target.ui.util.validation.a.h j()
    {
        String s = "";
        if (mViews.registryTypeSpinner.getSelectedItem() != null)
        {
            s = mViews.registryTypeSpinner.getSelectedItem().toString();
        }
        return com.target.ui.util.validation.f.d(s);
    }

    private boolean k()
    {
        return com.target.ui.util.validation.f.c(mViews.email.getText().toString());
    }

    private void l()
    {
        if (com.target.mothership.util.o.f(mViews.city.getText().toString()))
        {
            setCityErrorState(m());
        }
    }

    private com.target.ui.util.validation.a.d m()
    {
        return com.target.ui.util.validation.f.a(mViews.city.getText().toString());
    }

    private void n()
    {
        if (!com.target.mothership.util.o.e(mViews.startDate.getText().toString()))
        {
            mViews.startDate.setText("");
            if (mListener != null)
            {
                mListener.a();
                return;
            }
        }
    }

    private void o()
    {
        if (!com.target.mothership.util.o.e(mViews.endDate.getText().toString()))
        {
            mViews.endDate.setText("");
            if (mListener != null)
            {
                mListener.c();
                return;
            }
        }
    }

    private void setCityErrorState(com.target.ui.util.validation.a.d d1)
    {
        a(d1, mViews.city, mViews.cityWrapper);
    }

    private void setEmailIdErrorState(boolean flag)
    {
        if (mViews.email.getText().toString() == null)
        {
            return;
        }
        if (flag)
        {
            mViews.emailWrapper.b();
            return;
        }
        boolean flag1 = mViews.email.hasFocus();
        if (!flag1 && !flag)
        {
            mViews.emailWrapper.setErrorState(getResources().getString(0x7f0901f4));
            return;
        }
        if (flag1 && mViews.emailWrapper.a())
        {
            mViews.emailWrapper.setErrorState(getResources().getString(0x7f0901f4));
            return;
        } else
        {
            mViews.emailWrapper.b();
            return;
        }
    }

    private void setRegistryErrorState(com.target.ui.util.validation.a.h h1)
    {
        a(h1, mViews.registryTypeSpinner, mViews.registryTypeWrapper);
    }

    private void setStateErrorState(com.target.ui.util.validation.a.j j1)
    {
        a(j1, mViews.stateSpinner, mViews.stateWrapper);
    }

    public void a()
    {
        mViews.startDate.setText("");
    }

    public void a(int i1)
    {
        mViews.startDateWrapper.setErrorState(getResources().getString(i1));
    }

    public void a(Date date)
    {
        mViews.startDate.setTag(date);
        mViews.startDate.setText(c(date));
    }

    public void b()
    {
        mViews.startDateWrapper.b();
    }

    public void b(int i1)
    {
        mViews.endDateWrapper.setErrorState(getResources().getString(i1));
    }

    public void b(Date date)
    {
        mViews.endDate.setTag(date);
        mViews.endDate.setText(c(date));
    }

    public void c()
    {
        mViews.endDate.setText("");
    }

    public void d()
    {
        mViews.endDateWrapper.b();
    }

    public String getCity()
    {
        return mViews.city.getText().toString();
    }

    public String getEmail()
    {
        return mViews.email.getText().toString();
    }

    public Date getEndDate()
    {
        return (Date)mViews.endDate.getTag();
    }

    public com.target.mothership.common.registries.c getRegistryEventType()
    {
        if (mViews.registryTypeSpinner.getSelectedItemPosition() == 0)
        {
            return com.target.mothership.common.registries.c.UNKNOWN;
        } else
        {
            return com.target.mothership.common.registries.c.a(mViews.registryTypeSpinner.getSelectedItem().toString());
        }
    }

    public Date getStartDate()
    {
        return (Date)mViews.startDate.getTag();
    }

    public String getState()
    {
        if (!i().isValid)
        {
            return "";
        }
        if (mViews.stateSpinner.getSelectedItemPosition() == 0)
        {
            return "";
        } else
        {
            return mViews.stateSpinner.getSelectedItem().toString();
        }
    }

    public void setClickListener(h h1)
    {
        mListener = h1;
    }

}
