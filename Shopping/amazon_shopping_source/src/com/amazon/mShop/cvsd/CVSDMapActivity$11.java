// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.content.DialogInterface;
import android.widget.EditText;
import com.amazon.mShop.control.cvsd.CVSDController;
import com.amazon.mShop.util.UIUtils;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDMapActivity

class val.market
    implements android.content.lickListener
{

    final CVSDMapActivity this$0;
    final String val$market;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CVSDMapActivity.access$1200(CVSDMapActivity.this);
        dialoginterface = null;
        if (val$market.equals("JP"))
        {
            dialoginterface = CVSDMapActivity.access$1500(CVSDMapActivity.this).getText().toString();
            String s = CVSDMapActivity.access$1600(CVSDMapActivity.this).getText().toString();
            dialoginterface = (new StringBuilder()).append(dialoginterface).append("-").append(s).toString();
        } else
        if (val$market.equals("FR"))
        {
            dialoginterface = CVSDMapActivity.access$1700(CVSDMapActivity.this).getText().toString();
        }
        if (CVSDMapActivity.access$1500(CVSDMapActivity.this) != null || CVSDMapActivity.access$1700(CVSDMapActivity.this) != null)
        {
            EditText edittext;
            if (CVSDMapActivity.access$1500(CVSDMapActivity.this) != null)
            {
                edittext = CVSDMapActivity.access$1500(CVSDMapActivity.this);
            } else
            {
                edittext = CVSDMapActivity.access$1700(CVSDMapActivity.this);
            }
            UIUtils.closeSoftKeyboard(edittext);
        }
        CVSDMapActivity.access$1400(CVSDMapActivity.this).searchDeliveryLocationByZipcode(dialoginterface, null);
    }

    ler()
    {
        this$0 = final_cvsdmapactivity;
        val$market = String.this;
        super();
    }
}
