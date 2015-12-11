// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation;

import android.content.res.Resources;
import android.text.Editable;
import android.widget.EditText;
import com.target.ui.k.a;
import com.target.ui.util.validation.a.g;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.account.b;
import java.util.List;

// Referenced classes of package com.target.ui.util.validation:
//            g, b

public class e extends a
{

    final com.target.ui.view.account.a mInputChangeListener;
    final b mInputValidationListener;
    boolean mNowValid;
    private final EditText mPhone;
    private final CustomErrorViewWrapper mPhoneWrapper;

    public e(EditText edittext, CustomErrorViewWrapper customerrorviewwrapper, b b1, com.target.ui.view.account.a a1)
    {
        mPhone = edittext;
        mPhoneWrapper = customerrorviewwrapper;
        mInputValidationListener = b1;
        mInputChangeListener = a1;
    }

    private void a(g g1, EditText edittext, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (com.target.ui.util.validation.g.a(g1, edittext, customerrorviewwrapper))
        {
            a(g1.reasons, customerrorviewwrapper);
            return;
        } else
        {
            customerrorviewwrapper.b();
            return;
        }
    }

    public g a()
    {
        return com.target.ui.util.validation.b.f(mPhone.getText().toString());
    }

    public void a(Editable editable)
    {
        editable = a();
        if (mNowValid != editable.a())
        {
            mInputValidationListener.a(mPhone, ((g) (editable)).isValid);
        }
        mNowValid = editable.a();
        if (mInputChangeListener != null)
        {
            mInputChangeListener.b(mPhone, mNowValid);
        }
        a(((g) (editable)));
    }

    public void a(g g1)
    {
        a(g1, mPhone, mPhoneWrapper);
    }

    public void a(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void a(List list, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (list != null && !list.isEmpty())
        {
            Resources resources = customerrorviewwrapper.getResources();
            if (list.contains(com.target.ui.util.validation.a.g.a.TOO_SHORT) || list.contains(com.target.ui.util.validation.a.g.a.ONLY_SPACES))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f3));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.g.a.TOO_LONG))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f5));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.g.a.INVALID_LENGTH))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f5));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.g.a.SPECIAL_CHAR_NOT_ALLOWED))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901f6));
                return;
            }
        }
    }

    public void b(CharSequence charsequence, int i, int j, int k)
    {
    }
}
