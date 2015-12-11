// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.dialogs;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package com.gotv.crackle.dialogs:
//            ParentalPinDialog

class this._cls0
    implements TextWatcher
{

    final ParentalPinDialog this$0;

    public void afterTextChanged(Editable editable)
    {
        ParentalPinDialog.access$002(ParentalPinDialog.this, (new StringBuilder()).append(ParentalPinDialog.access$100(ParentalPinDialog.this).getEditableText().toString()).append(ParentalPinDialog.access$200(ParentalPinDialog.this).getEditableText().toString()).append(ParentalPinDialog.access$300(ParentalPinDialog.this).getEditableText().toString()).append(ParentalPinDialog.access$400(ParentalPinDialog.this).getEditableText().toString()).toString());
        if (ParentalPinDialog.access$000(ParentalPinDialog.this).length() == 4)
        {
            dismiss();
        } else
        {
            if (ParentalPinDialog.access$100(ParentalPinDialog.this).hasFocus())
            {
                ParentalPinDialog.access$200(ParentalPinDialog.this).requestFocus();
                return;
            }
            if (ParentalPinDialog.access$200(ParentalPinDialog.this).hasFocus())
            {
                ParentalPinDialog.access$300(ParentalPinDialog.this).requestFocus();
                return;
            }
            if (ParentalPinDialog.access$300(ParentalPinDialog.this).hasFocus())
            {
                ParentalPinDialog.access$400(ParentalPinDialog.this).requestFocus();
                return;
            }
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
        this$0 = ParentalPinDialog.this;
        super();
    }
}
