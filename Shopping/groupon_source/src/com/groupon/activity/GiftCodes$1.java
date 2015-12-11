// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.EditText;
import com.groupon.view.GrouponCheckMark;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GiftCodes

class this._cls0
    implements android.view.Listener
{

    final GiftCodes this$0;

    public void onClick(View view)
    {
        if (giftCardCheckMark != null && giftCardCheckMark.isChecked())
        {
            view = giftCardNumber.getText();
        } else
        {
            view = code.getText();
        }
        view = Strings.toString(view);
        if (!GiftCodes.access$000(GiftCodes.this, view))
        {
            return;
        } else
        {
            GiftCodes.access$100(GiftCodes.this, view);
            return;
        }
    }

    ()
    {
        this$0 = GiftCodes.this;
        super();
    }
}
