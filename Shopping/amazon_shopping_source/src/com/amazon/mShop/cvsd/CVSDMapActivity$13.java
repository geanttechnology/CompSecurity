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
    implements android.content.lickListener
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
            dialoginterface = (String)val$statesSpinner.getSelectedItem();
        }
        UIUtils.closeSoftKeyboard(CVSDMapActivity.access$1800(CVSDMapActivity.this));
        CVSDMapActivity.access$1400(CVSDMapActivity.this).searchDeliveryLoationByLandmark(CVSDMapActivity.access$1800(CVSDMapActivity.this).getText().toString(), dialoginterface, null);
    }

    ler()
    {
        this$0 = final_cvsdmapactivity;
        val$market = s;
        val$statesSpinner = Spinner.this;
        super();
    }
}
