// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package co.vine.android:
//            ConfirmationFlowEntryFragment

class val.phoneNumberBox
    implements TextWatcher
{

    final ConfirmationFlowEntryFragment this$0;
    final EditText val$phoneNumberBox;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (!TextUtils.isEmpty(val$phoneNumberBox.getText()))
        {
            ConfirmationFlowEntryFragment.access$000(ConfirmationFlowEntryFragment.this, true);
            return;
        } else
        {
            ConfirmationFlowEntryFragment.access$000(ConfirmationFlowEntryFragment.this, false);
            return;
        }
    }

    ()
    {
        this$0 = final_confirmationflowentryfragment;
        val$phoneNumberBox = EditText.this;
        super();
    }
}
