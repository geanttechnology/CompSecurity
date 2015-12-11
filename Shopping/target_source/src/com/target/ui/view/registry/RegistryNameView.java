// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.target.ui.view.CustomErrorViewWrapper;

public class RegistryNameView extends RelativeLayout
{
    static class Views extends com.target.ui.view.a
    {

        EditText firstName;
        CustomErrorViewWrapper firstNameWrapper;
        EditText lastName;
        CustomErrorViewWrapper lastNameWrapper;

        Views(View view)
        {
            super(view);
        }
    }

    private final class a
        implements android.view.View.OnFocusChangeListener
    {

        final RegistryNameView this$0;

        public void onFocusChange(View view, boolean flag)
        {
            if (RegistryNameView.a(RegistryNameView.this) == null)
            {
                return;
            } else
            {
                view = RegistryNameView.b(RegistryNameView.this).firstName.getText().toString();
                RegistryNameView.a(RegistryNameView.this).a(view, flag);
                return;
            }
        }

        private a()
        {
            this$0 = RegistryNameView.this;
            super();
        }

    }

    private final class b extends com.target.ui.k.b
    {

        final RegistryNameView this$0;

        public void a(Editable editable)
        {
            if (RegistryNameView.a(RegistryNameView.this) == null)
            {
                return;
            } else
            {
                editable = editable.toString();
                RegistryNameView.a(RegistryNameView.this).a(editable);
                return;
            }
        }

        public void a(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void b(CharSequence charsequence, int i, int j, int k)
        {
        }

        private b()
        {
            this$0 = RegistryNameView.this;
            super();
        }

    }

    private final class c
        implements android.view.View.OnFocusChangeListener
    {

        final RegistryNameView this$0;

        public void onFocusChange(View view, boolean flag)
        {
            if (RegistryNameView.a(RegistryNameView.this) == null)
            {
                return;
            } else
            {
                view = RegistryNameView.b(RegistryNameView.this).lastName.getText().toString();
                RegistryNameView.a(RegistryNameView.this).b(view, flag);
                return;
            }
        }

        private c()
        {
            this$0 = RegistryNameView.this;
            super();
        }

    }

    private final class d extends com.target.ui.k.b
    {

        final RegistryNameView this$0;

        public void a(Editable editable)
        {
            if (RegistryNameView.a(RegistryNameView.this) == null)
            {
                return;
            } else
            {
                editable = editable.toString();
                RegistryNameView.a(RegistryNameView.this).b(editable);
                return;
            }
        }

        public void a(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void b(CharSequence charsequence, int i, int j, int k)
        {
        }

        private d()
        {
            this$0 = RegistryNameView.this;
            super();
        }

    }

    public static interface e
    {

        public abstract void a(String s);

        public abstract void a(String s, boolean flag);

        public abstract void b(String s);

        public abstract void b(String s, boolean flag);
    }


    private static final String TAG = com/target/ui/view/registry/RegistryNameView.getSimpleName();
    private e mListener;
    private Views mViews;

    public RegistryNameView(Context context)
    {
        super(context);
        c();
    }

    public RegistryNameView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c();
    }

    public RegistryNameView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c();
    }

    static e a(RegistryNameView registrynameview)
    {
        return registrynameview.mListener;
    }

    static Views b(RegistryNameView registrynameview)
    {
        return registrynameview.mViews;
    }

    private void c()
    {
        inflate(getContext(), 0x7f0301d6, this);
        mViews = new Views(this);
        d();
    }

    private void d()
    {
        mViews.firstName.addTextChangedListener(new b());
        mViews.lastName.addTextChangedListener(new d());
        mViews.firstName.setOnFocusChangeListener(new a());
        mViews.lastName.setOnFocusChangeListener(new c());
    }

    public void a()
    {
        mViews.firstNameWrapper.b();
    }

    public void a(String s)
    {
        mViews.firstNameWrapper.setErrorState(s);
    }

    public void a(String s, String s1)
    {
        mViews.firstName.setText(s);
        mViews.lastName.setText(s1);
    }

    public void b()
    {
        mViews.lastNameWrapper.b();
    }

    public void b(String s)
    {
        mViews.lastNameWrapper.setErrorState(s);
    }

    public String getFirstName()
    {
        return mViews.firstName.getText().toString();
    }

    public String getLastName()
    {
        return mViews.lastName.getText().toString();
    }

    public void setClickListener(e e1)
    {
        mListener = e1;
    }

}
