// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.dialogs;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.gotv.crackle.dialogs:
//            ParentalPinDialog

class this._cls0
    implements android.view.
{

    final ParentalPinDialog this$0;

    public void onClick(View view)
    {
        ParentalPinDialog.access$002(ParentalPinDialog.this, (new StringBuilder()).append(ParentalPinDialog.access$100(ParentalPinDialog.this).getEditableText().toString()).append(ParentalPinDialog.access$200(ParentalPinDialog.this).getEditableText().toString()).append(ParentalPinDialog.access$300(ParentalPinDialog.this).getEditableText().toString()).append(ParentalPinDialog.access$400(ParentalPinDialog.this).getEditableText().toString()).toString());
        if (ParentalPinDialog.access$000(ParentalPinDialog.this).length() == 4)
        {
            dismiss();
        }
    }

    ()
    {
        this$0 = ParentalPinDialog.this;
        super();
    }
}
