// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.view.View;
import android.widget.AdapterView;
import com.amazon.mShop.AmazonAlertDialog;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDMapActivity

class val.dialog
    implements android.widget.ClickListener
{

    final CVSDMapActivity this$0;
    final AmazonAlertDialog val$dialog;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        CVSDMapActivity.access$800(CVSDMapActivity.this);
_L4:
        val$dialog.dismiss();
        return;
_L2:
        if (i == 1)
        {
            CVSDMapActivity.access$900(CVSDMapActivity.this);
        } else
        if (i == 2)
        {
            CVSDMapActivity.access$1000(CVSDMapActivity.this);
        } else
        if (i == 3)
        {
            CVSDMapActivity.access$1100(CVSDMapActivity.this);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    stener()
    {
        this$0 = final_cvsdmapactivity;
        val$dialog = AmazonAlertDialog.this;
        super();
    }
}
