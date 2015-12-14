// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import com.amazon.gallery.thor.widget.BackableEditText;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class this._cls0
    implements TextWatcher
{

    final SignInActivity this$0;

    public void afterTextChanged(Editable editable)
    {
        if (SignInActivity.access$100(SignInActivity.this).length() > 0 && SignInActivity.access$200(SignInActivity.this).length() > 0)
        {
            SignInActivity.access$300(SignInActivity.this).setEnabled(true);
            if (android.os._INT >= 11)
            {
                SignInActivity.access$300(SignInActivity.this).setAlpha(1.0F);
            }
        } else
        {
            SignInActivity.access$300(SignInActivity.this).setEnabled(false);
            if (android.os._INT >= 11)
            {
                SignInActivity.access$300(SignInActivity.this).setAlpha(0.66F);
            }
        }
        if (SignInActivity.access$100(SignInActivity.this).length() > 0)
        {
            SignInActivity.access$400(SignInActivity.this).setVisibility(0);
            return;
        } else
        {
            SignInActivity.access$400(SignInActivity.this).setVisibility(4);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = SignInActivity.this;
        super();
    }
}
