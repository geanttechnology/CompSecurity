// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.ButterKnife;

public class RevealablePasswordContainer extends FrameLayout
{
    public static interface a
    {

        public abstract void q();
    }


    a a;
    EditText etPassword;
    CheckBox revealPasswordCb;

    public RevealablePasswordContainer(Context context)
    {
        super(context);
        a();
    }

    public RevealablePasswordContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public RevealablePasswordContainer(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        ButterKnife.bind(this, inflate(getContext(), 0x7f040069, this));
    }

    public a getPasswordChangeListener()
    {
        return a;
    }

    void onRevealPasswordChecked(boolean flag)
    {
        if (flag)
        {
            etPassword.setTransformationMethod(null);
            return;
        } else
        {
            etPassword.setTransformationMethod(new PasswordTransformationMethod());
            return;
        }
    }

    void onSignInPasswordTextChanged(CharSequence charsequence)
    {
        if (a != null)
        {
            a.q();
        }
        if (charsequence != null && charsequence.length() > 0)
        {
            revealPasswordCb.setVisibility(0);
            return;
        } else
        {
            revealPasswordCb.setVisibility(4);
            return;
        }
    }

    public void setPasswordChangeListener(a a1)
    {
        a = a1;
    }
}
