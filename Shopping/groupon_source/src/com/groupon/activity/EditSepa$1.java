// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditSepa

class this._cls0
    implements android.view.sChangeListener
{

    final EditSepa this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag && iban.getText().length() == 0)
        {
            iban.setText(Strings.toString(currentCountryManager.getCurrentCountry().isoName).toUpperCase());
            iban.setSelection(2);
        }
    }

    ry()
    {
        this$0 = EditSepa.this;
        super();
    }
}
