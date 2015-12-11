// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.widget.EditText;
import com.target.mothership.util.o;
import com.target.ui.view.BackSpaceDetectorEditText;

// Referenced classes of package com.target.ui.view.checkout:
//            GiftCardInputView

private final class <init>
    implements com.target.ui.view.tText.a
{

    final GiftCardInputView this$0;

    public void a(BackSpaceDetectorEditText backspacedetectoredittext)
    {
        if (backspacedetectoredittext != null && GiftCardInputView.a(GiftCardInputView.this) != null)
        {
            switch (backspacedetectoredittext.getId())
            {
            default:
                return;

            case 2131755949: 
                break;
            }
            if (o.e(backspacedetectoredittext.getText().toString()))
            {
                GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.setSelection(GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.length());
                GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.requestFocus();
                return;
            }
        }
    }

    private ews()
    {
        this$0 = GiftCardInputView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
