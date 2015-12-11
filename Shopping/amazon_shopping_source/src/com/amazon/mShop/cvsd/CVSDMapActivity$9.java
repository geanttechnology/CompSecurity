// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Spinner;
import com.amazon.mShop.control.cvsd.CVSDController;
import com.amazon.mShop.util.UIUtils;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDMapActivity

class val.statesSpinner
    implements android.content.ClickListener
{

    final CVSDMapActivity this$0;
    final String val$market;
    final Spinner val$statesSpinner;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CVSDMapActivity.access$1200(CVSDMapActivity.this);
        dialoginterface = null;
        if (val$market.equals("JP"))
        {
            dialoginterface = val$statesSpinner.getSelectedItem().toString();
        }
        UIUtils.closeSoftKeyboard(CVSDMapActivity.access$1300(CVSDMapActivity.this));
        CVSDMapActivity.access$1400(CVSDMapActivity.this).searchDeliveryLocationByAddress(dialoginterface, CVSDMapActivity.access$1300(CVSDMapActivity.this).getText().toString(), null);
    }

    ller()
    {
        this$0 = final_cvsdmapactivity;
        val$market = s;
        val$statesSpinner = Spinner.this;
        super();
    }
}
