// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package co.vine.android:
//            ConfirmationFlowVerificationFragment

class val.confirmationBox
    implements TextWatcher
{

    final ConfirmationFlowVerificationFragment this$0;
    final EditText val$confirmationBox;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (!TextUtils.isEmpty(val$confirmationBox.getText()))
        {
            ConfirmationFlowVerificationFragment.access$100(ConfirmationFlowVerificationFragment.this, true);
            return;
        } else
        {
            ConfirmationFlowVerificationFragment.access$100(ConfirmationFlowVerificationFragment.this, false);
            return;
        }
    }

    ()
    {
        this$0 = final_confirmationflowverificationfragment;
        val$confirmationBox = EditText.this;
        super();
    }
}
