// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.posting;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.posting:
//            ProductNewActivity

class a
    implements TextWatcher
{

    final ProductNewActivity a;

    public void afterTextChanged(Editable editable)
    {
        int i = a.getResources().getInteger(0x7f0d0001);
        int j = a.etProductDescription.getText().length();
        a.productDescriptionLabel.setText((new StringBuilder()).append(i - j).append("").toString());
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (ProductNewActivity productnewactivity)
    {
        a = productnewactivity;
        super();
    }
}
