// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;

// Referenced classes of package com.comcast.cim.android.authentication:
//            AuthenticationActivity

private class mEditText
    implements TextWatcher
{

    private EditText mEditText;
    final AuthenticationActivity this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        mEditText.getText().setSpan(new ForegroundColorSpan(-1), i, i, 33);
    }

    public (EditText edittext)
    {
        this$0 = AuthenticationActivity.this;
        super();
        mEditText = edittext;
    }
}
