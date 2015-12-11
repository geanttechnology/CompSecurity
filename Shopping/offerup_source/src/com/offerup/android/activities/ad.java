// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import android.widget.EditText;
import org.apache.commons.lang3.math.NumberUtils;

// Referenced classes of package com.offerup.android.activities:
//            BuyActivity

final class ad
    implements android.view.View.OnClickListener
{

    private EditText a;
    private BuyActivity b;

    ad(BuyActivity buyactivity, EditText edittext)
    {
        b = buyactivity;
        a = edittext;
        super();
    }

    public final void onClick(View view)
    {
        view = a.getText().toString().replace("$", "");
        if (NumberUtils.isNumber(view))
        {
            b.b = Double.valueOf(view).doubleValue();
        } else
        {
            b.b = 0.0D;
        }
        BuyActivity.a(b);
    }
}
