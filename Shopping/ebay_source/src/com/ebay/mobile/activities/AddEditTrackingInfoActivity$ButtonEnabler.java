// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.ebay.mobile.activities:
//            AddEditTrackingInfoActivity

private static class setEnabled
    implements TextWatcher
{

    View button;
    EditText carrier;
    EditText number;

    private void setEnabled()
    {
        String s = number.getText().toString().trim();
        String s1 = carrier.getText().toString().trim();
        View view = button;
        boolean flag;
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setEnabled(flag);
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        setEnabled();
    }

    (View view, EditText edittext, EditText edittext1)
    {
        button = view;
        number = edittext;
        carrier = edittext1;
        setEnabled();
    }
}
